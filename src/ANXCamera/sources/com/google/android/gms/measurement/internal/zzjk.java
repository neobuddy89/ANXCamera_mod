package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzn;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
final class zzjk implements Runnable {
    private final /* synthetic */ zzan zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzn zzc;
    private final /* synthetic */ zziz zzd;

    zzjk(zziz zziz, zzan zzan, String str, zzn zzn) {
        this.zzd = zziz;
        this.zza = zzan;
        this.zzb = str;
        this.zzc = zzn;
    }

    public final void run() {
        byte[] bArr = null;
        try {
            zzfb zzd2 = this.zzd.zzb;
            if (zzd2 == null) {
                this.zzd.zzr().zzf().zza("Discarding data. Failed to send event to service to bundle");
                return;
            }
            bArr = zzd2.zza(this.zza, this.zzb);
            this.zzd.zzak();
            this.zzd.zzp().zza(this.zzc, bArr);
        } catch (RemoteException e2) {
            this.zzd.zzr().zzf().zza("Failed to send event to the service to bundle", e2);
        } finally {
            this.zzd.zzp().zza(this.zzc, bArr);
        }
    }
}
