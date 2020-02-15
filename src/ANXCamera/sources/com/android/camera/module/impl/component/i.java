package com.android.camera.module.impl.component;

import com.android.camera.module.BaseModule;
import java.util.function.Consumer;

/* compiled from: lambda */
public final /* synthetic */ class i implements Consumer {
    private final /* synthetic */ int[] wb;

    public /* synthetic */ i(int[] iArr) {
        this.wb = iArr;
    }

    public final void accept(Object obj) {
        ConfigChangeImpl.a(this.wb, (BaseModule) obj);
    }
}
