package com.android.camera.fragment;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.camera2.params.MeteringRectangle;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.text.SpannableStringBuilder;
import android.text.style.TextAppearanceSpan;
import android.util.Size;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.camera.ActivityBase;
import com.android.camera.CameraSettings;
import com.android.camera.HybridZoomingSystem;
import com.android.camera.R;
import com.android.camera.Util;
import com.android.camera.animation.type.AlphaInOnSubscribe;
import com.android.camera.animation.type.AlphaOutOnSubscribe;
import com.android.camera.animation.type.SlideInOnSubscribe;
import com.android.camera.animation.type.SlideOutOnSubscribe;
import com.android.camera.animation.type.TranslateXOnSubscribe;
import com.android.camera.data.DataRepository;
import com.android.camera.fragment.mimoji.MimojiHelper;
import com.android.camera.log.Log;
import com.android.camera.module.ModuleManager;
import com.android.camera.protocol.ModeCoordinatorImpl;
import com.android.camera.protocol.ModeProtocol;
import com.android.camera.statistic.CameraStatUtils;
import com.android.camera.ui.AfRegionsView;
import com.android.camera.ui.FaceView;
import com.android.camera.ui.FocusIndicator;
import com.android.camera.ui.FocusView;
import com.android.camera.ui.HistogramView;
import com.android.camera.ui.LightingView;
import com.android.camera.ui.ObjectView;
import com.android.camera.ui.V6EffectCropView;
import com.android.camera.ui.V6PreviewFrame;
import com.android.camera.ui.V6PreviewPanel;
import com.android.camera.ui.VideoTagView;
import com.android.camera.ui.ZoomView;
import com.android.camera.watermark.WaterMarkData;
import com.android.camera2.CameraHardwareFace;
import com.android.camera2.autozoom.AutoZoomCaptureResult;
import com.android.camera2.autozoom.AutoZoomView;
import com.bumptech.glide.c;
import com.mi.config.b;
import io.reactivex.Completable;
import java.util.List;
import miui.view.animation.QuadraticEaseInOutInterpolator;

public class FragmentMainContent extends BaseFragment implements ModeProtocol.MainContentProtocol, ModeProtocol.SnapShotIndicator, ModeProtocol.AutoZoomViewProtocol, ModeProtocol.HandleBackTrace {
    public static final int FRAGMENT_INFO = 243;
    public static final int FRONT_CAMERA_ID = 1;
    private static final String TAG = "FragmentMainContent";
    private long lastConfirmTime;
    /* access modifiers changed from: private */
    public int lastFaceResult;
    private int mActiveIndicator = 2;
    private AfRegionsView mAfRegionsView;
    private AutoZoomView mAutoZoomOverlay;
    private View mBottomCover;
    private TextView mCaptureDelayNumber;
    private ImageView mCenterHintIcon;
    private TextView mCenterHintText;
    private ViewGroup mCoverParent;
    /* access modifiers changed from: private */
    public int mCurrentMimojiFaceResult;
    private int mDisplayRectTopMargin;
    private V6EffectCropView mEffectCropView;
    private FaceView mFaceView;
    private FocusView mFocusView;
    private Handler mHandler = new Handler();
    private ValueAnimator mHistogramAnimator;
    private HistogramView mHistogramView;
    private boolean mIsHorizontal;
    private boolean mIsIntentAction;
    private boolean mIsMimojiCreateLowLight;
    private boolean mIsMimojiFaceDetectTip;
    private boolean mIsShowMainLyingDirectHint;
    private int mLastCameraId = -1;
    /* access modifiers changed from: private */
    public boolean mLastFaceSuccess;
    private int mLastTranslateY;
    private View mLeftCover;
    private LightingView mLightingView;
    private TextView mLyingDirectHint;
    private int mMimojiDetectTipType;
    private int mMimojiFaceDetect;
    private boolean mMimojiLastFaceSuccess;
    /* access modifiers changed from: private */
    public LightingView mMimojiLightingView;
    private TextView mMultiSnapNum;
    private int mNormalCoverHeight;
    private ObjectView mObjectView;
    /* access modifiers changed from: private */
    public ViewGroup mPreviewCenterHint;
    private V6PreviewFrame mPreviewFrame;
    private ViewGroup mPreviewPage;
    private V6PreviewPanel mPreviewPanel;
    private View mRightCover;
    private TextAppearanceSpan mSnapStyle;
    private SpannableStringBuilder mStringBuilder;
    private View mTopCover;
    private VideoTagView mVideoTagView;
    private AnimatorSet mZoomInAnimator;
    private AnimatorSet mZoomOutAnimator;
    private ZoomView mZoomView;
    private ZoomView mZoomViewHorizontal;
    private RectF mergeRectF = new RectF();

