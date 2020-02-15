package com.xiaomi.stat.a;

import android.text.TextUtils;
import com.xiaomi.stat.a.l;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final int f320a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f321b = 1;

    /* renamed from: c  reason: collision with root package name */
    private String f322c;

    /* renamed from: d  reason: collision with root package name */
    private int f323d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f324e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f325f;

    public b(String str, int i, boolean z) {
        this.f322c = str;
        this.f323d = i;
        this.f324e = z;
        this.f325f = TextUtils.isEmpty(str);
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        sb.append(j.i);
        if (this.f325f) {
            sb.append(" is null");
        } else {
            sb.append(" = \"");
            sb.append(this.f322c);
            sb.append("\"");
        }
        if (this.f323d != 0) {
            sb.append(" and ");
            sb.append("eg");
            sb.append(" = \"");
            sb.append(l.a.h);
            sb.append("\"");
        }
        sb.append(" and ");
        sb.append(j.j);
        sb.append(" = ");
        sb.append(this.f324e ? 1 : 0);
        return sb.toString();
    }

    public boolean a(String str, String str2, boolean z) {
        if (TextUtils.equals(str, this.f322c) && this.f324e == z) {
            if (this.f323d == 0) {
                return true;
            }
            return this.f325f && TextUtils.equals(str2, l.a.h);
        }
    }
}
