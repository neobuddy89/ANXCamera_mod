package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
final class zzhx implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzhr zzb;

    zzhx(zzhr zzhr, AtomicReference atomicReference) {
        this.zzb = zzhr;
        this.zza = atomicReference;
    }

    public final void run() {
        this.zzb.zzh().zza((AtomicReference<String>) this.zza);
    }
}
