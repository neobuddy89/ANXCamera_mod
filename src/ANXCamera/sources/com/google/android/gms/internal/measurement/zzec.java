package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.3.0 */
final class zzec {
    private final zzen zza;
    private final byte[] zzb;

    private zzec(int i) {
        byte[] bArr = new byte[i];
        this.zzb = bArr;
        this.zza = zzen.zza(bArr);
    }

    /* synthetic */ zzec(int i, zzdx zzdx) {
        this(i);
    }

    public final zzdu zza() {
        this.zza.zzb();
        return new zzee(this.zzb);
    }

    public final zzen zzb() {
        return this.zza;
    }
}