    /* renamed from: com.android.camera.fragment.FragmentMainContent$6  reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$com$android$camera$fragment$FragmentMainContent$CoverState = new int[CoverState.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            $SwitchMap$com$android$camera$fragment$FragmentMainContent$CoverState[CoverState.NONE.ordinal()] = 1;
            $SwitchMap$com$android$camera$fragment$FragmentMainContent$CoverState[CoverState.TB.ordinal()] = 2;
            try {
                $SwitchMap$com$android$camera$fragment$FragmentMainContent$CoverState[CoverState.LR.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    enum CoverState {
        NONE,
        TB,
        LR,
        TOP,
        BOTTOM,
        LEFT,
        RIGHT
    }

    private void adjustViewHeight() {
        if (getContext() != null) {
            V6PreviewPanel v6PreviewPanel = this.mPreviewPanel;
            if (v6PreviewPanel != null) {
                ViewGroup viewGroup = (ViewGroup) v6PreviewPanel.getParent();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewGroup.getLayoutParams();
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mPreviewPanel.getLayoutParams();
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.mPreviewCenterHint.getLayoutParams();
                Rect previewRect = Util.getPreviewRect(getContext());
                if (marginLayoutParams2.height != previewRect.height() || previewRect.top != this.mDisplayRectTopMargin) {
                    this.mDisplayRectTopMargin = previewRect.top;
                    marginLayoutParams2.height = previewRect.height();
                    marginLayoutParams2.topMargin = previewRect.top;
                    this.mPreviewPanel.setLayoutParams(marginLayoutParams2);
                    marginLayoutParams3.height = (previewRect.width() * 4) / 3;
                    this.mPreviewCenterHint.setLayoutParams(marginLayoutParams3);
                    marginLayoutParams.height = previewRect.height() + this.mDisplayRectTopMargin;
                    viewGroup.setLayoutParams(marginLayoutParams);
                    setDisplaySize(previewRect.width(), previewRect.height());
                }
            }
        }
    }

    private void consumeResult(int i, boolean z) {
        if (System.currentTimeMillis() - this.lastConfirmTime >= ((long) (z ? 700 : 1000))) {
            this.lastConfirmTime = System.currentTimeMillis();
            Log.d("faceResult:", i + "");
            if (z) {
                mimojiFaceDetectSync(161, i);
            } else if (this.lastFaceResult != i) {
                this.lastFaceResult = i;
                final LightingView lightingView = this.mLightingView;
                lightingView.post(new Runnable() {
                    public void run() {
                        ModeProtocol.TopAlert topAlert = (ModeProtocol.TopAlert) ModeCoordinatorImpl.getInstance().getAttachProtocol(172);
                        if (topAlert != null) {
                            topAlert.alertLightingHint(FragmentMainContent.this.lastFaceResult);
                        }
                        ModeProtocol.VerticalProtocol verticalProtocol = (ModeProtocol.VerticalProtocol) ModeCoordinatorImpl.getInstance().getAttachProtocol(198);
                        if (verticalProtocol != null) {
                            verticalProtocol.alertLightingHint(FragmentMainContent.this.lastFaceResult);
                        }
                    }
                });
                boolean z2 = i == 6;
                if (this.mLastFaceSuccess != z2) {
                    this.mLastFaceSuccess = z2;
                    lightingView.post(new Runnable() {
                        public void run() {
                            if (FragmentMainContent.this.mLastFaceSuccess) {
                                lightingView.triggerAnimateSuccess();
                            } else {
                                lightingView.triggerAnimateFocusing();
                            }
                        }
                    });
                }
            }
        }
    }

    private RectF getMergeRect(RectF rectF, RectF rectF2) {
        float max = Math.max(rectF.left, rectF2.left);
        float min = Math.min(rectF.right, rectF2.right);
        this.mergeRectF.set(max, Math.max(rectF.top, rectF2.top), min, Math.min(rectF.bottom, rectF2.bottom));
        return this.mergeRectF;
    }

    private void initSnapNumAnimator() {
        this.mZoomInAnimator = (AnimatorSet) AnimatorInflater.loadAnimator(getContext(), R.animator.zoom_button_zoom_in);
        this.mZoomInAnimator.setTarget(this.mMultiSnapNum);
        this.mZoomInAnimator.setInterpolator(new QuadraticEaseInOutInterpolator());
        this.mZoomOutAnimator = (AnimatorSet) AnimatorInflater.loadAnimator(getContext(), R.animator.zoom_button_zoom_out);
        this.mZoomOutAnimator.setTarget(this.mMultiSnapNum);
        this.mZoomOutAnimator.setInterpolator(new QuadraticEaseInOutInterpolator());
    }

    private boolean isMimojiFaceDetectTip() {
        boolean z = this.mIsMimojiFaceDetectTip;
        this.mIsMimojiFaceDetectTip = false;
        return z;
    }

    private boolean isRectIntersect(RectF rectF, RectF rectF2) {
        return rectF2.right >= rectF.left && rectF2.left <= rectF.right && rectF2.bottom >= rectF.top && rectF2.top <= rectF.bottom;
    }

    private boolean isReferenceLineEnabled() {
        return DataRepository.dataItemGlobal().getBoolean("pref_camera_referenceline_key", false);
    }

    /* access modifiers changed from: private */
    public synchronized void mimojiFaceDetectSync(int i, int i2) {
        int tipsResIdFace = MimojiHelper.getTipsResIdFace(i2);
        int tipsResId = MimojiHelper.getTipsResId(i2);
        if (160 == i && tipsResId == -1 && i2 != 6) {
            Log.c(TAG, "mimojiFaceDetectSync 0, faceResult = " + i2 + ", mimoji tips resId = " + tipsResId);
        } else if (161 == i && tipsResIdFace == -1 && i2 != 6) {
            Log.c(TAG, "mimojiFaceDetectSync 1, faceResult = " + i2 + ", miface tips resId = " + tipsResIdFace);
        } else if (i2 == this.mMimojiFaceDetect && i == this.mMimojiDetectTipType) {
            Log.c(TAG, "mimojiFaceDetectSync 2, faceResult = " + i2 + "type:" + i);
        } else {
            this.mMimojiDetectTipType = i;
            this.mMimojiFaceDetect = i2;
            setMimojiFaceDetectTip();
            if (i2 == 6 && MimojiHelper.getTipsResId(this.mCurrentMimojiFaceResult) == -1) {
                this.mLastFaceSuccess = true;
            } else {
                this.mLastFaceSuccess = false;
            }
            Log.d("mimojiFaceDetectSync", "face_detect_type:" + i + ",result:" + i2 + ",is_face_location_ok:" + this.mLastFaceSuccess);
        }
    }

    private boolean needReferenceLineMode() {
        return true;
    }

    private void onZoomViewOrientationChanged(int i) {
        boolean z = (i + 180) % 180 != 0;
        boolean z2 = this.mIsHorizontal;
        if (z != z2) {
            if (z2) {
                this.mZoomView.show();
                this.mZoomViewHorizontal.hide();
                this.mZoomView.setCurrentZoomRatio(this.mZoomViewHorizontal.getCurrentZoomRatio());
            } else {
                this.mZoomView.hide();
                this.mZoomViewHorizontal.show();
                this.mZoomViewHorizontal.setCurrentZoomRatio(this.mZoomView.getCurrentZoomRatio());
            }
            this.mIsHorizontal = z;
        }
    }

    private void setMimojiFaceDetectTip() {
        this.mIsMimojiFaceDetectTip = true;
    }

    private void showIndicator(FocusIndicator focusIndicator, int i) {
        if (i == 1) {
            focusIndicator.showStart();
        } else if (i == 2) {
            focusIndicator.showSuccess();
        } else if (i == 3) {
            focusIndicator.showFail();
        }
    }

    private void updateReferenceGradienterSwitched() {
        if (this.mPreviewFrame != null) {
            this.mPreviewFrame.updateReferenceGradienterSwitched(isReferenceLineEnabled() && !((ActivityBase) getContext()).getCameraIntentManager().isScanQRCodeIntent() && needReferenceLineMode(), CameraSettings.isGradienterOn(), ModuleManager.isSquareModule());
        }
    }

    public void adjustHistogram(int i) {
        if (i == 0) {
            ViewCompat.animate(this.mHistogramView).setDuration(300).translationY(0.0f).setInterpolator(new DecelerateInterpolator()).start();
        } else {
            ViewCompat.animate(this.mHistogramView).setDuration(300).translationY((float) (-getResources().getDimensionPixelSize(R.dimen.histogram_move_distance))).setInterpolator(new DecelerateInterpolator()).start();
        }
    }

    public void clearFocusView(int i) {
        this.mFocusView.clear(i);
    }

    public void clearIndicator(int i) {
        if (i == 1) {
            this.mFaceView.clear();
        } else if (i == 2) {
            throw new RuntimeException("not allowed call in this method");
        } else if (i == 3) {
            this.mObjectView.clear();
        }
    }

