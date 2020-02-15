package com.bumptech.glide.load.model.a;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.android.volley.DefaultRetryPolicy;
import com.bumptech.glide.load.a.k;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.load.model.l;
import com.bumptech.glide.load.model.t;
import com.bumptech.glide.load.model.u;
import com.bumptech.glide.load.model.x;
import java.io.InputStream;

/* compiled from: HttpGlideUrlLoader */
public class b implements t<l, InputStream> {
    public static final f<Integer> TIMEOUT = f.a("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", Integer.valueOf(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS));
    @Nullable
    private final ModelCache<l, l> yi;

    /* compiled from: HttpGlideUrlLoader */
    public static class a implements u<l, InputStream> {
        private final ModelCache<l, l> yi = new ModelCache<>(500);

        public void S() {
        }

        @NonNull
        public t<l, InputStream> a(x xVar) {
            return new b(this.yi);
        }
    }

    public b() {
        this((ModelCache<l, l>) null);
    }

    public b(@Nullable ModelCache<l, l> modelCache) {
        this.yi = modelCache;
    }

    public t.a<InputStream> a(@NonNull l lVar, int i, int i2, @NonNull g gVar) {
        ModelCache<l, l> modelCache = this.yi;
        if (modelCache != null) {
            l b2 = modelCache.b(lVar, 0, 0);
            if (b2 == null) {
                this.yi.a(lVar, 0, 0, lVar);
            } else {
                lVar = b2;
            }
        }
        return new t.a<>(lVar, new k(lVar, ((Integer) gVar.a(TIMEOUT)).intValue()));
    }

    /* renamed from: a */
    public boolean c(@NonNull l lVar) {
        return true;
    }
}
