package com.bumptech.glide.d;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: EncoderRegistry */
public class a {
    private final List<C0005a<?>> Ek = new ArrayList();

    /* renamed from: com.bumptech.glide.d.a$a  reason: collision with other inner class name */
    /* compiled from: EncoderRegistry */
    private static final class C0005a<T> {
        private final Class<T> dataClass;
        final com.bumptech.glide.load.a<T> encoder;

        C0005a(@NonNull Class<T> cls, @NonNull com.bumptech.glide.load.a<T> aVar) {
            this.dataClass = cls;
            this.encoder = aVar;
        }

        /* access modifiers changed from: package-private */
        public boolean g(@NonNull Class<?> cls) {
            return this.dataClass.isAssignableFrom(cls);
        }
    }

    public synchronized <T> void a(@NonNull Class<T> cls, @NonNull com.bumptech.glide.load.a<T> aVar) {
        this.Ek.add(new C0005a(cls, aVar));
    }

    public synchronized <T> void b(@NonNull Class<T> cls, @NonNull com.bumptech.glide.load.a<T> aVar) {
        this.Ek.add(0, new C0005a(cls, aVar));
    }

    @Nullable
    public synchronized <T> com.bumptech.glide.load.a<T> i(@NonNull Class<T> cls) {
        for (C0005a next : this.Ek) {
            if (next.g(cls)) {
                return next.encoder;
            }
        }
        return null;
    }
}
