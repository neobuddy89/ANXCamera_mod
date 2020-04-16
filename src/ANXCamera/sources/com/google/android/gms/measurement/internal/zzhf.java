package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
final class zzhf implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ long zzd;
    private final /* synthetic */ zzgr zze;

    zzhf(zzgr zzgr, String str, String str2, String str3, long j) {
        this.zze = zzgr;
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = j;
    }

    public final void run() {
        if (this.zza == null) {
            this.zze.zza.zzs().zzv().zza(this.zzb, (zziv) null);
            return;
        }
        this.zze.zza.zzs().zzv().zza(this.zzb, new zziv(this.zzc, this.zza, this.zzd));
    }
}
