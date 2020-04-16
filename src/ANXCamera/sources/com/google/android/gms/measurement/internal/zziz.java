package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzn;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
public final class zziz extends zze {
    /* access modifiers changed from: private */
    public final zzjr zza;
    /* access modifiers changed from: private */
    public zzfb zzb;
    private volatile Boolean zzc;
    private final zzaf zzd;
    private final zzkl zze;
    private final List<Runnable> zzf = new ArrayList();
    private final zzaf zzg;

    protected zziz(zzgq zzgq) {
        super(zzgq);
        this.zze = new zzkl(zzgq.zzm());
        this.zza = new zzjr(this);
        this.zzd = new zzjc(this, zzgq);
        this.zzg = new zzjj(this, zzgq);
    }

    private final zzm zza(boolean z) {
        zzu();
        return zzg().zza(z ? zzr().zzy() : null);
    }

    /* access modifiers changed from: private */
    public final void zza(ComponentName componentName) {
        zzd();
        if (this.zzb != null) {
            this.zzb = null;
            zzr().zzx().zza("Disconnected from device MeasurementService", componentName);
            zzd();
            zzaf();
        }
    }

    private final void zza(Runnable runnable) throws IllegalStateException {
        zzd();
        if (zzab()) {
            runnable.run();
        } else if (((long) this.zzf.size()) >= 1000) {
            zzr().zzf().zza("Discarding data. Max runnable queue size reached");
        } else {
            this.zzf.add(runnable);
            this.zzg.zza(60000);
            zzaf();
        }
    }

    private final boolean zzaj() {
        zzu();
        return true;
    }

    /* access modifiers changed from: private */
    public final void zzak() {
        zzd();
        this.zze.zza();
        this.zzd.zza(zzap.zzai.zza(null).longValue());
    }

    private final boolean zzal() {
        boolean z;
        zzd();
        zzw();
        if (this.zzc == null) {
            zzd();
            zzw();
            Boolean zzj = zzs().zzj();
            boolean z2 = true;
            if (zzj == null || !zzj.booleanValue()) {
                zzu();
                boolean z3 = false;
                if (zzg().zzag() == 1) {
                    z = true;
                } else {
                    zzr().zzx().zza("Checking service availability");
                    int zza2 = zzp().zza(12451000);
                    if (zza2 == 0) {
                        zzr().zzx().zza("Service available");
                        z = true;
                    } else if (zza2 == 1) {
                        zzr().zzx().zza("Service missing");
                        z = true;
                        z2 = false;
                    } else if (zza2 == 2) {
                        zzr().zzw().zza("Service container out of date");
                        if (zzp().zzj() < 17443) {
                            z = true;
                            z2 = false;
                        } else {
                            if (zzj != null) {
                                z2 = false;
                            }
                            z = false;
                        }
                    } else if (zza2 == 3) {
                        zzr().zzi().zza("Service disabled");
                        z = false;
                        z2 = false;
                    } else if (zza2 == 9) {
                        zzr().zzi().zza("Service invalid");
                        z = false;
                        z2 = false;
                    } else if (zza2 != 18) {
                        zzr().zzi().zza("Unexpected service status", Integer.valueOf(zza2));
                        z = false;
                        z2 = false;
                    } else {
                        zzr().zzi().zza("Service updating");
                        z = true;
                    }
                }
                if (z2 || !zzt().zzy()) {
                    z3 = z;
                } else {
                    zzr().zzf().zza("No way to upload. Consider using the full version of Analytics");
                }
                if (z3) {
                    zzs().zza(z2);
                }
            }
            this.zzc = Boolean.valueOf(z2);
        }
        return this.zzc.booleanValue();
    }

    /* access modifiers changed from: private */
    public final void zzam() {
        zzd();
        if (zzab()) {
            zzr().zzx().zza("Inactivity, disconnecting from the service");
            zzah();
        }
    }

