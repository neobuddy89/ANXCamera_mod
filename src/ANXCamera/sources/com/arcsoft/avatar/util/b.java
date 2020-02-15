package com.arcsoft.avatar.util;

import android.util.Log;

/* compiled from: LogUtil */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private boolean f153a = false;

    /* renamed from: b  reason: collision with root package name */
    private String f154b;

    public b(String str) {
        this.f154b = str;
    }

    public void a(String str) {
        if (this.f153a) {
            Log.d(this.f154b, str);
        }
    }

    public void b(String str) {
        if (this.f153a) {
            Log.i(this.f154b, str);
        }
    }

    public void c(String str) {
        Log.e(this.f154b, str);
    }
}
