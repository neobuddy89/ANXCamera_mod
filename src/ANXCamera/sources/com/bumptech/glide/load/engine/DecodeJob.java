package com.bumptech.glide.load.engine;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.util.Pools;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.engine.f;
import com.bumptech.glide.load.engine.i;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.resource.bitmap.o;
import com.bumptech.glide.util.a.d;
import com.bumptech.glide.util.a.g;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class DecodeJob<R> implements f.a, Runnable, Comparable<DecodeJob<?>>, d.c {
    private static final String TAG = "DecodeJob";
    private com.bumptech.glide.e Hb;
    private final d Ie;
    private o Le;
    private final g<R> Ve = new g<>();
    private final List<Throwable> We = new ArrayList();
    private final g Xe = g.newInstance();
    private final c<?> Ye = new c<>();
    private final e Ze = new e();
    private volatile boolean _d;
    private s _e;
    private Stage bf;
    private a<R> callback;
    private RunReason cf;
    private long df;
    private boolean ef;
    private Thread ff;
    private com.bumptech.glide.load.c gf;
    private int height;
    private com.bumptech.glide.load.c hf;

    /* renamed from: if  reason: not valid java name */
    private Object f0if;
    private DataSource jf;
    private com.bumptech.glide.load.a.d<?> kf;
    private volatile f lf;
    private volatile boolean mf;
    private Object model;
    private com.bumptech.glide.load.g options;
    private int order;
    private final Pools.Pool<DecodeJob<?>> pool;
    private Priority priority;
    private com.bumptech.glide.load.c signature;
    private int width;

    private enum RunReason {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    private enum Stage {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    interface a<R> {
        void a(A<R> a2, DataSource dataSource);

        void a(DecodeJob<?> decodeJob);

        void a(GlideException glideException);
    }

    private final class b<Z> implements i.a<Z> {
        private final DataSource dataSource;

        b(DataSource dataSource2) {
            this.dataSource = dataSource2;
        }

        @NonNull
        public A<Z> a(@NonNull A<Z> a2) {
            return DecodeJob.this.a(this.dataSource, a2);
        }
    }

    private static class c<Z> {
        private z<Z> Re;
        private com.bumptech.glide.load.i<Z> encoder;
        private com.bumptech.glide.load.c key;

        c() {
        }

        /* access modifiers changed from: package-private */
        public <X> void a(com.bumptech.glide.load.c cVar, com.bumptech.glide.load.i<X> iVar, z<X> zVar) {
            this.key = cVar;
            this.encoder = iVar;
            this.Re = zVar;
        }

        /* access modifiers changed from: package-private */
        public void a(d dVar, com.bumptech.glide.load.g gVar) {
            try {
                dVar.C().a(this.key, new C0150e(this.encoder, this.Re, gVar));
            } finally {
                this.Re.unlock();
            }
        }

        /* access modifiers changed from: package-private */
        public void clear() {
            this.key = null;
            this.encoder = null;
            this.Re = null;
        }

        /* access modifiers changed from: package-private */
        public boolean li() {
            return this.Re != null;
        }
    }

    interface d {
        com.bumptech.glide.load.engine.a.a C();
    }

    private static class e {
        private boolean Se;
        private boolean Te;
        private boolean Ue;

        e() {
        }

        private boolean B(boolean z) {
            return (this.Ue || z || this.Te) && this.Se;
        }

        /* access modifiers changed from: package-private */
        public synchronized boolean mi() {
            this.Te = true;
            return B(false);
        }

        /* access modifiers changed from: package-private */
        public synchronized boolean onFailed() {
            this.Ue = true;
            return B(false);
        }

        /* access modifiers changed from: package-private */
        public synchronized boolean release(boolean z) {
            this.Se = true;
            return B(z);
        }

        /* access modifiers changed from: package-private */
        public synchronized void reset() {
            this.Te = false;
            this.Se = false;
            this.Ue = false;
        }
    }

    DecodeJob(d dVar, Pools.Pool<DecodeJob<?>> pool2) {
        this.Ie = dVar;
        this.pool = pool2;
    }

    private void Ol() {
        if (Log.isLoggable(TAG, 2)) {
            long j = this.df;
            a("Retrieved data", j, "data: " + this.f0if + ", cache key: " + this.gf + ", fetcher: " + this.kf);
        }
        A<R> a2 = null;
        try {
            a2 = a(this.kf, this.f0if, this.jf);
        } catch (GlideException e2) {
            e2.a(this.hf, this.jf);
            this.We.add(e2);
        }
        if (a2 != null) {
            c(a2, this.jf);
        } else {
            Sl();
        }
    }

    private f Pl() {
        int i = h.Pe[this.bf.ordinal()];
        if (i == 1) {
            return new B(this.Ve, this);
        }
        if (i == 2) {
            return new C0148c(this.Ve, this);
        }
        if (i == 3) {
            return new E(this.Ve, this);
        }
        if (i == 4) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: " + this.bf);
    }

    private void Ql() {
        if (this.Ze.onFailed()) {
            Rl();
        }
    }

    private void Rl() {
        this.Ze.reset();
        this.Ye.clear();
        this.Ve.clear();
        this.mf = false;
        this.Hb = null;
        this.signature = null;
        this.options = null;
        this.priority = null;
        this._e = null;
        this.callback = null;
        this.bf = null;
        this.lf = null;
        this.ff = null;
        this.gf = null;
        this.f0if = null;
        this.jf = null;
        this.kf = null;
        this.df = 0;
        this._d = false;
        this.model = null;
        this.We.clear();
        this.pool.release(this);
    }

    private void Sl() {
        this.ff = Thread.currentThread();
        this.df = com.bumptech.glide.util.e.Hj();
        boolean z = false;
        while (!this._d && this.lf != null) {
            z = this.lf.F();
            if (z) {
                break;
            }
            this.bf = a(this.bf);
            this.lf = Pl();
            if (this.bf == Stage.SOURCE) {
                Z();
                return;
            }
        }
        if ((this.bf == Stage.FINISHED || this._d) && !z) {
            notifyFailed();
        }
    }

    private void Tl() {
        int i = h.Oe[this.cf.ordinal()];
        if (i == 1) {
            this.bf = a(Stage.INITIALIZE);
            this.lf = Pl();
            Sl();
        } else if (i == 2) {
            Sl();
        } else if (i == 3) {
            Ol();
        } else {
            throw new IllegalStateException("Unrecognized run reason: " + this.cf);
        }
    }

    private void Ul() {
        this.Xe.Nj();
        if (!this.mf) {
            this.mf = true;
            return;
        }
        throw new IllegalStateException("Already notified");
    }

    private <Data> A<R> a(com.bumptech.glide.load.a.d<?> dVar, Data data, DataSource dataSource) throws GlideException {
        if (data == null) {
            dVar.cleanup();
            return null;
        }
        try {
            long Hj = com.bumptech.glide.util.e.Hj();
            A<R> a2 = a(data, dataSource);
            if (Log.isLoggable(TAG, 2)) {
                c("Decoded result " + a2, Hj);
            }
            return a2;
        } finally {
            dVar.cleanup();
        }
    }

    private <Data> A<R> a(Data data, DataSource dataSource) throws GlideException {
        return a(data, dataSource, this.Ve.c(data.getClass()));
    }

    private <Data, ResourceType> A<R> a(Data data, DataSource dataSource, x<Data, ResourceType, R> xVar) throws GlideException {
        com.bumptech.glide.load.g b2 = b(dataSource);
        com.bumptech.glide.load.a.e k = this.Hb.getRegistry().k(data);
        try {
            return xVar.a(k, b2, this.width, this.height, new b(dataSource));
        } finally {
            k.cleanup();
        }
    }

    private Stage a(Stage stage) {
        int i = h.Pe[stage.ordinal()];
        if (i == 1) {
            return this.Le.pi() ? Stage.DATA_CACHE : a(Stage.DATA_CACHE);
        }
        if (i == 2) {
            return this.ef ? Stage.FINISHED : Stage.SOURCE;
        }
        if (i == 3 || i == 4) {
            return Stage.FINISHED;
        }
        if (i == 5) {
            return this.Le.qi() ? Stage.RESOURCE_CACHE : a(Stage.RESOURCE_CACHE);
        }
        throw new IllegalArgumentException("Unrecognized stage: " + stage);
    }

    private void a(String str, long j, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(com.bumptech.glide.util.e.g(j));
        sb.append(", load key: ");
        sb.append(this._e);
        if (str2 != null) {
            str3 = ", " + str2;
        } else {
            str3 = "";
        }
        sb.append(str3);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        Log.v(TAG, sb.toString());
    }

    @NonNull
    private com.bumptech.glide.load.g b(DataSource dataSource) {
        com.bumptech.glide.load.g gVar = this.options;
        if (Build.VERSION.SDK_INT < 26 || gVar.a(o.kj) != null) {
            return gVar;
        }
        if (dataSource != DataSource.RESOURCE_DISK_CACHE && !this.Ve.ki()) {
            return gVar;
        }
        com.bumptech.glide.load.g gVar2 = new com.bumptech.glide.load.g();
        gVar2.b(this.options);
        gVar2.a(o.kj, true);
        return gVar2;
    }

    private void b(A<R> a2, DataSource dataSource) {
        Ul();
        this.callback.a(a2, dataSource);
    }

    private void c(A<R> a2, DataSource dataSource) {
        if (a2 instanceof v) {
            ((v) a2).initialize();
        }
        z<R> zVar = null;
        z<R> zVar2 = a2;
        if (this.Ye.li()) {
            z<R> f2 = z.f(a2);
            zVar = f2;
            zVar2 = f2;
        }
        b(zVar2, dataSource);
        this.bf = Stage.ENCODE;
        try {
            if (this.Ye.li()) {
                this.Ye.a(this.Ie, this.options);
            }
            mi();
        } finally {
            if (zVar != null) {
                zVar.unlock();
            }
        }
    }

    private void c(String str, long j) {
        a(str, j, (String) null);
    }

    private int getPriority() {
        return this.priority.ordinal();
    }

    private void mi() {
        if (this.Ze.mi()) {
            Rl();
        }
    }

    private void notifyFailed() {
        Ul();
        this.callback.a(new GlideException("Failed to load resource", (List<Throwable>) new ArrayList(this.We)));
        Ql();
    }

    public void Z() {
        this.cf = RunReason.SWITCH_TO_SOURCE_SERVICE;
        this.callback.a((DecodeJob<?>) this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v7, resolved type: com.bumptech.glide.load.engine.d} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v11, resolved type: com.bumptech.glide.load.engine.C} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: com.bumptech.glide.load.engine.C} */
    /* JADX WARNING: type inference failed for: r12v6, types: [com.bumptech.glide.load.c] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    @NonNull
    public <Z> A<Z> a(DataSource dataSource, @NonNull A<Z> a2) {
        j<Z> jVar;
        A<Z> a3;
        EncodeStrategy encodeStrategy;
        C c2;
        Class<?> cls = a2.get().getClass();
        com.bumptech.glide.load.i<Z> iVar = null;
        if (dataSource != DataSource.RESOURCE_DISK_CACHE) {
            j<Z> d2 = this.Ve.d(cls);
            jVar = d2;
            a3 = d2.transform(this.Hb, a2, this.width, this.height);
        } else {
            a3 = a2;
            jVar = null;
        }
        if (!a2.equals(a3)) {
            a2.recycle();
        }
        if (this.Ve.d((A<?>) a3)) {
            iVar = this.Ve.c(a3);
            encodeStrategy = iVar.a(this.options);
        } else {
            encodeStrategy = EncodeStrategy.NONE;
        }
        com.bumptech.glide.load.i<Z> iVar2 = iVar;
        if (!this.Le.a(!this.Ve.e(this.gf), dataSource, encodeStrategy)) {
            return a3;
        }
        if (iVar2 != null) {
            int i = h.Qe[encodeStrategy.ordinal()];
            if (i == 1) {
                c2 = new C0149d(this.gf, this.signature);
            } else if (i == 2) {
                C c3 = new C(this.Ve.ka(), this.gf, this.signature, this.width, this.height, jVar, cls, this.options);
                c2 = c3;
            } else {
                throw new IllegalArgumentException("Unknown strategy: " + encodeStrategy);
            }
            z<Z> f2 = z.f(a3);
            this.Ye.a(c2, iVar2, f2);
            return f2;
        }
        throw new Registry.NoResultEncoderAvailableException(a3.get().getClass());
    }

    /* access modifiers changed from: package-private */
    public DecodeJob<R> a(com.bumptech.glide.e eVar, Object obj, s sVar, com.bumptech.glide.load.c cVar, int i, int i2, Class<?> cls, Class<R> cls2, Priority priority2, o oVar, Map<Class<?>, j<?>> map, boolean z, boolean z2, boolean z3, com.bumptech.glide.load.g gVar, a<R> aVar, int i3) {
        this.Ve.a(eVar, obj, cVar, i, i2, oVar, cls, cls2, priority2, gVar, map, z, z2, this.Ie);
        this.Hb = eVar;
        this.signature = cVar;
        this.priority = priority2;
        this._e = sVar;
        this.width = i;
        this.height = i2;
        this.Le = oVar;
        this.ef = z3;
        this.options = gVar;
        this.callback = aVar;
        this.order = i3;
        this.cf = RunReason.INITIALIZE;
        this.model = obj;
        return this;
    }

    public void a(com.bumptech.glide.load.c cVar, Exception exc, com.bumptech.glide.load.a.d<?> dVar, DataSource dataSource) {
        dVar.cleanup();
        GlideException glideException = new GlideException("Fetching data failed", (Throwable) exc);
        glideException.a(cVar, dataSource, dVar.ba());
        this.We.add(glideException);
        if (Thread.currentThread() != this.ff) {
            this.cf = RunReason.SWITCH_TO_SOURCE_SERVICE;
            this.callback.a((DecodeJob<?>) this);
            return;
        }
        Sl();
    }

    public void a(com.bumptech.glide.load.c cVar, Object obj, com.bumptech.glide.load.a.d<?> dVar, DataSource dataSource, com.bumptech.glide.load.c cVar2) {
        this.gf = cVar;
        this.f0if = obj;
        this.kf = dVar;
        this.jf = dataSource;
        this.hf = cVar2;
        if (Thread.currentThread() != this.ff) {
            this.cf = RunReason.DECODE_DATA;
            this.callback.a((DecodeJob<?>) this);
            return;
        }
        Ol();
    }

    /* renamed from: b */
    public int compareTo(@NonNull DecodeJob<?> decodeJob) {
        int priority2 = getPriority() - decodeJob.getPriority();
        return priority2 == 0 ? this.order - decodeJob.order : priority2;
    }

    public void cancel() {
        this._d = true;
        f fVar = this.lf;
        if (fVar != null) {
            fVar.cancel();
        }
    }

    @NonNull
    public g getVerifier() {
        return this.Xe;
    }

    /* access modifiers changed from: package-private */
    public boolean oi() {
        Stage a2 = a(Stage.INITIALIZE);
        return a2 == Stage.RESOURCE_CACHE || a2 == Stage.DATA_CACHE;
    }

    /* access modifiers changed from: package-private */
    public void release(boolean z) {
        if (this.Ze.release(z)) {
            Rl();
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    public void run() {
        com.bumptech.glide.load.a.d<?> dVar = this.kf;
        try {
            if (this._d) {
                notifyFailed();
                if (dVar != null) {
                    dVar.cleanup();
                    return;
                }
                return;
            }
            Tl();
            if (dVar == null) {
                return;
            }
            dVar.cleanup();
        } catch (Throwable th) {
            if (dVar != null) {
                dVar.cleanup();
            }
            throw th;
        }
    }
}
