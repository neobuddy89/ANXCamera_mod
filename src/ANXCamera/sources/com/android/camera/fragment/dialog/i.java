package com.android.camera.fragment.dialog;

import io.reactivex.functions.Consumer;

/* compiled from: lambda */
public final /* synthetic */ class i implements Consumer {
    private final /* synthetic */ FragmentLiveReview wb;

    public /* synthetic */ i(FragmentLiveReview fragmentLiveReview) {
        this.wb = fragmentLiveReview;
    }

    public final void accept(Object obj) {
        this.wb.d((Integer) obj);
    }
}
