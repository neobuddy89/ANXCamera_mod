package com.google.android.gms.internal.measurement;

import android.os.Binder;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
public final /* synthetic */ class zzce {
    public static <V> V zza(zzcd<V> zzcd) {
        long clearCallingIdentity;
        try {
            return zzcd.zza();
        } catch (SecurityException e2) {
            clearCallingIdentity = Binder.clearCallingIdentity();
            V zza = zzcd.zza();
            Binder.restoreCallingIdentity(clearCallingIdentity);
            return zza;
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(clearCallingIdentity);
            throw th;
        }
    }
}
