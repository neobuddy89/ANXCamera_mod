package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

public abstract class RegisterListenerMethod<A extends Api.AnyClient, L> {
    private final ListenerHolder<L> zaju;
    private final Feature[] zajv;
    private final boolean zajw;

    protected RegisterListenerMethod(ListenerHolder<L> listenerHolder) {
        this.zaju = listenerHolder;
        this.zajv = null;
        this.zajw = false;
    }

    protected RegisterListenerMethod(ListenerHolder<L> listenerHolder, Feature[] featureArr, boolean z) {
        this.zaju = listenerHolder;
        this.zajv = featureArr;
        this.zajw = z;
    }

    public void clearListener() {
        this.zaju.clear();
    }

    public ListenerHolder.ListenerKey<L> getListenerKey() {
        return this.zaju.getListenerKey();
    }

    public Feature[] getRequiredFeatures() {
        return this.zajv;
    }

    /* access modifiers changed from: protected */
    public abstract void registerListener(A a2, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException;

    public final boolean shouldAutoResolveMissingFeatures() {
        return this.zajw;
    }
}