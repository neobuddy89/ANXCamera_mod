package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.3.0 */
final class zzib {
    static final boolean zza = (ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN);
    private static final Logger zzb = Logger.getLogger(zzib.class.getName());
    private static final Unsafe zzc = zzc();
    private static final Class<?> zzd = zzdr.zzb();
    private static final boolean zze = zzd(Long.TYPE);
    private static final boolean zzf = zzd(Integer.TYPE);
    private static final zzd zzg;
    private static final boolean zzh = zze();
    private static final boolean zzi = zzd();
    private static final long zzj = ((long) zzb(byte[].class));
    private static final long zzk;
    private static final long zzl;
    private static final long zzm;
    private static final long zzn;
    private static final long zzo;
    private static final long zzp;
    private static final long zzq;
    private static final long zzr;
    private static final long zzs;
    private static final long zzt;
    private static final long zzu = ((long) zzb(Object[].class));
    private static final long zzv = ((long) zzc(Object[].class));
    private static final long zzw;
    private static final int zzx = ((int) (zzj & 7));

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.3.0 */
    static final class zza extends zzd {
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zza(Object obj, long j) {
            return zzib.zza ? zzib.zzk(obj, j) : zzib.zzl(obj, j);
        }

        public final void zza(Object obj, long j, byte b2) {
            if (zzib.zza) {
                zzib.zzc(obj, j, b2);
            } else {
                zzib.zzd(obj, j, b2);
            }
        }

        public final void zza(Object obj, long j, double d2) {
            zza(obj, j, Double.doubleToLongBits(d2));
        }

        public final void zza(Object obj, long j, float f2) {
            zza(obj, j, Float.floatToIntBits(f2));
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzib.zza) {
                zzib.zzd(obj, j, z);
            } else {
                zzib.zze(obj, j, z);
            }
        }

        public final boolean zzb(Object obj, long j) {
            return zzib.zza ? zzib.zzm(obj, j) : zzib.zzn(obj, j);
        }

        public final float zzc(Object obj, long j) {
            return Float.intBitsToFloat(zze(obj, j));
        }

