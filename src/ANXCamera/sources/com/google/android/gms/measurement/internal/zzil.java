package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
final class zzil implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzhr zzb;

    zzil(zzhr zzhr, long j) {
        this.zzb = zzhr;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zzs().zzl.zza(this.zza);
        this.zzb.zzr().zzw().zza("Session timeout duration set", Long.valueOf(this.zza));
    }
}
