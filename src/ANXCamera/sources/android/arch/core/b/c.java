package android.arch.core.b;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* compiled from: SafeIterableMap */
public class c<K, V> implements Iterable<Map.Entry<K, V>> {
    private C0002c<K, V> mEnd;
    private int mSize = 0;
    /* access modifiers changed from: private */
    public C0002c<K, V> mStart;
    private WeakHashMap<f<K, V>, Boolean> oa = new WeakHashMap<>();

    /* compiled from: SafeIterableMap */
    static class a<K, V> extends e<K, V> {
        a(C0002c<K, V> cVar, C0002c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        /* access modifiers changed from: package-private */
        public C0002c<K, V> b(C0002c<K, V> cVar) {
            return cVar.la;
        }

        /* access modifiers changed from: package-private */
        public C0002c<K, V> c(C0002c<K, V> cVar) {
            return cVar.mNext;
        }
    }

    /* compiled from: SafeIterableMap */
    private static class b<K, V> extends e<K, V> {
        b(C0002c<K, V> cVar, C0002c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        /* access modifiers changed from: package-private */
        public C0002c<K, V> b(C0002c<K, V> cVar) {
            return cVar.mNext;
        }

        /* access modifiers changed from: package-private */
        public C0002c<K, V> c(C0002c<K, V> cVar) {
            return cVar.la;
        }
    }

    /* renamed from: android.arch.core.b.c$c  reason: collision with other inner class name */
    /* compiled from: SafeIterableMap */
    static class C0002c<K, V> implements Map.Entry<K, V> {
        C0002c<K, V> la;
        @NonNull
        final K mKey;
        C0002c<K, V> mNext;
        @NonNull
        final V mValue;

        C0002c(@NonNull K k, @NonNull V v) {
            this.mKey = k;
            this.mValue = v;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C0002c)) {
                return false;
            }
            C0002c cVar = (C0002c) obj;
            return this.mKey.equals(cVar.mKey) && this.mValue.equals(cVar.mValue);
        }

        @NonNull
        public K getKey() {
            return this.mKey;
        }

        @NonNull
        public V getValue() {
            return this.mValue;
        }

        public int hashCode() {
            return this.mValue.hashCode() ^ this.mKey.hashCode();
        }

        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.mKey + "=" + this.mValue;
        }
    }

    /* compiled from: SafeIterableMap */
    private class d implements Iterator<Map.Entry<K, V>>, f<K, V> {
        private C0002c<K, V> mCurrent;
        private boolean ma;

        private d() {
            this.ma = true;
        }

        public void a(@NonNull C0002c<K, V> cVar) {
            C0002c<K, V> cVar2 = this.mCurrent;
            if (cVar == cVar2) {
                this.mCurrent = cVar2.la;
                this.ma = this.mCurrent == null;
            }
        }

        public boolean hasNext() {
            if (this.ma) {
                return c.this.mStart != null;
            }
            C0002c<K, V> cVar = this.mCurrent;
            return (cVar == null || cVar.mNext == null) ? false : true;
        }

        public Map.Entry<K, V> next() {
            if (this.ma) {
                this.ma = false;
                this.mCurrent = c.this.mStart;
            } else {
                C0002c<K, V> cVar = this.mCurrent;
                this.mCurrent = cVar != null ? cVar.mNext : null;
            }
            return this.mCurrent;
        }
    }

    /* compiled from: SafeIterableMap */
    private static abstract class e<K, V> implements Iterator<Map.Entry<K, V>>, f<K, V> {
        C0002c<K, V> mNext;
        C0002c<K, V> na;

        e(C0002c<K, V> cVar, C0002c<K, V> cVar2) {
            this.na = cVar2;
            this.mNext = cVar;
        }

        private C0002c<K, V> nextNode() {
            C0002c<K, V> cVar = this.mNext;
            C0002c<K, V> cVar2 = this.na;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return c(cVar);
        }

        public void a(@NonNull C0002c<K, V> cVar) {
            if (this.na == cVar && cVar == this.mNext) {
                this.mNext = null;
                this.na = null;
            }
            C0002c<K, V> cVar2 = this.na;
            if (cVar2 == cVar) {
                this.na = b(cVar2);
            }
            if (this.mNext == cVar) {
                this.mNext = nextNode();
            }
        }

        /* access modifiers changed from: package-private */
        public abstract C0002c<K, V> b(C0002c<K, V> cVar);

        /* access modifiers changed from: package-private */
        public abstract C0002c<K, V> c(C0002c<K, V> cVar);

        public boolean hasNext() {
            return this.mNext != null;
        }

        public Map.Entry<K, V> next() {
            C0002c<K, V> cVar = this.mNext;
            this.mNext = nextNode();
            return cVar;
        }
    }

    /* compiled from: SafeIterableMap */
    interface f<K, V> {
        void a(@NonNull C0002c<K, V> cVar);
    }

    public Iterator<Map.Entry<K, V>> descendingIterator() {
        b bVar = new b(this.mEnd, this.mStart);
        this.oa.put(bVar, false);
        return bVar;
    }

    public Map.Entry<K, V> eldest() {
        return this.mStart;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (size() != cVar.size()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = cVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object next = it2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        return !it.hasNext() && !it2.hasNext();
    }

    /* access modifiers changed from: protected */
    public C0002c<K, V> get(K k) {
        C0002c<K, V> cVar = this.mStart;
        while (cVar != null && !cVar.mKey.equals(k)) {
            cVar = cVar.mNext;
        }
        return cVar;
    }

    public int hashCode() {
        Iterator it = iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((Map.Entry) it.next()).hashCode();
        }
        return i;
    }

    public c<K, V>.d ia() {
        c<K, V>.d dVar = new d();
        this.oa.put(dVar, false);
        return dVar;
    }

    @NonNull
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.mStart, this.mEnd);
        this.oa.put(aVar, false);
        return aVar;
    }

    public Map.Entry<K, V> ja() {
        return this.mEnd;
    }

    /* access modifiers changed from: protected */
    public C0002c<K, V> put(@NonNull K k, @NonNull V v) {
        C0002c<K, V> cVar = new C0002c<>(k, v);
        this.mSize++;
        C0002c<K, V> cVar2 = this.mEnd;
        if (cVar2 == null) {
            this.mStart = cVar;
            this.mEnd = this.mStart;
            return cVar;
        }
        cVar2.mNext = cVar;
        cVar.la = cVar2;
        this.mEnd = cVar;
        return cVar;
    }

    public V putIfAbsent(@NonNull K k, @NonNull V v) {
        C0002c cVar = get(k);
        if (cVar != null) {
            return cVar.mValue;
        }
        put(k, v);
        return null;
    }

    public V remove(@NonNull K k) {
        C0002c cVar = get(k);
        if (cVar == null) {
            return null;
        }
        this.mSize--;
        if (!this.oa.isEmpty()) {
            for (f<K, V> a2 : this.oa.keySet()) {
                a2.a(cVar);
            }
        }
        C0002c<K, V> cVar2 = cVar.la;
        if (cVar2 != null) {
            cVar2.mNext = cVar.mNext;
        } else {
            this.mStart = cVar.mNext;
        }
        C0002c<K, V> cVar3 = cVar.mNext;
        if (cVar3 != null) {
            cVar3.la = cVar.la;
        } else {
            this.mEnd = cVar.la;
        }
        cVar.mNext = null;
        cVar.la = null;
        return cVar.mValue;
    }

    public int size() {
        return this.mSize;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            sb.append(((Map.Entry) it.next()).toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
