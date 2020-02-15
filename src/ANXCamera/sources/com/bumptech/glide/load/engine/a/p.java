package com.bumptech.glide.load.engine.a;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.engine.A;
import com.bumptech.glide.load.engine.a.o;

/* compiled from: MemoryCacheAdapter */
public class p implements o {
    private o.a listener;

    public void V() {
    }

    public long Y() {
        return 0;
    }

    @Nullable
    public A<?> a(@NonNull c cVar) {
        return null;
    }

    @Nullable
    public A<?> a(@NonNull c cVar, @Nullable A<?> a2) {
        if (a2 == null) {
            return null;
        }
        this.listener.b(a2);
        return null;
    }

    public void a(float f2) {
    }

    public void a(@NonNull o.a aVar) {
        this.listener = aVar;
    }

    public long getMaxSize() {
        return 0;
    }

    public void trimMemory(int i) {
    }
}
