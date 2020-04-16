package android.support.v4.os;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.os.C0170IResultReceiver;

/* renamed from: android.support.v4.os.ResultReceiver  reason: case insensitive filesystem */
public class C0171ResultReceiver implements Parcelable {
    public static final Parcelable.Creator<C0171ResultReceiver> CREATOR = new Parcelable.Creator<C0171ResultReceiver>() {
        public C0171ResultReceiver createFromParcel(Parcel parcel) {
            return new C0171ResultReceiver(parcel);
        }

        public C0171ResultReceiver[] newArray(int i) {
            return new C0171ResultReceiver[i];
        }
    };
    final Handler mHandler;
    final boolean mLocal;
    C0170IResultReceiver mReceiver;

    /* renamed from: android.support.v4.os.ResultReceiver$MyResultReceiver */
    class MyResultReceiver extends C0170IResultReceiver.Stub {
        MyResultReceiver() {
        }

        public void send(int i, Bundle bundle) {
            if (C0171ResultReceiver.this.mHandler != null) {
                C0171ResultReceiver.this.mHandler.post(new MyRunnable(i, bundle));
            } else {
                C0171ResultReceiver.this.onReceiveResult(i, bundle);
            }
        }
    }

    /* renamed from: android.support.v4.os.ResultReceiver$MyRunnable */
    class MyRunnable implements Runnable {
        final int mResultCode;
        final Bundle mResultData;

        MyRunnable(int i, Bundle bundle) {
            this.mResultCode = i;
            this.mResultData = bundle;
        }

        public void run() {
            C0171ResultReceiver.this.onReceiveResult(this.mResultCode, this.mResultData);
        }
    }

    public C0171ResultReceiver(Handler handler) {
        this.mLocal = true;
        this.mHandler = handler;
    }

    C0171ResultReceiver(Parcel parcel) {
        this.mLocal = false;
        this.mHandler = null;
        this.mReceiver = C0170IResultReceiver.Stub.asInterface(parcel.readStrongBinder());
    }

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onReceiveResult(int i, Bundle bundle) {
    }

    public void send(int i, Bundle bundle) {
        if (this.mLocal) {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new MyRunnable(i, bundle));
            } else {
                onReceiveResult(i, bundle);
            }
        } else {
            C0170IResultReceiver iResultReceiver = this.mReceiver;
            if (iResultReceiver != null) {
                try {
                    iResultReceiver.send(i, bundle);
                } catch (RemoteException e2) {
                }
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            if (this.mReceiver == null) {
                this.mReceiver = new MyResultReceiver();
            }
            parcel.writeStrongBinder(this.mReceiver.asBinder());
        }
    }
}
