package com.android.camera.data.data.setting;

import android.content.Context;
import com.android.camera.data.data.ComponentMultiple;
import com.android.camera.data.data.DataItemBase;
import com.android.camera2.CameraCapabilities;

public class ComponentSettingMultipleVideo extends ComponentMultiple {
    public <D extends DataItemBase> ComponentSettingMultipleVideo(D d2) {
        super(d2);
    }

    public int getDisplayTitleString() {
        return 0;
    }

    public void initTypeElements(Context context, int i, CameraCapabilities cameraCapabilities, int i2) {
    }
}
