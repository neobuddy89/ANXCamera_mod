package com.android.camera.module.impl.component;

import com.android.camera.module.Camera2Module;

/* compiled from: lambda */
public final /* synthetic */ class u implements Runnable {
    private final /* synthetic */ boolean Ab;
    private final /* synthetic */ int Bb;
    private final /* synthetic */ Camera2Module wb;

    public /* synthetic */ u(Camera2Module camera2Module, boolean z, int i) {
        this.wb = camera2Module;
        this.Ab = z;
        this.Bb = i;
    }

    public final void run() {
        MiAsdDetectImpl.a(this.wb, this.Ab, this.Bb);
    }
}
