package com.bumptech.glide.load.engine.b;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: GlideExecutor */
public final class b implements ExecutorService {
    private static final String TAG = "GlideExecutor";
    private static final String rh = "source";
    private static final String sh = "disk-cache";
    private static final int th = 1;
    private static final String uh = "source-unlimited";
    private static final String vh = "animation";
    private static final long wh = TimeUnit.SECONDS.toMillis(10);
    private static final int xh = 4;
    private static volatile int yh;
    private final ExecutorService delegate;

    /* compiled from: GlideExecutor */
    private static final class a implements ThreadFactory {
        private static final int qh = 9;
        final C0008b mh;
        private final String name;
        final boolean nh;
        private int oh;

        a(String str, C0008b bVar, boolean z) {
            this.name = str;
            this.mh = bVar;
            this.nh = z;
        }

        public synchronized Thread newThread(@NonNull Runnable runnable) {
            a aVar;
            aVar = new a(this, runnable, "glide-" + this.name + "-thread-" + this.oh);
            this.oh = this.oh + 1;
            return aVar;
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.b.b$b  reason: collision with other inner class name */
    /* compiled from: GlideExecutor */
    public interface C0008b {
        public static final C0008b DEFAULT = LOG;
        public static final C0008b IGNORE = new c();
        public static final C0008b LOG = new d();
        public static final C0008b cr = new e();

        void b(Throwable th);
    }

    @VisibleForTesting
    b(ExecutorService executorService) {
        this.delegate = executorService;
    }

    public static int Ai() {
        if (yh == 0) {
            yh = Math.min(4, g.availableProcessors());
        }
        return yh;
    }

    public static b Bi() {
        return a(Ai() >= 4 ? 2 : 1, C0008b.DEFAULT);
    }

    public static b Ci() {
        return a(1, sh, C0008b.DEFAULT);
    }

    public static b Di() {
        return b(Ai(), "source", C0008b.DEFAULT);
    }

    public static b Ei() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, wh, TimeUnit.MILLISECONDS, new SynchronousQueue(), new a(uh, C0008b.DEFAULT, false));
        return new b(threadPoolExecutor);
    }

    public static b a(int i, C0008b bVar) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, i, wh, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new a(vh, bVar, true));
        return new b(threadPoolExecutor);
    }

    public static b a(int i, String str, C0008b bVar) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new a(str, bVar, true));
        return new b(threadPoolExecutor);
    }

    public static b a(C0008b bVar) {
        return a(1, sh, bVar);
    }

    public static b b(int i, String str, C0008b bVar) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new a(str, bVar, false));
        return new b(threadPoolExecutor);
    }

    public static b b(C0008b bVar) {
        return b(Ai(), "source", bVar);
    }

    public boolean awaitTermination(long j, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.delegate.awaitTermination(j, timeUnit);
    }

    public void execute(@NonNull Runnable runnable) {
        this.delegate.execute(runnable);
    }

    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.delegate.invokeAll(collection);
    }

    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection, long j, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.delegate.invokeAll(collection, j, timeUnit);
    }

    @NonNull
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return this.delegate.invokeAny(collection);
    }

    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection, long j, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.delegate.invokeAny(collection, j, timeUnit);
    }

    public boolean isShutdown() {
        return this.delegate.isShutdown();
    }

    public boolean isTerminated() {
        return this.delegate.isTerminated();
    }

    public void shutdown() {
        this.delegate.shutdown();
    }

    @NonNull
    public List<Runnable> shutdownNow() {
        return this.delegate.shutdownNow();
    }

    @NonNull
    public Future<?> submit(@NonNull Runnable runnable) {
        return this.delegate.submit(runnable);
    }

    @NonNull
    public <T> Future<T> submit(@NonNull Runnable runnable, T t) {
        return this.delegate.submit(runnable, t);
    }

    public <T> Future<T> submit(@NonNull Callable<T> callable) {
        return this.delegate.submit(callable);
    }

    public String toString() {
        return this.delegate.toString();
    }
}
