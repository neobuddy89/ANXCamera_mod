package com.android.camera2;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.utils.SurfaceUtils;
import android.media.Image;
import android.support.annotation.NonNull;
import android.util.Size;
import android.view.Surface;
import com.android.camera.log.Log;
import com.android.camera.parallel.AlgoConnector;
import com.android.camera2.Camera2Proxy;
import com.android.camera2.compat.MiCameraCompat;
import com.mi.config.b;
import com.xiaomi.camera.base.CameraDeviceUtil;
import com.xiaomi.camera.base.PerformanceTracker;
import com.xiaomi.camera.core.ParallelTaskData;
import com.xiaomi.camera.imagecodec.ImagePool;
import java.util.Locale;

public class MiCamera2ShotParallelRepeating extends MiCamera2ShotParallel<byte[]> {
    private static final int INVALID_SEQUENCE_ID = -1;
    private static final String TAG = "ParallelRepeating";
    /* access modifiers changed from: private */
    public CaptureResult mRepeatingCaptureResult;

    public MiCamera2ShotParallelRepeating(MiCamera2 miCamera2, int i) {
        super(miCamera2);
    }

    /* access modifiers changed from: private */
    public void onRepeatingEnd(boolean z, int i) {
        this.mMiCamera.setAWBLock(false);
        this.mMiCamera.resumePreview();
        if (-1 != i) {
            Camera2Proxy.PictureCallback pictureCallback = getPictureCallback();
            if (pictureCallback != null) {
                pictureCallback.onPictureTakenFinished(z);
            } else {
                Log.w(TAG, "onRepeatingEnd: null picture callback");
            }
            this.mMiCamera.onMultiSnapEnd(z, this);
        }
    }

    /* access modifiers changed from: protected */
    public CameraCaptureSession.CaptureCallback generateCaptureCallback() {
        return new CameraCaptureSession.CaptureCallback() {
            long mCaptureTimestamp = -1;

            public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
                super.onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
                Log.d(MiCamera2ShotParallelRepeating.TAG, "onCaptureCompleted: frameNumber=" + totalCaptureResult.getFrameNumber());
                CaptureResult unused = MiCamera2ShotParallelRepeating.this.mRepeatingCaptureResult = totalCaptureResult;
                AlgoConnector.getInstance().getLocalBinder().onCaptureCompleted(CameraDeviceUtil.getCustomCaptureResult(MiCamera2ShotParallelRepeating.this.mRepeatingCaptureResult), true);
            }

            public void onCaptureFailed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureFailure captureFailure) {
                super.onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
                Log.e(MiCamera2ShotParallelRepeating.TAG, "onCaptureFailed: reason=" + captureFailure.getReason());
                MiCamera2ShotParallelRepeating.this.onRepeatingEnd(false, -1);
                if (this.mCaptureTimestamp != -1) {
                    AlgoConnector.getInstance().getLocalBinder().onCaptureFailed(this.mCaptureTimestamp, captureFailure.getReason());
                }
            }

            public void onCaptureSequenceAborted(@NonNull CameraCaptureSession cameraCaptureSession, int i) {
                super.onCaptureSequenceAborted(cameraCaptureSession, i);
                Log.w(MiCamera2ShotParallelRepeating.TAG, "onCaptureSequenceAborted: sequenceId=" + i);
                MiCamera2ShotParallelRepeating.this.onRepeatingEnd(false, i);
                ImagePool.getInstance().trimPoolBuffer();
            }

            public void onCaptureSequenceCompleted(@NonNull CameraCaptureSession cameraCaptureSession, int i, long j) {
                Log.d(MiCamera2ShotParallelRepeating.TAG, "onCaptureSequenceCompleted: sequenceId=" + i + " frameNumber=" + j);
                MiCamera2ShotParallelRepeating.this.onRepeatingEnd(true, i);
                ImagePool.getInstance().trimPoolBuffer();
            }

