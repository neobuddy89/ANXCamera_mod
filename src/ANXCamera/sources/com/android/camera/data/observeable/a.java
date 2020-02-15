package com.android.camera.data.observeable;

import com.android.camera.fragment.vv.VVList;
import io.reactivex.functions.Function;

/* compiled from: lambda */
public final /* synthetic */ class a implements Function {
    private final /* synthetic */ VlogViewModel wb;

    public /* synthetic */ a(VlogViewModel vlogViewModel) {
        this.wb = vlogViewModel;
    }

    public final Object apply(Object obj) {
        return this.wb.b((VVList) obj);
    }
}
