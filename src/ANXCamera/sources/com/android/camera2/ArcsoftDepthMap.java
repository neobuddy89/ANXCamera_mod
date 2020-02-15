package com.android.camera2;

import android.graphics.Point;
import android.support.annotation.NonNull;
import android.util.Xml;
import com.adobe.xmp.XMPException;
import com.adobe.xmp.XMPMeta;
import com.android.camera.Util;
import com.android.camera.XmpHelper;
import com.android.camera.log.Log;
import com.android.gallery3d.exif.ExifInterface;
import com.xiaomi.camera.core.PictureInfo;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import org.xmlpull.v1.XmlSerializer;

public class ArcsoftDepthMap {
    private static final int BLUR_LEVEL_START_ADDR = 16;
    private static final int DAPTH_MAP_START_ADDR = 152;
    private static final int DATA_LENGTH_4 = 4;
    private static final int DATA_LENGTH_START_ADDR = 148;
    private static final int HEADER_LENGTH_START_ADDR = 4;
    private static final int HEADER_START_ADDR = 0;
    private static final int POINT_X_START_ADDR = 8;
    private static final int POINT_Y_START_ADDR = 12;
    private static final String TAG = "ArcsoftDepthMap";
    @Deprecated
    public static final int TAG_DEPTH_MAP_BLUR_LEVEL = ExifInterface.defineTag(2, -30575);
    @Deprecated
    public static final int TAG_DEPTH_MAP_FOCUS_POINT = ExifInterface.defineTag(2, -30576);
    private byte[] mDepthMapHeader;
    private byte[] mDepthMapOriginalData;

