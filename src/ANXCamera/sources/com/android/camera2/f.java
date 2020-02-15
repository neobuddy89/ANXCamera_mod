package com.android.camera2;

import java.util.Comparator;
import java.util.HashMap;

/* compiled from: lambda */
public final /* synthetic */ class f implements Comparator {
    private final /* synthetic */ HashMap wb;

    public /* synthetic */ f(HashMap hashMap) {
        this.wb = hashMap;
    }

    public final int compare(Object obj, Object obj2) {
        return MiCamera2.a(this.wb, (Integer) obj, (Integer) obj2);
    }
}
