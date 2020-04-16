package com.bumptech.glide.load.model;

import android.support.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.model.t;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* renamed from: com.bumptech.glide.load.model.c  reason: case insensitive filesystem */
/* compiled from: ByteArrayLoader */
public class C0153c<Data> implements t<byte[], Data> {
    private final b<Data> Rh;

    /* renamed from: com.bumptech.glide.load.model.c$a */
    /* compiled from: ByteArrayLoader */
    public static class a implements u<byte[], ByteBuffer> {
        public void S() {
        }

        @NonNull
        public t<byte[], ByteBuffer> a(@NonNull x xVar) {
            return new C0153c(new C0152b(this));
        }
    }

    /* renamed from: com.bumptech.glide.load.model.c$b */
    /* compiled from: ByteArrayLoader */
    public interface b<Data> {
        Class<Data> ba();

        Data e(byte[] bArr);
    }

    /* renamed from: com.bumptech.glide.load.model.c$c  reason: collision with other inner class name */
    /* compiled from: ByteArrayLoader */
    private static class C0010c<Data> implements com.bumptech.glide.load.a.d<Data> {
        private final b<Data> Rh;
        private final byte[] model;

        C0010c(byte[] bArr, b<Data> bVar) {
            this.model = bArr;
            this.Rh = bVar;
        }

        @NonNull
        public DataSource G() {
            return DataSource.LOCAL;
        }

        public void a(@NonNull Priority priority, @NonNull d.a<? super Data> aVar) {
            aVar.b(this.Rh.e(this.model));
        }

        @NonNull
        public Class<Data> ba() {
            return this.Rh.ba();
        }

        public void cancel() {
        }

        public void cleanup() {
        }
    }

    /* renamed from: com.bumptech.glide.load.model.c$d */
    /* compiled from: ByteArrayLoader */
    public static class d implements u<byte[], InputStream> {
        public void S() {
        }

        @NonNull
        public t<byte[], InputStream> a(@NonNull x xVar) {
            return new C0153c(new C0154d(this));
        }
    }

    public C0153c(b<Data> bVar) {
        this.Rh = bVar;
    }

    public t.a<Data> a(@NonNull byte[] bArr, int i, int i2, @NonNull g gVar) {
        return new t.a<>(new com.bumptech.glide.e.d(bArr), new C0010c(bArr, this.Rh));
    }

    /* renamed from: i */
    public boolean c(@NonNull byte[] bArr) {
        return true;
    }
}
