package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
final class zzhc implements Runnable {
    private final /* synthetic */ zzan zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzgr zzc;

    zzhc(zzgr zzgr, zzan zzan, String str) {
        this.zzc = zzgr;
        this.zza = zzan;
        this.zzb = str;
    }

    public final void run() {
        this.zzc.zza.zzo();
        this.zzc.zza.zza(this.zza, this.zzb);
    }
}
