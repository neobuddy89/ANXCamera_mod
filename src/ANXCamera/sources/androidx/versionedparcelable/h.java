package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcelable;
import android.support.annotation.RestrictTo;
import android.support.v4.internal.view.SupportMenu;
import android.util.SparseArray;
import androidx.versionedparcelable.VersionedParcel;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Set;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* compiled from: VersionedParcelStream */
class h extends VersionedParcel {
    private static final int TYPE_BOOLEAN = 5;
    private static final int TYPE_DOUBLE = 7;
    private static final int TYPE_FLOAT = 13;
    private static final int TYPE_INT = 9;
    private static final int TYPE_LONG = 11;
    private static final int TYPE_NULL = 0;
    private static final int TYPE_STRING = 3;
    private static final int TYPE_STRING_ARRAY = 4;
    private static final Charset UTF_16 = Charset.forName("UTF-16");
    private static final int mb = 1;
    private static final int nb = 2;
    private static final int ob = 6;
    private static final int pb = 8;
    private static final int qb = 10;
    private static final int rb = 12;
    private static final int sb = 14;
    private final DataInputStream fb;
    private final DataOutputStream gb;
    private final SparseArray<b> hb = new SparseArray<>();
    private DataInputStream ib;
    private DataOutputStream jb;
    private a kb;
    private boolean lb;

    /* compiled from: VersionedParcelStream */
    private static class a {
        private final DataOutputStream mTarget;
        /* access modifiers changed from: private */
        public final ByteArrayOutputStream tb = new ByteArrayOutputStream();
        /* access modifiers changed from: private */
        public final DataOutputStream ub = new DataOutputStream(this.tb);
        private final int vb;

        a(int i, DataOutputStream dataOutputStream) {
            this.vb = i;
            this.mTarget = dataOutputStream;
        }

        /* access modifiers changed from: package-private */
        public void Pa() throws IOException {
            this.ub.flush();
            int size = this.tb.size();
            this.mTarget.writeInt((this.vb << 16) | (size >= 65535 ? 65535 : size));
            if (size >= 65535) {
                this.mTarget.writeInt(size);
            }
            this.tb.writeTo(this.mTarget);
        }
    }

    /* compiled from: VersionedParcelStream */
    private static class b {
        /* access modifiers changed from: private */
        public final DataInputStream mInputStream;
        private final int mSize;
        /* access modifiers changed from: private */
        public final int vb;

        b(int i, int i2, DataInputStream dataInputStream) throws IOException {
            this.mSize = i2;
            this.vb = i;
            byte[] bArr = new byte[this.mSize];
            dataInputStream.readFully(bArr);
            this.mInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        }
    }

    public h(InputStream inputStream, OutputStream outputStream) {
        DataOutputStream dataOutputStream = null;
        this.fb = inputStream != null ? new DataInputStream(inputStream) : null;
        this.gb = outputStream != null ? new DataOutputStream(outputStream) : dataOutputStream;
        this.ib = this.fb;
        this.jb = this.gb;
    }

    private void a(int i, String str, Bundle bundle) {
        switch (i) {
            case 0:
                bundle.putParcelable(str, (Parcelable) null);
                return;
            case 1:
                bundle.putBundle(str, readBundle());
                return;
            case 2:
                bundle.putBundle(str, readBundle());
                return;
            case 3:
                bundle.putString(str, readString());
                return;
            case 4:
                bundle.putStringArray(str, (String[]) a(new String[0]));
                return;
            case 5:
                bundle.putBoolean(str, readBoolean());
                return;
            case 6:
                bundle.putBooleanArray(str, Ia());
                return;
            case 7:
                bundle.putDouble(str, readDouble());
                return;
            case 8:
                bundle.putDoubleArray(str, Ja());
                return;
            case 9:
                bundle.putInt(str, readInt());
                return;
            case 10:
                bundle.putIntArray(str, La());
                return;
            case 11:
                bundle.putLong(str, readLong());
                return;
            case 12:
                bundle.putLongArray(str, Ma());
                return;
            case 13:
                bundle.putFloat(str, readFloat());
                return;
            case 14:
                bundle.putFloatArray(str, Ka());
                return;
            default:
                throw new RuntimeException("Unknown type " + i);
        }
    }

    private void writeObject(Object obj) {
        if (obj == null) {
            writeInt(0);
        } else if (obj instanceof Bundle) {
            writeInt(1);
            writeBundle((Bundle) obj);
        } else if (obj instanceof String) {
            writeInt(3);
            writeString((String) obj);
        } else if (obj instanceof String[]) {
            writeInt(4);
            writeArray((String[]) obj);
        } else if (obj instanceof Boolean) {
            writeInt(5);
            writeBoolean(((Boolean) obj).booleanValue());
        } else if (obj instanceof boolean[]) {
            writeInt(6);
            writeBooleanArray((boolean[]) obj);
        } else if (obj instanceof Double) {
            writeInt(7);
            writeDouble(((Double) obj).doubleValue());
        } else if (obj instanceof double[]) {
            writeInt(8);
            writeDoubleArray((double[]) obj);
        } else if (obj instanceof Integer) {
            writeInt(9);
            writeInt(((Integer) obj).intValue());
        } else if (obj instanceof int[]) {
            writeInt(10);
            writeIntArray((int[]) obj);
        } else if (obj instanceof Long) {
            writeInt(11);
            writeLong(((Long) obj).longValue());
        } else if (obj instanceof long[]) {
            writeInt(12);
            writeLongArray((long[]) obj);
        } else if (obj instanceof Float) {
            writeInt(13);
            writeFloat(((Float) obj).floatValue());
        } else if (obj instanceof float[]) {
            writeInt(14);
            writeFloatArray((float[]) obj);
        } else {
            throw new IllegalArgumentException("Unsupported type " + obj.getClass());
        }
    }

