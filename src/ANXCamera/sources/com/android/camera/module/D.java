package com.android.camera.module;

import android.net.Uri;

/* compiled from: lambda */
public final /* synthetic */ class D implements Runnable {
    private final /* synthetic */ String Ab;
    private final /* synthetic */ Uri Bb;
    private final /* synthetic */ MiLiveModule wb;

    public /* synthetic */ D(MiLiveModule miLiveModule, String str, Uri uri) {
        this.wb = miLiveModule;
        this.Ab = str;
        this.Bb = uri;
    }

    public final void run() {
        this.wb.a(this.Ab, this.Bb);
    }
}
