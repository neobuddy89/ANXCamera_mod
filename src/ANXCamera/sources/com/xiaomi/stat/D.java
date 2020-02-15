package com.xiaomi.stat;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.xiaomi.stat.A;
import com.xiaomi.stat.d.k;

class D implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f276a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f277b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ A f278c;

    D(A a2, String str, String str2) {
        this.f278c = a2;
        this.f276a = str;
        this.f277b = str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    public void run() {
        Cursor cursor = null;
        try {
            SQLiteDatabase writableDatabase = this.f278c.f267f.getWritableDatabase();
            if (TextUtils.isEmpty(this.f276a)) {
                writableDatabase.delete(A.a.f269b, "pref_key=?", new String[]{this.f277b});
                return;
            }
            Cursor query = writableDatabase.query(A.a.f269b, (String[]) null, "pref_key=?", new String[]{this.f277b}, (String) null, (String) null, (String) null);
            try {
                boolean z = query.getCount() <= 0;
                ContentValues contentValues = new ContentValues();
                contentValues.put(A.a.f270c, this.f277b);
                contentValues.put(A.a.f271d, this.f276a);
                if (z) {
                    writableDatabase.insert(A.a.f269b, (String) null, contentValues);
                } else {
                    writableDatabase.update(A.a.f269b, contentValues, "pref_key=?", new String[]{this.f277b});
                }
                if (query != null) {
                    query.close();
                }
            } catch (Exception e2) {
                e = e2;
                cursor = query;
                try {
                    k.c("MiStatPref", "update pref db failed with " + e);
                    if (cursor == null) {
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = query;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            k.c("MiStatPref", "update pref db failed with " + e);
            if (cursor == null) {
                cursor.close();
            }
        }
    }
}
