package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzbj;

/* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
final /* synthetic */ class zzq {
    static final /* synthetic */ int[] zza;
    static final /* synthetic */ int[] zzb;

    static {
        int[] iArr = new int[zzbj.zzd.zza.values().length];
        zzb = iArr;
        try {
            iArr[zzbj.zzd.zza.LESS_THAN.ordinal()] = 1;
        } catch (NoSuchFieldError e2) {
        }
        try {
            zzb[zzbj.zzd.zza.GREATER_THAN.ordinal()] = 2;
        } catch (NoSuchFieldError e3) {
        }
        try {
            zzb[zzbj.zzd.zza.EQUAL.ordinal()] = 3;
        } catch (NoSuchFieldError e4) {
        }
        try {
            zzb[zzbj.zzd.zza.BETWEEN.ordinal()] = 4;
        } catch (NoSuchFieldError e5) {
        }
        int[] iArr2 = new int[zzbj.zzf.zzb.values().length];
        zza = iArr2;
        try {
            iArr2[zzbj.zzf.zzb.REGEXP.ordinal()] = 1;
        } catch (NoSuchFieldError e6) {
        }
        try {
            zza[zzbj.zzf.zzb.BEGINS_WITH.ordinal()] = 2;
        } catch (NoSuchFieldError e7) {
        }
        try {
            zza[zzbj.zzf.zzb.ENDS_WITH.ordinal()] = 3;
        } catch (NoSuchFieldError e8) {
        }
        try {
            zza[zzbj.zzf.zzb.PARTIAL.ordinal()] = 4;
        } catch (NoSuchFieldError e9) {
        }
        try {
            zza[zzbj.zzf.zzb.EXACT.ordinal()] = 5;
        } catch (NoSuchFieldError e10) {
        }
        try {
            zza[zzbj.zzf.zzb.IN_LIST.ordinal()] = 6;
        } catch (NoSuchFieldError e11) {
        }
    }
}
