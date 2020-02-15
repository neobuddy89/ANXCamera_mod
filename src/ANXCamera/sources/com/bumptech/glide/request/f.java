package com.bumptech.glide.request;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.CheckResult;
import android.support.annotation.DrawableRes;
import android.support.annotation.FloatRange;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.e.b;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.d;
import com.bumptech.glide.load.engine.o;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.bitmap.k;
import com.bumptech.glide.load.resource.bitmap.l;
import com.bumptech.glide.load.resource.bitmap.r;
import com.bumptech.glide.load.resource.bitmap.s;
import com.bumptech.glide.load.resource.gif.e;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import com.bumptech.glide.util.i;
import java.util.Map;

/* compiled from: RequestOptions */
public class f implements Cloneable {
    private static final int Ai = 2048;
    private static final int FALLBACK = 8192;
    private static final int PRIORITY = 8;
    private static final int SIGNATURE = 1024;
    private static final int THEME = 32768;
    private static final int UNSET = -1;
    private static final int bl = 2;
    private static final int cl = 4;
    private static final int dl = 16;
    private static final int el = 32;
    private static final int fl = 64;
    private static final int gl = 128;
    private static final int hl = 256;
    private static final int il = 512;
    private static final int jl = 4096;
    private static final int kl = 16384;
    private static final int ll = 65536;
    private static final int ml = 131072;
    private static final int nl = 262144;
    private static final int ol = 524288;
    private static final int pl = 1048576;
    @Nullable
    private static f ql;
    @Nullable
    private static f rl;
    @Nullable
    private static f sl;
    @Nullable
    private static f tl;
    @Nullable
    private static f ul;
    @Nullable
    private static f vl;
    @Nullable
    private static f wl;
    @Nullable
    private static f xl;
    private boolean Ff = true;
    @NonNull
    private Class<?> He = Object.class;
    private boolean Hf;
    @NonNull
    private o Le = o.AUTOMATIC;
    private boolean Me;
    private boolean Ne = true;
    private float Pk = 1.0f;
    @NonNull
    private Map<Class<?>, j<?>> Qd = new CachedHashCodeArrayMap();
    @Nullable
    private Drawable Qk;
    private int Rk;
    @Nullable
    private Drawable Sk;
    private int Tk;
    private int Uk = -1;
    private int Vk = -1;
    private boolean Wk = true;
    @Nullable
    private Drawable Xk;
    private int Yk;
    private boolean Zk;
    private boolean _k;
    private boolean ef;
    private int fields;
    private boolean isLocked;
    @NonNull
    private g options = new g();
    @NonNull
    private Priority priority = Priority.NORMAL;
    @NonNull
    private c signature = b.obtain();
    @Nullable
    private Resources.Theme theme;

    @CheckResult
    @NonNull
    public static f D(@IntRange(from = 0, to = 100) int i) {
        return new f().C(i);
    }

    @CheckResult
    @NonNull
    public static f E(@DrawableRes int i) {
        return new f().error(i);
    }

    @CheckResult
    @NonNull
    public static f H(@IntRange(from = 0) int i) {
        return m(i, i);
    }

    @CheckResult
    @NonNull
    public static f J(@DrawableRes int i) {
        return new f().I(i);
    }

    @CheckResult
    @NonNull
    public static f L(@IntRange(from = 0) int i) {
        return new f().K(i);
    }

    @CheckResult
    @NonNull
    public static f Si() {
        if (ul == null) {
            ul = new f().Ri().Qi();
        }
        return ul;
    }

    @CheckResult
    @NonNull
    public static f Ui() {
        if (tl == null) {
            tl = new f().Ti().Qi();
        }
        return tl;
    }

    @CheckResult
    @NonNull
    public static f Wi() {
        if (vl == null) {
            vl = new f().Vi().Qi();
        }
        return vl;
    }

    @CheckResult
    @NonNull
    public static f _i() {
        if (sl == null) {
            sl = new f().fitCenter().Qi();
        }
        return sl;
    }

    @CheckResult
    @NonNull
    public static f a(@NonNull j<Bitmap> jVar) {
        return new f().c(jVar);
    }

