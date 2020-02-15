package com.android.camera.module.loader.camera2;

import com.android.camera.data.DataRepository;
import com.android.camera.data.data.global.DataItemGlobal;
import com.android.camera.log.Log;
import com.android.camera.module.ModuleManager;
import com.android.camera.module.loader.SurfaceCreatedCallback;
import com.android.camera.module.loader.SurfaceStateListener;
import com.android.camera.snap.SnapTrigger;
import io.reactivex.Observer;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.disposables.Disposable;

public class Camera2OpenOnSubScribe implements SingleOnSubscribe<Camera2Result>, SurfaceCreatedCallback, Observer<Camera2Result> {
    private static final String TAG = "Camera2OpenOnSubScribe";
    private Camera2Result mCamera2Result;
    private SingleEmitter<Camera2Result> mSingleEmitter;
    private SurfaceStateListener mSurfaceStateListener;

    public Camera2OpenOnSubScribe(SurfaceStateListener surfaceStateListener) {
        this.mSurfaceStateListener = surfaceStateListener;
    }

    private void openCamera() {
        if (SnapTrigger.getInstance().isRunning()) {
            SnapTrigger.getInstance();
            SnapTrigger.destroy();
        }
        DataItemGlobal dataItemGlobal = DataRepository.dataItemGlobal();
        Camera2OpenManager.getInstance().openCamera(dataItemGlobal.getCurrentCameraId(), dataItemGlobal.getCurrentMode(), this, false);
    }

    private void submitResult(Camera2Result camera2Result) {
        SingleEmitter<Camera2Result> singleEmitter = this.mSingleEmitter;
        if (singleEmitter != null) {
            singleEmitter.onSuccess(camera2Result);
        }
    }

    public void onComplete() {
    }

    public void onError(Throwable th) {
        this.mCamera2Result = Camera2Result.create(3);
        submitResult(this.mCamera2Result);
    }

    public void onGlSurfaceCreated() {
        Log.d(TAG, "onGlSurfaceCreated: mSingleEmitter = " + this.mSingleEmitter);
        SingleEmitter<Camera2Result> singleEmitter = this.mSingleEmitter;
        if (singleEmitter != null && !singleEmitter.isDisposed()) {
            Camera2Result camera2Result = this.mCamera2Result;
            if (camera2Result != null) {
                submitResult(camera2Result);
            }
        }
    }

    public void onNext(Camera2Result camera2Result) {
        Log.d(TAG, "onNext: hasSurface = " + this.mSurfaceStateListener.hasSurface());
        this.mCamera2Result = camera2Result;
        if (ModuleManager.isCapture() || this.mSurfaceStateListener.hasSurface()) {
            submitResult(camera2Result);
        }
    }

    public void onSubscribe(Disposable disposable) {
    }

    public void subscribe(SingleEmitter<Camera2Result> singleEmitter) throws Exception {
        this.mCamera2Result = null;
        this.mSingleEmitter = singleEmitter;
        openCamera();
    }
}
