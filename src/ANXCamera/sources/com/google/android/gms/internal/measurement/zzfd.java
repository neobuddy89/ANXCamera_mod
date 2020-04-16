package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfd;
import com.google.android.gms.internal.measurement.zzfd.zzb;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.3.0 */
public abstract class zzfd<MessageType extends zzfd<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzdl<MessageType, BuilderType> {
    private static Map<Object, zzfd<?, ?>> zzd = new ConcurrentHashMap();
    protected zzhy zzb = zzhy.zza();
    private int zzc = -1;

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.3.0 */
    public static class zza<T extends zzfd<T, ?>> extends zzdp<T> {
        private final T zza;

        public zza(T t) {
            this.zza = t;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.3.0 */
    public static abstract class zzb<MessageType extends zzfd<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzdn<MessageType, BuilderType> {
        protected MessageType zza;
        protected boolean zzb = false;
        private final MessageType zzc;

        protected zzb(MessageType messagetype) {
            this.zzc = messagetype;
            this.zza = (zzfd) messagetype.zza(zze.zzd, (Object) null, (Object) null);
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzgz.zza().zza(messagetype).zzb(messagetype, messagetype2);
        }

        /* access modifiers changed from: private */
        /* renamed from: zzb */
        public final BuilderType zza(zzeg zzeg, zzeq zzeq) throws IOException {
            if (this.zzb) {
                zzq();
                this.zzb = false;
            }
            try {
                zzgz.zza().zza(this.zza).zza(this.zza, zzel.zza(zzeg), zzeq);
                return this;
            } catch (RuntimeException e2) {
                if (e2.getCause() instanceof IOException) {
                    throw ((IOException) e2.getCause());
                }
                throw e2;
            }
        }

        private final BuilderType zzb(byte[] bArr, int i, int i2, zzeq zzeq) throws zzfo {
            if (this.zzb) {
                zzq();
                this.zzb = false;
            }
            try {
                zzgz.zza().zza(this.zza).zza(this.zza, bArr, 0, i2 + 0, new zzdt(zzeq));
                return this;
            } catch (zzfo e2) {
                throw e2;
            } catch (IndexOutOfBoundsException e3) {
                throw zzfo.zza();
            } catch (IOException e4) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e4);
            }
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zzb zzb2 = (zzb) ((zzfd) this.zzc).zza(zze.zze, (Object) null, (Object) null);
            zzb2.zza((zzfd) zzt());
            return zzb2;
        }

        public final /* synthetic */ zzdn zza(byte[] bArr, int i, int i2) throws zzfo {
            return zzb(bArr, 0, i2, zzeq.zza());
        }

        public final /* synthetic */ zzdn zza(byte[] bArr, int i, int i2, zzeq zzeq) throws zzfo {
            return zzb(bArr, 0, i2, zzeq);
        }

        public final BuilderType zza(MessageType messagetype) {
            if (this.zzb) {
                zzq();
                this.zzb = false;
            }
            zza(this.zza, messagetype);
            return this;
        }

        public final boolean zzbl() {
            return zzfd.zza(this.zza, false);
        }

        public final /* synthetic */ zzgo zzbt() {
            return this.zzc;
        }

        public final /* synthetic */ zzdn zzp() {
            return (zzb) clone();
        }

        /* access modifiers changed from: protected */
        public void zzq() {
            MessageType messagetype = (zzfd) this.zza.zza(zze.zzd, (Object) null, (Object) null);
            zza(messagetype, this.zza);
            this.zza = messagetype;
        }

        /* renamed from: zzr */
        public MessageType zzt() {
            if (this.zzb) {
                return this.zza;
            }
            MessageType messagetype = this.zza;
            zzgz.zza().zza(messagetype).zzc(messagetype);
            this.zzb = true;
            return this.zza;
        }

