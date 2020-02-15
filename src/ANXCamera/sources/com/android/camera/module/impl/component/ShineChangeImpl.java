package com.android.camera.module.impl.component;

import com.android.camera.ActivityBase;
import com.android.camera.data.DataRepository;
import com.android.camera.data.data.runing.ComponentRunningShine;
import com.android.camera.log.Log;
import com.android.camera.module.BaseModule;
import com.android.camera.protocol.ModeCoordinatorImpl;
import com.android.camera.protocol.ModeProtocol;

public class ShineChangeImpl implements ModeProtocol.OnShineChangedProtocol {
    public static final int BEAUTY_ADJUST_TRIGGER = 2;
    public static final int BEAUTY_SHINE_TRIGGER = 1;
    private static final String TAG = "ShineChangeImpl";
    private ActivityBase mActivity;

    public ShineChangeImpl(ActivityBase activityBase) {
        this.mActivity = activityBase;
    }

    public static ShineChangeImpl create(ActivityBase activityBase) {
        return new ShineChangeImpl(activityBase);
    }

    private BaseModule getBaseModule() {
        ActivityBase activityBase = this.mActivity;
        if (activityBase == null) {
            return null;
        }
        return (BaseModule) activityBase.getCurrentModule();
    }

    private void onBeautyChanged() {
    }

    private void onVideoFilterChanged() {
    }

    public static void preload() {
        Log.i(TAG, "preload");
    }

    public void onShineChanged(boolean z, int i) {
        BaseModule baseModule = getBaseModule();
        if (baseModule != null) {
            int moduleIndex = baseModule.getModuleIndex();
            ComponentRunningShine componentRunningShine = DataRepository.dataItemRunning().getComponentRunningShine();
            if (componentRunningShine.supportTopConfigEntry()) {
                boolean currentStatus = componentRunningShine.getCurrentStatus();
                boolean determineStatus = componentRunningShine.determineStatus(moduleIndex);
                if (currentStatus != determineStatus) {
                    String str = TAG;
                    Log.d(str, "beauty status changed: " + determineStatus);
                    baseModule.getHandler().post(new Runnable() {
                        public void run() {
                            ((ModeProtocol.TopAlert) ModeCoordinatorImpl.getInstance().getAttachProtocol(172)).updateConfigItem(212);
                        }
                    });
                }
            }
            if (!z) {
                getBaseModule().onShineChanged(i);
            }
        }
    }

    public void registerProtocol() {
        ModeCoordinatorImpl.getInstance().attachProtocol(234, this);
    }

    public void unRegisterProtocol() {
        this.mActivity = null;
        ModeCoordinatorImpl.getInstance().detachProtocol(234, this);
    }
}
