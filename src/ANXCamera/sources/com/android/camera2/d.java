package com.android.camera2;

/* compiled from: lambda */
public final /* synthetic */ class d implements Runnable {
    private final /* synthetic */ boolean Ab;
    private final /* synthetic */ MiCamera2 wb;

    public /* synthetic */ d(MiCamera2 miCamera2, boolean z) {
        this.wb = miCamera2;
        this.Ab = z;
    }

    public final void run() {
        this.wb.s(this.Ab);
    }
}
