package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
final class zzjv implements Runnable {
    private final /* synthetic */ zzjr zza;

    zzjv(zzjr zzjr) {
        this.zza = zzjr;
    }

    public final void run() {
        zziz zziz = this.zza.zza;
        Context zzn = this.zza.zza.zzn();
        this.zza.zza.zzu();
        zziz.zza(new ComponentName(zzn, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
