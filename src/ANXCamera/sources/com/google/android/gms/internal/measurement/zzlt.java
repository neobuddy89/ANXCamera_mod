package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
public final class zzlt implements zzlu {
    private static final zzcl<Boolean> zza;
    private static final zzcl<Boolean> zzb;
    private static final zzcl<Boolean> zzc;
    private static final zzcl<Boolean> zzd;
    private static final zzcl<Boolean> zze;
    private static final zzcl<Long> zzf;

    static {
        zzcr zzcr = new zzcr(zzcm.zza("com.google.android.gms.measurement"));
        zza = zzcr.zza("measurement.sdk.collection.enable_extend_user_property_size", true);
        zzb = zzcr.zza("measurement.sdk.collection.last_deep_link_referrer2", true);
        zzc = zzcr.zza("measurement.sdk.collection.last_deep_link_referrer_campaign2", false);
        zzd = zzcr.zza("measurement.sdk.collection.last_gclid_from_referrer2", false);
        zze = zzcr.zza("measurement.sdk.collection.worker_thread_referrer", true);
        zzf = zzcr.zza("measurement.id.sdk.collection.last_deep_link_referrer2", 0);
    }

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }

    public final boolean zzc() {
        return zzb.zzc().booleanValue();
    }

    public final boolean zzd() {
        return zzc.zzc().booleanValue();
    }

    public final boolean zze() {
        return zzd.zzc().booleanValue();
    }

    public final boolean zzf() {
        return zze.zzc().booleanValue();
    }
}
