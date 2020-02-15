package com.bumptech.glide.load.engine.bitmap_recycle;

import android.support.annotation.Nullable;
import com.bumptech.glide.load.engine.bitmap_recycle.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: GroupedLinkedMap */
class g<K extends l, V> {
    private final a<K, V> head = new a<>();
    private final Map<K, a<K, V>> mg = new HashMap();

    /* compiled from: GroupedLinkedMap */
    private static class a<K, V> {
        final K key;
        a<K, V> next;
        a<K, V> prev;
        private List<V> values;

        a() {
            this((Object) null);
        }

        a(K k) {
            this.prev = this;
            this.next = this;
            this.key = k;
        }

        public void add(V v) {
            if (this.values == null) {
                this.values = new ArrayList();
            }
            this.values.add(v);
        }

        @Nullable
        public V removeLast() {
            int size = size();
            if (size > 0) {
                return this.values.remove(size - 1);
            }
            return null;
        }

        public int size() {
            List<V> list = this.values;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
    }

    g() {
    }

    private void a(a<K, V> aVar) {
        c(aVar);
        a<K, V> aVar2 = this.head;
        aVar.prev = aVar2;
        aVar.next = aVar2.next;
        d(aVar);
    }

    private void b(a<K, V> aVar) {
        c(aVar);
        a<K, V> aVar2 = this.head;
        aVar.prev = aVar2.prev;
        aVar.next = aVar2;
        d(aVar);
    }

    private static <K, V> void c(a<K, V> aVar) {
        a<K, V> aVar2 = aVar.prev;
        aVar2.next = aVar.next;
        aVar.next.prev = aVar2;
    }

    private static <K, V> void d(a<K, V> aVar) {
        aVar.next.prev = aVar;
        aVar.prev.next = aVar;
    }

    public void a(K k, V v) {
        a aVar = this.mg.get(k);
        if (aVar == null) {
            aVar = new a(k);
            b(aVar);
            this.mg.put(k, aVar);
        } else {
            k.J();
        }
        aVar.add(v);
    }

    @Nullable
    public V b(K k) {
        a aVar = this.mg.get(k);
        if (aVar == null) {
            aVar = new a(k);
            this.mg.put(k, aVar);
        } else {
            k.J();
        }
        a(aVar);
        return aVar.removeLast();
    }

    @Nullable
    public V removeLast() {
        for (a<K, V> aVar = this.head.prev; !aVar.equals(this.head); aVar = aVar.prev) {
            V removeLast = aVar.removeLast();
            if (removeLast != null) {
                return removeLast;
            }
            c(aVar);
            this.mg.remove(aVar.key);
            ((l) aVar.key).J();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z = false;
        for (a<K, V> aVar = this.head.next; !aVar.equals(this.head); aVar = aVar.next) {
            z = true;
            sb.append('{');
            sb.append(aVar.key);
            sb.append(':');
            sb.append(aVar.size());
            sb.append("}, ");
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }
}
