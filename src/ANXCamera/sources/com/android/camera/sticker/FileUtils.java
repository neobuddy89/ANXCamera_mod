package com.android.camera.sticker;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileUtils {
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v4, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v6, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x007b A[SYNTHETIC, Splitter:B:52:0x007b] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0085 A[SYNTHETIC, Splitter:B:57:0x0085] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0094 A[SYNTHETIC, Splitter:B:66:0x0094] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x009e A[SYNTHETIC, Splitter:B:71:0x009e] */
    public static boolean copyFileIfNeed(Context context, File file, String str) {
        Throwable th;
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        if (file == null || TextUtils.isEmpty(str)) {
            return true;
        }
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        if (file.exists()) {
            return true;
        }
        ? r0 = 0;
        try {
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            inputStream = context.getAssets().open(str);
            if (inputStream == null) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                return false;
            }
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (IOException unused) {
                fileOutputStream = null;
                r0 = inputStream;
                try {
                    file.delete();
                    if (r0 != 0) {
                        try {
                            r0.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = r0;
                    r0 = fileOutputStream;
                    if (inputStream != null) {
                    }
                    if (r0 != 0) {
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                if (r0 != 0) {
                    try {
                        r0.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                throw th;
            }
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                inputStream.close();
                fileOutputStream.close();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
                try {
                    fileOutputStream.close();
                    return true;
                } catch (IOException e8) {
                    e8.printStackTrace();
                    return true;
                }
            } catch (IOException unused2) {
                r0 = inputStream;
                file.delete();
                if (r0 != 0) {
                }
                if (fileOutputStream != null) {
                }
                return false;
            } catch (Throwable th4) {
                th = th4;
                r0 = fileOutputStream;
                if (inputStream != null) {
                }
                if (r0 != 0) {
                }
                throw th;
            }
        } catch (IOException unused3) {
            fileOutputStream = null;
            file.delete();
            if (r0 != 0) {
            }
            if (fileOutputStream != null) {
            }
            return false;
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
            if (inputStream != null) {
            }
            if (r0 != 0) {
            }
            throw th;
        }
    }
}
