package com.bumptech.glide.load.b.b;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import com.bumptech.glide.n;
import com.bumptech.glide.request.a.c;
import com.bumptech.glide.request.a.g;

/* compiled from: DrawableTransitionOptions */
public final class c extends n<c, Drawable> {
    @NonNull
    public static c Zh() {
        return new c().Yh();
    }

    @NonNull
    public static c b(@NonNull c.a aVar) {
        return new c().a(aVar);
    }

    @NonNull
    public static c b(@NonNull com.bumptech.glide.request.a.c cVar) {
        return new c().a(cVar);
    }

    @NonNull
    public static c b(@NonNull g<Drawable> gVar) {
        return (c) new c().a(gVar);
    }

    @NonNull
    public static c s(int i) {
        return new c().r(i);
    }

    @NonNull
    public c Yh() {
        return a(new c.a());
    }

    @NonNull
    public c a(@NonNull c.a aVar) {
        return a(aVar.build());
    }

    @NonNull
    public c a(@NonNull com.bumptech.glide.request.a.c cVar) {
        return (c) a(cVar);
    }

    @NonNull
    public c r(int i) {
        return a(new c.a(i));
    }
}