        public final double zzd(Object obj, long j) {
            return Double.longBitsToDouble(zzf(obj, j));
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.3.0 */
    static final class zzb extends zzd {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zza(Object obj, long j) {
            return this.zza.getByte(obj, j);
        }

        public final void zza(Object obj, long j, byte b2) {
            this.zza.putByte(obj, j, b2);
        }

        public final void zza(Object obj, long j, double d2) {
            this.zza.putDouble(obj, j, d2);
        }

        public final void zza(Object obj, long j, float f2) {
            this.zza.putFloat(obj, j, f2);
        }

        public final void zza(Object obj, long j, boolean z) {
            this.zza.putBoolean(obj, j, z);
        }

        public final boolean zzb(Object obj, long j) {
            return this.zza.getBoolean(obj, j);
        }

        public final float zzc(Object obj, long j) {
            return this.zza.getFloat(obj, j);
        }

        public final double zzd(Object obj, long j) {
            return this.zza.getDouble(obj, j);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.3.0 */
    static final class zzc extends zzd {
        zzc(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zza(Object obj, long j) {
            return zzib.zza ? zzib.zzk(obj, j) : zzib.zzl(obj, j);
        }

        public final void zza(Object obj, long j, byte b2) {
            if (zzib.zza) {
                zzib.zzc(obj, j, b2);
            } else {
                zzib.zzd(obj, j, b2);
            }
        }

        public final void zza(Object obj, long j, double d2) {
            zza(obj, j, Double.doubleToLongBits(d2));
        }

        public final void zza(Object obj, long j, float f2) {
            zza(obj, j, Float.floatToIntBits(f2));
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzib.zza) {
                zzib.zzd(obj, j, z);
            } else {
                zzib.zze(obj, j, z);
            }
        }

        public final boolean zzb(Object obj, long j) {
            return zzib.zza ? zzib.zzm(obj, j) : zzib.zzn(obj, j);
        }

        public final float zzc(Object obj, long j) {
            return Float.intBitsToFloat(zze(obj, j));
        }

        public final double zzd(Object obj, long j) {
            return Double.longBitsToDouble(zzf(obj, j));
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.3.0 */
    static abstract class zzd {
        Unsafe zza;

        zzd(Unsafe unsafe) {
            this.zza = unsafe;
        }

        public abstract byte zza(Object obj, long j);

        public abstract void zza(Object obj, long j, byte b2);

        public abstract void zza(Object obj, long j, double d2);

        public abstract void zza(Object obj, long j, float f2);

        public final void zza(Object obj, long j, int i) {
            this.zza.putInt(obj, j, i);
        }

        public final void zza(Object obj, long j, long j2) {
            this.zza.putLong(obj, j, j2);
        }

        public abstract void zza(Object obj, long j, boolean z);

        public abstract boolean zzb(Object obj, long j);

        public abstract float zzc(Object obj, long j);

        public abstract double zzd(Object obj, long j);

        public final int zze(Object obj, long j) {
            return this.zza.getInt(obj, j);
        }

        public final long zzf(Object obj, long j) {
            return this.zza.getLong(obj, j);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00f5  */
    static {
        long j;
        Class<double[]> cls = double[].class;
        Class<float[]> cls2 = float[].class;
        Class<long[]> cls3 = long[].class;
        Class<int[]> cls4 = int[].class;
        Class<boolean[]> cls5 = boolean[].class;
        zzd zzd2 = null;
        if (zzc != null) {
            if (!zzdr.zza()) {
                zzd2 = new zzb(zzc);
            } else if (zze) {
                zzd2 = new zzc(zzc);
            } else if (zzf) {
                zzd2 = new zza(zzc);
            }
        }
        zzg = zzd2;
        zzk = (long) zzb(cls5);
        zzl = (long) zzc(cls5);
        zzm = (long) zzb(cls4);
        zzn = (long) zzc(cls4);
        zzo = (long) zzb(cls3);
        zzp = (long) zzc(cls3);
        zzq = (long) zzb(cls2);
        zzr = (long) zzc(cls2);
        zzs = (long) zzb(cls);
        zzt = (long) zzc(cls);
        Field zzf2 = zzf();
        if (zzf2 != null) {
            zzd zzd3 = zzg;
            if (zzd3 != null) {
                j = zzd3.zza.objectFieldOffset(zzf2);
                zzw = j;
            }
        }
        j = -1;
        zzw = j;
    }

    private zzib() {
    }

    static byte zza(byte[] bArr, long j) {
        return zzg.zza(bArr, zzj + j);
    }

    static int zza(Object obj, long j) {
        return zzg.zze(obj, j);
    }

    static <T> T zza(Class<T> cls) {
        try {
            return zzc.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable th) {
            return null;
        }
    }

    static void zza(Object obj, long j, double d2) {
        zzg.zza(obj, j, d2);
    }

    static void zza(Object obj, long j, float f2) {
        zzg.zza(obj, j, f2);
    }

    static void zza(Object obj, long j, int i) {
        zzg.zza(obj, j, i);
    }

    static void zza(Object obj, long j, long j2) {
        zzg.zza(obj, j, j2);
    }

    static void zza(Object obj, long j, Object obj2) {
        zzg.zza.putObject(obj, j, obj2);
    }

    static void zza(Object obj, long j, boolean z) {
        zzg.zza(obj, j, z);
    }

    static void zza(byte[] bArr, long j, byte b2) {
        zzg.zza((Object) bArr, zzj + j, b2);
    }

    static boolean zza() {
        return zzi;
    }

    private static int zzb(Class<?> cls) {
        if (zzi) {
            return zzg.zza.arrayBaseOffset(cls);
        }
        return -1;
    }

    static long zzb(Object obj, long j) {
        return zzg.zzf(obj, j);
    }

    static boolean zzb() {
        return zzh;
    }

    private static int zzc(Class<?> cls) {
        if (zzi) {
            return zzg.zza.arrayIndexScale(cls);
        }
        return -1;
    }

    static Unsafe zzc() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzid());
        } catch (Throwable th) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static void zzc(Object obj, long j, byte b2) {
        long j2 = -4 & j;
        int zza2 = zza(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        zza(obj, j2, ((255 & b2) << i) | (zza2 & (~(255 << i))));
    }

    static boolean zzc(Object obj, long j) {
        return zzg.zzb(obj, j);
    }

    static float zzd(Object obj, long j) {
        return zzg.zzc(obj, j);
    }

    /* access modifiers changed from: private */
    public static void zzd(Object obj, long j, byte b2) {
        long j2 = -4 & j;
        int i = (((int) j) & 3) << 3;
        zza(obj, j2, ((255 & b2) << i) | (zza(obj, j2) & (~(255 << i))));
    }

    /* access modifiers changed from: private */
    public static void zzd(Object obj, long j, boolean z) {
        zzc(obj, j, z ? (byte) 1 : 0);
    }

    private static boolean zzd() {
        Unsafe unsafe = zzc;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("arrayBaseOffset", new Class[]{Class.class});
            cls.getMethod("arrayIndexScale", new Class[]{Class.class});
            cls.getMethod("getInt", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putInt", new Class[]{Object.class, Long.TYPE, Integer.TYPE});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putLong", new Class[]{Object.class, Long.TYPE, Long.TYPE});
            cls.getMethod("getObject", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putObject", new Class[]{Object.class, Long.TYPE, Object.class});
            if (zzdr.zza()) {
                return true;
            }
            cls.getMethod("getByte", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putByte", new Class[]{Object.class, Long.TYPE, Byte.TYPE});
            cls.getMethod("getBoolean", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putBoolean", new Class[]{Object.class, Long.TYPE, Boolean.TYPE});
            cls.getMethod("getFloat", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putFloat", new Class[]{Object.class, Long.TYPE, Float.TYPE});
            cls.getMethod("getDouble", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putDouble", new Class[]{Object.class, Long.TYPE, Double.TYPE});
            return true;
        } catch (Throwable th) {
            Logger logger = zzb;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    private static boolean zzd(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        if (!zzdr.zza()) {
            return false;
        }
        try {
            Class<?> cls3 = zzd;
            cls3.getMethod("peekLong", new Class[]{cls, Boolean.TYPE});
            cls3.getMethod("pokeLong", new Class[]{cls, Long.TYPE, Boolean.TYPE});
            cls3.getMethod("pokeInt", new Class[]{cls, Integer.TYPE, Boolean.TYPE});
            cls3.getMethod("peekInt", new Class[]{cls, Boolean.TYPE});
            cls3.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls3.getMethod("peekByte", new Class[]{cls});
            cls3.getMethod("pokeByteArray", new Class[]{cls, cls2, Integer.TYPE, Integer.TYPE});
            cls3.getMethod("peekByteArray", new Class[]{cls, cls2, Integer.TYPE, Integer.TYPE});
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    static double zze(Object obj, long j) {
        return zzg.zzd(obj, j);
    }

    /* access modifiers changed from: private */
    public static void zze(Object obj, long j, boolean z) {
        zzd(obj, j, z ? (byte) 1 : 0);
    }

    private static boolean zze() {
        Unsafe unsafe = zzc;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            if (zzf() == null) {
                return false;
            }
            if (zzdr.zza()) {
                return true;
            }
            cls.getMethod("getByte", new Class[]{Long.TYPE});
            cls.getMethod("putByte", new Class[]{Long.TYPE, Byte.TYPE});
            cls.getMethod("getInt", new Class[]{Long.TYPE});
            cls.getMethod("putInt", new Class[]{Long.TYPE, Integer.TYPE});
            cls.getMethod("getLong", new Class[]{Long.TYPE});
            cls.getMethod("putLong", new Class[]{Long.TYPE, Long.TYPE});
            cls.getMethod("copyMemory", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
            cls.getMethod("copyMemory", new Class[]{Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE});
            return true;
        } catch (Throwable th) {
            Logger logger = zzb;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    static Object zzf(Object obj, long j) {
        return zzg.zza.getObject(obj, j);
    }

    private static Field zzf() {
        if (zzdr.zza()) {
            Field zza2 = zza((Class<?>) Buffer.class, "effectiveDirectAddress");
            if (zza2 != null) {
                return zza2;
            }
        }
        Field zza3 = zza((Class<?>) Buffer.class, "address");
        if (zza3 == null || zza3.getType() != Long.TYPE) {
            return null;
        }
        return zza3;
    }

    /* access modifiers changed from: private */
    public static byte zzk(Object obj, long j) {
        return (byte) (zza(obj, -4 & j) >>> ((int) (((~j) & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static byte zzl(Object obj, long j) {
        return (byte) (zza(obj, -4 & j) >>> ((int) ((j & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static boolean zzm(Object obj, long j) {
        return zzk(obj, j) != 0;
    }

    /* access modifiers changed from: private */
    public static boolean zzn(Object obj, long j) {
        return zzl(obj, j) != 0;
    }
}
