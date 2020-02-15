package com.bumptech.glide.load.engine;

import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.e;
import com.bumptech.glide.load.b.b;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.a.a;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.model.t;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: DecodeHelper */
final class g<Transcode> {
    private final List<t.a<?>> Fe = new ArrayList();
    private e Hb;
    private Class<?> He;
    private DecodeJob.d Ie;
    private boolean Je;
    private boolean Ke;
    private o Le;
    private boolean Me;
    private boolean Ne;
    private Map<Class<?>, j<?>> Qd;
    private int height;
    private Object model;
    private com.bumptech.glide.load.g options;
    private Priority priority;
    private c signature;
    private int width;
    private Class<Transcode> yc;
    private final List<c> ze = new ArrayList();

    g() {
    }

    /* access modifiers changed from: package-private */
    public a C() {
        return this.Ie.C();
    }

    /* access modifiers changed from: package-private */
    public <R> void a(e eVar, Object obj, c cVar, int i, int i2, o oVar, Class<?> cls, Class<R> cls2, Priority priority2, com.bumptech.glide.load.g gVar, Map<Class<?>, j<?>> map, boolean z, boolean z2, DecodeJob.d dVar) {
        this.Hb = eVar;
        this.model = obj;
        this.signature = cVar;
        this.width = i;
        this.height = i2;
        this.Le = oVar;
        this.He = cls;
        this.Ie = dVar;
        this.yc = cls2;
        this.priority = priority2;
        this.options = gVar;
        this.Qd = map;
        this.Me = z;
        this.Ne = z2;
    }

    /* access modifiers changed from: package-private */
    public <Data> x<Data, ?, Transcode> c(Class<Data> cls) {
        return this.Hb.getRegistry().a(cls, this.He, this.yc);
    }

    /* access modifiers changed from: package-private */
    public <Z> i<Z> c(A<Z> a2) {
        return this.Hb.getRegistry().c(a2);
    }

    /* access modifiers changed from: package-private */
    public void clear() {
        this.Hb = null;
        this.model = null;
        this.signature = null;
        this.He = null;
        this.yc = null;
        this.options = null;
        this.priority = null;
        this.Qd = null;
        this.Le = null;
        this.Fe.clear();
        this.Je = false;
        this.ze.clear();
        this.Ke = false;
    }

    /* access modifiers changed from: package-private */
    public <Z> j<Z> d(Class<Z> cls) {
        j<Z> jVar = this.Qd.get(cls);
        if (jVar == null) {
            Iterator<Map.Entry<Class<?>, j<?>>> it = this.Qd.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry next = it.next();
                if (((Class) next.getKey()).isAssignableFrom(cls)) {
                    jVar = (j) next.getValue();
                    break;
                }
            }
        }
        if (jVar != null) {
            return jVar;
        }
        if (!this.Qd.isEmpty() || !this.Me) {
            return b.get();
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }

    /* access modifiers changed from: package-private */
    public boolean d(A<?> a2) {
        return this.Hb.getRegistry().d(a2);
    }

    /* access modifiers changed from: package-private */
    public List<t<File, ?>> e(File file) throws Registry.NoModelLoaderAvailableException {
        return this.Hb.getRegistry().j(file);
    }

    /* access modifiers changed from: package-private */
    public boolean e(c cVar) {
        List<t.a<?>> gi = gi();
        int size = gi.size();
        for (int i = 0; i < size; i++) {
            if (gi.get(i).Ce.equals(cVar)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean e(Class<?> cls) {
        return c(cls) != null;
    }

    /* access modifiers changed from: package-private */
    public List<c> ei() {
        if (!this.Ke) {
            this.Ke = true;
            this.ze.clear();
            List<t.a<?>> gi = gi();
            int size = gi.size();
            for (int i = 0; i < size; i++) {
                t.a aVar = gi.get(i);
                if (!this.ze.contains(aVar.Ce)) {
                    this.ze.add(aVar.Ce);
                }
                for (int i2 = 0; i2 < aVar.ki.size(); i2++) {
                    if (!this.ze.contains(aVar.ki.get(i2))) {
                        this.ze.add(aVar.ki.get(i2));
                    }
                }
            }
        }
        return this.ze;
    }

    /* access modifiers changed from: package-private */
    public o fi() {
        return this.Le;
    }

    /* access modifiers changed from: package-private */
    public int getHeight() {
        return this.height;
    }

    /* access modifiers changed from: package-private */
    public com.bumptech.glide.load.g getOptions() {
        return this.options;
    }

    /* access modifiers changed from: package-private */
    public Priority getPriority() {
        return this.priority;
    }

    /* access modifiers changed from: package-private */
    public c getSignature() {
        return this.signature;
    }

    /* access modifiers changed from: package-private */
    public int getWidth() {
        return this.width;
    }

    /* access modifiers changed from: package-private */
    public List<t.a<?>> gi() {
        if (!this.Je) {
            this.Je = true;
            this.Fe.clear();
            List j = this.Hb.getRegistry().j(this.model);
            int size = j.size();
            for (int i = 0; i < size; i++) {
                t.a a2 = ((t) j.get(i)).a(this.model, this.width, this.height, this.options);
                if (a2 != null) {
                    this.Fe.add(a2);
                }
            }
        }
        return this.Fe;
    }

    /* access modifiers changed from: package-private */
    public Class<?> hi() {
        return this.model.getClass();
    }

    /* access modifiers changed from: package-private */
    public List<Class<?>> ii() {
        return this.Hb.getRegistry().b(this.model.getClass(), this.He, this.yc);
    }

    /* access modifiers changed from: package-private */
    public Class<?> ji() {
        return this.yc;
    }

    /* access modifiers changed from: package-private */
    public com.bumptech.glide.load.engine.bitmap_recycle.b ka() {
        return this.Hb.ka();
    }

    /* access modifiers changed from: package-private */
    public boolean ki() {
        return this.Ne;
    }

    /* access modifiers changed from: package-private */
    public <X> com.bumptech.glide.load.a<X> l(X x) throws Registry.NoSourceEncoderAvailableException {
        return this.Hb.getRegistry().l(x);
    }
}
