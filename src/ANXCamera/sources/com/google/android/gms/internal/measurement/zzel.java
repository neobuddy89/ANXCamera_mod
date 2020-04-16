package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.3.0 */
final class zzel implements zzhe {
    private final zzeg zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zzel(zzeg zzeg) {
        zzeg zzeg2 = (zzeg) zzff.zza(zzeg, "input");
        this.zza = zzeg2;
        zzeg2.zzc = this;
    }

    public static zzel zza(zzeg zzeg) {
        return zzeg.zzc != null ? zzeg.zzc : new zzel(zzeg);
    }

    private final Object zza(zzim zzim, Class<?> cls, zzeq zzeq) throws IOException {
        switch (zzek.zza[zzim.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzk());
            case 2:
                return zzn();
            case 3:
                return Double.valueOf(zzd());
            case 4:
                return Integer.valueOf(zzp());
            case 5:
                return Integer.valueOf(zzj());
            case 6:
                return Long.valueOf(zzi());
            case 7:
                return Float.valueOf(zze());
            case 8:
                return Integer.valueOf(zzh());
            case 9:
                return Long.valueOf(zzg());
            case 10:
                zza(2);
                return zzc(zzgz.zza().zza(cls), zzeq);
            case 11:
                return Integer.valueOf(zzq());
            case 12:
                return Long.valueOf(zzr());
            case 13:
                return Integer.valueOf(zzs());
            case 14:
                return Long.valueOf(zzt());
            case 15:
                return zzm();
            case 16:
                return Integer.valueOf(zzo());
            case 17:
                return Long.valueOf(zzf());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private final void zza(int i) throws IOException {
        if ((this.zzb & 7) != i) {
            throw zzfo.zzf();
        }
    }

    private final void zza(List<String> list, boolean z) throws IOException {
        int zza2;
        int zza3;
        if ((this.zzb & 7) != 2) {
            throw zzfo.zzf();
        } else if (!(list instanceof zzfv) || z) {
            do {
                list.add(z ? zzm() : zzl());
                if (!this.zza.zzt()) {
                    zza2 = this.zza.zza();
                } else {
                    return;
                }
            } while (zza2 == this.zzb);
            this.zzd = zza2;
        } else {
            zzfv zzfv = (zzfv) list;
            do {
                zzfv.zza(zzn());
                if (!this.zza.zzt()) {
                    zza3 = this.zza.zza();
                } else {
                    return;
                }
            } while (zza3 == this.zzb);
            this.zzd = zza3;
        }
    }

    private static void zzb(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzfo.zzg();
        }
    }

    private final <T> T zzc(zzhd<T> zzhd, zzeq zzeq) throws IOException {
        int zzm = this.zza.zzm();
        if (this.zza.zza < this.zza.zzb) {
            int zzc2 = this.zza.zzc(zzm);
            T zza2 = zzhd.zza();
            this.zza.zza++;
            zzhd.zza(zza2, this, zzeq);
            zzhd.zzc(zza2);
            this.zza.zza(0);
            zzeg zzeg = this.zza;
            zzeg.zza--;
            this.zza.zzd(zzc2);
            return zza2;
        }
        throw new zzfo("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    private static void zzc(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzfo.zzg();
        }
    }

    private final <T> T zzd(zzhd<T> zzhd, zzeq zzeq) throws IOException {
        int i = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            T zza2 = zzhd.zza();
            zzhd.zza(zza2, this, zzeq);
            zzhd.zzc(zza2);
            if (this.zzb == this.zzc) {
                return zza2;
            }
            throw zzfo.zzg();
        } finally {
            this.zzc = i;
        }
    }

    private final void zzd(int i) throws IOException {
        if (this.zza.zzu() != i) {
            throw zzfo.zza();
        }
    }

