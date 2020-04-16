package com.xiaomi.stat;

import android.text.TextUtils;
import com.xiaomi.stat.b.f;
import com.xiaomi.stat.d.m;

class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f565a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f566b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ C0162e f567c;

    l(C0162e eVar, boolean z, String str) {
        this.f567c = eVar;
        this.f565a = z;
        this.f566b = str;
    }

    public void run() {
        if (!m.a()) {
            C0159b.c(this.f565a);
            f.a().a(this.f565a);
        }
        if (C0159b.e() && !TextUtils.isEmpty(this.f566b)) {
            C0159b.a(this.f566b);
            f.a().a(this.f566b);
        }
    }
}
