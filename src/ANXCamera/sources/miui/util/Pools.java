package miui.util;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import miui.util.concurrent.ConcurrentRingQueue;

public final class Pools {
    /* access modifiers changed from: private */
    public static final HashMap<Class<?>, c<?>> pS = new HashMap<>();
    /* access modifiers changed from: private */
    public static final HashMap<Class<?>, d<?>> qS = new HashMap<>();
    private static final Pool<StringBuilder> rS = createSoftReferencePool(new Manager<StringBuilder>() {
        /* renamed from: a */
        public void onRelease(StringBuilder sb) {
            sb.setLength(0);
        }

        public StringBuilder createInstance() {
            return new StringBuilder();
        }
    }, 4);

    public static abstract class Manager<T> {
        public abstract T createInstance();

        public void onAcquire(T t) {
        }

        public void onDestroy(T t) {
        }

        public void onRelease(T t) {
        }
    }

    public interface Pool<T> {
        T acquire();

        void close();

        int getSize();

        void release(T t);
    }

    public static class SimplePool<T> extends a<T> {
        SimplePool(Manager<T> manager, int i) {
            super(manager, i);
        }

        /* access modifiers changed from: package-private */
        public final void a(b<T> bVar, int i) {
            Pools.a((c) bVar, i);
        }

        public /* bridge */ /* synthetic */ Object acquire() {
            return super.acquire();
        }

        /* access modifiers changed from: package-private */
        public final b<T> b(Class<T> cls, int i) {
            return Pools.c(cls, i);
        }

        public /* bridge */ /* synthetic */ void close() {
            super.close();
        }

        public /* bridge */ /* synthetic */ int getSize() {
            return super.getSize();
        }

        public /* bridge */ /* synthetic */ void release(Object obj) {
            super.release(obj);
        }
    }

    public static class SoftReferencePool<T> extends a<T> {
        SoftReferencePool(Manager<T> manager, int i) {
            super(manager, i);
        }

        /* access modifiers changed from: package-private */
        public final void a(b<T> bVar, int i) {
            Pools.a((d) bVar, i);
        }

        public /* bridge */ /* synthetic */ Object acquire() {
            return super.acquire();
        }

        /* access modifiers changed from: package-private */
        public final b<T> b(Class<T> cls, int i) {
            return Pools.d(cls, i);
        }

        public /* bridge */ /* synthetic */ void close() {
            super.close();
        }

        public /* bridge */ /* synthetic */ int getSize() {
            return super.getSize();
        }

        public /* bridge */ /* synthetic */ void release(Object obj) {
            super.release(obj);
        }
    }

    static abstract class a<T> implements Pool<T> {
        private final Object cG = new h(this);
        private final Manager<T> mManager;
        private final int mSize;
        private b<T> nS;

        public a(Manager<T> manager, int i) {
            if (manager == null || i < 1) {
                this.mSize = this.cG.hashCode();
                throw new IllegalArgumentException("manager cannot be null and size cannot less then 1");
            }
            this.mManager = manager;
            this.mSize = i;
            T createInstance = this.mManager.createInstance();
            if (createInstance != null) {
                this.nS = b(createInstance.getClass(), i);
                doRelease(createInstance);
                return;
            }
            throw new IllegalStateException("manager create instance cannot return null");
        }

        /* access modifiers changed from: package-private */
        public abstract void a(b<T> bVar, int i);

        public T acquire() {
            return doAcquire();
        }

        /* access modifiers changed from: package-private */
        public abstract b<T> b(Class<T> cls, int i);

        public void close() {
            b<T> bVar = this.nS;
            if (bVar != null) {
                a(bVar, this.mSize);
                this.nS = null;
            }
        }

        /* access modifiers changed from: protected */
        public final T doAcquire() {
            b<T> bVar = this.nS;
            if (bVar != null) {
                T t = bVar.get();
                if (t == null) {
                    t = this.mManager.createInstance();
                    if (t == null) {
                        throw new IllegalStateException("manager create instance cannot return null");
                    }
                }
                this.mManager.onAcquire(t);
                return t;
            }
            throw new IllegalStateException("Cannot acquire object after close()");
        }

        /* access modifiers changed from: protected */
        public final void doRelease(T t) {
            if (this.nS == null) {
                throw new IllegalStateException("Cannot release object after close()");
            } else if (t != null) {
                this.mManager.onRelease(t);
                if (!this.nS.put(t)) {
                    this.mManager.onDestroy(t);
                }
            }
        }

        public int getSize() {
            if (this.nS == null) {
                return 0;
            }
            return this.mSize;
        }

