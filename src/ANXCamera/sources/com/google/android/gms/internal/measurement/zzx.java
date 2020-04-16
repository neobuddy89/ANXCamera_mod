package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.android.camera.module.loader.FunctionParseBeautyBodySlimCount;
import com.android.camera.statistic.MistatsConstants;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzhp;
import com.google.android.gms.measurement.internal.zzhq;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.3.0 */
public class zzx {
    private static volatile zzx zzb;
    private static Boolean zzh = null;
    /* access modifiers changed from: private */
    public static Boolean zzi = null;
    private static boolean zzj = false;
    private static Boolean zzk = null;
    private static String zzl = "use_dynamite_api";
    private static String zzm = "allow_remote_dynamite";
    private static boolean zzn = false;
    private static boolean zzo = false;
    protected final Clock zza;
    /* access modifiers changed from: private */
    public final String zzc;
    private final ExecutorService zzd;
    private final AppMeasurementSdk zze;
    /* access modifiers changed from: private */
    public List<Pair<zzhp, zzb>> zzf;
    private int zzg;
    /* access modifiers changed from: private */
    public boolean zzp;
    private String zzq;
    /* access modifiers changed from: private */
    public zzm zzr;

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.3.0 */
    abstract class zza implements Runnable {
        final long zza;
        final long zzb;
        private final boolean zzc;

        zza(zzx zzx) {
            this(true);
        }

        zza(boolean z) {
            this.zza = zzx.this.zza.currentTimeMillis();
            this.zzb = zzx.this.zza.elapsedRealtime();
            this.zzc = z;
        }

        public void run() {
            if (zzx.this.zzp) {
                zzb();
                return;
            }
            try {
                zza();
            } catch (Exception e2) {
                zzx.this.zza(e2, false, this.zzc);
                zzb();
            }
        }

        /* access modifiers changed from: package-private */
        public abstract void zza() throws RemoteException;

