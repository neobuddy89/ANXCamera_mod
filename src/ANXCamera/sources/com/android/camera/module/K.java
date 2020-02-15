package com.android.camera.module;

/* compiled from: lambda */
public final /* synthetic */ class K implements Runnable {
    private final /* synthetic */ BaseModule wb;

    public /* synthetic */ K(BaseModule baseModule) {
        this.wb = baseModule;
    }

    public final void run() {
        this.wb.onThermalConstrained();
    }
}
