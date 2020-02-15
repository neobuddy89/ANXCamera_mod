package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.CheckResult;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RawRes;
import android.view.View;
import com.bumptech.glide.load.engine.o;
import com.bumptech.glide.manager.c;
import com.bumptech.glide.manager.d;
import com.bumptech.glide.manager.i;
import com.bumptech.glide.manager.j;
import com.bumptech.glide.manager.p;
import com.bumptech.glide.manager.q;
import com.bumptech.glide.request.f;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.util.l;
import java.io.File;
import java.net.URL;

/* compiled from: RequestManager */
public class m implements j, g<j<Drawable>> {
    private static final f Ic = f.b(o.DATA).a(Priority.LOW).v(true);
    private static final f Oc = f.k(Bitmap.class).lock();
    private static final f Pc = f.k(com.bumptech.glide.load.resource.gif.b.class).lock();
    private final p Jc;
    private final com.bumptech.glide.manager.o Kc;
    private final q Lc;
    private final Runnable Mc;
    protected final c Nb;
    private final c Nc;
    final i ba;
    protected final Context context;
    private final Handler qa;
    private f zc;

    /* compiled from: RequestManager */
    private static class a extends ViewTarget<View, Object> {
        a(@NonNull View view) {
            super(view);
        }

        public void a(@NonNull Object obj, @Nullable com.bumptech.glide.request.a.f<? super Object> fVar) {
        }
    }

    /* compiled from: RequestManager */
    private static class b implements c.a {
        private final p Jc;

        b(@NonNull p pVar) {
            this.Jc = pVar;
        }

        public void h(boolean z) {
            if (z) {
                this.Jc.Li();
            }
        }
    }

    public m(@NonNull c cVar, @NonNull i iVar, @NonNull com.bumptech.glide.manager.o oVar, @NonNull Context context2) {
        this(cVar, iVar, oVar, new p(), cVar.Eh(), context2);
    }

    m(c cVar, i iVar, com.bumptech.glide.manager.o oVar, p pVar, d dVar, Context context2) {
        this.Lc = new q();
        this.Mc = new k(this);
        this.qa = new Handler(Looper.getMainLooper());
        this.Nb = cVar;
        this.ba = iVar;
        this.Kc = oVar;
        this.Jc = pVar;
        this.context = context2;
        this.Nc = dVar.a(context2.getApplicationContext(), new b(pVar));
        if (l.Kj()) {
            this.qa.post(this.Mc);
        } else {
            iVar.b(this);
        }
        iVar.b(this.Nc);
        d(cVar.Fh().la());
        cVar.b(this);
    }

    private void e(@NonNull f fVar) {
        this.zc = this.zc.b(fVar);
    }

    private void g(@NonNull com.bumptech.glide.request.target.o<?> oVar) {
        if (!e(oVar) && !this.Nb.a(oVar) && oVar.getRequest() != null) {
            com.bumptech.glide.request.c request = oVar.getRequest();
            oVar.f((com.bumptech.glide.request.c) null);
            request.clear();
        }
    }

    @CheckResult
    @NonNull
    public j<Bitmap> Lh() {
        return b(Bitmap.class).b(Oc);
    }

    @CheckResult
    @NonNull
    public j<Drawable> Mh() {
        return b(Drawable.class);
    }

    @CheckResult
    @NonNull
    public j<File> Nh() {
        return b(File.class).b(f.w(true));
    }

    @CheckResult
    @NonNull
    public j<com.bumptech.glide.load.resource.gif.b> Oh() {
        return b(com.bumptech.glide.load.resource.gif.b.class).b(Pc);
    }

    @CheckResult
    @NonNull
    public j<File> Ph() {
        return b(File.class).b(Ic);
    }

    public void Qh() {
        l.Jj();
        this.Jc.Qh();
    }

    public void Rh() {
        l.Jj();
        this.Jc.Rh();
    }

    public void Sh() {
        l.Jj();
        Rh();
        for (m Rh : this.Kc.W()) {
            Rh.Rh();
        }
    }

