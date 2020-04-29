package com.xiaomi.stat.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.stat.C0154a;
import com.xiaomi.stat.C0156c;
import com.xiaomi.stat.I;
import com.xiaomi.stat.MiStatParams;
import com.xiaomi.stat.a.l;
import com.xiaomi.stat.d.k;
import com.xiaomi.stat.d.m;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f326a = "EventManager";

    /* renamed from: b  reason: collision with root package name */
    private static final int f327b = 10;

    /* renamed from: c  reason: collision with root package name */
    private static final int f328c = 0;

    /* renamed from: d  reason: collision with root package name */
    private static final int f329d = 300;

    /* renamed from: e  reason: collision with root package name */
    private static final int f330e = 122880;

    /* renamed from: f  reason: collision with root package name */
    private static final int f331f = 55;
    private static final int g = 2;
    private static final String h = "priority DESC, _id ASC";
    private static final int i = 7;
    private static final long j = 52428800;
    private static c k;
    /* access modifiers changed from: private */
    public a l;
    private File m;

    private c() {
        Context a2 = I.a();
        this.l = new a(a2);
        this.m = a2.getDatabasePath(j.f342a);
    }

    public static c a() {
        if (k == null) {
            synchronized (c.class) {
                if (k == null) {
                    k = new c();
                }
            }
        }
        return k;
    }

    private void a(MiStatParams miStatParams) {
        miStatParams.putString(l.a.n, com.xiaomi.stat.d.c.b());
        miStatParams.putString(l.a.o, C0154a.g);
        miStatParams.putString(l.a.p, m.c());
        miStatParams.putString(l.a.q, m.d());
        miStatParams.putString(l.a.r, com.xiaomi.stat.d.l.b(I.a()));
        miStatParams.putString(l.a.s, m.a(I.a()));
        miStatParams.putString(l.a.t, Build.MANUFACTURER);
        miStatParams.putString(l.a.u, Build.MODEL);
        miStatParams.putString(l.a.v, m.b());
    }

    private boolean a(b[] bVarArr, String str, String str2, boolean z) {
        for (b a2 : bVarArr) {
            if (a2.a(str, str2, z)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:30|(4:31|32|33|(14:34|35|36|37|38|39|40|41|42|43|44|45|46|47))|58|59|(2:90|61)(3:62|93|63)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:58:0x013c */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x014a A[Catch:{ Exception -> 0x0185, all -> 0x0183 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01a1  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0144 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    public k b(b[] bVarArr) {
        Cursor cursor;
        Cursor cursor2;
        String str;
        boolean z;
        ArrayList arrayList;
        JSONArray jSONArray;
        boolean z2;
        String str2;
        String str3;
        String str4;
        c cVar = this;
        b[] bVarArr2 = bVarArr;
        String str5 = "tp";
        try {
            if (bVarArr2.length == 1) {
                str = bVarArr2[0].a();
                z = false;
            } else {
                z = true;
                str = null;
            }
            cursor = cVar.l.getReadableDatabase().query(j.f343b, (String[]) null, str, (String[]) null, (String) null, (String) null, h);
            try {
                int columnIndex = cursor.getColumnIndex("_id");
                int columnIndex2 = cursor.getColumnIndex("e");
                int columnIndex3 = cursor.getColumnIndex("eg");
                int columnIndex4 = cursor.getColumnIndex(str5);
                int columnIndex5 = cursor.getColumnIndex("ts");
                int columnIndex6 = cursor.getColumnIndex("ps");
                int columnIndex7 = cursor.getColumnIndex(j.i);
                String str6 = "ps";
                int columnIndex8 = cursor.getColumnIndex(j.j);
                String str7 = "ts";
                JSONArray jSONArray2 = new JSONArray();
                ArrayList arrayList2 = new ArrayList();
                int i2 = 0;
                while (true) {
                    if (!cursor.moveToNext()) {
                        arrayList = arrayList2;
                        jSONArray = jSONArray2;
                        z2 = true;
                        break;
                    }
                    ArrayList arrayList3 = arrayList2;
                    String str8 = str5;
                    long j2 = cursor.getLong(columnIndex);
                    int i3 = columnIndex;
                    String string = cursor.getString(columnIndex2);
                    int i4 = columnIndex2;
                    String string2 = cursor.getString(columnIndex3);
                    int i5 = columnIndex3;
                    String string3 = cursor.getString(columnIndex4);
                    long j3 = j2;
                    long j4 = cursor.getLong(columnIndex5);
                    int i6 = columnIndex5;
                    String string4 = cursor.getString(columnIndex6);
                    int i7 = columnIndex6;
                    String string5 = cursor.getString(columnIndex7);
                    int i8 = columnIndex7;
                    int i9 = columnIndex8;
                    boolean z3 = cursor.getInt(columnIndex8) == 1;
                    if (z) {
                        if (!cVar.a(bVarArr2, string5, string2, z3)) {
                            str4 = str6;
                            str2 = str7;
                            jSONArray = jSONArray2;
                            str3 = str8;
                            arrayList = arrayList3;
                            cVar = this;
                            jSONArray2 = jSONArray;
                            str6 = str4;
                            str5 = str3;
                            str7 = str2;
                            columnIndex = i3;
                            columnIndex2 = i4;
                            columnIndex3 = i5;
                            columnIndex5 = i6;
                            columnIndex6 = i7;
                            columnIndex7 = i8;
                            columnIndex8 = i9;
                            arrayList2 = arrayList;
                            bVarArr2 = bVarArr;
                        }
                    }
                    int length = i2 + (string4.length() * 2) + 55;
                    if (!TextUtils.isEmpty(string)) {
                        length += string.length() * 2;
                    }
                    if (!TextUtils.isEmpty(string2)) {
                        length += string2.length() * 2;
                    }
                    int i10 = length;
                    if (i10 > f330e) {
                        jSONArray = jSONArray2;
                        arrayList = arrayList3;
                        z2 = false;
                        break;
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("e", string);
                        jSONObject.put("eg", string2);
                        str3 = str8;
                        try {
                            jSONObject.put(str3, string3);
                            str2 = str7;
                            try {
                                jSONObject.put(str2, j4);
                                long j5 = j3;
                                jSONObject.put(l.a.g, j5);
                                str4 = str6;
                                try {
                                    jSONObject.put(str4, new JSONObject(string4));
                                    jSONArray = jSONArray2;
                                    try {
                                        jSONArray.put(jSONObject);
                                        arrayList = arrayList3;
                                        arrayList.add(Long.valueOf(j5));
                                    } catch (JSONException unused) {
                                        arrayList = arrayList3;
                                        if (arrayList.size() >= 300) {
                                        }
                                    }
                                } catch (JSONException unused2) {
                                    jSONArray = jSONArray2;
                                    arrayList = arrayList3;
                                    if (arrayList.size() >= 300) {
                                    }
                                }
                            } catch (JSONException unused3) {
                                str4 = str6;
                                jSONArray = jSONArray2;
                                arrayList = arrayList3;
                                if (arrayList.size() >= 300) {
                                }
                            }
                        } catch (JSONException unused4) {
                            str4 = str6;
                            str2 = str7;
                            jSONArray = jSONArray2;
                            arrayList = arrayList3;
                            if (arrayList.size() >= 300) {
                            }
                        }
                    } catch (JSONException unused5) {
                        str4 = str6;
                        str2 = str7;
                        jSONArray = jSONArray2;
                        str3 = str8;
                        arrayList = arrayList3;
                        if (arrayList.size() >= 300) {
                        }
                    }
                    if (arrayList.size() >= 300) {
                        z2 = cursor.isLast();
                        break;
                    }
                    i2 = i10;
                    cVar = this;
                    jSONArray2 = jSONArray;
                    str6 = str4;
                    str5 = str3;
                    str7 = str2;
                    columnIndex = i3;
                    columnIndex2 = i4;
                    columnIndex3 = i5;
                    columnIndex5 = i6;
                    columnIndex6 = i7;
                    columnIndex7 = i8;
                    columnIndex8 = i9;
                    arrayList2 = arrayList;
                    bVarArr2 = bVarArr;
                }
                if (arrayList.size() > 0) {
                    k kVar = new k(jSONArray, arrayList, z2);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return kVar;
                } else if (cursor == null) {
                    return null;
                } else {
                    cursor.close();
                    return null;
                }
            } catch (Exception e2) {
                e = e2;
                cursor2 = cursor;
                try {
                    k.b(f326a, e.toString());
                    if (cursor2 != null) {
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursor2;
                    if (cursor != null) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                if (cursor != null) {
                }
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            cursor2 = null;
            k.b(f326a, e.toString());
            if (cursor2 != null) {
                return null;
            }
            cursor2.close();
            return null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public void b(l lVar) {
        d();
        SQLiteDatabase writableDatabase = this.l.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("e", lVar.f351a);
        contentValues.put("eg", lVar.f352b);
        contentValues.put("tp", lVar.f353c);
        contentValues.put("ts", Long.valueOf(lVar.f355e));
        if (c(lVar)) {
            a((MiStatParams) lVar.f354d);
        }
        contentValues.put("ps", lVar.f354d.toJsonString());
        contentValues.put(j.i, lVar.f356f);
        contentValues.put(j.j, Integer.valueOf(lVar.g ? 1 : 0));
        contentValues.put(j.k, Integer.valueOf(TextUtils.equals(lVar.f352b, l.a.h) ? 10 : 0));
        writableDatabase.insert(j.f343b, (String) null, contentValues);
    }

    /* access modifiers changed from: private */
    public void b(ArrayList<Long> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            try {
                SQLiteDatabase writableDatabase = this.l.getWritableDatabase();
                StringBuilder sb = new StringBuilder(((Long.toString(arrayList.get(0).longValue()).length() + 1) * arrayList.size()) + 16);
                sb.append("_id");
                sb.append(" in (");
                sb.append(arrayList.get(0));
                int size = arrayList.size();
                for (int i2 = 1; i2 < size; i2++) {
                    sb.append(",");
                    sb.append(arrayList.get(i2));
                }
                sb.append(")");
                int delete = writableDatabase.delete(j.f343b, sb.toString(), (String[]) null);
                k.c(f326a, "deleted events number " + delete);
            } catch (Exception unused) {
            }
        }
    }

    private boolean c(l lVar) {
        return !lVar.f353c.startsWith(l.a.w);
    }

    private void d() {
        if (this.m.exists() && this.m.length() >= 52428800) {
            k.e(f326a, "database too big: " + this.m.length());
            this.l.getWritableDatabase().delete(j.f343b, (String) null, (String[]) null);
        }
    }

    public k a(b[] bVarArr) {
        FutureTask futureTask = new FutureTask(new e(this, bVarArr));
        C0156c.a(futureTask);
        try {
            return (k) futureTask.get();
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }

    public void a(l lVar) {
        C0156c.a(new d(this, lVar));
        k.c(f326a, "add event: name=" + lVar.f351a);
    }

    public void a(String str) {
        C0156c.a(new h(this, str));
    }

    public void a(ArrayList<Long> arrayList) {
        FutureTask futureTask = new FutureTask(new f(this, arrayList), (Object) null);
        C0156c.a(futureTask);
        try {
            futureTask.get();
        } catch (InterruptedException | ExecutionException unused) {
        }
    }

    public void b() {
        C0156c.a(new g(this));
    }

    public long c() {
        FutureTask futureTask = new FutureTask(new i(this));
        C0156c.a(futureTask);
        try {
            return ((Long) futureTask.get()).longValue();
        } catch (InterruptedException | ExecutionException unused) {
            return -1;
        }
    }
}
