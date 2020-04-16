package com.google.android.gms.measurement.module;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzv;
import com.google.android.gms.measurement.internal.zzgq;
import com.google.android.gms.measurement.internal.zzhl;
import com.google.android.gms.measurement.internal.zzho;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
public class Analytics {
    public static final String CRASH_ORIGIN = "crash";
    public static final String FCM_ORIGIN = "fcm";
    public static final String FIAM_ORIGIN = "fiam";
    private static volatile Analytics zza;
    private final zzgq zzb;

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
    public static final class Event extends zzhl {
        public static final String AD_REWARD = "_ar";
        public static final String APP_EXCEPTION = "_ae";

        private Event() {
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
    public static final class Param extends zzho {
        public static final String FATAL = "fatal";
        public static final String TIMESTAMP = "timestamp";
        public static final String TYPE = "type";

        private Param() {
        }
    }

    private Analytics(zzgq zzgq) {
        Preconditions.checkNotNull(zzgq);
        this.zzb = zzgq;
    }

    public static Analytics getInstance(Context context) {
        if (zza == null) {
            synchronized (Analytics.class) {
                if (zza == null) {
                    zza = new Analytics(zzgq.zza(context, (zzv) null));
                }
            }
        }
        return zza;
    }
}
