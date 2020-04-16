package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzey;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.3.0 */
final class zzew<T extends zzey<T>> {
    private static final zzew zzd = new zzew(true);
    final zzhi<T, Object> zza;
    private boolean zzb;
    private boolean zzc;

    private zzew() {
        this.zza = zzhi.zza(16);
    }

    private zzew(zzhi<T, Object> zzhi) {
        this.zza = zzhi;
        zzb();
    }

    private zzew(boolean z) {
        this(zzhi.zza(0));
        zzb();
    }

    public static int zza(zzey<?> zzey, Object obj) {
        zzim zzb2 = zzey.zzb();
        int zza2 = zzey.zza();
        if (!zzey.zzd()) {
            return zza(zzb2, zza2, obj);
        }
        int i = 0;
        if (zzey.zze()) {
            for (Object zzb3 : (List) obj) {
                i += zzb(zzb2, zzb3);
            }
            return zzen.zze(zza2) + i + zzen.zzl(i);
        }
        for (Object zza3 : (List) obj) {
            i += zza(zzb2, zza2, zza3);
        }
        return i;
    }

    static int zza(zzim zzim, int i, Object obj) {
        int zze = zzen.zze(i);
        if (zzim == zzim.GROUP) {
            zzff.zza((zzgo) obj);
            zze <<= 1;
        }
        return zze + zzb(zzim, obj);
    }

    public static <T extends zzey<T>> zzew<T> zza() {
        return zzd;
    }

    private final Object zza(T t) {
        Object obj = this.zza.get(t);
        if (!(obj instanceof zzfp)) {
            return obj;
        }
        zzfp zzfp = (zzfp) obj;
        return zzfp.zza();
    }

