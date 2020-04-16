package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
final class zzai implements Runnable {
    private final /* synthetic */ zzhj zza;
    private final /* synthetic */ zzaf zzb;

    zzai(zzaf zzaf, zzhj zzhj) {
        this.zzb = zzaf;
        this.zza = zzhj;
    }

    public final void run() {
        this.zza.zzu();
        if (zzw.zza()) {
            this.zza.zzq().zza((Runnable) this);
            return;
        }
        boolean zzb2 = this.zzb.zzb();
        long unused = this.zzb.zzd = 0;
        if (zzb2) {
            this.zzb.zza();
        }
    }
}
