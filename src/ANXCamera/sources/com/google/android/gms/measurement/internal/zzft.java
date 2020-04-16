package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
class zzft extends BroadcastReceiver {
    private static final String zza = zzft.class.getName();
    /* access modifiers changed from: private */
    public final zzks zzb;
    private boolean zzc;
    private boolean zzd;

    zzft(zzks zzks) {
        Preconditions.checkNotNull(zzks);
        this.zzb = zzks;
    }

    public void onReceive(Context context, Intent intent) {
        this.zzb.zzk();
        String action = intent.getAction();
        this.zzb.zzr().zzx().zza("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean zzf = this.zzb.zzd().zzf();
            if (this.zzd != zzf) {
                this.zzd = zzf;
                this.zzb.zzq().zza((Runnable) new zzfw(this, zzf));
                return;
            }
            return;
        }
        this.zzb.zzr().zzi().zza("NetworkBroadcastReceiver received unknown action", action);
    }

    public final void zza() {
        this.zzb.zzk();
        this.zzb.zzq().zzd();
        if (!this.zzc) {
            this.zzb.zzn().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.zzd = this.zzb.zzd().zzf();
            this.zzb.zzr().zzx().zza("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.zzd));
            this.zzc = true;
        }
    }

    public final void zzb() {
        this.zzb.zzk();
        this.zzb.zzq().zzd();
        this.zzb.zzq().zzd();
        if (this.zzc) {
            this.zzb.zzr().zzx().zza("Unregistering connectivity change receiver");
            this.zzc = false;
            this.zzd = false;
            try {
                this.zzb.zzn().unregisterReceiver(this);
            } catch (IllegalArgumentException e2) {
                this.zzb.zzr().zzf().zza("Failed to unregister the network broadcast receiver", e2);
            }
        }
    }
}
