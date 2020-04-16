package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
final class zzjh implements Runnable {
    private final /* synthetic */ zziv zza;
    private final /* synthetic */ zziz zzb;

    zzjh(zziz zziz, zziv zziv) {
        this.zzb = zziz;
        this.zza = zziv;
    }

    public final void run() {
        zzfb zzd = this.zzb.zzb;
        if (zzd == null) {
            this.zzb.zzr().zzf().zza("Failed to send current screen to service");
            return;
        }
        try {
            if (this.zza == null) {
                zzd.zza(0, (String) null, (String) null, this.zzb.zzn().getPackageName());
            } else {
                zzd.zza(this.zza.zzc, this.zza.zza, this.zza.zzb, this.zzb.zzn().getPackageName());
            }
            this.zzb.zzak();
        } catch (RemoteException e2) {
            this.zzb.zzr().zzf().zza("Failed to send current screen to the service", e2);
        }
    }
}
