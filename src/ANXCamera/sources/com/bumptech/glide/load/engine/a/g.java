package com.bumptech.glide.load.engine.a;

import android.util.Log;
import com.bumptech.glide.a.b;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.engine.a.a;
import java.io.File;
import java.io.IOException;

/* compiled from: DiskLruCacheWrapper */
public class g implements a {
    private static final int APP_VERSION = 1;
    private static final int Rg = 1;
    private static g Sg = null;
    private static final String TAG = "DiskLruCacheWrapper";
    private final s Og;
    private final c Pg = new c();
    private b Qg;
    private final File directory;
    private final long maxSize;

    @Deprecated
    protected g(File file, long j) {
        this.directory = file;
        this.maxSize = j;
        this.Og = new s();
    }

    private synchronized b C() throws IOException {
        if (this.Qg == null) {
            this.Qg = b.a(this.directory, 1, 1, this.maxSize);
        }
        return this.Qg;
    }

    @Deprecated
    public static synchronized a a(File file, long j) {
        g gVar;
        synchronized (g.class) {
            if (Sg == null) {
                Sg = new g(file, j);
            }
            gVar = Sg;
        }
        return gVar;
    }

    private synchronized void bm() {
        this.Qg = null;
    }

    public static a create(File file, long j) {
        return new g(file, j);
    }

    public void a(c cVar, a.b bVar) {
        b.C0003b edit;
        String f2 = this.Og.f(cVar);
        this.Pg.t(f2);
        try {
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "Put: Obtained: " + f2 + " for for Key: " + cVar);
            }
            try {
                b C = C();
                if (C.get(f2) == null) {
                    edit = C.edit(f2);
                    if (edit != null) {
                        if (bVar.c(edit.t(0))) {
                            edit.commit();
                        }
                        edit.abortUnlessCommitted();
                        this.Pg.u(f2);
                        return;
                    }
                    throw new IllegalStateException("Had two simultaneous puts for: " + f2);
                }
            } catch (IOException e2) {
                if (Log.isLoggable(TAG, 5)) {
                    Log.w(TAG, "Unable to put to disk cache", e2);
                }
            } catch (Throwable th) {
                edit.abortUnlessCommitted();
                throw th;
            }
        } finally {
            this.Pg.u(f2);
        }
    }

    public File b(c cVar) {
        String f2 = this.Og.f(cVar);
        if (Log.isLoggable(TAG, 2)) {
            Log.v(TAG, "Get: Obtained: " + f2 + " for for Key: " + cVar);
        }
        try {
            b.d dVar = C().get(f2);
            if (dVar != null) {
                return dVar.t(0);
            }
            return null;
        } catch (IOException e2) {
            if (!Log.isLoggable(TAG, 5)) {
                return null;
            }
            Log.w(TAG, "Unable to get from disk cache", e2);
            return null;
        }
    }

    public void c(c cVar) {
        try {
            C().remove(this.Og.f(cVar));
        } catch (IOException e2) {
            if (Log.isLoggable(TAG, 5)) {
                Log.w(TAG, "Unable to delete from disk cache", e2);
            }
        }
    }

    public synchronized void clear() {
        try {
            C().delete();
        } catch (IOException e2) {
            try {
                if (Log.isLoggable(TAG, 5)) {
                    Log.w(TAG, "Unable to clear disk cache or disk cache cleared externally", e2);
                }
            } catch (Throwable th) {
                bm();
                throw th;
            }
        }
        bm();
    }
}
