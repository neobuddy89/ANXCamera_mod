package com.bumptech.glide.load.model;

import android.os.ParcelFileDescriptor;
import android.support.annotation.NonNull;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.model.t;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: FileLoader */
public class i<Data> implements t<File, Data> {
    private static final String TAG = "FileLoader";
    private final d<Data> Wh;

    /* compiled from: FileLoader */
    public static class a<Data> implements u<File, Data> {
        private final d<Data> se;

        public a(d<Data> dVar) {
            this.se = dVar;
        }

        public final void S() {
        }

        @NonNull
        public final t<File, Data> a(@NonNull x xVar) {
            return new i(this.se);
        }
    }

    /* compiled from: FileLoader */
    public static class b extends a<ParcelFileDescriptor> {
        public b() {
            super(new j());
        }
    }

    /* compiled from: FileLoader */
    private static final class c<Data> implements com.bumptech.glide.load.a.d<Data> {
        private Data data;
        private final File file;
        private final d<Data> se;

        c(File file2, d<Data> dVar) {
            this.file = file2;
            this.se = dVar;
        }

        @NonNull
        public DataSource G() {
            return DataSource.LOCAL;
        }

        public void a(@NonNull Priority priority, @NonNull d.a<? super Data> aVar) {
            try {
                this.data = this.se.b(this.file);
                aVar.b(this.data);
            } catch (FileNotFoundException e2) {
                if (Log.isLoggable(i.TAG, 3)) {
                    Log.d(i.TAG, "Failed to open file", e2);
                }
                aVar.b((Exception) e2);
            }
        }

        @NonNull
        public Class<Data> ba() {
            return this.se.ba();
        }

        public void cancel() {
        }

        public void cleanup() {
            Data data2 = this.data;
            if (data2 != null) {
                try {
                    this.se.e(data2);
                } catch (IOException unused) {
                }
            }
        }
    }

    /* compiled from: FileLoader */
    public interface d<Data> {
        Data b(File file) throws FileNotFoundException;

        Class<Data> ba();

        void e(Data data) throws IOException;
    }

    /* compiled from: FileLoader */
    public static class e extends a<InputStream> {
        public e() {
            super(new k());
        }
    }

    public i(d<Data> dVar) {
        this.Wh = dVar;
    }

    public t.a<Data> a(@NonNull File file, int i, int i2, @NonNull g gVar) {
        return new t.a<>(new com.bumptech.glide.e.d(file), new c(file, this.Wh));
    }

    /* renamed from: f */
    public boolean c(@NonNull File file) {
        return true;
    }
}
