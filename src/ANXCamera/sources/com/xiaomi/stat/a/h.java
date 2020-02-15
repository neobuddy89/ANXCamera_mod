package com.xiaomi.stat.a;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.xiaomi.stat.I;

class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f339a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ c f340b;

    h(c cVar, String str) {
        this.f340b = cVar;
        this.f339a = str;
    }

    public void run() {
        String str;
        String[] strArr;
        SQLiteDatabase writableDatabase = this.f340b.l.getWritableDatabase();
        if (TextUtils.equals(this.f339a, I.b())) {
            strArr = null;
            str = "sub is null";
        } else {
            strArr = new String[]{this.f339a};
            str = "sub = ?";
        }
        writableDatabase.delete(j.f343b, str, strArr);
    }
}
