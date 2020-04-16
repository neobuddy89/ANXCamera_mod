package com.xiaomi.stat;

import com.xiaomi.stat.a.l;
import com.xiaomi.stat.d.r;

class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C0162e f564a;

    k(C0162e eVar) {
        this.f564a = eVar;
    }

    public void run() {
        if (C0159b.a() && this.f564a.g()) {
            long b2 = r.b();
            if (this.f564a.a(C0159b.r(), b2)) {
                C0159b.a(b2);
                this.f564a.a(l.a());
            }
        }
    }
}
