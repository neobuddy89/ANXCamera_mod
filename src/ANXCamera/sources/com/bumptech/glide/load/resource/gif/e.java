package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.bumptech.glide.c;
import com.bumptech.glide.load.engine.A;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.resource.bitmap.f;
import com.bumptech.glide.util.i;
import java.security.MessageDigest;

/* compiled from: GifDrawableTransformation */
public class e implements j<b> {
    private final j<Bitmap> ya;

    public e(j<Bitmap> jVar) {
        i.checkNotNull(jVar);
        this.ya = jVar;
    }

    public boolean equals(Object obj) {
        if (obj instanceof e) {
            return this.ya.equals(((e) obj).ya);
        }
        return false;
    }

    public int hashCode() {
        return this.ya.hashCode();
    }

    @NonNull
    public A<b> transform(@NonNull Context context, @NonNull A<b> a2, int i, int i2) {
        b bVar = a2.get();
        f fVar = new f(bVar.oa(), c.get(context).Dh());
        A<Bitmap> transform = this.ya.transform(context, fVar, i, i2);
        if (!fVar.equals(transform)) {
            fVar.recycle();
        }
        bVar.a(this.ya, transform.get());
        return a2;
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        this.ya.updateDiskCacheKey(messageDigest);
    }
}
