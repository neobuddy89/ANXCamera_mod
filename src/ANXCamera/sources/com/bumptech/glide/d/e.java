package com.bumptech.glide.d;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ResourceDecoderRegistry */
public class e {
    private final List<String> Jk = new ArrayList();
    private final Map<String, List<a<?, ?>>> nf = new HashMap();

    /* compiled from: ResourceDecoderRegistry */
    private static class a<T, R> {
        final Class<R> He;
        private final Class<T> dataClass;
        final h<T, R> decoder;

        public a(@NonNull Class<T> cls, @NonNull Class<R> cls2, h<T, R> hVar) {
            this.dataClass = cls;
            this.He = cls2;
            this.decoder = hVar;
        }

        public boolean c(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return this.dataClass.isAssignableFrom(cls) && cls2.isAssignableFrom(this.He);
        }
    }

    @NonNull
    private synchronized List<a<?, ?>> G(@NonNull String str) {
        List<a<?, ?>> list;
        if (!this.Jk.contains(str)) {
            this.Jk.add(str);
        }
        list = this.nf.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.nf.put(str, list);
        }
        return list;
    }

    public synchronized <T, R> void a(@NonNull String str, @NonNull h<T, R> hVar, @NonNull Class<T> cls, @NonNull Class<R> cls2) {
        G(str).add(new a(cls, cls2, hVar));
    }

    public synchronized <T, R> void b(@NonNull String str, @NonNull h<T, R> hVar, @NonNull Class<T> cls, @NonNull Class<R> cls2) {
        G(str).add(0, new a(cls, cls2, hVar));
    }

    public synchronized void d(@NonNull List<String> list) {
        ArrayList<String> arrayList = new ArrayList<>(this.Jk);
        this.Jk.clear();
        this.Jk.addAll(list);
        for (String str : arrayList) {
            if (!list.contains(str)) {
                this.Jk.add(str);
            }
        }
    }

    @NonNull
    public synchronized <T, R> List<h<T, R>> f(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.Jk) {
            List<a> list = this.nf.get(str);
            if (list != null) {
                for (a aVar : list) {
                    if (aVar.c(cls, cls2)) {
                        arrayList.add(aVar.decoder);
                    }
                }
            }
        }
        return arrayList;
    }

    @NonNull
    public synchronized <T, R> List<Class<R>> g(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.Jk) {
            List<a> list = this.nf.get(str);
            if (list != null) {
                for (a aVar : list) {
                    if (aVar.c(cls, cls2) && !arrayList.contains(aVar.He)) {
                        arrayList.add(aVar.He);
                    }
                }
            }
        }
        return arrayList;
    }
}
