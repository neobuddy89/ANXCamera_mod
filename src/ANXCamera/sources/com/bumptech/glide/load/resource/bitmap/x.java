package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.engine.A;
import com.bumptech.glide.load.engine.bitmap_recycle.b;
import com.bumptech.glide.load.engine.bitmap_recycle.d;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.resource.bitmap.o;
import com.bumptech.glide.util.c;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: StreamBitmapDecoder */
public class x implements h<InputStream, Bitmap> {
    private final o Fi;
    private final b de;

    /* compiled from: StreamBitmapDecoder */
    static class a implements o.a {
        private final c Bj;
        private final RecyclableBufferedInputStream ee;

        a(RecyclableBufferedInputStream recyclableBufferedInputStream, c cVar) {
            this.ee = recyclableBufferedInputStream;
            this.Bj = cVar;
        }

        public void I() {
            this.ee.ql();
        }

        public void a(d dVar, Bitmap bitmap) throws IOException {
            IOException exception = this.Bj.getException();
            if (exception != null) {
                if (bitmap != null) {
                    dVar.a(bitmap);
                }
                throw exception;
            }
        }
    }

    public x(o oVar, b bVar) {
        this.Fi = oVar;
        this.de = bVar;
    }

    /* renamed from: a */
    public A<Bitmap> b(@NonNull InputStream inputStream, int i, int i2, @NonNull g gVar) throws IOException {
        RecyclableBufferedInputStream recyclableBufferedInputStream;
        boolean z;
        if (inputStream instanceof RecyclableBufferedInputStream) {
            recyclableBufferedInputStream = (RecyclableBufferedInputStream) inputStream;
            z = false;
        } else {
            RecyclableBufferedInputStream recyclableBufferedInputStream2 = new RecyclableBufferedInputStream(inputStream, this.de);
            z = true;
            recyclableBufferedInputStream = recyclableBufferedInputStream2;
        }
        c j = c.j(recyclableBufferedInputStream);
        try {
            return this.Fi.a((InputStream) new com.bumptech.glide.util.g(j), i, i2, gVar, (o.a) new a(recyclableBufferedInputStream, j));
        } finally {
            j.release();
            if (z) {
                recyclableBufferedInputStream.release();
            }
        }
    }

    public boolean a(@NonNull InputStream inputStream, @NonNull g gVar) {
        return this.Fi.h(inputStream);
    }
}
