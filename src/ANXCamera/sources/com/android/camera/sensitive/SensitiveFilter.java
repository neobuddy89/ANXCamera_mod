package com.android.camera.sensitive;

import android.text.TextUtils;
import android.util.Base64;
import com.android.camera.log.Log;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.NavigableSet;
import java.util.zip.ZipException;
import miui.hardware.display.DisplayFeatureManager;
import miui.util.IOUtils;

public class SensitiveFilter implements Serializable {
    public static final String CLOUD_FILE_PATH = "/data/data/com.android.camera/sensi_words";
    static final int DEFAULT_INITIAL_CAPACITY = 8388608;
    public static final String LOCAL_FILE_PATH = "/data/data/com.android.camera/";
    private static SensitiveFilter sensitiveFilter = null;
    private static final long serialVersionUID = 1;
    protected SensitiveNode[] nodes = new SensitiveNode[8388608];

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.io.ByteArrayInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.io.ByteArrayInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v15, resolved type: java.io.ByteArrayInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v16, resolved type: java.io.ByteArrayInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v17, resolved type: java.io.ByteArrayInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v18, resolved type: java.io.ByteArrayInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v19, resolved type: java.io.ByteArrayInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v20, resolved type: java.io.ByteArrayInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v21, resolved type: java.io.ByteArrayInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v22, resolved type: java.io.ByteArrayInputStream} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x009c A[SYNTHETIC, Splitter:B:44:0x009c] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00a4 A[Catch:{ IOException -> 0x00a0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00a9 A[Catch:{ IOException -> 0x00a0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00ae A[Catch:{ IOException -> 0x00a0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b9 A[SYNTHETIC, Splitter:B:57:0x00b9] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00c1 A[Catch:{ IOException -> 0x00bd }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00c6 A[Catch:{ IOException -> 0x00bd }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00cb A[Catch:{ IOException -> 0x00bd }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    private SensitiveFilter() {
        InputStreamReader inputStreamReader;
        ByteArrayInputStream byteArrayInputStream;
        InputStream inputStream;
        ByteArrayInputStream byteArrayInputStream2;
        InputStreamReader inputStreamReader2;
        InputStreamReader inputStreamReader3;
        ByteArrayInputStream byteArrayInputStream3;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            File file = new File(CLOUD_FILE_PATH);
            inputStream = file.exists() ? new FileInputStream(file) : getClass().getResourceAsStream("/assets/sensi/sensi_words.txt");
            try {
                byteArrayInputStream3 = new ByteArrayInputStream(new String(Base64.decode(IOUtils.toString(inputStream), 0)).getBytes());
            } catch (IOException e2) {
                e = e2;
                inputStreamReader2 = null;
                inputStreamReader = inputStreamReader2;
                byteArrayInputStream2 = inputStreamReader2;
                try {
                    Log.e("SensitiveFilter", "IOException in SensitiveFilter constructor", (Throwable) e);
                    if (bufferedReader2 != null) {
                    }
                    if (inputStreamReader != null) {
                    }
                    if (byteArrayInputStream2 != 0) {
                    }
                    if (inputStream != null) {
                    }
                } catch (Throwable th) {
                    th = th;
                    byteArrayInputStream = byteArrayInputStream2;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e3) {
                            Log.e("SensitiveFilter", "IOException in SensitiveFilter constructor finally", (Throwable) e3);
                            throw th;
                        }
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    if (byteArrayInputStream != null) {
                        byteArrayInputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                inputStreamReader3 = null;
                inputStreamReader = inputStreamReader3;
                byteArrayInputStream = inputStreamReader3;
                if (bufferedReader2 != null) {
                }
                if (inputStreamReader != null) {
                }
                if (byteArrayInputStream != null) {
                }
                if (inputStream != null) {
                }
                throw th;
            }
            try {
                inputStreamReader = new InputStreamReader(byteArrayInputStream3, StandardCharsets.UTF_8);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    try {
                        String readLine = bufferedReader.readLine();
                        while (readLine != null) {
                            readLine = bufferedReader.readLine();
                            put(readLine);
                        }
                        bufferedReader.close();
                        inputStreamReader.close();
                        byteArrayInputStream3.close();
                        inputStream.close();
                    } catch (IOException e4) {
                        e = e4;
                        bufferedReader2 = bufferedReader;
                        byteArrayInputStream2 = byteArrayInputStream3;
                        Log.e("SensitiveFilter", "IOException in SensitiveFilter constructor", (Throwable) e);
                        if (bufferedReader2 != null) {
                        }
                        if (inputStreamReader != null) {
                        }
                        if (byteArrayInputStream2 != 0) {
                        }
                        if (inputStream != null) {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader2 = bufferedReader;
                        byteArrayInputStream = byteArrayInputStream3;
                        if (bufferedReader2 != null) {
                        }
                        if (inputStreamReader != null) {
                        }
                        if (byteArrayInputStream != null) {
                        }
                        if (inputStream != null) {
                        }
                        throw th;
                    }
                } catch (IOException e5) {
                    e = e5;
                    byteArrayInputStream2 = byteArrayInputStream3;
                    Log.e("SensitiveFilter", "IOException in SensitiveFilter constructor", (Throwable) e);
                    if (bufferedReader2 != null) {
                    }
                    if (inputStreamReader != null) {
                    }
                    if (byteArrayInputStream2 != 0) {
                    }
                    if (inputStream != null) {
                    }
                }
                try {
                    bufferedReader.close();
                    inputStreamReader.close();
                    byteArrayInputStream3.close();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (IOException e6) {
                    Log.e("SensitiveFilter", "IOException in SensitiveFilter constructor finally", (Throwable) e6);
                }
            } catch (IOException e7) {
                e = e7;
                inputStreamReader = null;
                byteArrayInputStream2 = byteArrayInputStream3;
                Log.e("SensitiveFilter", "IOException in SensitiveFilter constructor", (Throwable) e);
                if (bufferedReader2 != null) {
                }
                if (inputStreamReader != null) {
                }
                if (byteArrayInputStream2 != 0) {
                }
                if (inputStream != null) {
                }
            } catch (Throwable th4) {
                th = th4;
                inputStreamReader = null;
                byteArrayInputStream = byteArrayInputStream3;
                if (bufferedReader2 != null) {
                }
                if (inputStreamReader != null) {
                }
                if (byteArrayInputStream != null) {
                }
                if (inputStream != null) {
                }
                throw th;
            }
        } catch (IOException e8) {
            e = e8;
            inputStream = null;
            inputStreamReader2 = null;
            inputStreamReader = inputStreamReader2;
            byteArrayInputStream2 = inputStreamReader2;
            Log.e("SensitiveFilter", "IOException in SensitiveFilter constructor", (Throwable) e);
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            if (byteArrayInputStream2 != 0) {
                byteArrayInputStream2.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
            inputStreamReader3 = null;
            inputStreamReader = inputStreamReader3;
            byteArrayInputStream = inputStreamReader3;
            if (bufferedReader2 != null) {
            }
            if (inputStreamReader != null) {
            }
            if (byteArrayInputStream != null) {
            }
            if (inputStream != null) {
            }
            throw th;
        }
    }

    public static synchronized SensitiveFilter getInstance() {
        SensitiveFilter sensitiveFilter2;
        synchronized (SensitiveFilter.class) {
            if (sensitiveFilter == null) {
                sensitiveFilter = new SensitiveFilter();
            }
            sensitiveFilter2 = sensitiveFilter;
        }
        return sensitiveFilter2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0074, code lost:
        if (r7 == null) goto L_0x00c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00a2, code lost:
        if (r7 != null) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x00b1, code lost:
        if (r7 != null) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x00c0, code lost:
        if (r7 != null) goto L_0x0076;
     */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x008d A[SYNTHETIC, Splitter:B:58:0x008d] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0092 A[SYNTHETIC, Splitter:B:62:0x0092] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x009f A[SYNTHETIC, Splitter:B:71:0x009f] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00ae A[SYNTHETIC, Splitter:B:80:0x00ae] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00bd A[SYNTHETIC, Splitter:B:89:0x00bd] */
    public static boolean loadSensitiveWords(String str, String str2) {
        FileOutputStream fileOutputStream;
        HttpURLConnection httpURLConnection;
        FileOutputStream fileOutputStream2;
        boolean z = false;
        InputStream inputStream = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setConnectTimeout(DisplayFeatureManager.UPDATE_PCC_LEVEL);
                httpURLConnection.setReadTimeout(DisplayFeatureManager.UPDATE_PCC_LEVEL);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoOutput(false);
                httpURLConnection.connect();
                if (httpURLConnection.getResponseCode() == 200) {
                    InputStream inputStream2 = httpURLConnection.getInputStream();
                    try {
                        File file = new File(str2, "sensi_words");
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        fileOutputStream = new FileOutputStream(file);
                        while (true) {
                            try {
                                int read = inputStream2.read();
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream.write(read);
                            } catch (MalformedURLException unused) {
                                inputStream = inputStream2;
                                if (httpURLConnection != null) {
                                }
                                if (inputStream != null) {
                                }
                            } catch (ZipException unused2) {
                                inputStream = inputStream2;
                                if (httpURLConnection != null) {
                                }
                                if (inputStream != null) {
                                }
                            } catch (Exception unused3) {
                                inputStream = inputStream2;
                                if (httpURLConnection != null) {
                                }
                                if (inputStream != null) {
                                }
                            } catch (Throwable th) {
                                inputStream = inputStream2;
                                Throwable th2 = th;
                                fileOutputStream2 = fileOutputStream;
                                th = th2;
                                if (httpURLConnection != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (fileOutputStream2 != null) {
                                }
                                throw th;
                            }
                        }
                        inputStream2.close();
                        fileOutputStream.close();
                        z = true;
                        inputStream = inputStream2;
                    } catch (MalformedURLException unused4) {
                        fileOutputStream = null;
                        inputStream = inputStream2;
                        if (httpURLConnection != null) {
                        }
                        if (inputStream != null) {
                        }
                    } catch (ZipException unused5) {
                        fileOutputStream = null;
                        inputStream = inputStream2;
                        if (httpURLConnection != null) {
                        }
                        if (inputStream != null) {
                        }
                    } catch (Exception unused6) {
                        fileOutputStream = null;
                        inputStream = inputStream2;
                        if (httpURLConnection != null) {
                        }
                        if (inputStream != null) {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream2 = null;
                        inputStream = inputStream2;
                        if (httpURLConnection != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (fileOutputStream2 != null) {
                        }
                        throw th;
                    }
                } else {
                    fileOutputStream = null;
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused7) {
                    }
                }
            } catch (MalformedURLException unused8) {
                fileOutputStream = null;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused9) {
                    }
                }
            } catch (ZipException unused10) {
                fileOutputStream = null;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused11) {
                    }
                }
            } catch (Exception unused12) {
                fileOutputStream = null;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused13) {
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream2 = null;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused14) {
                    }
                }
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused15) {
                    }
                }
                throw th;
            }
        } catch (MalformedURLException unused16) {
            httpURLConnection = null;
            fileOutputStream = null;
            if (httpURLConnection != null) {
            }
            if (inputStream != null) {
            }
        } catch (ZipException unused17) {
            httpURLConnection = null;
            fileOutputStream = null;
            if (httpURLConnection != null) {
            }
            if (inputStream != null) {
            }
        } catch (Exception unused18) {
            httpURLConnection = null;
            fileOutputStream = null;
            if (httpURLConnection != null) {
            }
            if (inputStream != null) {
            }
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection = null;
            fileOutputStream2 = null;
            if (httpURLConnection != null) {
            }
            if (inputStream != null) {
            }
            if (fileOutputStream2 != null) {
            }
            throw th;
        }
        return z;
    }

    public String getSensitiveWord(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        StringPointer stringPointer = new StringPointer(str);
        int i = 0;
        while (true) {
            int i2 = 1;
            if (i >= stringPointer.length - 1) {
                return str2;
            }
            int nextTwoCharHash = stringPointer.nextTwoCharHash(i);
            SensitiveNode[] sensitiveNodeArr = this.nodes;
            SensitiveNode sensitiveNode = sensitiveNodeArr[nextTwoCharHash & (sensitiveNodeArr.length - 1)];
            if (sensitiveNode != null) {
                int nextTwoCharMix = stringPointer.nextTwoCharMix(i);
                while (true) {
                    if (sensitiveNode == null) {
                        break;
                    }
                    if (sensitiveNode.headTwoCharMix == nextTwoCharMix) {
                        NavigableSet<StringPointer> headSet = sensitiveNode.words.headSet(stringPointer.substring(i), true);
                        if (headSet != null) {
                            for (StringPointer next : headSet.descendingSet()) {
                                if (stringPointer.nextStartsWith(i, next)) {
                                    str2 = new String(next.value);
                                    i2 = next.length;
                                    break;
                                }
                            }
                            continue;
                        } else {
                            continue;
                        }
                    }
                    sensitiveNode = sensitiveNode.next;
                }
            }
            i += i2;
        }
    }

    public boolean put(String str) {
        if (this.nodes == null || str == null || str.trim().length() < 2) {
            return false;
        }
        StringPointer stringPointer = new StringPointer(str.trim());
        int nextTwoCharHash = stringPointer.nextTwoCharHash(0);
        int nextTwoCharMix = stringPointer.nextTwoCharMix(0);
        SensitiveNode[] sensitiveNodeArr = this.nodes;
        int length = nextTwoCharHash & (sensitiveNodeArr.length - 1);
        SensitiveNode sensitiveNode = sensitiveNodeArr[length];
        if (sensitiveNode == null) {
            SensitiveNode sensitiveNode2 = new SensitiveNode(nextTwoCharMix);
            sensitiveNode2.words.add(stringPointer);
            this.nodes[length] = sensitiveNode2;
        } else {
            while (sensitiveNode != null) {
                if (sensitiveNode.headTwoCharMix == nextTwoCharMix) {
                    sensitiveNode.words.add(stringPointer);
                    return true;
                }
                SensitiveNode sensitiveNode3 = sensitiveNode.next;
                if (sensitiveNode3 == null) {
                    new SensitiveNode(nextTwoCharMix, sensitiveNode).words.add(stringPointer);
                    return true;
                }
                sensitiveNode = sensitiveNode3;
            }
        }
        return true;
    }

    public String replaceSensitiveWord(String str, char c2) {
        int i;
        StringPointer stringPointer = new StringPointer(str);
        int i2 = 0;
        boolean z = false;
        while (true) {
            boolean z2 = true;
            if (i2 >= stringPointer.length - 1) {
                break;
            }
            int nextTwoCharHash = stringPointer.nextTwoCharHash(i2);
            SensitiveNode[] sensitiveNodeArr = this.nodes;
            SensitiveNode sensitiveNode = sensitiveNodeArr[nextTwoCharHash & (sensitiveNodeArr.length - 1)];
            if (sensitiveNode != null) {
                int nextTwoCharMix = stringPointer.nextTwoCharMix(i2);
                while (true) {
                    if (sensitiveNode == null) {
                        break;
                    }
                    if (sensitiveNode.headTwoCharMix == nextTwoCharMix) {
                        NavigableSet<StringPointer> headSet = sensitiveNode.words.headSet(stringPointer.substring(i2), true);
                        if (headSet != null) {
                            for (StringPointer next : headSet.descendingSet()) {
                                if (stringPointer.nextStartsWith(i2, next)) {
                                    stringPointer.fill(i2, next.length + i2, c2);
                                    i = next.length;
                                    break;
                                }
                            }
                            continue;
                        } else {
                            continue;
                        }
                    }
                    sensitiveNode = sensitiveNode.next;
                }
            }
            z2 = z;
            i = 1;
            i2 += i;
            z = z2;
        }
        return z ? stringPointer.toString() : str;
    }
}
