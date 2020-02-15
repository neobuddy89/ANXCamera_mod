package com.arcsoft.supernight;

import android.graphics.Rect;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.Face;
import android.media.Image;
import android.os.Environment;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

public class SuperNightProcess implements ProgressCallback {
    public static final int ARC_SN_CAMERA_MODE_UNKNOWN = -1;
    public static final int ARC_SN_CAMERA_MODE_XIAOMI_G80_GW1 = 1793;
    public static final int ARC_SN_CAMERA_MODE_XIAOMI_G90_GW1 = 1793;
    public static final int ARC_SN_CAMERA_MODE_XIAOMI_G90_GW1_INDIA = 1796;
    public static final int ARC_SN_CAMERA_MODE_XIAOMI_SDM855_12MB_IMX586 = 1792;
    public static final int ARC_SN_CAMERA_STATE_HAND = 2;
    public static final int ARC_SN_CAMERA_STATE_UNKNOWN = 0;
    public static final int ARC_SN_MAX_INPUT_IMAGE_NUM = 20;
    public static final int ARC_SN_SCENEMODE_INDOOR = 1;
    public static final int ARC_SN_SCENEMODE_LOWLIGHT = 3;
    public static final int ARC_SN_SCENEMODE_OUTDOOR = 2;
    public static final int ARC_SN_SCENEMODE_PORTRAIT = 4;
    public static final int ARC_SN_SCENEMODE_UNKNOW = 0;
    public static final int ASVL_PAF_NV12 = 2049;
    public static final int ASVL_PAF_NV21 = 2050;
    public static final int ASVL_PAF_RAW10_BGGR_10B = 3332;
    public static final int ASVL_PAF_RAW10_BGGR_16B = 3340;
    public static final int ASVL_PAF_RAW10_GBRG_10B = 3331;
    public static final int ASVL_PAF_RAW10_GBRG_16B = 3339;
    public static final int ASVL_PAF_RAW10_GRAY_10B = 3585;
    public static final int ASVL_PAF_RAW10_GRAY_16B = 3713;
    public static final int ASVL_PAF_RAW10_GRBG_10B = 3330;
    public static final int ASVL_PAF_RAW10_GRBG_16B = 3338;
    public static final int ASVL_PAF_RAW10_RGGB_10B = 3329;
    public static final int ASVL_PAF_RAW10_RGGB_16B = 3337;
    public static final int ASVL_PAF_RAW12_BGGR_12B = 3336;
    public static final int ASVL_PAF_RAW12_BGGR_16B = 3348;
    public static final int ASVL_PAF_RAW12_GBRG_12B = 3335;
    public static final int ASVL_PAF_RAW12_GBRG_16B = 3347;
    public static final int ASVL_PAF_RAW12_GRAY_12B = 3601;
    public static final int ASVL_PAF_RAW12_GRAY_16B = 3729;
    public static final int ASVL_PAF_RAW12_GRBG_12B = 3334;
    public static final int ASVL_PAF_RAW12_GRBG_16B = 3346;
    public static final int ASVL_PAF_RAW12_RGGB_12B = 3333;
    public static final int ASVL_PAF_RAW12_RGGB_16B = 3345;
    public static final int ASVL_PAF_RAW14_BGGR_14B = 3384;
    public static final int ASVL_PAF_RAW14_BGGR_16B = 3396;
    public static final int ASVL_PAF_RAW14_GBRG_14B = 3383;
    public static final int ASVL_PAF_RAW14_GBRG_16B = 3395;
    public static final int ASVL_PAF_RAW14_GRAY_14B = 3617;
    public static final int ASVL_PAF_RAW14_GRAY_16B = 3745;
    public static final int ASVL_PAF_RAW14_GRBG_14B = 3382;
    public static final int ASVL_PAF_RAW14_GRBG_16B = 3394;
    public static final int ASVL_PAF_RAW14_RGGB_14B = 3381;
    public static final int ASVL_PAF_RAW14_RGGB_16B = 3393;
    public static final int ASVL_PAF_RAW16_BGGR_16B = 3364;
    public static final int ASVL_PAF_RAW16_GBRG_16B = 3363;
    public static final int ASVL_PAF_RAW16_GRAY_16B = 3633;
    public static final int ASVL_PAF_RAW16_GRBG_16B = 3362;
    public static final int ASVL_PAF_RAW16_RGGB_16B = 3361;
    private static final String DEBUG_FILE = (Environment.getExternalStorageDirectory().toString() + "/DCIM/arc_super_night/dump_file.txt");
    private static final String DUMP_KEY = "dumpSNImage";
    private static final String HINT_FOR_RAW_REPROCESS_KEY = "com.mediatek.control.capture.hintForRawReprocess";
    private static final String LOG_KEY = "debugSNLog";
    private static final String SUPPERNIGHT_ADRCGAIN_KEY = "com.mediatek.suppernightfeature.fadrcgain";
    private static final String SUPPERNIGHT_BLACKLEVEL_KEY = "com.mediatek.suppernightfeature.blacklevel";
    private static final String SUPPERNIGHT_BRIGHTLEVEL_KEY = "com.mediatek.suppernightfeature.brightlevel";
    private static final String SUPPERNIGHT_EXPINDEX_KEY = "com.mediatek.suppernightfeature.expindex";
    private static final String SUPPERNIGHT_ISPGAIN_KEY = "com.mediatek.suppernightfeature.fispgain";
    private static final String SUPPERNIGHT_LUXINDEX_KEY = "com.mediatek.suppernightfeature.luxindex";
    private static final String SUPPERNIGHT_SENSORGAIN_KEY = "com.mediatek.suppernightfeature.fsensorgain";
    private static final String SUPPERNIGHT_SHUTTER_KEY = "com.mediatek.suppernightfeature.fshutter";
    private static final String SUPPERNIGHT_TOTALGAIN_KEY = "com.mediatek.suppernightfeature.ftotalgain";
    private static final String SUPPERNIGHT_WBGAIN_KEY = "com.mediatek.suppernightfeature.fwbgain";
    private static final String TAG = "SuperNightProcess";
    private CaptureResult.Key<int[]> ADRC_GAIN_RESULT_KEY = null;
    private CaptureResult.Key<int[]> BLACK_LEVEL_RESULT_KEY = null;
    private CaptureResult.Key<int[]> BRIGHT_LEVEL_RESULT_KEY = null;
    private CaptureResult.Key<int[]> EXP_INDEX_RESULT_KEY = null;
    private CaptureResult.Key<int[]> ISP_GAIN_RESULT_KEY = null;
    private CaptureResult.Key<int[]> LUX_INDEX_RESULT_KEY = null;
    private CaptureResult.Key<int[]> SENSOR_GAIN_RESULT_KEY = null;
    private CaptureResult.Key<long[]> SHUTTER_RESULT_KEY = null;
    private CaptureResult.Key<int[]> TOTAL_GAIN_RESULT_KEY = null;
    private CaptureResult.Key<float[]> WB_GAIN_RESULT_KEY = null;
    private Rect mArrayRect = null;
    private CountDownLatch mCountDownLatch;
    private boolean mDumpFile = false;
    private boolean mEnableAdrcGain = true;
    private boolean mEnableBlackLevel = true;
    private boolean mEnableWbGain = true;
    private int mFaceOrientation = 90;
    private volatile boolean mInit = false;
    private volatile boolean mIsCancel = false;
    private TotalCaptureResult mMetdata;
    private SuperNightJni mSuperNightJni = new SuperNightJni();

