package com.xiaomi.stat.a;

import java.util.concurrent.Callable;

class e implements Callable<k> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b[] f334a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ c f335b;

    e(c cVar, b[] bVarArr) {
        this.f335b = cVar;
        this.f334a = bVarArr;
    }

    /* renamed from: a */
    public k call() throws Exception {
        return this.f335b.b(this.f334a);
    }
}
