package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.3.0 */
final class zzbv extends ContentObserver {
    zzbv(Handler handler) {
        super((Handler) null);
    }

    public final void onChange(boolean z) {
        zzbw.zze.set(true);
    }
}
