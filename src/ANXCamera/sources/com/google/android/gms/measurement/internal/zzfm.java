package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
final class zzfm implements Runnable {
    private final /* synthetic */ int zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ Object zzc;
    private final /* synthetic */ Object zzd;
    private final /* synthetic */ Object zze;
    private final /* synthetic */ zzfj zzf;

    zzfm(zzfj zzfj, int i, String str, Object obj, Object obj2, Object obj3) {
        this.zzf = zzfj;
        this.zza = i;
        this.zzb = str;
        this.zzc = obj;
        this.zzd = obj2;
        this.zze = obj3;
    }

    public final void run() {
        zzfv zzc2 = this.zzf.zzx.zzc();
        if (zzc2.zzz()) {
            if (this.zzf.zza == 0) {
                if (this.zzf.zzt().zzg()) {
                    zzfj zzfj = this.zzf;
                    zzfj.zzu();
                    char unused = zzfj.zza = 'C';
                } else {
                    zzfj zzfj2 = this.zzf;
                    zzfj2.zzu();
                    char unused2 = zzfj2.zza = 'c';
                }
            }
            if (this.zzf.zzb < 0) {
                zzfj zzfj3 = this.zzf;
                long unused3 = zzfj3.zzb = zzfj3.zzt().zzf();
            }
            char charAt = "01VDIWEA?".charAt(this.zza);
            char zza2 = this.zzf.zza;
            long zzb2 = this.zzf.zzb;
            String zza3 = zzfj.zza(true, this.zzb, this.zzc, this.zzd, this.zze);
            StringBuilder sb = new StringBuilder(String.valueOf(zza3).length() + 24);
            sb.append("2");
            sb.append(charAt);
            sb.append(zza2);
            sb.append(zzb2);
            sb.append(":");
            sb.append(zza3);
            String sb2 = sb.toString();
            if (sb2.length() > 1024) {
                sb2 = this.zzb.substring(0, 1024);
            }
            zzc2.zzb.zza(sb2, 1);
            return;
        }
        this.zzf.zza(6, "Persisted config not initialized. Not logging error/warn");
    }
}
