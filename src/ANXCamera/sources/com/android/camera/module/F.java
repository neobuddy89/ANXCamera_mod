package com.android.camera.module;

/* compiled from: lambda */
public final /* synthetic */ class F implements Runnable {
    private final /* synthetic */ boolean Ab;
    private final /* synthetic */ VideoModule wb;

    public /* synthetic */ F(VideoModule videoModule, boolean z) {
        this.wb = videoModule;
        this.Ab = z;
    }

    public final void run() {
        this.wb.r(this.Ab);
    }
}
