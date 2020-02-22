package android.os;

import android.annotation.SystemApi;
import android.annotation.UnsupportedAppUsage;
import android.app.ActivityThread;
import android.app.Application;
import android.os.IDeviceIdentifiersPolicyService;
import android.text.TextUtils;
import android.util.Slog;
import com.mi.config.d;
import dalvik.system.VMRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Build {
    public static final String BOARD = getString("ro.product.board");
    public static final String BOOTLOADER = getString("ro.bootloader");
    public static final String BRAND = getString("ro.product.brand");
    @Deprecated
    public static final String CPU_ABI;
    @Deprecated
    public static final String CPU_ABI2;
    public static final String DEVICE = getString("ro.product.device");
    public static final String DISPLAY = getString("ro.build.display.id");
    public static final String FINGERPRINT = deriveFingerprint();
    public static final String HARDWARE = getString("ro.hardware");
    public static final String HOST = getString("ro.build.host");
    public static final String ID = getString("ro.build.id");
    public static final boolean IS_CONTAINER = SystemProperties.getBoolean("ro.boot.container", false);
    @UnsupportedAppUsage
    public static final boolean IS_DEBUGGABLE;
    public static final boolean IS_EMULATOR = getString("ro.kernel.qemu").equals("1");
    public static final boolean IS_ENG = "eng".equals(TYPE);
    public static final boolean IS_TREBLE_ENABLED = SystemProperties.getBoolean("ro.treble.enabled", false);
    public static final boolean IS_USER = "user".equals(TYPE);
    public static final boolean IS_USERDEBUG = "userdebug".equals(TYPE);
    public static final String MANUFACTURER = getString("ro.product.manufacturer");
    public static final String MODEL = getString("ro.product.model");
    @SystemApi
    public static final boolean PERMISSIONS_REVIEW_REQUIRED = true;
    public static final String PRODUCT = getString("ro.product.name");
    @Deprecated
    public static final String RADIO = getString("gsm.version.baseband");
    @Deprecated
    public static final String SERIAL = getString("no.such.thing");
    public static final String[] SUPPORTED_32_BIT_ABIS = getStringList("ro.product.cpu.abilist32", ",");
    public static final String[] SUPPORTED_64_BIT_ABIS = getStringList("ro.product.cpu.abilist64", ",");
    public static final String[] SUPPORTED_ABIS = getStringList("ro.product.cpu.abilist", ",");
    private static final String TAG = "Build";
    public static final String TAGS = getString("ro.build.tags");
    public static final long TIME = (getLong("ro.build.date.utc") * 1000);
    public static final String TYPE = getString("ro.build.type");
    public static final String UNKNOWN = "unknown";
    public static final String USER = getString("ro.build.user");

    static {
        String[] strArr = VMRuntime.getRuntime().is64Bit() ? SUPPORTED_64_BIT_ABIS : SUPPORTED_32_BIT_ABIS;
        CPU_ABI = strArr[0];
        boolean z = true;
        if (strArr.length > 1) {
            CPU_ABI2 = strArr[1];
        } else {
            CPU_ABI2 = "";
        }
        if (SystemProperties.getInt("ro.debuggable", 0) != 1) {
            z = false;
        }
        IS_DEBUGGABLE = z;
    }

    private static String deriveFingerprint() {
        String str = SystemProperties.get("ro.build.fingerprint");
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        return getString("ro.product.brand") + '/' + getString("ro.product.name") + '/' + getString("ro.product.device") + ':' + getString("ro.build.version.release") + '/' + getString("ro.build.id") + '/' + getString("ro.build.version.incremental") + ':' + getString("ro.build.type") + '/' + getString("ro.build.tags");
    }

    public static void ensureFingerprintProperty() {
        if (TextUtils.isEmpty(SystemProperties.get("ro.build.fingerprint"))) {
            try {
                SystemProperties.set("ro.build.fingerprint", FINGERPRINT);
            } catch (IllegalArgumentException e2) {
                Slog.e(TAG, "Failed to set fingerprint property", e2);
            }
        }
    }

    public static List<Partition> getFingerprintedPartitions() {
        ArrayList arrayList = new ArrayList();
        for (String str : new String[]{"bootimage", "odm", "product", "product_services", "system", d.VENDOR}) {
            String str2 = SystemProperties.get("ro." + str + ".build.fingerprint");
            if (!TextUtils.isEmpty(str2)) {
                Partition partition = new Partition(str, str2, getLong("ro." + str + ".build.date.utc") * 1000, (1) null);
                arrayList.add(partition);
            }
        }
        return arrayList;
    }

    @UnsupportedAppUsage
    private static long getLong(String str) {
        try {
            return Long.parseLong(SystemProperties.get(str));
        } catch (NumberFormatException e2) {
            return -1;
        }
    }

    public static String getRadioVersion() {
        String str = SystemProperties.get("gsm.version.baseband");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str;
    }

    public static String getSerial() {
        IDeviceIdentifiersPolicyService asInterface = IDeviceIdentifiersPolicyService.Stub.asInterface(ServiceManager.getService("device_identifiers"));
        try {
            Application currentApplication = ActivityThread.currentApplication();
            return asInterface.getSerialForPackage(currentApplication != null ? currentApplication.getPackageName() : null);
        } catch (RemoteException e2) {
            e2.rethrowFromSystemServer();
            return "unknown";
        }
    }

    /* access modifiers changed from: private */
    @UnsupportedAppUsage
    public static String getString(String str) {
        return SystemProperties.get(str, "unknown");
    }

    /* access modifiers changed from: private */
    public static String[] getStringList(String str, String str2) {
        String str3 = SystemProperties.get(str);
        return str3.isEmpty() ? new String[0] : str3.split(str2);
    }

    public static boolean is64BitAbi(String str) {
        return VMRuntime.is64BitAbi(str);
    }

    public static boolean isBuildConsistent() {
        if (IS_ENG) {
            return true;
        }
        if (IS_TREBLE_ENABLED) {
            int verifyWithoutAvb = VintfObject.verifyWithoutAvb();
            if (verifyWithoutAvb != 0) {
                Slog.e(TAG, "Vendor interface is incompatible, error=" + String.valueOf(verifyWithoutAvb));
            }
            return verifyWithoutAvb == 0;
        }
        String str = SystemProperties.get("ro.build.fingerprint");
        String str2 = SystemProperties.get("ro.vendor.build.fingerprint");
        String str3 = SystemProperties.get("ro.bootimage.build.fingerprint");
        String str4 = SystemProperties.get("ro.build.expect.bootloader");
        String str5 = SystemProperties.get("ro.bootloader");
        String str6 = SystemProperties.get("ro.build.expect.baseband");
        String str7 = SystemProperties.get("gsm.version.baseband");
        if (TextUtils.isEmpty(str)) {
            Slog.e(TAG, "Required ro.build.fingerprint is empty!");
            return false;
        } else if (TextUtils.isEmpty(str2) || Objects.equals(str, str2)) {
            return true;
        } else {
            Slog.e(TAG, "Mismatched fingerprints; system reported " + str + " but vendor reported " + str2);
            return false;
        }
    }
}
