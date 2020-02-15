package android.os.statistics;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class E2EScenarioPayload implements Parcelable, Cloneable, Serializable {
    public static final Parcelable.Creator<E2EScenarioPayload> CREATOR = new Parcelable.Creator<E2EScenarioPayload>() {
        public E2EScenarioPayload createFromParcel(Parcel parcel) {
            return new E2EScenarioPayload(parcel);
        }

        public E2EScenarioPayload[] newArray(int i) {
            return new E2EScenarioPayload[i];
        }
    };
    private static final long serialVersionUID = 1;
    private final HashMap<String, String> values = new HashMap<>();

    public E2EScenarioPayload() {
    }

    public E2EScenarioPayload(Bundle bundle) {
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                if (!TextUtils.isEmpty(str)) {
                    String string = bundle.getString(str);
                    this.values.put(str, string == null ? "" : string);
                }
            }
        }
    }

    public E2EScenarioPayload(Parcel parcel) {
        HashMap readHashMap = parcel.readHashMap((ClassLoader) null);
        if (readHashMap != null) {
            for (Map.Entry entry : readHashMap.entrySet()) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                if (!TextUtils.isEmpty(str)) {
                    this.values.put(str, str2 == null ? "" : str2);
                }
            }
        }
    }

    public Object clone() {
        E2EScenarioPayload e2EScenarioPayload = new E2EScenarioPayload();
        e2EScenarioPayload.values.putAll(this.values);
        return e2EScenarioPayload;
    }

    public int describeContents() {
        return 0;
    }

    public String get(String str) {
        return this.values.get(str);
    }

    public boolean isEmpty() {
        return this.values.isEmpty();
    }

    public void mergeFrom(E2EScenarioPayload e2EScenarioPayload) {
        this.values.putAll(e2EScenarioPayload.values);
    }

    public void put(Object obj, Object obj2) {
        String str = null;
        String obj3 = obj == null ? null : obj.toString();
        if (obj2 != null) {
            str = obj2.toString();
        }
        if (!TextUtils.isEmpty(obj3)) {
            this.values.put(obj3, str == null ? "" : str);
        }
    }

    public void putAll(Map map) {
        if (map != null) {
            for (Object next : map.entrySet()) {
                put(((Map.Entry) next).getKey(), ((Map.Entry) next).getValue());
            }
        }
    }

    public void putValues(Object... objArr) {
        if (objArr != null) {
            if (objArr.length % 2 != 1) {
                for (int i = 0; i < objArr.length / 2; i++) {
                    put(objArr[i * 2], objArr[(i * 2) + 1]);
                }
                return;
            }
            throw new IllegalArgumentException("length of keyandvalues should be even");
        }
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry next : this.values.entrySet()) {
                jSONObject.put((String) next.getKey(), next.getValue());
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public void writeToBundle(Bundle bundle) {
        for (Map.Entry next : this.values.entrySet()) {
            bundle.putString((String) next.getKey(), (String) next.getValue());
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this.values);
    }
}
