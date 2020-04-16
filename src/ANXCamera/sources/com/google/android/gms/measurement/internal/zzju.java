package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
final class zzju implements Runnable {
    private final /* synthetic */ zzfb zza;
    private final /* synthetic */ zzjr zzb;

    zzju(zzjr zzjr, zzfb zzfb) {
        this.zzb = zzjr;
        this.zza = zzfb;
    }

    public final void run() {
        synchronized (this.zzb) {
            boolean unused = this.zzb.zzb = false;
            if (!this.zzb.zza.zzab()) {
                this.zzb.zza.zzr().zzx().zza("Connected to service");
                this.zzb.zza.zza(this.zza);
            }
        }
    }
}
