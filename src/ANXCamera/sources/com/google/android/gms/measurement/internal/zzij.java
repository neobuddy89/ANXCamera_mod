package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
final class zzij implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzhr zzb;

    zzij(zzhr zzhr, boolean z) {
        this.zzb = zzhr;
        this.zza = z;
    }

    public final void run() {
        boolean zzab = this.zzb.zzx.zzab();
        boolean zzaa = this.zzb.zzx.zzaa();
        this.zzb.zzx.zza(this.zza);
        if (zzaa == this.zza) {
            this.zzb.zzx.zzr().zzx().zza("Default data collection state already set to", Boolean.valueOf(this.zza));
        }
        if (this.zzb.zzx.zzab() == zzab || this.zzb.zzx.zzab() != this.zzb.zzx.zzaa()) {
            this.zzb.zzx.zzr().zzk().zza("Default data collection is different than actual status", Boolean.valueOf(this.zza), Boolean.valueOf(zzab));
        }
        this.zzb.zzam();
    }
}
