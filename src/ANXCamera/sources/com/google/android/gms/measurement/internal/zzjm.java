package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
final class zzjm implements Runnable {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ zziz zzb;

    zzjm(zziz zziz, zzm zzm) {
        this.zzb = zziz;
        this.zza = zzm;
    }

    public final void run() {
        zzfb zzd = this.zzb.zzb;
        if (zzd == null) {
            this.zzb.zzr().zzf().zza("Failed to send measurementEnabled to service");
            return;
        }
        try {
            zzd.zzb(this.zza);
            this.zzb.zzak();
        } catch (RemoteException e2) {
            this.zzb.zzr().zzf().zza("Failed to send measurementEnabled to the service", e2);
        }
    }
}
