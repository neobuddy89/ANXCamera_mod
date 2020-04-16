package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: ParcelImpl */
class d implements Parcelable.Creator<C0172ParcelImpl> {
    d() {
    }

    public C0172ParcelImpl createFromParcel(Parcel parcel) {
        return new C0172ParcelImpl(parcel);
    }

    public C0172ParcelImpl[] newArray(int i) {
        return new C0172ParcelImpl[i];
    }
}
