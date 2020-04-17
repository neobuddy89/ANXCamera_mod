package aeonax;

import android.os.SystemProperties;
import miui.external.SdkHelper;

public class Build extends miui.os.Build {
    public static final String ANXDEVICE;
    public static final String ANXMODEL;

    static {
        if (SdkHelper.isMiuiSystem()) {
            ANXDEVICE = SystemProperties.get("ro.product.device");
            ANXMODEL = SystemProperties.get("ro.product.model");
            return;
        }
        ANXDEVICE = SystemProperties.get("ro.product.vendor.device");
        ANXMODEL = SystemProperties.get("ro.product.vendor.model");
    }
}
