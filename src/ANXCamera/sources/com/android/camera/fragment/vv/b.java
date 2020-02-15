package com.android.camera.fragment.vv;

import io.reactivex.functions.Consumer;

/* compiled from: lambda */
public final /* synthetic */ class b implements Consumer {
    private final /* synthetic */ FragmentVVGallery wb;

    public /* synthetic */ b(FragmentVVGallery fragmentVVGallery) {
        this.wb = fragmentVVGallery;
    }

    public final void accept(Object obj) {
        this.wb.a((VVList) obj);
    }
}
