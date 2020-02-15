package com.android.camera;

import android.support.v4.view.MotionEventCompat;
import com.android.camera.panorama.NativeMemoryAllocator;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PanoUtil {
    public static double calculateDifferenceBetweenAngles(double d2, double d3) {
        double d4 = (d3 - d2) % 360.0d;
        if (d4 < 0.0d) {
            d4 += 360.0d;
        }
        double d5 = (d2 - d3) % 360.0d;
        if (d5 < 0.0d) {
            d5 += 360.0d;
        }
        return Math.min(d4, d5);
    }

    public static ByteBuffer createByteBuffer(byte[] bArr) {
        ByteBuffer allocateBuffer = NativeMemoryAllocator.allocateBuffer(bArr.length);
        allocateBuffer.order(ByteOrder.nativeOrder());
        allocateBuffer.position(0);
        allocateBuffer.put(bArr);
        allocateBuffer.position(0);
        return allocateBuffer;
    }

    public static String createName(String str, long j) {
        return new SimpleDateFormat(str).format(new Date(j));
    }

    public static void decodeYUV420SPQuarterRes(int[] iArr, byte[] bArr, int i, int i2) {
        int i3 = i;
        int i4 = i2;
        int i5 = i3 * i4;
        int i6 = 0;
        int i7 = 0;
        while (i6 < i4) {
            int i8 = ((i6 >> 1) * i3) + i5;
            int i9 = 0;
            int i10 = 0;
            int i11 = i7;
            int i12 = 0;
            while (i12 < i3) {
                int i13 = (bArr[(i6 * i3) + i12] & 255) - 16;
                if (i13 < 0) {
                    i13 = 0;
                }
                if ((i12 & 1) == 0) {
                    int i14 = i8 + 1;
                    int i15 = i14 + 1;
                    i9 = (bArr[i14] & 255) - 128;
                    int i16 = i15 + 2;
                    i10 = (bArr[i8] & 255) - 128;
                    i8 = i16;
                }
                int i17 = i13 * 1192;
                int i18 = (i10 * 1634) + i17;
                int i19 = (i17 - (i10 * 833)) - (i9 * 400);
                int i20 = i17 + (i9 * 2066);
                int i21 = 262143;
                if (i18 < 0) {
                    i18 = 0;
                } else if (i18 > 262143) {
                    i18 = 262143;
                }
                if (i19 < 0) {
                    i19 = 0;
                } else if (i19 > 262143) {
                    i19 = 262143;
                }
                if (i20 < 0) {
                    i21 = 0;
                } else if (i20 <= 262143) {
                    i21 = i20;
                }
                iArr[i11] = -16777216 | ((i18 << 6) & 16711680) | ((i19 >> 2) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | ((i21 >> 10) & 255);
                i12 += 4;
                i11++;
            }
            i6 += 4;
            i7 = i11;
        }
    }
}
