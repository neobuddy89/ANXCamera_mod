package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
final class zzic implements Runnable {
    private final /* synthetic */ Bundle zza;
    private final /* synthetic */ zzhr zzb;

    zzic(zzhr zzhr, Bundle bundle) {
        this.zzb = zzhr;
        this.zza = bundle;
    }

    public final void run() {
        this.zzb.zzc(this.zza);
    }
}
