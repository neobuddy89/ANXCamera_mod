package com.android.camera2.vendortag;

import android.hardware.camera2.CaptureResult;
import android.util.Log;
import com.android.camera2.vendortag.struct.AECFrameControl;
import com.android.camera2.vendortag.struct.AFFrameControl;
import com.android.camera2.vendortag.struct.AWBFrameControl;
import com.android.camera2.vendortag.struct.MarshalQueryableASDScene;
import com.android.camera2.vendortag.struct.MarshalQueryableSuperNightExif;
import com.mi.config.b;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.function.Supplier;

public class CaptureResultVendorTags {
    public static final VendorTag<CaptureResult.Key<AECFrameControl>> AEC_FRAME_CONTROL = create(C0078ic.INSTANCE, AECFrameControl.class);
    public static final VendorTag<CaptureResult.Key<Float>> AEC_LUX = create(C0137xc.INSTANCE, Float.class);
    public static final VendorTag<CaptureResult.Key<AFFrameControl>> AF_FRAME_CONTROL = create(vd.INSTANCE, AFFrameControl.class);
    public static final VendorTag<CaptureResult.Key<Byte>> AI_HDR_DETECTED = create(Pc.INSTANCE, Byte.class);
    public static final VendorTag<CaptureResult.Key<Integer>> AI_SCENE_DETECTED = create(Jc.INSTANCE, Integer.class);
    public static final VendorTag<CaptureResult.Key<Byte>> AI_SCENE_ENABLE = create(Ad.INSTANCE, Byte.class);
    public static final VendorTag<CaptureResult.Key<int[]>> AUTOZOOM_ACTIVE_OBJECTS = create(C0053cd.INSTANCE, int[].class);
    public static final VendorTag<CaptureResult.Key<float[]>> AUTOZOOM_BOUNDS = create(md.INSTANCE, float[].class);
    public static final VendorTag<CaptureResult.Key<float[]>> AUTOZOOM_DELAYED_TARGET_BOUNDS_STABILIZED = create(Hc.INSTANCE, float[].class);
    public static final VendorTag<CaptureResult.Key<float[]>> AUTOZOOM_DELAYED_TARGET_BOUNDS_ZOOMED = create(td.INSTANCE, float[].class);
    public static final VendorTag<CaptureResult.Key<float[]>> AUTOZOOM_OBJECT_BOUNDS_STABILIZED = create(C0052cc.INSTANCE, float[].class);
    public static final VendorTag<CaptureResult.Key<float[]>> AUTOZOOM_OBJECT_BOUNDS_ZOOMED = create(hd.INSTANCE, float[].class);
    public static final VendorTag<CaptureResult.Key<int[]>> AUTOZOOM_PAUSED_OBJECTS = create(ld.INSTANCE, int[].class);
    public static final VendorTag<CaptureResult.Key<int[]>> AUTOZOOM_SELECTED_OBJECTS = create(C0102oc.INSTANCE, int[].class);
    public static final VendorTag<CaptureResult.Key<Integer>> AUTOZOOM_STATUS = create(Cd.INSTANCE, Integer.class);
    public static final VendorTag<CaptureResult.Key<float[]>> AUTOZOOM_TARGET_BOUNDS_STABILIZED = create(C0113rc.INSTANCE, float[].class);
    public static final VendorTag<CaptureResult.Key<float[]>> AUTOZOOM_TARGET_BOUNDS_ZOOMED = create(C0066fc.INSTANCE, float[].class);
    public static final VendorTag<CaptureResult.Key<AWBFrameControl>> AWB_FRAME_CONTROL = create(wd.INSTANCE, AWBFrameControl.class);
    public static final VendorTag<CaptureResult.Key<Integer>> BEAUTY_BLUSHER = create(Oc.INSTANCE, Integer.class);
    public static final VendorTag<CaptureResult.Key<Integer>> BEAUTY_BODY_SLIM = create(Fc.INSTANCE, Integer.class);
    public static final VendorTag<CaptureResult.Key<Integer>> BEAUTY_BODY_SLIM_COUNT = create(C0070gc.INSTANCE, Integer.class);
    public static final VendorTag<CaptureResult.Key<Integer>> BEAUTY_CHIN = create(C0074hc.INSTANCE, Integer.class);
    public static final VendorTag<CaptureResult.Key<Integer>> BEAUTY_ENLARGE_EYE = create(C0043ad.INSTANCE, Integer.class);
    public static final VendorTag<CaptureResult.Key<Integer>> BEAUTY_EYEBROW_DYE = create(Wc.INSTANCE, Integer.class);
    public static final VendorTag<CaptureResult.Key<Integer>> BEAUTY_HAIRLINE = create(Lc.INSTANCE, Integer.class);
    public static final VendorTag<CaptureResult.Key<Integer>> BEAUTY_HEAD_SLIM = create(C0117sc.INSTANCE, Integer.class);
    public static final VendorTag<CaptureResult.Key<Integer>> BEAUTY_JELLY_LIPS = create(Zc.INSTANCE, Integer.class);
    public static final VendorTag<CaptureResult.Key<Integer>> BEAUTY_LEG_SLIM = create(Ac.INSTANCE, Integer.class);
    public static final VendorTag<CaptureResult.Key<String>> BEAUTY_LEVEL = create(_c.INSTANCE, String.class);
    public static final VendorTag<CaptureResult.Key<Integer>> BEAUTY_LIPS = create(Mc.INSTANCE, Integer.class);
    public static final VendorTag<CaptureResult.Key<Integer>> BEAUTY_NECK = create(C0145zc.INSTANCE, Integer.class);
    public static final VendorTag<CaptureResult.Key<Integer>> BEAUTY_NOSE = create(C0110qc.INSTANCE, Integer.class);
    public static final VendorTag<CaptureResult.Key<Integer>> BEAUTY_PUPIL_LINE = create(C0121tc.INSTANCE, Integer.class);
    public static final VendorTag<CaptureResult.Key<Integer>> BEAUTY_RISORIUS = create(C0057dc.INSTANCE, Integer.class);
    public static final VendorTag<CaptureResult.Key<Integer>> BEAUTY_SHOULDER_SLIM = create(gd.INSTANCE, Integer.class);
    public static final VendorTag<CaptureResult.Key<Integer>> BEAUTY_SKIN_COLOR = create(C0082jc.INSTANCE, Integer.class);
    public static final VendorTag<CaptureResult.Key<Integer>> BEAUTY_SKIN_SMOOTH = create(Bc.INSTANCE, Integer.class);
    public static final VendorTag<CaptureResult.Key<Integer>> BEAUTY_SLIM_FACE = create(Ic.INSTANCE, Integer.class);
    public static final VendorTag<CaptureResult.Key<Integer>> BEAUTY_SLIM_NOSE = create(Vc.INSTANCE, Integer.class);
    public static final VendorTag<CaptureResult.Key<Integer>> BEAUTY_SMILE = create(Dd.INSTANCE, Integer.class);
    public static final VendorTag<CaptureResult.Key<Integer>> BUTT_SLIM = create(C0133wc.INSTANCE, Integer.class);
    public static final VendorTag<CaptureResult.Key<Boolean>> CONTROL_ENABLE_REMOSAIC = create(C0090lc.INSTANCE, Boolean.class);
    public static final VendorTag<CaptureResult.Key<Byte>> DEPURPLE = create(C0129vc.INSTANCE, Byte.class);
    public static final VendorTag<CaptureResult.Key<byte[]>> DISTORTION_FPC_DATA = create(Gc.INSTANCE, byte[].class);
    public static VendorTag<CaptureResult.Key<byte[]>> EXIF_INFO_VALUES = create(C0062ec.INSTANCE, byte[].class);
    public static final VendorTag<CaptureResult.Key<Integer>> EYE_LIGHT_STRENGTH = create(od.INSTANCE, Integer.class);
    public static final VendorTag<CaptureResult.Key<Integer>> EYE_LIGHT_TYPE = create(C0094mc.INSTANCE, Integer.class);
    public static final VendorTag<CaptureResult.Key<Byte>> FAST_ZOOM_RESULT = create(Yc.INSTANCE, Byte.class);
    public static final VendorTag<CaptureResult.Key<Boolean>> FRONT_SINGLE_CAMERA_BOKEH = create(pd.INSTANCE, Boolean.class);
    public static final VendorTag<CaptureResult.Key<Integer>> HDR_CHECKER_ADRC = create(C0098nc.INSTANCE, Integer.class);
    public static final VendorTag<CaptureResult.Key<byte[]>> HDR_CHECKER_EV_VALUES = create(Nc.INSTANCE, byte[].class);
    public static final VendorTag<CaptureResult.Key<Integer>> HDR_CHECKER_SCENETYPE = create(kd.INSTANCE, Integer.class);
    public static final VendorTag<CaptureResult.Key<Byte>> HDR_MOTION_DETECTED = create(Tc.INSTANCE, Byte.class);
    public static final VendorTag<CaptureResult.Key<int[]>> HISTOGRAM_STATS = create(ed.INSTANCE, int[].class);
    public static final CaptureResult.Key<Integer> ISO_VALUE = new CaptureResult.Key<>("xiaomi.algoup.iso_value", Integer.TYPE);
    public static final VendorTag<CaptureResult.Key<Boolean>> IS_HDR_ENABLE = create(Ec.INSTANCE, Boolean.class);
    public static final VendorTag<CaptureResult.Key<Integer>> IS_LLS_NEEDED = create(zd.INSTANCE, Integer.class);
    public static final VendorTag<CaptureResult.Key<Boolean>> IS_SR_ENABLE = create(Qc.INSTANCE, Boolean.class);
    public static final VendorTag<CaptureResult.Key<Integer>> LENS_DIRTY_DETECTED = create(yd.INSTANCE, Integer.class);
    public static final VendorTag<CaptureResult.Key<Boolean>> MFNR_ENABLED = create(qd.INSTANCE, Boolean.class);
    public static final VendorTag<CaptureResult.Key<MarshalQueryableASDScene.ASDScene[]>> NON_SEMANTIC_SCENE = create(fd.INSTANCE, MarshalQueryableASDScene.ASDScene[].class);
    public static final VendorTag<CaptureResult.Key<Boolean>> REAR_BOKEH_ENABLE = create(Sc.INSTANCE, Boolean.class);
    public static final VendorTag<CaptureResult.Key<Boolean>> REMOSAIC_DETECTED = create(Dc.INSTANCE, Boolean.class);
    public static final VendorTag<CaptureResult.Key<byte[]>> SAT_DBG_INFO = create(Uc.INSTANCE, byte[].class);
    public static final VendorTag<CaptureResult.Key<Boolean>> SAT_FALLBACK_DETECTED = create(Rc.INSTANCE, Boolean.class);
    public static final VendorTag<CaptureResult.Key<Integer>> SAT_MATER_CAMERA_ID = create(xd.INSTANCE, Integer.class);
    public static final VendorTag<CaptureResult.Key<Integer>> SCENE_DETECTION_RESULT = create(Bd.INSTANCE, Integer.class);
    public static final VendorTag<CaptureResult.Key<MarshalQueryableASDScene.ASDScene[]>> SEMANTIC_SCENE = create(C0125uc.INSTANCE, MarshalQueryableASDScene.ASDScene[].class);
    public static final VendorTag<CaptureResult.Key<Byte>> SENSOR_HDR_ENABLE = create(C0106pc.INSTANCE, Byte.class);
    public static final VendorTag<CaptureResult.Key<MarshalQueryableASDScene.ASDScene[]>> STATE_SCENE = create(Cc.INSTANCE, MarshalQueryableASDScene.ASDScene[].class);
    public static final VendorTag<CaptureResult.Key<float[]>> STATISTICS_FACE_AGE = create(Kc.INSTANCE, float[].class);
    public static final VendorTag<CaptureResult.Key<float[]>> STATISTICS_FACE_FACESCORE = create(C0086kc.INSTANCE, float[].class);
    public static final VendorTag<CaptureResult.Key<float[]>> STATISTICS_FACE_GENDER = create(jd.INSTANCE, float[].class);
    public static final VendorTag<CaptureResult.Key<byte[]>> STATISTICS_FACE_INFO = create(id.INSTANCE, byte[].class);
    public static final VendorTag<CaptureResult.Key<float[]>> STATISTICS_FACE_PROP = create(ud.INSTANCE, float[].class);
    public static final VendorTag<CaptureResult.Key<MarshalQueryableSuperNightExif.SuperNightExif>> SUPER_NIGHT_EXIF = create(nd.INSTANCE, MarshalQueryableSuperNightExif.SuperNightExif.class);
    public static final VendorTag<CaptureResult.Key<Boolean>> SUPER_NIGHT_SCENE_ENABLED = create(C0048bd.INSTANCE, Boolean.class);
    public static final VendorTag<CaptureResult.Key<Boolean>> SW_MFNR_ENABLED = create(sd.INSTANCE, Boolean.class);
    private static final String TAG = "CaptureResultVendorTags";
    public static final VendorTag<CaptureResult.Key<Byte>> ULTRA_WIDE_LENS_DISTORTION_CORRECTION_LEVEL = create(C0141yc.INSTANCE, Byte.class);
    public static final VendorTag<CaptureResult.Key<Integer>> ULTRA_WIDE_RECOMMENDED_RESULT = create(Xc.INSTANCE, Integer.class);
    public static final int VALUE_SAT_MATER_CAMERA_ID_TELE = 3;
    public static final int VALUE_SAT_MATER_CAMERA_ID_ULTRA_WIDE = 1;
    public static final int VALUE_SAT_MATER_CAMERA_ID_WIDE = 2;
    public static final int VALUE_VIDEO_RECORD_STATE_IDLE = 2;
    public static final int VALUE_VIDEO_RECORD_STATE_PROCESS = 1;
    public static final VendorTag<CaptureResult.Key<Integer>> VIDEO_RECORD_STATE = create(rd.INSTANCE, Integer.class);
    public static final VendorTag<CaptureResult.Key<Integer>> WHOLE_BODY_SLIM = create(C0058dd.INSTANCE, Integer.class);
    private static Constructor<CaptureResult.Key> resultConstructor;

