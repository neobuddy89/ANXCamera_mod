package com.android.camera.data.data.runing;

import com.android.camera.CameraSettings;
import com.android.camera.R;
import com.android.camera.data.DataRepository;
import com.android.camera.data.data.ComponentData;
import com.android.camera.data.data.ComponentDataItem;
import com.android.camera.module.loader.camera2.Camera2DataContainer;
import java.util.ArrayList;
import java.util.List;

public class ComponentRunningLighting extends ComponentData {
    public ComponentRunningLighting(DataItemRunning dataItemRunning) {
        super(dataItemRunning);
    }

    public String getDefaultValue(int i) {
        return "0";
    }

    public int getDisplayTitleString() {
        return 0;
    }

    public List<ComponentDataItem> getItems() {
        if (this.mItems == null) {
            initItems();
        }
        return this.mItems;
    }

    public String getKey(int i) {
        return "pref_portrait_lighting";
    }

    public void initItems() {
        if (this.mItems == null) {
            this.mItems = new ArrayList();
        } else {
            this.mItems.clear();
        }
        this.mItems.add(new ComponentDataItem((int) R.drawable.ic_lighting_none, (int) R.drawable.ic_lighting_none, (int) R.string.lighting_pattern_null, "0"));
        if (CameraSettings.isBackCamera() || Camera2DataContainer.getInstance().getBokehFrontCameraId() != -1) {
            this.mItems.add(new ComponentDataItem((int) R.drawable.ic_lighting_nature, (int) R.drawable.ic_lighting_nature, (int) R.string.lighting_pattern_nature, "1"));
        }
        this.mItems.add(new ComponentDataItem((int) R.drawable.ic_lighting_stage, (int) R.drawable.ic_lighting_stage, (int) R.string.lighting_pattern_stage, "2"));
        this.mItems.add(new ComponentDataItem((int) R.drawable.ic_lighting_movie, (int) R.drawable.ic_lighting_movie, (int) R.string.lighting_pattern_movie, "3"));
        this.mItems.add(new ComponentDataItem((int) R.drawable.ic_lighting_rainbow, (int) R.drawable.ic_lighting_rainbow, (int) R.string.lighting_pattern_rainbow, "4"));
        this.mItems.add(new ComponentDataItem((int) R.drawable.ic_lighting_shutter, (int) R.drawable.ic_lighting_shutter, (int) R.string.lighting_pattern_shutter, "5"));
        this.mItems.add(new ComponentDataItem((int) R.drawable.ic_lighting_dot, (int) R.drawable.ic_lighting_dot, (int) R.string.lighting_pattern_dot, "6"));
        this.mItems.add(new ComponentDataItem((int) R.drawable.ic_lighting_leaf, (int) R.drawable.ic_lighting_leaf, (int) R.string.lighting_pattern_leaf, "7"));
        if (DataRepository.dataItemFeature().ne()) {
            this.mItems.add(new ComponentDataItem((int) R.drawable.ic_lighting_holi, (int) R.drawable.ic_lighting_holi, (int) R.string.lighting_pattern_holi, "8"));
        }
    }

    public boolean isSwitchOn(int i) {
        return !getComponentValue(i).equals("0");
    }
}
