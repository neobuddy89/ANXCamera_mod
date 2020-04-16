package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
final class zzje implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzm zzb;
    private final /* synthetic */ boolean zzc;
    private final /* synthetic */ zziz zzd;

    zzje(zziz zziz, AtomicReference atomicReference, zzm zzm, boolean z) {
        this.zzd = zziz;
        this.zza = atomicReference;
        this.zzb = zzm;
        this.zzc = z;
    }

    public final void run() {
        synchronized (this.zza) {
            try {
                zzfb zzd2 = this.zzd.zzb;
                if (zzd2 == null) {
                    this.zzd.zzr().zzf().zza("Failed to get all user properties; not connected to service");
                    this.zza.notify();
                    return;
                }
                this.zza.set(zzd2.zza(this.zzb, this.zzc));
                this.zzd.zzak();
                this.zza.notify();
            } catch (RemoteException e2) {
                try {
                    this.zzd.zzr().zzf().zza("Failed to get all user properties; remote exception", e2);
                    this.zza.notify();
                } catch (Throwable th) {
                    this.zza.notify();
                    throw th;
                }
            }
        }
    }
}
