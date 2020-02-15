package com.bumptech.glide.load.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.Pools;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.model.t;
import com.bumptech.glide.util.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: MultiModelLoader */
class w<Model, Data> implements t<Model, Data> {
    private final List<t<Model, Data>> De;
    private final Pools.Pool<List<Throwable>> qi;

    /* compiled from: MultiModelLoader */
    static class a<Data> implements d<Data>, d.a<Data> {
        private d.a<? super Data> callback;
        private int currentIndex = 0;
        @Nullable
        private List<Throwable> exceptions;
        private final List<d<Data>> oi;
        private Priority priority;
        private final Pools.Pool<List<Throwable>> qc;

        a(@NonNull List<d<Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            this.qc = pool;
            i.a(list);
            this.oi = list;
        }

        private void lm() {
            if (this.currentIndex < this.oi.size() - 1) {
                this.currentIndex++;
                a(this.priority, this.callback);
                return;
            }
            i.checkNotNull(this.exceptions);
            this.callback.b((Exception) new GlideException("Fetch failed", (List<Throwable>) new ArrayList(this.exceptions)));
        }

        @NonNull
        public DataSource G() {
            return this.oi.get(0).G();
        }

        public void a(@NonNull Priority priority2, @NonNull d.a<? super Data> aVar) {
            this.priority = priority2;
            this.callback = aVar;
            this.exceptions = this.qc.acquire();
            this.oi.get(this.currentIndex).a(priority2, this);
        }

        public void b(@NonNull Exception exc) {
            List<Throwable> list = this.exceptions;
            i.checkNotNull(list);
            list.add(exc);
            lm();
        }

        public void b(@Nullable Data data) {
            if (data != null) {
                this.callback.b(data);
            } else {
                lm();
            }
        }

        @NonNull
        public Class<Data> ba() {
            return this.oi.get(0).ba();
        }

        public void cancel() {
            for (d<Data> cancel : this.oi) {
                cancel.cancel();
            }
        }

        public void cleanup() {
            List<Throwable> list = this.exceptions;
            if (list != null) {
                this.qc.release(list);
            }
            this.exceptions = null;
            for (d<Data> cleanup : this.oi) {
                cleanup.cleanup();
            }
        }
    }

    w(@NonNull List<t<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
        this.De = list;
        this.qi = pool;
    }

    public t.a<Data> a(@NonNull Model model, int i, int i2, @NonNull g gVar) {
        int size = this.De.size();
        ArrayList arrayList = new ArrayList(size);
        c cVar = null;
        for (int i3 = 0; i3 < size; i3++) {
            t tVar = this.De.get(i3);
            if (tVar.c(model)) {
                t.a a2 = tVar.a(model, i, i2, gVar);
                if (a2 != null) {
                    cVar = a2.Ce;
                    arrayList.add(a2.li);
                }
            }
        }
        if (arrayList.isEmpty() || cVar == null) {
            return null;
        }
        return new t.a<>(cVar, new a(arrayList, this.qi));
    }

    public boolean c(@NonNull Model model) {
        for (t<Model, Data> c2 : this.De) {
            if (c2.c(model)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.De.toArray()) + '}';
    }
}
