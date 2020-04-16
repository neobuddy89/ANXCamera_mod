package com.xiaomi.stat;

import com.xiaomi.stat.a.l;

class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ HttpEvent f568a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C0162e f569b;

    m(C0162e eVar, HttpEvent httpEvent) {
        this.f569b = eVar;
        this.f568a = httpEvent;
    }

    public void run() {
        if (C0159b.a() && this.f569b.g(false)) {
            C0162e eVar = this.f569b;
            eVar.a(l.a(this.f568a, eVar.f548b));
        }
    }
}
