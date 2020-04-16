package com.xiaomi.stat;

import com.xiaomi.stat.a.c;
import com.xiaomi.stat.b.f;
import com.xiaomi.stat.d.e;

/* renamed from: com.xiaomi.stat.f  reason: case insensitive filesystem */
class C0163f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f553a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ boolean f554b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ C0162e f555c;

    C0163f(C0162e eVar, String str, boolean z) {
        this.f555c = eVar;
        this.f553a = str;
        this.f554b = z;
    }

    public void run() {
        e.a();
        if (this.f555c.f547a) {
            C0159b.h(this.f553a);
        }
        C0159b.d();
        f.a().a(C0159b.f());
        C0159b.a(this.f555c.f549c, this.f554b);
        if (!this.f555c.f547a) {
            C0159b.f(this.f555c.f548b);
        }
        this.f555c.f();
        c.a().b();
        com.xiaomi.stat.b.e.a().b().execute(new C0164g(this));
    }
}
