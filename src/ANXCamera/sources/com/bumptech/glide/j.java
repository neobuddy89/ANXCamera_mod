package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.CheckResult;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RawRes;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.o;
import com.bumptech.glide.request.RequestFutureTarget;
import com.bumptech.glide.request.SingleRequest;
import com.bumptech.glide.request.a;
import com.bumptech.glide.request.b;
import com.bumptech.glide.request.c;
import com.bumptech.glide.request.d;
import com.bumptech.glide.request.e;
import com.bumptech.glide.request.f;
import com.bumptech.glide.request.i;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.util.l;
import java.io.File;
import java.net.URL;

/* compiled from: RequestBuilder */
public class j<TranscodeType> implements Cloneable, g<j<TranscodeType>> {
    protected static final f Ic = new f().a(o.DATA).a(Priority.LOW).v(true);
    @NonNull
    private n<?, ? super TranscodeType> Ac;
    @Nullable
    private e<TranscodeType> Bc;
    @Nullable
    private j<TranscodeType> Cc;
    @Nullable
    private j<TranscodeType> Dc;
    @Nullable
    private Float Ec;
    private boolean Fc;
    private boolean Gc;
    private final e Hb;
    private boolean Hc;
    private final c Nb;
    private final Context context;
    private final m ea;
    @Nullable
    private Object model;
    private final f ua;
    private final Class<TranscodeType> yc;
    @NonNull
    protected f zc;

    protected j(c cVar, m mVar, Class<TranscodeType> cls, Context context2) {
        this.Fc = true;
        this.Nb = cVar;
        this.ea = mVar;
        this.yc = cls;
        this.ua = mVar.la();
        this.context = context2;
        this.Ac = mVar.a(cls);
        this.zc = this.ua;
        this.Hb = cVar.Fh();
    }

    protected j(Class<TranscodeType> cls, j<?> jVar) {
        this(jVar.Nb, jVar.ea, cls, jVar.context);
        this.model = jVar.model;
        this.Gc = jVar.Gc;
        this.zc = jVar.zc;
    }

    private c a(com.bumptech.glide.request.target.o<TranscodeType> oVar, @Nullable e<TranscodeType> eVar, @Nullable d dVar, n<?, ? super TranscodeType> nVar, Priority priority, int i, int i2, f fVar) {
        a aVar;
        a aVar2;
        if (this.Dc != null) {
            aVar2 = new a(dVar);
            aVar = aVar2;
        } else {
            aVar = null;
            aVar2 = dVar;
        }
        c b2 = b(oVar, eVar, aVar2, nVar, priority, i, i2, fVar);
        if (aVar == null) {
            return b2;
        }
        int gj = this.Dc.zc.gj();
        int fj = this.Dc.zc.fj();
        if (l.o(i, i2) && !this.Dc.zc.uj()) {
            gj = fVar.gj();
            fj = fVar.fj();
        }
        j<TranscodeType> jVar = this.Dc;
        aVar.a(b2, jVar.a(oVar, eVar, (d) aVar, jVar.Ac, jVar.zc.getPriority(), gj, fj, this.Dc.zc));
        return aVar;
    }

    private c a(com.bumptech.glide.request.target.o<TranscodeType> oVar, @Nullable e<TranscodeType> eVar, f fVar) {
        return a(oVar, eVar, (d) null, this.Ac, fVar.getPriority(), fVar.gj(), fVar.fj(), fVar);
    }

    private c a(com.bumptech.glide.request.target.o<TranscodeType> oVar, e<TranscodeType> eVar, f fVar, d dVar, n<?, ? super TranscodeType> nVar, Priority priority, int i, int i2) {
        Context context2 = this.context;
        e eVar2 = this.Hb;
        Object obj = this.model;
        Class<TranscodeType> cls = this.yc;
        return SingleRequest.a(context2, eVar2, obj, cls, fVar, i, i2, priority, oVar, eVar, this.Bc, dVar, eVar2.ma(), nVar.Wh());
    }

    private boolean a(f fVar, c cVar) {
        return !fVar.oj() && cVar.isComplete();
    }

