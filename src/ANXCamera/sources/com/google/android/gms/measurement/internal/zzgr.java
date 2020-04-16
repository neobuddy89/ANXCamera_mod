package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.internal.measurement.zzkz;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
public final class zzgr extends zzfe {
    /* access modifiers changed from: private */
    public final zzks zza;
    private Boolean zzb;
    private String zzc;

    public zzgr(zzks zzks) {
        this(zzks, (String) null);
    }

    private zzgr(zzks zzks, String str) {
        Preconditions.checkNotNull(zzks);
        this.zza = zzks;
        this.zzc = null;
    }

    private final void zza(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        if (this.zza.zzq().zzg()) {
            runnable.run();
        } else {
            this.zza.zzq().zza(runnable);
        }
    }

    private final void zza(String str, boolean z) {
        boolean z2;
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                try {
                    if (this.zzb == null) {
                        if (!"com.google.android.gms".equals(this.zzc) && !UidVerifier.isGooglePlayServicesUid(this.zza.zzn(), Binder.getCallingUid())) {
                            if (!GoogleSignatureVerifier.getInstance(this.zza.zzn()).isUidGoogleSigned(Binder.getCallingUid())) {
                                z2 = false;
                                this.zzb = Boolean.valueOf(z2);
                            }
                        }
                        z2 = true;
                        this.zzb = Boolean.valueOf(z2);
                    }
                    if (this.zzb.booleanValue()) {
                        return;
                    }
                } catch (SecurityException e2) {
                    this.zza.zzr().zzf().zza("Measurement Service called with invalid calling package. appId", zzfj.zza(str));
                    throw e2;
                }
            }
            if (this.zzc == null && GooglePlayServicesUtilLight.uidHasPackageName(this.zza.zzn(), Binder.getCallingUid(), str)) {
                this.zzc = str;
            }
            if (!str.equals(this.zzc)) {
                throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[]{str}));
            }
            return;
        }
        this.zza.zzr().zzf().zza("Measurement Service called without app package");
        throw new SecurityException("Measurement Service called without app package");
    }

    private final void zzb(zzm zzm, boolean z) {
        Preconditions.checkNotNull(zzm);
        zza(zzm.zza, false);
        this.zza.zzj().zza(zzm.zzb, zzm.zzr, zzm.zzv);
    }

    public final List<zzkz> zza(zzm zzm, boolean z) {
        zzb(zzm, false);
        try {
            List<zzlb> list = (List) this.zza.zzq().zza(new zzhd(this, zzm)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzlb zzlb : list) {
                if (z || !zzla.zze(zzlb.zzc)) {
                    arrayList.add(new zzkz(zzlb));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e2) {
            if (!zzkz.zzb() || !this.zza.zzb().zze(zzm.zza, zzap.zzcy)) {
                this.zza.zzr().zzf().zza("Failed to get user attributes. appId", zzfj.zza(zzm.zza), e2);
                return null;
            }
            this.zza.zzr().zzf().zza("Failed to get user properties. appId", zzfj.zza(zzm.zza), e2);
            return null;
        }
    }

    public final List<zzv> zza(String str, String str2, zzm zzm) {
        zzb(zzm, false);
        try {
            return (List) this.zza.zzq().zza(new zzgy(this, zzm, str, str2)).get();
        } catch (InterruptedException | ExecutionException e2) {
            this.zza.zzr().zzf().zza("Failed to get conditional user properties", e2);
            return Collections.emptyList();
        }
    }

    public final List<zzv> zza(String str, String str2, String str3) {
        zza(str, true);
        try {
            return (List) this.zza.zzq().zza(new zzgx(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e2) {
            if (!zzkz.zzb() || !this.zza.zzb().zze(str, zzap.zzcy)) {
                this.zza.zzr().zzf().zza("Failed to get conditional user properties", e2);
            } else {
                this.zza.zzr().zzf().zza("Failed to get conditional user properties as", e2);
            }
            return Collections.emptyList();
        }
    }

    public final List<zzkz> zza(String str, String str2, String str3, boolean z) {
        zza(str, true);
        try {
            List<zzlb> list = (List) this.zza.zzq().zza(new zzgv(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzlb zzlb : list) {
                if (z || !zzla.zze(zzlb.zzc)) {
                    arrayList.add(new zzkz(zzlb));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e2) {
            if (!zzkz.zzb() || !this.zza.zzb().zze(str, zzap.zzcy)) {
                this.zza.zzr().zzf().zza("Failed to get user attributes. appId", zzfj.zza(str), e2);
            } else {
                this.zza.zzr().zzf().zza("Failed to get user properties as. appId", zzfj.zza(str), e2);
            }
            return Collections.emptyList();
        }
    }

    public final List<zzkz> zza(String str, String str2, boolean z, zzm zzm) {
        zzb(zzm, false);
        try {
            List<zzlb> list = (List) this.zza.zzq().zza(new zzgw(this, zzm, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzlb zzlb : list) {
                if (z || !zzla.zze(zzlb.zzc)) {
                    arrayList.add(new zzkz(zzlb));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e2) {
            if (!zzkz.zzb() || !this.zza.zzb().zze(zzm.zza, zzap.zzcy)) {
                this.zza.zzr().zzf().zza("Failed to get user attributes. appId", zzfj.zza(zzm.zza), e2);
            } else {
                this.zza.zzr().zzf().zza("Failed to query user properties. appId", zzfj.zza(zzm.zza), e2);
            }
            return Collections.emptyList();
        }
    }

    public final void zza(long j, String str, String str2, String str3) {
        zzhf zzhf = new zzhf(this, str2, str3, str, j);
        zza((Runnable) zzhf);
    }

    public final void zza(zzan zzan, zzm zzm) {
        Preconditions.checkNotNull(zzan);
        zzb(zzm, false);
        zza((Runnable) new zzgz(this, zzan, zzm));
    }

    public final void zza(zzan zzan, String str, String str2) {
        Preconditions.checkNotNull(zzan);
        Preconditions.checkNotEmpty(str);
        zza(str, true);
        zza((Runnable) new zzhc(this, zzan, str));
    }

    public final void zza(zzkz zzkz, zzm zzm) {
        Preconditions.checkNotNull(zzkz);
        zzb(zzm, false);
        zza((Runnable) new zzhe(this, zzkz, zzm));
    }

    public final void zza(zzm zzm) {
        zzb(zzm, false);
        zza((Runnable) new zzhg(this, zzm));
    }

    public final void zza(zzv zzv) {
        Preconditions.checkNotNull(zzv);
        Preconditions.checkNotNull(zzv.zzc);
        zza(zzv.zza, true);
        zza((Runnable) new zzgt(this, new zzv(zzv)));
    }

    public final void zza(zzv zzv, zzm zzm) {
        Preconditions.checkNotNull(zzv);
        Preconditions.checkNotNull(zzv.zzc);
        zzb(zzm, false);
        zzv zzv2 = new zzv(zzv);
        zzv2.zza = zzm.zza;
        zza((Runnable) new zzhi(this, zzv2, zzm));
    }

    public final byte[] zza(zzan zzan, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzan);
        zza(str, true);
        this.zza.zzr().zzw().zza("Log and bundle. event", this.zza.zzi().zza(zzan.zza));
        long nanoTime = this.zza.zzm().nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) this.zza.zzq().zzb(new zzhb(this, zzan, str)).get();
            if (bArr == null) {
                this.zza.zzr().zzf().zza("Log and bundle returned null. appId", zzfj.zza(str));
                bArr = new byte[0];
            }
            this.zza.zzr().zzw().zza("Log and bundle processed. event, size, time_ms", this.zza.zzi().zza(zzan.zza), Integer.valueOf(bArr.length), Long.valueOf((this.zza.zzm().nanoTime() / 1000000) - nanoTime));
            return bArr;
        } catch (InterruptedException | ExecutionException e2) {
            this.zza.zzr().zzf().zza("Failed to log and bundle. appId, event, error", zzfj.zza(str), this.zza.zzi().zza(zzan.zza), e2);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final zzan zzb(zzan zzan, zzm zzm) {
        boolean z = false;
        if (!(!"_cmp".equals(zzan.zza) || zzan.zzb == null || zzan.zzb.zza() == 0)) {
            String zzd = zzan.zzb.zzd("_cis");
            if (!TextUtils.isEmpty(zzd) && (("referrer broadcast".equals(zzd) || "referrer API".equals(zzd)) && this.zza.zzb().zze(zzm.zza, zzap.zzar))) {
                z = true;
            }
        }
        if (!z) {
            return zzan;
        }
        this.zza.zzr().zzv().zza("Event has been filtered ", zzan.toString());
        zzan zzan2 = new zzan("_cmpx", zzan.zzb, zzan.zzc, zzan.zzd);
        return zzan2;
    }

    public final void zzb(zzm zzm) {
        zzb(zzm, false);
        zza((Runnable) new zzgu(this, zzm));
    }

    public final String zzc(zzm zzm) {
        zzb(zzm, false);
        return this.zza.zzd(zzm);
    }

    public final void zzd(zzm zzm) {
        zza(zzm.zza, false);
        zza((Runnable) new zzha(this, zzm));
    }
}
