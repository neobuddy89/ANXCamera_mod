package com.bumptech.glide.load.engine;

import android.support.annotation.NonNull;
import android.util.Log;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.engine.f;
import com.bumptech.glide.load.model.t;
import com.bumptech.glide.util.e;
import java.util.Collections;
import java.util.List;

/* compiled from: SourceGenerator */
class E implements f, d.a<Object>, f.a {
    private static final String TAG = "SourceGenerator";
    private final g<?> Ae;
    private volatile t.a<?> Fe;
    private final f.a cb;
    private int gg;
    private C0144c hg;
    private Object ig;
    private C0145d jg;

    E(g<?> gVar, f.a aVar) {
        this.Ae = gVar;
        this.cb = aVar;
    }

    private boolean Nl() {
        return this.gg < this.Ae.gi().size();
    }

    /* JADX INFO: finally extract failed */
    private void u(Object obj) {
        long Hj = e.Hj();
        try {
            a<X> l = this.Ae.l(obj);
            C0146e eVar = new C0146e(l, obj, this.Ae.getOptions());
            this.jg = new C0145d(this.Fe.Ce, this.Ae.getSignature());
            this.Ae.C().a(this.jg, eVar);
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "Finished encoding source to cache, key: " + this.jg + ", data: " + obj + ", encoder: " + l + ", duration: " + e.g(Hj));
            }
            this.Fe.li.cleanup();
            this.hg = new C0144c(Collections.singletonList(this.Fe.Ce), this.Ae, this);
        } catch (Throwable th) {
            this.Fe.li.cleanup();
            throw th;
        }
    }

    public boolean F() {
        Object obj = this.ig;
        if (obj != null) {
            this.ig = null;
            u(obj);
        }
        C0144c cVar = this.hg;
        if (cVar != null && cVar.F()) {
            return true;
        }
        this.hg = null;
        this.Fe = null;
        boolean z = false;
        while (!z && Nl()) {
            List<t.a<?>> gi = this.Ae.gi();
            int i = this.gg;
            this.gg = i + 1;
            this.Fe = gi.get(i);
            if (this.Fe != null && (this.Ae.fi().a(this.Fe.li.G()) || this.Ae.e((Class<?>) this.Fe.li.ba()))) {
                this.Fe.li.a(this.Ae.getPriority(), this);
                z = true;
            }
        }
        return z;
    }

    public void Z() {
        throw new UnsupportedOperationException();
    }

    public void a(c cVar, Exception exc, d<?> dVar, DataSource dataSource) {
        this.cb.a(cVar, exc, dVar, this.Fe.li.G());
    }

    public void a(c cVar, Object obj, d<?> dVar, DataSource dataSource, c cVar2) {
        this.cb.a(cVar, obj, dVar, this.Fe.li.G(), cVar);
    }

    public void b(@NonNull Exception exc) {
        this.cb.a(this.jg, exc, this.Fe.li, this.Fe.li.G());
    }

    public void b(Object obj) {
        o fi = this.Ae.fi();
        if (obj == null || !fi.a(this.Fe.li.G())) {
            this.cb.a(this.Fe.Ce, obj, this.Fe.li, this.Fe.li.G(), this.jg);
            return;
        }
        this.ig = obj;
        this.cb.Z();
    }

    public void cancel() {
        t.a<?> aVar = this.Fe;
        if (aVar != null) {
            aVar.li.cancel();
        }
    }
}
