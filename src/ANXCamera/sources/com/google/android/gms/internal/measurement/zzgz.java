package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.3.0 */
final class zzgz {
    private static final zzgz zza = new zzgz();
    private final zzhg zzb = new zzgb();
    private final ConcurrentMap<Class<?>, zzhd<?>> zzc = new ConcurrentHashMap();

    private zzgz() {
    }

    public static zzgz zza() {
        return zza;
    }

    public final <T> zzhd<T> zza(Class<T> cls) {
        zzff.zza(cls, "messageType");
        zzhd<T> zzhd = (zzhd) this.zzc.get(cls);
        if (zzhd != null) {
            return zzhd;
        }
        zzhd<T> zza2 = this.zzb.zza(cls);
        zzff.zza(cls, "messageType");
        zzff.zza(zza2, "schema");
        zzhd<T> putIfAbsent = this.zzc.putIfAbsent(cls, zza2);
        return putIfAbsent != null ? putIfAbsent : zza2;
    }

    public final <T> zzhd<T> zza(T t) {
        return zza(t.getClass());
    }
}
