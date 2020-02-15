package com.android.camera.module.impl.component;

import com.android.camera.module.BaseModule;
import java.util.function.Consumer;

/* renamed from: com.android.camera.module.impl.component.b  reason: case insensitive filesystem */
/* compiled from: lambda */
public final /* synthetic */ class C0031b implements Consumer {
    public static final /* synthetic */ C0031b INSTANCE = new C0031b();

    private /* synthetic */ C0031b() {
    }

    public final void accept(Object obj) {
        ((BaseModule) obj).updatePreferenceInWorkThread(29);
    }
}