    public class FaceInfo {
        public int faceNum;
        public int faceOrientation;
        public Rect[] faceRects;

        public FaceInfo() {
        }
    }

    public class InputInfo {
        public int cameraState;
        public int curIndex;
        public int imgNum;
        public int[] inputFd = new int[20];
        public RawImage[] inputImages = new RawImage[20];
        public float[] inputImagesEV = new float[20];

        public InputInfo() {
        }
    }

    public class Param {
        public int curveBrightness;
        public int curveContrast;
        public int curveHighlight;
        public int curveMid;
        public int curveShadow;
        public int edgeSharpIntensity;
        public int noiseLength;
        public int sharpIntensity;

        public Param() {
        }
    }

    public class RawInfo {
        public int[] blackLevel = new int[4];
        public int[] brightLevel = new int[4];
        public int[] evList = new int[20];
        public int expIndex;
        public float fAdrcGain;
        public float fISPGain;
        public float fSensorGain;
        public float fShutter;
        public float fTotalGain;
        public float[] fWbGain = new float[4];
        public int luxIndex;
        public int rawType;

        public RawInfo() {
            for (int i = 0; i < 4; i++) {
                this.fWbGain[i] = 1.0f;
            }
            this.fAdrcGain = 1.0f;
        }
    }

    public SuperNightProcess(Rect rect) {
        readDebugFileValue();
        this.mSuperNightJni.setDumpImageFile(this.mDumpFile);
        this.mArrayRect = rect;
        LOG.d(TAG, "dumpFile = " + this.mDumpFile + " debugLog = " + LOG.DEBUG);
        StringBuilder sb = new StringBuilder();
        sb.append("mArrayRect = ");
        sb.append(this.mArrayRect);
        LOG.d(TAG, sb.toString());
        if (this.mArrayRect != null) {
            LOG.d(TAG, "mArrayRect = " + this.mArrayRect.toString());
        }
        LOG.d("Version", "--11/20--");
    }

    private void conversionCropRect(Rect rect, int i, int i2) {
        if (rect != null) {
            Rect rect2 = this.mArrayRect;
            if (rect2 != null && i > 0 && i2 > 0) {
                float width = ((float) rect2.width()) / ((float) i);
                float height = ((float) this.mArrayRect.height()) / ((float) i2);
                LOG.d(TAG, "fMultipleW = " + width + ", fMultipleH = " + height);
                rect.left = (int) (((float) rect.left) * width);
                rect.top = (int) (((float) rect.top) * height);
                Rect rect3 = this.mArrayRect;
                rect.right = rect3.right - ((int) (((float) (i - rect.right)) * width));
                rect.bottom = rect3.bottom - ((int) (((float) (i2 - rect.bottom)) * height));
                int i3 = rect.left;
                if (i3 % 2 != 0) {
                    rect.left = i3 + 1;
                }
                int i4 = rect.top;
                if (i4 % 2 != 0) {
                    rect.top = i4 + 1;
                }
                int i5 = rect.right;
                if (i5 % 2 != 0) {
                    rect.right = i5 - 1;
                }
                int i6 = rect.bottom;
                if (i6 % 2 != 0) {
                    rect.bottom = i6 - 1;
                }
                LOG.d(TAG, "conversionCropRect -> cropRect = " + rect.toString());
            }
        }
    }

