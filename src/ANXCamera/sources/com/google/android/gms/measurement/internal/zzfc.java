package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
public final class zzfc<V> {
    private static final Object zzf = new Object();
    private final String zza;
    private final zzfa<V> zzb;
    private final V zzc;
    private final V zzd;
    private final Object zze;
    private volatile V zzg;
    private volatile V zzh;

    private zzfc(String str, V v, V v2, zzfa<V> zzfa) {
        this.zze = new Object();
        this.zzg = null;
        this.zzh = null;
        this.zza = str;
        this.zzc = v;
        this.zzd = v2;
        this.zzb = zzfa;
    }

    /* JADX WARNING: CFG modification limit reached, blocks count: 172 */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0024, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r4 = com.google.android.gms.measurement.internal.zzap.zzdi.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0032, code lost:
        if (r4.hasNext() == false) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0034, code lost:
        r0 = (com.google.android.gms.measurement.internal.zzfc) r4.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003f, code lost:
        if (com.google.android.gms.measurement.internal.zzw.zza() != false) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0041, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0044, code lost:
        if (r0.zzb == null) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0046, code lost:
        r1 = r0.zzb.zza();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0060, code lost:
        throw new java.lang.IllegalStateException("Refreshing flag cache must be done on a worker thread.");
     */
    public final V zza(V v) {
        zzfc zzfc;
        V v2;
        synchronized (this.zze) {
        }
        if (v != null) {
            return v;
        }
        if (zzez.zza == null) {
            return this.zzc;
        }
        zzw zzw = zzez.zza;
        synchronized (zzf) {
            if (zzw.zza()) {
                V v3 = this.zzh == null ? this.zzc : this.zzh;
            }
        }
        zzfa<V> zzfa = this.zzb;
        if (zzfa == null) {
            zzw zzw2 = zzez.zza;
            return this.zzc;
        }
        try {
            return zzfa.zza();
        } catch (SecurityException e2) {
            zzw zzw3 = zzez.zza;
            return this.zzc;
        } catch (IllegalStateException e3) {
            zzw zzw4 = zzez.zza;
            return this.zzc;
        }
        synchronized (zzf) {
            zzfc.zzh = v2;
        }
    }

    public final String zza() {
        return this.zza;
    }
}
