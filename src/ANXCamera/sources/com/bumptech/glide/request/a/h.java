package com.bumptech.glide.request.a;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.a.k;

/* compiled from: ViewAnimationFactory */
public class h<R> implements g<R> {
    private final k.a fm;
    private f<R> transition;

    /* compiled from: ViewAnimationFactory */
    private static class a implements k.a {
        private final Animation animation;

        a(Animation animation2) {
            this.animation = animation2;
        }

        public Animation E(Context context) {
            return this.animation;
        }
    }

    /* compiled from: ViewAnimationFactory */
    private static class b implements k.a {
        private final int em;

        b(int i) {
            this.em = i;
        }

        public Animation E(Context context) {
            return AnimationUtils.loadAnimation(context, this.em);
        }
    }

    public h(int i) {
        this((k.a) new b(i));
    }

    public h(Animation animation) {
        this((k.a) new a(animation));
    }

    h(k.a aVar) {
        this.fm = aVar;
    }

    public f<R> a(DataSource dataSource, boolean z) {
        if (dataSource == DataSource.MEMORY_CACHE || !z) {
            return e.get();
        }
        if (this.transition == null) {
            this.transition = new k(this.fm);
        }
        return this.transition;
    }
}
