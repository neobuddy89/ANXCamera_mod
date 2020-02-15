package com.android.camera2.vendortag;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfiguration;
import android.util.Log;
import com.android.camera2.vendortag.struct.SlowMotionVideoConfiguration;
import com.mi.config.b;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.function.Supplier;

public class CameraCharacteristicsVendorTags {
    public static final VendorTag<CameraCharacteristics.Key<Boolean>> ADAPTIVE_SNAPSHOT_SIZE_IN_SAT_MODE_SUPPORTED = create(A.INSTANCE, Boolean.class);
    public static final VendorTag<CameraCharacteristics.Key<int[]>> AI_SCENE_AVAILABLE_MODES = create(C0099p.INSTANCE, int[].class);
    public static final VendorTag<CameraCharacteristics.Key<Boolean>> BEAUTY_MAKEUP = create(C0083l.INSTANCE, Boolean.class);
    public static final VendorTag<CameraCharacteristics.Key<Byte>> BEAUTY_VERSION = create(C0035a.INSTANCE, Byte.class);
    public static final VendorTag<CameraCharacteristics.Key<Integer>> CAMERA_ROLE_ID = create(C0075j.INSTANCE, Integer.class);
    public static final VendorTag<CameraCharacteristics.Key<byte[]>> CAM_CALIBRATION_DATA = create(C0126w.INSTANCE, byte[].class);
    public static final VendorTag<CameraCharacteristics.Key<int[]>> CUSTOM_HFR_FPS_TABLE = create(E.INSTANCE, int[].class);
    public static final VendorTag<CameraCharacteristics.Key<Byte>> EIS_PREVIEW_SUPPORTED = create(G.INSTANCE, Byte.class);
    public static final VendorTag<CameraCharacteristics.Key<int[]>> EXTRA_HIGH_SPEED_VIDEO_CONFIGURATIONS = create(B.INSTANCE, int[].class);
    public static final VendorTag<CameraCharacteristics.Key<Integer>> EXTRA_HIGH_SPEED_VIDEO_NUMBER = create(C0045c.INSTANCE, Integer.class);
    public static final VendorTag<CameraCharacteristics.Key<Byte>> FOVC_SUPPORTED = create(C0118u.INSTANCE, Byte.class);
    public static final VendorTag<CameraCharacteristics.Key<Byte>> IS_QCFA_SENSOR = create(C0134y.INSTANCE, Byte.class);
    public static final VendorTag<CameraCharacteristics.Key<Boolean>> LOG_FORMAT = create(r.INSTANCE, Boolean.class);
    public static final VendorTag<CameraCharacteristics.Key<Byte>> MACRO_ZOOM_FEATURE = create(C0079k.INSTANCE, Byte.class);
    public static final VendorTag<CameraCharacteristics.Key<Byte>> MFNR_BOKEH_SUPPORTED = create(F.INSTANCE, Byte.class);
    public static final VendorTag<CameraCharacteristics.Key<Float>> MI_ALGO_ASD_VERSION = create(C.INSTANCE, Float.class);
    public static final VendorTag<CameraCharacteristics.Key<Rect>> QCFA_ACTIVE_ARRAY_SIZE = create(I.INSTANCE, Rect.class);
    public static final VendorTag<CameraCharacteristics.Key<StreamConfiguration[]>> QCFA_STREAM_CONFIGURATIONS = create(C0110s.INSTANCE, StreamConfiguration[].class);
    public static final VendorTag<CameraCharacteristics.Key<StreamConfiguration[]>> SCALER_AVAILABLE_LIMIT_STREAM_CONFIGURATIONS = create(C0130x.INSTANCE, StreamConfiguration[].class);
    public static final VendorTag<CameraCharacteristics.Key<StreamConfiguration[]>> SCALER_AVAILABLE_SR_STREAM_CONFIGURATIONS = create(D.INSTANCE, StreamConfiguration[].class);
    public static final VendorTag<CameraCharacteristics.Key<StreamConfiguration[]>> SCALER_AVAILABLE_STREAM_CONFIGURATIONS = create(K.INSTANCE, StreamConfiguration[].class);
    public static final VendorTag<CameraCharacteristics.Key<Integer>> SCREEN_LIGHT_BRIGHTNESS = create(C0040b.INSTANCE, Integer.class);
    public static final VendorTag<CameraCharacteristics.Key<SlowMotionVideoConfiguration[]>> SLOW_MOTION_VIDEO_CONFIGURATIONS = create(C0050d.INSTANCE, SlowMotionVideoConfiguration[].class);
    public static final VendorTag<CameraCharacteristics.Key<Boolean>> SUPER_PORTRAIT_SUPPORTED = create(C0063g.INSTANCE, Boolean.class);
    private static final String TAG = "CameraCharacteristicsVendorTags";
    public static final VendorTag<CameraCharacteristics.Key<Byte>> TELE_OIS_SUPPORTED = create(C0071i.INSTANCE, Byte.class);
    public static final VendorTag<CameraCharacteristics.Key<Boolean>> TRIPARTITE_LIGHT = create(H.INSTANCE, Boolean.class);
    public static final VendorTag<CameraCharacteristics.Key<Boolean>> VIDEO_BEAUTY = create(C0114t.INSTANCE, Boolean.class);
    public static final VendorTag<CameraCharacteristics.Key<Boolean>> VIDEO_BOKEH_ADJUEST = create(C0087m.INSTANCE, Boolean.class);
    public static final VendorTag<CameraCharacteristics.Key<Boolean>> VIDEO_BOKEH_FRONT_ADJUEST = create(C0055e.INSTANCE, Boolean.class);
    public static final VendorTag<CameraCharacteristics.Key<Boolean>> VIDEO_COLOR_RENTENTION_BACK = create(C0095o.INSTANCE, Boolean.class);
    public static final VendorTag<CameraCharacteristics.Key<Boolean>> VIDEO_COLOR_RENTENTION_FRONT = create(C0103q.INSTANCE, Boolean.class);
    public static final VendorTag<CameraCharacteristics.Key<Boolean>> VIDEO_FILTER = create(C0122v.INSTANCE, Boolean.class);
    public static final VendorTag<CameraCharacteristics.Key<Boolean>> VIDEO_MIMOVIE = create(C0059f.INSTANCE, Boolean.class);
    public static final VendorTag<CameraCharacteristics.Key<Byte>> XIAOMI_AI_COLOR_CORRECTION_VERSION = create(C0067h.INSTANCE, Byte.class);
    public static final VendorTag<CameraCharacteristics.Key<StreamConfiguration[]>> XIAOMI_SCALER_HEIC_STREAM_CONFIGURATIONS = create(C0091n.INSTANCE, StreamConfiguration[].class);
    public static final VendorTag<CameraCharacteristics.Key<int[]>> XIAOMI_SENSOR_INFO_SENSITIVITY_RANGE = create(J.INSTANCE, int[].class);
    public static final VendorTag<CameraCharacteristics.Key<Integer>> XIAOMI_YUV_FORMAT = create(C0138z.INSTANCE, Integer.class);
    private static Constructor<CameraCharacteristics.Key> characteristicsConstructor;

