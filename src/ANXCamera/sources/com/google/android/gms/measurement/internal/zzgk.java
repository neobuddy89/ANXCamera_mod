package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzbj;
import com.google.android.gms.internal.measurement.zzbo;
import com.google.android.gms.internal.measurement.zzfd;
import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzju;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
public final class zzgk extends zzkp implements zzz {
    private static int zzb = 65535;
    private static int zzc = 2;
    private final Map<String, Map<String, String>> zzd = new ArrayMap();
    private final Map<String, Map<String, Boolean>> zze = new ArrayMap();
    private final Map<String, Map<String, Boolean>> zzf = new ArrayMap();
    private final Map<String, zzbo.zzb> zzg = new ArrayMap();
    private final Map<String, Map<String, Integer>> zzh = new ArrayMap();
    private final Map<String, String> zzi = new ArrayMap();

    zzgk(zzks zzks) {
        super(zzks);
    }

    private final zzbo.zzb zza(String str, byte[] bArr) {
        if (bArr == null) {
            return zzbo.zzb.zzj();
        }
        try {
            zzbo.zzb zzb2 = (zzbo.zzb) ((zzfd) ((zzbo.zzb.zza) zzkw.zza(zzbo.zzb.zzi(), bArr)).zzu());
            zzfl zzx = zzr().zzx();
            String str2 = null;
            Long valueOf = zzb2.zza() ? Long.valueOf(zzb2.zzb()) : null;
            if (zzb2.zzc()) {
                str2 = zzb2.zzd();
            }
            zzx.zza("Parsed config. version, gmp_app_id", valueOf, str2);
            return zzb2;
        } catch (zzfo e2) {
            zzr().zzi().zza("Unable to merge remote config. appId", zzfj.zza(str), e2);
            return zzbo.zzb.zzj();
        } catch (RuntimeException e3) {
            zzr().zzi().zza("Unable to merge remote config. appId", zzfj.zza(str), e3);
            return zzbo.zzb.zzj();
        }
    }

    private static Map<String, String> zza(zzbo.zzb zzb2) {
        ArrayMap arrayMap = new ArrayMap();
        if (zzb2 != null) {
            for (zzbo.zzc next : zzb2.zze()) {
                arrayMap.put(next.zza(), next.zzb());
            }
        }
        return arrayMap;
    }

