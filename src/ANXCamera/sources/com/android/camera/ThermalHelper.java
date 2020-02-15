package com.android.camera;

import android.content.Intent;
import android.util.Log;

public final class ThermalHelper {
    private static final String PACKAGE_NAME = "com.miui.powerkeeper";
    private static final String TAG = "ThermalHelper";

    private ThermalHelper() {
    }

    public static void notifyThermalRecordStart(int i) {
        Log.d(TAG, "notifyThermalRecordStart: " + i);
        Intent intent = new Intent();
        intent.setPackage(PACKAGE_NAME);
        intent.setAction("record_start");
        intent.putExtra("quality", i);
        CameraAppImpl.getAndroidContext().sendBroadcast(intent);
    }

    public static void notifyThermalRecordStop(int i) {
        Log.d(TAG, "notifyThermalRecordStop: " + i);
        Intent intent = new Intent();
        intent.setPackage(PACKAGE_NAME);
        intent.setAction("record_end");
        intent.putExtra("quality", i);
        CameraAppImpl.getAndroidContext().sendBroadcast(intent);
    }
}
