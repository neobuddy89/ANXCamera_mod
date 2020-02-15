package com.android.camera.module.impl.component;

import com.android.camera.module.BaseModule;
import java.util.function.Consumer;

/* compiled from: lambda */
public final /* synthetic */ class s implements Consumer {
    private final /* synthetic */ ConfigChangeImpl wb;

    public /* synthetic */ s(ConfigChangeImpl configChangeImpl) {
        this.wb = configChangeImpl;
    }

    public final void accept(Object obj) {
        this.wb.i((BaseModule) obj);
    }
}
