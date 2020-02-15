package com.bumptech.glide.request.a;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import com.bumptech.glide.request.a.f;

/* compiled from: ViewTransition */
public class k<R> implements f<R> {
    private final a fm;

    /* compiled from: ViewTransition */
    interface a {
        Animation E(Context context);
    }

    k(a aVar) {
        this.fm = aVar;
    }

    public boolean a(R r, f.a aVar) {
        View view = aVar.getView();
        if (view == null) {
            return false;
        }
        view.clearAnimation();
        view.startAnimation(this.fm.E(view.getContext()));
        return false;
    }
}
