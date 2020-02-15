package com.bumptech.glide.load.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.Pools;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ModelLoaderRegistry */
public class v {
    private final a cache;
    private final x ni;

    /* compiled from: ModelLoaderRegistry */
    private static class a {
        private final Map<Class<?>, C0011a<?>> mi = new HashMap();

        /* renamed from: com.bumptech.glide.load.model.v$a$a  reason: collision with other inner class name */
        /* compiled from: ModelLoaderRegistry */
        private static class C0011a<Model> {
            final List<t<Model, ?>> loaders;

            public C0011a(List<t<Model, ?>> list) {
                this.loaders = list;
            }
        }

        a() {
        }

        public <Model> void a(Class<Model> cls, List<t<Model, ?>> list) {
            if (this.mi.put(cls, new C0011a(list)) != null) {
                throw new IllegalStateException("Already cached loaders for model: " + cls);
            }
        }

        public void clear() {
            this.mi.clear();
        }

        @Nullable
        public <Model> List<t<Model, ?>> get(Class<Model> cls) {
            C0011a aVar = this.mi.get(cls);
            if (aVar == null) {
                return null;
            }
            return aVar.loaders;
        }
    }

    public v(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(new x(pool));
    }

    private v(@NonNull x xVar) {
        this.cache = new a();
        this.ni = xVar;
    }

    private <Model, Data> void g(@NonNull List<u<? extends Model, ? extends Data>> list) {
        for (u<? extends Model, ? extends Data> S : list) {
            S.S();
        }
    }

    @NonNull
    private <A> List<t<A, ?>> o(@NonNull Class<A> cls) {
        List<t<A, ?>> list = this.cache.get(cls);
        if (list != null) {
            return list;
        }
        List<t<A, ?>> unmodifiableList = Collections.unmodifiableList(this.ni.h(cls));
        this.cache.a(cls, unmodifiableList);
        return unmodifiableList;
    }

    @NonNull
    private static <A> Class<A> w(@NonNull A a2) {
        return a2.getClass();
    }

    public synchronized <Model, Data> t<Model, Data> a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        return this.ni.a(cls, cls2);
    }

    public synchronized <Model, Data> void a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull u<? extends Model, ? extends Data> uVar) {
        this.ni.a(cls, cls2, uVar);
        this.cache.clear();
    }

    public synchronized <Model, Data> void b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        g(this.ni.b(cls, cls2));
        this.cache.clear();
    }

    public synchronized <Model, Data> void b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull u<? extends Model, ? extends Data> uVar) {
        this.ni.b(cls, cls2, uVar);
        this.cache.clear();
    }

    public synchronized <Model, Data> void c(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull u<? extends Model, ? extends Data> uVar) {
        g(this.ni.c(cls, cls2, uVar));
        this.cache.clear();
    }

    @NonNull
    public synchronized List<Class<?>> f(@NonNull Class<?> cls) {
        return this.ni.f(cls);
    }

    @NonNull
    public synchronized <A> List<t<A, ?>> j(@NonNull A a2) {
        ArrayList arrayList;
        List o = o(w(a2));
        int size = o.size();
        arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            t tVar = (t) o.get(i);
            if (tVar.c(a2)) {
                arrayList.add(tVar);
            }
        }
        return arrayList;
    }
}