    private final void zza(String str, zzbo.zzb.zza zza) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        if (zza != null) {
            for (int i = 0; i < zza.zza(); i++) {
                zzbo.zza.C0023zza zza2 = (zzbo.zza.C0023zza) zza.zza(i).zzbm();
                if (TextUtils.isEmpty(zza2.zza())) {
                    zzr().zzi().zza("EventConfig contained null event name");
                } else {
                    String zzb2 = zzhl.zzb(zza2.zza());
                    if (!TextUtils.isEmpty(zzb2)) {
                        zza2 = zza2.zza(zzb2);
                        zza.zza(i, zza2);
                    }
                    arrayMap.put(zza2.zza(), Boolean.valueOf(zza2.zzb()));
                    arrayMap2.put(zza2.zza(), Boolean.valueOf(zza2.zzc()));
                    if (zza2.zzd()) {
                        if (zza2.zze() < zzc || zza2.zze() > zzb) {
                            zzr().zzi().zza("Invalid sampling rate. Event name, sample rate", zza2.zza(), Integer.valueOf(zza2.zze()));
                        } else {
                            arrayMap3.put(zza2.zza(), Integer.valueOf(zza2.zze()));
                        }
                    }
                }
            }
        }
        this.zze.put(str, arrayMap);
        this.zzf.put(str, arrayMap2);
        this.zzh.put(str, arrayMap3);
    }

    private final void zzi(String str) {
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        if (this.zzg.get(str) == null) {
            byte[] zzd2 = zzi().zzd(str);
            if (zzd2 == null) {
                this.zzd.put(str, (Object) null);
                this.zze.put(str, (Object) null);
                this.zzf.put(str, (Object) null);
                this.zzg.put(str, (Object) null);
                this.zzi.put(str, (Object) null);
                this.zzh.put(str, (Object) null);
                return;
            }
            zzbo.zzb.zza zza = (zzbo.zzb.zza) zza(str, zzd2).zzbm();
            zza(str, zza);
            this.zzd.put(str, zza((zzbo.zzb) ((zzfd) zza.zzu())));
            this.zzg.put(str, (zzbo.zzb) ((zzfd) zza.zzu()));
            this.zzi.put(str, (Object) null);
        }
    }

    public final /* bridge */ /* synthetic */ zzn e_() {
        return super.e_();
    }

    /* access modifiers changed from: protected */
    public final zzbo.zzb zza(String str) {
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        zzi(str);
        return this.zzg.get(str);
    }

    public final String zza(String str, String str2) {
        zzd();
        zzi(str);
        Map map = this.zzd.get(str);
        if (map != null) {
            return (String) map.get(str2);
        }
        return null;
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    /* access modifiers changed from: protected */
    public final boolean zza(String str, byte[] bArr, String str2) {
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        zzbo.zzb.zza zza = (zzbo.zzb.zza) zza(str, bArr).zzbm();
        if (zza == null) {
            return false;
        }
        zza(str, zza);
        this.zzg.put(str, (zzbo.zzb) ((zzfd) zza.zzu()));
        this.zzi.put(str, str2);
        this.zzd.put(str, zza((zzbo.zzb) ((zzfd) zza.zzu())));
        zzi().zzb(str, (List<zzbj.zza>) new ArrayList(zza.zzb()));
        try {
            zza.zzc();
            bArr = ((zzbo.zzb) ((zzfd) zza.zzu())).zzbi();
        } catch (RuntimeException e2) {
            zzr().zzi().zza("Unable to serialize reduced-size config. Storing full config instead. appId", zzfj.zza(str), e2);
        }
        zzac zzi2 = zzi();
        Preconditions.checkNotEmpty(str);
        zzi2.zzd();
        zzi2.zzak();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        try {
            if (((long) zzi2.c_().update("apps", contentValues, "app_id = ?", new String[]{str})) == 0) {
                zzi2.zzr().zzf().zza("Failed to update remote config (got 0). appId", zzfj.zza(str));
            }
        } catch (SQLiteException e3) {
            zzi2.zzr().zzf().zza("Error storing remote config. appId", zzfj.zza(str), e3);
        }
        this.zzg.put(str, (zzbo.zzb) ((zzfd) zza.zzu()));
        return true;
    }

    /* access modifiers changed from: protected */
    public final String zzb(String str) {
        zzd();
        return this.zzi.get(str);
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzb(String str, String str2) {
        zzd();
        zzi(str);
        if (zzg(str) && zzla.zze(str2)) {
            return true;
        }
        if (zzh(str) && zzla.zza(str2)) {
            return true;
        }
        Map map = this.zze.get(str);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str2);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    /* access modifiers changed from: protected */
    public final void zzc(String str) {
        zzd();
        this.zzi.put(str, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzc(String str, String str2) {
        zzd();
        zzi(str);
        if (FirebaseAnalytics.Event.ECOMMERCE_PURCHASE.equals(str2)) {
            return true;
        }
        if (zzju.zzb() && zzt().zza(zzap.zzde) && (FirebaseAnalytics.Event.PURCHASE.equals(str2) || FirebaseAnalytics.Event.REFUND.equals(str2))) {
            return true;
        }
        Map map = this.zzf.get(str);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str2);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public final int zzd(String str, String str2) {
        zzd();
        zzi(str);
        Map map = this.zzh.get(str);
        if (map == null) {
            return 1;
        }
        Integer num = (Integer) map.get(str2);
        if (num == null) {
            return 1;
        }
        return num.intValue();
    }

    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    /* access modifiers changed from: package-private */
    public final void zzd(String str) {
        zzd();
        this.zzg.remove(str);
    }

    /* access modifiers changed from: protected */
    public final boolean zze() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean zze(String str) {
        zzd();
        zzbo.zzb zza = zza(str);
        if (zza == null) {
            return false;
        }
        return zza.zzh();
    }

    /* access modifiers changed from: package-private */
    public final long zzf(String str) {
        String zza = zza(str, "measurement.account.time_zone_offset_minutes");
        if (TextUtils.isEmpty(zza)) {
            return 0;
        }
        try {
            return Long.parseLong(zza);
        } catch (NumberFormatException e2) {
            zzr().zzi().zza("Unable to parse timezone offset. appId", zzfj.zza(str), e2);
            return 0;
        }
    }

    public final /* bridge */ /* synthetic */ zzkw zzg() {
        return super.zzg();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzg(String str) {
        return "1".equals(zza(str, "measurement.upload.blacklist_internal"));
    }

    /* access modifiers changed from: package-private */
    public final boolean zzh(String str) {
        return "1".equals(zza(str, "measurement.upload.blacklist_public"));
    }

    public final /* bridge */ /* synthetic */ zzac zzi() {
        return super.zzi();
    }

    public final /* bridge */ /* synthetic */ zzgk zzj() {
        return super.zzj();
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
}
