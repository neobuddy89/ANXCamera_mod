package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.RestrictTo;
import android.util.SparseIntArray;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* compiled from: VersionedParcelParcel */
class g extends VersionedParcel {
    private static final boolean DEBUG = false;
    private static final String TAG = "VersionedParcelParcel";
    private final SparseIntArray _a;
    private int bb;
    private int eb;
    private final int mEnd;
    private final int mOffset;
    private final Parcel mParcel;
    private final String mPrefix;

    g(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "");
    }

    g(Parcel parcel, int i, int i2, String str) {
        this._a = new SparseIntArray();
        this.bb = -1;
        this.eb = 0;
        this.mParcel = parcel;
        this.mOffset = i;
        this.mEnd = i2;
        this.eb = this.mOffset;
        this.mPrefix = str;
    }

    private int P(int i) {
        int readInt;
        do {
            int i2 = this.eb;
            if (i2 >= this.mEnd) {
                return -1;
            }
            this.mParcel.setDataPosition(i2);
            int readInt2 = this.mParcel.readInt();
            readInt = this.mParcel.readInt();
            this.eb += readInt2;
        } while (readInt != i);
        return this.mParcel.dataPosition();
    }

    public void Fa() {
        int i = this.bb;
        if (i >= 0) {
            int i2 = this._a.get(i);
            int dataPosition = this.mParcel.dataPosition();
            this.mParcel.setDataPosition(i2);
            this.mParcel.writeInt(dataPosition - i2);
            this.mParcel.setDataPosition(dataPosition);
        }
    }

    /* access modifiers changed from: protected */
    public VersionedParcel Ga() {
        Parcel parcel = this.mParcel;
        int dataPosition = parcel.dataPosition();
        int i = this.eb;
        if (i == this.mOffset) {
            i = this.mEnd;
        }
        return new g(parcel, dataPosition, i, this.mPrefix + "  ");
    }

    public <T extends Parcelable> T Na() {
        return this.mParcel.readParcelable(g.class.getClassLoader());
    }

    public void b(Parcelable parcelable) {
        this.mParcel.writeParcelable(parcelable, 0);
    }

    public boolean k(int i) {
        int P = P(i);
        if (P == -1) {
            return false;
        }
        this.mParcel.setDataPosition(P);
        return true;
    }

    public void l(int i) {
        Fa();
        this.bb = i;
        this._a.put(i, this.mParcel.dataPosition());
        writeInt(0);
        writeInt(i);
    }

    public boolean readBoolean() {
        return this.mParcel.readInt() != 0;
    }

    public Bundle readBundle() {
        return this.mParcel.readBundle(g.class.getClassLoader());
    }

    public byte[] readByteArray() {
        int readInt = this.mParcel.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.mParcel.readByteArray(bArr);
        return bArr;
    }

    public double readDouble() {
        return this.mParcel.readDouble();
    }

    public float readFloat() {
        return this.mParcel.readFloat();
    }

    public int readInt() {
        return this.mParcel.readInt();
    }

    public long readLong() {
        return this.mParcel.readLong();
    }

    public String readString() {
        return this.mParcel.readString();
    }

    public IBinder readStrongBinder() {
        return this.mParcel.readStrongBinder();
    }

    public void writeBoolean(boolean z) {
        this.mParcel.writeInt(z ? 1 : 0);
    }

    public void writeBundle(Bundle bundle) {
        this.mParcel.writeBundle(bundle);
    }

    public void writeByteArray(byte[] bArr) {
        if (bArr != null) {
            this.mParcel.writeInt(bArr.length);
            this.mParcel.writeByteArray(bArr);
            return;
        }
        this.mParcel.writeInt(-1);
    }

    public void writeByteArray(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            this.mParcel.writeInt(bArr.length);
            this.mParcel.writeByteArray(bArr, i, i2);
            return;
        }
        this.mParcel.writeInt(-1);
    }

    public void writeDouble(double d2) {
        this.mParcel.writeDouble(d2);
    }

    public void writeFloat(float f2) {
        this.mParcel.writeFloat(f2);
    }

    public void writeInt(int i) {
        this.mParcel.writeInt(i);
    }

    public void writeLong(long j) {
        this.mParcel.writeLong(j);
    }

    public void writeString(String str) {
        this.mParcel.writeString(str);
    }

    public void writeStrongBinder(IBinder iBinder) {
        this.mParcel.writeStrongBinder(iBinder);
    }

    public void writeStrongInterface(IInterface iInterface) {
        this.mParcel.writeStrongInterface(iInterface);
    }
}
