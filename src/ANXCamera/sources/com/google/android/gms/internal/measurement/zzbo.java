package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzbj;
import com.google.android.gms.internal.measurement.zzfd;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
public final class zzbo {

    /* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
    public static final class zza extends zzfd<zza, C0023zza> implements zzgq {
        /* access modifiers changed from: private */
        public static final zza zzh;
        private static volatile zzgx<zza> zzi;
        private int zzc;
        private String zzd = "";
        private boolean zze;
        private boolean zzf;
        private int zzg;

        /* renamed from: com.google.android.gms.internal.measurement.zzbo$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
        public static final class C0023zza extends zzfd.zzb<zza, C0023zza> implements zzgq {
            private C0023zza() {
                super(zza.zzh);
            }

            /* synthetic */ C0023zza(zzbq zzbq) {
                this();
            }

            public final C0023zza zza(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zza) this.zza).zza(str);
                return this;
            }

            public final String zza() {
                return ((zza) this.zza).zza();
            }

            public final boolean zzb() {
                return ((zza) this.zza).zzb();
            }

            public final boolean zzc() {
                return ((zza) this.zza).zzc();
            }

            public final boolean zzd() {
                return ((zza) this.zza).zzd();
            }

            public final int zze() {
                return ((zza) this.zza).zze();
            }
        }

        static {
            zza zza = new zza();
            zzh = zza;
            zzfd.zza(zza.class, zza);
        }

        private zza() {
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbq.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0023zza((zzbq) null);
                case 3:
                    return zza((zzgo) zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\b\u0000\u0002\u0007\u0001\u0003\u0007\u0002\u0004\u0004\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzgx<zza> zzgx = zzi;
                    if (zzgx == null) {
                        synchronized (zza.class) {
                            zzgx = zzi;
                            if (zzgx == null) {
                                zzgx = new zzfd.zza<>(zzh);
                                zzi = zzgx;
                            }
                        }
                    }
                    return zzgx;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public final String zza() {
            return this.zzd;
        }

        public final boolean zzb() {
            return this.zze;
        }

        public final boolean zzc() {
            return this.zzf;
        }

        public final boolean zzd() {
            return (this.zzc & 8) != 0;
        }

        public final int zze() {
            return this.zzg;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
    public static final class zzb extends zzfd<zzb, zza> implements zzgq {
        /* access modifiers changed from: private */
        public static final zzb zzl;
        private static volatile zzgx<zzb> zzm;
        private int zzc;
        private long zzd;
        private String zze = "";
        private int zzf;
        private zzfl<zzc> zzg = zzbq();
        private zzfl<zza> zzh = zzbq();
        private zzfl<zzbj.zza> zzi = zzbq();
        private String zzj = "";
        private boolean zzk;

        /* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
        public static final class zza extends zzfd.zzb<zzb, zza> implements zzgq {
            private zza() {
                super(zzb.zzl);
            }

            /* synthetic */ zza(zzbq zzbq) {
                this();
            }

            public final int zza() {
                return ((zzb) this.zza).zzf();
            }

            public final zza zza(int i) {
                return ((zzb) this.zza).zza(i);
            }

            public final zza zza(int i, zza.C0023zza zza) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzb) this.zza).zza(i, (zza) ((zzfd) zza.zzu()));
                return this;
            }

            public final List<zzbj.zza> zzb() {
                return Collections.unmodifiableList(((zzb) this.zza).zzg());
            }

            public final zza zzc() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzb) this.zza).zzl();
                return this;
            }
        }

        static {
            zzb zzb = new zzb();
            zzl = zzb;
            zzfd.zza(zzb.class, zzb);
        }

        private zzb() {
        }

        /* access modifiers changed from: private */
        public final void zza(int i, zza zza2) {
            zza2.getClass();
            if (!this.zzh.zza()) {
                this.zzh = zzfd.zza(this.zzh);
            }
            this.zzh.set(i, zza2);
        }

        public static zza zzi() {
            return (zza) zzl.zzbk();
        }

        public static zzb zzj() {
            return zzl;
        }

        /* access modifiers changed from: private */
        public final void zzl() {
            this.zzi = zzbq();
        }

        public final zza zza(int i) {
            return (zza) this.zzh.get(i);
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbq.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza((zzbq) null);
                case 3:
                    return zza((zzgo) zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0003\u0000\u0001\u0002\u0000\u0002\b\u0001\u0003\u0004\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007\b\u0003\b\u0007\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", zzc.class, "zzh", zza.class, "zzi", zzbj.zza.class, "zzj", "zzk"});
                case 4:
                    return zzl;
                case 5:
                    zzgx<zzb> zzgx = zzm;
                    if (zzgx == null) {
                        synchronized (zzb.class) {
                            zzgx = zzm;
                            if (zzgx == null) {
                                zzgx = new zzfd.zza<>(zzl);
                                zzm = zzgx;
                            }
                        }
                    }
                    return zzgx;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final long zzb() {
            return this.zzd;
        }

        public final boolean zzc() {
            return (this.zzc & 2) != 0;
        }

        public final String zzd() {
            return this.zze;
        }

        public final List<zzc> zze() {
            return this.zzg;
        }

        public final int zzf() {
            return this.zzh.size();
        }

        public final List<zzbj.zza> zzg() {
            return this.zzi;
        }

        public final boolean zzh() {
            return this.zzk;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
    public static final class zzc extends zzfd<zzc, zza> implements zzgq {
        /* access modifiers changed from: private */
        public static final zzc zzf;
        private static volatile zzgx<zzc> zzg;
        private int zzc;
        private String zzd = "";
        private String zze = "";

        /* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
        public static final class zza extends zzfd.zzb<zzc, zza> implements zzgq {
            private zza() {
                super(zzc.zzf);
            }

            /* synthetic */ zza(zzbq zzbq) {
                this();
            }
        }

        static {
            zzc zzc2 = new zzc();
            zzf = zzc2;
            zzfd.zza(zzc.class, zzc2);
        }

        private zzc() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbq.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza((zzbq) null);
                case 3:
                    return zza((zzgo) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzgx<zzc> zzgx = zzg;
                    if (zzgx == null) {
                        synchronized (zzc.class) {
                            zzgx = zzg;
                            if (zzgx == null) {
                                zzgx = new zzfd.zza<>(zzf);
                                zzg = zzgx;
                            }
                        }
                    }
                    return zzgx;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public final String zza() {
            return this.zzd;
        }

        public final String zzb() {
            return this.zze;
        }
    }
}
