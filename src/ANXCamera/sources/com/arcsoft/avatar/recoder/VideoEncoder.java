package com.arcsoft.avatar.recoder;

import android.graphics.Bitmap;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.view.Surface;
import com.android.camera.storage.Storage;
import com.arcsoft.avatar.gl.EGLWrapper;
import com.arcsoft.avatar.gl.GLFramebuffer;
import com.arcsoft.avatar.gl.GLRender;
import com.arcsoft.avatar.util.CodecLog;
import com.arcsoft.avatar.util.NotifyMessage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.locks.ReentrantLock;

public class VideoEncoder extends BaseEncoder {
    private static String E = "video/hevc";
    public static final String ENCODER_THREAD_NAME = "Arc_Video_Encoder";
    public static final String NAME = "ARC_V";
    private static final String u = "Arc_VideoEncoder";
    private static final long v = 1000000000;
    private static final int w = 10000000;
    private static final int x = 30;
    private static final int y = 10;
    /* access modifiers changed from: private */
    public int A;
    /* access modifiers changed from: private */
    public int B;
    private boolean C;
    private int D;
    private Surface F;
    private Thread G;
    /* access modifiers changed from: private */
    public EGLWrapper H;
    private EGLContext I = EGL14.EGL_NO_CONTEXT;
    /* access modifiers changed from: private */
    public GLRender J;
    private int K;
    protected long t;
    private MediaFormat z;

    public class SaveThread extends Thread {

        /* renamed from: b  reason: collision with root package name */
        private ByteBuffer f113b;

        public SaveThread(ByteBuffer byteBuffer) {
            this.f113b = byteBuffer;
        }

        public void run() {
            super.run();
            Bitmap createBitmap = Bitmap.createBitmap(VideoEncoder.this.A, VideoEncoder.this.B, Bitmap.Config.ARGB_8888);
            createBitmap.copyPixelsFromBuffer(this.f113b);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream("/sdcard/Pictures/_" + System.currentTimeMillis() + Storage.JPEG_SUFFIX);
                createBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.close();
                createBitmap.recycle();
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
    }

    public VideoEncoder(MuxerWrapper muxerWrapper, int i, int i2, Object obj, RecordingListener recordingListener, EGLContext eGLContext, int i3, String str) {
        super(muxerWrapper, obj, recordingListener);
        this.A = i;
        this.B = i2;
        this.G = null;
        this.K = i3;
        this.I = eGLContext;
        E = str;
        prepare(true);
        b();
        this.q = new ReentrantLock();
        this.r = this.q.newCondition();
        CodecLog.d(u, "VideoEncoder constructor mCustomerBitRate = " + this.K);
        CodecLog.d(u, "VideoEncoder constructor mWidth = " + i + " ,mHeight = " + i2);
    }

    private void a(boolean z2) {
        CodecLog.d(u, "initVideoEncoder()->in");
        this.z = MediaFormat.createVideoFormat(E, this.A, this.B);
        this.z.setInteger("color-format", 2130708361);
        this.z.setInteger("bitrate", this.K);
        this.z.setInteger("frame-rate", 30);
        this.z.setInteger("i-frame-interval", 10);
        try {
            this.i = MediaCodec.createEncoderByType(E);
            CodecLog.i(u, "initVideoEncoder(): selected_codec_name = " + this.i.getName());
        } catch (IOException e2) {
            CodecLog.e(u, "initVideoEncoder()->createEncoderByType failed.");
            e2.printStackTrace();
            RecordingListener recordingListener = this.o;
            if (recordingListener != null) {
                recordingListener.onRecordingListener(NotifyMessage.MSG_MEDIA_RECORDER_ERROR_ENCODER_VIDEO_CREATE, 0);
            }
        }
        try {
            this.i.configure(this.z, (Surface) null, (MediaCrypto) null, 1);
        } catch (Exception e3) {
            CodecLog.e(u, "initVideoEncoder()->configure failed.");
            e3.printStackTrace();
            RecordingListener recordingListener2 = this.o;
            if (recordingListener2 != null) {
                recordingListener2.onRecordingListener(NotifyMessage.MSG_MEDIA_RECORDER_ERROR_ENCODER_VIDEO_CONFIGURE, 0);
            }
        }
        if (z2) {
            try {
                this.F = this.i.createInputSurface();
            } catch (Exception e4) {
                CodecLog.e(u, "initVideoEncoder()->createInputSurface failed.");
                e4.printStackTrace();
                RecordingListener recordingListener3 = this.o;
                if (recordingListener3 != null) {
                    recordingListener3.onRecordingListener(NotifyMessage.MSG_MEDIA_RECORDER_ERROR_ENCODER_VIDEO_CONFIGURE, 0);
                }
            }
        } else {
            this.F = null;
        }
        CodecLog.d(u, "initVideoEncoder()->out");
    }

    private void b() {
        this.H = new EGLWrapper(getInputSurface(), this.I);
    }

    /* access modifiers changed from: private */
    public void c() {
        this.J = new GLRender(this.A, this.B, this.D, true);
        this.J.initRender(false);
        CodecLog.d(u, "VideoEncoder initGL glError = " + GLES20.glGetError());
    }

    /* access modifiers changed from: private */
    public void d() {
        this.J.unInitRender();
        this.J = null;
    }

    private void e() {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.A * this.B * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        GLES20.glReadPixels(0, 0, this.A, this.B, 6408, 5121, allocateDirect);
        new SaveThread(allocateDirect).start();
    }

    public Surface getInputSurface() {
        return this.i != null ? this.F : super.getInputSurface();
    }

