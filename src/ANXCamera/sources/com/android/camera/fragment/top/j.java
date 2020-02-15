package com.android.camera.fragment.top;

/* compiled from: lambda */
public final /* synthetic */ class j implements Runnable {
    private final /* synthetic */ boolean Ab;
    private final /* synthetic */ FragmentTopConfig wb;

    public /* synthetic */ j(FragmentTopConfig fragmentTopConfig, boolean z) {
        this.wb = fragmentTopConfig;
        this.Ab = z;
    }

    public final void run() {
        this.wb.k(this.Ab);
    }
}
