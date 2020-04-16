package com.google.android.gms.common.api.internal;

import android.app.Activity;

public abstract class ActivityLifecycleObserver {
    public static final ActivityLifecycleObserver of(Activity activity) {
        return new zaa(activity);
    }

    public abstract ActivityLifecycleObserver onStopCallOnce(Runnable runnable);
}
