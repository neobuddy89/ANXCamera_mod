package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
final class zzjn implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ zzm zze;
    private final /* synthetic */ zziz zzf;

    zzjn(zziz zziz, AtomicReference atomicReference, String str, String str2, String str3, zzm zzm) {
        this.zzf = zziz;
        this.zza = atomicReference;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = zzm;
    }

    public final void run() {
        synchronized (this.zza) {
            try {
                zzfb zzd2 = this.zzf.zzb;
                if (zzd2 == null) {
                    this.zzf.zzr().zzf().zza("(legacy) Failed to get conditional properties; not connected to service", zzfj.zza(this.zzb), this.zzc, this.zzd);
                    this.zza.set(Collections.emptyList());
                    this.zza.notify();
                    return;
                }
                if (TextUtils.isEmpty(this.zzb)) {
                    this.zza.set(zzd2.zza(this.zzc, this.zzd, this.zze));
                } else {
                    this.zza.set(zzd2.zza(this.zzb, this.zzc, this.zzd));
                }
                this.zzf.zzak();
                this.zza.notify();
            } catch (RemoteException e2) {
                try {
                    this.zzf.zzr().zzf().zza("(legacy) Failed to get conditional properties; remote exception", zzfj.zza(this.zzb), this.zzc, e2);
                    this.zza.set(Collections.emptyList());
                    this.zza.notify();
                } catch (Throwable th) {
                    this.zza.notify();
                    throw th;
                }
            }
        }
    }
}
