package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzkb;
import com.google.android.gms.internal.measurement.zzle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
final class zzkm {
    final /* synthetic */ zzke zza;

    zzkm(zzke zzke) {
        this.zza = zzke;
    }

    private final void zzb(long j, boolean z) {
        this.zza.zzd();
        if (zzle.zzb() && this.zza.zzt().zza(zzap.zzaz)) {
            if (this.zza.zzx.zzab()) {
                this.zza.zzs().zzq.zza(j);
            } else {
                return;
            }
        }
        this.zza.zzr().zzx().zza("Session started, time", Long.valueOf(this.zza.zzm().elapsedRealtime()));
        Long l = null;
        if (this.zza.zzt().zza(zzap.zzas)) {
            l = Long.valueOf(j / 1000);
        }
        this.zza.zzf().zza("auto", "_sid", (Object) l, j);
        this.zza.zzs().zzm.zza(false);
        Bundle bundle = new Bundle();
        if (this.zza.zzt().zza(zzap.zzas)) {
            bundle.putLong("_sid", l.longValue());
        }
        if (this.zza.zzt().zza(zzap.zzcj) && z) {
            bundle.putLong("_aib", 1);
        }
        this.zza.zzf().zza("auto", "_s", j, bundle);
        if (zzkb.zzb() && this.zza.zzt().zza(zzap.zzcq)) {
            String zza2 = this.zza.zzs().zzw.zza();
            if (!TextUtils.isEmpty(zza2)) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("_ffr", zza2);
                this.zza.zzf().zza("auto", "_ssr", j, bundle2);
            }
        }
        if (!zzle.zzb() || !this.zza.zzt().zza(zzap.zzaz)) {
            this.zza.zzs().zzq.zza(j);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        if (zzle.zzb() && this.zza.zzt().zza(zzap.zzaz)) {
            this.zza.zzd();
            if (this.zza.zzs().zza(this.zza.zzm().currentTimeMillis())) {
                this.zza.zzs().zzm.zza(true);
                if (Build.VERSION.SDK_INT >= 16) {
                    ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                    ActivityManager.getMyMemoryState(runningAppProcessInfo);
                    if (runningAppProcessInfo.importance == 100) {
                        this.zza.zzr().zzx().zza("Detected application was in foreground");
                        zzb(this.zza.zzm().currentTimeMillis(), false);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(long j, boolean z) {
        this.zza.zzd();
        this.zza.zzac();
        if (this.zza.zzs().zza(j)) {
            this.zza.zzs().zzm.zza(true);
            this.zza.zzs().zzr.zza(0);
        }
        if (z && this.zza.zzt().zza(zzap.zzau)) {
            this.zza.zzs().zzq.zza(j);
        }
        if (this.zza.zzs().zzm.zza()) {
            zzb(j, z);
        }
    }
}
