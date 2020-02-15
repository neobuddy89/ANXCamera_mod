package org.xplatform_util;

import android.content.Context;
import android.os.Environment;
import java.io.File;

public class SystemInfo {
    static String getStoragePath(Context context) {
        if (Environment.getExternalStorageState().equals("mounted")) {
            return Environment.getExternalStorageDirectory().getAbsolutePath();
        }
        if (context == null) {
            return "";
        }
        File filesDir = context.getFilesDir();
        return filesDir == null ? "" : filesDir.toString();
    }
}
