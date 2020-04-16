package com.xiaomi.stat;

import com.xiaomi.stat.a.l;

/* renamed from: com.xiaomi.stat.j  reason: case insensitive filesystem */
class C0167j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f561a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f562b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ C0162e f563c;

    C0167j(C0162e eVar, int i, int i2) {
        this.f563c = eVar;
        this.f561a = i;
        this.f562b = i2;
    }

    public void run() {
        if (C0159b.a() && this.f563c.g()) {
            C0159b.e(this.f561a);
            this.f563c.a(l.a(this.f562b));
        }
    }
}
