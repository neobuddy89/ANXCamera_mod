package com.android.camera.module;

/* compiled from: lambda */
public final /* synthetic */ class J implements Runnable {
    private final /* synthetic */ Camera2Module wb;

    public /* synthetic */ J(Camera2Module camera2Module) {
        this.wb = camera2Module;
    }

    public final void run() {
        this.wb.restartModule();
    }
}
