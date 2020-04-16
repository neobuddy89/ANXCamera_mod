package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
public final class zziy implements zziv {
    private static final zzcl<Boolean> zza;
    private static final zzcl<Boolean> zzb;

    static {
        zzcr zzcr = new zzcr(zzcm.zza("com.google.android.gms.measurement"));
        zza = zzcr.zza("measurement.androidId.delete_feature", true);
        zzb = zzcr.zza("measurement.log_androidId_enabled", false);
    }

    public final boolean zza() {
        return zza.zzc().booleanValue();
    }
}
