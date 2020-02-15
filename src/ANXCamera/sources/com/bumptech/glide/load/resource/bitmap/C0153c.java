package com.bumptech.glide.load.resource.bitmap;

import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.b.b.b;
import com.bumptech.glide.load.engine.bitmap_recycle.d;
import com.bumptech.glide.load.engine.v;
import com.bumptech.glide.util.l;

/* renamed from: com.bumptech.glide.load.resource.bitmap.c  reason: case insensitive filesystem */
/* compiled from: BitmapDrawableResource */
public class C0153c extends b<BitmapDrawable> implements v {
    private final d Eb;

    public C0153c(BitmapDrawable bitmapDrawable, d dVar) {
        super(bitmapDrawable);
        this.Eb = dVar;
    }

    @NonNull
    public Class<BitmapDrawable> O() {
        return BitmapDrawable.class;
    }

    public int getSize() {
        return l.j(((BitmapDrawable) this.drawable).getBitmap());
    }

    public void initialize() {
        ((BitmapDrawable) this.drawable).getBitmap().prepareToDraw();
    }

    public void recycle() {
        this.Eb.a(((BitmapDrawable) this.drawable).getBitmap());
    }
}
