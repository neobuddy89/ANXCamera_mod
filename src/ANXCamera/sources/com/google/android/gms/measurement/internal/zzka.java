package com.google.android.gms.measurement.internal;

import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
final /* synthetic */ class zzka implements Runnable {
    private final zzjx zza;
    private final int zzb;
    private final zzfj zzc;
    private final Intent zzd;

    zzka(zzjx zzjx, int i, zzfj zzfj, Intent intent) {
        this.zza = zzjx;
        this.zzb = i;
        this.zzc = zzfj;
        this.zzd = intent;
    }

    public final void run() {
        this.zza.zza(this.zzb, this.zzc, this.zzd);
    }
}
