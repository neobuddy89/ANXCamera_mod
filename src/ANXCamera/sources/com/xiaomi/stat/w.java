package com.xiaomi.stat;

import com.xiaomi.stat.a.l;

class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f591a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ long f592b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ long f593c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ MiStatParams f594d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ C0162e f595e;

    w(C0162e eVar, String str, long j, long j2, MiStatParams miStatParams) {
        this.f595e = eVar;
        this.f591a = str;
        this.f592b = j;
        this.f593c = j2;
        this.f594d = miStatParams;
    }

    public void run() {
        if (C0159b.a() && this.f595e.g(false)) {
            C0162e eVar = this.f595e;
            String str = this.f591a;
            long j = this.f592b;
            eVar.a(l.a(str, j - this.f593c, j, this.f594d, eVar.f548b));
        }
    }
}
