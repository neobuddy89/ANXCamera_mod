package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.3.0 */
final class zzig {
    /* access modifiers changed from: private */
    public static void zzb(byte b2, byte b3, byte b4, byte b5, char[] cArr, int i) throws zzfo {
        if (zzg(b3) || (((b2 << 28) + (b3 + 112)) >> 30) != 0 || zzg(b4) || zzg(b5)) {
            throw zzfo.zzh();
        }
        byte b6 = ((b2 & 7) << 18) | ((b3 & 63) << 12) | ((b4 & 63) << 6) | (b5 & 63);
        cArr[i] = (char) ((b6 >>> 10) + 55232);
        cArr[i + 1] = (char) ((b6 & 1023) + 56320);
    }

    /* access modifiers changed from: private */
    public static void zzb(byte b2, byte b3, byte b4, char[] cArr, int i) throws zzfo {
        if (zzg(b3) || ((b2 == -32 && b3 < -96) || ((b2 == -19 && b3 >= -96) || zzg(b4)))) {
            throw zzfo.zzh();
        }
        cArr[i] = (char) (((b2 & 15) << 12) | ((b3 & 63) << 6) | (b4 & 63));
    }

    /* access modifiers changed from: private */
    public static void zzb(byte b2, byte b3, char[] cArr, int i) throws zzfo {
        if (b2 < -62 || zzg(b3)) {
            throw zzfo.zzh();
        }
        cArr[i] = (char) (((b2 & 31) << 6) | (b3 & 63));
    }

    /* access modifiers changed from: private */
    public static void zzb(byte b2, char[] cArr, int i) {
        cArr[i] = (char) b2;
    }

    /* access modifiers changed from: private */
    public static boolean zzd(byte b2) {
        return b2 >= 0;
    }

    /* access modifiers changed from: private */
    public static boolean zze(byte b2) {
        return b2 < -32;
    }

    /* access modifiers changed from: private */
    public static boolean zzf(byte b2) {
        return b2 < -16;
    }

    private static boolean zzg(byte b2) {
        return b2 > -65;
    }
}
