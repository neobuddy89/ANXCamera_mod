package com.android.camera;

/* compiled from: lambda */
public final /* synthetic */ class e implements Runnable {
    private final /* synthetic */ CameraPreferenceActivity wb;

    public /* synthetic */ e(CameraPreferenceActivity cameraPreferenceActivity) {
        this.wb = cameraPreferenceActivity;
    }

    public final void run() {
        this.wb.installQRCodeReceiver();
    }
}
