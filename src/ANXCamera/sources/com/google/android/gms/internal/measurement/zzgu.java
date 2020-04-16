package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfd;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.3.0 */
final class zzgu<T> implements zzhd<T> {
    private final zzgo zza;
    private final zzhv<?, ?> zzb;
    private final boolean zzc;
    private final zzes<?> zzd;

    private zzgu(zzhv<?, ?> zzhv, zzes<?> zzes, zzgo zzgo) {
        this.zzb = zzhv;
        this.zzc = zzes.zza(zzgo);
        this.zzd = zzes;
        this.zza = zzgo;
    }

    static <T> zzgu<T> zza(zzhv<?, ?> zzhv, zzes<?> zzes, zzgo zzgo) {
        return new zzgu<>(zzhv, zzes, zzgo);
    }

    public final int zza(T t) {
        int hashCode = this.zzb.zzb(t).hashCode();
        return this.zzc ? (hashCode * 53) + this.zzd.zza((Object) t).hashCode() : hashCode;
    }

    public final T zza() {
        return this.zza.zzbs().zzt();
    }

    public final void zza(T t, zzhe zzhe, zzeq zzeq) throws IOException {
        boolean z;
        zzhv<?, ?> zzhv = this.zzb;
        zzes<?> zzes = this.zzd;
        Object zzc2 = zzhv.zzc(t);
        zzew<?> zzb2 = zzes.zzb(t);
        do {
            try {
                if (zzhe.zza() == Integer.MAX_VALUE) {
                    zzhv.zzb((Object) t, zzc2);
                    return;
                }
                int zzb3 = zzhe.zzb();
                if (zzb3 == 11) {
                    int i = 0;
                    Object obj = null;
                    zzdu zzdu = null;
                    while (zzhe.zza() != Integer.MAX_VALUE) {
                        int zzb4 = zzhe.zzb();
                        if (zzb4 == 16) {
                            i = zzhe.zzo();
                            obj = zzes.zza(zzeq, this.zza, i);
                        } else if (zzb4 == 26) {
                            if (obj != null) {
                                zzes.zza(zzhe, obj, zzeq, zzb2);
                            } else {
                                zzdu = zzhe.zzn();
                            }
                        } else if (!zzhe.zzc()) {
                            break;
                        }
                    }
                    if (zzhe.zzb() != 12) {
                        throw zzfo.zze();
                    } else if (zzdu != null) {
                        if (obj != null) {
                            zzes.zza(zzdu, obj, zzeq, zzb2);
                        } else {
                            zzhv.zza(zzc2, i, zzdu);
                        }
                    }
                } else if ((zzb3 & 7) == 2) {
                    Object zza2 = zzes.zza(zzeq, this.zza, zzb3 >>> 3);
                    if (zza2 != null) {
                        zzes.zza(zzhe, zza2, zzeq, zzb2);
                    } else {
                        z = zzhv.zza(zzc2, zzhe);
                        continue;
                    }
                } else {
                    z = zzhe.zzc();
                    continue;
                }
                z = true;
                continue;
            } finally {
                zzhv.zzb((Object) t, zzc2);
            }
        } while (z);
    }

    public final void zza(T t, zzis zzis) throws IOException {
        Iterator<Map.Entry<?, Object>> zzd2 = this.zzd.zza((Object) t).zzd();
        while (zzd2.hasNext()) {
            Map.Entry next = zzd2.next();
            zzey zzey = (zzey) next.getKey();
            if (zzey.zzc() != zzip.MESSAGE || zzey.zzd() || zzey.zze()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof zzfr) {
                zzis.zza(zzey.zza(), (Object) ((zzfr) next).zza().zzc());
            } else {
                zzis.zza(zzey.zza(), next.getValue());
            }
        }
        zzhv<?, ?> zzhv = this.zzb;
        zzhv.zzb(zzhv.zzb(t), zzis);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: com.google.android.gms.internal.measurement.zzfd$zzf} */
    /* JADX WARNING: Multi-variable type inference failed */
    public final void zza(T t, byte[] bArr, int i, int i2, zzdt zzdt) throws IOException {
        zzfd zzfd = t;
        zzhy zzhy = zzfd.zzb;
        if (zzhy == zzhy.zza()) {
            zzhy = zzhy.zzb();
            zzfd.zzb = zzhy;
        }
        ((zzfd.zzd) t).zza();
        zzfd.zzf zzf = null;
        while (i < i2) {
            int zza2 = zzdq.zza(bArr, i, zzdt);
            int i3 = zzdt.zza;
            if (i3 == 11) {
                int i4 = 0;
                zzdu zzdu = null;
                while (zza2 < i2) {
                    zza2 = zzdq.zza(bArr, zza2, zzdt);
                    int i5 = zzdt.zza;
                    int i6 = i5 >>> 3;
                    int i7 = i5 & 7;
                    if (i6 != 2) {
                        if (i6 == 3) {
                            if (zzf != null) {
                                zzgz.zza();
                                throw new NoSuchMethodError();
                            } else if (i7 == 2) {
                                zza2 = zzdq.zze(bArr, zza2, zzdt);
                                zzdu = (zzdu) zzdt.zzc;
                            }
                        }
                    } else if (i7 == 0) {
                        zza2 = zzdq.zza(bArr, zza2, zzdt);
                        i4 = zzdt.zza;
                        zzf = (zzfd.zzf) this.zzd.zza(zzdt.zzd, this.zza, i4);
                    }
                    if (i5 == 12) {
                        break;
                    }
                    zza2 = zzdq.zza(i5, bArr, zza2, i2, zzdt);
                }
                if (zzdu != null) {
                    zzhy.zza((i4 << 3) | 2, (Object) zzdu);
                }
                i = zza2;
            } else if ((i3 & 7) == 2) {
                zzf = this.zzd.zza(zzdt.zzd, this.zza, i3 >>> 3);
                if (zzf == null) {
                    i = zzdq.zza(i3, bArr, zza2, i2, zzhy, zzdt);
                } else {
                    zzgz.zza();
                    throw new NoSuchMethodError();
                }
            } else {
                i = zzdq.zza(i3, bArr, zza2, i2, zzdt);
            }
        }
        if (i != i2) {
            throw zzfo.zzg();
        }
    }

    public final boolean zza(T t, T t2) {
        if (!this.zzb.zzb(t).equals(this.zzb.zzb(t2))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zza((Object) t).equals(this.zzd.zza((Object) t2));
        }
        return true;
    }

    public final int zzb(T t) {
        zzhv<?, ?> zzhv = this.zzb;
        int zze = zzhv.zze(zzhv.zzb(t)) + 0;
        return this.zzc ? zze + this.zzd.zza((Object) t).zzg() : zze;
    }

    public final void zzb(T t, T t2) {
        zzhf.zza(this.zzb, t, t2);
        if (this.zzc) {
            zzhf.zza(this.zzd, t, t2);
        }
    }

    public final void zzc(T t) {
        this.zzb.zzd(t);
        this.zzd.zzc(t);
    }

    public final boolean zzd(T t) {
        return this.zzd.zza((Object) t).zzf();
    }
}
