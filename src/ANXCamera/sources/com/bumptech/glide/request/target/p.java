package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.view.ViewGroup;
import android.widget.ImageView;

/* compiled from: ThumbnailImageViewTarget */
public abstract class p<T> extends h<T> {
    public p(ImageView imageView) {
        super(imageView);
    }

    @Deprecated
    public p(ImageView imageView, boolean z) {
        super(imageView, z);
    }

    /* access modifiers changed from: protected */
    public void o(@Nullable T t) {
        ViewGroup.LayoutParams layoutParams = ((ImageView) this.view).getLayoutParams();
        Drawable p = p(t);
        if (layoutParams != null) {
            int i = layoutParams.width;
            if (i > 0) {
                int i2 = layoutParams.height;
                if (i2 > 0) {
                    p = new g(p, i, i2);
                }
            }
        }
        ((ImageView) this.view).setImageDrawable(p);
    }

    /* access modifiers changed from: protected */
    public abstract Drawable p(T t);
}
