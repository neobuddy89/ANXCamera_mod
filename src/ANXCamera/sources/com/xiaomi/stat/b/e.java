package com.xiaomi.stat.b;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f383a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static volatile e f384b;

    /* renamed from: c  reason: collision with root package name */
    private static volatile ExecutorService f385c;

    private e() {
    }

    public static e a() {
        if (f384b == null) {
            synchronized (f383a) {
                if (f384b == null) {
                    f384b = new e();
                }
            }
        }
        return f384b;
    }

    public synchronized ExecutorService b() {
        if (f385c == null) {
            f385c = Executors.newCachedThreadPool();
        }
        return f385c;
    }
}