    static /* synthetic */ String Af() {
        return "xiaomi.beauty.slimNoseRatio";
    }

    static /* synthetic */ String Ag() {
        return "xiaomi.faceAnalyzeResult.age";
    }

    static /* synthetic */ String Bf() {
        return "xiaomi.beauty.hairlineRatio";
    }

    static /* synthetic */ String Bg() {
        return "xiaomi.faceAnalyzeResult.gender";
    }

    static /* synthetic */ String Cf() {
        return "xiaomi.beauty.eyeBrowDyeRatio";
    }

    static /* synthetic */ String Cg() {
        return "xiaomi.faceAnalyzeResult.score";
    }

    static /* synthetic */ String Df() {
        return "xiaomi.beauty.pupilLineRatio";
    }

    static /* synthetic */ String Dg() {
        return "xiaomi.faceAnalyzeResult.prop";
    }

    static /* synthetic */ String Ef() {
        return "xiaomi.beauty.lipGlossRatio";
    }

    static /* synthetic */ String Eg() {
        return "org.quic.camera2.statsconfigs.AECIsInsensorHDR";
    }

    static /* synthetic */ String Ff() {
        return "xiaomi.beauty.blushRatio";
    }

    static /* synthetic */ String Fg() {
        return "xiaomi.scene.result";
    }

