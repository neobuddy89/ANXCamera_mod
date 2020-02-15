package com.android.camera2;

import android.hardware.camera2.CaptureRequest;
import java.util.function.BiConsumer;

/* compiled from: lambda */
public final /* synthetic */ class b implements BiConsumer {
    private final /* synthetic */ CaptureRequest.Builder wb;

    public /* synthetic */ b(CaptureRequest.Builder builder) {
        this.wb = builder;
    }

    public final void accept(Object obj, Object obj2) {
        CaptureSessionConfigurations.a(this.wb, obj, obj2);
    }
}