    @NonNull
    private f a(@NonNull j<Bitmap> jVar, boolean z) {
        if (this.Zk) {
            return clone().a(jVar, z);
        }
        r rVar = new r(jVar, z);
        a(Bitmap.class, jVar, z);
        a(Drawable.class, rVar, z);
        a(BitmapDrawable.class, rVar.Gi(), z);
        a(com.bumptech.glide.load.resource.gif.b.class, new e(jVar), z);
        xm();
        return this;
    }

    @NonNull
    private f a(@NonNull DownsampleStrategy downsampleStrategy, @NonNull j<Bitmap> jVar, boolean z) {
        f b2 = z ? b(downsampleStrategy, jVar) : a(downsampleStrategy, jVar);
        b2.Ne = true;
        return b2;
    }

    @NonNull
    private <T> f a(@NonNull Class<T> cls, @NonNull j<T> jVar, boolean z) {
        if (this.Zk) {
            return clone().a(cls, jVar, z);
        }
        i.checkNotNull(cls);
        i.checkNotNull(jVar);
        this.Qd.put(cls, jVar);
        this.fields |= 2048;
        this.Wk = true;
        this.fields |= 65536;
        this.Ne = false;
        if (z) {
            this.fields |= 131072;
            this.Me = true;
        }
        xm();
        return this;
    }

    @CheckResult
    @NonNull
    public static f b(@NonNull Bitmap.CompressFormat compressFormat) {
        return new f().a(compressFormat);
    }

    @CheckResult
    @NonNull
    public static f b(@NonNull Priority priority2) {
        return new f().a(priority2);
    }

    @CheckResult
    @NonNull
    public static f b(@NonNull DecodeFormat decodeFormat) {
        return new f().a(decodeFormat);
    }

    @CheckResult
    @NonNull
    public static f b(@NonNull o oVar) {
        return new f().a(oVar);
    }

    @CheckResult
    @NonNull
    public static <T> f b(@NonNull com.bumptech.glide.load.f<T> fVar, @NonNull T t) {
        return new f().a(fVar, t);
    }

    @CheckResult
    @NonNull
    public static f b(@NonNull DownsampleStrategy downsampleStrategy) {
        return new f().a(downsampleStrategy);
    }

    @NonNull
    private f c(@NonNull DownsampleStrategy downsampleStrategy, @NonNull j<Bitmap> jVar) {
        return a(downsampleStrategy, jVar, false);
    }

    @NonNull
    private f d(@NonNull DownsampleStrategy downsampleStrategy, @NonNull j<Bitmap> jVar) {
        return a(downsampleStrategy, jVar, true);
    }

    @CheckResult
    @NonNull
    public static f f(@IntRange(from = 0) long j) {
        return new f().e(j);
    }

    @CheckResult
    @NonNull
    public static f g(@Nullable Drawable drawable) {
        return new f().f(drawable);
    }

    @CheckResult
    @NonNull
    public static f h(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return new f().g(f2);
    }

    @CheckResult
    @NonNull
    public static f h(@NonNull c cVar) {
        return new f().g(cVar);
    }

    private boolean isSet(int i) {
        return q(this.fields, i);
    }

    @CheckResult
    @NonNull
    public static f j(@Nullable Drawable drawable) {
        return new f().i(drawable);
    }

    @CheckResult
    @NonNull
    public static f k(@NonNull Class<?> cls) {
        return new f().j(cls);
    }

    @CheckResult
    @NonNull
    public static f m(@IntRange(from = 0) int i, @IntRange(from = 0) int i2) {
        return new f().l(i, i2);
    }

    private static boolean q(int i, int i2) {
        return (i & i2) != 0;
    }

    @CheckResult
    @NonNull
    public static f vj() {
        if (xl == null) {
            xl = new f().Yi().Qi();
        }
        return xl;
    }

    @CheckResult
    @NonNull
    public static f w(boolean z) {
        if (z) {
            if (ql == null) {
                ql = new f().v(true).Qi();
            }
            return ql;
        }
        if (rl == null) {
            rl = new f().v(false).Qi();
        }
        return rl;
    }

    @CheckResult
    @NonNull
    public static f wj() {
        if (wl == null) {
            wl = new f().Zi().Qi();
        }
        return wl;
    }

