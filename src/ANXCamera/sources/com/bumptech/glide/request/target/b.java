package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import com.bumptech.glide.request.c;

/* compiled from: BaseTarget */
public abstract class b<Z> implements o<Z> {
    private c request;

    public void b(@Nullable Drawable drawable) {
    }

    public void c(@Nullable Drawable drawable) {
    }

    public void d(@Nullable Drawable drawable) {
    }

    public void f(@Nullable c cVar) {
        this.request = cVar;
    }

    @Nullable
    public c getRequest() {
        return this.request;
    }

    public void onDestroy() {
    }

    public void onStart() {
    }

    public void onStop() {
    }
}
