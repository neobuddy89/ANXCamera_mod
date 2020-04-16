package com.bumptech.glide.load.model;

import com.bumptech.glide.load.model.C0153c;
import java.nio.ByteBuffer;

/* renamed from: com.bumptech.glide.load.model.b  reason: case insensitive filesystem */
/* compiled from: ByteArrayLoader */
class C0152b implements C0153c.b<ByteBuffer> {
    final /* synthetic */ C0153c.a this$0;

    C0152b(C0153c.a aVar) {
        this.this$0 = aVar;
    }

    public Class<ByteBuffer> ba() {
        return ByteBuffer.class;
    }

    public ByteBuffer e(byte[] bArr) {
        return ByteBuffer.wrap(bArr);
    }
}
