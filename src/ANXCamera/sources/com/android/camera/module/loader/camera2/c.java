package com.android.camera.module.loader.camera2;

import com.android.camera2.Camera2Proxy;

/* compiled from: lambda */
public final /* synthetic */ class c implements Camera2Proxy.CaptureBusyCallback {
    private final /* synthetic */ boolean Ab;
    private final /* synthetic */ Camera2OpenManager wb;

    public /* synthetic */ c(Camera2OpenManager camera2OpenManager, boolean z) {
        this.wb = camera2OpenManager;
        this.Ab = z;
    }

    public final void onCaptureCompleted(boolean z) {
        this.wb.c(this.Ab, z);
    }
}
