package com.android.camera.module.loader.camera2;

import io.reactivex.functions.Function;

/* compiled from: lambda */
public final /* synthetic */ class b implements Function {
    private final /* synthetic */ Camera2OpenManager wb;

    public /* synthetic */ b(Camera2OpenManager camera2OpenManager) {
        this.wb = camera2OpenManager;
    }

    public final Object apply(Object obj) {
        return this.wb.d((Throwable) obj);
    }
}
