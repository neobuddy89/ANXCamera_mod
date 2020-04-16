package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
final class zzjb implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzkz zzb;
    private final /* synthetic */ zzm zzc;
    private final /* synthetic */ zziz zzd;

    zzjb(zziz zziz, boolean z, zzkz zzkz, zzm zzm) {
        this.zzd = zziz;
        this.zza = z;
        this.zzb = zzkz;
        this.zzc = zzm;
    }

    public final void run() {
        zzfb zzd2 = this.zzd.zzb;
        if (zzd2 == null) {
            this.zzd.zzr().zzf().zza("Discarding data. Failed to set user property");
            return;
        }
        this.zzd.zza(zzd2, (AbstractSafeParcelable) this.zza ? null : this.zzb, this.zzc);
        this.zzd.zzak();
    }
}
