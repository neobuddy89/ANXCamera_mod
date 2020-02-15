package org.webrtc.voiceengine;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Process;
import android.util.Log;
import com.ss.android.vesdk.VEEditor;
import java.nio.ByteBuffer;
import java.util.concurrent.locks.ReentrantLock;

class WebRtcAudioTrack {
    private AudioManager _audioManager;
    private AudioTrack _audioTrack = null;
    private int _bufferedPlaySamples = 0;
    private Context _context;
    private boolean _doPlayInit = true;
    private boolean _doRecInit = true;
    private boolean _isPlaying = false;
    private boolean _isRecording = false;
    private ByteBuffer _playBuffer;
    private final ReentrantLock _playLock = new ReentrantLock();
    private int _playPosition = 0;
    private byte[] _tempBufPlay;
    final String logTag = "WebRTC AD java";

    WebRtcAudioTrack() {
        try {
            this._playBuffer = ByteBuffer.allocateDirect(1920);
        } catch (Exception e2) {
            DoLog(e2.getMessage());
        }
        this._tempBufPlay = new byte[1920];
    }

    private void DoLog(String str) {
        Log.d("WebRTC AD java", str);
    }

    private void DoLogErr(String str) {
        Log.e("WebRTC AD java", str);
    }

    private int GetPlayoutVolume() {
        if (this._audioManager == null) {
            Context context = this._context;
            if (context != null) {
                this._audioManager = (AudioManager) context.getSystemService(VEEditor.MVConsts.TYPE_AUDIO);
            }
        }
        AudioManager audioManager = this._audioManager;
        if (audioManager != null) {
            return audioManager.getStreamVolume(0);
        }
        return -1;
    }

    private int InitPlayback(int i, int i2, int i3) {
        int minBufferSize = AudioTrack.getMinBufferSize(i, i2, 2);
        if (minBufferSize < 6000) {
            minBufferSize *= 2;
        }
        int i4 = minBufferSize;
        this._bufferedPlaySamples = 0;
        AudioTrack audioTrack = this._audioTrack;
        if (audioTrack != null) {
            audioTrack.release();
            this._audioTrack = null;
        }
        try {
            AudioTrack audioTrack2 = new AudioTrack(i3, i, i2, 2, i4, 1);
            this._audioTrack = audioTrack2;
            if (this._audioTrack.getState() != 1) {
                return -1;
            }
            if (this._audioManager == null) {
                Context context = this._context;
                if (context != null) {
                    this._audioManager = (AudioManager) context.getSystemService(VEEditor.MVConsts.TYPE_AUDIO);
                }
            }
            AudioManager audioManager = this._audioManager;
            if (audioManager == null) {
                return 0;
            }
            return audioManager.getStreamMaxVolume(i3);
        } catch (Exception e2) {
            DoLog(e2.getMessage());
            return -1;
        }
    }

    private int PlayAudio(int i) {
        int i2;
        this._playLock.lock();
        try {
            if (this._audioTrack == null) {
                i2 = -2;
            } else {
                if (this._doPlayInit) {
                    Process.setThreadPriority(-19);
                    this._doPlayInit = false;
                }
                this._playBuffer.get(this._tempBufPlay);
                int write = this._audioTrack.write(this._tempBufPlay, 0, i);
                this._playBuffer.rewind();
                this._bufferedPlaySamples += write >> 1;
                int playbackHeadPosition = this._audioTrack.getPlaybackHeadPosition();
                if (playbackHeadPosition < this._playPosition) {
                    this._playPosition = 0;
                }
                this._bufferedPlaySamples -= playbackHeadPosition - this._playPosition;
                this._playPosition = playbackHeadPosition;
                if (write != i) {
                    i2 = -1;
                } else {
                    this._playLock.unlock();
                    return this._bufferedPlaySamples;
                }
            }
        } catch (Exception e2) {
            DoLog("Set play thread priority failed: " + e2.getMessage());
        } catch (Throwable th) {
            this._playLock.unlock();
            throw th;
        }
        this._playLock.unlock();
        return i2;
    }

    private int SetPlayoutSpeaker(boolean z) {
        if (this._audioManager == null) {
            Context context = this._context;
            if (context != null) {
                this._audioManager = (AudioManager) context.getSystemService(VEEditor.MVConsts.TYPE_AUDIO);
            }
        }
        if (this._audioManager == null) {
            DoLogErr("Could not change audio routing - no audio manager");
            return -1;
        }
        int i = Build.VERSION.SDK_INT;
        if (3 == i || 4 == i) {
            if (z) {
                this._audioManager.setMode(0);
            } else {
                this._audioManager.setMode(2);
            }
        } else if ((!Build.BRAND.equals("Samsung") && !Build.BRAND.equals("samsung")) || (5 != i && 6 != i && 7 != i)) {
            this._audioManager.setSpeakerphoneOn(z);
        } else if (z) {
            this._audioManager.setMode(2);
            this._audioManager.setSpeakerphoneOn(z);
        } else {
            this._audioManager.setSpeakerphoneOn(z);
            this._audioManager.setMode(0);
        }
        return 0;
    }

    private int SetPlayoutVolume(int i) {
        if (this._audioManager == null) {
            Context context = this._context;
            if (context != null) {
                this._audioManager = (AudioManager) context.getSystemService(VEEditor.MVConsts.TYPE_AUDIO);
            }
        }
        AudioManager audioManager = this._audioManager;
        if (audioManager == null) {
            return -1;
        }
        audioManager.setStreamVolume(0, i, 0);
        return 0;
    }

    private int StartPlayback() {
        try {
            this._audioTrack.play();
            this._isPlaying = true;
            return 0;
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    private int StopPlayback() {
        this._playLock.lock();
        try {
            if (this._audioTrack.getPlayState() == 3) {
                this._audioTrack.stop();
                this._audioTrack.flush();
            }
            this._audioTrack.release();
            this._audioTrack = null;
            this._doPlayInit = true;
            this._playLock.unlock();
            this._isPlaying = false;
            return 0;
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            this._doPlayInit = true;
            this._playLock.unlock();
            return -1;
        } catch (Throwable th) {
            this._doPlayInit = true;
            this._playLock.unlock();
            throw th;
        }
    }
}
