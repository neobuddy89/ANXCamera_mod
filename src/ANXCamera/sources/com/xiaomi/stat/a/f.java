package com.xiaomi.stat.a;

import java.util.ArrayList;

class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArrayList f336a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ c f337b;

    f(c cVar, ArrayList arrayList) {
        this.f337b = cVar;
        this.f336a = arrayList;
    }

    public void run() {
        this.f337b.b((ArrayList<Long>) this.f336a);
    }
}
