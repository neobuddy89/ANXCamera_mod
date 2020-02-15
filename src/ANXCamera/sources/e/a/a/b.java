package e.a.a;

import android.media.AudioRecord;
import android.util.Log;
import com.android.camera.fragment.subtitle.recog.record.PcmRecorder;
import com.android.camera.module.BaseModule;
import com.ss.android.medialib.audio.AudioDataProcessThread;
import com.ss.android.medialib.common.LogUtil;
import com.ss.android.vesdk.VELogUtil;

/* compiled from: BufferedAudioRecorder */
public class b {
    private static final String TAG = "BufferedAudioRecorder";
    protected static int channelConfigOffset = -1;
    protected static int[] channelConfigSuggested = {12, 16, 1};
    protected static int sampleRateOffset = -1;
    protected static int[] sampleRateSuggested = {44100, BaseModule.LENS_DIRTY_DETECT_HINT_DURATION_8S, 11025, PcmRecorder.RATE16K, 22050};
    AudioRecord audio;
    int audioFormat = 2;
    int bufferSizeInBytes = 0;
    int channelConfig = -1;
    AudioDataProcessThread iq;
    boolean isRecording = false;
    a jq;
    boolean kq = false;
    int lq = 1;
    int sampleRateInHz = -1;

    /* compiled from: BufferedAudioRecorder */
    private class a implements Runnable {
        boolean hq;
        private double speed;

        public a(double d2, boolean z) {
            this.speed = d2;
            this.hq = z;
        }

        public void run() {
            boolean z;
            b bVar = b.this;
            byte[] bArr = new byte[bVar.bufferSizeInBytes];
            bVar.kq = false;
            a aVar = bVar.jq;
            bVar.iq = new AudioDataProcessThread(aVar, aVar);
            b.this.iq.start();
            if (this.hq) {
                b bVar2 = b.this;
                bVar2.iq.startFeeding(bVar2.sampleRateInHz, this.speed);
            }
            try {
                if (b.this.audio != null) {
                    b.this.audio.startRecording();
                    if (b.this.audio == null || b.this.audio.getRecordingState() == 3) {
                        z = false;
                    } else {
                        b.this.jq.recordStatus(false);
                        z = true;
                    }
                    boolean z2 = z;
                    int i = 0;
                    while (true) {
                        b bVar3 = b.this;
                        if (bVar3.isRecording) {
                            AudioRecord audioRecord = bVar3.audio;
                            if (audioRecord != null) {
                                i = audioRecord.read(bArr, 0, bVar3.bufferSizeInBytes);
                            }
                            if (-3 == i) {
                                VELogUtil.e(b.TAG, "bad audio buffer len " + i);
                            } else if (i > 0) {
                                try {
                                    if (b.this.isRecording) {
                                        b.this.jq.addPCMData(bArr, i);
                                    }
                                    if (b.this.iq.isProcessing() && !b.this.kq) {
                                        b.this.iq.feed(bArr, i);
                                    }
                                } catch (Exception unused) {
                                }
                            } else {
                                AudioRecord audioRecord2 = b.this.audio;
                                if (!(audioRecord2 == null || audioRecord2.getRecordingState() == 3 || z2)) {
                                    b.this.jq.recordStatus(false);
                                    z2 = true;
                                }
                                Thread.sleep(50);
                            }
                        } else {
                            return;
                        }
                    }
                }
            } catch (Exception e2) {
                try {
                    if (b.this.audio != null) {
                        b.this.audio.release();
                    }
                } catch (Exception unused2) {
                }
                b.this.audio = null;
                VELogUtil.e(b.TAG, "audio recording failed!" + e2);
            }
        }
    }

    public b(a aVar) {
        this.jq = aVar;
    }

    public int O(int i) {
        return 16 == i ? 1 : 2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0019, code lost:
        return;
     */
    public void a(double d2, boolean z) {
        VELogUtil.i(TAG, "startRecording() called");
        synchronized (this) {
            if (this.isRecording) {
                VELogUtil.w(TAG, "recorder is started");
                if (z) {
                    a(d2);
                }
            } else {
                if (this.audio == null) {
                    init(this.lq);
                    if (this.audio == null) {
                        VELogUtil.e(TAG, "recorder is null");
                        return;
                    }
                }
                this.isRecording = true;
                try {
                    new Thread(new a(d2, z)).start();
                } catch (OutOfMemoryError unused) {
                    Runtime.getRuntime().gc();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException unused2) {
                    }
                    System.runFinalization();
                    new Thread(new a(d2, z)).start();
                }
            }
        }
    }

