package com.bumptech.glide.request.a;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.a.f;

/* compiled from: NoTransition */
public class e<R> implements f<R> {
    static final e<?> cm = new e<>();
    private static final g<?> dm = new a();

    /* compiled from: NoTransition */
    public static class a<R> implements g<R> {
        public f<R> a(DataSource dataSource, boolean z) {
            return e.cm;
        }
    }

    public static <R> f<R> get() {
        return cm;
    }

    public static <R> g<R> getFactory() {
        return dm;
    }

    public boolean a(Object obj, f.a aVar) {
        return false;
    }
}