        /* access modifiers changed from: protected */
        public void zzb() {
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.3.0 */
    static class zzb extends zzr {
        private final zzhp zza;

        zzb(zzhp zzhp) {
            this.zza = zzhp;
        }

        public final int zza() {
            return System.identityHashCode(this.zza);
        }

        public final void zza(String str, String str2, Bundle bundle, long j) {
            this.zza.onEvent(str, str2, bundle, j);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.3.0 */
    static class zzc extends zzr {
        private final zzhq zza;

        zzc(zzhq zzhq) {
            this.zza = zzhq;
        }

        public final int zza() {
            return System.identityHashCode(this.zza);
        }

        public final void zza(String str, String str2, Bundle bundle, long j) {
            this.zza.interceptEvent(str, str2, bundle, j);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.3.0 */
    class zzd implements Application.ActivityLifecycleCallbacks {
        zzd() {
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
            zzx.this.zza((zza) new zzbc(this, activity, bundle));
        }

        public final void onActivityDestroyed(Activity activity) {
            zzx.this.zza((zza) new zzbh(this, activity));
        }

        public final void onActivityPaused(Activity activity) {
            zzx.this.zza((zza) new zzbg(this, activity));
        }

        public final void onActivityResumed(Activity activity) {
            zzx.this.zza((zza) new zzbd(this, activity));
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            zzk zzk = new zzk();
            zzx.this.zza((zza) new zzbi(this, activity, zzk));
            Bundle zzb = zzk.zzb(50);
            if (zzb != null) {
                bundle.putAll(zzb);
            }
        }

        public final void onActivityStarted(Activity activity) {
            zzx.this.zza((zza) new zzbe(this, activity));
        }

        public final void onActivityStopped(Activity activity) {
            zzx.this.zza((zza) new zzbf(this, activity));
        }
    }

    private zzx(Context context, String str, String str2, String str3, Bundle bundle) {
        if (str == null || !zzc(str2, str3)) {
            this.zzc = "FA";
        } else {
            this.zzc = str;
        }
        this.zza = DefaultClock.getInstance();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.zzd = threadPoolExecutor;
        this.zze = new AppMeasurementSdk(this);
        boolean z = false;
        if (!(!zzf(context) || zzk())) {
            this.zzq = null;
            this.zzp = true;
            Log.w(this.zzc, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
            return;
        }
        if (!zzc(str2, str3)) {
            this.zzq = "fa";
            if (str2 == null || str3 == null) {
                if ((str2 == null) ^ (str3 == null ? true : z)) {
                    Log.w(this.zzc, "Specified origin or custom app id is null. Both parameters will be ignored.");
                }
            } else {
                Log.v(this.zzc, "Deferring to Google Analytics for Firebase for event data collection. https://goo.gl/J1sWQy");
            }
        } else {
            this.zzq = str2;
        }
        zzaa zzaa = new zzaa(this, str2, str3, context, bundle);
        zza((zza) zzaa);
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            Log.w(this.zzc, "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new zzd());
        }
    }

    public static zzx zza(Context context) {
        return zza(context, (String) null, (String) null, (String) null, (Bundle) null);
    }

    public static zzx zza(Context context, String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotNull(context);
        if (zzb == null) {
            synchronized (zzx.class) {
                if (zzb == null) {
                    zzx zzx = new zzx(context, str, str2, str3, bundle);
                    zzb = zzx;
                }
            }
        }
        return zzb;
    }

    /* access modifiers changed from: private */
    public final void zza(zza zza2) {
        this.zzd.execute(zza2);
    }

    /* access modifiers changed from: private */
    public final void zza(Exception exc, boolean z, boolean z2) {
        this.zzp |= z;
        if (z) {
            Log.w(this.zzc, "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z2) {
            zza(5, "Error with data collection. Data lost.", (Object) exc, (Object) null, (Object) null);
        }
        Log.w(this.zzc, "Error with data collection. Data lost.", exc);
    }

    private final void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, Long l) {
        zzba zzba = new zzba(this, l, str, str2, bundle, z, z2);
        zza((zza) zzba);
    }

    private final void zza(String str, String str2, Object obj, boolean z) {
        zzaz zzaz = new zzaz(this, str, str2, obj, z);
        zza((zza) zzaz);
    }

    private static boolean zza(Context context, String str) {
        Preconditions.checkNotEmpty(str);
        try {
            ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                if (applicationInfo.metaData != null) {
                    return applicationInfo.metaData.getBoolean(str);
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException e2) {
            return false;
        }
    }

    public static boolean zzb(Context context) {
        zzi(context);
        synchronized (zzx.class) {
            if (!zzj) {
                try {
                    String str = (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke((Object) null, new Object[]{"measurement.dynamite.enabled", ""});
                    if (MistatsConstants.BaseEvent.VALUE_TRUE.equals(str)) {
                        zzk = true;
                    } else if (MistatsConstants.BaseEvent.VALUE_FALSE.equals(str)) {
                        zzk = false;
                    } else {
                        zzk = null;
                    }
                    zzj = true;
                } catch (Exception e2) {
                    try {
                        Log.e("FA", "Unable to call SystemProperties.get()", e2);
                        zzk = null;
                    } finally {
                        zzj = true;
                    }
                }
            }
        }
        Boolean bool = zzk;
        if (bool == null) {
            bool = zzh;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: private */
    public static boolean zzc(String str, String str2) {
        return (str2 == null || str == null || zzk()) ? false : true;
    }

    private static boolean zzf(Context context) {
        try {
            GoogleServices.initialize(context);
            return GoogleServices.getGoogleAppId() != null;
        } catch (IllegalStateException e2) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public static int zzg(Context context) {
        return DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID);
    }

    /* access modifiers changed from: private */
    public static int zzh(Context context) {
        return DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID);
    }

    /* access modifiers changed from: private */
    public static void zzi(Context context) {
        synchronized (zzx.class) {
            try {
                if (zzh != null && zzi != null) {
                    return;
                }
                if (zza(context, "app_measurement_internal_disable_startup_flags")) {
                    zzh = false;
                    zzi = false;
                    return;
                }
                SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
                zzh = Boolean.valueOf(sharedPreferences.getBoolean(zzl, false));
                zzi = Boolean.valueOf(sharedPreferences.getBoolean(zzm, false));
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.remove(zzl);
                edit.remove(zzm);
                edit.apply();
            } catch (Exception e2) {
                Log.e("FA", "Exception reading flag from SharedPreferences.", e2);
                zzh = false;
                zzi = false;
            }
        }
    }

    private static boolean zzk() {
        try {
            Class.forName("com.google.firebase.analytics.FirebaseAnalytics");
            return true;
        } catch (ClassNotFoundException e2) {
            return false;
        }
    }

    public final Bundle zza(Bundle bundle, boolean z) {
        zzk zzk2 = new zzk();
        zza((zza) new zzar(this, bundle, zzk2));
        if (z) {
            return zzk2.zzb(5000);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final zzm zza(Context context, boolean z) {
        DynamiteModule.VersionPolicy versionPolicy;
        if (z) {
            try {
                versionPolicy = DynamiteModule.PREFER_HIGHEST_OR_REMOTE_VERSION;
            } catch (DynamiteModule.LoadingException e2) {
                zza((Exception) e2, true, false);
                return null;
            }
        } else {
            versionPolicy = DynamiteModule.PREFER_LOCAL;
        }
        return zzl.asInterface(DynamiteModule.load(context, versionPolicy, ModuleDescriptor.MODULE_ID).instantiate("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
    }

    public final AppMeasurementSdk zza() {
        return this.zze;
    }

    public final Object zza(int i) {
        zzk zzk2 = new zzk();
        zza((zza) new zzav(this, zzk2, i));
        return zzk.zza(zzk2.zzb(15000), Object.class);
    }

    public final Map<String, Object> zza(String str, String str2, boolean z) {
        zzk zzk2 = new zzk();
        zzap zzap = new zzap(this, str, str2, z, zzk2);
        zza((zza) zzap);
        Bundle zzb2 = zzk2.zzb(5000);
        if (zzb2 == null || zzb2.size() == 0) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap(zzb2.size());
        for (String str3 : zzb2.keySet()) {
            Object obj = zzb2.get(str3);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                hashMap.put(str3, obj);
            }
        }
        return hashMap;
    }

    public final void zza(int i, String str, Object obj, Object obj2, Object obj3) {
        zzas zzas = new zzas(this, false, 5, str, obj, (Object) null, (Object) null);
        zza((zza) zzas);
    }

    public final void zza(long j) {
        zza((zza) new zzaf(this, j));
    }

    public final void zza(Activity activity, String str, String str2) {
        zza((zza) new zzae(this, activity, str, str2));
    }

    public final void zza(Bundle bundle) {
        zza((zza) new zzbb(this, bundle));
    }

    public final void zza(zzhp zzhp) {
        Preconditions.checkNotNull(zzhp);
        zza((zza) new zzaw(this, zzhp));
    }

    public final void zza(zzhq zzhq) {
        zza((zza) new zzaj(this, zzhq));
    }

    public final void zza(String str) {
        zza((zza) new zzab(this, str));
    }

    public final void zza(String str, Bundle bundle) {
        zza((String) null, str, bundle, false, true, (Long) null);
    }

    public final void zza(String str, String str2) {
        zza((String) null, str, (Object) str2, false);
    }

    public final void zza(String str, String str2, Bundle bundle) {
        zza(str, str2, bundle, true, true, (Long) null);
    }

    public final void zza(String str, String str2, Bundle bundle, long j) {
        zza(str, str2, bundle, true, false, Long.valueOf(j));
    }

    public final void zza(String str, String str2, Object obj) {
        zza(str, str2, obj, true);
    }

    public final void zza(boolean z) {
        zza((zza) new zzad(this, z));
    }

    public final List<Bundle> zzb(String str, String str2) {
        zzk zzk2 = new zzk();
        zza((zza) new zzac(this, str, str2, zzk2));
        List<Bundle> list = (List) zzk.zza(zzk2.zzb(5000), List.class);
        return list == null ? Collections.emptyList() : list;
    }

    public final void zzb() {
        zza((zza) new zzag(this));
    }

    public final void zzb(long j) {
        zza((zza) new zzai(this, j));
    }

    public final void zzb(zzhp zzhp) {
        Preconditions.checkNotNull(zzhp);
        zza((zza) new zzax(this, zzhp));
    }

    public final void zzb(String str) {
        zza((zza) new zzah(this, str));
    }

    public final void zzb(String str, String str2, Bundle bundle) {
        zza((zza) new zzz(this, str, str2, bundle));
    }

    public final void zzb(boolean z) {
        zza((zza) new zzay(this, z));
    }

    public final String zzc() {
        zzk zzk2 = new zzk();
        zza((zza) new zzam(this, zzk2));
        return zzk2.zza(500);
    }

    public final void zzc(String str) {
        zza((zza) new zzak(this, str));
    }

    public final int zzd(String str) {
        zzk zzk2 = new zzk();
        zza((zza) new zzau(this, str, zzk2));
        Integer num = (Integer) zzk.zza(zzk2.zzb(FunctionParseBeautyBodySlimCount.TIP_INTERVAL_TIME), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    public final String zzd() {
        zzk zzk2 = new zzk();
        zza((zza) new zzal(this, zzk2));
        return zzk2.zza(50);
    }

    public final long zze() {
        zzk zzk2 = new zzk();
        zza((zza) new zzao(this, zzk2));
        Long l = (Long) zzk.zza(zzk2.zzb(500), Long.class);
        if (l != null) {
            return l.longValue();
        }
        long nextLong = new Random(System.nanoTime() ^ this.zza.currentTimeMillis()).nextLong();
        int i = this.zzg + 1;
        this.zzg = i;
        return nextLong + ((long) i);
    }

    public final String zzf() {
        zzk zzk2 = new zzk();
        zza((zza) new zzan(this, zzk2));
        return zzk2.zza(500);
    }

    public final String zzg() {
        zzk zzk2 = new zzk();
        zza((zza) new zzaq(this, zzk2));
        return zzk2.zza(500);
    }

    public final String zzh() {
        zzk zzk2 = new zzk();
        zza((zza) new zzat(this, zzk2));
        return zzk2.zza(120000);
    }

    public final String zzi() {
        return this.zzq;
    }
}
