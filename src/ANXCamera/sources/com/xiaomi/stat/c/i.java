package com.xiaomi.stat.c;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.xiaomi.stat.C0159b;
import com.xiaomi.stat.C0161d;
import com.xiaomi.stat.I;
import com.xiaomi.stat.a.b;
import com.xiaomi.stat.a.k;
import com.xiaomi.stat.b.f;
import com.xiaomi.stat.b.h;
import com.xiaomi.stat.d.c;
import com.xiaomi.stat.d.d;
import com.xiaomi.stat.d.e;
import com.xiaomi.stat.d.j;
import com.xiaomi.stat.d.l;
import com.xiaomi.stat.d.m;
import com.xiaomi.stat.d.r;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private static final String f444a = "3.0";

    /* renamed from: b  reason: collision with root package name */
    private static final String f445b = "UploaderEngine";

    /* renamed from: c  reason: collision with root package name */
    private static final String f446c = "code";

    /* renamed from: d  reason: collision with root package name */
    private static final String f447d = "UTF-8";

    /* renamed from: e  reason: collision with root package name */
    private static final String f448e = "mistat";

    /* renamed from: f  reason: collision with root package name */
    private static final String f449f = "uploader";
    private static final String g = "3.0.10";
    private static final String h = "Android";
    private static final int i = 200;
    private static final int j = 1;
    private static final int k = -1;
    private static final int l = 3;
    private static volatile i m;
    private final byte[] n = new byte[0];
    private FileLock o;
    private FileChannel p;
    private g q;
    private a r;

    private class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                i.this.f();
            }
        }
    }

    private i() {
        e();
    }

    private int a(int i2) {
        if (i2 == 1) {
            return -1;
        }
        return i2 == 3 ? 0 : 1;
    }

    public static i a() {
        if (m == null) {
            synchronized (i.class) {
                if (m == null) {
                    m = new i();
                }
            }
        }
        return m;
    }

    private String a(JSONArray jSONArray, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", str);
            a(str, jSONObject);
            jSONObject.put(C0161d.I, e.d());
            jSONObject.put("rc", m.h());
            jSONObject.put(C0161d.j, c.b());
            jSONObject.put(C0161d.k, C0159b.t());
            jSONObject.put(C0161d.l, h);
            jSONObject.put(C0161d.Z, m.a(I.a()));
            jSONObject.put(C0161d.m, this.q != null ? this.q.a() : 0);
            jSONObject.put(C0161d.n, String.valueOf(r.b()));
            jSONObject.put(C0161d.o, m.e());
            jSONObject.put(C0161d.p, a.a(I.b()));
            String[] o2 = C0159b.o();
            if (o2 != null && o2.length > 0) {
                jSONObject.put(C0161d.v, a(o2));
            }
            jSONObject.put(C0161d.q, m.d());
            jSONObject.put("n", l.b(I.a()));
            jSONObject.put(C0161d.t, C0159b.h());
            jSONObject.put(C0161d.u, jSONArray);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    private JSONArray a(String[] strArr) {
        JSONArray jSONArray = new JSONArray();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(strArr[i2], a.a(strArr[i2]));
                jSONArray.put(jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONArray;
    }

    private void a(Message message) {
        synchronized (this.n) {
            if (this.r == null || this.q == null) {
                e();
            }
            this.r.sendMessage(message);
        }
    }

    private void a(String str, JSONObject jSONObject) {
        try {
            if (!C0159b.e() && TextUtils.isEmpty(str)) {
                Context a2 = I.a();
                jSONObject.put(C0161d.C, e.b(a2));
                jSONObject.put(C0161d.J, e.k(a2));
                jSONObject.put(C0161d.L, e.n(a2));
                jSONObject.put(C0161d.O, e.q(a2));
                jSONObject.put("ai", e.p(a2));
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00fa A[SYNTHETIC] */
    private void a(b[] bVarArr, String str) {
        boolean z;
        k a2;
        if (bVarArr.length == 0) {
            com.xiaomi.stat.d.k.c(f445b, "privacy policy or network state not matched");
            return;
        }
        k a3 = com.xiaomi.stat.a.c.a().a(bVarArr);
        AtomicInteger atomicInteger = new AtomicInteger();
        boolean z2 = a3 != null ? a3.f350c : true;
        com.xiaomi.stat.d.k.b(f445b + a3);
        boolean z3 = z2;
        boolean z4 = false;
        while (true) {
            if (a3 == null) {
                z = z4;
                break;
            }
            ArrayList<Long> arrayList = a3.f349b;
            try {
                String a4 = a(a3.f348a, str);
                if (com.xiaomi.stat.d.k.a()) {
                    com.xiaomi.stat.d.k.b("UploaderEngine payload:" + a4);
                }
                String b2 = b(a(a(a4)));
                if (com.xiaomi.stat.d.k.a()) {
                    com.xiaomi.stat.d.k.b("UploaderEngine encodePayload " + b2);
                }
                String a5 = c.a(f.a().c(), (Map<String, String>) c(b2), true);
                if (com.xiaomi.stat.d.k.a()) {
                    com.xiaomi.stat.d.k.b("UploaderEngine sendDataToServer response: " + a5);
                }
                if (TextUtils.isEmpty(a5)) {
                    z = false;
                    if (!z) {
                        com.xiaomi.stat.a.c.a().a(arrayList);
                    } else {
                        atomicInteger.addAndGet(1);
                    }
                    com.xiaomi.stat.d.k.b("UploaderEngine deleteData= " + z + " retryCount.get()= " + atomicInteger.get());
                    if (z3 || (!z && atomicInteger.get() > 3)) {
                        break;
                    }
                    a2 = com.xiaomi.stat.a.c.a().a(bVarArr);
                    if (a2 == null) {
                        z3 = a2.f350c;
                    }
                    k kVar = a2;
                    z4 = z;
                    a3 = kVar;
                } else {
                    z = b(a5);
                    if (!z) {
                    }
                    com.xiaomi.stat.d.k.b("UploaderEngine deleteData= " + z + " retryCount.get()= " + atomicInteger.get());
                    a2 = com.xiaomi.stat.a.c.a().a(bVarArr);
                    if (a2 == null) {
                    }
                    k kVar2 = a2;
                    z4 = z;
                    a3 = kVar2;
                }
            } catch (Exception unused) {
            }
        }
        g gVar = this.q;
        if (gVar != null) {
            gVar.b(z);
        }
    }

    public static byte[] a(String str) {
        GZIPOutputStream gZIPOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(str.getBytes("UTF-8").length);
            try {
                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            } catch (Exception e2) {
                e = e2;
                gZIPOutputStream = null;
                try {
                    com.xiaomi.stat.d.k.e("UploaderEngine zipData failed! " + e.toString());
                    j.a((OutputStream) byteArrayOutputStream);
                    j.a((OutputStream) gZIPOutputStream);
                    return bArr;
                } catch (Throwable th) {
                    th = th;
                    j.a((OutputStream) byteArrayOutputStream);
                    j.a((OutputStream) gZIPOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                gZIPOutputStream = null;
                j.a((OutputStream) byteArrayOutputStream);
                j.a((OutputStream) gZIPOutputStream);
                throw th;
            }
            try {
                gZIPOutputStream.write(str.getBytes("UTF-8"));
                gZIPOutputStream.finish();
                bArr = byteArrayOutputStream.toByteArray();
            } catch (Exception e3) {
                e = e3;
                com.xiaomi.stat.d.k.e("UploaderEngine zipData failed! " + e.toString());
                j.a((OutputStream) byteArrayOutputStream);
                j.a((OutputStream) gZIPOutputStream);
                return bArr;
            }
        } catch (Exception e4) {
            e = e4;
            byteArrayOutputStream = null;
            gZIPOutputStream = null;
            com.xiaomi.stat.d.k.e("UploaderEngine zipData failed! " + e.toString());
            j.a((OutputStream) byteArrayOutputStream);
            j.a((OutputStream) gZIPOutputStream);
            return bArr;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            gZIPOutputStream = null;
            j.a((OutputStream) byteArrayOutputStream);
            j.a((OutputStream) gZIPOutputStream);
            throw th;
        }
        j.a((OutputStream) byteArrayOutputStream);
        j.a((OutputStream) gZIPOutputStream);
        return bArr;
    }

    private byte[] a(byte[] bArr) {
        return h.a().a(bArr);
    }

    private String b(byte[] bArr) {
        return d.a(bArr);
    }

    private void b(boolean z) {
        a(c(z), com.xiaomi.stat.b.d.a().a(z));
    }

    private boolean b(String str) {
        try {
            int optInt = new JSONObject(str).optInt(f446c);
            if (optInt != 200) {
                if (!(optInt == 1002 || optInt == 1004 || optInt == 1005 || optInt == 1006 || optInt == 1007)) {
                    if (optInt != 1011) {
                        if (optInt == 2002) {
                            h.a().a(true);
                            com.xiaomi.stat.b.d.a().b();
                        }
                    }
                }
                h.a().a(true);
                com.xiaomi.stat.b.d.a().b();
                return false;
            }
            return true;
        } catch (Exception e2) {
            com.xiaomi.stat.d.k.d(f445b, "parseUploadingResult exception ", e2);
            return false;
        }
    }

    private HashMap<String, String> c(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("ai", I.b());
        hashMap.put(C0161d.f452b, "3.0.10");
        hashMap.put(C0161d.f453c, f444a);
        hashMap.put(C0161d.f454d, m.g());
        hashMap.put("p", str);
        hashMap.put(C0161d.ak, h.a().c());
        hashMap.put(C0161d.g, h.a().b());
        return hashMap;
    }

    private b[] c(boolean z) {
        ArrayList<String> g2 = g();
        int size = g2.size();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < size; i2++) {
            String str = g2.get(i2);
            int a2 = a(new f(str, z).a());
            if (a2 != -1) {
                arrayList.add(new b(str, a2, z));
            }
        }
        b d2 = d(z);
        if (d2 != null) {
            arrayList.add(d2);
        }
        return (b[]) arrayList.toArray(new b[arrayList.size()]);
    }

    private b d(boolean z) {
        int a2 = new f(z).a();
        com.xiaomi.stat.d.k.b("UploaderEngine createMainAppFilter: " + a2);
        int a3 = a(a2);
        if (a3 != -1) {
            return new b((String) null, a3, z);
        }
        return null;
    }

    private void e() {
        HandlerThread handlerThread = new HandlerThread("mi_analytics_uploader_worker");
        handlerThread.start();
        this.r = new a(handlerThread.getLooper());
        this.q = new g(handlerThread.getLooper());
    }

    /* access modifiers changed from: private */
    public void f() {
        if (h()) {
            if (C0159b.e()) {
                b(true);
                b(false);
            } else {
                a(c(false), com.xiaomi.stat.b.d.a().c());
            }
            i();
        }
    }

    private ArrayList<String> g() {
        String[] o2 = C0159b.o();
        int length = o2 != null ? o2.length : 0;
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < length; i2++) {
            if (!TextUtils.isEmpty(o2[i2])) {
                arrayList.add(o2[i2]);
            }
        }
        return arrayList;
    }

    private boolean h() {
        File file = new File(I.a().getFilesDir(), f448e);
        if (!file.exists()) {
            file.mkdir();
        }
        try {
            this.p = new FileOutputStream(new File(file, f449f)).getChannel();
            try {
                this.o = this.p.tryLock();
                if (this.o != null) {
                    com.xiaomi.stat.d.k.c("UploaderEngine acquire lock for uploader");
                    if (this.o == null) {
                        try {
                            this.p.close();
                            this.p = null;
                        } catch (IOException unused) {
                        }
                    }
                    return true;
                }
                com.xiaomi.stat.d.k.c("UploaderEngine acquire lock for uploader failed");
                if (this.o == null) {
                    try {
                        this.p.close();
                        this.p = null;
                    } catch (IOException unused2) {
                    }
                }
                return false;
            } catch (IOException e2) {
                com.xiaomi.stat.d.k.c("UploaderEngine acquire lock for uploader failed with " + e2);
                if (this.o == null) {
                    try {
                        this.p.close();
                        this.p = null;
                    } catch (IOException unused3) {
                    }
                }
                return false;
            } catch (Throwable th) {
                if (this.o == null) {
                    try {
                        this.p.close();
                        this.p = null;
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e3) {
            com.xiaomi.stat.d.k.c("UploaderEngine acquire lock for uploader failed with " + e3);
            return false;
        }
    }

    private void i() {
        try {
            if (this.o != null) {
                this.o.release();
                this.o = null;
            }
            if (this.p != null) {
                this.p.close();
                this.p = null;
            }
            com.xiaomi.stat.d.k.c("UploaderEngine releaseLock lock for uploader");
        } catch (IOException e2) {
            com.xiaomi.stat.d.k.c("UploaderEngine releaseLock lock for uploader failed with " + e2);
        }
    }

    public void a(boolean z) {
        g gVar = this.q;
        if (gVar != null) {
            gVar.a(z);
        }
    }

    public void b() {
        this.q.b();
        c();
    }

    public void c() {
        if (!l.a()) {
            com.xiaomi.stat.d.k.b("UploaderEngine postToServer network is not connected ");
        } else if (!C0159b.a() || !C0159b.b()) {
            com.xiaomi.stat.d.k.b("UploaderEngine postToServer statistic disable or network disable access! ");
        } else {
            Message obtain = Message.obtain();
            obtain.what = 1;
            a(obtain);
        }
    }

    public synchronized void d() {
        if (this.q != null) {
            this.q.c();
        }
    }
}
