package com.bumptech.glide.load.a;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.a.e;
import com.bumptech.glide.load.engine.bitmap_recycle.b;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: InputStreamRewinder */
public final class l implements e<InputStream> {
    private static final int fe = 5242880;
    private final RecyclableBufferedInputStream ee;

    /* compiled from: InputStreamRewinder */
    public static final class a implements e.a<InputStream> {
        private final b de;

        public a(b bVar) {
            this.de = bVar;
        }

        @NonNull
        public Class<InputStream> ba() {
            return InputStream.class;
        }

        @NonNull
        /* renamed from: g */
        public e<InputStream> build(InputStream inputStream) {
            return new l(inputStream, this.de);
        }
    }

    l(InputStream inputStream, b bVar) {
        this.ee = new RecyclableBufferedInputStream(inputStream, bVar);
        this.ee.mark(fe);
    }

    @NonNull
    public InputStream R() throws IOException {
        this.ee.reset();
        return this.ee;
    }

    public void cleanup() {
        this.ee.release();
    }
}
