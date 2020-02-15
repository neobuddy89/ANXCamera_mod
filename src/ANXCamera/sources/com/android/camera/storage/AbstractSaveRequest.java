package com.android.camera.storage;

import android.location.Location;
import android.net.Uri;
import com.android.camera.CameraSettings;
import com.android.camera.Util;
import com.android.camera.effect.EffectController;
import com.android.camera.effect.FilterInfo;
import com.android.camera.effect.draw_mode.DrawJPEGAttribute;
import com.android.camera.lib.compatibility.util.CompatibilityUtils;
import com.android.camera.log.Log;
import com.android.camera.watermark.WaterMarkData;
import com.android.camera2.ArcsoftDepthMap;
import com.android.gallery3d.exif.ExifHelper;
import com.android.gallery3d.exif.ExifInterface;
import com.mi.config.b;
import com.xiaomi.camera.base.Constants;
import com.xiaomi.camera.base.PerformanceTracker;
import com.xiaomi.camera.core.ParallelTaskData;
import com.xiaomi.camera.core.ParallelTaskDataParameter;
import com.xiaomi.camera.core.PictureInfo;
import com.xiaomi.camera.liveshot.CircularMediaRecorder;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Locale;

public abstract class AbstractSaveRequest implements SaveRequest {
    private static final String TAG = "AbstractSaveRequest";
    protected long date;
    public int height;
    protected ParallelTaskData mParallelTaskData;
    private WeakReference<SaverCallback> mSaverCallbackRef;
    public int orientation;
    public int width;

    private DrawJPEGAttribute getDrawJPEGAttribute(byte[] bArr, int i, int i2, int i3, boolean z, int i4, int i5, Location location, String str, int i6, int i7, float f2, String str2, boolean z2, boolean z3, String str3, List<WaterMarkData> list, boolean z4, PictureInfo pictureInfo, int i8, int i9) {
        int i10 = i4;
        int i11 = i5;
        Location location2 = location;
        DrawJPEGAttribute drawJPEGAttribute = new DrawJPEGAttribute(bArr, z, i10 > i11 ? Math.max(i, i2) : Math.min(i, i2), i11 > i10 ? Math.max(i, i2) : Math.min(i, i2), i4, i5, i3, EffectController.getInstance().copyEffectRectAttribute(), location2 == null ? null : new Location(location2), str, System.currentTimeMillis(), i6, i7, f2, pictureInfo.isFrontMirror(), str2, z2, pictureInfo, list, CameraSettings.isDualCameraWaterMarkOpen() || CameraSettings.isFrontCameraWaterMarkOpen(), z3, CameraSettings.isTimeWaterMarkOpen() ? str3 : null, z4, i8, i9);
        return drawJPEGAttribute;
    }

    private SaverCallback getSaverCallback() {
        WeakReference<SaverCallback> weakReference = this.mSaverCallbackRef;
        if (weakReference != null) {
            return (SaverCallback) weakReference.get();
        }
        return null;
    }

