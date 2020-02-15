package com.android.camera.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.StringRes;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.camera.ActivityBase;
import com.android.camera.Camera;
import com.android.camera.CameraSettings;
import com.android.camera.HybridZoomingSystem;
import com.android.camera.R;
import com.android.camera.Util;
import com.android.camera.animation.FragmentAnimationFactory;
import com.android.camera.animation.type.AlphaInOnSubscribe;
import com.android.camera.animation.type.AlphaOutOnSubscribe;
import com.android.camera.animation.type.TranslateYOnSubscribe;
import com.android.camera.constant.DurationConstant;
import com.android.camera.data.DataRepository;
import com.android.camera.fragment.mimoji.FragmentMimoji;
import com.android.camera.fragment.top.FragmentTopAlert;
import com.android.camera.log.Log;
import com.android.camera.protocol.ModeCoordinatorImpl;
import com.android.camera.protocol.ModeProtocol;
import com.android.camera.statistic.CameraStatUtils;
import com.android.camera.statistic.MistatsConstants;
import com.android.camera.statistic.MistatsWrapper;
import com.android.camera.storage.Storage;
import com.mi.config.b;
import io.reactivex.Completable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.List;
import miui.view.animation.BackEaseOutInterpolator;

public class FragmentBottomPopupTips extends BaseFragment implements View.OnClickListener, ModeProtocol.BottomPopupTips, ModeProtocol.HandleBackTrace {
    private static final int ANIM_DELAY_SHOW = 3;
    private static final int ANIM_DIRECT_HIDE = 1;
    private static final int ANIM_DIRECT_SHOW = 0;
    private static final int ANIM_HIDE = 4;
    private static final int ANIM_SHOW = 2;
    private static final int CALL_TYPE_NOTIFY = 1;
    private static final int CALL_TYPE_PROVIDE = 0;
    private static final int CENTER_TIP_IMAGE_MIMOJI = 34;
    private static final int CENTER_TIP_IMAGE_SPEED = 33;
    private static final int CENTER_TIP_IMAGE_VIDEO_BEAUTY = 35;
    public static final int FRAGMENT_INFO = 65522;
    private static final int LEFT_TIP_IMAGE_CLOSE = 20;
    private static final int LEFT_TIP_IMAGE_KALEIDOSCOPE = 22;
    private static final int LEFT_TIP_IMAGE_LIGHTING = 19;
    private static final int LEFT_TIP_IMAGE_STICKER = 18;
    private static final int LEFT_TIP_IMAGE_ULTRA_WIDE = 21;
    private static final long MAX_RED_DOT_TIME = 86400000;
    private static final int MSG_HIDE_TIP = 1;
    private static final int TIP_ID_CARD = 4;
    private static final int TIP_IMAGE_INVALID = -1;
    private static final int TIP_IMAGE_STICKER = 2;
    private static final int TIP_SHINE = 3;
    private boolean INIT_TAG = false;
    private int mBottomTipHeight;
    private View mCenterRedDot;
    private ImageView mCenterTipImage;
    private int mCloseType = 0;
    private String mCurrentTipMessage;
    /* access modifiers changed from: private */
    public int mCurrentTipType;
    private Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            if (message.what == 1) {
                FragmentBottomPopupTips.this.mTipMessage.setVisibility(8);
                if (FragmentBottomPopupTips.this.mCurrentMode == 163) {
                    ModeProtocol.CameraModuleSpecial cameraModuleSpecial = (ModeProtocol.CameraModuleSpecial) ModeCoordinatorImpl.getInstance().getAttachProtocol(195);
                    if (cameraModuleSpecial != null) {
                        cameraModuleSpecial.showOrHideChip(true);
                    }
                }
                if (FragmentBottomPopupTips.this.mLastTipType == 6 && FragmentBottomPopupTips.this.mCurrentTipType != 8 && !FragmentBottomPopupTips.this.isPortraitHintVisible()) {
                    FragmentBottomPopupTips fragmentBottomPopupTips = FragmentBottomPopupTips.this;
                    fragmentBottomPopupTips.showTips(fragmentBottomPopupTips.mLastTipType, FragmentBottomPopupTips.this.mLastTipMessage, 4);
                } else if (FragmentBottomPopupTips.this.mLastTipType == 10 && CameraSettings.isEyeLightOpen()) {
                    FragmentBottomPopupTips fragmentBottomPopupTips2 = FragmentBottomPopupTips.this;
                    fragmentBottomPopupTips2.showTips(fragmentBottomPopupTips2.mLastTipType, FragmentBottomPopupTips.this.mLastTipMessage, 4);
                } else if ((FragmentBottomPopupTips.this.mLastTipType != 18 || !CameraSettings.isMacroModeEnabled(FragmentBottomPopupTips.this.mCurrentMode)) && (FragmentBottomPopupTips.this.mLastTipType != 8 || !CameraSettings.isMacroModeEnabled(FragmentBottomPopupTips.this.mCurrentMode))) {
                    FragmentBottomPopupTips.this.updateLyingDirectHint(false, true);
                }
                int unused = FragmentBottomPopupTips.this.mLastTipType = 4;
            }
        }
    };
    private boolean mIsShowLeftImageIntro;
    private boolean mIsShowLyingDirectHint;
    /* access modifiers changed from: private */
    public String mLastTipMessage;
    /* access modifiers changed from: private */
    public int mLastTipType;
    /* access modifiers changed from: private */
    public FrameLayout mLeftImageIntro;
    private AnimatorSet mLeftImageIntroAnimator;
    private TextView mLeftImageIntroContent;
    private int mLeftImageIntroRadius;
    private int mLeftImageIntroWidth;
    private ImageView mLeftTipImage;
    private TextView mLightingPattern;
    private TextView mLyingDirectHint;
    /* access modifiers changed from: private */
    public TextView mMimojiTextview;
    private boolean mNeedShowIDCardTip;
    private View mPortraitSuccessHint;
    /* access modifiers changed from: private */
    public TextView mQrCodeButton;
    private View mRootView;
    private ViewGroup mSpeedTipImage;
    private ImageView mTipImage;
    /* access modifiers changed from: private */
    public TextView mTipMessage;
    private int stringLightingRes;

    @Retention(RetentionPolicy.SOURCE)
    @interface TipImageType {
    }

    private void adjustViewBackground(int i) {
        int uiStyle = DataRepository.dataItemRunning().getUiStyle();
        if (uiStyle == 1 || uiStyle == 3) {
            this.mQrCodeButton.setBackgroundResource(R.drawable.btn_camera_mode_exit_full_screen);
            this.mMimojiTextview.setBackgroundResource(R.drawable.btn_camera_mode_exit);
            return;
        }
        this.mQrCodeButton.setBackgroundResource(R.drawable.btn_camera_mode_exit);
        this.mMimojiTextview.setBackgroundResource(R.drawable.btn_camera_mode_exit);
    }

    private void closeFilter() {
        showCloseTip(1, false);
        ModeProtocol.ConfigChanges configChanges = (ModeProtocol.ConfigChanges) ModeCoordinatorImpl.getInstance().getAttachProtocol(164);
        if (configChanges != null) {
            configChanges.showOrHideFilter();
        }
    }

    private void closeLight() {
        showCloseTip(2, false);
        ModeProtocol.ConfigChanges configChanges = (ModeProtocol.ConfigChanges) ModeCoordinatorImpl.getInstance().getAttachProtocol(164);
        if (configChanges != null) {
            configChanges.showOrHideLighting(false);
        }
        updateLeftTipImage();
    }

    private boolean currentIsIDCardShow() {
        return this.mTipImage.getTag() != null && ((Integer) this.mTipImage.getTag()).intValue() == 4;
    }

    private int getLeftImageIntroWide() {
        this.mLeftImageIntroContent.measure(0, 0);
        int measuredWidth = this.mLeftImageIntroContent.getMeasuredWidth();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.popup_tip_beauty_intro_left_padding);
        return measuredWidth + dimensionPixelSize + getResources().getDimensionPixelSize(R.dimen.popup_tip_beauty_intro_right_padding) + ((this.mLeftImageIntroRadius - dimensionPixelSize) * 2);
    }

    private int getTipBottomMargin(int i) {
        int dimensionPixelSize;
        int i2;
        int dimensionPixelSize2;
        ModeProtocol.DualController dualController = (ModeProtocol.DualController) ModeCoordinatorImpl.getInstance().getAttachProtocol(182);
        ModeProtocol.ManuallyAdjust manuallyAdjust = (ModeProtocol.ManuallyAdjust) ModeCoordinatorImpl.getInstance().getAttachProtocol(181);
        ModeProtocol.MiBeautyProtocol miBeautyProtocol = (ModeProtocol.MiBeautyProtocol) ModeCoordinatorImpl.getInstance().getAttachProtocol(194);
        ModeProtocol.BokehFNumberController bokehFNumberController = (ModeProtocol.BokehFNumberController) ModeCoordinatorImpl.getInstance().getAttachProtocol(210);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.beauty_extra_tip_bottom_margin);
        int i3 = this.mCurrentMode;
        if (i3 == 165) {
            if (CameraSettings.isUltraWideConfigOpen(i3)) {
                ImageView imageView = this.mCenterTipImage;
                if (!(imageView == null || imageView.getVisibility() == 0) || HybridZoomingSystem.IS_3_OR_MORE_SAT) {
                    dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.manually_indicator_layout_height) / 2;
                    i2 = i / 2;
                }
            }
            int i4 = Util.sWindowWidth;
            return getResources().getDimensionPixelSize(R.dimen.tips_margin_bottom_normal) + ((((int) (((float) i4) / 0.75f)) - i4) / 2);
        } else if (manuallyAdjust != null && manuallyAdjust.visibleHeight() > 0) {
            return manuallyAdjust.visibleHeight();
        } else {
            if (this.mCenterTipImage.getVisibility() == 0) {
                if (miBeautyProtocol == null || !miBeautyProtocol.isBeautyPanelShow()) {
                    return this.mTipImage.getHeight();
                }
                dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.beauty_fragment_height);
            } else if (dualController != null && dualController.isZoomVisible()) {
                return dualController.visibleHeight();
            } else {
                if (bokehFNumberController != null && bokehFNumberController.isFNumberVisible()) {
                    return bokehFNumberController.getBokehFButtonHeight();
                }
                ModeProtocol.MakeupProtocol makeupProtocol = (ModeProtocol.MakeupProtocol) ModeCoordinatorImpl.getInstance().getAttachProtocol(180);
                if (makeupProtocol != null && makeupProtocol.isSeekBarVisible()) {
                    return getResources().getDimensionPixelSize(R.dimen.beautycamera_popup_fragment_height) + getResources().getDimensionPixelSize(R.dimen.beauty_fragment_height);
                } else if (miBeautyProtocol == null || !miBeautyProtocol.isBeautyPanelShow()) {
                    dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.manually_indicator_layout_height) / 2;
                    i2 = i / 2;
                } else {
                    dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.beauty_fragment_height);
                }
            }
            return dimensionPixelSize2 + dimensionPixelSize3;
        }
        return dimensionPixelSize - i2;
    }

    private void hideAllTipImage() {
        hideTipImage();
        hideLeftTipImage();
        directHideLeftImageIntro();
        hideSpeedTipImage();
        hideTip(this.mTipMessage);
        hideZoomTipImage(this.mCurrentMode);
        hideCenterTipImage();
    }

    private boolean hideTip(View view) {
        if (view.getVisibility() == 8) {
            return false;
        }
        view.setVisibility(8);
        return true;
    }

    private void hideZoomTipImage(int i) {
        if (i != 165) {
            if (i != 166) {
                if (i != 173) {
                    if (!(i == 174 || i == 183)) {
                        switch (i) {
                            case 161:
                            case 162:
                                break;
                            case 163:
                                break;
                            default:
                                return;
                        }
                    }
                }
            } else if (!DataRepository.dataItemFeature().ad()) {
                return;
            }
            if (!HybridZoomingSystem.IS_3_OR_MORE_SAT) {
                return;
            }
        }
        ModeProtocol.DualController dualController = (ModeProtocol.DualController) ModeCoordinatorImpl.getInstance().getAttachProtocol(182);
        if (dualController != null) {
            dualController.hideZoomButton();
            ModeProtocol.TopAlert topAlert = (ModeProtocol.TopAlert) ModeCoordinatorImpl.getInstance().getAttachProtocol(172);
            if (topAlert != null) {
                topAlert.alertUpdateValue(2);
            }
        }
    }

    private boolean isPortraitSuccessHintVisible() {
        return this.mPortraitSuccessHint.getVisibility() == 0;
    }

    private void onLeftImageClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        ModeProtocol.ConfigChanges configChanges = (ModeProtocol.ConfigChanges) ModeCoordinatorImpl.getInstance().getAttachProtocol(164);
        if (intValue != 33) {
            switch (intValue) {
                case 19:
                    if (configChanges != null) {
                        configChanges.onConfigChanged(203);
                        return;
                    }
                    return;
                case 20:
                    int i = this.mCloseType;
                    if (i == 1) {
                        closeFilter();
                        return;
                    } else if (i == 2) {
                        closeLight();
                        return;
                    } else {
                        return;
                    }
                case 21:
                    if (configChanges != null && !HybridZoomingSystem.IS_3_OR_MORE_SAT) {
                        configChanges.onConfigChanged(205);
                        return;
                    }
                    return;
                case 22:
                    if (DataRepository.dataItemFeature().Hd()) {
                        hideAllTipImage();
                        showKaleidoscope();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else {
            hideAllTipImage();
            CameraStatUtils.trackMiLiveClick(MistatsConstants.MiLive.VALUE_MI_LIVE_CLICK_SPEED);
            showLiveSpeed();
        }
    }

    private void reConfigBottomTipOf960FPS() {
        if (CameraSettings.isFPS960(this.mCurrentMode)) {
            showTips(9, (int) R.string.fps960_toast, 4);
        }
    }

    private void reConfigBottomTipOfMacro() {
        if (!CameraSettings.isMacroModeEnabled(this.mCurrentMode)) {
        }
    }

    private void reConfigBottomTipOfMimoji() {
        if (this.mCurrentMode == 177 && DataRepository.dataItemLive().getMimojiStatusManager().IsInMimojiPreview()) {
            if (DataRepository.dataItemLive().getMimojiStatusManager().getMimojiPannelState()) {
                hideAllTipImage();
            } else {
                showTips(19, (int) R.string.mimoji_tips, 2);
            }
        }
    }

    private void reIntTipViewMarginBottom(View view, int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int tipBottomMargin = getTipBottomMargin(i);
        if (marginLayoutParams.bottomMargin != tipBottomMargin) {
            marginLayoutParams.bottomMargin = tipBottomMargin;
            view.setLayoutParams(marginLayoutParams);
        }
    }

    /* access modifiers changed from: private */
    public void setBeautyIntroButtonWidth(View view, int i) {
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = i;
            view.setLayoutParams(layoutParams);
        }
    }

    private void showBeauty(int i) {
        ModeProtocol.ConfigChanges configChanges = (ModeProtocol.ConfigChanges) ModeCoordinatorImpl.getInstance().getAttachProtocol(164);
        if (configChanges != null) {
            configChanges.showOrHideShine();
        }
    }

    private void showKaleidoscope() {
        CameraStatUtils.trackKaleidoscopeClick(MistatsConstants.Fun.VALUE_FUN_KALEIDOSCOPE);
        ModeProtocol.BottomMenuProtocol bottomMenuProtocol = (ModeProtocol.BottomMenuProtocol) ModeCoordinatorImpl.getInstance().getAttachProtocol(197);
        if (bottomMenuProtocol != null) {
            bottomMenuProtocol.onSwitchKaleidoscopeActionMenu(166);
        }
        ModeProtocol.BaseDelegate baseDelegate = (ModeProtocol.BaseDelegate) ModeCoordinatorImpl.getInstance().getAttachProtocol(160);
        if (baseDelegate != null) {
            baseDelegate.delegateEvent(18);
        }
    }

    private void showLiveSpeed() {
        ModeProtocol.BottomMenuProtocol bottomMenuProtocol = (ModeProtocol.BottomMenuProtocol) ModeCoordinatorImpl.getInstance().getAttachProtocol(197);
        if (bottomMenuProtocol != null) {
            bottomMenuProtocol.onSwitchLiveActionMenu(165);
        }
        ModeProtocol.BaseDelegate baseDelegate = (ModeProtocol.BaseDelegate) ModeCoordinatorImpl.getInstance().getAttachProtocol(160);
        if (baseDelegate != null) {
            baseDelegate.delegateEvent(13);
        }
    }

    private void showLiveSticker() {
        CameraStatUtils.trackLiveClick(MistatsConstants.Live.VALUE_LIVE_STICKER);
        ModeProtocol.BottomMenuProtocol bottomMenuProtocol = (ModeProtocol.BottomMenuProtocol) ModeCoordinatorImpl.getInstance().getAttachProtocol(197);
        if (bottomMenuProtocol != null) {
            bottomMenuProtocol.onSwitchLiveActionMenu(164);
        }
        ModeProtocol.BaseDelegate baseDelegate = (ModeProtocol.BaseDelegate) ModeCoordinatorImpl.getInstance().getAttachProtocol(160);
        if (baseDelegate != null) {
            baseDelegate.delegateEvent(12);
        }
        ModeProtocol.BottomPopupTips bottomPopupTips = (ModeProtocol.BottomPopupTips) ModeCoordinatorImpl.getInstance().getAttachProtocol(175);
        if (bottomPopupTips != null) {
            bottomPopupTips.directlyHideTips();
        }
    }

    private void startLeftImageIntroAnim(int i) {
        if (i != 1) {
            directShowOrHideLeftTipImage(false);
            this.mLeftImageIntro.setVisibility(0);
            if (this.mLeftImageIntroAnimator == null) {
                ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.mLeftImageIntroWidth, this.mLeftImageIntroRadius * 2});
                ofInt.setDuration(300);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mLeftImageIntroContent, "alpha", new float[]{1.0f, 0.0f});
                ofFloat.setDuration(250);
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        FragmentBottomPopupTips fragmentBottomPopupTips = FragmentBottomPopupTips.this;
                        fragmentBottomPopupTips.setBeautyIntroButtonWidth(fragmentBottomPopupTips.mLeftImageIntro, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                });
                this.mLeftImageIntroAnimator = new AnimatorSet();
                this.mLeftImageIntroAnimator.playTogether(new Animator[]{ofInt, ofFloat});
                this.mLeftImageIntroAnimator.setInterpolator(new PathInterpolator(0.25f, 0.1f, 0.25f, 0.1f));
                this.mLeftImageIntroAnimator.setStartDelay(FragmentTopAlert.HINT_DELAY_TIME);
                this.mLeftImageIntroAnimator.addListener(new AnimatorListenerAdapter() {
                    private boolean cancelled;

                    public void onAnimationCancel(Animator animator) {
                        this.cancelled = true;
                    }

                    public void onAnimationEnd(Animator animator) {
                        if (FragmentBottomPopupTips.this.canProvide() && !this.cancelled) {
                            FragmentBottomPopupTips.this.directHideLeftImageIntro();
                            FragmentBottomPopupTips.this.updateLeftTipImage();
                        }
                    }

                    public void onAnimationStart(Animator animator) {
                        this.cancelled = false;
                    }
                });
            } else {
                this.mLeftImageIntro.setAlpha(1.0f);
                this.mLeftImageIntroContent.clearAnimation();
                this.mLeftImageIntroAnimator.cancel();
            }
            this.mLeftImageIntroAnimator.start();
            CameraSettings.addPopupUltraWideIntroShowTimes();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0057, code lost:
        if (com.android.camera.data.DataRepository.dataItemLive().getMimojiStatusManager().getMimojiPannelState() == false) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x007c, code lost:
        if (r10 == false) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008b, code lost:
        if (com.android.camera.data.DataRepository.dataItemRunning().getComponentRunningShine().isVideoBeautyOpen(162) != false) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0195, code lost:
        if (r4 != false) goto L_0x01b3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01b5  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01fd  */
    private void updateCenterTipImage(int i, int i2, List<Completable> list) {
        int i3;
        boolean z;
        int i4;
        boolean z2;
        int i5 = i;
        int i6 = i2;
        List<Completable> list2 = list;
        if (i5 != 162) {
            if (i5 == 174) {
                i3 = 18;
            } else if (i5 == 177) {
                if (((ActivityBase) getActivity()).startFromKeyguard()) {
                    if (!this.INIT_TAG) {
                        this.INIT_TAG = true;
                        DataRepository.dataItemLive().getMimojiStatusManager().setCurrentMimojiCloseState();
                    }
                } else if (DataRepository.dataItemLive().getMimojiStatusManager().IsInMimojiPreview()) {
                }
                i3 = 34;
            }
            FrameLayout frameLayout = (FrameLayout) this.mRootView.findViewById(R.id.popup_center_tip_layout);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
            z = false;
            if (i3 != -1) {
                i4 = R.drawable.ic_live_sticker_on;
                if (i3 == 18) {
                    if ("".equals(CameraSettings.getCurrentLiveSticker())) {
                        i4 = R.drawable.ic_live_sticker_normal;
                    }
                    if (this.mCenterRedDot != null) {
                        boolean tTLiveStickerNeedRedDot = CameraSettings.getTTLiveStickerNeedRedDot();
                        long liveStickerRedDotTime = CameraSettings.getLiveStickerRedDotTime();
                        long currentTimeMillis = System.currentTimeMillis();
                        if ((liveStickerRedDotTime <= 0 || currentTimeMillis - liveStickerRedDotTime < 86400000) && tTLiveStickerNeedRedDot) {
                            this.mCenterRedDot.setVisibility(0);
                        }
                    }
                    if (!HybridZoomingSystem.IS_3_OR_MORE_SAT) {
                        layoutParams.gravity = 81;
                    } else {
                        layoutParams.gravity = 8388691;
                    }
                } else if (i3 == 34) {
                    String currentMimojiState = DataRepository.dataItemLive().getMimojiStatusManager().getCurrentMimojiState();
                    if (FragmentMimoji.ADD_STATE.equals(currentMimojiState) || FragmentMimoji.CLOSE_STATE.equals(currentMimojiState)) {
                        i4 = R.drawable.ic_live_sticker_normal;
                    }
                    layoutParams.gravity = 81;
                } else if (i3 != 35) {
                    z2 = true;
                    i4 = 0;
                } else {
                    layoutParams.gravity = 81;
                    layoutParams.width = (int) getResources().getDimension(R.dimen.manually_indicator_layout_width);
                    layoutParams.height = (int) getResources().getDimension(R.dimen.manually_indicator_layout_height);
                    View view = this.mCenterRedDot;
                    if (view != null) {
                        view.setVisibility(8);
                    }
                    i4 = R.drawable.ic_manually_indicator;
                }
                z2 = true;
            } else {
                View view2 = this.mCenterRedDot;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                z2 = false;
                i4 = 0;
            }
            if (i4 > 0) {
                frameLayout.requestLayout();
                this.mCenterTipImage.setImageResource(i4);
            }
            updateImageBgColor(i5, this.mCenterTipImage);
            if (this.mCenterTipImage.getTag() != null || ((Integer) this.mCenterTipImage.getTag()).intValue() != i3) {
                if (z2) {
                    if (i3 == 35) {
                        ViewCompat.setRotation(this.mTipImage, 0.0f);
                    } else {
                        ViewCompat.setRotation(this.mTipImage, (float) this.mDegree);
                    }
                }
                this.mCenterTipImage.setTag(Integer.valueOf(i3));
                if (list2 != null) {
                    if (z2) {
                        if (i6 != 165) {
                            z = true;
                        } else if (!b.isSupportedOpticalZoom()) {
                            z = true;
                        }
                    } else if (!(i6 == 165 || this.mCurrentMode == 165)) {
                        z = true;
                    }
                    if (z) {
                        AlphaInOnSubscribe.directSetResult(this.mCenterTipImage);
                        return;
                    } else if (z) {
                        AlphaOutOnSubscribe.directSetResult(this.mCenterTipImage);
                        return;
                    } else if (z) {
                        list2.add(Completable.create(new AlphaInOnSubscribe(this.mCenterTipImage)));
                        return;
                    } else if (z) {
                        list2.add(Completable.create(new AlphaInOnSubscribe(this.mCenterTipImage).setStartDelayTime(150).setDurationTime(150)));
                        return;
                    } else if (z) {
                        list2.add(Completable.create(new AlphaOutOnSubscribe(this.mCenterTipImage)));
                        return;
                    } else {
                        return;
                    }
                }
                z = true;
                if (z) {
                }
            } else {
                return;
            }
        } else {
            ModeProtocol.MiBeautyProtocol miBeautyProtocol = (ModeProtocol.MiBeautyProtocol) ModeCoordinatorImpl.getInstance().getAttachProtocol(194);
            if (miBeautyProtocol != null) {
                boolean isBeautyPanelShow = miBeautyProtocol.isBeautyPanelShow();
                if (DataRepository.dataItemRunning().getComponentRunningShine().isVideoBeautyOpen(162)) {
                }
            }
            i3 = 35;
            FrameLayout frameLayout2 = (FrameLayout) this.mRootView.findViewById(R.id.popup_center_tip_layout);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) frameLayout2.getLayoutParams();
            z = false;
            if (i3 != -1) {
            }
            if (i4 > 0) {
            }
            updateImageBgColor(i5, this.mCenterTipImage);
            if (this.mCenterTipImage.getTag() != null) {
            }
            if (z2) {
            }
            this.mCenterTipImage.setTag(Integer.valueOf(i3));
            if (list2 != null) {
            }
            z = true;
            if (z) {
            }
        }
        i3 = -1;
        FrameLayout frameLayout22 = (FrameLayout) this.mRootView.findViewById(R.id.popup_center_tip_layout);
        FrameLayout.LayoutParams layoutParams22 = (FrameLayout.LayoutParams) frameLayout22.getLayoutParams();
        z = false;
        if (i3 != -1) {
        }
        if (i4 > 0) {
        }
        updateImageBgColor(i5, this.mCenterTipImage);
        if (this.mCenterTipImage.getTag() != null) {
        }
        if (z2) {
        }
        this.mCenterTipImage.setTag(Integer.valueOf(i3));
        if (list2 != null) {
        }
        z = true;
        if (z) {
        }
    }

    private void updateImageBgColor(int i, View view) {
        int i2;
        int i3;
        if (i == 162) {
            i2 = R.drawable.bg_popup_indicator;
            i3 = R.drawable.square_module_bg_popup_indicator;
        } else {
            i2 = R.drawable.bg_popup_indicator_no_stroke;
            i3 = R.drawable.square_module_bg_popup_indicator_no_stroke;
        }
        if (i != 165) {
            view.setBackgroundResource(i2);
        } else {
            view.setBackgroundResource(i3);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:127:0x01cf, code lost:
        if (r10 != false) goto L_0x01ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0108, code lost:
        if (r4 != 34) goto L_0x0145;
     */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0181  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01ba  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x01cf  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x01d4  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x0236  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00fa  */
    private void updateLeftTipImage(int i, int i2, int i3, List<Completable> list) {
        int i4;
        int i5;
        boolean z;
        int i6;
        int i7 = i2;
        int i8 = i3;
        List<Completable> list2 = list;
        int currentCameraId = DataRepository.dataItemGlobal().getCurrentCameraId();
        boolean isNormalIntent = DataRepository.dataItemGlobal().isNormalIntent();
        boolean z2 = false;
        boolean z3 = DataRepository.dataItemFeature().isSupportUltraWide() && !HybridZoomingSystem.IS_3_OR_MORE_SAT;
        if (i7 != 165) {
            if (i7 == 169) {
                if (currentCameraId == 0 && isNormalIntent && z3 && !CameraSettings.isAutoZoomEnabled(i2)) {
                    if (this.mIsShowLeftImageIntro) {
                        startLeftImageIntroAnim(i);
                        return;
                    }
                    i4 = 21;
                    i5 = R.drawable.ic_live_sticker_normal;
                    if (i4 == -1) {
                    }
                    if (i5 > 0) {
                    }
                    this.mLeftTipImage.setContentDescription(getString(i6));
                    updateImageBgColor(i7, this.mLeftTipImage);
                    if (this.mLeftTipImage.getTag() != null) {
                    }
                    if (z) {
                    }
                    this.mLeftTipImage.setTag(Integer.valueOf(i4));
                    if (list2 == null) {
                    }
                    z2 = true;
                    if (!z2) {
                    }
                }
                i4 = -1;
                i5 = R.drawable.ic_live_sticker_normal;
                if (i4 == -1) {
                }
                if (i5 > 0) {
                }
                this.mLeftTipImage.setContentDescription(getString(i6));
                updateImageBgColor(i7, this.mLeftTipImage);
                if (this.mLeftTipImage.getTag() != null) {
                }
                if (z) {
                }
                this.mLeftTipImage.setTag(Integer.valueOf(i4));
                if (list2 == null) {
                }
                z2 = true;
                if (!z2) {
                }
            } else if (i7 == 171) {
                if (isNormalIntent && (currentCameraId == 0 ? DataRepository.dataItemFeature().oe() : !(currentCameraId != 1 || !DataRepository.dataItemFeature().pe()))) {
                    i4 = 19;
                    i5 = R.drawable.ic_live_sticker_normal;
                    if (i4 == -1) {
                    }
                    if (i5 > 0) {
                    }
                    this.mLeftTipImage.setContentDescription(getString(i6));
                    updateImageBgColor(i7, this.mLeftTipImage);
                    if (this.mLeftTipImage.getTag() != null) {
                    }
                    if (z) {
                    }
                    this.mLeftTipImage.setTag(Integer.valueOf(i4));
                    if (list2 == null) {
                    }
                    z2 = true;
                    if (!z2) {
                    }
                }
                i4 = -1;
                i5 = R.drawable.ic_live_sticker_normal;
                if (i4 == -1) {
                }
                if (i5 > 0) {
                }
                this.mLeftTipImage.setContentDescription(getString(i6));
                updateImageBgColor(i7, this.mLeftTipImage);
                if (this.mLeftTipImage.getTag() != null) {
                }
                if (z) {
                }
                this.mLeftTipImage.setTag(Integer.valueOf(i4));
                if (list2 == null) {
                }
                z2 = true;
                if (!z2) {
                }
            } else if (i7 == 174) {
                if (z3 && currentCameraId == 0) {
                    if (this.mIsShowLeftImageIntro) {
                        startLeftImageIntroAnim(i);
                        return;
                    }
                    i4 = 21;
                    i5 = R.drawable.ic_live_sticker_normal;
                    if (i4 == -1) {
                    }
                    if (i5 > 0) {
                    }
                    this.mLeftTipImage.setContentDescription(getString(i6));
                    updateImageBgColor(i7, this.mLeftTipImage);
                    if (this.mLeftTipImage.getTag() != null) {
                    }
                    if (z) {
                    }
                    this.mLeftTipImage.setTag(Integer.valueOf(i4));
                    if (list2 == null) {
                    }
                    z2 = true;
                    if (!z2) {
                    }
                }
                i4 = -1;
                i5 = R.drawable.ic_live_sticker_normal;
                if (i4 == -1) {
                }
                if (i5 > 0) {
                }
                this.mLeftTipImage.setContentDescription(getString(i6));
                updateImageBgColor(i7, this.mLeftTipImage);
                if (this.mLeftTipImage.getTag() != null) {
                }
                if (z) {
                }
                this.mLeftTipImage.setTag(Integer.valueOf(i4));
                if (list2 == null) {
                }
                z2 = true;
                if (!z2) {
                }
            } else if (i7 != 183) {
                switch (i7) {
                    case 161:
                        if (!z3 || currentCameraId != 0) {
                            if (DataRepository.dataItemFeature().Hd()) {
                                i4 = 22;
                                break;
                            }
                        } else if (this.mIsShowLeftImageIntro) {
                            startLeftImageIntroAnim(i);
                            return;
                        }
                        break;
                    case 162:
                        if (!CameraSettings.isMacroModeEnabled(i2) && currentCameraId == 0 && isNormalIntent && z3 && !CameraSettings.isAutoZoomEnabled(i2) && !CameraSettings.isSuperEISEnabled(i2)) {
                            if (this.mIsShowLeftImageIntro) {
                                startLeftImageIntroAnim(i);
                                return;
                            }
                        }
                        break;
                    case 163:
                        break;
                }
            } else {
                if (!DataRepository.dataItemFeature().Tb()) {
                    i4 = 33;
                    i5 = R.drawable.ic_live_sticker_normal;
                    if (i4 == -1) {
                        if (i4 != 18) {
                            if (i4 == 19) {
                                i5 = R.drawable.ic_light;
                                i6 = R.string.accessibility_lighting_panel_on;
                                z = true;
                            } else if (i4 != 21) {
                                if (i4 != 22) {
                                    if (i4 == 33) {
                                        i5 = CameraSettings.getCurrentLiveSpeed().equals(String.valueOf(2)) ? R.drawable.ic_live_speed_normal : R.drawable.ic_live_speed_mod;
                                    }
                                } else if (DataRepository.dataItemFeature().Hd()) {
                                    i5 = DataRepository.dataItemRunning().getComponentRunningKaleidoscope().isSwitchOn() ? R.drawable.ic_wht_on : R.drawable.ic_wht_normal;
                                }
                                z = true;
                                i5 = 0;
                                i6 = 0;
                            } else {
                                boolean isUltraWideConfigOpen = CameraSettings.isUltraWideConfigOpen(this.mCurrentMode);
                                z = true;
                                int i9 = isUltraWideConfigOpen ? R.drawable.icon_config_ultra_wide_on : R.drawable.icon_config_ultra_wide_off;
                                i6 = isUltraWideConfigOpen ? R.string.accessibility_ultra_wide_on : R.string.accessibility_ultra_wide_off;
                                i5 = i9;
                            }
                        } else if (!"".equals(CameraSettings.getCurrentLiveSticker())) {
                            i5 = R.drawable.ic_live_sticker_on;
                        }
                        z = true;
                        i6 = 0;
                    } else {
                        i5 = 0;
                        i6 = 0;
                        z = false;
                    }
                    if (i5 > 0) {
                        this.mLeftTipImage.setImageResource(i5);
                    }
                    if (i6 > 0 && Util.isAccessible()) {
                        this.mLeftTipImage.setContentDescription(getString(i6));
                    }
                    updateImageBgColor(i7, this.mLeftTipImage);
                    if (this.mLeftTipImage.getTag() != null || ((Integer) this.mLeftTipImage.getTag()).intValue() != i4) {
                        if (z) {
                            ViewCompat.setRotation(this.mLeftTipImage, (float) this.mDegree);
                        }
                        this.mLeftTipImage.setTag(Integer.valueOf(i4));
                        if (list2 == null) {
                            if (z) {
                                if (i8 != 165) {
                                    z2 = true;
                                } else if (!b.isSupportedOpticalZoom()) {
                                    z2 = true;
                                }
                                directHideLeftImageIntro();
                            } else if (!(i8 == 165 || this.mCurrentMode == 165)) {
                                z2 = true;
                            }
                            if (!z2) {
                                AlphaInOnSubscribe.directSetResult(this.mLeftTipImage);
                                return;
                            } else if (z2) {
                                AlphaOutOnSubscribe.directSetResult(this.mLeftTipImage);
                                return;
                            } else if (z2) {
                                list2.add(Completable.create(new AlphaInOnSubscribe(this.mLeftTipImage)));
                                return;
                            } else if (z2) {
                                list2.add(Completable.create(new AlphaInOnSubscribe(this.mLeftTipImage).setStartDelayTime(150).setDurationTime(150)));
                                return;
                            } else if (z2) {
                                list2.add(Completable.create(new AlphaOutOnSubscribe(this.mLeftTipImage)));
                                return;
                            } else {
                                return;
                            }
                        }
                        z2 = true;
                        if (!z2) {
                        }
                    } else {
                        return;
                    }
                }
                i4 = -1;
                i5 = R.drawable.ic_live_sticker_normal;
                if (i4 == -1) {
                }
                if (i5 > 0) {
                }
                this.mLeftTipImage.setContentDescription(getString(i6));
                updateImageBgColor(i7, this.mLeftTipImage);
                if (this.mLeftTipImage.getTag() != null) {
                }
                if (z) {
                }
                this.mLeftTipImage.setTag(Integer.valueOf(i4));
                if (list2 == null) {
                }
                z2 = true;
                if (!z2) {
                }
            }
        }
        if (!CameraSettings.isMacroModeEnabled(i2) && !CameraSettings.isUltraPixelRearOn() && z3 && currentCameraId == 0) {
            if (this.mIsShowLeftImageIntro) {
                startLeftImageIntroAnim(i);
                return;
            }
            i4 = 21;
            i5 = R.drawable.ic_live_sticker_normal;
            if (i4 == -1) {
            }
            if (i5 > 0) {
            }
            this.mLeftTipImage.setContentDescription(getString(i6));
            updateImageBgColor(i7, this.mLeftTipImage);
            if (this.mLeftTipImage.getTag() != null) {
            }
            if (z) {
            }
            this.mLeftTipImage.setTag(Integer.valueOf(i4));
            if (list2 == null) {
            }
            z2 = true;
            if (!z2) {
            }
        }
        i4 = -1;
        i5 = R.drawable.ic_live_sticker_normal;
        if (i4 == -1) {
        }
        if (i5 > 0) {
        }
        this.mLeftTipImage.setContentDescription(getString(i6));
        updateImageBgColor(i7, this.mLeftTipImage);
        if (this.mLeftTipImage.getTag() != null) {
        }
        if (z) {
        }
        this.mLeftTipImage.setTag(Integer.valueOf(i4));
        if (list2 == null) {
        }
        z2 = true;
        if (!z2) {
        }
    }

    private void updateLightingPattern(boolean z, boolean z2) {
        if (z) {
            this.stringLightingRes = -1;
        }
        if (!DataRepository.dataItemRunning().getComponentRunningLighting().getComponentValue(171).equals("0")) {
            if (isLandScape()) {
                starAnimatetViewGone(this.mLightingPattern, z2);
            } else if (this.stringLightingRes > 0) {
                startAnimateViewVisible(this.mLightingPattern, z2);
            }
        }
    }

    private void updateSpeedTipImage(int i, int i2, List<Completable> list) {
        boolean z;
        boolean z2;
        int i3;
        int i4 = (i == 161 ? !DataRepository.dataItemFeature().Pb() : i != 174 && (i != 183 || !DataRepository.dataItemFeature().Tb())) ? -1 : 33;
        boolean z3 = false;
        if (i4 == -1) {
            z = true;
            i3 = 0;
            z2 = false;
        } else if (i4 != 33) {
            z2 = true;
            z = true;
            i3 = 0;
        } else {
            i3 = R.layout.bottom_popup_tips_center_live_speed;
            z2 = true;
            z = false;
        }
        boolean z4 = this.mSpeedTipImage.getTag() == null || ((Integer) this.mSpeedTipImage.getTag()).intValue() != i4;
        if (z4) {
            this.mSpeedTipImage.removeAllViews();
            if (i3 > 0) {
                this.mSpeedTipImage.addView(LayoutInflater.from(getContext()).inflate(i3, (ViewGroup) null));
            }
        }
        if (i4 == 33) {
            ((TextView) this.mSpeedTipImage.findViewById(R.id.live_speed_text)).setText(CameraSettings.getCurrentLiveSpeedText());
            ImageView imageView = (ImageView) this.mSpeedTipImage.findViewById(R.id.icon);
            if (CameraSettings.getCurrentLiveSpeed().equals(String.valueOf(2))) {
                imageView.setImageResource(R.drawable.ic_live_speed_normal);
            } else {
                imageView.setImageResource(R.drawable.ic_live_speed_mod);
            }
        }
        if (z4) {
            if (!z2 || !z) {
                ViewCompat.setRotation(this.mSpeedTipImage, 0.0f);
            } else {
                ViewCompat.setRotation(this.mSpeedTipImage, (float) this.mDegree);
            }
            this.mSpeedTipImage.setTag(Integer.valueOf(i4));
            if (list == null) {
                if (!z2) {
                    z3 = true;
                }
            } else if (!z2) {
                z3 = true;
            } else if (i2 != 163) {
                z3 = true;
            } else if (!b.isSupportedOpticalZoom()) {
                z3 = true;
            }
            if (!z3) {
                AlphaInOnSubscribe.directSetResult(this.mSpeedTipImage);
            } else if (z3) {
                AlphaOutOnSubscribe.directSetResult(this.mSpeedTipImage);
            } else if (z3) {
                list.add(Completable.create(new AlphaInOnSubscribe(this.mSpeedTipImage)));
            } else if (z3) {
                list.add(Completable.create(new AlphaInOnSubscribe(this.mSpeedTipImage).setStartDelayTime(150).setDurationTime(150)));
            } else if (z3) {
                list.add(Completable.create(new AlphaOutOnSubscribe(this.mSpeedTipImage)));
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002f, code lost:
        if (com.android.camera.CameraSettings.isSuperEISEnabled(r12) == false) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003e, code lost:
        if (com.android.camera.data.DataRepository.dataItemRunning().supportPopShineEntry() != false) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0049, code lost:
        if (com.android.camera.data.DataRepository.dataItemRunning().supportPopShineEntry() == false) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004b, code lost:
        r4 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0055, code lost:
        if (com.android.camera.data.DataRepository.dataItemRunning().supportPopShineEntry() != false) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0074, code lost:
        if (com.android.camera.data.DataRepository.dataItemRunning().supportPopShineEntry() != false) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0108, code lost:
        if (r9 != false) goto L_0x0124;
     */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x016c  */
    private void updateTipImage(int i, int i2, List<Completable> list) {
        int i3;
        boolean z;
        boolean z2;
        int i4;
        int i5;
        if (i != 165) {
            if (i != 171) {
                if (!(i == 174 || i == 183)) {
                    if (i != 176) {
                        if (i != 177) {
                            switch (i) {
                                case 162:
                                    if (!CameraSettings.isAutoZoomEnabled(i)) {
                                        if (!CameraSettings.isMacroModeEnabled(i)) {
                                            break;
                                        }
                                    }
                                    break;
                                case 161:
                                    break;
                                case 163:
                                    break;
                            }
                        } else {
                            updateCenterTipImage(i, i2, list);
                        }
                    }
                    i3 = -1;
                    z = false;
                    if (i3 != -1) {
                        if (i3 == 34) {
                            i5 = DataRepository.dataItemRunning().getComponentRunningShine().getBottomEntryRes(i);
                        } else if (i3 == 2) {
                            i5 = R.drawable.ic_beauty_sticker;
                        } else if (i3 == 3) {
                            i5 = DataRepository.dataItemRunning().getComponentRunningShine().getBottomEntryRes(i);
                            i4 = R.string.accessibility_beauty_panel_open;
                            z2 = true;
                        } else if (i3 != 4) {
                            z2 = true;
                            i5 = 0;
                            i4 = 0;
                        } else {
                            i5 = R.drawable.id_card_mode;
                        }
                        z2 = true;
                        i4 = 0;
                    } else {
                        i5 = 0;
                        i4 = 0;
                        z2 = false;
                    }
                    if (i5 > 0) {
                        this.mTipImage.setImageResource(i5);
                    }
                    if (i4 > 0 && Util.isAccessible()) {
                        this.mTipImage.setContentDescription(getString(i4));
                    }
                    updateImageBgColor(i, this.mTipImage);
                    if (this.mTipImage.getTag() != null || ((Integer) this.mTipImage.getTag()).intValue() != i3) {
                        if (z2) {
                            if (i3 == 4) {
                                ViewCompat.setRotation(this.mTipImage, 0.0f);
                            } else {
                                ViewCompat.setRotation(this.mTipImage, (float) this.mDegree);
                            }
                        }
                        this.mTipImage.setTag(Integer.valueOf(i3));
                        if (list != null) {
                            if (z2) {
                                if (i2 != 165) {
                                    z = true;
                                } else if (!b.isSupportedOpticalZoom()) {
                                    z = true;
                                }
                            } else if (!(i2 == 165 || this.mCurrentMode == 165)) {
                                z = true;
                            }
                            if (z) {
                                AlphaInOnSubscribe.directSetResult(this.mTipImage);
                                return;
                            } else if (z) {
                                AlphaOutOnSubscribe.directSetResult(this.mTipImage);
                                return;
                            } else if (z) {
                                list.add(Completable.create(new AlphaInOnSubscribe(this.mTipImage)));
                                return;
                            } else if (z) {
                                list.add(Completable.create(new AlphaInOnSubscribe(this.mTipImage).setStartDelayTime(150).setDurationTime(150)));
                                return;
                            } else if (z) {
                                list.add(Completable.create(new AlphaOutOnSubscribe(this.mTipImage)));
                                return;
                            } else {
                                return;
                            }
                        }
                        z = true;
                        if (z) {
                        }
                    } else {
                        return;
                    }
                }
            }
        }
        if (!CameraSettings.isMacroModeEnabled(i) && !CameraSettings.isUltraPixelPortraitFrontOn()) {
            if (this.mNeedShowIDCardTip) {
                i3 = 4;
                z = false;
                if (i3 != -1) {
                }
                if (i5 > 0) {
                }
                this.mTipImage.setContentDescription(getString(i4));
                updateImageBgColor(i, this.mTipImage);
                if (this.mTipImage.getTag() != null) {
                }
                if (z2) {
                }
                this.mTipImage.setTag(Integer.valueOf(i3));
                if (list != null) {
                }
                z = true;
                if (z) {
                }
            }
        }
        i3 = -1;
        z = false;
        if (i3 != -1) {
        }
        if (i5 > 0) {
        }
        this.mTipImage.setContentDescription(getString(i4));
        updateImageBgColor(i, this.mTipImage);
        if (this.mTipImage.getTag() != null) {
        }
        if (z2) {
        }
        this.mTipImage.setTag(Integer.valueOf(i3));
        if (list != null) {
        }
        z = true;
        if (z) {
        }
    }

    public boolean containTips(@StringRes int i) {
        return this.mTipMessage.getVisibility() == 0 && getString(i).equals(this.mTipMessage.getText().toString());
    }

    public void directHideCenterTipImage() {
        ImageView imageView = this.mCenterTipImage;
        if (imageView != null && imageView.getVisibility() != 4) {
            this.mCenterTipImage.setVisibility(8);
        }
    }

    public void directHideLeftImageIntro() {
        this.mIsShowLeftImageIntro = false;
        AnimatorSet animatorSet = this.mLeftImageIntroAnimator;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        if (this.mLeftImageIntro.getVisibility() == 0) {
            AlphaOutOnSubscribe.directSetResult(this.mLeftImageIntro);
        }
    }

    public void directHideLyingDirectHint() {
        this.mLyingDirectHint.setVisibility(8);
    }

    public void directHideTipImage() {
        if (this.mTipImage.getVisibility() != 4) {
            this.mTipImage.setTag(-1);
            this.mTipImage.setVisibility(4);
        }
    }

    public void directShowLeftImageIntro() {
        if (CameraSettings.isShowUltraWideIntro()) {
            this.mIsShowLeftImageIntro = true;
        }
        int i = this.mCurrentMode;
        updateLeftTipImage(0, i, i, (List<Completable>) null);
    }

    public void directShowOrHideLeftTipImage(boolean z) {
        ImageView imageView = this.mLeftTipImage;
        if (imageView != null) {
            if (z) {
                updateLeftTipImage();
                this.mLeftTipImage.setVisibility(0);
                return;
            }
            imageView.setTag(-1);
            this.mLeftTipImage.setVisibility(4);
        }
    }

    public void directlyHideTips() {
        ViewCompat.animate(this.mTipMessage).cancel();
        this.mHandler.removeCallbacksAndMessages((Object) null);
        if (this.mTipMessage.getVisibility() == 0) {
            this.mTipMessage.setVisibility(8);
            ModeProtocol.CameraModuleSpecial cameraModuleSpecial = (ModeProtocol.CameraModuleSpecial) ModeCoordinatorImpl.getInstance().getAttachProtocol(195);
            if (cameraModuleSpecial != null) {
                cameraModuleSpecial.showOrHideChip(true);
            }
            if (this.mLastTipType == 6 && !isPortraitHintVisible()) {
                showTips(this.mLastTipType, this.mLastTipMessage, 4);
            }
            this.mLastTipType = 4;
        }
    }

    public void directlyHideTips(@StringRes int i) {
        if (i <= 0 || containTips(i)) {
            directlyHideTips();
        }
    }

    public void directlyShowTips(int i, @StringRes int i2) {
        ViewCompat.animate(this.mTipMessage).cancel();
        this.mHandler.removeCallbacksAndMessages((Object) null);
        if (this.mTipMessage.getVisibility() != 0) {
            this.mLastTipType = this.mCurrentTipType;
            this.mLastTipMessage = this.mCurrentTipMessage;
            this.mCurrentTipType = i;
            this.mCurrentTipMessage = getString(i2);
            AlphaInOnSubscribe.directSetResult(this.mTipMessage);
            this.mTipMessage.setText(i2);
        }
    }

    public String getCurrentBottomTipMsg() {
        return this.mCurrentTipMessage;
    }

    public int getCurrentBottomTipType() {
        return this.mCurrentTipType;
    }

    public int getFragmentInto() {
        return 65522;
    }

    /* access modifiers changed from: protected */
    public int getLayoutResourceId() {
        return R.layout.fragment_bottom_popup_tips;
    }

    public void hideCenterTipImage() {
        ImageView imageView = this.mCenterTipImage;
        if (imageView != null && imageView.getVisibility() != 4) {
            this.mCenterTipImage.setTag(-1);
            Completable.create(new AlphaOutOnSubscribe(this.mCenterTipImage)).subscribe();
            View view = this.mCenterRedDot;
            if (view != null) {
                view.setVisibility(8);
            }
        }
    }

    public void hideLeftTipImage() {
        ImageView imageView = this.mLeftTipImage;
        if (imageView != null && imageView.getVisibility() != 4) {
            this.mLeftTipImage.setTag(-1);
            Completable.create(new AlphaOutOnSubscribe(this.mLeftTipImage)).subscribe();
        }
    }

    public void hideMimojiTip() {
        if (this.mMimojiTextview.getVisibility() != 8) {
            this.mMimojiTextview.setVisibility(8);
        }
    }

    public void hideQrCodeTip() {
        if (this.mQrCodeButton.getVisibility() != 8) {
            this.mQrCodeButton.setVisibility(8);
            String tag = getTag();
            Log.w(tag, "  hideQrCodeTip  time  : " + System.currentTimeMillis());
        }
    }

    public void hideSpeedTipImage() {
        ViewGroup viewGroup = this.mSpeedTipImage;
        if (viewGroup != null && viewGroup.getVisibility() != 4) {
            this.mSpeedTipImage.setTag(-1);
            Completable.create(new AlphaOutOnSubscribe(this.mSpeedTipImage)).subscribe();
        }
    }

    public void hideTipImage() {
        ImageView imageView = this.mTipImage;
        if (imageView != null && imageView.getVisibility() != 4) {
            this.mTipImage.setTag(-1);
            Completable.create(new AlphaOutOnSubscribe(this.mTipImage)).subscribe();
        }
    }

    /* access modifiers changed from: protected */
    public void initView(View view) {
        this.mRootView = view;
        this.mTipImage = (ImageView) view.findViewById(R.id.popup_tip_image);
        ((FrameLayout.LayoutParams) this.mTipImage.getLayoutParams()).gravity = 8388693;
        this.mLeftTipImage = (ImageView) view.findViewById(R.id.popup_left_tip_image);
        ((FrameLayout.LayoutParams) this.mLeftTipImage.getLayoutParams()).gravity = 8388691;
        this.mLeftTipImage.setImageResource(R.drawable.ic_new_effect_button_normal);
        this.mLeftTipImage.setOnClickListener(this);
        this.mSpeedTipImage = (ViewGroup) view.findViewById(R.id.popup_speed_tip_image);
        this.mSpeedTipImage.setOnClickListener(this);
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.popup_center_tip_layout);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
        if (!HybridZoomingSystem.IS_3_OR_MORE_SAT || !CameraSettings.isSupportedOpticalZoom()) {
            layoutParams.gravity = 81;
        } else {
            layoutParams.gravity = 8388691;
        }
        this.mCenterTipImage = (ImageView) viewGroup.findViewById(R.id.popup_center_tip_image);
        this.mCenterTipImage.setOnClickListener(this);
        this.mCenterRedDot = viewGroup.findViewById(R.id.popup_center_red_dot);
        this.mLeftImageIntro = (FrameLayout) view.findViewById(R.id.popup_left_tip_intro);
        this.mLeftImageIntro.setOnClickListener(this);
        this.mLeftImageIntroContent = (TextView) view.findViewById(R.id.popup_left_tip_intro_text);
        this.mLeftImageIntroRadius = getResources().getDimensionPixelSize(R.dimen.popup_tip_beauty_intro_radius);
        this.mLeftImageIntroWidth = getLeftImageIntroWide();
        this.mQrCodeButton = (TextView) view.findViewById(R.id.popup_tips_qrcode);
        this.mMimojiTextview = (TextView) view.findViewById(R.id.popup_tips_mimoji);
        this.mLyingDirectHint = (TextView) view.findViewById(R.id.bottom_lying_direct_hint_text);
        this.mTipMessage = (TextView) view.findViewById(R.id.popup_tips_message);
        this.mPortraitSuccessHint = view.findViewById(R.id.portrait_success_hint);
        this.mLightingPattern = (TextView) view.findViewById(R.id.lighting_pattern);
        ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin = Util.getBottomHeight();
        this.mTipImage.setOnClickListener(this);
        this.mQrCodeButton.setOnClickListener(this);
        adjustViewBackground(this.mCurrentMode);
        provideAnimateElement(this.mCurrentMode, (List<Completable>) null, 2);
        if (((ActivityBase) getContext()).getCameraIntentManager().isFromScreenSlide().booleanValue()) {
            Util.startScreenSlideAlphaInAnimation(this.mTipImage);
        }
        this.mBottomTipHeight = getResources().getDimensionPixelSize(R.dimen.portrait_hint_height);
    }

    public boolean isLightingHintVisible() {
        ModeProtocol.VerticalProtocol verticalProtocol = (ModeProtocol.VerticalProtocol) ModeCoordinatorImpl.getInstance().getAttachProtocol(198);
        return (verticalProtocol != null ? verticalProtocol.isAnyViewVisible() : false) || this.mLightingPattern.getVisibility() == 0;
    }

    public boolean isPortraitHintVisible() {
        return this.mPortraitSuccessHint.getVisibility() == 0;
    }

    public boolean isQRTipVisible() {
        TextView textView = this.mQrCodeButton;
        return textView != null && textView.getVisibility() == 0;
    }

    public boolean isTipShowing() {
        TextView textView = this.mTipMessage;
        return textView != null && textView.getVisibility() == 0;
    }

    public void notifyAfterFrameAvailable(int i) {
        super.notifyAfterFrameAvailable(i);
        reConfigBottomTipOfUltraWide();
        reConfigBottomTipOfMacro();
        reConfigBottomTipOf960FPS();
        reConfigBottomTipOfMimoji();
    }

    public void notifyDataChanged(int i, int i2) {
        super.notifyDataChanged(i, i2);
        if (i == 2) {
            directlyHideTips();
        } else if (i == 3) {
            adjustViewBackground(this.mCurrentMode);
        }
        int i3 = this.mCurrentMode;
        updateTipImage(i3, i3, (List<Completable>) null);
        int i4 = this.mCurrentMode;
        updateLeftTipImage(1, i4, i4, (List<Completable>) null);
        int i5 = this.mCurrentMode;
        updateSpeedTipImage(i5, i5, (List<Completable>) null);
        int i6 = this.mCurrentMode;
        updateCenterTipImage(i6, i6, (List<Completable>) null);
    }

    public boolean onBackEvent(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    int i2 = this.mCurrentTipType;
                    if (i2 == 6 || i2 == 7 || i2 == 11 || i2 == 9 || i2 == 12 || i2 == 18 || i2 == 10 || i2 == 13 || i2 == 17) {
                        return false;
                    }
                }
                hideTip(this.mTipMessage);
                hideTip(this.mPortraitSuccessHint);
                hideTip(this.mQrCodeButton);
                hideTip(this.mLightingPattern);
                this.mHandler.removeCallbacksAndMessages((Object) null);
            }
            return false;
        }
        if (this.mCurrentTipType == 9) {
            return false;
        }
        hideTip(this.mTipMessage);
        hideTip(this.mPortraitSuccessHint);
        hideTip(this.mQrCodeButton);
        hideTip(this.mLightingPattern);
        this.mHandler.removeCallbacksAndMessages((Object) null);
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00da, code lost:
        onLeftImageClick(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00de, code lost:
        r5 = ((java.lang.Integer) r5.getTag()).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ea, code lost:
        if (r5 == 18) goto L_0x00fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00ee, code lost:
        if (r5 == 34) goto L_0x00f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00f2, code lost:
        if (r5 == 35) goto L_0x00f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00f5, code lost:
        showOrHideVideoBeautyPanel();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00f9, code lost:
        showOrHideMimojiPanel();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00fd, code lost:
        hideAllTipImage();
        showLiveSticker();
        r4 = r4.mCenterRedDot;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0105, code lost:
        if (r4 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0107, code lost:
        r4.setVisibility(8);
        com.android.camera.CameraSettings.setTTLiveStickerNeedRedDot(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        return;
     */
    public void onClick(View view) {
        if (isEnableClick()) {
            ModeProtocol.CameraAction cameraAction = (ModeProtocol.CameraAction) ModeCoordinatorImpl.getInstance().getAttachProtocol(161);
            if (cameraAction != null && cameraAction.isDoingAction()) {
                return;
            }
            if (!CameraSettings.isFrontCamera() || !((Camera) getContext()).isScreenSlideOff()) {
                switch (view.getId()) {
                    case R.id.popup_center_tip_image:
                        break;
                    case R.id.popup_left_tip_image:
                        break;
                    case R.id.popup_left_tip_intro:
                        view.setTag(21);
                        CameraSettings.setPopupUltraWideIntroClicked();
                        directHideLeftImageIntro();
                        break;
                    case R.id.popup_speed_tip_image:
                        if (((Integer) view.getTag()).intValue() == 33) {
                            hideAllTipImage();
                            CameraStatUtils.trackLiveClick(MistatsConstants.Live.VALUE_LIVE_SPEED);
                            showLiveSpeed();
                            break;
                        }
                        break;
                    case R.id.popup_tip_image:
                        int intValue = ((Integer) view.getTag()).intValue();
                        hideAllTipImage();
                        CameraSettings.setPopupTipBeautyIntroClicked();
                        ModeProtocol.BaseDelegate baseDelegate = (ModeProtocol.BaseDelegate) ModeCoordinatorImpl.getInstance().getAttachProtocol(160);
                        if (intValue == 2) {
                            baseDelegate.delegateEvent(4);
                            return;
                        } else if (intValue == 3) {
                            hideQrCodeTip();
                            MistatsWrapper.commonKeyTriggerEvent(MistatsConstants.BeautyAttr.VALUE_BEAUTY_SHOW_BOTTOM_BUTTON, (Object) null, (String) null);
                            showBeauty(this.mCurrentMode);
                            return;
                        } else if (intValue == 4) {
                            ((ModeProtocol.ModeChangeController) ModeCoordinatorImpl.getInstance().getAttachProtocol(179)).changeModeByNewMode(182, 0);
                            Storage.createHideFile();
                            CameraStatUtils.trackGotoIDCard();
                            return;
                        } else {
                            return;
                        }
                    case R.id.popup_tips_qrcode:
                        hideQrCodeTip();
                        HashMap hashMap = new HashMap();
                        hashMap.put(MistatsConstants.CaptureAttr.PARAM_ASD_DETECT_TIP, MistatsConstants.FeatureName.VALUE_QRCODE_DETECTED);
                        MistatsWrapper.mistatEvent(MistatsConstants.FeatureName.KEY_COMMON_TIPS, hashMap);
                        ((ModeProtocol.CameraModuleSpecial) ModeCoordinatorImpl.getInstance().getAttachProtocol(195)).showQRCodeResult();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void provideAnimateElement(int i, List<Completable> list, int i2) {
        if (i2 == 3 || this.mCurrentMode != i) {
            this.mCloseType = 0;
        }
        int i3 = this.mCurrentMode;
        super.provideAnimateElement(i, list, i2);
        if (isInModeChanging() || i2 == 3) {
            this.mIsShowLyingDirectHint = false;
            directHideLyingDirectHint();
        }
        onBackEvent(4);
        updateTipBottomMargin(0, false);
        updateTipImage(i, i3, list);
        updateLeftTipImage(0, i, i3, list);
        updateSpeedTipImage(i, i3, list);
        updateCenterTipImage(i, i3, list);
        updateLeftRightTipImageForCinematic();
    }

    /* access modifiers changed from: protected */
    public Animation provideEnterAnimation(int i) {
        if (i == 240 || i == getFragmentInto()) {
            return null;
        }
        return FragmentAnimationFactory.wrapperAnimation(161);
    }

    public void provideRotateItem(List<View> list, int i) {
        super.provideRotateItem(list, i);
        if (this.mTipImage.getVisibility() == 0 && !currentIsIDCardShow()) {
            list.add(this.mTipImage);
        }
        ImageView imageView = this.mLeftTipImage;
        if (imageView != null && imageView.getVisibility() == 0) {
            list.add(this.mLeftTipImage);
        }
        ViewGroup viewGroup = this.mSpeedTipImage;
        if (!(viewGroup == null || viewGroup.getVisibility() != 0 || ((Integer) this.mSpeedTipImage.getTag()).intValue() == 33)) {
            list.add(this.mSpeedTipImage);
        }
        ImageView imageView2 = this.mCenterTipImage;
        if (!(imageView2 == null || imageView2.getVisibility() != 0 || ((Integer) this.mCenterTipImage.getTag()).intValue() == 35)) {
            list.add(this.mCenterTipImage);
        }
        updateLightingPattern(false, true);
    }

    public void reConfigBottomTipOfUltraWide() {
        if (HybridZoomingSystem.IS_3_OR_MORE_SAT) {
            int i = this.mCurrentMode;
            if (!(163 == i || 165 == i || 162 == i || 169 == i || 174 == i || 161 == i || 183 == i)) {
                return;
            }
        } else {
            int i2 = this.mCurrentMode;
            if (!(163 == i2 || 165 == i2 || 162 == i2)) {
                return;
            }
        }
        boolean isAutoZoomEnabled = CameraSettings.isAutoZoomEnabled(this.mCurrentMode);
        if ((162 != this.mCurrentMode || !isAutoZoomEnabled) && !CameraSettings.isSuperEISEnabled(this.mCurrentMode) && !CameraSettings.isMacroModeEnabled(this.mCurrentMode)) {
            if (HybridZoomingSystem.IS_3_OR_MORE_SAT) {
                if (HybridZoomingSystem.toFloat(HybridZoomingSystem.getZoomRatioHistory(this.mCurrentMode, "1.0"), 1.0f) >= 1.0f) {
                    return;
                }
            } else if (!CameraSettings.isUltraWideConfigOpen(this.mCurrentMode)) {
                return;
            }
            ModeProtocol.MiBeautyProtocol miBeautyProtocol = (ModeProtocol.MiBeautyProtocol) ModeCoordinatorImpl.getInstance().getAttachProtocol(194);
            if (miBeautyProtocol != null && miBeautyProtocol.isBeautyPanelShow()) {
                return;
            }
            if (!HybridZoomingSystem.IS_3_OR_MORE_SAT) {
                showTips(13, (int) R.string.ultra_wide_open_tip, 4);
            } else if (CameraSettings.shouldShowUltraWideSatTip(this.mCurrentMode)) {
                showTips(13, (int) R.string.ultra_wide_open_tip_sat, 2);
            }
        }
    }

    public boolean reConfigQrCodeTip() {
        if (this.mCurrentMode == 163) {
            ModeProtocol.BottomPopupTips bottomPopupTips = (ModeProtocol.BottomPopupTips) ModeCoordinatorImpl.getInstance().getAttachProtocol(175);
            boolean z = bottomPopupTips != null && bottomPopupTips.isTipShowing() && (TextUtils.equals(this.mCurrentTipMessage, getString(R.string.ultra_wide_recommend_tip_hint)) || TextUtils.equals(this.mCurrentTipMessage, getString(R.string.ultra_wide_recommend_tip_hint_sat)));
            boolean z2 = HybridZoomingSystem.toDecimal(CameraSettings.readZoom()) == 0.6f || CameraSettings.isUltraWideConfigOpen(this.mCurrentMode);
            ModeProtocol.MakeupProtocol makeupProtocol = (ModeProtocol.MakeupProtocol) ModeCoordinatorImpl.getInstance().getAttachProtocol(180);
            boolean z3 = makeupProtocol != null && makeupProtocol.isSeekBarVisible();
            ModeProtocol.MiBeautyProtocol miBeautyProtocol = (ModeProtocol.MiBeautyProtocol) ModeCoordinatorImpl.getInstance().getAttachProtocol(194);
            boolean z4 = miBeautyProtocol != null && miBeautyProtocol.isBeautyPanelShow();
            ModeProtocol.TopAlert topAlert = (ModeProtocol.TopAlert) ModeCoordinatorImpl.getInstance().getAttachProtocol(172);
            int currentAiSceneLevel = topAlert.getCurrentAiSceneLevel();
            boolean z5 = topAlert.getAlertIsShow() && (currentAiSceneLevel == -1 || currentAiSceneLevel == 23 || currentAiSceneLevel == 24 || currentAiSceneLevel == 35 || currentAiSceneLevel == -35);
            if (CameraSettings.isTiltShiftOn() || CameraSettings.isGroupShotOn() || CameraSettings.isGradienterOn() || z2 || z4 || z3 || z || z5) {
                hideQrCodeTip();
                return true;
            }
        }
        return false;
    }

    public void reInitTipImage() {
        provideAnimateElement(this.mCurrentMode, (List<Completable>) null, 2);
        reConfigBottomTipOfMacro();
        reConfigBottomTipOf960FPS();
    }

    /* access modifiers changed from: protected */
    public void register(ModeProtocol.ModeCoordinator modeCoordinator) {
        super.register(modeCoordinator);
        modeCoordinator.attachProtocol(175, this);
        registerBackStack(modeCoordinator, this);
        boolean z = DataRepository.dataItemGlobal().getBoolean("pref_camera_first_ultra_wide_use_hint_shown_key", true);
        if (CameraSettings.isShowUltraWideIntro() && !z) {
            this.mIsShowLeftImageIntro = true;
        }
    }

    public void selectBeautyTipImage(boolean z) {
        if (z) {
            this.mTipImage.setImageResource(R.drawable.ic_beauty_on);
        } else {
            this.mTipImage.setImageResource(R.drawable.ic_beauty_normal);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    public void setLightingPattern(String str) {
        char c2;
        this.stringLightingRes = -1;
        switch (str.hashCode()) {
            case 48:
                if (str.equals("0")) {
                    c2 = 0;
                    break;
                }
            case 49:
                if (str.equals("1")) {
                    c2 = 1;
                    break;
                }
            case 50:
                if (str.equals("2")) {
                    c2 = 2;
                    break;
                }
            case 51:
                if (str.equals("3")) {
                    c2 = 3;
                    break;
                }
            case 52:
                if (str.equals("4")) {
                    c2 = 4;
                    break;
                }
            case 53:
                if (str.equals("5")) {
                    c2 = 5;
                    break;
                }
            case 54:
                if (str.equals("6")) {
                    c2 = 6;
                    break;
                }
            case 55:
                if (str.equals("7")) {
                    c2 = 7;
                    break;
                }
            case 56:
                if (str.equals("8")) {
                    c2 = 8;
                    break;
                }
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                this.stringLightingRes = -1;
                break;
            case 1:
                this.stringLightingRes = R.string.lighting_pattern_nature;
                break;
            case 2:
                this.stringLightingRes = R.string.lighting_pattern_stage;
                break;
            case 3:
                this.stringLightingRes = R.string.lighting_pattern_movie;
                break;
            case 4:
                this.stringLightingRes = R.string.lighting_pattern_rainbow;
                break;
            case 5:
                this.stringLightingRes = R.string.lighting_pattern_shutter;
                break;
            case 6:
                this.stringLightingRes = R.string.lighting_pattern_dot;
                break;
            case 7:
                this.stringLightingRes = R.string.lighting_pattern_leaf;
                break;
            case 8:
                this.stringLightingRes = R.string.lighting_pattern_holi;
                break;
        }
        if (this.stringLightingRes == -1) {
            AlphaOutOnSubscribe.directSetResult(this.mLightingPattern);
            return;
        }
        this.mCurrentTipType = 12;
        hideTip(this.mTipMessage);
        hideTip(this.mPortraitSuccessHint);
        directHideTipImage();
        reIntTipViewMarginBottom(this.mLightingPattern, this.mBottomTipHeight);
        this.mLightingPattern.setText(this.stringLightingRes);
        if (!isLandScape()) {
            AlphaInOnSubscribe.directSetResult(this.mLightingPattern);
        }
    }

    public void setPortraitHintVisible(int i) {
        if ((i != 0 || !isLightingHintVisible()) && this.mCurrentTipType != 21) {
            this.mLastTipType = i == 0 ? 7 : 4;
            directlyHideTips();
            if (i == 0) {
                reIntTipViewMarginBottom(this.mPortraitSuccessHint, this.mBottomTipHeight);
            }
            this.mPortraitSuccessHint.setVisibility(i);
        }
    }

    public void showCloseTip(int i, boolean z) {
        if (!z) {
            this.mCloseType = 0;
        } else if (this.mCurrentMode != 167) {
            this.mCloseType = i;
        } else {
            return;
        }
        showOrHideCloseImage(z);
    }

    public void showIDCardTip(boolean z) {
        this.mNeedShowIDCardTip = z;
        int i = this.mCurrentMode;
        updateTipImage(i, i, (List<Completable>) null);
    }

    public void showMimojiTip() {
        if (this.mMimojiTextview.getVisibility() != 0) {
            hideTip(this.mTipMessage);
            TextView textView = this.mMimojiTextview;
            reIntTipViewMarginBottom(textView, textView.getBackground().getIntrinsicHeight());
            AlphaInOnSubscribe.directSetResult(this.mMimojiTextview);
            Completable.create(new AlphaOutOnSubscribe(this.mMimojiTextview).setStartDelayTime(3000)).subscribe();
            if (Util.isAccessible()) {
                this.mMimojiTextview.postDelayed(new Runnable() {
                    public void run() {
                        FragmentBottomPopupTips.this.mMimojiTextview.sendAccessibilityEvent(128);
                    }
                }, 100);
            }
        }
    }

    public void showOrHideCloseImage(boolean z) {
        ImageView imageView = this.mLeftTipImage;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.ic_manually_indicator);
            if (z) {
                if (Util.isAccessible() && this.mCloseType == 2) {
                    this.mLeftTipImage.setContentDescription(getString(R.string.accessibility_lighting_panel_off));
                }
                this.mLeftTipImage.setTag(20);
                Completable.create(new AlphaInOnSubscribe(this.mLeftTipImage)).subscribe();
                return;
            }
            this.mLeftTipImage.setTag(-1);
            Completable.create(new AlphaOutOnSubscribe(this.mLeftTipImage)).subscribe();
        }
    }

    public void showOrHideMimojiPanel() {
        DataRepository.dataItemLive().getMimojiStatusManager().setMimojiPannelState(true);
        hideAllTipImage();
        ModeProtocol.ConfigChanges configChanges = (ModeProtocol.ConfigChanges) ModeCoordinatorImpl.getInstance().getAttachProtocol(164);
        if (configChanges != null) {
            configChanges.showOrHideMimoji();
        }
    }

    public void showOrHideVideoBeautyPanel() {
        hideAllTipImage();
        ModeProtocol.MiBeautyProtocol miBeautyProtocol = (ModeProtocol.MiBeautyProtocol) ModeCoordinatorImpl.getInstance().getAttachProtocol(194);
        if (miBeautyProtocol != null) {
            miBeautyProtocol.show();
        } else {
            ModeProtocol.BaseDelegate baseDelegate = (ModeProtocol.BaseDelegate) ModeCoordinatorImpl.getInstance().getAttachProtocol(160);
            if (baseDelegate != null) {
                baseDelegate.delegateEvent(2);
            }
        }
        ((ModeProtocol.BottomMenuProtocol) ModeCoordinatorImpl.getInstance().getAttachProtocol(197)).expandShineBottomMenu(DataRepository.dataItemRunning().getComponentRunningShine());
    }

    public void showQrCodeTip() {
        if (!reConfigQrCodeTip() && this.mQrCodeButton.getVisibility() != 0) {
            directHideLyingDirectHint();
            hideTip(this.mTipMessage);
            TextView textView = this.mQrCodeButton;
            reIntTipViewMarginBottom(textView, textView.getBackground().getIntrinsicHeight());
            AlphaInOnSubscribe.directSetResult(this.mQrCodeButton);
            if (Util.isAccessible()) {
                this.mQrCodeButton.postDelayed(new Runnable() {
                    public void run() {
                        FragmentBottomPopupTips.this.mQrCodeButton.sendAccessibilityEvent(128);
                    }
                }, 100);
            }
        }
    }

    public void showTips(int i, @StringRes int i2, int i3) {
        showTips(i, getString(i2), i3);
    }

    public void showTips(final int i, final int i2, final int i3, int i4) {
        this.mHandler.postDelayed(new Runnable() {
            public void run() {
                FragmentBottomPopupTips.this.showTips(i, i2, i3);
            }
        }, (long) i4);
    }

    public void showTips(int i, String str, int i2) {
        int i3;
        if (!isResumed()) {
            Log.w(getTag(), "current fragment is not resumed");
        } else if (i != 6 || (this.mCurrentMode == 171 && CameraSettings.getCameraId() != 1)) {
            int i4 = this.mCurrentMode;
            if ((i4 != 171 && i4 != 169 && i4 != 162 && i4 != 180) || this.mTipMessage.getVisibility() == 8 || this.mCurrentTipType != 21) {
                if (!(i == 10 && CameraSettings.getBogusCameraId() == 0) && !isLightingHintVisible()) {
                    if (isPortraitSuccessHintVisible()) {
                        hideTip(this.mPortraitSuccessHint);
                    }
                    this.mLastTipType = this.mCurrentTipType;
                    this.mLastTipMessage = this.mCurrentTipMessage;
                    if (!TextUtils.equals(this.mLastTipMessage, getString(R.string.mimoji_start_create)) || !TextUtils.equals(str, getString(R.string.mimoji_check_normal))) {
                        this.mCurrentTipType = i;
                        this.mCurrentTipMessage = str;
                        hideTip(this.mQrCodeButton);
                        directHideLyingDirectHint();
                        reIntTipViewMarginBottom(this.mTipMessage, this.mBottomTipHeight);
                        AlphaInOnSubscribe.directSetResult(this.mTipMessage);
                        this.mTipMessage.setText(str);
                        if (Util.isAccessible()) {
                            this.mTipMessage.setContentDescription(this.mCurrentTipMessage);
                            this.mTipMessage.postDelayed(new Runnable() {
                                public void run() {
                                    if (FragmentBottomPopupTips.this.isAdded()) {
                                        FragmentBottomPopupTips.this.mTipMessage.sendAccessibilityEvent(4);
                                    }
                                }
                            }, 3000);
                        }
                        switch (i2) {
                            case 1:
                                i3 = 1000;
                                break;
                            case 2:
                                i3 = 5000;
                                break;
                            case 3:
                                i3 = 15000;
                                break;
                            case 5:
                                i3 = 2000;
                                break;
                            case 6:
                                i3 = 3000;
                                break;
                            case 7:
                                i3 = DurationConstant.DURATION_LANDSCAPE_HINT;
                                break;
                            default:
                                i3 = 0;
                                break;
                        }
                        this.mHandler.removeCallbacksAndMessages((Object) null);
                        if (i3 > 0) {
                            this.mHandler.sendEmptyMessageDelayed(1, (long) i3);
                        }
                        if (this.mCurrentMode == 163) {
                            ModeProtocol.CameraModuleSpecial cameraModuleSpecial = (ModeProtocol.CameraModuleSpecial) ModeCoordinatorImpl.getInstance().getAttachProtocol(195);
                            if (cameraModuleSpecial != null) {
                                cameraModuleSpecial.showOrHideChip(false);
                            }
                        }
                    }
                }
            }
        }
    }

    public void showTipsWithOrientation(int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            showTips(i, i2, i3, i4);
        } else if (i5 != 1) {
            if (i5 == 2 && !isLandScape()) {
                showTips(i, i2, i3, i4);
            }
        } else if (isLandScape()) {
            showTips(i, i2, i3, i4);
        }
    }

    /* access modifiers changed from: protected */
    public void unRegister(ModeProtocol.ModeCoordinator modeCoordinator) {
        super.unRegister(modeCoordinator);
        this.mHandler.removeCallbacksAndMessages((Object) null);
        modeCoordinator.detachProtocol(175, this);
        unRegisterBackStack(modeCoordinator, this);
        this.mIsShowLeftImageIntro = false;
    }

    public void updateLeftRightTipImageForCinematic() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mTipImage.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mLeftTipImage.getLayoutParams();
        if (CameraSettings.isCinematicAspectRatioEnabled(this.mCurrentMode)) {
            if (layoutParams.rightMargin != Util.getCinematicAspectRatioMargin()) {
                layoutParams.rightMargin = Util.getCinematicAspectRatioMargin();
                this.mTipImage.setLayoutParams(layoutParams);
            }
            if (layoutParams2.leftMargin != Util.getCinematicAspectRatioMargin()) {
                layoutParams2.leftMargin = Util.getCinematicAspectRatioMargin();
                this.mLeftTipImage.setLayoutParams(layoutParams2);
                return;
            }
            return;
        }
        if (layoutParams.rightMargin != 0) {
            layoutParams.rightMargin = (int) getResources().getDimension(R.dimen.popup_indicator_button_extra_margin_end);
            this.mTipImage.setLayoutParams(layoutParams);
        }
        if (layoutParams2.leftMargin != 0) {
            layoutParams2.leftMargin = 0;
            this.mLeftTipImage.setLayoutParams(layoutParams2);
        }
    }

    public void updateLeftTipImage() {
        int i = this.mCurrentMode;
        updateLeftTipImage(1, i, i, (List<Completable>) null);
    }

    public void updateLyingDirectHint(boolean z, boolean z2) {
        if (!z2) {
            this.mIsShowLyingDirectHint = z;
        }
        if (this.mIsShowLyingDirectHint) {
            ModeProtocol.DualController dualController = (ModeProtocol.DualController) ModeCoordinatorImpl.getInstance().getAttachProtocol(182);
            boolean z3 = true;
            boolean z4 = dualController != null && dualController.isSlideVisible();
            ModeProtocol.MakeupProtocol makeupProtocol = (ModeProtocol.MakeupProtocol) ModeCoordinatorImpl.getInstance().getAttachProtocol(180);
            boolean z5 = makeupProtocol != null && makeupProtocol.isSeekBarVisible();
            ModeProtocol.MiBeautyProtocol miBeautyProtocol = (ModeProtocol.MiBeautyProtocol) ModeCoordinatorImpl.getInstance().getAttachProtocol(194);
            if (miBeautyProtocol == null || !miBeautyProtocol.isBeautyPanelShow()) {
                z3 = false;
            }
            if (isTipShowing() || z4 || z5 || z3 || this.mQrCodeButton.getVisibility() == 0 || this.mLyingDirectHint.getVisibility() == 0) {
                this.mLyingDirectHint.setVisibility(8);
                return;
            }
            this.mLyingDirectHint.setRotation(180.0f);
            reIntTipViewMarginBottom(this.mLyingDirectHint, this.mBottomTipHeight);
            this.mLyingDirectHint.setVisibility(0);
            CameraStatUtils.trackLyingDirectShow(180);
        } else if (this.mLyingDirectHint.getVisibility() == 0) {
            this.mLyingDirectHint.setVisibility(8);
        }
    }

    public void updateTipBottomMargin(int i, boolean z) {
        if (this.mRootView.getPaddingTop() < i) {
            this.mRootView.setPadding(0, (int) (((float) i) * 1.2f), 0, 0);
        }
        if (!z) {
            TranslateYOnSubscribe.directSetResult(this.mRootView, -i);
        } else if (((float) i) < ViewCompat.getTranslationY(this.mRootView)) {
            Completable.create(new TranslateYOnSubscribe(this.mRootView, -i).setInterpolator(new OvershootInterpolator())).subscribe();
        } else {
            Completable.create(new TranslateYOnSubscribe(this.mRootView, -i).setInterpolator(new BackEaseOutInterpolator())).subscribe();
        }
    }

    public void updateTipImage() {
        int i = this.mCurrentMode;
        updateTipImage(i, i, (List<Completable>) null);
    }
}
