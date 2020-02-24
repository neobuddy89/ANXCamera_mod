package aeonax;

import android.os.SystemProperties;
import miui.external.SdkHelper;

public class Build extends miui.os.Build {
    public static final String ANXDEVICE;

    static {
        if (SdkHelper.isMiuiSystem()) {
            ANXDEVICE = SystemProperties.get("ro.product.device");
        } else {
            ANXDEVICE = SystemProperties.get("ro.product.vendor.device");
        }
    }
}
