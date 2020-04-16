package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
final class zzgs implements Runnable {
    private final /* synthetic */ zzhs zza;
    private final /* synthetic */ zzgq zzb;

    zzgs(zzgq zzgq, zzhs zzhs) {
        this.zzb = zzgq;
        this.zza = zzhs;
    }

    public final void run() {
        this.zzb.zza(this.zza);
        this.zzb.zza();
    }
}
