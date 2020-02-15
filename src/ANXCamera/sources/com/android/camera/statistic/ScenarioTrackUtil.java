package com.android.camera.statistic;

import android.content.Context;
import android.os.SystemClock;
import android.os.statistics.E2EScenario;
import android.os.statistics.E2EScenarioPayload;
import android.os.statistics.E2EScenarioPerfTracer;
import android.os.statistics.E2EScenarioSettings;
import android.provider.MiuiSettings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.android.camera.log.Log;
import com.xiaomi.stat.C0155b;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class ScenarioTrackUtil {
    /* access modifiers changed from: private */
    public static final String TAG = "ScenarioTrackUtil";
    public static final CameraEventScenario sCaptureTimeScenario = new CameraEventScenario("CaptureTime");
    public static final CameraEventScenario sLaunchTimeScenario = new CameraEventScenario("CameraLaunchTime");
    public static final CameraEventScenario sShotToGalleryTimeScenario = new CameraEventScenario("ShotToGallery");
    public static final CameraEventScenario sShotToViewTimeScenario = new CameraEventScenario("ShotToView");
    public static final CameraEventScenario sStartVideoRecordTimeScenario = new CameraEventScenario("StartVideoRecordTime");
    public static final CameraEventScenario sStopVideoRecordTimeScenario = new CameraEventScenario("StopVideoRecordTime");
    private static final CameraEventScenario sSwitchCameraTimeScenario = new CameraEventScenario("SwitchCameraTime");
    public static final CameraEventScenario sSwitchModeTimeScenario = new CameraEventScenario("SwitchModeTime");
    private static final E2EScenarioSettings scenarioSettings = new E2EScenarioSettings();

    public static class CameraEventScenario {
        private static final String CAMERA_PACKAGE = "com.android.camera";
        private static final String CATEGORY_PERFORMANCE = "Performance";
        E2EScenario e2eScenario;
        public volatile boolean isTrackStarted = false;
        String mEventName;

        CameraEventScenario(String str) {
            this.e2eScenario = initE2EScenario(str);
            this.mEventName = str;
        }

        private E2EScenario initE2EScenario(String str) {
            try {
                return new E2EScenario(CAMERA_PACKAGE, CATEGORY_PERFORMANCE, str);
            } catch (Exception e2) {
                String access$000 = ScenarioTrackUtil.TAG;
                Log.w(access$000, str + " initializer failed: " + e2.getMessage());
                return null;
            }
        }

        public String toString() {
            return this.mEventName;
        }
    }

    static {
        scenarioSettings.setStatisticsMode(7);
        scenarioSettings.setHistoryLimitPerDay(200);
    }

    private static void abortScenario(@NonNull CameraEventScenario cameraEventScenario) {
        abortScenario(cameraEventScenario, "");
    }

    private static void abortScenario(@NonNull CameraEventScenario cameraEventScenario, @Nullable String str) {
        if (cameraEventScenario.e2eScenario == null) {
            String str2 = TAG;
            Log.w(str2, "track " + cameraEventScenario.toString() + " event start cancel due to scenario is null!");
        } else if (cameraEventScenario.isTrackStarted) {
            E2EScenarioPerfTracer.abortScenario(cameraEventScenario.e2eScenario, str);
        }
    }

    private static void beginScenario(@NonNull CameraEventScenario cameraEventScenario) {
        beginScenario(cameraEventScenario, "", (E2EScenarioPayload) null);
    }

    private static void beginScenario(CameraEventScenario cameraEventScenario, E2EScenarioPayload e2EScenarioPayload) {
        beginScenario(cameraEventScenario, "", e2EScenarioPayload);
    }

    private static void beginScenario(@NonNull CameraEventScenario cameraEventScenario, @Nullable String str, @Nullable E2EScenarioPayload e2EScenarioPayload) {
        if (cameraEventScenario.e2eScenario == null) {
            String str2 = TAG;
            Log.w(str2, "track " + cameraEventScenario.toString() + " event start cancel due to scenario is null!");
            return;
        }
        if (cameraEventScenario.isTrackStarted) {
            E2EScenario e2EScenario = cameraEventScenario.e2eScenario;
            String str3 = "";
            if (!str3.equals(str)) {
                str3 = str;
            }
            E2EScenarioPerfTracer.abortScenario(e2EScenario, str3);
        }
        try {
            E2EScenarioPerfTracer.asyncBeginScenario(cameraEventScenario.e2eScenario, scenarioSettings, str, e2EScenarioPayload);
            cameraEventScenario.isTrackStarted = true;
        } catch (Exception e2) {
            String str4 = TAG;
            Log.w(str4, "track " + cameraEventScenario.toString() + " event start failed: " + e2.getMessage());
        }
    }

    private static void finishScenario(CameraEventScenario cameraEventScenario, E2EScenarioPayload e2EScenarioPayload) {
        finishScenario(cameraEventScenario, "", e2EScenarioPayload);
    }

    private static void finishScenario(@NonNull CameraEventScenario cameraEventScenario, @Nullable String str, @Nullable E2EScenarioPayload e2EScenarioPayload) {
        if (cameraEventScenario.e2eScenario == null) {
            String str2 = TAG;
            Log.w(str2, "track " + cameraEventScenario.toString() + " event end cancel, due to scenario is null!");
        } else if (!cameraEventScenario.isTrackStarted) {
            String str3 = TAG;
            Log.w(str3, "track " + cameraEventScenario.toString() + " event end cancel, due to scenario has not started!");
        } else {
            if (e2EScenarioPayload != null) {
                try {
                    E2EScenarioPerfTracer.finishScenario(cameraEventScenario.e2eScenario, str, e2EScenarioPayload);
                } catch (Exception e2) {
                    String str4 = TAG;
                    Log.w(str4, "track " + cameraEventScenario.toString() + " event end failed: " + e2.getMessage());
                    return;
                }
            } else {
                E2EScenarioPerfTracer.finishScenario(cameraEventScenario.e2eScenario);
            }
            cameraEventScenario.isTrackStarted = false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0040  */
    public static void trackAppLunchTimeEnd(@Nullable Map map, Context context) {
        JSONObject jSONObject;
        String string = MiuiSettings.System.getString(context.getContentResolver(), "camera_boost");
        E2EScenarioPayload e2EScenarioPayload = new E2EScenarioPayload();
        if (string != null) {
            boolean z = false;
            try {
                jSONObject = new JSONObject(string);
                try {
                    if (SystemClock.uptimeMillis() - Long.parseLong(jSONObject.optString(C0155b.j)) < 1000) {
                        z = true;
                    }
                    jSONObject.remove(C0155b.j);
                } catch (Exception e2) {
                    e = e2;
                    Log.w(TAG, "Exception", (Throwable) e);
                    if (z) {
                    }
                    e2EScenarioPayload.putAll(map);
                    finishScenario(sLaunchTimeScenario, e2EScenarioPayload);
                }
            } catch (Exception e3) {
                e = e3;
                jSONObject = null;
                Log.w(TAG, "Exception", (Throwable) e);
                if (z) {
                }
                e2EScenarioPayload.putAll(map);
                finishScenario(sLaunchTimeScenario, e2EScenarioPayload);
            }
            if (z) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    e2EScenarioPayload.put(next, jSONObject.opt(next));
                }
            }
        }
        e2EScenarioPayload.putAll(map);
        finishScenario(sLaunchTimeScenario, e2EScenarioPayload);
    }

    public static void trackAppLunchTimeStart(@NonNull boolean z) {
        E2EScenarioPayload e2EScenarioPayload = new E2EScenarioPayload();
        e2EScenarioPayload.put("LaunchMode", z ? "COLD" : "HOT");
        beginScenario(sLaunchTimeScenario, e2EScenarioPayload);
    }

    public static void trackCaptureTimeEnd() {
        finishScenario(sCaptureTimeScenario, (E2EScenarioPayload) null);
    }

    public static void trackCaptureTimeStart(@NonNull boolean z, @NonNull int i) {
        E2EScenarioPayload e2EScenarioPayload = new E2EScenarioPayload();
        e2EScenarioPayload.putValues(new Object[]{"CameraID", CameraStatUtils.cameraIdToName(z), "Module", CameraStatUtils.modeIdToName(i)});
        beginScenario(sCaptureTimeScenario, e2EScenarioPayload);
    }

    public static void trackScenarioAbort(@NonNull CameraEventScenario cameraEventScenario) {
        abortScenario(cameraEventScenario);
    }

    public static void trackScenarioAbort(@NonNull CameraEventScenario cameraEventScenario, @Nullable String str) {
        abortScenario(cameraEventScenario, str);
    }

    public static void trackShotToGalleryEnd(@NonNull boolean z, @NonNull long j) {
        E2EScenarioPayload e2EScenarioPayload = new E2EScenarioPayload();
        e2EScenarioPayload.putValues(new Object[]{"quickShotAnimation", Boolean.valueOf(z)});
        finishScenario(sShotToGalleryTimeScenario, String.valueOf(j), e2EScenarioPayload);
    }

    public static void trackShotToGalleryStart(@NonNull boolean z, @NonNull int i, @NonNull long j) {
        E2EScenarioPayload e2EScenarioPayload = new E2EScenarioPayload();
        e2EScenarioPayload.putValues(new Object[]{"CameraID", CameraStatUtils.cameraIdToName(z), "Module", CameraStatUtils.modeIdToName(i)});
        beginScenario(sShotToGalleryTimeScenario, String.valueOf(j), e2EScenarioPayload);
    }

    public static void trackShotToViewEnd(@NonNull boolean z, @NonNull long j) {
        E2EScenarioPayload e2EScenarioPayload = new E2EScenarioPayload();
        e2EScenarioPayload.putValues(new Object[]{"quickShotAnimation", Boolean.valueOf(z)});
        finishScenario(sShotToViewTimeScenario, String.valueOf(j), e2EScenarioPayload);
    }

    public static void trackShotToViewStart(@NonNull boolean z, @NonNull int i, @NonNull long j) {
        E2EScenarioPayload e2EScenarioPayload = new E2EScenarioPayload();
        e2EScenarioPayload.putValues(new Object[]{"CameraID", CameraStatUtils.cameraIdToName(z), "Module", CameraStatUtils.modeIdToName(i)});
        beginScenario(sShotToViewTimeScenario, String.valueOf(j), e2EScenarioPayload);
    }

    public static void trackStartVideoRecordEnd() {
        finishScenario(sStartVideoRecordTimeScenario, (E2EScenarioPayload) null);
    }

    public static void trackStartVideoRecordStart(@NonNull String str, @NonNull boolean z) {
        E2EScenarioPayload e2EScenarioPayload = new E2EScenarioPayload();
        e2EScenarioPayload.putValues(new Object[]{"mode", str, "cameraId", CameraStatUtils.cameraIdToName(z)});
        beginScenario(sStartVideoRecordTimeScenario, e2EScenarioPayload);
    }

    public static void trackStopVideoRecordEnd() {
        finishScenario(sStopVideoRecordTimeScenario, (E2EScenarioPayload) null);
    }

    public static void trackStopVideoRecordStart(@NonNull String str, @NonNull boolean z) {
        E2EScenarioPayload e2EScenarioPayload = new E2EScenarioPayload();
        e2EScenarioPayload.putValues(new Object[]{"mode", str, "cameraId", CameraStatUtils.cameraIdToName(z)});
        beginScenario(sStopVideoRecordTimeScenario, e2EScenarioPayload);
    }

    public static void trackSwitchCameraEnd() {
        finishScenario(sSwitchCameraTimeScenario, (E2EScenarioPayload) null);
    }

    public static void trackSwitchCameraStart(@NonNull boolean z, @NonNull boolean z2, @NonNull int i) {
        E2EScenarioPayload e2EScenarioPayload = new E2EScenarioPayload();
        e2EScenarioPayload.putValues(new Object[]{"from", CameraStatUtils.cameraIdToName(z), "to", CameraStatUtils.cameraIdToName(z2), "inMode", CameraStatUtils.modeIdToName(i)});
        beginScenario(sSwitchCameraTimeScenario, e2EScenarioPayload);
    }

    public static void trackSwitchModeEnd() {
        finishScenario(sSwitchModeTimeScenario, (E2EScenarioPayload) null);
    }

    public static void trackSwitchModeStart(@NonNull int i, @NonNull int i2, @NonNull boolean z) {
        E2EScenarioPayload e2EScenarioPayload = new E2EScenarioPayload();
        e2EScenarioPayload.putValues(new Object[]{"from", CameraStatUtils.modeIdToName(i), "to", CameraStatUtils.modeIdToName(i2), "cameraId", CameraStatUtils.cameraIdToName(z)});
        beginScenario(sSwitchModeTimeScenario, e2EScenarioPayload);
    }
}
