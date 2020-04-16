package com.bumptech.glide.load.model;

import com.bumptech.glide.load.model.C0153c;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.model.d  reason: case insensitive filesystem */
/* compiled from: ByteArrayLoader */
class C0154d implements C0153c.b<InputStream> {
    final /* synthetic */ C0153c.d this$0;

    C0154d(C0153c.d dVar) {
        this.this$0 = dVar;
    }

    public Class<InputStream> ba() {
        return InputStream.class;
    }

    public InputStream e(byte[] bArr) {
        return new ByteArrayInputStream(bArr);
    }
}
