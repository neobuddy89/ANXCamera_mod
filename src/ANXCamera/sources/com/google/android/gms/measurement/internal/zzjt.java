package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
final class zzjt implements Runnable {
    private final /* synthetic */ ComponentName zza;
    private final /* synthetic */ zzjr zzb;

    zzjt(zzjr zzjr, ComponentName componentName) {
        this.zzb = zzjr;
        this.zza = componentName;
    }

    public final void run() {
        this.zzb.zza.zza(this.zza);
    }
}
