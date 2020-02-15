package com.android.camera.data.data.config;

import android.support.annotation.NonNull;
import com.android.camera.R;
import com.android.camera.data.data.ComponentData;
import com.android.camera.data.data.ComponentDataItem;
import com.android.camera2.CameraCapabilities;
import java.util.ArrayList;
import java.util.List;

public class ComponentConfigAuxiliary extends ComponentData {
    public static final String A_CLOSE = "close";
    public static final String A_EXPOSURE_FEEDBACK = "exposure_feedback";
    public static final String A_FOCUS_PEAK = "peak_focus";

    public ComponentConfigAuxiliary(DataItemConfig dataItemConfig) {
        super(dataItemConfig);
    }

    @NonNull
    public String getDefaultValue(int i) {
        return "close";
    }

    public int getDisplayTitleString() {
        return R.string.pref_camera_auxiliary_title;
    }

    public List<ComponentDataItem> getItems() {
        return this.mItems;
    }

    public String getKey(int i) {
        if (i == 167 || i == 180) {
            return "pref_camera_exposure_feedback";
        }
        return null;
    }

    public int getValueSelectedDrawable(int i) {
        String componentValue = getComponentValue(i);
        return A_FOCUS_PEAK.equals(componentValue) ? R.drawable.ic_config_focus_peak_on : A_EXPOSURE_FEEDBACK.equals(componentValue) ? R.drawable.ic_config_exposure_feedback_on : R.drawable.ic_config_auxiliary;
    }

    public int getValueSelectedStringIdIgnoreClose(int i) {
        String componentValue = getComponentValue(i);
        return A_FOCUS_PEAK.equals(componentValue) ? R.string.auxiliary_focus_peak_status : A_EXPOSURE_FEEDBACK.equals(componentValue) ? R.string.auxiliary_exposure_feedback_status : R.string.auxiliary_close_status;
    }

    public List<ComponentDataItem> reInit(int i, CameraCapabilities cameraCapabilities) {
        if (this.mItems == null) {
            this.mItems = new ArrayList();
        } else {
            this.mItems.clear();
        }
        if (i == 180) {
            this.mItems.add(new ComponentDataItem(-1, -1, (int) R.string.pref_camera_auxiliary_close, "close"));
            this.mItems.add(new ComponentDataItem(-1, -1, (int) R.string.pref_camera_auxiliary_focus_peak, A_FOCUS_PEAK));
            this.mItems.add(new ComponentDataItem(-1, -1, (int) R.string.pref_camera_auxiliary_exposure_feedback, A_EXPOSURE_FEEDBACK));
        }
        return this.mItems;
    }
}
