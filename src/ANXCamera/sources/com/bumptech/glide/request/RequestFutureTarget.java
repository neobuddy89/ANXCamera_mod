package com.bumptech.glide.request;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.a.f;
import com.bumptech.glide.request.target.n;
import com.bumptech.glide.request.target.o;
import com.bumptech.glide.util.l;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class RequestFutureTarget<R> implements b<R>, e<R>, Runnable {
    private static final Waiter Ok = new Waiter();
    private final boolean Kk;
    private final Waiter Lk;
    private boolean Mk;
    private boolean Nk;
    private boolean _d;
    @Nullable
    private GlideException exception;
    private final int height;
    private final Handler qa;
    @Nullable
    private c request;
    @Nullable
    private R resource;
    private final int width;

    @VisibleForTesting
    static class Waiter {
        Waiter() {
        }

        /* access modifiers changed from: package-private */
        public void a(Object obj, long j) throws InterruptedException {
            obj.wait(j);
        }

        /* access modifiers changed from: package-private */
        public void n(Object obj) {
            obj.notifyAll();
        }
    }

    public RequestFutureTarget(Handler handler, int i, int i2) {
        this(handler, i, i2, true, Ok);
    }

    RequestFutureTarget(Handler handler, int i, int i2, boolean z, Waiter waiter) {
        this.qa = handler;
        this.width = i;
        this.height = i2;
        this.Kk = z;
        this.Lk = waiter;
    }

    private synchronized R doGet(Long l) throws ExecutionException, InterruptedException, TimeoutException {
        if (this.Kk && !isDone()) {
            l.Ij();
        }
        if (this._d) {
            throw new CancellationException();
        } else if (this.Nk) {
            throw new ExecutionException(this.exception);
        } else if (this.Mk) {
            return this.resource;
        } else {
            if (l == null) {
                this.Lk.a(this, 0);
            } else if (l.longValue() > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                long longValue = l.longValue() + currentTimeMillis;
                while (!isDone() && currentTimeMillis < longValue) {
                    this.Lk.a(this, longValue - currentTimeMillis);
                    currentTimeMillis = System.currentTimeMillis();
                }
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            } else if (this.Nk) {
                throw new ExecutionException(this.exception);
            } else if (this._d) {
                throw new CancellationException();
            } else if (this.Mk) {
                return this.resource;
            } else {
                throw new TimeoutException();
            }
        }
    }

    private void wm() {
        this.qa.post(this);
    }

    public void a(@NonNull n nVar) {
    }

    public synchronized void a(@NonNull R r, @Nullable f<? super R> fVar) {
    }

    public synchronized boolean a(@Nullable GlideException glideException, Object obj, o<R> oVar, boolean z) {
        this.Nk = true;
        this.exception = glideException;
        this.Lk.n(this);
        return false;
    }

    public synchronized boolean a(R r, Object obj, o<R> oVar, DataSource dataSource, boolean z) {
        this.Mk = true;
        this.resource = r;
        this.Lk.n(this);
        return false;
    }

    public void b(@Nullable Drawable drawable) {
    }

    public void b(@NonNull n nVar) {
        nVar.b(this.width, this.height);
    }

    public void c(@Nullable Drawable drawable) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0018, code lost:
        return true;
     */
    public synchronized boolean cancel(boolean z) {
        if (isDone()) {
            return false;
        }
        this._d = true;
        this.Lk.n(this);
        if (z) {
            wm();
        }
    }

    public synchronized void d(@Nullable Drawable drawable) {
    }

    public void f(@Nullable c cVar) {
        this.request = cVar;
    }

    public R get() throws InterruptedException, ExecutionException {
        try {
            return doGet((Long) null);
        } catch (TimeoutException e2) {
            throw new AssertionError(e2);
        }
    }

    public R get(long j, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return doGet(Long.valueOf(timeUnit.toMillis(j)));
    }

    @Nullable
    public c getRequest() {
        return this.request;
    }

    public synchronized boolean isCancelled() {
        return this._d;
    }

    public synchronized boolean isDone() {
        return this._d || this.Mk || this.Nk;
    }

    public void onDestroy() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void run() {
        c cVar = this.request;
        if (cVar != null) {
            cVar.clear();
            this.request = null;
        }
    }
}
