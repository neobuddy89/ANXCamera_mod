package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
final class zzik implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzhr zzb;

    zzik(zzhr zzhr, boolean z) {
        this.zzb = zzhr;
        this.zza = z;
    }

    public final void run() {
        this.zzb.zzd(this.zza);
    }
}
