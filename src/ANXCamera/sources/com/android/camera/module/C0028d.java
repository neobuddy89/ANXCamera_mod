package com.android.camera.module;

import com.android.camera2.Camera2Proxy;

/* renamed from: com.android.camera.module.d  reason: case insensitive filesystem */
/* compiled from: lambda */
public final /* synthetic */ class C0028d implements Camera2Proxy.CaptureCallback {
    private final /* synthetic */ Camera2Module wb;

    public /* synthetic */ C0028d(Camera2Module camera2Module) {
        this.wb = camera2Module;
    }

    public final void onCaptureCompleted(boolean z) {
        this.wb.o(z);
    }
}
