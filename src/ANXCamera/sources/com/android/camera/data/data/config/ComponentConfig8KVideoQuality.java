package com.android.camera.data.data.config;

import android.support.annotation.NonNull;
import com.android.camera.R;
import com.android.camera.data.data.ComponentData;
import com.android.camera.data.data.ComponentDataItem;
import com.android.camera.data.provider.DataProvider;
import com.android.camera2.CameraCapabilities;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComponentConfig8KVideoQuality extends ComponentData {
    public ComponentConfig8KVideoQuality(DataItemConfig dataItemConfig) {
        super(dataItemConfig);
    }

    @NonNull
    public String getDefaultValue(int i) {
        return null;
    }

    public int getDisplayTitleString() {
        return R.string.video_ultra_clear_tip_8k;
    }

    public List<ComponentDataItem> getItems() {
        return this.mItems;
    }

    public String getKey(int i) {
        if (i != 162 && i != 180) {
            return "pref_camera_video_8k_unsupported";
        }
        return "pref_camera_video_8k_" + i;
    }

    public boolean isEnabled(int i) {
        return this.mParentDataItem.getBoolean(getKey(i), false);
    }

    public void reInit(int i, int i2, CameraCapabilities cameraCapabilities) {
        ArrayList arrayList = new ArrayList();
        if (i == 162 || i == 180) {
            arrayList.add(new ComponentDataItem((int) R.drawable.ic_config_video_8k_highlight, (int) R.drawable.ic_config_video_8k_normal, (int) R.string.video_ultra_clear_tip_8k, "on"));
        }
        this.mItems = Collections.unmodifiableList(arrayList);
    }

    public void reset(DataProvider.ProviderEditor providerEditor) {
        providerEditor.putBoolean(getKey(162), false);
        providerEditor.putBoolean(getKey(180), false);
    }

    public void setEnabled(int i, boolean z) {
        this.mParentDataItem.putBoolean(getKey(i), z);
    }
}
