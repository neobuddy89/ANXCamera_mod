package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfd;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.3.0 */
final class zzgb implements zzhg {
    private static final zzgl zzb = new zzge();
    private final zzgl zza;

    public zzgb() {
        this(new zzgd(zzfe.zza(), zza()));
    }

    private zzgb(zzgl zzgl) {
        this.zza = (zzgl) zzff.zza(zzgl, "messageInfoFactory");
    }

    private static zzgl zza() {
        try {
            return (zzgl) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception e2) {
            return zzb;
        }
    }

    private static boolean zza(zzgm zzgm) {
        return zzgm.zza() == zzfd.zze.zzh;
    }

    public final <T> zzhd<T> zza(Class<T> cls) {
        zzhf.zza((Class<?>) cls);
        zzgm zzb2 = this.zza.zzb(cls);
        if (zzb2.zzb()) {
            return zzfd.class.isAssignableFrom(cls) ? zzgu.zza(zzhf.zzc(), zzet.zza(), zzb2.zzc()) : zzgu.zza(zzhf.zza(), zzet.zzb(), zzb2.zzc());
        }
        if (zzfd.class.isAssignableFrom(cls)) {
            if (zza(zzb2)) {
                return zzgs.zza(cls, zzb2, zzgy.zzb(), zzfy.zzb(), zzhf.zzc(), zzet.zza(), zzgj.zzb());
            }
            return zzgs.zza(cls, zzb2, zzgy.zzb(), zzfy.zzb(), zzhf.zzc(), (zzes<?>) null, zzgj.zzb());
        } else if (zza(zzb2)) {
            return zzgs.zza(cls, zzb2, zzgy.zza(), zzfy.zza(), zzhf.zza(), zzet.zzb(), zzgj.zza());
        } else {
            return zzgs.zza(cls, zzb2, zzgy.zza(), zzfy.zza(), zzhf.zzb(), (zzes<?>) null, zzgj.zza());
        }
    }
}
