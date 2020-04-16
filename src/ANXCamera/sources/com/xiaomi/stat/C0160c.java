package com.xiaomi.stat;

import android.os.Handler;
import android.os.HandlerThread;
import com.xiaomi.stat.d.k;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* renamed from: com.xiaomi.stat.c  reason: case insensitive filesystem */
public class C0160c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f404a = "DBExecutor";

    /* renamed from: b  reason: collision with root package name */
    private static String f405b = "mistat_db";

    /* renamed from: c  reason: collision with root package name */
    private static final String f406c = "mistat";

    /* renamed from: d  reason: collision with root package name */
    private static final String f407d = "db.lk";

    /* renamed from: e  reason: collision with root package name */
    private static Handler f408e;

    /* renamed from: f  reason: collision with root package name */
    private static FileLock f409f;
    private static FileChannel g;

    /* renamed from: com.xiaomi.stat.c$a */
    private static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private Runnable f410a;

        public a(Runnable runnable) {
            this.f410a = runnable;
        }

        public void run() {
            if (C0160c.d()) {
                Runnable runnable = this.f410a;
                if (runnable != null) {
                    runnable.run();
                }
                C0160c.e();
            }
        }
    }

    public static void a(Runnable runnable) {
        c();
        f408e.post(new a(runnable));
    }

    private static void c() {
        if (f408e == null) {
            synchronized (C0160c.class) {
                if (f408e == null) {
                    HandlerThread handlerThread = new HandlerThread(f405b);
                    handlerThread.start();
                    f408e = new Handler(handlerThread.getLooper());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static boolean d() {
        File file = new File(I.a().getFilesDir(), f406c);
        if (!file.exists()) {
            file.mkdir();
        }
        try {
            g = new FileOutputStream(new File(file, f407d)).getChannel();
            try {
                f409f = g.lock();
                k.c(f404a, "acquire lock for db");
                return true;
            } catch (IOException e2) {
                k.c(f404a, "acquire lock for db failed with " + e2);
                try {
                    g.close();
                    g = null;
                } catch (IOException unused) {
                    k.c(f404a, "close file stream failed with " + e2);
                }
                return false;
            }
        } catch (FileNotFoundException e3) {
            k.c(f404a, "acquire lock for db failed with " + e3);
            return false;
        }
    }

    /* access modifiers changed from: private */
    public static void e() {
        FileLock fileLock = f409f;
        if (fileLock != null) {
            try {
                fileLock.release();
                f409f = null;
                k.c(f404a, "release lock for db");
                g.close();
                g = null;
            } catch (IOException e2) {
                k.c(f404a, "release lock for db failed with " + e2);
            }
        }
    }
}
