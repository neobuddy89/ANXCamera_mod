package com.xiaomi.stat.c;

import android.os.IBinder;
import android.os.RemoteException;
import com.xiaomi.a.a.a.a;
import com.xiaomi.stat.C0155b;
import com.xiaomi.stat.d.k;

class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IBinder f429a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ d f430b;

    e(d dVar, IBinder iBinder) {
        this.f430b = dVar;
        this.f429a = iBinder;
    }

    public void run() {
        a a2 = a.C0015a.a(this.f429a);
        try {
            if (!C0155b.e()) {
                this.f430b.f426a[0] = a2.a(this.f430b.f427b, this.f430b.f428c);
            } else if (C0155b.x()) {
                this.f430b.f426a[0] = a2.b(this.f430b.f427b, this.f430b.f428c);
            } else {
                this.f430b.f426a[0] = null;
            }
            k.b("UploadMode connected, do remote http post " + this.f430b.f426a[0]);
            synchronized (i.class) {
                try {
                    i.class.notify();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        } catch (RemoteException e3) {
            k.e("UploadMode error while uploading the data by IPC." + e3.toString());
            this.f430b.f426a[0] = null;
        }
    }
}
