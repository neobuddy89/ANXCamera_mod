package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
final class zzha implements Runnable {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ zzgr zzb;

    zzha(zzgr zzgr, zzm zzm) {
        this.zzb = zzgr;
        this.zza = zzm;
    }

    public final void run() {
        this.zzb.zza.zzo();
        this.zzb.zza.zza(this.zza);
    }
}
