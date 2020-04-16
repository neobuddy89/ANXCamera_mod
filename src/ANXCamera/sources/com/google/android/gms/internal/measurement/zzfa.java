package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.3.0 */
final /* synthetic */ class zzfa {
    static final /* synthetic */ int[] zza;
    static final /* synthetic */ int[] zzb;

    static {
        int[] iArr = new int[zzfq.values().length];
        zzb = iArr;
        try {
            iArr[zzfq.BYTE_STRING.ordinal()] = 1;
        } catch (NoSuchFieldError e2) {
        }
        try {
            zzb[zzfq.MESSAGE.ordinal()] = 2;
        } catch (NoSuchFieldError e3) {
        }
        try {
            zzb[zzfq.STRING.ordinal()] = 3;
        } catch (NoSuchFieldError e4) {
        }
        int[] iArr2 = new int[zzez.values().length];
        zza = iArr2;
        try {
            iArr2[zzez.MAP.ordinal()] = 1;
        } catch (NoSuchFieldError e5) {
        }
        try {
            zza[zzez.VECTOR.ordinal()] = 2;
        } catch (NoSuchFieldError e6) {
        }
        try {
            zza[zzez.SCALAR.ordinal()] = 3;
        } catch (NoSuchFieldError e7) {
        }
    }
}
