package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzbj;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzkg;

/* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
final class zzt extends zzu {
    private zzbj.zze zzg;
    private final /* synthetic */ zzn zzh;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzt(zzn zzn, String str, int i, zzbj.zze zze) {
        super(str, i);
        this.zzh = zzn;
        this.zzg = zze;
    }

    /* access modifiers changed from: package-private */
    public final int zza() {
        return this.zzg.zzb();
    }

    /* JADX WARNING: type inference failed for: r7v17, types: [java.lang.Integer] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    public final boolean zza(Long l, Long l2, zzbr.zzk zzk, boolean z) {
        boolean zzd = this.zzh.zzt().zzd(this.zza, zzap.zzbm);
        boolean zzd2 = this.zzh.zzt().zzd(this.zza, zzap.zzbs);
        boolean z2 = zzkg.zzb() && this.zzh.zzt().zzd(this.zza, zzap.zzbv);
        boolean zze = this.zzg.zze();
        boolean zzf = this.zzg.zzf();
        boolean z3 = zzd && this.zzg.zzh();
        boolean z4 = zze || zzf || z3;
        Boolean bool = null;
        if (!z || z4) {
            zzbj.zzc zzd3 = this.zzg.zzd();
            boolean zzf2 = zzd3.zzf();
            if (zzk.zzf()) {
                if (!zzd3.zzc()) {
                    this.zzh.zzr().zzi().zza("No number filter for long property. property", this.zzh.zzo().zzc(zzk.zzc()));
                } else {
                    bool = zza(zza(zzk.zzg(), zzd3.zzd()), zzf2);
                }
            } else if (zzk.zzh()) {
                if (!zzd3.zzc()) {
                    this.zzh.zzr().zzi().zza("No number filter for double property. property", this.zzh.zzo().zzc(zzk.zzc()));
                } else {
                    bool = zza(zza(zzk.zzi(), zzd3.zzd()), zzf2);
                }
            } else if (!zzk.zzd()) {
                this.zzh.zzr().zzi().zza("User property has no value, property", this.zzh.zzo().zzc(zzk.zzc()));
            } else if (zzd3.zza()) {
                bool = zza(zza(zzk.zze(), zzd3.zzb(), this.zzh.zzr()), zzf2);
            } else if (!zzd3.zzc()) {
                this.zzh.zzr().zzi().zza("No string or number filter defined. property", this.zzh.zzo().zzc(zzk.zzc()));
            } else if (zzkw.zza(zzk.zze())) {
                bool = zza(zza(zzk.zze(), zzd3.zzd()), zzf2);
            } else {
                this.zzh.zzr().zzi().zza("Invalid user property value for Numeric number filter. property, value", this.zzh.zzo().zzc(zzk.zzc()), zzk.zze());
            }
            this.zzh.zzr().zzx().zza("Property filter result", bool == null ? "null" : bool);
            if (bool == null) {
                return false;
            }
            this.zzc = true;
            if (zzd && z3 && !bool.booleanValue()) {
                return true;
            }
            if (!z || this.zzg.zze()) {
                this.zzd = bool;
            }
            if (bool.booleanValue() && z4 && zzk.zza()) {
                long zzb = zzk.zzb();
                if (zzd2 && l != null) {
                    zzb = l.longValue();
                }
                if (z2 && this.zzg.zze() && !this.zzg.zzf() && l2 != null) {
                    zzb = l2.longValue();
                }
                if (this.zzg.zzf()) {
                    this.zzf = Long.valueOf(zzb);
                } else {
                    this.zze = Long.valueOf(zzb);
                }
            }
            return true;
        }
        zzfl zzx = this.zzh.zzr().zzx();
        Integer valueOf = Integer.valueOf(this.zzb);
        if (this.zzg.zza()) {
            bool = Integer.valueOf(this.zzg.zzb());
        }
        zzx.zza("Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", valueOf, bool);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzb() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzc() {
        return false;
    }
}
