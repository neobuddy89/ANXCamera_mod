package com.xiaomi.stat;

import com.xiaomi.stat.d.k;
import com.xiaomi.stat.d.n;
import org.json.JSONException;
import org.json.JSONObject;

public class MiStatParams {

    /* renamed from: a  reason: collision with root package name */
    private static final String f309a = "MiStatParams";

    /* renamed from: b  reason: collision with root package name */
    private JSONObject f310b;

    public MiStatParams() {
        this.f310b = new JSONObject();
    }

    MiStatParams(MiStatParams miStatParams) {
        if (miStatParams != null) {
            JSONObject jSONObject = miStatParams.f310b;
            if (jSONObject != null) {
                this.f310b = jSONObject;
                return;
            }
        }
        this.f310b = new JSONObject();
    }

    private boolean c(String str) {
        return a() && !this.f310b.has(str) && this.f310b.length() == 30;
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean a(String str) {
        return n.a(str);
    }

    /* access modifiers changed from: package-private */
    public boolean b(String str) {
        return n.b(str);
    }

    public int getParamsNumber() {
        return this.f310b.length();
    }

    public boolean isEmpty() {
        return this.f310b.length() == 0;
    }

    public void putBoolean(String str, boolean z) {
        if (!a(str)) {
            n.e(str);
        } else if (c(str)) {
            n.a();
        } else {
            try {
                this.f310b.put(str, z);
            } catch (JSONException e2) {
                k.c(f309a, "put value error " + e2);
            }
        }
    }

    public void putDouble(String str, double d2) {
        if (!a(str)) {
            n.e(str);
        } else if (c(str)) {
            n.a();
        } else {
            try {
                this.f310b.put(str, d2);
            } catch (JSONException e2) {
                k.c(f309a, "put value error " + e2);
            }
        }
    }

    public void putInt(String str, int i) {
        if (!a(str)) {
            n.e(str);
        } else if (c(str)) {
            n.a();
        } else {
            try {
                this.f310b.put(str, i);
            } catch (JSONException e2) {
                k.c(f309a, "put value error " + e2);
            }
        }
    }

    public void putLong(String str, long j) {
        if (!a(str)) {
            n.e(str);
        } else if (c(str)) {
            n.a();
        } else {
            try {
                this.f310b.put(str, j);
            } catch (JSONException e2) {
                k.c(f309a, "put value error " + e2);
            }
        }
    }

    public void putString(String str, String str2) {
        if (!a(str)) {
            n.e(str);
        } else if (!b(str2)) {
            n.f(str2);
        } else if (c(str)) {
            n.a();
        } else {
            try {
                this.f310b.put(str, n.c(str2));
            } catch (JSONException e2) {
                k.c(f309a, "put value error " + e2);
            }
        }
    }

    public String toJsonString() {
        return this.f310b.toString();
    }
}
