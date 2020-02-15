package com.bumptech.glide.load.engine.a;

import android.content.Context;
import com.bumptech.glide.load.engine.a.a;
import com.bumptech.glide.load.engine.a.f;

@Deprecated
/* compiled from: ExternalCacheDiskCacheFactory */
public final class i extends f {
    public i(Context context) {
        this(context, a.C0007a.Mb, a.C0007a.br);
    }

    public i(Context context, int i) {
        this(context, a.C0007a.Mb, i);
    }

    public i(Context context, String str, int i) {
        super((f.a) new h(context, str), (long) i);
    }
}
