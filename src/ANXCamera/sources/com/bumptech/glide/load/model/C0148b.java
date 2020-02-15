package com.bumptech.glide.load.model;

import com.bumptech.glide.load.model.C0149c;
import java.nio.ByteBuffer;

/* renamed from: com.bumptech.glide.load.model.b  reason: case insensitive filesystem */
/* compiled from: ByteArrayLoader */
class C0148b implements C0149c.b<ByteBuffer> {
    final /* synthetic */ C0149c.a this$0;

    C0148b(C0149c.a aVar) {
        this.this$0 = aVar;
    }

    public Class<ByteBuffer> ba() {
        return ByteBuffer.class;
    }

    public ByteBuffer e(byte[] bArr) {
        return ByteBuffer.wrap(bArr);
    }
}
