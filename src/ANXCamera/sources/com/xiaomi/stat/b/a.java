package com.xiaomi.stat.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.xiaomi.stat.A;
import com.xiaomi.stat.C0159b;
import com.xiaomi.stat.I;
import com.xiaomi.stat.c.c;
import com.xiaomi.stat.d.k;
import com.xiaomi.stat.d.l;
import com.xiaomi.stat.d.r;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import org.json.JSONObject;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f369a = "ConfigManager";

    /* renamed from: b  reason: collision with root package name */
    private static final String f370b = "-";

    /* renamed from: c  reason: collision with root package name */
    private static int f371c = 0;

    /* renamed from: d  reason: collision with root package name */
    private static int f372d = 1;

    /* renamed from: e  reason: collision with root package name */
    private static int f373e = 2;

    /* renamed from: f  reason: collision with root package name */
    private static final String f374f = "config_request_count";
    private static final String g = "config_request_time";
    private static final String h = "config_success_requested";
    private static final int i = 1;
    private static final int j = 2;
    private static final int k = 0;
    private static final int l = -1;
    private static final int m = 0;
    private static final int n = 12;
    private static final String o = "t";
    private static final int p = 0;
    private static volatile a q;
    /* access modifiers changed from: private */
    public int r = 0;
    private Context s = I.a();
    private String t;
    /* access modifiers changed from: private */
    public BroadcastReceiver u = new b(this);

    private a() {
    }

    public static a a() {
        if (q == null) {
            synchronized (a.class) {
                if (q == null) {
                    q = new a();
                }
            }
        }
        return q;
    }

    private void a(int i2) {
        if (i2 > 0) {
            try {
                Thread.sleep((long) (i2 * 1000));
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
        b();
    }

    private void a(String str) {
        try {
            k.b(f369a, String.format("config result:%s", new Object[]{str}));
            d();
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.getInt("errorCode") == 0) {
                    long optLong = jSONObject.optLong(C0159b.j, 0);
                    A.a().b(h, optLong);
                    C0159b.c(jSONObject.optString(C0159b.i, C0159b.l));
                    C0159b.c(jSONObject.optInt(C0159b.h, -1));
                    C0159b.d(jSONObject.optInt(C0159b.g, 0) / 1000);
                    r.a(optLong);
                    f.a().a(jSONObject);
                    if (this.r == 1) {
                        this.s.unregisterReceiver(this.u);
                    }
                    this.r = 2;
                }
            }
        } catch (Exception e2) {
            k.d(f369a, "processResult exception", e2);
        }
    }

    private String b() {
        k.b(f369a, "requestConfigInner");
        this.t = f.a().b();
        String str = null;
        try {
            TreeMap treeMap = new TreeMap();
            treeMap.put(o, String.valueOf(f373e));
            treeMap.put("ai", I.b());
            str = c.a(this.t, (Map<String, String>) treeMap, false);
            a(str);
            return str;
        } catch (Exception e2) {
            k.b(f369a, "requestConfigInner exception ", e2);
            return str;
        }
    }

    private boolean c() {
        long b2 = r.b();
        A a2 = A.a();
        try {
            if (!A.a().a(g)) {
                a2.b(g, b2);
                a2.b(f374f, 1);
                return false;
            } else if (r.b(a2.a(g, 0))) {
                return a2.a(f374f, 0) >= 12;
            } else {
                a2.b(g, b2);
                a2.b(f374f, 0);
                return false;
            }
        } catch (Exception e2) {
            k.d(f369a, "isRequestCountReachMax exception", e2);
            return false;
        }
    }

    private void d() {
        try {
            A a2 = A.a();
            a2.b(f374f, a2.a(f374f, 0) + 1);
        } catch (Exception e2) {
            k.d(f369a, "addRequestCount exception", e2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a1, code lost:
        return;
     */
    public synchronized void a(boolean z, boolean z2) {
        if (C0159b.a()) {
            if (C0159b.b()) {
                if (!l.a()) {
                    k.b(f369a, "network is not connected!");
                    this.r = 1;
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    this.s.registerReceiver(this.u, intentFilter);
                    return;
                }
                k.b(f369a, "updateConfig");
                if (!z2) {
                    k.b("MI_STAT_TEST", "updateConfig-InToday");
                    if (r.b(A.a().a(h, 0))) {
                        k.b(f369a, "Today has successfully requested key.");
                        return;
                    } else if (c()) {
                        k.d(f369a, "config request to max count skip..");
                        return;
                    }
                }
                int i2 = 0;
                if (!z || z2) {
                    a(0);
                } else {
                    String[] split = C0159b.k().split(f370b);
                    if (split.length > 1) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        if (parseInt2 > parseInt) {
                            i2 = new Random().nextInt(parseInt2 - parseInt) + parseInt;
                        }
                    }
                    a(i2);
                }
            }
        }
        k.c(f369a, "update abort: statistic or network is not enabled");
    }
}
