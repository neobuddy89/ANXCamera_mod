package com.bumptech.glide.d;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.i;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ResourceEncoderRegistry */
public class f {
    private final List<a<?>> Ek = new ArrayList();

    /* compiled from: ResourceEncoderRegistry */
    private static final class a<T> {
        private final Class<T> He;
        final i<T> encoder;

        a(@NonNull Class<T> cls, @NonNull i<T> iVar) {
            this.He = cls;
            this.encoder = iVar;
        }

        /* access modifiers changed from: package-private */
        public boolean g(@NonNull Class<?> cls) {
            return this.He.isAssignableFrom(cls);
        }
    }

    public synchronized <Z> void a(@NonNull Class<Z> cls, @NonNull i<Z> iVar) {
        this.Ek.add(new a(cls, iVar));
    }

    public synchronized <Z> void b(@NonNull Class<Z> cls, @NonNull i<Z> iVar) {
        this.Ek.add(0, new a(cls, iVar));
    }

    @Nullable
    public synchronized <Z> i<Z> get(@NonNull Class<Z> cls) {
        int size = this.Ek.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.Ek.get(i);
            if (aVar.g(cls)) {
                return aVar.encoder;
            }
        }
        return null;
    }
}
