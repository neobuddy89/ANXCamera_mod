package com.xiaomi.stat;

import com.xiaomi.stat.a.l;

class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f571a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f572b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ long f573c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ long f574d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ C0158e f575e;

    o(C0158e eVar, int i, int i2, long j, long j2) {
        this.f575e = eVar;
        this.f571a = i;
        this.f572b = i2;
        this.f573c = j;
        this.f574d = j2;
    }

    public void run() {
        if (C0155b.a() && this.f575e.g()) {
            this.f575e.a(l.a(this.f571a, this.f572b, this.f573c, this.f574d));
        }
    }
}
