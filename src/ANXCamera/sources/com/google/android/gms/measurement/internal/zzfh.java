package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import com.adobe.xmp.XMPConst;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzju;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
public final class zzfh extends zzhk {
    private static final AtomicReference<String[]> zza = new AtomicReference<>();
    private static final AtomicReference<String[]> zzb = new AtomicReference<>();
    private static final AtomicReference<String[]> zzc = new AtomicReference<>();

    zzfh(zzgq zzgq) {
        super(zzgq);
    }

    private final String zza(zzam zzam) {
        if (zzam == null) {
            return null;
        }
        return !zzg() ? zzam.toString() : zza(zzam.zzb());
    }

    private static String zza(String str, String[] strArr, String[] strArr2, AtomicReference<String[]> atomicReference) {
        String str2;
        Preconditions.checkNotNull(strArr);
        Preconditions.checkNotNull(strArr2);
        Preconditions.checkNotNull(atomicReference);
        Preconditions.checkArgument(strArr.length == strArr2.length);
        for (int i = 0; i < strArr.length; i++) {
            if (zzla.zzc(str, strArr[i])) {
                synchronized (atomicReference) {
                    String[] strArr3 = atomicReference.get();
                    if (strArr3 == null) {
                        strArr3 = new String[strArr2.length];
                        atomicReference.set(strArr3);
                    }
                    if (strArr3[i] == null) {
                        strArr3[i] = strArr2[i] + "(" + strArr[i] + ")";
                    }
                    str2 = strArr3[i];
                }
                return str2;
            }
        }
        return str;
    }

    private final String zza(Object[] objArr) {
        if (objArr == null) {
            return XMPConst.ARRAY_ITEM_NAME;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Bundle bundle : objArr) {
            String zza2 = bundle instanceof Bundle ? zza(bundle) : String.valueOf(bundle);
            if (zza2 != null) {
                if (sb.length() != 1) {
                    sb.append(", ");
                }
                sb.append(zza2);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private final boolean zzg() {
        zzu();
        return this.zzx.zzl() && this.zzx.zzr().zza(3);
    }

    /* access modifiers changed from: protected */
    public final String zza(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        if (!zzg()) {
            return bundle.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Bundle[{");
        for (String str : bundle.keySet()) {
            if (sb.length() != 8) {
                sb.append(", ");
            }
            sb.append(zzb(str));
            sb.append("=");
            if (!zzju.zzb() || !zzt().zza(zzap.zzcz)) {
                sb.append(bundle.get(str));
            } else {
                Object obj = bundle.get(str);
                sb.append(obj instanceof Bundle ? zza(new Object[]{obj}) : obj instanceof Object[] ? zza((Object[]) obj) : obj instanceof ArrayList ? zza(((ArrayList) obj).toArray()) : String.valueOf(obj));
            }
        }
        sb.append("}]");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public final String zza(zzak zzak) {
        if (zzak == null) {
            return null;
        }
        if (!zzg()) {
            return zzak.toString();
        }
        return "Event{appId='" + zzak.zza + "', name='" + zza(zzak.zzb) + "', params=" + zza(zzak.zze) + "}";
    }

    /* access modifiers changed from: protected */
    public final String zza(zzan zzan) {
        if (zzan == null) {
            return null;
        }
        if (!zzg()) {
            return zzan.toString();
        }
        return "origin=" + zzan.zzc + ",name=" + zza(zzan.zza) + ",params=" + zza(zzan.zzb);
    }

    /* access modifiers changed from: protected */
    public final String zza(String str) {
        if (str == null) {
            return null;
        }
        return !zzg() ? str : zza(str, zzhl.zzb, zzhl.zza, zza);
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    /* access modifiers changed from: protected */
    public final String zzb(String str) {
        if (str == null) {
            return null;
        }
        return !zzg() ? str : zza(str, zzho.zzb, zzho.zza, zzb);
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    /* access modifiers changed from: protected */
    public final String zzc(String str) {
        if (str == null) {
            return null;
        }
        if (!zzg()) {
            return str;
        }
        if (!str.startsWith("_exp_")) {
            return zza(str, zzhn.zzb, zzhn.zza, zzc);
        }
        return "experiment_id" + "(" + str + ")";
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    /* access modifiers changed from: protected */
    public final boolean zze() {
        return false;
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
