package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
final class zzhi implements Runnable {
    private final /* synthetic */ zzv zza;
    private final /* synthetic */ zzm zzb;
    private final /* synthetic */ zzgr zzc;

    zzhi(zzgr zzgr, zzv zzv, zzm zzm) {
        this.zzc = zzgr;
        this.zza = zzv;
        this.zzb = zzm;
    }

    public final void run() {
        this.zzc.zza.zzo();
        if (this.zza.zzc.zza() == null) {
            this.zzc.zza.zzb(this.zza, this.zzb);
        } else {
            this.zzc.zza.zza(this.zza, this.zzb);
        }
    }
}
