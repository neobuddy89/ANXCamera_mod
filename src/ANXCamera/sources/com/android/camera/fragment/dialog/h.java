package com.android.camera.fragment.dialog;

import io.reactivex.functions.Consumer;

/* compiled from: lambda */
public final /* synthetic */ class h implements Consumer {
    private final /* synthetic */ FragmentLiveReview wb;

    public /* synthetic */ h(FragmentLiveReview fragmentLiveReview) {
        this.wb = fragmentLiveReview;
    }

    public final void accept(Object obj) {
        this.wb.b((Integer) obj);
    }
}
