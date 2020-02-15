package com.android.camera.module.impl.component;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.android.camera.ActivityBase;
import com.android.camera.CameraSettings;
import com.android.camera.HybridZoomingSystem;
import com.android.camera.R;
import com.android.camera.aftersales.AftersalesManager;
import com.android.camera.data.DataRepository;
import com.android.camera.log.Log;
import com.android.camera.protocol.ModeCoordinatorImpl;
import com.android.camera.protocol.ModeProtocol;

public class RecordingStateChangeImpl implements ModeProtocol.RecordState {
    private static final String TAG = "RecordingState";
    private ActivityBase mActivity;

    public RecordingStateChangeImpl(ActivityBase activityBase) {
        this.mActivity = activityBase;
    }

    public static RecordingStateChangeImpl create(ActivityBase activityBase) {
        return new RecordingStateChangeImpl(activityBase);
    }

    private int getCurrentModuleIndex() {
        ActivityBase activityBase = this.mActivity;
        if (activityBase == null) {
            return 160;
        }
        return activityBase.getCurrentModuleIndex();
    }

    private boolean isFPS960() {
        if (getCurrentModuleIndex() != 172 || !DataRepository.dataItemFeature().vd()) {
            return false;
        }
        return DataRepository.dataItemConfig().getComponentConfigSlowMotion().isSlowMotionFps960();
    }

    private void setZoomRatio(float f2, float f3) {
        ModeProtocol.ZoomProtocol zoomProtocol = (ModeProtocol.ZoomProtocol) ModeCoordinatorImpl.getInstance().getAttachProtocol(170);
        if (zoomProtocol != null) {
            zoomProtocol.setMaxZoomRatio(f2);
            zoomProtocol.setMinZoomRatio(f3);
        }
    }

    public void onFailed() {
        Log.d(TAG, "onFailed");
        onFinish();
        AftersalesManager.getInstance().count(System.currentTimeMillis(), 7);
        ((ModeProtocol.ActionProcessing) ModeCoordinatorImpl.getInstance().getAttachProtocol(162)).processingFailed();
    }

    public void onFinish() {
        Log.d(TAG, "onFinish");
        ModeProtocol.TopAlert topAlert = (ModeProtocol.TopAlert) ModeCoordinatorImpl.getInstance().getAttachProtocol(172);
        ModeProtocol.BottomPopupTips bottomPopupTips = (ModeProtocol.BottomPopupTips) ModeCoordinatorImpl.getInstance().getAttachProtocol(175);
        ModeProtocol.ActionProcessing actionProcessing = (ModeProtocol.ActionProcessing) ModeCoordinatorImpl.getInstance().getAttachProtocol(162);
        int currentModuleIndex = getCurrentModuleIndex();
        if (currentModuleIndex == 174) {
            topAlert.showConfigMenu();
            bottomPopupTips.reInitTipImage();
            if (!HybridZoomingSystem.IS_3_OR_MORE_SAT) {
                bottomPopupTips.reConfigBottomTipOfUltraWide();
            }
            actionProcessing.processingFinish();
            topAlert.setRecordingTimeState(2);
            topAlert.enableMenuItem(true, 225, 245);
            topAlert.alertMusicClose(true);
        } else if (currentModuleIndex == 183) {
            topAlert.showConfigMenu();
            bottomPopupTips.reInitTipImage();
            if (!HybridZoomingSystem.IS_3_OR_MORE_SAT) {
                bottomPopupTips.reConfigBottomTipOfUltraWide();
            }
            actionProcessing.processingFinish();
            topAlert.setRecordingTimeState(2);
            topAlert.enableMenuItem(true, 197, 245);
            topAlert.alertMusicClose(true);
        } else if (currentModuleIndex == 179) {
            topAlert.showConfigMenu();
            ((ModeProtocol.LiveVVProcess) ModeCoordinatorImpl.getInstance().getAttachProtocol(230)).processingFinish();
        } else if (currentModuleIndex != 180) {
            topAlert.showConfigMenu();
            bottomPopupTips.reInitTipImage();
            if (!HybridZoomingSystem.IS_3_OR_MORE_SAT) {
                bottomPopupTips.reConfigBottomTipOfUltraWide();
            }
            actionProcessing.processingFinish();
            topAlert.setRecordingTimeState(2);
        } else {
            topAlert.showConfigMenu();
            bottomPopupTips.reInitTipImage();
            if (!HybridZoomingSystem.IS_3_OR_MORE_SAT) {
                bottomPopupTips.reConfigBottomTipOfUltraWide();
            }
            actionProcessing.processingFinish();
            topAlert.setRecordingTimeState(2);
            ModeProtocol.ManuallyAdjust manuallyAdjust = (ModeProtocol.ManuallyAdjust) ModeCoordinatorImpl.getInstance().getAttachProtocol(181);
            if (manuallyAdjust != null) {
                manuallyAdjust.setManuallyLayoutVisible(true);
            }
        }
    }

