package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.b;
import com.bumptech.glide.request.f;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.request.target.i;
import java.util.Map;

/* compiled from: GlideContext */
public class e extends ContextWrapper {
    @VisibleForTesting
    static final n<?, ?> DEFAULT_TRANSITION_OPTIONS = new b();
    private final int logLevel;
    private final Handler qa = new Handler(Looper.getMainLooper());
    private final b ra;
    private final Registry registry;
    private final i ta;
    private final f ua;
    private final Map<Class<?>, n<?, ?>> va;
    private final Engine wa;

    public e(@NonNull Context context, @NonNull b bVar, @NonNull Registry registry2, @NonNull i iVar, @NonNull f fVar, @NonNull Map<Class<?>, n<?, ?>> map, @NonNull Engine engine, int i) {
        super(context.getApplicationContext());
        this.ra = bVar;
        this.registry = registry2;
        this.ta = iVar;
        this.ua = fVar;
        this.va = map;
        this.wa = engine;
        this.logLevel = i;
    }

    @NonNull
    public <T> n<?, T> a(@NonNull Class<T> cls) {
        n<?, T> nVar = this.va.get(cls);
        if (nVar == null) {
            for (Map.Entry next : this.va.entrySet()) {
                if (((Class) next.getKey()).isAssignableFrom(cls)) {
                    nVar = (n) next.getValue();
                }
            }
        }
        return nVar == null ? DEFAULT_TRANSITION_OPTIONS : nVar;
    }

    @NonNull
    public <X> ViewTarget<ImageView, X> a(@NonNull ImageView imageView, @NonNull Class<X> cls) {
        return this.ta.b(imageView, cls);
    }

    public int getLogLevel() {
        return this.logLevel;
    }

    @NonNull
    public Registry getRegistry() {
        return this.registry;
    }

    @NonNull
    public b ka() {
        return this.ra;
    }

    public f la() {
        return this.ua;
    }

    @NonNull
    public Engine ma() {
        return this.wa;
    }

    @NonNull
    public Handler na() {
        return this.qa;
    }
}
