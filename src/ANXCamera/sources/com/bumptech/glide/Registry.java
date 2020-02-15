package com.bumptech.glide;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.Pools;
import com.bumptech.glide.d.a;
import com.bumptech.glide.d.b;
import com.bumptech.glide.d.c;
import com.bumptech.glide.d.d;
import com.bumptech.glide.d.e;
import com.bumptech.glide.d.f;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.a.e;
import com.bumptech.glide.load.a.g;
import com.bumptech.glide.load.engine.A;
import com.bumptech.glide.load.engine.i;
import com.bumptech.glide.load.engine.x;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.model.t;
import com.bumptech.glide.load.model.u;
import com.bumptech.glide.load.model.v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Registry {
    public static final String rc = "Gif";
    public static final String sc = "Bitmap";
    public static final String tc = "BitmapDrawable";
    private static final String uc = "legacy_prepend_all";
    private static final String vc = "legacy_append";
    private final v gc = new v(this.qc);
    private final a hc = new a();
    private final e ic = new e();
    private final f jc = new f();
    private final g kc = new g();
    private final com.bumptech.glide.load.b.d.f lc = new com.bumptech.glide.load.b.d.f();
    private final b mc = new b();
    private final d nc = new d();
    private final c oc = new c();
    private final Pools.Pool<List<Throwable>> qc = com.bumptech.glide.util.a.d.Mj();

    public static class MissingComponentException extends RuntimeException {
        public MissingComponentException(@NonNull String str) {
            super(str);
        }
    }

    public static final class NoImageHeaderParserException extends MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }

    public static class NoModelLoaderAvailableException extends MissingComponentException {
        public NoModelLoaderAvailableException(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }

        public NoModelLoaderAvailableException(@NonNull Object obj) {
            super("Failed to find any ModelLoaders for model: " + obj);
        }
    }

    public static class NoResultEncoderAvailableException extends MissingComponentException {
        public NoResultEncoderAvailableException(@NonNull Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    public static class NoSourceEncoderAvailableException extends MissingComponentException {
        public NoSourceEncoderAvailableException(@NonNull Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public Registry() {
        c((List<String>) Arrays.asList(new String[]{rc, sc, tc}));
    }

    @NonNull
    private <Data, TResource, Transcode> List<i<Data, TResource, Transcode>> e(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class next : this.ic.g(cls, cls2)) {
            for (Class next2 : this.lc.e(next, cls3)) {
                i iVar = new i(cls, next, next2, this.ic.f(cls, next), this.lc.d(next, next2), this.qc);
                arrayList.add(iVar);
            }
        }
        return arrayList;
    }

    @NonNull
    public List<ImageHeaderParser> Hh() {
        List<ImageHeaderParser> Pi = this.mc.Pi();
        if (!Pi.isEmpty()) {
            return Pi;
        }
        throw new NoImageHeaderParserException();
    }

    @NonNull
    public Registry a(@NonNull ImageHeaderParser imageHeaderParser) {
        this.mc.b(imageHeaderParser);
        return this;
    }

    @NonNull
    public Registry a(@NonNull e.a<?> aVar) {
        this.kc.a(aVar);
        return this;
    }

    @NonNull
    public <Data> Registry a(@NonNull Class<Data> cls, @NonNull com.bumptech.glide.load.a<Data> aVar) {
        this.hc.a(cls, aVar);
        return this;
    }

    @NonNull
    public <TResource> Registry a(@NonNull Class<TResource> cls, @NonNull com.bumptech.glide.load.i<TResource> iVar) {
        this.jc.a(cls, iVar);
        return this;
    }

    @NonNull
    public <TResource, Transcode> Registry a(@NonNull Class<TResource> cls, @NonNull Class<Transcode> cls2, @NonNull com.bumptech.glide.load.b.d.e<TResource, Transcode> eVar) {
        this.lc.a(cls, cls2, eVar);
        return this;
    }

    @NonNull
    public <Data, TResource> Registry a(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull h<Data, TResource> hVar) {
        a(vc, cls, cls2, hVar);
        return this;
    }

    @NonNull
    public <Model, Data> Registry a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull u<Model, Data> uVar) {
        this.gc.a(cls, cls2, uVar);
        return this;
    }

    @NonNull
    public <Data, TResource> Registry a(@NonNull String str, @NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull h<Data, TResource> hVar) {
        this.ic.a(str, hVar, cls, cls2);
        return this;
    }

    @Nullable
    public <Data, TResource, Transcode> x<Data, TResource, Transcode> a(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        x<Data, TResource, Transcode> c2 = this.oc.c(cls, cls2, cls3);
        if (this.oc.a(c2)) {
            return null;
        }
        if (c2 == null) {
            List<i<Data, TResource, Transcode>> e2 = e(cls, cls2, cls3);
            if (e2.isEmpty()) {
                c2 = null;
            } else {
                c2 = new x<>(cls, cls2, cls3, e2, this.qc);
            }
            this.oc.a(cls, cls2, cls3, c2);
        }
        return c2;
    }

    @NonNull
    public <Data> Registry b(@NonNull Class<Data> cls, @NonNull com.bumptech.glide.load.a<Data> aVar) {
        this.hc.b(cls, aVar);
        return this;
    }

    @NonNull
    public <TResource> Registry b(@NonNull Class<TResource> cls, @NonNull com.bumptech.glide.load.i<TResource> iVar) {
        this.jc.b(cls, iVar);
        return this;
    }

    @NonNull
    public <Data, TResource> Registry b(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull h<Data, TResource> hVar) {
        b(uc, cls, cls2, hVar);
        return this;
    }

    @NonNull
    public <Model, Data> Registry b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull u<Model, Data> uVar) {
        this.gc.b(cls, cls2, uVar);
        return this;
    }

    @NonNull
    public <Data, TResource> Registry b(@NonNull String str, @NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull h<Data, TResource> hVar) {
        this.ic.b(str, hVar, cls, cls2);
        return this;
    }

    @NonNull
    public <Model, TResource, Transcode> List<Class<?>> b(@NonNull Class<Model> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        List<Class<?>> d2 = this.nc.d(cls, cls2);
        if (d2 == null) {
            d2 = new ArrayList<>();
            for (Class<?> g : this.gc.f(cls)) {
                for (Class next : this.ic.g(g, cls2)) {
                    if (!this.lc.e(next, cls3).isEmpty() && !d2.contains(next)) {
                        d2.add(next);
                    }
                }
            }
            this.nc.a(cls, cls2, Collections.unmodifiableList(d2));
        }
        return d2;
    }

    @Deprecated
    @NonNull
    public <Data> Registry c(@NonNull Class<Data> cls, @NonNull com.bumptech.glide.load.a<Data> aVar) {
        return a(cls, aVar);
    }

    @Deprecated
    @NonNull
    public <TResource> Registry c(@NonNull Class<TResource> cls, @NonNull com.bumptech.glide.load.i<TResource> iVar) {
        return a(cls, iVar);
    }

    @NonNull
    public <Model, Data> Registry c(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull u<? extends Model, ? extends Data> uVar) {
        this.gc.c(cls, cls2, uVar);
        return this;
    }

    @NonNull
    public final Registry c(@NonNull List<String> list) {
        ArrayList arrayList = new ArrayList(list);
        arrayList.add(0, uc);
        arrayList.add(vc);
        this.ic.d(arrayList);
        return this;
    }

    @NonNull
    public <X> com.bumptech.glide.load.i<X> c(@NonNull A<X> a2) throws NoResultEncoderAvailableException {
        com.bumptech.glide.load.i<X> iVar = this.jc.get(a2.O());
        if (iVar != null) {
            return iVar;
        }
        throw new NoResultEncoderAvailableException(a2.O());
    }

    public boolean d(@NonNull A<?> a2) {
        return this.jc.get(a2.O()) != null;
    }

    @NonNull
    public <Model> List<t<Model, ?>> j(@NonNull Model model) {
        List<t<Model, ?>> j = this.gc.j(model);
        if (!j.isEmpty()) {
            return j;
        }
        throw new NoModelLoaderAvailableException(model);
    }

    @NonNull
    public <X> com.bumptech.glide.load.a.e<X> k(@NonNull X x) {
        return this.kc.build(x);
    }

    @NonNull
    public <X> com.bumptech.glide.load.a<X> l(@NonNull X x) throws NoSourceEncoderAvailableException {
        com.bumptech.glide.load.a<X> i = this.hc.i(x.getClass());
        if (i != null) {
            return i;
        }
        throw new NoSourceEncoderAvailableException(x.getClass());
    }
}
