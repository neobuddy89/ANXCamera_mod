package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.3.0 */
final class zzgy {
    private static final zzgw zza = zzc();
    private static final zzgw zzb = new zzgv();

    static zzgw zza() {
        return zza;
    }

    static zzgw zzb() {
        return zzb;
    }

    private static zzgw zzc() {
        try {
            return (zzgw) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e2) {
            return null;
        }
    }
}
