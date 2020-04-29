package com.xiaomi.stat;

import com.xiaomi.stat.a.l;

class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f576a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f577b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ C0158e f578c;

    p(C0158e eVar, String str, String str2) {
        this.f578c = eVar;
        this.f576a = str;
        this.f577b = str2;
    }

    public void run() {
        if (C0155b.a() && this.f578c.g(false)) {
            C0158e eVar = this.f578c;
            eVar.a(l.a(this.f576a, this.f577b, eVar.f548b));
        }
    }
}
