package com.ss.android.vesdk.settings;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.stat.C0154a;

public enum VEVideoEncodeProfile implements Parcelable {
    ENCODE_PROFILE_UNKNOWN,
    ENCODE_PROFILE_BASELINE,
    ENCODE_PROFILE_MAIN,
    ENCODE_PROFILE_HIGH;
    
    public static final Parcelable.Creator<VEVideoEncodeProfile> CREATOR = null;

    static {
        CREATOR = new Parcelable.Creator<VEVideoEncodeProfile>() {
            public VEVideoEncodeProfile createFromParcel(Parcel parcel) {
                return VEVideoEncodeProfile.values()[parcel.readInt()];
            }

            public VEVideoEncodeProfile[] newArray(int i) {
                return new VEVideoEncodeProfile[i];
            }
        };
    }

    public static VEVideoEncodeProfile valueOfString(String str) {
        VEVideoEncodeProfile vEVideoEncodeProfile = ENCODE_PROFILE_UNKNOWN;
        return !TextUtils.isEmpty(str) ? "baseline".equals(str) ? ENCODE_PROFILE_BASELINE : C0154a.f314d.equals(str) ? ENCODE_PROFILE_MAIN : "high".equals(str) ? ENCODE_PROFILE_HIGH : vEVideoEncodeProfile : vEVideoEncodeProfile;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(ordinal());
    }
}
