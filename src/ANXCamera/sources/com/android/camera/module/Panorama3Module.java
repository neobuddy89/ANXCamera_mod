package com.android.camera.module;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.camera2.CameraCaptureSession;
import android.location.Location;
import android.media.Image;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.text.format.DateFormat;
import android.util.Size;
import android.view.KeyEvent;
import android.view.Surface;
import android.view.View;
import com.android.camera.AutoLockManager;
import com.android.camera.BasePreferenceActivity;
import com.android.camera.Camera;
import com.android.camera.CameraAppImpl;
import com.android.camera.CameraPreferenceActivity;
import com.android.camera.CameraScreenNail;
import com.android.camera.CameraSettings;
import com.android.camera.CameraSize;
import com.android.camera.FileCompat;
import com.android.camera.LocationManager;
import com.android.camera.OnClickAttr;
import com.android.camera.PictureSizeManager;
import com.android.camera.R;
import com.android.camera.SensorStateManager;
import com.android.camera.Thumbnail;
import com.android.camera.Util;
import com.android.camera.constant.UpdateConstant;
import com.android.camera.data.DataRepository;
import com.android.camera.data.data.config.ComponentManuallyDualLens;
import com.android.camera.effect.EffectController;
import com.android.camera.effect.FilterInfo;
import com.android.camera.fragment.beauty.BeautyValues;
import com.android.camera.log.Log;
import com.android.camera.panorama.AttachRunnable;
import com.android.camera.panorama.Camera1Image;
import com.android.camera.panorama.Camera2Image;
import com.android.camera.panorama.CaptureImage;
import com.android.camera.panorama.DirectionFunction;
import com.android.camera.panorama.DownDirectionFunction;
import com.android.camera.panorama.GyroscopeRoundDetector;
import com.android.camera.panorama.InputSave;
import com.android.camera.panorama.LeftDirectionFunction;
import com.android.camera.panorama.MorphoPanoramaGP3;
import com.android.camera.panorama.MorphoSensorFusion;
import com.android.camera.panorama.PanoramaGP3ImageFormat;
import com.android.camera.panorama.PanoramaSetting;
import com.android.camera.panorama.PanoramaState;
import com.android.camera.panorama.PositionDetector;
import com.android.camera.panorama.RightDirectionFunction;
import com.android.camera.panorama.RoundDetector;
import com.android.camera.panorama.SensorFusion;
import com.android.camera.panorama.SensorInfoManager;
import com.android.camera.panorama.UpDirectionFunction;
import com.android.camera.protocol.ModeCoordinatorImpl;
import com.android.camera.protocol.ModeProtocol;
import com.android.camera.statistic.CameraStatUtils;
import com.android.camera.statistic.MistatsConstants;
import com.android.camera.statistic.MistatsWrapper;
import com.android.camera.storage.MediaProviderUtil;
import com.android.camera.storage.Storage;
import com.android.camera2.Camera2Proxy;
import com.android.gallery3d.exif.ExifHelper;
import com.mi.config.b;
import com.xiaomi.camera.core.ParallelCallback;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@TargetApi(21)
public class Panorama3Module extends BaseModule implements ModeProtocol.CameraAction, Camera2Proxy.CameraPreviewCallback {
    /* access modifiers changed from: private */
    public static final boolean DUMP_YUV = SystemProperties.getBoolean("camera.debug.panorama", false);
    private static final int MIN_SHOOTING_TIME = 600;
    private static final int SENSOR_LIST = 186;
    /* access modifiers changed from: private */
    public static final String TAG = "Panorama3Module";
    public static final Object mEngineLock = new Object();
    /* access modifiers changed from: private */
    public static final Object mPreviewImageLock = new Object();
    /* access modifiers changed from: private */
    public static final CaptureImage sAttachExit = new Camera1Image((byte[]) null, 0, 0);
    /* access modifiers changed from: private */
    public final LinkedBlockingQueue<CaptureImage> mAttachImageQueue = new LinkedBlockingQueue<>();
    private int mAttachPosOffsetX;
    /* access modifiers changed from: private */
    public int mAttachPosOffsetY;
    /* access modifiers changed from: private */
    public int mCameraOrientation = 0;
    /* access modifiers changed from: private */
    public volatile boolean mCanSavePanorama;
    /* access modifiers changed from: private */
    public boolean mCaptureOrientationDecided = false;
    /* access modifiers changed from: private */
    public SensorInfoManager mCurrentSensorInfoManager;
    private final Object mDeviceLock = new Object();
    private int mDeviceOrientationAtCapture;
    /* access modifiers changed from: private */
    public int mDirection;
    /* access modifiers changed from: private */
    public DirectionFunction mDirectionFunction;
    /* access modifiers changed from: private */
    public Bitmap mDispPreviewImage;
    /* access modifiers changed from: private */
    public Canvas mDispPreviewImageCanvas;
    /* access modifiers changed from: private */
    public Paint mDispPreviewImagePaint;
    /* access modifiers changed from: private */
    public final ExecutorService mExecutor;
    private int mGoalAngle = 280;
    /* access modifiers changed from: private */
    public float[] mGravities;
    /* access modifiers changed from: private */
    public String mImageFormat = PanoramaGP3ImageFormat.YVU420_SEMIPLANAR;
    /* access modifiers changed from: private */
    public MorphoPanoramaGP3.InitParam mInitParam = new MorphoPanoramaGP3.InitParam();
    private boolean mIsRegisterSensorListener = false;
    /* access modifiers changed from: private */
    public boolean mIsSensorAverage;
    /* access modifiers changed from: private */
    public volatile boolean mIsShooting = false;
    private Location mLocation;
    /* access modifiers changed from: private */
    public float mLongSideCropRatio = 0.8766f;
    /* access modifiers changed from: private */
    public int mMaxHeight;
    /* access modifiers changed from: private */
    public int mMaxWidth;
    /* access modifiers changed from: private */
    public MorphoPanoramaGP3 mMorphoPanoramaGP3;
    private PanoramaSetting mPanoramaSetting;
    private long mPanoramaShootingStartTime;
    /* access modifiers changed from: private */
    public PanoramaState mPanoramaState;
    /* access modifiers changed from: private */
    public int mPictureHeight;
    /* access modifiers changed from: private */
    public int mPictureWidth;
    /* access modifiers changed from: private */
    public Bitmap mPreviewImage;
    /* access modifiers changed from: private */
    public int mPreviewRefY;
    /* access modifiers changed from: private */
    public volatile boolean mRequestStop;
    /* access modifiers changed from: private */
    public RoundDetector mRoundDetector;
    private SaveOutputImageTask mSaveOutputImageTask;
    /* access modifiers changed from: private */
    public int mSensorCnt;
    /* access modifiers changed from: private */
    public SensorEventListener mSensorEventListener = new MySensorEventListener(new SensorListener() {
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (Panorama3Module.this.mIsSensorAverage) {
                float[] access$100 = Panorama3Module.this.mGravities;
                access$100[0] = access$100[0] + sensorEvent.values[0];
                float[] access$1002 = Panorama3Module.this.mGravities;
                access$1002[1] = access$1002[1] + sensorEvent.values[1];
                float[] access$1003 = Panorama3Module.this.mGravities;
                access$1003[2] = access$1003[2] + sensorEvent.values[2];
                int unused = Panorama3Module.this.mSensorCnt = Panorama3Module.this.mSensorCnt + 1;
                return;
            }
            Panorama3Module.this.mGravities[0] = sensorEvent.values[0];
            Panorama3Module.this.mGravities[1] = sensorEvent.values[1];
            Panorama3Module.this.mGravities[2] = sensorEvent.values[2];
            int unused2 = Panorama3Module.this.mSensorCnt = 1;
        }
    });
    /* access modifiers changed from: private */
    public SensorFusion mSensorFusion = null;
    private int mSensorFusionMode;
    private ArrayList<SensorInfoManager> mSensorInfoManagerList;
    private SensorStateManager.SensorStateListener mSensorStateListener = new SensorStateManager.SensorStateAdapter() {
        public boolean isWorking() {
            return Panorama3Module.this.isAlive() && Panorama3Module.this.getCameraState() != 0;
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            super.onSensorChanged(sensorEvent);
            if (sensorEvent.sensor.getType() == 9) {
                Panorama3Module.this.mSensorEventListener.onSensorChanged(sensorEvent);
            } else {
                Panorama3Module.this.mSensorFusion.onSensorChanged(sensorEvent);
            }
        }
    };
    private String mShutterEndTime;
    private String mShutterStartTime;
    /* access modifiers changed from: private */
    public int mSmallPreviewHeight;
    private int mSnapshotFocusMode = 1;
    private int mTargetFocusMode = 4;
    /* access modifiers changed from: private */
    public long mTimeTaken;
    /* access modifiers changed from: private */
    public float mViewAngleH = 71.231476f;
    /* access modifiers changed from: private */
    public float mViewAngleV = 56.49462f;

    private class DecideDirection extends PanoramaState {
        private boolean mHasSubmit;

        private class DecideDirectionAttach extends AttachRunnable {

            private class DecideRunnable implements Runnable {
                private DecideRunnable() {
                }

                public void run() {
                    Panorama3Module.this.reInitGravitySensorData();
                    if (Panorama3Module.this.mRequestStop) {
                        Log.w(Panorama3Module.TAG, "DecideRunnable exit request stop");
                        return;
                    }
                    Log.d(Panorama3Module.TAG, "go to PanoramaPreview in DecideRunnable");
                    synchronized (Panorama3Module.mEngineLock) {
                        if (Panorama3Module.this.mMorphoPanoramaGP3 == null) {
                            Log.w(Panorama3Module.TAG, "DecideRunnable exit due to mMorphoPanoramaGP3 is null");
                            return;
                        }
                        PanoramaState unused = Panorama3Module.this.mPanoramaState = new PanoramaPreview(Panorama3Module.this);
                        Panorama3Module.this.mPanoramaState.setPanoramaStateEventListener(DecideDirection.this.listener);
                        DecideDirection.this.clearListener();
                    }
                }
            }

            private DecideDirectionAttach() {
            }

            private void createDirection(int i) {
                if (Panorama3Module.this.mInitParam.output_rotation == 90 || Panorama3Module.this.mInitParam.output_rotation == 270) {
                    if (i == 3) {
                        Log.i(Panorama3Module.TAG, "direction : VERTICAL_UP");
                        int scaleV = getScaleV();
                        if (Panorama3Module.this.mCameraOrientation == 90) {
                            Panorama3Module panorama3Module = Panorama3Module.this;
                            RightDirectionFunction rightDirectionFunction = new RightDirectionFunction(panorama3Module.mPictureWidth, Panorama3Module.this.mPictureHeight, Panorama3Module.this.mMaxWidth, Panorama3Module.this.mMaxHeight, scaleV, Panorama3Module.this.mInitParam.output_rotation);
                            DirectionFunction unused = panorama3Module.mDirectionFunction = rightDirectionFunction;
                            return;
                        }
                        Panorama3Module panorama3Module2 = Panorama3Module.this;
                        LeftDirectionFunction leftDirectionFunction = new LeftDirectionFunction(panorama3Module2.mPictureWidth, Panorama3Module.this.mPictureHeight, Panorama3Module.this.mMaxWidth, Panorama3Module.this.mMaxHeight, scaleV, Panorama3Module.this.mInitParam.output_rotation);
                        DirectionFunction unused2 = panorama3Module2.mDirectionFunction = leftDirectionFunction;
                    } else if (i == 4) {
                        Log.i(Panorama3Module.TAG, "direction : VERTICAL_DOWN");
                        int scaleV2 = getScaleV();
                        if (Panorama3Module.this.mCameraOrientation == 90) {
                            Panorama3Module panorama3Module3 = Panorama3Module.this;
                            LeftDirectionFunction leftDirectionFunction2 = new LeftDirectionFunction(panorama3Module3.mPictureWidth, Panorama3Module.this.mPictureHeight, Panorama3Module.this.mMaxWidth, Panorama3Module.this.mMaxHeight, scaleV2, Panorama3Module.this.mInitParam.output_rotation);
                            DirectionFunction unused3 = panorama3Module3.mDirectionFunction = leftDirectionFunction2;
                            return;
                        }
                        Panorama3Module panorama3Module4 = Panorama3Module.this;
                        RightDirectionFunction rightDirectionFunction2 = new RightDirectionFunction(panorama3Module4.mPictureWidth, Panorama3Module.this.mPictureHeight, Panorama3Module.this.mMaxWidth, Panorama3Module.this.mMaxHeight, scaleV2, Panorama3Module.this.mInitParam.output_rotation);
                        DirectionFunction unused4 = panorama3Module4.mDirectionFunction = rightDirectionFunction2;
                    }
                } else if (i == 3) {
                    Log.i(Panorama3Module.TAG, "direction : VERTICAL_UP");
                    int scaleH = getScaleH();
                    if (Panorama3Module.this.mCameraOrientation == 90) {
                        Panorama3Module panorama3Module5 = Panorama3Module.this;
                        UpDirectionFunction upDirectionFunction = new UpDirectionFunction(panorama3Module5.mPictureWidth, Panorama3Module.this.mPictureHeight, Panorama3Module.this.mMaxWidth, Panorama3Module.this.mMaxHeight, scaleH, Panorama3Module.this.mInitParam.output_rotation);
                        DirectionFunction unused5 = panorama3Module5.mDirectionFunction = upDirectionFunction;
                        return;
                    }
                    Panorama3Module panorama3Module6 = Panorama3Module.this;
                    DownDirectionFunction downDirectionFunction = new DownDirectionFunction(panorama3Module6.mPictureWidth, Panorama3Module.this.mPictureHeight, Panorama3Module.this.mMaxWidth, Panorama3Module.this.mMaxHeight, scaleH, Panorama3Module.this.mInitParam.output_rotation);
                    DirectionFunction unused6 = panorama3Module6.mDirectionFunction = downDirectionFunction;
                } else if (i == 4) {
                    Log.i(Panorama3Module.TAG, "direction : VERTICAL_DOWN");
                    int scaleH2 = getScaleH();
                    if (Panorama3Module.this.mCameraOrientation == 90) {
                        Panorama3Module panorama3Module7 = Panorama3Module.this;
                        DownDirectionFunction downDirectionFunction2 = new DownDirectionFunction(panorama3Module7.mPictureWidth, Panorama3Module.this.mPictureHeight, Panorama3Module.this.mMaxWidth, Panorama3Module.this.mMaxHeight, scaleH2, Panorama3Module.this.mInitParam.output_rotation);
                        DirectionFunction unused7 = panorama3Module7.mDirectionFunction = downDirectionFunction2;
                        return;
                    }
                    Panorama3Module panorama3Module8 = Panorama3Module.this;
                    UpDirectionFunction upDirectionFunction2 = new UpDirectionFunction(panorama3Module8.mPictureWidth, Panorama3Module.this.mPictureHeight, Panorama3Module.this.mMaxWidth, Panorama3Module.this.mMaxHeight, scaleH2, Panorama3Module.this.mInitParam.output_rotation);
                    DirectionFunction unused8 = panorama3Module8.mDirectionFunction = upDirectionFunction2;
                }
            }

            private int getScaleH() {
                return Math.max(1, (Panorama3Module.this.mMaxHeight / Util.sWindowHeight) * 2);
            }

            private int getScaleV() {
                return (int) Math.max(1.0f, (((float) Panorama3Module.this.mMaxHeight) / (((float) Panorama3Module.this.mSmallPreviewHeight) / Panorama3Module.this.mLongSideCropRatio)) - 1.0f);
            }

            private boolean isUnDecideDirection(int i) {
                return i == -1 || i == 0 || i == 2 || i == 1;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:24:0x00c6, code lost:
                if (r5 != false) goto L_0x00e0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:25:0x00c8, code lost:
                r5 = com.android.camera.module.Panorama3Module.access$500();
                com.android.camera.log.Log.e(r5, "DecideDirectionAttach error ret:" + r0);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:26:0x00e0, code lost:
                com.android.camera.log.Log.e(com.android.camera.module.Panorama3Module.access$500(), java.lang.String.format(java.util.Locale.US, "attach error ret:0x%08X", new java.lang.Object[]{java.lang.Integer.valueOf(r0)}));
             */
            /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
                closeSrc();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:30:0x00fb, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
                closeSrc();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
                closeSrc();
                com.android.camera.module.Panorama3Module.access$3602(r1.this$1.this$0, r0);
                createDirection(r0);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:53:0x01d5, code lost:
                if (com.android.camera.module.Panorama3Module.access$3700(r1.this$1.this$0).enabled() == false) goto L_0x0002;
             */
            public void run() {
                int i;
                while (true) {
                    try {
                        CaptureImage captureImage = (CaptureImage) Panorama3Module.this.mAttachImageQueue.take();
                        if (captureImage == Panorama3Module.sAttachExit) {
                            break;
                        }
                        try {
                            setImage(captureImage);
                            synchronized (Panorama3Module.mEngineLock) {
                                if (Panorama3Module.this.mMorphoPanoramaGP3.getAttachCount() % 5 == 0) {
                                    Panorama3Module.this.setInitialRotationByGravity();
                                    boolean unused = Panorama3Module.this.mIsSensorAverage = true;
                                }
                                Panorama3Module.this.setSensorFusionValue(captureImage);
                                if (Panorama3Module.this.mRequestStop) {
                                    Log.e(Panorama3Module.TAG, "DecideDirectionAttach request stop");
                                    closeSrc();
                                    return;
                                }
                                Log.d(Panorama3Module.TAG, "DecideDirectionAttach attach start");
                                int attach = Panorama3Module.this.mMorphoPanoramaGP3.attach(this.byteBuffer[0], this.byteBuffer[1], this.byteBuffer[2], this.rowStride[0], this.rowStride[1], this.rowStride[2], this.pixelStride[0], this.pixelStride[1], this.pixelStride[2], Panorama3Module.this.mCurrentSensorInfoManager, (double[]) null, Panorama3Module.this.getActivity().getApplicationContext());
                                Log.d(Panorama3Module.TAG, "DecideDirectionAttach attach end");
                                boolean z = attach == -1073741823;
                                if (attach != 0) {
                                    break;
                                }
                                if (isUnDecideDirection(Panorama3Module.this.mInitParam.direction)) {
                                    i = Panorama3Module.this.mMorphoPanoramaGP3.getDirection();
                                    if (i == Panorama3Module.this.mInitParam.direction) {
                                    }
                                } else {
                                    i = Panorama3Module.this.mInitParam.direction;
                                }
                                String access$500 = Panorama3Module.TAG;
                                Log.d(access$500, "getDirection = " + i);
                                int[] iArr = new int[2];
                                int outputImageSize = Panorama3Module.this.mMorphoPanoramaGP3.getOutputImageSize(iArr);
                                if (outputImageSize != 0) {
                                    Log.e(Panorama3Module.TAG, String.format(Locale.US, "getOutputImageSize error ret:0x%08X", new Object[]{Integer.valueOf(outputImageSize)}));
                                    closeSrc();
                                    return;
                                }
                                int unused2 = Panorama3Module.this.mMaxWidth = iArr[0];
                                int unused3 = Panorama3Module.this.mMaxHeight = iArr[1];
                                String access$5002 = Panorama3Module.TAG;
                                Log.d(access$5002, "mMaxWidth = " + Panorama3Module.this.mMaxWidth + ", mMaxHeight = " + Panorama3Module.this.mMaxHeight);
                            }
                        } catch (Throwable th) {
                            closeSrc();
                            throw th;
                        }
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
                Panorama3Module.this.getActivity().runOnUiThread(new DecideRunnable());
                Log.d(Panorama3Module.TAG, "DecideDirectionAttach end");
            }
        }

        private DecideDirection() {
            this.mHasSubmit = false;
        }

        public boolean onSaveImage(CaptureImage captureImage) {
            Panorama3Module.this.addAttachQueue(captureImage);
            if (!this.mHasSubmit) {
                Log.d(Panorama3Module.TAG, "submit DecideDirectionAttach");
                Panorama3Module.this.mExecutor.submit(new DecideDirectionAttach());
                this.mHasSubmit = true;
            }
            return true;
        }
    }

    private static class MainHandler extends Handler {
        private WeakReference<Panorama3Module> mModule;

        public MainHandler(Panorama3Module panorama3Module, Looper looper) {
            super(looper);
            this.mModule = new WeakReference<>(panorama3Module);
        }

        public void handleMessage(Message message) {
            Panorama3Module panorama3Module = (Panorama3Module) this.mModule.get();
            if (panorama3Module != null) {
                if (message.what == 45) {
                    Log.d(Panorama3Module.TAG, "onMessage MSG_ABANDON_HANDLER setActivity null");
                    panorama3Module.setActivity((Camera) null);
                }
                if (!panorama3Module.isCreated()) {
                    removeCallbacksAndMessages((Object) null);
                } else if (panorama3Module.getActivity() != null) {
                    int i = message.what;
                    if (i != 2) {
                        if (i == 17) {
                            removeMessages(17);
                            removeMessages(2);
                            panorama3Module.getWindow().addFlags(128);
                            sendEmptyMessageDelayed(2, (long) panorama3Module.getScreenDelay());
                            return;
                        } else if (i == 51) {
                            Camera camera = panorama3Module.mActivity;
                            if (camera != null && !camera.isActivityPaused()) {
                                panorama3Module.mOpenCameraFail = true;
                                panorama3Module.onCameraException();
                                return;
                            }
                            return;
                        } else if (i == 9) {
                            CameraSize cameraSize = panorama3Module.mPreviewSize;
                            int uIStyleByPreview = CameraSettings.getUIStyleByPreview(cameraSize.width, cameraSize.height);
                            if (uIStyleByPreview != panorama3Module.mUIStyle) {
                                panorama3Module.mUIStyle = uIStyleByPreview;
                            }
                            panorama3Module.initPreviewLayout();
                            return;
                        } else if (i == 10) {
                            panorama3Module.mOpenCameraFail = true;
                            panorama3Module.onCameraException();
                            return;
                        } else if (!BaseModule.DEBUG) {
                            String access$500 = Panorama3Module.TAG;
                            Log.e(access$500, "no consumer for this message: " + message.what);
                        } else {
                            throw new RuntimeException("no consumer for this message: " + message.what);
                        }
                    }
                    panorama3Module.getWindow().clearFlags(128);
                }
            }
        }
    }

    private static class MySensorEventListener implements SensorEventListener {
        private WeakReference<SensorListener> mRefSensorListener;

        public MySensorEventListener(SensorListener sensorListener) {
            this.mRefSensorListener = new WeakReference<>(sensorListener);
        }

        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            SensorListener sensorListener = (SensorListener) this.mRefSensorListener.get();
            if (sensorListener != null) {
                sensorListener.onSensorChanged(sensorEvent);
            }
        }
    }

    private class PanoramaFirst extends PanoramaState {
        private PanoramaFirst() {
        }

        public boolean onSaveImage(CaptureImage captureImage) {
            captureImage.close();
            Panorama3Module.this.setNullDirectionFunction();
            if (Panorama3Module.this.mRequestStop) {
                Log.e(Panorama3Module.TAG, "PanoramaFirst.onSaveImage request stop");
                return false;
            }
            boolean unused = Panorama3Module.this.configMorphoPanoramaGP3();
            int start = Panorama3Module.this.mMorphoPanoramaGP3.start(Panorama3Module.this.mPictureWidth, Panorama3Module.this.mPictureHeight);
            if (start != 0) {
                String access$500 = Panorama3Module.TAG;
                Log.e(access$500, "start error resultCode:" + start);
                return false;
            }
            Panorama3Module panorama3Module = Panorama3Module.this;
            PanoramaState unused2 = panorama3Module.mPanoramaState = new DecideDirection();
            Panorama3Module.this.mPanoramaState.setPanoramaStateEventListener(this.listener);
            clearListener();
            return true;
        }
    }

    private class PanoramaInit extends PanoramaState {
        private PanoramaInit() {
        }

        public boolean onSaveImage(CaptureImage captureImage) {
            String unused = Panorama3Module.this.mImageFormat = captureImage.getImageFormat();
            String access$500 = Panorama3Module.TAG;
            Log.d(access$500, "PanoramaInit onSaveImage start, ImageFormat :" + Panorama3Module.this.mImageFormat);
            if (Panorama3Module.this.mRequestStop) {
                Log.w(Panorama3Module.TAG, "mRequestStop when PanoramaInit");
                captureImage.close();
                return false;
            }
            synchronized (Panorama3Module.mEngineLock) {
                if (Panorama3Module.this.createEngine()) {
                    int inputImageFormat = Panorama3Module.this.mMorphoPanoramaGP3.setInputImageFormat(Panorama3Module.this.mImageFormat);
                    if (inputImageFormat != 0) {
                        String access$5002 = Panorama3Module.TAG;
                        Log.e(access$5002, "setInputImageFormat error resultCode:" + inputImageFormat);
                    }
                    PanoramaState unused2 = Panorama3Module.this.mPanoramaState = new PanoramaFirst();
                    Panorama3Module.this.mPanoramaState.setPanoramaStateEventListener(this.listener);
                    clearListener();
                    Panorama3Module.this.mPanoramaState.onSaveImage(captureImage);
                    Log.d(Panorama3Module.TAG, "PanoramaInit onSaveImage end");
                    return true;
                }
                captureImage.close();
                return true;
            }
        }
    }

    private class PanoramaPreview extends PanoramaState {
        /* access modifiers changed from: private */
        public PositionDetector mDetector;
        private boolean mHasSubmit;
        private int mPreviewImgHeight = 0;
        private int mPreviewImgWidth = 0;
        /* access modifiers changed from: private */
        public final UiUpdateRunnable mUiUpdateRunnable = new UiUpdateRunnable();
        final /* synthetic */ Panorama3Module this$0;

        private class PreviewAttach extends AttachRunnable {
            private InputSave mInputSave;
            private boolean mIsAttachEnd;
            private final PostAttachRunnable mPostAttachRunnable;
            private int mResultCode;

            private class PostAttachRunnable implements Runnable {
                private PostAttachRunnable() {
                }

                public void run() {
                    if (!PanoramaPreview.this.this$0.mPaused && !PanoramaPreview.this.this$0.mRequestStop) {
                        PanoramaPreview.this.this$0.onPreviewMoving();
                        if (!PanoramaPreview.this.this$0.mCaptureOrientationDecided) {
                            PanoramaPreview.this.this$0.onCaptureOrientationDecided();
                        }
                        ModeProtocol.PanoramaProtocol panoramaProtocol = (ModeProtocol.PanoramaProtocol) ModeCoordinatorImpl.getInstance().getAttachProtocol(176);
                        synchronized (Panorama3Module.mPreviewImageLock) {
                            if (panoramaProtocol != null) {
                                if (PanoramaPreview.this.this$0.mDispPreviewImage != null) {
                                    panoramaProtocol.setDisplayPreviewBitmap(PanoramaPreview.this.this$0.mDispPreviewImage);
                                }
                            }
                        }
                    }
                }
            }

            private PreviewAttach() {
                this.mIsAttachEnd = false;
                this.mPostAttachRunnable = new PostAttachRunnable();
                this.mInputSave = new InputSave();
            }

            private void checkAttachEnd(double[] dArr) {
                int detect = PanoramaPreview.this.mDetector.detect(dArr[0], dArr[1]);
                String access$500 = Panorama3Module.TAG;
                Log.v(access$500, "checkAttachEnd detect_result = " + detect);
                if (detect == -2 || detect == -1 || detect == 1) {
                    this.mResultCode = 0;
                    this.mIsAttachEnd = true;
                }
                PanoramaPreview.this.mUiUpdateRunnable.setDetectResult(detect);
                PanoramaPreview.this.this$0.getActivity().runOnUiThread(PanoramaPreview.this.mUiUpdateRunnable);
                if (this.mIsAttachEnd) {
                }
            }

            /* JADX WARNING: Code restructure failed: missing block: B:25:0x01f8, code lost:
                return;
             */
            private void updatePreviewImage() {
                Bitmap bitmap;
                synchronized (Panorama3Module.mPreviewImageLock) {
                    int updatePreviewImage = PanoramaPreview.this.this$0.mMorphoPanoramaGP3.updatePreviewImage(PanoramaPreview.this.this$0.mPreviewImage);
                    if (updatePreviewImage != 0) {
                        String access$500 = Panorama3Module.TAG;
                        Log.e(access$500, "updatePreviewImage error ret:" + updatePreviewImage);
                    } else if (PanoramaPreview.this.this$0.mPreviewImage == null) {
                        Log.w(Panorama3Module.TAG, "mPreviewImage is null when updatePreviewImage");
                    } else {
                        int i = 90;
                        if (PanoramaPreview.this.this$0.mInitParam.output_rotation % 180 == 90) {
                            if (PanoramaPreview.this.this$0.mInitParam.output_rotation == 270) {
                                Matrix matrix = new Matrix();
                                matrix.postRotate((float) 180);
                                bitmap = Bitmap.createBitmap(PanoramaPreview.this.this$0.mPreviewImage, 0, 0, PanoramaPreview.this.this$0.mPreviewImage.getWidth(), PanoramaPreview.this.this$0.mPreviewImage.getHeight(), matrix, true);
                            } else {
                                bitmap = PanoramaPreview.this.this$0.mPreviewImage;
                            }
                            int width = bitmap.getWidth();
                            int round = Math.round(((float) bitmap.getHeight()) * PanoramaPreview.this.this$0.mLongSideCropRatio);
                            int width2 = PanoramaPreview.this.this$0.mDispPreviewImage.getWidth();
                            int height = PanoramaPreview.this.this$0.mDispPreviewImage.getHeight();
                            Rect rect = new Rect(0, 0, width2, height);
                            int i2 = (int) (((float) width) / (((float) width2) / ((float) height)));
                            int height2 = ((int) ((((float) bitmap.getHeight()) * (1.0f - PanoramaPreview.this.this$0.mLongSideCropRatio)) / 2.0f)) + ((i2 - round) / 2);
                            Rect rect2 = new Rect(0, height2, width, i2 + height2);
                            String access$5002 = Panorama3Module.TAG;
                            Log.v(access$5002, "src " + rect2 + ", dst = " + rect);
                            PanoramaPreview.this.this$0.mDispPreviewImageCanvas.drawBitmap(bitmap, rect2, rect, PanoramaPreview.this.this$0.mDispPreviewImagePaint);
                        } else {
                            if (PanoramaPreview.this.this$0.mInitParam.output_rotation == 180) {
                                i = -90;
                            }
                            Matrix matrix2 = new Matrix();
                            matrix2.postRotate((float) i);
                            Bitmap createBitmap = Bitmap.createBitmap(PanoramaPreview.this.this$0.mPreviewImage, 0, 0, PanoramaPreview.this.this$0.mPreviewImage.getWidth(), PanoramaPreview.this.this$0.mPreviewImage.getHeight(), matrix2, true);
                            int width3 = createBitmap.getWidth();
                            int round2 = Math.round(((float) createBitmap.getHeight()) * PanoramaPreview.this.this$0.mLongSideCropRatio);
                            int width4 = PanoramaPreview.this.this$0.mDispPreviewImage.getWidth();
                            int height3 = PanoramaPreview.this.this$0.mDispPreviewImage.getHeight();
                            Rect rect3 = new Rect(0, 0, width4, height3);
                            int i3 = (int) (((float) width3) / (((float) width4) / ((float) height3)));
                            int height4 = ((int) ((((float) createBitmap.getHeight()) * (1.0f - PanoramaPreview.this.this$0.mLongSideCropRatio)) / 2.0f)) + ((i3 - round2) / 2);
                            Rect rect4 = new Rect(0, height4, width3, i3 + height4);
                            String access$5003 = Panorama3Module.TAG;
                            Log.v(access$5003, "src " + rect4 + ", dst = " + rect3);
                            PanoramaPreview.this.this$0.mDispPreviewImageCanvas.drawBitmap(createBitmap, rect4, rect3, PanoramaPreview.this.this$0.mDispPreviewImagePaint);
                        }
                    }
                }
            }

            /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
                r1.this$1.this$0.getActivity().runOnUiThread(r1.mPostAttachRunnable);
                r0 = r18;
                checkAttachEnd(r0);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:34:0x010c, code lost:
                if (r1.mIsAttachEnd == false) goto L_0x0118;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:35:0x010e, code lost:
                com.android.camera.log.Log.d(com.android.camera.module.Panorama3Module.access$500(), "preview attach end");
             */
            /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
                closeSrc();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:45:0x0123, code lost:
                r0 = th;
             */
            /* JADX WARNING: Removed duplicated region for block: B:58:0x0146  */
            /* JADX WARNING: Removed duplicated region for block: B:60:0x0150  */
            /* JADX WARNING: Unknown top exception splitter block from list: {B:49:0x0129=Splitter:B:49:0x0129, B:27:0x00ba=Splitter:B:27:0x00ba} */
            public void run() {
                int i;
                double[] dArr;
                Log.d(Panorama3Module.TAG, "PreviewAttach.run start");
                char c2 = 2;
                double[] dArr2 = new double[2];
                while (true) {
                    try {
                        CaptureImage captureImage = (CaptureImage) PanoramaPreview.this.this$0.mAttachImageQueue.take();
                        if (captureImage == Panorama3Module.sAttachExit) {
                            break;
                        }
                        try {
                            setImage(captureImage);
                            if (Panorama3Module.DUMP_YUV) {
                                this.mInputSave.onSaveImage(captureImage, PanoramaPreview.this.this$0.mImageFormat);
                            }
                            synchronized (Panorama3Module.mEngineLock) {
                                try {
                                    if (PanoramaPreview.this.this$0.mRequestStop) {
                                        Log.w(Panorama3Module.TAG, "PreviewAttach request stop");
                                        closeSrc();
                                        return;
                                    }
                                    Log.v(Panorama3Module.TAG, "PreviewAttach attach start");
                                    PanoramaPreview.this.this$0.setSensorFusionValue(captureImage);
                                    double[] dArr3 = dArr2;
                                    double[] dArr4 = dArr2;
                                    i = -1;
                                    try {
                                        if (PanoramaPreview.this.this$0.mMorphoPanoramaGP3.attach(this.byteBuffer[0], this.byteBuffer[1], this.byteBuffer[c2], this.rowStride[0], this.rowStride[1], this.rowStride[c2], this.pixelStride[0], this.pixelStride[1], this.pixelStride[c2], PanoramaPreview.this.this$0.mCurrentSensorInfoManager, dArr3, PanoramaPreview.this.this$0.getActivity()) != 0) {
                                            Log.e(Panorama3Module.TAG, "PreviewAttach attach error.");
                                            this.mResultCode = -1;
                                        } else {
                                            Log.v(Panorama3Module.TAG, "PreviewAttach attach end");
                                            boolean unused = PanoramaPreview.this.this$0.mCanSavePanorama = true;
                                            updatePreviewImage();
                                            Log.v(Panorama3Module.TAG, "mCenter = " + dArr4[0] + ", " + dArr4[1]);
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    i = -1;
                                    throw th;
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            i = -1;
                            closeSrc();
                            throw th;
                        }
                        dArr2 = dArr;
                        c2 = 2;
                    } catch (InterruptedException e2) {
                        e = e2;
                        i = -1;
                        Log.w(Panorama3Module.TAG, "PreviewAttach interrupted", (Throwable) e);
                        this.mResultCode = i;
                        if (!PanoramaPreview.this.this$0.mRequestStop) {
                        }
                    }
                }
                try {
                    closeSrc();
                } catch (InterruptedException e3) {
                    e = e3;
                }
                if (!PanoramaPreview.this.this$0.mRequestStop) {
                    Log.d(Panorama3Module.TAG, "PreviewAttach exit. (request exit)");
                    return;
                }
                final int i2 = this.mResultCode;
                PanoramaPreview.this.this$0.getActivity().runOnUiThread(new Runnable() {
                    public void run() {
                        PanoramaPreview.this.attachEnd(i2);
                    }
                });
                Log.d(Panorama3Module.TAG, "PreviewAttach exit.");
            }
        }

        private class UiUpdateRunnable implements Runnable {
            private int mDetectResult;

            private UiUpdateRunnable() {
            }

            /* JADX WARNING: Code restructure failed: missing block: B:19:0x0084, code lost:
                com.android.camera.module.Panorama3Module.access$6502(r5.this$1.this$0, java.lang.Math.min(r3, r4) / 2);
                r0 = (com.android.camera.protocol.ModeProtocol.PanoramaProtocol) com.android.camera.protocol.ModeCoordinatorImpl.getInstance().getAttachProtocol(176);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:20:0x009d, code lost:
                if (r0 == null) goto L_?;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:21:0x009f, code lost:
                r0.setDirectionPosition(r2, com.android.camera.module.Panorama3Module.access$6500(r5.this$1.this$0));
             */
            /* JADX WARNING: Code restructure failed: missing block: B:22:0x00ac, code lost:
                if (r5.mDetectResult == 2) goto L_0x00b3;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:23:0x00ae, code lost:
                r0.setDirectionTooFast(false, 0);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:24:0x00b3, code lost:
                r0.setDirectionTooFast(true, com.android.camera.constant.DurationConstant.DURATION_LANDSCAPE_HINT);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
                return;
             */
            public void run() {
                int i = this.mDetectResult;
                if (i == -2 || i == -1 || i == 1) {
                    if (this.mDetectResult != 1) {
                        String access$500 = Panorama3Module.TAG;
                        Log.w(access$500, "stopPanoramaShooting due to detect result " + this.mDetectResult);
                    }
                    PanoramaPreview.this.this$0.stopPanoramaShooting(true);
                    return;
                }
                RectF frameRect = PanoramaPreview.this.mDetector.getFrameRect();
                String access$5002 = Panorama3Module.TAG;
                Log.v(access$5002, "frame_rect = " + frameRect);
                Point point = new Point();
                if (PanoramaPreview.this.this$0.mDirection == 3) {
                    point.x = (int) frameRect.right;
                } else {
                    point.x = (int) frameRect.left;
                }
                point.y = (int) frameRect.centerY();
                synchronized (Panorama3Module.mPreviewImageLock) {
                    if (PanoramaPreview.this.this$0.mDispPreviewImage == null) {
                        Log.w(Panorama3Module.TAG, "mPreviewImage is null in UiUpdateRunnable");
                    } else {
                        int width = PanoramaPreview.this.this$0.mDispPreviewImage.getWidth();
                        int height = PanoramaPreview.this.this$0.mDispPreviewImage.getHeight();
                    }
                }
            }

            public void setDetectResult(int i) {
                this.mDetectResult = i;
            }
        }

        @TargetApi(21)
        public PanoramaPreview(Panorama3Module panorama3Module) {
            Panorama3Module panorama3Module2 = panorama3Module;
            this.this$0 = panorama3Module2;
            int scale = panorama3Module.mDirectionFunction.getScale();
            Size previewSize = panorama3Module.mDirectionFunction.getPreviewSize();
            Log.d(Panorama3Module.TAG, String.format(Locale.US, "previewSize %dx%d, scale %d", new Object[]{Integer.valueOf(previewSize.getWidth()), Integer.valueOf(previewSize.getHeight()), Integer.valueOf(scale)}));
            this.mPreviewImgWidth = previewSize.getWidth();
            this.mPreviewImgHeight = previewSize.getHeight();
            String access$500 = Panorama3Module.TAG;
            Log.d(access$500, "mPreviewImgWidth = " + this.mPreviewImgWidth + ", mPreviewImgHeight = " + this.mPreviewImgHeight);
            int previewImage = panorama3Module.mMorphoPanoramaGP3.setPreviewImage(this.mPreviewImgWidth, this.mPreviewImgHeight);
            if (previewImage != 0) {
                Log.e(Panorama3Module.TAG, String.format(Locale.US, "setPreviewImage error ret:0x%08X", new Object[]{Integer.valueOf(previewImage)}));
            }
            ModeProtocol.PanoramaProtocol panoramaProtocol = (ModeProtocol.PanoramaProtocol) ModeCoordinatorImpl.getInstance().getAttachProtocol(176);
            if (panoramaProtocol != null) {
                PositionDetector positionDetector = new PositionDetector(panorama3Module.mInitParam, panoramaProtocol.getPreivewContainer(), false, panorama3Module2.mCameraDisplayOrientation, panorama3Module.mPictureWidth, panorama3Module.mPictureHeight, panorama3Module.mDirectionFunction.getDirection(), panorama3Module.mMaxWidth, panorama3Module.mMaxHeight);
                this.mDetector = positionDetector;
                panorama3Module.mRoundDetector.setStartPosition(panorama3Module.mInitParam.output_rotation, 1, panorama3Module.mViewAngleH, panorama3Module.mViewAngleV, false);
                allocateDisplayBuffers();
            }
        }

        private void allocateDisplayBuffers() {
            synchronized (Panorama3Module.mPreviewImageLock) {
                if (!(this.this$0.mPreviewImage == null || (this.this$0.mPreviewImage.getWidth() == this.mPreviewImgWidth && this.this$0.mPreviewImage.getHeight() == this.mPreviewImgHeight))) {
                    this.this$0.mPreviewImage.recycle();
                    Bitmap unused = this.this$0.mPreviewImage = null;
                    this.this$0.mDispPreviewImage.recycle();
                    Bitmap unused2 = this.this$0.mDispPreviewImage = null;
                }
                if (this.this$0.mPreviewImage == null) {
                    Bitmap unused3 = this.this$0.mPreviewImage = Bitmap.createBitmap(this.mPreviewImgWidth, this.mPreviewImgHeight, Bitmap.Config.ARGB_8888);
                    Bitmap unused4 = this.this$0.mDispPreviewImage = Bitmap.createBitmap(Util.sWindowWidth, this.this$0.mSmallPreviewHeight, Bitmap.Config.ARGB_8888);
                    int unused5 = this.this$0.mAttachPosOffsetY = ((this.this$0.mDispPreviewImage.getWidth() * this.this$0.mPictureWidth) / this.this$0.mPictureHeight) / 2;
                    String access$500 = Panorama3Module.TAG;
                    Log.d(access$500, "mAttachPosOffsetY = " + this.this$0.mAttachPosOffsetY);
                    Canvas unused6 = this.this$0.mDispPreviewImageCanvas = new Canvas(this.this$0.mDispPreviewImage);
                    Paint unused7 = this.this$0.mDispPreviewImagePaint = new Paint();
                    this.this$0.mDispPreviewImagePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
                }
            }
        }

        /* access modifiers changed from: private */
        public void attachEnd(int i) {
            this.this$0.initAttachQueue();
            this.listener.requestEnd(this, i);
            if (i == 0) {
                this.this$0.stopPanoramaShooting(true);
            }
        }

        public boolean onSaveImage(CaptureImage captureImage) {
            this.this$0.addAttachQueue(captureImage);
            if (!this.mHasSubmit) {
                Log.d(Panorama3Module.TAG, "submit PreviewAttach");
                this.this$0.mExecutor.submit(new PreviewAttach());
                this.mHasSubmit = true;
            }
            return true;
        }
    }

    private class SaveOutputImageTask extends AsyncTask<Void, Integer, Integer> {
        private boolean mSaveImage;
        private long start_time;

        SaveOutputImageTask(boolean z) {
            this.mSaveImage = z;
        }

        private void savePanoramaPicture() {
            Log.d(Panorama3Module.TAG, "savePanoramaPicture start");
            synchronized (Panorama3Module.mEngineLock) {
                try {
                    Log.d(Panorama3Module.TAG, "savePanoramaPicture enter mEngineLock");
                    if (Panorama3Module.this.mMorphoPanoramaGP3 == null) {
                        Log.w(Panorama3Module.TAG, "savePanoramaPicture while mMorphoPanoramaGP3 is null");
                        Panorama3Module.this.finishEngine();
                    } else if (!this.mSaveImage) {
                        Log.w(Panorama3Module.TAG, String.format("savePanoramaPicture, don't save image", new Object[0]));
                        int end = Panorama3Module.this.mMorphoPanoramaGP3.end(1, (double) Panorama3Module.this.mRoundDetector.currentDegree0Base());
                        if (end != 0) {
                            Log.e(Panorama3Module.TAG, String.format("savePanoramaPicture, end() -> 0x%x", new Object[]{Integer.valueOf(end)}));
                        }
                        Panorama3Module.this.finishEngine();
                    } else {
                        int noiseReductionParam = Panorama3Module.this.mMorphoPanoramaGP3.setNoiseReductionParam(0);
                        if (noiseReductionParam != 0) {
                            String access$500 = Panorama3Module.TAG;
                            Log.e(access$500, "setNoiseReductionParam error ret:" + noiseReductionParam);
                        }
                        int unsharpStrength = Panorama3Module.this.mMorphoPanoramaGP3.setUnsharpStrength(1536);
                        if (unsharpStrength != 0) {
                            Log.e(Panorama3Module.TAG, String.format(Locale.US, "setUnsharpStrength error ret:0x%08X", new Object[]{Integer.valueOf(unsharpStrength)}));
                        }
                        int end2 = Panorama3Module.this.mMorphoPanoramaGP3.end(1, (double) Panorama3Module.this.mRoundDetector.currentDegree0Base());
                        if (end2 != 0) {
                            Log.e(Panorama3Module.TAG, String.format("savePanoramaPicture, end() -> 0x%x", new Object[]{Integer.valueOf(end2)}));
                            Panorama3Module.this.finishEngine();
                            return;
                        }
                        Rect rect = new Rect();
                        int clippingRect = Panorama3Module.this.mMorphoPanoramaGP3.getClippingRect(rect);
                        if (clippingRect != 0) {
                            Log.e(Panorama3Module.TAG, String.format("getClippingRect() -> 0x%x", new Object[]{Integer.valueOf(clippingRect)}));
                            Panorama3Module.this.finishEngine();
                            return;
                        }
                        int width = rect.width();
                        int height = rect.height();
                        if (width != 0) {
                            if (height != 0) {
                                int createOutputImage = Panorama3Module.this.mMorphoPanoramaGP3.createOutputImage(rect);
                                if (createOutputImage != 0) {
                                    String access$5002 = Panorama3Module.TAG;
                                    Log.e(access$5002, "createOutputImage error ret:" + createOutputImage);
                                    Panorama3Module.this.finishEngine();
                                    return;
                                }
                                String access$1200 = Panorama3Module.this.createNameString(Panorama3Module.this.mTimeTaken);
                                String generateFilepath4Image = Storage.generateFilepath4Image(access$1200, false);
                                if (!Panorama3Module.this.savePanoramaFile(generateFilepath4Image, width, height)) {
                                    Panorama3Module.this.finishEngine();
                                    return;
                                }
                                Panorama3Module.this.addImageAsApplication(generateFilepath4Image, access$1200, width, height, Panorama3Module.this.calibrateRotation(1));
                                Panorama3Module.this.finishEngine();
                                Log.d(Panorama3Module.TAG, "savePanoramaPicture end");
                                return;
                            }
                        }
                        String access$5003 = Panorama3Module.TAG;
                        Log.e(access$5003, "getClippingRect() " + rect);
                        Panorama3Module.this.finishEngine();
                    }
                } catch (Throwable th) {
                    Panorama3Module.this.finishEngine();
                    throw th;
                }
            }
        }

        /* access modifiers changed from: protected */
        public Integer doInBackground(Void... voidArr) {
            Log.v(Panorama3Module.TAG, "doInBackground>>");
            savePanoramaPicture();
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Integer num) {
            Log.d(Panorama3Module.TAG, "PanoramaFinish done");
            Camera camera = Panorama3Module.this.mActivity;
            if (camera != null) {
                AutoLockManager.getInstance(camera).hibernateDelayed();
            }
            if (Panorama3Module.this.mPaused) {
                boolean unused = Panorama3Module.this.mIsShooting = false;
                Log.w(Panorama3Module.TAG, "panorama mode has been paused");
                return;
            }
            if (camera != null) {
                camera.getThumbnailUpdater().updateThumbnailView(true);
            }
            Panorama3Module.this.enableCameraControls(true);
            Panorama3Module.this.mHandler.post(new Runnable() {
                public void run() {
                    Panorama3Module.this.handlePendingScreenSlide();
                }
            });
            boolean unused2 = Panorama3Module.this.mIsShooting = false;
            Log.d(Panorama3Module.TAG, String.format(Locale.ENGLISH, "[MORTIME] PanoramaFinish time = %d", new Object[]{Long.valueOf(System.currentTimeMillis() - this.start_time)}));
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            this.start_time = System.currentTimeMillis();
        }
    }

    public interface SensorListener {
        void onSensorChanged(SensorEvent sensorEvent);
    }

    private static /* synthetic */ void $closeResource(Throwable th, AutoCloseable autoCloseable) {
        if (th != null) {
            try {
                autoCloseable.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        } else {
            autoCloseable.close();
        }
    }

    public Panorama3Module() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "PanoramaThread");
            }
        }, new RejectedExecutionHandler() {
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                String access$500 = Panorama3Module.TAG;
                Log.w(access$500, "rejectedExecution " + runnable);
            }
        });
        this.mExecutor = threadPoolExecutor;
        this.mCanSavePanorama = false;
        this.mRequestStop = false;
    }

    /* access modifiers changed from: private */
    public void addAttachQueue(CaptureImage captureImage) {
        if (captureImage == null) {
            Log.w(TAG, "addAttachQueue failed due to image is null");
            return;
        }
        boolean z = false;
        try {
            if (this.mRequestStop) {
                Log.w(TAG, "addAttachQueue failed due to request stop");
                captureImage.close();
                return;
            }
            z = this.mAttachImageQueue.offer(captureImage);
            while (this.mAttachImageQueue.size() > 1) {
                CaptureImage poll = this.mAttachImageQueue.poll();
                if (poll != null) {
                    poll.close();
                }
            }
            Log.v(TAG, "addAttachQueue");
        } finally {
            if (!z) {
                captureImage.close();
            }
        }
    }

    /* access modifiers changed from: private */
    public void addImageAsApplication(String str, String str2, int i, int i2, int i3) {
        Throwable th;
        String str3 = str;
        int i4 = i3;
        Location currentLocation = LocationManager.instance().getCurrentLocation();
        if (!Storage.isUseDocumentMode()) {
            ExifHelper.writeExifByFilePath(str3, i4, currentLocation, this.mTimeTaken);
        } else {
            try {
                ParcelFileDescriptor parcelFileDescriptor = FileCompat.getParcelFileDescriptor(str3, true);
                try {
                    ExifHelper.writeExifByFd(parcelFileDescriptor.getFileDescriptor(), i4, currentLocation, this.mTimeTaken);
                    if (parcelFileDescriptor != null) {
                        $closeResource((Throwable) null, parcelFileDescriptor);
                    }
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    if (parcelFileDescriptor != null) {
                        $closeResource(th, parcelFileDescriptor);
                    }
                    throw th3;
                }
            } catch (Exception e2) {
                String str4 = TAG;
                Log.e(str4, "open file failed, filePath " + str3, (Throwable) e2);
            }
        }
        boolean z = currentLocation != null;
        Uri addImageForGroupOrPanorama = Storage.addImageForGroupOrPanorama(CameraAppImpl.getAndroidContext(), str, i3, this.mTimeTaken, this.mLocation, i, i2);
        if (addImageForGroupOrPanorama == null) {
            String str5 = TAG;
            Log.w(str5, "insert MediaProvider failed, attempt to find uri by path, " + str3);
            addImageForGroupOrPanorama = MediaProviderUtil.getContentUriFromPath(CameraAppImpl.getAndroidContext(), str3);
        }
        Uri uri = addImageForGroupOrPanorama;
        String str6 = TAG;
        Log.d(str6, "addImageAsApplication uri = " + uri + ", path = " + str3);
        HashMap hashMap = new HashMap();
        hashMap.put(MistatsConstants.Manual.PARAM_3A_LOCKED, false);
        boolean z2 = z;
        trackGeneralInfo(hashMap, 1, false, (BeautyValues) null, z2, 0);
        MistatsWrapper.PictureTakenParameter pictureTakenParameter = new MistatsWrapper.PictureTakenParameter();
        pictureTakenParameter.takenNum = 1;
        pictureTakenParameter.burst = false;
        pictureTakenParameter.location = z2;
        pictureTakenParameter.aiSceneName = null;
        pictureTakenParameter.isEnteringMoon = false;
        pictureTakenParameter.isSelectMoonMode = false;
        pictureTakenParameter.beautyValues = null;
        trackPictureTaken(pictureTakenParameter);
        Camera camera = this.mActivity;
        if (isCreated() && camera != null) {
            camera.getScreenHint().updateHint();
            if (uri != null) {
                camera.onNewUriArrived(uri, str2);
                Thumbnail createThumbnailFromUri = Thumbnail.createThumbnailFromUri(camera, uri, false);
                Util.broadcastNewPicture(camera, uri);
                camera.getThumbnailUpdater().setThumbnail(createThumbnailFromUri, false, false);
            }
        }
    }

    /* access modifiers changed from: private */
    public int calibrateRotation(int i) {
        if (!(i == 0 || i == 90 || i == 180 || i == 270)) {
            i = 0;
        }
        return (i + this.mDeviceOrientationAtCapture) % 360;
    }

    /* access modifiers changed from: private */
    public boolean configMorphoPanoramaGP3() {
        Log.d(TAG, "configMorphoPanoramaGP3 start");
        this.mMorphoPanoramaGP3.setAttachEnabled(true);
        this.mMorphoPanoramaGP3.disableSaveInputImages();
        int shrinkRatio = this.mMorphoPanoramaGP3.setShrinkRatio((double) this.mPanoramaSetting.getShrink_ratio());
        if (shrinkRatio != 0) {
            Log.e(TAG, String.format(Locale.US, "setShrinkRatio error ret:0x%08X", new Object[]{Integer.valueOf(shrinkRatio)}));
        }
        int calcseamPixnum = this.mMorphoPanoramaGP3.setCalcseamPixnum(this.mPanoramaSetting.getCalcseam_pixnum());
        if (calcseamPixnum != 0) {
            Log.e(TAG, String.format(Locale.US, "setCalcseamPixnum error ret:0x%08X", new Object[]{Integer.valueOf(calcseamPixnum)}));
        }
        int useDeform = this.mMorphoPanoramaGP3.setUseDeform(this.mPanoramaSetting.isUse_deform());
        if (useDeform != 0) {
            Log.e(TAG, String.format(Locale.US, "setUseDeform error ret:0x%08X", new Object[]{Integer.valueOf(useDeform)}));
        }
        int useLuminanceCorrection = this.mMorphoPanoramaGP3.setUseLuminanceCorrection(this.mPanoramaSetting.isUse_luminance_correction());
        if (useLuminanceCorrection != 0) {
            Log.e(TAG, String.format(Locale.US, "setUseLuminanceCorrection error ret:0x%08X", new Object[]{Integer.valueOf(useLuminanceCorrection)}));
        }
        int seamsearchRatio = this.mMorphoPanoramaGP3.setSeamsearchRatio(this.mPanoramaSetting.getSeamsearch_ratio());
        if (seamsearchRatio != 0) {
            Log.e(TAG, String.format(Locale.US, "setSeamsearchRatio error ret:0x%08X", new Object[]{Integer.valueOf(seamsearchRatio)}));
        }
        int zrotationCoeff = this.mMorphoPanoramaGP3.setZrotationCoeff(this.mPanoramaSetting.getZrotation_coeff());
        if (zrotationCoeff != 0) {
            Log.e(TAG, String.format(Locale.US, "setZrotationCoeff error ret:0x%08X", new Object[]{Integer.valueOf(zrotationCoeff)}));
        }
        int drawThreshold = this.mMorphoPanoramaGP3.setDrawThreshold(this.mPanoramaSetting.getDraw_threshold());
        if (drawThreshold != 0) {
            Log.e(TAG, String.format(Locale.US, "setDrawThreshold error ret:0x%08X", new Object[]{Integer.valueOf(drawThreshold)}));
        }
        int aovGain = this.mMorphoPanoramaGP3.setAovGain(this.mPanoramaSetting.getAov_gain());
        if (aovGain != 0) {
            Log.e(TAG, String.format(Locale.US, "setAovGain error ret:0x%08X", new Object[]{Integer.valueOf(aovGain)}));
        }
        int distortionCorrectionParam = this.mMorphoPanoramaGP3.setDistortionCorrectionParam(this.mPanoramaSetting.getDistortion_k1(), this.mPanoramaSetting.getDistortion_k2(), this.mPanoramaSetting.getDistortion_k3(), this.mPanoramaSetting.getDistortion_k4());
        if (distortionCorrectionParam != 0) {
            Log.e(TAG, String.format(Locale.US, "setDistortionCorrectionParam error ret:0x%08X", new Object[]{Integer.valueOf(distortionCorrectionParam)}));
        }
        int rotationRatio = this.mMorphoPanoramaGP3.setRotationRatio(this.mPanoramaSetting.getRotation_ratio());
        if (rotationRatio != 0) {
            Log.e(TAG, String.format(Locale.US, "setRotationRatio error ret:0x%08X", new Object[]{Integer.valueOf(rotationRatio)}));
        }
        int sensorUseMode = this.mMorphoPanoramaGP3.setSensorUseMode(0);
        if (sensorUseMode != 0) {
            Log.e(TAG, String.format(Locale.US, "setSensorUseMode error ret:0x%08X", new Object[]{Integer.valueOf(sensorUseMode)}));
        }
        int projectionMode = this.mMorphoPanoramaGP3.setProjectionMode(0);
        if (projectionMode != 0) {
            Log.e(TAG, String.format(Locale.US, "setProjectionMode error ret:0x%08X", new Object[]{Integer.valueOf(projectionMode)}));
        }
        int motionDetectionMode = this.mMorphoPanoramaGP3.setMotionDetectionMode(0);
        if (motionDetectionMode != 0) {
            Log.e(TAG, String.format(Locale.US, "setMotionDetectionMode error ret:0x%08X", new Object[]{Integer.valueOf(motionDetectionMode)}));
        }
        Log.d(TAG, "configMorphoPanoramaGP3 end");
        return true;
    }

    public static String createDateStringForAppSeg(long j) {
        Date date = new Date(j);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(date);
    }

    /* access modifiers changed from: private */
    public boolean createEngine() {
        if (this.mMorphoPanoramaGP3 != null) {
            Log.w(TAG, "finish prior Engine");
            finishEngine();
        }
        this.mMorphoPanoramaGP3 = new MorphoPanoramaGP3();
        if (PanoramaGP3ImageFormat.YUV420_PLANAR.equals(this.mImageFormat)) {
            MorphoPanoramaGP3.InitParam initParam = this.mInitParam;
            initParam.input_format = this.mImageFormat;
            initParam.output_format = PanoramaGP3ImageFormat.YUV420_SEMIPLANAR;
        } else {
            MorphoPanoramaGP3.InitParam initParam2 = this.mInitParam;
            String str = this.mImageFormat;
            initParam2.input_format = str;
            initParam2.output_format = str;
        }
        MorphoPanoramaGP3.InitParam initParam3 = this.mInitParam;
        initParam3.input_width = this.mPictureWidth;
        initParam3.input_height = this.mPictureHeight;
        initParam3.aovx = (double) this.mViewAngleH;
        initParam3.aovy = (double) this.mViewAngleV;
        initParam3.direction = CameraSettings.getPanoramaMoveDirection(this.mActivity);
        int displayRotation = Util.getDisplayRotation(this.mActivity);
        int i = this.mOrientation;
        if (i == -1) {
            this.mInitParam.output_rotation = ((this.mCameraOrientation + displayRotation) + 360) % 360;
        } else {
            this.mInitParam.output_rotation = (((this.mCameraOrientation + displayRotation) + i) + 360) % 360;
        }
        String cameraLensType = CameraSettings.getCameraLensType(166);
        String str2 = TAG;
        Log.d(str2, "lensType " + cameraLensType);
        if (ComponentManuallyDualLens.LENS_WIDE.equals(cameraLensType)) {
            this.mInitParam.goal_angle = (double) this.mGoalAngle;
        } else if (Build.DEVICE.equals("cepheus")) {
            this.mInitParam.goal_angle = 152.18d;
        } else {
            this.mInitParam.goal_angle = ((double) this.mGoalAngle) * 0.6265d;
        }
        int i2 = this.mCameraOrientation;
        int rotation = this.mSensorFusion.setRotation(i2 != 90 ? i2 != 180 ? i2 != 270 ? 0 : 3 : 2 : 1);
        if (rotation != 0) {
            Log.e(TAG, String.format(Locale.US, "SensorFusion.setRotation error ret:0x%08X", new Object[]{Integer.valueOf(rotation)}));
        }
        initializeEngine(this.mMorphoPanoramaGP3, this.mInitParam);
        return true;
    }

    /* access modifiers changed from: private */
    public String createNameString(long j) {
        return DateFormat.format(getString(R.string.pano_file_name_format), j).toString();
    }

    private void doLaterReleaseIfNeed() {
        Camera camera = this.mActivity;
        if (camera != null && camera.isActivityPaused()) {
            this.mActivity.pause();
            this.mActivity.releaseAll(true, true);
        }
    }

    /* access modifiers changed from: private */
    public void finishEngine() {
        if (this.mMorphoPanoramaGP3 != null) {
            Log.d(TAG, "finishEngine start");
            this.mMorphoPanoramaGP3.deleteNativeOutputInfo();
            int finish = this.mMorphoPanoramaGP3.finish(true);
            if (finish != 0) {
                Log.e(TAG, String.format(Locale.US, "finish error ret:0x%08X", new Object[]{Integer.valueOf(finish)}));
            }
            Log.d(TAG, "finishEngine end");
            this.mMorphoPanoramaGP3 = null;
        }
    }

    /* access modifiers changed from: private */
    public void initAttachQueue() {
        while (this.mAttachImageQueue.size() > 0) {
            CaptureImage poll = this.mAttachImageQueue.poll();
            if (poll != null) {
                poll.close();
            }
        }
        Log.d(TAG, "initAttachQueue");
    }

    /* access modifiers changed from: private */
    public void initPreviewLayout() {
        if (isAlive()) {
            CameraScreenNail cameraScreenNail = this.mActivity.getCameraScreenNail();
            CameraSize cameraSize = this.mPreviewSize;
            cameraScreenNail.setPreviewSize(cameraSize.width, cameraSize.height);
            CameraScreenNail cameraScreenNail2 = this.mActivity.getCameraScreenNail();
            int width = cameraScreenNail2.getWidth();
            int dimensionPixelSize = this.mActivity.getResources().getDimensionPixelSize(R.dimen.pano_preview_hint_frame_height);
            int height = (width * dimensionPixelSize) / ((int) (((float) cameraScreenNail2.getHeight()) * this.mLongSideCropRatio));
            CameraSize cameraSize2 = this.mPreviewSize;
            ((ModeProtocol.PanoramaProtocol) ModeCoordinatorImpl.getInstance().getAttachProtocol(176)).initPreviewLayout(height, dimensionPixelSize, cameraSize2.width, cameraSize2.height);
        }
    }

    private boolean initializeEngine(MorphoPanoramaGP3 morphoPanoramaGP3, MorphoPanoramaGP3.InitParam initParam) {
        Log.d(TAG, "initializeEngine start");
        int createNativeOutputInfo = morphoPanoramaGP3.createNativeOutputInfo();
        if (createNativeOutputInfo != 0) {
            Log.e(TAG, String.format(Locale.US, "createNativeOutputInfo error ret:0x%08X", new Object[]{Integer.valueOf(createNativeOutputInfo)}));
        }
        int initialize = morphoPanoramaGP3.initialize(initParam);
        if (initialize != 0) {
            Log.e(TAG, String.format(Locale.US, "initialize error ret:0x%08X", new Object[]{Integer.valueOf(initialize)}));
            return false;
        }
        Log.e(TAG, "initializeEngine end");
        return true;
    }

    private boolean isProcessingFinishTask() {
        SaveOutputImageTask saveOutputImageTask = this.mSaveOutputImageTask;
        return (saveOutputImageTask == null || saveOutputImageTask.getStatus() == AsyncTask.Status.FINISHED) ? false : true;
    }

    private boolean isShootingTooShort() {
        return SystemClock.elapsedRealtime() - this.mPanoramaShootingStartTime < 600;
    }

    private void keepScreenOnAwhile() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(17, 1000);
        }
    }

    /* access modifiers changed from: private */
    public void onCaptureOrientationDecided() {
        Log.d(TAG, "onCaptureOrientationDecided");
        ((ModeProtocol.PanoramaProtocol) ModeCoordinatorImpl.getInstance().getAttachProtocol(176)).onCaptureOrientationDecided(this.mDirection, this.mAttachPosOffsetX, this.mAttachPosOffsetY);
        this.mCaptureOrientationDecided = true;
    }

    /* access modifiers changed from: private */
    public void onPreviewMoving() {
        ((ModeProtocol.PanoramaProtocol) ModeCoordinatorImpl.getInstance().getAttachProtocol(176)).onPreviewMoving();
    }

    private void onSaveFinish() {
        if (isAlive()) {
            Camera2Proxy camera2Proxy = this.mCamera2Device;
            if (camera2Proxy != null) {
                if (this.mAeLockSupported) {
                    camera2Proxy.setAELock(false);
                }
                if (this.mAwbLockSupported) {
                    this.mCamera2Device.setAWBLock(false);
                }
                this.mCamera2Device.setFocusMode(this.mTargetFocusMode);
                startPreview();
                ModeProtocol.RecordState recordState = (ModeProtocol.RecordState) ModeCoordinatorImpl.getInstance().getAttachProtocol(212);
                if (recordState != null) {
                    recordState.onPostSavingFinish();
                }
            }
        }
    }

    private void onStopShooting(boolean z) {
        ModeProtocol.RecordState recordState = (ModeProtocol.RecordState) ModeCoordinatorImpl.getInstance().getAttachProtocol(212);
        if (recordState == null) {
            String str = TAG;
            Log.w(str, "onStopShooting recordState is null, succeed = " + z);
            return;
        }
        if (z) {
            recordState.onPostSavingStart();
        } else {
            recordState.onFailed();
        }
        Bitmap bitmap = this.mDispPreviewImage;
        if (bitmap != null) {
            bitmap.eraseColor(0);
        }
        onSaveFinish();
    }

    /* access modifiers changed from: private */
    public void reInitGravitySensorData() {
        float[] fArr = this.mGravities;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        this.mSensorCnt = 0;
    }

    private void registerSensorListener() {
        if (!this.mIsRegisterSensorListener) {
            this.mIsRegisterSensorListener = true;
            this.mIsSensorAverage = false;
            this.mSensorCnt = 0;
            this.mGravities = new float[3];
            this.mRoundDetector = new GyroscopeRoundDetector();
            this.mActivity.getSensorStateManager().setSensorStateListener(this.mSensorStateListener);
            this.mActivity.getSensorStateManager().register(186);
        }
    }

    private void requestStopShoot() {
        addAttachQueue(sAttachExit);
        this.mRequestStop = true;
    }

    private void resetScreenOn() {
        this.mHandler.removeMessages(17);
        this.mHandler.removeMessages(2);
    }

    /* JADX WARNING: type inference failed for: r10v1 */
    /* JADX WARNING: type inference failed for: r10v2 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Incorrect type for immutable var: ssa=int, code=?, for r10v0, types: [int, boolean] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008c  */
    public boolean savePanoramaFile(String str, int i, int i2) {
        ? r10;
        int i3;
        ParcelFileDescriptor parcelFileDescriptor;
        Throwable th;
        String str2 = str;
        MorphoPanoramaGP3.GalleryInfoData galleryInfoData = new MorphoPanoramaGP3.GalleryInfoData();
        int integer = (CameraSettings.getEncodingQuality(false).toInteger(false) * 256) / 100;
        if (Storage.isUseDocumentMode()) {
            try {
                ParcelFileDescriptor parcelFileDescriptor2 = FileCompat.getParcelFileDescriptor(str2, true);
                try {
                    parcelFileDescriptor = parcelFileDescriptor2;
                    try {
                        i3 = this.mMorphoPanoramaGP3.savePanorama360(i, i2, parcelFileDescriptor2.getFileDescriptor(), integer, this.mShutterStartTime, this.mShutterEndTime, false, galleryInfoData, false);
                        if (parcelFileDescriptor != null) {
                            try {
                                $closeResource((Throwable) null, parcelFileDescriptor);
                            } catch (Exception e2) {
                                e = e2;
                            }
                        }
                        r10 = 1;
                    } catch (Throwable th2) {
                        th = th2;
                        th = th;
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    parcelFileDescriptor = parcelFileDescriptor2;
                    th = th;
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                i3 = -1;
                String str3 = TAG;
                Log.e(str3, "open file failed, filePath " + str2, (Throwable) e);
                r10 = 1;
                if (i3 != 0) {
                }
            } catch (Throwable th4) {
                Throwable th5 = th4;
                if (parcelFileDescriptor != null) {
                    $closeResource(th, parcelFileDescriptor);
                }
                throw th5;
            }
        } else {
            r10 = 1;
            i3 = this.mMorphoPanoramaGP3.savePanorama360(i, i2, str, integer, this.mShutterStartTime, this.mShutterEndTime, false, galleryInfoData, false);
        }
        if (i3 != 0) {
            Log.d(TAG, galleryInfoData.toString());
            return r10;
        }
        String str4 = TAG;
        Object[] objArr = new Object[r10];
        objArr[0] = Integer.valueOf(i3);
        Log.e(str4, String.format("savePanorama360() -> 0x%x", objArr));
        return false;
    }

    /* access modifiers changed from: private */
    public void setInitialRotationByGravity() {
        if (this.mMorphoPanoramaGP3 != null) {
            int i = this.mSensorCnt;
            if (i > 0) {
                float[] fArr = this.mGravities;
                float f2 = fArr[0] / ((float) i);
                float f3 = fArr[1] / ((float) i);
                float f4 = fArr[2] / ((float) i);
                Log.d(TAG, String.format(Locale.US, "Gravity Sensor Value X=%f Y=%f Z=%f cnt=%d", new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Integer.valueOf(this.mSensorCnt)}));
                int initialRotationByGravity = this.mMorphoPanoramaGP3.setInitialRotationByGravity((double) f2, (double) f3, (double) f4);
                if (initialRotationByGravity != 0) {
                    Log.e(TAG, String.format(Locale.US, "setInitialRotationByGravity error ret:0x%08X", new Object[]{Integer.valueOf(initialRotationByGravity)}));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void setSensorFusionValue(CaptureImage captureImage) {
        if (this.mMorphoPanoramaGP3 != null) {
            SensorFusion sensorFusion = this.mSensorFusion;
            if (sensorFusion != null) {
                int[] iArr = new int[4];
                int sensorMatrix = sensorFusion.getSensorMatrix((double[]) null, (double[]) null, (double[]) null, iArr);
                if (sensorMatrix != 0) {
                    Log.e(TAG, String.format(Locale.US, "SensorFusion.getSensorMatrix error ret:0x%08X", new Object[]{Integer.valueOf(sensorMatrix)}));
                }
                ArrayList<ArrayList<MorphoSensorFusion.SensorData>> stockData = this.mSensorFusion.getStockData();
                SensorInfoManager sensorInfoManager = new SensorInfoManager(4);
                sensorInfoManager.g_ix = iArr[0];
                sensorInfoManager.r_ix = iArr[3];
                sensorInfoManager.a_ix = iArr[1];
                sensorInfoManager.img_ix = this.mMorphoPanoramaGP3.getAttachCount();
                sensorInfoManager.timeMillis = System.currentTimeMillis();
                sensorInfoManager.imageTimeStamp = captureImage.getTimestamp();
                sensorInfoManager.sensitivity = captureImage.getSensitivity();
                sensorInfoManager.exposureTime = captureImage.getExposureTime();
                sensorInfoManager.rollingShutterSkew = captureImage.getRollingShutterSkew();
                sensorInfoManager.sensorTimeStamp = captureImage.getSensorTimeStamp();
                sensorInfoManager.sensorData[0] = (ArrayList) stockData.get(0).clone();
                sensorInfoManager.sensorData[3] = (ArrayList) stockData.get(3).clone();
                sensorInfoManager.sensorData[1] = (ArrayList) stockData.get(1).clone();
                if (sensorInfoManager.sensorData[0].isEmpty()) {
                    int size = this.mSensorInfoManagerList.size();
                    if (size > 0) {
                        SensorInfoManager sensorInfoManager2 = this.mSensorInfoManagerList.get(size - 1);
                        sensorInfoManager.g_ix = sensorInfoManager2.g_ix;
                        sensorInfoManager.sensorData[0] = sensorInfoManager2.sensorData[0];
                    }
                }
                if (sensorInfoManager.sensorData[3].isEmpty()) {
                    int size2 = this.mSensorInfoManagerList.size();
                    if (size2 > 0) {
                        SensorInfoManager sensorInfoManager3 = this.mSensorInfoManagerList.get(size2 - 1);
                        sensorInfoManager.r_ix = sensorInfoManager3.r_ix;
                        sensorInfoManager.sensorData[3] = sensorInfoManager3.sensorData[3];
                    }
                }
                if (sensorInfoManager.sensorData[1].isEmpty()) {
                    int size3 = this.mSensorInfoManagerList.size();
                    if (size3 > 0) {
                        SensorInfoManager sensorInfoManager4 = this.mSensorInfoManagerList.get(size3 - 1);
                        sensorInfoManager.a_ix = sensorInfoManager4.a_ix;
                        sensorInfoManager.sensorData[1] = sensorInfoManager4.sensorData[1];
                    }
                }
                this.mCurrentSensorInfoManager = sensorInfoManager;
                this.mSensorInfoManagerList.add(sensorInfoManager);
                long attachCount = this.mMorphoPanoramaGP3.getAttachCount();
                int size4 = stockData.get(0).size();
                if (size4 > 0 && attachCount > 0) {
                    int gyroscopeData = this.mMorphoPanoramaGP3.setGyroscopeData((MorphoSensorFusion.SensorData[]) stockData.get(0).toArray(new MorphoSensorFusion.SensorData[size4]));
                    if (gyroscopeData != 0) {
                        Log.e(TAG, String.format(Locale.US, "setGyroscopeData error ret:0x%08X", new Object[]{Integer.valueOf(gyroscopeData)}));
                    }
                }
                this.mSensorFusion.clearStockData();
            }
        }
    }

    private void setupCaptureParams() {
        Camera2Proxy camera2Proxy = this.mCamera2Device;
        if (camera2Proxy == null) {
            Log.e(TAG, "camera device is not ready");
            return;
        }
        camera2Proxy.setFocusMode(this.mTargetFocusMode);
        this.mCamera2Device.setZoomRatio(1.0f);
        this.mCamera2Device.setFlashMode(0);
        String antiBanding = CameraSettings.getAntiBanding();
        this.mCamera2Device.setAntiBanding(Integer.valueOf(antiBanding).intValue());
        String str = TAG;
        Log.d(str, "antiBanding=" + antiBanding);
        this.mCamera2Device.setEnableZsl(isZslPreferred());
        this.mCamera2Device.setHHT(false);
        this.mCamera2Device.setEnableOIS(false);
        this.mCamera2Device.setTimeWaterMarkEnable(false);
        this.mCamera2Device.setFaceWaterMarkEnable(false);
    }

    /* access modifiers changed from: private */
    public void stopPanoramaShooting(boolean z) {
        stopPanoramaShooting(z, false);
    }

    private void stopPanoramaShooting(boolean z, boolean z2) {
        if (!this.mIsShooting) {
            Log.w(TAG, "stopPanoramaShooting while not shooting");
            return;
        }
        String str = TAG;
        Log.v(str, "stopPanoramaShooting: saveImage=" + z + ", isRelease=" + z2);
        requestStopShoot();
        keepScreenOnAwhile();
        this.mRoundDetector.stop();
        synchronized (this.mDeviceLock) {
            if (this.mCamera2Device != null) {
                if (z2) {
                    ModeProtocol.PanoramaProtocol panoramaProtocol = (ModeProtocol.PanoramaProtocol) ModeCoordinatorImpl.getInstance().getAttachProtocol(176);
                    if (panoramaProtocol != null) {
                        Log.d(TAG, "onPause setDisplayPreviewBitmap null");
                        panoramaProtocol.setDisplayPreviewBitmap((Bitmap) null);
                    }
                } else {
                    this.mCamera2Device.captureAbortBurst();
                }
                this.mCamera2Device.stopPreviewCallback(z2);
            }
        }
        boolean z3 = z && this.mCanSavePanorama;
        this.mShutterEndTime = createDateStringForAppSeg(System.currentTimeMillis());
        this.mSaveOutputImageTask = new SaveOutputImageTask(z3);
        this.mSaveOutputImageTask.execute(new Void[0]);
        onStopShooting(z3);
    }

    private void unRegisterSensorListener() {
        if (this.mIsRegisterSensorListener) {
            this.mIsRegisterSensorListener = false;
            this.mActivity.getSensorStateManager().setSensorStateListener((SensorStateManager.SensorStateListener) null);
            this.mActivity.getSensorStateManager().unregister(186);
        }
    }

    private void updatePictureAndPreviewSize() {
        CameraSize bestPanoPictureSize = getBestPanoPictureSize(this.mCameraCapabilities.getSupportedOutputSizeWithAssignedMode(256), DataRepository.dataItemFeature().hb());
        this.mPreviewSize = Util.getOptimalPreviewSize(false, this.mBogusCameraId, this.mCameraCapabilities.getSupportedOutputSizeWithAssignedMode(SurfaceTexture.class), (double) CameraSettings.getPreviewAspectRatio(bestPanoPictureSize.width, bestPanoPictureSize.height));
        this.mPictureSize = bestPanoPictureSize;
        CameraSize cameraSize = this.mPictureSize;
        this.mPictureWidth = cameraSize.width;
        this.mPictureHeight = cameraSize.height;
        String str = TAG;
        Log.d(str, "pictureSize= " + bestPanoPictureSize.width + "X" + bestPanoPictureSize.height + " previewSize=" + this.mPreviewSize.width + "X" + this.mPreviewSize.height);
        CameraSize cameraSize2 = this.mPreviewSize;
        updateCameraScreenNailSize(cameraSize2.width, cameraSize2.height);
    }

    public void closeCamera() {
        Log.d(TAG, "closeCamera: start");
        synchronized (this.mDeviceLock) {
            setCameraState(0);
            if (this.mCamera2Device != null) {
                this.mCamera2Device.setErrorCallback((Camera2Proxy.CameraErrorCallback) null);
                this.mCamera2Device.stopPreviewCallback(true);
                this.mCamera2Device = null;
            }
        }
        Log.d(TAG, "closeCamera: end");
    }

    public void consumePreference(@UpdateConstant.UpdateType int... iArr) {
        for (int i : iArr) {
            if (i == 1) {
                updatePictureAndPreviewSize();
            } else if (!(i == 2 || i == 5)) {
                if (i == 24) {
                    applyZoomRatio();
                } else if (i == 32) {
                    setupCaptureParams();
                } else if (i == 55) {
                    updateModuleRelated();
                } else if (i != 66) {
                    switch (i) {
                        case 46:
                        case 47:
                        case 48:
                            continue;
                        default:
                            if (!BaseModule.DEBUG) {
                                Log.w(TAG, "no consumer for this updateType: " + i);
                                break;
                            } else {
                                throw new RuntimeException("no consumer for this updateType: " + i);
                            }
                    }
                } else {
                    updateThermalLevel();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public CameraSize getBestPanoPictureSize(List<CameraSize> list, int i) {
        PictureSizeManager.initialize(list, i, this.mModuleIndex, this.mBogusCameraId);
        return PictureSizeManager.getBestPanoPictureSize();
    }

    /* access modifiers changed from: protected */
    public int getOperatingMode() {
        return 32776;
    }

    public boolean isDoingAction() {
        return isProcessingFinishTask();
    }

    public boolean isRecording() {
        return this.mIsShooting;
    }

    public boolean isUnInterruptable() {
        this.mUnInterruptableReason = null;
        if (this.mIsShooting) {
            this.mUnInterruptableReason = "shooting";
        }
        return this.mUnInterruptableReason != null;
    }

    /* access modifiers changed from: protected */
    public boolean isZoomEnabled() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean isZslPreferred() {
        return !b.isMTKPlatform();
    }

    /* access modifiers changed from: protected */
    public void keepScreenOn() {
        this.mHandler.removeMessages(17);
        this.mHandler.removeMessages(2);
        getWindow().addFlags(128);
    }

    public boolean onBackPressed() {
        if (!this.mIsShooting) {
            return false;
        }
        if (!isProcessingFinishTask()) {
            playCameraSound(3);
            stopPanoramaShooting(true);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onCameraOpened() {
        super.onCameraOpened();
        checkDisplayOrientation();
        updatePreferenceTrampoline(UpdateConstant.PANORAMA_TYPES_INIT);
        startSession();
        this.mHandler.sendEmptyMessage(9);
        Log.v(TAG, "SetupCameraThread done");
        this.mViewAngleH = this.mCameraCapabilities.getViewAngle(false);
        this.mViewAngleV = this.mCameraCapabilities.getViewAngle(true);
        if (b.xm.equals("lavender") && this.mViewAngleH > 50.0f) {
            this.mGoalAngle = 291;
        }
        this.mCameraOrientation = this.mCameraCapabilities.getSensorOrientation();
    }

    public void onCreate(int i, int i2) {
        super.onCreate(i, i2);
        this.mHandler = new MainHandler(this, this.mActivity.getMainLooper());
        this.mGoalAngle = DataRepository.dataItemFeature().gb();
        this.mLongSideCropRatio = DataRepository.dataItemFeature().fb();
        this.mSmallPreviewHeight = (int) this.mActivity.getResources().getDimension(R.dimen.pano_preview_hint_frame_height);
        EffectController.getInstance().setEffect(FilterInfo.FILTER_ID_NONE);
        onCameraOpened();
        this.mRoundDetector = new RoundDetector();
        this.mPanoramaSetting = new PanoramaSetting(this.mActivity.getApplicationContext());
        this.mSensorFusion = new SensorFusion(true);
        this.mSensorFusionMode = 1;
        int mode = this.mSensorFusion.setMode(this.mSensorFusionMode);
        if (mode != 0) {
            Log.e(TAG, String.format(Locale.US, "SensorFusion.setMode error ret:0x%08X", new Object[]{Integer.valueOf(mode)}));
        }
        int offsetMode = this.mSensorFusion.setOffsetMode(0);
        if (offsetMode != 0) {
            Log.e(TAG, String.format(Locale.US, "SensorFusion.setOffsetMode error ret:0x%08X", new Object[]{Integer.valueOf(offsetMode)}));
        }
        int appState = this.mSensorFusion.setAppState(1);
        if (appState != 0) {
            Log.e(TAG, String.format(Locale.US, "SensorFusion.setAppState error ret:0x%08X", new Object[]{Integer.valueOf(appState)}));
        }
        this.mSensorInfoManagerList = new ArrayList<>();
    }

    public void onDestroy() {
        super.onDestroy();
        this.mHandler.sendEmptyMessage(45);
        this.mExecutor.shutdown();
    }

    public void onHostStopAndNotifyActionStop() {
        playCameraSound(3);
        stopPanoramaShooting(true, true);
        synchronized (mPreviewImageLock) {
            if (this.mPreviewImage != null) {
                this.mPreviewImage.recycle();
                this.mPreviewImage = null;
            }
            if (this.mDispPreviewImage != null) {
                String str = TAG;
                Log.d(str, "onPause recycle bitmap " + this.mDispPreviewImage);
                this.mDispPreviewImage.recycle();
                this.mDispPreviewImage = null;
            }
        }
        doLaterReleaseIfNeed();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.mPaused) {
            return true;
        }
        boolean z = false;
        if (!isFrameAvailable()) {
            return false;
        }
        if (i == 27 || i == 66) {
            if (keyEvent.getRepeatCount() == 0) {
                if (!Util.isFingerPrintKeyEvent(keyEvent)) {
                    performKeyClicked(40, getString(R.string.pref_camera_volumekey_function_entryvalue_shutter), keyEvent.getRepeatCount(), true);
                } else if (CameraSettings.isFingerprintCaptureEnable()) {
                    performKeyClicked(30, getString(R.string.pref_camera_volumekey_function_entryvalue_shutter), keyEvent.getRepeatCount(), true);
                }
                return true;
            }
        } else if (i != 700) {
            if (!(i == 87 || i == 88)) {
                switch (i) {
                    case 23:
                        if (keyEvent.getRepeatCount() == 0) {
                            performKeyClicked(50, getString(R.string.pref_camera_volumekey_function_entryvalue_shutter), keyEvent.getRepeatCount(), true);
                            return true;
                        }
                        break;
                    case 24:
                    case 25:
                        break;
                }
            }
            if (i == 24 || i == 88) {
                z = true;
            }
            if (handleVolumeKeyEvent(z, true, keyEvent.getRepeatCount(), keyEvent.getDevice().isExternal())) {
                return true;
            }
        } else if (this.mIsShooting) {
            stopPanoramaShooting(true);
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.mPaused) {
            return true;
        }
        if (i != 4) {
            if (i == 27 || i == 66) {
                return true;
            }
        } else if (((ModeProtocol.BackStack) ModeCoordinatorImpl.getInstance().getAttachProtocol(171)).handleBackStackFromKeyBack()) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    public void onPause() {
        super.onPause();
        unRegisterSensorListener();
        this.mHandler.removeCallbacksAndMessages((Object) null);
        closeCamera();
        resetScreenOn();
    }

    public void onPreviewLayoutChanged(Rect rect) {
        this.mActivity.onLayoutChange(rect);
    }

    public void onPreviewSessionClosed(CameraCaptureSession cameraCaptureSession) {
    }

    public void onPreviewSessionFailed(CameraCaptureSession cameraCaptureSession) {
        if (!isTextureExpired() || !retryOnceIfCameraError(this.mHandler)) {
            this.mHandler.sendEmptyMessage(51);
        } else {
            Log.d(TAG, "sessionFailed due to surfaceTexture expired, retry");
        }
    }

    public void onPreviewSessionSuccess(CameraCaptureSession cameraCaptureSession) {
        if (cameraCaptureSession != null && isAlive()) {
            setCameraState(1);
            updatePreferenceInWorkThread(UpdateConstant.PANORAMA_ON_PREVIEW_SUCCESS);
        }
    }

    public void onPreviewSizeChanged(int i, int i2) {
    }

    public void onResume() {
        super.onResume();
        keepScreenOnAwhile();
        registerSensorListener();
    }

    public void onReviewCancelClicked() {
    }

    public void onReviewDoneClicked() {
    }

    public void onShutterButtonClick(int i) {
        if (!this.mPaused && getCameraState() != 0 && !isIgnoreTouchEvent()) {
            if (isFrontCamera() && this.mActivity.isScreenSlideOff()) {
                return;
            }
            if (isDoingAction()) {
                Log.w(TAG, "onShutterButtonClick return, isDoingAction");
                return;
            }
            setTriggerMode(i);
            if (!this.mIsShooting) {
                this.mActivity.getScreenHint().updateHint();
                if (Storage.isLowStorageAtLastPoint()) {
                    ((ModeProtocol.RecordState) ModeCoordinatorImpl.getInstance().getAttachProtocol(212)).onFailed();
                    return;
                }
                this.mPanoramaState = new PanoramaInit();
                initAttachQueue();
                playCameraSound(2);
                startPanoramaShooting();
            } else if (isShootingTooShort()) {
                Log.w(TAG, "panorama shooting is too short, ignore this click");
            } else {
                playCameraSound(3);
                stopPanoramaShooting(true, false);
            }
        }
    }

    public void onShutterButtonFocus(boolean z, int i) {
    }

    public boolean onShutterButtonLongClick() {
        return false;
    }

    public void onShutterButtonLongClickCancel(boolean z) {
        onShutterButtonFocus(false, 2);
    }

    public void onStop() {
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onThermalConstrained() {
        super.onThermalConstrained();
        if (!this.mIsShooting) {
            return;
        }
        if (isShootingTooShort()) {
            Log.w(TAG, "panorama shooting is too short, ignore this click");
            return;
        }
        playCameraSound(3);
        stopPanoramaShooting(true, false);
    }

    @OnClickAttr
    public void onThumbnailClicked(View view) {
        if (!this.mPaused && !isProcessingFinishTask() && this.mActivity.getThumbnailUpdater().getThumbnail() != null) {
            this.mActivity.gotoGallery();
        }
    }

    public void onUserInteraction() {
        super.onUserInteraction();
        if (!this.mPaused && !this.mIsShooting) {
            keepScreenOnAwhile();
        }
    }

    /* access modifiers changed from: protected */
    public void openSettingActivity() {
        Intent intent = new Intent();
        intent.setClass(this.mActivity, CameraPreferenceActivity.class);
        intent.putExtra(BasePreferenceActivity.FROM_WHERE, 166);
        intent.putExtra(":miui:starting_window_label", getResources().getString(R.string.pref_camera_settings_category));
        if (this.mActivity.startFromKeyguard()) {
            intent.putExtra("StartActivityWhenLocked", true);
        }
        this.mActivity.startActivity(intent);
        this.mActivity.setJumpFlag(2);
        CameraStatUtils.trackGotoSettings(this.mModuleIndex);
    }

    public void pausePreview() {
        Log.v(TAG, "pausePreview");
        this.mCamera2Device.pausePreview();
        setCameraState(0);
    }

    /* access modifiers changed from: protected */
    public void performKeyClicked(int i, String str, int i2, boolean z) {
        if (i2 == 0 && z) {
            onShutterButtonClick(i);
        }
    }

    public void registerProtocol() {
        super.registerProtocol();
        ModeCoordinatorImpl.getInstance().attachProtocol(161, this);
        getActivity().getImplFactory().initAdditional(getActivity(), 174, 164, 212);
    }

    public void requestRender() {
        ModeProtocol.PanoramaProtocol panoramaProtocol = (ModeProtocol.PanoramaProtocol) ModeCoordinatorImpl.getInstance().getAttachProtocol(176);
        if (panoramaProtocol != null) {
            panoramaProtocol.requestRender();
        }
    }

    public void resumePreview() {
        Log.v(TAG, "resumePreview");
        this.mCamera2Device.resumePreview();
        setCameraState(1);
    }

    /* access modifiers changed from: protected */
    public void sendOpenFailMessage() {
        this.mHandler.sendEmptyMessage(10);
    }

    public void setFrameAvailable(boolean z) {
        super.setFrameAvailable(z);
        if (z && CameraSettings.isCameraSoundOpen()) {
            Camera camera = this.mActivity;
            if (camera != null) {
                camera.loadCameraSound(2);
                camera.loadCameraSound(3);
            }
        }
    }

    public void setNullDirectionFunction() {
        DirectionFunction directionFunction = new DirectionFunction(this.mPictureWidth, this.mPictureHeight, 1, 1, 1, 0);
        this.mDirectionFunction = directionFunction;
    }

    public boolean shouldReleaseLater() {
        return isRecording();
    }

    public void startPanoramaShooting() {
        if (isProcessingFinishTask()) {
            Log.e(TAG, "previous save task is on going");
            return;
        }
        ModeProtocol.RecordState recordState = (ModeProtocol.RecordState) ModeCoordinatorImpl.getInstance().getAttachProtocol(212);
        recordState.onPrepare();
        Log.v(TAG, "startPanoramaShooting");
        this.mCaptureOrientationDecided = false;
        this.mDirection = this.mInitParam.direction;
        this.mTimeTaken = System.currentTimeMillis();
        this.mDeviceOrientationAtCapture = this.mOrientationCompensation;
        this.mIsShooting = true;
        this.mCanSavePanorama = false;
        this.mRequestStop = false;
        this.mShutterStartTime = createDateStringForAppSeg(System.currentTimeMillis());
        this.mShutterEndTime = "";
        synchronized (this.mDeviceLock) {
            if (this.mAeLockSupported) {
                this.mCamera2Device.setAELock(true);
            }
            if (this.mAwbLockSupported && DataRepository.dataItemFeature().Gb()) {
                this.mCamera2Device.setAWBLock(true);
            }
            this.mLocation = LocationManager.instance().getCurrentLocation();
            this.mCamera2Device.setGpsLocation(this.mLocation);
            this.mCamera2Device.setFocusMode(this.mSnapshotFocusMode);
            this.mCamera2Device.setJpegQuality(CameraSettings.getEncodingQuality(false).toInteger(false));
            this.mCamera2Device.setJpegThumbnailSize(getJpegThumbnailSize());
            this.mCamera2Device.setEnableZsl(isZslPreferred());
            this.mCamera2Device.setNeedPausePreview(false);
            this.mCamera2Device.setShotType(3);
            this.mCamera2Device.captureBurstPictures(-1, new Camera2Proxy.PictureCallbackWrapper() {
                public void onPictureTakenFinished(boolean z) {
                    String access$500 = Panorama3Module.TAG;
                    Log.d(access$500, "onPictureBurstFinished success = " + z);
                }

                public boolean onPictureTakenImageConsumed(Image image) {
                    String access$500 = Panorama3Module.TAG;
                    Log.v(access$500, "onPictureTaken>>image=" + image);
                    if (Panorama3Module.this.mCamera2Device == null) {
                        image.close();
                        return true;
                    }
                    if (!Panorama3Module.this.mPanoramaState.onSaveImage(new Camera2Image(image))) {
                        Log.w(Panorama3Module.TAG, "set mPanoramaState PanoramaState");
                        PanoramaState unused = Panorama3Module.this.mPanoramaState = new PanoramaState();
                    }
                    return true;
                }
            }, (ParallelCallback) null);
        }
        keepScreenOnAwhile();
        recordState.onStart();
        this.mPanoramaShootingStartTime = SystemClock.elapsedRealtime();
        keepScreenOn();
        AutoLockManager.getInstance(this.mActivity).removeMessage();
    }

    public void startPreview() {
        synchronized (this.mDeviceLock) {
            if (this.mCamera2Device == null) {
                Log.e(TAG, "startPreview: camera has been closed");
                return;
            }
            checkDisplayOrientation();
            this.mCamera2Device.setDisplayOrientation(this.mCameraDisplayOrientation);
            if (this.mAeLockSupported) {
                this.mCamera2Device.setAELock(false);
            }
            if (this.mAwbLockSupported) {
                this.mCamera2Device.setAWBLock(false);
            }
            this.mCamera2Device.setFocusMode(this.mTargetFocusMode);
            this.mCamera2Device.resumePreview();
            setCameraState(1);
        }
    }

    public void startSession() {
        Camera2Proxy camera2Proxy = this.mCamera2Device;
        if (camera2Proxy == null) {
            Log.e(TAG, "startPreview: camera has been closed");
            return;
        }
        camera2Proxy.setDualCamWaterMarkEnable(false);
        this.mCamera2Device.setErrorCallback(this.mErrorCallback);
        this.mCamera2Device.setPreviewSize(this.mPreviewSize);
        this.mCamera2Device.setAlgorithmPreviewSize(this.mPreviewSize);
        this.mCamera2Device.setPictureSize(this.mPictureSize);
        this.mCamera2Device.setPictureMaxImages(3);
        this.mCamera2Device.setPictureFormat(35);
        this.mSurfaceCreatedTimestamp = this.mActivity.getCameraScreenNail().getSurfaceCreatedTimestamp();
        this.mCamera2Device.startPreviewSession(new Surface(this.mActivity.getCameraScreenNail().getSurfaceTexture()), !b.isMTKPlatform(), false, false, getOperatingMode(), false, this);
    }

    /* access modifiers changed from: protected */
    public void trackModeCustomInfo(Map map, boolean z, BeautyValues beautyValues, int i) {
        CameraStatUtils.trackPictureTakenInPanorama(map, this.mActivity, beautyValues, i);
    }

    public void unRegisterProtocol() {
        super.unRegisterProtocol();
        ModeCoordinatorImpl.getInstance().detachProtocol(161, this);
        Camera camera = this.mActivity;
        if (camera != null) {
            camera.getImplFactory().detachAdditional();
        }
    }
}
