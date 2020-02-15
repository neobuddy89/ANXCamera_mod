package com.android.camera.fragment;

/* compiled from: lambda */
public final /* synthetic */ class f implements Runnable {
    private final /* synthetic */ boolean Ab;
    private final /* synthetic */ FragmentMainContent wb;

    public /* synthetic */ f(FragmentMainContent fragmentMainContent, boolean z) {
        this.wb = fragmentMainContent;
        this.Ab = z;
    }

    public final void run() {
        this.wb.j(this.Ab);
    }
}
