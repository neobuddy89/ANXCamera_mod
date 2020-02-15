package com.bumptech.glide.load;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.util.i;
import java.security.MessageDigest;

/* compiled from: Option */
public final class f<T> {
    private static final a<Object> Td = new e();
    private final a<T> Rd;
    private volatile byte[] Sd;
    private final T defaultValue;
    private final String key;

    /* compiled from: Option */
    public interface a<T> {
        void a(@NonNull byte[] bArr, @NonNull T t, @NonNull MessageDigest messageDigest);
    }

    private f(@NonNull String str, @Nullable T t, @NonNull a<T> aVar) {
        i.y(str);
        this.key = str;
        this.defaultValue = t;
        i.checkNotNull(aVar);
        this.Rd = aVar;
    }

    @NonNull
    private static <T> a<T> Jl() {
        return Td;
    }

    @NonNull
    private byte[] Kl() {
        if (this.Sd == null) {
            this.Sd = this.key.getBytes(c.CHARSET);
        }
        return this.Sd;
    }

    @NonNull
    public static <T> f<T> a(@NonNull String str, @NonNull a<T> aVar) {
        return new f<>(str, (T) null, aVar);
    }

    @NonNull
    public static <T> f<T> a(@NonNull String str, @NonNull T t) {
        return new f<>(str, t, Jl());
    }

    @NonNull
    public static <T> f<T> a(@NonNull String str, @Nullable T t, @NonNull a<T> aVar) {
        return new f<>(str, t, aVar);
    }

    @NonNull
    public static <T> f<T> s(@NonNull String str) {
        return new f<>(str, (T) null, Jl());
    }

    public void a(@NonNull T t, @NonNull MessageDigest messageDigest) {
        this.Rd.a(Kl(), t, messageDigest);
    }

    public boolean equals(Object obj) {
        if (obj instanceof f) {
            return this.key.equals(((f) obj).key);
        }
        return false;
    }

    @Nullable
    public T getDefaultValue() {
        return this.defaultValue;
    }

    public int hashCode() {
        return this.key.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.key + '\'' + '}';
    }
}
