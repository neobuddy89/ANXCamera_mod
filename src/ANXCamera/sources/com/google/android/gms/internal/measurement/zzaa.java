package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzx;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.3.0 */
final class zzaa extends zzx.zza {
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ Context zze;
    private final /* synthetic */ Bundle zzf;
    private final /* synthetic */ zzx zzg;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzaa(zzx zzx, String str, String str2, Context context, Bundle bundle) {
        super(zzx);
        this.zzg = zzx;
        this.zzc = str;
        this.zzd = str2;
        this.zze = context;
        this.zzf = bundle;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0057 A[Catch:{ Exception -> 0x00a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0063 A[Catch:{ Exception -> 0x00a3 }] */
    public final void zza() {
        String str;
        String str2;
        String str3;
        boolean z;
        boolean z2;
        int i;
        try {
            List unused = this.zzg.zzf = new ArrayList();
            if (zzx.zzc(this.zzc, this.zzd)) {
                String str4 = this.zzd;
                str2 = this.zzc;
                str = str4;
                str3 = this.zzg.zzc;
            } else {
                str3 = null;
                str2 = null;
                str = null;
            }
            zzx.zzi(this.zze);
            if (!zzx.zzi.booleanValue()) {
                if (str2 == null) {
                    z = false;
                    zzm unused2 = this.zzg.zzr = this.zzg.zza(this.zze, z);
                    if (this.zzg.zzr != null) {
                        Log.w(this.zzg.zzc, "Failed to connect to measurement client.");
                        return;
                    }
                    int zzd2 = zzx.zzh(this.zze);
                    int zze2 = zzx.zzg(this.zze);
                    if (z) {
                        i = Math.max(zzd2, zze2);
                        z2 = zze2 < zzd2;
                    } else {
                        if (zzd2 > 0) {
                            zze2 = zzd2;
                        }
                        z2 = zzd2 > 0;
                        i = zze2;
                    }
                    zzv zzv = new zzv(25001, (long) i, z2, str3, str2, str, this.zzf);
                    this.zzg.zzr.initialize(ObjectWrapper.wrap(this.zze), zzv, this.zza);
                    return;
                }
            }
            z = true;
            zzm unused3 = this.zzg.zzr = this.zzg.zza(this.zze, z);
            if (this.zzg.zzr != null) {
            }
        } catch (Exception e2) {
            this.zzg.zza(e2, true, false);
        }
    }
}
