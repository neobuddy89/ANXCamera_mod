package com.android.camera.fragment.dialog;

import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;

/* compiled from: lambda */
public final /* synthetic */ class d implements CompletableOnSubscribe {
    private final /* synthetic */ FragmentLiveReview wb;

    public /* synthetic */ d(FragmentLiveReview fragmentLiveReview) {
        this.wb = fragmentLiveReview;
    }

    public final void subscribe(CompletableEmitter completableEmitter) {
        this.wb.a(completableEmitter);
    }
}
