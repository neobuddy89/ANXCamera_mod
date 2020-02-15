package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.util.i;
import com.bumptech.glide.util.l;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

final class ActiveResources {
    private static final int ye = 1;
    private final boolean Vb;
    @VisibleForTesting
    final Map<c, ResourceWeakReference> activeEngineResources = new HashMap();
    @Nullable
    private volatile DequeuedResourceCallback cb;
    private u.a listener;
    private final Handler qa = new Handler(Looper.getMainLooper(), new C0142a(this));
    @Nullable
    private ReferenceQueue<u<?>> ve;
    @Nullable
    private Thread we;
    private volatile boolean xe;

    @VisibleForTesting
    interface DequeuedResourceCallback {
        void N();
    }

    @VisibleForTesting
    static final class ResourceWeakReference extends WeakReference<u<?>> {
        final boolean Ff;
        final c key;
        @Nullable
        A<?> resource;

        ResourceWeakReference(@NonNull c cVar, @NonNull u<?> uVar, @NonNull ReferenceQueue<? super u<?>> referenceQueue, boolean z) {
            super(uVar, referenceQueue);
            A<?> a2;
            i.checkNotNull(cVar);
            this.key = cVar;
            if (!uVar.wi() || !z) {
                a2 = null;
            } else {
                A<?> vi = uVar.vi();
                i.checkNotNull(vi);
                a2 = vi;
            }
            this.resource = a2;
            this.Ff = uVar.wi();
        }

        /* access modifiers changed from: package-private */
        public void reset() {
            this.resource = null;
            clear();
        }
    }

    ActiveResources(boolean z) {
        this.Vb = z;
    }

    private ReferenceQueue<u<?>> Ml() {
        if (this.ve == null) {
            this.ve = new ReferenceQueue<>();
            this.we = new Thread(new C0143b(this), "glide-active-resources");
            this.we.start();
        }
        return this.ve;
    }

    /* access modifiers changed from: package-private */
    public void a(@NonNull ResourceWeakReference resourceWeakReference) {
        l.Jj();
        this.activeEngineResources.remove(resourceWeakReference.key);
        if (resourceWeakReference.Ff) {
            A<?> a2 = resourceWeakReference.resource;
            if (a2 != null) {
                u uVar = new u(a2, true, false);
                uVar.a(resourceWeakReference.key, this.listener);
                this.listener.a(resourceWeakReference.key, uVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(u.a aVar) {
        this.listener = aVar;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public u<?> b(c cVar) {
        ResourceWeakReference resourceWeakReference = this.activeEngineResources.get(cVar);
        if (resourceWeakReference == null) {
            return null;
        }
        u<?> uVar = (u) resourceWeakReference.get();
        if (uVar == null) {
            a(resourceWeakReference);
        }
        return uVar;
    }

    /* access modifiers changed from: package-private */
    public void b(c cVar, u<?> uVar) {
        ResourceWeakReference put = this.activeEngineResources.put(cVar, new ResourceWeakReference(cVar, uVar, Ml(), this.Vb));
        if (put != null) {
            put.reset();
        }
    }

    /* access modifiers changed from: package-private */
    public void ci() {
        while (!this.xe) {
            try {
                this.qa.obtainMessage(1, (ResourceWeakReference) this.ve.remove()).sendToTarget();
                DequeuedResourceCallback dequeuedResourceCallback = this.cb;
                if (dequeuedResourceCallback != null) {
                    dequeuedResourceCallback.N();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d(c cVar) {
        ResourceWeakReference remove = this.activeEngineResources.remove(cVar);
        if (remove != null) {
            remove.reset();
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void setDequeuedResourceCallback(DequeuedResourceCallback dequeuedResourceCallback) {
        this.cb = dequeuedResourceCallback;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void shutdown() {
        this.xe = true;
        Thread thread = this.we;
        if (thread != null) {
            thread.interrupt();
            try {
                this.we.join(TimeUnit.SECONDS.toMillis(5));
                if (this.we.isAlive()) {
                    throw new RuntimeException("Failed to join in time");
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
