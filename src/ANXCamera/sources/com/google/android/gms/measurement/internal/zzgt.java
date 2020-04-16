package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
final class zzgt implements Runnable {
    private final /* synthetic */ zzv zza;
    private final /* synthetic */ zzgr zzb;

    zzgt(zzgr zzgr, zzv zzv) {
        this.zzb = zzgr;
        this.zza = zzv;
    }

    public final void run() {
        this.zzb.zza.zzo();
        if (this.zza.zzc.zza() == null) {
            this.zzb.zza.zzb(this.zza);
        } else {
            this.zzb.zza.zza(this.zza);
        }
    }
}
