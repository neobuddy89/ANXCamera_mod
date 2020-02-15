package com.android.camera.resource;

import android.support.annotation.NonNull;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.Scheduler;

public abstract class BaseObservableRequest<T> implements ResponseListener<T> {
    protected ObservableEmitter mEmitter;
    private Observable<T> mOutPutObservable;

    public /* synthetic */ void a(Class cls, ObservableEmitter observableEmitter) throws Exception {
        this.mEmitter = observableEmitter;
        scheduleRequest(this, cls);
    }

    /* access modifiers changed from: protected */
    public Scheduler getWorkThread() {
        return null;
    }

    public void onResponse(T t) {
        ObservableEmitter observableEmitter = this.mEmitter;
        if (observableEmitter != null) {
            observableEmitter.onNext(t);
            this.mEmitter.onComplete();
        }
    }

    public void onResponseError(int i, String str, Object obj) {
        this.mEmitter.onError(new BaseRequestException(i, str));
    }

    /* access modifiers changed from: protected */
    public abstract void scheduleRequest(ResponseListener<T> responseListener, Class<T> cls);

    public Observable<T> startObservable(@NonNull Class<T> cls) {
        this.mOutPutObservable = Observable.create(new a(this, cls));
        return this.mOutPutObservable;
    }
}
