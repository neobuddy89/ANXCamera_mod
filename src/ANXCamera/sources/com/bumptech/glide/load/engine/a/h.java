package com.bumptech.glide.load.engine.a;

import android.content.Context;
import com.bumptech.glide.load.engine.a.f;
import java.io.File;

/* compiled from: ExternalCacheDiskCacheFactory */
class h implements f.a {
    final /* synthetic */ String Lg;
    final /* synthetic */ Context val$context;

    h(Context context, String str) {
        this.val$context = context;
        this.Lg = str;
    }

    public File L() {
        File externalCacheDir = this.val$context.getExternalCacheDir();
        if (externalCacheDir == null) {
            return null;
        }
        String str = this.Lg;
        return str != null ? new File(externalCacheDir, str) : externalCacheDir;
    }
}
