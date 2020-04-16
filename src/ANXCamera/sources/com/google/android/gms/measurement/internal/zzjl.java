package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
final class zzjl implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ boolean zzb;
    private final /* synthetic */ zzan zzc;
    private final /* synthetic */ zzm zzd;
    private final /* synthetic */ String zze;
    private final /* synthetic */ zziz zzf;

    zzjl(zziz zziz, boolean z, boolean z2, zzan zzan, zzm zzm, String str) {
        this.zzf = zziz;
        this.zza = z;
        this.zzb = z2;
        this.zzc = zzan;
        this.zzd = zzm;
        this.zze = str;
    }

    public final void run() {
        zzfb zzd2 = this.zzf.zzb;
        if (zzd2 == null) {
            this.zzf.zzr().zzf().zza("Discarding data. Failed to send event to service");
            return;
        }
        if (this.zza) {
            this.zzf.zza(zzd2, (AbstractSafeParcelable) this.zzb ? null : this.zzc, this.zzd);
        } else {
            try {
                if (TextUtils.isEmpty(this.zze)) {
                    zzd2.zza(this.zzc, this.zzd);
                } else {
                    zzd2.zza(this.zzc, this.zze, this.zzf.zzr().zzy());
                }
            } catch (RemoteException e2) {
                this.zzf.zzr().zzf().zza("Failed to send event to the service", e2);
            }
        }
        this.zzf.zzak();
    }
}
