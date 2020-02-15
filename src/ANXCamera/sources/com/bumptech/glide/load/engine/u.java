package com.bumptech.glide.load.engine;

import android.os.Looper;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.c;
import com.bumptech.glide.util.i;

/* compiled from: EngineResource */
class u<Z> implements A<Z> {
    private boolean Aa;
    private final boolean Ff;
    private final boolean Rf;
    private int Sf;
    private c key;
    private a listener;
    private final A<Z> resource;

    /* compiled from: EngineResource */
    interface a {
        void a(c cVar, u<?> uVar);
    }

    u(A<Z> a2, boolean z, boolean z2) {
        i.checkNotNull(a2);
        this.resource = a2;
        this.Ff = z;
        this.Rf = z2;
    }

    @NonNull
    public Class<Z> O() {
        return this.resource.O();
    }

    /* access modifiers changed from: package-private */
    public void a(c cVar, a aVar) {
        this.key = cVar;
        this.listener = aVar;
    }

    /* access modifiers changed from: package-private */
    public void acquire() {
        if (this.Aa) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        } else if (Looper.getMainLooper().equals(Looper.myLooper())) {
            this.Sf++;
        } else {
            throw new IllegalThreadStateException("Must call acquire on the main thread");
        }
    }

    @NonNull
    public Z get() {
        return this.resource.get();
    }

    public int getSize() {
        return this.resource.getSize();
    }

    public void recycle() {
        if (this.Sf > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        } else if (!this.Aa) {
            this.Aa = true;
            if (this.Rf) {
                this.resource.recycle();
            }
        } else {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
    }

    /* access modifiers changed from: package-private */
    public void release() {
        if (this.Sf <= 0) {
            throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
        } else if (Looper.getMainLooper().equals(Looper.myLooper())) {
            int i = this.Sf - 1;
            this.Sf = i;
            if (i == 0) {
                this.listener.a(this.key, this);
            }
        } else {
            throw new IllegalThreadStateException("Must call release on the main thread");
        }
    }

    public String toString() {
        return "EngineResource{isCacheable=" + this.Ff + ", listener=" + this.listener + ", key=" + this.key + ", acquired=" + this.Sf + ", isRecycled=" + this.Aa + ", resource=" + this.resource + '}';
    }

    /* access modifiers changed from: package-private */
    public A<Z> vi() {
        return this.resource;
    }

    /* access modifiers changed from: package-private */
    public boolean wi() {
        return this.Ff;
    }
}
