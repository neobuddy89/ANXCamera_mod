package com.arcsoft.camera.wideselfie;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;

public class WideSelfieEngine {
    public static final int HORIZ_FLIP = 12289;
    public static final int MPAF_16BITS = 83886080;
    public static final int MPAF_32BITS = 117440512;
    public static final int MPAF_BGR = 4096;
    public static final int MPAF_OTHERS_NV21 = 1879048194;
    public static final int MPAF_RGB16_R5G6B5 = (MPAF_MAKE_B(5) | ((MPAF_MAKE_R(5) | 352321536) | MPAF_MAKE_G(6)));
    public static final int MPAF_RGB32_A8R8G8B8 = (MPAF_MAKE_B(8) | ((MPAF_MAKE_R(8) | 922746880) | MPAF_MAKE_G(8)));
    public static final int MPAF_RGB32_B8G8R8A8 = (MPAF_RGB32_A8R8G8B8 | 4096);
    public static final int MPAF_RGBA_BASE = 805306368;
    public static final int MPAF_RGB_BASE = 268435456;
    public static final int VERT_FLIP = 12290;

    /* renamed from: a  reason: collision with root package name */
    private static final String f206a = "com.arcsoft.camera.wideselfie.WideSelfieEngine";

    /* renamed from: b  reason: collision with root package name */
    private static WideSelfieEngine f207b;

    /* renamed from: c  reason: collision with root package name */
    private AwsInitParameter f208c = null;

    /* renamed from: d  reason: collision with root package name */
    private WideSelfieCallback f209d = null;

    /* renamed from: e  reason: collision with root package name */
    private boolean f210e = false;

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        int f211a;

        /* renamed from: b  reason: collision with root package name */
        int f212b;

        /* renamed from: c  reason: collision with root package name */
        int f213c;

        /* renamed from: d  reason: collision with root package name */
        int f214d;

        /* renamed from: e  reason: collision with root package name */
        String f215e;

        /* renamed from: f  reason: collision with root package name */
        String f216f;
        String g;

        private a() {
        }
    }

    static {
        System.loadLibrary("camera_wideselfie_mpbase");
        System.loadLibrary("arcsoft_wideselfie");
        System.loadLibrary("jni_wideselfie");
    }

    private native byte[] ConvertCS(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6);

    private native Bitmap ConvertCS2Bitmap(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z);

    private native byte[] ConvertCSEx(ByteBuffer[] byteBufferArr, int i, int i2, int i3, int i4, int i5, int i6);

    private native byte[] ConvertCSExx(long j, int i, int i2, int i3);

    public static final int MPAF_MAKE_B(int i) {
        return (i - 1) << 0;
    }

    public static final int MPAF_MAKE_G(int i) {
        return (i - 1) << 4;
    }

    public static final int MPAF_MAKE_R(int i) {
        return (i - 1) << 8;
    }

    private native void SetLogLevel(int i);

    private a a() {
        return native_version();
    }

    private int b() {
        return native_capture();
    }

    private WideSelfieCallback c() {
        return this.f209d;
    }

    public static synchronized WideSelfieEngine getSingleInstance() {
        WideSelfieEngine wideSelfieEngine;
        synchronized (WideSelfieEngine.class) {
            if (f207b == null) {
                synchronized (WideSelfieEngine.class) {
                    if (f207b == null) {
                        f207b = new WideSelfieEngine();
                    }
                }
            }
            wideSelfieEngine = f207b;
        }
        return wideSelfieEngine;
    }

    private native int native_capture();

    private native int native_init(int i, int i2, float f2, float f3, float f4, float f5, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, float f6, int i13, int i14, boolean z);

    private native int native_init_default(int i, int i2);

    private native int native_process(int i, byte[] bArr);

    private native int native_process(int i, byte[] bArr, boolean z, int i2);

    private native int native_push_sensor_data_in(float[] fArr, long j, int i);

    private native void native_register_callback(WideSelfieCallback wideSelfieCallback);

    private native int native_uninit();

    private native a native_version();

    public synchronized byte[] convertCS(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6) {
        return ConvertCS(bArr, i, i2, i3, i4, i5, i6);
    }

    public synchronized Bitmap convertCS2Bitmap(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        return ConvertCS2Bitmap(bArr, i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    public synchronized byte[] convertCSEx(ByteBuffer[] byteBufferArr, int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
        return ConvertCSEx(byteBufferArr, i, i2, i3, i4, i5, i6);
    }

    public synchronized byte[] convertCSExx(long j, int i, int i2, int i3) {
        return ConvertCSExx(j, i, i2, i3);
    }

    public synchronized int init(AwsInitParameter awsInitParameter) {
        int native_init;
        AwsInitParameter awsInitParameter2 = awsInitParameter;
        synchronized (this) {
            try {
                boolean z = false;
                if (this.f210e) {
                    return 0;
                }
                if (awsInitParameter2 == null) {
                    return 2;
                }
                this.f208c = awsInitParameter2;
                try {
                    native_init = native_init(this.f208c.getBufferSize(), this.f208c.mode, this.f208c.cameraViewAngleForWidth, this.f208c.cameraViewAngleForHeight, this.f208c.resultAngleForWidth, this.f208c.resultAngleForHeight, this.f208c.getSrcFormat(), this.f208c.getFullImageWidth(), this.f208c.getFullImageHeight(), this.f208c.getThumbForamt(), this.f208c.getThumbnailWidth(), this.f208c.getThumbnailHeight(), this.f208c.maxResultWidth, this.f208c.progressBarThumbHeight, this.f208c.guideStopBarThumbHeight, this.f208c.guideStableBarThumbHeight, this.f208c.progressBarThumbHeightCropRatio, this.f208c.changeDirectionThumbThreshold, this.f208c.getDeviceOrientation(), this.f208c.convertNV21);
                    if (native_init == 0) {
                        z = true;
                    }
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
                try {
                    this.f210e = z;
                    return native_init;
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                throw th;
            }
        }
    }

    public synchronized int process(int i, byte[] bArr) {
        return bArr != null ? native_process(i, bArr) : 2;
    }

    public synchronized int process(int i, byte[] bArr, boolean z, int i2) {
        return bArr != null ? native_process(i, bArr, z, i2) : 2;
    }

    public synchronized void setOnCallback(WideSelfieCallback wideSelfieCallback) {
        this.f209d = wideSelfieCallback;
        if (this.f209d != null) {
            native_register_callback(this.f209d);
        }
    }

    public void setSensorData(float[] fArr, long j, int i) {
        if (this.f210e) {
            native_push_sensor_data_in(fArr, j, i);
        }
    }

    public synchronized int uninit() {
        boolean z = false;
        if (!this.f210e) {
            return 0;
        }
        int native_uninit = native_uninit();
        if (native_uninit != 0) {
            z = true;
        }
        this.f210e = z;
        return native_uninit;
    }
}
