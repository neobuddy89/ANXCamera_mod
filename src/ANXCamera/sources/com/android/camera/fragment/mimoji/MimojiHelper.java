package com.android.camera.fragment.mimoji;

import android.graphics.Bitmap;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.media.Image;
import android.os.Environment;
import android.provider.MiuiSettings;
import com.android.camera.R;
import com.android.camera.log.Log;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class MimojiHelper {
    public static final int COLOR_FormatI420 = 1;
    public static final int COLOR_FormatNV21 = 2;
    public static final String CUSTOM_DIR = (ROOT_DIR + "custom/");
    public static final String DATA_DIR = (MIMOJI_DIR + "data/");
    public static final String MIMOJI_DIR = (ROOT_DIR + "mimoji/");
    public static final String MIMOJI_PREFIX = "vendor/camera/mimoji/";
    public static final String MODEL_PATH = (MIMOJI_DIR + "model/");
    private static final int ORIENTATION_HYSTERESIS = 5;
    public static final String ROOT_DIR = (Environment.getExternalStorageDirectory().getPath() + "/MIUI/Camera/");
    private static int mCurrentOrientation = -1;

    public static byte[] getDataFromImage(Image image, int i) {
        Rect rect;
        int i2;
        int i3 = i;
        int i4 = 2;
        int i5 = 1;
        if (i3 == 1 || i3 == 2) {
            Rect cropRect = image.getCropRect();
            int format = image.getFormat();
            int width = cropRect.width();
            int height = cropRect.height();
            Image.Plane[] planes = image.getPlanes();
            int i6 = width * height;
            byte[] bArr = new byte[((ImageFormat.getBitsPerPixel(format) * i6) / 8)];
            int i7 = 0;
            byte[] bArr2 = new byte[planes[0].getRowStride()];
            int i8 = 1;
            int i9 = 0;
            int i10 = 0;
            while (i9 < planes.length) {
                if (i9 != 0) {
                    if (i9 != i5) {
                        if (i9 == i4) {
                            if (i3 == i5) {
                                i10 = (int) (((double) i6) * 1.25d);
                                i8 = i5;
                            } else if (i3 == i4) {
                                i8 = i4;
                            }
                        }
                    } else if (i3 == i5) {
                        i8 = i5;
                    } else if (i3 == i4) {
                        i10 = i6 + 1;
                        i8 = i4;
                    }
                    i10 = i6;
                } else {
                    i8 = i5;
                    i10 = i7;
                }
                ByteBuffer buffer = planes[i9].getBuffer();
                int rowStride = planes[i9].getRowStride();
                int pixelStride = planes[i9].getPixelStride();
                int i11 = i9 == 0 ? i7 : i5;
                int i12 = width >> i11;
                int i13 = height >> i11;
                int i14 = width;
                buffer.position(((cropRect.top >> i11) * rowStride) + ((cropRect.left >> i11) * pixelStride));
                int i15 = 0;
                while (i15 < i13) {
                    if (pixelStride == 1 && i8 == 1) {
                        buffer.get(bArr, i10, i12);
                        i10 += i12;
                        rect = cropRect;
                        i2 = i12;
                    } else {
                        rect = cropRect;
                        i2 = ((i12 - 1) * pixelStride) + 1;
                        buffer.get(bArr2, 0, i2);
                        int i16 = i10;
                        for (int i17 = 0; i17 < i12; i17++) {
                            bArr[i16] = bArr2[i17 * pixelStride];
                            i16 += i8;
                        }
                        i10 = i16;
                    }
                    if (i15 < i13 - 1) {
                        buffer.position((buffer.position() + rowStride) - i2);
                    }
                    i15++;
                    cropRect = rect;
                }
                Rect rect2 = cropRect;
                i9++;
                i3 = i;
                width = i14;
                i4 = 2;
                i5 = 1;
                i7 = 0;
            }
            return bArr;
        }
        throw new IllegalArgumentException("only support COLOR_FormatI420 and COLOR_FormatNV21");
    }

    public static List<MimojiInfo> getMimojiInfoList() {
        String absolutePath;
        File file = new File(MODEL_PATH);
        if (!file.exists()) {
            return null;
        }
        File[] listFiles = file.listFiles();
        ArrayList arrayList = new ArrayList();
        int length = listFiles.length;
        int i = 0;
        while (i < length) {
            File file2 = new File(absolutePath + "/save");
            if (file2.exists()) {
                for (File file3 : file2.listFiles()) {
                    if (file3.getPath().substring(file3.getPath().length() - 4).equals(".dat")) {
                        MimojiInfo mimojiInfo = new MimojiInfo();
                        mimojiInfo.mAvatarTemplatePath = absolutePath;
                        mimojiInfo.mConfigPath = file3.getAbsolutePath();
                    }
                }
            }
            i++;
        }
        return arrayList;
    }

    public static int getOutlineOrientation(int i, int i2, boolean z) {
        mCurrentOrientation = roundOrientation(i2, mCurrentOrientation);
        int i3 = z ? ((i - mCurrentOrientation) + MiuiSettings.ScreenEffect.SCREEN_PAPER_MODE_TWILIGHT_START_DEAULT) % MiuiSettings.ScreenEffect.SCREEN_PAPER_MODE_TWILIGHT_START_DEAULT : (mCurrentOrientation + i) % MiuiSettings.ScreenEffect.SCREEN_PAPER_MODE_TWILIGHT_START_DEAULT;
        Log.d("OrientationUtil", "cameraRotation = " + i + " sensorOrientation = " + mCurrentOrientation + "outlineOrientation = " + i3);
        return i3;
    }

    public static Bitmap getThumbnailBitmapFromData(byte[] bArr, int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        createBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(bArr));
        return createBitmap;
    }

    public static int getTipsResId(int i) {
        switch (i) {
            case 1:
                return R.string.mimoji_check_no_face;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return R.string.mimoji_check_face_occlusion;
            case 9:
                return R.string.mimoji_check_beyond_20_degrees;
            case 10:
                return R.string.mimoji_check_multi_face;
            default:
                return -1;
        }
    }

    public static int getTipsResIdFace(int i) {
        if (i == 3) {
            return R.string.mimoji_check_face_too_close;
        }
        if (i == 4) {
            return R.string.mimoji_check_face_too_far;
        }
        if (i != 7) {
            return -1;
        }
        return R.string.mimoji_check_low_light;
    }

    private static int roundOrientation(int i, int i2) {
        boolean z = true;
        if (i2 != -1) {
            int abs = Math.abs(i - i2);
            if (Math.min(abs, 360 - abs) < 50) {
                z = false;
            }
        }
        return z ? (((i + 45) / 90) * 90) % MiuiSettings.ScreenEffect.SCREEN_PAPER_MODE_TWILIGHT_START_DEAULT : i2;
    }
}
