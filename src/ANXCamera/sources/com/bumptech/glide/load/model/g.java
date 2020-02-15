package com.bumptech.glide.load.model;

import android.support.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.model.t;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: DataUrlLoader */
public final class g<Model, Data> implements t<Model, Data> {
    private static final String Uh = "data:image";
    private static final String Vh = ";base64";
    private final a<Data> Th;

    /* compiled from: DataUrlLoader */
    public interface a<Data> {
        Class<Data> ba();

        Data decode(String str) throws IllegalArgumentException;

        void e(Data data) throws IOException;
    }

    /* compiled from: DataUrlLoader */
    private static final class b<Data> implements d<Data> {
        private final String Sh;
        private Data data;
        private final a<Data> reader;

        b(String str, a<Data> aVar) {
            this.Sh = str;
            this.reader = aVar;
        }

        @NonNull
        public DataSource G() {
            return DataSource.LOCAL;
        }

        public void a(@NonNull Priority priority, @NonNull d.a<? super Data> aVar) {
            try {
                this.data = this.reader.decode(this.Sh);
                aVar.b(this.data);
            } catch (IllegalArgumentException e2) {
                aVar.b((Exception) e2);
            }
        }

        @NonNull
        public Class<Data> ba() {
            return this.reader.ba();
        }

        public void cancel() {
        }

        public void cleanup() {
            try {
                this.reader.e(this.data);
            } catch (IOException unused) {
            }
        }
    }

    /* compiled from: DataUrlLoader */
    public static final class c<Model> implements u<Model, InputStream> {
        private final a<InputStream> se = new h(this);

        public void S() {
        }

        @NonNull
        public t<Model, InputStream> a(@NonNull x xVar) {
            return new g(this.se);
        }
    }

    public g(a<Data> aVar) {
        this.Th = aVar;
    }

    public t.a<Data> a(@NonNull Model model, int i, int i2, @NonNull com.bumptech.glide.load.g gVar) {
        return new t.a<>(new com.bumptech.glide.e.d(model), new b(model.toString(), this.Th));
    }

    public boolean c(@NonNull Model model) {
        return model.toString().startsWith(Uh);
    }
}