    public void onMimojiCreateBack() {
        ((ModeProtocol.ActionProcessing) ModeCoordinatorImpl.getInstance().getAttachProtocol(162)).processingMimojiBack();
        ModeProtocol.MimojiAvatarEngine mimojiAvatarEngine = (ModeProtocol.MimojiAvatarEngine) ModeCoordinatorImpl.getInstance().getAttachProtocol(217);
        if (mimojiAvatarEngine != null) {
            mimojiAvatarEngine.backToPreview(false, true);
        }
        ((ModeProtocol.MainContentProtocol) ModeCoordinatorImpl.getInstance().getAttachProtocol(166)).mimojiEnd();
    }

    public void onPause() {
        Log.d(TAG, "onPause");
        ModeProtocol.ActionProcessing actionProcessing = (ModeProtocol.ActionProcessing) ModeCoordinatorImpl.getInstance().getAttachProtocol(162);
        ModeProtocol.TopAlert topAlert = (ModeProtocol.TopAlert) ModeCoordinatorImpl.getInstance().getAttachProtocol(172);
        ModeProtocol.BottomPopupTips bottomPopupTips = (ModeProtocol.BottomPopupTips) ModeCoordinatorImpl.getInstance().getAttachProtocol(175);
        int currentModuleIndex = getCurrentModuleIndex();
        if (currentModuleIndex == 174) {
            actionProcessing.processingPause();
            bottomPopupTips.reInitTipImage();
            if (!HybridZoomingSystem.IS_3_OR_MORE_SAT) {
                bottomPopupTips.reConfigBottomTipOfUltraWide();
            }
            topAlert.disableMenuItem(true, 225, 245);
            topAlert.showConfigMenu();
        } else if (currentModuleIndex == 179) {
            topAlert.showConfigMenu();
            ((ModeProtocol.LiveVVProcess) ModeCoordinatorImpl.getInstance().getAttachProtocol(230)).processingPause();
        } else if (currentModuleIndex != 183) {
            actionProcessing.processingPause();
            topAlert.setRecordingTimeState(3);
        } else {
            actionProcessing.processingPause();
            bottomPopupTips.reInitTipImage();
            if (!HybridZoomingSystem.IS_3_OR_MORE_SAT) {
                bottomPopupTips.reConfigBottomTipOfUltraWide();
            }
            topAlert.disableMenuItem(true, 197, 245);
            topAlert.showConfigMenu();
        }
    }

    public void onPostPreview() {
        Log.d(TAG, "onPostPreview");
        ((ModeProtocol.BackStack) ModeCoordinatorImpl.getInstance().getAttachProtocol(171)).handleBackStackFromShutter();
        ((ModeProtocol.TopAlert) ModeCoordinatorImpl.getInstance().getAttachProtocol(172)).hideConfigMenu();
        ((ModeProtocol.ActionProcessing) ModeCoordinatorImpl.getInstance().getAttachProtocol(162)).processingWorkspace(false);
    }

    public void onPostPreviewBack() {
        Log.d(TAG, "onPostPreviewBack");
        ModeProtocol.ActionProcessing actionProcessing = (ModeProtocol.ActionProcessing) ModeCoordinatorImpl.getInstance().getAttachProtocol(162);
        if (getCurrentModuleIndex() != 177) {
            actionProcessing.processingWorkspace(true);
        } else {
            actionProcessing.processingFinish();
        }
        ((ModeProtocol.BottomPopupTips) ModeCoordinatorImpl.getInstance().getAttachProtocol(175)).reInitTipImage();
        ModeProtocol.TopAlert topAlert = (ModeProtocol.TopAlert) ModeCoordinatorImpl.getInstance().getAttachProtocol(172);
        int[] iArr = new int[2];
        iArr[0] = (getCurrentModuleIndex() == 177 || getCurrentModuleIndex() == 183) ? 197 : 225;
        iArr[1] = 245;
        topAlert.enableMenuItem(true, iArr);
        topAlert.showConfigMenu();
    }

