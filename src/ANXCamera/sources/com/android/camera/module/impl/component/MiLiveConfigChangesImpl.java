package com.android.camera.module.impl.component;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.Image;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.android.camera.ActivityBase;
import com.android.camera.CameraScreenNail;
import com.android.camera.CameraSettings;
import com.android.camera.CameraSize;
import com.android.camera.SurfaceTextureScreenNail;
import com.android.camera.Util;
import com.android.camera.data.DataRepository;
import com.android.camera.effect.EffectController;
import com.android.camera.effect.draw_mode.DrawExtTexAttribute;
import com.android.camera.fragment.beauty.LiveBeautyFilterFragment;
import com.android.camera.log.Log;
import com.android.camera.module.MiLiveModule;
import com.android.camera.module.impl.component.ILive;
import com.android.camera.module.impl.component.MiLiveRecorder;
import com.android.camera.protocol.ModeCoordinatorImpl;
import com.android.camera.protocol.ModeProtocol;
import com.android.camera2.Camera2Proxy;
import com.ss.android.vesdk.VEEditor;
import java.io.File;
import java.util.List;

public class MiLiveConfigChangesImpl implements ModeProtocol.MiLiveConfigChanges, ILive.ILiveRecorderStateListener {
    private static final int DEFAULT_FPS = 30;
    private static final int DEFAULT_RECORD_BITRATE = 31457280;
    private static final float DEFAULT_SPEED = 1.0f;
    private static final int VIDEO_HEIGHT = 1080;
    private static final int VIDEO_WIDTH = 1920;
    private final float[] SPEEDS = {0.33f, 0.5f, 1.0f, 2.0f, 3.0f};
    private final String TAG = (MiLiveConfigChangesImpl.class.getSimpleName() + "@" + hashCode());
    /* access modifiers changed from: private */
    public ActivityBase mActivity;
    private Context mContext;
    private String mCurAudioPath;
    private float mCurSpeed;
    private int mCurrentOrientation = -1;
    private String mFilterBitmapPath;
    private int mRecordState = 0;
    private ILive.ILiveRecorder mRecorder;
    private ModeProtocol.MiLiveRecorderControl.IRecorderListener mRecorderListener;
    private ILive.ILiveRecordingTimeListener mRecordingTimeListener = new ILive.ILiveRecordingTimeListener() {
        public void onRecordingTimeFinish() {
            if (MiLiveConfigChangesImpl.this.mActivity != null && MiLiveConfigChangesImpl.this.mActivity.getCurrentModule() != null && (MiLiveConfigChangesImpl.this.mActivity.getCurrentModule() instanceof MiLiveModule)) {
                ((MiLiveModule) MiLiveConfigChangesImpl.this.mActivity.getCurrentModule()).stopVideoRecording(true, true);
            }
        }

        public void onRecordingTimeUpdate(long j, float f2) {
            ModeProtocol.ActionProcessing actionProcessing = (ModeProtocol.ActionProcessing) ModeCoordinatorImpl.getInstance().getAttachProtocol(162);
            if (actionProcessing != null) {
                actionProcessing.updateRecordingTime(Util.millisecondToTimeString((long) ((((float) j) * 1.0f) / f2), false));
            }
        }
    };
    private SurfaceTextureScreenNail.SurfaceTextureScreenNailCallback mRender;
    private Handler mUIHandler;

    private MiLiveConfigChangesImpl(ActivityBase activityBase) {
        this.mActivity = activityBase;
        this.mContext = activityBase.getApplicationContext();
    }