    private FaceInfo getFaceInfo(TotalCaptureResult totalCaptureResult, int i, int i2) {
        if (totalCaptureResult == null || this.mArrayRect == null || i <= 0 || i2 <= 0) {
            return null;
        }
        Face[] faceArr = (Face[]) totalCaptureResult.get(CaptureResult.STATISTICS_FACES);
        if (faceArr != null) {
            LOG.d(TAG, "face length = " + faceArr.length);
        }
        if (faceArr == null || faceArr.length <= 0) {
            return null;
        }
        float width = ((float) this.mArrayRect.width()) / ((float) i);
        float height = ((float) this.mArrayRect.height()) / ((float) i2);
        LOG.d(TAG, "fMultipleW = " + width + ", fMultipleH = " + height);
        FaceInfo faceInfo = new FaceInfo();
        faceInfo.faceRects = new Rect[faceArr.length];
        faceInfo.faceNum = faceArr.length;
        faceInfo.faceOrientation = this.mFaceOrientation;
        for (int i3 = 0; i3 < faceArr.length; i3++) {
            faceInfo.faceRects[i3] = new Rect(faceArr[i3].getBounds());
            Rect[] rectArr = faceInfo.faceRects;
            rectArr[i3].left = (int) (((float) rectArr[i3].left) / width);
            rectArr[i3].top = (int) (((float) rectArr[i3].top) / height);
            rectArr[i3].right = (int) (((float) rectArr[i3].right) / width);
            rectArr[i3].bottom = (int) (((float) rectArr[i3].bottom) / height);
            LOG.d(TAG, "conversionFaceRect -> faceRect = " + faceInfo.faceRects[i3].toString());
        }
        return faceInfo;
    }

    private RawImage getRawImage(Image image, int i) {
        RawImage rawImage = new RawImage();
        int format = image.getFormat();
        rawImage.mWidth = image.getWidth();
        rawImage.mHeight = image.getHeight();
        Image.Plane[] planes = image.getPlanes();
        ByteBuffer buffer = planes[0].getBuffer();
        buffer.rewind();
        rawImage.mPitch1 = 0;
        rawImage.mPlane1 = null;
        if (format == 35) {
            rawImage.mPixelArrayFormat = 2050;
            ByteBuffer buffer2 = planes[2].getBuffer();
            buffer2.rewind();
            rawImage.mPitch1 = planes[2].getRowStride();
            rawImage.mPlane1 = buffer2;
        } else if (format == 32) {
            rawImage.mPixelArrayFormat = i;
        }
        rawImage.mPitch0 = planes[0].getRowStride();
        rawImage.mPitch2 = 0;
        rawImage.mPitch3 = 0;
        rawImage.mPlane0 = buffer;
        rawImage.mPlane2 = null;
        rawImage.mPlane3 = null;
        return rawImage;
    }

