package com.google.firebase.analytics;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-measurement-api@@17.3.0 */
final class zzb implements Callable<String> {
    private final /* synthetic */ FirebaseAnalytics zza;

    zzb(FirebaseAnalytics firebaseAnalytics) {
        this.zza = firebaseAnalytics;
    }

    public final /* synthetic */ Object call() throws Exception {
        String zza2 = this.zza.zzb();
        if (zza2 != null) {
            return zza2;
        }
        String zzh = this.zza.zzd ? this.zza.zzc.zzh() : this.zza.zzb.zzh().zzc(120000);
        if (zzh != null) {
            this.zza.zza(zzh);
            return zzh;
        }
        throw new TimeoutException();
    }
}