    @NonNull
    private f xm() {
        if (!this.isLocked) {
            return this;
        }
        throw new IllegalStateException("You cannot modify locked RequestOptions, consider clone()");
    }

    @CheckResult
    @NonNull
    public f Aj() {
        return c(DownsampleStrategy.FIT_CENTER, new s());
    }

    @CheckResult
    @NonNull
    public f C(@IntRange(from = 0, to = 100) int i) {
        return a(com.bumptech.glide.load.resource.bitmap.e.Bi, Integer.valueOf(i));
    }

    @CheckResult
    @NonNull
    public f F(@DrawableRes int i) {
        if (this.Zk) {
            return clone().F(i);
        }
        this.Yk = i;
        this.fields |= 16384;
        xm();
        return this;
    }

    @CheckResult
    @NonNull
    public f G(int i) {
        return l(i, i);
    }

    @CheckResult
    @NonNull
    public f I(@DrawableRes int i) {
        if (this.Zk) {
            return clone().I(i);
        }
        this.Tk = i;
        this.fields |= 128;
        xm();
        return this;
    }

    @CheckResult
    @NonNull
    public f K(@IntRange(from = 0) int i) {
        return a(com.bumptech.glide.load.model.a.b.TIMEOUT, Integer.valueOf(i));
    }

    @NonNull
    public final Class<?> O() {
        return this.He;
    }

    @NonNull
    public f Qi() {
        if (!this.isLocked || this.Zk) {
            this.Zk = true;
            return lock();
        }
        throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
    }

    @CheckResult
    @NonNull
    public f Ri() {
        return b(DownsampleStrategy.dj, (j<Bitmap>) new com.bumptech.glide.load.resource.bitmap.j());
    }

    @CheckResult
    @NonNull
    public f Ti() {
        return d(DownsampleStrategy.CENTER_INSIDE, new k());
    }

    @CheckResult
    @NonNull
    public f Vi() {
        return b(DownsampleStrategy.CENTER_INSIDE, (j<Bitmap>) new l());
    }

    @CheckResult
    @NonNull
    public f Xi() {
        return a(com.bumptech.glide.load.resource.bitmap.o.kj, false);
    }

    @CheckResult
    @NonNull
    public f Yi() {
        return a(com.bumptech.glide.load.resource.gif.g.gk, true);
    }

    @CheckResult
    @NonNull
    public f Zi() {
        if (this.Zk) {
            return clone().Zi();
        }
        this.Qd.clear();
        this.fields &= -2049;
        this.Me = false;
        this.fields &= -131073;
        this.Wk = false;
        this.fields |= 65536;
        this.Ne = true;
        xm();
        return this;
    }

    @CheckResult
    @NonNull
    public f a(@Nullable Resources.Theme theme2) {
        if (this.Zk) {
            return clone().a(theme2);
        }
        this.theme = theme2;
        this.fields |= 32768;
        xm();
        return this;
    }

    @CheckResult
    @NonNull
    public f a(@NonNull Bitmap.CompressFormat compressFormat) {
        com.bumptech.glide.load.f<Bitmap.CompressFormat> fVar = com.bumptech.glide.load.resource.bitmap.e.Ci;
        i.checkNotNull(compressFormat);
        return a(fVar, compressFormat);
    }

    @CheckResult
    @NonNull
    public f a(@NonNull Priority priority2) {
        if (this.Zk) {
            return clone().a(priority2);
        }
        i.checkNotNull(priority2);
        this.priority = priority2;
        this.fields |= 8;
        xm();
        return this;
    }

    @CheckResult
    @NonNull
    public f a(@NonNull DecodeFormat decodeFormat) {
        i.checkNotNull(decodeFormat);
        return a(com.bumptech.glide.load.resource.bitmap.o.hj, decodeFormat).a(com.bumptech.glide.load.resource.gif.g.hj, decodeFormat);
    }

    @CheckResult
    @NonNull
    public f a(@NonNull o oVar) {
        if (this.Zk) {
            return clone().a(oVar);
        }
        i.checkNotNull(oVar);
        this.Le = oVar;
        this.fields |= 4;
        xm();
        return this;
    }

