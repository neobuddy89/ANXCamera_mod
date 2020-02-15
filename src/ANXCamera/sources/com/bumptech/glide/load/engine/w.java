package com.bumptech.glide.load.engine;

import android.support.annotation.VisibleForTesting;
import com.bumptech.glide.load.c;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Jobs */
final class w {
    private final Map<c, EngineJob<?>> Vf = new HashMap();
    private final Map<c, EngineJob<?>> vf = new HashMap();

    w() {
    }

    private Map<c, EngineJob<?>> C(boolean z) {
        return z ? this.Vf : this.vf;
    }

    /* access modifiers changed from: package-private */
    public EngineJob<?> a(c cVar, boolean z) {
        return C(z).get(cVar);
    }

    /* access modifiers changed from: package-private */
    public void a(c cVar, EngineJob<?> engineJob) {
        C(engineJob.ui()).put(cVar, engineJob);
    }

    /* access modifiers changed from: package-private */
    public void b(c cVar, EngineJob<?> engineJob) {
        Map<c, EngineJob<?>> C = C(engineJob.ui());
        if (engineJob.equals(C.get(cVar))) {
            C.remove(cVar);
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public Map<c, EngineJob<?>> getAll() {
        return Collections.unmodifiableMap(this.vf);
    }
}
