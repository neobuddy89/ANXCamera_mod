package com.bumptech.glide.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: LruCache */
public class f<T, Y> {
    private final Map<T, Y> cache = new LinkedHashMap(100, 0.75f, true);
    private long currentSize;
    private long maxSize;
    private final long tg;

    public f(long j) {
        this.tg = j;
        this.maxSize = j;
    }

    private void Xl() {
        h(this.maxSize);
    }

    public void V() {
        h(0);
    }

    public synchronized long Y() {
        return this.currentSize;
    }

    public synchronized void a(float f2) {
        if (f2 >= 0.0f) {
            this.maxSize = (long) Math.round(((float) this.tg) * f2);
            Xl();
        } else {
            throw new IllegalArgumentException("Multiplier must be >= 0");
        }
    }

    /* access modifiers changed from: protected */
    public void b(@NonNull T t, @Nullable Y y) {
    }

    public synchronized boolean contains(@NonNull T t) {
        return this.cache.containsKey(t);
    }

    @Nullable
    public synchronized Y get(@NonNull T t) {
        return this.cache.get(t);
    }

    /* access modifiers changed from: protected */
    public synchronized int getCount() {
        return this.cache.size();
    }

    public synchronized long getMaxSize() {
        return this.maxSize;
    }

    /* access modifiers changed from: protected */
    public synchronized void h(long j) {
        while (this.currentSize > j) {
            Iterator<Map.Entry<T, Y>> it = this.cache.entrySet().iterator();
            Map.Entry next = it.next();
            Object value = next.getValue();
            this.currentSize -= (long) r(value);
            Object key = next.getKey();
            it.remove();
            b(key, value);
        }
    }

    @Nullable
    public synchronized Y put(@NonNull T t, @Nullable Y y) {
        long r = (long) r(y);
        if (r >= this.maxSize) {
            b(t, y);
            return null;
        }
        if (y != null) {
            this.currentSize += r;
        }
        Y put = this.cache.put(t, y);
        if (put != null) {
            this.currentSize -= (long) r(put);
            if (!put.equals(y)) {
                b(t, put);
            }
        }
        Xl();
        return put;
    }

    /* access modifiers changed from: protected */
    public int r(@Nullable Y y) {
        return 1;
    }

    @Nullable
    public synchronized Y remove(@NonNull T t) {
        Y remove;
        remove = this.cache.remove(t);
        if (remove != null) {
            this.currentSize -= (long) r(remove);
        }
        return remove;
    }
}
