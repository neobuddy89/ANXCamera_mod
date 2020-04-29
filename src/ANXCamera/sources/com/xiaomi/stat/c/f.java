package com.xiaomi.stat.c;

import com.xiaomi.stat.C0155b;
import com.xiaomi.stat.I;
import com.xiaomi.stat.d.k;
import com.xiaomi.stat.d.l;
import com.xiaomi.stat.d.m;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final int f431a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static final int f432b = 2;

    /* renamed from: c  reason: collision with root package name */
    public static final int f433c = 3;

    /* renamed from: e  reason: collision with root package name */
    private static final String f434e = "UploadPolicy";

    /* renamed from: d  reason: collision with root package name */
    boolean f435d;

    /* renamed from: f  reason: collision with root package name */
    private String f436f;

    public f(String str, boolean z) {
        this.f435d = z;
        this.f436f = str;
    }

    public f(boolean z) {
        this.f435d = z;
        this.f436f = I.b();
    }

    private boolean a(int i) {
        return (i & -32) == 0;
    }

    private int b() {
        boolean b2 = m.b(I.a());
        k.b("UploadPolicy getExperiencePlanPolicy: " + b2 + " isInternationalVersion= " + C0155b.e() + " isAnonymous= " + this.f435d);
        if (b2) {
            return 3;
        }
        return (!C0155b.e() || !this.f435d) ? 2 : 3;
    }

    private int c() {
        int e2 = C0155b.e(this.f436f);
        k.b("UploadPolicy getCustomPrivacyPolicy: state=" + e2);
        return e2 == 1 ? 3 : 1;
    }

    private int d() {
        return C0155b.d(this.f436f) ? c() : b();
    }

    private int e() {
        int a2 = l.a(I.a());
        int l = a(C0155b.l()) ? C0155b.l() : C0155b.i();
        StringBuilder sb = new StringBuilder();
        sb.append("UploadPolicy getHttpServicePolicy: currentNet= ");
        sb.append(a2);
        sb.append(" Config.getServerNetworkType= ");
        sb.append(C0155b.l());
        sb.append(" Config.getUserNetworkType()= ");
        sb.append(C0155b.i());
        sb.append(" (configNet & currentNet) == currentNet ");
        int i = l & a2;
        sb.append(i == a2);
        k.b(sb.toString());
        return i == a2 ? 3 : 1;
    }

    private int f() {
        return l.a(I.a()) == 8 ? 3 : 1;
    }

    private int g() {
        return (!C0155b.u() || !c.a()) ? e() : f();
    }

    public int a() {
        return Math.min(d(), g());
    }
}
