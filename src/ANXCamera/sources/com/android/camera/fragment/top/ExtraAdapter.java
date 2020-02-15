package com.android.camera.fragment.top;

import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.camera.CameraSettings;
import com.android.camera.R;
import com.android.camera.Util;
import com.android.camera.constant.ColorConstant;
import com.android.camera.data.DataRepository;
import com.android.camera.data.data.config.ComponentConfigBeauty;
import com.android.camera.data.data.config.ComponentConfigRatio;
import com.android.camera.data.data.config.ComponentConfigSlowMotionQuality;
import com.android.camera.data.data.config.ComponentConfigVideoQuality;
import com.android.camera.data.data.config.ComponentRunningMacroMode;
import com.android.camera.data.data.config.ComponentRunningUltraPixel;
import com.android.camera.data.data.config.DataItemConfig;
import com.android.camera.data.data.config.SupportedConfigs;
import com.android.camera.data.data.runing.ComponentRunningAutoZoom;
import com.android.camera.data.data.runing.ComponentRunningDocument;
import com.android.camera.data.data.runing.ComponentRunningDualVideo;
import com.android.camera.data.data.runing.ComponentRunningSubtitle;
import com.android.camera.data.data.runing.ComponentRunningTiltValue;
import com.android.camera.data.data.runing.ComponentRunningTimer;
import com.android.camera.data.data.runing.DataItemRunning;
import com.android.camera.fragment.CommonRecyclerViewHolder;
import com.android.camera.module.ModuleManager;
import com.android.camera.protocol.ModeCoordinatorImpl;
import com.android.camera.protocol.ModeProtocol;
import com.android.camera.ui.ColorImageView;

public class ExtraAdapter extends RecyclerView.Adapter<CommonRecyclerViewHolder> implements View.OnTouchListener {
    private DataItemConfig mDataItemConfig;
    private DataItemRunning mDataItemRunning;
    private int mDegree;
    private int mImageNormalColor;
    private View.OnClickListener mOnClickListener;
    private int mSelectedColor;
    private SupportedConfigs mSupportedConfigs;
    private int mTAG = -1;
    private int mTextNormalColor;
    private int mUnableClickColor;

    public ExtraAdapter(SupportedConfigs supportedConfigs, View.OnClickListener onClickListener) {
        this.mSupportedConfigs = supportedConfigs;
        this.mOnClickListener = onClickListener;
        this.mDataItemRunning = DataRepository.dataItemRunning();
        this.mDataItemConfig = DataRepository.dataItemConfig();
        this.mTextNormalColor = ColorConstant.COLOR_COMMON_NORMAL;
        this.mImageNormalColor = -1315861;
        this.mSelectedColor = -15101209;
        this.mUnableClickColor = 1207959551;
    }

