package miui.hardware.display;

import android.os.HwParcel;
import android.os.IBinder;
import android.os.IHwBinder;
import android.os.IHwInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Slog;
import miui.os.DeviceFeature;

class DisplayFeatureServiceProxy {
    private static final int HIDL_TRANSACTION_interfaceDescriptor = 256136003;
    private static final int HIDL_TRANSACTION_registerCallback = 2;
    private static final int HIDL_TRANSACTION_setFeature = 1;
    private static final String HWBINDER_BASE_INTERFACE_DESCRIPTOR = "android.hidl.base@1.0::IBase";
    private static final String HWBINDER_INTERFACE_DESCRIPTOR = "vendor.xiaomi.hardware.displayfeature@1.0::IDisplayFeature";
    private static final String INTERFACE_DESCRIPTOR = "miui.hardware.display.IDisplayFeatureService";
    private static String TAG = "DisplayFeatureServiceProxy";
    private static final int TRANSACTION_setFeature = 100;
    private String mDescriptor;
    private IHwBinder mHwService;
    private IBinder mService;

    DisplayFeatureServiceProxy(Object obj) {
        if (obj instanceof IBinder) {
            this.mService = (IBinder) obj;
            try {
                this.mDescriptor = this.mService.getInterfaceDescriptor();
            } catch (RemoteException e2) {
            }
            if (TextUtils.isEmpty(this.mDescriptor)) {
                this.mDescriptor = INTERFACE_DESCRIPTOR;
            }
        } else if (obj instanceof IHwBinder) {
            this.mHwService = (IHwBinder) obj;
            try {
                this.mDescriptor = interfaceDescriptor();
            } catch (RemoteException e3) {
            }
            if (TextUtils.isEmpty(this.mDescriptor)) {
                this.mDescriptor = HWBINDER_INTERFACE_DESCRIPTOR;
            }
        }
    }

    private int callBinderTransact(int i, int i2, Object... objArr) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        int i3 = -1;
        try {
            obtain.writeInterfaceToken(this.mDescriptor);
            for (Integer num : objArr) {
                if (num instanceof Integer) {
                    obtain.writeInt(num.intValue());
                }
            }
            if (this.mService.transact(i, obtain, obtain2, i2)) {
                obtain2.readException();
                i3 = obtain2.readInt();
            }
        } catch (RemoteException e2) {
            Slog.e(TAG, "callBinderTransact transact fail. " + e2);
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
            throw th;
        }
        obtain2.recycle();
        obtain.recycle();
        return i3;
    }

    private void callHwBinderTransact(int i, int i2, Object... objArr) {
        HwParcel hwParcel = new HwParcel();
        try {
            HwParcel hwParcel2 = new HwParcel();
            hwParcel2.writeInterfaceToken(this.mDescriptor);
            for (Integer num : objArr) {
                if (num instanceof Integer) {
                    hwParcel2.writeInt32(num.intValue());
                } else if (num instanceof IHwInterface) {
                    hwParcel2.writeStrongBinder(num.asBinder());
                }
            }
            this.mHwService.transact(i, hwParcel2, hwParcel, i2);
            hwParcel.verifySuccess();
            hwParcel2.releaseTemporaryStorage();
        } catch (RemoteException e2) {
            Slog.e(TAG, "callHwBinderTransact transact fail. " + e2);
        } catch (Throwable th) {
            hwParcel.release();
            throw th;
        }
        hwParcel.release();
    }

    public String interfaceDescriptor() throws RemoteException {
        HwParcel hwParcel = new HwParcel();
        hwParcel.writeInterfaceToken("android.hidl.base@1.0::IBase");
        HwParcel hwParcel2 = new HwParcel();
        try {
            this.mHwService.transact(HIDL_TRANSACTION_interfaceDescriptor, hwParcel, hwParcel2, 0);
            hwParcel2.verifySuccess();
            hwParcel.releaseTemporaryStorage();
            return hwParcel2.readString();
        } finally {
            hwParcel2.release();
        }
    }

    /* access modifiers changed from: package-private */
    public void registerCallback(int i, Object obj) {
        if (DeviceFeature.SUPPORT_DISPLAYFEATURE_HIDL) {
            callHwBinderTransact(2, 0, Integer.valueOf(i), obj);
        }
    }

    /* access modifiers changed from: package-private */
    public void setFeature(int i, int i2, int i3, int i4) {
        if (DeviceFeature.SUPPORT_DISPLAYFEATURE_HIDL) {
            callHwBinderTransact(1, 0, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            return;
        }
        callBinderTransact(100, 0, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
    }
}
