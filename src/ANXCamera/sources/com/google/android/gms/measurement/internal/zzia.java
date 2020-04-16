package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzle;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
final class zzia implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzhr zzb;

    zzia(zzhr zzhr, long j) {
        this.zzb = zzhr;
        this.zza = j;
    }

    public final void run() {
        zzhr zzhr = this.zzb;
        long j = this.zza;
        zzhr.zzd();
        zzhr.zzb();
        zzhr.zzw();
        zzhr.zzr().zzw().zza("Resetting analytics data (FE)");
        zzke zzk = zzhr.zzk();
        zzk.zzd();
        zzk.zzb.zza();
        boolean zzab = zzhr.zzx.zzab();
        zzfv zzs = zzhr.zzs();
        zzs.zzh.zza(j);
        if (!TextUtils.isEmpty(zzs.zzs().zzw.zza())) {
            zzs.zzw.zza((String) null);
        }
        if (zzle.zzb() && zzs.zzt().zza(zzap.zzcr)) {
            zzs.zzq.zza(0);
        }
        if (!zzs.zzt().zzh()) {
            zzs.zzc(!zzab);
        }
        zzhr.zzh().zzad();
        if (zzle.zzb() && zzhr.zzt().zza(zzap.zzcr)) {
            zzhr.zzk().zza.zza();
        }
        zzhr.zzb = !zzab;
        this.zzb.zzh().zza((AtomicReference<String>) new AtomicReference());
    }
}
