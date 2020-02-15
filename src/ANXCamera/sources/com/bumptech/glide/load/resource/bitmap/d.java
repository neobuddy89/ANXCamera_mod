package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.engine.A;
import com.bumptech.glide.load.j;
import com.bumptech.glide.util.i;
import java.security.MessageDigest;

@Deprecated
/* compiled from: BitmapDrawableTransformation */
public class d implements j<BitmapDrawable> {
    private final j<Drawable> ya;

    public d(j<Bitmap> jVar) {
        r rVar = new r(jVar, false);
        i.checkNotNull(rVar);
        this.ya = rVar;
    }

    private static A<BitmapDrawable> j(A<Drawable> a2) {
        if (a2.get() instanceof BitmapDrawable) {
            return a2;
        }
        throw new IllegalArgumentException("Wrapped transformation unexpectedly returned a non BitmapDrawable resource: " + a2.get());
    }

    private static A<Drawable> k(A<BitmapDrawable> a2) {
        return a2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.ya.equals(((d) obj).ya);
        }
        return false;
    }

    public int hashCode() {
        return this.ya.hashCode();
    }

    @NonNull
    public A<BitmapDrawable> transform(@NonNull Context context, @NonNull A<BitmapDrawable> a2, int i, int i2) {
        A<Drawable> transform = this.ya.transform(context, a2, i, i2);
        j(transform);
        return transform;
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        this.ya.updateDiskCacheKey(messageDigest);
    }
}
