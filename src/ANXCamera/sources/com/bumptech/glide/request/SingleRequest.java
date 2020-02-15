package com.bumptech.glide.request;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.Pools;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.e;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.b.b.a;
import com.bumptech.glide.load.engine.A;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.a.g;
import com.bumptech.glide.request.target.n;
import com.bumptech.glide.request.target.o;
import com.bumptech.glide.util.a.d;
import com.bumptech.glide.util.l;

public final class SingleRequest<R> implements c, n, g, d.c {
    private static final String El = "Glide";
    private static final boolean Fl = Log.isLoggable(TAG, 2);
    private static final String TAG = "Request";
    private static final Pools.Pool<SingleRequest<?>> Yf = d.a(150, new h());
    private d Al;
    private e<R> Bc;
    private g<? super R> Bl;
    private Engine.b Cl;
    private Drawable Dl;
    private e Hb;
    private Drawable Sk;
    private int Uk;
    private int Vk;
    private final com.bumptech.glide.util.a.g Xe;
    private Drawable Xk;
    private Context context;
    private int height;
    @Nullable
    private Object model;
    private Priority priority;
    private A<R> resource;
    private long startTime;
    private Status status;
    @Nullable
    private final String tag;
    private o<R> target;
    private Engine wa;
    private int width;
    private Class<R> yc;
    private boolean yl;
    private f zc;
    @Nullable
    private e<R> zl;

