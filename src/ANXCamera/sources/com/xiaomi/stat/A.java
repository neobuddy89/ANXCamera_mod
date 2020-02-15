package com.xiaomi.stat;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.xiaomi.stat.d.k;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionException;

public class A {

    /* renamed from: a  reason: collision with root package name */
    private static final String f262a = "MiStatPref";

    /* renamed from: b  reason: collision with root package name */
    private static final String f263b = "true";

    /* renamed from: c  reason: collision with root package name */
    private static final String f264c = "false";

    /* renamed from: d  reason: collision with root package name */
    private static A f265d;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, String> f266e = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public SQLiteOpenHelper f267f;

    private static class a extends SQLiteOpenHelper {

        /* renamed from: a  reason: collision with root package name */
        public static final String f268a = "mistat_pf";

        /* renamed from: b  reason: collision with root package name */
        public static final String f269b = "pref";

        /* renamed from: c  reason: collision with root package name */
        public static final String f270c = "pref_key";

        /* renamed from: d  reason: collision with root package name */
        public static final String f271d = "pref_value";

        /* renamed from: e  reason: collision with root package name */
        private static final int f272e = 1;

        /* renamed from: f  reason: collision with root package name */
        private static final String f273f = "_id";
        private static final String g = "CREATE TABLE pref (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,pref_key TEXT,pref_value TEXT)";

        public a(Context context) {
            super(context, f268a, (SQLiteDatabase.CursorFactory) null, 1);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(g);
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    private A() {
        Context a2 = I.a();
        this.f267f = new a(a2);
        b();
        c(a2.getDatabasePath(a.f268a).getAbsolutePath());
    }

    public static A a() {
        if (f265d == null) {
            synchronized (A.class) {
                if (f265d == null) {
                    f265d = new A();
                }
            }
        }
        return f265d;
    }

    /* access modifiers changed from: private */
    public void b() {
        FutureTask futureTask = new FutureTask(new B(this));
        try {
            C0156c.a(futureTask);
            Cursor cursor = null;
            try {
                cursor = (Cursor) futureTask.get();
            } catch (InterruptedException | ExecutionException unused) {
            }
            if (cursor != null) {
                this.f266e.clear();
                try {
                    k.c(f262a, "load pref from db");
                    int columnIndex = cursor.getColumnIndex(a.f270c);
                    int columnIndex2 = cursor.getColumnIndex(a.f271d);
                    while (cursor.moveToNext()) {
                        String string = cursor.getString(columnIndex);
                        String string2 = cursor.getString(columnIndex2);
                        this.f266e.put(string, string2);
                        k.c(f262a, "key=" + string + " ,value=" + string2);
                    }
                } catch (Exception unused2) {
                } catch (Throwable th) {
                    cursor.close();
                    throw th;
                }
                cursor.close();
            }
        } catch (RejectedExecutionException e2) {
            k.c(f262a, "load data execute failed with " + e2);
        }
    }

    private void c(String str) {
        new C(this, str).startWatching();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:14|15|16|17|18|19|20|21) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0050 */
    private void c(String str, String str2) {
        synchronized (this) {
            boolean z = true;
            if (!TextUtils.isEmpty(str2)) {
                this.f266e.put(str, str2);
            } else if (this.f266e.containsKey(str)) {
                this.f266e.remove(str);
            } else {
                z = false;
            }
            k.c(f262a, "put value: key=" + str + " ,value=" + str2);
            if (z) {
                FutureTask futureTask = new FutureTask(new D(this, str2, str), (Object) null);
                try {
                    C0156c.a(futureTask);
                    futureTask.get();
                } catch (RejectedExecutionException e2) {
                    k.c(f262a, "execute failed with " + e2);
                }
            }
        }
    }

    public float a(String str, float f2) {
        synchronized (this) {
            if (this.f266e.containsKey(str)) {
                try {
                    float floatValue = Float.valueOf(this.f266e.get(str)).floatValue();
                    return floatValue;
                } catch (NumberFormatException unused) {
                    return f2;
                }
            }
        }
    }

    public int a(String str, int i) {
        synchronized (this) {
            if (this.f266e.containsKey(str)) {
                try {
                    int intValue = Integer.valueOf(this.f266e.get(str)).intValue();
                    return intValue;
                } catch (NumberFormatException unused) {
                    return i;
                }
            }
        }
    }

    public long a(String str, long j) {
        synchronized (this) {
            if (this.f266e.containsKey(str)) {
                try {
                    long longValue = Long.valueOf(this.f266e.get(str)).longValue();
                    return longValue;
                } catch (NumberFormatException unused) {
                    return j;
                }
            }
        }
    }

    public String a(String str, String str2) {
        synchronized (this) {
            if (!this.f266e.containsKey(str)) {
                return str2;
            }
            String str3 = this.f266e.get(str);
            return str3;
        }
    }

    public boolean a(String str) {
        boolean containsKey;
        synchronized (this) {
            containsKey = this.f266e.containsKey(str);
        }
        return containsKey;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0028, code lost:
        return r3;
     */
    public boolean a(String str, boolean z) {
        synchronized (this) {
            if (this.f266e.containsKey(str)) {
                String str2 = this.f266e.get(str);
                if ("true".equalsIgnoreCase(str2)) {
                    return true;
                }
                if ("false".equalsIgnoreCase(str2)) {
                    return false;
                }
            }
        }
    }

    public void b(String str) {
        b(str, (String) null);
    }

    public void b(String str, float f2) {
        c(str, Float.toString(f2));
    }

    public void b(String str, int i) {
        c(str, Integer.toString(i));
    }

    public void b(String str, long j) {
        c(str, Long.toString(j));
    }

    public void b(String str, String str2) {
        c(str, str2);
    }

    public void b(String str, boolean z) {
        c(str, Boolean.toString(z));
    }
}
