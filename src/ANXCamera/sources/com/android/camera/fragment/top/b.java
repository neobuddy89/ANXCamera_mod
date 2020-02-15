package com.android.camera.fragment.top;

import com.android.camera.statistic.CameraStatUtils;

/* compiled from: lambda */
public final /* synthetic */ class b implements Runnable {
    public static final /* synthetic */ b INSTANCE = new b();

    private /* synthetic */ b() {
    }

    public final void run() {
        CameraStatUtils.trackLyingDirectShow(0);
    }
}