    static /* synthetic */ String Gf() {
        return "xiaomi.beauty.eyeLightType";
    }

    static /* synthetic */ String Gg() {
        return b.isMTKPlatform() ? "com.xiaomi.statsconfigs.AecLux" : "com.qti.chi.statsaec.AecLux";
    }

    static /* synthetic */ String Hf() {
        return "xiaomi.beauty.eyeLightStrength";
    }

    static /* synthetic */ String Hg() {
        return "xiaomi.ai.asd.enabled";
    }

    static /* synthetic */ String If() {
        return "com.vidhance.autozoom.status";
    }

    static /* synthetic */ String Ig() {
        return "xiaomi.ai.asd.sceneDetected";
    }

    static /* synthetic */ String Jf() {
        return "xiaomi.supernight.enabled";
    }

    static /* synthetic */ String Jg() {
        return "xiaomi.hdr.hdrDetected";
    }

    static /* synthetic */ String Kf() {
        return "xiaomi.beauty.headSlimRatio";
    }

    static /* synthetic */ String Kg() {
        return "xiaomi.ai.add.lensDirtyDetected";
    }

    static /* synthetic */ String Lf() {
        return "xiaomi.beauty.bodySlimRatio";
    }

    static /* synthetic */ String Lg() {
        return b.isMTKPlatform() ? "xiaomi.camera.awb.colorTemperature" : "org.quic.camera2.statsconfigs.AWBFrameControl";
    }

