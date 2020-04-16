package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
public final class zziy extends zze {
    protected zziv zza;
    private volatile zziv zzb;
    private zziv zzc;
    private final Map<Activity, zziv> zzd = new ConcurrentHashMap();
    private zziv zze;
    private String zzf;

    public zziy(zzgq zzgq) {
        super(zzgq);
    }

    private static String zza(String str) {
        String[] split = str.split("\\.");
        String str2 = split.length > 0 ? split[split.length - 1] : "";
        return str2.length() > 100 ? str2.substring(0, 100) : str2;
    }

    private final void zza(Activity activity, zziv zziv, boolean z) {
        zziv zziv2 = this.zzb == null ? this.zzc : this.zzb;
        zziv zziv3 = zziv.zzb == null ? new zziv(zziv.zza, zza(activity.getClass().getCanonicalName()), zziv.zzc) : zziv;
        this.zzc = this.zzb;
        this.zzb = zziv3;
        long elapsedRealtime = zzm().elapsedRealtime();
        zzgj zzq = zzq();
        zzix zzix = new zzix(this, z, elapsedRealtime, zziv2, zziv3);
        zzq.zza((Runnable) zzix);
    }

    public static void zza(zziv zziv, Bundle bundle, boolean z) {
        if (bundle != null && zziv != null && (!bundle.containsKey("_sc") || z)) {
            if (zziv.zza != null) {
                bundle.putString("_sn", zziv.zza);
            } else {
                bundle.remove("_sn");
            }
            bundle.putString("_sc", zziv.zzb);
            bundle.putLong("_si", zziv.zzc);
        } else if (bundle != null && zziv == null && z) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    /* access modifiers changed from: private */
    public final void zza(zziv zziv, boolean z, long j) {
        zze().zza(zzm().elapsedRealtime());
        if (zzk().zza(zziv.zzd, z, j)) {
            zziv.zzd = false;
        }
    }

    private final zziv zzd(Activity activity) {
        Preconditions.checkNotNull(activity);
        zziv zziv = this.zzd.get(activity);
        if (zziv != null) {
            return zziv;
        }
        zziv zziv2 = new zziv((String) null, zza(activity.getClass().getCanonicalName()), zzp().zzg());
        this.zzd.put(activity, zziv2);
        return zziv2;
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    public final void zza(Activity activity) {
        zza(activity, zzd(activity), false);
        zzb zze2 = zze();
        zze2.zzq().zza((Runnable) new zzc(zze2, zze2.zzm().elapsedRealtime()));
    }

    public final void zza(Activity activity, Bundle bundle) {
        if (bundle != null) {
            Bundle bundle2 = bundle.getBundle("com.google.app_measurement.screen_service");
            if (bundle2 != null) {
                this.zzd.put(activity, new zziv(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME), bundle2.getString("referrer_name"), bundle2.getLong("id")));
            }
        }
    }

    public final void zza(Activity activity, String str, String str2) {
        if (this.zzb == null) {
            zzr().zzk().zza("setCurrentScreen cannot be called while no activity active");
        } else if (this.zzd.get(activity) == null) {
            zzr().zzk().zza("setCurrentScreen must be called with an activity in the activity lifecycle");
        } else {
            if (str2 == null) {
                str2 = zza(activity.getClass().getCanonicalName());
            }
            boolean equals = this.zzb.zzb.equals(str2);
            boolean zzc2 = zzla.zzc(this.zzb.zza, str);
            if (equals && zzc2) {
                zzr().zzk().zza("setCurrentScreen cannot be called with the same class and name");
            } else if (str != null && (str.length() <= 0 || str.length() > 100)) {
                zzr().zzk().zza("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            } else if (str2 == null || (str2.length() > 0 && str2.length() <= 100)) {
                zzr().zzx().zza("Setting current screen to name, class", str == null ? "null" : str, str2);
                zziv zziv = new zziv(str, str2, zzp().zzg());
                this.zzd.put(activity, zziv);
                zza(activity, zziv, true);
            } else {
                zzr().zzk().zza("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            }
        }
    }

    public final void zza(String str, zziv zziv) {
        zzd();
        synchronized (this) {
            if (this.zzf == null || this.zzf.equals(str) || zziv != null) {
                this.zzf = str;
                this.zze = zziv;
            }
        }
    }

    public final zziv zzab() {
        zzw();
        zzd();
        return this.zza;
    }

    public final zziv zzac() {
        zzb();
        return this.zzb;
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    public final void zzb(Activity activity) {
        zziv zzd2 = zzd(activity);
        this.zzc = this.zzb;
        this.zzb = null;
        zzq().zza((Runnable) new zzja(this, zzd2, zzm().elapsedRealtime()));
    }

    public final void zzb(Activity activity, Bundle bundle) {
        if (bundle != null) {
            zziv zziv = this.zzd.get(activity);
            if (zziv != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putLong("id", zziv.zzc);
                bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.NAME, zziv.zza);
                bundle2.putString("referrer_name", zziv.zzb);
                bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    public final void zzc(Activity activity) {
        this.zzd.remove(activity);
    }

    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    public final /* bridge */ /* synthetic */ zzb zze() {
        return super.zze();
    }

    public final /* bridge */ /* synthetic */ zzhr zzf() {
        return super.zzf();
    }

    public final /* bridge */ /* synthetic */ zzfg zzg() {
        return super.zzg();
    }

    public final /* bridge */ /* synthetic */ zziz zzh() {
        return super.zzh();
    }

    public final /* bridge */ /* synthetic */ zziy zzi() {
        return super.zzi();
    }

    public final /* bridge */ /* synthetic */ zzff zzj() {
        return super.zzj();
    }

    public final /* bridge */ /* synthetic */ zzke zzk() {
        return super.zzk();
    }

    public final /* bridge */ /* synthetic */ zzah zzl() {
        return super.zzl();
    }

    public final /* bridge */ /* synthetic */ Clock zzm() {
        return super.zzm();
    }

    public final /* bridge */ /* synthetic */ Context zzn() {
        return super.zzn();
    }

    public final /* bridge */ /* synthetic */ zzfh zzo() {
        return super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzla zzp() {
        return super.zzp();
    }

    public final /* bridge */ /* synthetic */ zzgj zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ zzfj zzr() {
        return super.zzr();
    }

    public final /* bridge */ /* synthetic */ zzfv zzs() {
        return super.zzs();
    }

    public final /* bridge */ /* synthetic */ zzx zzt() {
        return super.zzt();
    }

    public final /* bridge */ /* synthetic */ zzw zzu() {
        return super.zzu();
    }

    /* access modifiers changed from: protected */
    public final boolean zzz() {
        return false;
    }
}
