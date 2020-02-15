package com.bumptech.glide.d;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import com.bumptech.glide.util.h;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ModelToResourceClassCache */
public class d {
    private final AtomicReference<h> Hk = new AtomicReference<>();
    private final ArrayMap<h, List<Class<?>>> Ik = new ArrayMap<>();

    public void a(@NonNull Class<?> cls, @NonNull Class<?> cls2, @NonNull List<Class<?>> list) {
        synchronized (this.Ik) {
            this.Ik.put(new h(cls, cls2), list);
        }
    }

    public void clear() {
        synchronized (this.Ik) {
            this.Ik.clear();
        }
    }

    @Nullable
    public List<Class<?>> d(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
        List<Class<?>> list;
        h andSet = this.Hk.getAndSet((Object) null);
        if (andSet == null) {
            andSet = new h(cls, cls2);
        } else {
            andSet.h(cls, cls2);
        }
        synchronized (this.Ik) {
            list = this.Ik.get(andSet);
        }
        this.Hk.set(andSet);
        return list;
    }
}
