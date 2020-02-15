package com.android.camera.data.observeable;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.support.annotation.NonNull;
import com.android.camera.log.Log;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.EndConsumerHelper;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import java.util.concurrent.atomic.AtomicReference;

public class RxData<T> {
    private static final String TAG = "RxLiveData";
    private T data;
    private final Object dataLock;
    private Subject<DataWrap<T>> triggers;

    private static final class DataCheck<T> {
        /* access modifiers changed from: private */
        public LifecycleOwner owner;
        private final Predicate<T> predicateCheck = new Predicate<T>() {
            public boolean test(T t) {
                return !RxData.isLifecycleState(DataCheck.this.owner, Lifecycle.State.DESTROYED);
            }
        };

        DataCheck(LifecycleOwner lifecycleOwner) {
            this.owner = lifecycleOwner;
        }

        /* access modifiers changed from: package-private */
        public Predicate<T> getPredicateCheck() {
            return this.predicateCheck;
        }
    }

    public static class DataObservable<T> extends Observable<T> implements LifecycleObserver {
        private final DataCheck dataCheck;
        private DataObserver<T> dataObserver;
        private final Observable<T> observable;

        DataObservable(Observable<T> observable2, DataCheck dataCheck2) {
            this.observable = observable2;
            this.dataCheck = dataCheck2;
            if (dataCheck2.owner == null) {
                return;
            }
            if (!RxData.isLifecycleState(dataCheck2.owner, Lifecycle.State.DESTROYED)) {
                Log.d(RxData.TAG, "DataObservable add:" + dataCheck2.owner.getClass().getSimpleName());
                dataCheck2.owner.getLifecycle().addObserver(this);
                return;
            }
            Log.d(RxData.TAG, "DataObservable skip:" + dataCheck2.owner.getClass().getSimpleName());
        }

        static <T> Function<Observable<T>, DataObservable<T>> toFunction(final DataCheck dataCheck2) {
            return new Function<Observable<T>, DataObservable<T>>() {
                public DataObservable<T> apply(Observable<T> observable) {
                    return new DataObservable<>(observable, DataCheck.this);
                }
            };
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public void onLifecycleDestroy() {
            DataObserver<T> dataObserver2 = this.dataObserver;
            if (dataObserver2 != null && !dataObserver2.isDisposed()) {
                this.dataObserver.dispose();
            }
            if (this.dataCheck.owner != null) {
                Log.d(RxData.TAG, "removeObserver: " + this.dataCheck.owner.getClass().getSimpleName());
                this.dataCheck.owner.getLifecycle().removeObserver(this);
            }
        }

        /* access modifiers changed from: protected */
        public void subscribeActual(Observer<? super T> observer) {
            this.dataObserver = new DataObserver<>(observer);
            this.observable.subscribe(this.dataObserver);
            if (RxData.isLifecycleState(this.dataCheck.owner, Lifecycle.State.DESTROYED)) {
                DataObserver<T> dataObserver2 = this.dataObserver;
                if (dataObserver2 != null && !dataObserver2.isDisposed()) {
                    this.dataObserver.dispose();
                }
            }
        }
    }

    public static class DataObserver<T> implements Observer<T>, Disposable {
        final Observer<? super T> observer;
        final AtomicReference<Disposable> s = new AtomicReference<>();

        DataObserver(Observer<? super T> observer2) {
            this.observer = observer2;
        }

        public final void dispose() {
            DisposableHelper.dispose(this.s);
        }

        public final boolean isDisposed() {
            return this.s.get() == DisposableHelper.DISPOSED;
        }

        public void onComplete() {
            this.observer.onComplete();
        }

        public void onError(Throwable th) {
            this.observer.onError(th);
        }

        public void onNext(T t) {
            this.observer.onNext(t);
        }

        public final void onSubscribe(@NonNull Disposable disposable) {
            EndConsumerHelper.setOnce(this.s, disposable, (Class<?>) DataObserver.class);
            this.observer.onSubscribe(disposable);
        }
    }

    public static final class DataWrap<T> {
        final T data;

        public DataWrap(T t) {
            this.data = t;
        }

        public T get() {
            return this.data;
        }

        public boolean isNull() {
            return this.data == null;
        }
    }

    public RxData() {
        this.dataLock = new Object();
        this.triggers = PublishSubject.create();
    }

    public RxData(T t) {
        this();
        this.data = t;
    }

    /* access modifiers changed from: private */
    public static boolean isLifecycleState(LifecycleOwner lifecycleOwner, @NonNull Lifecycle.State state) {
        return lifecycleOwner != null && lifecycleOwner.getLifecycle().getCurrentState() == state;
    }

    private void notifyChangedInternal(T t) {
        this.triggers.onNext(new DataWrap(t));
    }

    public T get() {
        return this.data;
    }

    public void notifyChanged() {
        synchronized (this.dataLock) {
            notifyChangedInternal(this.data);
        }
    }

    public DataObservable<DataWrap<T>> observable(LifecycleOwner lifecycleOwner) {
        DataCheck dataCheck = new DataCheck(lifecycleOwner);
        return (DataObservable) this.triggers.startWith(new DataWrap(this.data)).filter(dataCheck.getPredicateCheck()).to(DataObservable.toFunction(dataCheck));
    }

    public DataObservable<DataWrap<T>> observableNullLife() {
        return observable((LifecycleOwner) null);
    }

    public void set(T t) {
        synchronized (this.dataLock) {
            this.data = t;
            notifyChangedInternal(this.data);
        }
    }

    public void setSilently(T t) {
        synchronized (this.dataLock) {
            this.data = t;
        }
    }
}
