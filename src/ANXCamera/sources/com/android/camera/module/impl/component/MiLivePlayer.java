package com.android.camera.module.impl.component;

import android.graphics.SurfaceTexture;
import android.text.TextUtils;
import android.view.Surface;
import com.android.camera.log.Log;
import com.android.camera.module.impl.component.ILive;
import com.xiaomi.recordmediaprocess.EffectMediaPlayer;
import com.xiaomi.recordmediaprocess.EffectNotifier;
import com.xiaomi.recordmediaprocess.MediaComposeFile;
import com.xiaomi.recordmediaprocess.MediaEffectGraph;
import java.util.Arrays;
import java.util.List;

public class MiLivePlayer implements ILive.ILivePlayer {
    private static final int DEFAULT_FPS = 30;
    private static final int DEFAULT_TARGET_BITRATE = 31457280;
    /* access modifiers changed from: private */
    public static final String TAG = "MiLivePlayer";
    private String mAudioPath;
    private EffectNotifier mComposeNotifier = new EffectNotifier() {
        public void OnReceiveFailed() {
            Log.d(MiLivePlayer.TAG, "Compose notifier OnReceiveFailed");
            MiLivePlayer.this.setComposeState(-1);
        }

        public void OnReceiveFinish() {
            Log.d(MiLivePlayer.TAG, "Compose notifier OnReceiveFinish");
            MiLivePlayer.this.setComposeState(3);
        }
    };
    private int mComposeState = 0;
    private EffectMediaPlayer mEffectMediaPlayer;
    private MediaComposeFile mMediaComposeFile;
    private MediaEffectGraph mMediaEffectGraph;
    private EffectNotifier mPlayerNotifier = new EffectNotifier() {
        public void OnReceiveFailed() {
            Log.d(MiLivePlayer.TAG, "player notifier OnReceiveFailed");
            MiLivePlayer.this.setPlayerState(-1);
        }

        public void OnReceiveFinish() {
            Log.d(MiLivePlayer.TAG, "player notifier OnReceiveFinish");
        }
    };
    private int mPlayerState = 0;
    private List<ILive.ILiveSegmentData> mSegmentData;
    private ILive.ILivePlayerStateListener mStateListener;
    private int mVideoHeight;
    private int mVideoWidth;

    private String getComposeStateString(int i) {
        return i != -1 ? i != 0 ? i != 1 ? i != 2 ? i != 3 ? "UNKNOWN" : "COMPOSED" : "PENDING_COMPOSE" : "CREATED" : "IDLE" : "ERROR";
    }

    private String getPlayerStateString(int i) {
        return i != -1 ? i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? "UNKNOWN" : "PAUSE" : "PREVIEWING" : "PENDING_START" : "CREATED" : "IDLE" : "ERROR";
    }

    private void initEffectGraph() {
        List<ILive.ILiveSegmentData> list = this.mSegmentData;
        if (list == null || list.size() <= 0) {
            throw new IllegalStateException("Segment data is empty.");
        }
        String str = TAG;
        Log.d(str, "initEffectGraph mSegmentData = " + Arrays.toString(this.mSegmentData.toArray()));
        String[] strArr = new String[this.mSegmentData.size()];
        float[] fArr = new float[this.mSegmentData.size()];
        for (int i = 0; i < this.mSegmentData.size(); i++) {
            strArr[i] = this.mSegmentData.get(i).getPath();
            fArr[i] = this.mSegmentData.get(i).getSpeed();
        }
        this.mMediaEffectGraph = new MediaEffectGraph();
        this.mMediaEffectGraph.ConstructMediaEffectGraph();
        this.mMediaEffectGraph.AddSourcesAndEffectBySourcesPath(strArr, fArr);
        if (!TextUtils.isEmpty(this.mAudioPath)) {
            this.mMediaEffectGraph.SetAudioMute(true);
            this.mMediaEffectGraph.AddAudioTrack(this.mAudioPath, false);
        }
    }

    private void initMediaCompose(String str) {
        if (this.mMediaComposeFile == null) {
            this.mMediaComposeFile = new MediaComposeFile(this.mMediaEffectGraph);
            this.mMediaComposeFile.ConstructMediaComposeFile(this.mVideoWidth, this.mVideoHeight, DEFAULT_TARGET_BITRATE, 30, this.mComposeNotifier);
        }
        this.mMediaComposeFile.SetComposeFileName(str);
        setComposeState(1);
    }

    private void initMediaPlayer(int i, int i2) {
        if (this.mVideoHeight <= 0 || this.mVideoWidth <= 0) {
            Log.e(TAG, "invalid video size.");
            return;
        }
        if (this.mEffectMediaPlayer == null) {
            this.mEffectMediaPlayer = new EffectMediaPlayer(this.mMediaEffectGraph);
            this.mEffectMediaPlayer.ConstructMediaPlayer();
            this.mEffectMediaPlayer.SetPlayerNotify(this.mPlayerNotifier);
            this.mEffectMediaPlayer.SetPlayLoop(true);
            this.mEffectMediaPlayer.setGravity(EffectMediaPlayer.SurfaceGravity.SurfaceGravityResizeAspectFit, i, i2);
            this.mEffectMediaPlayer.SetGraphLoop(true);
            this.mEffectMediaPlayer.EnableUserAdjustRotatePlay(true);
            Log.d(TAG, "initMediaPlayer");
        }
        setPlayerState(1);
    }

