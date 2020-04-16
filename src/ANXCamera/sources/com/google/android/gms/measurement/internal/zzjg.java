package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
final class zzjg implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzm zzb;
    private final /* synthetic */ zziz zzc;

    zzjg(zziz zziz, AtomicReference atomicReference, zzm zzm) {
        this.zzc = zziz;
        this.zza = atomicReference;
        this.zzb = zzm;
    }

    public final void run() {
        synchronized (this.zza) {
            try {
                zzfb zzd = this.zzc.zzb;
                if (zzd == null) {
                    this.zzc.zzr().zzf().zza("Failed to get app instance id");
                    this.zza.notify();
                    return;
                }
                this.zza.set(zzd.zzc(this.zzb));
                String str = (String) this.zza.get();
                if (str != null) {
                    this.zzc.zzf().zza(str);
                    this.zzc.zzs().zzj.zza(str);
                }
                this.zzc.zzak();
                this.zza.notify();
            } catch (RemoteException e2) {
                try {
                    this.zzc.zzr().zzf().zza("Failed to get app instance id", e2);
                    this.zza.notify();
                } catch (Throwable th) {
                    this.zza.notify();
                    throw th;
                }
            }
        }
    }
}
