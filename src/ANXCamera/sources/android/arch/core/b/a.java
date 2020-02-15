package android.arch.core.b;

import android.arch.core.b.c;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* compiled from: FastSafeIterableMap */
public class a<K, V> extends c<K, V> {
    private HashMap<K, c.C0002c<K, V>> pa = new HashMap<>();

    public boolean contains(K k) {
        return this.pa.containsKey(k);
    }

    public Map.Entry<K, V> g(K k) {
        if (contains(k)) {
            return this.pa.get(k).la;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public c.C0002c<K, V> get(K k) {
        return this.pa.get(k);
    }

    public V putIfAbsent(@NonNull K k, @NonNull V v) {
        c.C0002c cVar = get(k);
        if (cVar != null) {
            return cVar.mValue;
        }
        this.pa.put(k, put(k, v));
        return null;
    }

    public V remove(@NonNull K k) {
        V remove = super.remove(k);
        this.pa.remove(k);
        return remove;
    }
}
