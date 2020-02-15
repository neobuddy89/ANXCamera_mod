package com.android.camera;

import com.android.camera.ThermalDetector;

/* compiled from: lambda */
public final /* synthetic */ class a implements ThermalDetector.OnThermalNotificationListener {
    private final /* synthetic */ Camera wb;

    public /* synthetic */ a(Camera camera) {
        this.wb = camera;
    }

    public final void onThermalNotification(int i) {
        this.wb.j(i);
    }
}
