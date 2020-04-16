package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
final class zzgz implements Runnable {
    private final /* synthetic */ zzan zza;
    private final /* synthetic */ zzm zzb;
    private final /* synthetic */ zzgr zzc;

    zzgz(zzgr zzgr, zzan zzan, zzm zzm) {
        this.zzc = zzgr;
        this.zza = zzan;
        this.zzb = zzm;
    }

    public final void run() {
        zzan zzb2 = this.zzc.zzb(this.zza, this.zzb);
        this.zzc.zza.zzo();
        this.zzc.zza.zza(zzb2, this.zzb);
    }
}
