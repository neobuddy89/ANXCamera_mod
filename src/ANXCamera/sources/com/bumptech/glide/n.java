package com.bumptech.glide;

import android.support.annotation.NonNull;
import com.bumptech.glide.n;
import com.bumptech.glide.request.a.e;
import com.bumptech.glide.request.a.g;
import com.bumptech.glide.request.a.h;
import com.bumptech.glide.request.a.j;
import com.bumptech.glide.util.i;

/* compiled from: TransitionOptions */
public abstract class n<CHILD extends n<CHILD, TranscodeType>, TranscodeType> implements Cloneable {
    private g<? super TranscodeType> Qc = e.getFactory();

    private CHILD self() {
        return this;
    }

    @NonNull
    public final CHILD Vh() {
        return a(e.getFactory());
    }

    /* access modifiers changed from: package-private */
    public final g<? super TranscodeType> Wh() {
        return this.Qc;
    }

    @NonNull
    public final CHILD a(@NonNull g<? super TranscodeType> gVar) {
        i.checkNotNull(gVar);
        this.Qc = gVar;
        self();
        return this;
    }

    @NonNull
    public final CHILD a(@NonNull j.a aVar) {
        return a(new com.bumptech.glide.request.a.i(aVar));
    }

    public final CHILD clone() {
        try {
            return (n) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    @NonNull
    public final CHILD p(int i) {
        return a(new h(i));
    }
}