    /* access modifiers changed from: private */
    public final void zzan() {
        zzd();
        zzr().zzx().zza("Processing queued up service tasks", Integer.valueOf(this.zzf.size()));
        for (Runnable run : this.zzf) {
            try {
                run.run();
            } catch (Exception e2) {
                zzr().zzf().zza("Task exception while flushing queue", e2);
            }
        }
        this.zzf.clear();
        this.zzg.zzc();
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    public final void zza(zzn zzn) {
        zzd();
        zzw();
        zza((Runnable) new zzjf(this, zza(false), zzn));
    }

    public final void zza(zzn zzn, zzan zzan, String str) {
        zzd();
        zzw();
        if (zzp().zza(12451000) != 0) {
            zzr().zzi().zza("Not bundling data. Service unavailable or out of date");
            zzp().zza(zzn, new byte[0]);
            return;
        }
        zza((Runnable) new zzjk(this, zzan, str, zzn));
    }

    /* access modifiers changed from: protected */
    public final void zza(zzn zzn, String str, String str2) {
        zzd();
        zzw();
        zzjq zzjq = new zzjq(this, str, str2, zza(false), zzn);
        zza((Runnable) zzjq);
    }

    /* access modifiers changed from: protected */
    public final void zza(zzn zzn, String str, String str2, boolean z) {
        zzd();
        zzw();
        zzjs zzjs = new zzjs(this, str, str2, z, zza(false), zzn);
        zza((Runnable) zzjs);
    }

    /* access modifiers changed from: protected */
    public final void zza(zzan zzan, String str) {
        Preconditions.checkNotNull(zzan);
        zzd();
        zzw();
        boolean zzaj = zzaj();
        zzjl zzjl = new zzjl(this, zzaj, zzaj && zzj().zza(zzan), zzan, zza(true), str);
        zza((Runnable) zzjl);
    }

    /* access modifiers changed from: protected */
    public final void zza(zzfb zzfb) {
        zzd();
        Preconditions.checkNotNull(zzfb);
        this.zzb = zzfb;
        zzak();
        zzan();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0045  */
    public final void zza(zzfb zzfb, AbstractSafeParcelable abstractSafeParcelable, zzm zzm) {
        int i;
        int size;
        int i2;
        zzd();
        zzb();
        zzw();
        boolean zzaj = zzaj();
        int i3 = 0;
        int i4 = 100;
        while (i3 < 1001 && i4 == 100) {
            ArrayList arrayList = new ArrayList();
            if (zzaj) {
                List<AbstractSafeParcelable> zza2 = zzj().zza(100);
                if (zza2 != null) {
                    arrayList.addAll(zza2);
                    i = zza2.size();
                    if (abstractSafeParcelable != null && i < 100) {
                        arrayList.add(abstractSafeParcelable);
                    }
                    ArrayList arrayList2 = arrayList;
                    size = arrayList2.size();
                    i2 = 0;
                    while (i2 < size) {
                        Object obj = arrayList2.get(i2);
                        i2++;
                        AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) obj;
                        if (abstractSafeParcelable2 instanceof zzan) {
                            try {
                                zzfb.zza((zzan) abstractSafeParcelable2, zzm);
                            } catch (RemoteException e2) {
                                zzr().zzf().zza("Failed to send event to the service", e2);
                            }
                        } else if (abstractSafeParcelable2 instanceof zzkz) {
                            try {
                                zzfb.zza((zzkz) abstractSafeParcelable2, zzm);
                            } catch (RemoteException e3) {
                                zzr().zzf().zza("Failed to send user property to the service", e3);
                            }
                        } else if (abstractSafeParcelable2 instanceof zzv) {
                            try {
                                zzfb.zza((zzv) abstractSafeParcelable2, zzm);
                            } catch (RemoteException e4) {
                                zzr().zzf().zza("Failed to send conditional user property to the service", e4);
                            }
                        } else {
                            zzr().zzf().zza("Discarding data. Unrecognized parcel type.");
                        }
                    }
                    i3++;
                    i4 = i;
                }
            }
            i = 0;
            arrayList.add(abstractSafeParcelable);
            ArrayList arrayList22 = arrayList;
            size = arrayList22.size();
            i2 = 0;
            while (i2 < size) {
            }
            i3++;
            i4 = i;
        }
    }

    /* access modifiers changed from: protected */
    public final void zza(zziv zziv) {
        zzd();
        zzw();
        zza((Runnable) new zzjh(this, zziv));
    }

    /* access modifiers changed from: protected */
    public final void zza(zzkz zzkz) {
        zzd();
        zzw();
        zza((Runnable) new zzjb(this, zzaj() && zzj().zza(zzkz), zzkz, zza(true)));
    }

    /* access modifiers changed from: protected */
    public final void zza(zzv zzv) {
        Preconditions.checkNotNull(zzv);
        zzd();
        zzw();
        zzu();
        zzjo zzjo = new zzjo(this, true, zzj().zza(zzv), new zzv(zzv), zza(true), zzv);
        zza((Runnable) zzjo);
    }

    public final void zza(AtomicReference<String> atomicReference) {
        zzd();
        zzw();
        zza((Runnable) new zzjg(this, atomicReference, zza(false)));
    }

    /* access modifiers changed from: protected */
    public final void zza(AtomicReference<List<zzv>> atomicReference, String str, String str2, String str3) {
        zzd();
        zzw();
        zzjn zzjn = new zzjn(this, atomicReference, str, str2, str3, zza(false));
        zza((Runnable) zzjn);
    }

    /* access modifiers changed from: protected */
    public final void zza(AtomicReference<List<zzkz>> atomicReference, String str, String str2, String str3, boolean z) {
        zzd();
        zzw();
        zzjp zzjp = new zzjp(this, atomicReference, str, str2, str3, z, zza(false));
        zza((Runnable) zzjp);
    }

    /* access modifiers changed from: protected */
    public final void zza(AtomicReference<List<zzkz>> atomicReference, boolean z) {
        zzd();
        zzw();
        zza((Runnable) new zzje(this, atomicReference, zza(false), z));
    }

    public final boolean zzab() {
        zzd();
        zzw();
        return this.zzb != null;
    }

    /* access modifiers changed from: protected */
    public final void zzac() {
        zzd();
        zzw();
        zza((Runnable) new zzjm(this, zza(true)));
    }

    /* access modifiers changed from: protected */
    public final void zzad() {
        zzd();
        zzb();
        zzw();
        zzm zza2 = zza(false);
        if (zzaj()) {
            zzj().zzab();
        }
        zza((Runnable) new zzjd(this, zza2));
    }

    /* access modifiers changed from: protected */
    public final void zzae() {
        zzd();
        zzw();
        zzm zza2 = zza(true);
        boolean zza3 = zzt().zza(zzap.zzbz);
        if (zza3) {
            zzj().zzac();
        }
        zza((Runnable) new zzji(this, zza2, zza3));
    }

    /* access modifiers changed from: package-private */
    public final void zzaf() {
        zzd();
        zzw();
        if (!zzab()) {
            if (zzal()) {
                this.zza.zzb();
            } else if (!zzt().zzy()) {
                zzu();
                List<ResolveInfo> queryIntentServices = zzn().getPackageManager().queryIntentServices(new Intent().setClassName(zzn(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
                if (queryIntentServices != null && queryIntentServices.size() > 0) {
                    Intent intent = new Intent("com.google.android.gms.measurement.START");
                    Context zzn = zzn();
                    zzu();
                    intent.setComponent(new ComponentName(zzn, "com.google.android.gms.measurement.AppMeasurementService"));
                    this.zza.zza(intent);
                    return;
                }
                zzr().zzf().zza("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final Boolean zzag() {
        return this.zzc;
    }

    public final void zzah() {
        zzd();
        zzw();
        this.zza.zza();
        try {
            ConnectionTracker.getInstance().unbindService(zzn(), this.zza);
        } catch (IllegalArgumentException | IllegalStateException e2) {
        }
        this.zzb = null;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzai() {
        zzd();
        zzw();
        return !zzal() || zzp().zzj() >= 200900;
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    public final /* bridge */ /* synthetic */ zzb zze() {
        return super.zze();
    }

    public final /* bridge */ /* synthetic */ zzhr zzf() {
        return super.zzf();
    }

    public final /* bridge */ /* synthetic */ zzfg zzg() {
        return super.zzg();
    }

    public final /* bridge */ /* synthetic */ zziz zzh() {
        return super.zzh();
    }

    public final /* bridge */ /* synthetic */ zziy zzi() {
        return super.zzi();
    }

    public final /* bridge */ /* synthetic */ zzff zzj() {
        return super.zzj();
    }

    public final /* bridge */ /* synthetic */ zzke zzk() {
        return super.zzk();
    }

    public final /* bridge */ /* synthetic */ zzah zzl() {
        return super.zzl();
    }

    public final /* bridge */ /* synthetic */ Clock zzm() {
        return super.zzm();
    }

    public final /* bridge */ /* synthetic */ Context zzn() {
        return super.zzn();
    }

    public final /* bridge */ /* synthetic */ zzfh zzo() {
        return super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzla zzp() {
        return super.zzp();
    }

    public final /* bridge */ /* synthetic */ zzgj zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ zzfj zzr() {
        return super.zzr();
    }

    public final /* bridge */ /* synthetic */ zzfv zzs() {
        return super.zzs();
    }

    public final /* bridge */ /* synthetic */ zzx zzt() {
        return super.zzt();
    }

    public final /* bridge */ /* synthetic */ zzw zzu() {
        return super.zzu();
    }

    /* access modifiers changed from: protected */
    public final boolean zzz() {
        return false;
    }
}
