package android.os.statistics;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public final class E2EScenario implements Parcelable, Serializable {
    public static final Parcelable.Creator<E2EScenario> CREATOR = new Parcelable.Creator<E2EScenario>() {
        public E2EScenario createFromParcel(Parcel parcel) {
            return new E2EScenario(parcel);
        }

        public E2EScenario[] newArray(int i) {
            return new E2EScenario[i];
        }
    };
    public static final String DEFAULT_CATEGORY = "default";
    private static final long serialVersionUID = 1;
    public String category;
    public String name;
    public String namespace;

    protected E2EScenario() {
        this.namespace = "";
        this.category = "";
        this.name = "";
    }

    public E2EScenario(Parcel parcel) {
        String readString = parcel.readString();
        String readString2 = parcel.readString();
        String readString3 = parcel.readString();
        String str = "";
        this.namespace = readString == null ? str : readString;
        this.category = readString2 == null ? str : readString2;
        this.name = readString3 != null ? readString3 : str;
    }

    public E2EScenario(String str, String str2, String str3) {
        String str4 = "";
        this.namespace = str == null ? str4 : str;
        this.category = str2 == null ? str4 : str2;
        this.name = str3 != null ? str3 : str4;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof E2EScenario)) {
            return false;
        }
        E2EScenario e2EScenario = (E2EScenario) obj;
        return this.namespace.equals(e2EScenario.namespace) && this.category.equals(e2EScenario.category) && this.name.equals(e2EScenario.name);
    }

    public int hashCode() {
        return this.namespace.hashCode() + this.category.hashCode() + this.name.hashCode();
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.name);
    }

    public void normalize(String str) {
        if (TextUtils.isEmpty(this.namespace)) {
            this.namespace = TextUtils.isEmpty(str) ? "android" : str;
        }
        if (TextUtils.isEmpty(this.category)) {
            this.category = DEFAULT_CATEGORY;
        }
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("namespace", this.namespace);
            jSONObject.put(EffectConfiguration.KEY_CATEGORY, this.category);
            jSONObject.put("name", this.name);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.namespace);
        parcel.writeString(this.category);
        parcel.writeString(this.name);
    }
}
