package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
final class zzhd implements Callable<List<zzlb>> {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ zzgr zzb;

    zzhd(zzgr zzgr, zzm zzm) {
        this.zzb = zzgr;
        this.zza = zzm;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.zzb.zza.zzo();
        return this.zzb.zza.zze().zza(this.zza.zza);
    }
}
