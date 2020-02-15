package com.xiaomi.stat;

import android.text.TextUtils;
import com.xiaomi.stat.a.l;

/* renamed from: com.xiaomi.stat.h  reason: case insensitive filesystem */
class C0161h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f557a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C0158e f558b;

    C0161h(C0158e eVar, String str) {
        this.f558b = eVar;
        this.f557a = str;
    }

    public void run() {
        if (C0155b.a() && !TextUtils.equals(C0155b.h(), this.f557a)) {
            C0155b.b(this.f557a);
            if (this.f558b.g()) {
                this.f558b.a(l.a(this.f557a));
            }
        }
    }
}
