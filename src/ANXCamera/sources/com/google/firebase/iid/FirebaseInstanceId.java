package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Subscriber;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.firebase:firebase-iid@@20.0.2 */
public class FirebaseInstanceId {
    private static final long zza = TimeUnit.HOURS.toSeconds(8);
    private static zzat zzb;
    private static ScheduledExecutorService zzc;
    private final Executor zzd;
    /* access modifiers changed from: private */
    public final FirebaseApp zze;
    private final zzai zzf;
    private final zzl zzg;
    private final zzan zzh;
    private final zzax zzi;
    private boolean zzj;
    private final zza zzk;

    /* compiled from: com.google.firebase:firebase-iid@@20.0.2 */
    private class zza {
        private boolean zzb;
        private final Subscriber zzc;
        private boolean zzd;
        private EventHandler<DataCollectionDefaultChange> zze;
        private Boolean zzf;

        zza(Subscriber subscriber) {
            this.zzc = subscriber;
        }

        private final synchronized void zzb() {
            if (!this.zzd) {
                this.zzb = zzd();
                Boolean zzc2 = zzc();
                this.zzf = zzc2;
                if (zzc2 == null && this.zzb) {
                    zzk zzk = new zzk(this);
                    this.zze = zzk;
                    this.zzc.subscribe(DataCollectionDefaultChange.class, zzk);
                }
                this.zzd = true;
            }
        }

        private final Boolean zzc() {
            Context applicationContext = FirebaseInstanceId.this.zze.getApplicationContext();
            SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("auto_init")) {
                return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
            }
            try {
                PackageManager packageManager = applicationContext.getPackageManager();
                if (packageManager == null) {
                    return null;
                }
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(applicationContext.getPackageName(), 128);
                if (applicationInfo == null || applicationInfo.metaData == null || !applicationInfo.metaData.containsKey("firebase_messaging_auto_init_enabled")) {
                    return null;
                }
                return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
            } catch (PackageManager.NameNotFoundException e2) {
                return null;
            }
        }

        private final boolean zzd() {
            try {
                Class.forName("com.google.firebase.messaging.FirebaseMessaging");
                return true;
            } catch (ClassNotFoundException e2) {
                Context applicationContext = FirebaseInstanceId.this.zze.getApplicationContext();
                Intent intent = new Intent("com.google.firebase.MESSAGING_EVENT");
                intent.setPackage(applicationContext.getPackageName());
                ResolveInfo resolveService = applicationContext.getPackageManager().resolveService(intent, 0);
                return (resolveService == null || resolveService.serviceInfo == null) ? false : true;
            }
        }

        /* access modifiers changed from: package-private */
        public final synchronized void zza(boolean z) {
            zzb();
            if (this.zze != null) {
                this.zzc.unsubscribe(DataCollectionDefaultChange.class, this.zze);
                this.zze = null;
            }
            SharedPreferences.Editor edit = FirebaseInstanceId.this.zze.getApplicationContext().getSharedPreferences("com.google.firebase.messaging", 0).edit();
            edit.putBoolean("auto_init", z);
            edit.apply();
            if (z) {
                FirebaseInstanceId.this.zzj();
            }
            this.zzf = Boolean.valueOf(z);
        }