    static /* synthetic */ String Af() {
        return "com.xiaomi.camera.supportedfeatures.beautyVersion";
    }

    static /* synthetic */ String Bf() {
        return b.isMTKPlatform() ? "com.xiaomi.capabilities.satAdaptiveSnapshotSizeSupported" : "xiaomi.capabilities.satAdaptiveSnapshotSizeSupported";
    }

    static /* synthetic */ String Cf() {
        return "org.codeaurora.qcamera3.additional_hfr_video_sizes.valid_number";
    }

    static /* synthetic */ String Df() {
        return "com.mediatek.smvrfeature.availableSmvrModes";
    }

    static /* synthetic */ String Ef() {
        return "xiaomi.ai.misd.MiAlgoAsdVersion";
    }

    static /* synthetic */ String Ff() {
        return "com.xiaomi.camera.supportedfeatures.TeleOisSupported";
    }

    static /* synthetic */ String Gf() {
        return "com.xiaomi.cameraid.role.cameraId";
    }

    static /* synthetic */ String Hf() {
        return "com.xiaomi.camera.supportedfeatures.superportraitSupported";
    }

    static /* synthetic */ String If() {
        return "com.xiaomi.camera.supportedfeatures.videoBokeh";
    }

    static /* synthetic */ String Jf() {
        return "com.xiaomi.camera.supportedfeatures.videomimovie";
    }

    static /* synthetic */ String Kf() {
        return "com.xiaomi.camera.supportedfeatures.videologformat";
    }

    static /* synthetic */ String Lf() {
        return "com.xiaomi.camera.supportedfeatures.3rdLightWeightSupported";
    }

    static /* synthetic */ String Mf() {
        return "xiaomi.scaler.availableHeicStreamConfigurations";
    }

    static /* synthetic */ String Nf() {
        return "xiaomi.yuv.format";
    }

    static /* synthetic */ String Of() {
        return "com.xiaomi.camera.supportedfeatures.AIEnhancementVersion";
    }

    static /* synthetic */ String Pf() {
        return "xiaomi.sensor.info.sensitivityRange";
    }

