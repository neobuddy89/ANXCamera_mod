package com.xiaomi.stat;

import com.xiaomi.stat.a.l;

class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f583a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ long f584b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ long f585c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ C0162e f586d;

    t(C0162e eVar, String str, long j, long j2) {
        this.f586d = eVar;
        this.f583a = str;
        this.f584b = j;
        this.f585c = j2;
    }

    public void run() {
        if (C0159b.a() && this.f586d.g()) {
            this.f586d.a(l.a(this.f583a, this.f584b, this.f585c));
        }
    }
}
