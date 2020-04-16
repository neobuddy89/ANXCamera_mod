package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.3.0 */
final class zzhj extends zzhp {
    private final /* synthetic */ zzhi zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzhj(zzhi zzhi) {
        super(zzhi, (zzhh) null);
        this.zza = zzhi;
    }

    /* synthetic */ zzhj(zzhi zzhi, zzhh zzhh) {
        this(zzhi);
    }

    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzhk(this.zza, (zzhh) null);
    }
}
