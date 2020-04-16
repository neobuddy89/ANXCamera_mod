package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.3.0 */
final class zzik extends zzif {
    zzik() {
    }

    private static int zza(byte[] bArr, int i, long j, int i2) {
        if (i2 == 0) {
            return zzie.zzb(i);
        }
        if (i2 == 1) {
            return zzie.zzb(i, zzib.zza(bArr, j));
        }
        if (i2 == 2) {
            return zzie.zzb(i, (int) zzib.zza(bArr, j), (int) zzib.zza(bArr, j + 1));
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0067, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0093, code lost:
        return -1;
     */
    public final int zza(int i, byte[] bArr, int i2, int i3) {
        int i4;
        byte[] bArr2 = bArr;
        int i5 = i2;
        int i6 = i3;
        if ((i5 | i6 | (bArr2.length - i6)) >= 0) {
            long j = (long) i5;
            int i7 = (int) (((long) i6) - j);
            if (i7 >= 16) {
                i4 = 0;
                long j2 = j;
                while (true) {
                    if (i4 >= i7) {
                        i4 = i7;
                        break;
                    }
                    long j3 = j2 + 1;
                    if (zzib.zza(bArr2, j2) < 0) {
                        break;
                    }
                    i4++;
                    j2 = j3;
                }
            } else {
                i4 = 0;
            }
            int i8 = i7 - i4;
            long j4 = j + ((long) i4);
            while (true) {
                byte b2 = 0;
                while (true) {
                    if (i8 <= 0) {
                        break;
                    }
                    long j5 = j4 + 1;
                    byte zza = zzib.zza(bArr2, j4);
                    if (zza < 0) {
                        long j6 = j5;
                        b2 = zza;
                        j4 = j6;
                        break;
                    }
                    i8--;
                    long j7 = j5;
                    b2 = zza;
                    j4 = j7;
                }
                if (i8 != 0) {
                    int i9 = i8 - 1;
                    if (b2 >= -32) {
                        if (b2 >= -16) {
                            if (i9 >= 3) {
                                i8 = i9 - 3;
                                long j8 = j4 + 1;
                                byte zza2 = zzib.zza(bArr2, j4);
                                if (zza2 > -65 || (((b2 << 28) + (zza2 + 112)) >> 30) != 0) {
                                    break;
                                }
                                long j9 = j8 + 1;
                                if (zzib.zza(bArr2, j8) > -65) {
                                    break;
                                }
                                j4 = j9 + 1;
                                if (zzib.zza(bArr2, j9) > -65) {
                                    break;
                                }
                            } else {
                                return zza(bArr2, (int) b2, j4, i9);
                            }
                        } else if (i9 >= 2) {
                            i8 = i9 - 2;
                            long j10 = j4 + 1;
                            byte zza3 = zzib.zza(bArr2, j4);
                            if (zza3 > -65 || ((b2 == -32 && zza3 < -96) || (b2 == -19 && zza3 >= -96))) {
                                break;
                            }
                            j4 = j10 + 1;
                            if (zzib.zza(bArr2, j10) > -65) {
                                break;
                            }
                        } else {
                            return zza(bArr2, (int) b2, j4, i9);
                        }
                    } else if (i9 != 0) {
                        i8 = i9 - 1;
                        if (b2 < -62) {
                            break;
                        }
                        long j11 = j4 + 1;
                        if (zzib.zza(bArr2, j4) > -65) {
                            break;
                        }
                        j4 = j11;
                    } else {
                        return b2;
                    }
                } else {
                    return 0;
                }
            }
            return -1;
        }
        throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(bArr2.length), Integer.valueOf(i2), Integer.valueOf(i3)}));
    }

    /* access modifiers changed from: package-private */
    public final int zza(CharSequence charSequence, byte[] bArr, int i, int i2) {
        char c2;
        long j;
        long j2;
        char c3;
        long j3;
        CharSequence charSequence2 = charSequence;
        byte[] bArr2 = bArr;
        int i3 = i;
        int i4 = i2;
        long j4 = (long) i3;
        long j5 = ((long) i4) + j4;
        int length = charSequence.length();
        if (length > i4 || bArr2.length - i4 < i3) {
            char charAt = charSequence2.charAt(length - 1);
            StringBuilder sb = new StringBuilder(37);
            sb.append("Failed writing ");
            sb.append(charAt);
            sb.append(" at index ");
            sb.append(i3 + i4);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        int i5 = 0;
        while (true) {
            c2 = 128;
            j = 1;
            if (i5 >= length) {
                break;
            }
            char charAt2 = charSequence2.charAt(i5);
            if (charAt2 >= 128) {
                break;
            }
            zzib.zza(bArr2, j4, (byte) charAt2);
            i5++;
            j4 = 1 + j4;
        }
        if (i5 == length) {
            return (int) j4;
        }
        while (i5 < length) {
            char charAt3 = charSequence2.charAt(i5);
            if (charAt3 < c2 && j4 < j5) {
                long j6 = j4 + j;
                zzib.zza(bArr2, j4, (byte) charAt3);
                j3 = j;
                j2 = j6;
                c3 = c2;
            } else if (charAt3 < 2048 && j4 <= j5 - 2) {
                long j7 = j4 + j;
                zzib.zza(bArr2, j4, (byte) ((charAt3 >>> 6) | 960));
                long j8 = j7 + j;
                zzib.zza(bArr2, j7, (byte) ((charAt3 & '?') | 128));
                long j9 = j;
                c3 = 128;
                j2 = j8;
                j3 = j9;
            } else if ((charAt3 < 55296 || 57343 < charAt3) && j4 <= j5 - 3) {
                long j10 = j4 + j;
                zzib.zza(bArr2, j4, (byte) ((charAt3 >>> 12) | 480));
                long j11 = j10 + j;
                zzib.zza(bArr2, j10, (byte) (((charAt3 >>> 6) & 63) | 128));
                zzib.zza(bArr2, j11, (byte) ((charAt3 & '?') | 128));
                j2 = j11 + 1;
                j3 = 1;
                c3 = 128;
            } else if (j4 <= j5 - 4) {
                int i6 = i5 + 1;
                if (i6 != length) {
                    char charAt4 = charSequence2.charAt(i6);
                    if (Character.isSurrogatePair(charAt3, charAt4)) {
                        int codePoint = Character.toCodePoint(charAt3, charAt4);
                        long j12 = j4 + 1;
                        zzib.zza(bArr2, j4, (byte) ((codePoint >>> 18) | 240));
                        long j13 = j12 + 1;
                        c3 = 128;
                        zzib.zza(bArr2, j12, (byte) (((codePoint >>> 12) & 63) | 128));
                        long j14 = j13 + 1;
                        zzib.zza(bArr2, j13, (byte) (((codePoint >>> 6) & 63) | 128));
                        j3 = 1;
                        j2 = j14 + 1;
                        zzib.zza(bArr2, j14, (byte) ((codePoint & 63) | 128));
                        i5 = i6;
                    } else {
                        i5 = i6;
                    }
                }
                throw new zzih(i5 - 1, length);
            } else {
                if (55296 <= charAt3 && charAt3 <= 57343) {
                    int i7 = i5 + 1;
                    if (i7 == length || !Character.isSurrogatePair(charAt3, charSequence2.charAt(i7))) {
                        throw new zzih(i5, length);
                    }
                }
                StringBuilder sb2 = new StringBuilder(46);
                sb2.append("Failed writing ");
                sb2.append(charAt3);
                sb2.append(" at index ");
                sb2.append(j4);
                throw new ArrayIndexOutOfBoundsException(sb2.toString());
            }
            i5++;
            c2 = c3;
            long j15 = j3;
            j4 = j2;
            j = j15;
        }
        return (int) j4;
    }

    /* access modifiers changed from: package-private */
    public final String zzb(byte[] bArr, int i, int i2) throws zzfo {
        if ((i | i2 | ((bArr.length - i) - i2)) >= 0) {
            int i3 = i + i2;
            char[] cArr = new char[i2];
            int i4 = 0;
            while (r13 < i3) {
                byte zza = zzib.zza(bArr, (long) r13);
                if (!zzig.zzd(zza)) {
                    break;
                }
                i = r13 + 1;
                zzig.zzb(zza, cArr, i4);
                i4++;
            }
            int i5 = i4;
            while (r13 < i3) {
                int i6 = r13 + 1;
                byte zza2 = zzib.zza(bArr, (long) r13);
                if (zzig.zzd(zza2)) {
                    int i7 = i5 + 1;
                    zzig.zzb(zza2, cArr, i5);
                    while (i6 < i3) {
                        byte zza3 = zzib.zza(bArr, (long) i6);
                        if (!zzig.zzd(zza3)) {
                            break;
                        }
                        i6++;
                        zzig.zzb(zza3, cArr, i7);
                        i7++;
                    }
                    r13 = i6;
                    i5 = i7;
                } else if (zzig.zze(zza2)) {
                    if (i6 < i3) {
                        zzig.zzb(zza2, zzib.zza(bArr, (long) i6), cArr, i5);
                        r13 = i6 + 1;
                        i5++;
                    } else {
                        throw zzfo.zzh();
                    }
                } else if (zzig.zzf(zza2)) {
                    if (i6 < i3 - 1) {
                        int i8 = i6 + 1;
                        zzig.zzb(zza2, zzib.zza(bArr, (long) i6), zzib.zza(bArr, (long) i8), cArr, i5);
                        r13 = i8 + 1;
                        i5++;
                    } else {
                        throw zzfo.zzh();
                    }
                } else if (i6 < i3 - 2) {
                    int i9 = i6 + 1;
                    byte zza4 = zzib.zza(bArr, (long) i6);
                    int i10 = i9 + 1;
                    zzig.zzb(zza2, zza4, zzib.zza(bArr, (long) i9), zzib.zza(bArr, (long) i10), cArr, i5);
                    r13 = i10 + 1;
                    i5 = i5 + 1 + 1;
                } else {
                    throw zzfo.zzh();
                }
            }
            return new String(cArr, 0, i5);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
    }
}