    private void parserMimojiCaptureTask(ParallelTaskData parallelTaskData) {
        int i;
        int i2;
        ParallelTaskDataParameter parallelTaskDataParameter;
        ParallelTaskDataParameter dataParameter = parallelTaskData.getDataParameter();
        byte[] jpegImageData = parallelTaskData.getJpegImageData();
        int width2 = dataParameter.getPictureSize().getWidth();
        int height2 = dataParameter.getPictureSize().getHeight();
        int jpegRotation = dataParameter.getJpegRotation();
        int filterId = dataParameter.getFilterId();
        ExifInterface exif = ExifInterface.getExif(jpegImageData);
        int orientation2 = ExifInterface.getOrientation(exif);
        boolean z = EffectController.getInstance().hasEffect(false) || filterId != FilterInfo.FILTER_ID_NONE;
        String createJpegName = Util.createJpegName(System.currentTimeMillis());
        if (parallelTaskData.isAdaptiveSnapshotSize()) {
            int imageWidth = ExifInterface.getImageWidth(exif);
            i = ExifInterface.getImageHeight(exif);
            i2 = imageWidth;
        } else if ((jpegRotation + orientation2) % 180 == 0) {
            i2 = width2;
            i = height2;
        } else {
            i = width2;
            i2 = height2;
        }
        if (z || dataParameter.isHasWaterMark()) {
            SaverCallback saverCallback = getSaverCallback();
            if (saverCallback != null) {
                parallelTaskDataParameter = dataParameter;
                SaverCallback saverCallback2 = saverCallback;
                DrawJPEGAttribute drawJPEGAttribute = getDrawJPEGAttribute(jpegImageData, dataParameter.getPreviewSize().getWidth(), dataParameter.getPreviewSize().getHeight(), filterId, parallelTaskData.isNeedThumbnail(), i2, i, dataParameter.getLocation(), createJpegName, dataParameter.getShootOrientation(), jpegRotation, dataParameter.getShootRotation(), dataParameter.getAlgorithmName(), dataParameter.isHasWaterMark(), dataParameter.isUltraPixelWaterMark(), dataParameter.getTimeWaterMarkString(), dataParameter.getFaceWaterMarkList(), false, dataParameter.getPictureInfo(), parallelTaskData.getCurrentModuleIndex(), parallelTaskData.getPreviewThumbnailHash());
                saverCallback2.processorJpegSync(false, drawJPEGAttribute);
                jpegImageData = drawJPEGAttribute.mData;
            } else {
                parallelTaskDataParameter = dataParameter;
                Log.d(TAG, "parserMimojiCaptureTask(): saverCallback is null");
            }
        } else {
            parallelTaskDataParameter = dataParameter;
        }
        reFillSaveRequest(jpegImageData, parallelTaskData.isNeedThumbnail(), createJpegName, (String) null, parallelTaskData.getDateTakenTime(), (Uri) null, parallelTaskDataParameter.getLocation(), width2, height2, (ExifInterface) null, jpegRotation, false, false, true, false, false, Util.ALGORITHM_NAME_MIMOJI_CAPTURE, parallelTaskDataParameter.getPictureInfo(), parallelTaskData.getPreviewThumbnailHash());
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x01c4  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x01f0  */
    private void parserNormalDualTask(ParallelTaskData parallelTaskData) {
        int i;
        int i2;
        String str;
        String str2;
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3;
        int[] iArr;
        byte[] bArr4;
        String str3;
        boolean isDepthMapData = ArcsoftDepthMap.isDepthMapData(parallelTaskData.getPortraitDepthData());
        byte[] jpegImageData = parallelTaskData.getJpegImageData();
        byte[] portraitRawData = parallelTaskData.getPortraitRawData();
        byte[] portraitDepthData = parallelTaskData.getPortraitDepthData();
        ParallelTaskDataParameter dataParameter = parallelTaskData.getDataParameter();
        int filterId = dataParameter.getFilterId();
        boolean z = EffectController.getInstance().hasEffect(false) || filterId != FilterInfo.FILTER_ID_NONE;
        int width2 = dataParameter.getPictureSize().getWidth();
        int height2 = dataParameter.getPictureSize().getHeight();
        ExifInterface exif = ExifInterface.getExif(jpegImageData);
        int orientation2 = ExifInterface.getOrientation(exif);
        int jpegRotation = dataParameter.getJpegRotation();
        if (parallelTaskData.isAdaptiveSnapshotSize()) {
            width2 = ExifInterface.getImageWidth(exif);
            height2 = ExifInterface.getImageHeight(exif);
        } else if ((jpegRotation + orientation2) % 180 != 0) {
            i = width2;
            i2 = height2;
            if (!parallelTaskData.isShot2Gallery()) {
                str = Util.getFileTitleFromPath(parallelTaskData.getSavePath());
            } else {
                str = Util.createJpegName(System.currentTimeMillis()) + dataParameter.getSuffix();
            }
            String str4 = str;
            if (!z) {
                SaverCallback saverCallback = getSaverCallback();
                if (saverCallback != null) {
                    int width3 = dataParameter.getPreviewSize().getWidth();
                    int height3 = dataParameter.getPreviewSize().getHeight();
                    boolean isNeedThumbnail = parallelTaskData.isNeedThumbnail();
                    Location location = dataParameter.getLocation();
                    int shootOrientation = dataParameter.getShootOrientation();
                    float shootRotation = dataParameter.getShootRotation();
                    String algorithmName = dataParameter.getAlgorithmName();
                    boolean isHasWaterMark = dataParameter.isHasWaterMark();
                    String timeWaterMarkString = dataParameter.getTimeWaterMarkString();
                    List<WaterMarkData> faceWaterMarkList = dataParameter.getFaceWaterMarkList();
                    PictureInfo pictureInfo = dataParameter.getPictureInfo();
                    int currentModuleIndex = parallelTaskData.getCurrentModuleIndex();
                    SaverCallback saverCallback2 = saverCallback;
                    String str5 = TAG;
                    int i3 = filterId;
                    DrawJPEGAttribute drawJPEGAttribute = getDrawJPEGAttribute(jpegImageData, width3, height3, filterId, isNeedThumbnail, i2, i, location, str4, shootOrientation, orientation2, shootRotation, algorithmName, isHasWaterMark, false, timeWaterMarkString, faceWaterMarkList, false, pictureInfo, currentModuleIndex, -1);
                    DrawJPEGAttribute drawJPEGAttribute2 = isDepthMapData ? getDrawJPEGAttribute(portraitRawData, dataParameter.getPreviewSize().getWidth(), dataParameter.getPreviewSize().getHeight(), i3, parallelTaskData.isNeedThumbnail(), i2, i, dataParameter.getLocation(), str4, dataParameter.getShootOrientation(), orientation2, dataParameter.getShootRotation(), dataParameter.getAlgorithmName(), false, false, dataParameter.getTimeWaterMarkString(), dataParameter.getFaceWaterMarkList(), true, dataParameter.getPictureInfo(), parallelTaskData.getCurrentModuleIndex(), -1) : null;
                    saverCallback2.processorJpegSync(false, drawJPEGAttribute, drawJPEGAttribute2);
                    bArr3 = drawJPEGAttribute.mData;
                    byte[] bArr5 = drawJPEGAttribute.mDataOfTheRegionUnderWatermarks;
                    iArr = drawJPEGAttribute.mCoordinatesOfTheRegionUnderWatermarks;
                    if (b.jn) {
                        iArr = null;
                        bArr5 = null;
                    }
                    if (isDepthMapData) {
                        portraitRawData = drawJPEGAttribute2.mData;
                    }
                    bArr = bArr5;
                    bArr2 = portraitRawData;
                    str2 = str5;
                    if (isDepthMapData) {
                        str3 = str2;
                        bArr4 = Util.composeDepthMapPicture(bArr3, portraitDepthData, bArr2, bArr, iArr, dataParameter.isHasDualWaterMark(), dataParameter.isHasFrontWaterMark(), dataParameter.getLightingPattern(), dataParameter.getTimeWaterMarkString(), dataParameter.getOutputSize().getWidth(), dataParameter.getOutputSize().getHeight(), dataParameter.isMirror(), dataParameter.isBokehFrontCamera(), dataParameter.getJpegRotation(), dataParameter.getDeviceWatermarkParam(), dataParameter.getPictureInfo(), parallelTaskData.getTimestamp());
                    } else {
                        str3 = str2;
                        bArr4 = Util.composeMainSubPicture(bArr3, bArr, iArr);
                    }
                    Log.d(str3, "insertNormalDualTask: isShot2Gallery = " + parallelTaskData.isShot2Gallery());
                    if (parallelTaskData.isShot2Gallery()) {
                        parallelTaskData.refillJpegData(bArr4);
                        parserParallelDualTask(parallelTaskData);
                        return;
                    }
                    ParallelTaskData parallelTaskData2 = parallelTaskData;
                    reFillSaveRequest(bArr4, parallelTaskData.isNeedThumbnail(), str4, (String) null, parallelTaskData.getDateTakenTime(), (Uri) null, dataParameter.getLocation(), i2, i, (ExifInterface) null, orientation2, false, false, true, false, false, dataParameter.getAlgorithmName(), dataParameter.getPictureInfo(), -1);
                    return;
                }
                str2 = TAG;
                Log.d(str2, "parserNormalDualTask(): saverCallback is null");
            } else {
                str2 = TAG;
            }
            bArr3 = jpegImageData;
            bArr2 = portraitRawData;
            iArr = null;
            bArr = null;
            if (isDepthMapData) {
            }
            Log.d(str3, "insertNormalDualTask: isShot2Gallery = " + parallelTaskData.isShot2Gallery());
            if (parallelTaskData.isShot2Gallery()) {
            }
        }
        i2 = width2;
        i = height2;
        if (!parallelTaskData.isShot2Gallery()) {
        }
        String str42 = str;
        if (!z) {
        }
        bArr3 = jpegImageData;
        bArr2 = portraitRawData;
        iArr = null;
        bArr = null;
        if (isDepthMapData) {
        }
        Log.d(str3, "insertNormalDualTask: isShot2Gallery = " + parallelTaskData.isShot2Gallery());
        if (parallelTaskData.isShot2Gallery()) {
        }
    }

    private void parserParallelBurstTask(ParallelTaskData parallelTaskData) {
        ParallelTaskDataParameter dataParameter = parallelTaskData.getDataParameter();
        Log.d(TAG, "insertParallelBurstTask: path=" + parallelTaskData.getSavePath());
        byte[] populateExif = populateExif(parallelTaskData.getJpegImageData(), parallelTaskData);
        byte[] dataOfTheRegionUnderWatermarks = parallelTaskData.getDataOfTheRegionUnderWatermarks();
        int[] coordinatesOfTheRegionUnderWatermarks = parallelTaskData.getCoordinatesOfTheRegionUnderWatermarks();
        int width2 = dataParameter.getPictureSize().getWidth();
        int height2 = dataParameter.getPictureSize().getHeight();
        int orientation2 = ExifHelper.getOrientation(populateExif);
        int jpegRotation = dataParameter.getJpegRotation();
        Log.d(TAG, String.format(Locale.ENGLISH, "insertParallelBurstTask: %d x %d, %d : %d", new Object[]{Integer.valueOf(width2), Integer.valueOf(height2), Integer.valueOf(jpegRotation), Integer.valueOf(orientation2)}));
        if ((jpegRotation + orientation2) % 180 != 0) {
            int i = height2;
            height2 = width2;
            width2 = i;
        }
        Log.d(TAG, "insertParallelBurstTask: result = " + width2 + "x" + height2);
        String fileTitleFromPath = Util.getFileTitleFromPath(parallelTaskData.getSavePath());
        StringBuilder sb = new StringBuilder();
        sb.append("insertParallelBurstTask: ");
        sb.append(fileTitleFromPath);
        Log.d(TAG, sb.toString());
        int i2 = width2;
        int i3 = height2;
        reFillSaveRequest(Util.composeMainSubPicture(populateExif, dataOfTheRegionUnderWatermarks, coordinatesOfTheRegionUnderWatermarks), parallelTaskData.isNeedThumbnail(), fileTitleFromPath, (String) null, parallelTaskData.getDateTakenTime(), (Uri) null, dataParameter.getLocation(), i2, i3, (ExifInterface) null, orientation2, false, false, parallelTaskData.isNeedThumbnail(), false, true, dataParameter.getAlgorithmName(), dataParameter.getPictureInfo(), -1);
    }

    private void parserParallelDualTask(ParallelTaskData parallelTaskData) {
        byte[] bArr;
        byte[] composeLiveShotPicture;
        ParallelTaskDataParameter dataParameter = parallelTaskData.getDataParameter();
        Log.d(TAG, "addParallel: path=" + parallelTaskData.getSavePath());
        byte[] populateExif = populateExif(parallelTaskData.getJpegImageData(), parallelTaskData);
        byte[] dataOfTheRegionUnderWatermarks = parallelTaskData.getDataOfTheRegionUnderWatermarks();
        int[] coordinatesOfTheRegionUnderWatermarks = parallelTaskData.getCoordinatesOfTheRegionUnderWatermarks();
        if ((6 == parallelTaskData.getParallelType() || 8 == parallelTaskData.getParallelType() || 7 == parallelTaskData.getParallelType() || -6 == parallelTaskData.getParallelType() || -7 == parallelTaskData.getParallelType()) && ArcsoftDepthMap.isDepthMapData(parallelTaskData.getPortraitDepthData())) {
            composeLiveShotPicture = Util.composeDepthMapPicture(populateExif, parallelTaskData.getPortraitDepthData(), parallelTaskData.getPortraitRawData(), dataOfTheRegionUnderWatermarks, coordinatesOfTheRegionUnderWatermarks, dataParameter.isHasDualWaterMark(), dataParameter.isHasFrontWaterMark(), dataParameter.getLightingPattern(), dataParameter.getTimeWaterMarkString(), dataParameter.getOutputSize().getWidth(), dataParameter.getOutputSize().getHeight(), dataParameter.isMirror(), dataParameter.isBokehFrontCamera(), dataParameter.getJpegRotation(), dataParameter.getDeviceWatermarkParam(), dataParameter.getPictureInfo(), parallelTaskData.getTimestamp());
        } else if (parallelTaskData.isLiveShotTask()) {
            String microVideoPath = parallelTaskData.getMicroVideoPath();
            long coverFrameTimestamp = parallelTaskData.getCoverFrameTimestamp();
            String str = microVideoPath;
            composeLiveShotPicture = Util.composeLiveShotPicture(populateExif, dataParameter.getOutputSize().getWidth(), dataParameter.getOutputSize().getHeight(), microVideoPath, coverFrameTimestamp, dataParameter.isHasDualWaterMark(), dataParameter.isHasFrontWaterMark(), dataParameter.getTimeWaterMarkString(), dataParameter.getJpegRotation(), dataParameter.getDeviceWatermarkParam(), dataOfTheRegionUnderWatermarks, coordinatesOfTheRegionUnderWatermarks);
            if (str != null && !CircularMediaRecorder.VideoClipSavingCallback.EMPTY_VIDEO_PATH.equals(str) && !Util.keepLiveShotMicroVideoInCache()) {
                Util.deleteFile(str);
            }
        } else {
            bArr = Util.composeMainSubPicture(populateExif, dataOfTheRegionUnderWatermarks, coordinatesOfTheRegionUnderWatermarks);
            if (parallelTaskData.getParallelType() != -7 || parallelTaskData.getParallelType() == -6 || parallelTaskData.getParallelType() == -5) {
                ExifInterface exif = ExifInterface.getExif(bArr);
                this.orientation = ExifInterface.getOrientation(exif);
                this.width = ExifInterface.getImageWidth(exif);
                parallelTaskData.refillJpegData(bArr);
            }
            reFillSaveRequest(bArr, parallelTaskData.getTimestamp(), parallelTaskData.getDateTakenTime(), dataParameter.getLocation(), dataParameter.getJpegRotation(), parallelTaskData.getSavePath(), dataParameter.getOutputSize().getWidth(), dataParameter.getOutputSize().getHeight(), parallelTaskData.isNeedThumbnail(), dataParameter.getAlgorithmName(), dataParameter.getPictureInfo());
            return;
        }
        bArr = composeLiveShotPicture;
        if (parallelTaskData.getParallelType() != -7) {
        }
        ExifInterface exif2 = ExifInterface.getExif(bArr);
        this.orientation = ExifInterface.getOrientation(exif2);
        this.width = ExifInterface.getImageWidth(exif2);
        parallelTaskData.refillJpegData(bArr);
    }

    private void parserPreviewShotTask(ParallelTaskData parallelTaskData) {
        PictureInfo pictureInfo;
        String str;
        int i;
        int i2;
        int i3;
        Location location;
        byte[] jpegImageData = parallelTaskData.getJpegImageData();
        ParallelTaskDataParameter dataParameter = parallelTaskData.getDataParameter();
        if (dataParameter != null) {
            int width2 = dataParameter.getOutputSize().getWidth();
            int height2 = dataParameter.getOutputSize().getHeight();
            Location location2 = dataParameter.getLocation();
            String algorithmName = dataParameter.getAlgorithmName();
            PictureInfo pictureInfo2 = dataParameter.getPictureInfo();
            i = dataParameter.getOrientation();
            i2 = height2;
            str = algorithmName;
            pictureInfo = pictureInfo2;
            i3 = width2;
            location = location2;
        } else {
            location = null;
            str = null;
            pictureInfo = null;
            i3 = 0;
            i2 = 0;
            i = 0;
        }
        PerformanceTracker.trackImageSaver(jpegImageData, 0);
        reFillSaveRequest(jpegImageData, parallelTaskData.isNeedThumbnail(), parallelTaskData.getSavePath(), parallelTaskData.getDateTakenTime(), location, i3, i2, i, true, true, str, pictureInfo);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01d0  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x023d  */
    private void parserSingleTask(ParallelTaskData parallelTaskData) {
        int i;
        int i2;
        String str;
        int i3;
        String str2;
        int i4;
        byte[] bArr;
        int i5;
        String str3;
        int[] iArr;
        int i6;
        int i7;
        AbstractSaveRequest abstractSaveRequest;
        ParallelTaskData parallelTaskData2;
        String str4;
        ParallelTaskData parallelTaskData3 = parallelTaskData;
        ParallelTaskDataParameter dataParameter = parallelTaskData.getDataParameter();
        int filterId = dataParameter.getFilterId();
        boolean z = EffectController.getInstance().hasEffect(false) || filterId != FilterInfo.FILTER_ID_NONE;
        byte[] jpegImageData = parallelTaskData.getJpegImageData();
        int width2 = dataParameter.getPictureSize().getWidth();
        int height2 = dataParameter.getPictureSize().getHeight();
        ExifInterface exif = ExifInterface.getExif(jpegImageData);
        int orientation2 = ExifInterface.getOrientation(exif);
        int jpegRotation = dataParameter.getJpegRotation();
        if (parallelTaskData.isAdaptiveSnapshotSize()) {
            int imageWidth = ExifInterface.getImageWidth(exif);
            i = ExifInterface.getImageHeight(exif);
            i2 = imageWidth;
        } else if ((jpegRotation + orientation2) % 180 == 0) {
            i2 = width2;
            i = height2;
        } else {
            i = width2;
            i2 = height2;
        }
        if (parallelTaskData.isShot2Gallery()) {
            str = Util.getFileTitleFromPath(parallelTaskData.getSavePath());
        } else {
            str = Util.createJpegName(System.currentTimeMillis()) + dataParameter.getSuffix();
        }
        String str5 = str;
        if (z) {
            SaverCallback saverCallback = getSaverCallback();
            if (saverCallback != null) {
                int width3 = dataParameter.getPreviewSize().getWidth();
                int height3 = dataParameter.getPreviewSize().getHeight();
                boolean isNeedThumbnail = parallelTaskData.isNeedThumbnail();
                Location location = dataParameter.getLocation();
                int shootOrientation = dataParameter.getShootOrientation();
                float shootRotation = dataParameter.getShootRotation();
                String algorithmName = dataParameter.getAlgorithmName();
                String str6 = TAG;
                str2 = str5;
                i3 = orientation2;
                SaverCallback saverCallback2 = saverCallback;
                DrawJPEGAttribute drawJPEGAttribute = getDrawJPEGAttribute(jpegImageData, width3, height3, filterId, isNeedThumbnail, i2, i, location, str2, shootOrientation, i3, shootRotation, algorithmName, dataParameter.isHasWaterMark(), dataParameter.isUltraPixelWaterMark(), dataParameter.getTimeWaterMarkString(), dataParameter.getFaceWaterMarkList(), false, dataParameter.getPictureInfo(), parallelTaskData.getCurrentModuleIndex(), parallelTaskData.getPreviewThumbnailHash());
                saverCallback2.processorJpegSync(false, drawJPEGAttribute);
                jpegImageData = drawJPEGAttribute.mData;
                int i8 = drawJPEGAttribute.mWidth;
                i5 = drawJPEGAttribute.mHeight;
                bArr = drawJPEGAttribute.mDataOfTheRegionUnderWatermarks;
                iArr = drawJPEGAttribute.mCoordinatesOfTheRegionUnderWatermarks;
                if (b.jn) {
                    iArr = null;
                    bArr = null;
                }
                i4 = i8;
                str3 = str6;
                if (parallelTaskData.isLiveShotTask()) {
                    byte[] composeMainSubPicture = Util.composeMainSubPicture(jpegImageData, bArr, iArr);
                    if (composeMainSubPicture == null || composeMainSubPicture.length < jpegImageData.length) {
                        Log.e(str3, "Failed to compose main sub photos: " + str2);
                    } else {
                        jpegImageData = composeMainSubPicture;
                    }
                } else {
                    String str7 = str2;
                    String microVideoPath = parallelTaskData.getMicroVideoPath();
                    byte[] composeLiveShotPicture = Util.composeLiveShotPicture(jpegImageData, width2, height2, microVideoPath, parallelTaskData.getCoverFrameTimestamp(), dataParameter.isHasDualWaterMark(), dataParameter.isHasFrontWaterMark(), dataParameter.getTimeWaterMarkString(), dataParameter.getJpegRotation(), dataParameter.getDeviceWatermarkParam(), bArr, iArr);
                    if (composeLiveShotPicture == null || composeLiveShotPicture.length < jpegImageData.length) {
                        Log.e(str3, "Failed to compose LiveShot photo: " + str7);
                        composeLiveShotPicture = jpegImageData;
                        str4 = str7;
                    } else {
                        str4 = dataParameter.getPrefix() + str7;
                    }
                    if (microVideoPath != null && !CircularMediaRecorder.VideoClipSavingCallback.EMPTY_VIDEO_PATH.equals(microVideoPath)) {
                        Util.deleteFile(microVideoPath);
                    }
                    jpegImageData = composeLiveShotPicture;
                    str2 = str4;
                }
                if (parallelTaskData.getParallelType() != -2) {
                    parallelTaskData2 = parallelTaskData;
                    i6 = i5;
                    i7 = i4;
                    abstractSaveRequest = this;
                } else if (parallelTaskData.getParallelType() == -3) {
                    abstractSaveRequest = this;
                    parallelTaskData2 = parallelTaskData;
                    i6 = i5;
                    i7 = i4;
                } else {
                    Log.d(str3, "insertSingleTask: isShot2Gallery = " + parallelTaskData.isShot2Gallery());
                    if (parallelTaskData.isShot2Gallery()) {
                        parallelTaskData.refillJpegData(jpegImageData);
                        parallelTaskData.getDataParameter().updateOutputSize(i4, i5);
                        parserParallelDualTask(parallelTaskData);
                        return;
                    }
                    ParallelTaskData parallelTaskData4 = parallelTaskData;
                    reFillSaveRequest(jpegImageData, parallelTaskData.isNeedThumbnail(), str2, (String) null, parallelTaskData.getDateTakenTime(), (Uri) null, dataParameter.getLocation(), i4, i5, (ExifInterface) null, i3, false, false, true, false, false, dataParameter.getAlgorithmName(), dataParameter.getPictureInfo(), parallelTaskData.getPreviewThumbnailHash());
                    return;
                }
                abstractSaveRequest.width = i7;
                abstractSaveRequest.height = i6;
                abstractSaveRequest.orientation = i3;
                parallelTaskData2.refillJpegData(jpegImageData);
            }
            str2 = str5;
            i3 = orientation2;
            str3 = TAG;
            Log.d(str3, "parserSingleTask(): saverCallback is null");
        } else {
            str3 = TAG;
            str2 = str5;
            i3 = orientation2;
        }
        i4 = i2;
        i5 = i;
        iArr = null;
        bArr = null;
        if (parallelTaskData.isLiveShotTask()) {
        }
        if (parallelTaskData.getParallelType() != -2) {
        }
        abstractSaveRequest.width = i7;
        abstractSaveRequest.height = i6;
        abstractSaveRequest.orientation = i3;
        parallelTaskData2.refillJpegData(jpegImageData);
    }

    private static byte[] populateExif(byte[] bArr, ParallelTaskData parallelTaskData) {
        if (parallelTaskData == null || parallelTaskData.getCaptureResult() == null) {
            return bArr;
        }
        return Util.appendCaptureResultToExif(bArr, parallelTaskData.getDataParameter().getPictureSize().getWidth(), parallelTaskData.getDataParameter().getPictureSize().getHeight(), parallelTaskData.getDataParameter().getJpegRotation(), parallelTaskData.getDateTakenTime(), parallelTaskData.getDataParameter().getLocation(), parallelTaskData.getCaptureResult().getResults());
    }

    /* access modifiers changed from: protected */
    public int calculateMemoryUsed() {
        ParallelTaskData parallelTaskData = this.mParallelTaskData;
        int i = 0;
        if (parallelTaskData == null) {
            return 0;
        }
        byte[] jpegImageData = parallelTaskData.getJpegImageData();
        int length = jpegImageData == null ? 0 : jpegImageData.length;
        byte[] portraitRawData = this.mParallelTaskData.getPortraitRawData();
        int length2 = length + (portraitRawData == null ? 0 : portraitRawData.length);
        byte[] portraitDepthData = this.mParallelTaskData.getPortraitDepthData();
        if (portraitDepthData != null) {
            i = portraitDepthData.length;
        }
        return i + length2;
    }

    /* access modifiers changed from: protected */
    public boolean isHeicSavingRequest() {
        ParallelTaskData parallelTaskData = this.mParallelTaskData;
        return (parallelTaskData == null || parallelTaskData.getDataParameter() == null || !CompatibilityUtils.isHeicImageFormat(this.mParallelTaskData.getDataParameter().getOutputFormat())) ? false : true;
    }

    /* access modifiers changed from: protected */
    public void parserParallelTaskData() {
        ParallelTaskData parallelTaskData = this.mParallelTaskData;
        if (parallelTaskData == null) {
            Log.v(TAG, "mParallelTaskData is null, ignore");
            return;
        }
        switch (parallelTaskData.getParallelType()) {
            case Constants.ShotType.INTENT_PARALLEL_DUAL_SHOT /*-7*/:
            case Constants.ShotType.INTENT_PARALLEL_SINGLE_PORTRAIT /*-6*/:
            case Constants.ShotType.INTENT_PARALLEL_SINGLE_SHOT /*-5*/:
            case 5:
            case 6:
            case 7:
            case 8:
                parserParallelDualTask(this.mParallelTaskData);
                return;
            case -4:
                parserMimojiCaptureTask(this.mParallelTaskData);
                return;
            case -3:
            case -2:
            case 0:
            case 1:
            case 10:
                parserSingleTask(this.mParallelTaskData);
                return;
            case -1:
                parserPreviewShotTask(this.mParallelTaskData);
                return;
            case 2:
                parserNormalDualTask(this.mParallelTaskData);
                return;
            case 9:
                parserParallelBurstTask(this.mParallelTaskData);
                return;
            default:
                throw new RuntimeException("Unknown shot type: " + this.mParallelTaskData.getParallelType());
        }
    }

    /* access modifiers changed from: protected */
    public void reFillSaveRequest(byte[] bArr, long j, long j2, Location location, int i, String str, int i2, int i3, boolean z, String str2, PictureInfo pictureInfo) {
    }

    /* access modifiers changed from: protected */
    public void reFillSaveRequest(byte[] bArr, boolean z, String str, long j, Location location, int i, int i2, int i3, boolean z2, boolean z3, String str2, PictureInfo pictureInfo) {
    }

    /* access modifiers changed from: protected */
    public void reFillSaveRequest(byte[] bArr, boolean z, String str, String str2, long j, Uri uri, Location location, int i, int i2, ExifInterface exifInterface, int i3, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, String str3, PictureInfo pictureInfo, int i4) {
    }

    public void setParallelTaskData(ParallelTaskData parallelTaskData) {
        this.mParallelTaskData = parallelTaskData;
    }

    public void setSaverCallback(SaverCallback saverCallback) {
        this.mSaverCallbackRef = new WeakReference<>(saverCallback);
    }
}
