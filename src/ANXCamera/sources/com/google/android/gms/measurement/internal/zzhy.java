package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
final class zzhy implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ boolean zzb;
    private final /* synthetic */ zzhr zzc;

    zzhy(zzhr zzhr, AtomicReference atomicReference, boolean z) {
        this.zzc = zzhr;
        this.zza = atomicReference;
        this.zzb = z;
    }

    public final void run() {
        this.zzc.zzh().zza((AtomicReference<List<zzkz>>) this.zza, this.zzb);
    }
}
