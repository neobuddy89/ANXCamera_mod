package com.xiaomi.camera.core;

import com.android.camera.log.Log;
import com.xiaomi.camera.base.Constants;
import com.xiaomi.camera.core.ParallelTaskDataParameter;
import com.xiaomi.camera.liveshot.CircularMediaRecorder;
import com.xiaomi.protocol.ICustomCaptureResult;

public class ParallelTaskData {
    private static final String GROUPSHOT_ORIGINAL_SUFFIX = "_ORG";
    private static final String TAG = "ParallelTaskData";
    private int currentModuleIndex = -1;
    private boolean isAbandoned = false;
    private boolean isAdaptiveSnapshotSize;
    private boolean isHWMFNRProcessing = false;
    private boolean isLiveShotTask;
    private boolean isNeedThumbnail;
    private boolean isPictureFilled;
    private int mAlgoType;
    private int mBurstNum;
    private int mCameraId;
    private ICustomCaptureResult mCaptureResult;
    private long mCaptureTime;
    private int[] mCoordinatesOfTheRegionUnderWatermarks;
    private long mCoverFrameTimestamp;
    private byte[] mDataOfTheRegionUnderWatermarks;
    private ParallelTaskDataParameter mDataParameter;
    private long mDateTakenTime;
    private boolean mIsShot2Gallery;
    private byte[] mJpegImageData;
    private int mParallelType;
    private byte[] mPortraitDepthData;
    private byte[] mPortraitRawData;
    private byte[] mRawImageData;
    private String mSavePath;
    private long mTimestamp;
    private String mVideoPath;
    private int previewThumbnailHash;

    public ParallelTaskData(int i, long j, int i2, String str) {
        this.mCameraId = i;
        this.mTimestamp = j;
        this.mParallelType = i2;
        this.mSavePath = str;
        this.mDateTakenTime = System.currentTimeMillis();
    }

    public ParallelTaskData(int i, long j, int i2, String str, long j2) {
        this.mCameraId = i;
        this.mTimestamp = j;
        this.mParallelType = i2;
        this.mSavePath = str;
        this.mDateTakenTime = System.currentTimeMillis();
        this.mCaptureTime = j2;
    }

    public ParallelTaskData(ParallelTaskData parallelTaskData) {
        this.mParallelType = parallelTaskData.mParallelType;
        this.mIsShot2Gallery = parallelTaskData.mIsShot2Gallery;
        this.mTimestamp = parallelTaskData.mTimestamp;
        this.mCaptureResult = parallelTaskData.mCaptureResult;
        this.mJpegImageData = parallelTaskData.mJpegImageData;
        this.mRawImageData = parallelTaskData.mRawImageData;
        this.mPortraitRawData = parallelTaskData.mPortraitRawData;
        this.mPortraitDepthData = parallelTaskData.mPortraitDepthData;
        this.mSavePath = parallelTaskData.mSavePath;
        this.mDataParameter = parallelTaskData.mDataParameter;
        this.isNeedThumbnail = parallelTaskData.isNeedThumbnail;
        this.mVideoPath = parallelTaskData.mVideoPath;
        this.mCoverFrameTimestamp = parallelTaskData.mCoverFrameTimestamp;
        this.isLiveShotTask = parallelTaskData.isLiveShotTask;
        this.isPictureFilled = parallelTaskData.isPictureFilled;
        this.mDataOfTheRegionUnderWatermarks = parallelTaskData.mDataOfTheRegionUnderWatermarks;
        this.mCoordinatesOfTheRegionUnderWatermarks = parallelTaskData.mCoordinatesOfTheRegionUnderWatermarks;
        this.mCameraId = parallelTaskData.mCameraId;
        this.mDateTakenTime = parallelTaskData.mDateTakenTime;
    }

    public void checkThread() {
    }

    public ParallelTaskData cloneTaskData(int i) {
        String str;
        ParallelTaskData parallelTaskData = new ParallelTaskData(this);
        String savePath = getSavePath();
        String str2 = GROUPSHOT_ORIGINAL_SUFFIX;
        if (i > 0) {
            str2 = str2 + "_" + i;
        }
        if (savePath.lastIndexOf(".") > 0) {
            str = savePath.substring(0, r7) + str2 + savePath.substring(r7);
        } else {
            str = savePath + str2;
        }
        Log.d(TAG, "[1] cloneTaskData: path=" + str);
        parallelTaskData.setSavePath(str);
        parallelTaskData.setNeedThumbnail(false);
        ParallelTaskDataParameter.Builder builder = new ParallelTaskDataParameter.Builder(getDataParameter());
        builder.setHasDualWaterMark(false);
        builder.setTimeWaterMarkString((String) null);
        builder.setSaveGroupshotPrimitive(false);
        parallelTaskData.fillParameter(builder.build());
        return parallelTaskData;
    }

