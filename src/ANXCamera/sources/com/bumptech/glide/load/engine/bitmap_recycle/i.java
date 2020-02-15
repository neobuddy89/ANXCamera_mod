package com.bumptech.glide.load.engine.bitmap_recycle;

import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* compiled from: LruArrayPool */
public final class i implements b {
    private static final int DEFAULT_SIZE = 4194304;
    @VisibleForTesting
    static final int MAX_OVER_SIZE_MULTIPLE = 8;
    private static final int qg = 2;
    private int currentSize;
    private final b kg;
    private final g<a, Object> lg;
    private final int maxSize;
    private final Map<Class<?>, NavigableMap<Integer, Integer>> og;
    private final Map<Class<?>, a<?>> pg;

    /* compiled from: LruArrayPool */
    private static final class a implements l {
        private Class<?> ng;
        private final b pool;
        int size;

        a(b bVar) {
            this.pool = bVar;
        }

        public void J() {
            this.pool.a(this);
        }

        /* access modifiers changed from: package-private */
        public void c(int i, Class<?> cls) {
            this.size = i;
            this.ng = cls;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.size == aVar.size && this.ng == aVar.ng;
        }

        public int hashCode() {
            int i = this.size * 31;
            Class<?> cls = this.ng;
            return i + (cls != null ? cls.hashCode() : 0);
        }

        public String toString() {
            return "Key{size=" + this.size + "array=" + this.ng + '}';
        }
    }

    /* compiled from: LruArrayPool */
    private static final class b extends c<a> {
        b() {
        }

        /* access modifiers changed from: package-private */
        public a a(int i, Class<?> cls) {
            a aVar = (a) get();
            aVar.c(i, cls);
            return aVar;
        }

        /* access modifiers changed from: protected */
        public a create() {
            return new a(this);
        }
    }

    @VisibleForTesting
    public i() {
        this.lg = new g<>();
        this.kg = new b();
        this.og = new HashMap();
        this.pg = new HashMap();
        this.maxSize = 4194304;
    }

    public i(int i) {
        this.lg = new g<>();
        this.kg = new b();
        this.og = new HashMap();
        this.pg = new HashMap();
        this.maxSize = i;
    }

    private void U(int i) {
        while (this.currentSize > i) {
            Object removeLast = this.lg.removeLast();
            com.bumptech.glide.util.i.checkNotNull(removeLast);
            a v = v(removeLast);
            this.currentSize -= v.a(removeLast) * v.T();
            d(v.a(removeLast), removeLast.getClass());
            if (Log.isLoggable(v.getTag(), 2)) {
                Log.v(v.getTag(), "evicted: " + v.a(removeLast));
            }
        }
    }

    private boolean V(int i) {
        return i <= this.maxSize / 2;
    }

    private void Xl() {
        U(this.maxSize);
    }

    private boolean Yl() {
        int i = this.currentSize;
        return i == 0 || this.maxSize / i >= 2;
    }

    @Nullable
    private <T> T a(a aVar) {
        return this.lg.b(aVar);
    }

    private <T> T a(a aVar, Class<T> cls) {
        a<T> m = m(cls);
        T a2 = a(aVar);
        if (a2 != null) {
            this.currentSize -= m.a(a2) * m.T();
            d(m.a(a2), cls);
        }
        if (a2 != null) {
            return a2;
        }
        if (Log.isLoggable(m.getTag(), 2)) {
            Log.v(m.getTag(), "Allocated " + aVar.size + " bytes");
        }
        return m.newArray(aVar.size);
    }

    private boolean a(int i, Integer num) {
        return num != null && (Yl() || num.intValue() <= i * 8);
    }

    private void d(int i, Class<?> cls) {
        NavigableMap<Integer, Integer> n = n(cls);
        Integer num = (Integer) n.get(Integer.valueOf(i));
        if (num == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + i + ", this: " + this);
        } else if (num.intValue() == 1) {
            n.remove(Integer.valueOf(i));
        } else {
            n.put(Integer.valueOf(i), Integer.valueOf(num.intValue() - 1));
        }
    }

    private <T> a<T> m(Class<T> cls) {
        a<T> aVar = this.pg.get(cls);
        if (aVar == null) {
            if (cls.equals(int[].class)) {
                aVar = new h();
            } else if (cls.equals(byte[].class)) {
                aVar = new f();
            } else {
                throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
            }
            this.pg.put(cls, aVar);
        }
        return aVar;
    }

    private NavigableMap<Integer, Integer> n(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.og.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.og.put(cls, treeMap);
        return treeMap;
    }

    private <T> a<T> v(T t) {
        return m(t.getClass());
    }

    public synchronized void V() {
        U(0);
    }

    /* access modifiers changed from: package-private */
    public int Y() {
        int i = 0;
        for (Class next : this.og.keySet()) {
            for (Integer num : this.og.get(next).keySet()) {
                i += num.intValue() * ((Integer) this.og.get(next).get(num)).intValue() * m(next).T();
            }
        }
        return i;
    }

    public synchronized <T> T a(int i, Class<T> cls) {
        Integer ceilingKey;
        ceilingKey = n(cls).ceilingKey(Integer.valueOf(i));
        return a(a(i, ceilingKey) ? this.kg.a(ceilingKey.intValue(), cls) : this.kg.a(i, cls), cls);
    }

    @Deprecated
    public <T> void a(T t, Class<T> cls) {
        put(t);
    }

    public synchronized <T> T b(int i, Class<T> cls) {
        return a(this.kg.a(i, cls), cls);
    }

    public synchronized <T> void put(T t) {
        Class<?> cls = t.getClass();
        a<?> m = m(cls);
        int a2 = m.a(t);
        int T = m.T() * a2;
        if (V(T)) {
            a a3 = this.kg.a(a2, cls);
            this.lg.a(a3, t);
            NavigableMap<Integer, Integer> n = n(cls);
            Integer num = (Integer) n.get(Integer.valueOf(a3.size));
            Integer valueOf = Integer.valueOf(a3.size);
            int i = 1;
            if (num != null) {
                i = 1 + num.intValue();
            }
            n.put(valueOf, Integer.valueOf(i));
            this.currentSize += T;
            Xl();
        }
    }

    public synchronized void trimMemory(int i) {
        if (i >= 40) {
            try {
                V();
            } catch (Throwable th) {
                throw th;
            }
        } else if (i >= 20 || i == 15) {
            U(this.maxSize / 2);
        }
    }
}