    private static /* synthetic */ void $closeResource(Throwable th, AutoCloseable autoCloseable) {
        if (th != null) {
            try {
                autoCloseable.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        } else {
            autoCloseable.close();
        }
    }

    public ArcsoftDepthMap(byte[] bArr) {
        if (bArr != null) {
            int headerTag = getHeaderTag(bArr);
            if (headerTag == 128) {
                this.mDepthMapOriginalData = bArr;
                this.mDepthMapHeader = getDepthMapHeader();
                return;
            }
            throw new IllegalArgumentException("Illegal depth format! 0x80 != " + headerTag);
        }
        throw new IllegalArgumentException("Null depth data!");
    }

    private static byte[] getBytes(byte[] bArr, int i, int i2) {
        if (i2 <= 0 || i < 0 || i2 > bArr.length - i) {
            throw new IllegalArgumentException("WRONG ARGUMENT: from =" + i + ", length = " + i2);
        }
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    private static int getHeaderTag(byte[] bArr) {
        return getInteger(getBytes(bArr, 0, 4));
    }

    private static int getInteger(byte[] bArr) {
        if (bArr.length == 4) {
            int i = 0;
            for (int i2 = 0; i2 < 4; i2++) {
                i += (bArr[i2] & 255) << (i2 * 8);
            }
            return i;
        }
        throw new IllegalArgumentException("bytes can not covert to a integer value!");
    }

    public static boolean isDepthMapData(byte[] bArr) {
        boolean z = bArr != null && bArr.length > 4 && getHeaderTag(bArr) == 128;
        if (!z) {
            Log.e(TAG, "Illegal depthmap format");
        }
        return z;
    }

    public int getBlurLevel() {
        return getInteger(getBytes(this.mDepthMapHeader, 16, 4));
    }

    public byte[] getDepthMapData() {
        return getBytes(this.mDepthMapOriginalData, 152, getDepthMapLength());
    }

    public byte[] getDepthMapHeader() {
        return getBytes(this.mDepthMapOriginalData, 0, getInteger(getBytes(this.mDepthMapOriginalData, 4, 4)));
    }

    public int getDepthMapLength() {
        return getInteger(getBytes(this.mDepthMapHeader, 148, 4));
    }

    public Point getFocusPoint() {
        return new Point(getInteger(getBytes(this.mDepthMapHeader, 8, 4)), getInteger(getBytes(this.mDepthMapHeader, 12, 4)));
    }

    /* JADX WARNING: Removed duplicated region for block: B:117:0x03fe  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0406 A[SYNTHETIC, Splitter:B:119:0x0406] */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x0490  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0343 A[SYNTHETIC, Splitter:B:99:0x0343] */
    public byte[] writePortraitExif(int i, byte[] bArr, byte[] bArr2, @NonNull int[] iArr, byte[] bArr3, @NonNull int[] iArr2, byte[] bArr4, int[] iArr3, int i2, boolean z, boolean z2, boolean z3, PictureInfo pictureInfo, int i3, int i4, long j) {
        byte[] bArr5;
        File file;
        File file2;
        byte[] bArr6;
        long j2;
        long j3;
        int i5;
        int i6;
        int i7;
        int i8;
        byte[] bArr7;
        int[] iArr4;
        byte[] bArr8;
        String str;
        byte[] bArr9;
        byte[] bArr10;
        byte[] bArr11;
        Throwable th;
        Throwable th2;
        long j4;
        int i9;
        int i10;
        byte[] bArr12;
        int i11;
        int i12;
        Throwable th3;
        int i13 = i;
        byte[] bArr13 = bArr;
        byte[] bArr14 = bArr2;
        byte[] bArr15 = bArr3;
        byte[] bArr16 = bArr4;
        int[] iArr5 = iArr3;
        int i14 = i2;
        int i15 = i3;
        int i16 = i4;
        long j5 = j;
        Point focusPoint = getFocusPoint();
        int blurLevel = getBlurLevel();
        boolean isFrontCamera = pictureInfo.isFrontCamera();
        int i17 = 10;
        int i18 = 5;
        if (i13 <= 0) {
            i18 = -1;
            i17 = -1;
        } else if (isFrontCamera) {
            i17 = (!pictureInfo.isAiEnabled() || pictureInfo.getAiType() != 10) ? 40 : 70;
        } else if (pictureInfo.isAiEnabled() && pictureInfo.getAiType() == 10) {
            i17 = 30;
        }
        Log.d(TAG, "writePortraitExif: focusPoint: " + focusPoint);
        Log.d(TAG, "writePortraitExif: blurLevel: " + blurLevel);
        Log.d(TAG, "writePortraitExif: shineThreshold: " + i18);
        Log.d(TAG, "writePortraitExif: shineLevel: " + i17);
        Log.d(TAG, "writePortraitExif: lightingPattern: " + i14);
        Log.d(TAG, "writePortraitExif: isCinematicAspectRatio: " + z3);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                ExifInterface exifInterface = new ExifInterface();
                exifInterface.readExif(bArr13);
                exifInterface.addXiaomiDepthmapVersion(i13);
                exifInterface.addDepthMapBlurLevel(blurLevel);
                exifInterface.addPortraitLighting(i14);
                if (z2) {
                    exifInterface.addFrontMirror(z ? 1 : 0);
                }
                exifInterface.writeExif(bArr13, (OutputStream) byteArrayOutputStream);
                bArr5 = byteArrayOutputStream.toByteArray();
                try {
                    $closeResource((Throwable) null, byteArrayOutputStream);
                } catch (IOException unused) {
                }
            } catch (Throwable th4) {
                Throwable th5 = th4;
                $closeResource(th3, byteArrayOutputStream);
                throw th5;
            }
        } catch (IOException unused2) {
            bArr5 = null;
            Log.e(TAG, "writePortraitExif(): Failed to write depthmap associated exif metadata");
            if (bArr5 != null) {
            }
            Log.e(TAG, "writePortraitExif(): #1: return original jpeg");
            return bArr;
        }
        if (bArr5 != null || bArr5.length <= bArr13.length) {
            Log.e(TAG, "writePortraitExif(): #1: return original jpeg");
            return bArr;
        }
        File file3 = new File("sdcard/DCIM/Camera/mainImage" + j5 + ".yuv");
        File file4 = new File("sdcard/DCIM/Camera/subImage" + j5 + ".yuv");
        if (!file3.exists() || !file4.exists()) {
            file = file4;
            bArr6 = bArr5;
            file2 = file3;
            j3 = 0;
            j2 = 0;
            i8 = 0;
            i7 = 0;
            i6 = 0;
            i5 = 0;
        } else {
            i6 = Util.getHeader2Int(file3, 0);
            i8 = Util.getHeader2Int(file3, 4);
            j3 = file3.length() - 8;
            file2 = file3;
            i7 = Util.getHeader2Int(file4, 0);
            i5 = Util.getHeader2Int(file4, 4);
            j2 = file4.length() - 8;
            String str2 = TAG;
            file = file4;
            StringBuilder sb = new StringBuilder();
            bArr6 = bArr5;
            sb.append("main width = ");
            sb.append(i6);
            sb.append(", main height = ");
            sb.append(i8);
            sb.append(", sub width =");
            sb.append(i7);
            sb.append(", sub height = ");
            sb.append(i5);
            Log.d(str2, sb.toString());
        }
        try {
            XmlSerializer newSerializer = Xml.newSerializer();
            StringWriter stringWriter = new StringWriter();
            newSerializer.setOutput(stringWriter);
            newSerializer.startDocument("UTF-8", true);
            newSerializer.startTag((String) null, "depthmap");
            StringWriter stringWriter2 = stringWriter;
            newSerializer.attribute((String) null, "version", String.valueOf(i));
            newSerializer.attribute((String) null, "focuspoint", focusPoint.x + "," + focusPoint.y);
            newSerializer.attribute((String) null, "blurlevel", String.valueOf(blurLevel));
            newSerializer.attribute((String) null, "shinethreshold", String.valueOf(i18));
            newSerializer.attribute((String) null, "shinelevel", String.valueOf(i17));
            newSerializer.attribute((String) null, "rawlength", String.valueOf(i3));
            newSerializer.attribute((String) null, "depthlength", String.valueOf(i4));
            newSerializer.attribute((String) null, "mimovie", String.valueOf(z3));
            newSerializer.endTag((String) null, "depthmap");
            long j6 = j3 + j2;
            if (j6 != 0) {
                try {
                    newSerializer.startTag((String) null, "mainyuv");
                    long j7 = (long) (i15 + i16);
                    newSerializer.attribute((String) null, "offset", String.valueOf(j7 + j6));
                    newSerializer.attribute((String) null, "length", String.valueOf(j3));
                    newSerializer.attribute((String) null, "width", String.valueOf(i6));
                    newSerializer.attribute((String) null, "height", String.valueOf(i8));
                    newSerializer.endTag((String) null, "mainyuv");
                    newSerializer.startTag((String) null, "subyuv");
                    newSerializer.attribute((String) null, "offset", String.valueOf(j7 + j2));
                    newSerializer.attribute((String) null, "length", String.valueOf(j2));
                    newSerializer.attribute((String) null, "width", String.valueOf(i7));
                    newSerializer.attribute((String) null, "height", String.valueOf(i5));
                    newSerializer.endTag((String) null, "subyuv");
                } catch (IOException unused3) {
                    bArr8 = bArr2;
                    bArr7 = bArr3;
                    iArr4 = iArr3;
                }
            }
            String str3 = "paddingx";
            if (bArr16 != null) {
                try {
                    if (bArr16.length > 0) {
                        iArr4 = iArr3;
                        if (iArr4 != null) {
                            try {
                                if (iArr4.length >= 4) {
                                    newSerializer.startTag((String) null, "subimage");
                                    int length = bArr16.length;
                                    bArr12 = bArr2;
                                    if (bArr12 != null) {
                                        try {
                                            i11 = bArr12.length;
                                        } catch (IOException unused4) {
                                            bArr7 = bArr3;
                                        }
                                    } else {
                                        i11 = 0;
                                    }
                                    int i19 = length + i11;
                                    bArr7 = bArr3;
                                    if (bArr7 != null) {
                                        try {
                                            i12 = bArr7.length;
                                        } catch (IOException unused5) {
                                        }
                                    } else {
                                        i12 = 0;
                                    }
                                    String str4 = str3;
                                    i10 = i3;
                                    j4 = j6;
                                    long j8 = ((long) (i19 + i12)) + j6 + ((long) i10);
                                    i9 = i4;
                                    try {
                                        newSerializer.attribute((String) null, "offset", String.valueOf(j8 + ((long) i9)));
                                        newSerializer.attribute((String) null, "length", String.valueOf(bArr16.length));
                                        str3 = str4;
                                        newSerializer.attribute((String) null, str3, String.valueOf(iArr4[0]));
                                        newSerializer.attribute((String) null, "paddingy", String.valueOf(iArr4[1]));
                                        newSerializer.attribute((String) null, "width", String.valueOf(iArr4[2]));
                                        newSerializer.attribute((String) null, "height", String.valueOf(iArr4[3]));
                                        newSerializer.endTag((String) null, "subimage");
                                        bArr8 = bArr2;
                                        if (bArr8 != null) {
                                            try {
                                                if (bArr8.length > 0) {
                                                    newSerializer.startTag((String) null, "lenswatermark");
                                                    newSerializer.attribute((String) null, "offset", String.valueOf(((long) (bArr8.length + (bArr7 != null ? bArr7.length : 0))) + j4 + ((long) i10) + ((long) i9)));
                                                    newSerializer.attribute((String) null, "length", String.valueOf(bArr8.length));
                                                    newSerializer.attribute((String) null, "width", String.valueOf(iArr[0]));
                                                    newSerializer.attribute((String) null, "height", String.valueOf(iArr[1]));
                                                    newSerializer.attribute((String) null, str3, String.valueOf(iArr[2]));
                                                    newSerializer.attribute((String) null, "paddingy", String.valueOf(iArr[3]));
                                                    newSerializer.endTag((String) null, "lenswatermark");
                                                }
                                            } catch (IOException unused6) {
                                                Log.e(TAG, "writePortraitExif(): Failed to generate depthmap associated xmp metadata");
                                                str = null;
                                                if (str != null) {
                                                }
                                            }
                                        }
                                        if (bArr7 != null && bArr7.length > 0) {
                                            newSerializer.startTag((String) null, "timewatermark");
                                            newSerializer.attribute((String) null, "offset", String.valueOf(((long) bArr7.length) + j4 + ((long) i10) + ((long) i9)));
                                            newSerializer.attribute((String) null, "length", String.valueOf(bArr7.length));
                                            newSerializer.attribute((String) null, "width", String.valueOf(iArr2[0]));
                                            newSerializer.attribute((String) null, "height", String.valueOf(iArr2[1]));
                                            newSerializer.attribute((String) null, str3, String.valueOf(iArr2[2]));
                                            newSerializer.attribute((String) null, "paddingy", String.valueOf(iArr2[3]));
                                            newSerializer.endTag((String) null, "timewatermark");
                                        }
                                        newSerializer.endDocument();
                                        str = stringWriter2.toString();
                                    } catch (IOException unused7) {
                                    }
                                    if (str != null) {
                                        Log.e(TAG, "writePortraitExif(): #2: return original jpeg");
                                        return bArr;
                                    }
                                    try {
                                        bArr10 = bArr6;
                                        try {
                                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr10);
                                            try {
                                                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                                                try {
                                                    XMPMeta createXMPMeta = XmpHelper.createXMPMeta();
                                                    createXMPMeta.setProperty(XmpHelper.XIAOMI_XMP_METADATA_NAMESPACE, XmpHelper.XIAOMI_XMP_METADATA_PROPERTY_NAME, str);
                                                    XmpHelper.writeXMPMeta(byteArrayInputStream, byteArrayOutputStream2, createXMPMeta);
                                                    byte[] bArr17 = bArr4;
                                                    if (bArr17 != null) {
                                                        try {
                                                            if (bArr17.length > 0 && iArr4 != null && iArr4.length >= 4) {
                                                                byteArrayOutputStream2.write(bArr17);
                                                            }
                                                        } catch (Throwable th6) {
                                                            th2 = th6;
                                                            bArr11 = null;
                                                            try {
                                                                throw th2;
                                                            } catch (Throwable th7) {
                                                                th = th7;
                                                                th = th;
                                                                try {
                                                                    throw th;
                                                                } catch (XMPException | IOException unused8) {
                                                                    bArr9 = bArr11;
                                                                    Log.d(TAG, "writePortraitExif(): Failed to insert depthmap associated xmp metadata");
                                                                    if (bArr9 == null) {
                                                                    }
                                                                    Log.e(TAG, "writePortraitExif(): #3: return original jpeg");
                                                                    return bArr;
                                                                } catch (Throwable th8) {
                                                                    Throwable th9 = th8;
                                                                    $closeResource(th, byteArrayInputStream);
                                                                    throw th9;
                                                                }
                                                            }
                                                        }
                                                    }
                                                    if (bArr8 != null) {
                                                        byteArrayOutputStream2.write(bArr8);
                                                    }
                                                    if (bArr7 != null) {
                                                        byteArrayOutputStream2.write(bArr7);
                                                    }
                                                    if (j3 != 0) {
                                                        File file5 = file2;
                                                        Util.writeFile2Stream(file5, byteArrayOutputStream2, 8);
                                                        file5.delete();
                                                    }
                                                    if (j2 != 0) {
                                                        File file6 = file;
                                                        Util.writeFile2Stream(file6, byteArrayOutputStream2, 8);
                                                        file6.delete();
                                                    }
                                                    byteArrayOutputStream2.flush();
                                                    bArr9 = byteArrayOutputStream2.toByteArray();
                                                } catch (Throwable th10) {
                                                    bArr11 = null;
                                                    th2 = th10;
                                                    throw th2;
                                                }
                                                try {
                                                    $closeResource((Throwable) null, byteArrayOutputStream2);
                                                    try {
                                                        $closeResource((Throwable) null, byteArrayInputStream);
                                                    } catch (XMPException | IOException unused9) {
                                                    }
                                                    if (bArr9 == null && bArr9.length > bArr10.length) {
                                                        return bArr9;
                                                    }
                                                    Log.e(TAG, "writePortraitExif(): #3: return original jpeg");
                                                    return bArr;
                                                } catch (Throwable th11) {
                                                    th = th11;
                                                    bArr11 = bArr9;
                                                    th = th;
                                                    throw th;
                                                }
                                            } catch (Throwable th12) {
                                                th = th12;
                                                bArr11 = null;
                                                th = th;
                                                throw th;
                                            }
                                        } catch (XMPException | IOException unused10) {
                                            bArr11 = null;
                                            bArr9 = bArr11;
                                            Log.d(TAG, "writePortraitExif(): Failed to insert depthmap associated xmp metadata");
                                            if (bArr9 == null) {
                                            }
                                            Log.e(TAG, "writePortraitExif(): #3: return original jpeg");
                                            return bArr;
                                        }
                                    } catch (XMPException | IOException unused11) {
                                        bArr10 = bArr6;
                                        bArr11 = null;
                                        bArr9 = bArr11;
                                        Log.d(TAG, "writePortraitExif(): Failed to insert depthmap associated xmp metadata");
                                        if (bArr9 == null) {
                                        }
                                        Log.e(TAG, "writePortraitExif(): #3: return original jpeg");
                                        return bArr;
                                    }
                                }
                            } catch (IOException unused12) {
                                bArr7 = bArr3;
                                bArr8 = bArr2;
                                Log.e(TAG, "writePortraitExif(): Failed to generate depthmap associated xmp metadata");
                                str = null;
                                if (str != null) {
                                }
                            }
                        }
                        bArr7 = bArr3;
                        i10 = i3;
                        j4 = j6;
                        i9 = i4;
                        bArr8 = bArr2;
                        if (bArr8 != null) {
                        }
                        newSerializer.startTag((String) null, "timewatermark");
                        newSerializer.attribute((String) null, "offset", String.valueOf(((long) bArr7.length) + j4 + ((long) i10) + ((long) i9)));
                        newSerializer.attribute((String) null, "length", String.valueOf(bArr7.length));
                        newSerializer.attribute((String) null, "width", String.valueOf(iArr2[0]));
                        newSerializer.attribute((String) null, "height", String.valueOf(iArr2[1]));
                        newSerializer.attribute((String) null, str3, String.valueOf(iArr2[2]));
                        newSerializer.attribute((String) null, "paddingy", String.valueOf(iArr2[3]));
                        newSerializer.endTag((String) null, "timewatermark");
                        newSerializer.endDocument();
                        str = stringWriter2.toString();
                        if (str != null) {
                        }
                    }
                } catch (IOException unused13) {
                    bArr7 = bArr3;
                    iArr4 = iArr3;
                    bArr8 = bArr2;
                    Log.e(TAG, "writePortraitExif(): Failed to generate depthmap associated xmp metadata");
                    str = null;
                    if (str != null) {
                    }
                }
            }
            bArr7 = bArr3;
            iArr4 = iArr3;
            i10 = i3;
            j4 = j6;
            i9 = i4;
            bArr8 = bArr2;
            if (bArr8 != null) {
            }
            newSerializer.startTag((String) null, "timewatermark");
            newSerializer.attribute((String) null, "offset", String.valueOf(((long) bArr7.length) + j4 + ((long) i10) + ((long) i9)));
            newSerializer.attribute((String) null, "length", String.valueOf(bArr7.length));
            newSerializer.attribute((String) null, "width", String.valueOf(iArr2[0]));
            newSerializer.attribute((String) null, "height", String.valueOf(iArr2[1]));
            newSerializer.attribute((String) null, str3, String.valueOf(iArr2[2]));
            newSerializer.attribute((String) null, "paddingy", String.valueOf(iArr2[3]));
            newSerializer.endTag((String) null, "timewatermark");
            newSerializer.endDocument();
            str = stringWriter2.toString();
        } catch (IOException unused14) {
            bArr8 = bArr2;
            bArr7 = bArr3;
            iArr4 = iArr5;
            Log.e(TAG, "writePortraitExif(): Failed to generate depthmap associated xmp metadata");
            str = null;
            if (str != null) {
            }
        }
        if (str != null) {
        }
        bArr8 = bArr12;
        Log.e(TAG, "writePortraitExif(): Failed to generate depthmap associated xmp metadata");
        str = null;
        if (str != null) {
        }
    }
}