        public void release(T t) {
            doRelease(t);
        }
    }

    private interface b<T> {
        Class<T> a();

        T get();

        int getSize();

        boolean put(T t);

        void resize(int i);
    }

    private static class c<T> implements b<T> {
        private final ConcurrentRingQueue<T> mQueue;
        private final Class<T> oS;

        c(Class<T> cls, int i) {
            this.oS = cls;
            this.mQueue = new ConcurrentRingQueue<>(i, false, true);
        }

        public Class<T> a() {
            return this.oS;
        }

        public T get() {
            return this.mQueue.get();
        }

        public int getSize() {
            return this.mQueue.getCapacity();
        }

        public boolean put(T t) {
            return this.mQueue.put(t);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x002f, code lost:
            return;
         */
        public synchronized void resize(int i) {
            int capacity = i + this.mQueue.getCapacity();
            if (capacity <= 0) {
                synchronized (Pools.pS) {
                    Pools.pS.remove(a());
                }
            } else if (capacity > 0) {
                this.mQueue.increaseCapacity(capacity);
            } else {
                this.mQueue.decreaseCapacity(-capacity);
            }
        }
    }

    private static class d<T> implements b<T> {
        private volatile SoftReference<T>[] mElements;
        private volatile int mIndex = 0;
        private volatile int mSize;
        private final Class<T> oS;

        d(Class<T> cls, int i) {
            this.oS = cls;
            this.mSize = i;
            this.mElements = new SoftReference[i];
        }

        public Class<T> a() {
            return this.oS;
        }

        public synchronized T get() {
            int i = this.mIndex;
            SoftReference<T>[] softReferenceArr = this.mElements;
            while (i != 0) {
                i--;
                if (softReferenceArr[i] != null) {
                    T t = softReferenceArr[i].get();
                    softReferenceArr[i] = null;
                    if (t != null) {
                        this.mIndex = i;
                        return t;
                    }
                }
            }
            return null;
        }

        public int getSize() {
            return this.mSize;
        }

        public synchronized boolean put(T t) {
            int i = this.mIndex;
            SoftReference<T>[] softReferenceArr = this.mElements;
            if (i >= this.mSize) {
                int i2 = 0;
                while (i2 < i) {
                    if (softReferenceArr[i2] != null) {
                        if (softReferenceArr[i2].get() != null) {
                            i2++;
                        }
                    }
                    softReferenceArr[i2] = new SoftReference<>(t);
                    return true;
                }
                return false;
            }
            softReferenceArr[i] = new SoftReference<>(t);
            this.mIndex = i + 1;
            return true;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x002e, code lost:
            return;
         */
        public synchronized void resize(int i) {
            int i2 = i + this.mSize;
            if (i2 <= 0) {
                synchronized (Pools.qS) {
                    Pools.qS.remove(a());
                }
                return;
            }
            this.mSize = i2;
            SoftReference<T>[] softReferenceArr = this.mElements;
            int i3 = this.mIndex;
            if (i2 > softReferenceArr.length) {
                SoftReference<T>[] softReferenceArr2 = new SoftReference[i2];
                System.arraycopy(softReferenceArr, 0, softReferenceArr2, 0, i3);
                this.mElements = softReferenceArr2;
            }
        }
    }

    static <T> void a(c<T> cVar, int i) {
        synchronized (pS) {
            cVar.resize(-i);
        }
    }

    static <T> void a(d<T> dVar, int i) {
        synchronized (qS) {
            dVar.resize(-i);
        }
    }

    static <T> c<T> c(Class<T> cls, int i) {
        c<T> cVar;
        synchronized (pS) {
            cVar = pS.get(cls);
            if (cVar == null) {
                cVar = new c<>(cls, i);
                pS.put(cls, cVar);
            } else {
                cVar.resize(i);
            }
        }
        return cVar;
    }

    public static <T> SimplePool<T> createSimplePool(Manager<T> manager, int i) {
        return new SimplePool<>(manager, i);
    }

    public static <T> SoftReferencePool<T> createSoftReferencePool(Manager<T> manager, int i) {
        return new SoftReferencePool<>(manager, i);
    }

    static <T> d<T> d(Class<T> cls, int i) {
        d<T> dVar;
        synchronized (qS) {
            dVar = qS.get(cls);
            if (dVar == null) {
                dVar = new d<>(cls, i);
                qS.put(cls, dVar);
            } else {
                dVar.resize(i);
            }
        }
        return dVar;
    }

    public static Pool<StringBuilder> getStringBuilderPool() {
        return rS;
    }
}
