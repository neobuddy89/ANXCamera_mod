package com.bumptech.glide.util.a;

import android.support.annotation.NonNull;

/* compiled from: StateVerifier */
public abstract class g {
    private static final boolean DEBUG = false;

    /* compiled from: StateVerifier */
    private static class a extends g {
        private volatile RuntimeException wm;

        a() {
            super();
        }

        public void Nj() {
            if (this.wm != null) {
                throw new IllegalStateException("Already released", this.wm);
            }
        }

        /* access modifiers changed from: package-private */
        public void z(boolean z) {
            if (z) {
                this.wm = new RuntimeException("Released");
            } else {
                this.wm = null;
            }
        }
    }

    /* compiled from: StateVerifier */
    private static class b extends g {
        private volatile boolean Se;

        b() {
            super();
        }

        public void Nj() {
            if (this.Se) {
                throw new IllegalStateException("Already released");
            }
        }

        public void z(boolean z) {
            this.Se = z;
        }
    }

    private g() {
    }

    @NonNull
    public static g newInstance() {
        return new b();
    }

    public abstract void Nj();

    /* access modifiers changed from: package-private */
    public abstract void z(boolean z);
}
