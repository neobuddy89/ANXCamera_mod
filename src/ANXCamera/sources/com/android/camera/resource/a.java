package com.android.camera.resource;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/* compiled from: lambda */
public final /* synthetic */ class a implements ObservableOnSubscribe {
    private final /* synthetic */ Class Ab;
    private final /* synthetic */ BaseObservableRequest wb;

    public /* synthetic */ a(BaseObservableRequest baseObservableRequest, Class cls) {
        this.wb = baseObservableRequest;
        this.Ab = cls;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        this.wb.a(this.Ab, observableEmitter);
    }
}
