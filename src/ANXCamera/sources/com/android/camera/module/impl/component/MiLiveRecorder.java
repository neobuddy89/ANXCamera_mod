package com.android.camera.module.impl.component;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.TextUtils;
import com.android.camera.ActivityBase;
import com.android.camera.SurfaceTextureScreenNail;
import com.android.camera.constant.GlobalConstant;
import com.android.camera.data.DataRepository;
import com.android.camera.effect.FrameBuffer;
import com.android.camera.effect.draw_mode.DrawExtTexAttribute;
import com.android.camera.effect.framework.gles.FrameTexture;
import com.android.camera.effect.framework.gles.FullFrameTexture;
import com.android.camera.effect.framework.gles.FullFramenOESTexture;
import com.android.camera.effect.framework.gles.OpenGlUtils;
import com.android.camera.log.Log;
import com.android.camera.module.impl.component.ILive;
import com.android.gallery3d.ui.GLCanvas;
import com.android.gallery3d.ui.GLCanvasImpl;
import com.android.gallery3d.ui.RawTexture;
import com.xiaomi.recordmediaprocess.EffectCameraNotifier;
import com.xiaomi.recordmediaprocess.MediaEffectCamera;
import com.xiaomi.recordmediaprocess.OpenGlRender;
import com.xiaomi.recordmediaprocess.SystemUtil;
import java.io.File;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.locks.ReentrantLock;

public class MiLiveRecorder implements ILive.ILiveRecorder, SurfaceTextureScreenNail.SurfaceTextureScreenNailCallback {
    /* access modifiers changed from: private */
    public final String TAG;
    private ActivityBase mActivity;
    private String mAudioPath;
    private int mBitrate;
    private EffectCameraNotifier mCameraNotifier;
    private CountDownTimer mCountDownTimer;
    /* access modifiers changed from: private */
    public float mCurSpeed;
    private int[] mDebugFrameBuffer;
    private boolean mDump;
    private String mFilterBitmapPath;
    private int mFps;
    private FrameBuffer mFrameBuffer;
    private int mFreq;
    private FrameTexture mFullFrameTexture;
    /* access modifiers changed from: private */
    public Handler mHandler;
    private int mIndex;
    /* access modifiers changed from: private */
    public int mLiveState;
    private long mMaxDuration;
    private MediaEffectCamera mMediaEffectCamera;
    private OpenGlRender mOpenGlRender;
    private RawTexture mRawTexture;
    private ILive.ILiveRecordingTimeListener mRecordingTimeListener;
    /* access modifiers changed from: private */
    public Stack<ILive.ILiveSegmentData> mSegments;
    private long mStartTime;
    private ILive.ILiveRecorderStateListener mStateListener;
    private final ReentrantLock mSurfaceLock;
    private int mVideoHeight;
    private String mVideoSaveDirPath;
    private int mVideoWidth;

    public static class Builder {
        /* access modifiers changed from: private */
        public ActivityBase mActivityBase;
        /* access modifiers changed from: private */
        public int mBitrate;
        /* access modifiers changed from: private */
        public int mFps;
        /* access modifiers changed from: private */
        public Handler mHandler;
        /* access modifiers changed from: private */
        public long mMaxDuration;
        /* access modifiers changed from: private */
        public ILive.ILiveRecordingTimeListener mRecordingTimeListener;
        /* access modifiers changed from: private */
        public List<ILive.ILiveSegmentData> mSegmentData;
        /* access modifiers changed from: private */
        public ILive.ILiveRecorderStateListener mStateListener;
        /* access modifiers changed from: private */
        public int mVideoHeight;
        /* access modifiers changed from: private */
        public String mVideoSaveDirPath;
        /* access modifiers changed from: private */
        public int mVideoWidth;

        public Builder(ActivityBase activityBase, int i, int i2) {
            this.mActivityBase = activityBase;
            this.mVideoWidth = i;
            this.mVideoHeight = i2;
        }

        public MiLiveRecorder build() {
            return new MiLiveRecorder(this);
        }

        public Builder setBitrate(int i) {
            this.mBitrate = i;
            return this;
        }

        public Builder setFps(int i) {
            this.mFps = i;
            return this;
        }

        public Builder setHandler(Handler handler) {
            this.mHandler = handler;
            return this;
        }

        public Builder setMaxDuration(long j) {
            this.mMaxDuration = j;
            return this;
        }

