package com.xiaomi.stat.c;

import android.content.Context;
import com.xiaomi.stat.C0159b;
import com.xiaomi.stat.I;
import com.xiaomi.stat.d.k;
import java.util.HashMap;
import java.util.Map;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f411a = "ClientConfigMoniter";

    /* renamed from: b  reason: collision with root package name */
    private static final int f412b = 1;

    /* renamed from: c  reason: collision with root package name */
    private static final int f413c = 2;

    /* renamed from: d  reason: collision with root package name */
    private static final int f414d = 3;

    /* renamed from: e  reason: collision with root package name */
    private static final int f415e = 4;

    /* renamed from: f  reason: collision with root package name */
    private static final int f416f = 5;
    private static Context g = I.a();
    private static HashMap<Integer, Integer> h = new HashMap<>();

    static {
        h.put(1, 1);
        h.put(2, 2);
        h.put(3, 4);
        h.put(4, 8);
        h.put(5, 16);
    }

    public static int a(String str) {
        int i = 0;
        try {
            for (Map.Entry next : h.entrySet()) {
                int intValue = ((Integer) next.getKey()).intValue();
                int intValue2 = ((Integer) next.getValue()).intValue();
                if (a(intValue, str)) {
                    i |= intValue2;
                }
            }
        } catch (Exception e2) {
            k.d(f411a, "getClientConfiguration exception", e2);
        }
        return i;
    }

    private static boolean a(int i, String str) {
        if (i == 1) {
            return C0159b.u();
        }
        if (i == 2) {
            return C0159b.d(str);
        }
        if (i == 3) {
            return k.a();
        }
        if (i == 4 || i != 5) {
            return false;
        }
        try {
            return C0159b.g();
        } catch (Exception e2) {
            k.d(f411a, "checkSetting exception", e2);
            return false;
        }
    }
}
