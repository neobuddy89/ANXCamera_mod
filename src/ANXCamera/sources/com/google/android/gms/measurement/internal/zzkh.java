package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
final /* synthetic */ class zzkh implements Runnable {
    private final zzki zza;

    zzkh(zzki zzki) {
        this.zza = zzki;
    }

    public final void run() {
        zzki zzki = this.zza;
        zzkf zzkf = zzki.zzb;
        long j = zzki.zza;
        zzkf.zza.zzd();
        zzkf.zza.zzr().zzw().zza("Application going to the background");
        zzkf.zza.zzf().zza("auto", "_ab", j, new Bundle());
    }
}
