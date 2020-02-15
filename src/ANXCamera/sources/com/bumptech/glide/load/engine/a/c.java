package com.bumptech.glide.load.engine.a;

import com.bumptech.glide.util.i;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: DiskCacheWriteLocker */
final class c {
    private final Map<String, a> Ig = new HashMap();
    private final b Jg = new b();

    /* compiled from: DiskCacheWriteLocker */
    private static class a {
        int Gg;
        final Lock lock = new ReentrantLock();

        a() {
        }
    }

    /* compiled from: DiskCacheWriteLocker */
    private static class b {
        private static final int Hg = 10;
        private final Queue<a> pool = new ArrayDeque();

        b() {
        }

        /* access modifiers changed from: package-private */
        public void a(a aVar) {
            synchronized (this.pool) {
                if (this.pool.size() < 10) {
                    this.pool.offer(aVar);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public a obtain() {
            a poll;
            synchronized (this.pool) {
                poll = this.pool.poll();
            }
            return poll == null ? new a() : poll;
        }
    }

    c() {
    }

    /* access modifiers changed from: package-private */
    public void t(String str) {
        a aVar;
        synchronized (this) {
            aVar = this.Ig.get(str);
            if (aVar == null) {
                aVar = this.Jg.obtain();
                this.Ig.put(str, aVar);
            }
            aVar.Gg++;
        }
        aVar.lock.lock();
    }

    /* access modifiers changed from: package-private */
    public void u(String str) {
        a aVar;
        synchronized (this) {
            a aVar2 = this.Ig.get(str);
            i.checkNotNull(aVar2);
            aVar = aVar2;
            if (aVar.Gg >= 1) {
                aVar.Gg--;
                if (aVar.Gg == 0) {
                    a remove = this.Ig.remove(str);
                    if (remove.equals(aVar)) {
                        this.Jg.a(remove);
                    } else {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + remove + ", safeKey: " + str);
                    }
                }
            } else {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.Gg);
            }
        }
        aVar.lock.unlock();
    }
}
