package com.android.camera.data.data.config;

import android.text.TextUtils;
import android.util.SparseBooleanArray;
import com.android.camera.R;
import com.android.camera.constant.BeautyConstant;
import com.android.camera.data.data.ComponentData;
import com.android.camera.data.data.ComponentDataItem;
import com.android.camera.log.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Deprecated
public class ComponentConfigBeauty extends ComponentData {
    private static final String[] SWITCHABLE_BEAUTY_LEVELS = {BeautyConstant.LEVEL_CLOSE, BeautyConstant.LEVEL_HIGH, BeautyConstant.LEVEL_XXXHIGH};
    private static final String TAG = "ComponentConfigBeauty";
    private SparseBooleanArray mIsClosed;

    public ComponentConfigBeauty(DataItemConfig dataItemConfig, int i) {
        super(dataItemConfig);
        this.mItems = new ArrayList();
        this.mItems.add(new ComponentDataItem((int) R.drawable.ic_config_beauty_off, (int) R.drawable.ic_config_beauty_off, (int) R.string.pref_camera_beauty, SWITCHABLE_BEAUTY_LEVELS[0]));
        this.mItems.add(new ComponentDataItem((int) R.drawable.ic_config_beauty_off, (int) R.drawable.ic_config_beauty_low, (int) R.string.pref_camera_beauty, SWITCHABLE_BEAUTY_LEVELS[1]));
        this.mItems.add(new ComponentDataItem((int) R.drawable.ic_config_beauty_off, (int) R.drawable.ic_config_beauty_height, (int) R.string.pref_camera_beauty_deep, SWITCHABLE_BEAUTY_LEVELS[2]));
    }

    private static final void logd(String str, int i, String str2) {
        Log.d(TAG, String.format(Locale.ENGLISH, "%s: legacy=%b, mode=%d, value=%s", new Object[]{str, false, Integer.valueOf(i), str2}));
    }

    public void clearClosed() {
        SparseBooleanArray sparseBooleanArray = this.mIsClosed;
        if (sparseBooleanArray != null) {
            sparseBooleanArray.clear();
        }
    }

    public String getComponentValue(int i) {
        if (isClosed(i)) {
            logd("1: getComponentValue()", i, BeautyConstant.LEVEL_CLOSE);
            return BeautyConstant.LEVEL_CLOSE;
        }
        String componentValue = super.getComponentValue(i);
        logd("2: getComponentValue()", i, componentValue);
        logd("3: getComponentValue()", i, componentValue);
        return componentValue;
    }

    public String getDefaultValue(int i) {
        return BeautyConstant.LEVEL_CLOSE;
    }

    public int getDisplayTitleString() {
        return 0;
    }

    public List<ComponentDataItem> getItems() {
        return this.mItems;
    }

    public String getKey(int i) {
        return (i == 161 || i == 162 || i == 169) ? "pref_beautify_level_key_video" : "pref_beautify_level_key_capture";
    }

    public String getNextValue(int i) {
        String componentValue = getComponentValue(i);
        int length = SWITCHABLE_BEAUTY_LEVELS.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (TextUtils.equals(SWITCHABLE_BEAUTY_LEVELS[i2], componentValue)) {
                return SWITCHABLE_BEAUTY_LEVELS[(i2 + 1) % length];
            }
        }
        return getDefaultValue(i);
    }

    public String getPersistValue(int i) {
        return getComponentValue(i);
    }

    public boolean isClosed(int i) {
        if (this.mIsClosed == null) {
            return false;
        }
        if (i == 165) {
            i = 163;
        }
        return this.mIsClosed.get(i);
    }

    public boolean isSwitchOn(int i) {
        return !TextUtils.equals(getComponentValue(i), getDefaultValue(i));
    }

    public void setClosed(boolean z, int i) {
        if (this.mIsClosed == null) {
            this.mIsClosed = new SparseBooleanArray();
        }
        if (i == 165) {
            i = 163;
        }
        this.mIsClosed.put(i, z);
    }

    public void setComponentValue(int i, String str) {
        setClosed(false, i);
        super.setComponentValue(i, str);
    }
}
