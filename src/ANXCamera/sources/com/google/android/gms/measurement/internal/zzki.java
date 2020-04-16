package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
final class zzki implements Runnable {
    long zza;
    final /* synthetic */ zzkf zzb;

    zzki(zzkf zzkf, long j) {
        this.zzb = zzkf;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zza.zzq().zza((Runnable) new zzkh(this));
    }
}
