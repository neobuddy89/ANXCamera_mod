package com.xiaomi.stat.b;

import android.content.Context;
import android.text.TextUtils;
import com.android.camera.module.loader.FunctionParseBeautyBodySlimCount;
import com.xiaomi.stat.A;
import com.xiaomi.stat.C0154a;
import com.xiaomi.stat.C0155b;
import com.xiaomi.stat.C0157d;
import com.xiaomi.stat.I;
import com.xiaomi.stat.c.c;
import com.xiaomi.stat.d.e;
import com.xiaomi.stat.d.g;
import com.xiaomi.stat.d.k;
import com.xiaomi.stat.d.l;
import com.xiaomi.stat.d.r;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f377a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static final String f378b = " http://data.mistat.xiaomi.com/idservice/deviceid_get";

    /* renamed from: c  reason: collision with root package name */
    private static final String f379c = "DeviceIdManager";

    /* renamed from: d  reason: collision with root package name */
    private static final String f380d = "ia";

    /* renamed from: e  reason: collision with root package name */
    private static final String f381e = "ib";

    /* renamed from: f  reason: collision with root package name */
    private static final String f382f = "md";
    private static final String g = "mm";
    private static final String h = "bm";
    private static final String i = "aa";
    private static final String j = "ai";
    private static final int k = 0;
    private static final int l = 1;
    private static final int m = 2;
    private static final int n = 3;
    private static final int o = 4;
    private static final int p = 5;
    private static final int q = 6;
    private static final int r = 1;
    private static final String s = "pref_key_device_id";
    private static final String t = "pref_key_restore_ts";
    private static d u;
    private String v = A.a().a(s, "");
    private Context w = I.a();

    private d() {
    }

    public static d a() {
        if (u == null) {
            synchronized (f377a) {
                if (u == null) {
                    u = new d();
                }
            }
        }
        return u;
    }

    private void e() {
        if (!C0155b.a() || !C0155b.b()) {
            k.c(f379c, "request abort: statistic or network is not enabled");
        } else if (l.a()) {
            int i2 = 1;
            while (i2 <= 3 && f() && i2 != 3) {
                try {
                    Thread.sleep(FunctionParseBeautyBodySlimCount.TIP_INTERVAL_TIME);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                i2++;
            }
        } else {
            k.b(f379c, "network is not connected!");
        }
    }

    private boolean f() {
        try {
            String a2 = c.a(f378b, (Map<String, String>) h(), true);
            k.b(f379c, a2);
            if (!TextUtils.isEmpty(a2)) {
                JSONObject jSONObject = new JSONObject(a2);
                long optLong = jSONObject.optLong("timestamp");
                int optInt = jSONObject.optInt("code");
                String optString = jSONObject.optString("device_id");
                if (optInt == 1) {
                    this.v = optString;
                    A a3 = A.a();
                    if (!TextUtils.isEmpty(this.v)) {
                        a3.b(s, optString);
                        a3.b(t, optLong);
                    }
                    r.a(optLong);
                    return false;
                }
            }
        } catch (IOException e2) {
            k.b(f379c, "[getDeviceIdLocal IOException]:", e2);
        } catch (JSONException e3) {
            k.b(f379c, "[getDeviceIdLocal JSONException]:", e3);
        }
        return true;
    }

    private String[] g() {
        return new String[]{e.b(this.w), e.e(this.w), e.h(this.w), e.k(this.w), e.n(this.w), e.q(this.w), e.p(this.w)};
    }

    private HashMap<String, String> h() {
        HashMap<String, String> hashMap = new HashMap<>();
        String[] g2 = g();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ia", g2[0]);
            jSONObject.put("ib", g2[1]);
            jSONObject.put("md", g2[2]);
            jSONObject.put("mm", g2[3]);
            jSONObject.put("bm", g2[4]);
            jSONObject.put("aa", g2[5]);
            jSONObject.put("ai", g2[6]);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        k.b(f379c, "[pay-load]:" + jSONObject.toString());
        byte[] bArr = new byte[0];
        try {
            bArr = h.a().a(jSONObject.toString().getBytes("utf-8"));
        } catch (UnsupportedEncodingException e3) {
            e3.printStackTrace();
        }
        String str = null;
        if (bArr != null) {
            str = com.xiaomi.stat.d.d.a(g.a(bArr, true).getBytes());
        }
        hashMap.put(C0157d.f452b, C0154a.g);
        if (str == null) {
            str = "";
        }
        hashMap.put("p", str);
        hashMap.put("ai", I.b());
        hashMap.put("gzip", "0");
        hashMap.put(C0157d.ak, h.a().c());
        hashMap.put(C0157d.g, h.a().b());
        return hashMap;
    }

    public String a(boolean z) {
        if (z) {
            return e.d();
        }
        String r2 = e.r(I.a());
        return !TextUtils.isEmpty(r2) ? r2 : e.d();
    }

    public synchronized String b() {
        if (C0155b.e()) {
            this.v = e.d();
        } else if (!d()) {
            e();
        }
        return this.v;
    }

    public String c() {
        return this.v;
    }

    public boolean d() {
        String a2 = A.a().a(s, (String) null);
        return !TextUtils.isEmpty(a2) && !TextUtils.isEmpty(this.v) && this.v.equals(a2);
    }
}
