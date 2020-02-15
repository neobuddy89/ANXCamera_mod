package com.android.camera.fragment.bottom.action;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.PathInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.camera.ActivityBase;
import com.android.camera.Camera;
import com.android.camera.CameraSettings;
import com.android.camera.HybridZoomingSystem;
import com.android.camera.R;
import com.android.camera.Thumbnail;
import com.android.camera.ThumbnailUpdater;
import com.android.camera.Util;
import com.android.camera.animation.FragmentAnimationFactory;
import com.android.camera.animation.type.AlphaInOnSubscribe;
import com.android.camera.animation.type.AlphaOutOnSubscribe;
import com.android.camera.data.DataRepository;
import com.android.camera.data.data.global.ComponentModuleList;
import com.android.camera.data.data.global.DataItemGlobal;
import com.android.camera.data.data.runing.ComponentRunningShine;
import com.android.camera.fragment.BaseFragment;
import com.android.camera.fragment.FragmentUtils;
import com.android.camera.fragment.bottom.BottomActionMenu;
import com.android.camera.fragment.bottom.BottomAnimationConfig;
import com.android.camera.lib.compatibility.related.vibrator.ViberatorContext;
import com.android.camera.log.Log;
import com.android.camera.module.FunModule;
import com.android.camera.module.ILiveModule;
import com.android.camera.module.LiveModule;
import com.android.camera.module.MiLiveModule;
import com.android.camera.module.Module;
import com.android.camera.module.VideoModule;
import com.android.camera.module.impl.component.MimojiStatusManager;
import com.android.camera.module.loader.StartControl;
import com.android.camera.permission.PermissionManager;
import com.android.camera.protocol.ModeCoordinatorImpl;
import com.android.camera.protocol.ModeProtocol;
import com.android.camera.statistic.CameraStatUtils;
import com.android.camera.statistic.MistatsConstants;
import com.android.camera.statistic.ScenarioTrackUtil;
import com.android.camera.ui.CameraSnapView;
import com.android.camera.ui.EdgeHorizonScrollView;
import com.android.camera.ui.ModeSelectView;
import com.mi.config.b;
import com.xiaomi.stat.C0157d;
import io.reactivex.Completable;
import java.util.List;
import java.util.Locale;
import miui.view.animation.CubicEaseInInterpolator;
import miui.view.animation.CubicEaseOutInterpolator;
import miui.view.animation.SineEaseOutInterpolator;

