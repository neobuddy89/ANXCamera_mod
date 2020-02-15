package com.android.zxing;

import io.reactivex.functions.Consumer;

/* compiled from: lambda */
public final /* synthetic */ class d implements Consumer {
    private final /* synthetic */ QrDecoder wb;

    public /* synthetic */ d(QrDecoder qrDecoder) {
        this.wb = qrDecoder;
    }

    public final void accept(Object obj) {
        this.wb.o((String) obj);
    }
}
