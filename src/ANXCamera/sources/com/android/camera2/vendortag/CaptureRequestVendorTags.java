package com.android.camera2.vendortag;

import android.graphics.Rect;
import android.hardware.camera2.CaptureRequest;
import android.util.Log;
import com.android.camera2.vendortag.struct.MarshalQueryableASDScene;
import com.mi.config.b;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.function.Supplier;

public class CaptureRequestVendorTags {
    public static final VendorTag<CaptureRequest.Key<Boolean>> AI_SCENE = create(C0056db.INSTANCE, Boolean.class);
    public static final VendorTag<CaptureRequest.Key<Integer>> AI_SCENE_APPLY = create(La.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<Integer>> AI_SCENE_PERIOD = create(Ea.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<Boolean>> ALGO_UP_ENABLED = create(Hb.INSTANCE, Boolean.class);
    public static final VendorTag<CaptureRequest.Key<Byte>> ASD_DIRTY_ENABLE = create(Da.INSTANCE, Byte.class);
    public static final VendorTag<CaptureRequest.Key<Boolean>> ASD_ENABLE = create(Fb.INSTANCE, Boolean.class);
    public static final VendorTag<CaptureRequest.Key<Integer>> AUTOZOOM_APPLY_IN_PREVIEW = create(C0105pb.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<float[]>> AUTOZOOM_CENTER_OFFSET = create(C0131wa.INSTANCE, float[].class);
    public static final VendorTag<CaptureRequest.Key<Integer>> AUTOZOOM_FORCE_LOCK = create(C0119ta.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<Float>> AUTOZOOM_MINIMUM_SCALING = create(Fa.INSTANCE, Float.class);
    public static final VendorTag<CaptureRequest.Key<Integer>> AUTOZOOM_MODE = create(Jb.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<Float>> AUTOZOOM_SCALE_OFFSET = create(T.INSTANCE, Float.class);
    public static final VendorTag<CaptureRequest.Key<Integer>> AUTOZOOM_SELECT = create(C0109qb.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<float[]>> AUTOZOOM_START = create(C0064fa.INSTANCE, float[].class);
    public static final VendorTag<CaptureRequest.Key<Integer>> AUTOZOOM_STOP = create(N.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<Integer>> AUTOZOOM_UNSELECT = create(C0123ua.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<Byte>> BACKWARD_CAPTURE_HINT = create(Aa.INSTANCE, Byte.class);
    public static final VendorTag<CaptureRequest.Key<Byte>> BACK_SOFT_LIGHT = create(C0055da.INSTANCE, Byte.class);
    public static final VendorTag<CaptureRequest.Key<Integer>> BEAUTY_BLUSHER = create(C0076ia.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<Integer>> BEAUTY_BODY_SLIM = create(X.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<Integer>> BEAUTY_CHIN = create(Sa.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<Integer>> BEAUTY_ENLARGE_EYE = create(C0045ba.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<Integer>> BEAUTY_EYEBROW_DYE = create(C0132wb.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<Integer>> BEAUTY_HAIRLINE = create(Zb.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<Integer>> BEAUTY_HEAD_SLIM = create(C0080ja.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<Integer>> BEAUTY_JELLY_LIPS = create(Za.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<Integer>> BEAUTY_LEG_SLIM = create(C0127va.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<String>> BEAUTY_LEVEL = create(C0069gb.INSTANCE, String.class);
    public static final VendorTag<CaptureRequest.Key<Integer>> BEAUTY_LIPS = create(C0089lb.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<Integer>> BEAUTY_NECK = create(Oa.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<Integer>> BEAUTY_NOSE = create(Ka.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<Integer>> BEAUTY_PUPIL_LINE = create(Yb.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<Integer>> BEAUTY_RISORIUS = create(Gb.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<Integer>> BEAUTY_SHOULDER_SLIM = create(U.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<Integer>> BEAUTY_SKIN_COLOR = create(C0104pa.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<Integer>> BEAUTY_SKIN_SMOOTH = create(C0116sb.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<Integer>> BEAUTY_SLIM_FACE = create(C0085kb.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<Integer>> BEAUTY_SLIM_NOSE = create(C0084ka.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<Integer>> BEAUTY_SMILE = create(Na.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<String>> BOKEH_F_NUMBER = create(W.INSTANCE, String.class);
    public static final VendorTag<CaptureRequest.Key<Integer>> BURST_CAPTURE_HINT = create(C0041ab.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<Integer>> BURST_SHOOT_FPS = create(Vb.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<Integer>> BUTT_SLIM = create(Xb.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<Byte>> CAMERA_AI_30 = create(M.INSTANCE, Byte.class);
    public static final VendorTag<CaptureRequest.Key<Byte>> CINEMATIC_PHOTO_ENABLED = create(Ua.INSTANCE, Byte.class);
    public static final VendorTag<CaptureRequest.Key<Byte>> CINEMATIC_VIDEO_ENABLED = create(Ab.INSTANCE, Byte.class);
    public static final VendorTag<CaptureRequest.Key<Integer>> CONTRAST_LEVEL = create(Pb.INSTANCE, Integer.class);
    public static VendorTag<CaptureRequest.Key<Integer>> CONTROL_AI_SCENE_MODE = create(C0092ma.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<byte[]>> CONTROL_DISTORTION_FPC_DATA = create(C0124ub.INSTANCE, byte[].class);
    public static final VendorTag<CaptureRequest.Key<Boolean>> CONTROL_ENABLE_REMOSAIC = create(C0042ac.INSTANCE, Boolean.class);
    public static final VendorTag<CaptureRequest.Key<int[]>> CONTROL_QUICK_PREVIEW = create(Wb.INSTANCE, int[].class);
    public static final int[] CONTROL_QUICK_PREVIEW_OFF = {0};
    public static final int[] CONTROL_QUICK_PREVIEW_ON = {1};
    public static final VendorTag<CaptureRequest.Key<int[]>> CONTROL_REMOSAIC_HINT = create(Ja.INSTANCE, int[].class);
    public static final int[] CONTROL_REMOSAIC_HINT_OFF = {0};
    public static final int[] CONTROL_REMOSAIC_HINT_ON = {1};
    public static final VendorTag<CaptureRequest.Key<String>> CUSTOM_WATERMARK_TEXT = create(Va.INSTANCE, String.class);
    public static final VendorTag<CaptureRequest.Key<Boolean>> DEFLICKER_ENABLED = create(Ib.INSTANCE, Boolean.class);
    public static final VendorTag<CaptureRequest.Key<Byte>> DEPURPLE = create(Ga.INSTANCE, Byte.class);
    public static final VendorTag<CaptureRequest.Key<Integer>> DEVICE_ORIENTATION = create(C0077ib.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<Integer>> EXPOSURE_METERING = create(Ub.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<Integer>> EYE_LIGHT_STRENGTH = create(Pa.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<Integer>> EYE_LIGHT_TYPE = create(Nb.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<Boolean>> FACE_AGE_ANALYZE_ENABLED = create(Tb.INSTANCE, Boolean.class);
    public static final VendorTag<CaptureRequest.Key<Boolean>> FACE_SCORE_ENABLED = create(C0115sa.INSTANCE, Boolean.class);
    public static final VendorTag<CaptureRequest.Key<Boolean>> FLAW_DETECT_ENABLE = create(Cb.INSTANCE, Boolean.class);
    public static final VendorTag<CaptureRequest.Key<Boolean>> FRONT_MIRROR = create(C0060ea.INSTANCE, Boolean.class);
    public static final VendorTag<CaptureRequest.Key<Boolean>> FRONT_SINGLE_CAMERA_BOKEH = create(C0072ha.INSTANCE, Boolean.class);
    public static final VendorTag<CaptureRequest.Key<Byte>> HDR_BRACKET_MODE = create(C0112rb.INSTANCE, Byte.class);
    public static final VendorTag<CaptureRequest.Key<Integer>> HDR_CHECKER_ADRC = create(Ob.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<Boolean>> HDR_CHECKER_ENABLE = create(C0144zb.INSTANCE, Boolean.class);
    public static final VendorTag<CaptureRequest.Key<Integer>> HDR_CHECKER_SCENETYPE = create(V.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<Integer>> HDR_CHECKER_STATUS = create(Xa.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<Boolean>> HDR_ENABLED = create(Eb.INSTANCE, Boolean.class);
    public static final VendorTag<CaptureRequest.Key<Integer>> HFPSVR_MODE = create(Qa.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<Boolean>> HHT_ENABLED = create(C0108qa.INSTANCE, Boolean.class);
    public static final VendorTag<CaptureRequest.Key<Boolean>> HINT_FOR_RAW_REPROCESS = create(C0046bb.INSTANCE, Boolean.class);
    public static final VendorTag<CaptureRequest.Key<Long>> ISO_EXP = create(Bb.INSTANCE, Long.class);
    public static final VendorTag<CaptureRequest.Key<Byte>> IS_HFR_PREVIEW = create(Sb.INSTANCE, Byte.class);
    public static final VendorTag<CaptureRequest.Key<Boolean>> LENS_DIRTY_DETECT = create(C0111ra.INSTANCE, Boolean.class);
    public static final VendorTag<CaptureRequest.Key<Byte>> MACRO_MODE = create(Kb.INSTANCE, Byte.class);
    public static final VendorTag<CaptureRequest.Key<Boolean>> MFNR_ENABLED = create(C0139ya.INSTANCE, Boolean.class);
    public static final VendorTag<CaptureRequest.Key<int[]>> MTK_CONFIGURE_SETTING_PROPRIETARY = create(Rb.INSTANCE, int[].class);
    public static final int[] MTK_CONFIGURE_SETTING_PROPRIETARY_OFF = {0};
    public static final int[] MTK_CONFIGURE_SETTING_PROPRIETARY_ON = {1};
    public static final VendorTag<CaptureRequest.Key<Byte>> MTK_EXPOSURE_METERING_MODE = create(C0088la.INSTANCE, Byte.class);
    public static final byte MTK_EXPOSURE_METERING_MODE_AVERAGE = 2;
    public static final byte MTK_EXPOSURE_METERING_MODE_CENTER_WEIGHT = 0;
    public static final byte MTK_EXPOSURE_METERING_MODE_SOPT = 1;
    public static final VendorTag<CaptureRequest.Key<Integer>> MULTIFRAME_INPUTNUM = create(Ca.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<Byte>> NORMAL_WIDE_LENS_DISTORTION_CORRECTION_LEVEL = create(_b.INSTANCE, Byte.class);
    public static final VendorTag<CaptureRequest.Key<MarshalQueryableASDScene.ASDScene[]>> ON_TRIPOD_MODE = create(C0050ca.INSTANCE, MarshalQueryableASDScene.ASDScene[].class);
    public static final VendorTag<CaptureRequest.Key<Boolean>> PARALLEL_ENABLED = create(C0100oa.INSTANCE, Boolean.class);
    public static final VendorTag<CaptureRequest.Key<byte[]>> PARALLEL_PATH = create(P.INSTANCE, byte[].class);
    public static final VendorTag<CaptureRequest.Key<Integer>> PORTRAIT_LIGHTING = create(C0135xa.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<Rect>> POST_PROCESS_CROP_REGION = create(C0128vb.INSTANCE, Rect.class);
    public static final VendorTag<CaptureRequest.Key<Byte>> PRO_VIDEO_LOG_ENABLED = create(L.INSTANCE, Byte.class);
    public static final VendorTag<CaptureRequest.Key<Boolean>> REAR_BOKEH_ENABLE = create(Wa.INSTANCE, Boolean.class);
    public static final VendorTag<CaptureRequest.Key<Byte>> RECORDING_END_STREAM = create(C0097nb.INSTANCE, Byte.class);
    public static final VendorTag<CaptureRequest.Key<Integer>> SANPSHOT_FLIP_MODE = create(C0073hb.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<Integer>> SATURATION = create(Ia.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<Boolean>> SAT_FALLBACK_ENABLE = create(C0065fb.INSTANCE, Boolean.class);
    public static final VendorTag<CaptureRequest.Key<Boolean>> SAT_IS_ZOOMING = create(Ya.INSTANCE, Boolean.class);
    public static final VendorTag<CaptureRequest.Key<Byte>> SCREEN_LIGHT_HINT = create(Ma.INSTANCE, Byte.class);
    public static final VendorTag<CaptureRequest.Key<Integer>> SELECT_PRIORITY = create(Ba.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<Integer>> SHARPNESS_CONTROL = create(Qb.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<Integer>> SHRINK_MEMORY_MODE = create(C0081jb.INSTANCE, Integer.class);
    public static final int SHRINK_MEMORY_MODE_ALL = 2;
    public static final int SHRINK_MEMORY_MODE_INACTIVE = 1;
    public static final int SHRINK_MEMORY_MODE_NONE = 0;
    public static final VendorTag<CaptureRequest.Key<int[]>> SMVR_MODE = create(C0040aa.INSTANCE, int[].class);
    public static final VendorTag<CaptureRequest.Key<Boolean>> SNAP_SHOT_TORCH = create(S.INSTANCE, Boolean.class);
    public static final VendorTag<CaptureRequest.Key<Boolean>> ST_ENABLED = create(Y.INSTANCE, Boolean.class);
    public static final VendorTag<CaptureRequest.Key<Boolean>> ST_FAST_ZOOM_IN = create(Db.INSTANCE, Boolean.class);
    public static final VendorTag<CaptureRequest.Key<Boolean>> SUPER_NIGHT_SCENE_ENABLED = create(Ta.INSTANCE, Boolean.class);
    public static final VendorTag<CaptureRequest.Key<Boolean>> SUPER_RESOLUTION_ENABLED = create(_a.INSTANCE, Boolean.class);
    public static final VendorTag<CaptureRequest.Key<Boolean>> SW_MFNR_ENABLED = create(Ra.INSTANCE, Boolean.class);
    private static final String TAG = "CaptureRequestVendorTags";
    public static final VendorTag<CaptureRequest.Key<Integer>> THERMAL_LEVEL = create(O.INSTANCE, Integer.class);
    public static VendorTag<CaptureRequest.Key<Boolean>> ULTRA_PIXEL_PORTRAIT_ENABLED = create(Lb.INSTANCE, Boolean.class);
    public static final VendorTag<CaptureRequest.Key<Byte>> ULTRA_WIDE_LENS_DISTORTION_CORRECTION_LEVEL = create(C0093mb.INSTANCE, Byte.class);
    public static final VendorTag<CaptureRequest.Key<Integer>> USE_CUSTOM_WB = create(C0068ga.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<Integer>> USE_ISO_VALUE = create(C0140yb.INSTANCE, Integer.class);
    public static final int VALUE_HFPSVR_MODE_OFF = 0;
    public static final int VALUE_HFPSVR_MODE_ON = 1;
    public static final int VALUE_SANPSHOT_FLIP_MODE_OFF = 0;
    public static final int VALUE_SANPSHOT_FLIP_MODE_ON = 1;
    public static final int VALUE_SELECT_PRIORITY_EXP_TIME_PRIORITY = 1;
    public static final int VALUE_SELECT_PRIORITY_ISO_PRIORITY = 0;
    public static final int[] VALUE_SMVR_MODE_120FPS = {120, 4};
    public static final int[] VALUE_SMVR_MODE_240FPS = {240, 8};
    public static final int VALUE_VIDEO_RECORD_CONTROL_PREPARE = 0;
    public static final int VALUE_VIDEO_RECORD_CONTROL_START = 1;
    public static final int VALUE_VIDEO_RECORD_CONTROL_STOP = 2;
    public static final byte VALUE_ZSL_CAPTURE_MODE_OFF = 0;
    public static final byte VALUE_ZSL_CAPTURE_MODE_ON = 1;
    public static final VendorTag<CaptureRequest.Key<Integer>> VIDEO_BOKEH_BACK_LEVEL = create(C0120tb.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<Float>> VIDEO_BOKEH_FRONT_LEVEL = create(C0101ob.INSTANCE, Float.class);
    public static final VendorTag<CaptureRequest.Key<Boolean>> VIDEO_FILTER_COLOR_RETENTION_BACK = create(Mb.INSTANCE, Boolean.class);
    public static final VendorTag<CaptureRequest.Key<Boolean>> VIDEO_FILTER_COLOR_RETENTION_FRONT = create(C0061eb.INSTANCE, Boolean.class);
    public static final VendorTag<CaptureRequest.Key<Integer>> VIDEO_FILTER_ID = create(C0047bc.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<Integer>> VIDEO_RECORD_CONTROL = create(Z.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<String>> WATERMARK_APPLIEDTYPE = create(C0143za.INSTANCE, String.class);
    public static final VendorTag<CaptureRequest.Key<String>> WATERMARK_AVAILABLETYPE = create(C0136xb.INSTANCE, String.class);
    public static final VendorTag<CaptureRequest.Key<String>> WATERMARK_FACE = create(Ha.INSTANCE, String.class);
    public static final VendorTag<CaptureRequest.Key<String>> WATERMARK_TIME = create(C0096na.INSTANCE, String.class);
    public static final VendorTag<CaptureRequest.Key<Integer>> WHOLE_BODY_SLIM = create(Q.INSTANCE, Integer.class);
    public static final VendorTag<CaptureRequest.Key<Byte>> ZSL_CAPTURE_MODE = create(C0051cb.INSTANCE, Byte.class);
    private static Constructor<CaptureRequest.Key> requestConstructor;

    static /* synthetic */ String Af() {
        return "xiaomi.superResolution.enabled";
    }

    static /* synthetic */ String Ag() {
        return "xiaomi.beauty.enlargeEyeRatio";
    }

    static /* synthetic */ String Ah() {
        return "xiaomi.MacroMode.enabled";
    }

    static /* synthetic */ String Bf() {
        return "xiaomi.mfnr.enabled";
    }

    static /* synthetic */ String Bg() {
        return "xiaomi.beauty.noseRatio";
    }

    static /* synthetic */ String Bh() {
        return "xiaomi.watermark.custom";
    }

    static /* synthetic */ String Cf() {
        return "xiaomi.swmf.enabled";
    }

    static /* synthetic */ String Cg() {
        return "xiaomi.beauty.risoriusRatio";
    }

    static /* synthetic */ String Df() {
        return "xiaomi.bokeh.enabled";
    }

    static /* synthetic */ String Dg() {
        return "xiaomi.beauty.lipsRatio";
    }

    static /* synthetic */ String Ef() {
        return "xiaomi.bokehrear.enabled";
    }

    static /* synthetic */ String Eg() {
        return "xiaomi.beauty.chinRatio";
    }

    static /* synthetic */ String Ff() {
        return "xiaomi.bokeh.fNumberApplied";
    }

    static /* synthetic */ String Fg() {
        return "xiaomi.beauty.neckRatio";
    }

    static /* synthetic */ String Gf() {
        return "xiaomi.videoBokehParam.back";
    }

    static /* synthetic */ String Gg() {
        return "xiaomi.beauty.smileRatio";
    }

    static /* synthetic */ String Hf() {
        return "xiaomi.videoBokehParam.front";
    }

    static /* synthetic */ String Hg() {
        return "xiaomi.beauty.slimNoseRatio";
    }

    static /* synthetic */ String If() {
        return "com.vidhance.autozoom.stop";
    }

    static /* synthetic */ String Ig() {
        return "xiaomi.beauty.hairlineRatio";
    }

    static /* synthetic */ String Jf() {
        return "xiaomi.videofilter.filterApplied";
    }

    static /* synthetic */ String Jg() {
        return "xiaomi.watermark.availableType";
    }

    static /* synthetic */ String Kf() {
        return "xiaomi.colorRetention.enable";
    }

    static /* synthetic */ String Kg() {
        return "xiaomi.watermark.typeApplied";
    }

    static /* synthetic */ String Lf() {
        return "xiaomi.colorRetention.frontEnable";
    }

    static /* synthetic */ String Lg() {
        return "xiaomi.watermark.time";
    }

    static /* synthetic */ String Mf() {
        return "xiaomi.smoothTransition.enabled";
    }

    static /* synthetic */ String Mg() {
        return "xiaomi.watermark.face";
    }

    static /* synthetic */ String Nf() {
        return "xiaomi.smoothTransition.fallback";
    }

    static /* synthetic */ String Ng() {
        return "xiaomi.snapshotTorch.enabled";
    }

    static /* synthetic */ String Of() {
        return "xiaomi.smoothTransition.fastZoomIn";
    }

    static /* synthetic */ String Og() {
        return "xiaomi.flip.enabled";
    }

    static /* synthetic */ String Pf() {
        return "xiaomi.ai.add.enabled";
    }

    static /* synthetic */ String Pg() {
        return "xiaomi.burst.captureHint";
    }

    static /* synthetic */ String Qf() {
        return "com.vidhance.autozoom.start_region";
    }

    static /* synthetic */ String Qg() {
        return "xiaomi.burst.shootFPS";
    }

    static /* synthetic */ String Rf() {
        return "com.vidhance.autozoom.select";
    }

    static /* synthetic */ String Rg() {
        return "xiaomi.beauty.eyeBrowDyeRatio";
    }

    static /* synthetic */ String Sf() {
        return "com.vidhance.autozoom.unselect";
    }

    static /* synthetic */ String Sg() {
        return "xiaomi.beauty.pupilLineRatio";
    }

    static /* synthetic */ String Tf() {
        return "com.vidhance.autozoom.force_lock";
    }

    static /* synthetic */ String Tg() {
        return "xiaomi.beauty.lipGlossRatio";
    }

    static /* synthetic */ String Uf() {
        return "com.vidhance.autozoom.center_offset";
    }

    static /* synthetic */ String Ug() {
        return "xiaomi.beauty.blushRatio";
    }

    static /* synthetic */ String Vf() {
        return "com.vidhance.autozoom.scale_offset";
    }

    static /* synthetic */ String Vg() {
        return "xiaomi.beauty.eyeLightType";
    }

    static /* synthetic */ String Wf() {
        return "xiaomi.satIsZooming.satIsZooming";
    }

    static /* synthetic */ String Wg() {
        return "xiaomi.beauty.eyeLightStrength";
    }

    static /* synthetic */ String Xf() {
        return "com.mediatek.streamingfeature.hfpsMode";
    }

    static /* synthetic */ String Xg() {
        return "xiaomi.supernight.enabled";
    }

    static /* synthetic */ String Yf() {
        return "com.mediatek.smvrfeature.smvrMode";
    }

    static /* synthetic */ String Yg() {
        return "xiaomi.mimovie.enabled";
    }

    static /* synthetic */ String Zf() {
        return "com.mediatek.control.capture.zsl.mode";
    }

    static /* synthetic */ String Zg() {
        return "xiaomi.beauty.headSlimRatio";
    }

    static /* synthetic */ String _f() {
        return "com.mediatek.control.capture.flipmode";
    }

    static /* synthetic */ String _g() {
        return "xiaomi.beauty.bodySlimRatio";
    }

    static /* synthetic */ String ag() {
        return "com.mediatek.control.capture.remosaicenable";
    }

    static /* synthetic */ String ah() {
        return "xiaomi.beauty.shoulderSlimRatio";
    }

    static /* synthetic */ String bg() {
        return "xiaomi.remosaic.enabled";
    }

    static /* synthetic */ String bh() {
        return "xiaomi.beauty.legSlimRatio";
    }

    static /* synthetic */ String cg() {
        return "xiaomi.distortion.distortioFpcData";
    }

    private static <T> VendorTag<CaptureRequest.Key<T>> create(final Supplier<String> supplier, final Class<T> cls) {
        return new VendorTag<CaptureRequest.Key<T>>() {
            /* access modifiers changed from: protected */
            public CaptureRequest.Key<T> create() {
                return CaptureRequestVendorTags.requestKey(getName(), cls);
            }

            public String getName() {
                return (String) supplier.get();
            }
        };
    }

    static /* synthetic */ String dg() {
        return "com.mediatek.control.capture.hintForRawReprocess";
    }

    static /* synthetic */ String dh() {
        return "xiaomi.beauty.oneKeySlimRatio";
    }

    static /* synthetic */ String eg() {
        return "xiaomi.superResolution.cropRegionMtk";
    }

    static /* synthetic */ String eh() {
        return "xiaomi.beauty.buttPlumpSlimRatio";
    }

    static /* synthetic */ String fg() {
        return "com.mediatek.3afeature.aeMeteringMode";
    }

    static /* synthetic */ String fh() {
        return "xiaomi.distortion.distortionLevelApplied";
    }

    static /* synthetic */ String gg() {
        return "com.mediatek.configure.setting.initrequest";
    }

    static /* synthetic */ String gh() {
        return "xiaomi.distortion.ultraWideDistortionLevel";
    }

    static /* synthetic */ String hg() {
        return "com.mediatek.configure.setting.proprietaryRequest";
    }

    static /* synthetic */ String hh() {
        return "xiaomi.snapshot.front.ScreenLighting.enabled";
    }

    static /* synthetic */ String ig() {
        return "xiaomi.ai.asd.sceneDetected";
    }

    static /* synthetic */ String ih() {
        return "xiaomi.softlightMode.enabled";
    }

    static /* synthetic */ String jg() {
        return "xiaomi.ai.misd.StateScene";
    }

    static /* synthetic */ String jh() {
        return "xiaomi.snapshot.backwardfetchframe.enabled";
    }

    static /* synthetic */ String kg() {
        return "xiaomi.ai.flaw.enabled";
    }

    static /* synthetic */ String kh() {
        return "org.codeaurora.qcamera3.iso_exp_priority.select_priority";
    }

    static /* synthetic */ String lf() {
        return "com.vidhance.autozoom.mode";
    }

    static /* synthetic */ String lg() {
        return "xiaomi.ai.asd.dirtyEnable";
    }

    static /* synthetic */ String lh() {
        return "org.codeaurora.qcamera3.iso_exp_priority.use_iso_exp_priority";
    }

    static /* synthetic */ String mf() {
        return "com.vidhance.autozoom.applyinpreview";
    }

    static /* synthetic */ String mg() {
        return "xiaomi.pro.video.log.enabled";
    }

    static /* synthetic */ String mh() {
        return "org.codeaurora.qcamera3.iso_exp_priority.use_iso_value";
    }

    static /* synthetic */ String nf() {
        return "xiaomi.video.recordControl";
    }

    static /* synthetic */ String ng() {
        return "xiaomi.thermal.thermalLevel";
    }

    static /* synthetic */ String nh() {
        return b.isMTKPlatform() ? "xiaomi.camera.awb.cct" : "com.qti.stats.awbwrapper.AWBCCT";
    }

    static /* synthetic */ String of() {
        return "xiaomi.hdr.enabled";
    }

    static /* synthetic */ String og() {
        return "xiaomi.pro.video.movie.enabled";
    }

    static /* synthetic */ String oh() {
        return "org.codeaurora.qcamera3.saturation.use_saturation";
    }

    static /* synthetic */ String pf() {
        return "xiaomi.algoup.enabled";
    }

    static /* synthetic */ String pg() {
        return "xiaomi.memory.shrinkMode";
    }

    static /* synthetic */ String ph() {
        return "org.codeaurora.qcamera3.sharpness.strength";
    }

    public static void preload() {
        Log.d(TAG, "preloading...");
    }

    static /* synthetic */ String qf() {
        return "xiaomi.hdr.hdrChecker.enabled";
    }

    static /* synthetic */ String qg() {
        return "xiaomi.asd.enabled";
    }

    static /* synthetic */ String qh() {
        return "org.codeaurora.qcamera3.exposure_metering.exposure_metering_mode";
    }

    static <T> CaptureRequest.Key<T> requestKey(String str, Class<T> cls) {
        try {
            if (requestConstructor == null) {
                requestConstructor = CaptureRequest.Key.class.getConstructor(new Class[]{String.class, cls.getClass()});
                requestConstructor.setAccessible(true);
            }
            return requestConstructor.newInstance(new Object[]{str, cls});
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            Log.d(TAG, "Cannot find/call Key constructor: " + e2.getMessage());
            return null;
        }
    }

    static /* synthetic */ String rf() {
        return "xiaomi.hdr.hdrChecker.status";
    }

    static /* synthetic */ String rg() {
        return "xiaomi.portrait.lighting";
    }

    static /* synthetic */ String rh() {
        return "org.quic.camera.recording.endOfStream";
    }

    static /* synthetic */ String sf() {
        return "xiaomi.hdr.hdrChecker.sceneType";
    }

    static /* synthetic */ String sg() {
        return "xiaomi.ai.segment.enabled";
    }

    static /* synthetic */ String sh() {
        return "xiaomi.ai.asd.enabled";
    }

    static /* synthetic */ String tf() {
        return "xiaomi.hdr.hdrChecker.adrc";
    }

    static /* synthetic */ String tg() {
        return "xiaomi.faceGenderAndAge.enabled";
    }

    static /* synthetic */ String th() {
        return "xiaomi.ai.asd.sceneApplied";
    }

    static /* synthetic */ String uf() {
        return "xiaomi.parallel.path";
    }

    static /* synthetic */ String ug() {
        return "xiaomi.faceScore.enabled";
    }

    static /* synthetic */ String uh() {
        return "xiaomi.ai.asd.period";
    }

    static /* synthetic */ String vf() {
        return "xiaomi.parallel.enabled";
    }

    static /* synthetic */ String vg() {
        return "xiaomi.device.orientation";
    }

    static /* synthetic */ String vh() {
        return "org.codeaurora.qcamera3.contrast.level";
    }

    static /* synthetic */ String wf() {
        return "xiaomi.hht.enabled";
    }

    static /* synthetic */ String wg() {
        return "xiaomi.beauty.beautyLevelApplied";
    }

    static /* synthetic */ String wh() {
        return "xiaomi.hfrPreview.isHFRPreview";
    }

    static /* synthetic */ String xf() {
        return "com.vidhance.autozoom.minimumscaling";
    }

    static /* synthetic */ String xg() {
        return "xiaomi.beauty.skinColorRatio";
    }

    static /* synthetic */ String xh() {
        return "org.codeaurora.qcamera3.ae_bracket.mode";
    }

    static /* synthetic */ String yf() {
        return "xiaomi.node.hfr.deflicker.enabled";
    }

    static /* synthetic */ String yg() {
        return "xiaomi.beauty.slimFaceRatio";
    }

    static /* synthetic */ String yh() {
        return "xiaomi.multiframe.inputNum";
    }

    static /* synthetic */ String zf() {
        return "xiaomi.superportrait.enabled";
    }

    static /* synthetic */ String zg() {
        return "xiaomi.beauty.skinSmoothRatio";
    }

    static /* synthetic */ String zh() {
        return "xiaomi.depurple.enabled";
    }
}