    private void abandomAudioFocus() {
        ((AudioManager) this.mActivity.getSystemService(VEEditor.MVConsts.TYPE_AUDIO)).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener) null);
    }

    public static MiLiveConfigChangesImpl create(ActivityBase activityBase) {
        return new MiLiveConfigChangesImpl(activityBase);
    }

    private void requestAudioFocus() {
        ((AudioManager) this.mActivity.getSystemService(VEEditor.MVConsts.TYPE_AUDIO)).requestAudioFocus((AudioManager.OnAudioFocusChangeListener) null, 3, 1);
    }

    public boolean canRecordingStop() {
        return this.mRecorder != null && ((float) (System.currentTimeMillis() - this.mRecorder.getStartTime())) > (this.mCurSpeed * 500.0f) * 2.0f;
    }

    public void clearAudio() {
        this.mCurAudioPath = "";
        ILive.ILiveRecorder iLiveRecorder = this.mRecorder;
        if (iLiveRecorder != null) {
            iLiveRecorder.setAudioPath(this.mCurAudioPath);
        }
    }

    public void deleteLastFragment() {
        ILive.ILiveRecorder iLiveRecorder = this.mRecorder;
        if (iLiveRecorder != null) {
            iLiveRecorder.deletePreSegment();
            if (this.mRecorder.getLiveSegments().isEmpty()) {
                ModeProtocol.MiLiveRecorderControl.IRecorderListener iRecorderListener = this.mRecorderListener;
                if (iRecorderListener != null) {
                    iRecorderListener.onRecorderCancel();
                }
            }
        }
    }

    public /* synthetic */ void df() {
        ModeProtocol.MiLiveRecorderControl.IRecorderListener iRecorderListener = this.mRecorderListener;
        if (iRecorderListener != null) {
            ILive.ILiveRecorder iLiveRecorder = this.mRecorder;
            if (iLiveRecorder != null) {
                iRecorderListener.onRecorderPaused(iLiveRecorder.getLiveSegments());
            }
        }
    }

    public /* synthetic */ void ef() {
        ModeProtocol.MiLiveRecorderControl.IRecorderListener iRecorderListener = this.mRecorderListener;
        if (iRecorderListener != null) {
            ILive.ILiveRecorder iLiveRecorder = this.mRecorder;
            if (iLiveRecorder != null) {
                iRecorderListener.onRecorderFinish(iLiveRecorder.getLiveSegments(), this.mCurAudioPath);
                this.mRecorder.getLiveSegments().clear();
            }
        }
    }

    public /* synthetic */ void ff() {
        ModeProtocol.MiLiveRecorderControl.IRecorderListener iRecorderListener = this.mRecorderListener;
        if (iRecorderListener != null && this.mRecorder != null) {
            iRecorderListener.onRecorderError();
        }
    }

    public CameraSize getAlgorithmPreviewSize(List<CameraSize> list) {
        return Util.getOptimalVideoSnapshotPictureSize(list, (double) getPreviewRatio(), 176, 144);
    }

    public String getAudioPath() {
        return this.mCurAudioPath;
    }

    @SuppressLint({"WrongConstant"})
    public int getAuthResult() {
        return 0;
    }

    public int getCurState() {
        switch (this.mRecordState) {
            case 1:
            case 4:
            case 8:
                return 1;
            case 2:
            case 5:
            case 6:
                return 2;
            case 3:
                return 3;
            default:
                return 0;
        }
    }

    public SurfaceTexture getInputSurfaceTexture() {
        ILive.ILiveRecorder iLiveRecorder = this.mRecorder;
        if (iLiveRecorder != null) {
            return iLiveRecorder.genInputSurfaceTexture();
        }
        Log.e(this.TAG, "genInputSurfaceTexture null");
        return null;
    }

    public float getPreviewRatio() {
        return 1.7777777f;
    }

    public float getRecordSpeed() {
        return this.mCurSpeed;
    }

    public int getSegmentSize() {
        ILive.ILiveRecorder iLiveRecorder = this.mRecorder;
        if (iLiveRecorder != null) {
            return iLiveRecorder.getLiveSegments().size();
        }
        return 0;
    }

    public long getStartRecordingTime() {
        ILive.ILiveRecorder iLiveRecorder = this.mRecorder;
        if (iLiveRecorder != null) {
            return iLiveRecorder.getStartTime();
        }
        return 0;
    }

    public String getTimeValue() {
        return Util.millisecondToTimeString(Util.clamp(getTotalRecordingTime(), 1000, 15000), false, true);
    }

    public long getTotalRecordingTime() {
        ILive.ILiveRecorder iLiveRecorder = this.mRecorder;
        if (iLiveRecorder != null) {
            return ILive.getTotolDuration(iLiveRecorder.getLiveSegments());
        }
        return 0;
    }

    public void initPreview(int i, int i2, int i3, CameraScreenNail cameraScreenNail) {
        if (this.mRecorder == null) {
            MiLiveRecorder build = new MiLiveRecorder.Builder(this.mActivity, VIDEO_WIDTH, VIDEO_HEIGHT).setStateListener(this).setHandler(this.mUIHandler).setRecordingTimeListener(this.mRecordingTimeListener).setMaxDuration(15400).setBitrate(DEFAULT_RECORD_BITRATE).setFps(30).setVideoSaveDirPath(FileUtils.VIDEO_TMP).setSegmentData(DataRepository.dataItemLive().getMiLiveSegmentData()).build();
            this.mRender = build;
            this.mRecorder = build;
        }
        this.mRecorder.initPreview(i, i2, i3 == 1);
        LiveBeautyFilterFragment.LiveFilterItem findLiveFilter = EffectController.getInstance().findLiveFilter(this.mActivity, DataRepository.dataItemLive().getLiveFilter());
        String str = "";
        setFilter(true, findLiveFilter != null ? findLiveFilter.directoryName : str);
        setRecordSpeed(Integer.valueOf(CameraSettings.getCurrentLiveSpeed()).intValue());
        String[] currentLiveMusic = CameraSettings.getCurrentLiveMusic();
        if (!currentLiveMusic[0].isEmpty()) {
            str = currentLiveMusic[0];
        }
        setAudioPath(str);
    }

    public void initResource() {
        Log.d(this.TAG, "initResource");
        if (!FileUtils.hasDir(FileUtils.ROOT_DIR) || !FileUtils.makeSureNoMedia(FileUtils.RESOURCE_DIR)) {
            FileUtils.makeNoMediaDir(FileUtils.RESOURCE_DIR);
            FileUtils.makeNoMediaDir(FileUtils.VIDEO_TMP);
            FileUtils.makeNoMediaDir(FileUtils.MUSIC_LOCAL);
            FileUtils.makeNoMediaDir(FileUtils.MUSIC_ONLINE);
            FileUtils.makeNoMediaDir(FileUtils.ROOT_DIR);
        }
    }

    public boolean isRecording() {
        return getCurState() == 2;
    }

    public boolean isRecordingPaused() {
        return getCurState() == 3;
    }

    public boolean onBackPressed() {
        return false;
    }

    public void onOrientationChanged(int i, int i2, int i3) {
        if (this.mCurrentOrientation != i2 && !isRecording()) {
            this.mCurrentOrientation = i2;
        }
    }

    public boolean onPreviewFrame(Image image, Camera2Proxy camera2Proxy, int i) {
        return true;
    }

    public void onStateChange(int i) {
        this.mRecordState = i;
        int i2 = this.mRecordState;
        if (i2 == 3) {
            this.mUIHandler.post(new v(this));
        } else if (i2 == 8) {
            this.mUIHandler.post(new w(this));
        } else if (i2 == 9) {
            this.mUIHandler.post(new x(this));
        }
    }

    public void onSurfaceTextureReleased() {
        SurfaceTextureScreenNail.SurfaceTextureScreenNailCallback surfaceTextureScreenNailCallback = this.mRender;
        if (surfaceTextureScreenNailCallback != null) {
            surfaceTextureScreenNailCallback.onSurfaceTextureReleased();
        }
    }

    public void onSurfaceTextureUpdated(DrawExtTexAttribute drawExtTexAttribute) {
        SurfaceTextureScreenNail.SurfaceTextureScreenNailCallback surfaceTextureScreenNailCallback = this.mRender;
        if (surfaceTextureScreenNailCallback != null) {
            surfaceTextureScreenNailCallback.onSurfaceTextureUpdated(drawExtTexAttribute);
        }
    }

    public void pauseRecording() {
        ILive.ILiveRecorder iLiveRecorder = this.mRecorder;
        if (iLiveRecorder != null) {
            iLiveRecorder.pauseRecording();
            abandomAudioFocus();
        }
    }

    public void prepare() {
        Log.d(this.TAG, "prepare");
        this.mUIHandler = new Handler(Looper.getMainLooper());
    }

    public void registerProtocol() {
        ModeCoordinatorImpl.getInstance().attachProtocol(241, this);
        ModeCoordinatorImpl.getInstance().attachProtocol(232, this);
        ModeCoordinatorImpl.getInstance().attachProtocol(243, this);
        ModeCoordinatorImpl.getInstance().attachProtocol(244, this);
        ModeCoordinatorImpl.getInstance().attachProtocol(211, this);
    }

    public void release() {
        String str = this.TAG;
        Log.d(str, "release " + this.mRecorder.getLiveSegments().size());
        ILive.ILiveRecorder iLiveRecorder = this.mRecorder;
        if (iLiveRecorder != null) {
            iLiveRecorder.release();
        }
        Handler handler = this.mUIHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
    }

    public void resumeRecording() {
        if (this.mRecorder != null && isRecordingPaused()) {
            requestAudioFocus();
            this.mRecorder.resumeRecording();
        }
    }

    public void setAudioPath(String str) {
        this.mCurAudioPath = str;
        ILive.ILiveRecorder iLiveRecorder = this.mRecorder;
        if (iLiveRecorder != null) {
            iLiveRecorder.setAudioPath(str);
        }
    }

    public void setFilter(boolean z, String str) {
        if (!z || TextUtils.isEmpty(str)) {
            this.mFilterBitmapPath = "";
        } else {
            this.mFilterBitmapPath = FileUtils.FILTER_DIR + str + File.separator + str + File.separator + str + FileUtils.FILTER_FILE_SUFFIX;
        }
        ILive.ILiveRecorder iLiveRecorder = this.mRecorder;
        if (iLiveRecorder != null) {
            iLiveRecorder.setFilterPath(this.mFilterBitmapPath);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARNING: Removed duplicated region for block: B:9:? A[RETURN, SYNTHETIC] */
    public void setRecordSpeed(int i) {
        ILive.ILiveRecorder iLiveRecorder;
        if (i >= 0) {
            float[] fArr = this.SPEEDS;
            if (i < fArr.length) {
                this.mCurSpeed = fArr[i];
                iLiveRecorder = this.mRecorder;
                if (iLiveRecorder == null) {
                    iLiveRecorder.setSpeed(this.mCurSpeed);
                    return;
                }
                return;
            }
        }
        this.mCurSpeed = 1.0f;
        iLiveRecorder = this.mRecorder;
        if (iLiveRecorder == null) {
        }
    }

    public void setRecorderListener(ModeProtocol.MiLiveRecorderControl.IRecorderListener iRecorderListener) {
        this.mRecorderListener = iRecorderListener;
    }

    public void startRecording() {
        if (this.mRecorder != null && !isRecording()) {
            FileUtils.deleteSubFiles(FileUtils.VIDEO_TMP);
            requestAudioFocus();
            this.mRecorder.setOrientation((this.mCurrentOrientation + 90) % 360);
            this.mRecorder.startRecording();
        }
    }

    public void stopRecording() {
        ILive.ILiveRecorder iLiveRecorder = this.mRecorder;
        if (iLiveRecorder != null) {
            iLiveRecorder.stopRecording();
            abandomAudioFocus();
        }
    }

    public void trackVideoParams() {
    }

    public void unRegisterProtocol() {
        ModeCoordinatorImpl.getInstance().detachProtocol(211, this);
        ModeCoordinatorImpl.getInstance().detachProtocol(244, this);
        ModeCoordinatorImpl.getInstance().detachProtocol(243, this);
        ModeCoordinatorImpl.getInstance().detachProtocol(232, this);
        ModeCoordinatorImpl.getInstance().detachProtocol(241, this);
        release();
    }
}
