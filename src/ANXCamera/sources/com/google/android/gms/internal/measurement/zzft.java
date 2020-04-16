package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.3.0 */
public class zzft {
    private static final zzeq zza = zzeq.zza();
    private zzdu zzb;
    private volatile zzgo zzc;
    private volatile zzdu zzd;

    private final zzgo zzb(zzgo zzgo) {
        if (this.zzc == null) {
            synchronized (this) {
                if (this.zzc == null) {
                    try {
                        this.zzc = zzgo;
                        this.zzd = zzdu.zza;
                    } catch (zzfo e2) {
                        this.zzc = zzgo;
                        this.zzd = zzdu.zza;
                    }
                }
            }
        }
        return this.zzc;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzft)) {
            return false;
        }
        zzft zzft = (zzft) obj;
        zzgo zzgo = this.zzc;
        zzgo zzgo2 = zzft.zzc;
        return (zzgo == null && zzgo2 == null) ? zzc().equals(zzft.zzc()) : (zzgo == null || zzgo2 == null) ? zzgo != null ? zzgo.equals(zzft.zzb(zzgo.zzbt())) : zzb(zzgo2.zzbt()).equals(zzgo2) : zzgo.equals(zzgo2);
    }

    public int hashCode() {
        return 1;
    }

    public final zzgo zza(zzgo zzgo) {
        zzgo zzgo2 = this.zzc;
        this.zzb = null;
        this.zzd = null;
        this.zzc = zzgo;
        return zzgo2;
    }

    public final int zzb() {
        if (this.zzd != null) {
            return this.zzd.zza();
        }
        if (this.zzc != null) {
            return this.zzc.zzbn();
        }
        return 0;
    }

    public final zzdu zzc() {
        if (this.zzd != null) {
            return this.zzd;
        }
        synchronized (this) {
            if (this.zzd != null) {
                zzdu zzdu = this.zzd;
                return zzdu;
            }
            if (this.zzc == null) {
                this.zzd = zzdu.zza;
            } else {
                this.zzd = this.zzc.zzbh();
            }
            zzdu zzdu2 = this.zzd;
            return zzdu2;
        }
    }
}