    private void getVendorTagValue(TotalCaptureResult totalCaptureResult, RawInfo rawInfo) {
        CaptureResult.Key<int[]> key = this.BRIGHT_LEVEL_RESULT_KEY;
        if (key != null) {
            int[] iArr = (int[]) totalCaptureResult.get(key);
            if (iArr != null && iArr.length > 0) {
                if (this.mEnableBlackLevel) {
                    int i = 0;
                    while (true) {
                        int[] iArr2 = rawInfo.brightLevel;
                        if (i >= iArr2.length) {
                            break;
                        }
                        iArr2[i] = iArr[0] / 1024;
                        LOG.d(TAG, "brightLevel[" + i + "] = " + rawInfo.brightLevel[i]);
                        i++;
                    }
                }
                for (int i2 = 0; i2 < iArr.length; i2++) {
                    LOG.d("vendorTag", "bright[" + i2 + "] = " + iArr[i2]);
                }
            }
        }
        CaptureResult.Key<int[]> key2 = this.BLACK_LEVEL_RESULT_KEY;
        if (key2 != null) {
            int[] iArr3 = (int[]) totalCaptureResult.get(key2);
            if (iArr3 != null && iArr3.length > 0) {
                if (this.mEnableBlackLevel) {
                    int i3 = 0;
                    while (true) {
                        int[] iArr4 = rawInfo.blackLevel;
                        if (i3 >= iArr4.length) {
                            break;
                        }
                        iArr4[i3] = iArr3[0] / 1024;
                        LOG.d(TAG, "blackLevel[" + i3 + "] = " + rawInfo.blackLevel[i3]);
                        i3++;
                    }
                }
                for (int i4 = 0; i4 < iArr3.length; i4++) {
                    LOG.d("vendorTag", "black[" + i4 + "] = " + iArr3[i4]);
                }
            }
        }
        CaptureResult.Key<float[]> key3 = this.WB_GAIN_RESULT_KEY;
        if (key3 != null) {
            float[] fArr = (float[]) totalCaptureResult.get(key3);
            LOG.d("vendorTag", "awbGain = " + fArr);
            if (fArr != null && fArr.length > 0) {
                if (this.mEnableWbGain) {
                    float[] fArr2 = rawInfo.fWbGain;
                    fArr2[0] = fArr[0];
                    fArr2[1] = fArr[1];
                    fArr2[2] = fArr[2];
                    fArr2[3] = fArr[3];
                }
                for (int i5 = 0; i5 < fArr.length; i5++) {
                    LOG.d("vendorTag", "wbGain[" + i5 + "] = " + fArr[i5]);
                }
            }
        }
        CaptureResult.Key<long[]> key4 = this.SHUTTER_RESULT_KEY;
        if (key4 != null) {
            long[] jArr = (long[]) totalCaptureResult.get(key4);
            if (jArr != null && jArr.length > 0) {
                rawInfo.fShutter = (float) jArr[0];
                LOG.d(TAG, "fShutter = " + rawInfo.fShutter);
                for (int i6 = 0; i6 < jArr.length; i6++) {
                    LOG.d("vendorTag", "shutter[" + i6 + "] = " + jArr[i6]);
                }
            }
        }
        CaptureResult.Key<int[]> key5 = this.SENSOR_GAIN_RESULT_KEY;
        if (key5 != null) {
            int[] iArr5 = (int[]) totalCaptureResult.get(key5);
            if (iArr5 != null && iArr5.length > 0) {
                rawInfo.fSensorGain = ((float) iArr5[0]) / 1024.0f;
                LOG.d(TAG, "fSensorGain = " + rawInfo.fSensorGain);
                for (int i7 = 0; i7 < iArr5.length; i7++) {
                    LOG.d("vendorTag", "sensorGain[" + i7 + "] = " + iArr5[i7]);
                }
            }
        }
        CaptureResult.Key<int[]> key6 = this.ISP_GAIN_RESULT_KEY;
        if (key6 != null) {
            int[] iArr6 = (int[]) totalCaptureResult.get(key6);
            if (iArr6 != null && iArr6.length > 0) {
                rawInfo.fISPGain = ((float) iArr6[0]) / 1024.0f;
                LOG.d(TAG, "fISPGain = " + rawInfo.fISPGain);
                for (int i8 = 0; i8 < iArr6.length; i8++) {
                    LOG.d("vendorTag", "ispGain[" + i8 + "] = " + iArr6[i8]);
                }
            }
        }
        CaptureResult.Key<int[]> key7 = this.LUX_INDEX_RESULT_KEY;
        if (key7 != null) {
            int[] iArr7 = (int[]) totalCaptureResult.get(key7);
            if (iArr7 != null && iArr7.length > 0) {
                rawInfo.luxIndex = iArr7[0] / 10000;
                LOG.d(TAG, "luxIndex = " + rawInfo.luxIndex);
                for (int i9 = 0; i9 < iArr7.length; i9++) {
                    LOG.d("vendorTag", "luxIndex[" + i9 + "] = " + iArr7[i9]);
                }
            }
        }
        CaptureResult.Key<int[]> key8 = this.EXP_INDEX_RESULT_KEY;
        if (key8 != null) {
            int[] iArr8 = (int[]) totalCaptureResult.get(key8);
            if (iArr8 != null && iArr8.length > 0) {
                rawInfo.expIndex = iArr8[0];
                LOG.d(TAG, "expIndex = " + rawInfo.expIndex);
                for (int i10 = 0; i10 < iArr8.length; i10++) {
                    LOG.d("vendorTag", "expIndex[" + i10 + "] = " + iArr8[i10]);
                }
            }
        }
        CaptureResult.Key<int[]> key9 = this.ADRC_GAIN_RESULT_KEY;
        if (key9 != null) {
            int[] iArr9 = (int[]) totalCaptureResult.get(key9);
            if (iArr9 != null && iArr9.length > 0) {
                if (this.mEnableAdrcGain) {
                    rawInfo.fAdrcGain = ((float) iArr9[0]) / 1000.0f;
                    LOG.d(TAG, "fAdrcGain = " + rawInfo.fAdrcGain);
                }
                for (int i11 = 0; i11 < iArr9.length; i11++) {
                    LOG.d("vendorTag", "adrcGain[" + i11 + "] = " + iArr9[i11]);
                }
            }
        }
        CaptureResult.Key<int[]> key10 = this.TOTAL_GAIN_RESULT_KEY;
        if (key10 != null) {
            int[] iArr10 = (int[]) totalCaptureResult.get(key10);
            if (iArr10 != null && iArr10.length > 0) {
                rawInfo.fTotalGain = ((float) iArr10[0]) / 100.0f;
                LOG.d(TAG, "fTotalGain = " + rawInfo.fTotalGain);
                for (int i12 = 0; i12 < iArr10.length; i12++) {
                    LOG.d("vendorTag", "totalGain[" + i12 + "] = " + iArr10[i12]);
                }
            }
        }
    }

