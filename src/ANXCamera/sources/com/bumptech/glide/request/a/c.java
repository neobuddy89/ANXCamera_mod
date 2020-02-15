package com.bumptech.glide.request.a;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;

/* compiled from: DrawableCrossFadeFactory */
public class c implements g<Drawable> {
    private final boolean Zl;
    private d bm;
    private final int duration;

    /* compiled from: DrawableCrossFadeFactory */
    public static class a {
        private static final int _l = 300;
        private boolean Zl;
        private final int durationMillis;

        public a() {
            this(300);
        }

        public a(int i) {
            this.durationMillis = i;
        }

        public c build() {
            return new c(this.durationMillis, this.Zl);
        }

        public a setCrossFadeEnabled(boolean z) {
            this.Zl = z;
            return this;
        }
    }

    protected c(int i, boolean z) {
        this.duration = i;
        this.Zl = z;
    }

    private f<Drawable> Lm() {
        if (this.bm == null) {
            this.bm = new d(this.duration, this.Zl);
        }
        return this.bm;
    }

    public f<Drawable> a(DataSource dataSource, boolean z) {
        return dataSource == DataSource.MEMORY_CACHE ? e.get() : Lm();
    }
}