    static /* synthetic */ String Qf() {
        return "com.xiaomi.camera.supportedfeatures.videoBokehFront";
    }

    static /* synthetic */ String Rf() {
        return "com.xiaomi.camera.supportedfeatures.videoColorRetentionFront";
    }

    static /* synthetic */ String Sf() {
        return "com.xiaomi.camera.supportedfeatures.videoColorRetentionBack";
    }

    static /* synthetic */ String Tf() {
        return "com.xiaomi.camera.supportedfeatures.videoBeauty";
    }

    static /* synthetic */ String Uf() {
        return "com.xiaomi.camera.supportedfeatures.beautyMakeup";
    }

    static /* synthetic */ String Vf() {
        return "org.codeaurora.qcamera3.additional_hfr_video_sizes.hfr_video_size";
    }

    /* access modifiers changed from: private */
    public static <T> CameraCharacteristics.Key<T> characteristicsKey(String str, Class<T> cls) {
        try {
            if (characteristicsConstructor == null) {
                characteristicsConstructor = CameraCharacteristics.Key.class.getConstructor(new Class[]{String.class, cls.getClass()});
                characteristicsConstructor.setAccessible(true);
            }
            return characteristicsConstructor.newInstance(new Object[]{str, cls});
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            Log.d(TAG, "Cannot find/call Key constructor: " + e2.getMessage());
            return null;
        }
    }

    private static <T> VendorTag<CameraCharacteristics.Key<T>> create(final Supplier<String> supplier, final Class<T> cls) {
        return new VendorTag<CameraCharacteristics.Key<T>>() {
            /* access modifiers changed from: protected */
            public CameraCharacteristics.Key<T> create() {
                return CameraCharacteristicsVendorTags.characteristicsKey(getName(), cls);
            }

            public String getName() {
                return (String) supplier.get();
            }
        };
    }

    static /* synthetic */ String lf() {
        return b.isMTKPlatform() ? "com.xiaomi.ai.asd.availableSceneMode" : "xiaomi.ai.asd.availableSceneMode";
    }

    static /* synthetic */ String mf() {
        return b.isMTKPlatform() ? "com.xiaomi.qcfa.supported" : "org.codeaurora.qcamera3.quadra_cfa.is_qcfa_sensor";
    }

    static /* synthetic */ String nf() {
        return b.isMTKPlatform() ? "com.mediatek.streamingfeature.availableHfpsMaxResolutions" : "org.quic.camera2.customhfrfps.info.CustomHFRFpsTable";
    }

    static /* synthetic */ String of() {
        return b.isMTKPlatform() ? "com.xiaomi.scaler.availableStreamConfigurations" : "xiaomi.scaler.availableStreamConfigurations";
    }

    static /* synthetic */ String pf() {
        return b.isMTKPlatform() ? "com.xiaomi.scaler.availableLimitStreamConfigurations" : "xiaomi.scaler.availableLimitStreamConfigurations";
    }

    public static void preload() {
        Log.d(TAG, "preloading...");
    }

    static /* synthetic */ String qf() {
        return "org.codeaurora.qcamera3.quadra_cfa.activeArraySize";
    }

    static /* synthetic */ String rf() {
        return "org.codeaurora.qcamera3.quadra_cfa.availableStreamConfigurations";
    }

    static /* synthetic */ String sf() {
        return b.isMTKPlatform() ? "com.xiaomi.scaler.availableSuperResolutionStreamConfigurations" : "xiaomi.scaler.availableSuperResolutionStreamConfigurations";
    }

    static /* synthetic */ String tf() {
        return "com.xiaomi.camera.algoup.dualCalibrationData";
    }

    static /* synthetic */ String uf() {
        return b.isMTKPlatform() ? "com.xiaomi.capabilities.videoStabilization.previewSupported" : "xiaomi.capabilities.videoStabilization.previewSupported";
    }

    static /* synthetic */ String vf() {
        return b.isMTKPlatform() ? "com.xiaomi.flash.screenLight.brightness" : "xiaomi.flash.screenLight.brightness";
    }

    static /* synthetic */ String wf() {
        return b.isMTKPlatform() ? "com.xiaomi.capabilities.mfnr_bokeh_supported" : "xiaomi.capabilities.mfnr_bokeh_supported";
    }

    static /* synthetic */ String xf() {
        return "com.xiaomi.camera.supportedfeatures.videofilter";
    }

    static /* synthetic */ String yf() {
        return "xiaomi.capabilities.macro_zoom_feature";
    }

    static /* synthetic */ String zf() {
        return "com.xiaomi.camera.supportedfeatures.fovcEnable";
    }
}
