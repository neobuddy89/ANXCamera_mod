package com.bumptech.glide.load.engine.a;

import android.content.Context;
import com.bumptech.glide.load.engine.a.f;
import java.io.File;

/* compiled from: InternalCacheDiskCacheFactory */
class l implements f.a {
    final /* synthetic */ String Lg;
    final /* synthetic */ Context val$context;

    l(Context context, String str) {
        this.val$context = context;
        this.Lg = str;
    }

    public File L() {
        File cacheDir = this.val$context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        String str = this.Lg;
        return str != null ? new File(cacheDir, str) : cacheDir;
    }
}
