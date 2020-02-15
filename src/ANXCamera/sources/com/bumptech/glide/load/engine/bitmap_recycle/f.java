package com.bumptech.glide.load.engine.bitmap_recycle;

/* compiled from: ByteArrayAdapter */
public final class f implements a<byte[]> {
    private static final String TAG = "ByteArrayPool";

    public int T() {
        return 1;
    }

    public String getTag() {
        return TAG;
    }

    /* renamed from: h */
    public int a(byte[] bArr) {
        return bArr.length;
    }

    public byte[] newArray(int i) {
        return new byte[i];
    }
}
