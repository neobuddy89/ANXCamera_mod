package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
final class zzjw implements Runnable {
    private final /* synthetic */ zzfb zza;
    private final /* synthetic */ zzjr zzb;

    zzjw(zzjr zzjr, zzfb zzfb) {
        this.zzb = zzjr;
        this.zza = zzfb;
    }

    public final void run() {
        synchronized (this.zzb) {
            boolean unused = this.zzb.zzb = false;
            if (!this.zzb.zza.zzab()) {
                this.zzb.zza.zzr().zzw().zza("Connected to remote service");
                this.zzb.zza.zza(this.zza);
            }
        }
    }
}
