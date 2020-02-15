package com.arcsoft.camera.utils;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* compiled from: ArrayUtil */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f166a = "e";

    /* renamed from: b  reason: collision with root package name */
    private static final double f167b = 1.0E-9d;

    private e() {
    }

    public static <T extends Comparable<? super T>> void a(List<T> list) {
        Collections.sort(list);
    }

    public static <T extends Comparable<? super T>> void a(T[] tArr) {
        Arrays.sort(tArr);
    }

    public static <T> boolean a(T t, T t2) {
        if (t == null && t2 == null) {
            return true;
        }
        if (t == null || t2 == null) {
            return false;
        }
        if (t instanceof Byte) {
            return ((Byte) t).byteValue() == ((Byte) t2).byteValue();
        }
        if (t instanceof Short) {
            return ((Short) t).shortValue() == ((Short) t2).shortValue();
        }
        if (t instanceof Integer) {
            return ((Integer) t).intValue() == ((Integer) t2).intValue();
        }
        if (t instanceof Long) {
            return ((Long) t).longValue() == ((Long) t2).longValue();
        }
        if (t instanceof Float) {
            double abs = (double) Math.abs(((Float) t).floatValue() - ((Float) t2).floatValue());
            return abs > -1.0E-9d && abs < f167b;
        } else if (!(t instanceof Double)) {
            return t instanceof String ? ((String) t).equals((String) t2) : t instanceof g ? ((g) t).h((g) t2) : t.equals(t2);
        } else {
            double abs2 = Math.abs(((Double) t).doubleValue() - ((Double) t2).doubleValue());
            return abs2 > -1.0E-9d && abs2 < f167b;
        }
    }

    public static <T> boolean a(T[] tArr, T t) {
        if (tArr == null || tArr.length <= 0) {
            return false;
        }
        for (T a2 : tArr) {
            if (a(a2, t)) {
                return true;
            }
        }
        return false;
    }

    public static <T> T[] a(T[] tArr, Class<T> cls) {
        HashSet hashSet = new HashSet();
        for (T add : tArr) {
            hashSet.add(add);
        }
        return hashSet.toArray((Object[]) Array.newInstance(cls, hashSet.size()));
    }

    public static <T> T[] a(T[] tArr, T t, Class<T> cls) {
        if (!a(tArr, t)) {
            return tArr;
        }
        int length = tArr.length;
        if (length == 1) {
            return tArr[0] == t ? (Object[]) Array.newInstance(cls, 0) : tArr;
        }
        int[] c2 = c(tArr, t);
        if (c2 == null || c2.length <= 0) {
            return tArr;
        }
        T[] tArr2 = (Object[]) Array.newInstance(cls, length - c2.length);
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (!c(c2, i2)) {
                tArr2[i] = tArr[i2];
                i++;
            }
        }
        return tArr2;
    }

    public static <T> T[] a(T[] tArr, T[]... tArr2) {
        int length = tArr.length;
        for (T[] length2 : tArr2) {
            length += length2.length;
        }
        T[] copyOf = Arrays.copyOf(tArr, length);
        int length3 = tArr.length;
        int i = length3;
        for (T[] tArr3 : tArr2) {
            System.arraycopy(tArr3, 0, copyOf, i, tArr3.length);
            i += tArr3.length;
        }
        return copyOf;
    }

    public static <T> int b(T[] tArr, T t) {
        if (tArr == null) {
            return -1;
        }
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            if (a(t, tArr[i])) {
                return i;
            }
        }
        return -1;
    }

    public static <T> void b(T[] tArr) {
        if (tArr != null && tArr.length != 0 && tArr.length != 1) {
            int length = tArr.length;
            int i = length / 2;
            for (int i2 = 0; i2 < i; i2++) {
                T t = tArr[i2];
                int i3 = (length - i2) - 1;
                tArr[i2] = tArr[i3];
                tArr[i3] = t;
            }
        }
    }

    public static int[] b(int[] iArr) {
        if (iArr != null && iArr.length > 1) {
            int length = iArr.length;
            int i = 0;
            while (i < length - 1) {
                int i2 = i + 1;
                int i3 = i;
                for (int i4 = i2; i4 < length; i4++) {
                    if (iArr[i3] > iArr[i4]) {
                        i3 = i4;
                    }
                }
                if (i3 != i) {
                    int i5 = iArr[i];
                    iArr[i] = iArr[i3];
                    iArr[i3] = i5;
                }
                i = i2;
            }
        }
        return iArr;
    }

    public static <T> String c(T[] tArr) {
        return Arrays.toString(tArr);
    }

    public static boolean c(int[] iArr, int i) {
        if (iArr == null || iArr.length <= 0) {
            return false;
        }
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static <T> int[] c(T[] tArr, T t) {
        if (!a(tArr, t)) {
            return new int[0];
        }
        int length = tArr.length;
        int[] iArr = new int[length];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (a(tArr[i2], t)) {
                iArr[i] = i2;
                i++;
            }
        }
        if (i == 0) {
            return new int[0];
        }
        int[] iArr2 = new int[i];
        System.arraycopy(iArr, 0, iArr2, 0, i);
        return iArr2;
    }
}
