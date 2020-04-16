package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.3.0 */
public abstract class zzen extends zzdv {
    private static final Logger zzb = Logger.getLogger(zzen.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zzc = zzib.zza();
    zzep zza;

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.3.0 */
    public static class zza extends IOException {
        zza() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        zza(String str, Throwable th) {
            super(r3.length() != 0 ? r0.concat(r3) : new String(r0), th);
            String valueOf = String.valueOf("CodedOutputStream was writing to a flat byte array and ran out of space.: ");
            String valueOf2 = String.valueOf(str);
        }

        zza(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.3.0 */
    static class zzb extends zzen {
        private final byte[] zzb;
        private final int zzc;
        private final int zzd;
        private int zze;

        zzb(byte[] bArr, int i, int i2) {
            super();
            if (bArr != null) {
                int i3 = i2 + 0;
                if ((i2 | 0 | (bArr.length - i3)) >= 0) {
                    this.zzb = bArr;
                    this.zzc = 0;
                    this.zze = 0;
                    this.zzd = i3;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), 0, Integer.valueOf(i2)}));
            }
            throw new NullPointerException("buffer");
        }

        private final void zzc(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.zzb, this.zze, i2);
                this.zze += i2;
            } catch (IndexOutOfBoundsException e2) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), Integer.valueOf(i2)}), e2);
            }
        }

        public final int zza() {
            return this.zzd - this.zze;
        }

        public final void zza(byte b2) throws IOException {
            try {
                byte[] bArr = this.zzb;
                int i = this.zze;
                this.zze = i + 1;
                bArr[i] = b2;
            } catch (IndexOutOfBoundsException e2) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1}), e2);
            }
        }

        public final void zza(int i) throws IOException {
            if (i >= 0) {
                zzb(i);
            } else {
                zza((long) i);
            }
        }

        public final void zza(int i, int i2) throws IOException {
            zzb((i << 3) | i2);
        }

        public final void zza(int i, long j) throws IOException {
            zza(i, 0);
            zza(j);
        }

        public final void zza(int i, zzdu zzdu) throws IOException {
            zza(i, 2);
            zza(zzdu);
        }

        public final void zza(int i, zzgo zzgo) throws IOException {
            zza(1, 3);
            zzc(2, i);
            zza(3, 2);
            zza(zzgo);
            zza(1, 4);
        }

        /* access modifiers changed from: package-private */
        public final void zza(int i, zzgo zzgo, zzhd zzhd) throws IOException {
            zza(i, 2);
            zzdl zzdl = (zzdl) zzgo;
            int zzbj = zzdl.zzbj();
            if (zzbj == -1) {
                zzbj = zzhd.zzb(zzdl);
                zzdl.zzc(zzbj);
            }
            zzb(zzbj);
            zzhd.zza(zzgo, (zzis) this.zza);
        }

        public final void zza(int i, String str) throws IOException {
            zza(i, 2);
            zza(str);
        }

        public final void zza(int i, boolean z) throws IOException {
            zza(i, 0);
            zza(z ? (byte) 1 : 0);
        }

        public final void zza(long j) throws IOException {
            if (!zzen.zzc || zza() < 10) {
                while ((j & -128) != 0) {
                    byte[] bArr = this.zzb;
                    int i = this.zze;
                    this.zze = i + 1;
                    bArr[i] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                }
                try {
                    byte[] bArr2 = this.zzb;
                    int i2 = this.zze;
                    this.zze = i2 + 1;
                    bArr2[i2] = (byte) ((int) j);
                } catch (IndexOutOfBoundsException e2) {
                    throw new zza(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1}), e2);
                }
            } else {
                while ((j & -128) != 0) {
                    byte[] bArr3 = this.zzb;
                    int i3 = this.zze;
                    this.zze = i3 + 1;
                    zzib.zza(bArr3, (long) i3, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr4 = this.zzb;
                int i4 = this.zze;
                this.zze = i4 + 1;
                zzib.zza(bArr4, (long) i4, (byte) ((int) j));
            }
        }

        public final void zza(zzdu zzdu) throws IOException {
            zzb(zzdu.zza());
            zzdu.zza((zzdv) this);
        }

        public final void zza(zzgo zzgo) throws IOException {
            zzb(zzgo.zzbn());
            zzgo.zza(this);
        }

        public final void zza(String str) throws IOException {
            int i = this.zze;
            try {
                int zzg = zzg(str.length() * 3);
                int zzg2 = zzg(str.length());
                if (zzg2 == zzg) {
                    int i2 = i + zzg2;
                    this.zze = i2;
                    int zza = zzie.zza(str, this.zzb, i2, zza());
                    this.zze = i;
                    zzb((zza - i) - zzg2);
                    this.zze = zza;
                    return;
                }
                zzb(zzie.zza((CharSequence) str));
                this.zze = zzie.zza(str, this.zzb, this.zze, zza());
            } catch (zzih e2) {
                this.zze = i;
                zza(str, e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new zza(e3);
            }
        }

        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            zzc(bArr, i, i2);
        }

        public final void zzb(int i) throws IOException {
            if (!zzen.zzc || zzdr.zza() || zza() < 5) {
                while ((i & -128) != 0) {
                    byte[] bArr = this.zzb;
                    int i2 = this.zze;
                    this.zze = i2 + 1;
                    bArr[i2] = (byte) ((i & 127) | 128);
                    i >>>= 7;
                }
                try {
                    byte[] bArr2 = this.zzb;
                    int i3 = this.zze;
                    this.zze = i3 + 1;
                    bArr2[i3] = (byte) i;
                } catch (IndexOutOfBoundsException e2) {
                    throw new zza(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1}), e2);
                }
            } else if ((i & -128) == 0) {
                byte[] bArr3 = this.zzb;
                int i4 = this.zze;
                this.zze = i4 + 1;
                zzib.zza(bArr3, (long) i4, (byte) i);
            } else {
                byte[] bArr4 = this.zzb;
                int i5 = this.zze;
                this.zze = i5 + 1;
                zzib.zza(bArr4, (long) i5, (byte) (i | 128));
                int i6 = i >>> 7;
                if ((i6 & -128) == 0) {
                    byte[] bArr5 = this.zzb;
                    int i7 = this.zze;
                    this.zze = i7 + 1;
                    zzib.zza(bArr5, (long) i7, (byte) i6);
                    return;
                }
                byte[] bArr6 = this.zzb;
                int i8 = this.zze;
                this.zze = i8 + 1;
                zzib.zza(bArr6, (long) i8, (byte) (i6 | 128));
                int i9 = i6 >>> 7;
                if ((i9 & -128) == 0) {
                    byte[] bArr7 = this.zzb;
                    int i10 = this.zze;
                    this.zze = i10 + 1;
                    zzib.zza(bArr7, (long) i10, (byte) i9);
                    return;
                }
                byte[] bArr8 = this.zzb;
                int i11 = this.zze;
                this.zze = i11 + 1;
                zzib.zza(bArr8, (long) i11, (byte) (i9 | 128));
                int i12 = i9 >>> 7;
                if ((i12 & -128) == 0) {
                    byte[] bArr9 = this.zzb;
                    int i13 = this.zze;
                    this.zze = i13 + 1;
                    zzib.zza(bArr9, (long) i13, (byte) i12);
                    return;
                }
                byte[] bArr10 = this.zzb;
                int i14 = this.zze;
                this.zze = i14 + 1;
                zzib.zza(bArr10, (long) i14, (byte) (i12 | 128));
                byte[] bArr11 = this.zzb;
                int i15 = this.zze;
                this.zze = i15 + 1;
                zzib.zza(bArr11, (long) i15, (byte) (i12 >>> 7));
            }
        }

        public final void zzb(int i, int i2) throws IOException {
            zza(i, 0);
            zza(i2);
        }

        public final void zzb(int i, zzdu zzdu) throws IOException {
            zza(1, 3);
            zzc(2, i);
            zza(3, zzdu);
            zza(1, 4);
        }

        public final void zzb(byte[] bArr, int i, int i2) throws IOException {
            zzb(i2);
            zzc(bArr, 0, i2);
        }

        public final void zzc(int i, int i2) throws IOException {
            zza(i, 0);
            zzb(i2);
        }

        public final void zzc(int i, long j) throws IOException {
            zza(i, 1);
            zzc(j);
        }

        public final void zzc(long j) throws IOException {
            try {
                byte[] bArr = this.zzb;
                int i = this.zze;
                int i2 = i + 1;
                this.zze = i2;
                bArr[i] = (byte) ((int) j);
                byte[] bArr2 = this.zzb;
                int i3 = i2 + 1;
                this.zze = i3;
                bArr2[i2] = (byte) ((int) (j >> 8));
                byte[] bArr3 = this.zzb;
                int i4 = i3 + 1;
                this.zze = i4;
                bArr3[i3] = (byte) ((int) (j >> 16));
                byte[] bArr4 = this.zzb;
                int i5 = i4 + 1;
                this.zze = i5;
                bArr4[i4] = (byte) ((int) (j >> 24));
                byte[] bArr5 = this.zzb;
                int i6 = i5 + 1;
                this.zze = i6;
                bArr5[i5] = (byte) ((int) (j >> 32));
                byte[] bArr6 = this.zzb;
                int i7 = i6 + 1;
                this.zze = i7;
                bArr6[i6] = (byte) ((int) (j >> 40));
                byte[] bArr7 = this.zzb;
                int i8 = i7 + 1;
                this.zze = i8;
                bArr7[i7] = (byte) ((int) (j >> 48));
                byte[] bArr8 = this.zzb;
                this.zze = i8 + 1;
                bArr8[i8] = (byte) ((int) (j >> 56));
            } catch (IndexOutOfBoundsException e2) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1}), e2);
            }
        }

        public final void zzd(int i) throws IOException {
            try {
                byte[] bArr = this.zzb;
                int i2 = this.zze;
                int i3 = i2 + 1;
                this.zze = i3;
                bArr[i2] = (byte) i;
                byte[] bArr2 = this.zzb;
                int i4 = i3 + 1;
                this.zze = i4;
                bArr2[i3] = (byte) (i >> 8);
                byte[] bArr3 = this.zzb;
                int i5 = i4 + 1;
                this.zze = i5;
                bArr3[i4] = (byte) (i >> 16);
                byte[] bArr4 = this.zzb;
                this.zze = i5 + 1;
                bArr4[i5] = (byte) (i >>> 24);
            } catch (IndexOutOfBoundsException e2) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1}), e2);
            }
        }

        public final void zze(int i, int i2) throws IOException {
            zza(i, 5);
            zzd(i2);
        }
    }

    private zzen() {
    }

    public static int zza(int i, zzft zzft) {
        int zze = zze(i);
        int zzb2 = zzft.zzb();
        return zze + zzg(zzb2) + zzb2;
    }

    public static int zza(zzft zzft) {
        int zzb2 = zzft.zzb();
        return zzg(zzb2) + zzb2;
    }

    static int zza(zzgo zzgo, zzhd zzhd) {
        zzdl zzdl = (zzdl) zzgo;
        int zzbj = zzdl.zzbj();
        if (zzbj == -1) {
            zzbj = zzhd.zzb(zzdl);
            zzdl.zzc(zzbj);
        }
        return zzg(zzbj) + zzbj;
    }

    public static zzen zza(byte[] bArr) {
        return new zzb(bArr, 0, bArr.length);
    }

    public static int zzb(double d2) {
        return 8;
    }

    public static int zzb(float f2) {
        return 4;
    }

    public static int zzb(int i, double d2) {
        return zze(i) + 8;
    }

    public static int zzb(int i, float f2) {
        return zze(i) + 4;
    }

    public static int zzb(int i, zzft zzft) {
        return (zze(1) << 1) + zzg(2, i) + zza(3, zzft);
    }

    public static int zzb(int i, zzgo zzgo) {
        return (zze(1) << 1) + zzg(2, i) + zze(3) + zzb(zzgo);
    }

    static int zzb(int i, zzgo zzgo, zzhd zzhd) {
        return zze(i) + zza(zzgo, zzhd);
    }

    public static int zzb(int i, String str) {
        return zze(i) + zzb(str);
    }

    public static int zzb(int i, boolean z) {
        return zze(i) + 1;
    }

    public static int zzb(zzdu zzdu) {
        int zza2 = zzdu.zza();
        return zzg(zza2) + zza2;
    }

    public static int zzb(zzgo zzgo) {
        int zzbn = zzgo.zzbn();
        return zzg(zzbn) + zzbn;
    }

    public static int zzb(String str) {
        int i;
        try {
            i = zzie.zza((CharSequence) str);
        } catch (zzih e2) {
            i = str.getBytes(zzff.zza).length;
        }
        return zzg(i) + i;
    }

    public static int zzb(boolean z) {
        return 1;
    }

    public static int zzb(byte[] bArr) {
        int length = bArr.length;
        return zzg(length) + length;
    }

    public static int zzc(int i, zzdu zzdu) {
        int zze = zze(i);
        int zza2 = zzdu.zza();
        return zze + zzg(zza2) + zza2;
    }

    @Deprecated
    static int zzc(int i, zzgo zzgo, zzhd zzhd) {
        int zze = zze(i) << 1;
        zzdl zzdl = (zzdl) zzgo;
        int zzbj = zzdl.zzbj();
        if (zzbj == -1) {
            zzbj = zzhd.zzb(zzdl);
            zzdl.zzc(zzbj);
        }
        return zze + zzbj;
    }

    @Deprecated
    public static int zzc(zzgo zzgo) {
        return zzgo.zzbn();
    }

    public static int zzd(int i, long j) {
        return zze(i) + zze(j);
    }

    public static int zzd(int i, zzdu zzdu) {
        return (zze(1) << 1) + zzg(2, i) + zzc(3, zzdu);
    }

    public static int zzd(long j) {
        return zze(j);
    }

    public static int zze(int i) {
        return zzg(i << 3);
    }

    public static int zze(int i, long j) {
        return zze(i) + zze(j);
    }

    public static int zze(long j) {
        int i;
        if ((-128 & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if ((-34359738368L & j) != 0) {
            i = 6;
            j >>>= 28;
        } else {
            i = 2;
        }
        if ((-2097152 & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & -16384) != 0 ? i + 1 : i;
    }

    public static int zzf(int i) {
        if (i >= 0) {
            return zzg(i);
        }
        return 10;
    }

    public static int zzf(int i, int i2) {
        return zze(i) + zzf(i2);
    }

    public static int zzf(int i, long j) {
        return zze(i) + zze(zzi(j));
    }

    public static int zzf(long j) {
        return zze(zzi(j));
    }

    public static int zzg(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    public static int zzg(int i, int i2) {
        return zze(i) + zzg(i2);
    }

    public static int zzg(int i, long j) {
        return zze(i) + 8;
    }

    public static int zzg(long j) {
        return 8;
    }

    public static int zzh(int i) {
        return zzg(zzm(i));
    }

    public static int zzh(int i, int i2) {
        return zze(i) + zzg(zzm(i2));
    }

    public static int zzh(int i, long j) {
        return zze(i) + 8;
    }

    public static int zzh(long j) {
        return 8;
    }

    public static int zzi(int i) {
        return 4;
    }

    public static int zzi(int i, int i2) {
        return zze(i) + 4;
    }

    private static long zzi(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int zzj(int i) {
        return 4;
    }

    public static int zzj(int i, int i2) {
        return zze(i) + 4;
    }

    public static int zzk(int i) {
        return zzf(i);
    }

    public static int zzk(int i, int i2) {
        return zze(i) + zzf(i2);
    }

    @Deprecated
    public static int zzl(int i) {
        return zzg(i);
    }

    private static int zzm(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public abstract int zza();

    public abstract void zza(byte b2) throws IOException;

    public final void zza(double d2) throws IOException {
        zzc(Double.doubleToRawLongBits(d2));
    }

    public final void zza(float f2) throws IOException {
        zzd(Float.floatToRawIntBits(f2));
    }

    public abstract void zza(int i) throws IOException;

    public final void zza(int i, double d2) throws IOException {
        zzc(i, Double.doubleToRawLongBits(d2));
    }

    public final void zza(int i, float f2) throws IOException {
        zze(i, Float.floatToRawIntBits(f2));
    }

    public abstract void zza(int i, int i2) throws IOException;

    public abstract void zza(int i, long j) throws IOException;

    public abstract void zza(int i, zzdu zzdu) throws IOException;

    public abstract void zza(int i, zzgo zzgo) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zza(int i, zzgo zzgo, zzhd zzhd) throws IOException;

    public abstract void zza(int i, String str) throws IOException;

    public abstract void zza(int i, boolean z) throws IOException;

    public abstract void zza(long j) throws IOException;

    public abstract void zza(zzdu zzdu) throws IOException;

    public abstract void zza(zzgo zzgo) throws IOException;

    public abstract void zza(String str) throws IOException;

    /* access modifiers changed from: package-private */
    public final void zza(String str, zzih zzih) throws IOException {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzih);
        byte[] bytes = str.getBytes(zzff.zza);
        try {
            zzb(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e2) {
            throw new zza(e2);
        } catch (zza e3) {
            throw e3;
        }
    }

    public final void zza(boolean z) throws IOException {
        zza(z ? (byte) 1 : 0);
    }

    public final void zzb() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract void zzb(int i) throws IOException;

    public abstract void zzb(int i, int i2) throws IOException;

    public final void zzb(int i, long j) throws IOException {
        zza(i, zzi(j));
    }

    public abstract void zzb(int i, zzdu zzdu) throws IOException;

    public final void zzb(long j) throws IOException {
        zza(zzi(j));
    }

    /* access modifiers changed from: package-private */
    public abstract void zzb(byte[] bArr, int i, int i2) throws IOException;

    public final void zzc(int i) throws IOException {
        zzb(zzm(i));
    }

    public abstract void zzc(int i, int i2) throws IOException;

    public abstract void zzc(int i, long j) throws IOException;

    public abstract void zzc(long j) throws IOException;

    public abstract void zzd(int i) throws IOException;

    public final void zzd(int i, int i2) throws IOException {
        zzc(i, zzm(i2));
    }

    public abstract void zze(int i, int i2) throws IOException;
}
