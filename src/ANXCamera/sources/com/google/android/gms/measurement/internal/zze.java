package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
abstract class zze extends zzf {
    private boolean zza;

    zze(zzgq zzgq) {
        super(zzgq);
        this.zzx.zza(this);
    }

    /* access modifiers changed from: protected */
    public void zzaa() {
    }

    /* access modifiers changed from: package-private */
    public final boolean zzv() {
        return this.zza;
    }

    /* access modifiers changed from: protected */
    public final void zzw() {
        if (!zzv()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzx() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!zzz()) {
            this.zzx.zzag();
            this.zza = true;
        }
    }

    public final void zzy() {
        if (!this.zza) {
            zzaa();
            this.zzx.zzag();
            this.zza = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    /* access modifiers changed from: protected */
    public abstract boolean zzz();
}
