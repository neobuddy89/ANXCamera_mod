package com.android.camera.data.data.config;

import com.android.camera.data.data.ComponentDataItem;
import java.util.function.Predicate;

/* compiled from: lambda */
public final /* synthetic */ class a implements Predicate {
    private final /* synthetic */ String wb;

    public /* synthetic */ a(String str) {
        this.wb = str;
    }

    public final boolean test(Object obj) {
        return ((ComponentDataItem) obj).mValue.equals(this.wb);
    }
}