        public Builder setRecordingTimeListener(ILive.ILiveRecordingTimeListener iLiveRecordingTimeListener) {
            this.mRecordingTimeListener = iLiveRecordingTimeListener;
            return this;
        }

        public Builder setSegmentData(List<ILive.ILiveSegmentData> list) {
            this.mSegmentData = list;
            return this;
        }

        public Builder setStateListener(ILive.ILiveRecorderStateListener iLiveRecorderStateListener) {
            this.mStateListener = iLiveRecorderStateListener;
            return this;
        }

        public Builder setVideoSaveDirPath(String str) {
            this.mVideoSaveDirPath = str;
            return this;
        }
    }

    public static class MiLiveItem implements ILive.ILiveSegmentData {
        private long mDuration;
        private long mNextPos;
        private String mPath;
        private float mSpeed;

        public MiLiveItem(String str, long j, long j2, float f2) {
            this.mPath = str;
            this.mNextPos = j;
            this.mDuration = j2;
            this.mSpeed = f2;
        }

        public long getDuration() {
            return this.mDuration;
        }

        public long getNextPos() {
            return this.mNextPos;
        }

        public String getPath() {
            String str = this.mPath;
            return str == null ? "" : str;
        }

        public float getSpeed() {
            return this.mSpeed;
        }

        public String toString() {
            return "MiLiveItem{mPath='" + this.mPath + '\'' + ", mNextPos=" + this.mNextPos + ", mDuration=" + this.mDuration + ", mSpeed=" + this.mSpeed + '}';
        }
    }

    private MiLiveRecorder(Builder builder) {
        this.TAG = MiLiveRecorder.class.getSimpleName() + "@" + hashCode();
        this.mSegments = new Stack<>();
        this.mLiveState = 0;
        this.mSurfaceLock = new ReentrantLock();
        this.mCameraNotifier = new EffectCameraNotifier() {
            public void OnNeedStopRecording() {
                if (MiLiveRecorder.this.mHandler != null) {
                    Log.d(MiLiveRecorder.this.TAG, "OnNeedStopRecording");
                    MiLiveRecorder.this.mHandler.post(new y(this));
                    return;
                }
                Log.d(MiLiveRecorder.this.TAG, "OnNeedStopRecording fail~");
            }

            public void OnNotifyRender() {
                Log.d(MiLiveRecorder.this.TAG, "OnNotifyRender");
            }

            public void OnRecordFailed() {
                Log.d(MiLiveRecorder.this.TAG, "OnRecordFailed");
                MiLiveRecorder.this.setLiveState(9);
            }

            public void OnRecordFinish(String str) {
            }

            public void OnRecordFinish(String str, long j, long j2) {
                if (j2 > 500 || j2 < 0) {
                    Stack access$1300 = MiLiveRecorder.this.mSegments;
                    MiLiveItem miLiveItem = new MiLiveItem(str, j, j2, MiLiveRecorder.this.mCurSpeed);
                    access$1300.push(miLiveItem);
                } else {
                    String access$1100 = MiLiveRecorder.this.TAG;
                    Log.d(access$1100, "recording time = " + j2 + ", it's too short");
                }
                String access$11002 = MiLiveRecorder.this.TAG;
                Log.d(access$11002, "OnRecordFinish path = " + str + ", nextPos = " + j + ", count = " + MiLiveRecorder.this.mSegments.size() + ", segments = " + Arrays.toString(MiLiveRecorder.this.mSegments.toArray()));
                DataRepository.dataItemLive().setMiLiveSegmentData(MiLiveRecorder.this.getLiveSegments());
                if (MiLiveRecorder.this.mLiveState == 6) {
                    MiLiveRecorder.this.setLiveState(3);
                } else if (MiLiveRecorder.this.mLiveState != 5) {
                } else {
                    if (MiLiveRecorder.this.mSegments.isEmpty()) {
                        MiLiveRecorder.this.setLiveState(1);
                    } else {
                        MiLiveRecorder.this.setLiveState(8);
                    }
                }
            }

            public /* synthetic */ void gf() {
                MiLiveRecorder.this.stopRecording();
            }
        };
        this.mDebugFrameBuffer = new int[1];
        this.mDump = false;
        this.mIndex = 0;
        this.mFreq = 30;
        this.mActivity = builder.mActivityBase;
        this.mVideoWidth = Math.max(builder.mVideoWidth, builder.mVideoHeight);
        this.mVideoHeight = Math.min(builder.mVideoWidth, builder.mVideoHeight);
        this.mBitrate = builder.mBitrate;
        this.mFps = builder.mFps;
        this.mVideoSaveDirPath = builder.mVideoSaveDirPath;
        this.mMaxDuration = builder.mMaxDuration;
        this.mStateListener = builder.mStateListener;
        this.mRecordingTimeListener = builder.mRecordingTimeListener;
        this.mHandler = builder.mHandler;
        if (builder.mSegmentData != null) {
            this.mSegments.addAll(builder.mSegmentData);
        }
        String str = this.TAG;
        Log.d(str, "MiLiveRecorder mSegments" + Arrays.toString(this.mSegments.toArray()));
        initMediaCamera();
    }