    static /* synthetic */ String Mf() {
        return "xiaomi.beauty.shoulderSlimRatio";
    }

    static /* synthetic */ String Mg() {
        return "org.quic.camera2.statsconfigs.AECFrameControl";
    }

    static /* synthetic */ String Nf() {
        return "xiaomi.beauty.legSlimRatio";
    }

    static /* synthetic */ String Ng() {
        return "org.quic.camera2.statsconfigs.AFFrameControl";
    }

    static /* synthetic */ String Of() {
        return "xiaomi.beauty.oneKeySlimRatio";
    }

    static /* synthetic */ String Og() {
        return "org.codeaurora.qcamera3.histogram.stats";
    }

    static /* synthetic */ String Pf() {
        return "xiaomi.beauty.buttPlumpSlimRatio";
    }

    static /* synthetic */ String Pg() {
        return "xiaomi.smoothTransition.result";
    }

    static /* synthetic */ String Qf() {
        return "com.vidhance.autozoom.active_objects";
    }

    static /* synthetic */ String Qg() {
        return "xiaomi.hdr.hdrChecker";
    }

    static /* synthetic */ String Rf() {
        return "com.vidhance.autozoom.selected_objects";
    }

    static /* synthetic */ String Rg() {
        return "xiaomi.hdr.hdrChecker.sceneType";
    }

