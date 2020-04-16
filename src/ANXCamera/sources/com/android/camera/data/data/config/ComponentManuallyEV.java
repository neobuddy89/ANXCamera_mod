package com.android.camera.data.data.config;

import android.annotation.TargetApi;
import android.icu.text.DecimalFormat;
import android.icu.text.DecimalFormatSymbols;
import android.text.TextUtils;
import android.util.Range;
import com.android.camera.CameraSettings;
import com.android.camera.R;
import com.android.camera.data.DataRepository;
import com.android.camera.data.data.ComponentData;
import com.android.camera.data.data.ComponentDataItem;
import com.android.camera.log.Log;
import com.android.camera.module.loader.camera2.Camera2DataContainer;
import com.android.camera2.CameraCapabilities;
import com.xiaomi.stat.C0159b;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ComponentManuallyEV extends ComponentData {
    private static final float FLOAT_ERROR = 0.001f;
    private static final String TAG = "ComponentManuallyEV";
    private boolean mDisabled;
    private ComponentDataItem[] mFullItems;

    public ComponentManuallyEV(DataItemConfig dataItemConfig) {
        super(dataItemConfig);
    }

    private ComponentDataItem[] getFullItems() {
        String str;
        ComponentDataItem[] componentDataItemArr = this.mFullItems;
        if (componentDataItemArr != null) {
            return componentDataItemArr;
        }
        this.mIsDisplayStringFromResourceId = true;
        this.mIsKeepValueWhenDisabled = true;
        ArrayList arrayList = new ArrayList();
        CameraCapabilities capabilitiesByBogusCameraId = Camera2DataContainer.getInstance().getCapabilitiesByBogusCameraId(DataRepository.dataItemGlobal().getCurrentCameraId(), DataRepository.dataItemGlobal().getCurrentMode());
        Range<Integer> exposureCompensationRange = capabilitiesByBogusCameraId.getExposureCompensationRange();
        float intValue = ((float) exposureCompensationRange.getUpper().intValue()) * capabilitiesByBogusCameraId.getExposureCompensationStep();
        DecimalFormat decimalFormat = new DecimalFormat(C0159b.k);
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.ENGLISH);
        decimalFormatSymbols.setDecimalSeparator('.');
        decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
        float exposureCompensationStep = capabilitiesByBogusCameraId.getExposureCompensationStep() * 2.0f;
        for (float intValue2 = ((float) exposureCompensationRange.getLower().intValue()) * capabilitiesByBogusCameraId.getExposureCompensationStep(); intValue2 < FLOAT_ERROR + intValue; intValue2 += exposureCompensationStep) {
            String format = decimalFormat.format((double) intValue2);
            if (format.equals("-0.0") || format.equals(C0159b.k)) {
                format = "0";
            }
            if (intValue2 > 0.01f) {
                str = "+" + format;
            } else {
                str = format;
            }
            arrayList.add(new ComponentDataItem(-1, -1, str, format));
        }
        this.mFullItems = (ComponentDataItem[]) arrayList.toArray(new ComponentDataItem[arrayList.size()]);
        return this.mFullItems;
    }

    public boolean checkValueValid(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            for (ComponentDataItem componentDataItem : getFullItems()) {
                if (componentDataItem.mValue.equals(str)) {
                    return true;
                }
            }
        }
        Log.d(TAG, "checkValueValid: invalid value!");
        return false;
    }

    public boolean disableUpdate() {
        return this.mDisabled;
    }

    public String getComponentValue(int i) {
        String componentValue = super.getComponentValue(i);
        List<ComponentDataItem> items = getItems();
        if (items.isEmpty()) {
            return componentValue;
        }
        String str = items.get(items.size() - 1).mValue;
        if (Float.parseFloat(componentValue) <= Float.parseFloat(str)) {
            return componentValue;
        }
        setComponentValue(i, str);
        return str;
    }

    public String getDefaultValue(int i) {
        return "0";
    }

    public int getDisplayTitleString() {
        return R.string.pref_camera_manually_exposure_value_abbr;
    }

    public List<ComponentDataItem> getItems() {
        return this.mItems;
    }

    public String getKey(int i) {
        return i != 167 ? CameraSettings.KEY_QC_PRO_VIDEO_EXPOSURE_VALUE : CameraSettings.KEY_QC_MANUAL_EXPOSURE_VALUE;
    }

    public int getValueDisplayString(int i) {
        String componentValue = getComponentValue(i);
        for (ComponentDataItem componentDataItem : getFullItems()) {
            if (componentDataItem.mValue.equals(componentValue)) {
                return componentDataItem.mDisplayNameRes;
            }
        }
        throw new IllegalArgumentException("invalid value");
    }

    @TargetApi(21)
    public List<ComponentDataItem> reInit(int i, CameraCapabilities cameraCapabilities) {
        if (this.mItems == null) {
            this.mItems = new ArrayList();
        } else {
            this.mItems.clear();
        }
        if (cameraCapabilities == null) {
            return this.mItems;
        }
        if (i == 167 || i == 180) {
            ComponentDataItem[] fullItems = getFullItems();
            this.mItems.add(fullItems[0]);
            Range<Integer> exposureCompensationRange = cameraCapabilities.getExposureCompensationRange();
            if (exposureCompensationRange != null) {
                float exposureCompensationStep = cameraCapabilities.getExposureCompensationStep() * 2.0f;
                float intValue = ((float) exposureCompensationRange.getLower().intValue()) * exposureCompensationStep;
                float intValue2 = ((float) exposureCompensationRange.getUpper().intValue()) * exposureCompensationStep;
                for (int i2 = 1; i2 < fullItems.length; i2++) {
                    ComponentDataItem componentDataItem = fullItems[i2];
                    float parseFloat = Float.parseFloat(componentDataItem.mValue);
                    if (intValue <= parseFloat && parseFloat <= intValue2) {
                        this.mItems.add(componentDataItem);
                    }
                }
            }
        }
        return this.mItems;
    }

    public void resetComponentValue(int i) {
        super.resetComponentValue(i);
        setComponentValue(i, getDefaultValue(i));
    }

    public void setDisabled(boolean z) {
        this.mDisabled = z;
    }
}