    public void onPostSavingFinish() {
        Log.d(TAG, "onPostSavingFinish");
        int currentModuleIndex = getCurrentModuleIndex();
        if (currentModuleIndex == 166) {
            ModeProtocol.PanoramaProtocol panoramaProtocol = (ModeProtocol.PanoramaProtocol) ModeCoordinatorImpl.getInstance().getAttachProtocol(176);
            if (panoramaProtocol != null) {
                Log.d(TAG, "onPostExecute setDisplayPreviewBitmap null");
                panoramaProtocol.setDisplayPreviewBitmap((Bitmap) null);
                panoramaProtocol.showSmallPreview(false);
            }
        } else if (currentModuleIndex != 176) {
            ModeProtocol.ActionProcessing actionProcessing = (ModeProtocol.ActionProcessing) ModeCoordinatorImpl.getInstance().getAttachProtocol(162);
            if (actionProcessing != null) {
                actionProcessing.processingFinish();
            }
        } else {
            ModeProtocol.WideSelfieProtocol wideSelfieProtocol = (ModeProtocol.WideSelfieProtocol) ModeCoordinatorImpl.getInstance().getAttachProtocol(216);
            if (wideSelfieProtocol != null) {
                wideSelfieProtocol.updatePreviewBitmap((Bitmap) null, (Rect) null, (Rect) null);
            }
        }
    }

    public void onPostSavingStart() {
        Log.d(TAG, "onPostSaving");
        ModeProtocol.ActionProcessing actionProcessing = (ModeProtocol.ActionProcessing) ModeCoordinatorImpl.getInstance().getAttachProtocol(162);
        ModeProtocol.TopAlert topAlert = (ModeProtocol.TopAlert) ModeCoordinatorImpl.getInstance().getAttachProtocol(172);
        topAlert.showConfigMenu();
        ((ModeProtocol.BottomPopupTips) ModeCoordinatorImpl.getInstance().getAttachProtocol(175)).reInitTipImage();
        int currentModuleIndex = getCurrentModuleIndex();
        if (currentModuleIndex == 166) {
            actionProcessing.processingFinish();
            actionProcessing.updateLoading(false);
            if (DataRepository.dataItemFeature().ad()) {
                ModeProtocol.DualController dualController = (ModeProtocol.DualController) ModeCoordinatorImpl.getInstance().getAttachProtocol(182);
                if (dualController != null) {
                    dualController.showZoomButton();
                    if (topAlert != null) {
                        topAlert.clearAlertStatus();
                    }
                }
            }
            ((ModeProtocol.PanoramaProtocol) ModeCoordinatorImpl.getInstance().getAttachProtocol(176)).resetShootUI();
        } else if (currentModuleIndex == 173) {
            actionProcessing.processingPostAction();
            ModeProtocol.DualController dualController2 = (ModeProtocol.DualController) ModeCoordinatorImpl.getInstance().getAttachProtocol(182);
            if (dualController2 != null) {
                dualController2.showZoomButton();
                if (topAlert != null) {
                    topAlert.clearAlertStatus();
                }
            }
            ModeProtocol.BottomPopupTips bottomPopupTips = (ModeProtocol.BottomPopupTips) ModeCoordinatorImpl.getInstance().getAttachProtocol(175);
            if (bottomPopupTips != null) {
                bottomPopupTips.hideTipImage();
            }
        } else if (currentModuleIndex == 176) {
            actionProcessing.processingFinish();
            actionProcessing.updateLoading(false);
            ((ModeProtocol.WideSelfieProtocol) ModeCoordinatorImpl.getInstance().getAttachProtocol(216)).resetShootUI();
        } else if (currentModuleIndex != 177) {
            topAlert.setRecordingTimeState(2);
            actionProcessing.processingPostAction();
        }
    }

