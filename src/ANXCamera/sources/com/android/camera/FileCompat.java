package com.android.camera;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.support.v4.provider.DocumentFile;
import android.text.TextUtils;
import com.android.camera.lib.compatibility.util.CompatibilityUtils;
import com.android.camera.log.Log;
import com.android.camera.storage.Storage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class FileCompat {
    static final FileCompatCommonImpl IMPL_COMMON;
    static final FileCompatOperateImpl IMPL_OPERATE;
    public static final int REQUEST_CODE_OPEN_EXTERNAL_DOCUMENT_PERMISSION = 161;
    public static final String TAG = "FileCompat";

    static class BaseFileCompatImpl implements FileCompatOperateImpl {
        HashMap<String, DocumentFile> mDocumentFileHashMap = new HashMap<>(1);

        BaseFileCompatImpl() {
        }

        /* JADX WARNING: type inference failed for: r2v0 */
        /* JADX WARNING: type inference failed for: r2v1, types: [java.io.OutputStream] */
        /* JADX WARNING: type inference failed for: r2v2, types: [java.io.FileInputStream] */
        /* JADX WARNING: type inference failed for: r2v3 */
        /* JADX WARNING: type inference failed for: r2v4 */
        /* JADX WARNING: type inference failed for: r2v5 */
        /* JADX WARNING: type inference failed for: r2v6 */
        /* JADX WARNING: type inference failed for: r2v8 */
        /* JADX WARNING: type inference failed for: r2v9 */
        /* JADX WARNING: type inference failed for: r2v10 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x004d A[SYNTHETIC, Splitter:B:39:0x004d] */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x0052 A[SYNTHETIC, Splitter:B:43:0x0052] */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x0060 A[SYNTHETIC, Splitter:B:51:0x0060] */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x0065 A[SYNTHETIC, Splitter:B:55:0x0065] */
        public boolean copyFile(String str, String str2) {
            FileInputStream fileInputStream;
            OutputStream outputStream;
            ? r2 = 0;
            try {
                fileInputStream = new FileInputStream(str);
                try {
                    OutputStream fileOutputStream = getFileOutputStream(str2, false);
                    if (fileOutputStream == null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception unused) {
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e2) {
                                Log.w(FileCompat.TAG, "copyFile error", (Throwable) e2);
                            }
                        }
                        return false;
                    }
                    r2 = fileOutputStream;
                    r2 = fileOutputStream;
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read != -1) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            try {
                                break;
                            } catch (Exception unused2) {
                            }
                        }
                    }
                    fileInputStream.close();
                    if (fileOutputStream == null) {
                        return true;
                    }
                    try {
                        fileOutputStream.close();
                        return true;
                    } catch (Exception e3) {
                        Log.w(FileCompat.TAG, "copyFile error", (Throwable) e3);
                        return true;
                    }
                } catch (Exception e4) {
                    e = e4;
                    outputStream = r2;
                    r2 = fileInputStream;
                    try {
                        Log.w(FileCompat.TAG, "copyFile error", (Throwable) e);
                        if (r2 != 0) {
                        }
                        if (outputStream != null) {
                        }
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = r2;
                        r2 = outputStream;
                        if (fileInputStream != null) {
                        }
                        if (r2 != 0) {
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    r2 = r2;
                    if (fileInputStream != null) {
                    }
                    if (r2 != 0) {
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                outputStream = null;
                Log.w(FileCompat.TAG, "copyFile error", (Throwable) e);
                if (r2 != 0) {
                    try {
                        r2.close();
                    } catch (Exception unused3) {
                    }
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Exception e6) {
                        Log.w(FileCompat.TAG, "copyFile error", (Throwable) e6);
                    }
                }
                return false;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception unused4) {
                    }
                }
                if (r2 != 0) {
                    try {
                        r2.close();
                    } catch (Exception e7) {
                        Log.w(FileCompat.TAG, "copyFile error", (Throwable) e7);
                    }
                }
                throw th;
            }
        }

        public boolean createNewFile(String str) {
            try {
                return new File(str).createNewFile();
            } catch (IOException e2) {
                Log.w(FileCompat.TAG, "createNewFile error", (Throwable) e2);
                return false;
            }
        }

        public String createNewFileFixPath(String str) {
            if (createNewFile(str)) {
                return str;
            }
            return null;
        }

        public FileWrapper createNewFileWrapper(String str) {
            return null;
        }

        public boolean deleteFile(String str) {
            return new File(str).delete();
        }

        public boolean exists(String str) {
            return new File(str).exists();
        }

        public OutputStream getFileOutputStream(String str, boolean z) {
            if (!z && !exists(str)) {
                return null;
            }
            try {
                return new FileOutputStream(new File(str));
            } catch (Exception unused) {
                Log.w(FileCompat.TAG, "getFileOutputStream error, path = " + str);
                return null;
            }
        }

        public ParcelFileDescriptor getParcelFileDescriptor(String str, boolean z) throws IOException {
            return CameraAppImpl.getAndroidContext().getContentResolver().openFileDescriptor(Uri.fromFile(new File(str)), "rw");
        }

        public boolean mkdirs(String str) {
            return new File(str).mkdirs();
        }

        public void removeDocumentFileForPath(String str) {
            this.mDocumentFileHashMap.remove(str);
        }

        public boolean renameFile(String str, String str2) throws IOException {
            return new File(str).renameTo(new File(str2));
        }
    }

    interface FileCompatCommonImpl {
        String getSDPath(String str);

        boolean getStorageAccessForLOLLIPOP(Activity activity, String str);

        Uri getTreeUri(String str);

        boolean handleActivityResult(Activity activity, int i, int i2, Intent intent);

        boolean hasStoragePermission(String str);

        boolean isExternalSDFile(String str);

        void updateSDPath();
    }

    interface FileCompatOperateImpl {
        boolean copyFile(String str, String str2);

        boolean createNewFile(String str);

        String createNewFileFixPath(String str);

        FileWrapper createNewFileWrapper(String str);

        boolean deleteFile(String str);

        boolean exists(String str);

        OutputStream getFileOutputStream(String str, boolean z);

        ParcelFileDescriptor getParcelFileDescriptor(String str, boolean z) throws IOException;

        boolean mkdirs(String str);

        void removeDocumentFileForPath(String str);

        boolean renameFile(String str, String str2) throws IOException;
    }

    static class FileWrapper {
        DocumentFile documentFile;
        File legacyFile;

        FileWrapper() {
        }

        public long getLength() {
            return this.legacyFile.length();
        }
    }

    static class KitKatFileCompatCommonImpl implements FileCompatCommonImpl {
        protected String accessSDPath;
        protected String[] sdPaths;

        public KitKatFileCompatCommonImpl() {
            update();
        }

        /* access modifiers changed from: protected */
        @TargetApi(19)
        public String[] getExtSDCardPaths() {
            String[] strArr = new String[0];
            ArrayList arrayList = new ArrayList();
            String sdcardPath = CompatibilityUtils.getSdcardPath(CameraAppImpl.getAndroidContext());
            Log.d(FileCompat.TAG, "getExtSDCardPaths: activePath = " + sdcardPath);
            if (!TextUtils.isEmpty(sdcardPath)) {
                arrayList.add(sdcardPath);
            }
            return !arrayList.isEmpty() ? (String[]) arrayList.toArray(new String[arrayList.size()]) : strArr;
        }

        public String getSDPath(String str) {
            String[] strArr = this.sdPaths;
            if (strArr == null) {
                return null;
            }
            for (String str2 : strArr) {
                if (str.startsWith(str2)) {
                    return str2;
                }
            }
            return null;
        }

        public boolean getStorageAccessForLOLLIPOP(Activity activity, String str) {
            return false;
        }

        public Uri getTreeUri(String str) {
            return null;
        }

        public boolean handleActivityResult(Activity activity, int i, int i2, Intent intent) {
            return false;
        }

        public boolean hasStoragePermission(String str) {
            return true;
        }

        public boolean isExternalSDFile(String str) {
            String[] strArr = this.sdPaths;
            if (strArr == null) {
                return false;
            }
            for (String startsWith : strArr) {
                if (str.startsWith(startsWith)) {
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: protected */
        public void update() {
            this.sdPaths = getExtSDCardPaths();
        }

        public void updateSDPath() {
            update();
        }
    }

    static class LollipopFileCompatCommonImpl extends KitKatFileCompatCommonImpl {
        private static final String SD_PATH_TREE_URI = "sd_path_tree_uri";

        public LollipopFileCompatCommonImpl() {
            update();
        }

        @TargetApi(21)
        public boolean getStorageAccessForLOLLIPOP(Activity activity, String str) {
            String[] extSDCardPaths = getExtSDCardPaths();
            if (extSDCardPaths == null || extSDCardPaths.length == 0) {
                return false;
            }
            int length = extSDCardPaths.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                String str2 = extSDCardPaths[i];
                if (str.startsWith(str2)) {
                    this.accessSDPath = str2;
                    break;
                }
                i++;
            }
            List<StorageVolume> storageVolumes = ((StorageManager) activity.getSystemService("storage")).getStorageVolumes();
            if (storageVolumes.size() > 1) {
                Intent createAccessIntent = storageVolumes.get(1).createAccessIntent(Environment.DIRECTORY_DCIM);
                if (createAccessIntent == null) {
                    Log.w(FileCompat.TAG, "getStorageAccessForLOLLIPOP error, intent is null");
                    return false;
                }
                try {
                    activity.startActivityForResult(createAccessIntent, 161);
                } catch (Exception e2) {
                    Log.w(FileCompat.TAG, "getStorageAccessForLOLLIPOP error", (Throwable) e2);
                }
            }
            return true;
        }

        public Uri getTreeUri(String str) {
            String string = CameraAppImpl.getAndroidContext().getSharedPreferences(SD_PATH_TREE_URI, 0).getString(str, (String) null);
            if (string == null) {
                return null;
            }
            return Uri.parse(string);
        }

        @TargetApi(19)
        public boolean handleActivityResult(Activity activity, int i, int i2, Intent intent) {
            if (i == 161 && i2 == -1) {
                Uri data = intent.getData();
                if (data == null) {
                    Log.d(FileCompat.TAG, "handleActivityResult: uri is null, documents permission is Failed!");
                    return false;
                } else if (!DocumentFile.fromTreeUri(activity, data).exists()) {
                    Log.d(FileCompat.TAG, "handleActivityResult: documentFile is not exist, documents permission is Failed!");
                    return false;
                } else {
                    try {
                        activity.getContentResolver().takePersistableUriPermission(data, intent.getFlags() & 3);
                        activity.getSharedPreferences(SD_PATH_TREE_URI, 0).edit().putString(this.accessSDPath, data.toString()).apply();
                        return true;
                    } catch (Exception e2) {
                        Log.w(FileCompat.TAG, "cacheUri failed, uri = " + data, (Throwable) e2);
                        update();
                    }
                }
            }
            return false;
        }

        public boolean hasStoragePermission(String str) {
            if (!isExternalSDFile(str)) {
                return true;
            }
            String sDPath = super.getSDPath(str);
            if (sDPath == null || getTreeUri(sDPath) == null) {
                return false;
            }
            DocumentFile fromTreeUri = DocumentFile.fromTreeUri(CameraAppImpl.getAndroidContext(), getTreeUri(sDPath));
            Log.d(FileCompat.TAG, "hasStoragePermission document = " + fromTreeUri);
            if (fromTreeUri == null) {
                return false;
            }
            Log.d(FileCompat.TAG, "hasStoragePermission document = " + fromTreeUri.exists() + ", " + fromTreeUri.canRead() + ", " + fromTreeUri.canWrite());
            return fromTreeUri.exists() && fromTreeUri.canRead() && fromTreeUri.canWrite();
        }
    }

    static class LollipopFileCompatImpl extends BaseFileCompatImpl {
        LollipopFileCompatImpl() {
        }

        public boolean copyFile(String str, String str2) {
            return super.copyFile(str, str2);
        }

        public boolean createNewFile(String str) {
            if (super.createNewFile(str)) {
                return true;
            }
            if (!FileCompat.isSDFile(str)) {
                return false;
            }
            return getDocumentFileByPath(str, true, (String) null, false) != null;
        }

        public String createNewFileFixPath(String str) {
            if (super.createNewFile(str)) {
                return str;
            }
            if (!FileCompat.isSDFile(str)) {
                return null;
            }
            DocumentFile documentFileByPath = getDocumentFileByPath(str, true, (String) null, false);
            if (documentFileByPath == null) {
                return null;
            }
            String substring = str.substring(0, str.lastIndexOf(File.separator));
            return substring + File.separator + documentFileByPath.getName();
        }

        public boolean deleteFile(String str) {
            boolean z = true;
            if (super.deleteFile(str)) {
                return true;
            }
            if (!FileCompat.isSDFile(str)) {
                return false;
            }
            DocumentFile documentFileByPath = getDocumentFileByPath(str, false, (String) null, false);
            if (documentFileByPath != null) {
                z = documentFileByPath.delete();
            }
            removeDocumentFileForPath(str);
            return z;
        }

        public boolean exists(String str) {
            if (super.exists(str)) {
                return true;
            }
            if (!FileCompat.isSDFile(str)) {
                return false;
            }
            return getDocumentFileByPath(str, false, (String) null, false) != null;
        }

        public DocumentFile getDocumentFileByPath(String str, boolean z, String str2, boolean z2) {
            String str3;
            DocumentFile createDirectory;
            String str4 = str;
            boolean z3 = z;
            Log.d(FileCompat.TAG, "getDocumentFileByPath start>>");
            String access$000 = FileCompat.getSDPath(str);
            String str5 = null;
            if (access$000 == null) {
                Log.w(FileCompat.TAG, "getDocumentFileByPath: no sd path for " + str4);
                return null;
            }
            DocumentFile documentFile = this.mDocumentFileHashMap.get(str4);
            if (documentFile != null && documentFile.exists()) {
                return documentFile;
            }
            Uri access$100 = FileCompat.getTreeUri(access$000);
            if (access$100 == null) {
                Log.w(FileCompat.TAG, "getDocumentFileByPath: no tree uri for " + access$000);
                return null;
            }
            DocumentFile fromTreeUri = DocumentFile.fromTreeUri(CameraAppImpl.getAndroidContext(), access$100);
            String str6 = access$000 + File.separator + Environment.DIRECTORY_DCIM;
            if (str4.equals(str6)) {
                return fromTreeUri;
            }
            String substring = str4.substring(str6.length() + 1);
            if (TextUtils.isEmpty(substring)) {
                Log.w(FileCompat.TAG, "getDocumentFileByPath: empty relative path");
                return null;
            }
            String[] split = substring.split("\\" + File.separator);
            String[] strArr = new String[(split.length - 1)];
            System.arraycopy(split, 0, strArr, 0, split.length - 1);
            DocumentFile documentFile2 = fromTreeUri;
            boolean z4 = false;
            for (String str7 : strArr) {
                if (documentFile2 == null) {
                    break;
                }
                if (z4) {
                    createDirectory = documentFile2.createDirectory(str7);
                } else {
                    DocumentFile findFile = documentFile2.findFile(str7);
                    if (findFile != null) {
                        documentFile2 = findFile;
                    } else if (z3) {
                        createDirectory = documentFile2.createDirectory(str7);
                        z4 = true;
                    } else {
                        Log.d(FileCompat.TAG, "getDocumentFileByPath: no document for " + str7);
                        return null;
                    }
                }
                documentFile2 = createDirectory;
            }
            if (documentFile2 == null) {
                Log.d(FileCompat.TAG, "getDocumentFileByPath: no document for " + substring);
                return null;
            }
            String str8 = split[split.length - 1];
            Log.d(FileCompat.TAG, "getDocumentFileByPath: createIfNotFound = " + z3);
            long currentTimeMillis = System.currentTimeMillis();
            if (!z3) {
                documentFile = documentFile2.findFile(str8);
            } else if (z2) {
                try {
                    documentFile = documentFile2.findFile(str8);
                    if (documentFile == null) {
                        documentFile = documentFile2.createDirectory(str8);
                    }
                } catch (Exception e2) {
                    Log.w(FileCompat.TAG, "createFile error", (Throwable) e2);
                }
            } else {
                int indexOf = str8.indexOf(".");
                if (!TextUtils.isEmpty(str2) || indexOf <= 0) {
                    str3 = str2;
                } else {
                    str3 = FileCompat.getMimeTypeFromPath(str8);
                    if (!TextUtils.isEmpty(str3)) {
                        str5 = str8.substring(0, indexOf);
                    }
                }
                if (str5 != null) {
                    str8 = str5;
                }
                try {
                    documentFile = documentFile2.createFile(str3, str8);
                } catch (Exception e3) {
                    Log.w(FileCompat.TAG, "createFile error", (Throwable) e3);
                }
            }
            if (documentFile != null) {
                this.mDocumentFileHashMap.put(str4, documentFile);
            }
            Log.d(FileCompat.TAG, "getDocumentFileByPath end<< cost time = " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            return documentFile;
        }

        public OutputStream getFileOutputStream(String str, boolean z) {
            if (Build.VERSION.SDK_INT < 28 || !FileCompat.isSDFile(str)) {
                OutputStream fileOutputStream = super.getFileOutputStream(str, z);
                if (fileOutputStream != null) {
                    return fileOutputStream;
                }
            }
            if (!FileCompat.isSDFile(str)) {
                return null;
            }
            DocumentFile documentFileByPath = getDocumentFileByPath(str, z, (String) null, false);
            if (documentFileByPath == null) {
                return null;
            }
            try {
                return CameraAppImpl.getAndroidContext().getContentResolver().openOutputStream(documentFileByPath.getUri());
            } catch (FileNotFoundException e2) {
                Log.w(FileCompat.TAG, "getFileOutputStream error", (Throwable) e2);
                return null;
            }
        }

        public ParcelFileDescriptor getParcelFileDescriptor(String str, boolean z) throws IOException {
            if (!FileCompat.isSDFile(str)) {
                return super.getParcelFileDescriptor(str, z);
            }
            return CameraAppImpl.getAndroidContext().getContentResolver().openFileDescriptor(getDocumentFileByPath(str, z, FileCompat.getMimeTypeFromPath(str), false).getUri(), "rw");
        }

        public boolean mkdirs(String str) {
            if (super.mkdirs(str)) {
                return true;
            }
            if (!FileCompat.isSDFile(str)) {
                return false;
            }
            return getDocumentFileByPath(str, true, (String) null, true) != null;
        }

        public boolean renameFile(String str, String str2) throws IOException {
            if (super.renameFile(str, str2)) {
                return true;
            }
            if (!new File(str).getParent().equalsIgnoreCase(new File(str2).getParent())) {
                Log.w(FileCompat.TAG, "only support rename to the same folder");
                return false;
            }
            String name = new File(str2).getName();
            DocumentFile documentFileByPath = getDocumentFileByPath(str, false, (String) null, false);
            if (documentFileByPath == null) {
                Log.w(FileCompat.TAG, "renameFile: null document");
                return false;
            }
            try {
                return documentFileByPath.renameTo(name);
            } catch (Exception e2) {
                throw new IOException("renameFile error, path = " + str, e2);
            }
        }
    }

    static class MarshmallowFileCompatImpl extends LollipopFileCompatImpl {
        MarshmallowFileCompatImpl() {
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 28) {
            IMPL_COMMON = new LollipopFileCompatCommonImpl();
            IMPL_OPERATE = new MarshmallowFileCompatImpl();
            return;
        }
        IMPL_COMMON = new KitKatFileCompatCommonImpl();
        IMPL_OPERATE = new BaseFileCompatImpl();
    }

    public static boolean copyFile(String str, String str2) {
        return IMPL_OPERATE.copyFile(str, str2);
    }

    public static boolean createNewFile(String str) {
        return IMPL_OPERATE.createNewFile(str);
    }

    public static String createNewFileFixPath(String str) {
        return IMPL_OPERATE.createNewFileFixPath(str);
    }

    public static boolean deleteFile(String str) {
        return IMPL_OPERATE.deleteFile(str);
    }

    public static boolean exists(String str) {
        return IMPL_OPERATE.exists(str);
    }

    public static OutputStream getFileOutputStream(String str, boolean z) {
        return IMPL_OPERATE.getFileOutputStream(str, z);
    }

    /* access modifiers changed from: private */
    public static String getMimeTypeFromPath(String str) {
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf < 0) {
            return null;
        }
        String lowerCase = str.substring(lastIndexOf + 1).toLowerCase(Locale.ENGLISH);
        if ("jpg".equals(lowerCase) || "jpeg".equals(lowerCase)) {
            return Storage.MIME_JPEG;
        }
        if ("png".equals(lowerCase)) {
            return "image/png";
        }
        if ("mp4".equals(lowerCase)) {
            return "video/mp4";
        }
        return null;
    }

    public static ParcelFileDescriptor getParcelFileDescriptor(String str, boolean z) throws IOException {
        return IMPL_OPERATE.getParcelFileDescriptor(str, z);
    }

    /* access modifiers changed from: private */
    public static String getSDPath(String str) {
        return IMPL_COMMON.getSDPath(str);
    }

    @TargetApi(21)
    public static boolean getStorageAccessForLOLLIPOP(Activity activity, String str) {
        return IMPL_COMMON.getStorageAccessForLOLLIPOP(activity, str);
    }

    /* access modifiers changed from: private */
    public static Uri getTreeUri(String str) {
        return IMPL_COMMON.getTreeUri(str);
    }

    @TargetApi(21)
    public static boolean handleActivityResult(Activity activity, int i, int i2, Intent intent) {
        return IMPL_COMMON.handleActivityResult(activity, i, i2, intent);
    }

    @TargetApi(21)
    public static boolean hasStoragePermission(String str) {
        return IMPL_COMMON.hasStoragePermission(str);
    }

    @TargetApi(19)
    public static boolean isSDFile(String str) {
        return IMPL_COMMON.isExternalSDFile(str);
    }

    public static boolean mkdirs(String str) {
        return IMPL_OPERATE.mkdirs(str);
    }

    public static void removeDocumentFileForPath(String str) {
        IMPL_OPERATE.removeDocumentFileForPath(str);
    }

    public static boolean renameFile(String str, String str2) throws IOException {
        return IMPL_OPERATE.renameFile(str, str2);
    }

    @TargetApi(21)
    public static void updateSDPath() {
        IMPL_COMMON.updateSDPath();
    }
}
