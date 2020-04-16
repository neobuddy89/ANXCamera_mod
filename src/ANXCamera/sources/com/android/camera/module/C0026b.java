package com.android.camera.module;

import com.android.camera.protocol.ModeCoordinatorImpl;
import com.android.camera.protocol.ModeProtocol;

/* renamed from: com.android.camera.module.b  reason: case insensitive filesystem */
/* compiled from: lambda */
public final /* synthetic */ class C0026b implements Runnable {
    public static final /* synthetic */ C0026b INSTANCE = new C0026b();

    private /* synthetic */ C0026b() {
    }

    public final void run() {
        ((ModeProtocol.IDCardModeProtocol) ModeCoordinatorImpl.getInstance().getAttachProtocol(233)).switchNextPage();
    }
}
