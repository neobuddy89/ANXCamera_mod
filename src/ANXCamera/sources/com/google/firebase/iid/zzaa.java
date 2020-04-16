package com.google.firebase.iid;

import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-iid@@20.0.2 */
final /* synthetic */ class zzaa implements Runnable {
    private final zzw zza;

    zzaa(zzw zzw) {
        this.zza = zzw;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0041, code lost:
        if (android.util.Log.isLoggable("MessengerIpcClient", 3) == false) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0043, code lost:
        r3 = java.lang.String.valueOf(r1);
        r5 = new java.lang.StringBuilder(java.lang.String.valueOf(r3).length() + 8);
        r5.append("Sending ");
        r5.append(r3);
        android.util.Log.d("MessengerIpcClient", r5.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0067, code lost:
        r3 = com.google.firebase.iid.zzv.zza(r0.zzf);
        r4 = r0.zzb;
        r5 = android.os.Message.obtain();
        r5.what = r1.zzc;
        r5.arg1 = r1.zza;
        r5.replyTo = r4;
        r4 = new android.os.Bundle();
        r4.putBoolean("oneWay", r1.zza());
        r4.putString("pkg", r3.getPackageName());
        r4.putBundle(com.google.android.apps.photos.api.PhotosOemApi.PATH_SPECIAL_TYPE_DATA, r1.zzd);
        r5.setData(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r0.zzc.zza(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00a7, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a8, code lost:
        r0.zza(2, r1.getMessage());
     */
    public final void run() {
        zzw zzw = this.zza;
        while (true) {
            synchronized (zzw) {
                if (zzw.zza == 2) {
                    if (zzw.zzd.isEmpty()) {
                        zzw.zzb();
                        return;
                    }
                    zzah poll = zzw.zzd.poll();
                    zzw.zze.put(poll.zza, poll);
                    zzw.zzf.zzc.schedule(new zzac(zzw, poll), 30, TimeUnit.SECONDS);
                } else {
                    return;
                }
            }
        }
        while (true) {
        }
    }
}
