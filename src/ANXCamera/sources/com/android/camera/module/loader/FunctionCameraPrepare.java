package com.android.camera.module.loader;

import android.text.TextUtils;
import com.android.camera.Camera;
import com.android.camera.CameraAppImpl;
import com.android.camera.CameraSettings;
import com.android.camera.R;
import com.android.camera.Util;
import com.android.camera.constant.BeautyConstant;
import com.android.camera.constant.GlobalConstant;
import com.android.camera.data.DataRepository;
import com.android.camera.data.backup.DataBackUp;
import com.android.camera.data.data.config.ComponentConfigBeauty;
import com.android.camera.data.data.config.ComponentConfigBokeh;
import com.android.camera.data.data.config.ComponentConfigCinematicAspectRatio;
import com.android.camera.data.data.config.ComponentConfigFlash;
import com.android.camera.data.data.config.ComponentConfigGradienter;
import com.android.camera.data.data.config.ComponentConfigHdr;
import com.android.camera.data.data.config.ComponentConfigRatio;
import com.android.camera.data.data.config.ComponentConfigSlowMotion;
import com.android.camera.data.data.config.ComponentConfigUltraWide;
import com.android.camera.data.data.config.ComponentManuallyDualLens;
import com.android.camera.data.data.config.ComponentRunningMacroMode;
import com.android.camera.data.data.config.DataItemConfig;
import com.android.camera.data.data.global.DataItemGlobal;
import com.android.camera.data.data.runing.ComponentRunningAutoZoom;
import com.android.camera.data.data.runing.ComponentRunningSubtitle;
import com.android.camera.data.data.runing.ComponentRunningSuperEIS;
import com.android.camera.data.data.runing.DataItemRunning;
import com.android.camera.data.provider.DataProvider;
import com.android.camera.log.Log;
import com.android.camera.module.BaseModule;
import com.android.camera.permission.PermissionManager;
import com.mi.config.b;
import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;

public class FunctionCameraPrepare extends Func1Base<Camera, BaseModule> {
    private static final String TAG = "FunctionCameraPrepare";
    private BaseModule baseModule;
    private boolean mNeedReConfigureData;
    private int mResetType;

    public FunctionCameraPrepare(int i, int i2, boolean z, BaseModule baseModule2) {
        super(i);
        this.mResetType = i2;
        this.mNeedReConfigureData = z;
        this.baseModule = baseModule2;
    }

