package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzj;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
public final class zzke extends zze {
    protected zzkm zza = new zzkm(this);
    protected zzkk zzb = new zzkk(this);
    /* access modifiers changed from: private */
    public Handler zzc;
    private zzkf zzd = new zzkf(this);

    zzke(zzgq zzgq) {
        super(zzgq);
    }

    /* access modifiers changed from: private */
    public final void zza(long j) {
        zzd();
        zzac();
        zzr().zzx().zza("Activity resumed, time", Long.valueOf(j));
        this.zzd.zza();
        this.zzb.zza(j);
        zzkm zzkm = this.zza;
        zzkm.zza.zzd();
        if (zzkm.zza.zzx.zzab()) {
            if (zzkm.zza.zzt().zza(zzap.zzav)) {
                zzkm.zza.zzs().zzt.zza(false);
            }
            zzkm.zza(zzkm.zza.zzm().currentTimeMillis(), false);
        }
    }

    /* access modifiers changed from: private */
    public final void zzac() {
        zzd();
        if (this.zzc == null) {
            this.zzc = new zzj(Looper.getMainLooper());
        }
    }

    /* access modifiers changed from: private */
    public final void zzb(long j) {
        zzd();
        zzac();
        zzr().zzx().zza("Activity paused, time", Long.valueOf(j));
        this.zzd.zzb();
        this.zzb.zzb(j);
        zzkm zzkm = this.zza;
        if (zzkm.zza.zzt().zza(zzap.zzav)) {
            zzkm.zza.zzs().zzt.zza(true);
        }
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    public final boolean zza(boolean z, boolean z2, long j) {
        return this.zzb.zza(z, z2, j);
    }

    /* access modifiers changed from: protected */
    public final void zzab() {
        zzq().zza((Runnable) new zzkd(this, zzm().elapsedRealtime()));
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
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