    private enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CANCELLED,
        CLEARED,
        PAUSED
    }

    SingleRequest() {
        this.tag = Fl ? String.valueOf(super.hashCode()) : null;
        this.Xe = com.bumptech.glide.util.a.g.newInstance();
    }

    private boolean Am() {
        d dVar = this.Al;
        return dVar == null || dVar.c(this);
    }

    private boolean Bm() {
        d dVar = this.Al;
        return dVar == null || dVar.d(this);
    }

    private Drawable Cm() {
        if (this.Dl == null) {
            this.Dl = this.zc.bj();
            if (this.Dl == null && this.zc.aj() > 0) {
                this.Dl = Y(this.zc.aj());
            }
        }
        return this.Dl;
    }

    private boolean Dm() {
        d dVar = this.Al;
        return dVar == null || !dVar.z();
    }

    private void Em() {
        d dVar = this.Al;
        if (dVar != null) {
            dVar.e(this);
        }
    }

    private void Fm() {
        d dVar = this.Al;
        if (dVar != null) {
            dVar.b(this);
        }
    }

    private void Gm() {
        if (Am()) {
            Drawable drawable = null;
            if (this.model == null) {
                drawable = cj();
            }
            if (drawable == null) {
                drawable = Cm();
            }
            if (drawable == null) {
                drawable = hj();
            }
            this.target.d(drawable);
        }
    }

    private void H(String str) {
        Log.v(TAG, str + " this: " + this.tag);
    }

    private Drawable Y(@DrawableRes int i) {
        return a.a((Context) this.Hb, i, this.zc.getTheme() != null ? this.zc.getTheme() : this.context.getTheme());
    }

    private static int a(int i, float f2) {
        return i == Integer.MIN_VALUE ? i : Math.round(f2 * ((float) i));
    }

    public static <R> SingleRequest<R> a(Context context2, e eVar, Object obj, Class<R> cls, f fVar, int i, int i2, Priority priority2, o<R> oVar, e<R> eVar2, e<R> eVar3, d dVar, Engine engine, g<? super R> gVar) {
        SingleRequest<R> acquire = Yf.acquire();
        if (acquire == null) {
            acquire = new SingleRequest<>();
        }
        acquire.b(context2, eVar, obj, cls, fVar, i, i2, priority2, oVar, eVar2, eVar3, dVar, engine, gVar);
        return acquire;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0092, code lost:
        if (r7.zl.a(r9, r7.model, r7.target, r10, r6) == false) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x007f, code lost:
        if (r7.Bc.a(r9, r7.model, r7.target, r10, r6) == false) goto L_0x0081;
     */
    private void a(A<R> a2, R r, DataSource dataSource) {
        boolean Dm = Dm();
        this.status = Status.COMPLETE;
        this.resource = a2;
        if (this.Hb.getLogLevel() <= 3) {
            Log.d(El, "Finished loading " + r.getClass().getSimpleName() + " from " + dataSource + " for " + this.model + " with size [" + this.width + "x" + this.height + "] in " + com.bumptech.glide.util.e.g(this.startTime) + " ms");
        }
        this.yl = true;
        try {
            if (this.Bc != null) {
            }
            if (this.zl != null) {
            }
            this.target.a(r, this.Bl.a(dataSource, Dm));
            this.yl = false;
            Fm();
        } catch (Throwable th) {
            this.yl = false;
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    private void a(GlideException glideException, int i) {
        this.Xe.Nj();
        int logLevel = this.Hb.getLogLevel();
        if (logLevel <= i) {
            Log.w(El, "Load failed for " + this.model + " with size [" + this.width + "x" + this.height + "]", glideException);
            if (logLevel <= 4) {
                glideException.z(El);
            }
        }
        this.Cl = null;
        this.status = Status.FAILED;
        this.yl = true;
        try {
            if ((this.Bc == null || !this.Bc.a(glideException, this.model, this.target, Dm())) && (this.zl == null || !this.zl.a(glideException, this.model, this.target, Dm()))) {
                Gm();
            }
            this.yl = false;
            Em();
        } catch (Throwable th) {
            this.yl = false;
            throw th;
        }
    }

    private void b(Context context2, e eVar, Object obj, Class<R> cls, f fVar, int i, int i2, Priority priority2, o<R> oVar, e<R> eVar2, e<R> eVar3, d dVar, Engine engine, g<? super R> gVar) {
        this.context = context2;
        this.Hb = eVar;
        this.model = obj;
        this.yc = cls;
        this.zc = fVar;
        this.Vk = i;
        this.Uk = i2;
        this.priority = priority2;
        this.target = oVar;
        this.zl = eVar2;
        this.Bc = eVar3;
        this.Al = dVar;
        this.wa = engine;
        this.Bl = gVar;
        this.status = Status.PENDING;
    }

    private Drawable cj() {
        if (this.Xk == null) {
            this.Xk = this.zc.cj();
            if (this.Xk == null && this.zc.dj() > 0) {
                this.Xk = Y(this.zc.dj());
            }
        }
        return this.Xk;
    }

    private Drawable hj() {
        if (this.Sk == null) {
            this.Sk = this.zc.hj();
            if (this.Sk == null && this.zc.ij() > 0) {
                this.Sk = Y(this.zc.ij());
            }
        }
        return this.Sk;
    }

    private void m(A<?> a2) {
        this.wa.e(a2);
        this.resource = null;
    }

    private void ym() {
        if (this.yl) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    private boolean zm() {
        d dVar = this.Al;
        return dVar == null || dVar.g(this);
    }

    public boolean A() {
        return isComplete();
    }

    public void a(A<?> a2, DataSource dataSource) {
        this.Xe.Nj();
        this.Cl = null;
        if (a2 == null) {
            a(new GlideException("Expected to receive a Resource<R> with an object of " + this.yc + " inside, but instead got null."));
            return;
        }
        Object obj = a2.get();
        if (obj == null || !this.yc.isAssignableFrom(obj.getClass())) {
            m(a2);
            StringBuilder sb = new StringBuilder();
            sb.append("Expected to receive an object of ");
            sb.append(this.yc);
            sb.append(" but instead got ");
            String str = "";
            sb.append(obj != null ? obj.getClass() : str);
            sb.append("{");
            sb.append(obj);
            sb.append("} inside Resource{");
            sb.append(a2);
            sb.append("}.");
            if (obj == null) {
                str = " To indicate failure return a null Resource object, rather than a Resource object containing null data.";
            }
            sb.append(str);
            a(new GlideException(sb.toString()));
        } else if (!Bm()) {
            m(a2);
            this.status = Status.COMPLETE;
        } else {
            a(a2, obj, dataSource);
        }
    }

    public void a(GlideException glideException) {
        a(glideException, 5);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0044 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    public boolean a(c cVar) {
        if (!(cVar instanceof SingleRequest)) {
            return false;
        }
        SingleRequest singleRequest = (SingleRequest) cVar;
        if (this.Vk != singleRequest.Vk || this.Uk != singleRequest.Uk || !l.c(this.model, singleRequest.model) || !this.yc.equals(singleRequest.yc) || !this.zc.equals(singleRequest.zc) || this.priority != singleRequest.priority) {
            return false;
        }
        if (this.Bc != null) {
            return singleRequest.Bc != null;
        }
        if (singleRequest.Bc != null) {
            return false;
        }
    }

    public void b(int i, int i2) {
        this.Xe.Nj();
        if (Fl) {
            H("Got onSizeReady in " + com.bumptech.glide.util.e.g(this.startTime));
        }
        if (this.status == Status.WAITING_FOR_SIZE) {
            this.status = Status.RUNNING;
            float jj = this.zc.jj();
            this.width = a(i, jj);
            this.height = a(i2, jj);
            if (Fl) {
                H("finished setup for calling load in " + com.bumptech.glide.util.e.g(this.startTime));
            }
            Engine engine = this.wa;
            e eVar = this.Hb;
            Engine.b a2 = engine.a(eVar, this.model, this.zc.getSignature(), this.width, this.height, this.zc.O(), this.yc, this.priority, this.zc.fi(), this.zc.getTransformations(), this.zc.sj(), this.zc.ki(), this.zc.getOptions(), this.zc.oj(), this.zc.lj(), this.zc.kj(), this.zc.ej(), this);
            this.Cl = a2;
            if (this.status != Status.RUNNING) {
                this.Cl = null;
            }
            if (Fl) {
                H("finished onSizeReady in " + com.bumptech.glide.util.e.g(this.startTime));
            }
        }
    }

    public void begin() {
        ym();
        this.Xe.Nj();
        this.startTime = com.bumptech.glide.util.e.Hj();
        if (this.model == null) {
            if (l.o(this.Vk, this.Uk)) {
                this.width = this.Vk;
                this.height = this.Uk;
            }
            a(new GlideException("Received null model"), cj() == null ? 5 : 3);
            return;
        }
        Status status2 = this.status;
        if (status2 == Status.RUNNING) {
            throw new IllegalArgumentException("Cannot restart a running request");
        } else if (status2 == Status.COMPLETE) {
            a((A<?>) this.resource, DataSource.MEMORY_CACHE);
        } else {
            this.status = Status.WAITING_FOR_SIZE;
            if (l.o(this.Vk, this.Uk)) {
                b(this.Vk, this.Uk);
            } else {
                this.target.b((n) this);
            }
            Status status3 = this.status;
            if ((status3 == Status.RUNNING || status3 == Status.WAITING_FOR_SIZE) && Am()) {
                this.target.c(hj());
            }
            if (Fl) {
                H("finished run method in " + com.bumptech.glide.util.e.g(this.startTime));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void cancel() {
        ym();
        this.Xe.Nj();
        this.target.a(this);
        this.status = Status.CANCELLED;
        Engine.b bVar = this.Cl;
        if (bVar != null) {
            bVar.cancel();
            this.Cl = null;
        }
    }

    public void clear() {
        l.Jj();
        ym();
        this.Xe.Nj();
        if (this.status != Status.CLEARED) {
            cancel();
            A<R> a2 = this.resource;
            if (a2 != null) {
                m(a2);
            }
            if (zm()) {
                this.target.b(hj());
            }
            this.status = Status.CLEARED;
        }
    }

    @NonNull
    public com.bumptech.glide.util.a.g getVerifier() {
        return this.Xe;
    }

    public boolean isCancelled() {
        Status status2 = this.status;
        return status2 == Status.CANCELLED || status2 == Status.CLEARED;
    }

    public boolean isComplete() {
        return this.status == Status.COMPLETE;
    }

    public boolean isFailed() {
        return this.status == Status.FAILED;
    }

    public boolean isPaused() {
        return this.status == Status.PAUSED;
    }

    public boolean isRunning() {
        Status status2 = this.status;
        return status2 == Status.RUNNING || status2 == Status.WAITING_FOR_SIZE;
    }

    public void pause() {
        clear();
        this.status = Status.PAUSED;
    }

    public void recycle() {
        ym();
        this.context = null;
        this.Hb = null;
        this.model = null;
        this.yc = null;
        this.zc = null;
        this.Vk = -1;
        this.Uk = -1;
        this.target = null;
        this.Bc = null;
        this.zl = null;
        this.Al = null;
        this.Bl = null;
        this.Cl = null;
        this.Dl = null;
        this.Sk = null;
        this.Xk = null;
        this.width = -1;
        this.height = -1;
        Yf.release(this);
    }
}
