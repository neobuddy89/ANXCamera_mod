package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
class zzkq extends zzhh implements zzhj {
    protected final zzks zza;

    zzkq(zzks zzks) {
        super(zzks.zzs());
        Preconditions.checkNotNull(zzks);
        this.zza = zzks;
    }

    public zzn e_() {
        return this.zza.zzf();
    }

    public zzkw zzg() {
        return this.zza.zzh();
    }

    public zzac zzi() {
        return this.zza.zze();
    }

    public zzgk zzj() {
        return this.zza.zzc();
    }
}
