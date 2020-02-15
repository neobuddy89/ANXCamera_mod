package com.xiaomi.stat;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.xiaomi.stat.d.r;

public class F {

    /* renamed from: a  reason: collision with root package name */
    public static final int f285a = 1;

    /* renamed from: b  reason: collision with root package name */
    private static final int f286b = 10000;

    /* renamed from: c  reason: collision with root package name */
    private static final int f287c = 3;

    /* renamed from: d  reason: collision with root package name */
    private Handler f288d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Runnable f289e;

    /* renamed from: f  reason: collision with root package name */
    private HandlerThread f290f;
    /* access modifiers changed from: private */
    public int g = 3;
    /* access modifiers changed from: private */
    public int h = 10000;
    private int i = 0;
    /* access modifiers changed from: private */
    public boolean j = false;

    class a implements Handler.Callback {

        /* renamed from: b  reason: collision with root package name */
        private Handler f292b;

        private a() {
            this.f292b = null;
        }

        /* access modifiers changed from: private */
        public void a(Handler handler) {
            this.f292b = handler;
        }

        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                int intValue = ((Integer) message.obj).intValue();
                if (intValue < F.this.g) {
                    F.this.f289e.run();
                    if (F.this.j) {
                        Message obtainMessage = this.f292b.obtainMessage(1);
                        obtainMessage.obj = Integer.valueOf(intValue + 1);
                        this.f292b.sendMessageDelayed(obtainMessage, (long) F.this.h);
                    }
                } else {
                    F.this.b();
                }
            }
            return true;
        }
    }

    public F(Runnable runnable) {
        this.f289e = runnable;
    }

    private void d() {
        a aVar = new a();
        this.f290f = new HandlerThread("".concat("_").concat(String.valueOf(r.b())));
        this.f290f.start();
        this.f288d = new Handler(this.f290f.getLooper(), aVar);
        aVar.a(this.f288d);
    }

    public void a() {
        Handler handler = this.f288d;
        if (handler == null || !handler.hasMessages(1)) {
            d();
            Message obtainMessage = this.f288d.obtainMessage(1);
            obtainMessage.obj = 0;
            this.j = true;
            this.f288d.sendMessageDelayed(obtainMessage, (long) this.i);
        }
    }

    public void a(int i2) {
        this.i = i2;
    }

    public void b() {
        this.f288d.removeMessages(1);
        this.f288d.getLooper().quit();
        this.j = false;
    }

    public void b(int i2) {
        this.g = i2;
    }

    public void c(int i2) {
        this.h = i2;
    }

    public boolean c() {
        return this.j;
    }
}