    @CheckResult
    @NonNull
    public <T> f a(@NonNull com.bumptech.glide.load.f<T> fVar, @NonNull T t) {
        if (this.Zk) {
            return clone().a(fVar, t);
        }
        i.checkNotNull(fVar);
        i.checkNotNull(t);
        this.options.a(fVar, t);
        xm();
        return this;
    }

    @CheckResult
    @NonNull
    public f a(@NonNull DownsampleStrategy downsampleStrategy) {
        com.bumptech.glide.load.f<DownsampleStrategy> fVar = DownsampleStrategy.fj;
        i.checkNotNull(downsampleStrategy);
        return a(fVar, downsampleStrategy);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public final f a(@NonNull DownsampleStrategy downsampleStrategy, @NonNull j<Bitmap> jVar) {
        if (this.Zk) {
            return clone().a(downsampleStrategy, jVar);
        }
        a(downsampleStrategy);
        return a(jVar, false);
    }

    @CheckResult
    @NonNull
    public <T> f a(@NonNull Class<T> cls, @NonNull j<T> jVar) {
        return a(cls, jVar, false);
    }

    @CheckResult
    @NonNull
    public f a(@NonNull j<Bitmap>... jVarArr) {
        return a((j<Bitmap>) new d((j<T>[]) jVarArr), true);
    }

    public final int aj() {
        return this.Rk;
    }

    @CheckResult
    @NonNull
    public f b(@NonNull j<Bitmap> jVar) {
        return a(jVar, false);
    }

    /* access modifiers changed from: package-private */
    @CheckResult
    @NonNull
    public final f b(@NonNull DownsampleStrategy downsampleStrategy, @NonNull j<Bitmap> jVar) {
        if (this.Zk) {
            return clone().b(downsampleStrategy, jVar);
        }
        a(downsampleStrategy);
        return c(jVar);
    }

    @CheckResult
    @NonNull
    public f b(@NonNull f fVar) {
        if (this.Zk) {
            return clone().b(fVar);
        }
        if (q(fVar.fields, 2)) {
            this.Pk = fVar.Pk;
        }
        if (q(fVar.fields, 262144)) {
            this._k = fVar._k;
        }
        if (q(fVar.fields, 1048576)) {
            this.Hf = fVar.Hf;
        }
        if (q(fVar.fields, 4)) {
            this.Le = fVar.Le;
        }
        if (q(fVar.fields, 8)) {
            this.priority = fVar.priority;
        }
        if (q(fVar.fields, 16)) {
            this.Qk = fVar.Qk;
        }
        if (q(fVar.fields, 32)) {
            this.Rk = fVar.Rk;
        }
        if (q(fVar.fields, 64)) {
            this.Sk = fVar.Sk;
        }
        if (q(fVar.fields, 128)) {
            this.Tk = fVar.Tk;
        }
        if (q(fVar.fields, 256)) {
            this.Ff = fVar.Ff;
        }
        if (q(fVar.fields, 512)) {
            this.Vk = fVar.Vk;
            this.Uk = fVar.Uk;
        }
        if (q(fVar.fields, 1024)) {
            this.signature = fVar.signature;
        }
        if (q(fVar.fields, 4096)) {
            this.He = fVar.He;
        }
        if (q(fVar.fields, 8192)) {
            this.Xk = fVar.Xk;
        }
        if (q(fVar.fields, 16384)) {
            this.Yk = fVar.Yk;
        }
        if (q(fVar.fields, 32768)) {
            this.theme = fVar.theme;
        }
        if (q(fVar.fields, 65536)) {
            this.Wk = fVar.Wk;
        }
        if (q(fVar.fields, 131072)) {
            this.Me = fVar.Me;
        }
        if (q(fVar.fields, 2048)) {
            this.Qd.putAll(fVar.Qd);
            this.Ne = fVar.Ne;
        }
        if (q(fVar.fields, 524288)) {
            this.ef = fVar.ef;
        }
        if (!this.Wk) {
            this.Qd.clear();
            this.fields &= -2049;
            this.Me = false;
            this.fields &= -131073;
            this.Ne = true;
        }
        this.fields |= fVar.fields;
        this.options.b(fVar.options);
        xm();
        return this;
    }

    @CheckResult
    @NonNull
    public <T> f b(@NonNull Class<T> cls, @NonNull j<T> jVar) {
        return a(cls, jVar, true);
    }

    @Nullable
    public final Drawable bj() {
        return this.Qk;
    }

    @CheckResult
    @NonNull
    public f c(@NonNull j<Bitmap> jVar) {
        return a(jVar, true);
    }

    @Nullable
    public final Drawable cj() {
        return this.Xk;
    }

    @CheckResult
    public f clone() {
        try {
            f fVar = (f) super.clone();
            fVar.options = new g();
            fVar.options.b(this.options);
            fVar.Qd = new CachedHashCodeArrayMap();
            fVar.Qd.putAll(this.Qd);
            fVar.isLocked = false;
            fVar.Zk = false;
            return fVar;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public final int dj() {
        return this.Yk;
    }

    @CheckResult
    @NonNull
    public f e(@IntRange(from = 0) long j) {
        return a(VideoDecoder.Lj, Long.valueOf(j));
    }

    public final boolean ej() {
        return this.ef;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return Float.compare(fVar.Pk, this.Pk) == 0 && this.Rk == fVar.Rk && com.bumptech.glide.util.l.d(this.Qk, fVar.Qk) && this.Tk == fVar.Tk && com.bumptech.glide.util.l.d(this.Sk, fVar.Sk) && this.Yk == fVar.Yk && com.bumptech.glide.util.l.d(this.Xk, fVar.Xk) && this.Ff == fVar.Ff && this.Uk == fVar.Uk && this.Vk == fVar.Vk && this.Me == fVar.Me && this.Wk == fVar.Wk && this._k == fVar._k && this.ef == fVar.ef && this.Le.equals(fVar.Le) && this.priority == fVar.priority && this.options.equals(fVar.options) && this.Qd.equals(fVar.Qd) && this.He.equals(fVar.He) && com.bumptech.glide.util.l.d(this.signature, fVar.signature) && com.bumptech.glide.util.l.d(this.theme, fVar.theme);
    }

    @CheckResult
    @NonNull
    public f error(@DrawableRes int i) {
        if (this.Zk) {
            return clone().error(i);
        }
        this.Rk = i;
        this.fields |= 32;
        xm();
        return this;
    }

    @CheckResult
    @NonNull
    public f f(@Nullable Drawable drawable) {
        if (this.Zk) {
            return clone().f(drawable);
        }
        this.Qk = drawable;
        this.fields |= 16;
        xm();
        return this;
    }

    @NonNull
    public final o fi() {
        return this.Le;
    }

    @CheckResult
    @NonNull
    public f fitCenter() {
        return d(DownsampleStrategy.FIT_CENTER, new s());
    }

    public final int fj() {
        return this.Uk;
    }

    @CheckResult
    @NonNull
    public f g(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (this.Zk) {
            return clone().g(f2);
        }
        if (f2 < 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.Pk = f2;
        this.fields |= 2;
        xm();
        return this;
    }

    @CheckResult
    @NonNull
    public f g(@NonNull c cVar) {
        if (this.Zk) {
            return clone().g(cVar);
        }
        i.checkNotNull(cVar);
        this.signature = cVar;
        this.fields |= 1024;
        xm();
        return this;
    }

    @NonNull
    public final g getOptions() {
        return this.options;
    }

    @NonNull
    public final Priority getPriority() {
        return this.priority;
    }

    @NonNull
    public final c getSignature() {
        return this.signature;
    }

    @Nullable
    public final Resources.Theme getTheme() {
        return this.theme;
    }

    @NonNull
    public final Map<Class<?>, j<?>> getTransformations() {
        return this.Qd;
    }

    public final int gj() {
        return this.Vk;
    }

    @CheckResult
    @NonNull
    public f h(@Nullable Drawable drawable) {
        if (this.Zk) {
            return clone().h(drawable);
        }
        this.Xk = drawable;
        this.fields |= 8192;
        xm();
        return this;
    }

    public int hashCode() {
        return com.bumptech.glide.util.l.a(this.theme, com.bumptech.glide.util.l.a(this.signature, com.bumptech.glide.util.l.a(this.He, com.bumptech.glide.util.l.a(this.Qd, com.bumptech.glide.util.l.a(this.options, com.bumptech.glide.util.l.a(this.priority, com.bumptech.glide.util.l.a(this.Le, com.bumptech.glide.util.l.c(this.ef, com.bumptech.glide.util.l.c(this._k, com.bumptech.glide.util.l.c(this.Wk, com.bumptech.glide.util.l.c(this.Me, com.bumptech.glide.util.l.n(this.Vk, com.bumptech.glide.util.l.n(this.Uk, com.bumptech.glide.util.l.c(this.Ff, com.bumptech.glide.util.l.a(this.Xk, com.bumptech.glide.util.l.n(this.Yk, com.bumptech.glide.util.l.a(this.Sk, com.bumptech.glide.util.l.n(this.Tk, com.bumptech.glide.util.l.a(this.Qk, com.bumptech.glide.util.l.n(this.Rk, com.bumptech.glide.util.l.hashCode(this.Pk)))))))))))))))))))));
    }

    @Nullable
    public final Drawable hj() {
        return this.Sk;
    }

    @CheckResult
    @NonNull
    public f i(@Nullable Drawable drawable) {
        if (this.Zk) {
            return clone().i(drawable);
        }
        this.Sk = drawable;
        this.fields |= 64;
        xm();
        return this;
    }

    public final int ij() {
        return this.Tk;
    }

    public final boolean isLocked() {
        return this.isLocked;
    }

    @CheckResult
    @NonNull
    public f j(@NonNull Class<?> cls) {
        if (this.Zk) {
            return clone().j(cls);
        }
        i.checkNotNull(cls);
        this.He = cls;
        this.fields |= 4096;
        xm();
        return this;
    }

    public final float jj() {
        return this.Pk;
    }

    /* access modifiers changed from: package-private */
    public boolean ki() {
        return this.Ne;
    }

    public final boolean kj() {
        return this.Hf;
    }

    @CheckResult
    @NonNull
    public f l(int i, int i2) {
        if (this.Zk) {
            return clone().l(i, i2);
        }
        this.Vk = i;
        this.Uk = i2;
        this.fields |= 512;
        xm();
        return this;
    }

    public final boolean lj() {
        return this._k;
    }

    @NonNull
    public f lock() {
        this.isLocked = true;
        return this;
    }

    /* access modifiers changed from: protected */
    public boolean mj() {
        return this.Zk;
    }

    public final boolean nj() {
        return isSet(4);
    }

    public final boolean oj() {
        return this.Ff;
    }

    public final boolean pj() {
        return isSet(8);
    }

    public final boolean qj() {
        return isSet(256);
    }

    public final boolean rj() {
        return this.Wk;
    }

    public final boolean sj() {
        return this.Me;
    }

    public final boolean tj() {
        return isSet(2048);
    }

    @CheckResult
    @NonNull
    public f u(boolean z) {
        if (this.Zk) {
            return clone().u(z);
        }
        this.ef = z;
        this.fields |= 524288;
        xm();
        return this;
    }

    public final boolean uj() {
        return com.bumptech.glide.util.l.o(this.Vk, this.Uk);
    }

    @CheckResult
    @NonNull
    public f v(boolean z) {
        if (this.Zk) {
            return clone().v(true);
        }
        this.Ff = !z;
        this.fields |= 256;
        xm();
        return this;
    }

    @CheckResult
    @NonNull
    public f x(boolean z) {
        if (this.Zk) {
            return clone().x(z);
        }
        this.Hf = z;
        this.fields |= 1048576;
        xm();
        return this;
    }

    @CheckResult
    @NonNull
    public f xj() {
        return a(DownsampleStrategy.dj, (j<Bitmap>) new com.bumptech.glide.load.resource.bitmap.j());
    }

    @CheckResult
    @NonNull
    public f y(boolean z) {
        if (this.Zk) {
            return clone().y(z);
        }
        this._k = z;
        this.fields |= 262144;
        xm();
        return this;
    }

    @CheckResult
    @NonNull
    public f yj() {
        return c(DownsampleStrategy.CENTER_INSIDE, new k());
    }

    @CheckResult
    @NonNull
    public f zj() {
        return a(DownsampleStrategy.dj, (j<Bitmap>) new l());
    }
}