    private void releaseComposeFile() {
        MediaComposeFile mediaComposeFile = this.mMediaComposeFile;
        if (mediaComposeFile != null) {
            mediaComposeFile.DestructMediaComposeFile();
            this.mMediaComposeFile = null;
        }
    }

    private void releaseEffectGraph() {
        MediaEffectGraph mediaEffectGraph = this.mMediaEffectGraph;
        if (mediaEffectGraph != null) {
            mediaEffectGraph.DestructMediaEffectGraph();
            this.mMediaEffectGraph = null;
        }
    }

    private void releasePlayer() {
        EffectMediaPlayer effectMediaPlayer = this.mEffectMediaPlayer;
        if (effectMediaPlayer != null) {
            effectMediaPlayer.DestructMediaPlayer();
            this.mEffectMediaPlayer = null;
        }
    }

    /* access modifiers changed from: private */
    public void setComposeState(int i) {
        if (this.mComposeState != i) {
            String str = TAG;
            Log.d(str, "ComposeState state change from " + getComposeStateString(this.mComposeState) + " to " + getComposeStateString(i));
            this.mComposeState = i;
            ILive.ILivePlayerStateListener iLivePlayerStateListener = this.mStateListener;
            if (iLivePlayerStateListener != null) {
                iLivePlayerStateListener.onComposeStateChange(this.mComposeState);
            }
        }
    }

    /* access modifiers changed from: private */
    public void setPlayerState(int i) {
        if (this.mPlayerState != i) {
            String str = TAG;
            Log.d(str, "Player state change from " + getPlayerStateString(this.mPlayerState) + " to " + getPlayerStateString(i));
            this.mPlayerState = i;
            ILive.ILivePlayerStateListener iLivePlayerStateListener = this.mStateListener;
            if (iLivePlayerStateListener != null) {
                iLivePlayerStateListener.onPlayStateChange(this.mPlayerState);
            }
        }
    }

    public void cancelCompose() {
        if (this.mComposeState == 2) {
            this.mMediaComposeFile.CancelCompose();
        }
        release();
    }

    public void init(int i, int i2, List<ILive.ILiveSegmentData> list, String str) {
        String str2 = TAG;
        Log.d(str2, "init size = " + i + "x" + i2 + ", data = " + Arrays.toString(list.toArray()) + ", audioPath = " + str);
        this.mVideoWidth = Math.max(i, i2);
        this.mVideoHeight = Math.min(i, i2);
        this.mSegmentData = list;
        this.mAudioPath = str;
    }

    public void pausePlayer() {
        if (this.mPlayerState == 3) {
            this.mEffectMediaPlayer.PausePreView();
            setPlayerState(4);
        }
    }

    public void release() {
        releasePlayer();
        releaseComposeFile();
        releaseEffectGraph();
        reset();
    }

    public void reset() {
        setPlayerState(0);
        setComposeState(0);
    }

    public void resumePlayer() {
        if (this.mPlayerState == 4) {
            this.mEffectMediaPlayer.ResumePreView();
            setPlayerState(3);
        }
    }

    public void setStateListener(ILive.ILivePlayerStateListener iLivePlayerStateListener) {
        this.mStateListener = iLivePlayerStateListener;
    }

    public void startCompose(String str) {
        String str2 = TAG;
        Log.d(str2, "startCompose path = " + str + ", state = " + getComposeStateString(this.mComposeState));
        if (this.mComposeState == 0 || this.mPlayerState == 4) {
            initEffectGraph();
            initMediaCompose(str);
            this.mMediaComposeFile.BeginCompose();
            setComposeState(2);
        }
    }

    public void startPlayer(SurfaceTexture surfaceTexture, int i, int i2) {
        String str = TAG;
        Log.d(str, "startPlayer state = " + getPlayerStateString(this.mPlayerState) + ",texture = " + surfaceTexture + ", size = " + i + "x" + i2);
        if (this.mPlayerState == 0) {
            initEffectGraph();
            initMediaPlayer(i, i2);
            this.mEffectMediaPlayer.SetViewSurface(new Surface(surfaceTexture));
            setPlayerState(2);
            this.mEffectMediaPlayer.StartPreView();
            setPlayerState(3);
        }
    }

    public void stopPlayer() {
        String str = TAG;
        Log.d(str, "stopPlayer state = " + getPlayerStateString(this.mPlayerState));
        int i = this.mPlayerState;
        if (i == 3 || i == 4) {
            this.mEffectMediaPlayer.StopPreView();
            release();
        }
    }
}
