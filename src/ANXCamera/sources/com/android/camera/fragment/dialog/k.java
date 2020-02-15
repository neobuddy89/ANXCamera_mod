package com.android.camera.fragment.dialog;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/* compiled from: lambda */
public final /* synthetic */ class k implements ObservableOnSubscribe {
    private final /* synthetic */ FragmentLiveReview wb;

    public /* synthetic */ k(FragmentLiveReview fragmentLiveReview) {
        this.wb = fragmentLiveReview;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        this.wb.b(observableEmitter);
    }
}
