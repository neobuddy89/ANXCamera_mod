package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import com.bumptech.glide.c;
import com.bumptech.glide.load.engine.A;
import com.bumptech.glide.load.engine.bitmap_recycle.d;
import com.bumptech.glide.load.j;
import java.security.MessageDigest;

/* compiled from: DrawableTransformation */
public class r implements j<Drawable> {
    private final boolean sj;
    private final j<Bitmap> ya;

    public r(j<Bitmap> jVar, boolean z) {
        this.ya = jVar;
        this.sj = z;
    }

    private A<Drawable> a(Context context, A<Bitmap> a2) {
        return u.a(context.getResources(), a2);
    }

    public j<BitmapDrawable> Gi() {
        return this;
    }

    public boolean equals(Object obj) {
        if (obj instanceof r) {
            return this.ya.equals(((r) obj).ya);
        }
        return false;
    }

    public int hashCode() {
        return this.ya.hashCode();
    }

    @NonNull
    public A<Drawable> transform(@NonNull Context context, @NonNull A<Drawable> a2, int i, int i2) {
        d Dh = c.get(context).Dh();
        Drawable drawable = a2.get();
        A<Bitmap> a3 = q.a(Dh, drawable, i, i2);
        if (a3 != null) {
            A<Bitmap> transform = this.ya.transform(context, a3, i, i2);
            if (!transform.equals(a3)) {
                return a(context, transform);
            }
            transform.recycle();
            return a2;
        } else if (!this.sj) {
            return a2;
        } else {
            throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
        }
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        this.ya.updateDiskCacheKey(messageDigest);
    }
}
