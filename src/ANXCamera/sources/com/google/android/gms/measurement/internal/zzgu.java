package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
final class zzgu implements Runnable {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ zzgr zzb;

    zzgu(zzgr zzgr, zzm zzm) {
        this.zzb = zzgr;
        this.zza = zzm;
    }

    public final void run() {
        this.zzb.zza.zzo();
        zzks zza2 = this.zzb.zza;
        zzm zzm = this.zza;
        zza2.zzq().zzd();
        zza2.zzk();
        Preconditions.checkNotEmpty(zzm.zza);
        zza2.zzc(zzm);
    }
}
