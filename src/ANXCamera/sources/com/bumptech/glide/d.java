package com.bumptech.glide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.a.a;
import com.bumptech.glide.load.engine.a.m;
import com.bumptech.glide.load.engine.a.o;
import com.bumptech.glide.load.engine.a.q;
import com.bumptech.glide.load.engine.b.b;
import com.bumptech.glide.load.engine.bitmap_recycle.e;
import com.bumptech.glide.load.engine.bitmap_recycle.i;
import com.bumptech.glide.load.engine.bitmap_recycle.j;
import com.bumptech.glide.manager.g;
import com.bumptech.glide.manager.n;
import com.bumptech.glide.request.f;
import java.util.Map;

/* compiled from: GlideBuilder */
public final class d {
    private com.bumptech.glide.load.engine.bitmap_recycle.d Eb;
    private o Fb;
    private com.bumptech.glide.manager.d Jb;
    private b Pb;
    private b Qb;
    private a.C0007a Rb;
    private q Sb;
    @Nullable
    private n.a Tb;
    private b Ub;
    private boolean Vb;
    private int logLevel = 4;
    private com.bumptech.glide.load.engine.bitmap_recycle.b ra;
    private f ua = new f();
    private final Map<Class<?>, n<?, ?>> va = new ArrayMap();
    private Engine wa;

    /* access modifiers changed from: package-private */
    @NonNull
    public c E(@NonNull Context context) {
        if (this.Pb == null) {
            this.Pb = b.Di();
        }
        if (this.Qb == null) {
            this.Qb = b.Ci();
        }
        if (this.Ub == null) {
            this.Ub = b.Bi();
        }
        if (this.Sb == null) {
            this.Sb = new q.a(context).build();
        }
        if (this.Jb == null) {
            this.Jb = new g();
        }
        if (this.Eb == null) {
            int yi = this.Sb.yi();
            if (yi > 0) {
                this.Eb = new j((long) yi);
            } else {
                this.Eb = new e();
            }
        }
        if (this.ra == null) {
            this.ra = new i(this.Sb.xi());
        }
        if (this.Fb == null) {
            this.Fb = new com.bumptech.glide.load.engine.a.n((long) this.Sb.zi());
        }
        if (this.Rb == null) {
            this.Rb = new m(context);
        }
        if (this.wa == null) {
            Engine engine = new Engine(this.Fb, this.Rb, this.Qb, this.Pb, b.Ei(), b.Bi(), this.Vb);
            this.wa = engine;
        }
        Context context2 = context;
        c cVar = new c(context2, this.wa, this.Fb, this.Eb, this.ra, new n(this.Tb), this.Jb, this.logLevel, this.ua.lock(), this.va);
        return cVar;
    }

    /* access modifiers changed from: package-private */
    public d a(Engine engine) {
        this.wa = engine;
        return this;
    }

    @NonNull
    public d a(@Nullable a.C0007a aVar) {
        this.Rb = aVar;
        return this;
    }

    @NonNull
    public d a(@Nullable o oVar) {
        this.Fb = oVar;
        return this;
    }

    @NonNull
    public d a(@NonNull q.a aVar) {
        return a(aVar.build());
    }

    @NonNull
    public d a(@Nullable q qVar) {
        this.Sb = qVar;
        return this;
    }

    @NonNull
    public d a(@Nullable b bVar) {
        this.Ub = bVar;
        return this;
    }

    @NonNull
    public d a(@Nullable com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
        this.ra = bVar;
        return this;
    }

    @NonNull
    public d a(@Nullable com.bumptech.glide.load.engine.bitmap_recycle.d dVar) {
        this.Eb = dVar;
        return this;
    }

    @NonNull
    public d a(@Nullable com.bumptech.glide.manager.d dVar) {
        this.Jb = dVar;
        return this;
    }

    @NonNull
    public d a(@Nullable f fVar) {
        this.ua = fVar;
        return this;
    }

    @NonNull
    public <T> d a(@NonNull Class<T> cls, @Nullable n<?, T> nVar) {
        this.va.put(cls, nVar);
        return this;
    }

    /* access modifiers changed from: package-private */
    public void a(@Nullable n.a aVar) {
        this.Tb = aVar;
    }

    @NonNull
    public d b(@Nullable b bVar) {
        this.Qb = bVar;
        return this;
    }

    @Deprecated
    public d c(@Nullable b bVar) {
        return d(bVar);
    }

    @NonNull
    public d d(@Nullable b bVar) {
        this.Pb = bVar;
        return this;
    }

    @NonNull
    public d setLogLevel(int i) {
        if (i < 2 || i > 6) {
            throw new IllegalArgumentException("Log level must be one of Log.VERBOSE, Log.DEBUG, Log.INFO, Log.WARN, or Log.ERROR");
        }
        this.logLevel = i;
        return this;
    }

    @NonNull
    public d t(boolean z) {
        this.Vb = z;
        return this;
    }
}
