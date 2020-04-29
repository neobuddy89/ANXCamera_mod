package com.xiaomi.stat;

import com.xiaomi.stat.a.l;

class z implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f605a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ MiStatParams f606b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ C0158e f607c;

    z(C0158e eVar, boolean z, MiStatParams miStatParams) {
        this.f607c = eVar;
        this.f605a = z;
        this.f606b = miStatParams;
    }

    public void run() {
        if (C0155b.a() && this.f607c.g(this.f605a)) {
            C0158e eVar = this.f607c;
            eVar.a(l.a(this.f606b, this.f605a, eVar.f548b));
        }
    }
}
