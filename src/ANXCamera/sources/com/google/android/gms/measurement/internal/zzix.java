package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
final class zzix implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ long zzb;
    private final /* synthetic */ zziv zzc;
    private final /* synthetic */ zziv zzd;
    private final /* synthetic */ zziy zze;

    zzix(zziy zziy, boolean z, long j, zziv zziv, zziv zziv2) {
        this.zze = zziy;
        this.zza = z;
        this.zzb = j;
        this.zzc = zziv;
        this.zzd = zziv2;
    }

    public final void run() {
        boolean z;
        boolean z2 = false;
        if (this.zze.zzt().zza(zzap.zzbb)) {
            z = this.zza && this.zze.zza != null;
            if (z) {
                zziy zziy = this.zze;
                zziy.zza(zziy.zza, true, this.zzb);
            }
        } else {
            if (this.zza && this.zze.zza != null) {
                zziy zziy2 = this.zze;
                zziy2.zza(zziy2.zza, true, this.zzb);
            }
            z = false;
        }
        zziv zziv = this.zzc;
        if (zziv == null || zziv.zzc != this.zzd.zzc || !zzla.zzc(this.zzc.zzb, this.zzd.zzb) || !zzla.zzc(this.zzc.zza, this.zzd.zza)) {
            z2 = true;
        }
        if (z2) {
            Bundle bundle = new Bundle();
            zziy.zza(this.zzd, bundle, true);
            zziv zziv2 = this.zzc;
            if (zziv2 != null) {
                if (zziv2.zza != null) {
                    bundle.putString("_pn", this.zzc.zza);
                }
                bundle.putString("_pc", this.zzc.zzb);
                bundle.putLong("_pi", this.zzc.zzc);
            }
            if (this.zze.zzt().zza(zzap.zzbb) && z) {
                long zzb2 = this.zze.zzk().zzb.zzb();
                if (zzb2 > 0) {
                    this.zze.zzp().zza(bundle, zzb2);
                }
            }
            this.zze.zzf().zzb("auto", "_vs", bundle);
        }
        this.zze.zza = this.zzd;
        this.zze.zzh().zza(this.zzd);
    }
}
