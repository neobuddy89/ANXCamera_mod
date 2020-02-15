package com.arcsoft.avatar.util;

import java.util.HashMap;

/* compiled from: TimeConsumingUtil */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f155a = false;

    /* renamed from: b  reason: collision with root package name */
    private static HashMap<String, Long> f156b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private static final String f157c = "PERFORMANCE";

    public static void a(String str) {
        if (f155a) {
            HashMap<String, Long> hashMap = f156b;
            if (hashMap != null) {
                hashMap.put(str, Long.valueOf(System.currentTimeMillis()));
            }
        }
    }

    public static void a(String str, String str2) {
        if (f155a) {
            HashMap<String, Long> hashMap = f156b;
            if (hashMap != null && hashMap.containsKey(str2)) {
                long longValue = f156b.get(str2).longValue();
                LOG.d(str, "" + str2 + " : " + (System.currentTimeMillis() - longValue));
            }
        }
    }

    public static void b(String str) {
        if (f155a) {
            HashMap<String, Long> hashMap = f156b;
            if (hashMap != null && hashMap.containsKey(str)) {
                long longValue = f156b.get(str).longValue();
                LOG.d(f157c, "" + str + " : " + (System.currentTimeMillis() - longValue));
            }
        }
    }
}