    public void Fa() {
        a aVar = this.kb;
        if (aVar != null) {
            try {
                if (aVar.tb.size() != 0) {
                    this.kb.Pa();
                }
                this.kb = null;
            } catch (IOException e2) {
                throw new VersionedParcel.ParcelException(e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public VersionedParcel Ga() {
        return new h(this.ib, this.jb);
    }

    public boolean Ha() {
        return true;
    }

    public <T extends Parcelable> T Na() {
        return null;
    }

    public void b(Parcelable parcelable) {
        if (!this.lb) {
            throw new RuntimeException("Parcelables cannot be written to an OutputStream");
        }
    }

    public void b(boolean z, boolean z2) {
        if (z) {
            this.lb = z2;
            return;
        }
        throw new RuntimeException("Serialization of this object is not allowed");
    }

    public boolean k(int i) {
        b bVar = this.hb.get(i);
        if (bVar != null) {
            this.hb.remove(i);
            this.ib = bVar.mInputStream;
            return true;
        }
        while (true) {
            try {
                int readInt = this.fb.readInt();
                int i2 = readInt & SupportMenu.USER_MASK;
                if (i2 == 65535) {
                    i2 = this.fb.readInt();
                }
                b bVar2 = new b((readInt >> 16) & SupportMenu.USER_MASK, i2, this.fb);
                if (bVar2.vb == i) {
                    this.ib = bVar2.mInputStream;
                    return true;
                }
                this.hb.put(bVar2.vb, bVar2);
            } catch (IOException unused) {
                return false;
            }
        }
    }

    public void l(int i) {
        Fa();
        this.kb = new a(i, this.gb);
        this.jb = this.kb.ub;
    }

    public boolean readBoolean() {
        try {
            return this.ib.readBoolean();
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    public Bundle readBundle() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        for (int i = 0; i < readInt; i++) {
            a(readInt(), readString(), bundle);
        }
        return bundle;
    }

    public byte[] readByteArray() {
        try {
            int readInt = this.ib.readInt();
            if (readInt <= 0) {
                return null;
            }
            byte[] bArr = new byte[readInt];
            this.ib.readFully(bArr);
            return bArr;
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    public double readDouble() {
        try {
            return this.ib.readDouble();
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    public float readFloat() {
        try {
            return this.ib.readFloat();
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    public int readInt() {
        try {
            return this.ib.readInt();
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    public long readLong() {
        try {
            return this.ib.readLong();
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    public String readString() {
        try {
            int readInt = this.ib.readInt();
            if (readInt <= 0) {
                return null;
            }
            byte[] bArr = new byte[readInt];
            this.ib.readFully(bArr);
            return new String(bArr, UTF_16);
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    public IBinder readStrongBinder() {
        return null;
    }

    public void writeBoolean(boolean z) {
        try {
            this.jb.writeBoolean(z);
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    public void writeBundle(Bundle bundle) {
        if (bundle != null) {
            try {
                Set<String> keySet = bundle.keySet();
                this.jb.writeInt(keySet.size());
                for (String str : keySet) {
                    writeString(str);
                    writeObject(bundle.get(str));
                }
            } catch (IOException e2) {
                throw new VersionedParcel.ParcelException(e2);
            }
        } else {
            this.jb.writeInt(-1);
        }
    }

    public void writeByteArray(byte[] bArr) {
        if (bArr != null) {
            try {
                this.jb.writeInt(bArr.length);
                this.jb.write(bArr);
            } catch (IOException e2) {
                throw new VersionedParcel.ParcelException(e2);
            }
        } else {
            this.jb.writeInt(-1);
        }
    }

    public void writeByteArray(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            try {
                this.jb.writeInt(i2);
                this.jb.write(bArr, i, i2);
            } catch (IOException e2) {
                throw new VersionedParcel.ParcelException(e2);
            }
        } else {
            this.jb.writeInt(-1);
        }
    }

    public void writeDouble(double d2) {
        try {
            this.jb.writeDouble(d2);
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    public void writeFloat(float f2) {
        try {
            this.jb.writeFloat(f2);
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    public void writeInt(int i) {
        try {
            this.jb.writeInt(i);
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    public void writeLong(long j) {
        try {
            this.jb.writeLong(j);
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    public void writeString(String str) {
        if (str != null) {
            try {
                byte[] bytes = str.getBytes(UTF_16);
                this.jb.writeInt(bytes.length);
                this.jb.write(bytes);
            } catch (IOException e2) {
                throw new VersionedParcel.ParcelException(e2);
            }
        } else {
            this.jb.writeInt(-1);
        }
    }

    public void writeStrongBinder(IBinder iBinder) {
        if (!this.lb) {
            throw new RuntimeException("Binders cannot be written to an OutputStream");
        }
    }

    public void writeStrongInterface(IInterface iInterface) {
        if (!this.lb) {
            throw new RuntimeException("Binders cannot be written to an OutputStream");
        }
    }
}