    public void onPrepare() {
        ModeProtocol.TopAlert topAlert = (ModeProtocol.TopAlert) ModeCoordinatorImpl.getInstance().getAttachProtocol(172);
        topAlert.hideConfigMenu();
        if (getCurrentModuleIndex() != 179) {
            ((ModeProtocol.BackStack) ModeCoordinatorImpl.getInstance().getAttachProtocol(171)).handleBackStackFromShutter();
            ModeProtocol.ActionProcessing actionProcessing = (ModeProtocol.ActionProcessing) ModeCoordinatorImpl.getInstance().getAttachProtocol(162);
            actionProcessing.processingPrepare();
            if (actionProcessing.isShowFilterView()) {
                actionProcessing.showOrHideFilterView();
            }
            ModeProtocol.BottomPopupTips bottomPopupTips = (ModeProtocol.BottomPopupTips) ModeCoordinatorImpl.getInstance().getAttachProtocol(175);
            bottomPopupTips.hideTipImage();
            bottomPopupTips.hideLeftTipImage();
            bottomPopupTips.hideSpeedTipImage();
            bottomPopupTips.hideCenterTipImage();
            bottomPopupTips.directHideLeftImageIntro();
            if (HybridZoomingSystem.IS_3_OR_MORE_SAT) {
                if (HybridZoomingSystem.toFloat(HybridZoomingSystem.getZoomRatioHistory(getCurrentModuleIndex(), "1.0"), 1.0f) < 1.0f) {
                    bottomPopupTips.directlyHideTips();
                }
            } else if (CameraSettings.isUltraWideConfigOpen(getCurrentModuleIndex())) {
                bottomPopupTips.directlyHideTips();
            }
            if (CameraSettings.isFPS960(getCurrentModuleIndex())) {
                bottomPopupTips.directlyHideTips();
            }
        } else {
            ((ModeProtocol.LiveVVProcess) ModeCoordinatorImpl.getInstance().getAttachProtocol(230)).processingPrepare();
        }
        int currentModuleIndex = getCurrentModuleIndex();
        if (currentModuleIndex == 166) {
            ((ModeProtocol.PanoramaProtocol) ModeCoordinatorImpl.getInstance().getAttachProtocol(176)).setShootUI();
            if (DataRepository.dataItemFeature().ad()) {
                ModeProtocol.DualController dualController = (ModeProtocol.DualController) ModeCoordinatorImpl.getInstance().getAttachProtocol(182);
                if (dualController != null) {
                    dualController.hideZoomButton();
                    if (topAlert != null) {
                        topAlert.alertUpdateValue(2);
                    }
                }
            }
        } else if (currentModuleIndex == 176) {
            ModeProtocol.MainContentProtocol mainContentProtocol = (ModeProtocol.MainContentProtocol) ModeCoordinatorImpl.getInstance().getAttachProtocol(166);
            if (mainContentProtocol != null) {
                mainContentProtocol.clearIndicator(1);
            }
            ModeProtocol.WideSelfieProtocol wideSelfieProtocol = (ModeProtocol.WideSelfieProtocol) ModeCoordinatorImpl.getInstance().getAttachProtocol(216);
            if (wideSelfieProtocol != null) {
                wideSelfieProtocol.setShootingUI();
            }
        } else if (currentModuleIndex != 179 && currentModuleIndex != 183 && currentModuleIndex != 173 && currentModuleIndex != 174 && !isFPS960()) {
            topAlert.setRecordingTimeState(1);
        }
    }

    public void onResume() {
        Log.d(TAG, "onResume");
        ModeProtocol.ActionProcessing actionProcessing = (ModeProtocol.ActionProcessing) ModeCoordinatorImpl.getInstance().getAttachProtocol(162);
        ModeProtocol.TopAlert topAlert = (ModeProtocol.TopAlert) ModeCoordinatorImpl.getInstance().getAttachProtocol(172);
        int currentModuleIndex = getCurrentModuleIndex();
        if (currentModuleIndex != 174) {
            if (currentModuleIndex == 179) {
                topAlert.hideConfigMenu();
                ((ModeProtocol.LiveVVProcess) ModeCoordinatorImpl.getInstance().getAttachProtocol(230)).processingResume();
                return;
            } else if (currentModuleIndex != 183) {
                actionProcessing.processingResume();
                topAlert.setRecordingTimeState(4);
                return;
            }
        }
        actionProcessing.processingResume();
        topAlert.hideConfigMenu();
        ModeProtocol.BackStack backStack = (ModeProtocol.BackStack) ModeCoordinatorImpl.getInstance().getAttachProtocol(171);
        if (backStack != null) {
            backStack.handleBackStackFromShutter();
        }
        ModeProtocol.BottomPopupTips bottomPopupTips = (ModeProtocol.BottomPopupTips) ModeCoordinatorImpl.getInstance().getAttachProtocol(175);
        bottomPopupTips.hideTipImage();
        bottomPopupTips.hideLeftTipImage();
        bottomPopupTips.hideSpeedTipImage();
        bottomPopupTips.hideCenterTipImage();
        bottomPopupTips.directHideLeftImageIntro();
    }

