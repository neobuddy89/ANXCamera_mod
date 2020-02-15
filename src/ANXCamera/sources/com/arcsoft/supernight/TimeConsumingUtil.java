package com.arcsoft.supernight;

import java.util.HashMap;

public class TimeConsumingUtil {
    public static boolean DEBUG = false;

    /* renamed from: a  reason: collision with root package name */
    private static HashMap<String, Long> f236a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private static final String f237b = "Performance";

    public static void startTheTimer(String str) {
        if (DEBUG) {
            HashMap<String, Long> hashMap = f236a;
            if (hashMap != null) {
                hashMap.put(str, Long.valueOf(System.currentTimeMillis()));
            }
        }
    }

    public static void stopTiming(String str) {
        if (DEBUG) {
            HashMap<String, Long> hashMap = f236a;
            if (hashMap != null && hashMap.containsKey(str)) {
                long longValue = f236a.get(str).longValue();
                LOG.d(f237b, "" + str + " : " + (System.currentTimeMillis() - longValue) + " ms");
            }
        }
    }

    public static void stopTiming(String str, String str2) {
        if (DEBUG) {
            HashMap<String, Long> hashMap = f236a;
            if (hashMap != null && hashMap.containsKey(str2)) {
                long longValue = f236a.get(str2).longValue();
                LOG.d(str, "" + str2 + " : " + (System.currentTimeMillis() - longValue));
            }
        }
    }
}
