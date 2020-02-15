package com.bumptech.glide.load.engine.b;

import com.bumptech.glide.load.engine.b.b;

/* compiled from: GlideExecutor */
class e implements b.C0008b {
    e() {
    }

    public void b(Throwable th) {
        if (th != null) {
            throw new RuntimeException("Request threw uncaught throwable", th);
        }
    }
}
