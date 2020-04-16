package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzfd;
import com.google.android.gms.internal.measurement.zzkz;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
final class zzs {
    private zzbr.zzc zza;
    private Long zzb;
    private long zzc;
    private final /* synthetic */ zzn zzd;

    private zzs(zzn zzn) {
        this.zzd = zzn;
    }

    /* synthetic */ zzs(zzn zzn, zzq zzq) {
        this(zzn);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v0, resolved type: java.lang.String} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    public final zzbr.zzc zza(String str, zzbr.zzc zzc2) {
        String str2 = str;
        zzbr.zzc zzc3 = zzc2;
        String zzc4 = zzc2.zzc();
        List<zzbr.zze> zza2 = zzc2.zza();
        Long l = (Long) this.zzd.zzg().zzb(zzc3, "_eid");
        boolean z = l != null;
        if (z && zzc4.equals("_ep")) {
            String zzb2 = this.zzd.zzg().zzb(zzc3, "_en");
            if (TextUtils.isEmpty(zzb2)) {
                if (!zzkz.zzb() || !this.zzd.zzt().zzd(str2, zzap.zzcy)) {
                    this.zzd.zzr().zzf().zza("Extra parameter without an event name. eventId", l);
                } else {
                    this.zzd.zzr().zzg().zza("Extra parameter without an event name. eventId", l);
                }
                return null;
            }
            if (this.zza == null || this.zzb == null || l.longValue() != this.zzb.longValue()) {
                Pair<zzbr.zzc, Long> zza3 = this.zzd.zzi().zza(str2, l);
                if (zza3 == null || zza3.first == null) {
                    if (!zzkz.zzb() || !this.zzd.zzt().zzd(str2, zzap.zzcy)) {
                        this.zzd.zzr().zzf().zza("Extra parameter without existing main event. eventName, eventId", zzb2, l);
                    } else {
                        this.zzd.zzr().zzg().zza("Extra parameter without existing main event. eventName, eventId", zzb2, l);
                    }
                    return null;
                }
                this.zza = (zzbr.zzc) zza3.first;
                this.zzc = ((Long) zza3.second).longValue();
                this.zzb = (Long) this.zzd.zzg().zzb(this.zza, "_eid");
            }
            long j = this.zzc - 1;
            this.zzc = j;
            if (j <= 0) {
                zzac zzi = this.zzd.zzi();
                zzi.zzd();
                zzi.zzr().zzx().zza("Clearing complex main event info. appId", str2);
                try {
                    zzi.c_().execSQL("delete from main_event_params where app_id=?", new String[]{str2});
                } catch (SQLiteException e2) {
                    zzi.zzr().zzf().zza("Error clearing complex main event", e2);
                }
            } else {
                this.zzd.zzi().zza(str, l, this.zzc, this.zza);
            }
            List<zzbr.zze> arrayList = new ArrayList<>();
            for (zzbr.zze next : this.zza.zza()) {
                this.zzd.zzg();
                if (zzkw.zza(zzc3, next.zzb()) == null) {
                    arrayList.add(next);
                }
            }
            if (!arrayList.isEmpty()) {
                arrayList.addAll(zza2);
                zza2 = arrayList;
                zzc4 = zzb2;
            } else {
                if (!zzkz.zzb() || !this.zzd.zzt().zzd(str2, zzap.zzcy)) {
                    this.zzd.zzr().zzi().zza("No unique parameters in main event. eventName", zzb2);
                } else {
                    this.zzd.zzr().zzg().zza("No unique parameters in main event. eventName", zzb2);
                }
                zzc4 = zzb2;
            }
        } else if (z) {
            this.zzb = l;
            this.zza = zzc3;
            long j2 = 0L;
            Object zzb3 = this.zzd.zzg().zzb(zzc3, "_epc");
            if (zzb3 != null) {
                j2 = zzb3;
            }
            long longValue = ((Long) j2).longValue();
            this.zzc = longValue;
            if (longValue > 0) {
                this.zzd.zzi().zza(str, l, this.zzc, zzc2);
            } else if (!zzkz.zzb() || !this.zzd.zzt().zzd(str2, zzap.zzcy)) {
                this.zzd.zzr().zzi().zza("Complex event with zero extra param count. eventName", zzc4);
            } else {
                this.zzd.zzr().zzg().zza("Complex event with zero extra param count. eventName", zzc4);
            }
        }
        return (zzbr.zzc) ((zzfd) ((zzbr.zzc.zza) zzc2.zzbm()).zza(zzc4).zzc().zza((Iterable<? extends zzbr.zze>) zza2).zzu());
    }
}
