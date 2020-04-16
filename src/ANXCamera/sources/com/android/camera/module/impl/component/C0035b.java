package com.android.camera.module.impl.component;

import com.android.camera.module.BaseModule;
import java.util.function.Consumer;

/* renamed from: com.android.camera.module.impl.component.b  reason: case insensitive filesystem */
/* compiled from: lambda */
public final /* synthetic */ class C0035b implements Consumer {
    public static final /* synthetic */ C0035b INSTANCE = new C0035b();

    private /* synthetic */ C0035b() {
    }

    public final void accept(Object obj) {
        ((BaseModule) obj).updatePreferenceInWorkThread(29);
    }
}
