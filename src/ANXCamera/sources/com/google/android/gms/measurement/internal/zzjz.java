package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;

/* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
final /* synthetic */ class zzjz implements Runnable {
    private final zzjx zza;
    private final zzfj zzb;
    private final JobParameters zzc;

    zzjz(zzjx zzjx, zzfj zzfj, JobParameters jobParameters) {
        this.zza = zzjx;
        this.zzb = zzfj;
        this.zzc = jobParameters;
    }

    public final void run() {
        this.zza.zza(this.zzb, this.zzc);
    }
}
