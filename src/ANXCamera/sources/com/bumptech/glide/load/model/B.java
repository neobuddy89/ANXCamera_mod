package com.bumptech.glide.load.model;

import android.support.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.model.t;

/* compiled from: UnitModelLoader */
public class B<Model> implements t<Model, Model> {
    private static final B<?> INSTANCE = new B<>();

    /* compiled from: UnitModelLoader */
    public static class a<Model> implements u<Model, Model> {
        private static final a<?> FACTORY = new a<>();

        public static <T> a<T> getInstance() {
            return FACTORY;
        }

        public void S() {
        }

        @NonNull
        public t<Model, Model> a(x xVar) {
            return B.getInstance();
        }
    }

    /* compiled from: UnitModelLoader */
    private static class b<Model> implements d<Model> {
        private final Model resource;

        b(Model model) {
            this.resource = model;
        }

        @NonNull
        public DataSource G() {
            return DataSource.LOCAL;
        }

        public void a(@NonNull Priority priority, @NonNull d.a<? super Model> aVar) {
            aVar.b(this.resource);
        }

        @NonNull
        public Class<Model> ba() {
            return this.resource.getClass();
        }

        public void cancel() {
        }

        public void cleanup() {
        }
    }

    public static <T> B<T> getInstance() {
        return INSTANCE;
    }

    public t.a<Model> a(@NonNull Model model, int i, int i2, @NonNull g gVar) {
        return new t.a<>(new com.bumptech.glide.e.d(model), new b(model));
    }

    public boolean c(@NonNull Model model) {
        return true;
    }
}
