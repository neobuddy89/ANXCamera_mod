package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
final class zzjd implements Runnable {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ zziz zzb;

    zzjd(zziz zziz, zzm zzm) {
        this.zzb = zziz;
        this.zza = zzm;
    }

    public final void run() {
        zzfb zzd = this.zzb.zzb;
        if (zzd == null) {
            this.zzb.zzr().zzf().zza("Failed to reset data on the service: not connected to service");
            return;
        }
        try {
            zzd.zzd(this.zza);
        } catch (RemoteException e2) {
            this.zzb.zzr().zzf().zza("Failed to reset data on the service: remote exception", e2);
        }
        this.zzb.zzak();
    }
}
