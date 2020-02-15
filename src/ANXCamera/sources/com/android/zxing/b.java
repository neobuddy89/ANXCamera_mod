package com.android.zxing;

import io.reactivex.functions.Consumer;

/* compiled from: lambda */
public final /* synthetic */ class b implements Consumer {
    private final /* synthetic */ HandGestureDecoder wb;

    public /* synthetic */ b(HandGestureDecoder handGestureDecoder) {
        this.wb = handGestureDecoder;
    }

    public final void accept(Object obj) {
        this.wb.e((Integer) obj);
    }
}
