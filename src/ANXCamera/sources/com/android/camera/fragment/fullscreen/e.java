package com.android.camera.fragment.fullscreen;

/* compiled from: lambda */
public final /* synthetic */ class e implements Runnable {
    private final /* synthetic */ FragmentFullScreen wb;

    public /* synthetic */ e(FragmentFullScreen fragmentFullScreen) {
        this.wb = fragmentFullScreen;
    }

    public final void run() {
        this.wb.startCombine();
    }
}
