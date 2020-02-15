package com.bumptech.glide.load.engine.a;

import android.content.Context;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.engine.a.f;
import java.io.File;

/* compiled from: ExternalPreferredCacheDiskCacheFactory */
class j implements f.a {
    final /* synthetic */ String Lg;
    final /* synthetic */ Context val$context;

    j(Context context, String str) {
        this.val$context = context;
        this.Lg = str;
    }

    @Nullable
    private File cm() {
        File cacheDir = this.val$context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        String str = this.Lg;
        return str != null ? new File(cacheDir, str) : cacheDir;
    }

    public File L() {
        File cm = cm();
        if (cm != null && cm.exists()) {
            return cm;
        }
        File externalCacheDir = this.val$context.getExternalCacheDir();
        if (externalCacheDir == null || !externalCacheDir.canWrite()) {
            return cm;
        }
        String str = this.Lg;
        return str != null ? new File(externalCacheDir, str) : externalCacheDir;
    }
}
