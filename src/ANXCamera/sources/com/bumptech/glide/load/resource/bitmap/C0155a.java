package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.engine.A;
import com.bumptech.glide.load.engine.bitmap_recycle.d;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.h;
import com.bumptech.glide.util.i;
import java.io.IOException;

/* renamed from: com.bumptech.glide.load.resource.bitmap.a  reason: case insensitive filesystem */
/* compiled from: BitmapDrawableDecoder */
public class C0155a<DataType> implements h<DataType, BitmapDrawable> {
    private final h<DataType, Bitmap> decoder;
    private final Resources resources;

    public C0155a(Context context, h<DataType, Bitmap> hVar) {
        this(context.getResources(), hVar);
    }

    @Deprecated
    public C0155a(Resources resources2, d dVar, h<DataType, Bitmap> hVar) {
        this(resources2, hVar);
    }

    public C0155a(@NonNull Resources resources2, @NonNull h<DataType, Bitmap> hVar) {
        i.checkNotNull(resources2);
        this.resources = resources2;
        i.checkNotNull(hVar);
        this.decoder = hVar;
    }

    public boolean a(@NonNull DataType datatype, @NonNull g gVar) throws IOException {
        return this.decoder.a(datatype, gVar);
    }

    public A<BitmapDrawable> b(@NonNull DataType datatype, int i, int i2, @NonNull g gVar) throws IOException {
        return u.a(this.resources, this.decoder.b(datatype, i, i2, gVar));
    }
}
