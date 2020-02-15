package com.xiaomi.stat.c;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.xiaomi.stat.b.e;
import com.xiaomi.stat.d.k;
import java.util.Map;

final class d implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String[] f426a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f427b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Map f428c;

    d(String[] strArr, String str, Map map) {
        this.f426a = strArr;
        this.f427b = str;
        this.f428c = map;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x000b */
    public void onBindingDied(ComponentName componentName) {
        synchronized (i.class) {
            i.class.notify();
        }
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        e.a().b().execute(new e(this, iBinder));
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0011 */
    public void onServiceDisconnected(ComponentName componentName) {
        k.b("UploadMode error while perform IPC connection.", (String) null);
        synchronized (i.class) {
            i.class.notify();
        }
    }
}
