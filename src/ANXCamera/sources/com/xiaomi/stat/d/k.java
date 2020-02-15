package com.xiaomi.stat.d;

import android.text.TextUtils;
import android.util.Log;

public class k {

    /* renamed from: a  reason: collision with root package name */
    private static final String f500a = "MI_STAT";

    /* renamed from: b  reason: collision with root package name */
    private static boolean f501b = false;

    /* renamed from: c  reason: collision with root package name */
    private static final int f502c = 4000;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final int f503a = 0;

        /* renamed from: b  reason: collision with root package name */
        public static final int f504b = 1;

        /* renamed from: c  reason: collision with root package name */
        public static final int f505c = 2;

        /* renamed from: d  reason: collision with root package name */
        public static final int f506d = 3;

        /* renamed from: e  reason: collision with root package name */
        public static final int f507e = 4;
    }

    public static String a(Throwable th) {
        return Log.getStackTraceString(th);
    }

    private static void a(int i, String str, String str2, Throwable th) {
        if (TextUtils.isEmpty(str)) {
            str = f500a;
        }
        if (i == 0) {
            Log.v(str, str2, th);
        } else if (i == 1) {
            Log.i(str, str2, th);
        } else if (i == 2) {
            Log.d(str, str2, th);
        } else if (i == 3) {
            Log.w(str, str2, th);
        } else if (i == 4) {
            Log.e(str, str2, th);
        }
    }

    public static void a(String str) {
        a(f500a, str);
    }

    public static void a(String str, String str2) {
        if (f501b) {
            b(0, str, str2, (Throwable) null);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (f501b) {
            b(0, str, str2, th);
        }
    }

    public static void a(String str, Throwable th) {
        if (f501b) {
            b(3, str, (String) null, th);
        }
    }

    public static void a(boolean z) {
        f501b = z;
    }

    public static boolean a() {
        return f501b;
    }

    private static void b(int i, String str, String str2, Throwable th) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (str2.length() > 4000) {
            a(i, str, str2.substring(0, 4000), (Throwable) null);
            b(i, str, str2.substring(4000, str2.length()), (Throwable) null);
            return;
        }
        a(i, str, str2, th);
    }

    public static void b(String str) {
        b(f500a, str);
    }

    public static void b(String str, String str2) {
        if (f501b) {
            b(2, str, str2, (Throwable) null);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        if (f501b) {
            b(2, str, str2, th);
        }
    }

    public static void c(String str) {
        c(f500a, str);
    }

    public static void c(String str, String str2) {
        if (f501b) {
            b(1, str, str2, (Throwable) null);
        }
    }

    public static void c(String str, String str2, Throwable th) {
        if (f501b) {
            b(1, str, str2, th);
        }
    }

    public static void d(String str) {
        d(f500a, str);
    }

    public static void d(String str, String str2) {
        if (f501b) {
            b(3, str, str2, (Throwable) null);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (f501b) {
            b(4, str, str2, th);
        }
    }

    public static void e(String str) {
        e(f500a, str);
    }

    public static void e(String str, String str2) {
        if (f501b) {
            b(4, str, str2, (Throwable) null);
        }
    }
}
