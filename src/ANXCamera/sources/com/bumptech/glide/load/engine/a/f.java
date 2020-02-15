package com.bumptech.glide.load.engine.a;

import com.bumptech.glide.load.engine.a.a;
import java.io.File;

/* compiled from: DiskLruCacheFactory */
public class f implements a.C0007a {
    private final long Mg;
    private final a Ng;

    /* compiled from: DiskLruCacheFactory */
    public interface a {
        File L();
    }

    public f(a aVar, long j) {
        this.Mg = j;
        this.Ng = aVar;
    }

    public f(String str, long j) {
        this((a) new d(str), j);
    }

    public f(String str, String str2, long j) {
        this((a) new e(str, str2), j);
    }

    public a build() {
        File L = this.Ng.L();
        if (L == null) {
            return null;
        }
        if (L.mkdirs() || (L.exists() && L.isDirectory())) {
            return g.create(L, this.Mg);
        }
        return null;
    }
}
