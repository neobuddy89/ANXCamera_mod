package com.xiaomi.stat;

import android.os.FileObserver;

class C extends FileObserver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ A f275a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C(A a2, String str) {
        super(str);
        this.f275a = a2;
    }

    public void onEvent(int i, String str) {
        if (i == 2) {
            synchronized (this.f275a) {
                this.f275a.b();
            }
            C0155b.n();
        }
    }
}