    public void destroyEffectCropView() {
        this.mEffectCropView.onDestroy();
    }

    public void directHideLyingDirectHint() {
        this.mLyingDirectHint.setVisibility(8);
    }

    public void feedData(AutoZoomCaptureResult autoZoomCaptureResult) {
        this.mAutoZoomOverlay.feedData(autoZoomCaptureResult);
    }

    public int getActiveIndicator() {
        return this.mActiveIndicator;
    }

    public List<WaterMarkData> getFaceWaterMarkInfos() {
        return this.mFaceView.getFaceWaterMarkInfos();
    }

    public CameraHardwareFace[] getFaces() {
        return this.mFaceView.getFaces();
    }

    public RectF getFocusRect(int i) {
        if (i == 1) {
            return this.mFaceView.getFocusRect();
        }
        if (i == 3) {
            return this.mObjectView.getFocusRect();
        }
        Log.w(TAG, getFragmentTag() + ": unexpected type " + i);
        return new RectF();
    }

    public RectF getFocusRectInPreviewFrame() {
        return this.mObjectView.getFocusRectInPreviewFrame();
    }

    public int getFragmentInto() {
        return 243;
    }

    /* access modifiers changed from: protected */
    public int getLayoutResourceId() {
        return R.layout.fragment_main_content;
    }

    public String getVideoTagContent() {
        return this.mVideoTagView.getVideoTagContent();
    }

    public void hideDelayNumber() {
        if (this.mCaptureDelayNumber.getVisibility() != 8) {
            this.mCaptureDelayNumber.setVisibility(8);
        }
    }

    public void hideReviewViews() {
        if (this.mPreviewPanel.mVideoReviewImage.getVisibility() == 0) {
            Util.fadeOut(this.mPreviewPanel.mVideoReviewImage);
        }
        Util.fadeOut(this.mPreviewPanel.mVideoReviewPlay);
    }

    public void initEffectCropView() {
        this.mEffectCropView.onCreate();
    }

    /* access modifiers changed from: protected */
    public void initView(View view) {
        this.mCoverParent = (ViewGroup) view.findViewById(R.id.cover_parent);
        this.mMultiSnapNum = (TextView) this.mCoverParent.findViewById(R.id.v6_multi_snap_number);
        this.mCaptureDelayNumber = (TextView) this.mCoverParent.findViewById(R.id.v6_capture_delay_number);
        this.mTopCover = this.mCoverParent.findViewById(R.id.top_cover_layout);
        this.mBottomCover = this.mCoverParent.findViewById(R.id.bottom_cover_layout);
        this.mLeftCover = this.mCoverParent.findViewById(R.id.left_cover_layout);
        this.mRightCover = this.mCoverParent.findViewById(R.id.right_cover_layout);
        this.mPreviewPage = (ViewGroup) view.findViewById(R.id.v6_preview_page);
        this.mPreviewPanel = (V6PreviewPanel) this.mPreviewPage.findViewById(R.id.v6_preview_panel);
        this.mPreviewFrame = (V6PreviewFrame) this.mPreviewPanel.findViewById(R.id.v6_frame_layout);
        this.mPreviewCenterHint = (ViewGroup) this.mPreviewPanel.findViewById(R.id.center_hint_placeholder);
        this.mCenterHintIcon = (ImageView) this.mPreviewCenterHint.findViewById(R.id.center_hint_icon);
        this.mCenterHintText = (TextView) this.mPreviewCenterHint.findViewById(R.id.center_hint_text);
        this.mEffectCropView = (V6EffectCropView) this.mPreviewPanel.findViewById(R.id.v6_effect_crop_view);
        this.mFaceView = (FaceView) this.mPreviewPanel.findViewById(R.id.v6_face_view);
        this.mFocusView = (FocusView) this.mPreviewPanel.findViewById(R.id.v6_focus_view);
        this.mZoomView = (ZoomView) view.findViewById(R.id.v6_zoom_view);
        this.mZoomViewHorizontal = (ZoomView) view.findViewById(R.id.v6_zoom_view_horizontal);
        this.mZoomViewHorizontal.setIsHorizonal(true);
        this.mAutoZoomOverlay = (AutoZoomView) this.mPreviewPanel.findViewById(R.id.autozoom_overlay);
        this.mHistogramView = (HistogramView) view.findViewById(R.id.rgb_histogram);
        this.mLightingView = (LightingView) this.mPreviewPanel.findChildrenById(R.id.lighting_view);
        this.mObjectView = (ObjectView) this.mPreviewPanel.findViewById(R.id.object_view);
        this.mAfRegionsView = (AfRegionsView) this.mPreviewPanel.findViewById(R.id.afregions_view);
        this.mMimojiLightingView = (LightingView) this.mPreviewPanel.findChildrenById(R.id.mimoji_lighting_view);
        this.mLyingDirectHint = (TextView) view.findViewById(R.id.main_lying_direct_hint_text);
        this.mMimojiLightingView.setCircleRatio(1.18f);
        this.mMimojiLightingView.setCircleHeightRatio(1.12f);
        this.mVideoTagView = new VideoTagView();
        this.mVideoTagView.init(view, getContext());
        this.mLightingView.setRotation(this.mDegree);
        adjustViewHeight();
        this.mNormalCoverHeight = Util.sWindowHeight - Util.getBottomHeight();
        this.mCoverParent.getLayoutParams().height = this.mNormalCoverHeight;
        ViewGroup.LayoutParams layoutParams = this.mBottomCover.getLayoutParams();
        int i = Util.sWindowWidth;
        layoutParams.height = (((int) (((float) i) / 0.75f)) - i) / 2;
        this.mTopCover.getLayoutParams().height = (this.mCoverParent.getLayoutParams().height - Util.sWindowWidth) - this.mBottomCover.getLayoutParams().height;
        this.mLeftCover.getLayoutParams().width = Util.getCinematicAspectRatioMargin();
        this.mRightCover.getLayoutParams().width = Util.getCinematicAspectRatioMargin();
        this.mIsIntentAction = DataRepository.dataItemGlobal().isIntentAction();
        provideAnimateElement(this.mCurrentMode, (List<Completable>) null, 2);
    }

    public void initializeFocusView(FocusView.ExposureViewListener exposureViewListener) {
        this.mFocusView.initialize(exposureViewListener);
    }

    public boolean initializeObjectTrack(RectF rectF, boolean z) {
        this.mFocusView.clear();
        this.mObjectView.clear();
        this.mObjectView.setVisibility(0);
        return this.mObjectView.initializeTrackView(rectF, z);
    }

    public boolean initializeObjectView(RectF rectF, boolean z) {
        return this.mObjectView.initializeTrackView(rectF, z);
    }

    public boolean isAdjustingObjectView() {
        return this.mObjectView.isAdjusting();
    }

    public boolean isAutoZoomActive() {
        return this.mAutoZoomOverlay.isViewActive();
    }

