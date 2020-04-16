package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfd;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.3.0 */
final class zzfe implements zzgl {
    private static final zzfe zza = new zzfe();

    private zzfe() {
    }

    public static zzfe zza() {
        return zza;
    }

    public final boolean zza(Class<?> cls) {
        return zzfd.class.isAssignableFrom(cls);
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [java.lang.Class<?>, java.lang.Class] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final zzgm zzb(Class<?> r5) {
        if (!zzfd.class.isAssignableFrom(r5)) {
            String valueOf = String.valueOf(r5.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Unsupported message type: ".concat(valueOf) : new String("Unsupported message type: "));
        }
        try {
            return (zzgm) zzfd.zza(r5.asSubclass(zzfd.class)).zza(zzfd.zze.zzc, (Object) null, (Object) null);
        } catch (Exception e2) {
            String valueOf2 = String.valueOf(r5.getName());
            throw new RuntimeException(valueOf2.length() != 0 ? "Unable to get message info for ".concat(valueOf2) : new String("Unable to get message info for "), e2);
        }
    }
}
