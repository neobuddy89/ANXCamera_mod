package com.android.camera.fragment.fullscreen;

/* compiled from: lambda */
public final /* synthetic */ class a implements Runnable {
    private final /* synthetic */ FragmentFullScreen wb;

    public /* synthetic */ a(FragmentFullScreen fragmentFullScreen) {
        this.wb = fragmentFullScreen;
    }

    public final void run() {
        this.wb.startConcatVideoIfNeed();
    }
}
