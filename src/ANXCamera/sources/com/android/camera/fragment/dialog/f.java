package com.android.camera.fragment.dialog;

import io.reactivex.functions.Consumer;

/* compiled from: lambda */
public final /* synthetic */ class f implements Consumer {
    private final /* synthetic */ FragmentLiveReview wb;

    public /* synthetic */ f(FragmentLiveReview fragmentLiveReview) {
        this.wb = fragmentLiveReview;
    }

    public final void accept(Object obj) {
        this.wb.c((Integer) obj);
    }
}
