package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
final class zzkg implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzke zzb;

    zzkg(zzke zzke, long j) {
        this.zzb = zzke;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zzb(this.zza);
    }
}
