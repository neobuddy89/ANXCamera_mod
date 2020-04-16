package com.google.android.gms.internal.measurement;

import com.adobe.xmp.options.PropertyOptions;
import com.arcsoft.camera.wideselfie.WideSelfieEngine;
import com.google.android.gms.internal.measurement.zzfd;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
public final class zzbr {

    /* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
    public static final class zza extends zzfd<zza, C0024zza> implements zzgq {
        /* access modifiers changed from: private */
        public static final zza zzh;
        private static volatile zzgx<zza> zzi;
        private int zzc;
        private int zzd;
        private zzi zze;
        private zzi zzf;
        private boolean zzg;

        /* renamed from: com.google.android.gms.internal.measurement.zzbr$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
        public static final class C0024zza extends zzfd.zzb<zza, C0024zza> implements zzgq {
            private C0024zza() {
                super(zza.zzh);
            }

            /* synthetic */ C0024zza(zzbs zzbs) {
                this();
            }

            public final C0024zza zza(int i) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zza) this.zza).zza(i);
                return this;
            }

            public final C0024zza zza(zzi.zza zza) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zza) this.zza).zza((zzi) ((zzfd) zza.zzu()));
                return this;
            }

            public final C0024zza zza(zzi zzi) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zza) this.zza).zzb(zzi);
                return this;
            }

            public final C0024zza zza(boolean z) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zza) this.zza).zza(z);
                return this;
            }

            public final boolean zza() {
                return ((zza) this.zza).zzd();
            }

            public final zzi zzb() {
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
        public final void zza(int i) {
            this.zzc |= 1;
            this.zzd = i;
        }

        /* access modifiers changed from: private */
        public final void zza(zzi zzi2) {
            zzi2.getClass();
            this.zze = zzi2;
            this.zzc |= 2;
        }

        /* access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zzc |= 8;
            this.zzg = z;
        }

        /* access modifiers changed from: private */
        public final void zzb(zzi zzi2) {
            zzi2.getClass();
            this.zzf = zzi2;
            this.zzc |= 4;
        }

        public static C0024zza zzh() {
            return (C0024zza) zzh.zzbk();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbs.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0024zza((zzbs) null);
                case 3:
                    return zza((zzgo) zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0004\u0000\u0002\t\u0001\u0003\t\u0002\u0004\u0007\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
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

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final int zzb() {
            return this.zzd;
        }

        public final zzi zzc() {
            zzi zzi2 = this.zze;
            return zzi2 == null ? zzi.zzj() : zzi2;
        }

        public final boolean zzd() {
            return (this.zzc & 4) != 0;
        }

        public final zzi zze() {
            zzi zzi2 = this.zzf;
            return zzi2 == null ? zzi.zzj() : zzi2;
        }

        public final boolean zzf() {
            return (this.zzc & 8) != 0;
        }

        public final boolean zzg() {
            return this.zzg;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
    public static final class zzb extends zzfd<zzb, zza> implements zzgq {
        /* access modifiers changed from: private */
        public static final zzb zzf;
        private static volatile zzgx<zzb> zzg;
        private int zzc;
        private int zzd;
        private long zze;

        /* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
        public static final class zza extends zzfd.zzb<zzb, zza> implements zzgq {
            private zza() {
                super(zzb.zzf);
            }

            /* synthetic */ zza(zzbs zzbs) {
                this();
            }

            public final zza zza(int i) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzb) this.zza).zza(i);
                return this;
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzb) this.zza).zza(j);
                return this;
            }
        }

        static {
            zzb zzb = new zzb();
            zzf = zzb;
            zzfd.zza(zzb.class, zzb);
        }

        private zzb() {
        }

        /* access modifiers changed from: private */
        public final void zza(int i) {
            this.zzc |= 1;
            this.zzd = i;
        }

        /* access modifiers changed from: private */
        public final void zza(long j) {
            this.zzc |= 2;
            this.zze = j;
        }

        public static zza zze() {
            return (zza) zzf.zzbk();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbs.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza((zzbs) null);
                case 3:
                    return zza((zzgo) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0002\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzgx<zzb> zzgx = zzg;
                    if (zzgx == null) {
                        synchronized (zzb.class) {
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

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final int zzb() {
            return this.zzd;
        }

        public final boolean zzc() {
            return (this.zzc & 2) != 0;
        }

        public final long zzd() {
            return this.zze;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
    public static final class zzc extends zzfd<zzc, zza> implements zzgq {
        /* access modifiers changed from: private */
        public static final zzc zzi;
        private static volatile zzgx<zzc> zzj;
        private int zzc;
        private zzfl<zze> zzd = zzbq();
        private String zze = "";
        private long zzf;
        private long zzg;
        private int zzh;

        /* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
        public static final class zza extends zzfd.zzb<zzc, zza> implements zzgq {
            private zza() {
                super(zzc.zzi);
            }

            /* synthetic */ zza(zzbs zzbs) {
                this();
            }

            public final zza zza(int i, zze.zza zza) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzc) this.zza).zza(i, (zze) ((zzfd) zza.zzu()));
                return this;
            }

            public final zza zza(int i, zze zze) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzc) this.zza).zza(i, zze);
                return this;
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzc) this.zza).zza(j);
                return this;
            }

            public final zza zza(zze.zza zza) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzc) this.zza).zza((zze) ((zzfd) zza.zzu()));
                return this;
            }

            public final zza zza(zze zze) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzc) this.zza).zza(zze);
                return this;
            }

            public final zza zza(Iterable<? extends zze> iterable) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzc) this.zza).zza(iterable);
                return this;
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzc) this.zza).zza(str);
                return this;
            }

            public final zze zza(int i) {
                return ((zzc) this.zza).zza(i);
            }

            public final List<zze> zza() {
                return Collections.unmodifiableList(((zzc) this.zza).zza());
            }

            public final int zzb() {
                return ((zzc) this.zza).zzb();
            }

            public final zza zzb(int i) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzc) this.zza).zzb(i);
                return this;
            }

            public final zza zzb(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzc) this.zza).zzb(j);
                return this;
            }

            public final zza zzc() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzc) this.zza).zzm();
                return this;
            }

            public final String zzd() {
                return ((zzc) this.zza).zzc();
            }

            public final boolean zze() {
                return ((zzc) this.zza).zzd();
            }

            public final long zzf() {
                return ((zzc) this.zza).zze();
            }

            public final long zzg() {
                return ((zzc) this.zza).zzg();
            }
        }

        static {
            zzc zzc2 = new zzc();
            zzi = zzc2;
            zzfd.zza(zzc.class, zzc2);
        }

        private zzc() {
        }

        /* access modifiers changed from: private */
        public final void zza(int i, zze zze2) {
            zze2.getClass();
            zzl();
            this.zzd.set(i, zze2);
        }

        /* access modifiers changed from: private */
        public final void zza(long j) {
            this.zzc |= 2;
            this.zzf = j;
        }

        /* access modifiers changed from: private */
        public final void zza(zze zze2) {
            zze2.getClass();
            zzl();
            this.zzd.add(zze2);
        }

        /* access modifiers changed from: private */
        public final void zza(Iterable<? extends zze> iterable) {
            zzl();
            zzdl.zza(iterable, this.zzd);
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zze = str;
        }

        /* access modifiers changed from: private */
        public final void zzb(int i) {
            zzl();
            this.zzd.remove(i);
        }

        /* access modifiers changed from: private */
        public final void zzb(long j) {
            this.zzc |= 4;
            this.zzg = j;
        }

        public static zza zzj() {
            return (zza) zzi.zzbk();
        }

        private final void zzl() {
            if (!this.zzd.zza()) {
                this.zzd = zzfd.zza(this.zzd);
            }
        }

        /* access modifiers changed from: private */
        public final void zzm() {
            this.zzd = zzbq();
        }

        public final zze zza(int i) {
            return (zze) this.zzd.get(i);
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbs.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza((zzbs) null);
                case 3:
                    return zza((zzgo) zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002\b\u0000\u0003\u0002\u0001\u0004\u0002\u0002\u0005\u0004\u0003", new Object[]{"zzc", "zzd", zze.class, "zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzgx<zzc> zzgx = zzj;
                    if (zzgx == null) {
                        synchronized (zzc.class) {
                            zzgx = zzj;
                            if (zzgx == null) {
                                zzgx = new zzfd.zza<>(zzi);
                                zzj = zzgx;
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

        public final List<zze> zza() {
            return this.zzd;
        }

        public final int zzb() {
            return this.zzd.size();
        }

        public final String zzc() {
            return this.zze;
        }

        public final boolean zzd() {
            return (this.zzc & 2) != 0;
        }

        public final long zze() {
            return this.zzf;
        }

        public final boolean zzf() {
            return (this.zzc & 4) != 0;
        }

        public final long zzg() {
            return this.zzg;
        }

        public final boolean zzh() {
            return (this.zzc & 8) != 0;
        }

        public final int zzi() {
            return this.zzh;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
    public static final class zzd extends zzfd<zzd, zza> implements zzgq {
        /* access modifiers changed from: private */
        public static final zzd zzf;
        private static volatile zzgx<zzd> zzg;
        private int zzc;
        private String zzd = "";
        private long zze;

        /* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
        public static final class zza extends zzfd.zzb<zzd, zza> implements zzgq {
            private zza() {
                super(zzd.zzf);
            }

            /* synthetic */ zza(zzbs zzbs) {
                this();
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzd) this.zza).zza(j);
                return this;
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzd) this.zza).zza(str);
                return this;
            }
        }

        static {
            zzd zzd2 = new zzd();
            zzf = zzd2;
            zzfd.zza(zzd.class, zzd2);
        }

        private zzd() {
        }

        public static zza zza() {
            return (zza) zzf.zzbk();
        }

        /* access modifiers changed from: private */
        public final void zza(long j) {
            this.zzc |= 2;
            this.zze = j;
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbs.zza[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza((zzbs) null);
                case 3:
                    return zza((zzgo) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\u0002\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzgx<zzd> zzgx = zzg;
                    if (zzgx == null) {
                        synchronized (zzd.class) {
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
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
    public static final class zze extends zzfd<zze, zza> implements zzgq {
        /* access modifiers changed from: private */
        public static final zze zzj;
        private static volatile zzgx<zze> zzk;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private long zzf;
        private float zzg;
        private double zzh;
        private zzfl<zze> zzi = zzbq();

        /* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
        public static final class zza extends zzfd.zzb<zze, zza> implements zzgq {
            private zza() {
                super(zze.zzj);
            }

            /* synthetic */ zza(zzbs zzbs) {
                this();
            }

            public final zza zza() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zze) this.zza).zzm();
                return this;
            }

            public final zza zza(double d2) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zze) this.zza).zza(d2);
                return this;
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zze) this.zza).zza(j);
                return this;
            }

            public final zza zza(zza zza) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zze) this.zza).zze((zze) ((zzfd) zza.zzu()));
                return this;
            }

            public final zza zza(Iterable<? extends zze> iterable) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zze) this.zza).zza(iterable);
                return this;
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zze) this.zza).zza(str);
                return this;
            }

            public final zza zzb() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zze) this.zza).zzn();
                return this;
            }

            public final zza zzb(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zze) this.zza).zzb(str);
                return this;
            }

            public final zza zzc() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zze) this.zza).zzo();
                return this;
            }

            public final int zzd() {
                return ((zze) this.zza).zzj();
            }

            public final zza zze() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zze) this.zza).zzq();
                return this;
            }
        }

        static {
            zze zze2 = new zze();
            zzj = zze2;
            zzfd.zza(zze.class, zze2);
        }

        private zze() {
        }

        /* access modifiers changed from: private */
        public final void zza(double d2) {
            this.zzc |= 16;
            this.zzh = d2;
        }

        /* access modifiers changed from: private */
        public final void zza(long j) {
            this.zzc |= 4;
            this.zzf = j;
        }

        /* access modifiers changed from: private */
        public final void zza(Iterable<? extends zze> iterable) {
            zzp();
            zzdl.zza(iterable, this.zzi);
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        /* access modifiers changed from: private */
        public final void zzb(String str) {
            str.getClass();
            this.zzc |= 2;
            this.zze = str;
        }

        /* access modifiers changed from: private */
        public final void zze(zze zze2) {
            zze2.getClass();
            zzp();
            this.zzi.add(zze2);
        }

        public static zza zzk() {
            return (zza) zzj.zzbk();
        }

        /* access modifiers changed from: private */
        public final void zzm() {
            this.zzc &= -3;
            this.zze = zzj.zze;
        }

        /* access modifiers changed from: private */
        public final void zzn() {
            this.zzc &= -5;
            this.zzf = 0;
        }

        /* access modifiers changed from: private */
        public final void zzo() {
            this.zzc &= -17;
            this.zzh = 0.0d;
        }

        private final void zzp() {
            if (!this.zzi.zza()) {
                this.zzi = zzfd.zza(this.zzi);
            }
        }

        /* access modifiers changed from: private */
        public final void zzq() {
            this.zzi = zzbq();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            Class<zze> cls = zze.class;
            switch (zzbs.zza[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza((zzbs) null);
                case 3:
                    return zza((zzgo) zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001\b\u0000\u0002\b\u0001\u0003\u0002\u0002\u0004\u0001\u0003\u0005\u0000\u0004\u0006\u001b", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", cls});
                case 4:
                    return zzj;
                case 5:
                    zzgx<zze> zzgx = zzk;
                    if (zzgx == null) {
                        synchronized (cls) {
                            zzgx = zzk;
                            if (zzgx == null) {
                                zzgx = new zzfd.zza<>(zzj);
                                zzk = zzgx;
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

        public final String zzb() {
            return this.zzd;
        }

        public final boolean zzc() {
            return (this.zzc & 2) != 0;
        }

        public final String zzd() {
            return this.zze;
        }

        public final boolean zze() {
            return (this.zzc & 4) != 0;
        }

        public final long zzf() {
            return this.zzf;
        }

        public final boolean zzg() {
            return (this.zzc & 16) != 0;
        }

        public final double zzh() {
            return this.zzh;
        }

        public final List<zze> zzi() {
            return this.zzi;
        }

        public final int zzj() {
            return this.zzi.size();
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
    public static final class zzf extends zzfd<zzf, zza> implements zzgq {
        /* access modifiers changed from: private */
        public static final zzf zzd;
        private static volatile zzgx<zzf> zze;
        private zzfl<zzg> zzc = zzbq();

        /* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
        public static final class zza extends zzfd.zzb<zzf, zza> implements zzgq {
            private zza() {
                super(zzf.zzd);
            }

            /* synthetic */ zza(zzbs zzbs) {
                this();
            }

            public final zza zza(zzg.zza zza) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzf) this.zza).zza((zzg) ((zzfd) zza.zzu()));
                return this;
            }

            public final zzg zza(int i) {
                return ((zzf) this.zza).zza(0);
            }
        }

        static {
            zzf zzf = new zzf();
            zzd = zzf;
            zzfd.zza(zzf.class, zzf);
        }

        private zzf() {
        }

        /* access modifiers changed from: private */
        public final void zza(zzg zzg) {
            zzg.getClass();
            if (!this.zzc.zza()) {
                this.zzc = zzfd.zza(this.zzc);
            }
            this.zzc.add(zzg);
        }

        public static zza zzb() {
            return (zza) zzd.zzbk();
        }

        public final zzg zza(int i) {
            return (zzg) this.zzc.get(0);
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbs.zza[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza((zzbs) null);
                case 3:
                    return zza((zzgo) zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", zzg.class});
                case 4:
                    return zzd;
                case 5:
                    zzgx<zzf> zzgx = zze;
                    if (zzgx == null) {
                        synchronized (zzf.class) {
                            zzgx = zze;
                            if (zzgx == null) {
                                zzgx = new zzfd.zza<>(zzd);
                                zze = zzgx;
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

        public final List<zzg> zza() {
            return this.zzc;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
    public static final class zzg extends zzfd<zzg, zza> implements zzgq {
        /* access modifiers changed from: private */
        public static final zzg zzav;
        private static volatile zzgx<zzg> zzaw;
        private int zzaa;
        private String zzab = "";
        private String zzac = "";
        private boolean zzad;
        private zzfl<zza> zzae = zzbq();
        private String zzaf = "";
        private int zzag;
        private int zzah;
        private int zzai;
        private String zzaj = "";
        private long zzak;
        private long zzal;
        private String zzam = "";
        private String zzan = "";
        private int zzao;
        private String zzap = "";
        private zzh zzaq;
        private zzfj zzar = zzbo();
        private long zzas;
        private long zzat;
        private String zzau = "";
        private int zzc;
        private int zzd;
        private int zze;
        private zzfl<zzc> zzf = zzbq();
        private zzfl<zzk> zzg = zzbq();
        private long zzh;
        private long zzi;
        private long zzj;
        private long zzk;
        private long zzl;
        private String zzm = "";
        private String zzn = "";
        private String zzo = "";
        private String zzp = "";
        private int zzq;
        private String zzr = "";
        private String zzs = "";
        private String zzt = "";
        private long zzu;
        private long zzv;
        private String zzw = "";
        private boolean zzx;
        private String zzy = "";
        private long zzz;

        /* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
        public static final class zza extends zzfd.zzb<zzg, zza> implements zzgq {
            private zza() {
                super(zzg.zzav);
            }

            /* synthetic */ zza(zzbs zzbs) {
                this();
            }

            public final zza zza(int i) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzd(1);
                return this;
            }

            public final zza zza(int i, zzc.zza zza) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza(i, (zzc) ((zzfd) zza.zzu()));
                return this;
            }

            public final zza zza(int i, zzk zzk) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza(i, zzk);
                return this;
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza(j);
                return this;
            }

            public final zza zza(zzc.zza zza) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza((zzc) ((zzfd) zza.zzu()));
                return this;
            }

            public final zza zza(zzh.zzb zzb) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza((zzh) ((zzfd) zzb.zzu()));
                return this;
            }

            public final zza zza(zzk.zza zza) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza((zzk) ((zzfd) zza.zzu()));
                return this;
            }

            public final zza zza(zzk zzk) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza(zzk);
                return this;
            }

            public final zza zza(Iterable<? extends zzc> iterable) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza(iterable);
                return this;
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza(str);
                return this;
            }

            public final zza zza(boolean z) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza(z);
                return this;
            }

            public final List<zzc> zza() {
                return Collections.unmodifiableList(((zzg) this.zza).zzc());
            }

            public final int zzb() {
                return ((zzg) this.zza).zzd();
            }

            public final zzc zzb(int i) {
                return ((zzg) this.zza).zza(i);
            }

            public final zza zzb(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzb(j);
                return this;
            }

            public final zza zzb(Iterable<? extends zzk> iterable) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzb(iterable);
                return this;
            }

            public final zza zzb(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzb(str);
                return this;
            }

            public final zza zzb(boolean z) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzb(z);
                return this;
            }

            public final zza zzc() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzbv();
                return this;
            }

            public final zza zzc(int i) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zze(i);
                return this;
            }

            public final zza zzc(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzc(j);
                return this;
            }

            public final zza zzc(Iterable<? extends zza> iterable) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzc(iterable);
                return this;
            }

            public final zza zzc(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzc(str);
                return this;
            }

            public final zza zzd(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzd(j);
                return this;
            }

            public final zza zzd(Iterable<? extends Integer> iterable) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzd(iterable);
                return this;
            }

            public final zza zzd(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzd(str);
                return this;
            }

            public final zzk zzd(int i) {
                return ((zzg) this.zza).zzb(i);
            }

            public final List<zzk> zzd() {
                return Collections.unmodifiableList(((zzg) this.zza).zze());
            }

            public final int zze() {
                return ((zzg) this.zza).zzf();
            }

            public final zza zze(int i) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzf(i);
                return this;
            }

            public final zza zze(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zze(j);
                return this;
            }

            public final zza zze(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zze(str);
                return this;
            }

            public final long zzf() {
                return ((zzg) this.zza).zzj();
            }

            public final zza zzf(int i) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzg(i);
                return this;
            }

            public final zza zzf(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzf(j);
                return this;
            }

            public final zza zzf(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzf(str);
                return this;
            }

            public final long zzg() {
                return ((zzg) this.zza).zzl();
            }

            public final zza zzg(int i) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzh(i);
                return this;
            }

            public final zza zzg(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzg(j);
                return this;
            }

            public final zza zzg(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzg(str);
                return this;
            }

            public final zza zzh() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzbx();
                return this;
            }

            public final zza zzh(int i) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzi(i);
                return this;
            }

            public final zza zzh(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzh(j);
                return this;
            }

            public final zza zzh(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzh(str);
                return this;
            }

            public final zza zzi() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzby();
                return this;
            }

            public final zza zzi(int i) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzj(i);
                return this;
            }

            public final zza zzi(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzi(j);
                return this;
            }

            public final zza zzi(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzi(str);
                return this;
            }

            public final zza zzj(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzj(j);
                return this;
            }

            public final zza zzj(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzj(str);
                return this;
            }

            public final String zzj() {
                return ((zzg) this.zza).zzx();
            }

            public final zza zzk() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzbz();
                return this;
            }

            public final zza zzk(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzk(j);
                return this;
            }

            public final zza zzk(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzk(str);
                return this;
            }

            public final zza zzl(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzl(j);
                return this;
            }

            public final zza zzl(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzl(str);
                return this;
            }

            public final String zzl() {
                return ((zzg) this.zza).zzam();
            }

            public final zza zzm() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzca();
                return this;
            }

            public final zza zzm(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzm(str);
                return this;
            }

            public final zza zzn() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzcb();
                return this;
            }

            public final zza zzn(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzn((String) null);
                return this;
            }

            public final zza zzo(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzo(str);
                return this;
            }

            public final String zzo() {
                return ((zzg) this.zza).zzbe();
            }

            public final zza zzp(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzp(str);
                return this;
            }
        }

        static {
            zzg zzg2 = new zzg();
            zzav = zzg2;
            zzfd.zza(zzg.class, zzg2);
        }

        private zzg() {
        }

        /* access modifiers changed from: private */
        public final void zza(int i, zzc zzc2) {
            zzc2.getClass();
            zzbu();
            this.zzf.set(i, zzc2);
        }

        /* access modifiers changed from: private */
        public final void zza(int i, zzk zzk2) {
            zzk2.getClass();
            zzbw();
            this.zzg.set(i, zzk2);
        }

        /* access modifiers changed from: private */
        public final void zza(long j) {
            this.zzc |= 2;
            this.zzh = j;
        }

        /* access modifiers changed from: private */
        public final void zza(zzc zzc2) {
            zzc2.getClass();
            zzbu();
            this.zzf.add(zzc2);
        }

        /* access modifiers changed from: private */
        public final void zza(zzh zzh2) {
            zzh2.getClass();
            this.zzaq = zzh2;
            this.zzd |= 8;
        }

        /* access modifiers changed from: private */
        public final void zza(zzk zzk2) {
            zzk2.getClass();
            zzbw();
            this.zzg.add(zzk2);
        }

        /* access modifiers changed from: private */
        public final void zza(Iterable<? extends zzc> iterable) {
            zzbu();
            zzdl.zza(iterable, this.zzf);
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 64;
            this.zzm = str;
        }

        /* access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zzc |= 131072;
            this.zzx = z;
        }

        /* access modifiers changed from: private */
        public final void zzb(long j) {
            this.zzc |= 4;
            this.zzi = j;
        }

        /* access modifiers changed from: private */
        public final void zzb(Iterable<? extends zzk> iterable) {
            zzbw();
            zzdl.zza(iterable, this.zzg);
        }

        /* access modifiers changed from: private */
        public final void zzb(String str) {
            str.getClass();
            this.zzc |= 128;
            this.zzn = str;
        }

        /* access modifiers changed from: private */
        public final void zzb(boolean z) {
            this.zzc |= 8388608;
            this.zzad = z;
        }

        public static zza zzbf() {
            return (zza) zzav.zzbk();
        }

        private final void zzbu() {
            if (!this.zzf.zza()) {
                this.zzf = zzfd.zza(this.zzf);
            }
        }

        /* access modifiers changed from: private */
        public final void zzbv() {
            this.zzf = zzbq();
        }

        private final void zzbw() {
            if (!this.zzg.zza()) {
                this.zzg = zzfd.zza(this.zzg);
            }
        }

        /* access modifiers changed from: private */
        public final void zzbx() {
            this.zzc &= -17;
            this.zzk = 0;
        }

        /* access modifiers changed from: private */
        public final void zzby() {
            this.zzc &= -33;
            this.zzl = 0;
        }

        /* access modifiers changed from: private */
        public final void zzbz() {
            this.zzc &= -2097153;
            this.zzab = zzav.zzab;
        }

        /* access modifiers changed from: private */
        public final void zzc(long j) {
            this.zzc |= 8;
            this.zzj = j;
        }

        /* access modifiers changed from: private */
        public final void zzc(Iterable<? extends zza> iterable) {
            if (!this.zzae.zza()) {
                this.zzae = zzfd.zza(this.zzae);
            }
            zzdl.zza(iterable, this.zzae);
        }

        /* access modifiers changed from: private */
        public final void zzc(String str) {
            str.getClass();
            this.zzc |= 256;
            this.zzo = str;
        }

        /* access modifiers changed from: private */
        public final void zzca() {
            this.zzae = zzbq();
        }

        /* access modifiers changed from: private */
        public final void zzcb() {
            this.zzc &= Integer.MAX_VALUE;
            this.zzam = zzav.zzam;
        }

        /* access modifiers changed from: private */
        public final void zzd(int i) {
            this.zzc |= 1;
            this.zze = i;
        }

        /* access modifiers changed from: private */
        public final void zzd(long j) {
            this.zzc |= 16;
            this.zzk = j;
        }

        /* access modifiers changed from: private */
        public final void zzd(Iterable<? extends Integer> iterable) {
            if (!this.zzar.zza()) {
                zzfj zzfj = this.zzar;
                int size = zzfj.size();
                this.zzar = zzfj.zzb(size == 0 ? 10 : size << 1);
            }
            zzdl.zza(iterable, this.zzar);
        }

        /* access modifiers changed from: private */
        public final void zzd(String str) {
            str.getClass();
            this.zzc |= 512;
            this.zzp = str;
        }

        /* access modifiers changed from: private */
        public final void zze(int i) {
            zzbu();
            this.zzf.remove(i);
        }

        /* access modifiers changed from: private */
        public final void zze(long j) {
            this.zzc |= 32;
            this.zzl = j;
        }

        /* access modifiers changed from: private */
        public final void zze(String str) {
            str.getClass();
            this.zzc |= 2048;
            this.zzr = str;
        }

        /* access modifiers changed from: private */
        public final void zzf(int i) {
            zzbw();
            this.zzg.remove(i);
        }

        /* access modifiers changed from: private */
        public final void zzf(long j) {
            this.zzc |= 16384;
            this.zzu = j;
        }

        /* access modifiers changed from: private */
        public final void zzf(String str) {
            str.getClass();
            this.zzc |= 4096;
            this.zzs = str;
        }

        /* access modifiers changed from: private */
        public final void zzg(int i) {
            this.zzc |= 1024;
            this.zzq = i;
        }

        /* access modifiers changed from: private */
        public final void zzg(long j) {
            this.zzc |= 32768;
            this.zzv = j;
        }

        /* access modifiers changed from: private */
        public final void zzg(String str) {
            str.getClass();
            this.zzc |= 8192;
            this.zzt = str;
        }

        /* access modifiers changed from: private */
        public final void zzh(int i) {
            this.zzc |= 1048576;
            this.zzaa = i;
        }

        /* access modifiers changed from: private */
        public final void zzh(long j) {
            this.zzc |= 524288;
            this.zzz = j;
        }

        /* access modifiers changed from: private */
        public final void zzh(String str) {
            str.getClass();
            this.zzc |= 65536;
            this.zzw = str;
        }

        /* access modifiers changed from: private */
        public final void zzi(int i) {
            this.zzc |= 33554432;
            this.zzag = i;
        }

        /* access modifiers changed from: private */
        public final void zzi(long j) {
            this.zzc |= PropertyOptions.DELETE_EXISTING;
            this.zzak = j;
        }

        /* access modifiers changed from: private */
        public final void zzi(String str) {
            str.getClass();
            this.zzc |= 262144;
            this.zzy = str;
        }

        /* access modifiers changed from: private */
        public final void zzj(int i) {
            this.zzd |= 2;
            this.zzao = i;
        }

        /* access modifiers changed from: private */
        public final void zzj(long j) {
            this.zzc |= 1073741824;
            this.zzal = j;
        }

        /* access modifiers changed from: private */
        public final void zzj(String str) {
            str.getClass();
            this.zzc |= 2097152;
            this.zzab = str;
        }

        /* access modifiers changed from: private */
        public final void zzk(long j) {
            this.zzd |= 16;
            this.zzas = j;
        }

        /* access modifiers changed from: private */
        public final void zzk(String str) {
            str.getClass();
            this.zzc |= 4194304;
            this.zzac = str;
        }

        /* access modifiers changed from: private */
        public final void zzl(long j) {
            this.zzd |= 32;
            this.zzat = j;
        }

        /* access modifiers changed from: private */
        public final void zzl(String str) {
            str.getClass();
            this.zzc |= 16777216;
            this.zzaf = str;
        }

        /* access modifiers changed from: private */
        public final void zzm(String str) {
            str.getClass();
            this.zzc |= WideSelfieEngine.MPAF_RGB_BASE;
            this.zzaj = str;
        }

        /* access modifiers changed from: private */
        public final void zzn(String str) {
            str.getClass();
            this.zzc |= Integer.MIN_VALUE;
            this.zzam = str;
        }

        /* access modifiers changed from: private */
        public final void zzo(String str) {
            str.getClass();
            this.zzd |= 4;
            this.zzap = str;
        }

        /* access modifiers changed from: private */
        public final void zzp(String str) {
            str.getClass();
            this.zzd |= 64;
            this.zzau = str;
        }

        public final zzc zza(int i) {
            return (zzc) this.zzf.get(i);
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbs.zza[i - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zza((zzbs) null);
                case 3:
                    return zza((zzgo) zzav, "\u0001+\u0000\u0002\u00012+\u0000\u0004\u0000\u0001\u0004\u0000\u0002\u001b\u0003\u001b\u0004\u0002\u0001\u0005\u0002\u0002\u0006\u0002\u0003\u0007\u0002\u0005\b\b\u0006\t\b\u0007\n\b\b\u000b\b\t\f\u0004\n\r\b\u000b\u000e\b\f\u0010\b\r\u0011\u0002\u000e\u0012\u0002\u000f\u0013\b\u0010\u0014\u0007\u0011\u0015\b\u0012\u0016\u0002\u0013\u0017\u0004\u0014\u0018\b\u0015\u0019\b\u0016\u001a\u0002\u0004\u001c\u0007\u0017\u001d\u001b\u001e\b\u0018\u001f\u0004\u0019 \u0004\u001a!\u0004\u001b\"\b\u001c#\u0002\u001d$\u0002\u001e%\b\u001f&\b '\u0004!)\b\",\t#-\u001d.\u0002$/\u0002%2\b&", new Object[]{"zzc", "zzd", "zze", "zzf", zzc.class, "zzg", zzk.class, "zzh", "zzi", "zzj", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzaa", "zzab", "zzac", "zzk", "zzad", "zzae", zza.class, "zzaf", "zzag", "zzah", "zzai", "zzaj", "zzak", "zzal", "zzam", "zzan", "zzao", "zzap", "zzaq", "zzar", "zzas", "zzat", "zzau"});
                case 4:
                    return zzav;
                case 5:
                    zzgx<zzg> zzgx = zzaw;
                    if (zzgx == null) {
                        synchronized (zzg.class) {
                            zzgx = zzaw;
                            if (zzgx == null) {
                                zzgx = new zzfd.zza<>(zzav);
                                zzaw = zzgx;
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

        public final long zzaa() {
            return this.zzu;
        }

        public final boolean zzab() {
            return (this.zzc & 32768) != 0;
        }

        public final long zzac() {
            return this.zzv;
        }

        public final String zzad() {
            return this.zzw;
        }

        public final boolean zzae() {
            return (this.zzc & 131072) != 0;
        }

        public final boolean zzaf() {
            return this.zzx;
        }

        public final String zzag() {
            return this.zzy;
        }

        public final boolean zzah() {
            return (this.zzc & 524288) != 0;
        }

        public final long zzai() {
            return this.zzz;
        }

        public final boolean zzaj() {
            return (this.zzc & 1048576) != 0;
        }

        public final int zzak() {
            return this.zzaa;
        }

        public final String zzal() {
            return this.zzab;
        }

        public final String zzam() {
            return this.zzac;
        }

        public final boolean zzan() {
            return (this.zzc & 8388608) != 0;
        }

        public final boolean zzao() {
            return this.zzad;
        }

        public final List<zza> zzap() {
            return this.zzae;
        }

        public final String zzaq() {
            return this.zzaf;
        }

        public final boolean zzar() {
            return (this.zzc & 33554432) != 0;
        }

        public final int zzas() {
            return this.zzag;
        }

        public final String zzat() {
            return this.zzaj;
        }

        public final boolean zzau() {
            return (this.zzc & PropertyOptions.DELETE_EXISTING) != 0;
        }

        public final long zzav() {
            return this.zzak;
        }

        public final boolean zzaw() {
            return (this.zzc & 1073741824) != 0;
        }

        public final long zzax() {
            return this.zzal;
        }

        public final String zzay() {
            return this.zzam;
        }

        public final boolean zzaz() {
            return (this.zzd & 2) != 0;
        }

        public final int zzb() {
            return this.zze;
        }

        public final zzk zzb(int i) {
            return (zzk) this.zzg.get(i);
        }

        public final int zzba() {
            return this.zzao;
        }

        public final String zzbb() {
            return this.zzap;
        }

        public final boolean zzbc() {
            return (this.zzd & 16) != 0;
        }

        public final long zzbd() {
            return this.zzas;
        }

        public final String zzbe() {
            return this.zzau;
        }

        public final List<zzc> zzc() {
            return this.zzf;
        }

        public final int zzd() {
            return this.zzf.size();
        }

        public final List<zzk> zze() {
            return this.zzg;
        }

        public final int zzf() {
            return this.zzg.size();
        }

        public final boolean zzg() {
            return (this.zzc & 2) != 0;
        }

        public final long zzh() {
            return this.zzh;
        }

        public final boolean zzi() {
            return (this.zzc & 4) != 0;
        }

        public final long zzj() {
            return this.zzi;
        }

        public final boolean zzk() {
            return (this.zzc & 8) != 0;
        }

        public final long zzl() {
            return this.zzj;
        }

        public final boolean zzm() {
            return (this.zzc & 16) != 0;
        }

        public final long zzn() {
            return this.zzk;
        }

        public final boolean zzo() {
            return (this.zzc & 32) != 0;
        }

        public final long zzp() {
            return this.zzl;
        }

        public final String zzq() {
            return this.zzm;
        }

        public final String zzr() {
            return this.zzn;
        }

        public final String zzs() {
            return this.zzo;
        }

        public final String zzt() {
            return this.zzp;
        }

        public final boolean zzu() {
            return (this.zzc & 1024) != 0;
        }

        public final int zzv() {
            return this.zzq;
        }

        public final String zzw() {
            return this.zzr;
        }

        public final String zzx() {
            return this.zzs;
        }

        public final String zzy() {
            return this.zzt;
        }

        public final boolean zzz() {
            return (this.zzc & 16384) != 0;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
    public static final class zzh extends zzfd<zzh, zzb> implements zzgq {
        /* access modifiers changed from: private */
        public static final zzh zzf;
        private static volatile zzgx<zzh> zzg;
        private int zzc;
        private int zzd = 1;
        private zzfl<zzd> zze = zzbq();

        /* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
        public enum zza implements zzfi {
            RADS(1),
            PROVISIONING(2);
            
            private static final zzfh<zza> zzc = null;
            private final int zzd;

            static {
                zzc = new zzbu();
            }

            private zza(int i) {
                this.zzd = i;
            }

            public static zza zza(int i) {
                if (i == 1) {
                    return RADS;
                }
                if (i != 2) {
                    return null;
                }
                return PROVISIONING;
            }

            public static zzfk zzb() {
                return zzbt.zza;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzd + " name=" + name() + '>';
            }

            public final int zza() {
                return this.zzd;
            }
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
        public static final class zzb extends zzfd.zzb<zzh, zzb> implements zzgq {
            private zzb() {
                super(zzh.zzf);
            }

            /* synthetic */ zzb(zzbs zzbs) {
                this();
            }

            public final zzb zza(zzd.zza zza) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzh) this.zza).zza((zzd) ((zzfd) zza.zzu()));
                return this;
            }
        }

        static {
            zzh zzh = new zzh();
            zzf = zzh;
            zzfd.zza(zzh.class, zzh);
        }

        private zzh() {
        }

        public static zzb zza() {
            return (zzb) zzf.zzbk();
        }

        /* access modifiers changed from: private */
        public final void zza(zzd zzd2) {
            zzd2.getClass();
            if (!this.zze.zza()) {
                this.zze = zzfd.zza(this.zze);
            }
            this.zze.add(zzd2);
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbs.zza[i - 1]) {
                case 1:
                    return new zzh();
                case 2:
                    return new zzb((zzbs) null);
                case 3:
                    return zza((zzgo) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\f\u0000\u0002\u001b", new Object[]{"zzc", "zzd", zza.zzb(), "zze", zzd.class});
                case 4:
                    return zzf;
                case 5:
                    zzgx<zzh> zzgx = zzg;
                    if (zzgx == null) {
                        synchronized (zzh.class) {
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
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
    public static final class zzi extends zzfd<zzi, zza> implements zzgq {
        /* access modifiers changed from: private */
        public static final zzi zzg;
        private static volatile zzgx<zzi> zzh;
        private zzfm zzc = zzbp();
        private zzfm zzd = zzbp();
        private zzfl<zzb> zze = zzbq();
        private zzfl<zzj> zzf = zzbq();

        /* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
        public static final class zza extends zzfd.zzb<zzi, zza> implements zzgq {
            private zza() {
                super(zzi.zzg);
            }

            /* synthetic */ zza(zzbs zzbs) {
                this();
            }

            public final zza zza() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzi) this.zza).zzl();
                return this;
            }

            public final zza zza(int i) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzi) this.zza).zzd(i);
                return this;
            }

            public final zza zza(Iterable<? extends Long> iterable) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzi) this.zza).zza(iterable);
                return this;
            }

            public final zza zzb() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzi) this.zza).zzm();
                return this;
            }

            public final zza zzb(int i) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzi) this.zza).zze(i);
                return this;
            }

            public final zza zzb(Iterable<? extends Long> iterable) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzi) this.zza).zzb(iterable);
                return this;
            }

            public final zza zzc(Iterable<? extends zzb> iterable) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzi) this.zza).zzc(iterable);
                return this;
            }

            public final zza zzd(Iterable<? extends zzj> iterable) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzi) this.zza).zzd(iterable);
                return this;
            }
        }

        static {
            zzi zzi = new zzi();
            zzg = zzi;
            zzfd.zza(zzi.class, zzi);
        }

        private zzi() {
        }

        /* access modifiers changed from: private */
        public final void zza(Iterable<? extends Long> iterable) {
            if (!this.zzc.zza()) {
                this.zzc = zzfd.zza(this.zzc);
            }
            zzdl.zza(iterable, this.zzc);
        }

        /* access modifiers changed from: private */
        public final void zzb(Iterable<? extends Long> iterable) {
            if (!this.zzd.zza()) {
                this.zzd = zzfd.zza(this.zzd);
            }
            zzdl.zza(iterable, this.zzd);
        }

        /* access modifiers changed from: private */
        public final void zzc(Iterable<? extends zzb> iterable) {
            zzn();
            zzdl.zza(iterable, this.zze);
        }

        /* access modifiers changed from: private */
        public final void zzd(int i) {
            zzn();
            this.zze.remove(i);
        }

        /* access modifiers changed from: private */
        public final void zzd(Iterable<? extends zzj> iterable) {
            zzo();
            zzdl.zza(iterable, this.zzf);
        }

        /* access modifiers changed from: private */
        public final void zze(int i) {
            zzo();
            this.zzf.remove(i);
        }

        public static zza zzi() {
            return (zza) zzg.zzbk();
        }

        public static zzi zzj() {
            return zzg;
        }

        /* access modifiers changed from: private */
        public final void zzl() {
            this.zzc = zzbp();
        }

        /* access modifiers changed from: private */
        public final void zzm() {
            this.zzd = zzbp();
        }

        private final void zzn() {
            if (!this.zze.zza()) {
                this.zze = zzfd.zza(this.zze);
            }
        }

        private final void zzo() {
            if (!this.zzf.zza()) {
                this.zzf = zzfd.zza(this.zzf);
            }
        }

        public final zzb zza(int i) {
            return (zzb) this.zze.get(i);
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbs.zza[i - 1]) {
                case 1:
                    return new zzi();
                case 2:
                    return new zza((zzbs) null);
                case 3:
                    return zza((zzgo) zzg, "\u0001\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zzc", "zzd", "zze", zzb.class, "zzf", zzj.class});
                case 4:
                    return zzg;
                case 5:
                    zzgx<zzi> zzgx = zzh;
                    if (zzgx == null) {
                        synchronized (zzi.class) {
                            zzgx = zzh;
                            if (zzgx == null) {
                                zzgx = new zzfd.zza<>(zzg);
                                zzh = zzgx;
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

        public final List<Long> zza() {
            return this.zzc;
        }

        public final int zzb() {
            return this.zzc.size();
        }

        public final zzj zzb(int i) {
            return (zzj) this.zzf.get(i);
        }

        public final List<Long> zzc() {
            return this.zzd;
        }

        public final int zzd() {
            return this.zzd.size();
        }

        public final List<zzb> zze() {
            return this.zze;
        }

        public final int zzf() {
            return this.zze.size();
        }

        public final List<zzj> zzg() {
            return this.zzf;
        }

        public final int zzh() {
            return this.zzf.size();
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
    public static final class zzj extends zzfd<zzj, zza> implements zzgq {
        /* access modifiers changed from: private */
        public static final zzj zzf;
        private static volatile zzgx<zzj> zzg;
        private int zzc;
        private int zzd;
        private zzfm zze = zzbp();

        /* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
        public static final class zza extends zzfd.zzb<zzj, zza> implements zzgq {
            private zza() {
                super(zzj.zzf);
            }

            /* synthetic */ zza(zzbs zzbs) {
                this();
            }

            public final zza zza() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzj) this.zza).zzh();
                return this;
            }

            public final zza zza(int i) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzj) this.zza).zzb(i);
                return this;
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzj) this.zza).zza(j);
                return this;
            }

            public final zza zza(Iterable<? extends Long> iterable) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzj) this.zza).zza(iterable);
                return this;
            }
        }

        static {
            zzj zzj = new zzj();
            zzf = zzj;
            zzfd.zza(zzj.class, zzj);
        }

        private zzj() {
        }

        /* access modifiers changed from: private */
        public final void zza(long j) {
            zzg();
            this.zze.zza(j);
        }

        /* access modifiers changed from: private */
        public final void zza(Iterable<? extends Long> iterable) {
            zzg();
            zzdl.zza(iterable, this.zze);
        }

        /* access modifiers changed from: private */
        public final void zzb(int i) {
            this.zzc |= 1;
            this.zzd = i;
        }

        public static zza zze() {
            return (zza) zzf.zzbk();
        }

        private final void zzg() {
            if (!this.zze.zza()) {
                this.zze = zzfd.zza(this.zze);
            }
        }

        /* access modifiers changed from: private */
        public final void zzh() {
            this.zze = zzbp();
        }

        public final long zza(int i) {
            return this.zze.zzb(i);
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbs.zza[i - 1]) {
                case 1:
                    return new zzj();
                case 2:
                    return new zza((zzbs) null);
                case 3:
                    return zza((zzgo) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u0004\u0000\u0002\u0014", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzgx<zzj> zzgx = zzg;
                    if (zzgx == null) {
                        synchronized (zzj.class) {
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

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final int zzb() {
            return this.zzd;
        }

        public final List<Long> zzc() {
            return this.zze;
        }

        public final int zzd() {
            return this.zze.size();
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
    public static final class zzk extends zzfd<zzk, zza> implements zzgq {
        /* access modifiers changed from: private */
        public static final zzk zzj;
        private static volatile zzgx<zzk> zzk;
        private int zzc;
        private long zzd;
        private String zze = "";
        private String zzf = "";
        private long zzg;
        private float zzh;
        private double zzi;

        /* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
        public static final class zza extends zzfd.zzb<zzk, zza> implements zzgq {
            private zza() {
                super(zzk.zzj);
            }

            /* synthetic */ zza(zzbs zzbs) {
                this();
            }

            public final zza zza() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzk) this.zza).zzl();
                return this;
            }

            public final zza zza(double d2) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzk) this.zza).zza(d2);
                return this;
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzk) this.zza).zza(j);
                return this;
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzk) this.zza).zza(str);
                return this;
            }

            public final zza zzb() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzk) this.zza).zzm();
                return this;
            }

            public final zza zzb(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzk) this.zza).zzb(j);
                return this;
            }

            public final zza zzb(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzk) this.zza).zzb(str);
                return this;
            }

            public final zza zzc() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzk) this.zza).zzn();
                return this;
            }
        }

        static {
            zzk zzk2 = new zzk();
            zzj = zzk2;
            zzfd.zza(zzk.class, zzk2);
        }

        private zzk() {
        }

        /* access modifiers changed from: private */
        public final void zza(double d2) {
            this.zzc |= 32;
            this.zzi = d2;
        }

        /* access modifiers changed from: private */
        public final void zza(long j) {
            this.zzc |= 1;
            this.zzd = j;
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 2;
            this.zze = str;
        }

        /* access modifiers changed from: private */
        public final void zzb(long j) {
            this.zzc |= 8;
            this.zzg = j;
        }

        /* access modifiers changed from: private */
        public final void zzb(String str) {
            str.getClass();
            this.zzc |= 4;
            this.zzf = str;
        }

        public static zza zzj() {
            return (zza) zzj.zzbk();
        }

        /* access modifiers changed from: private */
        public final void zzl() {
            this.zzc &= -5;
            this.zzf = zzj.zzf;
        }

        /* access modifiers changed from: private */
        public final void zzm() {
            this.zzc &= -9;
            this.zzg = 0;
        }

        /* access modifiers changed from: private */
        public final void zzn() {
            this.zzc &= -33;
            this.zzi = 0.0d;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbs.zza[i - 1]) {
                case 1:
                    return new zzk();
                case 2:
                    return new zza((zzbs) null);
                case 3:
                    return zza((zzgo) zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u0002\u0000\u0002\b\u0001\u0003\b\u0002\u0004\u0002\u0003\u0005\u0001\u0004\u0006\u0000\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzgx<zzk> zzgx = zzk;
                    if (zzgx == null) {
                        synchronized (zzk.class) {
                            zzgx = zzk;
                            if (zzgx == null) {
                                zzgx = new zzfd.zza<>(zzj);
                                zzk = zzgx;
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

        public final String zzc() {
            return this.zze;
        }

        public final boolean zzd() {
            return (this.zzc & 4) != 0;
        }

        public final String zze() {
            return this.zzf;
        }

        public final boolean zzf() {
            return (this.zzc & 8) != 0;
        }

        public final long zzg() {
            return this.zzg;
        }

        public final boolean zzh() {
            return (this.zzc & 32) != 0;
        }

        public final double zzi() {
            return this.zzi;
        }
    }
}