    private void setupSomeVendorTag(TotalCaptureResult totalCaptureResult) {
        LOG.d(TAG, "setupSomeVendorTag");
        if (this.BRIGHT_LEVEL_RESULT_KEY == null || this.BLACK_LEVEL_RESULT_KEY == null || this.WB_GAIN_RESULT_KEY == null || this.SHUTTER_RESULT_KEY == null || this.SENSOR_GAIN_RESULT_KEY == null || this.ISP_GAIN_RESULT_KEY == null || this.LUX_INDEX_RESULT_KEY == null || this.ADRC_GAIN_RESULT_KEY == null || this.TOTAL_GAIN_RESULT_KEY == null || this.EXP_INDEX_RESULT_KEY == null) {
            for (CaptureResult.Key<int[]> key : totalCaptureResult.getKeys()) {
                if (SUPPERNIGHT_BRIGHTLEVEL_KEY.equals(key.getName())) {
                    LOG.d(TAG, "BRIGHT_LEVEL_RESULT_KEY");
                    this.BRIGHT_LEVEL_RESULT_KEY = key;
                }
                if (SUPPERNIGHT_BLACKLEVEL_KEY.equals(key.getName())) {
                    LOG.d(TAG, "BLACK_LEVEL_RESULT_KEY");
                    this.BLACK_LEVEL_RESULT_KEY = key;
                }
                if (SUPPERNIGHT_WBGAIN_KEY.equals(key.getName())) {
                    LOG.d(TAG, "WB_GAIN_RESULT_KEY");
                    this.WB_GAIN_RESULT_KEY = key;
                }
                if (SUPPERNIGHT_SHUTTER_KEY.equals(key.getName())) {
                    LOG.d(TAG, "SHUTTER_RESULT_KEY");
                    this.SHUTTER_RESULT_KEY = key;
                }
                if (SUPPERNIGHT_SENSORGAIN_KEY.equals(key.getName())) {
                    LOG.d(TAG, "SENSOR_GAIN_RESULT_KEY");
                    this.SENSOR_GAIN_RESULT_KEY = key;
                }
                if (SUPPERNIGHT_ISPGAIN_KEY.equals(key.getName())) {
                    LOG.d(TAG, "ISP_GAIN_RESULT_KEY");
                    this.ISP_GAIN_RESULT_KEY = key;
                }
                if (SUPPERNIGHT_LUXINDEX_KEY.equals(key.getName())) {
                    LOG.d(TAG, "LUX_INDEX_RESULT_KEY");
                    this.LUX_INDEX_RESULT_KEY = key;
                }
                if (SUPPERNIGHT_EXPINDEX_KEY.equals(key.getName())) {
                    LOG.d(TAG, "EXP_INDEX_RESULT_KEY");
                    this.EXP_INDEX_RESULT_KEY = key;
                }
                if (SUPPERNIGHT_ADRCGAIN_KEY.equals(key.getName())) {
                    LOG.d(TAG, "ADRC_GAIN_RESULT_KEY");
                    this.ADRC_GAIN_RESULT_KEY = key;
                }
                if (SUPPERNIGHT_TOTALGAIN_KEY.equals(key.getName())) {
                    LOG.d(TAG, "TOTAL_GAIN_RESULT_KEY");
                    this.TOTAL_GAIN_RESULT_KEY = key;
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:61:0x017c, code lost:
        if (r7.mCountDownLatch != null) goto L_0x017e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x017e, code lost:
        com.arcsoft.supernight.LOG.d(TAG, "mCountDownLatch.countDown() 0");
        r7.mCountDownLatch.countDown();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01a7, code lost:
        if (r7.mCountDownLatch != null) goto L_0x017e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01aa, code lost:
        return r10;
     */
    public int addAllInputInfo(ArrayList<Image> arrayList, ArrayList<TotalCaptureResult> arrayList2, int i, Image image, Rect rect) {
        ArrayList<Image> arrayList3 = arrayList;
        ArrayList<TotalCaptureResult> arrayList4 = arrayList2;
        int i2 = i;
        Image image2 = image;
        LOG.d(TAG, "-- addAllInputInfoEx --");
        int i3 = -1;
        if (arrayList3 == null || arrayList.size() <= 0 || arrayList4 == null || arrayList2.size() <= 0 || arrayList.size() != arrayList2.size() || this.mSuperNightJni == null || image2 == null || rect == null) {
            LOG.d(TAG, "addAllInputInfo - > error invalid param");
            if (this.mCountDownLatch == null) {
                return -1;
            }
            LOG.d(TAG, "mCountDownLatch.countDown() 1");
            this.mCountDownLatch.countDown();
            return -1;
        }
        LOG.d(TAG, " imageList size =  " + arrayList.size());
        int size = arrayList.size();
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < arrayList.size()) {
            try {
                if (this.mIsCancel) {
                    try {
                        LOG.d(TAG, "is cancel 0");
                        if (this.mCountDownLatch != null) {
                            LOG.d(TAG, "mCountDownLatch.countDown() 0");
                            this.mCountDownLatch.countDown();
                        }
                        return i3;
                    } catch (IllegalStateException e2) {
                        e = e2;
                        try {
                            LOG.d("Error", "e-> " + e.toString());
                        } catch (Throwable th) {
                            if (this.mCountDownLatch != null) {
                                LOG.d(TAG, "mCountDownLatch.countDown() 0");
                                this.mCountDownLatch.countDown();
                            }
                            throw th;
                        }
                    }
                } else {
                    Image image3 = arrayList3.get(i5);
                    TotalCaptureResult totalCaptureResult = arrayList4.get(i5);
                    if (image3 != null) {
                        if (totalCaptureResult != null) {
                            LOG.d("vendorTag", " ------ " + i5);
                            setupSomeVendorTag(totalCaptureResult);
                            InputInfo inputInfo = new InputInfo();
                            inputInfo.curIndex = i5;
                            inputInfo.imgNum = size;
                            inputInfo.cameraState = 2;
                            int width = image3.getWidth();
                            int height = image3.getHeight();
                            RawInfo rawInfo = new RawInfo();
                            rawInfo.rawType = i4;
                            getVendorTagValue(totalCaptureResult, rawInfo);
                            Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_EXPOSURE_COMPENSATION);
                            if (num != null) {
                                rawInfo.evList[0] = num.intValue();
                                inputInfo.inputImagesEV[0] = (float) num.intValue();
                            }
                            inputInfo.inputImages[0] = getRawImage(image3, i2);
                            this.mSuperNightJni.addOneInputInfo(rawInfo, inputInfo);
                            i5++;
                            i6 = width;
                            i7 = height;
                            i4 = 0;
                            i3 = -1;
                        }
                    }
                    LOG.d(TAG, "TotalCaptureResult - > error invalid param");
                    if (this.mCountDownLatch == null) {
                        return -1;
                    }
                    LOG.d(TAG, "mCountDownLatch.countDown() 0");
                    this.mCountDownLatch.countDown();
                    return -1;
                }
            } catch (IllegalStateException e3) {
                e = e3;
                i3 = -1;
                LOG.d("Error", "e-> " + e.toString());
            }
        }
        FaceInfo faceInfo = null;
        Iterator<TotalCaptureResult> it = arrayList2.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TotalCaptureResult next = it.next();
            Integer num2 = (Integer) next.get(CaptureResult.CONTROL_AE_EXPOSURE_COMPENSATION);
            if (num2 != null && num2.intValue() == 0) {
                faceInfo = getFaceInfo(next, i6, i7);
                break;
            }
        }
        if (this.mIsCancel) {
            LOG.d(TAG, "is cancel 1");
            if (this.mCountDownLatch == null) {
                return -1;
            }
            LOG.d(TAG, "mCountDownLatch.countDown() 0");
            this.mCountDownLatch.countDown();
            return -1;
        }
        InputInfo inputInfo2 = new InputInfo();
        inputInfo2.curIndex = 0;
        inputInfo2.imgNum = size;
        inputInfo2.cameraState = 2;
        inputInfo2.inputImages[0] = getRawImage(image2, i2);
        i3 = this.mSuperNightJni.process(faceInfo, inputInfo2, 3, rect, this);
        LOG.d(TAG, "cropRect0 = " + rect.toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:58:0x016f, code lost:
        if (r7.mCountDownLatch != null) goto L_0x0171;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0171, code lost:
        com.arcsoft.supernight.LOG.d(TAG, "mCountDownLatch.countDown() 2");
        r7.mCountDownLatch.countDown();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x019c, code lost:
        if (r7.mCountDownLatch != null) goto L_0x0171;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x019f, code lost:
        return r9;
     */
    public int addAllInputInfoEx(ArrayList<Image> arrayList, ArrayList<TotalCaptureResult> arrayList2, int i, Rect rect) {
        int i2;
        ArrayList<Image> arrayList3 = arrayList;
        ArrayList<TotalCaptureResult> arrayList4 = arrayList2;
        int i3 = -1;
        if (arrayList3 == null || arrayList.size() <= 0 || arrayList4 == null || arrayList2.size() <= 0 || arrayList.size() != arrayList2.size() || this.mSuperNightJni == null || rect == null) {
            LOG.d(TAG, "addAllInputInfo - > error invalid param");
            if (this.mCountDownLatch == null) {
                return -1;
            }
            LOG.d(TAG, "mCountDownLatch.countDown() 3");
            this.mCountDownLatch.countDown();
            return -1;
        }
        InputInfo inputInfo = new InputInfo();
        LOG.d(TAG, " imageList size =  " + arrayList.size());
        int size = arrayList.size();
        InputInfo inputInfo2 = inputInfo;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < arrayList.size()) {
            try {
                if (this.mIsCancel) {
                    if (this.mCountDownLatch != null) {
                        LOG.d(TAG, "mCountDownLatch.countDown() 2");
                        this.mCountDownLatch.countDown();
                    }
                    return i3;
                }
                Image image = arrayList3.get(i4);
                TotalCaptureResult totalCaptureResult = arrayList4.get(i4);
                LOG.d(TAG, "Image format - > " + image.getFormat());
                if (image != null) {
                    if (totalCaptureResult != null) {
                        LOG.d("vendorTag", " ------ " + i4);
                        setupSomeVendorTag(totalCaptureResult);
                        InputInfo inputInfo3 = new InputInfo();
                        inputInfo3.curIndex = i4;
                        inputInfo3.imgNum = size;
                        inputInfo3.cameraState = 2;
                        int width = image.getWidth();
                        int height = image.getHeight();
                        RawInfo rawInfo = new RawInfo();
                        rawInfo.rawType = 0;
                        getVendorTagValue(totalCaptureResult, rawInfo);
                        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_EXPOSURE_COMPENSATION);
                        if (num != null) {
                            rawInfo.evList[0] = num.intValue();
                            inputInfo3.inputImagesEV[0] = (float) num.intValue();
                        }
                        inputInfo3.inputImages[0] = getRawImage(image, i);
                        this.mSuperNightJni.addOneInputInfo(rawInfo, inputInfo3);
                        if (i4 == 0) {
                            inputInfo2 = inputInfo3;
                        }
                        i4++;
                        i5 = width;
                        i6 = height;
                        i3 = -1;
                    }
                }
                LOG.d(TAG, "TotalCaptureResult - > error invalid param");
                if (this.mCountDownLatch == null) {
                    return -1;
                }
                LOG.d(TAG, "mCountDownLatch.countDown() 2");
                this.mCountDownLatch.countDown();
                return -1;
            } catch (IllegalStateException e2) {
                e = e2;
                i2 = -1;
                try {
                    LOG.d("Error", "e-> " + e.toString());
                } catch (Throwable th) {
                    if (this.mCountDownLatch != null) {
                        LOG.d(TAG, "mCountDownLatch.countDown() 2");
                        this.mCountDownLatch.countDown();
                    }
                    throw th;
                }
            }
        }
        FaceInfo faceInfo = null;
        Iterator<TotalCaptureResult> it = arrayList2.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TotalCaptureResult next = it.next();
            Integer num2 = (Integer) next.get(CaptureResult.CONTROL_AE_EXPOSURE_COMPENSATION);
            if (num2 != null && num2.intValue() == 0) {
                faceInfo = getFaceInfo(next, i5, i6);
                break;
            }
        }
        FaceInfo faceInfo2 = faceInfo;
        if (!this.mIsCancel) {
            i2 = this.mSuperNightJni.process(faceInfo2, inputInfo2, 3, rect, this);
            try {
                LOG.d(TAG, "cropRect = " + rect.toString());
            } catch (IllegalStateException e3) {
                e = e3;
                LOG.d("Error", "e-> " + e.toString());
            }
        } else if (this.mCountDownLatch == null) {
            return -1;
        } else {
            LOG.d(TAG, "mCountDownLatch.countDown() 2");
            this.mCountDownLatch.countDown();
            return -1;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01ce, code lost:
        if (r1.mCountDownLatch != null) goto L_0x01d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01d0, code lost:
        com.arcsoft.supernight.LOG.d(TAG, "mCountDownLatch.countDown() 0");
        r1.mCountDownLatch.countDown();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01f9, code lost:
        if (r1.mCountDownLatch != null) goto L_0x01d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01fc, code lost:
        return r8;
     */
    public int addAllInputInfo_Fd(ArrayList<Image> arrayList, ArrayList<TotalCaptureResult> arrayList2, ArrayList<Integer> arrayList3, int i, Image image, int i2, Rect rect) {
        ArrayList<Image> arrayList4 = arrayList;
        ArrayList<TotalCaptureResult> arrayList5 = arrayList2;
        ArrayList<Integer> arrayList6 = arrayList3;
        int i3 = i;
        Image image2 = image;
        LOG.d(TAG, "-- addAllInputInfo by fd --");
        int i4 = -1;
        if (arrayList4 == null || arrayList.size() <= 0 || arrayList5 == null || arrayList2.size() <= 0 || arrayList6 == null || arrayList3.size() <= 0 || arrayList.size() != arrayList2.size() || arrayList.size() != arrayList3.size() || this.mSuperNightJni == null || image2 == null || rect == null) {
            LOG.d(TAG, "addAllInputInfo - > error invalid param");
            if (this.mCountDownLatch == null) {
                return -1;
            }
            LOG.d(TAG, "mCountDownLatch.countDown() 1");
            this.mCountDownLatch.countDown();
            return -1;
        }
        LOG.d(TAG, " imageList size =  " + arrayList.size());
        int size = arrayList.size();
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < arrayList.size()) {
            try {
                if (this.mIsCancel) {
                    try {
                        LOG.d(TAG, "is cancel 0");
                        if (this.mCountDownLatch != null) {
                            LOG.d(TAG, "mCountDownLatch.countDown() 0");
                            this.mCountDownLatch.countDown();
                        }
                        return i4;
                    } catch (IllegalStateException e2) {
                        e = e2;
                        try {
                            LOG.d("Error", "e-> " + e.toString());
                        } catch (Throwable th) {
                            if (this.mCountDownLatch != null) {
                                LOG.d(TAG, "mCountDownLatch.countDown() 0");
                                this.mCountDownLatch.countDown();
                            }
                            throw th;
                        }
                    }
                } else {
                    Image image3 = arrayList4.get(i5);
                    TotalCaptureResult totalCaptureResult = arrayList5.get(i5);
                    if (image3 != null) {
                        if (totalCaptureResult != null) {
                            LOG.d("vendorTag", " ------ " + i5);
                            setupSomeVendorTag(totalCaptureResult);
                            InputInfo inputInfo = new InputInfo();
                            inputInfo.curIndex = i5;
                            inputInfo.imgNum = size;
                            inputInfo.cameraState = 2;
                            Integer num = arrayList6.get(i5);
                            if (num != null) {
                                inputInfo.inputFd[0] = num.intValue();
                                LOG.d(TAG, "input fd[" + i5 + "] = " + inputInfo.inputFd[0]);
                            }
                            int width = image3.getWidth();
                            int height = image3.getHeight();
                            RawInfo rawInfo = new RawInfo();
                            rawInfo.rawType = 0;
                            getVendorTagValue(totalCaptureResult, rawInfo);
                            Integer num2 = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_EXPOSURE_COMPENSATION);
                            if (num2 != null) {
                                rawInfo.evList[0] = num2.intValue();
                                inputInfo.inputImagesEV[0] = (float) num2.intValue();
                            }
                            inputInfo.inputImages[0] = getRawImage(image3, i3);
                            this.mSuperNightJni.addOneInputInfo(rawInfo, inputInfo);
                            i5++;
                            arrayList4 = arrayList;
                            i6 = width;
                            i7 = height;
                            i4 = -1;
                        }
                    }
                    LOG.d(TAG, "TotalCaptureResult - > error invalid param");
                    if (this.mCountDownLatch == null) {
                        return -1;
                    }
                    LOG.d(TAG, "mCountDownLatch.countDown() 0");
                    this.mCountDownLatch.countDown();
                    return -1;
                }
            } catch (IllegalStateException e3) {
                e = e3;
                i4 = -1;
                LOG.d("Error", "e-> " + e.toString());
            }
        }
        FaceInfo faceInfo = null;
        Iterator<TotalCaptureResult> it = arrayList2.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TotalCaptureResult next = it.next();
            Integer num3 = (Integer) next.get(CaptureResult.CONTROL_AE_EXPOSURE_COMPENSATION);
            if (num3 != null && num3.intValue() == 0) {
                faceInfo = getFaceInfo(next, i6, i7);
                break;
            }
        }
        if (this.mIsCancel) {
            LOG.d(TAG, "is cancel 1");
            if (this.mCountDownLatch == null) {
                return -1;
            }
            LOG.d(TAG, "mCountDownLatch.countDown() 0");
            this.mCountDownLatch.countDown();
            return -1;
        }
        InputInfo inputInfo2 = new InputInfo();
        inputInfo2.curIndex = 0;
        inputInfo2.imgNum = size;
        inputInfo2.cameraState = 2;
        inputInfo2.inputImages[0] = getRawImage(image2, i3);
        inputInfo2.inputFd[0] = i2;
        i4 = this.mSuperNightJni.process(faceInfo, inputInfo2, 3, rect, this);
        LOG.d(TAG, "cropRect0 = " + rect.toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0064, code lost:
        if (r7.mCountDownLatch != null) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0066, code lost:
        com.arcsoft.supernight.LOG.d(TAG, "mCountDownLatch.countDown() 5");
        r7.mCountDownLatch.countDown();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0077, code lost:
        if (r7.mCountDownLatch == null) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007a, code lost:
        return r1;
     */
    public int addOneInputInfo(Image image, TotalCaptureResult totalCaptureResult, int i, int i2, int i3) {
        int i4 = -1;
        if (image == null || totalCaptureResult == null || this.mSuperNightJni == null || i < 0) {
            LOG.d(TAG, "addOneInputInfo - > error invalid param");
            return -1;
        }
        try {
            setupSomeVendorTag(totalCaptureResult);
            InputInfo inputInfo = new InputInfo();
            inputInfo.curIndex = i;
            inputInfo.imgNum = i3;
            inputInfo.cameraState = 2;
            RawInfo rawInfo = new RawInfo();
            rawInfo.rawType = 0;
            getVendorTagValue(totalCaptureResult, rawInfo);
            Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_EXPOSURE_COMPENSATION);
            if (num != null) {
                rawInfo.evList[0] = num.intValue();
                inputInfo.inputImagesEV[0] = (float) num.intValue();
            }
            inputInfo.inputImages[0] = getRawImage(image, i2);
            i4 = this.mSuperNightJni.addOneInputInfo(rawInfo, inputInfo);
            if (num != null && num.intValue() == 0 && this.mMetdata == null) {
                this.mMetdata = totalCaptureResult;
            }
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            if (this.mCountDownLatch != null) {
                LOG.d(TAG, "mCountDownLatch.countDown() 5");
                this.mCountDownLatch.countDown();
            }
            throw th;
        }
    }

