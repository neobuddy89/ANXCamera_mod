package com.android.camera;

/* compiled from: lambda */
public final /* synthetic */ class d implements Runnable {
    private final /* synthetic */ CameraPreferenceActivity wb;

    public /* synthetic */ d(CameraPreferenceActivity cameraPreferenceActivity) {
        this.wb = cameraPreferenceActivity;
    }

    public final void run() {
        this.wb.restorePreferences();
    }
}
