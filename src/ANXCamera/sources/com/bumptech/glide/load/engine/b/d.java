package com.bumptech.glide.load.engine.b;

import android.util.Log;
import com.bumptech.glide.load.engine.b.b;

/* compiled from: GlideExecutor */
class d implements b.C0008b {
    d() {
    }

    public void b(Throwable th) {
        if (th != null && Log.isLoggable("GlideExecutor", 6)) {
            Log.e("GlideExecutor", "Request threw uncaught throwable", th);
        }
    }
}
