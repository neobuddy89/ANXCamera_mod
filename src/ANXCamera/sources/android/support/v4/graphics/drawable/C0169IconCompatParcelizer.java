package android.support.v4.graphics.drawable;

import androidx.core.graphics.drawable.IconCompat;
import androidx.core.graphics.drawable.IconCompatParcelizer;
import androidx.versionedparcelable.C0173VersionedParcel;

/* renamed from: android.support.v4.graphics.drawable.IconCompatParcelizer  reason: case insensitive filesystem */
public final class C0169IconCompatParcelizer extends IconCompatParcelizer {
    public static IconCompat read(C0173VersionedParcel versionedParcel) {
        return IconCompatParcelizer.read(versionedParcel);
    }

    public static void write(IconCompat iconCompat, C0173VersionedParcel versionedParcel) {
        IconCompatParcelizer.write(iconCompat, versionedParcel);
    }
}
