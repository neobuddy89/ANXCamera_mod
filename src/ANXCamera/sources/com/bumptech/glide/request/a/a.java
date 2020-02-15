package com.bumptech.glide.request.a;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.a.f;

/* compiled from: BitmapContainerTransitionFactory */
public abstract class a<R> implements g<R> {
    private final g<Drawable> Yl;

    /* renamed from: com.bumptech.glide.request.a.a$a  reason: collision with other inner class name */
    /* compiled from: BitmapContainerTransitionFactory */
    private final class C0012a implements f<R> {
        private final f<Drawable> transition;

        C0012a(f<Drawable> fVar) {
            this.transition = fVar;
        }

        public boolean a(R r, f.a aVar) {
            return this.transition.a(new BitmapDrawable(aVar.getView().getResources(), a.this.q(r)), aVar);
        }
    }

    public a(g<Drawable> gVar) {
        this.Yl = gVar;
    }

    public f<R> a(DataSource dataSource, boolean z) {
        return new C0012a(this.Yl.a(dataSource, z));
    }

    /* access modifiers changed from: protected */
    public abstract Bitmap q(R r);
}
