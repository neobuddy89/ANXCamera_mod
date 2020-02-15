package miui.hardware.display;

import a.a.a.a.b;
import android.internal.hidl.base.V1_0.DebugInfo;
import android.internal.hidl.base.V1_0.IBase;
import android.os.HidlSupport;
import android.os.HwBinder;
import android.os.HwBlob;
import android.os.HwParcel;
import android.os.IHwBinder;
import android.os.IHwInterface;
import android.os.NativeHandle;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;

public interface IDisplayFeatureCallback extends IBase {
    public static final String kInterfaceName = "vendor.xiaomi.hardware.displayfeature@1.0::IDisplayFeatureCallback";

    public static abstract class Stub extends HwBinder implements IDisplayFeatureCallback {
        public IHwBinder asBinder() {
            return this;
        }

        public void debug(NativeHandle nativeHandle, ArrayList<String> arrayList) {
        }

        public final DebugInfo getDebugInfo() {
            DebugInfo debugInfo = new DebugInfo();
            debugInfo.pid = HidlSupport.getPidIfSharable();
            debugInfo.ptr = 0;
            debugInfo.arch = 0;
            return debugInfo;
        }

        public final ArrayList<byte[]> getHashChain() {
            return new ArrayList<>(Arrays.asList(new byte[][]{new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new byte[]{-67, -38, -74, 24, 77, 122, 52, 109, -90, -96, 125, -64, -126, -116, -15, -102, 105, 111, 76, -86, 54, 17, -59, 31, 46, 20, 86, 90, 20, -76, 15, -39}}));
        }

        public final ArrayList<String> interfaceChain() {
            return new ArrayList<>(Arrays.asList(new String[]{IDisplayFeatureCallback.kInterfaceName, b.kInterfaceName}));
        }

        public final String interfaceDescriptor() {
            return IDisplayFeatureCallback.kInterfaceName;
        }

        public final boolean linkToDeath(IHwBinder.DeathRecipient deathRecipient, long j) {
            return true;
        }

        public final void notifySyspropsChanged() {
            HwBinder.enableInstrumentation();
        }