    public final int zza() throws IOException {
        int i = this.zzd;
        if (i != 0) {
            this.zzb = i;
            this.zzd = 0;
        } else {
            this.zzb = this.zza.zza();
        }
        int i2 = this.zzb;
        if (i2 == 0 || i2 == this.zzc) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    public final <T> T zza(zzhd<T> zzhd, zzeq zzeq) throws IOException {
        zza(2);
        return zzc(zzhd, zzeq);
    }

    public final void zza(List<Double> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzeo) {
            zzeo zzeo = (zzeo) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzeo.zza(this.zza.zzb());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzm = this.zza.zzm();
                zzb(zzm);
                int zzu = this.zza.zzu() + zzm;
                do {
                    zzeo.zza(this.zza.zzb());
                } while (this.zza.zzu() < zzu);
            } else {
                throw zzfo.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    list.add(Double.valueOf(this.zza.zzb()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzm2 = this.zza.zzm();
                zzb(zzm2);
                int zzu2 = this.zza.zzu() + zzm2;
                do {
                    list.add(Double.valueOf(this.zza.zzb()));
                } while (this.zza.zzu() < zzu2);
            } else {
                throw zzfo.zzf();
            }
        }
    }

    public final <T> void zza(List<T> list, zzhd<T> zzhd, zzeq zzeq) throws IOException {
        int zza2;
        int i = this.zzb;
        if ((i & 7) == 2) {
            do {
                list.add(zzc(zzhd, zzeq));
                if (!this.zza.zzt() && this.zzd == 0) {
                    zza2 = this.zza.zza();
                } else {
                    return;
                }
            } while (zza2 == i);
            this.zzd = zza2;
            return;
        }
        throw zzfo.zzf();
    }

    public final <K, V> void zza(Map<K, V> map, zzgf<K, V> zzgf, zzeq zzeq) throws IOException {
        zza(2);
        int zzc2 = this.zza.zzc(this.zza.zzm());
        K k = zzgf.zzb;
        V v = zzgf.zzd;
        while (true) {
            try {
                int zza2 = zza();
                if (zza2 == Integer.MAX_VALUE || this.zza.zzt()) {
                    map.put(k, v);
                } else if (zza2 == 1) {
                    k = zza(zzgf.zza, (Class<?>) null, (zzeq) null);
                } else if (zza2 == 2) {
                    v = zza(zzgf.zzc, zzgf.zzd.getClass(), zzeq);
                } else if (!zzc()) {
                    throw new zzfo("Unable to parse map entry.");
                }
            } catch (zzfn e2) {
                if (!zzc()) {
                    throw new zzfo("Unable to parse map entry.");
                }
            } catch (Throwable th) {
                this.zza.zzd(zzc2);
                throw th;
            }
        }
        map.put(k, v);
        this.zza.zzd(zzc2);
    }

    public final int zzb() {
        return this.zzb;
    }

    public final <T> T zzb(zzhd<T> zzhd, zzeq zzeq) throws IOException {
        zza(3);
        return zzd(zzhd, zzeq);
    }

    public final void zzb(List<Float> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzfc) {
            zzfc zzfc = (zzfc) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int zzm = this.zza.zzm();
                zzc(zzm);
                int zzu = this.zza.zzu() + zzm;
                do {
                    zzfc.zza(this.zza.zzc());
                } while (this.zza.zzu() < zzu);
            } else if (i == 5) {
                do {
                    zzfc.zza(this.zza.zzc());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else {
                throw zzfo.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzm2 = this.zza.zzm();
                zzc(zzm2);
                int zzu2 = this.zza.zzu() + zzm2;
                do {
                    list.add(Float.valueOf(this.zza.zzc()));
                } while (this.zza.zzu() < zzu2);
            } else if (i2 == 5) {
                do {
                    list.add(Float.valueOf(this.zza.zzc()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else {
                throw zzfo.zzf();
            }
        }
    }

    public final <T> void zzb(List<T> list, zzhd<T> zzhd, zzeq zzeq) throws IOException {
        int zza2;
        int i = this.zzb;
        if ((i & 7) == 3) {
            do {
                list.add(zzd(zzhd, zzeq));
                if (!this.zza.zzt() && this.zzd == 0) {
                    zza2 = this.zza.zza();
                } else {
                    return;
                }
            } while (zza2 == i);
            this.zzd = zza2;
            return;
        }
        throw zzfo.zzf();
    }

    public final void zzc(List<Long> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzgc) {
            zzgc zzgc = (zzgc) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzgc.zza(this.zza.zzd());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzgc.zza(this.zza.zzd());
                } while (this.zza.zzu() < zzu);
                zzd(zzu);
            } else {
                throw zzfo.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzd()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzu2 = this.zza.zzu() + this.zza.zzm();
                do {
                    list.add(Long.valueOf(this.zza.zzd()));
                } while (this.zza.zzu() < zzu2);
                zzd(zzu2);
            } else {
                throw zzfo.zzf();
            }
        }
    }

    public final boolean zzc() throws IOException {
        if (this.zza.zzt()) {
            return false;
        }
        int i = this.zzb;
        if (i == this.zzc) {
            return false;
        }
        return this.zza.zzb(i);
    }

    public final double zzd() throws IOException {
        zza(1);
        return this.zza.zzb();
    }

    public final void zzd(List<Long> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzgc) {
            zzgc zzgc = (zzgc) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzgc.zza(this.zza.zze());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzgc.zza(this.zza.zze());
                } while (this.zza.zzu() < zzu);
                zzd(zzu);
            } else {
                throw zzfo.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zze()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzu2 = this.zza.zzu() + this.zza.zzm();
                do {
                    list.add(Long.valueOf(this.zza.zze()));
                } while (this.zza.zzu() < zzu2);
                zzd(zzu2);
            } else {
                throw zzfo.zzf();
            }
        }
    }

    public final float zze() throws IOException {
        zza(5);
        return this.zza.zzc();
    }

    public final void zze(List<Integer> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzfg) {
            zzfg zzfg = (zzfg) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzfg.zzd(this.zza.zzf());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzfg.zzd(this.zza.zzf());
                } while (this.zza.zzu() < zzu);
                zzd(zzu);
            } else {
                throw zzfo.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzf()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzu2 = this.zza.zzu() + this.zza.zzm();
                do {
                    list.add(Integer.valueOf(this.zza.zzf()));
                } while (this.zza.zzu() < zzu2);
                zzd(zzu2);
            } else {
                throw zzfo.zzf();
            }
        }
    }

    public final long zzf() throws IOException {
        zza(0);
        return this.zza.zzd();
    }

    public final void zzf(List<Long> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzgc) {
            zzgc zzgc = (zzgc) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzgc.zza(this.zza.zzg());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzm = this.zza.zzm();
                zzb(zzm);
                int zzu = this.zza.zzu() + zzm;
                do {
                    zzgc.zza(this.zza.zzg());
                } while (this.zza.zzu() < zzu);
            } else {
                throw zzfo.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.zza.zzg()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzm2 = this.zza.zzm();
                zzb(zzm2);
                int zzu2 = this.zza.zzu() + zzm2;
                do {
                    list.add(Long.valueOf(this.zza.zzg()));
                } while (this.zza.zzu() < zzu2);
            } else {
                throw zzfo.zzf();
            }
        }
    }

    public final long zzg() throws IOException {
        zza(0);
        return this.zza.zze();
    }

    public final void zzg(List<Integer> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzfg) {
            zzfg zzfg = (zzfg) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int zzm = this.zza.zzm();
                zzc(zzm);
                int zzu = this.zza.zzu() + zzm;
                do {
                    zzfg.zzd(this.zza.zzh());
                } while (this.zza.zzu() < zzu);
            } else if (i == 5) {
                do {
                    zzfg.zzd(this.zza.zzh());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else {
                throw zzfo.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzm2 = this.zza.zzm();
                zzc(zzm2);
                int zzu2 = this.zza.zzu() + zzm2;
                do {
                    list.add(Integer.valueOf(this.zza.zzh()));
                } while (this.zza.zzu() < zzu2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zza.zzh()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else {
                throw zzfo.zzf();
            }
        }
    }

    public final int zzh() throws IOException {
        zza(0);
        return this.zza.zzf();
    }

    public final void zzh(List<Boolean> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzds) {
            zzds zzds = (zzds) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzds.zza(this.zza.zzi());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzds.zza(this.zza.zzi());
                } while (this.zza.zzu() < zzu);
                zzd(zzu);
            } else {
                throw zzfo.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Boolean.valueOf(this.zza.zzi()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzu2 = this.zza.zzu() + this.zza.zzm();
                do {
                    list.add(Boolean.valueOf(this.zza.zzi()));
                } while (this.zza.zzu() < zzu2);
                zzd(zzu2);
            } else {
                throw zzfo.zzf();
            }
        }
    }

    public final long zzi() throws IOException {
        zza(1);
        return this.zza.zzg();
    }

    public final void zzi(List<String> list) throws IOException {
        zza(list, false);
    }

    public final int zzj() throws IOException {
        zza(5);
        return this.zza.zzh();
    }

    public final void zzj(List<String> list) throws IOException {
        zza(list, true);
    }

    public final void zzk(List<zzdu> list) throws IOException {
        int zza2;
        if ((this.zzb & 7) == 2) {
            do {
                list.add(zzn());
                if (!this.zza.zzt()) {
                    zza2 = this.zza.zza();
                } else {
                    return;
                }
            } while (zza2 == this.zzb);
            this.zzd = zza2;
            return;
        }
        throw zzfo.zzf();
    }

    public final boolean zzk() throws IOException {
        zza(0);
        return this.zza.zzi();
    }

    public final String zzl() throws IOException {
        zza(2);
        return this.zza.zzj();
    }

    public final void zzl(List<Integer> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzfg) {
            zzfg zzfg = (zzfg) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzfg.zzd(this.zza.zzm());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzfg.zzd(this.zza.zzm());
                } while (this.zza.zzu() < zzu);
                zzd(zzu);
            } else {
                throw zzfo.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzm()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzu2 = this.zza.zzu() + this.zza.zzm();
                do {
                    list.add(Integer.valueOf(this.zza.zzm()));
                } while (this.zza.zzu() < zzu2);
                zzd(zzu2);
            } else {
                throw zzfo.zzf();
            }
        }
    }

    public final String zzm() throws IOException {
        zza(2);
        return this.zza.zzk();
    }

    public final void zzm(List<Integer> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzfg) {
            zzfg zzfg = (zzfg) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzfg.zzd(this.zza.zzn());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzfg.zzd(this.zza.zzn());
                } while (this.zza.zzu() < zzu);
                zzd(zzu);
            } else {
                throw zzfo.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzn()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzu2 = this.zza.zzu() + this.zza.zzm();
                do {
                    list.add(Integer.valueOf(this.zza.zzn()));
                } while (this.zza.zzu() < zzu2);
                zzd(zzu2);
            } else {
                throw zzfo.zzf();
            }
        }
    }

    public final zzdu zzn() throws IOException {
        zza(2);
        return this.zza.zzl();
    }

    public final void zzn(List<Integer> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzfg) {
            zzfg zzfg = (zzfg) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int zzm = this.zza.zzm();
                zzc(zzm);
                int zzu = this.zza.zzu() + zzm;
                do {
                    zzfg.zzd(this.zza.zzo());
                } while (this.zza.zzu() < zzu);
            } else if (i == 5) {
                do {
                    zzfg.zzd(this.zza.zzo());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else {
                throw zzfo.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzm2 = this.zza.zzm();
                zzc(zzm2);
                int zzu2 = this.zza.zzu() + zzm2;
                do {
                    list.add(Integer.valueOf(this.zza.zzo()));
                } while (this.zza.zzu() < zzu2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zza.zzo()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else {
                throw zzfo.zzf();
            }
        }
    }

    public final int zzo() throws IOException {
        zza(0);
        return this.zza.zzm();
    }

    public final void zzo(List<Long> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzgc) {
            zzgc zzgc = (zzgc) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzgc.zza(this.zza.zzp());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzm = this.zza.zzm();
                zzb(zzm);
                int zzu = this.zza.zzu() + zzm;
                do {
                    zzgc.zza(this.zza.zzp());
                } while (this.zza.zzu() < zzu);
            } else {
                throw zzfo.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.zza.zzp()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzm2 = this.zza.zzm();
                zzb(zzm2);
                int zzu2 = this.zza.zzu() + zzm2;
                do {
                    list.add(Long.valueOf(this.zza.zzp()));
                } while (this.zza.zzu() < zzu2);
            } else {
                throw zzfo.zzf();
            }
        }
    }

    public final int zzp() throws IOException {
        zza(0);
        return this.zza.zzn();
    }

    public final void zzp(List<Integer> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzfg) {
            zzfg zzfg = (zzfg) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzfg.zzd(this.zza.zzq());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzfg.zzd(this.zza.zzq());
                } while (this.zza.zzu() < zzu);
                zzd(zzu);
            } else {
                throw zzfo.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzq()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzu2 = this.zza.zzu() + this.zza.zzm();
                do {
                    list.add(Integer.valueOf(this.zza.zzq()));
                } while (this.zza.zzu() < zzu2);
                zzd(zzu2);
            } else {
                throw zzfo.zzf();
            }
        }
    }

    public final int zzq() throws IOException {
        zza(5);
        return this.zza.zzo();
    }

    public final void zzq(List<Long> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzgc) {
            zzgc zzgc = (zzgc) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzgc.zza(this.zza.zzr());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzgc.zza(this.zza.zzr());
                } while (this.zza.zzu() < zzu);
                zzd(zzu);
            } else {
                throw zzfo.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzr()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzu2 = this.zza.zzu() + this.zza.zzm();
                do {
                    list.add(Long.valueOf(this.zza.zzr()));
                } while (this.zza.zzu() < zzu2);
                zzd(zzu2);
            } else {
                throw zzfo.zzf();
            }
        }
    }

    public final long zzr() throws IOException {
        zza(1);
        return this.zza.zzp();
    }

    public final int zzs() throws IOException {
        zza(0);
        return this.zza.zzq();
    }

    public final long zzt() throws IOException {
        zza(0);
        return this.zza.zzr();
    }
}
