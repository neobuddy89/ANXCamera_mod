package com.android.camera.fragment.top;

import com.android.camera.ui.ToggleSwitch;

/* compiled from: lambda */
public final /* synthetic */ class e implements ToggleSwitch.OnCheckedChangeListener {
    public static final /* synthetic */ e INSTANCE = new e();

    private /* synthetic */ e() {
    }

    public final void onCheckedChanged(ToggleSwitch toggleSwitch, boolean z) {
        FragmentTopAlert.a(toggleSwitch, z);
    }
}
