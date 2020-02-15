package com.android.camera.module;

import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;

/* compiled from: lambda */
public final /* synthetic */ class C implements FlowableOnSubscribe {
    private final /* synthetic */ MiLiveModule wb;

    public /* synthetic */ C(MiLiveModule miLiveModule) {
        this.wb = miLiveModule;
    }

    public final void subscribe(FlowableEmitter flowableEmitter) {
        this.wb.a(flowableEmitter);
    }
}
