package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.3.0 */
final class zzii extends zzif {
    zzii() {
    }

    /* access modifiers changed from: package-private */
    public final int zza(int i, byte[] bArr, int i2, int i3) {
        while (r9 < i3 && bArr[r9] >= 0) {
            i2 = r9 + 1;
        }
        if (r9 >= i3) {
            return 0;
        }
        while (r9 < i3) {
            int i4 = r9 + 1;
            byte b2 = bArr[r9];
            if (b2 >= 0) {
                r9 = i4;
            } else if (b2 < -32) {
                if (i4 >= i3) {
                    return b2;
                }
                if (b2 >= -62) {
                    r9 = i4 + 1;
                    if (bArr[i4] > -65) {
                    }
                }
                return -1;
            } else if (b2 < -16) {
                if (i4 >= i3 - 1) {
                    return zzie.zzd(bArr, i4, i3);
                }
                int i5 = i4 + 1;
                byte b3 = bArr[i4];
                if (b3 <= -65 && ((b2 != -32 || b3 >= -96) && (b2 != -19 || b3 < -96))) {
                    r9 = i5 + 1;
                    if (bArr[i5] > -65) {
                    }
                }
                return -1;
            } else if (i4 >= i3 - 2) {
                return zzie.zzd(bArr, i4, i3);
            } else {
                int i6 = i4 + 1;
                byte b4 = bArr[i4];
                if (b4 <= -65 && (((b2 << 28) + (b4 + 112)) >> 30) == 0) {
                    int i7 = i6 + 1;
                    if (bArr[i6] <= -65) {
                        int i8 = i7 + 1;
                        if (bArr[i7] <= -65) {
                            r9 = i8;
                        }
                    }
                }
                return -1;
            }
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final int zza(CharSequence charSequence, byte[] bArr, int i, int i2) {
        int length = charSequence.length();
        int i3 = i2 + i;
        int i4 = 0;
        while (i4 < length) {
            int i5 = i4 + i;
            if (i5 >= i3) {
                break;
            }
            char charAt = charSequence.charAt(i4);
            if (charAt >= 128) {
                break;
            }
            bArr[i5] = (byte) charAt;
            i4++;
        }
        if (i4 == length) {
            return i + length;
        }
        int i6 = i + i4;
        while (i4 < length) {
            char charAt2 = charSequence.charAt(i4);
            if (charAt2 < 128 && i6 < i3) {
                bArr[i6] = (byte) charAt2;
                i6++;
            } else if (charAt2 < 2048 && i6 <= i3 - 2) {
                int i7 = i6 + 1;
                bArr[i6] = (byte) ((charAt2 >>> 6) | 960);
                i6 = i7 + 1;
                bArr[i7] = (byte) ((charAt2 & '?') | 128);
            } else if ((charAt2 < 55296 || 57343 < charAt2) && i6 <= i3 - 3) {
                int i8 = i6 + 1;
                bArr[i6] = (byte) ((charAt2 >>> 12) | 480);
                int i9 = i8 + 1;
                bArr[i8] = (byte) (((charAt2 >>> 6) & 63) | 128);
                bArr[i9] = (byte) ((charAt2 & '?') | 128);
                i6 = i9 + 1;
            } else if (i6 <= i3 - 4) {
                int i10 = i4 + 1;
                if (i10 != charSequence.length()) {
                    char charAt3 = charSequence.charAt(i10);
                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                        int codePoint = Character.toCodePoint(charAt2, charAt3);
                        int i11 = i6 + 1;
                        bArr[i6] = (byte) ((codePoint >>> 18) | 240);
                        int i12 = i11 + 1;
                        bArr[i11] = (byte) (((codePoint >>> 12) & 63) | 128);
                        int i13 = i12 + 1;
                        bArr[i12] = (byte) (((codePoint >>> 6) & 63) | 128);
                        i6 = i13 + 1;
                        bArr[i13] = (byte) ((codePoint & 63) | 128);
                        i4 = i10;
                    } else {
                        i4 = i10;
                    }
                }
                throw new zzih(i4 - 1, length);
            } else {
                if (55296 <= charAt2 && charAt2 <= 57343) {
                    int i14 = i4 + 1;
                    if (i14 == charSequence.length() || !Character.isSurrogatePair(charAt2, charSequence.charAt(i14))) {
                        throw new zzih(i4, length);
                    }
                }
                StringBuilder sb = new StringBuilder(37);
                sb.append("Failed writing ");
                sb.append(charAt2);
                sb.append(" at index ");
                sb.append(i6);
                throw new ArrayIndexOutOfBoundsException(sb.toString());
            }
            i4++;
        }
        return i6;
    }

    /* access modifiers changed from: package-private */
    public final String zzb(byte[] bArr, int i, int i2) throws zzfo {
        if ((i | i2 | ((bArr.length - i) - i2)) >= 0) {
            int i3 = i + i2;
            char[] cArr = new char[i2];
            int i4 = 0;
            while (r13 < i3) {
                byte b2 = bArr[r13];
                if (!zzig.zzd(b2)) {
                    break;
                }
                i = r13 + 1;
                zzig.zzb(b2, cArr, i4);
                i4++;
            }
            int i5 = i4;
            while (r13 < i3) {
                int i6 = r13 + 1;
                byte b3 = bArr[r13];
                if (zzig.zzd(b3)) {
                    int i7 = i5 + 1;
                    zzig.zzb(b3, cArr, i5);
                    while (i6 < i3) {
                        byte b4 = bArr[i6];
                        if (!zzig.zzd(b4)) {
                            break;
                        }
                        i6++;
                        zzig.zzb(b4, cArr, i7);
                        i7++;
                    }
                    r13 = i6;
                    i5 = i7;
                } else if (zzig.zze(b3)) {
                    if (i6 < i3) {
                        zzig.zzb(b3, bArr[i6], cArr, i5);
                        r13 = i6 + 1;
                        i5++;
                    } else {
                        throw zzfo.zzh();
                    }
                } else if (zzig.zzf(b3)) {
                    if (i6 < i3 - 1) {
                        int i8 = i6 + 1;
                        zzig.zzb(b3, bArr[i6], bArr[i8], cArr, i5);
                        r13 = i8 + 1;
                        i5++;
                    } else {
                        throw zzfo.zzh();
                    }
                } else if (i6 < i3 - 2) {
                    int i9 = i6 + 1;
                    byte b5 = bArr[i6];
                    int i10 = i9 + 1;
                    zzig.zzb(b3, b5, bArr[i9], bArr[i10], cArr, i5);
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
