package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.util.Log;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
public abstract class zzcl<T> {
    private static final Object zza = new Object();
    private static Context zzb = null;
    private static boolean zzc = false;
    private static zzcz<zzcy<zzch>> zzd;
    private static final AtomicInteger zzh = new AtomicInteger();
    private final zzcr zze;
    private final String zzf;
    private final T zzg;
    private volatile int zzi;
    private volatile T zzj;

    private zzcl(zzcr zzcr, String str, T t) {
        this.zzi = -1;
        if (zzcr.zzb != null) {
            this.zze = zzcr;
            this.zzf = str;
            this.zzg = t;
            return;
        }
        throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
    }

    /* synthetic */ zzcl(zzcr zzcr, String str, Object obj, zzcn zzcn) {
        this(zzcr, str, obj);
    }

    private final String zza(String str) {
        if (str != null && str.isEmpty()) {
            return this.zzf;
        }
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf(this.zzf);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    static void zza() {
        zzh.incrementAndGet();
    }

    public static void zza(Context context) {
        synchronized (zza) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            if (zzb != context) {
                zzbx.zzc();
                zzcu.zza();
                zzcg.zza();
                zzh.incrementAndGet();
                zzb = context;
                zzd = zzdc.zza(zzco.zza);
            }
        }
    }

    /* access modifiers changed from: private */
    public static zzcl<Double> zzb(zzcr zzcr, String str, double d2) {
        return new zzcp(zzcr, str, Double.valueOf(d2));
    }

    /* access modifiers changed from: private */
    public static zzcl<Long> zzb(zzcr zzcr, String str, long j) {
        return new zzcn(zzcr, str, Long.valueOf(j));
    }

    /* access modifiers changed from: private */
    public static zzcl<String> zzb(zzcr zzcr, String str, String str2) {
        return new zzcs(zzcr, str, str2);
    }

    /* access modifiers changed from: private */
    public static zzcl<Boolean> zzb(zzcr zzcr, String str, boolean z) {
        return new zzcq(zzcr, str, Boolean.valueOf(z));
    }

    static final /* synthetic */ zzcy zzd() {
        new zzck();
        return zzck.zza(zzb);
    }

    /* access modifiers changed from: package-private */
    public abstract T zza(Object obj);

    public final String zzb() {
        return zza(this.zze.zzd);
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d6  */
    public final T zzc() {
        T t;
        zzcy zza2;
        int i = zzh.get();
        if (this.zzi < i) {
            synchronized (this) {
                if (this.zzi < i) {
                    if (zzb != null) {
                        String str = (String) zzcg.zza(zzb).zza("gms:phenotype:phenotype_flag:debug_bypass_phenotype");
                        if (!(str != null && zzbw.zzb.matcher(str).matches())) {
                            zzcb zza3 = this.zze.zzb != null ? zzcj.zza(zzb, this.zze.zzb) ? zzbx.zza(zzb.getContentResolver(), this.zze.zzb) : null : zzcu.zza(zzb, (String) null);
                            if (zza3 != null) {
                                Object zza4 = zza3.zza(zzb());
                                if (zza4 != null) {
                                    t = zza(zza4);
                                    if (t != null) {
                                        Object zza5 = zzcg.zza(zzb).zza(zza(this.zze.zzc));
                                        t = zza5 != null ? zza(zza5) : null;
                                        if (t == null) {
                                            t = this.zzg;
                                        }
                                    }
                                    zza2 = zzd.zza();
                                    if (zza2.zza()) {
                                        String zza6 = ((zzch) zza2.zzb()).zza(this.zze.zzb, (String) null, this.zze.zzd, this.zzf);
                                        t = zza6 == null ? this.zzg : zza((Object) zza6);
                                    }
                                    this.zzj = t;
                                    this.zzi = i;
                                }
                            }
                        } else if (Log.isLoggable("PhenotypeFlag", 3)) {
                            String valueOf = String.valueOf(zzb());
                            Log.d("PhenotypeFlag", valueOf.length() != 0 ? "Bypass reading Phenotype values for flag: ".concat(valueOf) : new String("Bypass reading Phenotype values for flag: "));
                        }
                        t = null;
                        if (t != null) {
                        }
                        zza2 = zzd.zza();
                        if (zza2.zza()) {
                        }
                        this.zzj = t;
                        this.zzi = i;
                    } else {
                        throw new IllegalStateException("Must call PhenotypeFlag.init() first");
                    }
                }
            }
        }
        return this.zzj;
    }
}
