package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
public final class zzak {
    final String zza;
    final String zzb;
    final long zzc;
    final long zzd;
    final zzam zze;
    private final String zzf;

    zzak(zzgq zzgq, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        zzam zzam;
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        this.zza = str2;
        this.zzb = str3;
        this.zzf = TextUtils.isEmpty(str) ? null : str;
        this.zzc = j;
        this.zzd = j2;
        if (j2 != 0 && j2 > j) {
            zzgq.zzr().zzi().zza("Event created with reverse previous/current timestamps. appId", zzfj.zza(str2));
        }
        if (bundle == null || bundle.isEmpty()) {
            zzam = new zzam(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String str4 = (String) it.next();
                if (str4 == null) {
                    zzgq.zzr().zzf().zza("Param name can't be null");
                    it.remove();
                } else {
                    Object zza2 = zzgq.zzi().zza(str4, bundle2.get(str4));
                    if (zza2 == null) {
                        zzgq.zzr().zzi().zza("Param value can't be null", zzgq.zzj().zzb(str4));
                        it.remove();
                    } else {
                        zzgq.zzi().zza(bundle2, str4, zza2);
                    }
                }
            }
            zzam = new zzam(bundle2);
        }
        this.zze = zzam;
    }

    private zzak(zzgq zzgq, String str, String str2, String str3, long j, long j2, zzam zzam) {
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzam);
        this.zza = str2;
        this.zzb = str3;
        this.zzf = TextUtils.isEmpty(str) ? null : str;
        this.zzc = j;
        this.zzd = j2;
        if (j2 != 0 && j2 > j) {
            zzgq.zzr().zzi().zza("Event created with reverse previous/current timestamps. appId, name", zzfj.zza(str2), zzfj.zza(str3));
        }
        this.zze = zzam;
    }

    public final String toString() {
        String str = this.zza;
        String str2 = this.zzb;
        String valueOf = String.valueOf(this.zze);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 33 + String.valueOf(str2).length() + String.valueOf(valueOf).length());
        sb.append("Event{appId='");
        sb.append(str);
        sb.append("', name='");
        sb.append(str2);
        sb.append("', params=");
        sb.append(valueOf);
        sb.append('}');
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final zzak zza(zzgq zzgq, long j) {
        zzak zzak = new zzak(zzgq, this.zzf, this.zza, this.zzb, this.zzc, j, this.zze);
        return zzak;
    }
}