    private static Object zza(Object obj) {
        if (obj instanceof zzgt) {
            return ((zzgt) obj).zza();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    static void zza(zzen zzen, zzim zzim, int i, Object obj) throws IOException {
        if (zzim == zzim.GROUP) {
            zzgo zzgo = (zzgo) obj;
            zzff.zza(zzgo);
            zzen.zza(i, 3);
            zzgo.zza(zzen);
            zzen.zza(i, 4);
            return;
        }
        zzen.zza(i, zzim.zzb());
        switch (zzev.zzb[zzim.ordinal()]) {
            case 1:
                zzen.zza(((Double) obj).doubleValue());
                return;
            case 2:
                zzen.zza(((Float) obj).floatValue());
                return;
            case 3:
                zzen.zza(((Long) obj).longValue());
                return;
            case 4:
                zzen.zza(((Long) obj).longValue());
                return;
            case 5:
                zzen.zza(((Integer) obj).intValue());
                return;
            case 6:
                zzen.zzc(((Long) obj).longValue());
                return;
            case 7:
                zzen.zzd(((Integer) obj).intValue());
                return;
            case 8:
                zzen.zza(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzgo) obj).zza(zzen);
                return;
            case 10:
                zzen.zza((zzgo) obj);
                return;
            case 11:
                if (obj instanceof zzdu) {
                    zzen.zza((zzdu) obj);
                    return;
                } else {
                    zzen.zza((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzdu) {
                    zzen.zza((zzdu) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzen.zzb(bArr, 0, bArr.length);
                return;
            case 13:
                zzen.zzb(((Integer) obj).intValue());
                return;
            case 14:
                zzen.zzd(((Integer) obj).intValue());
                return;
            case 15:
                zzen.zzc(((Long) obj).longValue());
                return;
            case 16:
                zzen.zzc(((Integer) obj).intValue());
                return;
            case 17:
                zzen.zzb(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzfi) {
                    zzen.zza(((zzfi) obj).zza());
                    return;
                } else {
                    zzen.zza(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    private static void zza(zzim zzim, Object obj) {
        zzff.zza(obj);
        boolean z = true;
        switch (zzev.zza[zzim.zza().ordinal()]) {
            case 1:
                z = obj instanceof Integer;
                break;
            case 2:
                z = obj instanceof Long;
                break;
            case 3:
                z = obj instanceof Float;
                break;
            case 4:
                z = obj instanceof Double;
                break;
            case 5:
                z = obj instanceof Boolean;
                break;
            case 6:
                z = obj instanceof String;
                break;
            case 7:
                if (!(obj instanceof zzdu) && !(obj instanceof byte[])) {
                    z = false;
                    break;
                }
            case 8:
                if (!(obj instanceof Integer) && !(obj instanceof zzfi)) {
                    z = false;
                    break;
                }
            case 9:
                if (!(obj instanceof zzgo) && !(obj instanceof zzfp)) {
                    z = false;
                    break;
                }
            default:
                z = false;
                break;
        }
        if (!z) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    private static <T extends zzey<T>> boolean zza(Map.Entry<T, Object> entry) {
        zzey zzey = (zzey) entry.getKey();
        if (zzey.zzc() == zzip.MESSAGE) {
            if (zzey.zzd()) {
                for (zzgo zzbl : (List) entry.getValue()) {
                    if (!zzbl.zzbl()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzgo) {
                    if (!((zzgo) value).zzbl()) {
                        return false;
                    }
                } else if (value instanceof zzfp) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    private static int zzb(zzim zzim, Object obj) {
        switch (zzev.zzb[zzim.ordinal()]) {
            case 1:
                return zzen.zzb(((Double) obj).doubleValue());
            case 2:
                return zzen.zzb(((Float) obj).floatValue());
            case 3:
                return zzen.zzd(((Long) obj).longValue());
            case 4:
                return zzen.zze(((Long) obj).longValue());
            case 5:
                return zzen.zzf(((Integer) obj).intValue());
            case 6:
                return zzen.zzg(((Long) obj).longValue());
            case 7:
                return zzen.zzi(((Integer) obj).intValue());
            case 8:
                return zzen.zzb(((Boolean) obj).booleanValue());
            case 9:
                return zzen.zzc((zzgo) obj);
            case 10:
                return obj instanceof zzfp ? zzen.zza((zzft) (zzfp) obj) : zzen.zzb((zzgo) obj);
            case 11:
                return obj instanceof zzdu ? zzen.zzb((zzdu) obj) : zzen.zzb((String) obj);
            case 12:
                return obj instanceof zzdu ? zzen.zzb((zzdu) obj) : zzen.zzb((byte[]) obj);
            case 13:
                return zzen.zzg(((Integer) obj).intValue());
            case 14:
                return zzen.zzj(((Integer) obj).intValue());
            case 15:
                return zzen.zzh(((Long) obj).longValue());
            case 16:
                return zzen.zzh(((Integer) obj).intValue());
            case 17:
                return zzen.zzf(((Long) obj).longValue());
            case 18:
                return obj instanceof zzfi ? zzen.zzk(((zzfi) obj).zza()) : zzen.zzk(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private final void zzb(T t, Object obj) {
        if (!t.zzd()) {
            zza(t.zzb(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                zza(t.zzb(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzfp) {
            this.zzc = true;
        }
        this.zza.put(t, obj);
    }

    private final void zzb(Map.Entry<T, Object> entry) {
        zzey zzey = (zzey) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzfp) {
            zzfp zzfp = (zzfp) value;
            value = zzfp.zza();
        }
        if (zzey.zzd()) {
            Object zza2 = zza(zzey);
            if (zza2 == null) {
                zza2 = new ArrayList();
            }
            for (Object zza3 : (List) value) {
                ((List) zza2).add(zza(zza3));
            }
            this.zza.put(zzey, zza2);
        } else if (zzey.zzc() == zzip.MESSAGE) {
            Object zza4 = zza(zzey);
            if (zza4 == null) {
                this.zza.put(zzey, zza(value));
            } else {
                this.zza.put(zzey, zza4 instanceof zzgt ? zzey.zza((zzgt) zza4, (zzgt) value) : zzey.zza(((zzgo) zza4).zzbr(), (zzgo) value).zzu());
            }
        } else {
            this.zza.put(zzey, zza(value));
        }
    }

    private static int zzc(Map.Entry<T, Object> entry) {
        zzey zzey = (zzey) entry.getKey();
        Object value = entry.getValue();
        return (zzey.zzc() != zzip.MESSAGE || zzey.zzd() || zzey.zze()) ? zza((zzey<?>) zzey, value) : value instanceof zzfp ? zzen.zzb(((zzey) entry.getKey()).zza(), (zzft) (zzfp) value) : zzen.zzb(((zzey) entry.getKey()).zza(), (zzgo) value);
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzew zzew = new zzew();
        for (int i = 0; i < this.zza.zzc(); i++) {
            Map.Entry<T, Object> zzb2 = this.zza.zzb(i);
            zzew.zzb((zzey) zzb2.getKey(), zzb2.getValue());
        }
        for (Map.Entry next : this.zza.zzd()) {
            zzew.zzb((zzey) next.getKey(), next.getValue());
        }
        zzew.zzc = this.zzc;
        return zzew;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzew)) {
            return false;
        }
        return this.zza.equals(((zzew) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zza(zzew<T> zzew) {
        for (int i = 0; i < zzew.zza.zzc(); i++) {
            zzb(zzew.zza.zzb(i));
        }
        for (Map.Entry<T, Object> zzb2 : zzew.zza.zzd()) {
            zzb(zzb2);
        }
    }

    public final void zzb() {
        if (!this.zzb) {
            this.zza.zza();
            this.zzb = true;
        }
    }

    public final boolean zzc() {
        return this.zzb;
    }

    public final Iterator<Map.Entry<T, Object>> zzd() {
        return this.zzc ? new zzfu(this.zza.entrySet().iterator()) : this.zza.entrySet().iterator();
    }

    /* access modifiers changed from: package-private */
    public final Iterator<Map.Entry<T, Object>> zze() {
        return this.zzc ? new zzfu(this.zza.zze().iterator()) : this.zza.zze().iterator();
    }

    public final boolean zzf() {
        for (int i = 0; i < this.zza.zzc(); i++) {
            if (!zza(this.zza.zzb(i))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> zza2 : this.zza.zzd()) {
            if (!zza(zza2)) {
                return false;
            }
        }
        return true;
    }

    public final int zzg() {
        int i = 0;
        for (int i2 = 0; i2 < this.zza.zzc(); i2++) {
            i += zzc(this.zza.zzb(i2));
        }
        for (Map.Entry<T, Object> zzc2 : this.zza.zzd()) {
            i += zzc(zzc2);
        }
        return i;
    }
}