    public boolean a(double d2) {
        VELogUtil.i(TAG, "startFeeding() called with: speed = [" + d2 + "]");
        if (this.isRecording) {
            AudioDataProcessThread audioDataProcessThread = this.iq;
            if (audioDataProcessThread != null) {
                if (audioDataProcessThread.isProcessing()) {
                    VELogUtil.w(TAG, "startFeeding 失败，已经调用过一次了");
                    return false;
                }
                this.kq = false;
                this.iq.startFeeding(this.sampleRateInHz, d2);
                return true;
            }
        }
        VELogUtil.w(TAG, "startFeeding 录音未启动，将先启动startRecording");
        a(d2, true);
        return true;
    }

    public void discard() {
        AudioDataProcessThread audioDataProcessThread = this.iq;
        if (audioDataProcessThread != null) {
            audioDataProcessThread.discard();
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        AudioRecord audioRecord = this.audio;
        if (audioRecord != null) {
            try {
                if (audioRecord.getState() != 0) {
                    this.audio.stop();
                }
                this.audio.release();
            } catch (Exception unused) {
            }
            this.audio = null;
        }
        super.finalize();
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x017f  */
    public void init(int i) {
        int i2;
        String str;
        int i3;
        int i4;
        int i5;
        int[] iArr;
        int i6;
        int i7;
        String str2 = " ";
        this.lq = i;
        if (this.audio != null) {
            VELogUtil.e(TAG, "second time audio init(), skip");
            return;
        }
        int i8 = -1;
        try {
            if (!(channelConfigOffset == -1 || sampleRateOffset == -1)) {
                this.channelConfig = channelConfigSuggested[channelConfigOffset];
                this.sampleRateInHz = sampleRateSuggested[sampleRateOffset];
                this.bufferSizeInBytes = AudioRecord.getMinBufferSize(this.sampleRateInHz, this.channelConfig, this.audioFormat);
                AudioRecord audioRecord = new AudioRecord(i, this.sampleRateInHz, this.channelConfig, this.audioFormat, this.bufferSizeInBytes);
                this.audio = audioRecord;
            }
        } catch (Exception e2) {
            VELogUtil.e(TAG, "使用预设配置" + channelConfigOffset + "," + sampleRateOffset + "实例化audio recorder失败，重新测试配置。" + e2);
            this.jq.lackPermission();
        }
        int i9 = 1;
        if (this.audio == null) {
            channelConfigOffset = -1;
            int[] iArr2 = channelConfigSuggested;
            int length = iArr2.length;
            int i10 = 0;
            boolean z = false;
            while (true) {
                if (i10 >= length) {
                    break;
                }
                this.channelConfig = iArr2[i10];
                channelConfigOffset += i9;
                sampleRateOffset = i8;
                int[] iArr3 = sampleRateSuggested;
                int length2 = iArr3.length;
                int i11 = 0;
                while (true) {
                    if (i11 >= length2) {
                        str = str2;
                        i3 = i10;
                        i2 = i9;
                        break;
                    }
                    int i12 = iArr3[i11];
                    sampleRateOffset += i9;
                    try {
                        this.bufferSizeInBytes = AudioRecord.getMinBufferSize(i12, this.channelConfig, this.audioFormat);
                        VELogUtil.e(TAG, "试用hz " + i12 + str2 + this.channelConfig + str2 + this.audioFormat);
                        if (this.bufferSizeInBytes > 0) {
                            this.sampleRateInHz = i12;
                            int i13 = this.sampleRateInHz;
                            int i14 = i13;
                            r3 = r3;
                            str = str2;
                            i7 = i12;
                            i4 = i11;
                            int i15 = i14;
                            i5 = length2;
                            iArr = iArr3;
                            i3 = i10;
                            try {
                                AudioRecord audioRecord2 = new AudioRecord(i, i15, this.channelConfig, this.audioFormat, this.bufferSizeInBytes);
                                this.audio = audioRecord2;
                                i2 = 1;
                                z = true;
                                break;
                            } catch (Exception e3) {
                                e = e3;
                                this.sampleRateInHz = 0;
                                this.audio = null;
                                VELogUtil.e(TAG, "apply audio record sample rate " + i7 + " failed: " + e.getMessage());
                                i6 = 1;
                                sampleRateOffset = sampleRateOffset + 1;
                                i11 = i4 + 1;
                                i9 = i6;
                                iArr3 = iArr;
                                i10 = i3;
                                length2 = i5;
                                str2 = str;
                            }
                        } else {
                            str = str2;
                            int i16 = i12;
                            i4 = i11;
                            i5 = length2;
                            iArr = iArr3;
                            i3 = i10;
                            sampleRateOffset++;
                            i6 = 1;
                            i11 = i4 + 1;
                            i9 = i6;
                            iArr3 = iArr;
                            i10 = i3;
                            length2 = i5;
                            str2 = str;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        str = str2;
                        i7 = i12;
                        i4 = i11;
                        i5 = length2;
                        iArr = iArr3;
                        i3 = i10;
                        this.sampleRateInHz = 0;
                        this.audio = null;
                        VELogUtil.e(TAG, "apply audio record sample rate " + i7 + " failed: " + e.getMessage());
                        i6 = 1;
                        sampleRateOffset = sampleRateOffset + 1;
                        i11 = i4 + 1;
                        i9 = i6;
                        iArr3 = iArr;
                        i10 = i3;
                        length2 = i5;
                        str2 = str;
                    }
                }
                if (z) {
                    break;
                }
                i10 = i3 + 1;
                i9 = i2;
                str2 = str;
                i8 = -1;
            }
            if (this.sampleRateInHz > 0) {
                VELogUtil.e(TAG, "!Init audio recorder failed, hz " + this.sampleRateInHz);
                return;
            }
            if (this.channelConfig != 16) {
                i2 = 2;
            }
            this.jq.initAudioConfig(this.sampleRateInHz, i2);
            VELogUtil.e(TAG, "Init audio recorder succeed, apply audio record sample rate " + this.sampleRateInHz + " buffer " + this.bufferSizeInBytes + " state " + this.audio.getState());
            return;
        }
        i2 = i9;
        if (this.sampleRateInHz > 0) {
        }
    }

    public synchronized boolean isProcessing() {
        return this.iq != null && this.iq.isProcessing();
    }

    public boolean stopFeeding() {
        VELogUtil.i(TAG, "stopFeeding() called");
        if (!this.isRecording || this.audio != null) {
            if (this.isRecording) {
                AudioDataProcessThread audioDataProcessThread = this.iq;
                if (audioDataProcessThread != null) {
                    if (!audioDataProcessThread.isProcessing()) {
                        VELogUtil.e(TAG, "stopFeeding 失败，请先startFeeding再stopFeeding");
                        return false;
                    }
                    this.iq.stopFeeding();
                    return true;
                }
            }
            VELogUtil.e(TAG, "stopFeeding 失败，请先调用startRecording");
            return false;
        }
        VELogUtil.e(TAG, "stopFeeding: 状态异常，重置状态");
        this.isRecording = false;
        this.kq = true;
        AudioDataProcessThread audioDataProcessThread2 = this.iq;
        if (audioDataProcessThread2 != null) {
            audioDataProcessThread2.stop();
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0034, code lost:
        return true;
     */
    public boolean stopRecording() {
        synchronized (this) {
            Log.d(TAG, "stopRecording() called");
            if (!this.isRecording) {
                return false;
            }
            this.isRecording = false;
            if (this.audio == null) {
                LogUtil.e(TAG, "未启动音频模块但调用stopRecording");
            } else if (this.audio.getState() != 0) {
                this.audio.stop();
            }
            if (this.iq != null) {
                this.iq.stop();
            }
        }
    }

    public void tl() {
        synchronized (this) {
            this.kq = true;
        }
    }

    public void unInit() {
        if (this.isRecording) {
            stopRecording();
        }
        AudioRecord audioRecord = this.audio;
        if (audioRecord != null) {
            try {
                if (audioRecord.getState() != 0) {
                    this.audio.stop();
                }
                this.audio.release();
            } catch (Exception unused) {
            }
            this.audio = null;
        }
        VELogUtil.i(TAG, "unInit()");
    }

    public void waitUtilAudioProcessDone() {
        AudioDataProcessThread audioDataProcessThread = this.iq;
        if (audioDataProcessThread != null) {
            audioDataProcessThread.waitUtilAudioProcessDone();
        }
    }
}
