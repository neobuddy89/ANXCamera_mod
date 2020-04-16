package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
public final class zzjr implements zzjs {
    private static final zzcl<Boolean> zza;
    private static final zzcl<Boolean> zzb;
    private static final zzcl<Boolean> zzc;
    private static final zzcl<Long> zzd;

    static {
        zzcr zzcr = new zzcr(zzcm.zza("com.google.android.gms.measurement"));
        zza = zzcr.zza("measurement.sdk.dynamite.allow_remote_dynamite", false);
        zzb = zzcr.zza("measurement.collection.init_params_control_enabled", true);
        zzc = zzcr.zza("measurement.sdk.dynamite.use_dynamite3", false);
        zzd = zzcr.zza("measurement.id.sdk.dynamite.use_dynamite", 0);
    }

    public final boolean zza() {
        return zza.zzc().booleanValue();
    }

    public final boolean zzb() {
        return zzc.zzc().booleanValue();
    }
}
