package com.android.camera.fragment.vv;

import com.android.camera.data.observeable.RxData;
import io.reactivex.functions.Consumer;

/* compiled from: lambda */
public final /* synthetic */ class c implements Consumer {
    private final /* synthetic */ FragmentVVProcess wb;

    public /* synthetic */ c(FragmentVVProcess fragmentVVProcess) {
        this.wb = fragmentVVProcess;
    }

    public final void accept(Object obj) {
        this.wb.a((RxData.DataWrap) obj);
    }
}
