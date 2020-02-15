package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;

/* compiled from: BitmapPoolAdapter */
public class e implements d {
    public void V() {
    }

    public void a(float f2) {
    }

    public void a(Bitmap bitmap) {
        bitmap.recycle();
    }

    @NonNull
    public Bitmap c(int i, int i2, Bitmap.Config config) {
        return d(i, i2, config);
    }

    @NonNull
    public Bitmap d(int i, int i2, Bitmap.Config config) {
        return Bitmap.createBitmap(i, i2, config);
    }

    public long getMaxSize() {
        return 0;
    }

    public void trimMemory(int i) {
    }
}
