package com.xiaomi.stat.d;

import android.content.Context;
import android.content.SharedPreferences;

public class p {

    /* renamed from: a  reason: collision with root package name */
    private static final String f530a = "mi_stat_pref";

    /* renamed from: b  reason: collision with root package name */
    private static SharedPreferences f531b = null;

    /* renamed from: c  reason: collision with root package name */
    private static SharedPreferences.Editor f532c = null;

    /* renamed from: d  reason: collision with root package name */
    private static final String f533d = "imei1";

    /* renamed from: e  reason: collision with root package name */
    private static final String f534e = "imei2";

    /* renamed from: f  reason: collision with root package name */
    private static final String f535f = "meid";
    private static final String g = "mac";
    private static final String h = "serial";
    private static final String i = "s_t";
    private static final String j = "l_t";
    private static final String k = "e_t";
    private static final String l = "od_checked";
    private static final String m = "od_v";
    private static final String n = "resued_old_instanced_id";

    private static long a(Context context, String str, long j2) {
        l(context);
        return f531b.getLong(str, j2);
    }

    public static String a(Context context) {
        return a(context, f533d, "");
    }

    private static String a(Context context, String str, String str2) {
        l(context);
        return f531b.getString(str, str2);
    }

    public static void a(Context context, long j2) {
        b(context, i, j2);
    }

    public static void a(Context context, String str) {
        b(context, f533d, str);
    }

    public static void a(Context context, boolean z) {
        b(context, l, z);
    }

    private static boolean a(Context context, String str, boolean z) {
        l(context);
        return f531b.getBoolean(str, z);
    }

    public static String b(Context context) {
        return a(context, f534e, "");
    }

    public static void b(Context context, long j2) {
        b(context, j, j2);
    }

    public static void b(Context context, String str) {
        b(context, f534e, str);
    }

    private static void b(Context context, String str, long j2) {
        l(context);
        f532c.putLong(str, j2).apply();
    }

    private static void b(Context context, String str, String str2) {
        l(context);
        f532c.putString(str, str2).apply();
    }

    private static void b(Context context, String str, boolean z) {
        l(context);
        f532c.putBoolean(str, z).apply();
    }

    public static void b(Context context, boolean z) {
        b(context, n, z);
    }

    public static String c(Context context) {
        return a(context, f535f, "");
    }

    public static void c(Context context, long j2) {
        b(context, k, j2);
    }

    public static void c(Context context, String str) {
        b(context, f535f, str);
    }

    public static String d(Context context) {
        return a(context, g, "");
    }

    public static void d(Context context, String str) {
        b(context, g, str);
    }

    public static String e(Context context) {
        return a(context, h, "");
    }

    public static void e(Context context, String str) {
        b(context, h, str);
    }

    public static long f(Context context) {
        return a(context, i, 0);
    }

    public static void f(Context context, String str) {
        b(context, m, str);
    }

    public static long g(Context context) {
        return a(context, j, 0);
    }

    public static long h(Context context) {
        return a(context, k, 0);
    }

    public static boolean i(Context context) {
        return a(context, l, false);
    }

    public static String j(Context context) {
        return a(context, m, (String) null);
    }

    public static boolean k(Context context) {
        return a(context, n, false);
    }

    private static void l(Context context) {
        if (f532c == null) {
            synchronized (p.class) {
                if (f532c == null) {
                    f531b = context.getSharedPreferences(f530a, 0);
                    f532c = f531b.edit();
                }
            }
        }
    }
}
