package com.xiaomi.stat;

import android.os.Looper;
import android.text.TextUtils;
import com.xiaomi.stat.d.m;

/* renamed from: com.xiaomi.stat.b  reason: case insensitive filesystem */
public class C0159b {
    private static final String A = "pref_system_upload_intl_enabled";
    private static int B = 31;
    private static int C = 15;
    private static String[] D = null;
    private static final String E = ",";
    private static boolean F = false;
    private static boolean G = false;
    private static String H = null;
    private static boolean I = false;
    private static Object J = new Object();
    private static boolean K = false;

    /* renamed from: a  reason: collision with root package name */
    public static final int f363a = -1;

    /* renamed from: b  reason: collision with root package name */
    public static final int f364b = -1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f365c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static final int f366d = 1;

    /* renamed from: e  reason: collision with root package name */
    public static final int f367e = 2;

    /* renamed from: f  reason: collision with root package name */
    public static final int f368f = -1;
    public static final String g = "uploadInterval";
    public static final String h = "configNetwork";
    public static final String i = "configDelay";
    public static final String j = "time";
    public static final String k = "0.0";
    public static final String l = "0-0";
    public static final int m = 0;
    private static final String n = "pref_statistic_enabled";
    private static final String o = "pref_network_access_enabled";
    private static final String p = "pref_user_id";
    private static final String q = "pref_random_uuid";
    private static final String r = "pref_using_custom_policy_";
    private static final String s = "pref_custom_policy_state_";
    private static final String t = "pref_app_previous_version";
    private static final String u = "pref_is_first_usage";
    private static final String v = "pref_last_dau_event_time";
    private static final String w = "pref_all_sub_ids_data";
    private static final String x = "pref_instance_id";
    private static final String y = "pref_main_app_channel";
    private static final String z = "pref_instance_id_last_use_time";

    static {
        n();
    }

    public static void a(int i2) {
        B = i2;
    }

    public static void a(long j2) {
        A.a().b(v, j2);
    }

    public static void a(String str) {
        H = str;
    }

    public static void a(String str, int i2) {
        if (!TextUtils.isEmpty(str)) {
            A a2 = A.a();
            a2.b(s + str, i2);
        }
    }

    public static void a(String str, boolean z2) {
        if (!TextUtils.isEmpty(str)) {
            A a2 = A.a();
            a2.b(r + str, z2);
        }
    }

    public static void a(boolean z2) {
        A.a().b(n, z2);
    }

    public static boolean a() {
        return A.a().a(n, true);
    }

    public static void b(int i2) {
        if (i2 <= 5) {
            i2 = 15;
        } else if (i2 > 86400) {
            i2 = 86400;
        }
        C = i2;
    }

    public static void b(long j2) {
        A.a().b(z, j2);
    }

    public static void b(String str) {
        A.a().b(p, str);
    }

    public static void b(boolean z2) {
        A.a().b(o, z2);
    }

    public static boolean b() {
        return A.a().a(o, true);
    }

    public static void c() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            long j2 = 5000;
            if (A.a().a(o)) {
                j2 = 1000;
            }
            try {
                Thread.sleep(j2);
            } catch (InterruptedException unused) {
            }
        } else {
            throw new IllegalStateException("don't call this on main thread");
        }
    }

    public static void c(int i2) {
        A.a().b(h, i2);
    }

    public static void c(String str) {
        A.a().b(i, str);
    }

    public static void c(boolean z2) {
        G = z2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
        return;
     */
    public static void d() {
        synchronized (J) {
            if (!I) {
                I = true;
                G = m.i();
                H = m.g();
                if (!G && !TextUtils.equals(H, "CN")) {
                    G = true;
                }
            }
        }
    }

    public static void d(int i2) {
        A.a().b(g, i2);
    }

    public static void d(boolean z2) {
        K = z2;
    }

    public static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        A a2 = A.a();
        return a2.a(r + str, false);
    }

    public static int e(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        A a2 = A.a();
        return a2.a(s + str, 0);
    }

    public static void e(int i2) {
        if (i2 > 0) {
            A.a().b(t, i2);
        }
    }

    public static void e(boolean z2) {
        A.a().b(u, z2);
    }

    public static boolean e() {
        if (!I) {
            d();
        }
        return G;
    }

    public static String f() {
        return H;
    }

    public static void f(String str) {
        String[] strArr = D;
        if (strArr != null) {
            int length = strArr.length;
            int i2 = 0;
            while (i2 < length) {
                if (!TextUtils.equals(str, strArr[i2])) {
                    i2++;
                } else {
                    return;
                }
            }
        }
        if (D == null) {
            A.a().b(w, str);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(D[0]);
        int length2 = D.length;
        for (int i3 = 1; i3 < length2; i3++) {
            sb.append(E);
            sb.append(D[i3]);
        }
        sb.append(E);
        sb.append(str);
        A.a().b(w, sb.toString());
    }

    public static void f(boolean z2) {
        F = z2;
    }

    public static void g(String str) {
        A.a().b(x, str);
    }

    public static void g(boolean z2) {
        A.a().b(A, z2);
    }

    public static boolean g() {
        return K;
    }

    public static String h() {
        return A.a().a(p, (String) null);
    }

    public static void h(String str) {
        A.a().b(y, str);
    }

    public static int i() {
        return B;
    }

    public static void i(String str) {
        A.a().b(q, str);
    }

    public static int j() {
        return C;
    }

    public static String k() {
        return A.a().a(i, l);
    }

    public static int l() {
        return A.a().a(h, -1);
    }

    public static int m() {
        return A.a().a(g, -1);
    }

    public static void n() {
        String a2 = A.a().a(w, (String) null);
        if (!TextUtils.isEmpty(a2)) {
            D = a2.split(E);
        }
    }

    public static String[] o() {
        return D;
    }

    public static int p() {
        return A.a().a(t, -1);
    }

    public static boolean q() {
        return A.a().a(u, true);
    }

    public static long r() {
        return A.a().a(v, -1);
    }

    public static String s() {
        return A.a().a(x, (String) null);
    }

    public static String t() {
        return A.a().a(y, (String) null);
    }

    public static boolean u() {
        return F;
    }

    public static long v() {
        return A.a().a(z, 0);
    }

    public static String w() {
        return A.a().a(q, (String) null);
    }

    public static boolean x() {
        return A.a().a(A, false);
    }
}