    private c b(com.bumptech.glide.request.target.o<TranscodeType> oVar, e<TranscodeType> eVar, @Nullable d dVar, n<?, ? super TranscodeType> nVar, Priority priority, int i, int i2, f fVar) {
        d dVar2 = dVar;
        Priority priority2 = priority;
        j<TranscodeType> jVar = this.Cc;
        if (jVar != null) {
            if (!this.Hc) {
                n<?, ? super TranscodeType> nVar2 = jVar.Fc ? nVar : jVar.Ac;
                Priority priority3 = this.Cc.zc.pj() ? this.Cc.zc.getPriority() : c(priority2);
                int gj = this.Cc.zc.gj();
                int fj = this.Cc.zc.fj();
                if (l.o(i, i2) && !this.Cc.zc.uj()) {
                    gj = fVar.gj();
                    fj = fVar.fj();
                }
                i iVar = new i(dVar2);
                c a2 = a(oVar, eVar, fVar, (d) iVar, nVar, priority, i, i2);
                this.Hc = true;
                j<TranscodeType> jVar2 = this.Cc;
                i iVar2 = iVar;
                c a3 = jVar2.a(oVar, eVar, (d) iVar, nVar2, priority3, gj, fj, jVar2.zc);
                this.Hc = false;
                iVar2.a(a2, a3);
                return iVar2;
            }
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        } else if (this.Ec == null) {
            return a(oVar, eVar, fVar, dVar, nVar, priority, i, i2);
        } else {
            i iVar3 = new i(dVar2);
            e<TranscodeType> eVar2 = eVar;
            i iVar4 = iVar3;
            n<?, ? super TranscodeType> nVar3 = nVar;
            int i3 = i;
            int i4 = i2;
            iVar3.a(a(oVar, eVar2, fVar, (d) iVar4, nVar3, priority, i3, i4), a(oVar, eVar2, fVar.clone().g(this.Ec.floatValue()), (d) iVar4, nVar3, c(priority2), i3, i4));
            return iVar3;
        }
    }

