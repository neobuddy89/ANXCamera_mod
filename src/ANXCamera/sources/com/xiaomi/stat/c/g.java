package com.xiaomi.stat.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.android.camera.statistic.MistatsConstants;
import com.ss.android.ugc.effectmanager.link.model.configuration.LinkSelectorConfiguration;
import com.xiaomi.stat.C0159b;
import com.xiaomi.stat.I;
import com.xiaomi.stat.a.c;
import com.xiaomi.stat.d.k;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class g extends Handler {

    /* renamed from: c  reason: collision with root package name */
    private static final String f437c = "UploadTimer";

    /* renamed from: d  reason: collision with root package name */
    private static final int f438d = 15000;

    /* renamed from: e  reason: collision with root package name */
    private static final int f439e = 5;

    /* renamed from: f  reason: collision with root package name */
    private static final int f440f = 86400;
    private static final int g = 1;
    private static final int h = 2;

    /* renamed from: a  reason: collision with root package name */
    public AtomicBoolean f441a;

    /* renamed from: b  reason: collision with root package name */
    BroadcastReceiver f442b;
    private long i;
    private AtomicInteger j;
    /* access modifiers changed from: private */
    public int k;
    /* access modifiers changed from: private */
    public boolean l;
    private long m;
    /* access modifiers changed from: private */
    public long n;
    private boolean o;

    public g(Looper looper) {
        super(looper);
        this.i = MistatsConstants.UPLOAD_POLICY_INTERVAL;
        this.j = new AtomicInteger();
        this.f441a = new AtomicBoolean(true);
        this.k = 15000;
        this.l = true;
        this.o = true;
        this.f442b = new h(this);
        this.k = LinkSelectorConfiguration.MS_OF_ONE_MIN;
        this.j.set(this.k);
        sendEmptyMessageDelayed(1, (long) this.k);
        a(I.a());
        k.b("UploadTimer UploadTimer: " + this.k);
    }

    private int a(int i2) {
        if (i2 < 0) {
            return 0;
        }
        if (i2 <= 0 || i2 >= 5) {
            return i2 > f440f ? f440f : i2;
        }
        return 5;
    }

    private void a(Context context) {
        if (context != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            context.registerReceiver(this.f442b, intentFilter);
        }
    }

    private int d() {
        int a2 = a(C0159b.m());
        if (a2 > 0) {
            return a2 * 1000;
        }
        int a3 = a(C0159b.j());
        if (a3 > 0) {
            return a3 * 1000;
        }
        return 15000;
    }

    private void e() {
        i.a().c();
    }

    private void f() {
        int i2 = (c.a().c() > 0 ? 1 : (c.a().c() == 0 ? 0 : -1));
        if (i2 >= 0) {
            if (i2 > 0) {
                b();
                this.f441a.set(false);
            } else {
                this.f441a.set(true);
            }
            k.b("UploadTimer checkDatabase mIsDatabaseEmpty=" + this.f441a.get());
        }
    }

    public long a() {
        return this.m;
    }

    public void a(boolean z) {
        if (!z && !this.o) {
            b();
        }
        this.l = z;
        this.o = false;
    }

    public void b() {
        this.k = d();
        this.j.set(this.k);
        removeMessages(1);
        sendEmptyMessageDelayed(1, (long) this.k);
        k.b("UploadTimer resetBackgroundInterval: " + this.k);
    }

    public void b(boolean z) {
        long c2 = c.a().c();
        int i2 = (c2 > 0 ? 1 : (c2 == 0 ? 0 : -1));
        if (i2 == 0) {
            this.f441a.set(true);
        }
        k.b("UploadTimer totalCount=" + c2 + " deleteData=" + z);
        if (((long) this.j.get()) < this.i && this.l) {
            if (i2 == 0 || !z) {
                this.j.addAndGet(this.k);
            }
        }
    }

    public void c() {
        if (this.l && this.f441a.get()) {
            sendEmptyMessage(2);
        }
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        int i2 = message.what;
        if (i2 == 1) {
            e();
            this.m = (long) (this.l ? this.j.get() : this.k);
            sendEmptyMessageDelayed(1, this.m);
            k.b("UploadTimer handleMessage: " + this.l);
        } else if (i2 == 2) {
            f();
        }
    }
}