    public void notifyNewFrameAvailable() {
    }

    public void pauseRecording() {
        if (!this.f88e) {
            this.f88e = true;
            this.t = System.nanoTime();
        }
    }

    public void prepare(boolean z2) {
        a(z2);
        if (this.i == null) {
            throw new RuntimeException("Init video encoder is failed.");
        }
    }

    public void release(boolean z2) {
        try {
            this.q.lock();
        } catch (Exception e2) {
            CodecLog.e(u, "release()-> meet error when get lock : " + e2.getMessage());
        } catch (Throwable th) {
            sinalCondition();
            this.q.unlock();
            throw th;
        }
        sinalCondition();
        this.q.unlock();
        Thread thread = this.G;
        if (thread != null) {
            try {
                thread.join();
            } catch (InterruptedException e3) {
                CodecLog.d(u, "Encoder Thread has been Interrupted, errors may be occurred.");
                e3.printStackTrace();
            } catch (Throwable th2) {
                this.G = null;
                throw th2;
            }
            this.G = null;
        }
        EGLWrapper eGLWrapper = this.H;
        if (eGLWrapper != null) {
            eGLWrapper.release();
            this.H = null;
        }
        this.I = EGL14.EGL_NO_CONTEXT;
        CodecLog.d(u, "VideoEncoder release() encoder thread exit. threadName =" + ENCODER_THREAD_NAME);
        this.F = null;
        this.q = null;
        this.r = null;
        this.s = null;
        super.release(z2);
    }

    public void resumeRecording() {
        if (this.f88e) {
            this.f88e = false;
            this.g += System.nanoTime() - this.t;
            this.n.add(Long.valueOf(this.g));
        }
    }

    public void startRecording() {
        if (this.G == null) {
            super.startRecording();
            this.G = new Thread(ENCODER_THREAD_NAME) {
                public void run() {
                    super.run();
                    setName(VideoEncoder.NAME);
                    try {
                        VideoEncoder.this.i.start();
                        VideoEncoder.this.H.makeCurrent();
                        VideoEncoder.this.c();
                        while (true) {
                            VideoEncoder videoEncoder = VideoEncoder.this;
                            if (!videoEncoder.f87d) {
                                FrameItem frameItem = null;
                                try {
                                    videoEncoder.lock();
                                    while (VideoEncoder.this.s.queueSize() == 0 && !VideoEncoder.this.f87d) {
                                        try {
                                            CodecLog.d(VideoEncoder.u, "VideoEncoder frame_item_wait");
                                            VideoEncoder.this.r.await();
                                        } catch (InterruptedException e2) {
                                            e2.printStackTrace();
                                        }
                                    }
                                    frameItem = VideoEncoder.this.s.getFrameForConsumer();
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                    CodecLog.e(VideoEncoder.u, "VideoEncoder meet exception when get item : " + e3.getMessage());
                                } catch (Throwable th) {
                                    VideoEncoder.this.unLock();
                                    throw th;
                                }
                                VideoEncoder.this.unLock();
                                if (frameItem != null) {
                                    GLFramebuffer gLFramebuffer = frameItem.mFramebuffer;
                                    VideoEncoder.this.drain();
                                    CodecLog.d(VideoEncoder.u, "VideoEncoder frame_item_index = " + frameItem.mFrameIndex);
                                    if (0 != frameItem.f90a) {
                                        CodecLog.d(VideoEncoder.u, "VideoEncoder wait gpu by sync = " + frameItem.f90a);
                                        GLES30.glWaitSync(frameItem.f90a, 0, -1);
                                    }
                                    VideoEncoder.this.J.renderWithTextureId(gLFramebuffer.getTextureId());
                                    try {
                                        VideoEncoder.this.lock();
                                        VideoEncoder.this.s.addEmptyFrameForConsumer();
                                    } catch (Exception e4) {
                                        e4.printStackTrace();
                                        CodecLog.e(VideoEncoder.u, "VideoEncoder meet exception when add item : " + e4.getMessage());
                                    } catch (Throwable th2) {
                                        VideoEncoder.this.unLock();
                                        throw th2;
                                    }
                                    VideoEncoder.this.unLock();
                                    VideoEncoder.this.H.swapBuffers();
                                }
                            } else {
                                videoEncoder.f84a = true;
                                videoEncoder.i.signalEndOfInputStream();
                                VideoEncoder.this.drain();
                                VideoEncoder.this.d();
                                VideoEncoder.this.H.makeUnCurrent();
                                return;
                            }
                        }
                    } catch (Exception e5) {
                        e5.printStackTrace();
                        RecordingListener recordingListener = VideoEncoder.this.o;
                        if (recordingListener != null) {
                            recordingListener.onRecordingListener(NotifyMessage.MSG_MEDIA_RECORDER_ERROR_ENCODER_VIDEO_START, 0);
                        }
                    }
                }
            };
            this.G.start();
            CodecLog.d(u, "VideoEncoder is started.");
            return;
        }
        CodecLog.e(u, "startRecording()-> Video encoder thread has been started already, can not start twice.");
        throw new RuntimeException("Video encoder thread has been started already, can not start twice.");
    }

    public void stopRecording() {
        super.stopRecording();
        try {
            this.q.lock();
        } catch (Exception e2) {
            CodecLog.e(u, "stopRecording()-> meet error when get lock : " + e2.getMessage());
        } catch (Throwable th) {
            sinalCondition();
            this.q.unlock();
            throw th;
        }
        sinalCondition();
        this.q.unlock();
    }
}
