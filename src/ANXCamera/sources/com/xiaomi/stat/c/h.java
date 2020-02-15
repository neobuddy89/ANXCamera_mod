package com.xiaomi.stat.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.stat.d.l;
import com.xiaomi.stat.d.r;

class h extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f443a;

    h(g gVar) {
        this.f443a = gVar;
    }

    public void onReceive(Context context, Intent intent) {
        boolean z = r.b() - this.f443a.n > ((long) this.f443a.k);
        if (l.a() && this.f443a.l && z) {
            this.f443a.b();
            long unused = this.f443a.n = r.b();
        }
    }
}
