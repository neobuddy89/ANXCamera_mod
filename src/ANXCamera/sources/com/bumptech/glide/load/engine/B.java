package com.bumptech.glide.load.engine;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.engine.f;
import com.bumptech.glide.load.model.t;
import java.io.File;
import java.util.List;

/* compiled from: ResourceCacheGenerator */
class B implements f, d.a<Object> {
    private final g<?> Ae;
    private int Be;
    private c Ce;
    private List<t<File, ?>> De;
    private int Ee;
    private volatile t.a<?> Fe;
    private File Ge;
    private int Zf = -1;
    private C _f;
    private final f.a cb;

    B(g<?> gVar, f.a aVar) {
        this.Ae = gVar;
        this.cb = aVar;
    }

    private boolean Nl() {
        return this.Ee < this.De.size();
    }

    public boolean F() {
        List<c> ei = this.Ae.ei();
        boolean z = false;
        if (ei.isEmpty()) {
            return false;
        }
        List<Class<?>> ii = this.Ae.ii();
        if (ii.isEmpty() && File.class.equals(this.Ae.ji())) {
            return false;
        }
        while (true) {
            if (this.De == null || !Nl()) {
                this.Zf++;
                if (this.Zf >= ii.size()) {
                    this.Be++;
                    if (this.Be >= ei.size()) {
                        return false;
                    }
                    this.Zf = 0;
                }
                c cVar = ei.get(this.Be);
                Class cls = ii.get(this.Zf);
                C c2 = new C(this.Ae.ka(), cVar, this.Ae.getSignature(), this.Ae.getWidth(), this.Ae.getHeight(), this.Ae.d(cls), cls, this.Ae.getOptions());
                this._f = c2;
                this.Ge = this.Ae.C().b(this._f);
                File file = this.Ge;
                if (file != null) {
                    this.Ce = cVar;
                    this.De = this.Ae.e(file);
                    this.Ee = 0;
                }
            } else {
                this.Fe = null;
                while (!z && Nl()) {
                    List<t<File, ?>> list = this.De;
                    int i = this.Ee;
                    this.Ee = i + 1;
                    this.Fe = list.get(i).a(this.Ge, this.Ae.getWidth(), this.Ae.getHeight(), this.Ae.getOptions());
                    if (this.Fe != null && this.Ae.e((Class<?>) this.Fe.li.ba())) {
                        this.Fe.li.a(this.Ae.getPriority(), this);
                        z = true;
                    }
                }
                return z;
            }
        }
    }

    public void b(@NonNull Exception exc) {
        this.cb.a(this._f, exc, this.Fe.li, DataSource.RESOURCE_DISK_CACHE);
    }

    public void b(Object obj) {
        this.cb.a(this.Ce, obj, this.Fe.li, DataSource.RESOURCE_DISK_CACHE, this._f);
    }

    public void cancel() {
        t.a<?> aVar = this.Fe;
        if (aVar != null) {
            aVar.li.cancel();
        }
    }
}
