package com.android.camera.module;

/* compiled from: lambda */
public final /* synthetic */ class I implements Runnable {
    private final /* synthetic */ Camera2Module wb;

    public /* synthetic */ I(Camera2Module camera2Module) {
        this.wb = camera2Module;
    }

    public final void run() {
        this.wb.handlePendingScreenSlide();
    }
}
