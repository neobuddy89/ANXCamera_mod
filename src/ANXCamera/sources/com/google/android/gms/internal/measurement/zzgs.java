package com.google.android.gms.internal.measurement;

import com.adobe.xmp.options.PropertyOptions;
import com.arcsoft.camera.wideselfie.WideSelfieEngine;
import com.google.android.gms.internal.measurement.zzfd;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.3.0 */
final class zzgs<T> implements zzhd<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzib.zzc();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzgo zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final boolean zzk;
    private final int[] zzl;
    private final int zzm;
    private final int zzn;
    private final zzgw zzo;
    private final zzfy zzp;
    private final zzhv<?, ?> zzq;
    private final zzes<?> zzr;
    private final zzgh zzs;

    private zzgs(int[] iArr, Object[] objArr, int i, int i2, zzgo zzgo, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzgw zzgw, zzfy zzfy, zzhv<?, ?> zzhv, zzes<?> zzes, zzgh zzgh) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzgo instanceof zzfd;
        this.zzj = z;
        this.zzh = zzes != null && zzes.zza(zzgo);
        this.zzk = false;
        this.zzl = iArr2;
        this.zzm = i3;
        this.zzn = i4;
        this.zzo = zzgw;
        this.zzp = zzfy;
        this.zzq = zzhv;
        this.zzr = zzes;
        this.zzg = zzgo;
        this.zzs = zzgh;
    }

    private final int zza(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzb(i, i2);
    }

    private static <UT, UB> int zza(zzhv<UT, UB> zzhv, T t) {
        return zzhv.zzf(zzhv.zzb(t));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01a4, code lost:
        r12.putInt(r1, r13, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
        return r2;
     */
    private final int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzdt zzdt) throws IOException {
        int i9;
        T t2 = t;
        byte[] bArr2 = bArr;
        int i10 = i;
        int i11 = i3;
        int i12 = i4;
        int i13 = i5;
        long j2 = j;
        int i14 = i8;
        zzdt zzdt2 = zzdt;
        Unsafe unsafe = zzb;
        long j3 = (long) (this.zzc[i14 + 2] & 1048575);
        switch (i7) {
            case 51:
                if (i13 == 1) {
                    unsafe.putObject(t2, j2, Double.valueOf(zzdq.zzc(bArr, i)));
                    i9 = i10 + 8;
                    break;
                }
                break;
            case 52:
                if (i13 == 5) {
                    unsafe.putObject(t2, j2, Float.valueOf(zzdq.zzd(bArr, i)));
                    i9 = i10 + 4;
                    break;
                }
                break;
            case 53:
            case 54:
                if (i13 == 0) {
                    i9 = zzdq.zzb(bArr2, i10, zzdt2);
                    unsafe.putObject(t2, j2, Long.valueOf(zzdt2.zzb));
                    break;
                }
                break;
            case 55:
            case 62:
                if (i13 == 0) {
                    i9 = zzdq.zza(bArr2, i10, zzdt2);
                    unsafe.putObject(t2, j2, Integer.valueOf(zzdt2.zza));
                    break;
                }
                break;
            case 56:
            case 65:
                if (i13 == 1) {
                    unsafe.putObject(t2, j2, Long.valueOf(zzdq.zzb(bArr, i)));
                    i9 = i10 + 8;
                    break;
                }
                break;
            case 57:
            case 64:
                if (i13 == 5) {
                    unsafe.putObject(t2, j2, Integer.valueOf(zzdq.zza(bArr, i)));
                    i9 = i10 + 4;
                    break;
                }
                break;
            case 58:
                if (i13 == 0) {
                    i9 = zzdq.zzb(bArr2, i10, zzdt2);
                    unsafe.putObject(t2, j2, Boolean.valueOf(zzdt2.zzb != 0));
                    break;
                }
                break;
            case 59:
                if (i13 == 2) {
                    int zza2 = zzdq.zza(bArr2, i10, zzdt2);
                    int i15 = zzdt2.zza;
                    if (i15 == 0) {
                        unsafe.putObject(t2, j2, "");
                    } else if ((i6 & PropertyOptions.DELETE_EXISTING) == 0 || zzie.zza(bArr2, zza2, zza2 + i15)) {
                        unsafe.putObject(t2, j2, new String(bArr2, zza2, i15, zzff.zza));
                        zza2 += i15;
                    } else {
                        throw zzfo.zzh();
                    }
                    unsafe.putInt(t2, j3, i12);
                    return zza2;
                }
                break;
            case 60:
                if (i13 == 2) {
                    int zza3 = zzdq.zza(zza(i14), bArr2, i10, i2, zzdt2);
                    Object object = unsafe.getInt(t2, j3) == i12 ? unsafe.getObject(t2, j2) : null;
                    if (object == null) {
                        unsafe.putObject(t2, j2, zzdt2.zzc);
                    } else {
                        unsafe.putObject(t2, j2, zzff.zza(object, zzdt2.zzc));
                    }
                    unsafe.putInt(t2, j3, i12);
                    return zza3;
                }
                break;
            case 61:
                if (i13 == 2) {
                    i9 = zzdq.zze(bArr2, i10, zzdt2);
                    unsafe.putObject(t2, j2, zzdt2.zzc);
                    break;
                }
                break;
            case 63:
                if (i13 == 0) {
                    int zza4 = zzdq.zza(bArr2, i10, zzdt2);
                    int i16 = zzdt2.zza;
                    zzfk zzc2 = zzc(i14);
                    if (zzc2 == null || zzc2.zza(i16)) {
                        unsafe.putObject(t2, j2, Integer.valueOf(i16));
                        i9 = zza4;
                        break;
                    } else {
                        zze((Object) t).zza(i11, (Object) Long.valueOf((long) i16));
                        return zza4;
                    }
                }
                break;
            case 66:
                if (i13 == 0) {
                    i9 = zzdq.zza(bArr2, i10, zzdt2);
                    unsafe.putObject(t2, j2, Integer.valueOf(zzeg.zze(zzdt2.zza)));
                    break;
                }
                break;
            case 67:
                if (i13 == 0) {
                    i9 = zzdq.zzb(bArr2, i10, zzdt2);
                    unsafe.putObject(t2, j2, Long.valueOf(zzeg.zza(zzdt2.zzb)));
                    break;
                }
                break;
            case 68:
                if (i13 == 3) {
                    i9 = zzdq.zza(zza(i14), bArr, i, i2, (i11 & -8) | 4, zzdt);
                    Object object2 = unsafe.getInt(t2, j3) == i12 ? unsafe.getObject(t2, j2) : null;
                    if (object2 != null) {
                        unsafe.putObject(t2, j2, zzff.zza(object2, zzdt2.zzc));
                        break;
                    } else {
                        unsafe.putObject(t2, j2, zzdt2.zzc);
                        break;
                    }
                }
                break;
        }
    }

    private final int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, zzdt zzdt) throws IOException {
        int i8;
        int i9;
        int i10;
        int i11;
        T t2 = t;
        byte[] bArr2 = bArr;
        int i12 = i;
        int i13 = i2;
        int i14 = i3;
        int i15 = i5;
        int i16 = i6;
        long j3 = j2;
        zzdt zzdt2 = zzdt;
        zzfl zzfl = (zzfl) zzb.getObject(t2, j3);
        if (!zzfl.zza()) {
            int size = zzfl.size();
            zzfl = zzfl.zza(size == 0 ? 10 : size << 1);
            zzb.putObject(t2, j3, zzfl);
        }
        switch (i7) {
            case 18:
            case 35:
                if (i15 == 2) {
                    zzeo zzeo = (zzeo) zzfl;
                    int zza2 = zzdq.zza(bArr2, i12, zzdt2);
                    int i17 = zzdt2.zza + zza2;
                    while (zza2 < i17) {
                        zzeo.zza(zzdq.zzc(bArr2, zza2));
                        zza2 += 8;
                    }
                    if (zza2 == i17) {
                        return zza2;
                    }
                    throw zzfo.zza();
                } else if (i15 == 1) {
                    zzeo zzeo2 = (zzeo) zzfl;
                    zzeo2.zza(zzdq.zzc(bArr, i));
                    int i18 = i12 + 8;
                    while (i18 < i13) {
                        int zza3 = zzdq.zza(bArr2, i18, zzdt2);
                        if (i14 != zzdt2.zza) {
                            return i18;
                        }
                        zzeo2.zza(zzdq.zzc(bArr2, zza3));
                        i18 = zza3 + 8;
                    }
                    return i18;
                }
                break;
            case 19:
            case 36:
                if (i15 == 2) {
                    zzfc zzfc = (zzfc) zzfl;
                    int zza4 = zzdq.zza(bArr2, i12, zzdt2);
                    int i19 = zzdt2.zza + zza4;
                    while (zza4 < i19) {
                        zzfc.zza(zzdq.zzd(bArr2, zza4));
                        zza4 += 4;
                    }
                    if (zza4 == i19) {
                        return zza4;
                    }
                    throw zzfo.zza();
                } else if (i15 == 5) {
                    zzfc zzfc2 = (zzfc) zzfl;
                    zzfc2.zza(zzdq.zzd(bArr, i));
                    int i20 = i12 + 4;
                    while (i20 < i13) {
                        int zza5 = zzdq.zza(bArr2, i20, zzdt2);
                        if (i14 != zzdt2.zza) {
                            return i20;
                        }
                        zzfc2.zza(zzdq.zzd(bArr2, zza5));
                        i20 = zza5 + 4;
                    }
                    return i20;
                }
                break;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i15 == 2) {
                    zzgc zzgc = (zzgc) zzfl;
                    int zza6 = zzdq.zza(bArr2, i12, zzdt2);
                    int i21 = zzdt2.zza + zza6;
                    while (zza6 < i21) {
                        zza6 = zzdq.zzb(bArr2, zza6, zzdt2);
                        zzgc.zza(zzdt2.zzb);
                    }
                    if (zza6 == i21) {
                        return zza6;
                    }
                    throw zzfo.zza();
                } else if (i15 == 0) {
                    zzgc zzgc2 = (zzgc) zzfl;
                    int zzb2 = zzdq.zzb(bArr2, i12, zzdt2);
                    zzgc2.zza(zzdt2.zzb);
                    while (zzb2 < i13) {
                        int zza7 = zzdq.zza(bArr2, zzb2, zzdt2);
                        if (i14 != zzdt2.zza) {
                            return zzb2;
                        }
                        zzb2 = zzdq.zzb(bArr2, zza7, zzdt2);
                        zzgc2.zza(zzdt2.zzb);
                    }
                    return zzb2;
                }
                break;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i15 == 2) {
                    return zzdq.zza(bArr2, i12, (zzfl<?>) zzfl, zzdt2);
                }
                if (i15 == 0) {
                    return zzdq.zza(i3, bArr, i, i2, (zzfl<?>) zzfl, zzdt);
                }
                break;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i15 == 2) {
                    zzgc zzgc3 = (zzgc) zzfl;
                    int zza8 = zzdq.zza(bArr2, i12, zzdt2);
                    int i22 = zzdt2.zza + zza8;
                    while (zza8 < i22) {
                        zzgc3.zza(zzdq.zzb(bArr2, zza8));
                        zza8 += 8;
                    }
                    if (zza8 == i22) {
                        return zza8;
                    }
                    throw zzfo.zza();
                } else if (i15 == 1) {
                    zzgc zzgc4 = (zzgc) zzfl;
                    zzgc4.zza(zzdq.zzb(bArr, i));
                    int i23 = i12 + 8;
                    while (i23 < i13) {
                        int zza9 = zzdq.zza(bArr2, i23, zzdt2);
                        if (i14 != zzdt2.zza) {
                            return i23;
                        }
                        zzgc4.zza(zzdq.zzb(bArr2, zza9));
                        i23 = zza9 + 8;
                    }
                    return i23;
                }
                break;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i15 == 2) {
                    zzfg zzfg = (zzfg) zzfl;
                    int zza10 = zzdq.zza(bArr2, i12, zzdt2);
                    int i24 = zzdt2.zza + zza10;
                    while (zza10 < i24) {
                        zzfg.zzd(zzdq.zza(bArr2, zza10));
                        zza10 += 4;
                    }
                    if (zza10 == i24) {
                        return zza10;
                    }
                    throw zzfo.zza();
                } else if (i15 == 5) {
                    zzfg zzfg2 = (zzfg) zzfl;
                    zzfg2.zzd(zzdq.zza(bArr, i));
                    int i25 = i12 + 4;
                    while (i25 < i13) {
                        int zza11 = zzdq.zza(bArr2, i25, zzdt2);
                        if (i14 != zzdt2.zza) {
                            return i25;
                        }
                        zzfg2.zzd(zzdq.zza(bArr2, zza11));
                        i25 = zza11 + 4;
                    }
                    return i25;
                }
                break;
            case 25:
            case 42:
                if (i15 == 2) {
                    zzds zzds = (zzds) zzfl;
                    int zza12 = zzdq.zza(bArr2, i12, zzdt2);
                    int i26 = zzdt2.zza + zza12;
                    while (zza12 < i26) {
                        zza12 = zzdq.zzb(bArr2, zza12, zzdt2);
                        zzds.zza(zzdt2.zzb != 0);
                    }
                    if (zza12 == i26) {
                        return zza12;
                    }
                    throw zzfo.zza();
                } else if (i15 == 0) {
                    zzds zzds2 = (zzds) zzfl;
                    int zzb3 = zzdq.zzb(bArr2, i12, zzdt2);
                    zzds2.zza(zzdt2.zzb != 0);
                    while (zzb3 < i13) {
                        int zza13 = zzdq.zza(bArr2, zzb3, zzdt2);
                        if (i14 != zzdt2.zza) {
                            return zzb3;
                        }
                        zzb3 = zzdq.zzb(bArr2, zza13, zzdt2);
                        zzds2.zza(zzdt2.zzb != 0);
                    }
                    return zzb3;
                }
                break;
            case 26:
                if (i15 == 2) {
                    if ((j & 536870912) == 0) {
                        int zza14 = zzdq.zza(bArr2, i12, zzdt2);
                        int i27 = zzdt2.zza;
                        if (i27 >= 0) {
                            if (i27 == 0) {
                                zzfl.add("");
                            } else {
                                zzfl.add(new String(bArr2, zza14, i27, zzff.zza));
                                zza14 += i27;
                            }
                            while (i9 < i13) {
                                int zza15 = zzdq.zza(bArr2, i9, zzdt2);
                                if (i14 != zzdt2.zza) {
                                    return i9;
                                }
                                i9 = zzdq.zza(bArr2, zza15, zzdt2);
                                int i28 = zzdt2.zza;
                                if (i28 < 0) {
                                    throw zzfo.zzb();
                                } else if (i28 == 0) {
                                    zzfl.add("");
                                } else {
                                    zzfl.add(new String(bArr2, i9, i28, zzff.zza));
                                    i9 += i28;
                                }
                            }
                            return i9;
                        }
                        throw zzfo.zzb();
                    }
                    int zza16 = zzdq.zza(bArr2, i12, zzdt2);
                    int i29 = zzdt2.zza;
                    if (i29 >= 0) {
                        if (i29 == 0) {
                            zzfl.add("");
                        } else {
                            int i30 = zza16 + i29;
                            if (zzie.zza(bArr2, zza16, i30)) {
                                zzfl.add(new String(bArr2, zza16, i29, zzff.zza));
                                zza16 = i30;
                            } else {
                                throw zzfo.zzh();
                            }
                        }
                        while (i8 < i13) {
                            int zza17 = zzdq.zza(bArr2, i8, zzdt2);
                            if (i14 != zzdt2.zza) {
                                return i8;
                            }
                            i8 = zzdq.zza(bArr2, zza17, zzdt2);
                            int i31 = zzdt2.zza;
                            if (i31 < 0) {
                                throw zzfo.zzb();
                            } else if (i31 == 0) {
                                zzfl.add("");
                            } else {
                                int i32 = i8 + i31;
                                if (zzie.zza(bArr2, i8, i32)) {
                                    zzfl.add(new String(bArr2, i8, i31, zzff.zza));
                                    i8 = i32;
                                } else {
                                    throw zzfo.zzh();
                                }
                            }
                        }
                        return i8;
                    }
                    throw zzfo.zzb();
                }
                break;
            case 27:
                if (i15 == 2) {
                    return zzdq.zza(zza(i16), i3, bArr, i, i2, zzfl, zzdt);
                }
                break;
            case 28:
                if (i15 == 2) {
                    int zza18 = zzdq.zza(bArr2, i12, zzdt2);
                    int i33 = zzdt2.zza;
                    if (i33 < 0) {
                        throw zzfo.zzb();
                    } else if (i33 <= bArr2.length - zza18) {
                        if (i33 == 0) {
                            zzfl.add(zzdu.zza);
                        } else {
                            zzfl.add(zzdu.zza(bArr2, zza18, i33));
                            zza18 += i33;
                        }
                        while (i10 < i13) {
                            int zza19 = zzdq.zza(bArr2, i10, zzdt2);
                            if (i14 != zzdt2.zza) {
                                return i10;
                            }
                            i10 = zzdq.zza(bArr2, zza19, zzdt2);
                            int i34 = zzdt2.zza;
                            if (i34 < 0) {
                                throw zzfo.zzb();
                            } else if (i34 > bArr2.length - i10) {
                                throw zzfo.zza();
                            } else if (i34 == 0) {
                                zzfl.add(zzdu.zza);
                            } else {
                                zzfl.add(zzdu.zza(bArr2, i10, i34));
                                i10 += i34;
                            }
                        }
                        return i10;
                    } else {
                        throw zzfo.zza();
                    }
                }
                break;
            case 30:
            case 44:
                if (i15 == 2) {
                    i11 = zzdq.zza(bArr2, i12, (zzfl<?>) zzfl, zzdt2);
                } else if (i15 == 0) {
                    i11 = zzdq.zza(i3, bArr, i, i2, (zzfl<?>) zzfl, zzdt);
                }
                zzfd zzfd = (zzfd) t2;
                zzhy zzhy = zzfd.zzb;
                if (zzhy == zzhy.zza()) {
                    zzhy = null;
                }
                zzhy zzhy2 = (zzhy) zzhf.zza(i4, zzfl, zzc(i16), zzhy, this.zzq);
                if (zzhy2 != null) {
                    zzfd.zzb = zzhy2;
                }
                return i11;
            case 33:
            case 47:
                if (i15 == 2) {
                    zzfg zzfg3 = (zzfg) zzfl;
                    int zza20 = zzdq.zza(bArr2, i12, zzdt2);
                    int i35 = zzdt2.zza + zza20;
                    while (zza20 < i35) {
                        zza20 = zzdq.zza(bArr2, zza20, zzdt2);
                        zzfg3.zzd(zzeg.zze(zzdt2.zza));
                    }
                    if (zza20 == i35) {
                        return zza20;
                    }
                    throw zzfo.zza();
                } else if (i15 == 0) {
                    zzfg zzfg4 = (zzfg) zzfl;
                    int zza21 = zzdq.zza(bArr2, i12, zzdt2);
                    zzfg4.zzd(zzeg.zze(zzdt2.zza));
                    while (zza21 < i13) {
                        int zza22 = zzdq.zza(bArr2, zza21, zzdt2);
                        if (i14 != zzdt2.zza) {
                            return zza21;
                        }
                        zza21 = zzdq.zza(bArr2, zza22, zzdt2);
                        zzfg4.zzd(zzeg.zze(zzdt2.zza));
                    }
                    return zza21;
                }
                break;
            case 34:
            case 48:
                if (i15 == 2) {
                    zzgc zzgc5 = (zzgc) zzfl;
                    int zza23 = zzdq.zza(bArr2, i12, zzdt2);
                    int i36 = zzdt2.zza + zza23;
                    while (zza23 < i36) {
                        zza23 = zzdq.zzb(bArr2, zza23, zzdt2);
                        zzgc5.zza(zzeg.zza(zzdt2.zzb));
                    }
                    if (zza23 == i36) {
                        return zza23;
                    }
                    throw zzfo.zza();
                } else if (i15 == 0) {
                    zzgc zzgc6 = (zzgc) zzfl;
                    int zzb4 = zzdq.zzb(bArr2, i12, zzdt2);
                    zzgc6.zza(zzeg.zza(zzdt2.zzb));
                    while (zzb4 < i13) {
                        int zza24 = zzdq.zza(bArr2, zzb4, zzdt2);
                        if (i14 != zzdt2.zza) {
                            return zzb4;
                        }
                        zzb4 = zzdq.zzb(bArr2, zza24, zzdt2);
                        zzgc6.zza(zzeg.zza(zzdt2.zzb));
                    }
                    return zzb4;
                }
                break;
            case 49:
                if (i15 == 3) {
                    zzhd zza25 = zza(i16);
                    int i37 = (i14 & -8) | 4;
                    int zza26 = zzdq.zza(zza25, bArr, i, i2, i37, zzdt);
                    zzfl.add(zzdt2.zzc);
                    while (zza26 < i13) {
                        int zza27 = zzdq.zza(bArr2, zza26, zzdt2);
                        if (i14 != zzdt2.zza) {
                            return zza26;
                        }
                        zza26 = zzdq.zza(zza25, bArr, zza27, i2, i37, zzdt);
                        zzfl.add(zzdt2.zzc);
                    }
                    return zza26;
                }
                break;
        }
        return i12;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v12, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    private final <K, V> int zza(T t, byte[] bArr, int i, int i2, int i3, long j, zzdt zzdt) throws IOException {
        int i4;
        int i5;
        Unsafe unsafe = zzb;
        Object zzb2 = zzb(i3);
        Object object = unsafe.getObject(t, j);
        if (this.zzs.zzc(object)) {
            Object zze2 = this.zzs.zze(zzb2);
            this.zzs.zza(zze2, object);
            unsafe.putObject(t, j, zze2);
            object = zze2;
        }
        zzgf<?, ?> zzf2 = this.zzs.zzf(zzb2);
        Map<?, ?> zza2 = this.zzs.zza(object);
        int zza3 = zzdq.zza(bArr, i, zzdt);
        int i6 = zzdt.zza;
        if (i6 < 0 || i6 > i2 - zza3) {
            throw zzfo.zza();
        }
        int i7 = i6 + zza3;
        K k = zzf2.zzb;
        V v = zzf2.zzd;
        while (zza3 < i7) {
            int i8 = zza3 + 1;
            byte b2 = bArr[zza3];
            if (b2 < 0) {
                i5 = zzdq.zza((int) b2, bArr, i8, zzdt);
                i4 = zzdt.zza;
            } else {
                i5 = i8;
                i4 = b2;
            }
            int i9 = i4 >>> 3;
            int i10 = i4 & 7;
            if (i9 != 1) {
                if (i9 == 2 && i10 == zzf2.zzc.zzb()) {
                    zza3 = zza(bArr, i5, i2, zzf2.zzc, zzf2.zzd.getClass(), zzdt);
                    v = zzdt.zzc;
                }
            } else if (i10 == zzf2.zza.zzb()) {
                zza3 = zza(bArr, i5, i2, zzf2.zza, (Class<?>) null, zzdt);
                k = zzdt.zzc;
            }
            zza3 = zzdq.zza(i4, bArr, i5, i2, zzdt);
        }
        if (zza3 == i7) {
            zza2.put(k, v);
            return i7;
        }
        throw zzfo.zzg();
    }

    private static int zza(byte[] bArr, int i, int i2, zzim zzim, Class<?> cls, zzdt zzdt) throws IOException {
        switch (zzgr.zza[zzim.ordinal()]) {
            case 1:
                int zzb2 = zzdq.zzb(bArr, i, zzdt);
                zzdt.zzc = Boolean.valueOf(zzdt.zzb != 0);
                return zzb2;
            case 2:
                return zzdq.zze(bArr, i, zzdt);
            case 3:
                zzdt.zzc = Double.valueOf(zzdq.zzc(bArr, i));
                return i + 8;
            case 4:
            case 5:
                zzdt.zzc = Integer.valueOf(zzdq.zza(bArr, i));
                return i + 4;
            case 6:
            case 7:
                zzdt.zzc = Long.valueOf(zzdq.zzb(bArr, i));
                return i + 8;
            case 8:
                zzdt.zzc = Float.valueOf(zzdq.zzd(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int zza2 = zzdq.zza(bArr, i, zzdt);
                zzdt.zzc = Integer.valueOf(zzdt.zza);
                return zza2;
            case 12:
            case 13:
                int zzb3 = zzdq.zzb(bArr, i, zzdt);
                zzdt.zzc = Long.valueOf(zzdt.zzb);
                return zzb3;
            case 14:
                return zzdq.zza((zzhd) zzgz.zza().zza(cls), bArr, i, i2, zzdt);
            case 15:
                int zza3 = zzdq.zza(bArr, i, zzdt);
                zzdt.zzc = Integer.valueOf(zzeg.zze(zzdt.zza));
                return zza3;
            case 16:
                int zzb4 = zzdq.zzb(bArr, i, zzdt);
                zzdt.zzc = Long.valueOf(zzeg.zza(zzdt.zzb));
                return zzb4;
            case 17:
                return zzdq.zzd(bArr, i, zzdt);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:161:0x037c  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x03e1  */
    static <T> zzgs<T> zza(Class<T> cls, zzgm zzgm, zzgw zzgw, zzfy zzfy, zzhv<?, ?> zzhv, zzes<?> zzes, zzgh zzgh) {
        int i;
        char c2;
        int[] iArr;
        char c3;
        int i2;
        char c4;
        char c5;
        char c6;
        char c7;
        int i3;
        boolean z;
        int i4;
        zzhb zzhb;
        int i5;
        Class<?> cls2;
        int i6;
        String str;
        int i7;
        int i8;
        char c8;
        char c9;
        Field field;
        int i9;
        char charAt;
        Field field2;
        Field field3;
        int i10;
        char charAt2;
        int i11;
        char charAt3;
        int i12;
        char charAt4;
        int i13;
        int i14;
        char charAt5;
        int i15;
        char charAt6;
        int i16;
        char charAt7;
        int i17;
        char charAt8;
        int i18;
        char charAt9;
        int i19;
        char charAt10;
        int i20;
        char charAt11;
        int i21;
        char charAt12;
        int i22;
        char charAt13;
        char charAt14;
        zzgm zzgm2 = zzgm;
        if (zzgm2 instanceof zzhb) {
            zzhb zzhb2 = (zzhb) zzgm2;
            char c10 = 0;
            boolean z2 = zzhb2.zza() == zzfd.zze.zzi;
            String zzd2 = zzhb2.zzd();
            int length = zzd2.length();
            char charAt15 = zzd2.charAt(0);
            if (charAt15 >= 55296) {
                char c11 = charAt15 & 8191;
                int i23 = 1;
                int i24 = 13;
                while (true) {
                    i = i23 + 1;
                    charAt14 = zzd2.charAt(i23);
                    if (charAt14 < 55296) {
                        break;
                    }
                    c11 |= (charAt14 & 8191) << i24;
                    i24 += 13;
                    i23 = i;
                }
                charAt15 = c11 | (charAt14 << i24);
            } else {
                i = 1;
            }
            int i25 = i + 1;
            char charAt16 = zzd2.charAt(i);
            if (charAt16 >= 55296) {
                char c12 = charAt16 & 8191;
                int i26 = 13;
                while (true) {
                    i22 = i25 + 1;
                    charAt13 = zzd2.charAt(i25);
                    if (charAt13 < 55296) {
                        break;
                    }
                    c12 |= (charAt13 & 8191) << i26;
                    i26 += 13;
                    i25 = i22;
                }
                charAt16 = c12 | (charAt13 << i26);
                i25 = i22;
            }
            if (charAt16 == 0) {
                c6 = 0;
                c4 = 0;
                i2 = 0;
                c3 = 0;
                c2 = 0;
                iArr = zza;
                c5 = 0;
            } else {
                int i27 = i25 + 1;
                char charAt17 = zzd2.charAt(i25);
                if (charAt17 >= 55296) {
                    char c13 = charAt17 & 8191;
                    int i28 = 13;
                    while (true) {
                        i21 = i27 + 1;
                        charAt12 = zzd2.charAt(i27);
                        if (charAt12 < 55296) {
                            break;
                        }
                        c13 |= (charAt12 & 8191) << i28;
                        i28 += 13;
                        i27 = i21;
                    }
                    charAt17 = c13 | (charAt12 << i28);
                    i27 = i21;
                }
                int i29 = i27 + 1;
                char charAt18 = zzd2.charAt(i27);
                if (charAt18 >= 55296) {
                    char c14 = charAt18 & 8191;
                    int i30 = 13;
                    while (true) {
                        i20 = i29 + 1;
                        charAt11 = zzd2.charAt(i29);
                        if (charAt11 < 55296) {
                            break;
                        }
                        c14 |= (charAt11 & 8191) << i30;
                        i30 += 13;
                        i29 = i20;
                    }
                    charAt18 = c14 | (charAt11 << i30);
                    i29 = i20;
                }
                int i31 = i29 + 1;
                c4 = zzd2.charAt(i29);
                if (c4 >= 55296) {
                    char c15 = c4 & 8191;
                    int i32 = 13;
                    while (true) {
                        i19 = i31 + 1;
                        charAt10 = zzd2.charAt(i31);
                        if (charAt10 < 55296) {
                            break;
                        }
                        c15 |= (charAt10 & 8191) << i32;
                        i32 += 13;
                        i31 = i19;
                    }
                    c4 = c15 | (charAt10 << i32);
                    i31 = i19;
                }
                int i33 = i31 + 1;
                char charAt19 = zzd2.charAt(i31);
                if (charAt19 >= 55296) {
                    char c16 = charAt19 & 8191;
                    int i34 = 13;
                    while (true) {
                        i18 = i33 + 1;
                        charAt9 = zzd2.charAt(i33);
                        if (charAt9 < 55296) {
                            break;
                        }
                        c16 |= (charAt9 & 8191) << i34;
                        i34 += 13;
                        i33 = i18;
                    }
                    charAt19 = c16 | (charAt9 << i34);
                    i33 = i18;
                }
                int i35 = i33 + 1;
                c3 = zzd2.charAt(i33);
                if (c3 >= 55296) {
                    char c17 = c3 & 8191;
                    int i36 = 13;
                    while (true) {
                        i17 = i35 + 1;
                        charAt8 = zzd2.charAt(i35);
                        if (charAt8 < 55296) {
                            break;
                        }
                        c17 |= (charAt8 & 8191) << i36;
                        i36 += 13;
                        i35 = i17;
                    }
                    c3 = c17 | (charAt8 << i36);
                    i35 = i17;
                }
                int i37 = i35 + 1;
                char charAt20 = zzd2.charAt(i35);
                if (charAt20 >= 55296) {
                    char c18 = charAt20 & 8191;
                    int i38 = 13;
                    while (true) {
                        i16 = i37 + 1;
                        charAt7 = zzd2.charAt(i37);
                        if (charAt7 < 55296) {
                            break;
                        }
                        c18 |= (charAt7 & 8191) << i38;
                        i38 += 13;
                        i37 = i16;
                    }
                    charAt20 = c18 | (charAt7 << i38);
                    i37 = i16;
                }
                int i39 = i37 + 1;
                char charAt21 = zzd2.charAt(i37);
                if (charAt21 >= 55296) {
                    char c19 = charAt21 & 8191;
                    int i40 = i39;
                    int i41 = 13;
                    while (true) {
                        i15 = i40 + 1;
                        charAt6 = zzd2.charAt(i40);
                        if (charAt6 < 55296) {
                            break;
                        }
                        c19 |= (charAt6 & 8191) << i41;
                        i41 += 13;
                        i40 = i15;
                    }
                    charAt21 = c19 | (charAt6 << i41);
                    i13 = i15;
                } else {
                    i13 = i39;
                }
                int i42 = i13 + 1;
                char charAt22 = zzd2.charAt(i13);
                if (charAt22 >= 55296) {
                    char c20 = charAt22 & 8191;
                    int i43 = i42;
                    int i44 = 13;
                    while (true) {
                        i14 = i43 + 1;
                        charAt5 = zzd2.charAt(i43);
                        if (charAt5 < 55296) {
                            break;
                        }
                        c20 |= (charAt5 & 8191) << i44;
                        i44 += 13;
                        i43 = i14;
                    }
                    charAt22 = c20 | (charAt5 << i44);
                    i42 = i14;
                }
                int i45 = (charAt17 << 1) + charAt18;
                c5 = charAt19;
                i2 = i45;
                c2 = charAt22;
                c10 = charAt17;
                i25 = i42;
                char c21 = charAt20;
                iArr = new int[(charAt22 + charAt20 + charAt21)];
                c6 = c21;
            }
            Unsafe unsafe = zzb;
            Object[] zze2 = zzhb2.zze();
            Class<?> cls3 = zzhb2.zzc().getClass();
            int i46 = i25;
            int[] iArr2 = new int[(c3 * 3)];
            Object[] objArr = new Object[(c3 << 1)];
            int i47 = c2 + c6;
            char c22 = c2;
            int i48 = i46;
            int i49 = i47;
            int i50 = 0;
            int i51 = 0;
            while (i48 < length) {
                int i52 = i48 + 1;
                int charAt23 = zzd2.charAt(i48);
                int i53 = length;
                if (charAt23 >= 55296) {
                    int i54 = charAt23 & 8191;
                    int i55 = i52;
                    int i56 = 13;
                    while (true) {
                        i12 = i55 + 1;
                        charAt4 = zzd2.charAt(i55);
                        c7 = c2;
                        if (charAt4 < 55296) {
                            break;
                        }
                        i54 |= (charAt4 & 8191) << i56;
                        i56 += 13;
                        i55 = i12;
                        c2 = c7;
                    }
                    charAt23 = i54 | (charAt4 << i56);
                    i3 = i12;
                } else {
                    c7 = c2;
                    i3 = i52;
                }
                int i57 = i3 + 1;
                char charAt24 = zzd2.charAt(i3);
                int i58 = i57;
                if (charAt24 >= 55296) {
                    char c23 = charAt24 & 8191;
                    int i59 = i58;
                    int i60 = 13;
                    while (true) {
                        i11 = i59 + 1;
                        charAt3 = zzd2.charAt(i59);
                        z = z2;
                        if (charAt3 < 55296) {
                            break;
                        }
                        c23 |= (charAt3 & 8191) << i60;
                        i60 += 13;
                        i59 = i11;
                        z2 = z;
                    }
                    charAt24 = c23 | (charAt3 << i60);
                    i4 = i11;
                } else {
                    z = z2;
                    i4 = i58;
                }
                char c24 = charAt24 & 255;
                char c25 = c5;
                if ((charAt24 & 1024) != 0) {
                    iArr[i50] = i51;
                    i50++;
                }
                char c26 = c4;
                if (c24 >= '3') {
                    int i61 = i4 + 1;
                    char charAt25 = zzd2.charAt(i4);
                    char c27 = 55296;
                    if (charAt25 >= 55296) {
                        char c28 = charAt25 & 8191;
                        int i62 = 13;
                        while (true) {
                            i10 = i61 + 1;
                            charAt2 = zzd2.charAt(i61);
                            if (charAt2 < c27) {
                                break;
                            }
                            c28 |= (charAt2 & 8191) << i62;
                            i62 += 13;
                            i61 = i10;
                            c27 = 55296;
                        }
                        charAt25 = c28 | (charAt2 << i62);
                        i61 = i10;
                    }
                    int i63 = c24 - '3';
                    int i64 = i61;
                    if (i63 == 9 || i63 == 17) {
                        objArr[((i51 / 3) << 1) + 1] = zze2[i2];
                        i2++;
                    } else if (i63 == 12 && (charAt15 & 1) == 1) {
                        objArr[((i51 / 3) << 1) + 1] = zze2[i2];
                        i2++;
                    }
                    int i65 = charAt25 << 1;
                    Object obj = zze2[i65];
                    if (obj instanceof Field) {
                        field2 = (Field) obj;
                    } else {
                        field2 = zza(cls3, (String) obj);
                        zze2[i65] = field2;
                    }
                    zzhb = zzhb2;
                    String str2 = zzd2;
                    int objectFieldOffset = (int) unsafe.objectFieldOffset(field2);
                    int i66 = i65 + 1;
                    Object obj2 = zze2[i66];
                    if (obj2 instanceof Field) {
                        field3 = (Field) obj2;
                    } else {
                        field3 = zza(cls3, (String) obj2);
                        zze2[i66] = field3;
                    }
                    cls2 = cls3;
                    i5 = i2;
                    i4 = i64;
                    str = str2;
                    i6 = 0;
                    i7 = (int) unsafe.objectFieldOffset(field3);
                    i8 = objectFieldOffset;
                    c8 = c10;
                } else {
                    zzhb = zzhb2;
                    String str3 = zzd2;
                    int i67 = i2 + 1;
                    Field zza2 = zza(cls3, (String) zze2[i2]);
                    if (c24 == 9) {
                        c9 = 1;
                    } else if (c24 == 17) {
                        c9 = 1;
                    } else if (c24 == 27 || c24 == '1') {
                        c9 = 1;
                        objArr[((i51 / 3) << 1) + 1] = zze2[i67];
                        i67++;
                        i8 = (int) unsafe.objectFieldOffset(zza2);
                        if ((charAt15 & 1) == c9) {
                            i5 = i67;
                            c8 = c10;
                            cls2 = cls3;
                            char c29 = c9;
                            str = str3;
                        } else if (c24 <= 17) {
                            int i68 = i4 + 1;
                            str = str3;
                            char charAt26 = str.charAt(i4);
                            if (charAt26 >= 55296) {
                                char c30 = charAt26 & 8191;
                                int i69 = 13;
                                while (true) {
                                    i9 = i68 + 1;
                                    charAt = str.charAt(i68);
                                    if (charAt < 55296) {
                                        break;
                                    }
                                    c30 |= (charAt & 8191) << i69;
                                    i69 += 13;
                                    i68 = i9;
                                }
                                charAt26 = c30 | (charAt << i69);
                                i68 = i9;
                            }
                            int i70 = (c10 << 1) + (charAt26 / ' ');
                            Object obj3 = zze2[i70];
                            i5 = i67;
                            if (obj3 instanceof Field) {
                                field = (Field) obj3;
                            } else {
                                field = zza(cls3, (String) obj3);
                                zze2[i70] = field;
                            }
                            c8 = c10;
                            cls2 = cls3;
                            i6 = charAt26 % ' ';
                            i7 = (int) unsafe.objectFieldOffset(field);
                            i4 = i68;
                            if (c24 >= 18 && c24 <= '1') {
                                iArr[i49] = i8;
                                i49++;
                            }
                        } else {
                            i5 = i67;
                            c8 = c10;
                            cls2 = cls3;
                            str = str3;
                        }
                        i7 = 0;
                        i6 = 0;
                        iArr[i49] = i8;
                        i49++;
                    } else if (c24 == 12 || c24 == 30 || c24 == ',') {
                        if ((charAt15 & 1) == 1) {
                            objArr[((i51 / 3) << 1) + 1] = zze2[i67];
                            i67++;
                            c9 = 1;
                        } else {
                            c9 = 1;
                        }
                        i8 = (int) unsafe.objectFieldOffset(zza2);
                        if ((charAt15 & 1) == c9) {
                        }
                        i7 = 0;
                        i6 = 0;
                        iArr[i49] = i8;
                        i49++;
                    } else {
                        if (c24 == '2') {
                            int i71 = c22 + 1;
                            iArr[c22] = i51;
                            int i72 = (i51 / 3) << 1;
                            int i73 = i67 + 1;
                            objArr[i72] = zze2[i67];
                            if ((charAt24 & 2048) != 0) {
                                i67 = i73 + 1;
                                objArr[i72 + 1] = zze2[i73];
                                c22 = i71;
                                c9 = 1;
                            } else {
                                i67 = i73;
                                c9 = 1;
                                c22 = i71;
                            }
                        } else {
                            c9 = 1;
                        }
                        i8 = (int) unsafe.objectFieldOffset(zza2);
                        if ((charAt15 & 1) == c9) {
                        }
                        i7 = 0;
                        i6 = 0;
                        iArr[i49] = i8;
                        i49++;
                    }
                    objArr[((i51 / 3) << c9) + c9] = zza2.getType();
                    i8 = (int) unsafe.objectFieldOffset(zza2);
                    if ((charAt15 & 1) == c9) {
                    }
                    i7 = 0;
                    i6 = 0;
                    iArr[i49] = i8;
                    i49++;
                }
                int i74 = i51 + 1;
                iArr2[i51] = charAt23;
                int i75 = i74 + 1;
                iArr2[i74] = i8 | ((charAt24 & 256) != 0 ? WideSelfieEngine.MPAF_RGB_BASE : 0) | ((charAt24 & 512) != 0 ? PropertyOptions.DELETE_EXISTING : 0) | (c24 << 20);
                i51 = i75 + 1;
                iArr2[i75] = (i6 << 20) | i7;
                c10 = c8;
                zzd2 = str;
                i48 = i4;
                cls3 = cls2;
                c5 = c25;
                length = i53;
                c2 = c7;
                z2 = z;
                c4 = c26;
                i2 = i5;
                zzhb2 = zzhb;
            }
            char c31 = c5;
            boolean z3 = z2;
            zzgs zzgs = new zzgs(iArr2, objArr, c4, c5, zzhb2.zzc(), z2, false, iArr, c2, i47, zzgw, zzfy, zzhv, zzes, zzgh);
            return zzgs;
        }
        int zza3 = ((zzhs) zzgm2).zza();
        int i76 = zzfd.zze.zzi;
        throw new NoSuchMethodError();
    }

    private final zzhd zza(int i) {
        int i2 = (i / 3) << 1;
        zzhd zzhd = (zzhd) this.zzd[i2];
        if (zzhd != null) {
            return zzhd;
        }
        zzhd zza2 = zzgz.zza().zza((Class) this.zzd[i2 + 1]);
        this.zzd[i2] = zza2;
        return zza2;
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzfk zzfk, UB ub, zzhv<UT, UB> zzhv) {
        zzgf<?, ?> zzf2 = this.zzs.zzf(zzb(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (!zzfk.zza(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = zzhv.zza();
                }
                zzec zzc2 = zzdu.zzc(zzgg.zza(zzf2, next.getKey(), next.getValue()));
                try {
                    zzgg.zza(zzc2.zzb(), zzf2, next.getKey(), next.getValue());
                    zzhv.zza(ub, i2, zzc2.zza());
                    it.remove();
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }
        return ub;
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzhv<UT, UB> zzhv) {
        int i2 = this.zzc[i];
        Object zzf2 = zzib.zzf(obj, (long) (zzd(i) & 1048575));
        if (zzf2 == null) {
            return ub;
        }
        zzfk zzc2 = zzc(i);
        if (zzc2 == null) {
            return ub;
        }
        return zza(i, i2, this.zzs.zza(zzf2), zzc2, ub, zzhv);
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e2) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    private static List<?> zza(Object obj, long j) {
        return (List) zzib.zzf(obj, j);
    }

    private static void zza(int i, Object obj, zzis zzis) throws IOException {
        if (obj instanceof String) {
            zzis.zza(i, (String) obj);
        } else {
            zzis.zza(i, (zzdu) obj);
        }
    }

    private static <UT, UB> void zza(zzhv<UT, UB> zzhv, T t, zzis zzis) throws IOException {
        zzhv.zza(zzhv.zzb(t), zzis);
    }

    private final <K, V> void zza(zzis zzis, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzis.zza(i, this.zzs.zzf(zzb(i2)), this.zzs.zzb(obj));
        }
    }

    private final void zza(Object obj, int i, zzhe zzhe) throws IOException {
        if (zzf(i)) {
            zzib.zza(obj, (long) (i & 1048575), (Object) zzhe.zzm());
        } else if (this.zzi) {
            zzib.zza(obj, (long) (i & 1048575), (Object) zzhe.zzl());
        } else {
            zzib.zza(obj, (long) (i & 1048575), (Object) zzhe.zzn());
        }
    }

    private final void zza(T t, T t2, int i) {
        long zzd2 = (long) (zzd(i) & 1048575);
        if (zza(t2, i)) {
            Object zzf2 = zzib.zzf(t, zzd2);
            Object zzf3 = zzib.zzf(t2, zzd2);
            if (zzf2 != null && zzf3 != null) {
                zzib.zza((Object) t, zzd2, zzff.zza(zzf2, zzf3));
                zzb(t, i);
            } else if (zzf3 != null) {
                zzib.zza((Object) t, zzd2, zzf3);
                zzb(t, i);
            }
        }
    }

    private final boolean zza(T t, int i) {
        if (this.zzj) {
            int zzd2 = zzd(i);
            long j = (long) (zzd2 & 1048575);
            switch ((zzd2 & 267386880) >>> 20) {
                case 0:
                    return zzib.zze(t, j) != 0.0d;
                case 1:
                    return zzib.zzd(t, j) != 0.0f;
                case 2:
                    return zzib.zzb(t, j) != 0;
                case 3:
                    return zzib.zzb(t, j) != 0;
                case 4:
                    return zzib.zza((Object) t, j) != 0;
                case 5:
                    return zzib.zzb(t, j) != 0;
                case 6:
                    return zzib.zza((Object) t, j) != 0;
                case 7:
                    return zzib.zzc(t, j);
                case 8:
                    Object zzf2 = zzib.zzf(t, j);
                    if (zzf2 instanceof String) {
                        return !((String) zzf2).isEmpty();
                    }
                    if (zzf2 instanceof zzdu) {
                        return !zzdu.zza.equals(zzf2);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzib.zzf(t, j) != null;
                case 10:
                    return !zzdu.zza.equals(zzib.zzf(t, j));
                case 11:
                    return zzib.zza((Object) t, j) != 0;
                case 12:
                    return zzib.zza((Object) t, j) != 0;
                case 13:
                    return zzib.zza((Object) t, j) != 0;
                case 14:
                    return zzib.zzb(t, j) != 0;
                case 15:
                    return zzib.zza((Object) t, j) != 0;
                case 16:
                    return zzib.zzb(t, j) != 0;
                case 17:
                    return zzib.zzf(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int zze2 = zze(i);
            return (zzib.zza((Object) t, (long) (zze2 & 1048575)) & (1 << (zze2 >>> 20))) != 0;
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zzib.zza((Object) t, (long) (zze(i2) & 1048575)) == i;
    }

    private final boolean zza(T t, int i, int i2, int i3) {
        return this.zzj ? zza(t, i) : (i2 & i3) != 0;
    }

    private static boolean zza(Object obj, int i, zzhd zzhd) {
        return zzhd.zzd(zzib.zzf(obj, (long) (i & 1048575)));
    }

    private static <T> double zzb(T t, long j) {
        return ((Double) zzib.zzf(t, j)).doubleValue();
    }

    private final int zzb(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private final Object zzb(int i) {
        return this.zzd[(i / 3) << 1];
    }

    private final void zzb(T t, int i) {
        if (!this.zzj) {
            int zze2 = zze(i);
            long j = (long) (zze2 & 1048575);
            zzib.zza((Object) t, j, zzib.zza((Object) t, j) | (1 << (zze2 >>> 20)));
        }
    }

    private final void zzb(T t, int i, int i2) {
        zzib.zza((Object) t, (long) (zze(i2) & 1048575), i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:189:0x05c7  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0032  */
    private final void zzb(T t, zzis zzis) throws IOException {
        Map.Entry entry;
        Iterator<Map.Entry<?, Object>> it;
        int length;
        int i;
        int i2;
        int i3;
        int i4;
        T t2 = t;
        zzis zzis2 = zzis;
        if (this.zzh) {
            zzew<?> zza2 = this.zzr.zza((Object) t2);
            if (!zza2.zza.isEmpty()) {
                it = zza2.zzd();
                entry = it.next();
                int i5 = -1;
                length = this.zzc.length;
                Unsafe unsafe = zzb;
                i = 0;
                int i6 = 0;
                while (i < length) {
                    int zzd2 = zzd(i);
                    int[] iArr = this.zzc;
                    int i7 = iArr[i];
                    int i8 = (267386880 & zzd2) >>> 20;
                    if (this.zzj || i8 > 17) {
                        i2 = i;
                        i3 = 0;
                    } else {
                        int i9 = iArr[i + 2];
                        int i10 = i9 & 1048575;
                        if (i10 != i5) {
                            i2 = i;
                            i6 = unsafe.getInt(t2, (long) i10);
                            i5 = i10;
                        } else {
                            i2 = i;
                        }
                        i3 = 1 << (i9 >>> 20);
                    }
                    while (entry != null && this.zzr.zza((Map.Entry<?, ?>) entry) <= i7) {
                        this.zzr.zza(zzis2, entry);
                        entry = it.hasNext() ? it.next() : null;
                    }
                    long j = (long) (zzd2 & 1048575);
                    switch (i8) {
                        case 0:
                            i4 = i2;
                            if ((i3 & i6) == 0) {
                                break;
                            } else {
                                zzis2.zza(i7, zzib.zze(t2, j));
                                break;
                            }
                        case 1:
                            i4 = i2;
                            if ((i3 & i6) == 0) {
                                break;
                            } else {
                                zzis2.zza(i7, zzib.zzd(t2, j));
                                break;
                            }
                        case 2:
                            i4 = i2;
                            if ((i3 & i6) == 0) {
                                break;
                            } else {
                                zzis2.zza(i7, unsafe.getLong(t2, j));
                                break;
                            }
                        case 3:
                            i4 = i2;
                            if ((i3 & i6) == 0) {
                                break;
                            } else {
                                zzis2.zzc(i7, unsafe.getLong(t2, j));
                                break;
                            }
                        case 4:
                            i4 = i2;
                            if ((i3 & i6) == 0) {
                                break;
                            } else {
                                zzis2.zzc(i7, unsafe.getInt(t2, j));
                                break;
                            }
                        case 5:
                            i4 = i2;
                            if ((i3 & i6) == 0) {
                                break;
                            } else {
                                zzis2.zzd(i7, unsafe.getLong(t2, j));
                                break;
                            }
                        case 6:
                            i4 = i2;
                            if ((i3 & i6) == 0) {
                                break;
                            } else {
                                zzis2.zzd(i7, unsafe.getInt(t2, j));
                                break;
                            }
                        case 7:
                            i4 = i2;
                            if ((i3 & i6) == 0) {
                                break;
                            } else {
                                zzis2.zza(i7, zzib.zzc(t2, j));
                                break;
                            }
                        case 8:
                            i4 = i2;
                            if ((i3 & i6) == 0) {
                                break;
                            } else {
                                zza(i7, unsafe.getObject(t2, j), zzis2);
                                break;
                            }
                        case 9:
                            i4 = i2;
                            if ((i3 & i6) == 0) {
                                break;
                            } else {
                                zzis2.zza(i7, unsafe.getObject(t2, j), zza(i4));
                                break;
                            }
                        case 10:
                            i4 = i2;
                            if ((i3 & i6) == 0) {
                                break;
                            } else {
                                zzis2.zza(i7, (zzdu) unsafe.getObject(t2, j));
                                break;
                            }
                        case 11:
                            i4 = i2;
                            if ((i3 & i6) == 0) {
                                break;
                            } else {
                                zzis2.zze(i7, unsafe.getInt(t2, j));
                                break;
                            }
                        case 12:
                            i4 = i2;
                            if ((i3 & i6) == 0) {
                                break;
                            } else {
                                zzis2.zzb(i7, unsafe.getInt(t2, j));
                                break;
                            }
                        case 13:
                            i4 = i2;
                            if ((i3 & i6) == 0) {
                                break;
                            } else {
                                zzis2.zza(i7, unsafe.getInt(t2, j));
                                break;
                            }
                        case 14:
                            i4 = i2;
                            if ((i3 & i6) == 0) {
                                break;
                            } else {
                                zzis2.zzb(i7, unsafe.getLong(t2, j));
                                break;
                            }
                        case 15:
                            i4 = i2;
                            if ((i3 & i6) == 0) {
                                break;
                            } else {
                                zzis2.zzf(i7, unsafe.getInt(t2, j));
                                break;
                            }
                        case 16:
                            i4 = i2;
                            if ((i3 & i6) == 0) {
                                break;
                            } else {
                                zzis2.zze(i7, unsafe.getLong(t2, j));
                                break;
                            }
                        case 17:
                            i4 = i2;
                            if ((i3 & i6) == 0) {
                                break;
                            } else {
                                zzis2.zzb(i7, unsafe.getObject(t2, j), zza(i4));
                                break;
                            }
                        case 18:
                            i4 = i2;
                            zzhf.zza(this.zzc[i4], (List<Double>) (List) unsafe.getObject(t2, j), zzis2, false);
                            break;
                        case 19:
                            i4 = i2;
                            zzhf.zzb(this.zzc[i4], (List<Float>) (List) unsafe.getObject(t2, j), zzis2, false);
                            break;
                        case 20:
                            i4 = i2;
                            zzhf.zzc(this.zzc[i4], (List) unsafe.getObject(t2, j), zzis2, false);
                            break;
                        case 21:
                            i4 = i2;
                            zzhf.zzd(this.zzc[i4], (List) unsafe.getObject(t2, j), zzis2, false);
                            break;
                        case 22:
                            i4 = i2;
                            zzhf.zzh(this.zzc[i4], (List) unsafe.getObject(t2, j), zzis2, false);
                            break;
                        case 23:
                            i4 = i2;
                            zzhf.zzf(this.zzc[i4], (List) unsafe.getObject(t2, j), zzis2, false);
                            break;
                        case 24:
                            i4 = i2;
                            zzhf.zzk(this.zzc[i4], (List) unsafe.getObject(t2, j), zzis2, false);
                            break;
                        case 25:
                            i4 = i2;
                            zzhf.zzn(this.zzc[i4], (List) unsafe.getObject(t2, j), zzis2, false);
                            break;
                        case 26:
                            i4 = i2;
                            zzhf.zza(this.zzc[i4], (List<String>) (List) unsafe.getObject(t2, j), zzis2);
                            break;
                        case 27:
                            i4 = i2;
                            zzhf.zza(this.zzc[i4], (List<?>) (List) unsafe.getObject(t2, j), zzis2, zza(i4));
                            break;
                        case 28:
                            i4 = i2;
                            zzhf.zzb(this.zzc[i4], (List<zzdu>) (List) unsafe.getObject(t2, j), zzis2);
                            break;
                        case 29:
                            i4 = i2;
                            zzhf.zzi(this.zzc[i4], (List) unsafe.getObject(t2, j), zzis2, false);
                            break;
                        case 30:
                            i4 = i2;
                            zzhf.zzm(this.zzc[i4], (List) unsafe.getObject(t2, j), zzis2, false);
                            break;
                        case 31:
                            i4 = i2;
                            zzhf.zzl(this.zzc[i4], (List) unsafe.getObject(t2, j), zzis2, false);
                            break;
                        case 32:
                            i4 = i2;
                            zzhf.zzg(this.zzc[i4], (List) unsafe.getObject(t2, j), zzis2, false);
                            break;
                        case 33:
                            i4 = i2;
                            zzhf.zzj(this.zzc[i4], (List) unsafe.getObject(t2, j), zzis2, false);
                            break;
                        case 34:
                            i4 = i2;
                            zzhf.zze(this.zzc[i4], (List) unsafe.getObject(t2, j), zzis2, false);
                            break;
                        case 35:
                            i4 = i2;
                            zzhf.zza(this.zzc[i4], (List<Double>) (List) unsafe.getObject(t2, j), zzis2, true);
                            break;
                        case 36:
                            i4 = i2;
                            zzhf.zzb(this.zzc[i4], (List<Float>) (List) unsafe.getObject(t2, j), zzis2, true);
                            break;
                        case 37:
                            i4 = i2;
                            zzhf.zzc(this.zzc[i4], (List) unsafe.getObject(t2, j), zzis2, true);
                            break;
                        case 38:
                            i4 = i2;
                            zzhf.zzd(this.zzc[i4], (List) unsafe.getObject(t2, j), zzis2, true);
                            break;
                        case 39:
                            i4 = i2;
                            zzhf.zzh(this.zzc[i4], (List) unsafe.getObject(t2, j), zzis2, true);
                            break;
                        case 40:
                            i4 = i2;
                            zzhf.zzf(this.zzc[i4], (List) unsafe.getObject(t2, j), zzis2, true);
                            break;
                        case 41:
                            i4 = i2;
                            zzhf.zzk(this.zzc[i4], (List) unsafe.getObject(t2, j), zzis2, true);
                            break;
                        case 42:
                            i4 = i2;
                            zzhf.zzn(this.zzc[i4], (List) unsafe.getObject(t2, j), zzis2, true);
                            break;
                        case 43:
                            i4 = i2;
                            zzhf.zzi(this.zzc[i4], (List) unsafe.getObject(t2, j), zzis2, true);
                            break;
                        case 44:
                            i4 = i2;
                            zzhf.zzm(this.zzc[i4], (List) unsafe.getObject(t2, j), zzis2, true);
                            break;
                        case 45:
                            i4 = i2;
                            zzhf.zzl(this.zzc[i4], (List) unsafe.getObject(t2, j), zzis2, true);
                            break;
                        case 46:
                            i4 = i2;
                            zzhf.zzg(this.zzc[i4], (List) unsafe.getObject(t2, j), zzis2, true);
                            break;
                        case 47:
                            i4 = i2;
                            zzhf.zzj(this.zzc[i4], (List) unsafe.getObject(t2, j), zzis2, true);
                            break;
                        case 48:
                            i4 = i2;
                            zzhf.zze(this.zzc[i4], (List) unsafe.getObject(t2, j), zzis2, true);
                            break;
                        case 49:
                            i4 = i2;
                            zzhf.zzb(this.zzc[i4], (List<?>) (List) unsafe.getObject(t2, j), zzis2, zza(i4));
                            break;
                        case 50:
                            i4 = i2;
                            zza(zzis2, i7, unsafe.getObject(t2, j), i4);
                            break;
                        case 51:
                            i4 = i2;
                            if (!zza(t2, i7, i4)) {
                                break;
                            } else {
                                zzis2.zza(i7, zzb(t2, j));
                                break;
                            }
                        case 52:
                            i4 = i2;
                            if (!zza(t2, i7, i4)) {
                                break;
                            } else {
                                zzis2.zza(i7, zzc(t2, j));
                                break;
                            }
                        case 53:
                            i4 = i2;
                            if (!zza(t2, i7, i4)) {
                                break;
                            } else {
                                zzis2.zza(i7, zze(t2, j));
                                break;
                            }
                        case 54:
                            i4 = i2;
                            if (!zza(t2, i7, i4)) {
                                break;
                            } else {
                                zzis2.zzc(i7, zze(t2, j));
                                break;
                            }
                        case 55:
                            i4 = i2;
                            if (!zza(t2, i7, i4)) {
                                break;
                            } else {
                                zzis2.zzc(i7, zzd(t2, j));
                                break;
                            }
                        case 56:
                            i4 = i2;
                            if (!zza(t2, i7, i4)) {
                                break;
                            } else {
                                zzis2.zzd(i7, zze(t2, j));
                                break;
                            }
                        case 57:
                            i4 = i2;
                            if (!zza(t2, i7, i4)) {
                                break;
                            } else {
                                zzis2.zzd(i7, zzd(t2, j));
                                break;
                            }
                        case 58:
                            i4 = i2;
                            if (!zza(t2, i7, i4)) {
                                break;
                            } else {
                                zzis2.zza(i7, zzf(t2, j));
                                break;
                            }
                        case 59:
                            i4 = i2;
                            if (!zza(t2, i7, i4)) {
                                break;
                            } else {
                                zza(i7, unsafe.getObject(t2, j), zzis2);
                                break;
                            }
                        case 60:
                            i4 = i2;
                            if (!zza(t2, i7, i4)) {
                                break;
                            } else {
                                zzis2.zza(i7, unsafe.getObject(t2, j), zza(i4));
                                break;
                            }
                        case 61:
                            i4 = i2;
                            if (!zza(t2, i7, i4)) {
                                break;
                            } else {
                                zzis2.zza(i7, (zzdu) unsafe.getObject(t2, j));
                                break;
                            }
                        case 62:
                            i4 = i2;
                            if (!zza(t2, i7, i4)) {
                                break;
                            } else {
                                zzis2.zze(i7, zzd(t2, j));
                                break;
                            }
                        case 63:
                            i4 = i2;
                            if (!zza(t2, i7, i4)) {
                                break;
                            } else {
                                zzis2.zzb(i7, zzd(t2, j));
                                break;
                            }
                        case 64:
                            i4 = i2;
                            if (!zza(t2, i7, i4)) {
                                break;
                            } else {
                                zzis2.zza(i7, zzd(t2, j));
                                break;
                            }
                        case 65:
                            i4 = i2;
                            if (!zza(t2, i7, i4)) {
                                break;
                            } else {
                                zzis2.zzb(i7, zze(t2, j));
                                break;
                            }
                        case 66:
                            i4 = i2;
                            if (!zza(t2, i7, i4)) {
                                break;
                            } else {
                                zzis2.zzf(i7, zzd(t2, j));
                                break;
                            }
                        case 67:
                            i4 = i2;
                            if (!zza(t2, i7, i4)) {
                                break;
                            } else {
                                zzis2.zze(i7, zze(t2, j));
                                break;
                            }
                        case 68:
                            i4 = i2;
                            if (!zza(t2, i7, i4)) {
                                break;
                            } else {
                                zzis2.zzb(i7, unsafe.getObject(t2, j), zza(i4));
                                break;
                            }
                        default:
                            i4 = i2;
                            break;
                    }
                    i = i4 + 3;
                }
                while (entry != null) {
                    this.zzr.zza(zzis2, entry);
                    entry = it.hasNext() ? it.next() : null;
                }
                zza(this.zzq, t2, zzis2);
            }
        }
        it = null;
        entry = null;
        int i52 = -1;
        length = this.zzc.length;
        Unsafe unsafe2 = zzb;
        i = 0;
        int i62 = 0;
        while (i < length) {
        }
        while (entry != null) {
        }
        zza(this.zzq, t2, zzis2);
    }

    private final void zzb(T t, T t2, int i) {
        int zzd2 = zzd(i);
        int i2 = this.zzc[i];
        long j = (long) (zzd2 & 1048575);
        if (zza(t2, i2, i)) {
            Object zzf2 = zzib.zzf(t, j);
            Object zzf3 = zzib.zzf(t2, j);
            if (zzf2 != null && zzf3 != null) {
                zzib.zza((Object) t, j, zzff.zza(zzf2, zzf3));
                zzb(t, i2, i);
            } else if (zzf3 != null) {
                zzib.zza((Object) t, j, zzf3);
                zzb(t, i2, i);
            }
        }
    }

    private static <T> float zzc(T t, long j) {
        return ((Float) zzib.zzf(t, j)).floatValue();
    }

    private final zzfk zzc(int i) {
        return (zzfk) this.zzd[((i / 3) << 1) + 1];
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza(t, i) == zza(t2, i);
    }

    private final int zzd(int i) {
        return this.zzc[i + 1];
    }

    private static <T> int zzd(T t, long j) {
        return ((Integer) zzib.zzf(t, j)).intValue();
    }

    private final int zze(int i) {
        return this.zzc[i + 2];
    }

    private static <T> long zze(T t, long j) {
        return ((Long) zzib.zzf(t, j)).longValue();
    }

    private static zzhy zze(Object obj) {
        zzfd zzfd = (zzfd) obj;
        zzhy zzhy = zzfd.zzb;
        if (zzhy != zzhy.zza()) {
            return zzhy;
        }
        zzhy zzb2 = zzhy.zzb();
        zzfd.zzb = zzb2;
        return zzb2;
    }

    private static boolean zzf(int i) {
        return (i & PropertyOptions.DELETE_EXISTING) != 0;
    }

    private static <T> boolean zzf(T t, long j) {
        return ((Boolean) zzib.zzf(t, j)).booleanValue();
    }

    private final int zzg(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzb(i, 0);
    }

    public final int zza(T t) {
        int length = this.zzc.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2 += 3) {
            int zzd2 = zzd(i2);
            int i3 = this.zzc[i2];
            long j = (long) (1048575 & zzd2);
            int i4 = 37;
            switch ((zzd2 & 267386880) >>> 20) {
                case 0:
                    i = (i * 53) + zzff.zza(Double.doubleToLongBits(zzib.zze(t, j)));
                    break;
                case 1:
                    i = (i * 53) + Float.floatToIntBits(zzib.zzd(t, j));
                    break;
                case 2:
                    i = (i * 53) + zzff.zza(zzib.zzb(t, j));
                    break;
                case 3:
                    i = (i * 53) + zzff.zza(zzib.zzb(t, j));
                    break;
                case 4:
                    i = (i * 53) + zzib.zza((Object) t, j);
                    break;
                case 5:
                    i = (i * 53) + zzff.zza(zzib.zzb(t, j));
                    break;
                case 6:
                    i = (i * 53) + zzib.zza((Object) t, j);
                    break;
                case 7:
                    i = (i * 53) + zzff.zza(zzib.zzc(t, j));
                    break;
                case 8:
                    i = (i * 53) + ((String) zzib.zzf(t, j)).hashCode();
                    break;
                case 9:
                    Object zzf2 = zzib.zzf(t, j);
                    if (zzf2 != null) {
                        i4 = zzf2.hashCode();
                    }
                    i = (i * 53) + i4;
                    break;
                case 10:
                    i = (i * 53) + zzib.zzf(t, j).hashCode();
                    break;
                case 11:
                    i = (i * 53) + zzib.zza((Object) t, j);
                    break;
                case 12:
                    i = (i * 53) + zzib.zza((Object) t, j);
                    break;
                case 13:
                    i = (i * 53) + zzib.zza((Object) t, j);
                    break;
                case 14:
                    i = (i * 53) + zzff.zza(zzib.zzb(t, j));
                    break;
                case 15:
                    i = (i * 53) + zzib.zza((Object) t, j);
                    break;
                case 16:
                    i = (i * 53) + zzff.zza(zzib.zzb(t, j));
                    break;
                case 17:
                    Object zzf3 = zzib.zzf(t, j);
                    if (zzf3 != null) {
                        i4 = zzf3.hashCode();
                    }
                    i = (i * 53) + i4;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = (i * 53) + zzib.zzf(t, j).hashCode();
                    break;
                case 50:
                    i = (i * 53) + zzib.zzf(t, j).hashCode();
                    break;
                case 51:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzff.zza(Double.doubleToLongBits(zzb(t, j)));
                        break;
                    }
                case 52:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + Float.floatToIntBits(zzc(t, j));
                        break;
                    }
                case 53:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzff.zza(zze(t, j));
                        break;
                    }
                case 54:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzff.zza(zze(t, j));
                        break;
                    }
                case 55:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzd(t, j);
                        break;
                    }
                case 56:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzff.zza(zze(t, j));
                        break;
                    }
                case 57:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzd(t, j);
                        break;
                    }
                case 58:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzff.zza(zzf(t, j));
                        break;
                    }
                case 59:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + ((String) zzib.zzf(t, j)).hashCode();
                        break;
                    }
                case 60:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzib.zzf(t, j).hashCode();
                        break;
                    }
                case 61:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzib.zzf(t, j).hashCode();
                        break;
                    }
                case 62:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzd(t, j);
                        break;
                    }
                case 63:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzd(t, j);
                        break;
                    }
                case 64:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzd(t, j);
                        break;
                    }
                case 65:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzff.zza(zze(t, j));
                        break;
                    }
                case 66:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzd(t, j);
                        break;
                    }
                case 67:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzff.zza(zze(t, j));
                        break;
                    }
                case 68:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzib.zzf(t, j).hashCode();
                        break;
                    }
            }
        }
        int hashCode = (i * 53) + this.zzq.zzb(t).hashCode();
        return this.zzh ? (hashCode * 53) + this.zzr.zza((Object) t).hashCode() : hashCode;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v37, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v38, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v40, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v42, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v45, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v31, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    public final int zza(T t, byte[] bArr, int i, int i2, int i3, zzdt zzdt) throws IOException {
        Unsafe unsafe;
        int i4;
        T t2;
        zzgs zzgs;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        T t3;
        zzdt zzdt2;
        int i11;
        int i12;
        char c2;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        zzdt zzdt3;
        zzgs zzgs2 = this;
        T t4 = t;
        byte[] bArr2 = bArr;
        int i18 = i2;
        int i19 = i3;
        zzdt zzdt4 = zzdt;
        Unsafe unsafe2 = zzb;
        int i20 = i;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = -1;
        int i25 = -1;
        while (true) {
            if (i20 < i18) {
                int i26 = i20 + 1;
                byte b2 = bArr2[i20];
                if (b2 < 0) {
                    i6 = zzdq.zza((int) b2, bArr2, i26, zzdt4);
                    i5 = zzdt4.zza;
                } else {
                    i5 = b2;
                    i6 = i26;
                }
                int i27 = i5 >>> 3;
                int i28 = i5 & 7;
                int zza2 = i27 > i24 ? zzgs2.zza(i27, i21 / 3) : zzgs2.zzg(i27);
                if (zza2 == -1) {
                    i8 = i27;
                    i10 = i6;
                    i7 = i5;
                    unsafe = unsafe2;
                    i9 = 0;
                } else {
                    int[] iArr = zzgs2.zzc;
                    int i29 = iArr[zza2 + 1];
                    int i30 = (i29 & 267386880) >>> 20;
                    int i31 = i5;
                    long j = (long) (i29 & 1048575);
                    int i32 = i29;
                    if (i30 <= 17) {
                        int i33 = iArr[zza2 + 2];
                        int i34 = 1 << (i33 >>> 20);
                        int i35 = i33 & 1048575;
                        if (i35 != i25) {
                            c2 = 65535;
                            if (i25 != -1) {
                                unsafe2.putInt(t4, (long) i25, i23);
                            }
                            i23 = unsafe2.getInt(t4, (long) i35);
                            i25 = i35;
                        } else {
                            c2 = 65535;
                        }
                        switch (i30) {
                            case 0:
                                i15 = zza2;
                                i14 = i27;
                                char c3 = c2;
                                i13 = i25;
                                long j2 = j;
                                i16 = i31;
                                bArr2 = bArr;
                                zzdt zzdt5 = zzdt;
                                i17 = i6;
                                if (i28 == 1) {
                                    zzib.zza((Object) t4, j2, zzdq.zzc(bArr2, i17));
                                    i20 = i17 + 8;
                                    i23 |= i34;
                                    i25 = i13;
                                    i22 = i16;
                                    i21 = i15;
                                    i24 = i14;
                                    zzdt4 = zzdt5;
                                    i18 = i2;
                                    i19 = i3;
                                    continue;
                                }
                                break;
                            case 1:
                                i15 = zza2;
                                i14 = i27;
                                char c4 = c2;
                                i13 = i25;
                                long j3 = j;
                                i16 = i31;
                                bArr2 = bArr;
                                zzdt zzdt6 = zzdt;
                                i17 = i6;
                                if (i28 == 5) {
                                    zzib.zza((Object) t4, j3, zzdq.zzd(bArr2, i17));
                                    i20 = i17 + 4;
                                    i23 |= i34;
                                    i25 = i13;
                                    i22 = i16;
                                    i21 = i15;
                                    i24 = i14;
                                    zzdt4 = zzdt6;
                                    i18 = i2;
                                    i19 = i3;
                                    continue;
                                }
                                break;
                            case 2:
                            case 3:
                                i15 = zza2;
                                i14 = i27;
                                char c5 = c2;
                                i13 = i25;
                                long j4 = j;
                                i16 = i31;
                                bArr2 = bArr;
                                zzdt zzdt7 = zzdt;
                                i17 = i6;
                                if (i28 == 0) {
                                    int zzb2 = zzdq.zzb(bArr2, i17, zzdt7);
                                    unsafe2.putLong(t, j4, zzdt7.zzb);
                                    i23 |= i34;
                                    i20 = zzb2;
                                    i22 = i16;
                                    i21 = i15;
                                    i24 = i14;
                                    zzdt4 = zzdt7;
                                    i25 = i13;
                                    i18 = i2;
                                    i19 = i3;
                                    continue;
                                }
                                break;
                            case 4:
                            case 11:
                                i15 = zza2;
                                i14 = i27;
                                char c6 = c2;
                                i13 = i25;
                                long j5 = j;
                                i16 = i31;
                                bArr2 = bArr;
                                zzdt zzdt8 = zzdt;
                                i17 = i6;
                                if (i28 == 0) {
                                    i20 = zzdq.zza(bArr2, i17, zzdt8);
                                    unsafe2.putInt(t4, j5, zzdt8.zza);
                                    i23 |= i34;
                                    i25 = i13;
                                    i22 = i16;
                                    i21 = i15;
                                    i24 = i14;
                                    zzdt4 = zzdt8;
                                    i18 = i2;
                                    i19 = i3;
                                    continue;
                                }
                                break;
                            case 5:
                            case 14:
                                i15 = zza2;
                                i14 = i27;
                                char c7 = c2;
                                long j6 = j;
                                i16 = i31;
                                bArr2 = bArr;
                                int i36 = i2;
                                zzdt zzdt9 = zzdt;
                                if (i28 != 1) {
                                    i13 = i25;
                                    i17 = i6;
                                    break;
                                } else {
                                    unsafe2.putLong(t, j6, zzdq.zzb(bArr2, i6));
                                    i20 = i6 + 8;
                                    i23 |= i34;
                                    i25 = i25;
                                    i22 = i16;
                                    i21 = i15;
                                    i24 = i14;
                                    zzdt4 = zzdt9;
                                    i18 = i2;
                                    i19 = i3;
                                    continue;
                                }
                            case 6:
                            case 13:
                                i15 = zza2;
                                i14 = i27;
                                char c8 = c2;
                                long j7 = j;
                                i16 = i31;
                                bArr2 = bArr;
                                int i37 = i2;
                                zzdt zzdt10 = zzdt;
                                if (i28 != 5) {
                                    i13 = i25;
                                    i17 = i6;
                                    break;
                                } else {
                                    unsafe2.putInt(t4, j7, zzdq.zza(bArr2, i6));
                                    i20 = i6 + 4;
                                    i23 |= i34;
                                    i22 = i16;
                                    i21 = i15;
                                    i24 = i14;
                                    zzdt4 = zzdt10;
                                    i19 = i3;
                                    i18 = i37;
                                    continue;
                                }
                            case 7:
                                i15 = zza2;
                                i14 = i27;
                                char c9 = c2;
                                long j8 = j;
                                i16 = i31;
                                bArr2 = bArr;
                                int i38 = i2;
                                zzdt zzdt11 = zzdt;
                                if (i28 != 0) {
                                    i13 = i25;
                                    i17 = i6;
                                    break;
                                } else {
                                    int zzb3 = zzdq.zzb(bArr2, i6, zzdt11);
                                    zzib.zza((Object) t4, j8, zzdt11.zzb != 0);
                                    i23 |= i34;
                                    i20 = zzb3;
                                    i22 = i16;
                                    i21 = i15;
                                    i24 = i14;
                                    zzdt4 = zzdt11;
                                    i19 = i3;
                                    i18 = i38;
                                    continue;
                                }
                            case 8:
                                i15 = zza2;
                                i14 = i27;
                                char c10 = c2;
                                long j9 = j;
                                i16 = i31;
                                bArr2 = bArr;
                                int i39 = i2;
                                zzdt zzdt12 = zzdt;
                                if (i28 != 2) {
                                    i13 = i25;
                                    i17 = i6;
                                    break;
                                } else {
                                    i20 = (i32 & PropertyOptions.DELETE_EXISTING) == 0 ? zzdq.zzc(bArr2, i6, zzdt12) : zzdq.zzd(bArr2, i6, zzdt12);
                                    unsafe2.putObject(t4, j9, zzdt12.zzc);
                                    i23 |= i34;
                                    i22 = i16;
                                    i21 = i15;
                                    i24 = i14;
                                    zzdt4 = zzdt12;
                                    i19 = i3;
                                    i18 = i39;
                                    continue;
                                }
                            case 9:
                                i15 = zza2;
                                i14 = i27;
                                char c11 = c2;
                                long j10 = j;
                                i16 = i31;
                                bArr2 = bArr;
                                zzdt zzdt13 = zzdt;
                                if (i28 != 2) {
                                    int i40 = i2;
                                    i13 = i25;
                                    i17 = i6;
                                    break;
                                } else {
                                    int i41 = i2;
                                    i20 = zzdq.zza(zzgs2.zza(i15), bArr2, i6, i41, zzdt13);
                                    if ((i23 & i34) == 0) {
                                        unsafe2.putObject(t4, j10, zzdt13.zzc);
                                    } else {
                                        unsafe2.putObject(t4, j10, zzff.zza(unsafe2.getObject(t4, j10), zzdt13.zzc));
                                    }
                                    i23 |= i34;
                                    i22 = i16;
                                    i21 = i15;
                                    i24 = i14;
                                    zzdt4 = zzdt13;
                                    i19 = i3;
                                    i18 = i41;
                                    continue;
                                }
                            case 10:
                                i15 = zza2;
                                i14 = i27;
                                char c12 = c2;
                                long j11 = j;
                                i16 = i31;
                                bArr2 = bArr;
                                zzdt zzdt14 = zzdt;
                                if (i28 != 2) {
                                    i13 = i25;
                                    i17 = i6;
                                    break;
                                } else {
                                    i20 = zzdq.zze(bArr2, i6, zzdt14);
                                    unsafe2.putObject(t4, j11, zzdt14.zzc);
                                    i23 |= i34;
                                    i22 = i16;
                                    i21 = i15;
                                    i24 = i14;
                                    zzdt4 = zzdt14;
                                    i18 = i2;
                                    i19 = i3;
                                    continue;
                                }
                            case 12:
                                i15 = zza2;
                                i14 = i27;
                                char c13 = c2;
                                long j12 = j;
                                i16 = i31;
                                bArr2 = bArr;
                                zzdt zzdt15 = zzdt;
                                if (i28 != 0) {
                                    i13 = i25;
                                    i17 = i6;
                                    break;
                                } else {
                                    i20 = zzdq.zza(bArr2, i6, zzdt15);
                                    int i42 = zzdt15.zza;
                                    zzfk zzc2 = zzgs2.zzc(i15);
                                    if (zzc2 == null || zzc2.zza(i42)) {
                                        unsafe2.putInt(t4, j12, i42);
                                        i23 |= i34;
                                        i22 = i16;
                                        i21 = i15;
                                        i24 = i14;
                                        zzdt4 = zzdt15;
                                        i18 = i2;
                                        i19 = i3;
                                        break;
                                    } else {
                                        zze((Object) t).zza(i16, (Object) Long.valueOf((long) i42));
                                        i22 = i16;
                                        i21 = i15;
                                        i24 = i14;
                                        zzdt4 = zzdt15;
                                        i18 = i2;
                                        i19 = i3;
                                        continue;
                                    }
                                }
                                break;
                            case 15:
                                i15 = zza2;
                                i14 = i27;
                                char c14 = c2;
                                long j13 = j;
                                i16 = i31;
                                bArr2 = bArr;
                                zzdt zzdt16 = zzdt;
                                if (i28 != 0) {
                                    i13 = i25;
                                    i17 = i6;
                                    break;
                                } else {
                                    i20 = zzdq.zza(bArr2, i6, zzdt16);
                                    unsafe2.putInt(t4, j13, zzeg.zze(zzdt16.zza));
                                    i23 |= i34;
                                    i22 = i16;
                                    i21 = i15;
                                    i24 = i14;
                                    zzdt4 = zzdt16;
                                    i18 = i2;
                                    i19 = i3;
                                    continue;
                                }
                            case 16:
                                i15 = zza2;
                                i14 = i27;
                                char c15 = c2;
                                i16 = i31;
                                zzdt zzdt17 = zzdt;
                                if (i28 != 0) {
                                    byte[] bArr3 = bArr;
                                    zzdt zzdt18 = zzdt17;
                                    i13 = i25;
                                    i17 = i6;
                                    break;
                                } else {
                                    long j14 = j;
                                    bArr2 = bArr;
                                    int zzb4 = zzdq.zzb(bArr2, i6, zzdt17);
                                    unsafe2.putLong(t, j14, zzeg.zza(zzdt17.zzb));
                                    i23 |= i34;
                                    i20 = zzb4;
                                    i22 = i16;
                                    i21 = i15;
                                    i24 = i14;
                                    zzdt4 = zzdt17;
                                    i18 = i2;
                                    i19 = i3;
                                    continue;
                                }
                            case 17:
                                if (i28 != 3) {
                                    i15 = zza2;
                                    i14 = i27;
                                    char c16 = c2;
                                    i16 = i31;
                                    byte[] bArr4 = bArr;
                                    zzdt zzdt19 = zzdt;
                                    i13 = i25;
                                    i17 = i6;
                                    break;
                                } else {
                                    int i43 = zza2;
                                    int i44 = i27;
                                    char c17 = c2;
                                    int i45 = i31;
                                    i20 = zzdq.zza(zzgs2.zza(zza2), bArr, i6, i2, (i27 << 3) | 4, zzdt);
                                    if ((i23 & i34) == 0) {
                                        zzdt3 = zzdt;
                                        unsafe2.putObject(t4, j, zzdt3.zzc);
                                    } else {
                                        zzdt3 = zzdt;
                                        unsafe2.putObject(t4, j, zzff.zza(unsafe2.getObject(t4, j), zzdt3.zzc));
                                    }
                                    i23 |= i34;
                                    bArr2 = bArr;
                                    i18 = i2;
                                    i22 = i45;
                                    i21 = i43;
                                    i24 = i44;
                                    i19 = i3;
                                    zzdt4 = zzdt3;
                                    continue;
                                }
                            default:
                                byte[] bArr5 = bArr;
                                zzdt zzdt20 = zzdt;
                                i15 = zza2;
                                i14 = i27;
                                char c18 = c2;
                                i13 = i25;
                                i16 = i31;
                                i17 = i6;
                                break;
                        }
                        i10 = i17;
                        i7 = i16;
                        i9 = i15;
                        unsafe = unsafe2;
                        i8 = i14;
                        i25 = i13;
                    } else {
                        int i46 = i27;
                        int i47 = i25;
                        int i48 = i31;
                        int i49 = i6;
                        long j15 = j;
                        bArr2 = bArr;
                        zzdt zzdt21 = zzdt4;
                        int i50 = zza2;
                        long j16 = j15;
                        if (i30 != 27) {
                            i11 = i23;
                            int i51 = i46;
                            if (i30 <= 49) {
                                i8 = i51;
                                int i52 = i49;
                                i7 = i48;
                                i9 = i50;
                                unsafe = unsafe2;
                                i20 = zza(t, bArr, i49, i2, i48, i51, i28, i50, (long) i32, i30, j16, zzdt);
                                if (i20 == i52) {
                                    i10 = i20;
                                    i25 = i47;
                                    i23 = i11;
                                } else {
                                    zzgs2 = this;
                                    t4 = t;
                                    bArr2 = bArr;
                                    i18 = i2;
                                    i19 = i3;
                                    zzdt4 = zzdt;
                                    i25 = i47;
                                    i21 = i9;
                                    i23 = i11;
                                    i24 = i8;
                                    i22 = i7;
                                    unsafe2 = unsafe;
                                }
                            } else {
                                int i53 = i28;
                                long j17 = j16;
                                i8 = i51;
                                i12 = i49;
                                i7 = i48;
                                i9 = i50;
                                unsafe = unsafe2;
                                int i54 = i32;
                                if (i30 != 50) {
                                    i20 = zza(t, bArr, i12, i2, i7, i8, i53, i54, i30, j17, i9, zzdt);
                                    if (i20 == i12) {
                                        i10 = i20;
                                        i25 = i47;
                                        i23 = i11;
                                    } else {
                                        i22 = i7;
                                        zzgs2 = this;
                                        zzdt4 = zzdt;
                                        i24 = i8;
                                        t4 = t;
                                        i25 = i47;
                                        i21 = i9;
                                        i23 = i11;
                                        unsafe2 = unsafe;
                                        bArr2 = bArr;
                                        i18 = i2;
                                        i19 = i3;
                                    }
                                } else if (i53 == 2) {
                                    i20 = zza(t, bArr, i12, i2, i9, j17, zzdt);
                                    if (i20 == i12) {
                                        i10 = i20;
                                        i25 = i47;
                                        i23 = i11;
                                    } else {
                                        zzgs2 = this;
                                        t4 = t;
                                        bArr2 = bArr;
                                        i18 = i2;
                                        i19 = i3;
                                        zzdt4 = zzdt;
                                        i25 = i47;
                                        i21 = i9;
                                        i23 = i11;
                                        i24 = i8;
                                        i22 = i7;
                                        unsafe2 = unsafe;
                                    }
                                }
                            }
                        } else if (i28 == 2) {
                            zzfl zzfl = (zzfl) unsafe2.getObject(t4, j16);
                            if (!zzfl.zza()) {
                                int size = zzfl.size();
                                zzfl = zzfl.zza(size == 0 ? 10 : size << 1);
                                unsafe2.putObject(t4, j16, zzfl);
                            }
                            i20 = zzdq.zza(zzgs2.zza(i50), i48, bArr, i49, i2, zzfl, zzdt);
                            i19 = i3;
                            i24 = i46;
                            i22 = i48;
                            i21 = i50;
                            zzdt4 = zzdt21;
                            i25 = i47;
                            i23 = i23;
                            i18 = i2;
                        } else {
                            i11 = i23;
                            i8 = i46;
                            i12 = i49;
                            i7 = i48;
                            i9 = i50;
                            unsafe = unsafe2;
                        }
                        i10 = i12;
                        i25 = i47;
                        i23 = i11;
                    }
                }
                i4 = i3;
                int i55 = i7;
                if (i55 != i4 || i4 == 0) {
                    if (this.zzh) {
                        zzdt2 = zzdt;
                        if (zzdt2.zzd != zzeq.zza()) {
                            int i56 = i8;
                            if (zzdt2.zzd.zza(this.zzg, i56) == null) {
                                i20 = zzdq.zza(i55, bArr, i10, i2, zze((Object) t), zzdt);
                                t4 = t;
                                i18 = i2;
                                i22 = i55;
                                zzgs2 = this;
                                zzdt4 = zzdt2;
                                i24 = i56;
                                i21 = i9;
                                unsafe2 = unsafe;
                                bArr2 = bArr;
                                i19 = i4;
                            } else {
                                zzfd.zzd zzd2 = t;
                                zzd2.zza();
                                zzew<zzfd.zzc> zzew = zzd2.zzc;
                                throw new NoSuchMethodError();
                            }
                        } else {
                            t3 = t;
                        }
                    } else {
                        t3 = t;
                        zzdt2 = zzdt;
                    }
                    i20 = zzdq.zza(i55, bArr, i10, i2, zze((Object) t), zzdt);
                    i22 = i55;
                    zzgs2 = this;
                    zzdt4 = zzdt2;
                    i24 = i8;
                    t4 = t3;
                    i21 = i9;
                    unsafe2 = unsafe;
                    bArr2 = bArr;
                    i18 = i2;
                    i19 = i4;
                } else {
                    zzgs = this;
                    t2 = t;
                    i20 = i10;
                    i22 = i55;
                }
            } else {
                int i57 = i23;
                int i58 = i25;
                unsafe = unsafe2;
                i4 = i19;
                t2 = t4;
                zzgs = zzgs2;
            }
        }
        if (i25 != -1) {
            unsafe.putInt(t2, (long) i25, i23);
        }
        zzhy zzhy = null;
        for (int i59 = zzgs.zzm; i59 < zzgs.zzn; i59++) {
            zzhy = (zzhy) zzgs.zza((Object) t2, zzgs.zzl[i59], zzhy, zzgs.zzq);
        }
        if (zzhy != null) {
            zzgs.zzq.zzb((Object) t2, zzhy);
        }
        if (i4 == 0) {
            if (i20 != i2) {
                throw zzfo.zzg();
            }
        } else if (i20 > i2 || i22 != i4) {
            throw zzfo.zzg();
        }
        return i20;
    }

    public final T zza() {
        return this.zzo.zza(this.zzg);
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final void zza(T r13, com.google.android.gms.internal.measurement.zzhe r14, com.google.android.gms.internal.measurement.zzeq r15) throws java.io.IOException {
        /*
            r12 = this;
            r0 = 0
            if (r15 == 0) goto L_0x0623
            com.google.android.gms.internal.measurement.zzhv<?, ?> r8 = r12.zzq
            com.google.android.gms.internal.measurement.zzes<?> r9 = r12.zzr
            r1 = r0
            r10 = r1
        L_0x000a:
            int r2 = r14.zza()     // Catch:{ all -> 0x060b }
            int r3 = r12.zzg(r2)     // Catch:{ all -> 0x060b }
            if (r3 >= 0) goto L_0x007b
            r3 = 2147483647(0x7fffffff, float:NaN)
            if (r2 != r3) goto L_0x0030
            int r14 = r12.zzm
        L_0x001b:
            int r15 = r12.zzn
            if (r14 >= r15) goto L_0x002a
            int[] r15 = r12.zzl
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x001b
        L_0x002a:
            if (r10 == 0) goto L_0x002f
            r8.zzb((java.lang.Object) r13, r10)
        L_0x002f:
            return
        L_0x0030:
            boolean r3 = r12.zzh     // Catch:{ all -> 0x060b }
            if (r3 != 0) goto L_0x0036
            r3 = r0
            goto L_0x003d
        L_0x0036:
            com.google.android.gms.internal.measurement.zzgo r3 = r12.zzg     // Catch:{ all -> 0x060b }
            java.lang.Object r2 = r9.zza(r15, r3, r2)     // Catch:{ all -> 0x060b }
            r3 = r2
        L_0x003d:
            if (r3 == 0) goto L_0x0055
            if (r1 != 0) goto L_0x0047
            com.google.android.gms.internal.measurement.zzew r1 = r9.zzb(r13)     // Catch:{ all -> 0x060b }
            r11 = r1
            goto L_0x0048
        L_0x0047:
            r11 = r1
        L_0x0048:
            r1 = r9
            r2 = r14
            r4 = r15
            r5 = r11
            r6 = r10
            r7 = r8
            java.lang.Object r10 = r1.zza(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x060b }
            r1 = r11
            goto L_0x000a
        L_0x0055:
            r8.zza((com.google.android.gms.internal.measurement.zzhe) r14)     // Catch:{ all -> 0x060b }
            if (r10 != 0) goto L_0x005e
            java.lang.Object r10 = r8.zzc(r13)     // Catch:{ all -> 0x060b }
        L_0x005e:
            boolean r2 = r8.zza(r10, (com.google.android.gms.internal.measurement.zzhe) r14)     // Catch:{ all -> 0x060b }
            if (r2 != 0) goto L_0x000a
            int r14 = r12.zzm
        L_0x0066:
            int r15 = r12.zzn
            if (r14 >= r15) goto L_0x0075
            int[] r15 = r12.zzl
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x0066
        L_0x0075:
            if (r10 == 0) goto L_0x007a
            r8.zzb((java.lang.Object) r13, r10)
        L_0x007a:
            return
        L_0x007b:
            int r4 = r12.zzd((int) r3)     // Catch:{ all -> 0x060b }
            r5 = 267386880(0xff00000, float:2.3665827E-29)
            r5 = r5 & r4
            int r5 = r5 >>> 20
            r6 = 1048575(0xfffff, float:1.469367E-39)
            switch(r5) {
                case 0: goto L_0x05b2;
                case 1: goto L_0x05a2;
                case 2: goto L_0x0592;
                case 3: goto L_0x0582;
                case 4: goto L_0x0572;
                case 5: goto L_0x0562;
                case 6: goto L_0x0552;
                case 7: goto L_0x0542;
                case 8: goto L_0x053a;
                case 9: goto L_0x0504;
                case 10: goto L_0x04f4;
                case 11: goto L_0x04e4;
                case 12: goto L_0x04c0;
                case 13: goto L_0x04b0;
                case 14: goto L_0x04a0;
                case 15: goto L_0x0490;
                case 16: goto L_0x0480;
                case 17: goto L_0x044a;
                case 18: goto L_0x043c;
                case 19: goto L_0x042e;
                case 20: goto L_0x0420;
                case 21: goto L_0x0412;
                case 22: goto L_0x0404;
                case 23: goto L_0x03f6;
                case 24: goto L_0x03e8;
                case 25: goto L_0x03da;
                case 26: goto L_0x03b7;
                case 27: goto L_0x03a1;
                case 28: goto L_0x0393;
                case 29: goto L_0x0385;
                case 30: goto L_0x036f;
                case 31: goto L_0x0361;
                case 32: goto L_0x0353;
                case 33: goto L_0x0345;
                case 34: goto L_0x0337;
                case 35: goto L_0x0329;
                case 36: goto L_0x031b;
                case 37: goto L_0x030d;
                case 38: goto L_0x02ff;
                case 39: goto L_0x02f1;
                case 40: goto L_0x02e3;
                case 41: goto L_0x02d5;
                case 42: goto L_0x02c7;
                case 43: goto L_0x02b9;
                case 44: goto L_0x02a3;
                case 45: goto L_0x0295;
                case 46: goto L_0x0287;
                case 47: goto L_0x0279;
                case 48: goto L_0x026b;
                case 49: goto L_0x0256;
                case 50: goto L_0x0212;
                case 51: goto L_0x01ff;
                case 52: goto L_0x01ec;
                case 53: goto L_0x01d9;
                case 54: goto L_0x01c6;
                case 55: goto L_0x01b3;
                case 56: goto L_0x01a0;
                case 57: goto L_0x018d;
                case 58: goto L_0x017a;
                case 59: goto L_0x0172;
                case 60: goto L_0x013c;
                case 61: goto L_0x012d;
                case 62: goto L_0x011a;
                case 63: goto L_0x00f3;
                case 64: goto L_0x00e0;
                case 65: goto L_0x00cd;
                case 66: goto L_0x00ba;
                case 67: goto L_0x00a7;
                case 68: goto L_0x0093;
                default: goto L_0x008b;
            }
        L_0x008b:
            if (r10 != 0) goto L_0x05c2
            java.lang.Object r10 = r8.zza()     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x05c2
        L_0x0093:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzhd r6 = r12.zza((int) r3)     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Object r6 = r14.zzb(r6, r15)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x00a7:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x05e1 }
            long r6 = r14.zzt()     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x00ba:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x05e1 }
            int r6 = r14.zzs()     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x00cd:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x05e1 }
            long r6 = r14.zzr()     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x00e0:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x05e1 }
            int r6 = r14.zzq()     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x00f3:
            int r5 = r14.zzp()     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzfk r7 = r12.zzc((int) r3)     // Catch:{ zzfn -> 0x05e1 }
            if (r7 == 0) goto L_0x010b
            boolean r7 = r7.zza(r5)     // Catch:{ zzfn -> 0x05e1 }
            if (r7 == 0) goto L_0x0104
            goto L_0x010b
        L_0x0104:
            java.lang.Object r10 = com.google.android.gms.internal.measurement.zzhf.zza((int) r2, (int) r5, r10, r8)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x010b:
            r4 = r4 & r6
            long r6 = (long) r4     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r6, (java.lang.Object) r4)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x011a:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x05e1 }
            int r6 = r14.zzo()     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x012d:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzdu r6 = r14.zzn()     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x013c:
            boolean r5 = r12.zza(r13, (int) r2, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            if (r5 == 0) goto L_0x015b
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Object r6 = com.google.android.gms.internal.measurement.zzib.zzf(r13, r4)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzhd r7 = r12.zza((int) r3)     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Object r7 = r14.zza(r7, r15)     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Object r6 = com.google.android.gms.internal.measurement.zzff.zza((java.lang.Object) r6, (java.lang.Object) r7)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x016d
        L_0x015b:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzhd r6 = r12.zza((int) r3)     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Object r6 = r14.zza(r6, r15)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
        L_0x016d:
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0172:
            r12.zza((java.lang.Object) r13, (int) r4, (com.google.android.gms.internal.measurement.zzhe) r14)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x017a:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x05e1 }
            boolean r6 = r14.zzk()     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x018d:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x05e1 }
            int r6 = r14.zzj()     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x01a0:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x05e1 }
            long r6 = r14.zzi()     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x01b3:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x05e1 }
            int r6 = r14.zzh()     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x01c6:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x05e1 }
            long r6 = r14.zzf()     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x01d9:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x05e1 }
            long r6 = r14.zzg()     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x01ec:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x05e1 }
            float r6 = r14.zze()     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Float r6 = java.lang.Float.valueOf(r6)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x01ff:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x05e1 }
            double r6 = r14.zzd()     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0212:
            java.lang.Object r2 = r12.zzb((int) r3)     // Catch:{ zzfn -> 0x05e1 }
            int r3 = r12.zzd((int) r3)     // Catch:{ zzfn -> 0x05e1 }
            r3 = r3 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzib.zzf(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            if (r5 != 0) goto L_0x022d
            com.google.android.gms.internal.measurement.zzgh r5 = r12.zzs     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Object r5 = r5.zze(r2)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x0245
        L_0x022d:
            com.google.android.gms.internal.measurement.zzgh r6 = r12.zzs     // Catch:{ zzfn -> 0x05e1 }
            boolean r6 = r6.zzc(r5)     // Catch:{ zzfn -> 0x05e1 }
            if (r6 == 0) goto L_0x0245
            com.google.android.gms.internal.measurement.zzgh r6 = r12.zzs     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Object r6 = r6.zze(r2)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzgh r7 = r12.zzs     // Catch:{ zzfn -> 0x05e1 }
            r7.zza(r6, r5)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r6)     // Catch:{ zzfn -> 0x05e1 }
            r5 = r6
        L_0x0245:
            com.google.android.gms.internal.measurement.zzgh r3 = r12.zzs     // Catch:{ zzfn -> 0x05e1 }
            java.util.Map r3 = r3.zza(r5)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzgh r4 = r12.zzs     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzgf r2 = r4.zzf(r2)     // Catch:{ zzfn -> 0x05e1 }
            r14.zza(r3, r2, (com.google.android.gms.internal.measurement.zzeq) r15)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0256:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzhd r2 = r12.zza((int) r3)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzfy r3 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r3 = r3.zza(r13, r4)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzb(r3, r2, r15)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x026b:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzq(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0279:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzp(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0287:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzo(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0295:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzn(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x02a3:
            com.google.android.gms.internal.measurement.zzfy r5 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r4 = r4 & r6
            long r6 = (long) r4     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r4 = r5.zza(r13, r6)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzm(r4)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzfk r3 = r12.zzc((int) r3)     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Object r10 = com.google.android.gms.internal.measurement.zzhf.zza(r2, r4, r3, r10, r8)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x02b9:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzl(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x02c7:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzh(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x02d5:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzg(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x02e3:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzf(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x02f1:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zze(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x02ff:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzc(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x030d:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzd(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x031b:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzb(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0329:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zza(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0337:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzq(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0345:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzp(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0353:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzo(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0361:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzn(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x036f:
            com.google.android.gms.internal.measurement.zzfy r5 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r4 = r4 & r6
            long r6 = (long) r4     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r4 = r5.zza(r13, r6)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzm(r4)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzfk r3 = r12.zzc((int) r3)     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Object r10 = com.google.android.gms.internal.measurement.zzhf.zza(r2, r4, r3, r10, r8)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0385:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzl(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0393:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzk(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x03a1:
            com.google.android.gms.internal.measurement.zzhd r2 = r12.zza((int) r3)     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzfy r5 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r3 = r5.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zza(r3, r2, (com.google.android.gms.internal.measurement.zzeq) r15)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x03b7:
            boolean r2 = zzf(r4)     // Catch:{ zzfn -> 0x05e1 }
            if (r2 == 0) goto L_0x03cc
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzj(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x03cc:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzi(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x03da:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzh(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x03e8:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzg(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x03f6:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzf(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0404:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zze(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0412:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzc(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0420:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzd(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x042e:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzb(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x043c:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zza(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x044a:
            boolean r2 = r12.zza(r13, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            if (r2 == 0) goto L_0x046b
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Object r2 = com.google.android.gms.internal.measurement.zzib.zzf(r13, r4)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzhd r3 = r12.zza((int) r3)     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Object r3 = r14.zzb(r3, r15)     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Object r2 = com.google.android.gms.internal.measurement.zzff.zza((java.lang.Object) r2, (java.lang.Object) r3)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x046b:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzhd r2 = r12.zza((int) r3)     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Object r2 = r14.zzb(r2, r15)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r2)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0480:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x05e1 }
            long r6 = r14.zzt()     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (long) r6)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0490:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x05e1 }
            int r2 = r14.zzs()     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (int) r2)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x04a0:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x05e1 }
            long r6 = r14.zzr()     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (long) r6)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x04b0:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x05e1 }
            int r2 = r14.zzq()     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (int) r2)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x04c0:
            int r5 = r14.zzp()     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzfk r7 = r12.zzc((int) r3)     // Catch:{ zzfn -> 0x05e1 }
            if (r7 == 0) goto L_0x04d8
            boolean r7 = r7.zza(r5)     // Catch:{ zzfn -> 0x05e1 }
            if (r7 == 0) goto L_0x04d1
            goto L_0x04d8
        L_0x04d1:
            java.lang.Object r10 = com.google.android.gms.internal.measurement.zzhf.zza((int) r2, (int) r5, r10, r8)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x04d8:
            r2 = r4 & r6
            long r6 = (long) r2     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r6, (int) r5)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x04e4:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x05e1 }
            int r2 = r14.zzo()     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (int) r2)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x04f4:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzdu r2 = r14.zzn()     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r2)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0504:
            boolean r2 = r12.zza(r13, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            if (r2 == 0) goto L_0x0525
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Object r2 = com.google.android.gms.internal.measurement.zzib.zzf(r13, r4)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzhd r3 = r12.zza((int) r3)     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Object r3 = r14.zza(r3, r15)     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Object r2 = com.google.android.gms.internal.measurement.zzff.zza((java.lang.Object) r2, (java.lang.Object) r3)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0525:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzhd r2 = r12.zza((int) r3)     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Object r2 = r14.zza(r2, r15)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r2)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x053a:
            r12.zza((java.lang.Object) r13, (int) r4, (com.google.android.gms.internal.measurement.zzhe) r14)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0542:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x05e1 }
            boolean r2 = r14.zzk()     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (boolean) r2)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0552:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x05e1 }
            int r2 = r14.zzj()     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (int) r2)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0562:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x05e1 }
            long r6 = r14.zzi()     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (long) r6)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0572:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x05e1 }
            int r2 = r14.zzh()     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (int) r2)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0582:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x05e1 }
            long r6 = r14.zzf()     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (long) r6)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0592:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x05e1 }
            long r6 = r14.zzg()     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (long) r6)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x05a2:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x05e1 }
            float r2 = r14.zze()     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (float) r2)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x05b2:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x05e1 }
            double r6 = r14.zzd()     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (double) r6)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x05c2:
            boolean r2 = r8.zza(r10, (com.google.android.gms.internal.measurement.zzhe) r14)     // Catch:{ zzfn -> 0x05e1 }
            if (r2 != 0) goto L_0x05df
            int r14 = r12.zzm
        L_0x05ca:
            int r15 = r12.zzn
            if (r14 >= r15) goto L_0x05d9
            int[] r15 = r12.zzl
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x05ca
        L_0x05d9:
            if (r10 == 0) goto L_0x05de
            r8.zzb((java.lang.Object) r13, r10)
        L_0x05de:
            return
        L_0x05df:
            goto L_0x000a
        L_0x05e1:
            r2 = move-exception
            r8.zza((com.google.android.gms.internal.measurement.zzhe) r14)     // Catch:{ all -> 0x060b }
            if (r10 != 0) goto L_0x05ec
            java.lang.Object r2 = r8.zzc(r13)     // Catch:{ all -> 0x060b }
            r10 = r2
        L_0x05ec:
            boolean r2 = r8.zza(r10, (com.google.android.gms.internal.measurement.zzhe) r14)     // Catch:{ all -> 0x060b }
            if (r2 != 0) goto L_0x0609
            int r14 = r12.zzm
        L_0x05f4:
            int r15 = r12.zzn
            if (r14 >= r15) goto L_0x0603
            int[] r15 = r12.zzl
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x05f4
        L_0x0603:
            if (r10 == 0) goto L_0x0608
            r8.zzb((java.lang.Object) r13, r10)
        L_0x0608:
            return
        L_0x0609:
            goto L_0x000a
        L_0x060b:
            r14 = move-exception
            int r15 = r12.zzm
        L_0x060e:
            int r0 = r12.zzn
            if (r15 >= r0) goto L_0x061d
            int[] r0 = r12.zzl
            r0 = r0[r15]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r0, r10, r8)
            int r15 = r15 + 1
            goto L_0x060e
        L_0x061d:
            if (r10 == 0) goto L_0x0622
            r8.zzb((java.lang.Object) r13, r10)
        L_0x0622:
            throw r14
        L_0x0623:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzhe, com.google.android.gms.internal.measurement.zzeq):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x05ad  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x05f0  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0b5e  */
    public final void zza(T t, zzis zzis) throws IOException {
        Map.Entry entry;
        Iterator it;
        int length;
        int i;
        Map.Entry entry2;
        Iterator it2;
        int length2;
        if (zzis.zza() == zzfd.zze.zzk) {
            zza(this.zzq, t, zzis);
            if (this.zzh) {
                zzew zza2 = this.zzr.zza((Object) t);
                if (!zza2.zza.isEmpty()) {
                    it2 = zza2.zze();
                    entry2 = (Map.Entry) it2.next();
                    for (length2 = this.zzc.length - 3; length2 >= 0; length2 -= 3) {
                        int zzd2 = zzd(length2);
                        int i2 = this.zzc[length2];
                        while (entry2 != null && this.zzr.zza((Map.Entry<?, ?>) entry2) > i2) {
                            this.zzr.zza(zzis, entry2);
                            entry2 = it2.hasNext() ? (Map.Entry) it2.next() : null;
                        }
                        switch ((zzd2 & 267386880) >>> 20) {
                            case 0:
                                if (!zza(t, length2)) {
                                    break;
                                } else {
                                    zzis.zza(i2, zzib.zze(t, (long) (zzd2 & 1048575)));
                                    break;
                                }
                            case 1:
                                if (!zza(t, length2)) {
                                    break;
                                } else {
                                    zzis.zza(i2, zzib.zzd(t, (long) (zzd2 & 1048575)));
                                    break;
                                }
                            case 2:
                                if (!zza(t, length2)) {
                                    break;
                                } else {
                                    zzis.zza(i2, zzib.zzb(t, (long) (zzd2 & 1048575)));
                                    break;
                                }
                            case 3:
                                if (!zza(t, length2)) {
                                    break;
                                } else {
                                    zzis.zzc(i2, zzib.zzb(t, (long) (zzd2 & 1048575)));
                                    break;
                                }
                            case 4:
                                if (!zza(t, length2)) {
                                    break;
                                } else {
                                    zzis.zzc(i2, zzib.zza((Object) t, (long) (zzd2 & 1048575)));
                                    break;
                                }
                            case 5:
                                if (!zza(t, length2)) {
                                    break;
                                } else {
                                    zzis.zzd(i2, zzib.zzb(t, (long) (zzd2 & 1048575)));
                                    break;
                                }
                            case 6:
                                if (!zza(t, length2)) {
                                    break;
                                } else {
                                    zzis.zzd(i2, zzib.zza((Object) t, (long) (zzd2 & 1048575)));
                                    break;
                                }
                            case 7:
                                if (!zza(t, length2)) {
                                    break;
                                } else {
                                    zzis.zza(i2, zzib.zzc(t, (long) (zzd2 & 1048575)));
                                    break;
                                }
                            case 8:
                                if (!zza(t, length2)) {
                                    break;
                                } else {
                                    zza(i2, zzib.zzf(t, (long) (zzd2 & 1048575)), zzis);
                                    break;
                                }
                            case 9:
                                if (!zza(t, length2)) {
                                    break;
                                } else {
                                    zzis.zza(i2, zzib.zzf(t, (long) (zzd2 & 1048575)), zza(length2));
                                    break;
                                }
                            case 10:
                                if (!zza(t, length2)) {
                                    break;
                                } else {
                                    zzis.zza(i2, (zzdu) zzib.zzf(t, (long) (zzd2 & 1048575)));
                                    break;
                                }
                            case 11:
                                if (!zza(t, length2)) {
                                    break;
                                } else {
                                    zzis.zze(i2, zzib.zza((Object) t, (long) (zzd2 & 1048575)));
                                    break;
                                }
                            case 12:
                                if (!zza(t, length2)) {
                                    break;
                                } else {
                                    zzis.zzb(i2, zzib.zza((Object) t, (long) (zzd2 & 1048575)));
                                    break;
                                }
                            case 13:
                                if (!zza(t, length2)) {
                                    break;
                                } else {
                                    zzis.zza(i2, zzib.zza((Object) t, (long) (zzd2 & 1048575)));
                                    break;
                                }
                            case 14:
                                if (!zza(t, length2)) {
                                    break;
                                } else {
                                    zzis.zzb(i2, zzib.zzb(t, (long) (zzd2 & 1048575)));
                                    break;
                                }
                            case 15:
                                if (!zza(t, length2)) {
                                    break;
                                } else {
                                    zzis.zzf(i2, zzib.zza((Object) t, (long) (zzd2 & 1048575)));
                                    break;
                                }
                            case 16:
                                if (!zza(t, length2)) {
                                    break;
                                } else {
                                    zzis.zze(i2, zzib.zzb(t, (long) (zzd2 & 1048575)));
                                    break;
                                }
                            case 17:
                                if (!zza(t, length2)) {
                                    break;
                                } else {
                                    zzis.zzb(i2, zzib.zzf(t, (long) (zzd2 & 1048575)), zza(length2));
                                    break;
                                }
                            case 18:
                                zzhf.zza(this.zzc[length2], (List<Double>) (List) zzib.zzf(t, (long) (zzd2 & 1048575)), zzis, false);
                                break;
                            case 19:
                                zzhf.zzb(this.zzc[length2], (List<Float>) (List) zzib.zzf(t, (long) (zzd2 & 1048575)), zzis, false);
                                break;
                            case 20:
                                zzhf.zzc(this.zzc[length2], (List) zzib.zzf(t, (long) (zzd2 & 1048575)), zzis, false);
                                break;
                            case 21:
                                zzhf.zzd(this.zzc[length2], (List) zzib.zzf(t, (long) (zzd2 & 1048575)), zzis, false);
                                break;
                            case 22:
                                zzhf.zzh(this.zzc[length2], (List) zzib.zzf(t, (long) (zzd2 & 1048575)), zzis, false);
                                break;
                            case 23:
                                zzhf.zzf(this.zzc[length2], (List) zzib.zzf(t, (long) (zzd2 & 1048575)), zzis, false);
                                break;
                            case 24:
                                zzhf.zzk(this.zzc[length2], (List) zzib.zzf(t, (long) (zzd2 & 1048575)), zzis, false);
                                break;
                            case 25:
                                zzhf.zzn(this.zzc[length2], (List) zzib.zzf(t, (long) (zzd2 & 1048575)), zzis, false);
                                break;
                            case 26:
                                zzhf.zza(this.zzc[length2], (List<String>) (List) zzib.zzf(t, (long) (zzd2 & 1048575)), zzis);
                                break;
                            case 27:
                                zzhf.zza(this.zzc[length2], (List<?>) (List) zzib.zzf(t, (long) (zzd2 & 1048575)), zzis, zza(length2));
                                break;
                            case 28:
                                zzhf.zzb(this.zzc[length2], (List<zzdu>) (List) zzib.zzf(t, (long) (zzd2 & 1048575)), zzis);
                                break;
                            case 29:
                                zzhf.zzi(this.zzc[length2], (List) zzib.zzf(t, (long) (zzd2 & 1048575)), zzis, false);
                                break;
                            case 30:
                                zzhf.zzm(this.zzc[length2], (List) zzib.zzf(t, (long) (zzd2 & 1048575)), zzis, false);
                                break;
                            case 31:
                                zzhf.zzl(this.zzc[length2], (List) zzib.zzf(t, (long) (zzd2 & 1048575)), zzis, false);
                                break;
                            case 32:
                                zzhf.zzg(this.zzc[length2], (List) zzib.zzf(t, (long) (zzd2 & 1048575)), zzis, false);
                                break;
                            case 33:
                                zzhf.zzj(this.zzc[length2], (List) zzib.zzf(t, (long) (zzd2 & 1048575)), zzis, false);
                                break;
                            case 34:
                                zzhf.zze(this.zzc[length2], (List) zzib.zzf(t, (long) (zzd2 & 1048575)), zzis, false);
                                break;
                            case 35:
                                zzhf.zza(this.zzc[length2], (List<Double>) (List) zzib.zzf(t, (long) (zzd2 & 1048575)), zzis, true);
                                break;
                            case 36:
                                zzhf.zzb(this.zzc[length2], (List<Float>) (List) zzib.zzf(t, (long) (zzd2 & 1048575)), zzis, true);
                                break;
                            case 37:
                                zzhf.zzc(this.zzc[length2], (List) zzib.zzf(t, (long) (zzd2 & 1048575)), zzis, true);
                                break;
                            case 38:
                                zzhf.zzd(this.zzc[length2], (List) zzib.zzf(t, (long) (zzd2 & 1048575)), zzis, true);
                                break;
                            case 39:
                                zzhf.zzh(this.zzc[length2], (List) zzib.zzf(t, (long) (zzd2 & 1048575)), zzis, true);
                                break;
                            case 40:
                                zzhf.zzf(this.zzc[length2], (List) zzib.zzf(t, (long) (zzd2 & 1048575)), zzis, true);
                                break;
                            case 41:
                                zzhf.zzk(this.zzc[length2], (List) zzib.zzf(t, (long) (zzd2 & 1048575)), zzis, true);
                                break;
                            case 42:
                                zzhf.zzn(this.zzc[length2], (List) zzib.zzf(t, (long) (zzd2 & 1048575)), zzis, true);
                                break;
                            case 43:
                                zzhf.zzi(this.zzc[length2], (List) zzib.zzf(t, (long) (zzd2 & 1048575)), zzis, true);
                                break;
                            case 44:
                                zzhf.zzm(this.zzc[length2], (List) zzib.zzf(t, (long) (zzd2 & 1048575)), zzis, true);
                                break;
                            case 45:
                                zzhf.zzl(this.zzc[length2], (List) zzib.zzf(t, (long) (zzd2 & 1048575)), zzis, true);
                                break;
                            case 46:
                                zzhf.zzg(this.zzc[length2], (List) zzib.zzf(t, (long) (zzd2 & 1048575)), zzis, true);
                                break;
                            case 47:
                                zzhf.zzj(this.zzc[length2], (List) zzib.zzf(t, (long) (zzd2 & 1048575)), zzis, true);
                                break;
                            case 48:
                                zzhf.zze(this.zzc[length2], (List) zzib.zzf(t, (long) (zzd2 & 1048575)), zzis, true);
                                break;
                            case 49:
                                zzhf.zzb(this.zzc[length2], (List<?>) (List) zzib.zzf(t, (long) (zzd2 & 1048575)), zzis, zza(length2));
                                break;
                            case 50:
                                zza(zzis, i2, zzib.zzf(t, (long) (zzd2 & 1048575)), length2);
                                break;
                            case 51:
                                if (!zza(t, i2, length2)) {
                                    break;
                                } else {
                                    zzis.zza(i2, zzb(t, (long) (zzd2 & 1048575)));
                                    break;
                                }
                            case 52:
                                if (!zza(t, i2, length2)) {
                                    break;
                                } else {
                                    zzis.zza(i2, zzc(t, (long) (zzd2 & 1048575)));
                                    break;
                                }
                            case 53:
                                if (!zza(t, i2, length2)) {
                                    break;
                                } else {
                                    zzis.zza(i2, zze(t, (long) (zzd2 & 1048575)));
                                    break;
                                }
                            case 54:
                                if (!zza(t, i2, length2)) {
                                    break;
                                } else {
                                    zzis.zzc(i2, zze(t, (long) (zzd2 & 1048575)));
                                    break;
                                }
                            case 55:
                                if (!zza(t, i2, length2)) {
                                    break;
                                } else {
                                    zzis.zzc(i2, zzd(t, (long) (zzd2 & 1048575)));
                                    break;
                                }
                            case 56:
                                if (!zza(t, i2, length2)) {
                                    break;
                                } else {
                                    zzis.zzd(i2, zze(t, (long) (zzd2 & 1048575)));
                                    break;
                                }
                            case 57:
                                if (!zza(t, i2, length2)) {
                                    break;
                                } else {
                                    zzis.zzd(i2, zzd(t, (long) (zzd2 & 1048575)));
                                    break;
                                }
                            case 58:
                                if (!zza(t, i2, length2)) {
                                    break;
                                } else {
                                    zzis.zza(i2, zzf(t, (long) (zzd2 & 1048575)));
                                    break;
                                }
                            case 59:
                                if (!zza(t, i2, length2)) {
                                    break;
                                } else {
                                    zza(i2, zzib.zzf(t, (long) (zzd2 & 1048575)), zzis);
                                    break;
                                }
                            case 60:
                                if (!zza(t, i2, length2)) {
                                    break;
                                } else {
                                    zzis.zza(i2, zzib.zzf(t, (long) (zzd2 & 1048575)), zza(length2));
                                    break;
                                }
                            case 61:
                                if (!zza(t, i2, length2)) {
                                    break;
                                } else {
                                    zzis.zza(i2, (zzdu) zzib.zzf(t, (long) (zzd2 & 1048575)));
                                    break;
                                }
                            case 62:
                                if (!zza(t, i2, length2)) {
                                    break;
                                } else {
                                    zzis.zze(i2, zzd(t, (long) (zzd2 & 1048575)));
                                    break;
                                }
                            case 63:
                                if (!zza(t, i2, length2)) {
                                    break;
                                } else {
                                    zzis.zzb(i2, zzd(t, (long) (zzd2 & 1048575)));
                                    break;
                                }
                            case 64:
                                if (!zza(t, i2, length2)) {
                                    break;
                                } else {
                                    zzis.zza(i2, zzd(t, (long) (zzd2 & 1048575)));
                                    break;
                                }
                            case 65:
                                if (!zza(t, i2, length2)) {
                                    break;
                                } else {
                                    zzis.zzb(i2, zze(t, (long) (zzd2 & 1048575)));
                                    break;
                                }
                            case 66:
                                if (!zza(t, i2, length2)) {
                                    break;
                                } else {
                                    zzis.zzf(i2, zzd(t, (long) (zzd2 & 1048575)));
                                    break;
                                }
                            case 67:
                                if (!zza(t, i2, length2)) {
                                    break;
                                } else {
                                    zzis.zze(i2, zze(t, (long) (zzd2 & 1048575)));
                                    break;
                                }
                            case 68:
                                if (!zza(t, i2, length2)) {
                                    break;
                                } else {
                                    zzis.zzb(i2, zzib.zzf(t, (long) (zzd2 & 1048575)), zza(length2));
                                    break;
                                }
                        }
                    }
                    while (entry2 != null) {
                        this.zzr.zza(zzis, entry2);
                        entry2 = it2.hasNext() ? (Map.Entry) it2.next() : null;
                    }
                }
            }
            it2 = null;
            entry2 = null;
            while (length2 >= 0) {
            }
            while (entry2 != null) {
            }
        } else if (this.zzj) {
            if (this.zzh) {
                zzew zza3 = this.zzr.zza((Object) t);
                if (!zza3.zza.isEmpty()) {
                    it = zza3.zzd();
                    entry = (Map.Entry) it.next();
                    length = this.zzc.length;
                    for (i = 0; i < length; i += 3) {
                        int zzd3 = zzd(i);
                        int i3 = this.zzc[i];
                        while (entry != null && this.zzr.zza((Map.Entry<?, ?>) entry) <= i3) {
                            this.zzr.zza(zzis, entry);
                            entry = it.hasNext() ? (Map.Entry) it.next() : null;
                        }
                        switch ((zzd3 & 267386880) >>> 20) {
                            case 0:
                                if (!zza(t, i)) {
                                    break;
                                } else {
                                    zzis.zza(i3, zzib.zze(t, (long) (zzd3 & 1048575)));
                                    break;
                                }
                            case 1:
                                if (!zza(t, i)) {
                                    break;
                                } else {
                                    zzis.zza(i3, zzib.zzd(t, (long) (zzd3 & 1048575)));
                                    break;
                                }
                            case 2:
                                if (!zza(t, i)) {
                                    break;
                                } else {
                                    zzis.zza(i3, zzib.zzb(t, (long) (zzd3 & 1048575)));
                                    break;
                                }
                            case 3:
                                if (!zza(t, i)) {
                                    break;
                                } else {
                                    zzis.zzc(i3, zzib.zzb(t, (long) (zzd3 & 1048575)));
                                    break;
                                }
                            case 4:
                                if (!zza(t, i)) {
                                    break;
                                } else {
                                    zzis.zzc(i3, zzib.zza((Object) t, (long) (zzd3 & 1048575)));
                                    break;
                                }
                            case 5:
                                if (!zza(t, i)) {
                                    break;
                                } else {
                                    zzis.zzd(i3, zzib.zzb(t, (long) (zzd3 & 1048575)));
                                    break;
                                }
                            case 6:
                                if (!zza(t, i)) {
                                    break;
                                } else {
                                    zzis.zzd(i3, zzib.zza((Object) t, (long) (zzd3 & 1048575)));
                                    break;
                                }
                            case 7:
                                if (!zza(t, i)) {
                                    break;
                                } else {
                                    zzis.zza(i3, zzib.zzc(t, (long) (zzd3 & 1048575)));
                                    break;
                                }
                            case 8:
                                if (!zza(t, i)) {
                                    break;
                                } else {
                                    zza(i3, zzib.zzf(t, (long) (zzd3 & 1048575)), zzis);
                                    break;
                                }
                            case 9:
                                if (!zza(t, i)) {
                                    break;
                                } else {
                                    zzis.zza(i3, zzib.zzf(t, (long) (zzd3 & 1048575)), zza(i));
                                    break;
                                }
                            case 10:
                                if (!zza(t, i)) {
                                    break;
                                } else {
                                    zzis.zza(i3, (zzdu) zzib.zzf(t, (long) (zzd3 & 1048575)));
                                    break;
                                }
                            case 11:
                                if (!zza(t, i)) {
                                    break;
                                } else {
                                    zzis.zze(i3, zzib.zza((Object) t, (long) (zzd3 & 1048575)));
                                    break;
                                }
                            case 12:
                                if (!zza(t, i)) {
                                    break;
                                } else {
                                    zzis.zzb(i3, zzib.zza((Object) t, (long) (zzd3 & 1048575)));
                                    break;
                                }
                            case 13:
                                if (!zza(t, i)) {
                                    break;
                                } else {
                                    zzis.zza(i3, zzib.zza((Object) t, (long) (zzd3 & 1048575)));
                                    break;
                                }
                            case 14:
                                if (!zza(t, i)) {
                                    break;
                                } else {
                                    zzis.zzb(i3, zzib.zzb(t, (long) (zzd3 & 1048575)));
                                    break;
                                }
                            case 15:
                                if (!zza(t, i)) {
                                    break;
                                } else {
                                    zzis.zzf(i3, zzib.zza((Object) t, (long) (zzd3 & 1048575)));
                                    break;
                                }
                            case 16:
                                if (!zza(t, i)) {
                                    break;
                                } else {
                                    zzis.zze(i3, zzib.zzb(t, (long) (zzd3 & 1048575)));
                                    break;
                                }
                            case 17:
                                if (!zza(t, i)) {
                                    break;
                                } else {
                                    zzis.zzb(i3, zzib.zzf(t, (long) (zzd3 & 1048575)), zza(i));
                                    break;
                                }
                            case 18:
                                zzhf.zza(this.zzc[i], (List<Double>) (List) zzib.zzf(t, (long) (zzd3 & 1048575)), zzis, false);
                                break;
                            case 19:
                                zzhf.zzb(this.zzc[i], (List<Float>) (List) zzib.zzf(t, (long) (zzd3 & 1048575)), zzis, false);
                                break;
                            case 20:
                                zzhf.zzc(this.zzc[i], (List) zzib.zzf(t, (long) (zzd3 & 1048575)), zzis, false);
                                break;
                            case 21:
                                zzhf.zzd(this.zzc[i], (List) zzib.zzf(t, (long) (zzd3 & 1048575)), zzis, false);
                                break;
                            case 22:
                                zzhf.zzh(this.zzc[i], (List) zzib.zzf(t, (long) (zzd3 & 1048575)), zzis, false);
                                break;
                            case 23:
                                zzhf.zzf(this.zzc[i], (List) zzib.zzf(t, (long) (zzd3 & 1048575)), zzis, false);
                                break;
                            case 24:
                                zzhf.zzk(this.zzc[i], (List) zzib.zzf(t, (long) (zzd3 & 1048575)), zzis, false);
                                break;
                            case 25:
                                zzhf.zzn(this.zzc[i], (List) zzib.zzf(t, (long) (zzd3 & 1048575)), zzis, false);
                                break;
                            case 26:
                                zzhf.zza(this.zzc[i], (List<String>) (List) zzib.zzf(t, (long) (zzd3 & 1048575)), zzis);
                                break;
                            case 27:
                                zzhf.zza(this.zzc[i], (List<?>) (List) zzib.zzf(t, (long) (zzd3 & 1048575)), zzis, zza(i));
                                break;
                            case 28:
                                zzhf.zzb(this.zzc[i], (List<zzdu>) (List) zzib.zzf(t, (long) (zzd3 & 1048575)), zzis);
                                break;
                            case 29:
                                zzhf.zzi(this.zzc[i], (List) zzib.zzf(t, (long) (zzd3 & 1048575)), zzis, false);
                                break;
                            case 30:
                                zzhf.zzm(this.zzc[i], (List) zzib.zzf(t, (long) (zzd3 & 1048575)), zzis, false);
                                break;
                            case 31:
                                zzhf.zzl(this.zzc[i], (List) zzib.zzf(t, (long) (zzd3 & 1048575)), zzis, false);
                                break;
                            case 32:
                                zzhf.zzg(this.zzc[i], (List) zzib.zzf(t, (long) (zzd3 & 1048575)), zzis, false);
                                break;
                            case 33:
                                zzhf.zzj(this.zzc[i], (List) zzib.zzf(t, (long) (zzd3 & 1048575)), zzis, false);
                                break;
                            case 34:
                                zzhf.zze(this.zzc[i], (List) zzib.zzf(t, (long) (zzd3 & 1048575)), zzis, false);
                                break;
                            case 35:
                                zzhf.zza(this.zzc[i], (List<Double>) (List) zzib.zzf(t, (long) (zzd3 & 1048575)), zzis, true);
                                break;
                            case 36:
                                zzhf.zzb(this.zzc[i], (List<Float>) (List) zzib.zzf(t, (long) (zzd3 & 1048575)), zzis, true);
                                break;
                            case 37:
                                zzhf.zzc(this.zzc[i], (List) zzib.zzf(t, (long) (zzd3 & 1048575)), zzis, true);
                                break;
                            case 38:
                                zzhf.zzd(this.zzc[i], (List) zzib.zzf(t, (long) (zzd3 & 1048575)), zzis, true);
                                break;
                            case 39:
                                zzhf.zzh(this.zzc[i], (List) zzib.zzf(t, (long) (zzd3 & 1048575)), zzis, true);
                                break;
                            case 40:
                                zzhf.zzf(this.zzc[i], (List) zzib.zzf(t, (long) (zzd3 & 1048575)), zzis, true);
                                break;
                            case 41:
                                zzhf.zzk(this.zzc[i], (List) zzib.zzf(t, (long) (zzd3 & 1048575)), zzis, true);
                                break;
                            case 42:
                                zzhf.zzn(this.zzc[i], (List) zzib.zzf(t, (long) (zzd3 & 1048575)), zzis, true);
                                break;
                            case 43:
                                zzhf.zzi(this.zzc[i], (List) zzib.zzf(t, (long) (zzd3 & 1048575)), zzis, true);
                                break;
                            case 44:
                                zzhf.zzm(this.zzc[i], (List) zzib.zzf(t, (long) (zzd3 & 1048575)), zzis, true);
                                break;
                            case 45:
                                zzhf.zzl(this.zzc[i], (List) zzib.zzf(t, (long) (zzd3 & 1048575)), zzis, true);
                                break;
                            case 46:
                                zzhf.zzg(this.zzc[i], (List) zzib.zzf(t, (long) (zzd3 & 1048575)), zzis, true);
                                break;
                            case 47:
                                zzhf.zzj(this.zzc[i], (List) zzib.zzf(t, (long) (zzd3 & 1048575)), zzis, true);
                                break;
                            case 48:
                                zzhf.zze(this.zzc[i], (List) zzib.zzf(t, (long) (zzd3 & 1048575)), zzis, true);
                                break;
                            case 49:
                                zzhf.zzb(this.zzc[i], (List<?>) (List) zzib.zzf(t, (long) (zzd3 & 1048575)), zzis, zza(i));
                                break;
                            case 50:
                                zza(zzis, i3, zzib.zzf(t, (long) (zzd3 & 1048575)), i);
                                break;
                            case 51:
                                if (!zza(t, i3, i)) {
                                    break;
                                } else {
                                    zzis.zza(i3, zzb(t, (long) (zzd3 & 1048575)));
                                    break;
                                }
                            case 52:
                                if (!zza(t, i3, i)) {
                                    break;
                                } else {
                                    zzis.zza(i3, zzc(t, (long) (zzd3 & 1048575)));
                                    break;
                                }
                            case 53:
                                if (!zza(t, i3, i)) {
                                    break;
                                } else {
                                    zzis.zza(i3, zze(t, (long) (zzd3 & 1048575)));
                                    break;
                                }
                            case 54:
                                if (!zza(t, i3, i)) {
                                    break;
                                } else {
                                    zzis.zzc(i3, zze(t, (long) (zzd3 & 1048575)));
                                    break;
                                }
                            case 55:
                                if (!zza(t, i3, i)) {
                                    break;
                                } else {
                                    zzis.zzc(i3, zzd(t, (long) (zzd3 & 1048575)));
                                    break;
                                }
                            case 56:
                                if (!zza(t, i3, i)) {
                                    break;
                                } else {
                                    zzis.zzd(i3, zze(t, (long) (zzd3 & 1048575)));
                                    break;
                                }
                            case 57:
                                if (!zza(t, i3, i)) {
                                    break;
                                } else {
                                    zzis.zzd(i3, zzd(t, (long) (zzd3 & 1048575)));
                                    break;
                                }
                            case 58:
                                if (!zza(t, i3, i)) {
                                    break;
                                } else {
                                    zzis.zza(i3, zzf(t, (long) (zzd3 & 1048575)));
                                    break;
                                }
                            case 59:
                                if (!zza(t, i3, i)) {
                                    break;
                                } else {
                                    zza(i3, zzib.zzf(t, (long) (zzd3 & 1048575)), zzis);
                                    break;
                                }
                            case 60:
                                if (!zza(t, i3, i)) {
                                    break;
                                } else {
                                    zzis.zza(i3, zzib.zzf(t, (long) (zzd3 & 1048575)), zza(i));
                                    break;
                                }
                            case 61:
                                if (!zza(t, i3, i)) {
                                    break;
                                } else {
                                    zzis.zza(i3, (zzdu) zzib.zzf(t, (long) (zzd3 & 1048575)));
                                    break;
                                }
                            case 62:
                                if (!zza(t, i3, i)) {
                                    break;
                                } else {
                                    zzis.zze(i3, zzd(t, (long) (zzd3 & 1048575)));
                                    break;
                                }
                            case 63:
                                if (!zza(t, i3, i)) {
                                    break;
                                } else {
                                    zzis.zzb(i3, zzd(t, (long) (zzd3 & 1048575)));
                                    break;
                                }
                            case 64:
                                if (!zza(t, i3, i)) {
                                    break;
                                } else {
                                    zzis.zza(i3, zzd(t, (long) (zzd3 & 1048575)));
                                    break;
                                }
                            case 65:
                                if (!zza(t, i3, i)) {
                                    break;
                                } else {
                                    zzis.zzb(i3, zze(t, (long) (zzd3 & 1048575)));
                                    break;
                                }
                            case 66:
                                if (!zza(t, i3, i)) {
                                    break;
                                } else {
                                    zzis.zzf(i3, zzd(t, (long) (zzd3 & 1048575)));
                                    break;
                                }
                            case 67:
                                if (!zza(t, i3, i)) {
                                    break;
                                } else {
                                    zzis.zze(i3, zze(t, (long) (zzd3 & 1048575)));
                                    break;
                                }
                            case 68:
                                if (!zza(t, i3, i)) {
                                    break;
                                } else {
                                    zzis.zzb(i3, zzib.zzf(t, (long) (zzd3 & 1048575)), zza(i));
                                    break;
                                }
                        }
                    }
                    while (entry != null) {
                        this.zzr.zza(zzis, entry);
                        entry = it.hasNext() ? (Map.Entry) it.next() : null;
                    }
                    zza(this.zzq, t, zzis);
                }
            }
            it = null;
            entry = null;
            length = this.zzc.length;
            while (i < length) {
            }
            while (entry != null) {
            }
            zza(this.zzq, t, zzis);
        } else {
            zzb(t, zzis);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v2, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    public final void zza(T t, byte[] bArr, int i, int i2, zzdt zzdt) throws IOException {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Unsafe unsafe;
        int i8;
        int i9;
        zzgs zzgs = this;
        T t2 = t;
        byte[] bArr2 = bArr;
        int i10 = i2;
        zzdt zzdt2 = zzdt;
        if (zzgs.zzj) {
            Unsafe unsafe2 = zzb;
            int i11 = -1;
            int i12 = i;
            int i13 = -1;
            int i14 = 0;
            while (i12 < i10) {
                int i15 = i12 + 1;
                byte b2 = bArr2[i12];
                if (b2 < 0) {
                    i4 = zzdq.zza((int) b2, bArr2, i15, zzdt2);
                    i3 = zzdt2.zza;
                } else {
                    i3 = b2;
                    i4 = i15;
                }
                int i16 = i3 >>> 3;
                int i17 = i3 & 7;
                int zza2 = i16 > i13 ? zzgs.zza(i16, i14 / 3) : zzgs.zzg(i16);
                if (zza2 == i11) {
                    i6 = i16;
                    i8 = i4;
                    unsafe = unsafe2;
                    i5 = i11;
                    i7 = 0;
                } else {
                    int i18 = zzgs.zzc[zza2 + 1];
                    int i19 = (267386880 & i18) >>> 20;
                    long j = (long) (1048575 & i18);
                    if (i19 <= 17) {
                        boolean z = true;
                        switch (i19) {
                            case 0:
                                long j2 = j;
                                int i20 = zza2;
                                if (i17 != 1) {
                                    i6 = i16;
                                    i9 = i4;
                                    unsafe = unsafe2;
                                    i7 = i20;
                                    i5 = -1;
                                    break;
                                } else {
                                    zzib.zza((Object) t2, j2, zzdq.zzc(bArr2, i4));
                                    i12 = i4 + 8;
                                    i13 = i16;
                                    i14 = i20;
                                    i11 = -1;
                                    continue;
                                }
                            case 1:
                                long j3 = j;
                                int i21 = zza2;
                                if (i17 != 5) {
                                    i6 = i16;
                                    i9 = i4;
                                    unsafe = unsafe2;
                                    i7 = i21;
                                    i5 = -1;
                                    break;
                                } else {
                                    zzib.zza((Object) t2, j3, zzdq.zzd(bArr2, i4));
                                    i12 = i4 + 4;
                                    i13 = i16;
                                    i14 = i21;
                                    i11 = -1;
                                    continue;
                                }
                            case 2:
                            case 3:
                                long j4 = j;
                                int i22 = zza2;
                                if (i17 != 0) {
                                    i6 = i16;
                                    i9 = i4;
                                    unsafe = unsafe2;
                                    i7 = i22;
                                    i5 = -1;
                                    break;
                                } else {
                                    int zzb2 = zzdq.zzb(bArr2, i4, zzdt2);
                                    unsafe2.putLong(t, j4, zzdt2.zzb);
                                    i12 = zzb2;
                                    i13 = i16;
                                    i14 = i22;
                                    i11 = -1;
                                    continue;
                                }
                            case 4:
                            case 11:
                                long j5 = j;
                                int i23 = zza2;
                                if (i17 != 0) {
                                    i6 = i16;
                                    i9 = i4;
                                    unsafe = unsafe2;
                                    i7 = i23;
                                    i5 = -1;
                                    break;
                                } else {
                                    i12 = zzdq.zza(bArr2, i4, zzdt2);
                                    unsafe2.putInt(t2, j5, zzdt2.zza);
                                    i13 = i16;
                                    i14 = i23;
                                    i11 = -1;
                                    continue;
                                }
                            case 5:
                            case 14:
                                long j6 = j;
                                if (i17 != 1) {
                                    i6 = i16;
                                    i9 = i4;
                                    unsafe = unsafe2;
                                    i7 = zza2;
                                    i5 = -1;
                                    break;
                                } else {
                                    unsafe2.putLong(t, j6, zzdq.zzb(bArr2, i4));
                                    i12 = i4 + 8;
                                    i13 = i16;
                                    i14 = zza2;
                                    i11 = -1;
                                    continue;
                                }
                            case 6:
                            case 13:
                                long j7 = j;
                                if (i17 != 5) {
                                    i7 = zza2;
                                    i6 = i16;
                                    i9 = i4;
                                    unsafe = unsafe2;
                                    i5 = -1;
                                    break;
                                } else {
                                    unsafe2.putInt(t2, j7, zzdq.zza(bArr2, i4));
                                    i12 = i4 + 4;
                                    i14 = zza2;
                                    i13 = i16;
                                    i11 = -1;
                                    continue;
                                }
                            case 7:
                                long j8 = j;
                                if (i17 != 0) {
                                    i7 = zza2;
                                    i6 = i16;
                                    i9 = i4;
                                    unsafe = unsafe2;
                                    i5 = -1;
                                    break;
                                } else {
                                    int zzb3 = zzdq.zzb(bArr2, i4, zzdt2);
                                    if (zzdt2.zzb == 0) {
                                        z = false;
                                    }
                                    zzib.zza((Object) t2, j8, z);
                                    i12 = zzb3;
                                    i14 = zza2;
                                    i13 = i16;
                                    i11 = -1;
                                    continue;
                                }
                            case 8:
                                long j9 = j;
                                if (i17 != 2) {
                                    i7 = zza2;
                                    i6 = i16;
                                    i9 = i4;
                                    unsafe = unsafe2;
                                    i5 = -1;
                                    break;
                                } else {
                                    i12 = (536870912 & i18) == 0 ? zzdq.zzc(bArr2, i4, zzdt2) : zzdq.zzd(bArr2, i4, zzdt2);
                                    unsafe2.putObject(t2, j9, zzdt2.zzc);
                                    i14 = zza2;
                                    i13 = i16;
                                    i11 = -1;
                                    continue;
                                }
                            case 9:
                                long j10 = j;
                                if (i17 != 2) {
                                    i7 = zza2;
                                    i6 = i16;
                                    i9 = i4;
                                    unsafe = unsafe2;
                                    i5 = -1;
                                    break;
                                } else {
                                    i12 = zzdq.zza(zzgs.zza(zza2), bArr2, i4, i10, zzdt2);
                                    Object object = unsafe2.getObject(t2, j10);
                                    if (object == null) {
                                        unsafe2.putObject(t2, j10, zzdt2.zzc);
                                    } else {
                                        unsafe2.putObject(t2, j10, zzff.zza(object, zzdt2.zzc));
                                    }
                                    i14 = zza2;
                                    i13 = i16;
                                    i11 = -1;
                                    continue;
                                }
                            case 10:
                                long j11 = j;
                                if (i17 != 2) {
                                    i7 = zza2;
                                    i6 = i16;
                                    i9 = i4;
                                    unsafe = unsafe2;
                                    i5 = -1;
                                    break;
                                } else {
                                    i12 = zzdq.zze(bArr2, i4, zzdt2);
                                    unsafe2.putObject(t2, j11, zzdt2.zzc);
                                    i14 = zza2;
                                    i13 = i16;
                                    i11 = -1;
                                    continue;
                                }
                            case 12:
                                long j12 = j;
                                int i24 = zza2;
                                if (i17 != 0) {
                                    i6 = i16;
                                    i9 = i4;
                                    unsafe = unsafe2;
                                    i7 = i24;
                                    i5 = -1;
                                    break;
                                } else {
                                    i12 = zzdq.zza(bArr2, i4, zzdt2);
                                    unsafe2.putInt(t2, j12, zzdt2.zza);
                                    i13 = i16;
                                    i14 = i24;
                                    i11 = -1;
                                    continue;
                                }
                            case 15:
                                long j13 = j;
                                int i25 = zza2;
                                if (i17 != 0) {
                                    i6 = i16;
                                    i9 = i4;
                                    unsafe = unsafe2;
                                    i7 = i25;
                                    i5 = -1;
                                    break;
                                } else {
                                    i12 = zzdq.zza(bArr2, i4, zzdt2);
                                    unsafe2.putInt(t2, j13, zzeg.zze(zzdt2.zza));
                                    i13 = i16;
                                    i14 = i25;
                                    i11 = -1;
                                    continue;
                                }
                            case 16:
                                if (i17 != 0) {
                                    i6 = i16;
                                    i9 = i4;
                                    unsafe = unsafe2;
                                    i7 = zza2;
                                    i5 = -1;
                                    break;
                                } else {
                                    int zzb4 = zzdq.zzb(bArr2, i4, zzdt2);
                                    unsafe2.putLong(t, j, zzeg.zza(zzdt2.zzb));
                                    i12 = zzb4;
                                    i13 = i16;
                                    i14 = zza2;
                                    i11 = -1;
                                    continue;
                                }
                            default:
                                i6 = i16;
                                i9 = i4;
                                unsafe = unsafe2;
                                i7 = zza2;
                                i5 = -1;
                                break;
                        }
                    } else if (i19 != 27) {
                        i7 = zza2;
                        if (i19 <= 49) {
                            i6 = i16;
                            int i26 = i4;
                            unsafe = unsafe2;
                            i5 = -1;
                            i12 = zza(t, bArr, i4, i2, i3, i16, i17, i7, (long) i18, i19, j, zzdt);
                            if (i12 == i26) {
                                i8 = i12;
                            } else {
                                zzgs = this;
                                t2 = t;
                                bArr2 = bArr;
                                i10 = i2;
                                zzdt2 = zzdt;
                                unsafe2 = unsafe;
                                i14 = i7;
                                i13 = i6;
                                i11 = -1;
                            }
                        } else {
                            long j14 = j;
                            int i27 = i17;
                            i6 = i16;
                            i9 = i4;
                            unsafe = unsafe2;
                            i5 = -1;
                            int i28 = i19;
                            if (i28 != 50) {
                                i12 = zza(t, bArr, i9, i2, i3, i6, i27, i18, i28, j14, i7, zzdt);
                                if (i12 == i9) {
                                    i8 = i12;
                                } else {
                                    zzgs = this;
                                    t2 = t;
                                    bArr2 = bArr;
                                    i10 = i2;
                                    zzdt2 = zzdt;
                                    unsafe2 = unsafe;
                                    i14 = i7;
                                    i13 = i6;
                                    i11 = -1;
                                }
                            } else if (i27 == 2) {
                                i12 = zza(t, bArr, i9, i2, i7, j14, zzdt);
                                if (i12 == i9) {
                                    i8 = i12;
                                } else {
                                    zzgs = this;
                                    t2 = t;
                                    bArr2 = bArr;
                                    i10 = i2;
                                    zzdt2 = zzdt;
                                    unsafe2 = unsafe;
                                    i14 = i7;
                                    i13 = i6;
                                    i11 = -1;
                                }
                            }
                        }
                    } else if (i17 == 2) {
                        zzfl zzfl = (zzfl) unsafe2.getObject(t2, j);
                        if (!zzfl.zza()) {
                            int size = zzfl.size();
                            zzfl = zzfl.zza(size == 0 ? 10 : size << 1);
                            unsafe2.putObject(t2, j, zzfl);
                        }
                        i12 = zzdq.zza(zzgs.zza(zza2), i3, bArr, i4, i2, zzfl, zzdt);
                        i13 = i16;
                        i14 = zza2;
                        i11 = -1;
                    } else {
                        i7 = zza2;
                        i6 = i16;
                        i9 = i4;
                        unsafe = unsafe2;
                        i5 = -1;
                    }
                    i8 = i9;
                }
                i12 = zzdq.zza(i3, bArr, i8, i2, zze((Object) t), zzdt);
                zzgs = this;
                t2 = t;
                bArr2 = bArr;
                i10 = i2;
                zzdt2 = zzdt;
                unsafe2 = unsafe;
                i14 = i7;
                i13 = i6;
                i11 = i5;
            }
            if (i12 != i2) {
                throw zzfo.zzg();
            }
            return;
        }
        int i29 = i10;
        zza(t, bArr, i, i2, 0, zzdt);
    }

    public final boolean zza(T t, T t2) {
        int length = this.zzc.length;
        int i = 0;
        while (true) {
            boolean z = true;
            if (i < length) {
                int zzd2 = zzd(i);
                long j = (long) (zzd2 & 1048575);
                switch ((zzd2 & 267386880) >>> 20) {
                    case 0:
                        if (!zzc(t, t2, i) || Double.doubleToLongBits(zzib.zze(t, j)) != Double.doubleToLongBits(zzib.zze(t2, j))) {
                            z = false;
                            break;
                        }
                    case 1:
                        if (!zzc(t, t2, i) || Float.floatToIntBits(zzib.zzd(t, j)) != Float.floatToIntBits(zzib.zzd(t2, j))) {
                            z = false;
                            break;
                        }
                    case 2:
                        if (!zzc(t, t2, i) || zzib.zzb(t, j) != zzib.zzb(t2, j)) {
                            z = false;
                            break;
                        }
                    case 3:
                        if (!zzc(t, t2, i) || zzib.zzb(t, j) != zzib.zzb(t2, j)) {
                            z = false;
                            break;
                        }
                    case 4:
                        if (!zzc(t, t2, i) || zzib.zza((Object) t, j) != zzib.zza((Object) t2, j)) {
                            z = false;
                            break;
                        }
                    case 5:
                        if (!zzc(t, t2, i) || zzib.zzb(t, j) != zzib.zzb(t2, j)) {
                            z = false;
                            break;
                        }
                    case 6:
                        if (!zzc(t, t2, i) || zzib.zza((Object) t, j) != zzib.zza((Object) t2, j)) {
                            z = false;
                            break;
                        }
                    case 7:
                        if (!zzc(t, t2, i) || zzib.zzc(t, j) != zzib.zzc(t2, j)) {
                            z = false;
                            break;
                        }
                    case 8:
                        if (!zzc(t, t2, i) || !zzhf.zza(zzib.zzf(t, j), zzib.zzf(t2, j))) {
                            z = false;
                            break;
                        }
                    case 9:
                        if (!zzc(t, t2, i) || !zzhf.zza(zzib.zzf(t, j), zzib.zzf(t2, j))) {
                            z = false;
                            break;
                        }
                    case 10:
                        if (!zzc(t, t2, i) || !zzhf.zza(zzib.zzf(t, j), zzib.zzf(t2, j))) {
                            z = false;
                            break;
                        }
                    case 11:
                        if (!zzc(t, t2, i) || zzib.zza((Object) t, j) != zzib.zza((Object) t2, j)) {
                            z = false;
                            break;
                        }
                    case 12:
                        if (!zzc(t, t2, i) || zzib.zza((Object) t, j) != zzib.zza((Object) t2, j)) {
                            z = false;
                            break;
                        }
                    case 13:
                        if (!zzc(t, t2, i) || zzib.zza((Object) t, j) != zzib.zza((Object) t2, j)) {
                            z = false;
                            break;
                        }
                    case 14:
                        if (!zzc(t, t2, i) || zzib.zzb(t, j) != zzib.zzb(t2, j)) {
                            z = false;
                            break;
                        }
                    case 15:
                        if (!zzc(t, t2, i) || zzib.zza((Object) t, j) != zzib.zza((Object) t2, j)) {
                            z = false;
                            break;
                        }
                    case 16:
                        if (!zzc(t, t2, i) || zzib.zzb(t, j) != zzib.zzb(t2, j)) {
                            z = false;
                            break;
                        }
                    case 17:
                        if (!zzc(t, t2, i) || !zzhf.zza(zzib.zzf(t, j), zzib.zzf(t2, j))) {
                            z = false;
                            break;
                        }
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        z = zzhf.zza(zzib.zzf(t, j), zzib.zzf(t2, j));
                        break;
                    case 50:
                        z = zzhf.zza(zzib.zzf(t, j), zzib.zzf(t2, j));
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                    case 68:
                        long zze2 = (long) (zze(i) & 1048575);
                        if (zzib.zza((Object) t, zze2) != zzib.zza((Object) t2, zze2) || !zzhf.zza(zzib.zzf(t, j), zzib.zzf(t2, j))) {
                            z = false;
                            break;
                        }
                }
                if (!z) {
                    return false;
                }
                i += 3;
            } else if (!this.zzq.zzb(t).equals(this.zzq.zzb(t2))) {
                return false;
            } else {
                if (this.zzh) {
                    return this.zzr.zza((Object) t).equals(this.zzr.zza((Object) t2));
                }
                return true;
            }
        }
    }

    public final int zzb(T t) {
        int i;
        int i2;
        long j;
        boolean z;
        int i3;
        boolean z2;
        T t2 = t;
        int i4 = 267386880;
        boolean z3 = true;
        int i5 = 0;
        if (this.zzj) {
            Unsafe unsafe = zzb;
            int i6 = 0;
            int i7 = 0;
            while (i6 < this.zzc.length) {
                int zzd2 = zzd(i6);
                int i8 = (zzd2 & i4) >>> 20;
                int i9 = this.zzc[i6];
                long j2 = (long) (zzd2 & 1048575);
                int i10 = (i8 < zzex.DOUBLE_LIST_PACKED.zza() || i8 > zzex.SINT64_LIST_PACKED.zza()) ? 0 : this.zzc[i6 + 2] & 1048575;
                switch (i8) {
                    case 0:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzb(i9, 0.0d);
                            break;
                        }
                    case 1:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzb(i9, 0.0f);
                            break;
                        }
                    case 2:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzd(i9, zzib.zzb(t2, j2));
                            break;
                        }
                    case 3:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzen.zze(i9, zzib.zzb(t2, j2));
                            break;
                        }
                    case 4:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzf(i9, zzib.zza((Object) t2, j2));
                            break;
                        }
                    case 5:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzg(i9, 0);
                            break;
                        }
                    case 6:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzi(i9, 0);
                            break;
                        }
                    case 7:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzb(i9, true);
                            break;
                        }
                    case 8:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            Object zzf2 = zzib.zzf(t2, j2);
                            if (!(zzf2 instanceof zzdu)) {
                                i7 += zzen.zzb(i9, (String) zzf2);
                                break;
                            } else {
                                i7 += zzen.zzc(i9, (zzdu) zzf2);
                                break;
                            }
                        }
                    case 9:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzhf.zza(i9, zzib.zzf(t2, j2), zza(i6));
                            break;
                        }
                    case 10:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzc(i9, (zzdu) zzib.zzf(t2, j2));
                            break;
                        }
                    case 11:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzg(i9, zzib.zza((Object) t2, j2));
                            break;
                        }
                    case 12:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzk(i9, zzib.zza((Object) t2, j2));
                            break;
                        }
                    case 13:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzj(i9, 0);
                            break;
                        }
                    case 14:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzh(i9, 0);
                            break;
                        }
                    case 15:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzh(i9, zzib.zza((Object) t2, j2));
                            break;
                        }
                    case 16:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzf(i9, zzib.zzb(t2, j2));
                            break;
                        }
                    case 17:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzc(i9, (zzgo) zzib.zzf(t2, j2), zza(i6));
                            break;
                        }
                    case 18:
                        i7 += zzhf.zzi(i9, zza((Object) t2, j2), false);
                        break;
                    case 19:
                        i7 += zzhf.zzh(i9, zza((Object) t2, j2), false);
                        break;
                    case 20:
                        i7 += zzhf.zza(i9, (List<Long>) zza((Object) t2, j2), false);
                        break;
                    case 21:
                        i7 += zzhf.zzb(i9, (List<Long>) zza((Object) t2, j2), false);
                        break;
                    case 22:
                        i7 += zzhf.zze(i9, zza((Object) t2, j2), false);
                        break;
                    case 23:
                        i7 += zzhf.zzi(i9, zza((Object) t2, j2), false);
                        break;
                    case 24:
                        i7 += zzhf.zzh(i9, zza((Object) t2, j2), false);
                        break;
                    case 25:
                        i7 += zzhf.zzj(i9, zza((Object) t2, j2), false);
                        break;
                    case 26:
                        i7 += zzhf.zza(i9, zza((Object) t2, j2));
                        break;
                    case 27:
                        i7 += zzhf.zza(i9, zza((Object) t2, j2), zza(i6));
                        break;
                    case 28:
                        i7 += zzhf.zzb(i9, zza((Object) t2, j2));
                        break;
                    case 29:
                        i7 += zzhf.zzf(i9, zza((Object) t2, j2), false);
                        break;
                    case 30:
                        i7 += zzhf.zzd(i9, zza((Object) t2, j2), false);
                        break;
                    case 31:
                        i7 += zzhf.zzh(i9, zza((Object) t2, j2), false);
                        break;
                    case 32:
                        i7 += zzhf.zzi(i9, zza((Object) t2, j2), false);
                        break;
                    case 33:
                        i7 += zzhf.zzg(i9, zza((Object) t2, j2), false);
                        break;
                    case 34:
                        i7 += zzhf.zzc(i9, zza((Object) t2, j2), false);
                        break;
                    case 35:
                        int zzi2 = zzhf.zzi((List) unsafe.getObject(t2, j2));
                        if (zzi2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i10, zzi2);
                            }
                            i7 += zzen.zze(i9) + zzen.zzg(zzi2) + zzi2;
                            break;
                        } else {
                            break;
                        }
                    case 36:
                        int zzh2 = zzhf.zzh((List) unsafe.getObject(t2, j2));
                        if (zzh2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i10, zzh2);
                            }
                            i7 += zzen.zze(i9) + zzen.zzg(zzh2) + zzh2;
                            break;
                        } else {
                            break;
                        }
                    case 37:
                        int zza2 = zzhf.zza((List<Long>) (List) unsafe.getObject(t2, j2));
                        if (zza2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i10, zza2);
                            }
                            i7 += zzen.zze(i9) + zzen.zzg(zza2) + zza2;
                            break;
                        } else {
                            break;
                        }
                    case 38:
                        int zzb2 = zzhf.zzb((List) unsafe.getObject(t2, j2));
                        if (zzb2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i10, zzb2);
                            }
                            i7 += zzen.zze(i9) + zzen.zzg(zzb2) + zzb2;
                            break;
                        } else {
                            break;
                        }
                    case 39:
                        int zze2 = zzhf.zze((List) unsafe.getObject(t2, j2));
                        if (zze2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i10, zze2);
                            }
                            i7 += zzen.zze(i9) + zzen.zzg(zze2) + zze2;
                            break;
                        } else {
                            break;
                        }
                    case 40:
                        int zzi3 = zzhf.zzi((List) unsafe.getObject(t2, j2));
                        if (zzi3 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i10, zzi3);
                            }
                            i7 += zzen.zze(i9) + zzen.zzg(zzi3) + zzi3;
                            break;
                        } else {
                            break;
                        }
                    case 41:
                        int zzh3 = zzhf.zzh((List) unsafe.getObject(t2, j2));
                        if (zzh3 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i10, zzh3);
                            }
                            i7 += zzen.zze(i9) + zzen.zzg(zzh3) + zzh3;
                            break;
                        } else {
                            break;
                        }
                    case 42:
                        int zzj2 = zzhf.zzj((List) unsafe.getObject(t2, j2));
                        if (zzj2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i10, zzj2);
                            }
                            i7 += zzen.zze(i9) + zzen.zzg(zzj2) + zzj2;
                            break;
                        } else {
                            break;
                        }
                    case 43:
                        int zzf3 = zzhf.zzf((List) unsafe.getObject(t2, j2));
                        if (zzf3 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i10, zzf3);
                            }
                            i7 += zzen.zze(i9) + zzen.zzg(zzf3) + zzf3;
                            break;
                        } else {
                            break;
                        }
                    case 44:
                        int zzd3 = zzhf.zzd((List) unsafe.getObject(t2, j2));
                        if (zzd3 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i10, zzd3);
                            }
                            i7 += zzen.zze(i9) + zzen.zzg(zzd3) + zzd3;
                            break;
                        } else {
                            break;
                        }
                    case 45:
                        int zzh4 = zzhf.zzh((List) unsafe.getObject(t2, j2));
                        if (zzh4 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i10, zzh4);
                            }
                            i7 += zzen.zze(i9) + zzen.zzg(zzh4) + zzh4;
                            break;
                        } else {
                            break;
                        }
                    case 46:
                        int zzi4 = zzhf.zzi((List) unsafe.getObject(t2, j2));
                        if (zzi4 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i10, zzi4);
                            }
                            i7 += zzen.zze(i9) + zzen.zzg(zzi4) + zzi4;
                            break;
                        } else {
                            break;
                        }
                    case 47:
                        int zzg2 = zzhf.zzg((List) unsafe.getObject(t2, j2));
                        if (zzg2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i10, zzg2);
                            }
                            i7 += zzen.zze(i9) + zzen.zzg(zzg2) + zzg2;
                            break;
                        } else {
                            break;
                        }
                    case 48:
                        int zzc2 = zzhf.zzc((List) unsafe.getObject(t2, j2));
                        if (zzc2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i10, zzc2);
                            }
                            i7 += zzen.zze(i9) + zzen.zzg(zzc2) + zzc2;
                            break;
                        } else {
                            break;
                        }
                    case 49:
                        i7 += zzhf.zzb(i9, (List<zzgo>) zza((Object) t2, j2), zza(i6));
                        break;
                    case 50:
                        i7 += this.zzs.zza(i9, zzib.zzf(t2, j2), zzb(i6));
                        break;
                    case 51:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzb(i9, 0.0d);
                            break;
                        }
                    case 52:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzb(i9, 0.0f);
                            break;
                        }
                    case 53:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzd(i9, zze(t2, j2));
                            break;
                        }
                    case 54:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzen.zze(i9, zze(t2, j2));
                            break;
                        }
                    case 55:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzf(i9, zzd(t2, j2));
                            break;
                        }
                    case 56:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzg(i9, 0);
                            break;
                        }
                    case 57:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzi(i9, 0);
                            break;
                        }
                    case 58:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzb(i9, true);
                            break;
                        }
                    case 59:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            Object zzf4 = zzib.zzf(t2, j2);
                            if (!(zzf4 instanceof zzdu)) {
                                i7 += zzen.zzb(i9, (String) zzf4);
                                break;
                            } else {
                                i7 += zzen.zzc(i9, (zzdu) zzf4);
                                break;
                            }
                        }
                    case 60:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzhf.zza(i9, zzib.zzf(t2, j2), zza(i6));
                            break;
                        }
                    case 61:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzc(i9, (zzdu) zzib.zzf(t2, j2));
                            break;
                        }
                    case 62:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzg(i9, zzd(t2, j2));
                            break;
                        }
                    case 63:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzk(i9, zzd(t2, j2));
                            break;
                        }
                    case 64:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzj(i9, 0);
                            break;
                        }
                    case 65:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzh(i9, 0);
                            break;
                        }
                    case 66:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzh(i9, zzd(t2, j2));
                            break;
                        }
                    case 67:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzf(i9, zze(t2, j2));
                            break;
                        }
                    case 68:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzc(i9, (zzgo) zzib.zzf(t2, j2), zza(i6));
                            break;
                        }
                }
                i6 += 3;
                i4 = 267386880;
            }
            return i7 + zza(this.zzq, t2);
        }
        Unsafe unsafe2 = zzb;
        int i11 = -1;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i12 < this.zzc.length) {
            int zzd4 = zzd(i12);
            int[] iArr = this.zzc;
            int i15 = iArr[i12];
            int i16 = (zzd4 & 267386880) >>> 20;
            if (i16 <= 17) {
                int i17 = iArr[i12 + 2];
                int i18 = i17 & 1048575;
                i = (z3 ? 1 : 0) << (i17 >>> 20);
                if (i18 != i11) {
                    i14 = unsafe2.getInt(t2, (long) i18);
                    i11 = i18;
                }
                i2 = i17;
            } else if (!this.zzk || i16 < zzex.DOUBLE_LIST_PACKED.zza() || i16 > zzex.SINT64_LIST_PACKED.zza()) {
                i2 = 0;
                i = 0;
            } else {
                i2 = this.zzc[i12 + 2] & 1048575;
                i = 0;
            }
            long j3 = (long) (zzd4 & 1048575);
            switch (i16) {
                case 0:
                    z2 = true;
                    i3 = 0;
                    z = false;
                    j = 0;
                    if ((i14 & i) == 0) {
                        break;
                    } else {
                        i13 += zzen.zzb(i15, 0.0d);
                        break;
                    }
                case 1:
                    z2 = true;
                    i3 = 0;
                    j = 0;
                    if ((i14 & i) == 0) {
                        z = false;
                        break;
                    } else {
                        z = false;
                        i13 += zzen.zzb(i15, 0.0f);
                        break;
                    }
                case 2:
                    z2 = true;
                    i3 = 0;
                    j = 0;
                    if ((i14 & i) == 0) {
                        z = false;
                        break;
                    } else {
                        i13 += zzen.zzd(i15, unsafe2.getLong(t2, j3));
                        z = false;
                        break;
                    }
                case 3:
                    z2 = true;
                    i3 = 0;
                    j = 0;
                    if ((i14 & i) == 0) {
                        z = false;
                        break;
                    } else {
                        i13 += zzen.zze(i15, unsafe2.getLong(t2, j3));
                        z = false;
                        break;
                    }
                case 4:
                    z2 = true;
                    i3 = 0;
                    j = 0;
                    if ((i14 & i) == 0) {
                        z = false;
                        break;
                    } else {
                        i13 += zzen.zzf(i15, unsafe2.getInt(t2, j3));
                        z = false;
                        break;
                    }
                case 5:
                    z2 = true;
                    i3 = 0;
                    if ((i14 & i) == 0) {
                        j = 0;
                        z = false;
                        break;
                    } else {
                        j = 0;
                        i13 += zzen.zzg(i15, 0);
                        z = false;
                        break;
                    }
                case 6:
                    z2 = true;
                    if ((i14 & i) == 0) {
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i3 = 0;
                        i13 += zzen.zzi(i15, 0);
                        z = false;
                        j = 0;
                        break;
                    }
                case 7:
                    if ((i14 & i) == 0) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        z2 = true;
                        i13 += zzen.zzb(i15, true);
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 8:
                    if ((i14 & i) == 0) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        Object object = unsafe2.getObject(t2, j3);
                        if (!(object instanceof zzdu)) {
                            i13 += zzen.zzb(i15, (String) object);
                            z2 = true;
                            i3 = 0;
                            z = false;
                            j = 0;
                            break;
                        } else {
                            i13 += zzen.zzc(i15, (zzdu) object);
                            z2 = true;
                            i3 = 0;
                            z = false;
                            j = 0;
                            break;
                        }
                    }
                case 9:
                    if ((i14 & i) == 0) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzhf.zza(i15, unsafe2.getObject(t2, j3), zza(i12));
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 10:
                    if ((i14 & i) == 0) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzen.zzc(i15, (zzdu) unsafe2.getObject(t2, j3));
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 11:
                    if ((i14 & i) == 0) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzen.zzg(i15, unsafe2.getInt(t2, j3));
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 12:
                    if ((i14 & i) == 0) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzen.zzk(i15, unsafe2.getInt(t2, j3));
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 13:
                    if ((i14 & i) == 0) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzen.zzj(i15, 0);
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 14:
                    if ((i14 & i) == 0) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzen.zzh(i15, 0);
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 15:
                    if ((i14 & i) == 0) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzen.zzh(i15, unsafe2.getInt(t2, j3));
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 16:
                    if ((i14 & i) == 0) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzen.zzf(i15, unsafe2.getLong(t2, j3));
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 17:
                    if ((i14 & i) == 0) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzen.zzc(i15, (zzgo) unsafe2.getObject(t2, j3), zza(i12));
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 18:
                    i13 += zzhf.zzi(i15, (List) unsafe2.getObject(t2, j3), false);
                    z2 = true;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 19:
                    i3 = 0;
                    i13 += zzhf.zzh(i15, (List) unsafe2.getObject(t2, j3), false);
                    z2 = true;
                    z = false;
                    j = 0;
                    break;
                case 20:
                    i3 = 0;
                    i13 += zzhf.zza(i15, (List<Long>) (List) unsafe2.getObject(t2, j3), false);
                    z2 = true;
                    z = false;
                    j = 0;
                    break;
                case 21:
                    i3 = 0;
                    i13 += zzhf.zzb(i15, (List<Long>) (List) unsafe2.getObject(t2, j3), false);
                    z2 = true;
                    z = false;
                    j = 0;
                    break;
                case 22:
                    i3 = 0;
                    i13 += zzhf.zze(i15, (List) unsafe2.getObject(t2, j3), false);
                    z2 = true;
                    z = false;
                    j = 0;
                    break;
                case 23:
                    i3 = 0;
                    i13 += zzhf.zzi(i15, (List) unsafe2.getObject(t2, j3), false);
                    z2 = true;
                    z = false;
                    j = 0;
                    break;
                case 24:
                    i3 = 0;
                    i13 += zzhf.zzh(i15, (List) unsafe2.getObject(t2, j3), false);
                    z2 = true;
                    z = false;
                    j = 0;
                    break;
                case 25:
                    i3 = 0;
                    i13 += zzhf.zzj(i15, (List) unsafe2.getObject(t2, j3), false);
                    z2 = true;
                    z = false;
                    j = 0;
                    break;
                case 26:
                    i13 += zzhf.zza(i15, (List<?>) (List) unsafe2.getObject(t2, j3));
                    z2 = true;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 27:
                    i13 += zzhf.zza(i15, (List<?>) (List) unsafe2.getObject(t2, j3), zza(i12));
                    z2 = true;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 28:
                    i13 += zzhf.zzb(i15, (List) unsafe2.getObject(t2, j3));
                    z2 = true;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 29:
                    i13 += zzhf.zzf(i15, (List) unsafe2.getObject(t2, j3), false);
                    z2 = true;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 30:
                    i3 = 0;
                    i13 += zzhf.zzd(i15, (List) unsafe2.getObject(t2, j3), false);
                    z2 = true;
                    z = false;
                    j = 0;
                    break;
                case 31:
                    i3 = 0;
                    i13 += zzhf.zzh(i15, (List) unsafe2.getObject(t2, j3), false);
                    z2 = true;
                    z = false;
                    j = 0;
                    break;
                case 32:
                    i3 = 0;
                    i13 += zzhf.zzi(i15, (List) unsafe2.getObject(t2, j3), false);
                    z2 = true;
                    z = false;
                    j = 0;
                    break;
                case 33:
                    i3 = 0;
                    i13 += zzhf.zzg(i15, (List) unsafe2.getObject(t2, j3), false);
                    z2 = true;
                    z = false;
                    j = 0;
                    break;
                case 34:
                    i3 = 0;
                    i13 += zzhf.zzc(i15, (List) unsafe2.getObject(t2, j3), false);
                    z2 = true;
                    z = false;
                    j = 0;
                    break;
                case 35:
                    int zzi5 = zzhf.zzi((List) unsafe2.getObject(t2, j3));
                    if (zzi5 <= 0) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzi5);
                        }
                        i13 += zzen.zze(i15) + zzen.zzg(zzi5) + zzi5;
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 36:
                    int zzh5 = zzhf.zzh((List) unsafe2.getObject(t2, j3));
                    if (zzh5 <= 0) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzh5);
                        }
                        i13 += zzen.zze(i15) + zzen.zzg(zzh5) + zzh5;
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 37:
                    int zza3 = zzhf.zza((List<Long>) (List) unsafe2.getObject(t2, j3));
                    if (zza3 <= 0) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zza3);
                        }
                        i13 += zzen.zze(i15) + zzen.zzg(zza3) + zza3;
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 38:
                    int zzb3 = zzhf.zzb((List) unsafe2.getObject(t2, j3));
                    if (zzb3 <= 0) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzb3);
                        }
                        i13 += zzen.zze(i15) + zzen.zzg(zzb3) + zzb3;
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 39:
                    int zze3 = zzhf.zze((List) unsafe2.getObject(t2, j3));
                    if (zze3 <= 0) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zze3);
                        }
                        i13 += zzen.zze(i15) + zzen.zzg(zze3) + zze3;
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 40:
                    int zzi6 = zzhf.zzi((List) unsafe2.getObject(t2, j3));
                    if (zzi6 <= 0) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzi6);
                        }
                        i13 += zzen.zze(i15) + zzen.zzg(zzi6) + zzi6;
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 41:
                    int zzh6 = zzhf.zzh((List) unsafe2.getObject(t2, j3));
                    if (zzh6 <= 0) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzh6);
                        }
                        i13 += zzen.zze(i15) + zzen.zzg(zzh6) + zzh6;
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 42:
                    int zzj3 = zzhf.zzj((List) unsafe2.getObject(t2, j3));
                    if (zzj3 <= 0) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzj3);
                        }
                        i13 += zzen.zze(i15) + zzen.zzg(zzj3) + zzj3;
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 43:
                    int zzf5 = zzhf.zzf((List) unsafe2.getObject(t2, j3));
                    if (zzf5 <= 0) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzf5);
                        }
                        i13 += zzen.zze(i15) + zzen.zzg(zzf5) + zzf5;
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 44:
                    int zzd5 = zzhf.zzd((List) unsafe2.getObject(t2, j3));
                    if (zzd5 <= 0) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzd5);
                        }
                        i13 += zzen.zze(i15) + zzen.zzg(zzd5) + zzd5;
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 45:
                    int zzh7 = zzhf.zzh((List) unsafe2.getObject(t2, j3));
                    if (zzh7 <= 0) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzh7);
                        }
                        i13 += zzen.zze(i15) + zzen.zzg(zzh7) + zzh7;
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 46:
                    int zzi7 = zzhf.zzi((List) unsafe2.getObject(t2, j3));
                    if (zzi7 <= 0) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzi7);
                        }
                        i13 += zzen.zze(i15) + zzen.zzg(zzi7) + zzi7;
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 47:
                    int zzg3 = zzhf.zzg((List) unsafe2.getObject(t2, j3));
                    if (zzg3 <= 0) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzg3);
                        }
                        i13 += zzen.zze(i15) + zzen.zzg(zzg3) + zzg3;
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 48:
                    int zzc3 = zzhf.zzc((List) unsafe2.getObject(t2, j3));
                    if (zzc3 <= 0) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzc3);
                        }
                        i13 += zzen.zze(i15) + zzen.zzg(zzc3) + zzc3;
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 49:
                    i13 += zzhf.zzb(i15, (List<zzgo>) (List) unsafe2.getObject(t2, j3), zza(i12));
                    z2 = true;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 50:
                    i13 += this.zzs.zza(i15, unsafe2.getObject(t2, j3), zzb(i12));
                    z2 = true;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 51:
                    if (!zza(t2, i15, i12)) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzen.zzb(i15, 0.0d);
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 52:
                    if (!zza(t2, i15, i12)) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzen.zzb(i15, 0.0f);
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 53:
                    if (!zza(t2, i15, i12)) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzen.zzd(i15, zze(t2, j3));
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 54:
                    if (!zza(t2, i15, i12)) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzen.zze(i15, zze(t2, j3));
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 55:
                    if (!zza(t2, i15, i12)) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzen.zzf(i15, zzd(t2, j3));
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 56:
                    if (!zza(t2, i15, i12)) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzen.zzg(i15, 0);
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 57:
                    if (!zza(t2, i15, i12)) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzen.zzi(i15, 0);
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 58:
                    if (!zza(t2, i15, i12)) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzen.zzb(i15, true);
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 59:
                    if (!zza(t2, i15, i12)) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        Object object2 = unsafe2.getObject(t2, j3);
                        if (!(object2 instanceof zzdu)) {
                            i13 += zzen.zzb(i15, (String) object2);
                            z2 = true;
                            i3 = 0;
                            z = false;
                            j = 0;
                            break;
                        } else {
                            i13 += zzen.zzc(i15, (zzdu) object2);
                            z2 = true;
                            i3 = 0;
                            z = false;
                            j = 0;
                            break;
                        }
                    }
                case 60:
                    if (!zza(t2, i15, i12)) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzhf.zza(i15, unsafe2.getObject(t2, j3), zza(i12));
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 61:
                    if (!zza(t2, i15, i12)) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzen.zzc(i15, (zzdu) unsafe2.getObject(t2, j3));
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 62:
                    if (!zza(t2, i15, i12)) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzen.zzg(i15, zzd(t2, j3));
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 63:
                    if (!zza(t2, i15, i12)) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzen.zzk(i15, zzd(t2, j3));
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 64:
                    if (!zza(t2, i15, i12)) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzen.zzj(i15, 0);
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 65:
                    if (!zza(t2, i15, i12)) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzen.zzh(i15, 0);
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 66:
                    if (!zza(t2, i15, i12)) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzen.zzh(i15, zzd(t2, j3));
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 67:
                    if (!zza(t2, i15, i12)) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzen.zzf(i15, zze(t2, j3));
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 68:
                    if (!zza(t2, i15, i12)) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzen.zzc(i15, (zzgo) unsafe2.getObject(t2, j3), zza(i12));
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                default:
                    z2 = true;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
            }
            i12 += 3;
            i5 = i3;
            z3 = z2;
            boolean z4 = z;
            long j4 = j;
        }
        int i19 = i5;
        int zza4 = i13 + zza(this.zzq, t2);
        if (!this.zzh) {
            return zza4;
        }
        zzew<?> zza5 = this.zzr.zza((Object) t2);
        for (int i20 = i19; i20 < zza5.zza.zzc(); i20++) {
            Map.Entry<T, Object> zzb4 = zza5.zza.zzb(i20);
            i19 += zzew.zza((zzey<?>) (zzey) zzb4.getKey(), zzb4.getValue());
        }
        for (Map.Entry next : zza5.zza.zzd()) {
            i19 += zzew.zza((zzey<?>) (zzey) next.getKey(), next.getValue());
        }
        return zza4 + i19;
    }

    public final void zzb(T t, T t2) {
        if (t2 != null) {
            for (int i = 0; i < this.zzc.length; i += 3) {
                int zzd2 = zzd(i);
                long j = (long) (1048575 & zzd2);
                int i2 = this.zzc[i];
                switch ((zzd2 & 267386880) >>> 20) {
                    case 0:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzib.zza((Object) t, j, zzib.zze(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 1:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzib.zza((Object) t, j, zzib.zzd(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 2:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzib.zza((Object) t, j, zzib.zzb(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 3:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzib.zza((Object) t, j, zzib.zzb(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 4:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzib.zza((Object) t, j, zzib.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 5:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzib.zza((Object) t, j, zzib.zzb(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 6:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzib.zza((Object) t, j, zzib.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 7:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzib.zza((Object) t, j, zzib.zzc(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 8:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzib.zza((Object) t, j, zzib.zzf(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 9:
                        zza(t, t2, i);
                        break;
                    case 10:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzib.zza((Object) t, j, zzib.zzf(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 11:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzib.zza((Object) t, j, zzib.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 12:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzib.zza((Object) t, j, zzib.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 13:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzib.zza((Object) t, j, zzib.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 14:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzib.zza((Object) t, j, zzib.zzb(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 15:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzib.zza((Object) t, j, zzib.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 16:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzib.zza((Object) t, j, zzib.zzb(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 17:
                        zza(t, t2, i);
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        this.zzp.zza(t, t2, j);
                        break;
                    case 50:
                        zzhf.zza(this.zzs, t, t2, j);
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                        if (!zza(t2, i2, i)) {
                            break;
                        } else {
                            zzib.zza((Object) t, j, zzib.zzf(t2, j));
                            zzb(t, i2, i);
                            break;
                        }
                    case 60:
                        zzb(t, t2, i);
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        if (!zza(t2, i2, i)) {
                            break;
                        } else {
                            zzib.zza((Object) t, j, zzib.zzf(t2, j));
                            zzb(t, i2, i);
                            break;
                        }
                    case 68:
                        zzb(t, t2, i);
                        break;
                }
            }
            zzhf.zza(this.zzq, t, t2);
            if (this.zzh) {
                zzhf.zza(this.zzr, t, t2);
                return;
            }
            return;
        }
        throw null;
    }

    public final void zzc(T t) {
        int i;
        int i2 = this.zzm;
        while (true) {
            i = this.zzn;
            if (i2 >= i) {
                break;
            }
            long zzd2 = (long) (zzd(this.zzl[i2]) & 1048575);
            Object zzf2 = zzib.zzf(t, zzd2);
            if (zzf2 != null) {
                zzib.zza((Object) t, zzd2, this.zzs.zzd(zzf2));
            }
            i2++;
        }
        int length = this.zzl.length;
        while (i < length) {
            this.zzp.zzb(t, (long) this.zzl[i]);
            i++;
        }
        this.zzq.zzd(t);
        if (this.zzh) {
            this.zzr.zzc(t);
        }
    }

    public final boolean zzd(T t) {
        int i;
        int i2 = -1;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            boolean z = true;
            if (i3 >= this.zzm) {
                return !this.zzh || this.zzr.zza((Object) t).zzf();
            }
            int i5 = this.zzl[i3];
            int i6 = this.zzc[i5];
            int zzd2 = zzd(i5);
            if (!this.zzj) {
                int i7 = this.zzc[i5 + 2];
                int i8 = i7 & 1048575;
                i = 1 << (i7 >>> 20);
                if (i8 != i2) {
                    i4 = zzb.getInt(t, (long) i8);
                    i2 = i8;
                }
            } else {
                i = 0;
            }
            if (((268435456 & zzd2) != 0) && !zza(t, i5, i4, i)) {
                return false;
            }
            int i9 = (267386880 & zzd2) >>> 20;
            if (i9 != 9 && i9 != 17) {
                if (i9 != 27) {
                    if (i9 == 60 || i9 == 68) {
                        if (zza(t, i6, i5) && !zza((Object) t, zzd2, zza(i5))) {
                            return false;
                        }
                    } else if (i9 != 49) {
                        if (i9 != 50) {
                            continue;
                        } else {
                            Map<?, ?> zzb2 = this.zzs.zzb(zzib.zzf(t, (long) (zzd2 & 1048575)));
                            if (!zzb2.isEmpty()) {
                                if (this.zzs.zzf(zzb(i5)).zzc.zza() == zzip.MESSAGE) {
                                    zzhd<?> zzhd = null;
                                    Iterator<?> it = zzb2.values().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Object next = it.next();
                                        if (zzhd == null) {
                                            zzhd = zzgz.zza().zza(next.getClass());
                                        }
                                        if (!zzhd.zzd(next)) {
                                            z = false;
                                            break;
                                        }
                                    }
                                }
                            }
                            if (!z) {
                                return false;
                            }
                        }
                    }
                }
                List list = (List) zzib.zzf(t, (long) (zzd2 & 1048575));
                if (!list.isEmpty()) {
                    zzhd zza2 = zza(i5);
                    int i10 = 0;
                    while (true) {
                        if (i10 >= list.size()) {
                            break;
                        } else if (!zza2.zzd(list.get(i10))) {
                            z = false;
                            break;
                        } else {
                            i10++;
                        }
                    }
                }
                if (!z) {
                    return false;
                }
            } else if (zza(t, i5, i4, i) && !zza((Object) t, zzd2, zza(i5))) {
                return false;
            }
            i3++;
        }
    }
}
