package com.android.camera.module.loader.camera2;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/* compiled from: lambda */
public final /* synthetic */ class a implements ObservableOnSubscribe {
    private final /* synthetic */ Camera2OpenManager wb;

    public /* synthetic */ a(Camera2OpenManager camera2OpenManager) {
        this.wb = camera2OpenManager;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        this.wb.d(observableEmitter);
    }
}
