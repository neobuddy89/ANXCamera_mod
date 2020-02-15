package com.android.camera.module;

import com.android.camera.data.observeable.RxData;
import io.reactivex.functions.Consumer;

/* compiled from: lambda */
public final /* synthetic */ class x implements Consumer {
    private final /* synthetic */ LiveModuleSubVV wb;

    public /* synthetic */ x(LiveModuleSubVV liveModuleSubVV) {
        this.wb = liveModuleSubVV;
    }

    public final void accept(Object obj) {
        this.wb.b((RxData.DataWrap) obj);
    }
}
