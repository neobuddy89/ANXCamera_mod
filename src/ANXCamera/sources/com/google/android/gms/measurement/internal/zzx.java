package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MiuiSettings;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzjj;
import com.google.android.gms.internal.measurement.zzll;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
public final class zzx extends zzhh {
    private Boolean zza;
    private zzz zzb = zzaa.zza;
    private Boolean zzc;

    zzx(zzgq zzgq) {
        super(zzgq);
    }

    private final String zza(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke((Object) null, new Object[]{str, str2});
        } catch (ClassNotFoundException e2) {
            zzr().zzf().zza("Could not find SystemProperties class", e2);
            return str2;
        } catch (NoSuchMethodException e3) {
            zzr().zzf().zza("Could not find SystemProperties.get() method", e3);
            return str2;
        } catch (IllegalAccessException e4) {
            zzr().zzf().zza("Could not access SystemProperties.get()", e4);
            return str2;
        } catch (InvocationTargetException e5) {
            zzr().zzf().zza("SystemProperties.get() threw an exception", e5);
            return str2;
        }
    }

    public static long zzk() {
        return zzap.zzac.zza(null).longValue();
    }

    public static long zzv() {
        return zzap.zzc.zza(null).longValue();
    }

    private final Bundle zzz() {
        try {
            if (zzn().getPackageManager() == null) {
                zzr().zzf().zza("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = Wrappers.packageManager(zzn()).getApplicationInfo(zzn().getPackageName(), 128);
            if (applicationInfo != null) {
                return applicationInfo.metaData;
            }
            zzr().zzf().zza("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (PackageManager.NameNotFoundException e2) {
            zzr().zzf().zza("Failed to load metadata: Package name not found", e2);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final int zza(String str) {
        return (!zzjj.zzb() || !zzd((String) null, zzap.zzdf)) ? MiuiSettings.System.SCREEN_KEY_LONG_PRESS_TIMEOUT_DEFAULT : zza(str, zzap.zzag, MiuiSettings.System.SCREEN_KEY_LONG_PRESS_TIMEOUT_DEFAULT, 2000);
    }

    public final int zza(String str, zzfc<Integer> zzfc, int i, int i2) {
        return Math.max(Math.min(zzb(str, zzfc), i2), i);
    }

    public final long zza(String str, zzfc<Long> zzfc) {
        if (str == null) {
            return zzfc.zza(null).longValue();
        }
        String zza2 = this.zzb.zza(str, zzfc.zza());
        if (TextUtils.isEmpty(zza2)) {
            return zzfc.zza(null).longValue();
        }
        try {
            return zzfc.zza(Long.valueOf(Long.parseLong(zza2))).longValue();
        } catch (NumberFormatException e2) {
            return zzfc.zza(null).longValue();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002d, code lost:
        if (android.text.TextUtils.isEmpty(r1) != false) goto L_0x002f;
     */
    public final String zza(zzg zzg) {
        Uri.Builder builder = new Uri.Builder();
        String zze = zzg.zze();
        if (TextUtils.isEmpty(zze)) {
            if (zzll.zzb() && zzt().zzd(zzg.zzc(), zzap.zzch)) {
                zze = zzg.zzg();
            }
            zze = zzg.zzf();
        }
        Uri.Builder encodedAuthority = builder.scheme(zzap.zzd.zza(null)).encodedAuthority(zzap.zze.zza(null));
        String valueOf = String.valueOf(zze);
        encodedAuthority.path(valueOf.length() != 0 ? "config/app/".concat(valueOf) : new String("config/app/")).appendQueryParameter("app_instance_id", zzg.zzd()).appendQueryParameter("platform", "android").appendQueryParameter("gmp_version", String.valueOf(zzf()));
        return builder.build().toString();
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzz zzz) {
        this.zzb = zzz;
    }

    public final boolean zza(zzfc<Boolean> zzfc) {
        return zzd((String) null, zzfc);
    }

    public final int zzb(String str) {
        return zzb(str, zzap.zzn);
    }

    public final int zzb(String str, zzfc<Integer> zzfc) {
        if (str == null) {
            return zzfc.zza(null).intValue();
        }
        String zza2 = this.zzb.zza(str, zzfc.zza());
        if (TextUtils.isEmpty(zza2)) {
            return zzfc.zza(null).intValue();
        }
        try {
            return zzfc.zza(Integer.valueOf(Integer.parseInt(zza2))).intValue();
        } catch (NumberFormatException e2) {
            return zzfc.zza(null).intValue();
        }
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    public final double zzc(String str, zzfc<Double> zzfc) {
        if (str == null) {
            return zzfc.zza(null).doubleValue();
        }
        String zza2 = this.zzb.zza(str, zzfc.zza());
        if (TextUtils.isEmpty(zza2)) {
            return zzfc.zza(null).doubleValue();
        }
        try {
            return zzfc.zza(Double.valueOf(Double.parseDouble(zza2))).doubleValue();
        } catch (NumberFormatException e2) {
            return zzfc.zza(null).doubleValue();
        }
    }

    /* access modifiers changed from: package-private */
    public final int zzc(String str) {
        if (!zzjj.zzb() || !zzd((String) null, zzap.zzdf)) {
            return 25;
        }
        return zza(str, zzap.zzaf, 25, 100);
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    /* access modifiers changed from: package-private */
    public final Boolean zzd(String str) {
        Preconditions.checkNotEmpty(str);
        Bundle zzz = zzz();
        if (zzz == null) {
            zzr().zzf().zza("Failed to load metadata: Metadata bundle is null");
            return null;
        } else if (!zzz.containsKey(str)) {
            return null;
        } else {
            return Boolean.valueOf(zzz.getBoolean(str));
        }
    }

    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    public final boolean zzd(String str, zzfc<Boolean> zzfc) {
        if (str == null) {
            return zzfc.zza(null).booleanValue();
        }
        String zza2 = this.zzb.zza(str, zzfc.zza());
        return TextUtils.isEmpty(zza2) ? zzfc.zza(null).booleanValue() : zzfc.zza(Boolean.valueOf(Boolean.parseBoolean(zza2))).booleanValue();
    }

    public final int zze() {
        return (!zzjj.zzb() || !zzt().zzd((String) null, zzap.zzdg) || zzp().zzj() < 2147483) ? 25 : 100;
    }

    /* access modifiers changed from: package-private */
    public final List<String> zze(String str) {
        Integer num;
        Preconditions.checkNotEmpty(str);
        Bundle zzz = zzz();
        if (zzz == null) {
            zzr().zzf().zza("Failed to load metadata: Metadata bundle is null");
            num = null;
        } else {
            num = !zzz.containsKey(str) ? null : Integer.valueOf(zzz.getInt(str));
        }
        if (num == null) {
            return null;
        }
        try {
            String[] stringArray = zzn().getResources().getStringArray(num.intValue());
            if (stringArray == null) {
                return null;
            }
            return Arrays.asList(stringArray);
        } catch (Resources.NotFoundException e2) {
            zzr().zzf().zza("Failed to load string array from metadata: resource not found", e2);
            return null;
        }
    }

    public final boolean zze(String str, zzfc<Boolean> zzfc) {
        return zzd(str, zzfc);
    }

    public final long zzf() {
        zzu();
        return 25001;
    }

    public final boolean zzf(String str) {
        return "1".equals(this.zzb.zza(str, "gaia_collection_enabled"));
    }

    public final boolean zzg() {
        if (this.zzc == null) {
            synchronized (this) {
                if (this.zzc == null) {
                    ApplicationInfo applicationInfo = zzn().getApplicationInfo();
                    String myProcessName = ProcessUtils.getMyProcessName();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.zzc = Boolean.valueOf(str != null && str.equals(myProcessName));
                    }
                    if (this.zzc == null) {
                        this.zzc = Boolean.TRUE;
                        zzr().zzf().zza("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.zzc.booleanValue();
    }

    public final boolean zzg(String str) {
        return "1".equals(this.zzb.zza(str, "measurement.event_sampling_enabled"));
    }

    public final boolean zzh() {
        zzu();
        Boolean zzd = zzd("firebase_analytics_collection_deactivated");
        return zzd != null && zzd.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzh(String str) {
        return zzd(str, zzap.zzaj);
    }

    public final Boolean zzi() {
        zzu();
        return zzd("firebase_analytics_collection_enabled");
    }

    /* access modifiers changed from: package-private */
    public final String zzi(String str) {
        zzfc<String> zzfc = zzap.zzak;
        return str == null ? zzfc.zza(null) : zzfc.zza(this.zzb.zza(str, zzfc.zza()));
    }

    public final Boolean zzj() {
        zzb();
        Boolean zzd = zzd("google_analytics_adid_collection_enabled");
        return Boolean.valueOf(zzd == null || zzd.booleanValue());
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

    public final String zzw() {
        return zza("debug.firebase.analytics.app", "");
    }

    public final String zzx() {
        return zza("debug.deferred.deeplink", "");
    }

    /* access modifiers changed from: package-private */
    public final boolean zzy() {
        if (this.zza == null) {
            Boolean zzd = zzd("app_measurement_lite");
            this.zza = zzd;
            if (zzd == null) {
                this.zza = false;
            }
        }
        return this.zza.booleanValue() || !this.zzx.zzt();
    }
}
