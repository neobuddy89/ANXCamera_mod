package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzl;
import com.google.android.gms.internal.measurement.zzn;
import com.google.android.gms.internal.measurement.zzs;
import com.google.android.gms.internal.measurement.zzt;
import com.google.android.gms.internal.measurement.zzv;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.3.0 */
public class AppMeasurementDynamiteService extends zzl {
    zzgq zza = null;
    private Map<Integer, zzhp> zzb = new ArrayMap();

    /* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.3.0 */
    class zza implements zzhq {
        private zzs zza;

        zza(zzs zzs) {
            this.zza = zzs;
        }

        public final void interceptEvent(String str, String str2, Bundle bundle, long j) {
            try {
                this.zza.zza(str, str2, bundle, j);
            } catch (RemoteException e2) {
                AppMeasurementDynamiteService.this.zza.zzr().zzi().zza("Event interceptor threw exception", e2);
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.3.0 */
    class zzb implements zzhp {
        private zzs zza;

        zzb(zzs zzs) {
            this.zza = zzs;
        }

        public final void onEvent(String str, String str2, Bundle bundle, long j) {
            try {
                this.zza.zza(str, str2, bundle, j);
            } catch (RemoteException e2) {
                AppMeasurementDynamiteService.this.zza.zzr().zzi().zza("Event listener threw exception", e2);
            }
        }
    }

    private final void zza() {
        if (this.zza == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    private final void zza(zzn zzn, String str) {
        this.zza.zzi().zza(zzn, str);
    }

    public void beginAdUnitExposure(String str, long j) throws RemoteException {
        zza();
        this.zza.zzz().zza(str, j);
    }

    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        zza();
        this.zza.zzh().zzc(str, str2, bundle);
    }

    public void endAdUnitExposure(String str, long j) throws RemoteException {
        zza();
        this.zza.zzz().zzb(str, j);
    }

    public void generateEventId(zzn zzn) throws RemoteException {
        zza();
        this.zza.zzi().zza(zzn, this.zza.zzi().zzg());
    }

    public void getAppInstanceId(zzn zzn) throws RemoteException {
        zza();
        this.zza.zzq().zza((Runnable) new zzi(this, zzn));
    }

    public void getCachedAppInstanceId(zzn zzn) throws RemoteException {
        zza();
        zza(zzn, this.zza.zzh().zzah());
    }

    public void getConditionalUserProperties(String str, String str2, zzn zzn) throws RemoteException {
        zza();
        this.zza.zzq().zza((Runnable) new zzj(this, zzn, str, str2));
    }

    public void getCurrentScreenClass(zzn zzn) throws RemoteException {
        zza();
        zza(zzn, this.zza.zzh().zzak());
    }

    public void getCurrentScreenName(zzn zzn) throws RemoteException {
        zza();
        zza(zzn, this.zza.zzh().zzaj());
    }

    public void getGmpAppId(zzn zzn) throws RemoteException {
        zza();
        zza(zzn, this.zza.zzh().zzal());
    }

    public void getMaxUserProperties(String str, zzn zzn) throws RemoteException {
        zza();
        this.zza.zzh();
        Preconditions.checkNotEmpty(str);
        this.zza.zzi().zza(zzn, 25);
    }

    public void getTestFlag(zzn zzn, int i) throws RemoteException {
        zza();
        if (i == 0) {
            this.zza.zzi().zza(zzn, this.zza.zzh().zzad());
        } else if (i == 1) {
            this.zza.zzi().zza(zzn, this.zza.zzh().zzae().longValue());
        } else if (i == 2) {
            zzla zzi = this.zza.zzi();
            double doubleValue = this.zza.zzh().zzag().doubleValue();
            Bundle bundle = new Bundle();
            bundle.putDouble("r", doubleValue);
            try {
                zzn.zza(bundle);
            } catch (RemoteException e2) {
                zzi.zzx.zzr().zzi().zza("Error returning double value to wrapper", e2);
            }
        } else if (i == 3) {
            this.zza.zzi().zza(zzn, this.zza.zzh().zzaf().intValue());
        } else if (i == 4) {
            this.zza.zzi().zza(zzn, this.zza.zzh().zzac().booleanValue());
        }
    }

    public void getUserProperties(String str, String str2, boolean z, zzn zzn) throws RemoteException {
        zza();
        zzgj zzq = this.zza.zzq();
        zzk zzk = new zzk(this, zzn, str, str2, z);
        zzq.zza((Runnable) zzk);
    }

    public void initForTests(Map map) throws RemoteException {
        zza();
    }

    public void initialize(IObjectWrapper iObjectWrapper, zzv zzv, long j) throws RemoteException {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzgq zzgq = this.zza;
        if (zzgq == null) {
            this.zza = zzgq.zza(context, zzv);
        } else {
            zzgq.zzr().zzi().zza("Attempting to initialize multiple times");
        }
    }

    public void isDataCollectionEnabled(zzn zzn) throws RemoteException {
        zza();
        this.zza.zzq().zza((Runnable) new zzl(this, zzn));
    }

    public void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        zza();
        this.zza.zzh().zza(str, str2, bundle, z, z2, j);
    }

    public void logEventAndBundle(String str, String str2, Bundle bundle, zzn zzn, long j) throws RemoteException {
        Bundle bundle2;
        zza();
        Preconditions.checkNotEmpty(str2);
        if (bundle != null) {
            bundle2 = new Bundle(bundle);
        } else {
            bundle2 = new Bundle();
        }
        bundle2.putString("_o", "app");
        zzan zzan = new zzan(str2, new zzam(bundle), "app", j);
        this.zza.zzq().zza((Runnable) new zzh(this, zzn, zzan, str));
    }

    public void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        zza();
        Object obj = null;
        Object unwrap = iObjectWrapper == null ? null : ObjectWrapper.unwrap(iObjectWrapper);
        Object unwrap2 = iObjectWrapper2 == null ? null : ObjectWrapper.unwrap(iObjectWrapper2);
        if (iObjectWrapper3 != null) {
            obj = ObjectWrapper.unwrap(iObjectWrapper3);
        }
        this.zza.zzr().zza(i, true, false, str, unwrap, unwrap2, obj);
    }

    public void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) throws RemoteException {
        zza();
        zzio zzio = this.zza.zzh().zza;
        if (zzio != null) {
            this.zza.zzh().zzab();
            zzio.onActivityCreated((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
    }

    public void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzio zzio = this.zza.zzh().zza;
        if (zzio != null) {
            this.zza.zzh().zzab();
            zzio.onActivityDestroyed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivityPaused(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzio zzio = this.zza.zzh().zza;
        if (zzio != null) {
            this.zza.zzh().zzab();
            zzio.onActivityPaused((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivityResumed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzio zzio = this.zza.zzh().zza;
        if (zzio != null) {
            this.zza.zzh().zzab();
            zzio.onActivityResumed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzn zzn, long j) throws RemoteException {
        zza();
        zzio zzio = this.zza.zzh().zza;
        Bundle bundle = new Bundle();
        if (zzio != null) {
            this.zza.zzh().zzab();
            zzio.onActivitySaveInstanceState((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
        try {
            zzn.zza(bundle);
        } catch (RemoteException e2) {
            this.zza.zzr().zzi().zza("Error returning bundle value to wrapper", e2);
        }
    }

    public void onActivityStarted(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzio zzio = this.zza.zzh().zza;
        if (zzio != null) {
            this.zza.zzh().zzab();
            zzio.onActivityStarted((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivityStopped(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzio zzio = this.zza.zzh().zza;
        if (zzio != null) {
            this.zza.zzh().zzab();
            zzio.onActivityStopped((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void performAction(Bundle bundle, zzn zzn, long j) throws RemoteException {
        zza();
        zzn.zza((Bundle) null);
    }

    public void registerOnMeasurementEventListener(zzs zzs) throws RemoteException {
        zza();
        zzhp zzhp = this.zzb.get(Integer.valueOf(zzs.zza()));
        if (zzhp == null) {
            zzhp = new zzb(zzs);
            this.zzb.put(Integer.valueOf(zzs.zza()), zzhp);
        }
        this.zza.zzh().zza(zzhp);
    }

    public void resetAnalyticsData(long j) throws RemoteException {
        zza();
        this.zza.zzh().zzd(j);
    }

    public void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException {
        zza();
        if (bundle == null) {
            this.zza.zzr().zzf().zza("Conditional user property must not be null");
        } else {
            this.zza.zzh().zza(bundle, j);
        }
    }

    public void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j) throws RemoteException {
        zza();
        this.zza.zzv().zza((Activity) ObjectWrapper.unwrap(iObjectWrapper), str, str2);
    }

    public void setDataCollectionEnabled(boolean z) throws RemoteException {
        zza();
        this.zza.zzh().zzb(z);
    }

    public void setEventInterceptor(zzs zzs) throws RemoteException {
        zza();
        zzhr zzh = this.zza.zzh();
        zza zza2 = new zza(zzs);
        zzh.zzb();
        zzh.zzw();
        zzh.zzq().zza((Runnable) new zzhz(zzh, zza2));
    }

    public void setInstanceIdProvider(zzt zzt) throws RemoteException {
        zza();
    }

    public void setMeasurementEnabled(boolean z, long j) throws RemoteException {
        zza();
        this.zza.zzh().zza(z);
    }

    public void setMinimumSessionDuration(long j) throws RemoteException {
        zza();
        this.zza.zzh().zza(j);
    }

    public void setSessionTimeoutDuration(long j) throws RemoteException {
        zza();
        this.zza.zzh().zzb(j);
    }

    public void setUserId(String str, long j) throws RemoteException {
        zza();
        this.zza.zzh().zza((String) null, "_id", str, true, j);
    }

    public void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) throws RemoteException {
        zza();
        this.zza.zzh().zza(str, str2, ObjectWrapper.unwrap(iObjectWrapper), z, j);
    }

    public void unregisterOnMeasurementEventListener(zzs zzs) throws RemoteException {
        zza();
        zzhp remove = this.zzb.remove(Integer.valueOf(zzs.zza()));
        if (remove == null) {
            remove = new zzb(zzs);
        }
        this.zza.zzh().zzb(remove);
    }
}
