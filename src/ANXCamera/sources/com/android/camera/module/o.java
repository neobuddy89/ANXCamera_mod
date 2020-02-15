package com.android.camera.module;

/* compiled from: lambda */
public final /* synthetic */ class o implements Runnable {
    private final /* synthetic */ boolean Ab;
    private final /* synthetic */ Camera2Module wb;

    public /* synthetic */ o(Camera2Module camera2Module, boolean z) {
        this.wb = camera2Module;
        this.Ab = z;
    }

    public final void run() {
        this.wb.q(this.Ab);
    }
}
