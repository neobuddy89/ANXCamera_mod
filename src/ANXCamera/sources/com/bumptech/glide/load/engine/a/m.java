package com.bumptech.glide.load.engine.a;

import android.content.Context;
import com.bumptech.glide.load.engine.a.a;
import com.bumptech.glide.load.engine.a.f;

/* compiled from: InternalCacheDiskCacheFactory */
public final class m extends f {
    public m(Context context) {
        this(context, a.C0007a.Mb, 262144000);
    }

    public m(Context context, long j) {
        this(context, a.C0007a.Mb, j);
    }

    public m(Context context, String str, long j) {
        super((f.a) new l(context, str), j);
    }
}
