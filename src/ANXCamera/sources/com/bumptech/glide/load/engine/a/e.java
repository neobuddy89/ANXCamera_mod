package com.bumptech.glide.load.engine.a;

import com.bumptech.glide.load.engine.a.f;
import java.io.File;

/* compiled from: DiskLruCacheFactory */
class e implements f.a {
    final /* synthetic */ String Kg;
    final /* synthetic */ String Lg;

    e(String str, String str2) {
        this.Kg = str;
        this.Lg = str2;
    }

    public File L() {
        return new File(this.Kg, this.Lg);
    }
}
