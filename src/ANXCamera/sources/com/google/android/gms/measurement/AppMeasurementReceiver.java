package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.zzgg;
import com.google.android.gms.measurement.internal.zzgh;

/* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
public final class AppMeasurementReceiver extends WakefulBroadcastReceiver implements zzgh {
    private zzgg zza;

    public final BroadcastReceiver.PendingResult doGoAsync() {
        return goAsync();
    }

    public final void doStartService(Context context, Intent intent) {
        startWakefulService(context, intent);
    }

    public final void onReceive(Context context, Intent intent) {
        if (this.zza == null) {
            this.zza = new zzgg(this);
        }
        this.zza.zza(context, intent);
    }
}
