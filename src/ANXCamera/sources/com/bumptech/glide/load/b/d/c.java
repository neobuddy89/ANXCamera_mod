package com.bumptech.glide.load.b.d;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.engine.A;
import com.bumptech.glide.load.engine.bitmap_recycle.d;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.resource.bitmap.f;
import com.bumptech.glide.load.resource.gif.b;

/* compiled from: DrawableBytesTranscoder */
public final class c implements e<Drawable, byte[]> {
    private final d Eb;
    private final e<Bitmap, byte[]> jk;
    private final e<b, byte[]> kk;

    public c(@NonNull d dVar, @NonNull e<Bitmap, byte[]> eVar, @NonNull e<b, byte[]> eVar2) {
        this.Eb = dVar;
        this.jk = eVar;
        this.kk = eVar2;
    }

    @NonNull
    private static A<b> l(@NonNull A<Drawable> a2) {
        return a2;
    }

    @Nullable
    public A<byte[]> a(@NonNull A<Drawable> a2, @NonNull g gVar) {
        Drawable drawable = a2.get();
        if (drawable instanceof BitmapDrawable) {
            return this.jk.a(f.a(((BitmapDrawable) drawable).getBitmap(), this.Eb), gVar);
        }
        if (drawable instanceof b) {
            return this.kk.a(a2, gVar);
        }
        return null;
    }
}
