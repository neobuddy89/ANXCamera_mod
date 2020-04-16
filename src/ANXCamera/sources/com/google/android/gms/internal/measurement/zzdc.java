package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
public final class zzdc {
    public static <T> zzcz<T> zza(zzcz<T> zzcz) {
        return ((zzcz instanceof zzde) || (zzcz instanceof zzdb)) ? zzcz : zzcz instanceof Serializable ? new zzdb(zzcz) : new zzde(zzcz);
    }

    public static <T> zzcz<T> zza(@NullableDecl T t) {
        return new zzdd(t);
    }
}
