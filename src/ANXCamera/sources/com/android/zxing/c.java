package com.android.zxing;

import io.reactivex.functions.Function;

/* compiled from: lambda */
public final /* synthetic */ class c implements Function {
    private final /* synthetic */ QrDecoder wb;

    public /* synthetic */ c(QrDecoder qrDecoder) {
        this.wb = qrDecoder;
    }

    public final Object apply(Object obj) {
        return this.wb.b((PreviewImage) obj);
    }
}
