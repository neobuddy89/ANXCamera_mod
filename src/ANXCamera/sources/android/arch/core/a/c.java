package android.arch.core.a;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import java.util.concurrent.Executor;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* compiled from: ArchTaskExecutor */
public class c extends e {
    @NonNull
    private static final Executor ja = new b();
    private static volatile c sInstance;
    @NonNull
    private static final Executor sMainThreadExecutor = new a();
    @NonNull
    private e ha = this.ia;
    @NonNull
    private e ia = new d();

    private c() {
    }

    @NonNull
    public static c getInstance() {
        if (sInstance != null) {
            return sInstance;
        }
        synchronized (c.class) {
            if (sInstance == null) {
                sInstance = new c();
            }
        }
        return sInstance;
    }

    @NonNull
    public static Executor getMainThreadExecutor() {
        return sMainThreadExecutor;
    }

    @NonNull
    public static Executor ha() {
        return ja;
    }

    public void a(@Nullable e eVar) {
        if (eVar == null) {
            eVar = this.ia;
        }
        this.ha = eVar;
    }

    public void b(Runnable runnable) {
        this.ha.b(runnable);
    }

    public void d(Runnable runnable) {
        this.ha.d(runnable);
    }

    public boolean isMainThread() {
        return this.ha.isMainThread();
    }
}
