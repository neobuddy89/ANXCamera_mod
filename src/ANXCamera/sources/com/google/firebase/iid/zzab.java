package com.google.firebase.iid;

import android.os.IBinder;

/* compiled from: com.google.firebase:firebase-iid@@20.0.2 */
final /* synthetic */ class zzab implements Runnable {
    private final zzw zza;
    private final IBinder zzb;

    zzab(zzw zzw, IBinder iBinder) {
        this.zza = zzw;
        this.zzb = iBinder;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x001f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0021, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0022, code lost:
        r0.zza(0, r1.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002c, code lost:
        throw r1;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:5:0x000a, B:9:0x000f] */
    public final void run() {
        zzw zzw = this.zza;
        IBinder iBinder = this.zzb;
        synchronized (zzw) {
            if (iBinder == null) {
                zzw.zza(0, "Null service connection");
                return;
            }
            zzw.zzc = new zzaf(iBinder);
            zzw.zza = 2;
            zzw.zza();
        }
    }
}
