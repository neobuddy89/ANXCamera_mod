package com.android.camera.module.impl.component;

import com.android.camera.module.BaseModule;
import java.util.function.Consumer;

/* compiled from: lambda */
public final /* synthetic */ class o implements Consumer {
    private final /* synthetic */ boolean wb;

    public /* synthetic */ o(boolean z) {
        this.wb = z;
    }

    public final void accept(Object obj) {
        ConfigChangeImpl.a(this.wb, (BaseModule) obj);
    }
}
