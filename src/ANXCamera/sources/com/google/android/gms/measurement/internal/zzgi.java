package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzv;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
final class zzgi implements Runnable {
    private final /* synthetic */ zzgq zza;
    private final /* synthetic */ long zzb;
    private final /* synthetic */ Bundle zzc;
    private final /* synthetic */ Context zzd;
    private final /* synthetic */ zzfj zze;
    private final /* synthetic */ BroadcastReceiver.PendingResult zzf;

    zzgi(zzgg zzgg, zzgq zzgq, long j, Bundle bundle, Context context, zzfj zzfj, BroadcastReceiver.PendingResult pendingResult) {
        this.zza = zzgq;
        this.zzb = j;
        this.zzc = bundle;
        this.zzd = context;
        this.zze = zzfj;
        this.zzf = pendingResult;
    }

    public final void run() {
        long zza2 = this.zza.zzc().zzh.zza();
        long j = this.zzb;
        if (zza2 > 0 && (j >= zza2 || j <= 0)) {
            j = zza2 - 1;
        }
        if (j > 0) {
            this.zzc.putLong("click_timestamp", j);
        }
        this.zzc.putString("_cis", "referrer broadcast");
        zzgq.zza(this.zzd, (zzv) null).zzh().zza("auto", "_cmp", this.zzc);
        this.zze.zzx().zza("Install campaign recorded");
        BroadcastReceiver.PendingResult pendingResult = this.zzf;
        if (pendingResult != null) {
            pendingResult.finish();
        }
    }
}
