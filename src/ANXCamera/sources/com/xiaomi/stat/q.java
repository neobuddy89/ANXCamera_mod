package com.xiaomi.stat;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.SystemClock;
import com.xiaomi.stat.d.r;

class q implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C0162e f579a;

    /* renamed from: b  reason: collision with root package name */
    private int f580b;

    q(C0162e eVar) {
        this.f579a = eVar;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
        int unused = this.f579a.k = this.f579a.k + 1;
        if (this.f580b == System.identityHashCode(activity)) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.f579a.f552f;
            long l = this.f579a.d();
            this.f579a.a(activity.getClass().getName(), l - elapsedRealtime, l);
        }
    }

    public void onActivityResumed(Activity activity) {
        int unused = this.f579a.j = this.f579a.j + 1;
        this.f580b = System.identityHashCode(activity);
        long unused2 = this.f579a.f552f = SystemClock.elapsedRealtime();
        this.f579a.h();
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        if (this.f579a.i == 0) {
            long unused = this.f579a.l = SystemClock.elapsedRealtime();
            int unused2 = this.f579a.j = 0;
            int unused3 = this.f579a.k = 0;
            this.f579a.f551e.execute(new r(this));
        }
        int unused4 = this.f579a.i = this.f579a.i + 1;
    }

    public void onActivityStopped(Activity activity) {
        C0162e.m(this.f579a);
        if (this.f579a.i == 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.f579a.l;
            long b2 = r.b();
            C0162e eVar = this.f579a;
            eVar.a(eVar.j, this.f579a.k, b2 - elapsedRealtime, b2);
            this.f579a.f551e.execute(new s(this));
        }
    }
}