    static /* synthetic */ String Sf() {
        return "com.vidhance.autozoom.paused_objects";
    }

    static /* synthetic */ String Sg() {
        return "xiaomi.hdr.hdrChecker.adrc";
    }

    static /* synthetic */ String Tf() {
        return "com.vidhance.autozoom.object_bounds_stabilized";
    }

    static /* synthetic */ String Tg() {
        return "xiaomi.debugInfo.info";
    }

    static /* synthetic */ String Uf() {
        return "com.vidhance.autozoom.object_bounds_zoomed";
    }

    static /* synthetic */ String Ug() {
        return "xiaomi.ai.misd.ultraWideRecommended";
    }

    static /* synthetic */ String Vf() {
        return "com.vidhance.autozoom.delayed_target_bounds_stabilized";
    }

    static /* synthetic */ String Vg() {
        return "xiaomi.beauty.bodySlimCnt";
    }

    static /* synthetic */ String Wg() {
        return "xiaomi.superResolution.enabled";
    }

    static /* synthetic */ String Xg() {
        return "xiaomi.hdr.enabled";
    }

    static /* synthetic */ String Yg() {
        return "xiaomi.remosaic.detected";
    }

    static /* synthetic */ String Zg() {
        return "xiaomi.ai.misd.SemanticScene";
    }

    static /* synthetic */ String _g() {
        return "xiaomi.ai.misd.NonSemanticScene";
    }

    static /* synthetic */ String ah() {
        return "xiaomi.ai.misd.StateScene";
    }

    static /* synthetic */ String bh() {
        return "xiaomi.distortion.distortioFpcData";
    }

