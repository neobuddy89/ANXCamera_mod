package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
public final class zzjw implements zzjt {
    private static final zzcl<Boolean> zza;
    private static final zzcl<Long> zzb;
    private static final zzcl<Boolean> zzc;
    private static final zzcl<Boolean> zzd;
    private static final zzcl<Boolean> zze;
    private static final zzcl<Boolean> zzf;
    private static final zzcl<Boolean> zzg;

    static {
        zzcr zzcr = new zzcr(zzcm.zza("com.google.android.gms.measurement"));
        zza = zzcr.zza("measurement.gold.enhanced_ecommerce.format_logs", false);
        zzb = zzcr.zza("measurement.id.gold.enhanced_ecommerce.service", 0);
        zzc = zzcr.zza("measurement.gold.enhanced_ecommerce.log_nested_complex_events", false);
        zzd = zzcr.zza("measurement.gold.enhanced_ecommerce.nested_param_daily_event_count", false);
        zze = zzcr.zza("measurement.gold.enhanced_ecommerce.updated_schema.client", false);
        zzf = zzcr.zza("measurement.gold.enhanced_ecommerce.updated_schema.service", false);
        zzg = zzcr.zza("measurement.gold.enhanced_ecommerce.upload_nested_complex_events", false);
    }

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }

    public final boolean zzc() {
        return zzc.zzc().booleanValue();
    }

    public final boolean zzd() {
        return zzd.zzc().booleanValue();
    }

    public final boolean zze() {
        return zze.zzc().booleanValue();
    }

    public final boolean zzf() {
        return zzf.zzc().booleanValue();
    }

    public final boolean zzg() {
        return zzg.zzc().booleanValue();
    }
}
