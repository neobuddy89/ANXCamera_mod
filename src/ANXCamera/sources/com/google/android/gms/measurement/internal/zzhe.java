package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
final class zzhe implements Runnable {
    private final /* synthetic */ zzkz zza;
    private final /* synthetic */ zzm zzb;
    private final /* synthetic */ zzgr zzc;

    zzhe(zzgr zzgr, zzkz zzkz, zzm zzm) {
        this.zzc = zzgr;
        this.zza = zzkz;
        this.zzb = zzm;
    }

    public final void run() {
        this.zzc.zza.zzo();
        if (this.zza.zza() == null) {
            this.zzc.zza.zzb(this.zza, this.zzb);
        } else {
            this.zzc.zza.zza(this.zza, this.zzb);
        }
    }
}
