package com.android.camera.scene;

import com.android.camera.module.Camera2Module;

/* compiled from: lambda */
public final /* synthetic */ class c implements Runnable {
    private final /* synthetic */ Camera2Module wb;

    public /* synthetic */ c(Camera2Module camera2Module) {
        this.wb = camera2Module;
    }

    public final void run() {
        this.wb.showBacklightTip();
    }
}
