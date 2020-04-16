package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzv;
import com.google.android.gms.measurement.internal.zzkb;

/* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
public final class zzjx<T extends Context & zzkb> {
    private final T zza;

    public zzjx(T t) {
        Preconditions.checkNotNull(t);
        this.zza = t;
    }

    private final void zza(Runnable runnable) {
        zzks zza2 = zzks.zza((Context) this.zza);
        zza2.zzq().zza((Runnable) new zzkc(this, zza2, runnable));
    }

    private final zzfj zzc() {
        return zzgq.zza((Context) this.zza, (zzv) null).zzr();
    }

    public final int zza(Intent intent, int i, int i2) {
        zzgq zza2 = zzgq.zza((Context) this.zza, (zzv) null);
        zzfj zzr = zza2.zzr();
        if (intent == null) {
            zzr.zzi().zza("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        zza2.zzu();
        zzr.zzx().zza("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            zza((Runnable) new zzka(this, i2, zzr, intent));
        }
        return 2;
    }

    public final IBinder zza(Intent intent) {
        if (intent == null) {
            zzc().zzf().zza("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new zzgr(zzks.zza((Context) this.zza));
        }
        zzc().zzi().zza("onBind received unknown action", action);
        return null;
    }

    public final void zza() {
        zzgq zza2 = zzgq.zza((Context) this.zza, (zzv) null);
        zzfj zzr = zza2.zzr();
        zza2.zzu();
        zzr.zzx().zza("Local AppMeasurementService is starting up");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(int i, zzfj zzfj, Intent intent) {
        if (((zzkb) this.zza).zza(i)) {
            zzfj.zzx().zza("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i));
            zzc().zzx().zza("Completed wakeful intent.");
            ((zzkb) this.zza).zza(intent);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzfj zzfj, JobParameters jobParameters) {
        zzfj.zzx().zza("AppMeasurementJobService processed last upload request.");
        ((zzkb) this.zza).zza(jobParameters, false);
    }

    public final boolean zza(JobParameters jobParameters) {
        zzgq zza2 = zzgq.zza((Context) this.zza, (zzv) null);
        zzfj zzr = zza2.zzr();
        String string = jobParameters.getExtras().getString("action");
        zza2.zzu();
        zzr.zzx().zza("Local AppMeasurementJobService called. action", string);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) {
            return true;
        }
        zza((Runnable) new zzjz(this, zzr, jobParameters));
        return true;
    }

    public final void zzb() {
        zzgq zza2 = zzgq.zza((Context) this.zza, (zzv) null);
        zzfj zzr = zza2.zzr();
        zza2.zzu();
        zzr.zzx().zza("Local AppMeasurementService is shutting down");
    }

    public final boolean zzb(Intent intent) {
        if (intent == null) {
            zzc().zzf().zza("onUnbind called with null intent");
            return true;
        }
        zzc().zzx().zza("onUnbind called for intent. action", intent.getAction());
        return true;
    }

    public final void zzc(Intent intent) {
        if (intent == null) {
            zzc().zzf().zza("onRebind called with null intent");
            return;
        }
        zzc().zzx().zza("onRebind called. action", intent.getAction());
    }
}
