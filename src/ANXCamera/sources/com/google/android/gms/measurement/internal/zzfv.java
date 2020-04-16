package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.android.camera.module.loader.FunctionParseBeautyBodySlimCount;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
final class zzfv extends zzhk {
    static final Pair<String, Long> zza = new Pair<>("", 0L);
    private boolean zzaa;
    private long zzab;
    public zzfz zzb;
    public final zzga zzc = new zzga(this, "last_upload", 0);
    public final zzga zzd = new zzga(this, "last_upload_attempt", 0);
    public final zzga zze = new zzga(this, "backoff", 0);
    public final zzga zzf = new zzga(this, "last_delete_stale", 0);
    public final zzga zzg = new zzga(this, "midnight_offset", 0);
    public final zzga zzh = new zzga(this, "first_open_time", 0);
    public final zzga zzi = new zzga(this, "app_install_time", 0);
    public final zzgc zzj = new zzgc(this, "app_instance_id", (String) null);
    public final zzga zzk = new zzga(this, "time_before_start", FunctionParseBeautyBodySlimCount.TIP_INTERVAL_TIME);
    public final zzga zzl = new zzga(this, "session_timeout", 1800000);
    public final zzfx zzm = new zzfx(this, "start_new_session", true);
    public final zzgc zzn = new zzgc(this, "non_personalized_ads", (String) null);
    public final zzfx zzo = new zzfx(this, "use_dynamite_api", false);
    public final zzfx zzp = new zzfx(this, "allow_remote_dynamite", false);
    public final zzga zzq = new zzga(this, "last_pause_time", 0);
    public final zzga zzr = new zzga(this, "time_active", 0);
    public boolean zzs;
    public zzfx zzt = new zzfx(this, "app_backgrounded", false);
    public zzfx zzu = new zzfx(this, "deep_link_retrieval_complete", false);
    public zzga zzv = new zzga(this, "deep_link_retrieval_attempts", 0);
    public final zzgc zzw = new zzgc(this, "firebase_feature_rollouts", (String) null);
    private SharedPreferences zzy;
    private String zzz;

    zzfv(zzgq zzgq) {
        super(zzgq);
    }

    /* access modifiers changed from: protected */
    public final void f_() {
        SharedPreferences sharedPreferences = zzn().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.zzy = sharedPreferences;
        boolean z = sharedPreferences.getBoolean("has_been_opened", false);
        this.zzs = z;
        if (!z) {
            SharedPreferences.Editor edit = this.zzy.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
        zzfz zzfz = new zzfz(this, "health_monitor", Math.max(0, zzap.zzb.zza(null).longValue()));
        this.zzb = zzfz;
    }

    /* access modifiers changed from: package-private */
    public final Pair<String, Boolean> zza(String str) {
        zzd();
        long elapsedRealtime = zzm().elapsedRealtime();
        if (this.zzz != null && elapsedRealtime < this.zzab) {
            return new Pair<>(this.zzz, Boolean.valueOf(this.zzaa));
        }
        this.zzab = elapsedRealtime + zzt().zza(str, zzap.zza);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(zzn());
            if (advertisingIdInfo != null) {
                this.zzz = advertisingIdInfo.getId();
                this.zzaa = advertisingIdInfo.isLimitAdTrackingEnabled();
            }
            if (this.zzz == null) {
                this.zzz = "";
            }
        } catch (Exception e2) {
            zzr().zzw().zza("Unable to get advertising id", e2);
            this.zzz = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair<>(this.zzz, Boolean.valueOf(this.zzaa));
    }

    /* access modifiers changed from: package-private */
    public final void zza(boolean z) {
        zzd();
        SharedPreferences.Editor edit = zzg().edit();
        edit.putBoolean("use_service", z);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(long j) {
        return j - this.zzl.zza() > this.zzq.zza();
    }

    /* access modifiers changed from: package-private */
    public final String zzb(String str) {
        zzd();
        String str2 = (String) zza(str).first;
        MessageDigest zzi2 = zzla.zzi();
        if (zzi2 == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, zzi2.digest(str2.getBytes()))});
    }

    /* access modifiers changed from: package-private */
    public final void zzb(boolean z) {
        zzd();
        SharedPreferences.Editor edit = zzg().edit();
        edit.putBoolean("measurement_enabled", z);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public final void zzc(String str) {
        zzd();
        SharedPreferences.Editor edit = zzg().edit();
        edit.putString("gmp_app_id", str);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public final void zzc(boolean z) {
        zzd();
        zzr().zzx().zza("App measurement setting deferred collection", Boolean.valueOf(z));
        SharedPreferences.Editor edit = zzg().edit();
        edit.putBoolean("deferred_analytics_collection", z);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public final void zzd(String str) {
        zzd();
        SharedPreferences.Editor edit = zzg().edit();
        edit.putString("admob_app_id", str);
        edit.apply();
    }

    /* access modifiers changed from: protected */
    public final boolean zze() {
        return true;
    }

    /* access modifiers changed from: protected */
    public final SharedPreferences zzg() {
        zzd();
        zzaa();
        return this.zzy;
    }

    /* access modifiers changed from: package-private */
    public final String zzh() {
        zzd();
        return zzg().getString("gmp_app_id", (String) null);
    }

    /* access modifiers changed from: package-private */
    public final String zzi() {
        zzd();
        return zzg().getString("admob_app_id", (String) null);
    }

    /* access modifiers changed from: package-private */
    public final Boolean zzj() {
        zzd();
        if (!zzg().contains("use_service")) {
            return null;
        }
        return Boolean.valueOf(zzg().getBoolean("use_service", false));
    }

    /* access modifiers changed from: package-private */
    public final void zzk() {
        zzd();
        Boolean zzv2 = zzv();
        SharedPreferences.Editor edit = zzg().edit();
        edit.clear();
        edit.apply();
        if (zzv2 != null) {
            zzb(zzv2.booleanValue());
        }
    }

    /* access modifiers changed from: package-private */
    public final Boolean zzv() {
        zzd();
        if (zzg().contains("measurement_enabled")) {
            return Boolean.valueOf(zzg().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final String zzw() {
        zzd();
        String string = zzg().getString("previous_os_version", (String) null);
        zzl().zzaa();
        String str = Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(str) && !str.equals(string)) {
            SharedPreferences.Editor edit = zzg().edit();
            edit.putString("previous_os_version", str);
            edit.apply();
        }
        return string;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzx() {
        return this.zzy.contains("deferred_analytics_collection");
    }
}
