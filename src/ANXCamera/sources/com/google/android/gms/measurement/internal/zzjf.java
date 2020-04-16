package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzn;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
final class zzjf implements Runnable {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ zziz zzc;

    zzjf(zziz zziz, zzm zzm, zzn zzn) {
        this.zzc = zziz;
        this.zza = zzm;
        this.zzb = zzn;
    }

    public final void run() {
        try {
            zzfb zzd = this.zzc.zzb;
            if (zzd == null) {
                this.zzc.zzr().zzf().zza("Failed to get app instance id");
                return;
            }
            String zzc2 = zzd.zzc(this.zza);
            if (zzc2 != null) {
                this.zzc.zzf().zza(zzc2);
                this.zzc.zzs().zzj.zza(zzc2);
            }
            this.zzc.zzak();
            this.zzc.zzp().zza(this.zzb, zzc2);
        } catch (RemoteException e2) {
            this.zzc.zzr().zzf().zza("Failed to get app instance id", e2);
        } finally {
            this.zzc.zzp().zza(this.zzb, (String) null);
        }
    }
}