public class FragmentBottomAction extends BaseFragment implements View.OnClickListener, ModeProtocol.ModeChangeController, ModeProtocol.ActionProcessing, ModeProtocol.HandleBeautyRecording, ModeProtocol.HandlerSwitcher, ModeProtocol.HandleBackTrace, ModeSelectView.onModeClickedListener, CameraSnapView.SnapListener, ModeProtocol.BottomMenuProtocol {
    public static final int FRAGMENT_INFO = 241;
    private static final int MSG_SHOW_PROGRESS = 1;
    private static final String TAG = "FragmentBottomAction";
    /* access modifiers changed from: private */
    public boolean mBackEnable;
    private FrameLayout mBottomActionView;
    private ValueAnimator mBottomAnimator;
    private View mBottomMenuLayout;
    private ImageView mBottomRecordingCameraPicker;
    private TextView mBottomRecordingTime;
    private int mBottomRollDownHeight;
    /* access modifiers changed from: private */
    public boolean mCameraPickEnable;
    /* access modifiers changed from: private */
    public ImageView mCameraPicker;
    private int mCaptureProgressDelay;
    private ComponentModuleList mComponentModuleList;
    private CubicEaseOutInterpolator mCubicEaseOut;
    private int mCurrentBeautyActionMenuType;
    private int mCurrentLiveActionMenuType;
    private EdgeHorizonScrollView mEdgeHorizonScrollView;
    private int mFilterListHeight;
    private FragmentActionLighting mFragmentActionLighting;
    private FragmentActionMimoji mFragmentActionMimoji;
    private View mFragmentLayoutExtra;
    @SuppressLint({"HandlerLeak"})
    private Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            if (message.what == 1) {
                FragmentBottomAction.this.mThumbnailProgress.setVisibility(0);
            }
        }
    };
    private boolean mInLoading;
    private boolean mIsBottomRollDown = false;
    private boolean mIsIntentAction;
    private boolean mIsShowLighting = false;
    private boolean mIsShowMiMoji = false;
    private long mLastPauseTime;
    private boolean mLongPressBurst;
    /* access modifiers changed from: private */
    public ImageView mMimojiBack;
    /* access modifiers changed from: private */
    public BottomActionMenu mModeSelectLayout;
    /* access modifiers changed from: private */
    public ModeSelectView mModeSelectView;
    /* access modifiers changed from: private */
    public ProgressBar mPostProcess;
    private int mRecordProgressDelay;
    /* access modifiers changed from: private */
    public ImageView mRecordingPause;
    /* access modifiers changed from: private */
    public ImageView mRecordingReverse;
    /* access modifiers changed from: private */
    public ImageView mRecordingSnap;
    private ImageView mRecordingSwitch;
    /* access modifiers changed from: private */
    public AlertDialog mReverseDialog;
    /* access modifiers changed from: private */
    public CameraSnapView mShutterButton;
    private SineEaseOutInterpolator mSineEaseOut;
    /* access modifiers changed from: private */
    public ImageView mThumbnailImage;
    /* access modifiers changed from: private */
    public ViewGroup mThumbnailImageLayout;
    /* access modifiers changed from: private */
    public ProgressBar mThumbnailProgress;
    private RelativeLayout mV9bottomParentLayout;
    /* access modifiers changed from: private */
    public boolean mVideoCaptureEnable;
    /* access modifiers changed from: private */
    public boolean mVideoPauseSupported;
    private boolean mVideoRecordingPaused;
    private boolean mVideoRecordingStarted;
    /* access modifiers changed from: private */
    public boolean mVideoReverseEnable;

    private void adjustViewBackground(View view, int i) {
        if (i == 165) {
            view.setBackgroundResource(R.color.black);
            return;
        }
        int uiStyle = DataRepository.dataItemRunning().getUiStyle();
        if (uiStyle != 1 && uiStyle != 3) {
            view.setBackgroundResource(R.color.black);
        } else if (DataRepository.dataItemGlobal().getDisplayMode() == 2) {
            view.setBackgroundResource(R.color.black);
        } else {
            view.setBackgroundResource(R.color.fullscreen_background);
        }
    }

    private void animateViews(int i, List<Completable> list, View view) {
        if (i == 1) {
            if (list == null) {
                AlphaInOnSubscribe.directSetResult(view);
            } else {
                list.add(Completable.create(new AlphaInOnSubscribe(view)));
            }
        } else if (list == null) {
            AlphaOutOnSubscribe.directSetResult(view);
        } else {
            list.add(Completable.create(new AlphaOutOnSubscribe(view)));
        }
    }

    private void changeCamera(View view) {
        DataItemGlobal dataItemGlobal = (DataItemGlobal) DataRepository.provider().dataGlobal();
        int currentCameraId = dataItemGlobal.getCurrentCameraId();
        boolean z = false;
        int i = currentCameraId == 0 ? 1 : 0;
        if (this.mCurrentMode == 163 && CameraSettings.isUltraPixelOn()) {
            ((ModeProtocol.ConfigChanges) ModeCoordinatorImpl.getInstance().getAttachProtocol(164)).switchOffElementsSilent(209);
        }
        HybridZoomingSystem.clearZoomRatioHistory();
        dataItemGlobal.setCameraId(i);
        if (i == 1) {
            ViewCompat.animate(view).rotationBy(-180.0f).setDuration(300).start();
        } else {
            ViewCompat.animate(view).rotationBy(180.0f).setDuration(300).start();
        }
        int i2 = 3;
        Log.d(TAG, String.format(Locale.ENGLISH, "switch camera from %d to %d, for module 0x%x", new Object[]{Integer.valueOf(currentCameraId), Integer.valueOf(i), Integer.valueOf(this.mCurrentMode)}));
        boolean z2 = currentCameraId == 1;
        if (i == 1) {
            z = true;
        }
        ScenarioTrackUtil.trackSwitchCameraStart(z2, z, this.mCurrentMode);
        ModeProtocol.TopAlert topAlert = (ModeProtocol.TopAlert) ModeCoordinatorImpl.getInstance().getAttachProtocol(172);
        topAlert.removeExtraMenu(4);
        int i3 = this.mCurrentMode;
        int i4 = 169;
        if (i3 == 162) {
            if (i != 0 || !DataRepository.getInstance().backUp().isLastVideoFastMotion()) {
                i4 = 162;
            }
            if (i4 != 162) {
                DataRepository.dataItemGlobal().setCurrentMode(i4);
            }
            ((Camera) getContext()).onModeSelected(StartControl.create(i4).setResetType(5).setNeedBlurAnimation(true).setViewConfigType(2));
        } else if (i3 == 166) {
            DataRepository.dataItemGlobal().setCurrentMode(176);
            ((Camera) getContext()).onModeSelected(StartControl.create(176).setResetType(4).setViewConfigType(2).setNeedBlurAnimation(true));
        } else if (i3 == 169) {
            DataRepository.dataItemGlobal().setCurrentMode(162);
            ((Camera) getContext()).onModeSelected(StartControl.create(162).setNeedBlurAnimation(true).setViewConfigType(2));
        } else if (i3 == 176) {
            DataRepository.dataItemGlobal().setCurrentMode(166);
            ((Camera) getContext()).onModeSelected(StartControl.create(166).setResetType(4).setViewConfigType(2).setNeedBlurAnimation(true));
        } else if (i3 != 177) {
            if (i3 == 163 || i3 == 165) {
                this.mCurrentMode = DataRepository.dataItemConfig().getComponentConfigRatio().getMappingModeByRatio(163);
                DataRepository.dataItemGlobal().setCurrentMode(this.mCurrentMode);
            }
            ((Camera) getContext()).onModeSelected(StartControl.create(this.mCurrentMode).setResetType(5).setViewConfigType(2).setNeedBlurAnimation(true));
        } else {
            ModeProtocol.MimojiAvatarEngine mimojiAvatarEngine = (ModeProtocol.MimojiAvatarEngine) ModeCoordinatorImpl.getInstance().getAttachProtocol(217);
            if (mimojiAvatarEngine == null || !mimojiAvatarEngine.isOnCreateMimoji()) {
                i2 = 2;
            } else {
                ((ModeProtocol.MainContentProtocol) ModeCoordinatorImpl.getInstance().getAttachProtocol(166)).mimojiStart();
                topAlert.disableMenuItem(true, 197, 193);
            }
            ((Camera) getContext()).onModeSelected(StartControl.create(this.mCurrentMode).setResetType(5).setViewConfigType(i2).setNeedBlurAnimation(true));
        }
        if (Util.isAccessible()) {
            this.mEdgeHorizonScrollView.setContentDescription(getString(R.string.accessibility_camera_picker_finish));
            this.mEdgeHorizonScrollView.sendAccessibilityEvent(32768);
        }
    }

    private void initThumbLayoutByIntent() {
        if (!this.mIsIntentAction) {
            ActivityBase activityBase = (ActivityBase) getContext();
            if ((activityBase.startFromSecureKeyguard() || activityBase.isGalleryLocked()) && !activityBase.isJumpBack()) {
                activityBase.getThumbnailUpdater().setThumbnail((Thumbnail) null, true, false);
            } else if (PermissionManager.checkStoragePermissions()) {
                activityBase.getThumbnailUpdater().getLastThumbnail();
            }
        } else {
            this.mThumbnailImage.setBackgroundResource(R.drawable.bg_thumbnail_background);
            ((ViewGroup.MarginLayoutParams) this.mThumbnailImage.getLayoutParams()).setMargins(0, 0, 0, 0);
            this.mThumbnailImage.setScaleType(ImageView.ScaleType.CENTER);
            this.mThumbnailImage.setImageResource(R.drawable.ic_close);
        }
    }

    private boolean isFPS960() {
        if (this.mCurrentMode != 172 || !DataRepository.dataItemFeature().vd()) {
            return false;
        }
        return DataRepository.dataItemConfig().getComponentConfigSlowMotion().isSlowMotionFps960();
    }

    private boolean isFocusOrZoomMoving() {
        ModeProtocol.MainContentProtocol mainContentProtocol = (ModeProtocol.MainContentProtocol) ModeCoordinatorImpl.getInstance().getAttachProtocol(166);
        return mainContentProtocol != null && (mainContentProtocol.isFocusViewMoving() || mainContentProtocol.isZoomViewMoving());
    }

    private boolean isThumbLoading() {
        return this.mInLoading;
    }

    private void setProgressBarVisible(int i) {
        if (this.mPostProcess.getVisibility() != i) {
            if (i == 0) {
                this.mPostProcess.setAlpha(0.0f);
                this.mPostProcess.setVisibility(0);
                ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
                ofFloat.setDuration(300);
                ofFloat.setStartDelay(160);
                ofFloat.setInterpolator(new PathInterpolator(0.25f, 0.1f, 0.25f, 1.0f));
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        Float f2 = (Float) valueAnimator.getAnimatedValue();
                        FragmentBottomAction.this.mPostProcess.setAlpha(f2.floatValue());
                        FragmentBottomAction.this.mPostProcess.setScaleX((f2.floatValue() * 0.1f) + 0.9f);
                        FragmentBottomAction.this.mPostProcess.setScaleY((f2.floatValue() * 0.1f) + 0.9f);
                    }
                });
                ofFloat.start();
            } else if (this.mPostProcess.getVisibility() != 8) {
                ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
                ofFloat2.setDuration(300);
                ofFloat2.setInterpolator(new CubicEaseInInterpolator());
                ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        FragmentBottomAction.this.mPostProcess.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
                ofFloat2.addListener(new Animator.AnimatorListener() {
                    public void onAnimationCancel(Animator animator) {
                        FragmentBottomAction.this.mPostProcess.setVisibility(8);
                    }

                    public void onAnimationEnd(Animator animator) {
                        FragmentBottomAction.this.mPostProcess.setVisibility(8);
                    }

                    public void onAnimationRepeat(Animator animator) {
                    }

                    public void onAnimationStart(Animator animator) {
                    }
                });
                ofFloat2.start();
            }
        }
    }

    private void setRecordingTimeState(int i) {
        if (i == 1) {
            int i2 = this.mCurrentMode;
            if (i2 == 174 || i2 == 183) {
                this.mBottomRecordingTime.setText("00:15");
            }
            Completable.create(new AlphaInOnSubscribe(this.mBottomRecordingTime)).subscribe();
        } else if (i == 2) {
            if (this.mBottomRecordingTime.getVisibility() == 0) {
                Completable.create(new AlphaOutOnSubscribe(this.mBottomRecordingTime)).subscribe();
            }
            if (this.mBottomRecordingCameraPicker.getVisibility() == 0) {
                Completable.create(new AlphaOutOnSubscribe(this.mBottomRecordingCameraPicker)).subscribe();
            }
        } else if (i == 3) {
            Completable.create(new AlphaInOnSubscribe(this.mBottomRecordingCameraPicker)).subscribe();
        } else if (i == 4 && this.mBottomRecordingTime.getVisibility() != 0) {
            this.mBottomRecordingTime.setVisibility(0);
        }
    }

    private void showReverseConfirmDialog() {
        if (this.mReverseDialog == null) {
            if (this.mCurrentMode == 174) {
                CameraStatUtils.trackLiveClick(MistatsConstants.Live.VALUE_LIVE_CLICK_REVERSE);
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setMessage(R.string.live_reverse_message);
            builder.setCancelable(false);
            builder.setPositiveButton(R.string.live_reverse_confirm, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    AlertDialog unused = FragmentBottomAction.this.mReverseDialog = null;
                    FragmentBottomAction.this.mShutterButton.removeLastSegment();
                    if (FragmentBottomAction.this.mCurrentMode == 174) {
                        CameraStatUtils.trackLiveClick(MistatsConstants.Live.VALUE_LIVE_CLICK_REVERSE_CONFIRM);
                    }
                    ((ILiveModule) ((ActivityBase) FragmentBottomAction.this.getContext()).getCurrentModule()).doReverse();
                }
            });
            builder.setNegativeButton(R.string.snap_cancel, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    AlertDialog unused = FragmentBottomAction.this.mReverseDialog = null;
                }
            });
            this.mReverseDialog = builder.show();
        }
    }

    private void startBottomAnimation(boolean z) {
        if (this.mIsBottomRollDown != z) {
            this.mIsBottomRollDown = z;
            if (z) {
                ViewCompat.setAlpha(this.mBottomMenuLayout, 1.0f);
                ViewCompat.animate(this.mBottomMenuLayout).setDuration(150).alpha(0.0f).setInterpolator(this.mCubicEaseOut).start();
                ViewCompat.setTranslationY(this.mBottomMenuLayout, 0.0f);
                ViewCompat.animate(this.mBottomMenuLayout).setDuration(300).translationY((float) this.mFilterListHeight).setInterpolator(this.mCubicEaseOut).start();
                ViewCompat.setTranslationY(this.mV9bottomParentLayout, 0.0f);
                ViewCompat.animate(this.mV9bottomParentLayout).setDuration(300).translationY((float) this.mBottomRollDownHeight).setInterpolator(this.mCubicEaseOut).start();
                ViewCompat.setScaleX(this.mShutterButton, 1.0f);
                ViewCompat.setScaleY(this.mShutterButton, 1.0f);
                ViewCompat.animate(this.mShutterButton).setDuration(300).scaleX(0.9f).scaleY(0.9f).setInterpolator(this.mCubicEaseOut).start();
                return;
            }
            ViewCompat.setAlpha(this.mBottomMenuLayout, 0.0f);
            ViewCompat.animate(this.mBottomMenuLayout).setStartDelay(50).setDuration(250).alpha(1.0f).setInterpolator(this.mSineEaseOut).start();
            ViewCompat.setTranslationY(this.mBottomMenuLayout, (float) this.mFilterListHeight);
            ViewCompat.animate(this.mBottomMenuLayout).setDuration(300).translationY(0.0f).setInterpolator(this.mCubicEaseOut).start();
            ViewCompat.setTranslationY(this.mV9bottomParentLayout, (float) this.mBottomRollDownHeight);
            ViewCompat.animate(this.mV9bottomParentLayout).setDuration(300).translationY(0.0f).setInterpolator(this.mCubicEaseOut).start();
            ViewCompat.setScaleX(this.mShutterButton, 0.9f);
            ViewCompat.setScaleY(this.mShutterButton, 0.9f);
            ViewCompat.animate(this.mShutterButton).setDuration(300).scaleX(1.0f).scaleY(1.0f).setInterpolator(this.mCubicEaseOut).start();
        }
    }

    private void startExtraLayoutAnimation(final View view, boolean z) {
        if (z) {
            ViewCompat.setTranslationY(view, (float) (-this.mFilterListHeight));
            ViewCompat.setAlpha(view, 0.0f);
            ViewCompat.animate(view).setDuration(300).translationY(0.0f).alpha(1.0f).setInterpolator(this.mCubicEaseOut).setListener(new ViewPropertyAnimatorListener() {
                public void onAnimationCancel(View view) {
                }

                public void onAnimationEnd(View view) {
                    FragmentBottomAction.this.mModeSelectView.setVisibility(8);
                }

                public void onAnimationStart(View view) {
                    view.setVisibility(0);
                }
            }).start();
            return;
        }
        ViewCompat.setAlpha(view, 1.0f);
        ViewCompat.animate(view).setDuration(150).alpha(0.0f).setInterpolator(this.mSineEaseOut).start();
        ViewCompat.setTranslationY(view, 0.0f);
        ViewCompat.animate(view).setDuration(300).translationY((float) (-this.mFilterListHeight)).setInterpolator(this.mCubicEaseOut).setListener(new ViewPropertyAnimatorListener() {
            public void onAnimationCancel(View view) {
            }

            public void onAnimationEnd(View view) {
                view.setVisibility(8);
            }

            public void onAnimationStart(View view) {
                FragmentBottomAction.this.mModeSelectView.setVisibility(0);
            }
        }).start();
    }

    private void startExtraLayoutExchangeAnimation(final View view) {
        ViewCompat.setAlpha(view, 1.0f);
        ViewCompat.setTranslationY(view, 0.0f);
        ViewCompat.animate(view).alpha(0.0f).translationY((float) this.mFilterListHeight).setDuration(250).setInterpolator(this.mCubicEaseOut).setListener(new ViewPropertyAnimatorListener() {
            public void onAnimationCancel(View view) {
            }

            public void onAnimationEnd(View view) {
                view.setVisibility(8);
            }

            public void onAnimationStart(View view) {
            }
        }).start();
    }

    private void switchVideoCapture(View view) {
        int i;
        int i2 = this.mCurrentMode;
        if (i2 != 167) {
            if (i2 == 180) {
                DataRepository.dataItemGlobal().setCurrentMode(167);
                ((Camera) getContext()).onModeSelected(StartControl.create(167).setResetType(5).setNeedBlurAnimation(true).setViewConfigType(2));
                this.mRecordingSwitch.setImageResource(R.drawable.ic_switch_record_video);
                this.mRecordingSwitch.setRotation(-90.0f);
            }
            i = 90;
        } else {
            DataRepository.dataItemGlobal().setCurrentMode(180);
            ((Camera) getContext()).onModeSelected(StartControl.create(180).setResetType(5).setNeedBlurAnimation(true).setViewConfigType(2));
            this.mRecordingSwitch.setImageResource(R.drawable.ic_switch_take_photo);
            this.mRecordingSwitch.setRotation(90.0f);
            i = -90;
        }
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, (float) i, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(300);
        rotateAnimation.setFillAfter(true);
        view.setAnimation(rotateAnimation);
    }

    private void updateBottomInRecording(final boolean z, boolean z2) {
        boolean z3 = true;
        if (z) {
            this.mHandler.removeMessages(1);
            if (this.mThumbnailProgress.getVisibility() != 8) {
                this.mThumbnailProgress.setVisibility(8);
            }
        }
        int i = this.mCurrentMode;
        if (i != 161) {
            if (i != 162) {
                if (i == 169 || i == 172) {
                    this.mVideoReverseEnable = false;
                    this.mVideoCaptureEnable = false;
                    this.mVideoPauseSupported = false;
                    this.mBackEnable = false;
                } else {
                    if (i != 174) {
                        if (i == 177) {
                            this.mCameraPickEnable = false;
                            this.mVideoPauseSupported = false;
                            this.mVideoCaptureEnable = false;
                            this.mVideoReverseEnable = false;
                            if (DataRepository.dataItemLive().getMimojiStatusManager().IsInMimojiCreate()) {
                                this.mBackEnable = true;
                            } else {
                                this.mBackEnable = false;
                                this.mCameraPickEnable = true;
                            }
                        } else if (!(i == 183 || i == 179)) {
                            if (i != 180) {
                                this.mVideoPauseSupported = false;
                                this.mVideoCaptureEnable = false;
                                this.mVideoReverseEnable = false;
                                this.mBackEnable = false;
                            }
                        }
                    }
                    this.mVideoCaptureEnable = false;
                    this.mVideoPauseSupported = true;
                    this.mVideoReverseEnable = true;
                    this.mBackEnable = false;
                }
            }
            if (!DataRepository.dataItemGlobal().isIntentAction()) {
                this.mVideoCaptureEnable = CameraSettings.isVideoCaptureVisible();
            }
            if (!b.jl() || CameraSettings.isVideoBokehOn()) {
                z3 = false;
            }
            this.mVideoPauseSupported = z3;
            this.mVideoReverseEnable = false;
            this.mBackEnable = false;
        } else {
            this.mVideoPauseSupported = false;
            this.mVideoReverseEnable = false;
            this.mBackEnable = false;
            if (DataRepository.dataItemFeature().Hd()) {
                this.mVideoCaptureEnable = true;
            } else {
                this.mVideoCaptureEnable = false;
            }
        }
        if (z) {
            if (this.mVideoCaptureEnable) {
                this.mRecordingSnap.setImageResource(R.drawable.ic_recording_snap);
                this.mRecordingSnap.setSoundEffectsEnabled(false);
                this.mRecordingSnap.setVisibility(0);
                ViewCompat.setAlpha(this.mRecordingSnap, 0.0f);
            }
            if (this.mVideoPauseSupported) {
                this.mRecordingPause.setImageResource(R.drawable.ic_recording_pause);
                this.mRecordingPause.setSoundEffectsEnabled(false);
                this.mRecordingPause.setVisibility(0);
                ViewCompat.setAlpha(this.mRecordingPause, 0.0f);
            }
            if (this.mVideoPauseSupported) {
                this.mRecordingReverse.setImageResource(R.drawable.ic_live_record_delete);
                this.mRecordingReverse.setSoundEffectsEnabled(false);
                this.mRecordingReverse.setVisibility(8);
            }
        }
        ValueAnimator valueAnimator = this.mBottomAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mBottomAnimator.cancel();
        }
        this.mBottomAnimator = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.mBottomAnimator.setDuration(z2 ? 250 : 0);
        this.mBottomAnimator.setInterpolator(new DecelerateInterpolator() {
            public float getInterpolation(float f2) {
                float interpolation = super.getInterpolation(f2);
                ViewCompat.setAlpha(FragmentBottomAction.this.mModeSelectLayout.getView(), z ? 1.0f - interpolation : FragmentBottomAction.this.mModeSelectLayout.getView().getAlpha() == 0.0f ? interpolation : 1.0f);
                if (FragmentBottomAction.this.mCameraPickEnable) {
                    ViewCompat.setAlpha(FragmentBottomAction.this.mCameraPicker, z ? 1.0f - interpolation : FragmentBottomAction.this.mCameraPicker.getAlpha() == 0.0f ? interpolation : 1.0f);
                }
                ViewCompat.setAlpha(FragmentBottomAction.this.mThumbnailImageLayout, z ? 1.0f - interpolation : FragmentBottomAction.this.mThumbnailImageLayout.getAlpha() == 0.0f ? interpolation : 1.0f);
                if (FragmentBottomAction.this.mVideoPauseSupported) {
                    ViewCompat.setAlpha(FragmentBottomAction.this.mRecordingPause, z ? interpolation : 1.0f - interpolation);
                }
                if (FragmentBottomAction.this.mVideoCaptureEnable) {
                    ViewCompat.setAlpha(FragmentBottomAction.this.mRecordingSnap, z ? interpolation : 1.0f - interpolation);
                }
                if (FragmentBottomAction.this.mVideoReverseEnable) {
                    ViewCompat.setAlpha(FragmentBottomAction.this.mRecordingReverse, z ? interpolation : 1.0f - interpolation);
                }
                if (FragmentBottomAction.this.mBackEnable) {
                    ViewCompat.setAlpha(FragmentBottomAction.this.mMimojiBack, z ? interpolation : 1.0f - interpolation);
                }
                return interpolation;
            }
        });
        this.mBottomAnimator.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                if (FragmentBottomAction.this.canProvide()) {
                    int i = 0;
                    if (FragmentBottomAction.this.mVideoPauseSupported) {
                        FragmentBottomAction.this.mRecordingPause.setVisibility(z ? 0 : 8);
                    }
                    if (FragmentBottomAction.this.mVideoCaptureEnable) {
                        FragmentBottomAction.this.mRecordingSnap.setVisibility(z ? 0 : 8);
                    }
                    if (FragmentBottomAction.this.mVideoReverseEnable && !z) {
                        FragmentBottomAction.this.mRecordingReverse.setVisibility(8);
                    }
                    if (FragmentBottomAction.this.mBackEnable) {
                        ImageView access$1700 = FragmentBottomAction.this.mMimojiBack;
                        if (!z) {
                            i = 8;
                        }
                        access$1700.setVisibility(i);
                    }
                    if (z) {
                        FragmentBottomAction.this.mThumbnailImageLayout.setVisibility(8);
                        if (FragmentBottomAction.this.mCameraPickEnable) {
                            FragmentBottomAction.this.mCameraPicker.setVisibility(8);
                        }
                        FragmentBottomAction.this.mThumbnailImage.setVisibility(8);
                    }
                }
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                if (!z) {
                    if (FragmentBottomAction.this.mCameraPickEnable) {
                        FragmentBottomAction.this.mCameraPicker.setVisibility(0);
                    }
                    FragmentBottomAction.this.mThumbnailImage.setVisibility(0);
                    FragmentBottomAction.this.mThumbnailImageLayout.setVisibility(0);
                }
            }
        });
        this.mBottomAnimator.start();
    }

    public void animateShineBeauty(boolean z) {
        this.mModeSelectLayout.animateShineBeauty(z);
    }

    public boolean canSnap() {
        ModeProtocol.CameraAction cameraAction = (ModeProtocol.CameraAction) ModeCoordinatorImpl.getInstance().getAttachProtocol(161);
        return cameraAction != null && !cameraAction.isBlockSnap();
    }

    public boolean canSwipeChangeMode() {
        if (!this.mVideoRecordingStarted && DataRepository.dataItemLive().getMimojiStatusManager().IsInMimojiPreview() && isVisible()) {
            int i = this.mCurrentMode;
            return (i == 182 || i == 179 || isFocusOrZoomMoving()) ? false : true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0021, code lost:
        if (r8 == 5) goto L_0x0018;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001a, code lost:
        if (r8 == 5) goto L_0x001f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0047 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0045 A[EDGE_INSN: B:26:0x0045->B:17:0x0045 ?: BREAK  , SYNTHETIC] */
    public void changeModeByGravity(int i, int i2) {
        int size;
        int i3;
        if (i != -1) {
            if (!Util.isLayoutRTL(getContext())) {
                if (i != 3) {
                }
                i = 8388611;
                int transferredMode = ComponentModuleList.getTransferredMode(this.mCurrentMode);
                size = this.mComponentModuleList.getItems().size();
                int i4 = 0;
                i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        break;
                    } else if (this.mComponentModuleList.getMode(i3) == transferredMode) {
                        i4 = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i == 8388611) {
                    if (i == 8388613 && i4 < size - 1) {
                        i4++;
                    }
                } else if (i4 > 0) {
                    i4--;
                }
                changeModeByNewMode(this.mComponentModuleList.getMode(i4), i2);
            } else if (i != 3) {
            }
            i = 8388613;
            int transferredMode2 = ComponentModuleList.getTransferredMode(this.mCurrentMode);
            size = this.mComponentModuleList.getItems().size();
            int i42 = 0;
            i3 = 0;
            while (true) {
                if (i3 >= size) {
                }
                i3++;
            }
            if (i == 8388611) {
            }
            changeModeByNewMode(this.mComponentModuleList.getMode(i42), i2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0055, code lost:
        if (r1 != 169) goto L_0x0078;
     */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0099 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x009a  */
    public void changeModeByNewMode(int i, int i2) {
        if (i == 166 && CameraSettings.isFrontCamera() && DataRepository.dataItemFeature().sd()) {
            i = 176;
        }
        if (i == 163 || i == 165) {
            i = DataRepository.dataItemConfig().getComponentConfigRatio().getMappingModeByRatio(163);
        }
        if (i != this.mCurrentMode) {
            if (i == 167 && CameraSettings.isFromProVideoMudule()) {
                i = 180;
            }
            int i3 = this.mCurrentMode;
            if (i3 == 180) {
                CameraSettings.setIsFromProVideoMudule(true);
            } else if (i3 == 167) {
                CameraSettings.setIsFromProVideoMudule(false);
            }
            int i4 = this.mCurrentMode;
            if (i4 != 162) {
                if (i4 == 163) {
                    if (CameraSettings.isUltraPixelOn()) {
                        ((ModeProtocol.ConfigChanges) ModeCoordinatorImpl.getInstance().getAttachProtocol(164)).switchOffElementsSilent(209);
                    }
                }
                if ((i == 174 || i == 183) && !CameraSettings.isLiveModuleClicked()) {
                    CameraSettings.setLiveModuleClicked(true);
                }
                DataItemGlobal dataItemGlobal = (DataItemGlobal) DataRepository.provider().dataGlobal();
                if (isThumbLoading()) {
                    ModeProtocol.CameraAction cameraAction = (ModeProtocol.CameraAction) ModeCoordinatorImpl.getInstance().getAttachProtocol(161);
                    if (cameraAction == null || !cameraAction.isDoingAction()) {
                        this.mCurrentMode = i;
                        dataItemGlobal.setCurrentMode(i);
                        ViberatorContext.getInstance(getActivity().getApplicationContext()).performModeSwitch();
                        ((Camera) getContext()).onModeSelected(StartControl.create(i).setStartDelay(i2).setResetType(4).setViewConfigType(2).setNeedBlurAnimation(true));
                        return;
                    }
                    return;
                }
                return;
            }
            if (i == 162 || i == 169) {
                return;
            }
            CameraSettings.setLiveModuleClicked(true);
            DataItemGlobal dataItemGlobal2 = (DataItemGlobal) DataRepository.provider().dataGlobal();
            if (isThumbLoading()) {
            }
        }
    }

    public void expandShineBottomMenu(ComponentRunningShine componentRunningShine) {
        if (this.mBottomRecordingTime.getVisibility() == 0) {
            this.mBottomRecordingTime.setVisibility(8);
        }
        this.mModeSelectLayout.expandShine(componentRunningShine, this.mCurrentMode);
    }

    public void filterUiChange() {
    }

    public boolean forceSwitchFront() {
        if (((DataItemGlobal) DataRepository.provider().dataGlobal()).getCurrentCameraId() == 1) {
            return false;
        }
        onClick(this.mCameraPicker);
        return true;
    }

    public int getBeautyActionMenuType() {
        return this.mCurrentBeautyActionMenuType;
    }

    public int getFragmentInto() {
        return 241;
    }

    /* access modifiers changed from: protected */
    public int getLayoutResourceId() {
        return R.layout.fragment_bottom_action;
    }

    public void hideExtra() {
        if (this.mIsShowLighting) {
            ModeProtocol.ConfigChanges configChanges = (ModeProtocol.ConfigChanges) ModeCoordinatorImpl.getInstance().getAttachProtocol(164);
            if (configChanges != null) {
                configChanges.showOrHideLighting(false);
            }
        }
        if (this.mIsShowMiMoji) {
            ModeProtocol.ConfigChanges configChanges2 = (ModeProtocol.ConfigChanges) ModeCoordinatorImpl.getInstance().getAttachProtocol(164);
            if (configChanges2 != null) {
                configChanges2.showOrHideMimoji();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void initView(View view) {
        this.mBottomActionView = (FrameLayout) view.findViewById(R.id.bottom_action);
        ((ViewGroup.MarginLayoutParams) this.mBottomActionView.getLayoutParams()).height = Util.getBottomHeight();
        this.mBottomRollDownHeight = getResources().getDimensionPixelSize(R.dimen.bottom_roll_down_height);
        this.mV9bottomParentLayout = (RelativeLayout) view.findViewById(R.id.v9_bottom_parent);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mV9bottomParentLayout.getLayoutParams();
        marginLayoutParams.height = Math.round(((float) Util.sBottomBarHeight) * 0.7f);
        marginLayoutParams.bottomMargin = Util.sBottomMargin;
        marginLayoutParams.topMargin = Math.round(((float) Util.sBottomBarHeight) * 0.3f);
        this.mComponentModuleList = DataRepository.dataItemGlobal().getComponentModuleList();
        this.mModeSelectLayout = new BottomActionMenu(getContext(), (FrameLayout) view.findViewById(R.id.mode_select_layout));
        this.mEdgeHorizonScrollView = this.mModeSelectLayout.getCameraOperateMenuView();
        this.mBottomMenuLayout = view.findViewById(R.id.bottom_menu_layout);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mBottomMenuLayout.getLayoutParams();
        marginLayoutParams2.height = Math.round(((float) Util.sBottomBarHeight) * 0.3f);
        marginLayoutParams2.bottomMargin = Util.sBottomMargin;
        this.mModeSelectView = this.mModeSelectLayout.getCameraOperateSelectView();
        this.mModeSelectView.init(this.mComponentModuleList, this.mCurrentMode);
        this.mModeSelectView.setOnModeClickedListener(this);
        this.mThumbnailImageLayout = (ViewGroup) view.findViewById(R.id.v9_thumbnail_layout);
        this.mThumbnailImage = (ImageView) this.mThumbnailImageLayout.findViewById(R.id.v9_thumbnail_image);
        this.mThumbnailProgress = (ProgressBar) view.findViewById(R.id.v9_recording_progress);
        this.mRecordingPause = (ImageView) view.findViewById(R.id.v9_recording_pause);
        this.mShutterButton = (CameraSnapView) view.findViewById(R.id.v9_shutter_button_internal);
        this.mCameraPicker = (ImageView) view.findViewById(R.id.v9_camera_picker);
        this.mRecordingSnap = (ImageView) view.findViewById(R.id.v9_recording_snap);
        this.mRecordingReverse = (ImageView) view.findViewById(R.id.v9_recording_reverse);
        this.mRecordingSwitch = (ImageView) view.findViewById(R.id.v9_capture_recording_switch);
        this.mFragmentLayoutExtra = view.findViewById(R.id.fragment_bottom_extra);
        this.mPostProcess = (ProgressBar) view.findViewById(R.id.v9_post_processing);
        this.mBottomRecordingTime = (TextView) view.findViewById(R.id.bottom_recording_time_view);
        this.mBottomRecordingCameraPicker = (ImageView) view.findViewById(R.id.bottom_recording_camera_picker);
        this.mBottomRecordingCameraPicker.setOnClickListener(this);
        this.mShutterButton.setSnapListener(this);
        this.mShutterButton.setSnapClickEnable(false);
        this.mCaptureProgressDelay = getResources().getInteger(R.integer.capture_progress_delay_time);
        this.mRecordProgressDelay = getResources().getInteger(R.integer.record_progress_delay_time);
        this.mThumbnailImageLayout.setOnClickListener(this);
        this.mCameraPicker.setOnClickListener(this);
        this.mRecordingPause.setOnClickListener(this);
        this.mRecordingSnap.setOnClickListener(this);
        this.mRecordingReverse.setOnClickListener(this);
        this.mRecordingSwitch.setOnClickListener(this);
        this.mMimojiBack = (ImageView) view.findViewById(R.id.mimoji_create_back);
        this.mMimojiBack.setOnClickListener(this);
        adjustViewBackground(this.mModeSelectLayout.getView(), this.mCurrentMode);
        provideAnimateElement(this.mCurrentMode, (List<Completable>) null, 2);
        this.mIsIntentAction = DataRepository.dataItemGlobal().isIntentAction();
        this.mCubicEaseOut = new CubicEaseOutInterpolator();
        this.mSineEaseOut = new SineEaseOutInterpolator();
        this.mFilterListHeight = getContext().getResources().getDimensionPixelSize(R.dimen.filter_still_height);
        if (Util.isAccessible()) {
            Util.setAccessibilityFocusable(this.mV9bottomParentLayout, false);
        }
    }

    public boolean isShowFilterView() {
        return false;
    }

    public boolean isShowLightingView() {
        return this.mIsShowLighting;
    }

    public void notifyAfterFrameAvailable(int i) {
        super.notifyAfterFrameAvailable(i);
        FragmentActionLighting fragmentActionLighting = this.mFragmentActionLighting;
        if (fragmentActionLighting != null && fragmentActionLighting.isAdded()) {
            this.mFragmentActionLighting.reInitAdapterBgMode(true);
        }
        this.mModeSelectLayout.initBeautyMenuView();
        adjustViewBackground(this.mModeSelectLayout.getView(), this.mCurrentMode);
        ProgressBar progressBar = this.mPostProcess;
        if (progressBar != null && progressBar.getVisibility() == 0) {
            Log.w(TAG, "notifyAfterFrameAvailable: shutter process bar is showing");
            processingFinish();
            CameraSnapView cameraSnapView = this.mShutterButton;
            if (cameraSnapView != null) {
                cameraSnapView.setParameters(this.mCurrentMode, false, isFPS960());
            }
        }
        if (DataRepository.dataItemLive().getMimojiStatusManager().IsInMimojiCreate()) {
            ((ModeProtocol.MainContentProtocol) ModeCoordinatorImpl.getInstance().getAttachProtocol(166)).mimojiStart();
        }
    }

    public void notifyDataChanged(int i, int i2) {
        super.notifyDataChanged(i, i2);
        boolean isIntentAction = DataRepository.dataItemGlobal().isIntentAction();
        if (isIntentAction != this.mIsIntentAction) {
            this.mIsIntentAction = isIntentAction;
            this.mModeSelectView.init(this.mComponentModuleList, this.mCurrentMode);
            initThumbLayoutByIntent();
        }
        this.mInLoading = false;
        FragmentActionLighting fragmentActionLighting = this.mFragmentActionLighting;
        if (fragmentActionLighting != null && fragmentActionLighting.isAdded()) {
            this.mFragmentActionLighting.reInit();
        }
        FragmentActionMimoji fragmentActionMimoji = this.mFragmentActionMimoji;
        if (fragmentActionMimoji != null && fragmentActionMimoji.isAdded()) {
            this.mFragmentActionMimoji.reInit();
        }
        if (!Util.isAccessible()) {
            return;
        }
        if (162 == this.mCurrentMode) {
            this.mShutterButton.setContentDescription(getString(R.string.accessibility_record_button));
        } else {
            this.mShutterButton.setContentDescription(getString(R.string.accessibility_shutter_button));
        }
    }

    public void onAngleChanged(float f2) {
    }

    public boolean onBackEvent(int i) {
        if (!(i == 1 && this.mIsShowLighting)) {
            return false;
        }
        hideExtra();
        if (Util.isAccessible()) {
            ((ModeProtocol.TopAlert) ModeCoordinatorImpl.getInstance().getAttachProtocol(172)).updateContentDescription();
        }
        return true;
    }

    public void onBeautyRecordingStart() {
        ViewCompat.animate(this.mModeSelectView).alpha(0.0f).start();
    }

    public void onBeautyRecordingStop() {
        ViewCompat.animate(this.mModeSelectView).alpha(1.0f).start();
    }

    public void onBottomMenuAnimate(int i, int i2) {
        this.mModeSelectLayout.bottomMenuAnimate(i, i2);
    }

    public void onClick(View view) {
        if (!isEnableClick()) {
            Log.d(TAG, "onClick: disabled");
            return;
        }
        ModeProtocol.CameraAction cameraAction = (ModeProtocol.CameraAction) ModeCoordinatorImpl.getInstance().getAttachProtocol(161);
        if (cameraAction == null) {
            Log.d(TAG, "onClick: null action");
            return;
        }
        Module currentModule = ((ActivityBase) getContext()).getCurrentModule();
        if (!currentModule.isIgnoreTouchEvent() || (currentModule.isShot2GalleryOrEnableParallel() && view.getId() == R.id.v9_thumbnail_layout)) {
            switch (view.getId()) {
                case R.id.bottom_recording_camera_picker:
                    if (this.mVideoRecordingPaused) {
                        int i = this.mCurrentMode;
                        if (i == 174) {
                            CameraStatUtils.trackLiveClick(MistatsConstants.Live.VALUE_LIVE_CLICK_SWITCH);
                        } else if (i == 183) {
                            CameraStatUtils.trackMiLiveClick(MistatsConstants.MiLive.VALUE_MI_LIVE_CLICK_SWITCH);
                        }
                        changeCamera(view);
                        return;
                    }
                    return;
                case R.id.mimoji_create_back:
                    DataRepository.dataItemLive().getMimojiStatusManager().setMode(MimojiStatusManager.MIMOJI_PREVIEW);
                    this.mMimojiBack.setVisibility(8);
                    this.mShutterButton.intoPattern(177, false);
                    ((ModeProtocol.RecordState) ModeCoordinatorImpl.getInstance().getAttachProtocol(212)).onMimojiCreateBack();
                    CameraStatUtils.trackMimojiClick(MistatsConstants.Mimoji.MIMOJI_CLICK_CREATE_BACK, MistatsConstants.BaseEvent.CREATE);
                    return;
                case R.id.v9_camera_picker:
                    if (!cameraAction.isDoingAction() && !cameraAction.isRecording() && !isThumbLoading()) {
                        hideExtra();
                        if (DataRepository.dataItemLive().getMimojiStatusManager().IsInMimojiCreate()) {
                            CameraStatUtils.trackMimojiClick(MistatsConstants.Mimoji.MIMOJI_CLICK_CREATE_SWITCH, MistatsConstants.BaseEvent.CREATE);
                        }
                        changeCamera(view);
                        return;
                    }
                    return;
                case R.id.v9_capture_recording_switch:
                    if (!cameraAction.isDoingAction()) {
                        switchVideoCapture(view);
                        return;
                    }
                    return;
                case R.id.v9_recording_pause:
                    if (this.mVideoPauseSupported && this.mVideoRecordingStarted) {
                        int i2 = this.mCurrentMode;
                        if (!(i2 == 162 || i2 == 169)) {
                            if (i2 != 174) {
                                if (i2 != 180) {
                                    if (i2 != 183) {
                                        return;
                                    }
                                }
                            } else if (this.mVideoRecordingPaused) {
                                CameraStatUtils.trackLiveClick(MistatsConstants.Live.LIVE_CLICK_RESUME);
                            } else {
                                CameraStatUtils.trackLiveClick(MistatsConstants.Live.LIVE_CLICK_PAUSE);
                            }
                            long currentTimeMillis = System.currentTimeMillis() - this.mLastPauseTime;
                            if (currentTimeMillis <= 0 || currentTimeMillis >= 500) {
                                this.mLastPauseTime = System.currentTimeMillis();
                                ActivityBase activityBase = (ActivityBase) getContext();
                                if (activityBase == null || (!(activityBase.getCurrentModule() instanceof LiveModule) && !(activityBase.getCurrentModule() instanceof MiLiveModule))) {
                                    Log.w(TAG, "onClick: recording pause is not allowed!!!");
                                    return;
                                } else {
                                    ((ILiveModule) activityBase.getCurrentModule()).onPauseButtonClick();
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        ((VideoModule) ((ActivityBase) getContext()).getCurrentModule()).onPauseButtonClick();
                        return;
                    }
                    return;
                case R.id.v9_recording_reverse:
                    if (this.mVideoReverseEnable && this.mVideoRecordingStarted && this.mShutterButton.hasSegments()) {
                        showReverseConfirmDialog();
                        return;
                    }
                    return;
                case R.id.v9_recording_snap:
                    if (this.mVideoCaptureEnable && this.mVideoRecordingStarted) {
                        ActivityBase activityBase2 = (ActivityBase) getContext();
                        if (activityBase2 == null || (!(activityBase2.getCurrentModule() instanceof VideoModule) && !(activityBase2.getCurrentModule() instanceof FunModule))) {
                            Log.w(TAG, "onClick: recording snap is not allowed!!!");
                            return;
                        }
                        Module currentModule2 = activityBase2.getCurrentModule();
                        if (currentModule2 instanceof VideoModule) {
                            ((VideoModule) currentModule2).takeVideoSnapShoot();
                            return;
                        } else if (currentModule2 instanceof FunModule) {
                            ((FunModule) currentModule2).takePreviewSnapShoot();
                            return;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                case R.id.v9_thumbnail_layout:
                    if (isThumbLoading()) {
                        Log.w(TAG, "onClick: ignore thumbnail click event as loading thumbnail");
                        return;
                    } else if (!DataRepository.dataItemGlobal().isIntentAction()) {
                        cameraAction.onThumbnailClicked((View) null);
                        return;
                    } else {
                        cameraAction.onReviewCancelClicked();
                        return;
                    }
                default:
                    return;
            }
        } else {
            Log.w(TAG, "onClick: ignore click event, because module isn't ready");
        }
    }

    public boolean onHandleSwitcher(int i) {
        if (!this.mIsShowLighting) {
            return false;
        }
        ModeProtocol.CameraAction cameraAction = (ModeProtocol.CameraAction) ModeCoordinatorImpl.getInstance().getAttachProtocol(161);
        if (cameraAction != null && !cameraAction.isDoingAction() && this.mIsShowLighting) {
            this.mFragmentActionLighting.switchLighting(i);
        }
        return true;
    }

    public void onModeClicked(int i) {
        if (!isShowFilterView() && !isShowLightingView()) {
            if (this.mCurrentMode == 177 && !DataRepository.dataItemLive().getMimojiStatusManager().IsInMimojiPreview()) {
                return;
            }
            if (this.mCurrentMode != 180 || i != 167) {
                changeModeByNewMode(i, 0);
            }
        }
    }

    public void onResume() {
        super.onResume();
        initThumbLayoutByIntent();
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    public void onSnapClick() {
        if (!isEnableClick()) {
            Log.w(TAG, "onSnapClick: disabled");
        } else if (getContext() == null) {
            Log.w(TAG, "onSnapClick: no context");
        } else {
            Camera camera = (Camera) getContext();
            Module currentModule = camera.getCurrentModule();
            if (currentModule != null && currentModule.isIgnoreTouchEvent()) {
                Log.w(TAG, "onSnapClick: ignore onSnapClick event, because module isn't ready");
            } else if (!CameraSettings.isFrontCamera() || !camera.isScreenSlideOff()) {
                ModeProtocol.CameraAction cameraAction = (ModeProtocol.CameraAction) ModeCoordinatorImpl.getInstance().getAttachProtocol(161);
                if (cameraAction == null) {
                    Log.w(TAG, "onSnapClick: no camera action");
                    return;
                }
                Log.d(TAG, "onSnapClick");
                int i = this.mCurrentMode;
                if (!(i == 161 || i == 162 || i == 166 || i == 169 || i == 172 || i == 174 || i == 183 || i == 176)) {
                    if (i != 177) {
                        if (!(i == 179 || i == 180)) {
                            if (cameraAction.isBlockSnap()) {
                                Log.w(TAG, "onSnapClick: block snap");
                                return;
                            }
                            cameraAction.onShutterButtonClick(10);
                        }
                    } else if (cameraAction.isDoingAction()) {
                        Log.w(TAG, "onSnapClick: doing action");
                        return;
                    } else {
                        cameraAction.onShutterButtonClick(10);
                    }
                    if (!Util.isAccessible()) {
                        if (162 != this.mCurrentMode) {
                            this.mEdgeHorizonScrollView.setContentDescription(getString(R.string.accessibility_camera_shutter_finish));
                        } else if (((Camera) getActivity()).isRecording()) {
                            this.mEdgeHorizonScrollView.setContentDescription(getString(R.string.accessibility_camera_record_start));
                        } else {
                            this.mEdgeHorizonScrollView.setContentDescription(getString(R.string.accessibility_camera_record_stop));
                        }
                        this.mEdgeHorizonScrollView.sendAccessibilityEvent(32768);
                        return;
                    }
                    return;
                }
                if (!this.mVideoRecordingStarted) {
                    this.mVideoRecordingStarted = true;
                }
                cameraAction.onShutterButtonClick(10);
                if (!Util.isAccessible()) {
                }
            } else {
                Log.w(TAG, "onSnapClick: ignore onSnapClick event, because screen slide is off");
            }
        }
    }

    public void onSnapLongPress() {
        if (isEnableClick()) {
            ModeProtocol.CameraAction cameraAction = (ModeProtocol.CameraAction) ModeCoordinatorImpl.getInstance().getAttachProtocol(161);
            if (cameraAction != null && !cameraAction.isDoingAction()) {
                if (getContext() != null) {
                    Camera camera = (Camera) getContext();
                    if (CameraSettings.isFrontCamera() && camera.isScreenSlideOff()) {
                        return;
                    }
                }
                Log.d(TAG, "onSnapLongPress");
                if (cameraAction.onShutterButtonLongClick()) {
                    this.mLongPressBurst = true;
                }
            }
        }
    }

    public void onSnapLongPressCancelIn() {
        if (isEnableClick()) {
            ModeProtocol.CameraAction cameraAction = (ModeProtocol.CameraAction) ModeCoordinatorImpl.getInstance().getAttachProtocol(161);
            if (cameraAction != null) {
                Log.d(TAG, "onSnapLongPressCancelIn");
                cameraAction.onShutterButtonLongClickCancel(true);
                int i = this.mCurrentMode;
                if (i != 163) {
                    if (i == 165 || i == 167 || i == 171) {
                        onSnapClick();
                    }
                } else if (this.mLongPressBurst) {
                    this.mLongPressBurst = false;
                }
            }
        }
    }

    public void onSnapLongPressCancelOut() {
        if (isEnableClick()) {
            ModeProtocol.CameraAction cameraAction = (ModeProtocol.CameraAction) ModeCoordinatorImpl.getInstance().getAttachProtocol(161);
            if (cameraAction != null) {
                Log.d(TAG, "onSnapLongPressCancelOut");
                cameraAction.onShutterButtonLongClickCancel(false);
                if (this.mLongPressBurst) {
                    this.mLongPressBurst = false;
                }
            }
        }
    }

    public void onSnapPrepare() {
        if (isEnableClick()) {
            ModeProtocol.CameraAction cameraAction = (ModeProtocol.CameraAction) ModeCoordinatorImpl.getInstance().getAttachProtocol(161);
            if (cameraAction != null) {
                Log.d(TAG, "onSnapPrepare");
                cameraAction.onShutterButtonFocus(true, 2);
            }
        }
    }

    public void onSwitchBeautyActionMenu(int i) {
        if (this.mBottomRecordingTime.getVisibility() == 0) {
            this.mBottomRecordingTime.setVisibility(8);
        }
        this.mCurrentBeautyActionMenuType = i;
        this.mModeSelectLayout.switchMenuMode(1, i, true);
    }

    public void onSwitchCameraActionMenu(int i) {
        if (this.mVideoRecordingStarted) {
            int i2 = this.mCurrentMode;
            if ((i2 == 174 || i2 == 183) && this.mBottomRecordingTime.getVisibility() != 0) {
                this.mBottomRecordingTime.setVisibility(0);
            }
        }
        if (this.mIsShowMiMoji) {
            showOrHideMiMojiView();
        }
        this.mModeSelectLayout.switchMenuMode(i, true);
    }

    public void onSwitchKaleidoscopeActionMenu(int i) {
        if (this.mBottomRecordingTime.getVisibility() == 0) {
            this.mBottomRecordingTime.setVisibility(8);
        }
        this.mModeSelectLayout.switchMenuMode(3, i, true);
    }

    public void onSwitchLiveActionMenu(int i) {
        if (this.mBottomRecordingTime.getVisibility() == 0) {
            this.mBottomRecordingTime.setVisibility(8);
        }
        this.mCurrentLiveActionMenuType = i;
        this.mModeSelectLayout.switchMenuMode(2, i, true);
    }

    public void onTrackSnapMissTaken(long j) {
        if (isEnableClick()) {
            ModeProtocol.CameraActionTrack cameraActionTrack = (ModeProtocol.CameraActionTrack) ModeCoordinatorImpl.getInstance().getAttachProtocol(186);
            if (cameraActionTrack != null) {
                Log.d(TAG, "onTrackSnapMissTaken " + j + C0157d.H);
                cameraActionTrack.onTrackShutterButtonMissTaken(j);
            }
        }
    }

    public void onTrackSnapTaken(long j) {
        if (isEnableClick()) {
            ModeProtocol.CameraActionTrack cameraActionTrack = (ModeProtocol.CameraActionTrack) ModeCoordinatorImpl.getInstance().getAttachProtocol(186);
            if (cameraActionTrack != null) {
                Log.d(TAG, "onTrackSnapTaken " + j + C0157d.H);
                cameraActionTrack.onTrackShutterButtonTaken(j);
            }
        }
    }

    public void processingAudioCapture(boolean z) {
        if (z) {
            this.mShutterButton.startRing();
        } else {
            this.mShutterButton.stopRing();
        }
    }

    public void processingFailed() {
        updateLoading(true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0043, code lost:
        if (r2 != 183) goto L_0x0083;
     */
    public void processingFinish() {
        if (isAdded()) {
            if (this.mShutterButton.getVisibility() != 0) {
                this.mShutterButton.setVisibility(0);
            }
            this.mEdgeHorizonScrollView.setEnabled(true);
            this.mEdgeHorizonScrollView.setVisibility(0);
            this.mModeSelectView.setEnabled(true);
            this.mVideoRecordingStarted = false;
            this.mVideoRecordingPaused = false;
            setProgressBarVisible(8);
            this.mShutterButton.showRoundPaintItem();
            int i = this.mCurrentMode;
            if (i != 174) {
                if (i == 177) {
                    this.mMimojiBack.setVisibility(8);
                    this.mModeSelectView.setVisibility(0);
                    this.mModeSelectLayout.getView().setVisibility(0);
                    this.mShutterButton.intoPattern(177, false);
                } else if (i == 180) {
                    this.mRecordingSwitch.setAnimation((Animation) null);
                    this.mRecordingSwitch.setRotation(0.0f);
                    AlphaInOnSubscribe.directSetResult(this.mRecordingSwitch);
                }
                BottomAnimationConfig configVariables = BottomAnimationConfig.generate(false, this.mCurrentMode, false, isFPS960(), CameraSettings.isVideoBokehOn()).configVariables();
                configVariables.mIsInMimojiCreate = DataRepository.dataItemLive().getMimojiStatusManager().IsInMimojiCreate();
                this.mShutterButton.triggerAnimation(configVariables);
                updateBottomInRecording(false, false);
            }
            this.mModeSelectView.setVisibility(0);
            this.mModeSelectLayout.getView().setVisibility(0);
            setRecordingTimeState(2);
            BottomAnimationConfig configVariables2 = BottomAnimationConfig.generate(false, this.mCurrentMode, false, isFPS960(), CameraSettings.isVideoBokehOn()).configVariables();
            configVariables2.mIsInMimojiCreate = DataRepository.dataItemLive().getMimojiStatusManager().IsInMimojiCreate();
            this.mShutterButton.triggerAnimation(configVariables2);
            updateBottomInRecording(false, false);
        }
    }

    public void processingMimojiBack() {
        this.mVideoRecordingStarted = false;
        DataRepository.dataItemLive().getMimojiStatusManager().setMode(MimojiStatusManager.MIMOJI_PREVIEW);
        this.mModeSelectView.setVisibility(0);
        Completable.create(new AlphaInOnSubscribe(this.mModeSelectLayout.getView())).subscribe();
        this.mThumbnailImageLayout.setVisibility(0);
        this.mThumbnailImageLayout.setAlpha(1.0f);
        this.mThumbnailImage.setVisibility(0);
        this.mMimojiBack.setVisibility(8);
        this.mEdgeHorizonScrollView.setEnabled(true);
        this.mModeSelectView.setEnabled(true);
    }

    public void processingMimojiPrepare() {
        this.mEdgeHorizonScrollView.setEnabled(false);
        this.mModeSelectView.setEnabled(false);
        this.mVideoRecordingStarted = true;
        updateBottomInRecording(true, true);
        this.mShutterButton.intoPattern(163, false);
    }

    public void processingPause() {
        this.mVideoRecordingPaused = true;
        this.mShutterButton.pauseRecording();
        this.mRecordingPause.setImageResource(R.drawable.ic_recording_resume);
        this.mRecordingPause.setContentDescription(getString(R.string.accessibility_video_resume_button));
        int i = this.mCurrentMode;
        if (i == 174 || i == 183) {
            setRecordingTimeState(3);
            this.mShutterButton.addSegmentNow();
            int i2 = 8;
            this.mModeSelectView.setVisibility(8);
            Completable.create(new AlphaInOnSubscribe(this.mModeSelectLayout.getView())).subscribe();
            int visibility = this.mRecordingReverse.getVisibility();
            ImageView imageView = this.mRecordingReverse;
            if (visibility != 0) {
                i2 = 0;
            }
            imageView.setVisibility(i2);
        }
    }

    public void processingPostAction() {
        if (this.mShutterButton.getVisibility() != 0) {
            this.mShutterButton.setVisibility(0);
        }
        this.mShutterButton.hideRoundPaintItem();
        this.mShutterButton.triggerAnimation(BottomAnimationConfig.generate(true, this.mCurrentMode, false, isFPS960(), CameraSettings.isVideoBokehOn()).configVariables());
        this.mEdgeHorizonScrollView.setVisibility(0);
        updateBottomInRecording(false, true);
        setProgressBarVisible(0);
    }

    public void processingPrepare() {
        BottomAnimationConfig configVariables = BottomAnimationConfig.generate(false, this.mCurrentMode, true, isFPS960(), CameraSettings.isVideoBokehOn()).configVariables();
        if (this.mCurrentMode == 177 && !DataRepository.dataItemLive().getMimojiStatusManager().IsInMimojiCreate()) {
            this.mShutterButton.intoPattern(162, false);
        }
        updateBottomInRecording(true, true);
        this.mShutterButton.prepareRecording(configVariables);
        int i = this.mCurrentMode;
        if (i == 174 || i == 183) {
            setRecordingTimeState(1);
        }
    }

    public void processingResume() {
        int i = 0;
        this.mVideoRecordingPaused = false;
        this.mShutterButton.resumeRecording();
        this.mRecordingPause.setImageResource(R.drawable.ic_recording_pause);
        this.mRecordingPause.setContentDescription(getString(R.string.accessibility_video_pause_button));
        int i2 = this.mCurrentMode;
        if (i2 == 174 || i2 == 183) {
            setRecordingTimeState(4);
            Completable.create(new AlphaOutOnSubscribe(this.mModeSelectLayout.getView())).subscribe();
            int visibility = this.mRecordingReverse.getVisibility();
            this.mRecordingReverse.setVisibility(visibility == 0 ? 8 : 0);
            ImageView imageView = this.mBottomRecordingCameraPicker;
            if (visibility == 0) {
                i = 8;
            }
            imageView.setVisibility(i);
        }
    }

    public void processingStart() {
        this.mEdgeHorizonScrollView.setEnabled(false);
        this.mEdgeHorizonScrollView.setVisibility(8);
        this.mModeSelectView.setEnabled(false);
        this.mVideoRecordingStarted = true;
        this.mShutterButton.triggerAnimation(BottomAnimationConfig.generate(false, this.mCurrentMode, true, isFPS960(), CameraSettings.isVideoBokehOn()).configVariables());
        this.mRecordingSwitch.setAnimation((Animation) null);
        this.mRecordingSwitch.setRotation(0.0f);
        AlphaOutOnSubscribe.directSetResult(this.mRecordingSwitch);
    }

    public void processingWorkspace(boolean z) {
        if (z) {
            this.mShutterButton.showRoundPaintItem();
            this.mShutterButton.invalidate();
            this.mBottomRecordingTime.setVisibility(0);
            if (this.mRecordingPause.getVisibility() == 8) {
                this.mRecordingPause.setImageResource(R.drawable.ic_recording_resume);
                Completable.create(new AlphaInOnSubscribe(this.mRecordingPause).targetGone()).subscribe();
            }
            if (this.mRecordingReverse.getVisibility() == 8) {
                Completable.create(new AlphaInOnSubscribe(this.mRecordingReverse).targetGone()).subscribe();
            }
            if (this.mBottomRecordingCameraPicker.getVisibility() == 8) {
                Completable.create(new AlphaInOnSubscribe(this.mBottomRecordingCameraPicker).targetGone()).subscribe();
                return;
            }
            return;
        }
        this.mShutterButton.pauseRecording();
        this.mShutterButton.hideRoundPaintItem();
        this.mShutterButton.invalidate();
        this.mShutterButton.addSegmentNow();
        this.mBottomRecordingTime.setVisibility(8);
        if (this.mRecordingPause.getVisibility() == 0) {
            Completable.create(new AlphaOutOnSubscribe(this.mRecordingPause).targetGone()).subscribe();
        }
        if (this.mRecordingReverse.getVisibility() == 0) {
            Completable.create(new AlphaOutOnSubscribe(this.mRecordingReverse).targetGone()).subscribe();
        }
        if (this.mBottomRecordingCameraPicker.getVisibility() == 0) {
            Completable.create(new AlphaOutOnSubscribe(this.mBottomRecordingCameraPicker).targetGone()).subscribe();
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01e0, code lost:
        if (r9 != 180) goto L_0x01e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01e2, code lost:
        r9 = com.android.camera.R.drawable.ic_switch_take_photo;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01e6, code lost:
        r9 = com.android.camera.R.drawable.ic_switch_record_video;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01e9, code lost:
        r10.setImageResource(r9);
        animateViews(r1, (java.util.List<io.reactivex.Completable>) null, r8.mRecordingSwitch);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01f1, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00d1, code lost:
        r1 = -1;
        r11 = 1;
        r0 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x013c, code lost:
        if (r8.mCameraPicker.getTag() == null) goto L_0x014c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x014a, code lost:
        if (((java.lang.Integer) r8.mCameraPicker.getTag()).intValue() == r11) goto L_0x015a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x014c, code lost:
        r8.mCameraPicker.setTag(java.lang.Integer.valueOf(r11));
        animateViews(r11, r10, r8.mCameraPicker);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0164, code lost:
        if (r8.mModeSelectLayout.getView().getTag() == null) goto L_0x0178;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0176, code lost:
        if (((java.lang.Integer) r8.mModeSelectLayout.getView().getTag()).intValue() == r2) goto L_0x018e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0178, code lost:
        r8.mModeSelectLayout.getView().setTag(java.lang.Integer.valueOf(r2));
        animateViews(r2, r10, r8.mModeSelectLayout.getView());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0194, code lost:
        if (r8.mThumbnailImageLayout.getTag() == null) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01a2, code lost:
        if (((java.lang.Integer) r8.mThumbnailImageLayout.getTag()).intValue() == r0) goto L_0x01b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01a4, code lost:
        r8.mThumbnailImageLayout.setTag(java.lang.Integer.valueOf(r0));
        animateViews(r0, r10, r8.mThumbnailImageLayout);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01b8, code lost:
        if (r8.mRecordingSwitch.getTag() == null) goto L_0x01c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01c6, code lost:
        if (((java.lang.Integer) r8.mRecordingSwitch.getTag()).intValue() != r1) goto L_0x01c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01c8, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01c9, code lost:
        r8.mRecordingSwitch.setAnimation((android.view.animation.Animation) null);
        r8.mRecordingSwitch.setRotation(0.0f);
        r8.mRecordingSwitch.setTag(java.lang.Integer.valueOf(r1));
        r10 = r8.mRecordingSwitch;
     */
    public void provideAnimateElement(int i, List<Completable> list, int i2) {
        int i3;
        int i4;
        int i5 = this.mCurrentMode;
        int i6 = 1;
        boolean z = i2 == 3;
        if (z || i5 != i) {
            View view = getView();
            if (!(view == null || ViewCompat.getTranslationY(view) == 0.0f)) {
                ViewCompat.setTranslationY(view, 0.0f);
            }
            AlertDialog alertDialog = this.mReverseDialog;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.mReverseDialog = null;
            }
            if (this.mIsShowMiMoji) {
                showOrHideLightingView();
            }
        }
        if (this.mIsShowLighting) {
            showOrHideLightingView();
        }
        if (i5 == 177 && DataRepository.dataItemLive().getMimojiStatusManager().IsInMimojiCreate()) {
            if (z) {
                processingFinish();
            } else {
                return;
            }
        }
        if ((i5 == 174 || i5 == 183) && this.mVideoRecordingStarted) {
            if (z) {
                processingFinish();
            } else {
                return;
            }
        }
        super.provideAnimateElement(i, list, i2);
        if (i == 165) {
            this.mModeSelectLayout.getView().setBackgroundResource(R.color.black);
        }
        this.mModeSelectLayout.clearBottomMenu();
        this.mShutterButton.setParameters(i, list != null, isFPS960());
        Log.d(TAG, "provideAnimateElement: newMode = " + i + ", mCurrentMode = " + this.mCurrentMode + ", animateInElements = " + list);
        if ((!this.mIsShowLighting || !this.mIsShowMiMoji) && this.mModeSelectView.getVisibility() != 0) {
            AlphaInOnSubscribe.directSetResult(this.mModeSelectView);
        }
        this.mModeSelectView.judgePosition(i, list);
        int i7 = -1;
        switch (i) {
            case 163:
            case 165:
                this.mCameraPickEnable = true;
                break;
            case 166:
                if (DataRepository.dataItemFeature().sd()) {
                    this.mCameraPickEnable = true;
                    break;
                } else {
                    this.mCameraPickEnable = false;
                }
            case 167:
            case 180:
                this.mCameraPickEnable = false;
                if (DataRepository.dataItemFeature().qe()) {
                    i4 = 1;
                    i3 = 1;
                    break;
                }
            case 171:
                if (!DataRepository.dataItemFeature().yd()) {
                    this.mCameraPickEnable = false;
                    i3 = -1;
                    i4 = 1;
                    break;
                } else {
                    this.mCameraPickEnable = true;
                    break;
                }
            case 172:
                if (!DataRepository.dataItemFeature().xd()) {
                    this.mCameraPickEnable = false;
                    i3 = -1;
                    i4 = 1;
                    break;
                } else {
                    this.mCameraPickEnable = true;
                    break;
                }
            case 173:
            case 175:
                this.mCameraPickEnable = false;
                i3 = -1;
                i4 = 1;
                break;
            case 176:
                if (!DataRepository.dataItemFeature().Ad()) {
                    this.mCameraPickEnable = false;
                    i3 = -1;
                    i4 = 1;
                    break;
                } else {
                    this.mCameraPickEnable = true;
                    break;
                }
            case 177:
                this.mCameraPickEnable = true;
                break;
            case 182:
                i4 = -1;
                i3 = -1;
                i6 = -1;
                break;
            default:
                this.mCameraPickEnable = true;
                break;
        }
    }

    /* access modifiers changed from: protected */
    public Animation provideEnterAnimation(int i) {
        if (i == 240) {
            return null;
        }
        if (i != 65523) {
            Animation wrapperAnimation = FragmentAnimationFactory.wrapperAnimation(161);
            wrapperAnimation.setStartOffset(150);
            return wrapperAnimation;
        }
        ViewCompat.setTranslationY(getView(), 0.0f);
        Animation wrapperAnimation2 = FragmentAnimationFactory.wrapperAnimation(161);
        wrapperAnimation2.setStartOffset(150);
        return wrapperAnimation2;
    }

    /* access modifiers changed from: protected */
    public Animation provideExitAnimation(int i) {
        if (i == 65523) {
            ViewCompat.setTranslationY(getView(), (float) ((getResources().getDimensionPixelSize(R.dimen.vv_start_layout_height) + getResources().getDimensionPixelSize(R.dimen.vv_list_height)) - getView().getHeight()));
        }
        return FragmentAnimationFactory.wrapperAnimation(162);
    }

    public void provideRotateItem(List<View> list, int i) {
        super.provideRotateItem(list, i);
        list.add(this.mThumbnailImageLayout);
        list.add(this.mShutterButton);
        list.add(this.mCameraPicker);
        list.add(this.mPostProcess);
        list.add(this.mRecordingPause);
        list.add(this.mBottomRecordingCameraPicker);
        list.add(this.mRecordingReverse);
    }

    /* access modifiers changed from: protected */
    public void register(ModeProtocol.ModeCoordinator modeCoordinator) {
        super.register(modeCoordinator);
        modeCoordinator.attachProtocol(179, this);
        modeCoordinator.attachProtocol(162, this);
        modeCoordinator.attachProtocol(183, this);
        modeCoordinator.attachProtocol(197, this);
        registerBackStack(modeCoordinator, this);
    }

    public void setClickEnable(boolean z) {
        super.setClickEnable(z);
        this.mShutterButton.setSnapClickEnable(z);
    }

    public void setLightingViewStatus(boolean z) {
        this.mIsShowLighting = z;
    }

    public void showCameraPicker(boolean z) {
        int i = z ? 1 : -1;
        if (this.mCameraPicker.getTag() == null || ((Integer) this.mCameraPicker.getTag()).intValue() != i) {
            this.mCameraPicker.setTag(Integer.valueOf(i));
            animateViews(i, (List<Completable>) null, this.mCameraPicker);
        }
    }

    public void showOrHideBottomViewWithAnim(boolean z) {
        float f2 = 1.0f;
        ViewCompat.animate(this.mModeSelectLayout.getView()).setInterpolator(new CubicEaseInInterpolator()).setDuration(300).alpha(z ? 1.0f : 0.0f).setListener((ViewPropertyAnimatorListener) null).start();
        ViewCompat.animate(this.mThumbnailImage).setInterpolator(new CubicEaseInInterpolator()).setDuration(300).alpha(z ? 1.0f : 0.0f).setListener((ViewPropertyAnimatorListener) null).start();
        ViewPropertyAnimatorCompat duration = ViewCompat.animate(this.mCameraPicker).setInterpolator(new CubicEaseInInterpolator()).setDuration(300);
        if (!z) {
            f2 = 0.0f;
        }
        duration.alpha(f2).setListener((ViewPropertyAnimatorListener) null).start();
    }

    public boolean showOrHideFilterView() {
        return false;
    }

    public boolean showOrHideLightingView() {
        if (this.mIsShowLighting) {
            startBottomAnimation(false);
            startExtraLayoutAnimation(this.mFragmentLayoutExtra, false);
        } else {
            if (this.mFragmentActionLighting == null) {
                this.mFragmentActionLighting = new FragmentActionLighting();
            }
            if (!this.mFragmentActionLighting.isAdded()) {
                FragmentManager childFragmentManager = getChildFragmentManager();
                FragmentActionLighting fragmentActionLighting = this.mFragmentActionLighting;
                FragmentUtils.addFragmentWithTag(childFragmentManager, (int) R.id.fragment_bottom_extra, (Fragment) fragmentActionLighting, fragmentActionLighting.getFragmentTag());
            } else {
                this.mFragmentActionLighting.reInit();
            }
            startBottomAnimation(true);
            startExtraLayoutAnimation(this.mFragmentLayoutExtra, true);
        }
        this.mIsShowLighting = !this.mIsShowLighting;
        return this.mIsShowLighting;
    }

    public void showOrHideLoadingProgress(boolean z) {
        if (z) {
            this.mShutterButton.hideRoundPaintItem();
        } else {
            this.mShutterButton.showRoundPaintItem();
        }
        setProgressBarVisible(z ? 0 : 8);
    }

    public boolean showOrHideMiMojiView() {
        if (this.mIsShowMiMoji) {
            AlphaInOnSubscribe.directSetResult(this.mModeSelectView);
            startExtraLayoutAnimation(this.mFragmentLayoutExtra, false);
        } else {
            if (this.mFragmentActionMimoji == null) {
                this.mFragmentActionMimoji = new FragmentActionMimoji();
            }
            if (!this.mFragmentActionMimoji.isAdded()) {
                FragmentManager childFragmentManager = getChildFragmentManager();
                FragmentActionMimoji fragmentActionMimoji = this.mFragmentActionMimoji;
                FragmentUtils.addFragmentWithTag(childFragmentManager, (int) R.id.fragment_bottom_extra, (Fragment) fragmentActionMimoji, fragmentActionMimoji.getFragmentTag());
            } else {
                this.mFragmentActionMimoji.reInit();
            }
            Completable.create(new AlphaOutOnSubscribe(this.mModeSelectView)).subscribe();
            startExtraLayoutAnimation(this.mFragmentLayoutExtra, true);
        }
        this.mIsShowMiMoji = !this.mIsShowMiMoji;
        return this.mIsShowMiMoji;
    }

    public void showOrHideMimojiProgress(boolean z) {
        if (z) {
            this.mShutterButton.hideRoundPaintItem();
        } else {
            this.mShutterButton.showRoundPaintItem();
        }
        int i = 0;
        BottomAnimationConfig configVariables = BottomAnimationConfig.generate(true, this.mCurrentMode, false, isFPS960(), CameraSettings.isVideoBokehOn()).configVariables();
        configVariables.mIsInMimojiCreate = true;
        this.mShutterButton.triggerAnimation(configVariables);
        if (!z) {
            i = 8;
        }
        setProgressBarVisible(i);
    }

    /* access modifiers changed from: protected */
    public void unRegister(ModeProtocol.ModeCoordinator modeCoordinator) {
        super.unRegister(modeCoordinator);
        this.mHandler.removeCallbacksAndMessages((Object) null);
        modeCoordinator.detachProtocol(179, this);
        modeCoordinator.detachProtocol(162, this);
        modeCoordinator.detachProtocol(183, this);
        modeCoordinator.detachProtocol(197, this);
        unRegisterBackStack(modeCoordinator, this);
    }

    public void updateLoading(boolean z) {
        if (z) {
            this.mInLoading = false;
            this.mHandler.removeCallbacksAndMessages((Object) null);
            this.mThumbnailProgress.setVisibility(8);
        } else if (!Util.isSaveToHidenFolder(this.mCurrentMode) && !this.mIsIntentAction) {
            this.mInLoading = true;
            int i = this.mCurrentMode;
            if (i == 161 || i == 162 || i == 166 || i == 172 || i == 174 || i == 176 || i == 183) {
                this.mHandler.sendEmptyMessageDelayed(1, (long) this.mRecordProgressDelay);
            } else {
                this.mHandler.sendEmptyMessageDelayed(1, (long) this.mCaptureProgressDelay);
            }
        }
    }

    public void updateRecordingTime(String str) {
        this.mBottomRecordingTime.setText(str);
    }

    public void updateThumbnail(Thumbnail thumbnail, boolean z, int i) {
        if (isAdded()) {
            ActivityBase activityBase = (ActivityBase) getContext();
            if (!DataRepository.dataItemGlobal().getStartFromKeyguard() || i == activityBase.hashCode()) {
                ThumbnailUpdater thumbnailUpdater = activityBase.getThumbnailUpdater();
                if (!(thumbnailUpdater == null || thumbnailUpdater.getThumbnail() == thumbnail)) {
                    thumbnailUpdater.setThumbnail(thumbnail, false, false);
                    Log.d(TAG, "inconsistent thumbnail");
                }
                this.mHandler.removeCallbacksAndMessages((Object) null);
                this.mInLoading = false;
                if (this.mThumbnailProgress.getVisibility() != 8) {
                    this.mThumbnailProgress.setVisibility(8);
                }
                if (!this.mIsIntentAction) {
                    if (thumbnail == null) {
                        this.mThumbnailImage.setImageResource(R.drawable.ic_thumbnail_background);
                        return;
                    }
                    RoundedBitmapDrawable create = RoundedBitmapDrawableFactory.create(getResources(), thumbnail.getBitmap());
                    create.getPaint().setAntiAlias(true);
                    create.setCircular(true);
                    this.mThumbnailImage.setImageDrawable(create);
                    if (z && !this.mVideoRecordingStarted) {
                        ViewCompat.setAlpha(this.mThumbnailImageLayout, 0.3f);
                        ViewCompat.setScaleX(this.mThumbnailImageLayout, 0.5f);
                        ViewCompat.setScaleY(this.mThumbnailImageLayout, 0.5f);
                        ViewCompat.animate(this.mThumbnailImageLayout).alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(80).start();
                    }
                }
            }
        }
    }
}
