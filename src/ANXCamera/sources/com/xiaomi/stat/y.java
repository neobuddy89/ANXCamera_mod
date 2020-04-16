package com.xiaomi.stat;

import com.xiaomi.stat.a.l;

class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Throwable f601a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f602b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ boolean f603c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ C0162e f604d;

    y(C0162e eVar, Throwable th, String str, boolean z) {
        this.f604d = eVar;
        this.f601a = th;
        this.f602b = str;
        this.f603c = z;
    }

    public void run() {
        if (C0159b.a() && this.f604d.g(false)) {
            C0162e eVar = this.f604d;
            eVar.a(l.a(this.f601a, this.f602b, this.f603c, eVar.f548b));
        }
    }
}