    public int getItemCount() {
        return this.mSupportedConfigs.getLength();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x020a, code lost:
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x020b, code lost:
        r0 = -1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x035b  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0363  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0367  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x036a  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0374  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0381  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0387  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0393  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0308  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x030c  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x031d  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x032c  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x033d  */
    public void onBindViewHolder(final CommonRecyclerViewHolder commonRecyclerViewHolder, int i) {
        boolean z;
        int i2;
        boolean z2;
        int i3;
        int i4;
        boolean isLiveShotOn;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z3;
        boolean z4;
        int i9;
        int valueSelectedDrawable;
        int displayTitleString;
        boolean z5;
        int valueDisplayString;
        int resIcon;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int config = this.mSupportedConfigs.getConfig(i);
        commonRecyclerViewHolder.itemView.setTag(Integer.valueOf(config));
        commonRecyclerViewHolder.itemView.setOnClickListener(this.mOnClickListener);
        int currentMode = DataRepository.dataItemGlobal().getCurrentMode();
        ModeProtocol.BaseDelegate baseDelegate = (ModeProtocol.BaseDelegate) ModeCoordinatorImpl.getInstance().getAttachProtocol(160);
        boolean z6 = false;
        String str = null;
        if (config != 206) {
            if (config == 213) {
                ComponentConfigSlowMotionQuality componentConfigSlowMotionQuality = this.mDataItemConfig.getComponentConfigSlowMotionQuality();
                valueSelectedDrawable = componentConfigSlowMotionQuality.getValueSelectedDrawable(currentMode);
                displayTitleString = componentConfigSlowMotionQuality.getDisplayTitleString();
                z5 = !componentConfigSlowMotionQuality.disableUpdate();
                valueDisplayString = componentConfigSlowMotionQuality.getValueDisplayString(currentMode);
            } else if (config != 216) {
                if (config != 255) {
                    if (config != 225) {
                        if (config == 226) {
                            ComponentRunningTimer componentRunningTimer = this.mDataItemRunning.getComponentRunningTimer();
                            boolean isSwitchOn = componentRunningTimer.isSwitchOn();
                            i7 = componentRunningTimer.getValueSelectedDrawable(160);
                            i13 = componentRunningTimer.getValueDisplayString(160);
                            z4 = isSwitchOn;
                            z = true;
                        } else if (config == 260) {
                            isLiveShotOn = CameraSettings.isProVideoLogOpen(currentMode);
                            i5 = R.drawable.ic_config_video_log_off;
                            i6 = R.string.log_format;
                        } else if (config != 261) {
                            switch (config) {
                                case 208:
                                    commonRecyclerViewHolder.itemView.setOnTouchListener(this);
                                    ComponentConfigVideoQuality componentConfigVideoQuality = this.mDataItemConfig.getComponentConfigVideoQuality();
                                    valueSelectedDrawable = componentConfigVideoQuality.getValueSelectedDrawable(currentMode);
                                    displayTitleString = componentConfigVideoQuality.getDisplayTitleString();
                                    z5 = !componentConfigVideoQuality.disableUpdate();
                                    valueDisplayString = componentConfigVideoQuality.getValueDisplayString(currentMode);
                                    break;
                                case 209:
                                    ComponentRunningUltraPixel componentUltraPixel = DataRepository.dataItemRunning().getComponentUltraPixel();
                                    int menuDrawable = componentUltraPixel.getMenuDrawable();
                                    str = componentUltraPixel.getMenuString();
                                    z2 = CameraSettings.isUltraPixelOn();
                                    i2 = menuDrawable;
                                    i4 = -1;
                                    i3 = -1;
                                    break;
                                case 210:
                                    ComponentConfigRatio componentConfigRatio = this.mDataItemConfig.getComponentConfigRatio();
                                    int valueSelectedDrawable2 = componentConfigRatio.getValueSelectedDrawable(currentMode);
                                    int displayTitleString2 = componentConfigRatio.getDisplayTitleString();
                                    i4 = componentConfigRatio.getValueDisplayString(currentMode);
                                    i3 = displayTitleString2;
                                    z = true;
                                    i2 = valueSelectedDrawable2;
                                    z2 = false;
                                    z6 = true;
                                    break;
                                default:
                                    switch (config) {
                                        case 219:
                                            i14 = R.drawable.ic_config_reference_line;
                                            i3 = R.string.pref_camera_referenceline_title;
                                            z2 = DataRepository.dataItemGlobal().getBoolean("pref_camera_referenceline_key", false);
                                            break;
                                        case 220:
                                            ComponentRunningSubtitle componentRunningSubtitle = DataRepository.dataItemRunning().getComponentRunningSubtitle();
                                            z3 = componentRunningSubtitle.isEnabled(currentMode);
                                            resIcon = componentRunningSubtitle.getResIcon(z3);
                                            i8 = componentRunningSubtitle.getResText();
                                            break;
                                        case 221:
                                            ComponentRunningDocument componentRunningDocument = DataRepository.dataItemRunning().getComponentRunningDocument();
                                            z3 = componentRunningDocument.isEnabled(currentMode);
                                            resIcon = componentRunningDocument.getResIcon(z3);
                                            i8 = componentRunningDocument.getResText();
                                            break;
                                        case 222:
                                            ComponentRunningDualVideo componentRunningDualVideo = DataRepository.dataItemRunning().getmComponentRunningDualVideo();
                                            z3 = componentRunningDualVideo.isEnabled(currentMode);
                                            resIcon = componentRunningDualVideo.getResIcon(z3);
                                            i8 = componentRunningDualVideo.getDisplayTitleString();
                                            break;
                                        default:
                                            switch (config) {
                                                case 228:
                                                    ComponentRunningTiltValue componentRunningTiltValue = this.mDataItemRunning.getComponentRunningTiltValue();
                                                    boolean isSwitchOn2 = this.mDataItemRunning.isSwitchOn("pref_camera_tilt_shift_mode");
                                                    if (isSwitchOn2) {
                                                        z4 = isSwitchOn2;
                                                        i8 = componentRunningTiltValue.getValueDisplayString(160);
                                                        z = true;
                                                        i7 = componentRunningTiltValue.getValueSelectedDrawable(160);
                                                        break;
                                                    } else {
                                                        i13 = R.string.config_name_tilt;
                                                        i7 = R.drawable.ic_config_tilt;
                                                        z = true;
                                                        z4 = isSwitchOn2;
                                                    }
                                                case 229:
                                                    boolean isGradienterOn = CameraSettings.isGradienterOn();
                                                    if ((baseDelegate != null && baseDelegate.getActiveFragment(R.id.bottom_action) == 65523) || !CameraSettings.isAutoZoomEnabled(currentMode)) {
                                                        i3 = R.string.config_name_straighten;
                                                        z2 = isGradienterOn;
                                                        i2 = R.drawable.ic_config_straighten;
                                                        break;
                                                    } else {
                                                        i10 = R.string.config_name_straighten;
                                                        i12 = R.drawable.ic_config_straighten;
                                                        break;
                                                    }
                                                    break;
                                                case 230:
                                                    i14 = R.drawable.ic_config_hht;
                                                    i3 = R.string.config_name_hht;
                                                    z2 = this.mDataItemRunning.isSwitchOn("pref_camera_hand_night_key");
                                                    break;
                                                case 231:
                                                    i14 = R.drawable.ic_config_magic;
                                                    i3 = R.string.config_name_magic;
                                                    z2 = this.mDataItemRunning.isSwitchOn("pref_camera_ubifocus_key");
                                                    break;
                                                default:
                                                    switch (config) {
                                                        case 233:
                                                            i14 = R.drawable.ic_config_fast_motion;
                                                            i3 = R.string.pref_video_speed_fast_title;
                                                            z2 = ModuleManager.isFastMotionModule();
                                                            break;
                                                        case 234:
                                                            i14 = R.drawable.ic_config_scene;
                                                            i3 = R.string.config_name_scene;
                                                            z2 = this.mDataItemRunning.isSwitchOn("pref_camera_scenemode_setting_key");
                                                            break;
                                                        case 235:
                                                            i14 = R.drawable.ic_config_group;
                                                            i3 = R.string.config_name_group;
                                                            z2 = this.mDataItemRunning.isSwitchOn("pref_camera_groupshot_mode_key");
                                                            break;
                                                        case 236:
                                                            i14 = R.drawable.ic_config_magic_mirror;
                                                            i3 = R.string.pref_camera_magic_mirror_title;
                                                            z2 = this.mDataItemRunning.isSwitchOn("pref_camera_magic_mirror_key");
                                                            break;
                                                        case 237:
                                                            i8 = R.string.pref_camera_picture_format_entry_raw;
                                                            z3 = DataRepository.dataItemConfig().getComponentConfigRaw().isSwitchOn(currentMode);
                                                            if (!z3) {
                                                                resIcon = R.drawable.ic_raw_off;
                                                                break;
                                                            } else {
                                                                resIcon = R.drawable.ic_raw_on;
                                                                break;
                                                            }
                                                        case 238:
                                                            i14 = R.drawable.ic_config_gender_age;
                                                            i3 = R.string.pref_camera_show_gender_age_config_title;
                                                            z2 = this.mDataItemRunning.isSwitchOn("pref_camera_show_gender_age_key");
                                                            break;
                                                        case 239:
                                                            ComponentConfigBeauty componentConfigBeauty = this.mDataItemConfig.getComponentConfigBeauty();
                                                            z2 = componentConfigBeauty.isSwitchOn(currentMode);
                                                            i2 = componentConfigBeauty.getValueSelectedDrawable(currentMode);
                                                            i3 = componentConfigBeauty.getValueDisplayString(currentMode);
                                                            break;
                                                        case 240:
                                                            i14 = R.drawable.ic_config_dual_watermark;
                                                            i3 = R.string.pref_camera_device_watermark_title;
                                                            z2 = CameraSettings.isDualCameraWaterMarkOpen();
                                                            break;
                                                        case 241:
                                                            i14 = R.drawable.ic_config_super_resolution;
                                                            i3 = R.string.config_name_super_resolution;
                                                            z2 = this.mDataItemRunning.isSwitchOn("pref_camera_super_resolution_key");
                                                            break;
                                                        case 242:
                                                            if (!Util.isGlobalVersion()) {
                                                                i11 = R.drawable.ic_config_ai_detect_unselected;
                                                                i10 = R.string.pref_ai_detect;
                                                                break;
                                                            } else {
                                                                i11 = R.drawable.ic_config_ai_glens;
                                                                i10 = R.string.pref_google_lens;
                                                                break;
                                                            }
                                                        default:
                                                            switch (config) {
                                                                case 251:
                                                                    isLiveShotOn = CameraSettings.isCinematicAspectRatioEnabled(currentMode);
                                                                    i5 = R.drawable.ic_cinematic_aspect_ratio_menu;
                                                                    i6 = R.string.moive_frame;
                                                                    break;
                                                                case 252:
                                                                    i14 = R.drawable.ic_config_hand_gesture;
                                                                    i3 = R.string.hand_gesture_tip;
                                                                    z2 = this.mDataItemRunning.isSwitchOn("pref_hand_gesture");
                                                                    break;
                                                                case 253:
                                                                    ComponentRunningAutoZoom componentRunningAutoZoom = DataRepository.dataItemRunning().getComponentRunningAutoZoom();
                                                                    z3 = componentRunningAutoZoom.isEnabled(currentMode);
                                                                    resIcon = componentRunningAutoZoom.getResIcon(z3);
                                                                    i8 = componentRunningAutoZoom.getResText();
                                                                    break;
                                                                default:
                                                                    i4 = -1;
                                                                    i3 = -1;
                                                                    z2 = false;
                                                                    i2 = 0;
                                                                    break;
                                                            }
                                                    }
                                            }
                                            break;
                                    }
                            }
                        } else {
                            isLiveShotOn = CameraSettings.isProVideoHistogramOpen(currentMode);
                            i5 = R.drawable.ic_config_histogram_off;
                            i6 = R.string.parameter_histogram_title;
                        }
                        i8 = i13;
                        i4 = -1;
                        TextView textView = (TextView) commonRecyclerViewHolder.getView(R.id.extra_item_text);
                        ColorImageView colorImageView = (ColorImageView) commonRecyclerViewHolder.getView(R.id.extra_item_image);
                        textView.setSelected(true);
                        if (i3 != -1) {
                            textView.setText(i3);
                        } else {
                            textView.setText(str);
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append(textView.getText());
                        if (i4 != -1) {
                            sb.append(commonRecyclerViewHolder.itemView.getResources().getString(i4));
                        }
                        if (z2) {
                            sb.append(commonRecyclerViewHolder.itemView.getResources().getString(R.string.accessibility_open));
                        } else if (!z6) {
                            sb.append(commonRecyclerViewHolder.itemView.getResources().getString(R.string.accessibility_closed));
                        }
                        commonRecyclerViewHolder.itemView.setContentDescription(sb);
                        commonRecyclerViewHolder.itemView.setEnabled(z);
                        int i15 = z ? z2 ? this.mSelectedColor : this.mTextNormalColor : this.mUnableClickColor;
                        int i16 = z2 ? this.mSelectedColor : this.mImageNormalColor;
                        textView.setTextColor(i15);
                        if (i2 == R.drawable.ic_config_4k_30_disable && i2 != R.drawable.ic_config_8k_30_disable && i2 != R.drawable.ic_config_straighten) {
                            colorImageView.setColor(i16);
                        } else if (!z) {
                            colorImageView.setColor(this.mUnableClickColor);
                        } else {
                            colorImageView.setColor(i16);
                        }
                        colorImageView.setImageResource(i2);
                        if ((!Util.isAccessible() || Util.isSetContentDesc()) && this.mTAG == config) {
                            commonRecyclerViewHolder.itemView.postDelayed(new Runnable() {
                                public void run() {
                                    commonRecyclerViewHolder.itemView.sendAccessibilityEvent(128);
                                }
                            }, 100);
                        }
                        return;
                    }
                    i11 = R.drawable.ic_config_extra_setting;
                    i10 = R.string.config_name_setting;
                    i12 = i11;
                    i4 = -1;
                    z2 = false;
                    z = true;
                    TextView textView2 = (TextView) commonRecyclerViewHolder.getView(R.id.extra_item_text);
                    ColorImageView colorImageView2 = (ColorImageView) commonRecyclerViewHolder.getView(R.id.extra_item_image);
                    textView2.setSelected(true);
                    if (i3 != -1) {
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(textView2.getText());
                    if (i4 != -1) {
                    }
                    if (z2) {
                    }
                    commonRecyclerViewHolder.itemView.setContentDescription(sb2);
                    commonRecyclerViewHolder.itemView.setEnabled(z);
                    if (z) {
                    }
                    if (z2) {
                    }
                    textView2.setTextColor(i15);
                    if (i2 == R.drawable.ic_config_4k_30_disable) {
                    }
                    if (!z) {
                    }
                    colorImageView2.setImageResource(i2);
                    if (!Util.isAccessible()) {
                    }
                    commonRecyclerViewHolder.itemView.postDelayed(new Runnable() {
                        public void run() {
                            commonRecyclerViewHolder.itemView.sendAccessibilityEvent(128);
                        }
                    }, 100);
                }
                ComponentRunningMacroMode componentRunningMacroMode = DataRepository.dataItemRunning().getComponentRunningMacroMode();
                z3 = componentRunningMacroMode.isSwitchOn(currentMode);
                resIcon = componentRunningMacroMode.getResIcon(z3);
                i8 = componentRunningMacroMode.getResText();
                i9 = resIcon;
                z = true;
                z4 = z3;
                i4 = -1;
                TextView textView22 = (TextView) commonRecyclerViewHolder.getView(R.id.extra_item_text);
                ColorImageView colorImageView22 = (ColorImageView) commonRecyclerViewHolder.getView(R.id.extra_item_image);
                textView22.setSelected(true);
                if (i3 != -1) {
                }
                StringBuilder sb22 = new StringBuilder();
                sb22.append(textView22.getText());
                if (i4 != -1) {
                }
                if (z2) {
                }
                commonRecyclerViewHolder.itemView.setContentDescription(sb22);
                commonRecyclerViewHolder.itemView.setEnabled(z);
                if (z) {
                }
                if (z2) {
                }
                textView22.setTextColor(i15);
                if (i2 == R.drawable.ic_config_4k_30_disable) {
                }
                if (!z) {
                }
                colorImageView22.setImageResource(i2);
                if (!Util.isAccessible()) {
                }
                commonRecyclerViewHolder.itemView.postDelayed(new Runnable() {
                    public void run() {
                        commonRecyclerViewHolder.itemView.sendAccessibilityEvent(128);
                    }
                }, 100);
            } else {
                isLiveShotOn = baseDelegate != null && baseDelegate.getActiveFragment(R.id.bottom_action) == 65523;
                i5 = R.drawable.ic_config_vv_normal;
                i6 = R.string.vv_mode_menu_item_name;
            }
            i3 = displayTitleString;
            i2 = valueSelectedDrawable;
            z2 = false;
            z6 = true;
            TextView textView222 = (TextView) commonRecyclerViewHolder.getView(R.id.extra_item_text);
            ColorImageView colorImageView222 = (ColorImageView) commonRecyclerViewHolder.getView(R.id.extra_item_image);
            textView222.setSelected(true);
            if (i3 != -1) {
            }
            StringBuilder sb222 = new StringBuilder();
            sb222.append(textView222.getText());
            if (i4 != -1) {
            }
            if (z2) {
            }
            commonRecyclerViewHolder.itemView.setContentDescription(sb222);
            commonRecyclerViewHolder.itemView.setEnabled(z);
            if (z) {
            }
            if (z2) {
            }
            textView222.setTextColor(i15);
            if (i2 == R.drawable.ic_config_4k_30_disable) {
            }
            if (!z) {
            }
            colorImageView222.setImageResource(i2);
            if (!Util.isAccessible()) {
            }
            commonRecyclerViewHolder.itemView.postDelayed(new Runnable() {
                public void run() {
                    commonRecyclerViewHolder.itemView.sendAccessibilityEvent(128);
                }
            }, 100);
        }
        isLiveShotOn = CameraSettings.isLiveShotOn();
        i5 = isLiveShotOn ? R.drawable.ic_motionphoto_highlight_extra : R.drawable.ic_motionphoto_extra;
        i6 = R.string.config_name_livephoto;
        i9 = i5;
        i8 = i6;
        z = true;
        z4 = z3;
        i4 = -1;
        TextView textView2222 = (TextView) commonRecyclerViewHolder.getView(R.id.extra_item_text);
        ColorImageView colorImageView2222 = (ColorImageView) commonRecyclerViewHolder.getView(R.id.extra_item_image);
        textView2222.setSelected(true);
        if (i3 != -1) {
        }
        StringBuilder sb2222 = new StringBuilder();
        sb2222.append(textView2222.getText());
        if (i4 != -1) {
        }
        if (z2) {
        }
        commonRecyclerViewHolder.itemView.setContentDescription(sb2222);
        commonRecyclerViewHolder.itemView.setEnabled(z);
        if (z) {
        }
        if (z2) {
        }
        textView2222.setTextColor(i15);
        if (i2 == R.drawable.ic_config_4k_30_disable) {
        }
        if (!z) {
        }
        colorImageView2222.setImageResource(i2);
        if (!Util.isAccessible()) {
        }
        commonRecyclerViewHolder.itemView.postDelayed(new Runnable() {
            public void run() {
                commonRecyclerViewHolder.itemView.sendAccessibilityEvent(128);
            }
        }, 100);
    }

    public CommonRecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_top_config_extra_item, viewGroup, false);
        int i2 = this.mDegree;
        if (i2 != 0) {
            ViewCompat.setRotation(inflate, (float) i2);
        }
        return new CommonRecyclerViewHolder(inflate);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        View findViewById = view.findViewById(R.id.extra_item_image);
        if (findViewById == null) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 || (action != 2 && action == 3)) {
                findViewById.setScaleX(1.0f);
                findViewById.setScaleY(1.0f);
            }
            return false;
        }
        findViewById.setScaleX(0.93f);
        findViewById.setScaleY(0.93f);
        return false;
    }

    public void setNewDegree(int i) {
        this.mDegree = i;
    }

    public void setOnClictTag(int i) {
        this.mTAG = i;
    }
}
