package com.android.camera.module.impl.component;

import com.android.camera.module.BaseModule;
import java.util.function.Consumer;

/* compiled from: lambda */
public final /* synthetic */ class e implements Consumer {
    private final /* synthetic */ ConfigChangeImpl wb;

    public /* synthetic */ e(ConfigChangeImpl configChangeImpl) {
        this.wb = configChangeImpl;
    }

    public final void accept(Object obj) {
        this.wb.a((BaseModule) obj);
    }
}
