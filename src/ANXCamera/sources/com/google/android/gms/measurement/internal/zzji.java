package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
final class zzji implements Runnable {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ boolean zzb;
    private final /* synthetic */ zziz zzc;

    zzji(zziz zziz, zzm zzm, boolean z) {
        this.zzc = zziz;
        this.zza = zzm;
        this.zzb = z;
    }

    public final void run() {
        zzfb zzd = this.zzc.zzb;
        if (zzd == null) {
            this.zzc.zzr().zzf().zza("Discarding data. Failed to send app launch");
            return;
        }
        try {
            zzd.zza(this.zza);
            if (this.zzb) {
                this.zzc.zzj().zzad();
            }
            this.zzc.zza(zzd, (AbstractSafeParcelable) null, this.zza);
            this.zzc.zzak();
        } catch (RemoteException e2) {
            this.zzc.zzr().zzf().zza("Failed to send app launch to the service", e2);
        }
    }
}
