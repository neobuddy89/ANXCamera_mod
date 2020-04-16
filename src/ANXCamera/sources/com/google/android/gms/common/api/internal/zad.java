package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class zad<T> extends zac {
    protected final TaskCompletionSource<T> zacn;

    public zad(int i, TaskCompletionSource<T> taskCompletionSource) {
        super(i);
        this.zacn = taskCompletionSource;
    }

    public void zaa(Status status) {
        this.zacn.trySetException(new ApiException(status));
    }

    public final void zaa(GoogleApiManager.zaa<?> zaa) throws DeadObjectException {
        try {
            zad(zaa);
        } catch (DeadObjectException e2) {
            zaa(zab.zaa((RemoteException) e2));
            throw e2;
        } catch (RemoteException e3) {
            zaa(zab.zaa(e3));
        } catch (RuntimeException e4) {
            zaa(e4);
        }
    }

    public void zaa(zaab zaab, boolean z) {
    }

    public void zaa(RuntimeException runtimeException) {
        this.zacn.trySetException(runtimeException);
    }

    /* access modifiers changed from: protected */
    public abstract void zad(GoogleApiManager.zaa<?> zaa) throws RemoteException;
}
