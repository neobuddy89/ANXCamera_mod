package com.android.camera.backup;

import android.content.Intent;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.android.camera.CameraAppImpl;
import com.android.camera.Util;
import com.android.camera.log.Log;
import com.android.camera.storage.Storage;
import com.mi.config.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import miui.app.backup.BackupMeta;
import miui.app.backup.FullBackupAgent;
import miui.cloud.backup.SettingsBackupHelper;

public class CameraBackupAgent extends FullBackupAgent {
    private static final long RESOTRE_LOW_STORAGE_THRESHOLD = 10485760;
    private static final String TAG = "CameraBackupAgent";

    private void backupFile(File file) {
        if (file.exists()) {
            if (!file.isFile() || !file.canRead()) {
                for (File backupFile : file.listFiles()) {
                    backupFile(backupFile);
                }
                return;
            }
            addAttachedFile(file.getPath());
        }
    }

    private void backupFile(String str) {
        if (str != null && str.length() != 0) {
            File file = new File(str);
            if (file.exists()) {
                backupFile(file);
            }
        }
    }

    private String correctFileName(String str) {
        int lastIndexOf = str.lastIndexOf(File.separator);
        Storage.switchStoragePathIfNeeded();
        if (lastIndexOf >= 0) {
            String substring = str.substring(0, lastIndexOf);
            if (!File.separator.equals(Character.valueOf(substring.charAt(0)))) {
                substring = File.separator + substring;
            }
            String primaryStoragePath = Storage.getPrimaryStoragePath();
            String secondaryStoragePath = Storage.getSecondaryStoragePath();
            if (substring.startsWith(Storage.DIRECTORY) || (((primaryStoragePath != null && substring.startsWith(primaryStoragePath)) || (secondaryStoragePath != null && substring.startsWith(secondaryStoragePath))) && Storage.getAvailableSpace(substring) > RESOTRE_LOW_STORAGE_THRESHOLD)) {
                return str;
            }
        }
        return Storage.generateFilepath(str, "");
    }

    /* access modifiers changed from: protected */
    public int getVersion(int i) {
        if (!b.un) {
            return CameraBackupAgent.super.getVersion(i);
        }
        return 1;
    }

    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: type inference failed for: r0v3, types: [java.io.FileInputStream] */
    /* JADX WARNING: type inference failed for: r0v4, types: [java.io.FileInputStream] */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v6, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0057, code lost:
        if (r5 == null) goto L_0x0073;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x003a */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0054 A[SYNTHETIC, Splitter:B:34:0x0054] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x005f A[SYNTHETIC, Splitter:B:42:0x005f] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0064 A[SYNTHETIC, Splitter:B:46:0x0064] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x006b A[SYNTHETIC, Splitter:B:54:0x006b] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0070 A[SYNTHETIC, Splitter:B:58:0x0070] */
    public int onAttachRestore(BackupMeta backupMeta, ParcelFileDescriptor parcelFileDescriptor, String str) throws IOException {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        Log.d(TAG, "onAttachRestore");
        if (!b.un) {
            return CameraBackupAgent.super.onAttachRestore(backupMeta, parcelFileDescriptor, str);
        }
        ? r0 = 0;
        try {
            fileOutputStream = new FileOutputStream(new File(correctFileName(str)));
            try {
                fileInputStream = new FileInputStream(parcelFileDescriptor.getFileDescriptor());
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read > 0) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            fileOutputStream.close();
                            try {
                                fileInputStream.close();
                            } catch (IOException unused) {
                            }
                            return 0;
                        }
                    }
                } catch (IllegalArgumentException unused2) {
                    r0 = fileInputStream;
                    if (fileOutputStream != null) {
                    }
                    if (r0 != 0) {
                    }
                    return 0;
                } catch (IOException e2) {
                    e = e2;
                    r0 = fileOutputStream;
                    try {
                        e.printStackTrace();
                        if (r0 != 0) {
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = r0;
                        r0 = fileInputStream;
                        if (fileOutputStream != null) {
                        }
                        if (r0 != 0) {
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    r0 = fileInputStream;
                    if (fileOutputStream != null) {
                    }
                    if (r0 != 0) {
                    }
                    throw th;
                }
            } catch (IllegalArgumentException unused3) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                if (r0 != 0) {
                    r0.close();
                }
                return 0;
            } catch (IOException e3) {
                e = e3;
                fileInputStream = null;
                r0 = fileOutputStream;
                e.printStackTrace();
                if (r0 != 0) {
                    try {
                        r0.close();
                    } catch (IOException unused5) {
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused6) {
                    }
                }
                if (r0 != 0) {
                    try {
                        r0.close();
                    } catch (IOException unused7) {
                    }
                }
                throw th;
            }
        } catch (IllegalArgumentException unused8) {
            fileOutputStream = null;
            if (fileOutputStream != null) {
            }
            if (r0 != 0) {
            }
            return 0;
        } catch (IOException e4) {
            e = e4;
            fileInputStream = null;
            e.printStackTrace();
            if (r0 != 0) {
            }
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            if (fileOutputStream != null) {
            }
            if (r0 != 0) {
            }
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public int onDataRestore(BackupMeta backupMeta, ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        Log.d(TAG, "onDataRestore");
        if (!b.un) {
            return CameraBackupAgent.super.onDataRestore(backupMeta, parcelFileDescriptor);
        }
        SettingsBackupHelper.restoreSettings(getApplicationContext(), parcelFileDescriptor, new CameraSettingsBackupImpl());
        return 0;
    }

    /* access modifiers changed from: protected */
    public int onFullBackup(ParcelFileDescriptor parcelFileDescriptor, int i) throws IOException {
        Log.d(TAG, "onFullBackup");
        if (!b.un) {
            return CameraBackupAgent.super.onFullBackup(parcelFileDescriptor, i);
        }
        SettingsBackupHelper.backupSettings(getApplicationContext(), parcelFileDescriptor, new CameraSettingsBackupImpl());
        backupFile(Storage.getPrimaryStoragePath());
        backupFile(Storage.getSecondaryStoragePath());
        return 0;
    }

    /* access modifiers changed from: protected */
    public int onRestoreEnd(BackupMeta backupMeta) throws IOException {
        Log.d(TAG, "onRestoreEnd: update watermark for vendor");
        Util.generateWatermark2File();
        if (!b.un) {
            return CameraBackupAgent.super.onRestoreEnd(backupMeta);
        }
        String primaryStoragePath = Storage.getPrimaryStoragePath();
        String secondaryStoragePath = Storage.getSecondaryStoragePath();
        Intent intent = new Intent("miui.intent.action.MEDIA_SCANNER_SCAN_FOLDER");
        intent.addFlags(16777216);
        if (primaryStoragePath != null) {
            intent.setData(Uri.fromFile(new File(primaryStoragePath)));
            CameraAppImpl.getAndroidContext().sendBroadcast(intent);
        }
        if (secondaryStoragePath == null) {
            return 0;
        }
        intent.setData(Uri.fromFile(new File(secondaryStoragePath)));
        CameraAppImpl.getAndroidContext().sendBroadcast(intent);
        return 0;
    }
}
