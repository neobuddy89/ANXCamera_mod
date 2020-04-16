package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzn;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
final class zzjq implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzm zzc;
    private final /* synthetic */ zzn zzd;
    private final /* synthetic */ zziz zze;

    zzjq(zziz zziz, String str, String str2, zzm zzm, zzn zzn) {
        this.zze = zziz;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzm;
        this.zzd = zzn;
    }

    public final void run() {
        ArrayList<Bundle> arrayList = new ArrayList<>();
        try {
            zzfb zzd2 = this.zze.zzb;
            if (zzd2 == null) {
                this.zze.zzr().zzf().zza("Failed to get conditional properties; not connected to service", this.zza, this.zzb);
                return;
            }
            arrayList = zzla.zzb(zzd2.zza(this.zza, this.zzb, this.zzc));
            this.zze.zzak();
            this.zze.zzp().zza(this.zzd, arrayList);
        } catch (RemoteException e2) {
            this.zze.zzr().zzf().zza("Failed to get conditional properties; remote exception", this.zza, this.zzb, e2);
        } finally {
            this.zze.zzp().zza(this.zzd, arrayList);
        }
    }
}
