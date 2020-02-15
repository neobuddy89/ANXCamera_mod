package com.bumptech.glide.request.target;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.m;
import com.bumptech.glide.request.a.f;

/* compiled from: PreloadTarget */
public final class l<Z> extends m<Z> {
    private static final Handler HANDLER = new Handler(Looper.getMainLooper(), new k());
    private static final int Ml = 1;
    private final m ea;

    private l(m mVar, int i, int i2) {
        super(i, i2);
        this.ea = mVar;
    }

    public static <Z> l<Z> a(m mVar, int i, int i2) {
        return new l<>(mVar, i, i2);
    }

    public void a(@NonNull Z z, @Nullable f<? super Z> fVar) {
        HANDLER.obtainMessage(1, this).sendToTarget();
    }

    /* access modifiers changed from: package-private */
    public void clear() {
        this.ea.d((o<?>) this);
    }
}
