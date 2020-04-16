package com.xiaomi.stat.c;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.xiaomi.stat.C0159b;
import com.xiaomi.stat.C0161d;
import com.xiaomi.stat.I;
import com.xiaomi.stat.d.i;
import java.io.IOException;
import java.util.Map;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f423a = "com.xiaomi.xmsf";

    /* renamed from: b  reason: collision with root package name */
    public static final String f424b = "com.xiaomi.xmsf.push.service.HttpService";

    /* renamed from: c  reason: collision with root package name */
    private static final String f425c = "UploadMode";

    private static ServiceConnection a(String str, Map<String, String> map, String[] strArr) {
        return new d(strArr, str, map);
    }

    public static String a(String str, Map<String, String> map, boolean z) throws IOException {
        return (!C0159b.u() || !a()) ? i.b(str, map, z) : b(str, map, z);
    }

    public static boolean a() {
        boolean z;
        Context a2 = I.a();
        if (a2 == null) {
            return false;
        }
        boolean z2 = (a2.getApplicationInfo().flags & 1) == 1;
        PackageManager packageManager = a2.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(a2.getPackageName(), 64);
            PackageInfo packageInfo2 = packageManager.getPackageInfo("android", 64);
            if (!(packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length <= 0 || packageInfo2 == null || packageInfo2.signatures == null || packageInfo2.signatures.length <= 0)) {
                z = packageInfo2.signatures[0].equals(packageInfo.signatures[0]);
                return !z2 || z;
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        z = false;
        if (!z2) {
        }
    }

    public static String b(String str, Map<String, String> map, boolean z) {
        if (z) {
            map.put(C0161d.f456f, i.a(map));
        }
        Intent intent = new Intent();
        intent.setClassName(f423a, f424b);
        Context a2 = I.a();
        String[] strArr = new String[1];
        if (a2 == null) {
            return strArr[0];
        }
        ServiceConnection a3 = a(str, map, strArr);
        boolean bindService = a2.bindService(intent, a3, 1);
        synchronized (i.class) {
            try {
                i.class.wait(15000);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
        if (!bindService) {
            strArr[0] = null;
        }
        if (bindService) {
            a2.unbindService(a3);
        }
        return strArr[0];
    }
}
