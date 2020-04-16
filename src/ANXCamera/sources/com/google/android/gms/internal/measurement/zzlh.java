package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
public final class zzlh implements zzli {
    private static final zzcl<Boolean> zza;
    private static final zzcl<Boolean> zzb;
    private static final zzcl<Long> zzc;

    static {
        zzcr zzcr = new zzcr(zzcm.zza("com.google.android.gms.measurement"));
        zza = zzcr.zza("measurement.collection.efficient_engagement_reporting_enabled_2", false);
        zzb = zzcr.zza("measurement.collection.redundant_engagement_removal_enabled", false);
        zzc = zzcr.zza("measurement.id.collection.efficient_engagement_reporting_enabled_2", 0);
    }

    public final boolean zza() {
        return zza.zzc().booleanValue();
    }

    public final boolean zzb() {
        return zzb.zzc().booleanValue();
    }
}