    public synchronized void fillJpegData(byte[] bArr, int i) {
        checkThread();
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        if (this.mRawImageData == null) {
                            this.mRawImageData = bArr;
                        } else {
                            throw new RuntimeException("algo fillJpegData: raw already set");
                        }
                    }
                } else if (this.mPortraitDepthData == null) {
                    this.mPortraitDepthData = new byte[bArr.length];
                    System.arraycopy(bArr, 0, this.mPortraitDepthData, 0, bArr.length);
                } else {
                    throw new RuntimeException("algo fillJpegData: depth already set");
                }
            } else if (this.mPortraitRawData == null) {
                this.mPortraitRawData = bArr;
            } else {
                throw new RuntimeException("algo fillJpegData: portrait raw already set");
            }
        } else if (this.mJpegImageData == null) {
            this.isPictureFilled = true;
            this.mJpegImageData = bArr;
        } else {
            throw new RuntimeException("algo fillJpegData: jpeg already set");
        }
        String str = TAG;
        Log.d(str, "fillJpegData: jpegData=" + bArr + "; imageType=" + i);
    }

    public void fillParameter(ParallelTaskDataParameter parallelTaskDataParameter) {
        this.mDataParameter = parallelTaskDataParameter;
    }

    public synchronized void fillVideoPath(String str, long j) {
        boolean z;
        checkThread();
        if (this.mVideoPath == null) {
            this.mVideoPath = str;
            this.mCoverFrameTimestamp = j;
            String str2 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("fillVideoPath: isVideoEmpty = ");
            if (str != null) {
                if (!CircularMediaRecorder.VideoClipSavingCallback.EMPTY_VIDEO_PATH.equals(str)) {
                    z = false;
                    sb.append(z);
                    sb.append(", timestamp = ");
                    sb.append(j);
                    Log.d(str2, sb.toString());
                }
            }
            z = true;
            sb.append(z);
            sb.append(", timestamp = ");
            sb.append(j);
            Log.d(str2, sb.toString());
        } else {
            throw new IllegalStateException("algo fillVideoPath: microvideo already set");
        }
    }

    public int getAlgoType() {
        return this.mAlgoType;
    }

    public int getBurstNum() {
        return this.mBurstNum;
    }

    public int getCameraId() {
        return this.mCameraId;
    }

    public ICustomCaptureResult getCaptureResult() {
        return this.mCaptureResult;
    }

    public long getCaptureTime() {
        return this.mCaptureTime;
    }

    public int[] getCoordinatesOfTheRegionUnderWatermarks() {
        return this.mCoordinatesOfTheRegionUnderWatermarks;
    }

    public synchronized long getCoverFrameTimestamp() {
        return this.mCoverFrameTimestamp;
    }

    public int getCurrentModuleIndex() {
        return this.currentModuleIndex;
    }

    public byte[] getDataOfTheRegionUnderWatermarks() {
        return this.mDataOfTheRegionUnderWatermarks;
    }

    public ParallelTaskDataParameter getDataParameter() {
        return this.mDataParameter;
    }

    public long getDateTakenTime() {
        return this.mDateTakenTime;
    }

    public byte[] getJpegImageData() {
        return this.mJpegImageData;
    }

    public synchronized String getMicroVideoPath() {
        return this.mVideoPath;
    }

    public int getParallelType() {
        return this.mParallelType;
    }

    public byte[] getPortraitDepthData() {
        return this.mPortraitDepthData;
    }

    public byte[] getPortraitRawData() {
        return this.mPortraitRawData;
    }

    public int getPreviewThumbnailHash() {
        return this.previewThumbnailHash;
    }

    public byte[] getRawImageData() {
        return this.mRawImageData;
    }

    public String getSavePath() {
        return this.mSavePath;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public boolean isAbandoned() {
        return this.isAbandoned;
    }

    public boolean isAdaptiveSnapshotSize() {
        return this.isAdaptiveSnapshotSize;
    }

    public boolean isDataFilled(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i == 3 && this.mRawImageData != null : this.mPortraitDepthData != null : this.mPortraitRawData != null : this.mJpegImageData != null;
    }

    public boolean isHWMFNRProcessing() {
        return this.isHWMFNRProcessing;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0026, code lost:
        r3 = TAG;
        r4 = new java.lang.StringBuilder();
        r4.append("isJpegDataReady: object = ");
        r4.append(r7);
        r4.append("; mParallelType = ");
        r4.append(r7.mParallelType);
        r4.append("; mJpegImageData = ");
        r4.append(r7.mJpegImageData);
        r4.append("; mRawImageData = ");
        r4.append(r7.mRawImageData);
        r4.append("; mPortraitRawData = ");
        r4.append(r7.mPortraitRawData);
        r4.append("; mPortraitDepthData = ");
        r4.append(r7.mPortraitDepthData);
        r4.append("; isVideoEmpty = ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006e, code lost:
        if (r7.mVideoPath == null) goto L_0x007c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0078, code lost:
        if (com.xiaomi.camera.liveshot.CircularMediaRecorder.VideoClipSavingCallback.EMPTY_VIDEO_PATH.equals(r7.mVideoPath) == false) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007b, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007c, code lost:
        r4.append(r1);
        r4.append("; result = ");
        r4.append(r0);
        com.android.camera.log.Log.d(r3, r4.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0008, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0010, code lost:
        if (r7.mRawImageData != null) goto L_0x0012;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        r0 = true;
     */
    public synchronized boolean isJpegDataReady() {
        boolean z;
        boolean z2 = true;
        switch (this.mParallelType) {
            case Constants.ShotType.INTENT_PARALLEL_DUAL_SHOT:
            case -3:
            case 2:
            case 6:
            case 7:
                if (!(this.mJpegImageData == null || this.mPortraitRawData == null || this.mPortraitDepthData == null)) {
                    break;
                }
            case Constants.ShotType.INTENT_PARALLEL_SINGLE_PORTRAIT:
            case Constants.ShotType.INTENT_PARALLEL_SINGLE_SHOT:
            case -2:
            case -1:
            case 0:
            case 5:
            case 8:
            case 9:
            case 10:
                if (this.mJpegImageData != null) {
                    break;
                }
                break;
            case 1:
                if (this.mJpegImageData != null) {
                    break;
                }
                break;
        }
        return z;
    }

    public synchronized boolean isLiveShotTask() {
        return this.isLiveShotTask;
    }

    public boolean isNeedThumbnail() {
        return this.isNeedThumbnail;
    }

    public synchronized boolean isPictureFilled() {
        return this.isPictureFilled;
    }

    public boolean isShot2Gallery() {
        return this.mIsShot2Gallery;
    }

    public void refillJpegData(byte[] bArr) {
        this.mJpegImageData = bArr;
        this.isPictureFilled = true;
    }

    public void releaseImageData() {
        this.mVideoPath = null;
        this.mJpegImageData = null;
        this.mRawImageData = null;
        this.mPortraitRawData = null;
        this.mPortraitDepthData = null;
        this.isPictureFilled = false;
        this.mDataOfTheRegionUnderWatermarks = null;
        this.mCoordinatesOfTheRegionUnderWatermarks = null;
    }

    public void setAbandoned(boolean z) {
        this.isAbandoned = z;
    }

    public void setAdaptiveSnapshotSize(boolean z) {
        this.isAdaptiveSnapshotSize = z;
    }

    public void setAlgoType(int i) {
        this.mAlgoType = i;
    }

    public void setBurstNum(int i) {
        this.mBurstNum = i;
    }

    public void setCaptureResult(ICustomCaptureResult iCustomCaptureResult) {
        this.mCaptureResult = iCustomCaptureResult;
    }

    public void setCoordinatesOfTheRegionUnderWatermarks(int[] iArr) {
        this.mCoordinatesOfTheRegionUnderWatermarks = iArr;
    }

    public void setCurrentModuleIndex(int i) {
        this.currentModuleIndex = i;
    }

    public void setDataOfTheRegionUnderWatermarks(byte[] bArr) {
        this.mDataOfTheRegionUnderWatermarks = bArr;
    }

    public void setHWMFNRProcessing(boolean z) {
        this.isHWMFNRProcessing = z;
    }

    public synchronized void setLiveShotTask(boolean z) {
        this.isLiveShotTask = z;
    }

    public void setNeedThumbnail(boolean z) {
        this.isNeedThumbnail = z;
    }

    public synchronized void setPictureFilled(boolean z) {
        this.isPictureFilled = z;
    }

    public void setPreviewThumbnailHash(int i) {
        this.previewThumbnailHash = i;
    }

    public void setSavePath(String str) {
        this.mSavePath = str;
    }

    public boolean setShot2Gallery(boolean z) {
        if (this.mIsShot2Gallery == z) {
            return false;
        }
        this.mIsShot2Gallery = z;
        return true;
    }

    public void setTimestamp(long j) {
        this.mTimestamp = j;
    }
}
