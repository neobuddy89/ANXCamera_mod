package com.android.camera.fragment.fullscreen;

/* compiled from: lambda */
public final /* synthetic */ class h implements Runnable {
    private final /* synthetic */ FragmentFullScreen wb;

    public /* synthetic */ h(FragmentFullScreen fragmentFullScreen) {
        this.wb = fragmentFullScreen;
    }

    public final void run() {
        this.wb.runPendingTask();
    }
}