        public void onTransact(int i, HwParcel hwParcel, HwParcel hwParcel2, int i2) throws RemoteException {
            boolean z = false;
            boolean z2 = true;
            switch (i) {
                case 1:
                    if (!((i2 & 1) != 0)) {
                        hwParcel2.writeStatus(Integer.MIN_VALUE);
                        hwParcel2.send();
                        return;
                    }
                    hwParcel.enforceInterface(IDisplayFeatureCallback.kInterfaceName);
                    int readInt32 = hwParcel.readInt32();
                    int readInt322 = hwParcel.readInt32();
                    float f2 = 0.0f;
                    float f3 = 0.0f;
                    float f4 = 0.0f;
                    if (readInt32 == 20000) {
                        f2 = hwParcel.readFloat();
                        f3 = hwParcel.readFloat();
                        f4 = hwParcel.readFloat();
                    }
                    displayfeatureInfoChanged(readInt32, Integer.valueOf(readInt322), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4));
                    return;
                case 256067662:
                    if ((i2 & 1) == 0) {
                        z2 = false;
                    }
                    if (z2) {
                        hwParcel2.writeStatus(Integer.MIN_VALUE);
                        hwParcel2.send();
                        return;
                    }
                    hwParcel.enforceInterface(b.kInterfaceName);
                    ArrayList<String> interfaceChain = interfaceChain();
                    hwParcel2.writeStatus(0);
                    hwParcel2.writeStringVector(interfaceChain);
                    hwParcel2.send();
                    return;
                case 256131655:
                    if ((i2 & 1) == 0) {
                        z2 = false;
                    }
                    if (z2) {
                        hwParcel2.writeStatus(Integer.MIN_VALUE);
                        hwParcel2.send();
                        return;
                    }
                    hwParcel.enforceInterface(b.kInterfaceName);
                    hwParcel2.writeStatus(0);
                    hwParcel2.send();
                    return;
                case 256136003:
                    if ((i2 & 1) == 0) {
                        z2 = false;
                    }
                    if (z2) {
                        hwParcel2.writeStatus(Integer.MIN_VALUE);
                        hwParcel2.send();
                        return;
                    }
                    hwParcel.enforceInterface(b.kInterfaceName);
                    String interfaceDescriptor = interfaceDescriptor();
                    hwParcel2.writeStatus(0);
                    hwParcel2.writeString(interfaceDescriptor);
                    hwParcel2.send();
                    return;
                case 256398152:
                    if ((i2 & 1) == 0) {
                        z2 = false;
                    }
                    if (z2) {
                        hwParcel2.writeStatus(Integer.MIN_VALUE);
                        hwParcel2.send();
                        return;
                    }
                    hwParcel.enforceInterface(b.kInterfaceName);
                    ArrayList<byte[]> hashChain = getHashChain();
                    hwParcel2.writeStatus(0);
                    HwBlob hwBlob = new HwBlob(16);
                    int size = hashChain.size();
                    hwBlob.putInt32(8, size);
                    hwBlob.putBool(12, false);
                    HwBlob hwBlob2 = new HwBlob(size * 32);
                    for (int i3 = 0; i3 < size; i3++) {
                        hwBlob2.putInt8Array((long) (i3 * 32), hashChain.get(i3));
                    }
                    hwBlob.putBlob(0, hwBlob2);
                    hwParcel2.writeBuffer(hwBlob);
                    hwParcel2.send();
                    return;
                case 256462420:
                    if ((i2 & 1) != 0) {
                        z = true;
                    }
                    if (!z) {
                        hwParcel2.writeStatus(Integer.MIN_VALUE);
                        hwParcel2.send();
                        return;
                    }
                    hwParcel.enforceInterface(b.kInterfaceName);
                    setHALInstrumentation();
                    return;
                case 256660548:
                    if ((i2 & 1) != 0) {
                        z = true;
                    }
                    if (z) {
                        hwParcel2.writeStatus(Integer.MIN_VALUE);
                        hwParcel2.send();
                        return;
                    }
                    return;
                case 256921159:
                    if ((i2 & 1) == 0) {
                        z2 = false;
                    }
                    if (z2) {
                        hwParcel2.writeStatus(Integer.MIN_VALUE);
                        hwParcel2.send();
                        return;
                    }
                    hwParcel.enforceInterface(b.kInterfaceName);
                    ping();
                    hwParcel2.writeStatus(0);
                    hwParcel2.send();
                    return;
                case 257049926:
                    if ((i2 & 1) == 0) {
                        z2 = false;
                    }
                    if (z2) {
                        hwParcel2.writeStatus(Integer.MIN_VALUE);
                        hwParcel2.send();
                        return;
                    }
                    hwParcel.enforceInterface(b.kInterfaceName);
                    DebugInfo debugInfo = getDebugInfo();
                    hwParcel2.writeStatus(0);
                    debugInfo.writeToParcel(hwParcel2);
                    hwParcel2.send();
                    return;
                case 257120595:
                    if ((i2 & 1) != 0) {
                        z = true;
                    }
                    if (!z) {
                        hwParcel2.writeStatus(Integer.MIN_VALUE);
                        hwParcel2.send();
                        return;
                    }
                    hwParcel.enforceInterface(b.kInterfaceName);
                    notifySyspropsChanged();
                    return;
                case 257250372:
                    if ((i2 & 1) != 0) {
                        z = true;
                    }
                    if (z) {
                        hwParcel2.writeStatus(Integer.MIN_VALUE);
                        hwParcel2.send();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        public final void ping() {
        }

        public IHwInterface queryLocalInterface(String str) {
            if (IDisplayFeatureCallback.kInterfaceName.equals(str)) {
                return this;
            }
            return null;
        }

        public void registerAsService(String str) throws RemoteException {
            registerService(str);
        }

        public final void setHALInstrumentation() {
        }

        public String toString() {
            return interfaceDescriptor() + "@Stub";
        }

        public final boolean unlinkToDeath(IHwBinder.DeathRecipient deathRecipient) {
            return true;
        }
    }

    void displayfeatureInfoChanged(int i, Object... objArr) throws RemoteException;
}
