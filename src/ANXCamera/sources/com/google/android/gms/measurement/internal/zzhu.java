package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
final /* synthetic */ class zzhu implements Runnable {
    private final zzhr zza;

    zzhu(zzhr zzhr) {
        this.zza = zzhr;
    }

    public final void run() {
        zzhr zzhr = this.zza;
        zzhr.zzd();
        if (zzhr.zzs().zzu.zza()) {
            zzhr.zzr().zzw().zza("Deferred Deep Link already retrieved. Not fetching again.");
            return;
        }
        long zza2 = zzhr.zzs().zzv.zza();
        zzhr.zzs().zzv.zza(1 + zza2);
        if (zza2 >= 5) {
            zzhr.zzr().zzi().zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
            zzhr.zzs().zzu.zza(true);
            return;
        }
        zzhr.zzx.zzai();
    }
}