    private static <T> VendorTag<CaptureResult.Key<T>> create(final Supplier<String> supplier, final Class<T> cls) {
        return new VendorTag<CaptureResult.Key<T>>() {
            /* access modifiers changed from: protected */
            public CaptureResult.Key<T> create() {
                return CaptureResultVendorTags.resultKey(getName(), cls);
            }

            public String getName() {
                return (String) supplier.get();
            }
        };
    }

    static /* synthetic */ String dh() {
        return "xiaomi.smoothTransition.masterCameraId";
    }

    static /* synthetic */ String eh() {
        return "xiaomi.smoothTransition.detected";
    }

    static /* synthetic */ String fh() {
        return "xiaomi.sat.dbg.satDbgInfo";
    }

    static /* synthetic */ String gh() {
        return "xiaomi.ai.misd.hdrmotionDetected";
    }

    static /* synthetic */ String hh() {
        return "xiaomi.ai.misd.SuperNightExif";
    }

    static /* synthetic */ String ih() {
        return "com.qti.stats_control.is_lls_needed";
    }

    static /* synthetic */ String lf() {
        return "com.vidhance.autozoom.bounds";
    }

    static /* synthetic */ String mf() {
        return "com.vidhance.autozoom.target_bounds_stabilized";
    }

    static /* synthetic */ String nf() {
        return "com.vidhance.autozoom.delayed_target_bounds_zoomed";
    }

    static /* synthetic */ String of() {
        return "xiaomi.beauty.beautyLevelApplied";
    }

    static /* synthetic */ String pf() {
        return "xiaomi.beauty.skinColorRatio";
    }

    public static void preload() {
        Log.d(TAG, "preloading...");
    }

    static /* synthetic */ String qf() {
        return "xiaomi.beauty.slimFaceRatio";
    }

    /* access modifiers changed from: private */
    public static <T> CaptureResult.Key<T> resultKey(String str, Class<T> cls) {
        try {
            if (resultConstructor == null) {
                resultConstructor = CaptureResult.Key.class.getConstructor(new Class[]{String.class, cls.getClass()});
                resultConstructor.setAccessible(true);
            }
            return resultConstructor.newInstance(new Object[]{str, cls});
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            Log.d(TAG, "Cannot find/call Key constructor: " + e2.getMessage());
            return null;
        }
    }

    static /* synthetic */ String rf() {
        return "xiaomi.beauty.skinSmoothRatio";
    }

    static /* synthetic */ String rg() {
        return "xiaomi.bokeh.enabled";
    }

    static /* synthetic */ String sf() {
        return "xiaomi.beauty.enlargeEyeRatio";
    }

    static /* synthetic */ String sg() {
        return "xiaomi.remosaic.enabled";
    }

    static /* synthetic */ String tf() {
        return "xiaomi.beauty.noseRatio";
    }

    static /* synthetic */ String tg() {
        return "xiaomi.distortion.ultraWideDistortionLevel";
    }

    static /* synthetic */ String uf() {
        return "xiaomi.beauty.risoriusRatio";
    }

    static /* synthetic */ String ug() {
        return "xiaomi.depurple.enabled";
    }

    static /* synthetic */ String vf() {
        return "xiaomi.beauty.lipsRatio";
    }

    static /* synthetic */ String vg() {
        return "xiaomi.bokehrear.enabled";
    }

    static /* synthetic */ String wf() {
        return "xiaomi.beauty.chinRatio";
    }

    static /* synthetic */ String wg() {
        return "xiaomi.mfnr.enabled";
    }

    static /* synthetic */ String xf() {
        return "com.vidhance.autozoom.target_bounds_zoomed";
    }

    static /* synthetic */ String xg() {
        return "xiaomi.swmf.enabled";
    }

    static /* synthetic */ String yf() {
        return "xiaomi.beauty.neckRatio";
    }

    static /* synthetic */ String yg() {
        return "xiaomi.video.recordState";
    }

    static /* synthetic */ String zf() {
        return "xiaomi.beauty.smileRatio";
    }

    static /* synthetic */ String zg() {
        return "xiaomi.faceAnalyzeResult.result";
    }
}
