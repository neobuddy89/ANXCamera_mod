package com.android.camera.fragment.fullscreen;

/* compiled from: lambda */
public final /* synthetic */ class d implements Runnable {
    private final /* synthetic */ FragmentFullScreen wb;

    public /* synthetic */ d(FragmentFullScreen fragmentFullScreen) {
        this.wb = fragmentFullScreen;
    }

    public final void run() {
        this.wb.showExitConfirm();
    }
}
