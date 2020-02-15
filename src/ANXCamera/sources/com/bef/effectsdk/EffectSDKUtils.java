package com.bef.effectsdk;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.ttve.monitor.MonitorUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EffectSDKUtils {
    private static List<String> assetFiles = ModelsList.list;
    private static Set<File> localFiles = new HashSet();
    private static Set<File> needRemoveFiles = new HashSet();

    /* access modifiers changed from: private */
    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    private static void copyAssets(Context context, String str, String[] strArr, boolean z) throws Throwable {
        boolean z2;
        if (!needRemoveFiles.isEmpty()) {
            needRemoveFiles.clear();
        }
        needRemoveFiles.addAll(localFiles);
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        for (String next : assetFiles) {
            final String fileName = getFileName(next);
            File takeFirstMatchingOrNull = takeFirstMatchingOrNull(needRemoveFiles, new FileFilter() {
                public boolean accept(File file) {
                    return file.getName().contains(fileName);
                }
            });
            boolean z3 = false;
            if (takeFirstMatchingOrNull == null || !new File(str, getAssetRelativePath(next)).exists()) {
                z2 = true;
            } else {
                needRemoveFiles.remove(takeFirstMatchingOrNull);
                z2 = false;
            }
            if (z2) {
                if (strArr != null && !TextUtils.isEmpty(fileName)) {
                    int length = strArr.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        } else if (fileName.equals(strArr[i])) {
                            z3 = true;
                            break;
                        } else {
                            i++;
                        }
                    }
                }
                if (z3 && z) {
                    copyFile(context, next, str);
                }
                if (!z3 && !z) {
                    copyFile(context, next, str);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.io.InputStream} */
    /* JADX WARNING: Multi-variable type inference failed */
    private static void copyFile(Context context, String str, String str2) throws Throwable {
        InputStream inputStream = null;
        try {
            InputStream open = context.getAssets().open(str);
            try {
                File file = new File(str2 + str.substring(str.indexOf(MonitorUtils.KEY_MODEL) + 6, str.lastIndexOf("/")));
                if (!file.exists()) {
                    if (!file.mkdirs()) {
                        throw new IOException("Can not mkdirs " + file.getPath());
                    }
                }
                open = new FileOutputStream(new File(r6 + "/" + getFileName(str)));
            } catch (Throwable th) {
                th = th;
                try {
                    closeQuietly(inputStream);
                    throw th;
                } finally {
                    closeQuietly(inputStream);
                }
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = open.read(bArr);
                    if (read > 0) {
                        open.write(bArr, 0, read);
                    } else {
                        try {
                            closeQuietly(open);
                            return;
                        } finally {
                            closeQuietly(open);
                        }
                    }
                }
            } catch (Throwable th2) {
                inputStream = open;
                th = th2;
                closeQuietly(inputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            InputStream inputStream2 = inputStream;
            closeQuietly(inputStream);
            throw th;
        }
    }

    private static void deleteNoUseModel() {
        for (File next : localFiles) {
            if (needRemoveFiles.contains(next) && next.exists()) {
                next.delete();
            }
        }
    }

    public static void flushAlgorithmModelFiles(Context context, String str) throws Throwable {
        if (!localFiles.isEmpty()) {
            localFiles.clear();
        }
        scanRecursive(str, localFiles);
        copyAssets(context, str, (String[]) null, false);
        deleteNoUseModel();
        localFiles.clear();
    }

    public static void flushAlgorithmModelFiles(Context context, String str, String[] strArr, boolean z) throws Throwable {
        if (!localFiles.isEmpty()) {
            localFiles.clear();
        }
        scanRecursive(str, localFiles);
        copyAssets(context, str, strArr, z);
        deleteNoUseModel();
        localFiles.clear();
    }

    private static String getAssetRelativePath(String str) {
        int indexOf = str.indexOf("model/");
        return indexOf >= 0 ? str.substring(indexOf + 6, str.length()) : str;
    }

    private static String getFileName(String str) {
        int lastIndexOf = str.lastIndexOf("/");
        return lastIndexOf != -1 ? str.substring(lastIndexOf + 1, str.length()) : "";
    }

    public static String getSdkVersion() {
        return nativeGetSdkVersion();
    }

    private static native String nativeGetSdkVersion();

    public static boolean needUpdate(final Context context, String str) {
        if (!localFiles.isEmpty()) {
            localFiles.clear();
        }
        scanRecursive(str, localFiles);
        try {
            if (assetFiles.size() > localFiles.size()) {
                return true;
            }
            for (final String next : assetFiles) {
                if (takeFirstMatchingOrNull(localFiles, new FileFilter() {
                    public boolean accept(File file) {
                        boolean z = false;
                        if (next.contains(file.getName())) {
                            InputStream inputStream = null;
                            try {
                                inputStream = context.getAssets().open(next);
                                if (file.length() == ((long) inputStream.available())) {
                                    z = true;
                                }
                                return z;
                            } catch (IOException unused) {
                            } finally {
                                EffectSDKUtils.closeQuietly(inputStream);
                            }
                        }
                        return false;
                    }
                }) == null) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    private static void scanRecursive(String str, Set<File> set) {
        File file = new File(str);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        scanRecursive(file2.getAbsolutePath(), set);
                    } else {
                        set.add(file2);
                    }
                }
            }
        }
    }

    private static File takeFirstMatchingOrNull(Set<File> set, FileFilter fileFilter) {
        for (File next : set) {
            if (fileFilter.accept(next)) {
                return next;
            }
        }
        return null;
    }
}
