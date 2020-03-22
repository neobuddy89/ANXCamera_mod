package miui.util;

import aeonax.Build;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class FeatureParser {
    private static final String ASSET_DIR = "device_features/";
    private static final String SYSTEM_DIR = "/sdcard/.ANXCamera/features";
    private static final String TAG = "FeatureParser";
    private static final String TAG_BOOL = "bool";
    private static final String TAG_FLOAT = "float";
    private static final String TAG_INTEGER = "integer";
    private static final String TAG_INTEGER_ARRAY = "integer-array";
    private static final String TAG_ITEM = "item";
    private static final String TAG_STRING = "string";
    private static final String TAG_STRING_ARRAY = "string-array";
    public static final int TYPE_BOOL = 1;
    public static final int TYPE_FLOAT = 6;
    public static final int TYPE_INTEGER = 2;
    public static final int TYPE_INTEGER_ARRAY = 5;
    public static final int TYPE_STRING = 3;
    public static final int TYPE_STRING_ARRAY = 4;
    private static final String VENDOR_DIR = "/sdcard/.ANXCamera/features";
    private static HashMap<String, Boolean> sBooleanMap = new HashMap<>();
    private static HashMap<String, Float> sFloatMap = new HashMap<>();
    private static HashMap<String, ArrayList<Integer>> sIntArrMap = new HashMap<>();
    private static HashMap<String, Integer> sIntMap = new HashMap<>();
    private static HashMap<String, ArrayList<String>> sStrArrMap = new HashMap<>();
    private static HashMap<String, String> sStrMap = new HashMap<>();

    static {
        read();
    }

    public static boolean getBoolean(String str, boolean z) {
        Boolean bool = sBooleanMap.get(str);
        return bool != null ? bool.booleanValue() : z;
    }

    public static String getDeviceFeaturesDir() {
        return (("umi".equals(Build.ANXDEVICE) || "cmi".equals(Build.ANXDEVICE) || "lmi".equals(Build.ANXDEVICE) || "picasso".equals(Build.ANXDEVICE) || "picassoin".equals(Build.ANXDEVICE)) && Build.VERSION.SDK_INT >= 29) ? "/sdcard/.ANXCamera/features" : "/sdcard/.ANXCamera/features";
    }

    public static Float getFloat(String str, float f2) {
        Float f3 = sFloatMap.get(str);
        return Float.valueOf(f3 != null ? f3.floatValue() : f2);
    }

    public static int[] getIntArray(String str) {
        ArrayList arrayList = sIntArrMap.get(str);
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = ((Integer) arrayList.get(i)).intValue();
        }
        return iArr;
    }

    public static int getInteger(String str, int i) {
        Integer num = sIntMap.get(str);
        return num != null ? num.intValue() : i;
    }

    public static String getString(String str) {
        return sStrMap.get(str);
    }

    public static String[] getStringArray(String str) {
        ArrayList arrayList = sStrArrMap.get(str);
        if (arrayList != null) {
            return (String[]) arrayList.toArray(new String[0]);
        }
        return null;
    }

    public static boolean hasFeature(String str, int i) {
        switch (i) {
            case 1:
                return sBooleanMap.containsKey(str);
            case 2:
                return sIntMap.containsKey(str);
            case 3:
                return sStrMap.containsKey(str);
            case 4:
                return sStrArrMap.containsKey(str);
            case 5:
                return sIntArrMap.containsKey(str);
            case 6:
                return sFloatMap.containsKey(str);
            default:
                return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        android.util.Log.i(TAG, "can't find " + r3 + " in assets/" + ASSET_DIR + ",it may be in " + getDeviceFeaturesDir());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01bc, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01bd, code lost:
        if (r2 != null) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01c6, code lost:
        if (r2 != null) goto L_0x01c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01bc A[ExcHandler: all (r0v3 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r2 
  PHI: (r2v3 java.io.FileInputStream) = (r2v0 java.io.FileInputStream), (r2v0 java.io.FileInputStream), (r2v5 java.io.FileInputStream), (r2v5 java.io.FileInputStream), (r2v0 java.io.FileInputStream) binds: [B:1:0x0008, B:12:0x0040, B:27:0x00c6, B:36:0x00ea, B:16:0x005e] A[DONT_GENERATE, DONT_INLINE], Splitter:B:12:0x0040] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01c5 A[ExcHandler: XmlPullParserException (e org.xmlpull.v1.XmlPullParserException), PHI: r2 
  PHI: (r2v2 java.io.FileInputStream) = (r2v0 java.io.FileInputStream), (r2v0 java.io.FileInputStream), (r2v5 java.io.FileInputStream), (r2v5 java.io.FileInputStream), (r2v0 java.io.FileInputStream) binds: [B:1:0x0008, B:12:0x0040, B:27:0x00c6, B:36:0x00ea, B:16:0x005e] A[DONT_GENERATE, DONT_INLINE], Splitter:B:1:0x0008] */
    private static void read() {
        FileInputStream fileInputStream = null;
        String str = null;
        try {
            if (!"cancro".equals(aeonax.Build.ANXDEVICE)) {
                str = aeonax.Build.ANXDEVICE + ".xml";
            } else if (miui.os.Build.MODEL.startsWith("MI 3")) {
                str = "cancro_MI3.xml";
            } else if (miui.os.Build.MODEL.startsWith("MI 4")) {
                str = "cancro_MI4.xml";
            }
            fileInputStream = Resources.getSystem().getAssets().open(ASSET_DIR + str);
            if (fileInputStream == null) {
                File file = new File(getDeviceFeaturesDir(), str);
                if (file.exists()) {
                    fileInputStream = new FileInputStream(file);
                } else {
                    Log.e(TAG, "both assets/device_features/ and " + getDeviceFeaturesDir() + " don't exist " + str);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                            return;
                        } catch (IOException e2) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            newPullParser.setInput(fileInputStream, "UTF-8");
            String str2 = null;
            ArrayList arrayList = null;
            ArrayList arrayList2 = null;
            for (int eventType = newPullParser.getEventType(); 1 != eventType; eventType = newPullParser.next()) {
                if (eventType == 2) {
                    String name = newPullParser.getName();
                    if (newPullParser.getAttributeCount() > 0) {
                        str2 = newPullParser.getAttributeValue(0);
                    }
                    if (TAG_INTEGER_ARRAY.equals(name)) {
                        arrayList = new ArrayList();
                    } else if (TAG_STRING_ARRAY.equals(name)) {
                        arrayList2 = new ArrayList();
                    } else if (TAG_BOOL.equals(name)) {
                        sBooleanMap.put(str2, Boolean.valueOf(newPullParser.nextText()));
                    } else if (TAG_INTEGER.equals(name)) {
                        sIntMap.put(str2, Integer.valueOf(newPullParser.nextText()));
                    } else if (TAG_STRING.equals(name)) {
                        sStrMap.put(str2, newPullParser.nextText());
                    } else if (TAG_FLOAT.equals(name)) {
                        sFloatMap.put(str2, Float.valueOf(Float.parseFloat(newPullParser.nextText())));
                    } else if (TAG_ITEM.equals(name)) {
                        if (arrayList != null) {
                            arrayList.add(Integer.valueOf(newPullParser.nextText()));
                        } else if (arrayList2 != null) {
                            arrayList2.add(newPullParser.nextText());
                        }
                    }
                } else if (eventType == 3) {
                    String name2 = newPullParser.getName();
                    if (TAG_INTEGER_ARRAY.equals(name2)) {
                        sIntArrMap.put(str2, arrayList);
                        arrayList = null;
                    } else if (TAG_STRING_ARRAY.equals(name2)) {
                        sStrArrMap.put(str2, arrayList2);
                        arrayList2 = null;
                    }
                }
            }
            try {
                fileInputStream.close();
                return;
            } catch (IOException e3) {
                return;
            }
        } catch (IOException e4) {
            if (fileInputStream != null) {
                fileInputStream.close();
                return;
            }
            return;
        } catch (XmlPullParserException e5) {
        } catch (Throwable th) {
        }
        throw th;
    }
}