    private <Y extends com.bumptech.glide.request.target.o<TranscodeType>> Y b(@NonNull Y y, @Nullable e<TranscodeType> eVar, @NonNull f fVar) {
        l.Jj();
        com.bumptech.glide.util.i.checkNotNull(y);
        if (this.Gc) {
            f Qi = fVar.Qi();
            c a2 = a(y, eVar, Qi);
            c request = y.getRequest();
            if (!a2.a(request) || a(Qi, request)) {
                this.ea.d((com.bumptech.glide.request.target.o<?>) y);
                y.f(a2);
                this.ea.a(y, a2);
                return y;
            }
            a2.recycle();
            com.bumptech.glide.util.i.checkNotNull(request);
            if (!request.isRunning()) {
                request.begin();
            }
            return y;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    @NonNull
    private Priority c(@NonNull Priority priority) {
        int i = i.xc[priority.ordinal()];
        if (i == 1) {
            return Priority.NORMAL;
        }
        if (i == 2) {
            return Priority.HIGH;
        }
        if (i == 3 || i == 4) {
            return Priority.IMMEDIATE;
        }
        throw new IllegalArgumentException("unknown priority: " + this.zc.getPriority());
    }

    @NonNull
    private j<TranscodeType> t(@Nullable Object obj) {
        this.model = obj;
        this.Gc = true;
        return this;
    }

    /* access modifiers changed from: protected */
    @CheckResult
    @NonNull
    public j<File> Ih() {
        return new j(File.class, this).b(Ic);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public f Jh() {
        f fVar = this.ua;
        f fVar2 = this.zc;
        return fVar == fVar2 ? fVar2.clone() : fVar2;
    }

    @NonNull
    public b<TranscodeType> Kh() {
        return j(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @CheckResult
    @NonNull
    public j<TranscodeType> a(@Nullable Drawable drawable) {
        t(drawable);
        return b(f.b(o.NONE));
    }

    @NonNull
    public j<TranscodeType> a(@Nullable j<TranscodeType> jVar) {
        this.Dc = jVar;
        return this;
    }

    @CheckResult
    @NonNull
    public j<TranscodeType> a(@NonNull n<?, ? super TranscodeType> nVar) {
        com.bumptech.glide.util.i.checkNotNull(nVar);
        this.Ac = nVar;
        this.Fc = false;
        return this;
    }

    @CheckResult
    @NonNull
    public j<TranscodeType> a(@Nullable e<TranscodeType> eVar) {
        this.Bc = eVar;
        return this;
    }

    @CheckResult
    @NonNull
    public j<TranscodeType> a(@Nullable File file) {
        t(file);
        return this;
    }

    @CheckResult
    @NonNull
    public j<TranscodeType> a(@Nullable @RawRes @DrawableRes Integer num) {
        t(num);
        return b(f.h(com.bumptech.glide.e.a.obtain(this.context)));
    }

    @CheckResult
    @NonNull
    public j<TranscodeType> a(@Nullable j<TranscodeType>... jVarArr) {
        j<TranscodeType> jVar = null;
        if (jVarArr == null || jVarArr.length == 0) {
            return b((j) null);
        }
        for (int length = jVarArr.length - 1; length >= 0; length--) {
            j<TranscodeType> jVar2 = jVarArr[length];
            if (jVar2 != null) {
                jVar = jVar == null ? jVar2 : jVar2.b(jVar);
            }
        }
        return b(jVar);
    }

    @NonNull
    public ViewTarget<ImageView, TranscodeType> a(@NonNull ImageView imageView) {
        l.Jj();
        com.bumptech.glide.util.i.checkNotNull(imageView);
        f fVar = this.zc;
        if (!fVar.tj() && fVar.rj() && imageView.getScaleType() != null) {
            switch (i.wc[imageView.getScaleType().ordinal()]) {
                case 1:
                    fVar = fVar.clone().xj();
                    break;
                case 2:
                    fVar = fVar.clone().yj();
                    break;
                case 3:
                case 4:
                case 5:
                    fVar = fVar.clone().Aj();
                    break;
                case 6:
                    fVar = fVar.clone().yj();
                    break;
            }
        }
        ViewTarget<ImageView, TranscodeType> a2 = this.Hb.a(imageView, this.yc);
        b(a2, (e) null, fVar);
        return a2;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public <Y extends com.bumptech.glide.request.target.o<TranscodeType>> Y a(@NonNull Y y, @Nullable e<TranscodeType> eVar) {
        b(y, eVar, Jh());
        return y;
    }

    @CheckResult
    @NonNull
    public j<TranscodeType> b(float f2) {
        if (f2 < 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.Ec = Float.valueOf(f2);
        return this;
    }

    @CheckResult
    @NonNull
    public j<TranscodeType> b(@Nullable j<TranscodeType> jVar) {
        this.Cc = jVar;
        return this;
    }

    @CheckResult
    @NonNull
    public j<TranscodeType> b(@NonNull f fVar) {
        com.bumptech.glide.util.i.checkNotNull(fVar);
        this.zc = Jh().b(fVar);
        return this;
    }

    @Deprecated
    @CheckResult
    public j<TranscodeType> b(@Nullable URL url) {
        t(url);
        return this;
    }

    @Deprecated
    @CheckResult
    public <Y extends com.bumptech.glide.request.target.o<File>> Y b(@NonNull Y y) {
        return Ih().c(y);
    }

    @CheckResult
    @NonNull
    public j<TranscodeType> c(@Nullable Uri uri) {
        t(uri);
        return this;
    }

    @NonNull
    public <Y extends com.bumptech.glide.request.target.o<TranscodeType>> Y c(@NonNull Y y) {
        return a(y, (e) null);
    }

    @CheckResult
    public j<TranscodeType> clone() {
        try {
            j<TranscodeType> jVar = (j) super.clone();
            jVar.zc = jVar.zc.clone();
            jVar.Ac = jVar.Ac.clone();
            return jVar;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    @CheckResult
    @NonNull
    public j<TranscodeType> f(@Nullable byte[] bArr) {
        t(bArr);
        if (!this.zc.nj()) {
            this = b(f.b(o.NONE));
        }
        return !this.zc.qj() ? this.b(f.w(true)) : this;
    }

    @CheckResult
    @NonNull
    public j<TranscodeType> g(@Nullable Bitmap bitmap) {
        t(bitmap);
        return b(f.b(o.NONE));
    }

    @Deprecated
    @CheckResult
    public b<File> g(int i, int i2) {
        return Ih().j(i, i2);
    }

    @Deprecated
    public b<TranscodeType> h(int i, int i2) {
        return j(i, i2);
    }

    @NonNull
    public com.bumptech.glide.request.target.o<TranscodeType> i(int i, int i2) {
        return c(com.bumptech.glide.request.target.l.a(this.ea, i, i2));
    }

    @NonNull
    public b<TranscodeType> j(int i, int i2) {
        RequestFutureTarget requestFutureTarget = new RequestFutureTarget(this.Hb.na(), i, i2);
        if (l.Kj()) {
            this.Hb.na().post(new h(this, requestFutureTarget));
        } else {
            a(requestFutureTarget, requestFutureTarget);
        }
        return requestFutureTarget;
    }

    @CheckResult
    @NonNull
    public j<TranscodeType> load(@Nullable Object obj) {
        t(obj);
        return this;
    }

    @CheckResult
    @NonNull
    public j<TranscodeType> load(@Nullable String str) {
        t(str);
        return this;
    }

    @NonNull
    public com.bumptech.glide.request.target.o<TranscodeType> preload() {
        return i(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }
}