    private void clearAllSegments() {
        while (!this.mSegments.empty()) {
            File file = new File(this.mSegments.pop().getPath());
            if (file.exists() && file.isFile()) {
                file.delete();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a8  */
    private void dump(int i, int i2, long j, int i3, int i4) {
        int i5;
        int i6;
        boolean z;
        int i7 = i2;
        if (this.mDump) {
            this.mIndex++;
            this.mIndex %= this.mFreq;
            if (this.mIndex == 0) {
                Log.d(this.TAG, "dump  = " + this.mIndex);
                if (i7 == 3553) {
                    if (!(this.mFullFrameTexture instanceof FullFrameTexture)) {
                        this.mFullFrameTexture = new FullFrameTexture();
                        i6 = i3;
                        i5 = i4;
                    }
                    i6 = i3;
                    i5 = i4;
                    z = true;
                    if (!z) {
                    }
                    if (!FileUtils.hasDir(FileUtils.VIDEO_DUMP)) {
                    }
                    GLES20.glBindFramebuffer(36160, this.mDebugFrameBuffer[0]);
                    GLES20.glViewport(0, 0, i6, i5);
                    this.mFullFrameTexture.draw(i);
                    String valueOf = String.valueOf(j);
                    OpenGlUtils.dumpToJpg(0, 0, i6, i5, FileUtils.VIDEO_DUMP + valueOf + "dump.jpg");
                    GLES20.glBindFramebuffer(36160, 0);
                } else if (i7 == 36197) {
                    if (!(this.mFullFrameTexture instanceof FullFramenOESTexture)) {
                        this.mFullFrameTexture = new FullFramenOESTexture();
                        i5 = i3;
                        i6 = i4;
                    }
                    i6 = i3;
                    i5 = i4;
                    z = true;
                    if (!z) {
                        int[] iArr = new int[1];
                        GLES20.glGenTextures(1, iArr, 0);
                        GLES20.glBindTexture(3553, iArr[0]);
                        GLES20.glTexImage2D(3553, 0, 6408, i3, i4, 0, 6408, 5121, (Buffer) null);
                        GLES20.glGenFramebuffers(1, this.mDebugFrameBuffer, 0);
                        GLES20.glBindFramebuffer(36160, this.mDebugFrameBuffer[0]);
                        GLES20.glFramebufferTexture2D(36160, 36064, 3553, iArr[0], 0);
                        GLES20.glBindFramebuffer(36160, 0);
                    }
                    if (!FileUtils.hasDir(FileUtils.VIDEO_DUMP)) {
                        FileUtils.makeNoMediaDir(FileUtils.VIDEO_DUMP);
                    }
                    GLES20.glBindFramebuffer(36160, this.mDebugFrameBuffer[0]);
                    GLES20.glViewport(0, 0, i6, i5);
                    this.mFullFrameTexture.draw(i);
                    String valueOf2 = String.valueOf(j);
                    OpenGlUtils.dumpToJpg(0, 0, i6, i5, FileUtils.VIDEO_DUMP + valueOf2 + "dump.jpg");
                    GLES20.glBindFramebuffer(36160, 0);
                } else {
                    return;
                }
                z = false;
                if (!z) {
                }
                if (!FileUtils.hasDir(FileUtils.VIDEO_DUMP)) {
                }
                GLES20.glBindFramebuffer(36160, this.mDebugFrameBuffer[0]);
                GLES20.glViewport(0, 0, i6, i5);
                this.mFullFrameTexture.draw(i);
                String valueOf22 = String.valueOf(j);
                OpenGlUtils.dumpToJpg(0, 0, i6, i5, FileUtils.VIDEO_DUMP + valueOf22 + "dump.jpg");
                GLES20.glBindFramebuffer(36160, 0);
            }
        }
    }

    private long getNextAudioPos() {
        ILive.ILiveSegmentData peek = this.mSegments.peek();
        if (peek != null) {
            return peek.getNextPos();
        }
        return 0;
    }

    private String getStateString(int i) {
        switch (i) {
            case 0:
                return "IDLE";
            case 1:
                return "PREVIEWING";
            case 2:
                return "RECORDING";
            case 3:
                return "RECORDING_PAUSED";
            case 4:
                return "PENDING_START_RECORDING";
            case 5:
                return "PENDING_STOP_RECORDING";
            case 6:
                return "PENDING_PAUSE_RECORDING";
            case 7:
                return "PENDING_RESUME_RECORDING";
            case 8:
                return "RECORDING_DONE";
            case 9:
                return "RECORDING_ERROR";
            default:
                return "UNKNOWN";
        }
    }

    private void initMediaCamera() {
        if (this.mVideoHeight <= 0 || this.mVideoWidth <= 0) {
            Log.e(this.TAG, "invalid video size.");
            return;
        }
        System.loadLibrary("vvc++_shared");
        System.loadLibrary("ffmpeg");
        System.loadLibrary("record_video");
        SystemUtil.Init(this.mActivity.getApplicationContext(), 50011);
        if (this.mMediaEffectCamera == null) {
            this.mMediaEffectCamera = new MediaEffectCamera();
            String str = this.TAG;
            Log.e(str, "ConstructMediaEffectCamera size = " + this.mVideoWidth + "x" + this.mVideoHeight);
            this.mMediaEffectCamera.ConstructMediaEffectCamera(this.mVideoWidth, this.mVideoHeight, this.mBitrate, this.mFps, this.mCameraNotifier);
        }
    }

    /* access modifiers changed from: private */
    public void setLiveState(int i) {
        if (i != this.mLiveState) {
            String str = this.TAG;
            Log.d(str, "live state change from " + getStateString(this.mLiveState) + " to " + getStateString(i));
            this.mLiveState = i;
            ILive.ILiveRecorderStateListener iLiveRecorderStateListener = this.mStateListener;
            if (iLiveRecorderStateListener != null) {
                iLiveRecorderStateListener.onStateChange(this.mLiveState);
            }
        }
    }

    private void startRecordingTime(ILive.ILiveRecordingTimeListener iLiveRecordingTimeListener) {
        if (this.mLiveState == 2) {
            CountDownTimer countDownTimer = this.mCountDownTimer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            float f2 = this.mCurSpeed;
            long totolDuration = (long) (((float) (this.mMaxDuration - ILive.getTotolDuration(this.mSegments))) * f2);
            final ILive.ILiveRecordingTimeListener iLiveRecordingTimeListener2 = iLiveRecordingTimeListener;
            AnonymousClass2 r2 = new CountDownTimer(totolDuration, (long) (f2 * 1000.0f)) {
                public void onFinish() {
                    if (MiLiveRecorder.this.mLiveState == 2) {
                        Log.d(MiLiveRecorder.this.TAG, "count down onFinish~");
                        ILive.ILiveRecordingTimeListener iLiveRecordingTimeListener = iLiveRecordingTimeListener2;
                        if (iLiveRecordingTimeListener != null) {
                            iLiveRecordingTimeListener.onRecordingTimeFinish();
                        }
                    }
                }

                public void onTick(long j) {
                    if (MiLiveRecorder.this.mLiveState == 2) {
                        ILive.ILiveRecordingTimeListener iLiveRecordingTimeListener = iLiveRecordingTimeListener2;
                        if (iLiveRecordingTimeListener != null) {
                            iLiveRecordingTimeListener.onRecordingTimeUpdate(j, MiLiveRecorder.this.mCurSpeed);
                        }
                    }
                }
            };
            this.mCountDownTimer = r2;
            this.mStartTime = System.currentTimeMillis();
            this.mCountDownTimer.start();
            String str = this.TAG;
            Log.d(str, "startRecordingTime " + totolDuration);
        }
    }

    public void deletePreSegment() {
        if (this.mLiveState == 3 && !this.mSegments.empty()) {
            ILive.ILiveSegmentData pop = this.mSegments.pop();
            long totolDuration = ILive.getTotolDuration(this.mSegments);
            ILive.ILiveRecordingTimeListener iLiveRecordingTimeListener = this.mRecordingTimeListener;
            if (iLiveRecordingTimeListener != null) {
                iLiveRecordingTimeListener.onRecordingTimeUpdate(Math.min(this.mMaxDuration - totolDuration, 15400), 1.0f);
            }
            String str = this.TAG;
            Log.d(str, "deletePreSegment = " + this.mSegments.size());
            if (!TextUtils.isEmpty(pop.getPath())) {
                File file = new File(pop.getPath());
                if (file.exists() && file.isFile()) {
                    file.delete();
                }
            }
        }
    }

    public SurfaceTexture genInputSurfaceTexture() {
        setLiveState(0);
        return null;
    }

    public String getAudioPath() {
        return this.mAudioPath;
    }

    public List<ILive.ILiveSegmentData> getLiveSegments() {
        return this.mSegments;
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public /* synthetic */ void hf() {
        try {
            this.mSurfaceLock.lock();
            Log.d(this.TAG, "release");
            if (this.mMediaEffectCamera != null) {
                this.mMediaEffectCamera.DestructMediaEffectCamera();
                this.mMediaEffectCamera = null;
            }
            setLiveState(0);
            SystemUtil.UnInit();
        } finally {
            this.mSurfaceLock.unlock();
        }
    }

    public void initPreview(int i, int i2, boolean z) {
        String str = this.TAG;
        Log.d(str, "initPreview size " + i + "x" + i2 + ", facing =" + z);
    }

    public void onSurfaceTextureCreated(SurfaceTexture surfaceTexture) {
    }

    public void onSurfaceTextureReleased() {
        RawTexture rawTexture = this.mRawTexture;
        if (rawTexture != null) {
            rawTexture.recycle();
            this.mRawTexture = null;
        }
        FrameBuffer frameBuffer = this.mFrameBuffer;
        if (frameBuffer != null) {
            frameBuffer.delete();
            this.mFrameBuffer = null;
        }
        FrameTexture frameTexture = this.mFullFrameTexture;
        if (frameTexture != null) {
            frameTexture.release();
            this.mFullFrameTexture = null;
        }
    }

    public void onSurfaceTextureUpdated(DrawExtTexAttribute drawExtTexAttribute) {
        try {
            this.mSurfaceLock.lock();
            if (!(this.mActivity.getCameraScreenNail() == null || this.mActivity.getCameraScreenNail().getExtTexture() == null)) {
                if (drawExtTexAttribute != null) {
                    if (this.mRawTexture == null) {
                        String str = this.TAG;
                        Log.d(str, "onSurfaceTextureUpdated , video size = " + this.mVideoWidth + "x" + this.mVideoHeight + ", attribute = " + drawExtTexAttribute);
                        this.mRawTexture = new RawTexture(drawExtTexAttribute.mHeight, drawExtTexAttribute.mWidth, true);
                    }
                    if (this.mFrameBuffer == null) {
                        this.mFrameBuffer = new FrameBuffer((GLCanvas) this.mActivity.getGLView().getGLCanvas(), this.mRawTexture, 0);
                    }
                    if (this.mOpenGlRender == null) {
                        this.mOpenGlRender = new OpenGlRender();
                        this.mOpenGlRender.SetCurrentGLContext(this.mRawTexture.getId());
                    }
                    if (this.mLiveState == 0) {
                        if (this.mSegments.isEmpty()) {
                            setLiveState(1);
                        } else {
                            setLiveState(3);
                        }
                    }
                    if (this.mLiveState == 2) {
                        GLCanvasImpl gLCanvas = this.mActivity.getGLView().getGLCanvas();
                        gLCanvas.beginBindFrameBuffer(this.mFrameBuffer);
                        gLCanvas.getState().pushState();
                        gLCanvas.getState().translate(((float) drawExtTexAttribute.mWidth) / 2.0f, ((float) drawExtTexAttribute.mHeight) / 2.0f);
                        gLCanvas.getState().scale(1.0f, -1.0f, 1.0f);
                        gLCanvas.getState().rotate(-90.0f, 0.0f, 0.0f, 1.0f);
                        gLCanvas.getState().translate(((float) (-drawExtTexAttribute.mHeight)) / 2.0f, ((float) (-drawExtTexAttribute.mWidth)) / 2.0f);
                        gLCanvas.getState().translate((float) drawExtTexAttribute.mX, (float) (-drawExtTexAttribute.mY));
                        gLCanvas.draw(drawExtTexAttribute);
                        gLCanvas.getState().popState();
                        gLCanvas.endBindFrameBuffer();
                        this.mMediaEffectCamera.NeedProcessTexture(this.mActivity.getCameraScreenNail().getSurfaceTexture().getTimestamp() / 1000000, this.mRawTexture.getWidth(), this.mRawTexture.getHeight());
                    }
                    this.mSurfaceLock.unlock();
                }
            }
        } finally {
            this.mSurfaceLock.unlock();
        }
    }

    public void pauseRecording() {
        if (this.mLiveState == 2) {
            Log.d(this.TAG, "pauseRecording");
            CountDownTimer countDownTimer = this.mCountDownTimer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            setLiveState(6);
            this.mMediaEffectCamera.StopRecording();
        }
    }

    public void release() {
        GlobalConstant.sCameraSetupScheduler.scheduleDirect(new z(this));
    }

    public void resumeRecording() {
        if (this.mLiveState == 3 && this.mVideoSaveDirPath != null && this.mFilterBitmapPath != null && this.mAudioPath != null) {
            String str = this.TAG;
            Log.d(str, "resumeRecording path = " + this.mVideoSaveDirPath + ",mFilterBitmapPath = " + this.mFilterBitmapPath + ",mAudioPath = " + this.mAudioPath + ",mCurSpeed = " + this.mCurSpeed);
            setLiveState(7);
            long totolDuration = this.mMaxDuration - ILive.getTotolDuration(this.mSegments);
            if (totolDuration < 0) {
                String str2 = this.TAG;
                Log.w(str2, "resumeRecording error,last duration : " + totolDuration);
            }
            this.mMediaEffectCamera.StartRecording(this.mVideoSaveDirPath, this.mFilterBitmapPath, this.mAudioPath, getNextAudioPos(), this.mCurSpeed, totolDuration < 500 ? 500 : totolDuration);
            setLiveState(2);
            startRecordingTime(this.mRecordingTimeListener);
        }
    }

    public void setAudioPath(String str) {
        String str2 = this.TAG;
        Log.d(str2, "setAudioPath = " + str);
        this.mAudioPath = str;
    }

    public void setFilterPath(String str) {
        String str2 = this.TAG;
        Log.d(str2, "setFilterPath = " + str);
        this.mFilterBitmapPath = str;
    }

    public void setOrientation(int i) {
        MediaEffectCamera mediaEffectCamera = this.mMediaEffectCamera;
        if (mediaEffectCamera != null) {
            mediaEffectCamera.SetOrientation(i);
        }
    }

    public void setSpeed(float f2) {
        String str = this.TAG;
        Log.d(str, "setSpeed = " + f2);
        this.mCurSpeed = f2;
    }

    public void startRecording() {
        int i = this.mLiveState;
        if ((i == 1 || i == 8) && this.mVideoSaveDirPath != null && this.mFilterBitmapPath != null && this.mAudioPath != null) {
            String str = this.TAG;
            Log.d(str, "startRecording path = " + this.mVideoSaveDirPath + ",mFilterBitmapPath = " + this.mFilterBitmapPath + ",mAudioPath = " + this.mAudioPath + ",mCurSpeed = " + this.mCurSpeed);
            this.mSegments.clear();
            setLiveState(4);
            this.mMediaEffectCamera.StartRecording(this.mVideoSaveDirPath, this.mFilterBitmapPath, this.mAudioPath, 0, this.mCurSpeed, this.mMaxDuration);
            setLiveState(2);
            startRecordingTime(this.mRecordingTimeListener);
        }
    }

    public void stopRecording() {
        int i = this.mLiveState;
        if (i == 2 || i == 3) {
            Log.d(this.TAG, "stopRecording");
            CountDownTimer countDownTimer = this.mCountDownTimer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            if (this.mLiveState == 2) {
                setLiveState(5);
                this.mMediaEffectCamera.StopRecording();
            } else if (this.mSegments.isEmpty()) {
                setLiveState(1);
            } else {
                setLiveState(8);
            }
        }
    }
}
