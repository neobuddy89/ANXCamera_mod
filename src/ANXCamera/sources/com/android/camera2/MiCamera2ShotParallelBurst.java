package com.android.camera2;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.Face;
import android.hardware.camera2.utils.SurfaceUtils;
import android.support.annotation.NonNull;
import android.util.Size;
import android.view.Surface;
import com.android.camera.CameraAppImpl;
import com.android.camera.CameraSettings;
import com.android.camera.HybridZoomingSystem;
import com.android.camera.LocalParallelService;
import com.android.camera.MemoryHelper;
import com.android.camera.Util;
import com.android.camera.data.DataRepository;
import com.android.camera.lib.compatibility.util.CompatibilityUtils;
import com.android.camera.log.Log;
import com.android.camera.module.loader.camera2.Camera2DataContainer;
import com.android.camera.parallel.AlgoConnector;
import com.android.camera2.Camera2Proxy;
import com.android.camera2.compat.MiCameraCompat;
import com.android.camera2.vendortag.CaptureResultVendorTags;
import com.android.camera2.vendortag.VendorTagHelper;
import com.android.camera2.vendortag.struct.HdrEvValue;
import com.mi.config.b;
import com.xiaomi.camera.base.CameraDeviceUtil;
import com.xiaomi.camera.core.ParallelTaskData;
import com.xiaomi.camera.imagecodec.ImagePool;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MiCamera2ShotParallelBurst extends MiCamera2ShotParallel<ParallelTaskData> {
    private static final String TAG = "ShotParallelBurst";
    /* access modifiers changed from: private */
    public int mAlgoType;
    /* access modifiers changed from: private */
    public int mCompletedNum;
    /* access modifiers changed from: private */
    public boolean mFirstNum;
    private Integer mHdrCheckerAdrc;
    private int[] mHdrCheckerEvValue;
    private Integer mHdrCheckerSceneType;
    private final int mOperationMode;
    /* access modifiers changed from: private */
    public int mSequenceNum;
    private boolean mShouldDoMFNR;
    private boolean mShouldDoQcfaCapture;
    private boolean mShouldDoSR;
    private final boolean mSingleCaptureForHDRplusMFNR;
    private List<CaptureRequest> requests = new ArrayList();

    public MiCamera2ShotParallelBurst(MiCamera2 miCamera2, CaptureResult captureResult) {
        super(miCamera2);
        boolean z = false;
        this.mAlgoType = 0;
        this.mPreviewCaptureResult = captureResult;
        this.mOperationMode = this.mMiCamera.getCapabilities().getOperatingMode();
        if ((b.ln || b.nn || b.mn) && this.mMiCamera.getCapabilities().getFacing() == 1 && !this.mMiCamera.isMacroMode()) {
            z = true;
        }
        this.mSingleCaptureForHDRplusMFNR = z;
    }

    private void applyAlgoParameter(CaptureRequest.Builder builder, int i, int i2) {
        if (i2 == 1) {
            applyHdrParameter(builder, i);
        } else if (i2 == 2) {
            applyClearShotParameter(builder);
        } else if (i2 == 3) {
            applySuperResolutionParameter(builder);
        } else if (i2 == 7) {
            MiCameraCompat.applySwMfnrEnable(builder, this.mShouldDoMFNR);
            MiCameraCompat.applyMfnrEnable(builder, false);
            MiCameraCompat.applyMultiFrameInputNum(builder, this.mSequenceNum);
            MiCameraCompat.applyHHT(builder, true);
            Log.i(TAG, "HHT algo in applyAlgoParameter");
        }
        if (b.isMTKPlatform()) {
            MiCameraCompat.copyAiSceneFromCaptureResultToRequest(this.mPreviewCaptureResult, builder);
        } else if (isIn3OrMoreSatMode()) {
            CaptureRequestBuilder.applySmoothTransition(builder, this.mMiCamera.getCapabilities(), false);
            CaptureRequestBuilder.applySatFallback(builder, this.mMiCamera.getCapabilities(), false);
        }
    }

    private void applyClearShotParameter(CaptureRequest.Builder builder) {
        MiCameraCompat.applySwMfnrEnable(builder, this.mShouldDoMFNR);
        MiCameraCompat.applyMfnrEnable(builder, false);
        if (b.fk() || b.en) {
            CompatibilityUtils.setZsl(builder, true);
        }
    }

    private void applyHdrParameter(CaptureRequest.Builder builder, int i) {
        if (i <= this.mSequenceNum) {
            if (!DataRepository.dataItemFeature().Ud()) {
                MiCameraCompat.applyHdrBracketMode(builder, (byte) 1);
            }
            if (!DataRepository.dataItemFeature().Ud() || !this.mMiCamera.getCameraConfigs().isHDREnabled()) {
                MiCameraCompat.applyMultiFrameInputNum(builder, this.mSequenceNum);
            } else {
                Log.e(TAG, "[ALGOUP|MMCAMERA] Algo Up HDR!!!!");
                MiCameraCompat.applyMultiFrameInputNum(builder, this.mSequenceNum * 2);
                builder.set(CaptureRequest.CONTROL_AE_LOCK, true);
            }
            if (b.isMTKPlatform() || b.jn || b.ln || b.nn || b.mn) {
                builder.set(CaptureRequest.CONTROL_AE_LOCK, true);
            }
            builder.set(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, Integer.valueOf(this.mHdrCheckerEvValue[i]));
            MiCameraCompat.applyHdrParameter(builder, this.mHdrCheckerSceneType, this.mHdrCheckerAdrc);
            if (b.jn && ((this.mMiCamera.getSatMasterCameraId() == 2 || this.mMiCamera.getSatMasterCameraId() == 1) && this.mHdrCheckerEvValue[i] >= 0 && isIn3OrMoreSatMode() && this.mSequenceNum < 4)) {
                Log.d(TAG, "applyHdrParameter enable mfnr EV = " + this.mHdrCheckerEvValue[i]);
                MiCameraCompat.applyMfnrEnable(builder, true);
            } else if (this.mSingleCaptureForHDRplusMFNR) {
                MiCameraCompat.applyMfnrEnable(builder, true);
            } else {
                MiCameraCompat.applyMfnrEnable(builder, false);
            }
        } else {
            throw new RuntimeException("wrong request index " + i);
        }
    }

    private void applySuperResolutionParameter(CaptureRequest.Builder builder) {
        MiCameraCompat.applyMultiFrameInputNum(builder, this.mSequenceNum);
        MiCameraCompat.applyMfnrEnable(builder, false);
        if (b.isMTKPlatform()) {
            builder.set(CaptureRequest.SCALER_CROP_REGION, this.mActiveArraySize);
            MiCameraCompat.applyPostProcessCropRegion(builder, HybridZoomingSystem.toCropRegion(this.mMiCamera.getZoomRatio(), this.mActiveArraySize));
        }
    }

    private int getGroupShotMaxImage() {
        Face[] faceArr = (Face[]) this.mPreviewCaptureResult.get(CaptureResult.STATISTICS_FACES);
        return Util.clamp((faceArr != null ? faceArr.length : 0) + 1, 2, 4);
    }

    private int getGroupShotNum() {
        if (Util.isMemoryRich(CameraAppImpl.getAndroidContext())) {
            return getGroupShotMaxImage();
        }
        Log.w(TAG, "getGroupShotNum: low memory");
        return 2;
    }

    private void prepareClearShot(int i) {
        if (b.fk()) {
            this.mSequenceNum = 10;
        } else {
            this.mSequenceNum = 5;
        }
    }

    private void prepareGroupShot() {
        this.mSequenceNum = getGroupShotNum();
    }

    private void prepareHHT() {
        LocalParallelService.LocalBinder localBinder = AlgoConnector.getInstance().getLocalBinder();
        if (localBinder == null || localBinder.isIdle() || this.mMiCamera.getCameraConfigs().isAiASDEnabled() || this.mMiCamera.getCameraConfigs().getBeautyValues().isSmoothLevelOn()) {
            this.mSequenceNum = 5;
            Log.i(TAG, "hht(5 -> 1)");
            return;
        }
        this.mSequenceNum = 3;
        Log.i(TAG, "switch to quick shot hht(3 -> 1)");
    }

    private void prepareHdr() {
        if (this.mSingleCaptureForHDRplusMFNR) {
            this.mSequenceNum = 1;
            this.mHdrCheckerEvValue = new int[]{0};
        } else {
            HdrEvValue hdrEvValue = new HdrEvValue(CaptureResultParser.getHdrCheckerValues(this.mPreviewCaptureResult));
            this.mSequenceNum = hdrEvValue.getSequenceNum();
            this.mHdrCheckerEvValue = hdrEvValue.getHdrCheckerEvValue();
        }
        this.mHdrCheckerSceneType = (Integer) VendorTagHelper.getValueSafely(this.mPreviewCaptureResult, CaptureResultVendorTags.HDR_CHECKER_SCENETYPE);
        this.mHdrCheckerAdrc = (Integer) VendorTagHelper.getValueSafely(this.mPreviewCaptureResult, CaptureResultVendorTags.HDR_CHECKER_ADRC);
        Log.d(TAG, "prepareHdr: scene = " + this.mHdrCheckerSceneType + " adrc = " + this.mHdrCheckerAdrc);
    }

    private void prepareSR() {
        this.mSequenceNum = DataRepository.dataItemFeature().kb();
    }

    /* access modifiers changed from: protected */
    public CameraCaptureSession.CaptureCallback generateCaptureCallback() {
        return new CameraCaptureSession.CaptureCallback() {
            long captureTimestamp = -1;

            public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
                int unused = MiCamera2ShotParallelBurst.this.mCompletedNum = MiCamera2ShotParallelBurst.this.mCompletedNum + 1;
                if (!DataRepository.dataItemFeature().Ud() || !MiCamera2ShotParallelBurst.this.mMiCamera.getCameraConfigs().isHDREnabled()) {
                    Log.d(MiCamera2ShotParallelBurst.TAG, "onCaptureCompleted: " + MiCamera2ShotParallelBurst.this.mCompletedNum + "/" + MiCamera2ShotParallelBurst.this.mSequenceNum);
                } else {
                    Log.d(MiCamera2ShotParallelBurst.TAG, "onCaptureCompleted: " + MiCamera2ShotParallelBurst.this.mCompletedNum + "/" + (MiCamera2ShotParallelBurst.this.mSequenceNum * 2));
                }
                AlgoConnector.getInstance().getLocalBinder().onCaptureCompleted(CameraDeviceUtil.getCustomCaptureResult(totalCaptureResult), MiCamera2ShotParallelBurst.this.mCompletedNum == 1);
                if (!DataRepository.dataItemFeature().Ud() || !MiCamera2ShotParallelBurst.this.mMiCamera.getCameraConfigs().isHDREnabled()) {
                    if (MiCamera2ShotParallelBurst.this.mSequenceNum == MiCamera2ShotParallelBurst.this.mCompletedNum) {
                        MiCamera2ShotParallelBurst miCamera2ShotParallelBurst = MiCamera2ShotParallelBurst.this;
                        miCamera2ShotParallelBurst.mMiCamera.onCapturePictureFinished(true, miCamera2ShotParallelBurst);
                    }
                } else if (MiCamera2ShotParallelBurst.this.mSequenceNum * 2 == MiCamera2ShotParallelBurst.this.mCompletedNum) {
                    MiCamera2ShotParallelBurst miCamera2ShotParallelBurst2 = MiCamera2ShotParallelBurst.this;
                    miCamera2ShotParallelBurst2.mMiCamera.onCapturePictureFinished(true, miCamera2ShotParallelBurst2);
                }
                boolean isSREnable = CaptureResultParser.isSREnable(totalCaptureResult);
                Log.d(MiCamera2ShotParallelBurst.TAG, "onCaptureCompleted: isSREnabled = " + isSREnable);
                Log.d(MiCamera2ShotParallelBurst.TAG, "onCaptureCompleted: hdrEnabled = " + ((Boolean) VendorTagHelper.getValue((CaptureResult) totalCaptureResult, CaptureResultVendorTags.IS_HDR_ENABLE)));
                ImagePool.getInstance().trimPoolBuffer();
            }

            public void onCaptureFailed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureFailure captureFailure) {
                super.onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
                Log.e(MiCamera2ShotParallelBurst.TAG, "onCaptureFailed: reason=" + captureFailure.getReason() + " timestamp=" + this.captureTimestamp);
                MiCamera2ShotParallelBurst miCamera2ShotParallelBurst = MiCamera2ShotParallelBurst.this;
                miCamera2ShotParallelBurst.mMiCamera.onCapturePictureFinished(false, miCamera2ShotParallelBurst);
                if (this.captureTimestamp != -1) {
                    AlgoConnector.getInstance().getLocalBinder().onCaptureFailed(this.captureTimestamp, captureFailure.getReason());
                }
            }

            public void onCaptureStarted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, long j, long j2) {
                long j3 = j;
                Log.d(MiCamera2ShotParallelBurst.TAG, "onCaptureStarted: timestamp=" + j3 + " frameNumber=" + j2 + " isFirst=" + MiCamera2ShotParallelBurst.this.mFirstNum);
                super.onCaptureStarted(cameraCaptureSession, captureRequest, j, j2);
                if (MiCamera2ShotParallelBurst.this.mFirstNum) {
                    Camera2Proxy.PictureCallback pictureCallback = MiCamera2ShotParallelBurst.this.getPictureCallback();
                    if (pictureCallback != null) {
                        ParallelTaskData parallelTaskData = new ParallelTaskData(MiCamera2ShotParallelBurst.this.mMiCamera.getId(), j, MiCamera2ShotParallelBurst.this.mMiCamera.getCameraConfigs().getShotType(), MiCamera2ShotParallelBurst.this.mMiCamera.getCameraConfigs().getShotPath(), MiCamera2ShotParallelBurst.this.mMiCamera.getCameraConfigs().getCaptureTime());
                        MiCamera2ShotParallelBurst miCamera2ShotParallelBurst = MiCamera2ShotParallelBurst.this;
                        ParallelTaskData onCaptureStart = pictureCallback.onCaptureStart(parallelTaskData, miCamera2ShotParallelBurst.mCapturedImageSize, miCamera2ShotParallelBurst.isQuickShotAnimation());
                        if (onCaptureStart != null) {
                            onCaptureStart.setAlgoType(MiCamera2ShotParallelBurst.this.mAlgoType);
                            if (!DataRepository.dataItemFeature().Ud() || !MiCamera2ShotParallelBurst.this.mMiCamera.getCameraConfigs().isHDREnabled()) {
                                onCaptureStart.setBurstNum(MiCamera2ShotParallelBurst.this.mSequenceNum);
                            } else {
                                onCaptureStart.setBurstNum(MiCamera2ShotParallelBurst.this.mSequenceNum * 2);
                            }
                            this.captureTimestamp = j3;
                            AlgoConnector.getInstance().getLocalBinder().onCaptureStarted(onCaptureStart);
                        } else {
                            Log.w(MiCamera2ShotParallelBurst.TAG, "onCaptureStarted: null task data");
                        }
                    } else {
                        Log.w(MiCamera2ShotParallelBurst.TAG, "onCaptureStarted: null picture callback");
                    }
                    boolean unused = MiCamera2ShotParallelBurst.this.mFirstNum = false;
                }
            }
        };
    }

    /* access modifiers changed from: protected */
    public CaptureRequest.Builder generateRequestBuilder() throws CameraAccessException, IllegalStateException {
        CaptureRequest.Builder createCaptureRequest = this.mMiCamera.getCameraDevice().createCaptureRequest(2);
        if (this.mMiCamera.isQcfaEnable()) {
            Surface wideRemoteSurface = this.mShouldDoQcfaCapture ? this.mMiCamera.getWideRemoteSurface() : this.mMiCamera.getQcfaRemoteSurface();
            Size surfaceSize = SurfaceUtils.getSurfaceSize(wideRemoteSurface);
            Log.d(TAG, String.format(Locale.ENGLISH, "[QCFA]add surface %s to capture request, size is: %s", new Object[]{wideRemoteSurface, surfaceSize}));
            createCaptureRequest.addTarget(wideRemoteSurface);
            if (b.fk() || b.en) {
                createCaptureRequest.addTarget(this.mMiCamera.getPreviewSurface());
            }
            configParallelSession(surfaceSize);
        } else {
            if (isIn3OrMoreSatMode() || isInMultiSurfaceSatMode()) {
                Surface mainCaptureSurface = getMainCaptureSurface();
                Size surfaceSize2 = SurfaceUtils.getSurfaceSize(mainCaptureSurface);
                Log.d(TAG, String.format(Locale.ENGLISH, "[SAT]add surface %s to capture request, size is: %s", new Object[]{mainCaptureSurface, surfaceSize2}));
                createCaptureRequest.addTarget(mainCaptureSurface);
                int i = 513;
                if (mainCaptureSurface == this.mMiCamera.getUltraWideRemoteSurface()) {
                    i = 3;
                }
                Log.d(TAG, "[SAT]combinationMode: " + i);
                configParallelSession(surfaceSize2, i);
            } else {
                for (Surface next : this.mMiCamera.getRemoteSurfaceList()) {
                    Log.d(TAG, String.format(Locale.ENGLISH, "add surface %s to capture request, size is: %s", new Object[]{next, SurfaceUtils.getSurfaceSize(next)}));
                    createCaptureRequest.addTarget(next);
                }
                this.mCapturedImageSize = this.mMiCamera.getPictureSize();
            }
            if (!b.isMTKPlatform() && this.mOperationMode != 36865 && (b.fk() || b.en || this.mOperationMode != 36867)) {
                Surface previewSurface = this.mMiCamera.getPreviewSurface();
                Log.d(TAG, String.format(Locale.ENGLISH, "add preview surface %s to capture request, size is: %s", new Object[]{previewSurface, SurfaceUtils.getSurfaceSize(previewSurface)}));
                createCaptureRequest.addTarget(previewSurface);
            }
        }
        createCaptureRequest.set(CaptureRequest.CONTROL_AE_MODE, 1);
        this.mMiCamera.applySettingsForCapture(createCaptureRequest, 3);
        if (!b.isMTKPlatform() || this.mAlgoType == 1) {
            Log.d(TAG, "disable ZSL for HDR");
            CompatibilityUtils.setZsl(createCaptureRequest, false);
        }
        CaptureRequestBuilder.applyFlawDetectEnable(this.mMiCamera.getCapabilities(), createCaptureRequest, this.mMiCamera.getCameraConfigs().isFlawDetectEnable());
        return createCaptureRequest;
    }

    /* access modifiers changed from: protected */
    public void prepare() {
        this.mFirstNum = true;
        this.mShouldDoQcfaCapture = false;
        this.mShouldDoSR = this.mMiCamera.getCameraConfigs().isSuperResolutionEnabled();
        if (this.mMiCamera.getCameraConfigs().isHDREnabled()) {
            this.mAlgoType = 1;
            prepareHdr();
        } else if (CameraSettings.isGroupShotOn()) {
            this.mAlgoType = 5;
            prepareGroupShot();
        } else if (this.mShouldDoSR) {
            this.mAlgoType = 3;
            prepareSR();
        } else {
            Integer num = (Integer) this.mPreviewCaptureResult.get(CaptureResult.SENSOR_SENSITIVITY);
            Log.d(TAG, "prepare: iso = " + num);
            if (b.dk() || b.Xj()) {
                this.mShouldDoMFNR = true;
            } else {
                this.mShouldDoMFNR = num != null && num.intValue() >= 800;
            }
            if (!this.mShouldDoMFNR) {
                this.mAlgoType = 0;
                this.mSequenceNum = 1;
            } else if (b.dk() && CameraSettings.isFrontCamera()) {
                this.mAlgoType = 2;
                prepareClearShot(num.intValue());
            } else if (!b.Xj() || !CameraSettings.isBackCamera()) {
                this.mAlgoType = 2;
                prepareClearShot(num.intValue());
            } else {
                this.mAlgoType = 7;
                prepareHHT();
            }
        }
        Log.d(TAG, String.format(Locale.ENGLISH, "prepare: algo=%d captureNum=%d doMFNR=%b doSR=%b", new Object[]{Integer.valueOf(this.mAlgoType), Integer.valueOf(this.mSequenceNum), Boolean.valueOf(this.mShouldDoMFNR), Boolean.valueOf(this.mShouldDoSR)}));
    }

    /* access modifiers changed from: protected */
    public void startSessionCapture() {
        try {
            CameraCaptureSession.CaptureCallback generateCaptureCallback = generateCaptureCallback();
            CaptureRequest.Builder generateRequestBuilder = generateRequestBuilder();
            for (int i = 0; i < this.mSequenceNum; i++) {
                if (b.isMTKPlatform() && this.mMiCamera.getCapabilities().getCameraId() == Camera2DataContainer.getInstance().getUltraWideCameraId()) {
                    MiCameraCompat.copyFpcDataFromCaptureResultToRequest(this.mPreviewCaptureResult, generateRequestBuilder);
                }
                if (DataRepository.dataItemFeature().Ud()) {
                    MiCameraCompat.applyAlgoUpEnabled(generateRequestBuilder, true);
                }
                applyAlgoParameter(generateRequestBuilder, i, this.mAlgoType);
                this.requests.add(generateRequestBuilder.build());
                if (DataRepository.dataItemFeature().Ud() && this.mMiCamera.getCameraConfigs().isHDREnabled()) {
                    CaptureRequest.Builder generateRequestBuilder2 = generateRequestBuilder();
                    MiCameraCompat.applyAlgoUpEnabled(generateRequestBuilder2, true);
                    applyAlgoParameter(generateRequestBuilder2, i, this.mAlgoType);
                    this.requests.add(generateRequestBuilder2.build());
                }
            }
            Log.d(TAG, "startSessionCapture request number:" + this.requests.size());
            this.mMiCamera.getCaptureSession().captureBurst(this.requests, generateCaptureCallback, this.mCameraHandler);
            MemoryHelper.addCapturedNumber(this.mMiCamera.hashCode(), this.mSequenceNum);
        } catch (CameraAccessException e2) {
            e2.printStackTrace();
            Log.e(TAG, "Cannot captureBurst");
            this.mMiCamera.notifyOnError(e2.getReason());
        } catch (IllegalStateException e3) {
            Log.e(TAG, "Failed to captureBurst, IllegalState", (Throwable) e3);
            this.mMiCamera.notifyOnError(256);
        } catch (IllegalArgumentException e4) {
            Log.e(TAG, "Failed to capture a still picture, IllegalArgument", (Throwable) e4);
            this.mMiCamera.notifyOnError(256);
        }
    }
}
