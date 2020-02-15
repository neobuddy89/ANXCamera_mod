package com.bumptech.glide.load.engine.b;

import android.os.Build;
import android.os.StrictMode;
import java.io.File;
import java.util.regex.Pattern;

/* compiled from: RuntimeCompat */
final class g {
    private static final String Ah = "cpu[0-9]+";
    private static final String Bh = "/sys/devices/system/cpu/";
    private static final String TAG = "GlideRuntimeCompat";

    private g() {
    }

    static int availableProcessors() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        return Build.VERSION.SDK_INT < 17 ? Math.max(dm(), availableProcessors) : availableProcessors;
    }

    /* JADX INFO: finally extract failed */
    private static int dm() {
        File[] fileArr;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            fileArr = new File(Bh).listFiles(new f(Pattern.compile(Ah)));
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th;
        }
        return Math.max(1, fileArr != null ? fileArr.length : 0);
    }
}