            public void onCaptureStarted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, long j, long j2) {
                super.onCaptureStarted(cameraCaptureSession, captureRequest, j, j2);
                Log.d(MiCamera2ShotParallelRepeating.TAG, "onCaptureStarted: timestamp=" + j + " frameNumber=" + j2);
                Camera2Proxy.PictureCallback pictureCallback = MiCamera2ShotParallelRepeating.this.getPictureCallback();
                if (pictureCallback != null) {
                    ParallelTaskData parallelTaskData = new ParallelTaskData(MiCamera2ShotParallelRepeating.this.mMiCamera.getId(), j, MiCamera2ShotParallelRepeating.this.mMiCamera.getCameraConfigs().getShotType(), MiCamera2ShotParallelRepeating.this.mMiCamera.getCameraConfigs().getShotPath());
                    MiCamera2ShotParallelRepeating miCamera2ShotParallelRepeating = MiCamera2ShotParallelRepeating.this;
                    ParallelTaskData onCaptureStart = pictureCallback.onCaptureStart(parallelTaskData, miCamera2ShotParallelRepeating.mCapturedImageSize, miCamera2ShotParallelRepeating.isQuickShotAnimation());
                    if (onCaptureStart != null) {
                        onCaptureStart.setAlgoType(4);
                        onCaptureStart.setBurstNum(1);
                        this.mCaptureTimestamp = j;
                        AlgoConnector.getInstance().getLocalBinder().onCaptureStarted(onCaptureStart);
                        return;
                    }
                    Log.w(MiCamera2ShotParallelRepeating.TAG, "onCaptureStarted: null task data");
                    return;
                }
                Log.w(MiCamera2ShotParallelRepeating.TAG, "onCaptureStarted: null picture callback");
            }
        };
    }

    /* access modifiers changed from: protected */
    public CaptureRequest.Builder generateRequestBuilder() throws CameraAccessException, IllegalStateException {
        CaptureRequest.Builder createCaptureRequest = b.isMTKPlatform() ? this.mMiCamera.getCameraDevice().createCaptureRequest(1) : this.mMiCamera.getCameraDevice().createCaptureRequest(2);
        if (isIn3OrMoreSatMode() || isInMultiSurfaceSatMode()) {
            Surface mainCaptureSurface = getMainCaptureSurface();
            Size surfaceSize = SurfaceUtils.getSurfaceSize(mainCaptureSurface);
            Log.d(TAG, String.format(Locale.ENGLISH, "add surface %s to capture request, size is: %s", new Object[]{mainCaptureSurface, surfaceSize}));
            createCaptureRequest.addTarget(mainCaptureSurface);
            int i = 513;
            if (mainCaptureSurface == this.mMiCamera.getUltraWideRemoteSurface()) {
                i = 3;
            }
            Log.d(TAG, "combinationMode: " + i);
            configParallelSession(surfaceSize, i);
        } else {
            for (Surface next : this.mMiCamera.getRemoteSurfaceList()) {
                Log.d(TAG, String.format(Locale.ENGLISH, "add surface %s to capture request, size is: %s", new Object[]{next, SurfaceUtils.getSurfaceSize(next)}));
                createCaptureRequest.addTarget(next);
            }
            this.mCapturedImageSize = this.mMiCamera.getPictureSize();
        }
        createCaptureRequest.addTarget(this.mMiCamera.getPreviewSurface());
        createCaptureRequest.set(CaptureRequest.CONTROL_AF_MODE, (Integer) this.mMiCamera.getPreviewRequestBuilder().get(CaptureRequest.CONTROL_AF_MODE));
        this.mMiCamera.applySettingsForCapture(createCaptureRequest, 3);
        MiCameraCompat.applyMfnrEnable(createCaptureRequest, false);
        MiCameraCompat.applyHDR(createCaptureRequest, false);
        MiCameraCompat.applySuperResolution(createCaptureRequest, false);
        MiCameraCompat.applyDepurpleEnable(createCaptureRequest, false);
        if (isIn3OrMoreSatMode() && !b.isMTKPlatform()) {
            CaptureRequestBuilder.applySmoothTransition(createCaptureRequest, this.mMiCamera.getCapabilities(), false);
            CaptureRequestBuilder.applySatFallback(createCaptureRequest, this.mMiCamera.getCapabilities(), false);
        }
        MiCameraCompat.applyMultiFrameInputNum(createCaptureRequest, 1);
        return createCaptureRequest;
    }

    /* access modifiers changed from: protected */
    public void notifyResultData(byte[] bArr) {
    }

    /* access modifiers changed from: protected */
    public void onImageReceived(Image image, int i) {
    }

    /* access modifiers changed from: protected */
    public void prepare() {
        this.mMiCamera.setAWBLock(true);
    }

    /* access modifiers changed from: protected */
    public void startSessionCapture() {
        Log.d(TAG, "startSessionCapture");
        PerformanceTracker.trackPictureCapture(0);
        this.mMiCamera.pausePreview();
        try {
            int repeatingRequest = this.mMiCamera.getCaptureSession().setRepeatingRequest(generateRequestBuilder().build(), generateCaptureCallback(), this.mCameraHandler);
            Log.d(TAG, "repeating sequenceId: " + repeatingRequest);
        } catch (CameraAccessException e2) {
            e2.printStackTrace();
            this.mMiCamera.notifyOnError(e2.getReason());
        } catch (IllegalStateException e3) {
            Log.e(TAG, "Failed to capture burst, IllegalState", (Throwable) e3);
            this.mMiCamera.notifyOnError(256);
        } catch (IllegalArgumentException e4) {
            Log.e(TAG, "Failed to capture a still picture, IllegalArgument", (Throwable) e4);
            this.mMiCamera.notifyOnError(256);
        }
    }
}
