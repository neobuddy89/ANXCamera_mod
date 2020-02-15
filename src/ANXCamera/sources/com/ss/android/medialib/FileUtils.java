package com.ss.android.medialib;

import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class FileUtils {
    private static final String DEFAULT_FOLDER_NAME = "BDMedia";
    protected static String msFolderPath;

    public static boolean checkFileExists(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    public static File createFile(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            if (!z) {
                file.mkdirs();
            } else {
                try {
                    File parentFile = file.getParentFile();
                    if (!parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    file.createNewFile();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return file;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v20, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v22, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v23, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v26, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v27, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v28, resolved type: java.nio.channels.FileChannel} */
    /* JADX WARNING: type inference failed for: r0v5, types: [java.io.FileInputStream] */
    /* JADX WARNING: type inference failed for: r0v8, types: [java.io.FileInputStream] */
    /* JADX WARNING: type inference failed for: r0v14 */
    /* JADX WARNING: type inference failed for: r0v16 */
    /* JADX WARNING: type inference failed for: r0v21 */
    /* JADX WARNING: type inference failed for: r0v24 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x00df A[SYNTHETIC, Splitter:B:106:0x00df] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x00e9 A[SYNTHETIC, Splitter:B:111:0x00e9] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x00f3 A[SYNTHETIC, Splitter:B:116:0x00f3] */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x00fd A[SYNTHETIC, Splitter:B:121:0x00fd] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0082 A[SYNTHETIC, Splitter:B:57:0x0082] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x008c A[SYNTHETIC, Splitter:B:62:0x008c] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0096 A[SYNTHETIC, Splitter:B:67:0x0096] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00a0 A[SYNTHETIC, Splitter:B:72:0x00a0] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x00b2 A[SYNTHETIC, Splitter:B:83:0x00b2] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x00bc A[SYNTHETIC, Splitter:B:88:0x00bc] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x00c6 A[SYNTHETIC, Splitter:B:93:0x00c6] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x00d0 A[SYNTHETIC, Splitter:B:98:0x00d0] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:54:0x007d=Splitter:B:54:0x007d, B:80:0x00ad=Splitter:B:80:0x00ad} */
    /* JADX WARNING: Unknown variable types count: 2 */
    public static boolean fileChannelCopy(String str, String str2) {
        FileChannel fileChannel;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        FileChannel fileChannel2;
        Object obj;
        ? r0;
        FileChannel fileChannel3;
        FileChannel fileChannel4;
        ? r02;
        if (!isSdcardWritable()) {
            return false;
        }
        FileChannel fileChannel5 = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                fileOutputStream = new FileOutputStream(str2);
                try {
                    fileChannel = fileInputStream.getChannel();
                    try {
                        FileChannel channel = fileOutputStream.getChannel();
                        fileChannel.transferTo(0, fileChannel.size(), channel);
                        fileChannel5 = channel;
                        fileChannel5 = channel;
                        fileChannel5 = channel;
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        if (fileChannel != null) {
                            try {
                                fileChannel.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                        if (channel == null) {
                            return true;
                        }
                        try {
                            channel.close();
                            return true;
                        } catch (IOException e5) {
                            e5.printStackTrace();
                            return true;
                        }
                    } catch (FileNotFoundException e6) {
                        e = e6;
                        Object obj2 = fileInputStream;
                        fileChannel3 = fileChannel5;
                        r0 = obj2;
                        obj = r0;
                        e.printStackTrace();
                        obj = r0;
                        if (r0 != 0) {
                        }
                        if (fileChannel != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        if (fileChannel2 != null) {
                        }
                        return false;
                    } catch (IOException e7) {
                        e = e7;
                        Object obj3 = fileInputStream;
                        fileChannel2 = fileChannel5;
                        r02 = obj3;
                        try {
                            obj = r02;
                            e.printStackTrace();
                            obj = r02;
                            if (r02 != 0) {
                            }
                            if (fileChannel != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            if (fileChannel2 != null) {
                            }
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            FileChannel fileChannel6 = fileChannel2;
                            fileInputStream = obj;
                            fileChannel5 = fileChannel6;
                            if (fileInputStream != null) {
                            }
                            if (fileChannel != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            if (fileChannel5 != null) {
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileChannel5 = fileChannel5;
                        if (fileInputStream != null) {
                        }
                        if (fileChannel != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        if (fileChannel5 != null) {
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e8) {
                    e = e8;
                    fileChannel4 = null;
                    fileChannel5 = fileInputStream;
                    fileChannel3 = fileChannel;
                    r0 = fileChannel5;
                    obj = r0;
                    e.printStackTrace();
                    obj = r0;
                    if (r0 != 0) {
                    }
                    if (fileChannel != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    if (fileChannel2 != null) {
                    }
                    return false;
                } catch (IOException e9) {
                    e = e9;
                    fileChannel = null;
                    fileChannel5 = fileInputStream;
                    fileChannel2 = fileChannel;
                    r02 = fileChannel5;
                    obj = r02;
                    e.printStackTrace();
                    obj = r02;
                    if (r02 != 0) {
                    }
                    if (fileChannel != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    if (fileChannel2 != null) {
                    }
                    return false;
                } catch (Throwable th3) {
                    th = th3;
                    fileChannel = null;
                    if (fileInputStream != null) {
                    }
                    if (fileChannel != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    if (fileChannel5 != null) {
                    }
                    throw th;
                }
            } catch (FileNotFoundException e10) {
                e = e10;
                fileOutputStream = null;
                fileChannel4 = null;
                fileChannel5 = fileInputStream;
                fileChannel3 = fileChannel;
                r0 = fileChannel5;
                obj = r0;
                e.printStackTrace();
                obj = r0;
                if (r0 != 0) {
                    try {
                        r0.close();
                    } catch (IOException e11) {
                        e11.printStackTrace();
                    }
                }
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException e12) {
                        e12.printStackTrace();
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e13) {
                        e13.printStackTrace();
                    }
                }
                if (fileChannel2 != null) {
                    try {
                        fileChannel2.close();
                    } catch (IOException e14) {
                        e14.printStackTrace();
                    }
                }
                return false;
            } catch (IOException e15) {
                e = e15;
                fileOutputStream = null;
                fileChannel = null;
                fileChannel5 = fileInputStream;
                fileChannel2 = fileChannel;
                r02 = fileChannel5;
                obj = r02;
                e.printStackTrace();
                obj = r02;
                if (r02 != 0) {
                    try {
                        r02.close();
                    } catch (IOException e16) {
                        e16.printStackTrace();
                    }
                }
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException e17) {
                        e17.printStackTrace();
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e18) {
                        e18.printStackTrace();
                    }
                }
                if (fileChannel2 != null) {
                    try {
                        fileChannel2.close();
                    } catch (IOException e19) {
                        e19.printStackTrace();
                    }
                }
                return false;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                fileChannel = null;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e20) {
                        e20.printStackTrace();
                    }
                }
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException e21) {
                        e21.printStackTrace();
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e22) {
                        e22.printStackTrace();
                    }
                }
                if (fileChannel5 != null) {
                    try {
                        fileChannel5.close();
                    } catch (IOException e23) {
                        e23.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e24) {
            e = e24;
            fileOutputStream = null;
            fileChannel4 = null;
            fileChannel3 = fileChannel;
            r0 = fileChannel5;
            obj = r0;
            e.printStackTrace();
            obj = r0;
            if (r0 != 0) {
            }
            if (fileChannel != null) {
            }
            if (fileOutputStream != null) {
            }
            if (fileChannel2 != null) {
            }
            return false;
        } catch (IOException e25) {
            e = e25;
            fileOutputStream = null;
            fileChannel = null;
            fileChannel2 = fileChannel;
            r02 = fileChannel5;
            obj = r02;
            e.printStackTrace();
            obj = r02;
            if (r02 != 0) {
            }
            if (fileChannel != null) {
            }
            if (fileOutputStream != null) {
            }
            if (fileChannel2 != null) {
            }
            return false;
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream = null;
            fileChannel = null;
            fileInputStream = null;
            if (fileInputStream != null) {
            }
            if (fileChannel != null) {
            }
            if (fileOutputStream != null) {
            }
            if (fileChannel5 != null) {
            }
            throw th;
        }
    }

    public static String getPath() {
        if (msFolderPath == null) {
            msFolderPath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + DEFAULT_FOLDER_NAME;
            File file = new File(msFolderPath);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return msFolderPath;
    }

    public static boolean isSdcardWritable() {
        try {
            return "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception unused) {
            return false;
        }
    }
}
