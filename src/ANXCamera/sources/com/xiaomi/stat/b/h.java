package com.xiaomi.stat.b;

import android.content.Context;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.android.camera.module.loader.FunctionParseBeautyBodySlimCount;
import com.xiaomi.stat.A;
import com.xiaomi.stat.C0155b;
import com.xiaomi.stat.I;
import com.xiaomi.stat.c.c;
import com.xiaomi.stat.d.a;
import com.xiaomi.stat.d.b;
import com.xiaomi.stat.d.d;
import com.xiaomi.stat.d.g;
import com.xiaomi.stat.d.k;
import com.xiaomi.stat.d.l;
import com.xiaomi.stat.d.o;
import com.xiaomi.stat.d.r;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private static final String f398a = "SecretKeyManager";

    /* renamed from: b  reason: collision with root package name */
    private static final String f399b = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCA1ynlvPE46RxIPx6qrb8f20DU\n\rkAJgwHtD3zCEkgOjcvFY2mLl0UGnK1F0Vsh4LvImSCa8o8qYYfBguROgIXRdJGZ+\n\rk9stSV7vWmcsxphMfHEE9R4q+QWqgPBSzwyWmwmAQ7PZmHifOrEYl9t/l0YtmjnW\n\r8Zs3aL7Ap9CGse2kWwIDAQAB\r";

    /* renamed from: c  reason: collision with root package name */
    private static final String f400c = "sid";

    /* renamed from: d  reason: collision with root package name */
    private static final String f401d = "sk";

    /* renamed from: e  reason: collision with root package name */
    private static final String f402e = "rt";

    /* renamed from: f  reason: collision with root package name */
    private static final String f403f = "rc";
    private static final String g = "request_history";
    private static final String h = "last_aes_content";
    private static final String i = "last_success_time";
    private static final String j = "4ef8b4ac42dbc3f95320b73ae0edbd43";
    private static final String k = "050f03d86eeafeb29cf38986462d957c";
    private static final int l = 1;
    private static final int m = 2;
    private static final String n = "1";
    private static final String o = "0";
    private static final int p = 7;
    private static final int q = 15;
    private static volatile h r;
    private Context s = I.a();
    private byte[] t;
    private byte[] u;
    private String v;

    private h() {
        d();
    }

    public static h a() {
        if (r == null) {
            synchronized (h.class) {
                if (r == null) {
                    r = new h();
                }
            }
        }
        return r;
    }

    private boolean b(boolean z) {
        if (Build.VERSION.SDK_INT < 18) {
            k.b(f398a, "under 4.3,use randomly generated key");
            return false;
        }
        if (j()) {
            k();
        }
        JSONObject g2 = g();
        if (g2 != null) {
            String optString = g2.optString("sid");
            if (!TextUtils.isEmpty(g2.optString("sk")) && !TextUtils.isEmpty(optString) && !z) {
                k.b(f398a, "key and sid already requested successfully in recent 7 days!");
                return false;
            }
        }
        JSONObject h2 = h();
        long optLong = h2.optLong(f402e);
        int optInt = h2.optInt("rc");
        if (!r.b(optLong) || optInt < 15 || z) {
            return f();
        }
        k.b(f398a, "request count > max count today, skip...");
        return false;
    }

    private void d() {
        this.u = a.a();
        byte[] bArr = this.u;
        if (bArr == null || bArr.length <= 0) {
            this.u = a.a(k);
        }
        String concat = g.a(this.u, true).concat("_").concat(String.valueOf(r.b()));
        try {
            concat = g.a(concat.getBytes("utf-8"), true);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        this.t = a.a(a.a(concat), j);
    }

    private String e() {
        String str;
        String str2 = null;
        if (Build.VERSION.SDK_INT >= 18) {
            JSONObject g2 = g();
            if (g2 != null) {
                str2 = g2.optString("sk");
                str = g2.optString("sid");
                return (!TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) ? g.a(this.u, true) : str2;
            }
        }
        str = null;
        if (!TextUtils.isEmpty(str2)) {
        }
    }

    private boolean f() {
        boolean z = false;
        try {
            byte[] a2 = a.a();
            String a3 = d.a(o.a(d.a(f399b), a2));
            i();
            HashMap hashMap = new HashMap();
            hashMap.put("skey_rsa", a3);
            String a4 = c.a(f.a().d(), (Map<String, String>) hashMap, false);
            if (!TextUtils.isEmpty(a4)) {
                k.b(f398a, "result:" + a4);
                JSONObject jSONObject = new JSONObject(a4);
                String optString = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE);
                int optInt = jSONObject.optInt("code");
                long optLong = jSONObject.optLong("curTime");
                JSONObject optJSONObject = jSONObject.optJSONObject("result");
                if (optInt == 1 && optJSONObject != null) {
                    try {
                        String optString2 = optJSONObject.optString("sid");
                        String a5 = a.a(optJSONObject.optString("key"), a2);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("sk", a5);
                        jSONObject2.put("sid", optString2);
                        this.v = jSONObject2.toString();
                        A.a().b("last_aes_content", b.a(this.s, jSONObject2.toString()));
                        A.a().b("last_success_time", optLong);
                        r.a(optLong);
                        return false;
                    } catch (Exception e2) {
                        e = e2;
                    }
                } else if (optInt == 2) {
                    k.b(f398a, "update secret-key failed: " + optString);
                }
            }
            return true;
        } catch (Exception e3) {
            e = e3;
            z = true;
            k.d(f398a, "updateSecretKey e", e);
            return z;
        }
    }

    private JSONObject g() {
        String str;
        String a2 = A.a().a("last_aes_content", "");
        try {
            if (TextUtils.isEmpty(a2)) {
                return null;
            }
            if (!TextUtils.isEmpty(this.v)) {
                str = this.v;
            } else {
                String b2 = b.b(this.s, a2);
                this.v = b2;
                str = b2;
            }
            return new JSONObject(str);
        } catch (Exception e2) {
            k.d(f398a, "decodeFromAndroidKeyStore e", e2);
            return null;
        }
    }

    private JSONObject h() {
        try {
            String a2 = A.a().a("request_history", "");
            if (!TextUtils.isEmpty(a2)) {
                return new JSONObject(a2);
            }
        } catch (Exception e2) {
            k.d(f398a, "getRequestHistory e", e2);
        }
        return new JSONObject();
    }

    private void i() {
        try {
            JSONObject h2 = h();
            long optLong = h2.optLong(f402e);
            int optInt = h2.optInt("rc");
            if (r.b(optLong)) {
                h2.put("rc", optInt + 1);
            } else {
                h2.put("rc", 1);
            }
            h2.put(f402e, r.b());
            A.a().b("request_history", h2.toString());
        } catch (JSONException e2) {
            k.b(f398a, "updateSecretKey e", e2);
        }
    }

    private boolean j() {
        long a2 = A.a().a("last_success_time", 0);
        return a2 != 0 && r.a(a2, 604800000);
    }

    private void k() {
        A a2 = A.a();
        this.v = null;
        a2.b("last_aes_content");
        a2.b("last_success_time");
    }

    private synchronized boolean l() {
        boolean z;
        JSONObject g2 = g();
        z = true;
        if (g2 != null) {
            String optString = g2.optString("sk");
            String optString2 = g2.optString("sid");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                z = false;
            }
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0036, code lost:
        return;
     */
    public synchronized void a(boolean z) {
        if (C0155b.a()) {
            if (C0155b.b()) {
                if (l.a()) {
                    int i2 = 1;
                    while (i2 <= 3 && b(z) && i2 != 3) {
                        try {
                            Thread.sleep(FunctionParseBeautyBodySlimCount.TIP_INTERVAL_TIME);
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                        i2++;
                    }
                } else {
                    k.b(f398a, "network not connected!");
                }
            }
        }
        k.c(f398a, "update abort: statistic or network is not enabled");
    }

    public synchronized byte[] a(byte[] bArr) {
        if (bArr == null) {
            k.b(f398a, "encrypt content is empty");
            return null;
        }
        return a.a(bArr, e());
    }

    public synchronized String b() {
        String str;
        String str2;
        str = null;
        if (Build.VERSION.SDK_INT >= 18) {
            JSONObject g2 = g();
            if (g2 != null) {
                str = g2.optString("sid");
                str2 = g2.optString("sk");
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    str = g.a(this.t, true);
                }
            }
        }
        str2 = null;
        str = g.a(this.t, true);
        return str;
    }

    public String c() {
        return (Build.VERSION.SDK_INT < 18 || l()) ? "1" : "0";
    }
}
