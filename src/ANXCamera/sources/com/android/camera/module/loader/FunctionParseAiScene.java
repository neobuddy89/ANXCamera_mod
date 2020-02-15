package com.android.camera.module.loader;

import android.graphics.Rect;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.params.Face;
import com.android.camera.CameraSettings;
import com.android.camera.data.DataRepository;
import com.android.camera.log.Log;
import com.android.camera2.CameraCapabilities;
import com.android.camera2.CaptureResultParser;
import io.reactivex.functions.Function;

public class FunctionParseAiScene implements Function<CaptureResult, Integer> {
    private static final String TAG = "FunctionParseAiScene";
    private CameraCapabilities mCameraCapabilities;
    private int mCurrentFaceScene;
    private int mLatestFaceScene;
    private int mModuleIndex;
    private int mParsedAiScene;
    private int mSameFaceSceneDetectedTimes;
    private final boolean mSupportMoonMode = DataRepository.dataItemFeature().Yc();

    public FunctionParseAiScene(int i, CameraCapabilities cameraCapabilities) {
        this.mModuleIndex = i;
        this.mCameraCapabilities = cameraCapabilities;
    }

    private boolean faceSceneFiltering(int i) {
        int i2 = this.mLatestFaceScene;
        if (i2 != i) {
            this.mLatestFaceScene = i;
            this.mSameFaceSceneDetectedTimes = 0;
        } else {
            int i3 = this.mSameFaceSceneDetectedTimes;
            if (i3 < 20) {
                this.mSameFaceSceneDetectedTimes = i3 + 1;
                if (20 == this.mSameFaceSceneDetectedTimes) {
                    int i4 = this.mCurrentFaceScene;
                    if (i4 != i2) {
                        this.mLatestFaceScene = i4;
                        this.mCurrentFaceScene = this.mLatestFaceScene;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Integer apply(CaptureResult captureResult) {
        int i;
        int hdrDetectedScene;
        Rect rect = (Rect) captureResult.get(CaptureResult.SCALER_CROP_REGION);
        Rect activeArraySize = this.mCameraCapabilities.getActiveArraySize();
        if (rect == null || activeArraySize == null) {
            return Integer.valueOf(this.mParsedAiScene);
        }
        float width = ((float) activeArraySize.width()) / ((float) rect.width());
        Face[] faceArr = (Face[]) captureResult.get(CaptureResult.STATISTICS_FACES);
        if (this.mModuleIndex == 171 || CameraSettings.isFrontCamera() || faceArr == null || faceArr.length <= 0) {
            i = Integer.MIN_VALUE;
        } else {
            i = Integer.MIN_VALUE;
            for (Face bounds : faceArr) {
                if (((float) bounds.getBounds().width()) > 300.0f / width) {
                    Log.c(TAG, "parseAiSceneResult: AI_SCENE_MODE_HUMAN  face.length = " + faceArr.length + ";face.width = " + bounds.getBounds().width() + ";hdrMode = " + hdrDetectedScene);
                    if (hdrDetectedScene == 1) {
                        CameraCapabilities cameraCapabilities = this.mCameraCapabilities;
                        if (cameraCapabilities != null && cameraCapabilities.getMiAlgoASDVersion() < 2.0f) {
                            i = -1;
                        }
                    }
                    i = 25;
                }
            }
        }
        if (faceSceneFiltering(i)) {
            int asdDetectedModes = CaptureResultParser.getAsdDetectedModes(captureResult);
            if (i == Integer.MIN_VALUE || asdDetectedModes == 38) {
                if (!this.mSupportMoonMode && asdDetectedModes == 35) {
                    Log.w(TAG, "detected moon mode on unsupported device, set scene negative");
                    asdDetectedModes = 0;
                }
                if (asdDetectedModes < 0) {
                    Log.e(TAG, "parseAiSceneResult: parse a error result: " + asdDetectedModes);
                    this.mParsedAiScene = 0;
                } else {
                    this.mParsedAiScene = asdDetectedModes;
                }
            } else {
                this.mParsedAiScene = i;
            }
        }
        if (CameraSettings.isDocumentModeOn(this.mModuleIndex)) {
            int i2 = this.mParsedAiScene;
            if (i2 == -1 || i2 == 10 || i2 == 35) {
                this.mParsedAiScene = 0;
            }
        }
        return Integer.valueOf(this.mParsedAiScene);
    }

    public void resetScene() {
        this.mLatestFaceScene = 0;
        this.mParsedAiScene = 0;
    }
}
