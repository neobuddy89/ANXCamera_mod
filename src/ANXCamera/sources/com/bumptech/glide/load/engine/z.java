package com.bumptech.glide.load.engine;

import android.support.annotation.NonNull;
import android.support.v4.util.Pools;
import com.bumptech.glide.util.a.d;
import com.bumptech.glide.util.a.g;
import com.bumptech.glide.util.i;

/* compiled from: LockedResource */
final class z<Z> implements A<Z>, d.c {
    private static final Pools.Pool<z<?>> Yf = d.b(20, new y());
    private boolean Aa;
    private final g Xe = g.newInstance();
    private A<Z> Xf;
    private boolean isLocked;

    z() {
    }

    @NonNull
    static <Z> z<Z> f(A<Z> a2) {
        z<Z> acquire = Yf.acquire();
        i.checkNotNull(acquire);
        z<Z> zVar = acquire;
        zVar.i(a2);
        return zVar;
    }

    private void i(A<Z> a2) {
        this.Aa = false;
        this.isLocked = true;
        this.Xf = a2;
    }

    private void release() {
        this.Xf = null;
        Yf.release(this);
    }

    @NonNull
    public Class<Z> O() {
        return this.Xf.O();
    }

    @NonNull
    public Z get() {
        return this.Xf.get();
    }

    public int getSize() {
        return this.Xf.getSize();
    }

    @NonNull
    public g getVerifier() {
        return this.Xe;
    }

    public synchronized void recycle() {
        this.Xe.Nj();
        this.Aa = true;
        if (!this.isLocked) {
            this.Xf.recycle();
            release();
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void unlock() {
        this.Xe.Nj();
        if (this.isLocked) {
            this.isLocked = false;
            if (this.Aa) {
                recycle();
            }
        } else {
            throw new IllegalStateException("Already unlocked");
        }
    }
}
