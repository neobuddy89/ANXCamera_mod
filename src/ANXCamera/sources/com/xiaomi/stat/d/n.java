package com.xiaomi.stat.d;

import android.text.TextUtils;
import java.util.regex.Pattern;

public class n {

    /* renamed from: a  reason: collision with root package name */
    private static final int f520a = 64;

    /* renamed from: b  reason: collision with root package name */
    private static final int f521b = 256;

    /* renamed from: c  reason: collision with root package name */
    private static final int f522c = 10240;

    /* renamed from: d  reason: collision with root package name */
    private static final String f523d = "mistat_";

    /* renamed from: e  reason: collision with root package name */
    private static final String f524e = "mi_";

    /* renamed from: f  reason: collision with root package name */
    private static final String f525f = "abtest_";
    private static final String g = "null";
    private static Pattern h = Pattern.compile("^[a-zA-Z_][a-zA-Z0-9_]*");

    public static void a() {
        k.e("parameter number exceed limits");
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str) || str.length() > 64 || str.startsWith(f523d) || str.startsWith(f524e) || str.startsWith(f525f)) {
            return false;
        }
        return h.matcher(str).matches();
    }

    public static boolean b(String str) {
        return str == null || str.length() <= 256;
    }

    public static String c(String str) {
        return str == null ? "null" : str;
    }

    public static boolean d(String str) {
        return str == null || str.length() <= f522c;
    }

    public static void e(String str) {
        k.e("invalid parameter name: " + str);
    }

    public static void f(String str) {
        k.e("parameter value is too long: " + str);
    }
}
