package com.xiaomi.stat.d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.xiaomi.stat.I;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f467a;

    /* renamed from: b  reason: collision with root package name */
    private static int f468b;

    /* renamed from: c  reason: collision with root package name */
    private static String f469c;

    public static int a() {
        if (!f467a) {
            c();
        }
        return f468b;
    }

    public static String b() {
        if (!f467a) {
            c();
        }
        return f469c;
    }

    private static void c() {
        if (!f467a) {
            f467a = true;
            Context a2 = I.a();
            try {
                PackageInfo packageInfo = a2.getPackageManager().getPackageInfo(a2.getPackageName(), 0);
                f468b = packageInfo.versionCode;
                f469c = packageInfo.versionName;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
    }
}
