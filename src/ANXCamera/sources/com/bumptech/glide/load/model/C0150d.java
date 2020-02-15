package com.bumptech.glide.load.model;

import com.bumptech.glide.load.model.C0149c;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.model.d  reason: case insensitive filesystem */
/* compiled from: ByteArrayLoader */
class C0150d implements C0149c.b<InputStream> {
    final /* synthetic */ C0149c.d this$0;

    C0150d(C0149c.d dVar) {
        this.this$0 = dVar;
    }

    public Class<InputStream> ba() {
        return InputStream.class;
    }

    public InputStream e(byte[] bArr) {
        return new ByteArrayInputStream(bArr);
    }
}