    public boolean isAutoZoomEnabled() {
        return this.mAutoZoomOverlay.isViewEnabled();
    }

    public boolean isAutoZoomViewEnabled() {
        return this.mAutoZoomOverlay.isViewEnabled();
    }

    public boolean isEffectViewMoved() {
        return this.mEffectCropView.isMoved();
    }

    public boolean isEffectViewVisible() {
        return this.mEffectCropView.isVisible();
    }

    public boolean isEvAdjusted(boolean z) {
        return z ? this.mFocusView.isEvAdjustedTime() : this.mFocusView.isEvAdjusted();
    }

    public boolean isFaceExists(int i) {
        if (i == 1) {
            return this.mFaceView.faceExists();
        }
        if (i != 3) {
            return false;
        }
        return this.mObjectView.faceExists();
    }

    public boolean isFaceLocationOK() {
        return this.mLastFaceSuccess;
    }

    public boolean isFaceStable(int i) {
        if (i == 1) {
            return this.mFaceView.isFaceStable();
        }
        if (i != 3) {
            return false;
        }
        return this.mObjectView.isFaceStable();
    }

    public boolean isFocusViewMoving() {
        return this.mFocusView.isFocusViewMoving();
    }

    public boolean isFocusViewVisible() {
        return this.mFocusView.isVisible();
    }

    public boolean isIndicatorVisible(int i) {
        return i != 1 ? i != 2 ? i == 3 && this.mObjectView.getVisibility() == 0 : this.mFocusView.getVisibility() == 0 : this.mFaceView.getVisibility() == 0;
    }

    public boolean isNeedExposure(int i) {
        if (i == 1) {
            return this.mFaceView.isNeedExposure();
        }
        if (i != 3) {
            return false;
        }
        return this.mObjectView.isNeedExposure();
    }

    public boolean isObjectTrackFailed() {
        return this.mObjectView.isTrackFailed();
    }

    public boolean isZoomAdjustVisible() {
        return this.mZoomView.isVisible() || this.mZoomViewHorizontal.isVisible();
    }

    public boolean isZoomViewMoving() {
        return this.mZoomView.isZoomMoving() || this.mZoomViewHorizontal.isZoomMoving();
    }

    public /* synthetic */ void j(boolean z) {
        ModeProtocol.TopAlert topAlert = (ModeProtocol.TopAlert) ModeCoordinatorImpl.getInstance().getAttachProtocol(172);
        boolean z2 = false;
        switch (this.mMimojiDetectTipType) {
            case 160:
                if (isMimojiFaceDetectTip()) {
                    int tipsResId = MimojiHelper.getTipsResId(this.mMimojiFaceDetect);
                    if (topAlert != null && tipsResId > 0) {
                        topAlert.alertMimojiFaceDetect(true, tipsResId);
                        break;
                    }
                } else {
                    return;
                }
            case 161:
                if (isMimojiFaceDetectTip()) {
                    int tipsResIdFace = MimojiHelper.getTipsResIdFace(this.mMimojiFaceDetect);
                    if (topAlert != null && tipsResIdFace > 0) {
                        topAlert.alertMimojiFaceDetect(true, tipsResIdFace);
                        break;
                    }
                } else {
                    return;
                }
            case 162:
                int tipsResIdFace2 = MimojiHelper.getTipsResIdFace(7);
                if (topAlert == null || tipsResIdFace2 == -1 || !z) {
                    if (topAlert != null) {
                        topAlert.alertMimojiFaceDetect(false, -1);
                        break;
                    }
                } else {
                    topAlert.alertMimojiFaceDetect(true, tipsResIdFace2);
                    break;
                }
                break;
        }
        ModeProtocol.MimojiAvatarEngine mimojiAvatarEngine = (ModeProtocol.MimojiAvatarEngine) ModeCoordinatorImpl.getInstance().getAttachProtocol(217);
        if (mimojiAvatarEngine != null) {
            mimojiAvatarEngine.setDetectSuccess(this.mLastFaceSuccess);
            ModeProtocol.BottomPopupTips bottomPopupTips = (ModeProtocol.BottomPopupTips) ModeCoordinatorImpl.getInstance().getAttachProtocol(175);
            if (this.mLastFaceSuccess && !z) {
                if (bottomPopupTips != null) {
                    bottomPopupTips.showTips(19, (int) R.string.mimoji_check_normal, 2);
                }
                if (topAlert != null) {
                    topAlert.alertMimojiFaceDetect(false, -1);
                }
            } else if (bottomPopupTips != null) {
                bottomPopupTips.directlyHideTips();
            }
        }
        if (this.mLastFaceSuccess && !z) {
            z2 = true;
        }
        if (z2) {
            this.mMimojiLightingView.triggerAnimateSuccess();
        } else if (!(this.mMimojiLastFaceSuccess == this.mLastFaceSuccess && this.mIsMimojiCreateLowLight == z)) {
            this.mMimojiLightingView.triggerAnimateStart();
        }
        this.mIsMimojiCreateLowLight = z;
        this.mMimojiLastFaceSuccess = this.mLastFaceSuccess;
    }

    public void lightingCancel() {
        this.mLightingView.triggerAnimateExit();
        this.lastConfirmTime = -1;
        this.mFaceView.setLightingOn(false);
        this.mAfRegionsView.setLightingOn(false);
    }

    public void lightingDetectFace(CameraHardwareFace[] cameraHardwareFaceArr, boolean z) {
        LightingView lightingView = z ? this.mMimojiLightingView : this.mLightingView;
        int i = 5;
        if (cameraHardwareFaceArr == null || cameraHardwareFaceArr.length == 0 || cameraHardwareFaceArr.length > 1) {
            consumeResult(5, z);
        } else if (this.lastConfirmTime != -1) {
            this.mFaceView.transToViewRect(cameraHardwareFaceArr[0].rect, lightingView.getFaceViewRectF());
            RectF faceViewRectF = lightingView.getFaceViewRectF();
            RectF focusRectF = lightingView.getFocusRectF();
            if (isRectIntersect(faceViewRectF, focusRectF)) {
                getMergeRect(faceViewRectF, focusRectF);
                float width = faceViewRectF.width() * faceViewRectF.height();
                float width2 = this.mergeRectF.width() * this.mergeRectF.height();
                float width3 = focusRectF.width() * focusRectF.height();
                float f2 = 1.0f;
                float f3 = z ? 0.5f : 1.0f;
                if (z) {
                    f2 = 1.5f;
                }
                float f4 = 0.2f * width3 * f3;
                float f5 = width3 * 0.5f * f2;
                if (width2 >= 0.5f * width) {
                    i = width2 < f4 ? 4 : (width2 >= f5 || width >= f5) ? 3 : 6;
                }
            }
            consumeResult(i, z);
        }
    }

    public void lightingFocused() {
        this.mLightingView.triggerAnimateSuccess();
    }

