package com.xiaomi.stat;

import com.xiaomi.stat.a.l;

class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f596a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f597b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f598c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ MiStatParams f599d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ C0162e f600e;

    x(C0162e eVar, boolean z, String str, String str2, MiStatParams miStatParams) {
        this.f600e = eVar;
        this.f596a = z;
        this.f597b = str;
        this.f598c = str2;
        this.f599d = miStatParams;
    }

    public void run() {
        if (C0159b.a() && this.f600e.g(this.f596a)) {
            C0162e eVar = this.f600e;
            eVar.a(l.a(this.f597b, this.f598c, this.f599d, eVar.f548b, this.f596a));
        }
    }
}
