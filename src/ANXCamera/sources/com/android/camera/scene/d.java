package com.android.camera.scene;

import com.android.camera.protocol.ModeProtocol;

/* compiled from: lambda */
public final /* synthetic */ class d implements Runnable {
    private final /* synthetic */ ModeProtocol.TopAlert wb;

    public /* synthetic */ d(ModeProtocol.TopAlert topAlert) {
        this.wb = topAlert;
    }

    public final void run() {
        this.wb.alertAiSceneSelector(8);
    }
}