    public void lightingStart() {
        this.mLightingView.setCinematicAspectRatio(CameraSettings.isCinematicAspectRatioEnabled(this.mCurrentMode));
        this.mLightingView.triggerAnimateStart();
        this.lastFaceResult = -1;
        this.mLastFaceSuccess = false;
        this.lastConfirmTime = System.currentTimeMillis();
        this.mFaceView.setLightingOn(true);
        this.mAfRegionsView.setLightingOn(true);
    }

    public void mimojiEnd() {
        if (getActivity() != null) {
            getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    FragmentMainContent.this.mMimojiLightingView.triggerAnimateExit();
                }
            });
        }
    }

    public void mimojiFaceDetect(final int i) {
        this.mMimojiLightingView.post(new Runnable() {
            public void run() {
                int unused = FragmentMainContent.this.mCurrentMimojiFaceResult = i;
                FragmentMainContent.this.mimojiFaceDetectSync(160, i);
            }
        });
    }

    public void mimojiStart() {
        this.lastFaceResult = -1;
        this.mLastFaceSuccess = false;
        this.lastConfirmTime = System.currentTimeMillis();
        this.mFaceView.setLightingOn(true);
        this.mAfRegionsView.setLightingOn(true);
        this.mMimojiLightingView.triggerAnimateStart();
    }

    public boolean needViewClear() {
        return true;
    }

    public void notifyAfterFrameAvailable(int i) {
        super.notifyAfterFrameAvailable(i);
        this.mPreviewFrame.updateReferenceLineAccordSquare();
        updateReferenceGradienterSwitched();
        updateCinematicAspectRatioSwitched(CameraSettings.isCinematicAspectRatioEnabled(this.mCurrentMode));
        this.mFocusView.reInit();
        this.mZoomView.reInit();
        this.mEffectCropView.updateVisible();
        updateFocusMode(CameraSettings.getFocusMode());
        if (CameraSettings.isProVideoHistogramOpen(this.mCurrentMode)) {
            this.mHistogramView.setVisibility(0);
            ViewCompat.animate(this.mHistogramView).setDuration(300).alpha(1.0f).start();
        }
    }

    public void notifyDataChanged(int i, int i2) {
        super.notifyDataChanged(i, i2);
        boolean isIntentAction = DataRepository.dataItemGlobal().isIntentAction();
        if (isIntentAction != this.mIsIntentAction) {
            this.mIsIntentAction = isIntentAction;
            hideReviewViews();
        }
        if (DataRepository.dataItemGlobal().getCurrentCameraId() != this.mLastCameraId) {
            this.mLastCameraId = DataRepository.dataItemGlobal().getCurrentCameraId();
            if (Util.isAccessible()) {
                if (this.mLastCameraId != 1) {
                    this.mPreviewFrame.setContentDescription(getString(R.string.accessibility_back_preview_status));
                    this.mPreviewFrame.announceForAccessibility(getString(R.string.accessibility_back_preview_status));
                } else if (Util.isScreenSlideOff(getActivity())) {
                    this.mPreviewFrame.setContentDescription(getString(R.string.accessibility_pull_down_to_open_camera));
                    this.mPreviewFrame.announceForAccessibility(getString(R.string.accessibility_pull_down_to_open_camera));
                } else {
                    this.mPreviewFrame.setContentDescription(getString(R.string.accessibility_front_preview_status));
                    this.mPreviewFrame.announceForAccessibility(getString(R.string.accessibility_front_preview_status));
                }
            }
        }
        if (i == 2) {
            adjustViewHeight();
        } else if (i == 3) {
            adjustViewHeight();
        }
    }

    public void onAutoZoomStarted() {
        if (!this.mAutoZoomOverlay.isViewEnabled()) {
            this.mAutoZoomOverlay.setViewEnable(true);
            this.mAutoZoomOverlay.setViewActive(false);
            this.mAutoZoomOverlay.clear(0);
        }
    }

    public void onAutoZoomStopped() {
        if (this.mAutoZoomOverlay.isViewEnabled()) {
            this.mAutoZoomOverlay.setViewEnable(false);
            this.mAutoZoomOverlay.setViewActive(false);
            this.mAutoZoomOverlay.clear(4);
        }
    }

    public boolean onBackEvent(int i) {
        return false;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onDestroy() {
        super.onDestroy();
        destroyEffectCropView();
    }

    public boolean onEffectViewTouchEvent(MotionEvent motionEvent) {
        return this.mEffectCropView.onTouchEvent(motionEvent);
    }

    public void onPause() {
        super.onPause();
        this.mLastFaceSuccess = false;
        this.mHandler.removeCallbacksAndMessages((Object) null);
    }

    public void onStop() {
        super.onStop();
        this.mLightingView.clear();
    }

    public void onStopObjectTrack() {
        this.mObjectView.clear();
        this.mObjectView.setVisibility(8);
    }

    public void onTrackingStarted(RectF rectF) {
        ModeProtocol.AutoZoomModuleProtocol autoZoomModuleProtocol = (ModeProtocol.AutoZoomModuleProtocol) ModeCoordinatorImpl.getInstance().getAttachProtocol(215);
        if (autoZoomModuleProtocol != null) {
            autoZoomModuleProtocol.startTracking(rectF);
        }
    }

    public void onTrackingStopped(int i) {
        if (this.mAutoZoomOverlay.isViewActive()) {
            this.mAutoZoomOverlay.setViewActive(false);
            this.mAutoZoomOverlay.clear(0);
        }
    }

    public boolean onViewTouchEvent(int i, MotionEvent motionEvent) {
        if (i == this.mFocusView.getId()) {
            return this.mFocusView.onViewTouchEvent(motionEvent);
        }
        if (i == this.mEffectCropView.getId()) {
            return this.mEffectCropView.onViewTouchEvent(motionEvent);
        }
        if (i == this.mAutoZoomOverlay.getId()) {
            return this.mAutoZoomOverlay.onViewTouchEvent(motionEvent);
        }
        if (i == this.mZoomView.getId()) {
            return this.mZoomView.onViewTouchEvent(motionEvent);
        }
        if (i == this.mZoomViewHorizontal.getId()) {
            return this.mZoomViewHorizontal.onViewTouchEvent(motionEvent);
        }
        return false;
    }

    public void performHapticFeedback(int i) {
        this.mPreviewFrame.performHapticFeedback(i);
    }

    public void processingFinish() {
        this.mVideoTagView.stop();
        this.mFocusView.processingFinish();
        updateZoomViewMarginBottom(0, false);
    }

    public void processingPause() {
        this.mVideoTagView.pause();
    }

    public void processingResume() {
        this.mVideoTagView.resume();
    }

    public void processingStart(String str) {
        this.mVideoTagView.start(str);
        this.mFocusView.processingStart();
        updateZoomViewMarginBottom(getResources().getDimensionPixelSize(R.dimen.settings_screen_height), false);
    }

    public void provideAnimateElement(int i, List<Completable> list, int i2) {
        int i3 = this.mCurrentMode;
        super.provideAnimateElement(i, list, i2);
        CoverState coverState = CoverState.NONE;
        if (i == 165) {
            coverState = CoverState.TB;
        } else if (i == 171) {
            coverState = (!CameraSettings.isCinematicAspectRatioEnabled(this.mCurrentMode) || i2 == 3) ? CoverState.NONE : CoverState.LR;
        } else if (i == 180) {
            this.mZoomViewHorizontal.init();
            this.mZoomView.init();
        }
        if (isInModeChanging() || i2 == 3) {
            this.mLyingDirectHint.setVisibility(8);
            this.mIsShowMainLyingDirectHint = false;
        }
        boolean z = true;
        setSnapNumVisible(false, true);
        hideDelayNumber();
        this.mPreviewFrame.hidePreviewReferenceLine();
        this.mPreviewFrame.hidePreviewGradienter();
        this.mFaceView.clear();
        this.mFaceView.clearFaceFlags();
        this.mFocusView.clear();
        this.mLightingView.clear();
        this.mAfRegionsView.clear();
        this.mMimojiLightingView.clear();
        if (this.mCurrentMode != 180 && this.mHistogramView.getVisibility() == 0) {
            list.add(Completable.create(new AlphaOutOnSubscribe(this.mHistogramView)));
        }
        this.mIsHorizontal = (this.mDegree + 180) % 180 != 0;
        setZoomViewVisible(i == 180);
        if ((i3 == 162 || i3 == 169) && (i == 162 || i == 169)) {
            z = false;
        }
        if (z) {
            this.mFocusView.releaseListener();
        }
        if (this.mTopCover.getTag() == null || this.mTopCover.getTag() != coverState) {
            this.mTopCover.setTag(coverState);
            int i4 = AnonymousClass6.$SwitchMap$com$android$camera$fragment$FragmentMainContent$CoverState[coverState.ordinal()];
            if (i4 == 2) {
                if (this.mCoverParent.getLayoutParams().height != this.mNormalCoverHeight) {
                    this.mCoverParent.getLayoutParams().height = this.mNormalCoverHeight;
                    this.mCoverParent.requestLayout();
                }
                SlideOutOnSubscribe.directSetResult(this.mLeftCover, 3);
                SlideOutOnSubscribe.directSetResult(this.mRightCover, 5);
                if (list == null) {
                    SlideInOnSubscribe.directSetResult(this.mTopCover, 48);
                    SlideInOnSubscribe.directSetResult(this.mBottomCover, 80);
                    return;
                }
                list.add(Completable.create(new SlideInOnSubscribe(this.mTopCover, 48)));
                list.add(Completable.create(new SlideInOnSubscribe(this.mBottomCover, 80)));
            } else if (i4 != 3) {
                if (list == null) {
                    SlideOutOnSubscribe.directSetResult(this.mTopCover, 48);
                    SlideOutOnSubscribe.directSetResult(this.mBottomCover, 80);
                    SlideOutOnSubscribe.directSetResult(this.mLeftCover, 3);
                    SlideOutOnSubscribe.directSetResult(this.mRightCover, 5);
                } else {
                    if (this.mTopCover.getVisibility() == 0) {
                        list.add(Completable.create(new SlideOutOnSubscribe(this.mTopCover, 48).setDurationTime(200)));
                    }
                    if (this.mBottomCover.getVisibility() == 0) {
                        list.add(Completable.create(new SlideOutOnSubscribe(this.mBottomCover, 80).setDurationTime(200)));
                    }
                    if (this.mLeftCover.getVisibility() == 0) {
                        list.add(Completable.create(new SlideOutOnSubscribe(this.mLeftCover, 3).setDurationTime(200)));
                    }
                    if (this.mRightCover.getVisibility() == 0) {
                        list.add(Completable.create(new SlideOutOnSubscribe(this.mRightCover, 5).setDurationTime(200)));
                    }
                }
                if (this.mCoverParent.getLayoutParams().height != this.mNormalCoverHeight) {
                    this.mCoverParent.getLayoutParams().height = this.mNormalCoverHeight;
                    this.mCoverParent.requestLayout();
                }
            } else {
                SlideOutOnSubscribe.directSetResult(this.mTopCover, 48);
                SlideOutOnSubscribe.directSetResult(this.mBottomCover, 80);
            }
        }
    }

    public void provideRotateItem(List<View> list, int i) {
        super.provideRotateItem(list, i);
        this.mFaceView.setOrientation((360 - i) % 360, false);
        this.mAfRegionsView.setOrientation(i, false);
        this.mLightingView.setOrientation(i, false);
        this.mFocusView.setOrientation(i, false);
        this.mHistogramView.setOrientation(i, true);
        list.add(this.mFocusView);
        list.add(this.mMultiSnapNum);
        list.add(this.mCaptureDelayNumber);
        if (this.mCurrentMode == 180) {
            onZoomViewOrientationChanged(i);
        }
    }

    public void reShowFaceRect() {
        this.mFaceView.reShowFaceRect();
    }

    /* access modifiers changed from: protected */
    public void register(ModeProtocol.ModeCoordinator modeCoordinator) {
        super.register(modeCoordinator);
        modeCoordinator.attachProtocol(166, this);
        modeCoordinator.attachProtocol(214, this);
        registerBackStack(modeCoordinator, this);
        if (!b.isSupportedOpticalZoom() && !HybridZoomingSystem.IS_3_OR_MORE_SAT) {
            modeCoordinator.attachProtocol(184, this);
        }
    }

    public void removeTiltShiftMask() {
        this.mEffectCropView.removeTiltShiftMask();
    }

    public void setActiveIndicator(int i) {
        this.mActiveIndicator = i;
    }

    public void setAfRegionView(MeteringRectangle[] meteringRectangleArr, Rect rect, float f2) {
        this.mAfRegionsView.setAfRegionRect(meteringRectangleArr, rect, f2);
    }

    public void setCameraDisplayOrientation(int i) {
        FaceView faceView = this.mFaceView;
        if (faceView != null && this.mAfRegionsView != null) {
            faceView.setCameraDisplayOrientation(i);
            this.mAfRegionsView.setCameraDisplayOrientation(i);
        }
    }

    public void setCenterHint(int i, String str, String str2, int i2) {
        this.mHandler.removeCallbacksAndMessages(this.mPreviewCenterHint);
        if (i == 0) {
            this.mCenterHintText.setText(str);
            if (str == null || str.equals("")) {
                this.mCenterHintText.setVisibility(8);
            } else {
                this.mCenterHintText.setVisibility(0);
            }
            if (str2 == null || str2.equals("")) {
                this.mCenterHintIcon.setVisibility(8);
            } else {
                c.b((Fragment) this).load(str2).a(this.mCenterHintIcon);
                this.mCenterHintIcon.setVisibility(0);
            }
            if (i2 > 0) {
                this.mHandler.postAtTime(new Runnable() {
                    public void run() {
                        FragmentMainContent.this.mPreviewCenterHint.setVisibility(8);
                    }
                }, this.mPreviewCenterHint, SystemClock.uptimeMillis() + ((long) i2));
            }
        }
        this.mPreviewCenterHint.setVisibility(i);
    }

    public void setDisplaySize(int i, int i2) {
        this.mObjectView.setDisplaySize(i, i2);
    }

    public void setEffectViewVisible(boolean z) {
        if (z) {
            this.mEffectCropView.show();
        } else {
            this.mEffectCropView.hide();
        }
    }

    public void setEvAdjustable(boolean z) {
        this.mFocusView.setEvAdjustable(z);
    }

    public boolean setFaces(int i, CameraHardwareFace[] cameraHardwareFaceArr, Rect rect, float f2) {
        if (i == 1) {
            return this.mFaceView.setFaces(cameraHardwareFaceArr, rect, f2);
        }
        if (i != 3) {
            return false;
        }
        if (cameraHardwareFaceArr != null && cameraHardwareFaceArr.length > 0) {
            this.mObjectView.setObject(cameraHardwareFaceArr[0]);
        }
        return true;
    }

    public void setFocusViewPosition(int i, int i2, int i3) {
        this.mFocusView.setPosition(i, i2, i3);
        this.mFaceView.forceHideRect();
    }

    public void setFocusViewType(boolean z) {
        this.mFocusView.setFocusType(z);
    }

    public void setMimojiDetectTipType(int i) {
        if (i != this.mMimojiDetectTipType) {
            this.mMimojiDetectTipType = i;
        }
    }

    public void setObjectViewListener(ObjectView.ObjectViewListener objectViewListener) {
        ObjectView objectView = this.mObjectView;
        if (objectView != null) {
            objectView.setObjectViewListener(objectViewListener);
        }
    }

    public void setPreviewAspectRatio(float f2) {
        adjustViewHeight();
    }

    public void setPreviewSize(int i, int i2) {
        AutoZoomView autoZoomView = this.mAutoZoomOverlay;
        if (autoZoomView != null) {
            autoZoomView.setPreviewSize(new Size(i, i2));
        }
    }

    public void setShowGenderAndAge(boolean z) {
        this.mFaceView.setShowGenderAndAge(z);
    }

    public void setShowMagicMirror(boolean z) {
        this.mFaceView.setShowMagicMirror(z);
    }

    public void setSkipDrawFace(boolean z) {
        this.mFaceView.setSkipDraw(z);
    }

    @TargetApi(21)
    public void setSnapNumValue(int i) {
        if (this.mSnapStyle == null) {
            this.mSnapStyle = new TextAppearanceSpan(getContext(), R.style.SnapTipTextStyle);
        }
        SpannableStringBuilder spannableStringBuilder = this.mStringBuilder;
        if (spannableStringBuilder == null) {
            this.mStringBuilder = new SpannableStringBuilder();
        } else {
            spannableStringBuilder.clear();
        }
        this.mStringBuilder.append(String.format("%02d", new Object[]{Integer.valueOf(i)}), this.mSnapStyle, 33);
        this.mMultiSnapNum.setText(this.mStringBuilder);
    }

    public void setSnapNumVisible(boolean z, boolean z2) {
        if (z != (this.mMultiSnapNum.getVisibility() == 0)) {
            if (this.mZoomInAnimator == null) {
                initSnapNumAnimator();
            }
            if (z) {
                AlphaInOnSubscribe.directSetResult(this.mMultiSnapNum);
                setSnapNumValue(0);
                this.mZoomInAnimator.start();
                return;
            }
            this.mZoomOutAnimator.start();
            Completable.create(new AlphaOutOnSubscribe(this.mMultiSnapNum).setStartDelayTime(500)).subscribe();
        }
    }

    public void setZoomViewVisible(boolean z) {
        if (z) {
            if (this.mIsHorizontal) {
                this.mZoomViewHorizontal.show();
            } else {
                this.mZoomView.show();
            }
        } else if (this.mIsHorizontal) {
            this.mZoomViewHorizontal.hide();
            this.mZoomViewHorizontal.reset();
        } else {
            this.mZoomView.hide();
            this.mZoomView.reset();
        }
    }

    public void showDelayNumber(int i) {
        long j;
        long round;
        if (this.mCaptureDelayNumber.getVisibility() != 0) {
            int topHeight = Util.getTopHeight();
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.capture_delay_number_text_size);
            int round2 = Math.round(((float) dimensionPixelSize) * 1.327f);
            int i2 = round2 - dimensionPixelSize;
            if (this.mCurrentMode == 165) {
                j = (long) topHeight;
                round = Math.round(((double) Util.sWindowWidth) * 0.0148d);
            } else if (this.mDisplayRectTopMargin == 0) {
                j = (long) topHeight;
                round = Math.round(((double) Util.sWindowWidth) * 0.0574d);
            } else {
                j = (long) topHeight;
                round = Math.round(((double) Util.sWindowWidth) * 0.0889d);
            }
            int i3 = ((int) (j + round)) - i2;
            Log.d(TAG, "showDelayNumber: topMargin = " + i3 + ", topHeight = " + Util.getTopHeight() + ", fontHeight = " + dimensionPixelSize + ", viewHeight = " + round2 + ", offset = " + i2);
            ((ViewGroup.MarginLayoutParams) this.mCaptureDelayNumber.getLayoutParams()).topMargin = i3;
            int i4 = this.mDegree;
            if (i4 > 0) {
                ViewCompat.setRotation(this.mCaptureDelayNumber, (float) i4);
            }
            Completable.create(new AlphaInOnSubscribe(this.mCaptureDelayNumber)).subscribe();
        }
        this.mCaptureDelayNumber.setText(String.valueOf(i));
    }

    public void showIndicator(int i, int i2) {
        if (i == 1) {
            showIndicator((FocusIndicator) this.mFaceView, i2);
        } else if (i == 2) {
            showIndicator((FocusIndicator) this.mFocusView, i2);
        } else if (i == 3) {
            showIndicator((FocusIndicator) this.mObjectView, i2);
        }
    }

    public void showReviewViews(Bitmap bitmap) {
        if (bitmap != null) {
            this.mPreviewPanel.mVideoReviewImage.setImageBitmap(bitmap);
            this.mPreviewPanel.mVideoReviewImage.setVisibility(0);
        }
        Util.fadeIn(this.mPreviewPanel.mVideoReviewPlay);
    }

    /* access modifiers changed from: protected */
    public void unRegister(ModeProtocol.ModeCoordinator modeCoordinator) {
        super.unRegister(modeCoordinator);
        modeCoordinator.detachProtocol(166, this);
        unRegisterBackStack(modeCoordinator, this);
        modeCoordinator.detachProtocol(214, this);
        if (!b.isSupportedOpticalZoom() && !HybridZoomingSystem.IS_3_OR_MORE_SAT) {
            modeCoordinator.detachProtocol(184, this);
        }
    }

    public void updateCinematicAspectRatioSwitched(boolean z) {
        Log.i(TAG, "updateCinematicPhotoSwitched isSwitchOn : " + z);
        if (z) {
            if (this.mCoverParent.getLayoutParams().height == this.mNormalCoverHeight) {
                this.mCoverParent.getLayoutParams().height = -1;
                this.mCoverParent.requestLayout();
            }
            Completable.create(new SlideInOnSubscribe(this.mLeftCover, 3)).subscribe();
            Completable.create(new SlideInOnSubscribe(this.mRightCover, 5)).subscribe();
            if (this.mZoomView.getVisibility() == 0) {
                Completable.create(new TranslateXOnSubscribe(this.mZoomView, -this.mRightCover.getWidth())).subscribe();
            }
            if (this.mHistogramView.getVisibility() == 0) {
                Completable.create(new TranslateXOnSubscribe(this.mHistogramView, -this.mLeftCover.getWidth())).subscribe();
                return;
            }
            return;
        }
        if (this.mLeftCover.getVisibility() == 0) {
            Completable.create(new SlideOutOnSubscribe(this.mLeftCover, 3).setDurationTime(200)).subscribe();
        }
        if (this.mRightCover.getVisibility() == 0) {
            Completable.create(new SlideOutOnSubscribe(this.mRightCover, 5).setDurationTime(200)).subscribe();
        }
        if (this.mCoverParent.getLayoutParams().height != this.mNormalCoverHeight) {
            this.mCoverParent.getLayoutParams().height = this.mNormalCoverHeight;
            this.mCoverParent.requestLayout();
        }
        if (((int) this.mZoomView.getTranslationX()) != 0) {
            Completable.create(new TranslateXOnSubscribe(this.mZoomView, 0)).subscribe();
        }
        if (((int) this.mHistogramView.getTranslationX()) != 0 && this.mHistogramView.getVisibility() == 0) {
            Completable.create(new TranslateXOnSubscribe(this.mHistogramView, 0)).subscribe();
        }
    }

    public void updateContentDescription() {
        this.mPreviewFrame.setContentDescription(getString(R.string.accessibility_front_preview_status));
        this.mPreviewFrame.announceForAccessibility(getString(R.string.accessibility_front_preview_status));
    }

    public void updateEffectViewVisible() {
        this.mEffectCropView.updateVisible();
    }

    public void updateEffectViewVisible(int i) {
        this.mEffectCropView.updateVisible(i);
    }

    public void updateFaceView(boolean z, boolean z2, boolean z3, boolean z4, int i) {
        if (z2) {
            this.mFaceView.clear();
        }
        this.mFaceView.setVisibility(z ? 0 : 8);
        if (i > 0) {
            this.mFaceView.setCameraDisplayOrientation(i);
        }
        this.mFaceView.setMirror(z3);
        if (z4) {
            this.mFaceView.resume();
        }
    }

    public void updateFocusMode(String str) {
        this.mFocusView.updateFocusMode(str);
    }

    public void updateGradienterSwitched(boolean z) {
        updateReferenceGradienterSwitched();
    }

    public void updateHistogramStats(int[] iArr) {
        HistogramView histogramView = this.mHistogramView;
        if (histogramView != null) {
            histogramView.updateStats(iArr);
        }
    }

    public void updateHistogramStats(int[] iArr, int[] iArr2, int[] iArr3) {
        this.mHistogramView.updateStats(iArr, iArr2, iArr3);
    }

    public void updateLyingDirectHint(boolean z, boolean z2) {
        int i = this.mDegree;
        if ((i != 0 && i != 180) || (!z && !z2)) {
            if (!z2) {
                this.mIsShowMainLyingDirectHint = z;
            }
            int dimensionPixelSize = Util.sWindowHeight - ((((Util.sWindowWidth / 3) * 2) + CameraSettings.BOTTOM_CONTROL_HEIGHT) + (getResources().getDimensionPixelSize(R.dimen.lying_direct_hint_height) / 2));
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.lying_direct_hint_margin_top);
            int dimensionPixelSize3 = (Util.sWindowWidth / 2) - (getResources().getDimensionPixelSize(R.dimen.lying_direct_hint_height) / 2);
            if (this.mIsShowMainLyingDirectHint && this.mLyingDirectHint.getVisibility() != 0) {
                ViewCompat.setTranslationX(this.mLyingDirectHint, (float) (this.mDegree == 90 ? dimensionPixelSize3 - dimensionPixelSize2 : dimensionPixelSize2 - dimensionPixelSize3));
                ViewCompat.setTranslationY(this.mLyingDirectHint, (float) dimensionPixelSize);
                ViewCompat.setRotation(this.mLyingDirectHint, (float) this.mDegree);
                this.mLyingDirectHint.setVisibility(0);
                CameraStatUtils.trackLyingDirectShow(this.mDegree);
            } else if (this.mLyingDirectHint.getVisibility() == 0) {
                this.mLyingDirectHint.setVisibility(8);
            }
        }
    }

    public void updateMimojiFaceDetectResultTip(boolean z) {
        this.mMimojiLightingView.post(new f(this, z));
    }

    public void updateRGBHistogramSwitched(boolean z) {
        if (z) {
            if (CameraSettings.isCinematicAspectRatioEnabled(this.mCurrentMode)) {
                Completable.create(new TranslateXOnSubscribe(this.mHistogramView, -this.mLeftCover.getWidth())).subscribe();
            } else if (((int) this.mHistogramView.getTranslationX()) != 0) {
                Completable.create(new TranslateXOnSubscribe(this.mHistogramView, 0)).subscribe();
            }
            Util.fadeIn(this.mHistogramView);
            return;
        }
        Util.fadeOut(this.mHistogramView);
    }

    public void updateReferenceLineSwitched(boolean z) {
        updateReferenceGradienterSwitched();
    }

    public void updateZoomRatio(float f2, float f3) {
        ZoomView zoomView = this.mZoomView;
        if (zoomView != null) {
            zoomView.updateZoomRatio(f2, f3);
        }
        ZoomView zoomView2 = this.mZoomViewHorizontal;
        if (zoomView2 != null) {
            zoomView2.updateZoomRatio(f2, f3);
        }
    }

    public void updateZoomViewMarginBottom(int i, boolean z) {
        if (z) {
            i = this.mLastTranslateY;
        } else {
            this.mLastTranslateY = (int) this.mZoomViewHorizontal.getTranslationY();
        }
        ViewCompat.animate(this.mZoomViewHorizontal).setDuration(300).translationY((float) i).setInterpolator(new DecelerateInterpolator()).start();
    }
}
