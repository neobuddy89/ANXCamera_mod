package com.android.camera.fragment.vv;

import com.android.camera.data.DataRepository;
import com.android.camera.data.data.extra.DataItemLive;
import com.android.camera.resource.BaseResourceList;
import com.google.android.apps.photos.api.PhotosOemApi;
import org.json.JSONArray;
import org.json.JSONObject;

public class VVList extends BaseResourceList<VVItem> {
    public static final int TYPE = 1;

    public JSONArray getJsonArray(JSONObject jSONObject) {
        return jSONObject.optJSONArray(PhotosOemApi.PATH_SPECIAL_TYPE_DATA);
    }

    public String getLocalVersion() {
        return DataRepository.dataItemLive().getString(DataItemLive.DATA_VV_VERSION, "");
    }

    public int getResourceType() {
        return 1;
    }

    public void parseExtraData(JSONObject jSONObject) {
        this.version = jSONObject.optString("version");
    }

    public VVItem parseSingleItem(JSONObject jSONObject, int i) {
        VVItem vVItem = new VVItem();
        vVItem.parseSummaryData(jSONObject, i);
        return vVItem;
    }

    public void setLocalVersion(String str) {
        DataRepository.dataItemLive().editor().putString(DataItemLive.DATA_VV_VERSION, str).apply();
    }
}
