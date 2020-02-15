package com.android.camera;

import android.app.IntentService;
import android.content.Intent;
import com.android.camera.log.Log;
import com.android.camera.module.Camera2Module;
import com.android.camera.module.impl.component.ConfigChangeImpl;
import com.android.camera.module.loader.camera2.Camera2DataContainer;
import com.android.camera.module.loader.camera2.Camera2OpenManager;
import com.android.camera.statistic.SettingUploadJobService;

public class PreloadIntentService extends IntentService {
    private static final String TAG = "PreloadIntentService";

    public PreloadIntentService() {
        super(TAG);
        Log.d(TAG, "PreloadIntentService: init");
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent: E");
        HybridZoomingSystem.preload();
        Camera2DataContainer.getInstance();
        new Camera2Module();
        Camera2OpenManager.preload();
        new CameraSettings();
        ConfigChangeImpl.preload();
        SettingUploadJobService.scheduleSettingUploadJob(getApplicationContext());
        Log.d(TAG, "onHandleIntent: X");
    }
}
