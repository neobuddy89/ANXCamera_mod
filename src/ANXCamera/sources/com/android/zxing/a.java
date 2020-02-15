package com.android.zxing;

import io.reactivex.functions.Function;

/* compiled from: lambda */
public final /* synthetic */ class a implements Function {
    private final /* synthetic */ HandGestureDecoder wb;

    public /* synthetic */ a(HandGestureDecoder handGestureDecoder) {
        this.wb = handGestureDecoder;
    }

    public final Object apply(Object obj) {
        return this.wb.a((PreviewImage) obj);
    }
}