    public void Th() {
        l.Jj();
        this.Jc.Th();
    }

    public void Uh() {
        l.Jj();
        Th();
        for (m Th : this.Kc.W()) {
            Th.Th();
        }
    }

    @CheckResult
    @NonNull
    public j<Drawable> a(@Nullable Drawable drawable) {
        return Mh().a(drawable);
    }

    @CheckResult
    @NonNull
    public j<Drawable> a(@Nullable File file) {
        return Mh().a(file);
    }

    @CheckResult
    @NonNull
    public j<Drawable> a(@Nullable @RawRes @DrawableRes Integer num) {
        return Mh().a(num);
    }

    @NonNull
    public m a(@NonNull f fVar) {
        d(fVar);
        return this;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public <T> n<?, T> a(Class<T> cls) {
        return this.Nb.Fh().a(cls);
    }

    /* access modifiers changed from: package-private */
    public void a(@NonNull com.bumptech.glide.request.target.o<?> oVar, @NonNull com.bumptech.glide.request.c cVar) {
        this.Lc.f(oVar);
        this.Jc.i(cVar);
    }

    @CheckResult
    @NonNull
    public <ResourceType> j<ResourceType> b(@NonNull Class<ResourceType> cls) {
        return new j<>(this.Nb, this, cls, this.context);
    }

    @Deprecated
    @CheckResult
    public j<Drawable> b(@Nullable URL url) {
        return Mh().b(url);
    }

    @CheckResult
    @NonNull
    public j<Drawable> c(@Nullable Uri uri) {
        return Mh().c(uri);
    }

    @NonNull
    public m c(@NonNull f fVar) {
        e(fVar);
        return this;
    }

    /* access modifiers changed from: protected */
    public void d(@NonNull f fVar) {
        this.zc = fVar.clone().Qi();
    }

    public void d(@Nullable com.bumptech.glide.request.target.o<?> oVar) {
        if (oVar != null) {
            if (l.Lj()) {
                g(oVar);
            } else {
                this.qa.post(new l(this, oVar));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean e(@NonNull com.bumptech.glide.request.target.o<?> oVar) {
        com.bumptech.glide.request.c request = oVar.getRequest();
        if (request == null) {
            return true;
        }
        if (!this.Jc.h(request)) {
            return false;
        }
        this.Lc.e(oVar);
        oVar.f((com.bumptech.glide.request.c) null);
        return true;
    }

    @CheckResult
    @NonNull
    public j<Drawable> f(@Nullable byte[] bArr) {
        return Mh().f(bArr);
    }

    public void f(@NonNull View view) {
        d((com.bumptech.glide.request.target.o<?>) new a(view));
    }

    @CheckResult
    @NonNull
    public j<Drawable> g(@Nullable Bitmap bitmap) {
        return Mh().g(bitmap);
    }

    public boolean isPaused() {
        l.Jj();
        return this.Jc.isPaused();
    }

    /* access modifiers changed from: package-private */
    public f la() {
        return this.zc;
    }

    @CheckResult
    @NonNull
    public j<Drawable> load(@Nullable Object obj) {
        return Mh().load(obj);
    }

    @CheckResult
    @NonNull
    public j<Drawable> load(@Nullable String str) {
        return Mh().load(str);
    }

    @CheckResult
    @NonNull
    public j<File> m(@Nullable Object obj) {
        return Ph().load(obj);
    }

    public void onDestroy() {
        this.Lc.onDestroy();
        for (com.bumptech.glide.request.target.o<?> d2 : this.Lc.getAll()) {
            d(d2);
        }
        this.Lc.clear();
        this.Jc.Ki();
        this.ba.a(this);
        this.ba.a(this.Nc);
        this.qa.removeCallbacks(this.Mc);
        this.Nb.c(this);
    }

    public void onStart() {
        Th();
        this.Lc.onStart();
    }

    public void onStop() {
        Rh();
        this.Lc.onStop();
    }

    public String toString() {
        return super.toString() + "{tracker=" + this.Jc + ", treeNode=" + this.Kc + "}";
    }
}
