package androidx.versionedparcelable;

import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.NetworkOnMainThreadException;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseBooleanArray;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class VersionedParcel {
    private static final int Oa = -1;
    private static final int Pa = -2;
    private static final int Qa = -3;
    private static final int Ra = -4;
    private static final int Sa = -5;
    private static final String TAG = "VersionedParcel";
    private static final int TYPE_STRING = 4;
    private static final int Ta = -6;
    private static final int Ua = -7;
    private static final int Va = -9;
    private static final int Wa = 1;
    private static final int Xa = 2;
    private static final int Ya = 3;
    private static final int Za = 5;

    public static class ParcelException extends RuntimeException {
        public ParcelException(Throwable th) {
            super(th);
        }
    }

    protected static <T extends i> T a(String str, VersionedParcel versionedParcel) {
        try {
            return (i) Class.forName(str, true, VersionedParcel.class.getClassLoader()).getDeclaredMethod("read", new Class[]{VersionedParcel.class}).invoke((Object) null, new Object[]{versionedParcel});
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (InvocationTargetException e3) {
            if (e3.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e3.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e4);
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e5);
        }
    }

    protected static <T extends i> void a(T t, VersionedParcel versionedParcel) {
        try {
            c(t).getDeclaredMethod("write", new Class[]{t.getClass(), VersionedParcel.class}).invoke((Object) null, new Object[]{t, versionedParcel});
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (InvocationTargetException e3) {
            if (e3.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e3.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e4);
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e5);
        }
    }

    private Exception b(int i, String str) {
        switch (i) {
            case Va /*-9*/:
                return (Exception) Na();
            case -7:
                return new UnsupportedOperationException(str);
            case -6:
                return new NetworkOnMainThreadException();
            case -5:
                return new IllegalStateException(str);
            case -4:
                return new NullPointerException(str);
            case -3:
                return new IllegalArgumentException(str);
            case -2:
                return new BadParcelableException(str);
            case -1:
                return new SecurityException(str);
            default:
                return new RuntimeException("Unknown exception code: " + i + " msg " + str);
        }
    }

    private static <T extends i> Class c(T t) throws ClassNotFoundException {
        return l((Class<? extends i>) t.getClass());
    }

    private void d(i iVar) {
        try {
            writeString(l((Class<? extends i>) iVar.getClass()).getName());
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException(iVar.getClass().getSimpleName() + " does not have a Parcelizer", e2);
        }
    }

    @NonNull
    protected static Throwable getRootCause(@NonNull Throwable th) {
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th;
    }

    private static Class l(Class<? extends i> cls) throws ClassNotFoundException {
        return Class.forName(String.format("%s.%sParcelizer", new Object[]{cls.getPackage().getName(), cls.getSimpleName()}), false, cls.getClassLoader());
    }

    private Exception readException(int i, String str) {
        return b(i, str);
    }

    private int readExceptionCode() {
        return readInt();
    }

    private <T> int s(T t) {
        if (t instanceof String) {
            return 4;
        }
        if (t instanceof Parcelable) {
            return 2;
        }
        if (t instanceof i) {
            return 1;
        }
        if (t instanceof Serializable) {
            return 3;
        }
        if (t instanceof IBinder) {
            return 5;
        }
        throw new IllegalArgumentException(t.getClass().getName() + " cannot be VersionedParcelled");
    }

    private void writeSerializable(Serializable serializable) {
        if (serializable == null) {
            writeString((String) null);
            return;
        }
        String name = serializable.getClass().getName();
        writeString(name);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
            writeByteArray(byteArrayOutputStream.toByteArray());
        } catch (IOException e2) {
            throw new RuntimeException("VersionedParcelable encountered IOException writing serializable object (name = " + name + ")", e2);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void Fa();

    /* access modifiers changed from: protected */
    public abstract VersionedParcel Ga();

    public boolean Ha() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean[] Ia() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        boolean[] zArr = new boolean[readInt];
        for (int i = 0; i < readInt; i++) {
            zArr[i] = readInt() != 0;
        }
        return zArr;
    }

    /* access modifiers changed from: protected */
    public double[] Ja() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        double[] dArr = new double[readInt];
        for (int i = 0; i < readInt; i++) {
            dArr[i] = readDouble();
        }
        return dArr;
    }

    /* access modifiers changed from: protected */
    public float[] Ka() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        float[] fArr = new float[readInt];
        for (int i = 0; i < readInt; i++) {
            fArr[i] = readFloat();
        }
        return fArr;
    }

    /* access modifiers changed from: protected */
    public int[] La() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        int[] iArr = new int[readInt];
        for (int i = 0; i < readInt; i++) {
            iArr[i] = readInt();
        }
        return iArr;
    }

    /* access modifiers changed from: protected */
    public long[] Ma() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        long[] jArr = new long[readInt];
        for (int i = 0; i < readInt; i++) {
            jArr[i] = readLong();
        }
        return jArr;
    }

    /* access modifiers changed from: protected */
    public abstract <T extends Parcelable> T Na();

    /* access modifiers changed from: protected */
    public <T extends i> T Oa() {
        String readString = readString();
        if (readString == null) {
            return null;
        }
        return a(readString, Ga());
    }

    public byte a(byte b2, int i) {
        return !k(i) ? b2 : (byte) (readInt() & 255);
    }

    public double a(double d2, int i) {
        return !k(i) ? d2 : readDouble();
    }

    public float a(float f2, int i) {
        return !k(i) ? f2 : readFloat();
    }

    public long a(long j, int i) {
        return !k(i) ? j : readLong();
    }

    public Bundle a(Bundle bundle, int i) {
        return !k(i) ? bundle : readBundle();
    }

    public IBinder a(IBinder iBinder, int i) {
        return !k(i) ? iBinder : readStrongBinder();
    }

    public <T extends Parcelable> T a(T t, int i) {
        return !k(i) ? t : Na();
    }

    @RequiresApi(api = 21)
    public Size a(Size size, int i) {
        if (!k(i)) {
            return size;
        }
        if (readBoolean()) {
            return new Size(readInt(), readInt());
        }
        return null;
    }

    @RequiresApi(api = 21)
    public SizeF a(SizeF sizeF, int i) {
        if (!k(i)) {
            return sizeF;
        }
        if (readBoolean()) {
            return new SizeF(readFloat(), readFloat());
        }
        return null;
    }

    public SparseBooleanArray a(SparseBooleanArray sparseBooleanArray, int i) {
        if (!k(i)) {
            return sparseBooleanArray;
        }
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        SparseBooleanArray sparseBooleanArray2 = new SparseBooleanArray(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            sparseBooleanArray2.put(readInt(), readBoolean());
        }
        return sparseBooleanArray2;
    }

    public <T extends i> T a(T t, int i) {
        return !k(i) ? t : Oa();
    }

    public Exception a(Exception exc, int i) {
        if (!k(i)) {
            return exc;
        }
        int readExceptionCode = readExceptionCode();
        return readExceptionCode != 0 ? readException(readExceptionCode, readString()) : exc;
    }

    public <T> List<T> a(List<T> list, int i) {
        if (!k(i)) {
            return list;
        }
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(readInt);
        if (readInt != 0) {
            int readInt2 = readInt();
            if (readInt < 0) {
                return null;
            }
            if (readInt2 == 1) {
                while (readInt > 0) {
                    arrayList.add(Oa());
                    readInt--;
                }
            } else if (readInt2 == 2) {
                while (readInt > 0) {
                    arrayList.add(Na());
                    readInt--;
                }
            } else if (readInt2 == 3) {
                while (readInt > 0) {
                    arrayList.add(readSerializable());
                    readInt--;
                }
            } else if (readInt2 == 4) {
                while (readInt > 0) {
                    arrayList.add(readString());
                    readInt--;
                }
            } else if (readInt2 == 5) {
                while (readInt > 0) {
                    arrayList.add(readStrongBinder());
                    readInt--;
                }
            }
        }
        return arrayList;
    }

    public void a(IInterface iInterface, int i) {
        l(i);
        writeStrongInterface(iInterface);
    }

    public void a(Serializable serializable, int i) {
        l(i);
        writeSerializable(serializable);
    }

    public void a(byte[] bArr, int i, int i2, int i3) {
        l(i3);
        writeByteArray(bArr, i, i2);
    }

    public boolean a(boolean z, int i) {
        return !k(i) ? z : readBoolean();
    }

    public byte[] a(byte[] bArr, int i) {
        return !k(i) ? bArr : readByteArray();
    }

    public char[] a(char[] cArr, int i) {
        if (!k(i)) {
            return cArr;
        }
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        char[] cArr2 = new char[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            cArr2[i2] = (char) readInt();
        }
        return cArr2;
    }

    public double[] a(double[] dArr, int i) {
        return !k(i) ? dArr : Ja();
    }

    public float[] a(float[] fArr, int i) {
        return !k(i) ? fArr : Ka();
    }

    public int[] a(int[] iArr, int i) {
        return !k(i) ? iArr : La();
    }

    public long[] a(long[] jArr, int i) {
        return !k(i) ? jArr : Ma();
    }

    /* access modifiers changed from: protected */
    public <T> T[] a(T[] tArr) {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(readInt);
        if (readInt != 0) {
            int readInt2 = readInt();
            if (readInt < 0) {
                return null;
            }
            if (readInt2 == 1) {
                while (readInt > 0) {
                    arrayList.add(Oa());
                    readInt--;
                }
            } else if (readInt2 == 2) {
                while (readInt > 0) {
                    arrayList.add(Na());
                    readInt--;
                }
            } else if (readInt2 == 3) {
                while (readInt > 0) {
                    arrayList.add(readSerializable());
                    readInt--;
                }
            } else if (readInt2 == 4) {
                while (readInt > 0) {
                    arrayList.add(readString());
                    readInt--;
                }
            } else if (readInt2 == 5) {
                while (readInt > 0) {
                    arrayList.add(readStrongBinder());
                    readInt--;
                }
            }
        }
        return arrayList.toArray(tArr);
    }

    public <T> T[] a(T[] tArr, int i) {
        return !k(i) ? tArr : a(tArr);
    }

    public boolean[] a(boolean[] zArr, int i) {
        return !k(i) ? zArr : Ia();
    }

    public void b(byte b2, int i) {
        l(i);
        writeInt(b2);
    }

    public void b(double d2, int i) {
        l(i);
        writeDouble(d2);
    }

    public void b(float f2, int i) {
        l(i);
        writeFloat(f2);
    }

    public void b(long j, int i) {
        l(i);
        writeLong(j);
    }

    public void b(Bundle bundle, int i) {
        l(i);
        writeBundle(bundle);
    }

    public void b(IBinder iBinder, int i) {
        l(i);
        writeStrongBinder(iBinder);
    }

    /* access modifiers changed from: protected */
    public abstract void b(Parcelable parcelable);

    @RequiresApi(api = 21)
    public void b(Size size, int i) {
        l(i);
        writeBoolean(size != null);
        if (size != null) {
            writeInt(size.getWidth());
            writeInt(size.getHeight());
        }
    }

    @RequiresApi(api = 21)
    public void b(SizeF sizeF, int i) {
        l(i);
        writeBoolean(sizeF != null);
        if (sizeF != null) {
            writeFloat(sizeF.getWidth());
            writeFloat(sizeF.getHeight());
        }
    }

    public void b(SparseBooleanArray sparseBooleanArray, int i) {
        l(i);
        if (sparseBooleanArray == null) {
            writeInt(-1);
            return;
        }
        int size = sparseBooleanArray.size();
        writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            writeInt(sparseBooleanArray.keyAt(i2));
            writeBoolean(sparseBooleanArray.valueAt(i2));
        }
    }

    /* access modifiers changed from: protected */
    public void b(i iVar) {
        if (iVar == null) {
            writeString((String) null);
            return;
        }
        d(iVar);
        VersionedParcel Ga = Ga();
        a(iVar, Ga);
        Ga.Fa();
    }

    public void b(i iVar, int i) {
        l(i);
        b(iVar);
    }

    public void b(Exception exc, int i) {
        l(i);
        if (exc == null) {
            writeNoException();
            return;
        }
        int i2 = 0;
        if ((exc instanceof Parcelable) && exc.getClass().getClassLoader() == Parcelable.class.getClassLoader()) {
            i2 = Va;
        } else if (exc instanceof SecurityException) {
            i2 = -1;
        } else if (exc instanceof BadParcelableException) {
            i2 = -2;
        } else if (exc instanceof IllegalArgumentException) {
            i2 = -3;
        } else if (exc instanceof NullPointerException) {
            i2 = -4;
        } else if (exc instanceof IllegalStateException) {
            i2 = -5;
        } else if (exc instanceof NetworkOnMainThreadException) {
            i2 = -6;
        } else if (exc instanceof UnsupportedOperationException) {
            i2 = -7;
        }
        writeInt(i2);
        if (i2 != 0) {
            writeString(exc.getMessage());
            if (i2 == Va) {
                b((Parcelable) exc);
            }
        } else if (exc instanceof RuntimeException) {
            throw ((RuntimeException) exc);
        } else {
            throw new RuntimeException(exc);
        }
    }

    public <T> void b(List<T> list, int i) {
        l(i);
        if (list == null) {
            writeInt(-1);
            return;
        }
        int size = list.size();
        writeInt(size);
        if (size > 0) {
            int i2 = 0;
            int s = s(list.get(0));
            writeInt(s);
            if (s == 1) {
                while (i2 < size) {
                    b((i) list.get(i2));
                    i2++;
                }
            } else if (s == 2) {
                while (i2 < size) {
                    b((Parcelable) list.get(i2));
                    i2++;
                }
            } else if (s == 3) {
                while (i2 < size) {
                    writeSerializable((Serializable) list.get(i2));
                    i2++;
                }
            } else if (s == 4) {
                while (i2 < size) {
                    writeString((String) list.get(i2));
                    i2++;
                }
            } else if (s == 5) {
                while (i2 < size) {
                    writeStrongBinder((IBinder) list.get(i2));
                    i2++;
                }
            }
        }
    }

    public void b(boolean z, int i) {
        l(i);
        writeBoolean(z);
    }

    public void b(boolean z, boolean z2) {
    }

    public void b(byte[] bArr, int i) {
        l(i);
        writeByteArray(bArr);
    }

    public void b(char[] cArr, int i) {
        l(i);
        if (cArr != null) {
            writeInt(r4);
            for (char writeInt : cArr) {
                writeInt(writeInt);
            }
            return;
        }
        writeInt(-1);
    }

    public void b(double[] dArr, int i) {
        l(i);
        writeDoubleArray(dArr);
    }

    public void b(float[] fArr, int i) {
        l(i);
        writeFloatArray(fArr);
    }

    public void b(int[] iArr, int i) {
        l(i);
        writeIntArray(iArr);
    }

    public void b(long[] jArr, int i) {
        l(i);
        writeLongArray(jArr);
    }

    public <T> void b(T[] tArr, int i) {
        l(i);
        writeArray(tArr);
    }

    public void b(boolean[] zArr, int i) {
        l(i);
        writeBooleanArray(zArr);
    }

    public String c(String str, int i) {
        return !k(i) ? str : readString();
    }

    public void c(int i, int i2) {
        l(i2);
        writeInt(i);
    }

    public void d(String str, int i) {
        l(i);
        writeString(str);
    }

    /* access modifiers changed from: protected */
    public abstract boolean k(int i);

    /* access modifiers changed from: protected */
    public abstract void l(int i);

    /* access modifiers changed from: protected */
    public abstract boolean readBoolean();

    /* access modifiers changed from: protected */
    public abstract Bundle readBundle();

    /* access modifiers changed from: protected */
    public abstract byte[] readByteArray();

    /* access modifiers changed from: protected */
    public abstract double readDouble();

    /* access modifiers changed from: protected */
    public abstract float readFloat();

    /* access modifiers changed from: protected */
    public abstract int readInt();

    public int readInt(int i, int i2) {
        return !k(i2) ? i : readInt();
    }

    /* access modifiers changed from: protected */
    public abstract long readLong();

    /* access modifiers changed from: protected */
    public Serializable readSerializable() {
        String readString = readString();
        if (readString == null) {
            return null;
        }
        try {
            return (Serializable) new f(this, new ByteArrayInputStream(readByteArray())).readObject();
        } catch (IOException e2) {
            throw new RuntimeException("VersionedParcelable encountered IOException reading a Serializable object (name = " + readString + ")", e2);
        } catch (ClassNotFoundException e3) {
            throw new RuntimeException("VersionedParcelable encountered ClassNotFoundException reading a Serializable object (name = " + readString + ")", e3);
        }
    }

    /* access modifiers changed from: protected */
    public abstract String readString();

    /* access modifiers changed from: protected */
    public abstract IBinder readStrongBinder();

    /* access modifiers changed from: protected */
    public <T> void writeArray(T[] tArr) {
        if (tArr == null) {
            writeInt(-1);
            return;
        }
        int length = tArr.length;
        writeInt(length);
        if (length > 0) {
            int i = 0;
            int s = s(tArr[0]);
            writeInt(s);
            if (s == 1) {
                while (i < length) {
                    b((i) tArr[i]);
                    i++;
                }
            } else if (s == 2) {
                while (i < length) {
                    b((Parcelable) tArr[i]);
                    i++;
                }
            } else if (s == 3) {
                while (i < length) {
                    writeSerializable((Serializable) tArr[i]);
                    i++;
                }
            } else if (s == 4) {
                while (i < length) {
                    writeString((String) tArr[i]);
                    i++;
                }
            } else if (s == 5) {
                while (i < length) {
                    writeStrongBinder((IBinder) tArr[i]);
                    i++;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract void writeBoolean(boolean z);

    /* access modifiers changed from: protected */
    public void writeBooleanArray(boolean[] zArr) {
        if (zArr != null) {
            writeInt(r0);
            for (boolean z : zArr) {
                writeInt(z ? 1 : 0);
            }
            return;
        }
        writeInt(-1);
    }

    /* access modifiers changed from: protected */
    public abstract void writeBundle(Bundle bundle);

    /* access modifiers changed from: protected */
    public abstract void writeByteArray(byte[] bArr);

    /* access modifiers changed from: protected */
    public abstract void writeByteArray(byte[] bArr, int i, int i2);

    /* access modifiers changed from: protected */
    public abstract void writeDouble(double d2);

    /* access modifiers changed from: protected */
    public void writeDoubleArray(double[] dArr) {
        if (dArr != null) {
            writeInt(r0);
            for (double writeDouble : dArr) {
                writeDouble(writeDouble);
            }
            return;
        }
        writeInt(-1);
    }

    /* access modifiers changed from: protected */
    public abstract void writeFloat(float f2);

    /* access modifiers changed from: protected */
    public void writeFloatArray(float[] fArr) {
        if (fArr != null) {
            writeInt(r0);
            for (float writeFloat : fArr) {
                writeFloat(writeFloat);
            }
            return;
        }
        writeInt(-1);
    }

    /* access modifiers changed from: protected */
    public abstract void writeInt(int i);

    /* access modifiers changed from: protected */
    public void writeIntArray(int[] iArr) {
        if (iArr != null) {
            writeInt(r0);
            for (int writeInt : iArr) {
                writeInt(writeInt);
            }
            return;
        }
        writeInt(-1);
    }

    /* access modifiers changed from: protected */
    public abstract void writeLong(long j);

    /* access modifiers changed from: protected */
    public void writeLongArray(long[] jArr) {
        if (jArr != null) {
            writeInt(r0);
            for (long writeLong : jArr) {
                writeLong(writeLong);
            }
            return;
        }
        writeInt(-1);
    }

    /* access modifiers changed from: protected */
    public void writeNoException() {
        writeInt(0);
    }

    public void writeParcelable(Parcelable parcelable, int i) {
        l(i);
        b(parcelable);
    }

    /* access modifiers changed from: protected */
    public abstract void writeString(String str);

    /* access modifiers changed from: protected */
    public abstract void writeStrongBinder(IBinder iBinder);

    /* access modifiers changed from: protected */
    public abstract void writeStrongInterface(IInterface iInterface);
}
