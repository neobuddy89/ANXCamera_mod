package com.google.firebase.iid;

import android.os.Bundle;
import com.google.android.apps.photos.api.PhotosOemApi;

/* compiled from: com.google.firebase:firebase-iid@@20.0.2 */
final class zzaj extends zzah<Bundle> {
    zzaj(int i, int i2, Bundle bundle) {
        super(i, 1, bundle);
    }

    /* access modifiers changed from: package-private */
    public final void zza(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle(PhotosOemApi.PATH_SPECIAL_TYPE_DATA);
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        zza(bundle2);
    }

    /* access modifiers changed from: package-private */
    public final boolean zza() {
        return false;
    }
}
