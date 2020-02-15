package com.xiaomi.stat;

import java.lang.Thread;

public class J implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private C0158e f301a;

    /* renamed from: b  reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f302b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f303c = true;

    public J(C0158e eVar) {
        this.f301a = eVar;
    }

    public void a() {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (!(defaultUncaughtExceptionHandler instanceof J)) {
            this.f302b = defaultUncaughtExceptionHandler;
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    public void a(boolean z) {
        this.f303c = z;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (this.f303c) {
            this.f301a.a(th, (String) null, false);
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f302b;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
