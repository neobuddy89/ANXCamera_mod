package com.xiaomi.stat;

import android.content.Context;

public class I {

    /* renamed from: a  reason: collision with root package name */
    private static Context f298a;

    /* renamed from: b  reason: collision with root package name */
    private static String f299b;

    /* renamed from: c  reason: collision with root package name */
    private static String f300c;

    public static Context a() {
        return f298a;
    }

    public static void a(Context context, String str, String str2) {
        f298a = context;
        f299b = str;
        f300c = str2;
    }

    public static String b() {
        return f299b;
    }

    public static String c() {
        return f300c;
    }
}
