package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
final class zzja implements Runnable {
    private final /* synthetic */ zziv zza;
    private final /* synthetic */ long zzb;
    private final /* synthetic */ zziy zzc;

    zzja(zziy zziy, zziv zziv, long j) {
        this.zzc = zziy;
        this.zza = zziv;
        this.zzb = j;
    }

    public final void run() {
        this.zzc.zza(this.zza, false, this.zzb);
        this.zzc.zza = null;
        this.zzc.zzh().zza((zziv) null);
    }
}
