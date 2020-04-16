package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: androidx.versionedparcelable.ParcelImpl  reason: case insensitive filesystem */
public class C0172ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<C0172ParcelImpl> CREATOR = new Parcelable.Creator<C0172ParcelImpl>() {
        public C0172ParcelImpl createFromParcel(Parcel parcel) {
            return new C0172ParcelImpl(parcel);
        }

        public C0172ParcelImpl[] newArray(int i) {
            return new C0172ParcelImpl[i];
        }
    };
    private final VersionedParcelable mParcel;

    protected C0172ParcelImpl(Parcel parcel) {
        this.mParcel = new VersionedParcelParcel(parcel).readVersionedParcelable();
    }

    public C0172ParcelImpl(VersionedParcelable versionedParcelable) {
        this.mParcel = versionedParcelable;
    }

    public int describeContents() {
        return 0;
    }

    public <T extends VersionedParcelable> T getVersionedParcel() {
        return this.mParcel;
    }

    public void writeToParcel(Parcel parcel, int i) {
        new VersionedParcelParcel(parcel).writeVersionedParcelable(this.mParcel);
    }
}