    private void reconfigureData() {
        boolean z;
        DataItemConfig dataItemConfig;
        int i;
        boolean z2;
        boolean z3;
        if (!this.mNeedReConfigureData) {
            DataRepository.dataItemConfig().editor().remove(CameraSettings.KEY_ZOOM).apply();
            return;
        }
        CameraSettings.upgradeGlobalPreferences();
        DataItemGlobal dataItemGlobal = DataRepository.dataItemGlobal();
        DataItemRunning dataItemRunning = DataRepository.dataItemRunning();
        DataItemConfig dataItemConfig2 = DataRepository.dataItemConfig();
        int lastCameraId = dataItemGlobal.getLastCameraId();
        ComponentConfigFlash componentFlash = dataItemConfig2.getComponentFlash();
        DataProvider.ProviderEditor editor = dataItemConfig2.editor();
        DataProvider.ProviderEditor editor2 = dataItemGlobal.editor();
        DataProvider.ProviderEditor editor3 = DataRepository.dataItemLive().editor();
        DataBackUp backUp = DataRepository.getInstance().backUp();
        editor.remove(CameraSettings.KEY_ZOOM).remove(CameraSettings.KEY_EXPOSURE);
        ComponentRunningAutoZoom componentRunningAutoZoom = dataItemRunning.getComponentRunningAutoZoom();
        if (componentRunningAutoZoom != null) {
            componentRunningAutoZoom.reInitIntentType(dataItemGlobal.getIntentType() == 0);
        }
        ComponentRunningSuperEIS componentRunningSuperEIS = dataItemRunning.getComponentRunningSuperEIS();
        if (componentRunningSuperEIS != null) {
            componentRunningSuperEIS.reInitIntentType(dataItemGlobal.getIntentType() == 0);
        }
        String persistValue = componentFlash.getPersistValue(this.mTargetMode);
        if (!componentFlash.isValidFlashValue(persistValue)) {
            editor.remove(componentFlash.getKey(this.mTargetMode));
        } else if (persistValue.equals("2") || componentFlash.getPersistValue(this.mTargetMode).equals("5")) {
            editor.putString(componentFlash.getKey(this.mTargetMode), componentFlash.getDefaultValue(this.mTargetMode));
        }
        ComponentConfigRatio componentConfigRatio = dataItemConfig2.getComponentConfigRatio();
        int i2 = this.mTargetMode;
        int i3 = lastCameraId;
        if (i2 == 163 || i2 == 165 || i2 == 167 || i2 == 173 || i2 == 175 || i2 == 171) {
            String[] fullSupportRatioValues = componentConfigRatio.getFullSupportRatioValues();
            String persistValue2 = componentConfigRatio.getPersistValue(this.mTargetMode);
            int length = fullSupportRatioValues.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    z3 = false;
                    break;
                } else if (TextUtils.equals(fullSupportRatioValues[i4], persistValue2)) {
                    z3 = true;
                    break;
                } else {
                    i4++;
                }
            }
            if (!z3 && (this.mTargetMode == 165 || !persistValue2.equals(ComponentConfigRatio.RATIO_1X1))) {
                Log.d(TAG, "reconfigureData: clear DATA_CONFIG_RATIO");
                editor.remove("pref_camera_picturesize_key");
            }
        }
        if (this.mTargetMode == 172) {
            ComponentConfigSlowMotion componentConfigSlowMotion = dataItemConfig2.getComponentConfigSlowMotion();
            String componentValue = componentConfigSlowMotion.getComponentValue(172);
            String[] supportedFpsOptions = componentConfigSlowMotion.getSupportedFpsOptions();
            int length2 = supportedFpsOptions.length;
            int i5 = 0;
            while (true) {
                if (i5 >= length2) {
                    z2 = false;
                    break;
                } else if (TextUtils.equals(supportedFpsOptions[i5], componentValue)) {
                    z2 = true;
                    break;
                } else {
                    i5++;
                }
            }
            if (!z2) {
                Log.d(TAG, "reconfigureData: clear DATA_CONFIG_NEW_SLOW_MOTION_KEY");
                editor.remove(DataItemConfig.DATA_CONFIG_NEW_SLOW_MOTION_KEY);
            }
        }
        if (this.mTargetMode == 167) {
            if (!Util.isStringValueContained((Object) dataItemConfig2.getString(CameraSettings.KEY_QC_ISO, CameraAppImpl.getAndroidContext().getString(R.string.pref_camera_iso_default)), (DataRepository.dataItemFeature().qe() || DataRepository.dataItemFeature().je()) ? R.array.pref_camera_iso_entryvalues_new : R.array.pref_camera_iso_entryvalues)) {
                editor.remove(CameraSettings.KEY_QC_ISO);
            }
        }
        if (!b.Wk()) {
            editor.remove(CameraSettings.KEY_QC_FOCUS_POSITION);
            editor.remove(CameraSettings.KEY_QC_EXPOSURETIME);
        }
        if (!Util.isLabOptionsVisible()) {
            editor2.remove("pref_camera_facedetection_key").remove("pref_camera_portrait_with_facebeauty_key").remove("pref_camera_facedetection_auto_hidden_key").remove("pref_camera_dual_enable_key").remove("pref_camera_dual_sat_enable_key").remove("pref_camera_mfnr_sat_enable_key").remove("pref_camera_sr_enable_key");
        }
        if (!Util.isValidValue(dataItemGlobal.getString("pref_camera_antibanding_key", "1"))) {
            editor2.remove("pref_camera_antibanding_key");
        }
        if (!b.Wj()) {
            editor2.remove("pref_fingerprint_capture_key");
        }
        switch (this.mResetType) {
            case 2:
            case 7:
                z = false;
                backUp.revertRunning(dataItemRunning, dataItemGlobal.getDataBackUpKey(this.mTargetMode), dataItemGlobal.getCurrentCameraId());
                if (componentFlash.getPersistValue(this.mTargetMode).equals("2")) {
                    editor.putString(componentFlash.getKey(this.mTargetMode), componentFlash.getDefaultValue(this.mTargetMode));
                    break;
                }
                break;
            case 3:
            case 6:
                resetFlash(componentFlash, editor);
                resetHdr(dataItemConfig2.getComponentHdr(), editor);
                resetBeautyTransientAndVideoPersist(dataItemConfig2.getComponentConfigBeauty(), editor);
                resetUltraWide(dataItemConfig2.getComponentConfigUltraWide(), editor);
                resetLensType(dataItemConfig2.getComponentConfigUltraWide(), dataItemConfig2.getManuallyDualLens(), editor);
                resetCinematicAspectRatio(dataItemConfig2.getCinematicAspectRatio(), editor);
                resetGradienter(dataItemConfig2.getComponentConfigGradienter(), editor);
                editor.remove(dataItemConfig2.getComponentConfigSlowMotion().getKey(this.mTargetMode));
                z = false;
                dataItemRunning.getComponentRunningShine().setVideoBeautySwitch(DataRepository.dataItemGlobal().getCurrentMode(), false);
                if (dataItemGlobal.getCurrentCameraId() == 0) {
                    resetBeautyBackLevel(editor);
                    resetBeautyCaptureFigure(editor);
                    dataItemConfig = (DataItemConfig) DataRepository.provider().dataConfig(1);
                } else {
                    dataItemConfig = (DataItemConfig) DataRepository.provider().dataConfig(0);
                }
                DataProvider.ProviderEditor editor4 = dataItemConfig.editor();
                resetFlash(dataItemConfig.getComponentFlash(), editor4);
                resetHdr(dataItemConfig.getComponentHdr(), editor4);
                resetFrontBokenh(dataItemConfig.getComponentBokeh(), editor4);
                resetBeautyTransientAndVideoPersist(dataItemConfig.getComponentConfigBeauty(), editor4);
                resetCinematicAspectRatio(dataItemConfig.getCinematicAspectRatio(), editor);
                resetBeautyVideoFront(dataItemConfig);
                editor4.apply();
                dataItemRunning.clearArrayMap();
                backUp.clearBackUp();
                DataRepository.dataItemLive().clearAll();
                resetMacroMode(dataItemRunning.getComponentRunningMacroMode());
                resetAutoZoom(dataItemRunning.getComponentRunningAutoZoom());
                resetSubtitle(dataItemRunning.getComponentRunningSubtitle());
                resetSuperEIS(dataItemRunning.getComponentRunningSuperEIS());
                if (DataRepository.dataItemFeature().Rc() || DataRepository.dataItemFeature().Xc()) {
                    editor3.remove(CameraSettings.KEY_LIVE_MUSIC_PATH).remove(CameraSettings.KEY_LIVE_MUSIC_HINT).remove(CameraSettings.KEY_LIVE_STICKER).remove(CameraSettings.KEY_LIVE_STICKER_NAME).remove(CameraSettings.KEY_LIVE_STICKER_HINT).remove(CameraSettings.KEY_LIVE_SPEED).remove(CameraSettings.KEY_LIVE_FILTER).remove("key_live_shrink_face_ratio").remove("key_live_enlarge_eye_ratio").remove("key_live_smooth_strength").remove(CameraSettings.KEY_LIVE_BEAUTY_STATUS);
                }
                if (DataRepository.dataItemFeature().Lc()) {
                    editor3.remove(CameraSettings.KEY_MIMOJI_INDEX).remove(CameraSettings.KEY_MIMOJI_PANNEL_STATE);
                }
                if (DataRepository.dataItemFeature().qe()) {
                    editor2.remove(CameraSettings.KEY_CAMERA_PRO_VIDEO_LOG_FROMAT).remove(CameraSettings.KEY_CAMERA_PRO_VIDEO_HISTOGRAM);
                    break;
                }
                break;
            case 4:
            case 5:
                int i6 = this.mTargetMode;
                if (i6 != 161) {
                    if (i6 != 162) {
                        if (!(i6 == 166 || i6 == 167)) {
                            if (i6 == 169) {
                                i = dataItemGlobal.getCurrentCameraId();
                            } else if (i6 != 171) {
                                if (!(i6 == 174 || i6 == 183)) {
                                    i = dataItemGlobal.getCurrentCameraId();
                                }
                            } else if (DataRepository.dataItemFeature().yd()) {
                                i = dataItemGlobal.getCurrentCameraId();
                            }
                        }
                        i = 0;
                    } else {
                        i = dataItemGlobal.getCurrentCameraId();
                        if (i == 0) {
                            backUp.removeOtherVideoMode();
                        }
                    }
                    dataItemGlobal.setCameraIdTransient(i);
                    backUp.revertRunning(dataItemRunning, dataItemGlobal.getDataBackUpKey(this.mTargetMode), i);
                    break;
                }
                i = dataItemGlobal.getCurrentCameraId();
                dataItemGlobal.setCameraIdTransient(i);
                backUp.revertRunning(dataItemRunning, dataItemGlobal.getDataBackUpKey(this.mTargetMode), i);
        }
        z = false;
        boolean Pc = DataRepository.dataItemFeature().Pc();
        if (!(this.mResetType == 4 && i3 == dataItemGlobal.getCurrentCameraId())) {
            z = Pc;
        }
        if (z) {
            editor.putBoolean(CameraSettings.KEY_LENS_DIRTY_DETECT_ENABLED, true);
        }
        editor.apply();
        editor2.apply();
        editor3.apply();
    }

    private void resetAutoZoom(ComponentRunningAutoZoom componentRunningAutoZoom) {
        componentRunningAutoZoom.clearArrayMap();
    }

    private void resetBeautyBackLevel(DataProvider.ProviderEditor providerEditor) {
        for (String str : BeautyConstant.BEAUTY_CATEGORY_LEVEL) {
            providerEditor.remove(BeautyConstant.wrappedSettingKeyForCapture(str));
            providerEditor.remove(BeautyConstant.wrappedSettingKeyForVideo(str));
            providerEditor.remove(BeautyConstant.wrappedSettingKeyForPortrait(str));
            providerEditor.remove(BeautyConstant.wrappedSettingKeyForFun(str));
        }
    }

    private void resetBeautyCaptureFigure(DataProvider.ProviderEditor providerEditor) {
        for (String wrappedSettingKeyForCapture : BeautyConstant.BEAUTY_CATEGORY_BACK_FIGURE) {
            providerEditor.remove(BeautyConstant.wrappedSettingKeyForCapture(wrappedSettingKeyForCapture));
        }
    }

    private void resetBeautyTransientAndVideoPersist(ComponentConfigBeauty componentConfigBeauty, DataProvider.ProviderEditor providerEditor) {
        componentConfigBeauty.clearClosed();
        String persistValue = componentConfigBeauty.getPersistValue(162);
        String defaultValue = componentConfigBeauty.getDefaultValue(162);
        if (!TextUtils.equals(persistValue, defaultValue)) {
            providerEditor.putString(componentConfigBeauty.getKey(162), defaultValue);
        }
    }

    private void resetBeautyVideoFront(DataProvider.ProviderEditor providerEditor) {
        for (String wrappedSettingKeyForVideo : BeautyConstant.BEAUTY_CATEGORY_LEVEL) {
            providerEditor.remove(BeautyConstant.wrappedSettingKeyForVideo(wrappedSettingKeyForVideo));
        }
    }

    private void resetCinematicAspectRatio(ComponentConfigCinematicAspectRatio componentConfigCinematicAspectRatio, DataProvider.ProviderEditor providerEditor) {
        if (componentConfigCinematicAspectRatio != null) {
            componentConfigCinematicAspectRatio.reset(providerEditor);
        }
    }

    private void resetFlash(ComponentConfigFlash componentConfigFlash, DataProvider.ProviderEditor providerEditor) {
        if (!componentConfigFlash.getPersistValue(this.mTargetMode).equals("3")) {
            providerEditor.putString(componentConfigFlash.getKey(this.mTargetMode), componentConfigFlash.getDefaultValue(this.mTargetMode));
        }
    }

    private void resetFrontBokenh(ComponentConfigBokeh componentConfigBokeh, DataProvider.ProviderEditor providerEditor) {
        if ("on".equals(componentConfigBokeh.getPersistValue(this.mTargetMode))) {
            componentConfigBokeh.setComponentValue(this.mTargetMode, "off");
        }
    }

    private void resetGradienter(ComponentConfigGradienter componentConfigGradienter, DataProvider.ProviderEditor providerEditor) {
        if (componentConfigGradienter != null) {
            componentConfigGradienter.reset(providerEditor);
        }
    }

    private void resetHdr(ComponentConfigHdr componentConfigHdr, DataProvider.ProviderEditor providerEditor) {
        String persistValue = componentConfigHdr.getPersistValue(this.mTargetMode);
        if (!persistValue.equals("auto") && !persistValue.equals("off")) {
            providerEditor.putString(componentConfigHdr.getKey(this.mTargetMode), componentConfigHdr.getDefaultValue(this.mTargetMode));
        }
    }

    private void resetLensType(ComponentConfigUltraWide componentConfigUltraWide, ComponentManuallyDualLens componentManuallyDualLens, DataProvider.ProviderEditor providerEditor) {
        if (componentConfigUltraWide != null && componentManuallyDualLens != null) {
            componentManuallyDualLens.resetLensType(componentConfigUltraWide, providerEditor);
        }
    }

    private void resetMacroMode(ComponentRunningMacroMode componentRunningMacroMode) {
        componentRunningMacroMode.clearArrayMap();
    }

    private void resetSubtitle(ComponentRunningSubtitle componentRunningSubtitle) {
        componentRunningSubtitle.clearArrayMap();
    }

    private void resetSuperEIS(ComponentRunningSuperEIS componentRunningSuperEIS) {
        componentRunningSuperEIS.clearArrayMap();
    }

    private void resetUltraWide(ComponentConfigUltraWide componentConfigUltraWide, DataProvider.ProviderEditor providerEditor) {
        if (componentConfigUltraWide != null) {
            componentConfigUltraWide.resetUltraWide(providerEditor);
        }
    }

    public NullHolder<BaseModule> apply(@NonNull NullHolder<Camera> nullHolder) throws Exception {
        if (!nullHolder.isPresent()) {
            return NullHolder.ofNullable(null, 234);
        }
        if (!PermissionManager.checkCameraLaunchPermissions()) {
            return NullHolder.ofNullable(null, 229);
        }
        Camera camera = nullHolder.get();
        if (camera.isFinishing()) {
            Log.d(TAG, "activity is finishing, the content of BaseModuleHolder is set to null");
            return NullHolder.ofNullable(null, 235);
        }
        camera.changeRequestOrientation();
        if (this.baseModule.isDeparted()) {
            return NullHolder.ofNullable(this.baseModule, 225);
        }
        reconfigureData();
        return NullHolder.ofNullable(this.baseModule);
    }

    public Scheduler getWorkThread() {
        return GlobalConstant.sCameraSetupScheduler;
    }
}
