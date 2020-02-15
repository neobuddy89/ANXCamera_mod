package com.xiaomi.stat;

import android.database.Cursor;
import com.xiaomi.stat.A;
import java.util.concurrent.Callable;

class B implements Callable<Cursor> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ A f274a;

    B(A a2) {
        this.f274a = a2;
    }

    /* renamed from: a */
    public Cursor call() throws Exception {
        try {
            return this.f274a.f267f.getWritableDatabase().query(A.a.f269b, (String[]) null, (String) null, (String[]) null, (String) null, (String) null, (String) null);
        } catch (Exception unused) {
            return null;
        }
    }
}
