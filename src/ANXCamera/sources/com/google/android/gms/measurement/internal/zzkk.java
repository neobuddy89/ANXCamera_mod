package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzkn;
import com.google.android.gms.internal.measurement.zzle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
final class zzkk {
    private long zza;
    private long zzb;
    private final zzaf zzc = new zzkj(this, this.zzd.zzx);
    private final /* synthetic */ zzke zzd;

    public zzkk(zzke zzke) {
        this.zzd = zzke;
        long elapsedRealtime = zzke.zzm().elapsedRealtime();
        this.zza = elapsedRealtime;
        this.zzb = elapsedRealtime;
    }

    /* access modifiers changed from: private */
    public final void zzc() {
        this.zzd.zzd();
        zza(false, false, this.zzd.zzm().elapsedRealtime());
        this.zzd.zze().zza(this.zzd.zzm().elapsedRealtime());
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        this.zzc.zzc();
        this.zza = 0;
        this.zzb = 0;
    }

    /* access modifiers changed from: package-private */
    public final void zza(long j) {
        this.zzd.zzd();
        this.zzc.zzc();
        this.zza = j;
        this.zzb = j;
    }

    public final boolean zza(boolean z, boolean z2, long j) {
        this.zzd.zzd();
        this.zzd.zzw();
        if (!zzkn.zzb() || !this.zzd.zzt().zza(zzap.zzcv)) {
            j = this.zzd.zzm().elapsedRealtime();
        }
        if (!zzle.zzb() || !this.zzd.zzt().zza(zzap.zzcr) || this.zzd.zzx.zzab()) {
            this.zzd.zzs().zzq.zza(this.zzd.zzm().currentTimeMillis());
        }
        long j2 = j - this.zza;
        if (z || j2 >= 1000) {
            if (this.zzd.zzt().zza(zzap.zzbb) && !z2) {
                j2 = zzb();
            }
            this.zzd.zzs().zzr.zza(j2);
            this.zzd.zzr().zzx().zza("Recording user engagement, ms", Long.valueOf(j2));
            Bundle bundle = new Bundle();
            bundle.putLong("_et", j2);
            zziy.zza(this.zzd.zzi().zzab(), bundle, true);
            if (this.zzd.zzt().zza(zzap.zzbb) && !this.zzd.zzt().zza(zzap.zzbc) && z2) {
                bundle.putLong("_fr", 1);
            }
            if (!this.zzd.zzt().zza(zzap.zzbc) || !z2) {
                this.zzd.zzf().zza("auto", "_e", bundle);
            }
            this.zza = j;
            this.zzc.zzc();
            this.zzc.zza(Math.max(0, 3600000 - this.zzd.zzs().zzr.zza()));
            return true;
        }
        this.zzd.zzr().zzx().zza("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j2));
        return false;
    }

    /* access modifiers changed from: package-private */
    public final long zzb() {
        long elapsedRealtime = this.zzd.zzm().elapsedRealtime();
        long j = elapsedRealtime - this.zzb;
        this.zzb = elapsedRealtime;
        return j;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(long j) {
        this.zzc.zzc();
        if (this.zza != 0) {
            this.zzd.zzs().zzr.zza(this.zzd.zzs().zzr.zza() + (j - this.zza));
        }
    }
}