        /* renamed from: zzs */
        public final MessageType zzu() {
            MessageType messagetype = (zzfd) zzt();
            if (messagetype.zzbl()) {
                return messagetype;
            }
            throw new zzhw(messagetype);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.3.0 */
    static final class zzc implements zzey<zzc> {
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }

        public final int zza() {
            throw new NoSuchMethodError();
        }

        public final zzgn zza(zzgn zzgn, zzgo zzgo) {
            throw new NoSuchMethodError();
        }

        public final zzgt zza(zzgt zzgt, zzgt zzgt2) {
            throw new NoSuchMethodError();
        }

        public final zzim zzb() {
            throw new NoSuchMethodError();
        }

        public final zzip zzc() {
            throw new NoSuchMethodError();
        }

        public final boolean zzd() {
            throw new NoSuchMethodError();
        }

        public final boolean zze() {
            throw new NoSuchMethodError();
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.3.0 */
    public static abstract class zzd<MessageType extends zzd<MessageType, BuilderType>, BuilderType> extends zzfd<MessageType, BuilderType> implements zzgq {
        protected zzew<zzc> zzc = zzew.zza();

        /* access modifiers changed from: package-private */
        public final zzew<zzc> zza() {
            if (this.zzc.zzc()) {
                this.zzc = (zzew) this.zzc.clone();
            }
            return this.zzc;
        }
    }

    /* 'enum' modifier removed */
    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.3.0 */
    public static final class zze {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        public static final int zzg = 7;
        public static final int zzh = 1;
        public static final int zzi = 2;
        public static final int zzj = 1;
        public static final int zzk = 2;
        private static final /* synthetic */ int[] zzl = {1, 2, 3, 4, 5, 6, 7};
        private static final /* synthetic */ int[] zzm = {1, 2};
        private static final /* synthetic */ int[] zzn = {1, 2};

        public static int[] zza() {
            return (int[]) zzl.clone();
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.3.0 */
    public static class zzf<ContainingType extends zzgo, Type> extends zzer<ContainingType, Type> {
    }

    static <T extends zzfd<?, ?>> T zza(Class<T> cls) {
        T t = (zzfd) zzd.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzfd) zzd.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (t == null) {
            t = (zzfd) ((zzfd) zzib.zza(cls)).zza(zze.zzf, (Object) null, (Object) null);
            if (t != null) {
                zzd.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    protected static <E> zzfl<E> zza(zzfl<E> zzfl) {
        int size = zzfl.size();
        return zzfl.zza(size == 0 ? 10 : size << 1);
    }

    protected static zzfm zza(zzfm zzfm) {
        int size = zzfm.size();
        return zzfm.zzc(size == 0 ? 10 : size << 1);
    }

    protected static Object zza(zzgo zzgo, String str, Object[] objArr) {
        return new zzhb(zzgo, str, objArr);
    }

    static Object zza(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected static <T extends zzfd<?, ?>> void zza(Class<T> cls, T t) {
        zzd.put(cls, t);
    }

    protected static final <T extends zzfd<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zze.zza, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzd2 = zzgz.zza().zza(t).zzd(t);
        if (z) {
            t.zza(zze.zzb, (Object) zzd2 ? t : null, (Object) null);
        }
        return zzd2;
    }

    protected static zzfj zzbo() {
        return zzfg.zzd();
    }

    protected static zzfm zzbp() {
        return zzgc.zzd();
    }

    protected static <E> zzfl<E> zzbq() {
        return zzhc.zzd();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzgz.zza().zza(this).zza(this, (zzfd) obj);
        }
        return false;
    }

    public int hashCode() {
        if (this.zza != 0) {
            return this.zza;
        }
        this.zza = zzgz.zza().zza(this).zza(this);
        return this.zza;
    }

    public String toString() {
        return zzgp.zza(this, super.toString());
    }

    /* access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);

    public final void zza(zzen zzen) throws IOException {
        zzgz.zza().zza(this).zza(this, (zzis) zzep.zza(zzen));
    }

    /* access modifiers changed from: package-private */
    public final int zzbj() {
        return this.zzc;
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends zzfd<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> BuilderType zzbk() {
        return (zzb) zza(zze.zze, (Object) null, (Object) null);
    }

    public final boolean zzbl() {
        return zza(this, Boolean.TRUE.booleanValue());
    }

    public final BuilderType zzbm() {
        BuilderType buildertype = (zzb) zza(zze.zze, (Object) null, (Object) null);
        buildertype.zza(this);
        return buildertype;
    }

    public final int zzbn() {
        if (this.zzc == -1) {
            this.zzc = zzgz.zza().zza(this).zzb(this);
        }
        return this.zzc;
    }

    public final /* synthetic */ zzgn zzbr() {
        zzb zzb2 = (zzb) zza(zze.zze, (Object) null, (Object) null);
        zzb2.zza(this);
        return zzb2;
    }

    public final /* synthetic */ zzgn zzbs() {
        return (zzb) zza(zze.zze, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzgo zzbt() {
        return (zzfd) zza(zze.zzf, (Object) null, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public final void zzc(int i) {
        this.zzc = i;
    }
}
