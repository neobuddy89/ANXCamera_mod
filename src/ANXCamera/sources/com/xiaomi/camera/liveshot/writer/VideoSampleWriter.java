package com.xiaomi.camera.liveshot.writer;

import android.media.MediaCodec;
import android.media.MediaMuxer;
import com.android.camera.Util;
import com.android.camera.log.Log;
import com.xiaomi.camera.liveshot.LivePhotoResult;
import com.xiaomi.camera.liveshot.encoder.CircularMediaEncoder;
import com.xiaomi.camera.liveshot.writer.SampleWriter;
import java.nio.ByteBuffer;

public class VideoSampleWriter extends SampleWriter {
    private static final boolean DEBUG = true;
    private static final long MIN_DURATION = 500000;
    private static final String TAG = "VideoSampleWriter";
    private final MediaMuxer mMediaMuxer;
    private final SampleWriter.StatusNotifier<Long> mVideoFirstKeyFrameArrivedNotifier;
    private final CircularMediaEncoder.Snapshot mVideoSnapshot;
    private final int mVideoTrackId;

    public VideoSampleWriter(MediaMuxer mediaMuxer, CircularMediaEncoder.Snapshot snapshot, int i, SampleWriter.StatusNotifier<Long> statusNotifier) {
        this.mMediaMuxer = mediaMuxer;
        this.mVideoSnapshot = snapshot;
        this.mVideoTrackId = i;
        this.mVideoFirstKeyFrameArrivedNotifier = statusNotifier;
    }

    /* access modifiers changed from: protected */
    public void writeSample() {
        long j;
        long j2;
        boolean z;
        long j3;
        Log.d(TAG, "writeVideoSamples: E");
        CircularMediaEncoder.Snapshot snapshot = this.mVideoSnapshot;
        long j4 = snapshot.head;
        long j5 = snapshot.tail;
        long j6 = snapshot.time;
        int i = snapshot.filterId;
        Log.d(TAG, "writeVideoSamples: head timestamp: " + this.mVideoSnapshot.head + ":" + j4);
        Log.d(TAG, "writeVideoSamples: snap timestamp: " + this.mVideoSnapshot.time + ":" + this.mVideoSnapshot.time);
        Log.d(TAG, "writeVideoSamples: tail timestamp: " + this.mVideoSnapshot.tail + ":" + j5);
        Log.d(TAG, "writeVideoSamples: cur filterId: " + this.mVideoSnapshot.filterId + ":" + i);
        long j7 = -1;
        boolean z2 = false;
        long j8 = 0;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        while (true) {
            if (z2) {
                break;
            }
            Log.d(TAG, "writeVideoSamples: take: E");
            try {
                CircularMediaEncoder.Sample take = this.mVideoSnapshot.samples.take();
                Log.d(TAG, "writeVideoSamples: take: X");
                if (take != null) {
                    ByteBuffer byteBuffer = take.data;
                    MediaCodec.BufferInfo bufferInfo = take.info;
                    LivePhotoResult livePhotoResult = take.livePhotoResult;
                    z = z2;
                    j2 = j5;
                    Log.d(TAG, "writeVideoSamples: livePhotoResult " + livePhotoResult);
                    if (byteBuffer.limit() == 0) {
                        break;
                    }
                    int i2 = bufferInfo.flags;
                    if ((i2 & 4) != 0) {
                        break;
                    }
                    if ((i2 & 1) != 0 || z3) {
                        if (j6 - bufferInfo.presentationTimeUs >= MIN_DURATION && !z4) {
                            if (!z5) {
                                boolean isLivePhotoStable = Util.isLivePhotoStable(livePhotoResult, i);
                                if (!isLivePhotoStable) {
                                    Log.d(TAG, "writeVideoSamples: drop not stable: " + bufferInfo.presentationTimeUs);
                                } else {
                                    Log.d(TAG, "writeVideoSamples: drop first stable: " + bufferInfo.presentationTimeUs);
                                    z5 = isLivePhotoStable;
                                }
                            } else if (!z4) {
                                z5 = Util.isLivePhotoStable(livePhotoResult, i);
                                if (!z5) {
                                    Log.d(TAG, "writeVideoSamples: drop second stable: " + bufferInfo.presentationTimeUs);
                                } else {
                                    Log.d(TAG, "writeVideoSamples: drop first and second stable: " + bufferInfo.presentationTimeUs);
                                    z2 = z;
                                    j5 = j2;
                                    z4 = true;
                                    z5 = true;
                                }
                            }
                            z2 = z;
                            j5 = j2;
                            z4 = false;
                        }
                        if (bufferInfo.presentationTimeUs - j6 <= MIN_DURATION || !(!Util.isLivePhotoStable(livePhotoResult, i))) {
                            j = j6;
                        } else {
                            String str = TAG;
                            StringBuilder sb = new StringBuilder();
                            sb.append("writeVideoSamples: drop not stable 2: ");
                            j = j6;
                            sb.append(bufferInfo.presentationTimeUs);
                            Log.d(str, sb.toString());
                            z6 = true;
                        }
                        long j9 = bufferInfo.presentationTimeUs;
                        if (j9 >= j4 && j7 < j9 - j8) {
                            if (!z3) {
                                CircularMediaEncoder.Snapshot snapshot2 = this.mVideoSnapshot;
                                snapshot2.offset = j9 - snapshot2.head;
                                SampleWriter.StatusNotifier<Long> statusNotifier = this.mVideoFirstKeyFrameArrivedNotifier;
                                if (statusNotifier != null) {
                                    statusNotifier.notify(Long.valueOf(snapshot2.offset));
                                }
                                Log.d(TAG, "writeVideoSamples: first video sample timestamp: " + j9);
                                z3 = true;
                            } else {
                                j9 = j8;
                            }
                            if (bufferInfo.presentationTimeUs >= j2 || z6) {
                                Log.d(TAG, "writeVideoSamples: stop writing as reaching the ending timestamp");
                                bufferInfo.flags = 4;
                            }
                            bufferInfo.presentationTimeUs -= j9;
                            this.mMediaMuxer.writeSampleData(this.mVideoTrackId, byteBuffer, bufferInfo);
                            j7 = bufferInfo.presentationTimeUs;
                            Log.d(TAG, "writeVideoSamples: video sample timestamp: " + (bufferInfo.presentationTimeUs + j9));
                            j8 = j9;
                        }
                        z2 = byteBuffer.limit() == 0 || (bufferInfo.flags & 4) != 0;
                        j5 = j2;
                        j6 = j;
                    } else {
                        Log.d(TAG, "writeVideoSamples: drop non-key frame sample timestamp: " + bufferInfo.presentationTimeUs);
                    }
                    j3 = j6;
                    z2 = z;
                    j5 = j2;
                    j6 = j;
                } else {
                    Log.e(TAG, "sample null return");
                    break;
                }
            } catch (InterruptedException unused) {
                j2 = j5;
                j3 = j6;
                z = z2;
                Log.d(TAG, "writeVideoSamples: take: meet interrupted exception");
            }
        }
        Log.d(TAG, "writeVideoSamples: EOF");
        CircularMediaEncoder.Snapshot snapshot3 = this.mVideoSnapshot;
        snapshot3.time = Math.max(0, snapshot3.time - j8);
        Log.d(TAG, "writeVideoSamples: cover frame timestamp: " + this.mVideoSnapshot.time);
        Log.d(TAG, "writeVideoSamples: X: duration: " + j7);
        Log.d(TAG, "writeVideoSamples: X: offset: " + this.mVideoSnapshot.offset);
    }
}
