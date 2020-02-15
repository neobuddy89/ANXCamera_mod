package com.bumptech.glide.load.b.a;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.engine.A;
import com.bumptech.glide.util.i;

/* compiled from: BytesResource */
public class b implements A<byte[]> {
    private final byte[] bytes;

    public b(byte[] bArr) {
        i.checkNotNull(bArr);
        this.bytes = bArr;
    }

    @NonNull
    public Class<byte[]> O() {
        return byte[].class;
    }

    @NonNull
    public byte[] get() {
        return this.bytes;
    }

    public int getSize() {
        return this.bytes.length;
    }

    public void recycle() {
    }
}
