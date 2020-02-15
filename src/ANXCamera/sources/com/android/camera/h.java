package com.android.camera;

/* compiled from: lambda */
public final /* synthetic */ class h implements Runnable {
    private final /* synthetic */ Camera wb;

    public /* synthetic */ h(Camera camera) {
        this.wb = camera;
    }

    public final void run() {
        this.wb.showGuide();
    }
}
