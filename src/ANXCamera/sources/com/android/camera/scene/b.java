package com.android.camera.scene;

/* compiled from: lambda */
public final /* synthetic */ class b implements Runnable {
    private final /* synthetic */ int Ab;
    private final /* synthetic */ int Bb;
    private final /* synthetic */ int Cb;
    private final /* synthetic */ ASDResultParse wb;

    public /* synthetic */ b(ASDResultParse aSDResultParse, int i, int i2, int i3) {
        this.wb = aSDResultParse;
        this.Ab = i;
        this.Bb = i2;
        this.Cb = i3;
    }

    public final void run() {
        this.wb.a(this.Ab, this.Bb, this.Cb);
    }
}
