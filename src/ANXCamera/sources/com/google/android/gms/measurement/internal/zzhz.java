package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
final class zzhz implements Runnable {
    private final /* synthetic */ zzhq zza;
    private final /* synthetic */ zzhr zzb;

    zzhz(zzhr zzhr, zzhq zzhq) {
        this.zzb = zzhr;
        this.zza = zzhq;
    }

    public final void run() {
        this.zzb.zza(this.zza);
    }
}
