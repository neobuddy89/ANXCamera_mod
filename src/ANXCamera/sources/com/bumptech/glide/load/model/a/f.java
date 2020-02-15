package com.bumptech.glide.load.model.a;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.model.l;
import com.bumptech.glide.load.model.t;
import com.bumptech.glide.load.model.u;
import com.bumptech.glide.load.model.x;
import java.io.InputStream;
import java.net.URL;

/* compiled from: UrlLoader */
public class f implements t<URL, InputStream> {
    private final t<l, InputStream> zi;

    /* compiled from: UrlLoader */
    public static class a implements u<URL, InputStream> {
        public void S() {
        }

        @NonNull
        public t<URL, InputStream> a(x xVar) {
            return new f(xVar.a(l.class, InputStream.class));
        }
    }

    public f(t<l, InputStream> tVar) {
        this.zi = tVar;
    }

    public t.a<InputStream> a(@NonNull URL url, int i, int i2, @NonNull g gVar) {
        return this.zi.a(new l(url), i, i2, gVar);
    }

    /* renamed from: d */
    public boolean c(@NonNull URL url) {
        return true;
    }
}
