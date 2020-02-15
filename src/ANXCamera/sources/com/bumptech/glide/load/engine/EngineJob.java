package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.support.v4.util.Pools;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.b.b;
import com.bumptech.glide.request.g;
import com.bumptech.glide.util.a.d;
import com.bumptech.glide.util.l;
import java.util.ArrayList;
import java.util.List;

class EngineJob<R> implements DecodeJob.a<R>, d.c {
    private static final Handler Nf = new Handler(Looper.getMainLooper(), new a());
    private static final int Of = 1;
    private static final int Pf = 2;
    private static final int Qf = 3;
    private static final EngineResourceFactory Xd = new EngineResourceFactory();
    private final List<g> Df;
    private final EngineResourceFactory Ef;
    private boolean Ff;
    private boolean Gf;
    private boolean Hf;
    private boolean If;
    private boolean Jf;
    private List<g> Kf;
    private u<?> Lf;
    private DecodeJob<R> Mf;
    private final b Pb;
    private final b Qb;
    private final b Ub;
    private final com.bumptech.glide.util.a.g Xe;
    private volatile boolean _d;
    private DataSource dataSource;
    private boolean ef;
    private GlideException exception;
    private c key;
    private final r listener;
    private final Pools.Pool<EngineJob<?>> pool;
    private A<?> resource;
    private final b sf;

    @VisibleForTesting
    static class EngineResourceFactory {
        EngineResourceFactory() {
        }

        public <R> u<R> a(A<R> a2, boolean z) {
            return new u<>(a2, z, true);
        }
    }

    private static class a implements Handler.Callback {
        a() {
        }

        public boolean handleMessage(Message message) {
            EngineJob engineJob = (EngineJob) message.obj;
            int i = message.what;
            if (i == 1) {
                engineJob.ti();
            } else if (i == 2) {
                engineJob.si();
            } else if (i == 3) {
                engineJob.ri();
            } else {
                throw new IllegalStateException("Unrecognized message: " + message.what);
            }
            return true;
        }
    }

    EngineJob(b bVar, b bVar2, b bVar3, b bVar4, r rVar, Pools.Pool<EngineJob<?>> pool2) {
        this(bVar, bVar2, bVar3, bVar4, rVar, pool2, Xd);
    }

    @VisibleForTesting
    EngineJob(b bVar, b bVar2, b bVar3, b bVar4, r rVar, Pools.Pool<EngineJob<?>> pool2, EngineResourceFactory engineResourceFactory) {
        this.Df = new ArrayList(2);
        this.Xe = com.bumptech.glide.util.a.g.newInstance();
        this.Qb = bVar;
        this.Pb = bVar2;
        this.sf = bVar3;
        this.Ub = bVar4;
        this.listener = rVar;
        this.pool = pool2;
        this.Ef = engineResourceFactory;
    }

    private b Vl() {
        return this.Gf ? this.sf : this.Hf ? this.Ub : this.Pb;
    }

    private void c(g gVar) {
        if (this.Kf == null) {
            this.Kf = new ArrayList(2);
        }
        if (!this.Kf.contains(gVar)) {
            this.Kf.add(gVar);
        }
    }

    private boolean d(g gVar) {
        List<g> list = this.Kf;
        return list != null && list.contains(gVar);
    }

    private void release(boolean z) {
        l.Jj();
        this.Df.clear();
        this.key = null;
        this.Lf = null;
        this.resource = null;
        List<g> list = this.Kf;
        if (list != null) {
            list.clear();
        }
        this.Jf = false;
        this._d = false;
        this.If = false;
        this.Mf.release(z);
        this.Mf = null;
        this.exception = null;
        this.dataSource = null;
        this.pool.release(this);
    }

    public void a(A<R> a2, DataSource dataSource2) {
        this.resource = a2;
        this.dataSource = dataSource2;
        Nf.obtainMessage(1, this).sendToTarget();
    }

    public void a(DecodeJob<?> decodeJob) {
        Vl().execute(decodeJob);
    }

    public void a(GlideException glideException) {
        this.exception = glideException;
        Nf.obtainMessage(2, this).sendToTarget();
    }

    /* access modifiers changed from: package-private */
    public void a(g gVar) {
        l.Jj();
        this.Xe.Nj();
        if (this.If) {
            gVar.a(this.Lf, this.dataSource);
        } else if (this.Jf) {
            gVar.a(this.exception);
        } else {
            this.Df.add(gVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(g gVar) {
        l.Jj();
        this.Xe.Nj();
        if (this.If || this.Jf) {
            c(gVar);
            return;
        }
        this.Df.remove(gVar);
        if (this.Df.isEmpty()) {
            cancel();
        }
    }

    public void c(DecodeJob<R> decodeJob) {
        this.Mf = decodeJob;
        (decodeJob.oi() ? this.Qb : Vl()).execute(decodeJob);
    }

    /* access modifiers changed from: package-private */
    public void cancel() {
        if (!this.Jf && !this.If && !this._d) {
            this._d = true;
            this.Mf.cancel();
            this.listener.a(this, this.key);
        }
    }

    @NonNull
    public com.bumptech.glide.util.a.g getVerifier() {
        return this.Xe;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public EngineJob<R> init(c cVar, boolean z, boolean z2, boolean z3, boolean z4) {
        this.key = cVar;
        this.Ff = z;
        this.Gf = z2;
        this.Hf = z3;
        this.ef = z4;
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean isCancelled() {
        return this._d;
    }

    /* access modifiers changed from: package-private */
    public void ri() {
        this.Xe.Nj();
        if (this._d) {
            this.listener.a(this, this.key);
            release(false);
            return;
        }
        throw new IllegalStateException("Not cancelled");
    }

    /* access modifiers changed from: package-private */
    public void si() {
        this.Xe.Nj();
        if (this._d) {
            release(false);
        } else if (this.Df.isEmpty()) {
            throw new IllegalStateException("Received an exception without any callbacks to notify");
        } else if (!this.Jf) {
            this.Jf = true;
            this.listener.a(this, this.key, (u<?>) null);
            for (g next : this.Df) {
                if (!d(next)) {
                    next.a(this.exception);
                }
            }
            release(false);
        } else {
            throw new IllegalStateException("Already failed once");
        }
    }

    /* access modifiers changed from: package-private */
    public void ti() {
        this.Xe.Nj();
        if (this._d) {
            this.resource.recycle();
            release(false);
        } else if (this.Df.isEmpty()) {
            throw new IllegalStateException("Received a resource without any callbacks to notify");
        } else if (!this.If) {
            this.Lf = this.Ef.a(this.resource, this.Ff);
            this.If = true;
            this.Lf.acquire();
            this.listener.a(this, this.key, this.Lf);
            int size = this.Df.size();
            for (int i = 0; i < size; i++) {
                g gVar = this.Df.get(i);
                if (!d(gVar)) {
                    this.Lf.acquire();
                    gVar.a(this.Lf, this.dataSource);
                }
            }
            this.Lf.release();
            release(false);
        } else {
            throw new IllegalStateException("Already have resource");
        }
    }

    /* access modifiers changed from: package-private */
    public boolean ui() {
        return this.ef;
    }
}
