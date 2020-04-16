package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.internal.measurement.zzx;
import com.google.android.gms.measurement.internal.zzhp;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.3.0 */
final class zzaw extends zzx.zza {
    private final /* synthetic */ zzhp zzc;
    private final /* synthetic */ zzx zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzaw(zzx zzx, zzhp zzhp) {
        super(zzx);
        this.zzd = zzx;
        this.zzc = zzhp;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        for (int i = 0; i < this.zzd.zzf.size(); i++) {
            if (this.zzc.equals(((Pair) this.zzd.zzf.get(i)).first)) {
                Log.w(this.zzd.zzc, "OnEventListener already registered.");
                return;
            }
        }
        zzx.zzb zzb = new zzx.zzb(this.zzc);
        this.zzd.zzf.add(new Pair(this.zzc, zzb));
        this.zzd.zzr.registerOnMeasurementEventListener(zzb);
    }
}