    public void cancelSuperNight() {
        SuperNightJni superNightJni = this.mSuperNightJni;
        if (superNightJni != null) {
            this.mIsCancel = true;
            superNightJni.cancelSuperNight();
            if (!this.mInit) {
                LOG.d(TAG, "mInit is false ,cancelSuperNight return!!!");
                return;
            }
            this.mCountDownLatch = new CountDownLatch(1);
            try {
                this.mCountDownLatch.await();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    public int init(int i, int i2, int i3, int i4) {
        SuperNightJni superNightJni = this.mSuperNightJni;
        if (superNightJni == null) {
            return -1;
        }
        superNightJni.init(i, i2, i3, i4);
        int preProcess = this.mSuperNightJni.preProcess();
        this.mIsCancel = false;
        this.mInit = true;
        LOG.d(TAG, "preprocess = " + preProcess);
        return preProcess;
    }

    public void onProgress(int i, int i2) {
        LOG.d(TAG, "progress = " + i + " status = " + i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0063, code lost:
        if (r10.mCountDownLatch == null) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0066, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0050, code lost:
        if (r10.mCountDownLatch != null) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0052, code lost:
        com.arcsoft.supernight.LOG.d(TAG, "mCountDownLatch.countDown() 4");
        r10.mCountDownLatch.countDown();
     */
    public int process(Image image, int i, Rect rect, int i2) {
        int i3 = -1;
        if (image == null || rect == null) {
            return -1;
        }
        try {
            FaceInfo faceInfo = getFaceInfo(this.mMetdata, image.getWidth(), image.getHeight());
            InputInfo inputInfo = new InputInfo();
            inputInfo.curIndex = 0;
            inputInfo.imgNum = i2;
            inputInfo.cameraState = 2;
            inputInfo.inputImages[0] = getRawImage(image, i);
            i3 = this.mSuperNightJni.process(faceInfo, inputInfo, 3, rect, this);
            LOG.d(TAG, "cropRect = " + rect.toString());
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            if (this.mCountDownLatch != null) {
                LOG.d(TAG, "mCountDownLatch.countDown() 4");
                this.mCountDownLatch.countDown();
            }
            throw th;
        }
    }

    public void readDebugFileValue() {
        String substring;
        String substring2;
        File file = new File(DEBUG_FILE);
        if (file.exists() || file.isFile()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                int i = 0;
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    LOG.d(TAG, "dump file line = " + readLine);
                    if (!TextUtils.isEmpty(readLine)) {
                        if (i >= 2) {
                            break;
                        }
                        boolean z = true;
                        if (readLine.contains(DUMP_KEY)) {
                            String trim = readLine.trim();
                            LOG.d(TAG, "dump file value =" + substring2);
                            if (Integer.parseInt(substring2) != 1) {
                                z = false;
                            }
                            this.mDumpFile = z;
                        } else if (readLine.contains(LOG_KEY)) {
                            String trim2 = readLine.trim();
                            LOG.d(TAG, "debug log value =" + substring);
                            if (Integer.parseInt(substring) != 1) {
                                z = false;
                            }
                            LOG.DEBUG = z;
                            TimeConsumingUtil.DEBUG = LOG.DEBUG;
                        }
                        i++;
                    }
                }
                bufferedReader.close();
                inputStreamReader.close();
                fileInputStream.close();
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            } catch (IOException e3) {
                e3.printStackTrace();
            } catch (NumberFormatException e4) {
                e4.printStackTrace();
            }
        } else {
            LOG.d(TAG, "dump file return false 0");
        }
    }

    public void setEnableAdrcGain(boolean z) {
        this.mEnableAdrcGain = z;
    }

    public void setEnableBlackLevel(boolean z) {
        this.mEnableBlackLevel = z;
    }

    public void setEnableWbGain(boolean z) {
        this.mEnableWbGain = z;
    }

    public void setFaceOrientation(int i) {
        this.mFaceOrientation = i;
    }

    public int unInit() {
        SuperNightJni superNightJni = this.mSuperNightJni;
        if (superNightJni == null) {
            return -1;
        }
        int postProcess = superNightJni.postProcess();
        LOG.d(TAG, "postProcess = " + postProcess);
        int unInit = this.mSuperNightJni.unInit();
        LOG.d(TAG, "unInit = " + unInit);
        this.mMetdata = null;
        CountDownLatch countDownLatch = this.mCountDownLatch;
        if (countDownLatch != null && countDownLatch.getCount() > 0) {
            LOG.d(TAG, "mCountDownLatch.countDown() 6");
            this.mCountDownLatch.countDown();
        }
        this.mInit = false;
        return unInit;
    }
}
