package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
public final class zznd implements zzne {
    private static final zzcl<Boolean> zza;
    private static final zzcl<Boolean> zzb;
    private static final zzcl<Boolean> zzc;
    private static final zzcl<Boolean> zzd;

    static {
        zzcr zzcr = new zzcr(zzcm.zza("com.google.android.gms.measurement"));
        zza = zzcr.zza("measurement.client.sessions.background_sessions_enabled", true);
        zzb = zzcr.zza("measurement.client.sessions.immediate_start_enabled_foreground", true);
        zzc = zzcr.zza("measurement.client.sessions.remove_expired_session_properties_enabled", true);
        zzd = zzcr.zza("measurement.client.sessions.session_id_enabled", true);
    }

    public final boolean zza() {
        return zza.zzc().booleanValue();
    }

    public final boolean zzb() {
        return zzc.zzc().booleanValue();
    }

    public final boolean zzc() {
        return zzd.zzc().booleanValue();
    }
}
