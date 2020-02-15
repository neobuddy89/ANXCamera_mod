package com.xiaomi.stat.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.stat.d.k;
import com.xiaomi.stat.d.l;

class b extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f375a;

    b(a aVar) {
        this.f375a = aVar;
    }

    public void onReceive(Context context, Intent intent) {
        try {
            if (this.f375a.r != 1) {
                context.unregisterReceiver(this.f375a.u);
            } else if (l.a()) {
                e.a().b().execute(new c(this));
            }
        } catch (Exception e2) {
            k.d("ConfigManager", "mNetReceiver exception", e2);
        }
    }
}
