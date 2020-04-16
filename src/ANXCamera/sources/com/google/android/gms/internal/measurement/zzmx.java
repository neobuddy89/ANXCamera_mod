package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
public final class zzmx implements zzmy {
    private static final zzcl<Boolean> zza;
    private static final zzcl<Boolean> zzb;
    private static final zzcl<Boolean> zzc;
    private static final zzcl<Boolean> zzd;
    private static final zzcl<Boolean> zze;
    private static final zzcl<Boolean> zzf;
    private static final zzcl<Long> zzg;
    private static final zzcl<Boolean> zzh;
    private static final zzcl<Boolean> zzi;

    static {
        zzcr zzcr = new zzcr(zzcm.zza("com.google.android.gms.measurement"));
        zza = zzcr.zza("measurement.service.audience.scoped_filters_v27", true);
        zzb = zzcr.zza("measurement.service.audience.session_scoped_user_engagement", true);
        zzc = zzcr.zza("measurement.client.audience.scoped_engagement_removal_when_session_expired", true);
        zzd = zzcr.zza("measurement.service.audience.scoped_engagement_removal_when_session_expired", true);
        zze = zzcr.zza("measurement.service.audience.session_scoped_event_aggregates", true);
        zzf = zzcr.zza("measurement.service.audience.use_bundle_timestamp_for_property_filters", true);
        zzg = zzcr.zza("measurement.id.scoped_audience_filters", 0);
        zzh = zzcr.zza("measurement.service.audience.fix_prepending_previous_sequence_timestamp", true);
        zzi = zzcr.zza("measurement.service.audience.remove_disabled_session_scoped_user_engagement", false);
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

    public final boolean zzg() {
        return zzf.zzc().booleanValue();
    }

    public final boolean zzh() {
        return zzh.zzc().booleanValue();
    }

    public final boolean zzi() {
        return zzi.zzc().booleanValue();
    }
}
