package com.google.firebase.iid;

import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-iid@@20.0.2 */
final class zzax {
    private int zza = 0;
    private final Map<Integer, TaskCompletionSource<Void>> zzb = new ArrayMap();
    private final zzat zzc;

    zzax(zzat zzat) {
        this.zzc = zzat;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0035 A[Catch:{ IOException -> 0x0057 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0047 A[Catch:{ IOException -> 0x0057 }] */
    private static boolean zza(FirebaseInstanceId firebaseInstanceId, String str) throws IOException {
        String[] split = str.split("!");
        if (split.length == 2) {
            String str2 = split[0];
            String str3 = split[1];
            char c2 = 65535;
            try {
                int hashCode = str2.hashCode();
                if (hashCode != 83) {
                    if (hashCode == 85 && str2.equals("U")) {
                        c2 = 1;
                        if (c2 == 0) {
                            firebaseInstanceId.zzb(str3);
                            if (FirebaseInstanceId.zzd()) {
                                Log.d("FirebaseInstanceId", "subscribe operation succeeded");
                            }
                        } else if (c2 == 1) {
                            firebaseInstanceId.zzc(str3);
                            if (FirebaseInstanceId.zzd()) {
                                Log.d("FirebaseInstanceId", "unsubscribe operation succeeded");
                            }
                        }
                    }
                } else if (str2.equals("S")) {
                    c2 = 0;
                    if (c2 == 0) {
                    }
                }
                if (c2 == 0) {
                }
            } catch (IOException e2) {
                if ("SERVICE_NOT_AVAILABLE".equals(e2.getMessage()) || "INTERNAL_SERVER_ERROR".equals(e2.getMessage())) {
                    String message = e2.getMessage();
                    StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 53);
                    sb.append("Topic operation failed: ");
                    sb.append(message);
                    sb.append(". Will retry Topic operation.");
                    Log.e("FirebaseInstanceId", sb.toString());
                    return false;
                } else if (e2.getMessage() == null) {
                    Log.e("FirebaseInstanceId", "Topic operation failed without exception message. Will retry Topic operation.");
                    return false;
                } else {
                    throw e2;
                }
            }
        }
        return true;
    }

    private final String zzb() {
        String zza2;
        synchronized (this.zzc) {
            zza2 = this.zzc.zza();
        }
        if (TextUtils.isEmpty(zza2)) {
            return null;
        }
        String[] split = zza2.split(",");
        if (split.length <= 1 || TextUtils.isEmpty(split[1])) {
            return null;
        }
        return split[1];
    }

    private final synchronized boolean zzb(String str) {
        synchronized (this.zzc) {
            String zza2 = this.zzc.zza();
            String valueOf = String.valueOf(",");
            String valueOf2 = String.valueOf(str);
            if (!zza2.startsWith(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf))) {
                return false;
            }
            String valueOf3 = String.valueOf(",");
            String valueOf4 = String.valueOf(str);
            this.zzc.zza(zza2.substring((valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3)).length()));
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized Task<Void> zza(String str) {
        String zza2;
        TaskCompletionSource taskCompletionSource;
        synchronized (this.zzc) {
            zza2 = this.zzc.zza();
            zzat zzat = this.zzc;
            StringBuilder sb = new StringBuilder(String.valueOf(zza2).length() + 1 + String.valueOf(str).length());
            sb.append(zza2);
            sb.append(",");
            sb.append(str);
            zzat.zza(sb.toString());
        }
        taskCompletionSource = new TaskCompletionSource();
        this.zzb.put(Integer.valueOf(this.zza + (TextUtils.isEmpty(zza2) ? 0 : zza2.split(",").length - 1)), taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean zza() {
        return zzb() != null;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (zza(r5, r0) != false) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r2 = r4.zzb.remove(java.lang.Integer.valueOf(r4.zza));
        zzb(r0);
        r4.zza++;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0037, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0038, code lost:
        if (r2 == null) goto L_0x0000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003a, code lost:
        r2.setResult(null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0016, code lost:
        return true;
     */
    public final boolean zza(FirebaseInstanceId firebaseInstanceId) throws IOException {
        while (true) {
            synchronized (this) {
                String zzb2 = zzb();
                if (zzb2 == null) {
                    if (FirebaseInstanceId.zzd()) {
                        Log.d("FirebaseInstanceId", "topic sync succeeded");
                    }
                }
            }
        }
        while (true) {
        }
    }
}
