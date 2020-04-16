package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.3.0 */
public final class zziw {
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0039 A[Catch:{ IOException -> 0x003f, ClassNotFoundException -> 0x003d }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0043 A[Catch:{ IOException -> 0x003f, ClassNotFoundException -> 0x003d }] */
    public static Object zza(Object obj) {
        ObjectInputStream objectInputStream;
        ObjectOutputStream objectOutputStream;
        Object readObject;
        if (obj == null) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(obj);
                objectOutputStream.flush();
                objectInputStream = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
                try {
                    readObject = objectInputStream.readObject();
                } catch (Throwable th) {
                    th = th;
                    if (objectOutputStream != null) {
                    }
                    if (objectInputStream != null) {
                    }
                    throw th;
                }
                try {
                    objectOutputStream.close();
                    objectInputStream.close();
                    return readObject;
                } catch (IOException e2) {
                    return null;
                } catch (ClassNotFoundException e3) {
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                objectInputStream = null;
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            objectInputStream = null;
            objectOutputStream = null;
            if (objectOutputStream != null) {
            }
            if (objectInputStream != null) {
            }
            throw th;
        }
    }

    public static String zza(String str, String[] strArr, String[] strArr2) {
        Preconditions.checkNotNull(strArr);
        Preconditions.checkNotNull(strArr2);
        int min = Math.min(strArr.length, strArr2.length);
        for (int i = 0; i < min; i++) {
            String str2 = strArr[i];
            if ((str == null && str2 == null) ? true : str == null ? false : str.equals(str2)) {
                return strArr2[i];
            }
        }
        return null;
    }
}
