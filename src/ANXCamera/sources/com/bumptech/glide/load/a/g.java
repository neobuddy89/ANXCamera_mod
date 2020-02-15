package com.bumptech.glide.load.a;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.a.e;
import com.bumptech.glide.util.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: DataRewinderRegistry */
public class g {
    private static final e.a<?> Xd = new f();
    private final Map<Class<?>, e.a<?>> Wd = new HashMap();

    /* compiled from: DataRewinderRegistry */
    private static final class a implements e<Object> {
        private final Object data;

        a(@NonNull Object obj) {
            this.data = obj;
        }

        @NonNull
        public Object R() {
            return this.data;
        }

        public void cleanup() {
        }
    }

    public synchronized void a(@NonNull e.a<?> aVar) {
        this.Wd.put(aVar.ba(), aVar);
    }

    @NonNull
    public synchronized <T> e<T> build(@NonNull T t) {
        e.a<?> aVar;
        i.checkNotNull(t);
        aVar = this.Wd.get(t.getClass());
        if (aVar == null) {
            Iterator<e.a<?>> it = this.Wd.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                e.a<?> next = it.next();
                if (next.ba().isAssignableFrom(t.getClass())) {
                    aVar = next;
                    break;
                }
            }
        }
        if (aVar == null) {
            aVar = Xd;
        }
        return aVar.build(t);
    }
}
