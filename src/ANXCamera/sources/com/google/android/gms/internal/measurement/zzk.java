package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.util.Log;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.3.0 */
public final class zzk extends zzq {
    private final AtomicReference<Bundle> zza = new AtomicReference<>();
    private boolean zzb;

    public static <T> T zza(Bundle bundle, Class<T> cls) {
        if (bundle == null) {
            return null;
        }
        Object obj = bundle.get("r");
        if (obj == null) {
            return null;
        }
        try {
            return cls.cast(obj);
        } catch (ClassCastException e2) {
            String canonicalName = cls.getCanonicalName();
            String canonicalName2 = obj.getClass().getCanonicalName();
            Log.w("AM", String.format(String.valueOf("Unexpected object type. Expected, Received").concat(": %s, %s"), new Object[]{canonicalName, canonicalName2}), e2);
            throw e2;
        }
    }

    public final String zza(long j) {
        return (String) zza(zzb(j), String.class);
    }

    public final void zza(Bundle bundle) {
        synchronized (this.zza) {
            try {
                this.zza.set(bundle);
                this.zzb = true;
                this.zza.notify();
            } catch (Throwable th) {
                this.zza.notify();
                throw th;
            }
        }
    }

    public final Bundle zzb(long j) {
        Bundle bundle;
        synchronized (this.zza) {
            if (!this.zzb) {
                try {
                    this.zza.wait(j);
                } catch (InterruptedException e2) {
                    return null;
                }
            }
            bundle = this.zza.get();
        }
        return bundle;
    }
}
