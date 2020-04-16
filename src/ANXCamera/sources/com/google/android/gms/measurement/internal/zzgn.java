package com.google.android.gms.measurement.internal;

import android.os.Process;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
final class zzgn extends Thread {
    private final Object zza;
    private final BlockingQueue<zzgo<?>> zzb;
    private boolean zzc = false;
    private final /* synthetic */ zzgj zzd;

    public zzgn(zzgj zzgj, String str, BlockingQueue<zzgo<?>> blockingQueue) {
        this.zzd = zzgj;
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(blockingQueue);
        this.zza = new Object();
        this.zzb = blockingQueue;
        setName(str);
    }

    private final void zza(InterruptedException interruptedException) {
        this.zzd.zzr().zzi().zza(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }

    private final void zzb() {
        synchronized (this.zzd.zzg) {
            if (!this.zzc) {
                this.zzd.zzh.release();
                this.zzd.zzg.notifyAll();
                if (this == this.zzd.zza) {
                    zzgn unused = this.zzd.zza = null;
                } else if (this == this.zzd.zzb) {
                    zzgn unused2 = this.zzd.zzb = null;
                } else {
                    this.zzd.zzr().zzf().zza("Current scheduler thread is neither worker nor network");
                }
                this.zzc = true;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0075, code lost:
        zzb();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0078, code lost:
        return;
     */
    public final void run() {
        boolean z = false;
        while (!z) {
            try {
                this.zzd.zzh.acquire();
                z = true;
            } catch (InterruptedException e2) {
                zza(e2);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                zzgo zzgo = (zzgo) this.zzb.poll();
                if (zzgo != null) {
                    Process.setThreadPriority(zzgo.zza ? threadPriority : 10);
                    zzgo.run();
                } else {
                    synchronized (this.zza) {
                        if (this.zzb.peek() == null && !this.zzd.zzi) {
                            try {
                                this.zza.wait(30000);
                            } catch (InterruptedException e3) {
                                zza(e3);
                            }
                        }
                    }
                    synchronized (this.zzd.zzg) {
                        if (this.zzb.peek() == null) {
                            if (this.zzd.zzt().zza(zzap.zzct)) {
                                zzb();
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            zzb();
            throw th;
        }
    }

    public final void zza() {
        synchronized (this.zza) {
            this.zza.notifyAll();
        }
    }
}
