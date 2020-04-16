package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
final class zzgf implements Runnable {
    private final /* synthetic */ zzgq zza;
    private final /* synthetic */ zzfj zzb;

    zzgf(zzgg zzgg, zzgq zzgq, zzfj zzfj) {
        this.zza = zzgq;
        this.zzb = zzfj;
    }

    public final void run() {
        if (this.zza.zzf() == null) {
            this.zzb.zzf().zza("Install Referrer Reporter is null");
        } else {
            this.zza.zzf().zza();
        }
    }
}
