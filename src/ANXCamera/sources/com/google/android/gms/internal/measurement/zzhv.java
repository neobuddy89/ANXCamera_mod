package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.3.0 */
abstract class zzhv<T, B> {
    zzhv() {
    }

    /* access modifiers changed from: package-private */
    public abstract B zza();

    /* access modifiers changed from: package-private */
    public abstract T zza(B b2);

    /* access modifiers changed from: package-private */
    public abstract void zza(B b2, int i, int i2);

    /* access modifiers changed from: package-private */
    public abstract void zza(B b2, int i, long j);

    /* access modifiers changed from: package-private */
    public abstract void zza(B b2, int i, zzdu zzdu);

    /* access modifiers changed from: package-private */
    public abstract void zza(B b2, int i, T t);

    /* access modifiers changed from: package-private */
    public abstract void zza(T t, zzis zzis) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zza(Object obj, T t);

    /* access modifiers changed from: package-private */
    public abstract boolean zza(zzhe zzhe);

    /* access modifiers changed from: package-private */
    public final boolean zza(B b2, zzhe zzhe) throws IOException {
        int zzb = zzhe.zzb();
        int i = zzb >>> 3;
        int i2 = zzb & 7;
        if (i2 == 0) {
            zza(b2, i, zzhe.zzg());
            return true;
        } else if (i2 == 1) {
            zzb(b2, i, zzhe.zzi());
            return true;
        } else if (i2 == 2) {
            zza(b2, i, zzhe.zzn());
            return true;
        } else if (i2 == 3) {
            Object zza = zza();
            int i3 = 4 | (i << 3);
            while (zzhe.zza() != Integer.MAX_VALUE) {
                if (!zza(zza, zzhe)) {
                    break;
                }
            }
            if (i3 == zzhe.zzb()) {
                zza(b2, i, zza(zza));
                return true;
            }
            throw zzfo.zze();
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                zza(b2, i, zzhe.zzj());
                return true;
            }
            throw zzfo.zzf();
        }
    }

    /* access modifiers changed from: package-private */
    public abstract T zzb(Object obj);

    /* access modifiers changed from: package-private */
    public abstract void zzb(B b2, int i, long j);

    /* access modifiers changed from: package-private */
    public abstract void zzb(T t, zzis zzis) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zzb(Object obj, B b2);

    /* access modifiers changed from: package-private */
    public abstract B zzc(Object obj);

    /* access modifiers changed from: package-private */
    public abstract T zzc(T t, T t2);

    /* access modifiers changed from: package-private */
    public abstract void zzd(Object obj);

    /* access modifiers changed from: package-private */
    public abstract int zze(T t);

    /* access modifiers changed from: package-private */
    public abstract int zzf(T t);
}
