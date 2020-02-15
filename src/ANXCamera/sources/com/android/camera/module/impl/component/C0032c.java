package com.android.camera.module.impl.component;

import com.android.camera.module.BaseModule;
import java.util.function.Consumer;

/* renamed from: com.android.camera.module.impl.component.c  reason: case insensitive filesystem */
/* compiled from: lambda */
public final /* synthetic */ class C0032c implements Consumer {
    private final /* synthetic */ boolean wb;

    public /* synthetic */ C0032c(boolean z) {
        this.wb = z;
    }

    public final void accept(Object obj) {
        ConfigChangeImpl.b(this.wb, (BaseModule) obj);
    }
}