    public void onStart() {
        Log.d(TAG, "onStart");
        ModeProtocol.ActionProcessing actionProcessing = (ModeProtocol.ActionProcessing) ModeCoordinatorImpl.getInstance().getAttachProtocol(162);
        ModeProtocol.TopAlert topAlert = (ModeProtocol.TopAlert) ModeCoordinatorImpl.getInstance().getAttachProtocol(172);
        int currentModuleIndex = getCurrentModuleIndex();
        if (currentModuleIndex != 174) {
            if (currentModuleIndex == 176) {
                actionProcessing.processingStart();
                ModeProtocol.WideSelfieProtocol wideSelfieProtocol = (ModeProtocol.WideSelfieProtocol) ModeCoordinatorImpl.getInstance().getAttachProtocol(216);
                if (wideSelfieProtocol != null) {
                    wideSelfieProtocol.updateHintText(R.string.wideselfie_rotate_slowly);
                    return;
                }
                return;
            } else if (currentModuleIndex != 183) {
                if (currentModuleIndex == 179) {
                    ((ModeProtocol.LiveVVProcess) ModeCoordinatorImpl.getInstance().getAttachProtocol(230)).processingStart();
                    return;
                } else if (currentModuleIndex != 180) {
                    actionProcessing.processingStart();
                    return;
                } else {
                    ModeProtocol.ManuallyAdjust manuallyAdjust = (ModeProtocol.ManuallyAdjust) ModeCoordinatorImpl.getInstance().getAttachProtocol(181);
                    if (manuallyAdjust != null) {
                        manuallyAdjust.setManuallyLayoutVisible(false);
                    }
                    actionProcessing.processingStart();
                    return;
                }
            }
        }
        actionProcessing.processingStart();
        topAlert.alertMusicClose(false);
    }

    public void prepareCreateMimoji() {
        ((ModeProtocol.BackStack) ModeCoordinatorImpl.getInstance().getAttachProtocol(171)).handleBackStackFromShutter();
        ModeProtocol.ActionProcessing actionProcessing = (ModeProtocol.ActionProcessing) ModeCoordinatorImpl.getInstance().getAttachProtocol(162);
        actionProcessing.processingMimojiPrepare();
        if (actionProcessing.isShowFilterView()) {
            actionProcessing.showOrHideFilterView();
        }
        ModeProtocol.TopAlert topAlert = (ModeProtocol.TopAlert) ModeCoordinatorImpl.getInstance().getAttachProtocol(172);
        topAlert.disableMenuItem(true, 197, 193);
        topAlert.alertFlash(8, "1", false);
        ModeProtocol.BottomPopupTips bottomPopupTips = (ModeProtocol.BottomPopupTips) ModeCoordinatorImpl.getInstance().getAttachProtocol(175);
        bottomPopupTips.hideTipImage();
        bottomPopupTips.hideLeftTipImage();
        bottomPopupTips.hideSpeedTipImage();
        bottomPopupTips.directHideCenterTipImage();
        bottomPopupTips.directHideLeftImageIntro();
        bottomPopupTips.directlyHideTips();
    }

    public void registerProtocol() {
        ModeCoordinatorImpl.getInstance().attachProtocol(212, this);
    }

    public void unRegisterProtocol() {
        this.mActivity = null;
        ModeCoordinatorImpl.getInstance().detachProtocol(212, this);
    }

    /* access modifiers changed from: protected */
    public void updateZoomRatioToggleButtonState(boolean z) {
        ModeProtocol.DualController dualController = (ModeProtocol.DualController) ModeCoordinatorImpl.getInstance().getAttachProtocol(182);
        if (dualController != null) {
            dualController.setRecordingOrPausing(z);
            if (z) {
                dualController.hideZoomButton();
            } else {
                dualController.showZoomButton();
                dualController.setImmersiveModeEnabled(false);
            }
        }
        ModeProtocol.TopAlert topAlert = (ModeProtocol.TopAlert) ModeCoordinatorImpl.getInstance().getAttachProtocol(172);
        if (topAlert == null) {
            return;
        }
        if (z) {
            topAlert.alertUpdateValue(2);
        } else {
            topAlert.clearAlertStatus();
        }
    }
}
