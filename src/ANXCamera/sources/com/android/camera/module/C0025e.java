package com.android.camera.module;

import com.android.camera.protocol.ModeProtocol;

/* renamed from: com.android.camera.module.e  reason: case insensitive filesystem */
/* compiled from: lambda */
public final /* synthetic */ class C0025e implements Runnable {
    private final /* synthetic */ ModeProtocol.TopAlert wb;

    public /* synthetic */ C0025e(ModeProtocol.TopAlert topAlert) {
        this.wb = topAlert;
    }

    public final void run() {
        this.wb.hideAlert();
    }
}
