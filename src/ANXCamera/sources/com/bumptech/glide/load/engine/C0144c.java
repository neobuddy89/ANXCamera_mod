package com.bumptech.glide.load.engine;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.engine.f;
import com.bumptech.glide.load.model.t;
import java.io.File;
import java.util.List;

/* renamed from: com.bumptech.glide.load.engine.c  reason: case insensitive filesystem */
/* compiled from: DataCacheGenerator */
class C0144c implements f, d.a<Object> {
    private final g<?> Ae;
    private int Be;
    private c Ce;
    private List<t<File, ?>> De;
    private int Ee;
    private volatile t.a<?> Fe;
    private File Ge;
    private final f.a cb;
    private final List<c> ze;

    C0144c(g<?> gVar, f.a aVar) {
        this(gVar.ei(), gVar, aVar);
    }

    C0144c(List<c> list, g<?> gVar, f.a aVar) {
        this.Be = -1;
        this.ze = list;
        this.Ae = gVar;
        this.cb = aVar;
    }

    private boolean Nl() {
        return this.Ee < this.De.size();
    }

    public boolean F() {
        while (true) {
            boolean z = false;
            if (this.De == null || !Nl()) {
                this.Be++;
                if (this.Be >= this.ze.size()) {
                    return false;
                }
                c cVar = this.ze.get(this.Be);
                this.Ge = this.Ae.C().b(new C0145d(cVar, this.Ae.getSignature()));
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
        this.cb.a(this.Ce, exc, this.Fe.li, DataSource.DATA_DISK_CACHE);
    }

    public void b(Object obj) {
        this.cb.a(this.Ce, obj, this.Fe.li, DataSource.DATA_DISK_CACHE, this.Ce);
    }

    public void cancel() {
        t.a<?> aVar = this.Fe;
        if (aVar != null) {
            aVar.li.cancel();
        }
    }
}
