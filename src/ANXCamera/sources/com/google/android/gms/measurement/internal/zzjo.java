package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
final class zzjo implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ boolean zzb;
    private final /* synthetic */ zzv zzc;
    private final /* synthetic */ zzm zzd;
    private final /* synthetic */ zzv zze;
    private final /* synthetic */ zziz zzf;

    zzjo(zziz zziz, boolean z, boolean z2, zzv zzv, zzm zzm, zzv zzv2) {
        this.zzf = zziz;
        this.zza = z;
        this.zzb = z2;
        this.zzc = zzv;
        this.zzd = zzm;
        this.zze = zzv2;
    }

    public final void run() {
        zzfb zzd2 = this.zzf.zzb;
        if (zzd2 == null) {
            this.zzf.zzr().zzf().zza("Discarding data. Failed to send conditional user property to service");
            return;
        }
        if (this.zza) {
            this.zzf.zza(zzd2, (AbstractSafeParcelable) this.zzb ? null : this.zzc, this.zzd);
        } else {
            try {
                if (TextUtils.isEmpty(this.zze.zza)) {
                    zzd2.zza(this.zzc, this.zzd);
                } else {
                    zzd2.zza(this.zzc);
                }
            } catch (RemoteException e2) {
                this.zzf.zzr().zzf().zza("Failed to send conditional user property to the service", e2);
            }
        }
        this.zzf.zzak();
    }
}
