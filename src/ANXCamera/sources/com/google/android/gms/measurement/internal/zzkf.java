package com.google.android.gms.measurement.internal;

import com.android.camera.fragment.top.FragmentTopAlert;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
final class zzkf {
    final /* synthetic */ zzke zza;
    private zzki zzb;

    zzkf(zzke zzke) {
        this.zza = zzke;
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        this.zza.zzd();
        if (this.zza.zzt().zza(zzap.zzci) && this.zzb != null) {
            this.zza.zzc.removeCallbacks(this.zzb);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb() {
        if (this.zza.zzt().zza(zzap.zzci)) {
            this.zzb = new zzki(this, this.zza.zzm().currentTimeMillis());
            this.zza.zzc.postDelayed(this.zzb, FragmentTopAlert.HINT_DELAY_TIME);
        }
    }
}
