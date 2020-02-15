package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.engine.a.o;
import com.bumptech.glide.load.engine.bitmap_recycle.d;
import com.bumptech.glide.load.resource.bitmap.f;
import com.bumptech.glide.util.l;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

final class BitmapPreFillRunner implements Runnable {
    private static final Clock Gh = new Clock();
    static final int Hh = 4;
    static final long INITIAL_BACKOFF_MS = 40;
    static final long Ih = TimeUnit.SECONDS.toMillis(1);
    static final long MAX_DURATION_MS = 32;
    @VisibleForTesting
    static final String TAG = "PreFillRunner";
    private final b Ch;
    private final Clock Dh;
    private final d Eb;
    private final Set<c> Eh;
    private final o Fb;
    private long Fh;
    private boolean _d;
    private final Handler handler;

    @VisibleForTesting
    static class Clock {
        Clock() {
        }

        /* access modifiers changed from: package-private */
        public long now() {
            return SystemClock.currentThreadTimeMillis();
        }
    }

    private static final class a implements c {
        a() {
        }

        public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
            throw new UnsupportedOperationException();
        }
    }

    public BitmapPreFillRunner(d dVar, o oVar, b bVar) {
        this(dVar, oVar, bVar, Gh, new Handler(Looper.getMainLooper()));
    }

    @VisibleForTesting
    BitmapPreFillRunner(d dVar, o oVar, b bVar, Clock clock, Handler handler2) {
        this.Eh = new HashSet();
        this.Fh = INITIAL_BACKOFF_MS;
        this.Eb = dVar;
        this.Fb = oVar;
        this.Ch = bVar;
        this.Dh = clock;
        this.handler = handler2;
    }

    private long X() {
        long j = this.Fh;
        this.Fh = Math.min(4 * j, Ih);
        return j;
    }

    private long em() {
        return this.Fb.getMaxSize() - this.Fb.Y();
    }

    private boolean i(long j) {
        return this.Dh.now() - j >= 32;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean allocate() {
        Bitmap bitmap;
        long now = this.Dh.now();
        while (!this.Ch.isEmpty() && !i(now)) {
            c remove = this.Ch.remove();
            if (!this.Eh.contains(remove)) {
                this.Eh.add(remove);
                bitmap = this.Eb.c(remove.getWidth(), remove.getHeight(), remove.getConfig());
            } else {
                bitmap = Bitmap.createBitmap(remove.getWidth(), remove.getHeight(), remove.getConfig());
            }
            int j = l.j(bitmap);
            if (em() >= ((long) j)) {
                this.Fb.a(new a(), f.a(bitmap, this.Eb));
            } else {
                this.Eb.a(bitmap);
            }
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "allocated [" + remove.getWidth() + "x" + remove.getHeight() + "] " + remove.getConfig() + " size: " + j);
            }
        }
        return !this._d && !this.Ch.isEmpty();
    }

    public void cancel() {
        this._d = true;
    }

    public void run() {
        if (allocate()) {
            this.handler.postDelayed(this, X());
        }
    }
}