        /* access modifiers changed from: package-private */
        public final synchronized boolean zza() {
            zzb();
            if (this.zzf == null) {
                return this.zzb && FirebaseInstanceId.this.zze.isDataCollectionDefaultEnabled();
            }
            return this.zzf.booleanValue();
        }
    }

    FirebaseInstanceId(FirebaseApp firebaseApp, Subscriber subscriber, UserAgentPublisher userAgentPublisher, HeartBeatInfo heartBeatInfo) {
        this(firebaseApp, new zzai(firebaseApp.getApplicationContext()), zza.zzb(), zza.zzb(), subscriber, userAgentPublisher, heartBeatInfo);
    }

    private FirebaseInstanceId(FirebaseApp firebaseApp, zzai zzai, Executor executor, Executor executor2, Subscriber subscriber, UserAgentPublisher userAgentPublisher, HeartBeatInfo heartBeatInfo) {
        this.zzj = false;
        if (zzai.zza(firebaseApp) != null) {
            synchronized (FirebaseInstanceId.class) {
                if (zzb == null) {
                    zzb = new zzat(firebaseApp.getApplicationContext());
                }
            }
            this.zze = firebaseApp;
            this.zzf = zzai;
            zzl zzl = new zzl(firebaseApp, zzai, executor, userAgentPublisher, heartBeatInfo);
            this.zzg = zzl;
            this.zzd = executor2;
            this.zzi = new zzax(zzb);
            this.zzk = new zza(subscriber);
            this.zzh = new zzan(executor);
            executor2.execute(new zzh(this));
            return;
        }
        throw new IllegalStateException("FirebaseInstanceId failed to initialize, FirebaseApp is missing project ID");
    }

    public static FirebaseInstanceId getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    public static FirebaseInstanceId getInstance(FirebaseApp firebaseApp) {
        return (FirebaseInstanceId) firebaseApp.get(FirebaseInstanceId.class);
    }

    private final Task<InstanceIdResult> zza(String str, String str2) {
        return Tasks.forResult(null).continueWithTask(this.zzd, new zzg(this, str, zzd(str2)));
    }

    private final <T> T zza(Task<T> task) throws IOException {
        try {
            return Tasks.await(task, 30000, TimeUnit.MILLISECONDS);
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof IOException) {
                if ("INSTANCE_ID_RESET".equals(cause.getMessage())) {
                    zze();
                }
                throw ((IOException) cause);
            } else if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else {
                throw new IOException(e2);
            }
        } catch (InterruptedException | TimeoutException e3) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
    }

    static void zza(Runnable runnable, long j) {
        synchronized (FirebaseInstanceId.class) {
            if (zzc == null) {
                zzc = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("FirebaseInstanceId"));
            }
            zzc.schedule(runnable, j, TimeUnit.SECONDS);
        }
    }

    private static zzas zzb(String str, String str2) {
        return zzb.zza("", str, str2);
    }

    private static String zzd(String str) {
        return (str.isEmpty() || str.equalsIgnoreCase("fcm") || str.equalsIgnoreCase("gcm")) ? "*" : str;
    }

    static boolean zzd() {
        if (!Log.isLoggable("FirebaseInstanceId", 3)) {
            return Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseInstanceId", 3);
        }
        return true;
    }

    /* access modifiers changed from: private */
    public final void zzj() {
        if (zza(zzb()) || this.zzi.zza()) {
            zzk();
        }
    }

    private final synchronized void zzk() {
        if (!this.zzj) {
            zza(0);
        }
    }

    private static String zzl() {
        return zzb.zzb("").zza();
    }

    public void deleteInstanceId() throws IOException {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            zza(this.zzg.zza(zzl()));
            zze();
            return;
        }
        throw new IOException("MAIN_THREAD");
    }

    public void deleteToken(String str, String str2) throws IOException {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            String zzd2 = zzd(str2);
            zza(this.zzg.zzb(zzl(), str, zzd2));
            zzb.zzb("", str, zzd2);
            return;
        }
        throw new IOException("MAIN_THREAD");
    }

    public long getCreationTime() {
        return zzb.zzb("").zzb();
    }

    public String getId() {
        zzj();
        return zzl();
    }

    public Task<InstanceIdResult> getInstanceId() {
        return zza(zzai.zza(this.zze), "*");
    }

    @Deprecated
    public String getToken() {
        zzas zzb2 = zzb();
        if (zza(zzb2)) {
            zzk();
        }
        return zzas.zza(zzb2);
    }

    public String getToken(String str, String str2) throws IOException {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            return ((InstanceIdResult) zza(zza(str, str2))).getToken();
        }
        throw new IOException("MAIN_THREAD");
    }

    public final synchronized Task<Void> zza(String str) {
        Task<Void> zza2;
        zza2 = this.zzi.zza(str);
        zzk();
        return zza2;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Task zza(String str, String str2, Task task) throws Exception {
        String zzl = zzl();
        zzas zzb2 = zzb(str, str2);
        return !zza(zzb2) ? Tasks.forResult(new zzu(zzl, zzb2.zza)) : this.zzh.zza(str, str2, new zzj(this, zzl, str, str2));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Task zza(String str, String str2, String str3) {
        return this.zzg.zza(str, str2, str3).onSuccessTask(this.zzd, new zzi(this, str2, str3, str));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Task zza(String str, String str2, String str3, String str4) throws Exception {
        zzb.zza("", str, str2, str4, this.zzf.zzb());
        return Tasks.forResult(new zzu(str3, str4));
    }

    /* access modifiers changed from: package-private */
    public final FirebaseApp zza() {
        return this.zze;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zza(long j) {
        zzav zzav = new zzav(this, this.zzf, this.zzi, Math.min(Math.max(30, j << 1), zza));
        zza((Runnable) zzav, j);
        this.zzj = true;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zza(boolean z) {
        this.zzj = z;
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzas zzas) {
        return zzas == null || zzas.zzb(this.zzf.zzb());
    }

    /* access modifiers changed from: package-private */
    public final zzas zzb() {
        return zzb(zzai.zza(this.zze), "*");
    }

    /* access modifiers changed from: package-private */
    public final void zzb(String str) throws IOException {
        zzas zzb2 = zzb();
        if (!zza(zzb2)) {
            zza(this.zzg.zzc(zzl(), zzb2.zza, str));
            return;
        }
        throw new IOException("token not available");
    }

    public final void zzb(boolean z) {
        this.zzk.zza(z);
    }

    /* access modifiers changed from: package-private */
    public final String zzc() throws IOException {
        return getToken(zzai.zza(this.zze), "*");
    }

    /* access modifiers changed from: package-private */
    public final void zzc(String str) throws IOException {
        zzas zzb2 = zzb();
        if (!zza(zzb2)) {
            zza(this.zzg.zzd(zzl(), zzb2.zza, str));
            return;
        }
        throw new IOException("token not available");
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zze() {
        zzb.zzb();
        if (this.zzk.zza()) {
            zzk();
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzf() {
        return this.zzf.zza() != 0;
    }

    /* access modifiers changed from: package-private */
    public final void zzg() {
        zzb.zzc("");
        zzk();
    }

    public final boolean zzh() {
        return this.zzk.zza();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi() {
        if (this.zzk.zza()) {
            zzj();
        }
    }
}
