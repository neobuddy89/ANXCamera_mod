package com.android.camera.module;

import com.android.camera2.CameraHardwareFace;

/* compiled from: lambda */
public final /* synthetic */ class r implements Runnable {
    private final /* synthetic */ CameraHardwareFace[] Ab;
    private final /* synthetic */ Camera2Module wb;

    public /* synthetic */ r(Camera2Module camera2Module, CameraHardwareFace[] cameraHardwareFaceArr) {
        this.wb = camera2Module;
        this.Ab = cameraHardwareFaceArr;
    }

    public final void run() {
        this.wb.a(this.Ab);
    }
}
