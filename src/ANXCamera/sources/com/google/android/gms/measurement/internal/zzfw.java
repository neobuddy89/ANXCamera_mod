package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
final class zzfw implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzft zzb;

    zzfw(zzft zzft, boolean z) {
        this.zzb = zzft;
        this.zza = z;
    }

    public final void run() {
        this.zzb.zzb.zza(this.zza);
    }
}
