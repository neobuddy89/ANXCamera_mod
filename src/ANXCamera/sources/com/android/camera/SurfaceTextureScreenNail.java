package com.android.camera;

import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.opengl.Matrix;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import com.android.camera.effect.FrameBuffer;
import com.android.camera.effect.draw_mode.DrawExtTexAttribute;
import com.android.camera.lib.compatibility.util.CompatibilityUtils;
import com.android.camera.log.Log;
import com.android.camera.module.ModuleManager;
import com.android.camera.storage.ImageSaver;
import com.android.camera.ui.Rotatable;
import com.android.gallery3d.ui.BitmapTexture;
import com.android.gallery3d.ui.ExtTexture;
import com.android.gallery3d.ui.GLCanvas;
import com.android.gallery3d.ui.RawTexture;
import com.android.gallery3d.ui.ScreenNail;
import com.mi.config.b;

public abstract class SurfaceTextureScreenNail implements ScreenNail, SurfaceTexture.OnFrameAvailableListener, Rotatable {
    private static final float MOVIE_SOLID_CROPPED_X = 0.8f;
    private static final float MOVIE_SOLID_CROPPED_Y = 0.8f;
    private static final String TAG = "STScreenNail";
    private static HandlerThread sFrameListener = new HandlerThread("FrameListener");
    private static int sMaxHighPriorityFrameCount = 8;
    private int currentFrameCount = 0;
    protected RawTexture mAnimTexture;
    protected BitmapTexture mBitmapTexture;
    protected int mCameraHeight;
    protected int mCameraWidth;
    protected FrameBuffer mCaptureAnimFrameBuffer;
    protected RawTexture mCaptureAnimTexture;
    private int mDisplayOrientation;
    protected Rect mDisplayRect;
    private DrawExtTexAttribute mDrawAttribute = new DrawExtTexAttribute();
    protected volatile boolean mDrawEnabled = true;
    protected ExtTexture mExtTexture;
    protected ExternalFrameProcessor mExternalFrameProcessor;
    protected FrameBuffer mFrameBuffer;
    protected FrameBuffer mFullCaptureAnimFrameBuffer;
    protected RawTexture mFullCaptureAnimTexture;
    private boolean mHasTexture = false;
    private int mHeight;
    private boolean mIsFullScreen;
    private boolean mIsRatio16_9 = true;
    protected final Object mLock = new Object();
    protected boolean mModuleSwitching;
    private boolean mNeedCropped;
    protected PreviewSaveListener mPreviewSaveListener;
    private int mRenderHeight;
    protected Rect mRenderLayoutRect = new Rect();
    private int mRenderOffsetX;
    private int mRenderOffsetY;
    private int mRenderWidth;
    private float mScaleX = 1.0f;
    private float mScaleY = 1.0f;
    private SurfaceTextureScreenNailCallback mScreenNailCallback;
    protected boolean mSkipFirstFrame;
    private long mSurfaceCreatedTimestamp;
    protected int mSurfaceHeight;
    private SurfaceTexture mSurfaceTexture;
    protected int mSurfaceWidth;
    private int mTargetRatio = -1;
    protected int mTheight;
    private float[] mTransform = new float[16];
    protected int mTwidth;
    protected int mTx;
    protected int mTy;
    private int mUncroppedRenderHeight;
    private int mUncroppedRenderWidth;
    private boolean mVideoStabilizationCropped;
    private int mWidth;

    public interface ExternalFrameProcessor {
        boolean isProcessorReady();

        void onDrawFrame(Rect rect, int i, int i2, boolean z);

        void releaseRender();
    }

    public interface PreviewSaveListener {
        void save(byte[] bArr, int i, int i2, int i3, ImageSaver imageSaver);
    }

    public interface SurfaceTextureScreenNailCallback {
        void onSurfaceTextureCreated(SurfaceTexture surfaceTexture);

        void onSurfaceTextureReleased();

        void onSurfaceTextureUpdated(DrawExtTexAttribute drawExtTexAttribute);
    }

    public SurfaceTextureScreenNail(SurfaceTextureScreenNailCallback surfaceTextureScreenNailCallback) {
        this.mScreenNailCallback = surfaceTextureScreenNailCallback;
    }

    private void checkThreadPriority() {
        int i = this.currentFrameCount;
        int i2 = sMaxHighPriorityFrameCount;
        if (i == i2) {
            Log.i(TAG, "normalHandlerCapacity:set normal");
            Process.setThreadPriority(sFrameListener.getThreadId(), 0);
            this.currentFrameCount++;
        } else if (i < i2) {
            this.currentFrameCount = i + 1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00e5  */
    private void computeRatio() {
        int i;
        int i2;
        int i3;
        boolean z = false;
        if (CameraSettings.getStrictAspectRatio(this.mRenderWidth, this.mRenderHeight) > -1 || !CameraSettings.isNearAspectRatio(this.mCameraWidth, this.mCameraHeight, this.mRenderWidth, this.mRenderHeight)) {
            int i4 = this.mCameraWidth;
            int i5 = this.mCameraHeight;
            int i6 = this.mTargetRatio;
            if (i6 == 0) {
                this.mIsFullScreen = false;
                this.mIsRatio16_9 = false;
                if (!CameraSettings.isAspectRatio4_3(i4, i5)) {
                    this.mNeedCropped = true;
                    if (i4 * 4 > i5 * 3) {
                        int i7 = (int) (((float) i5) * 0.75f);
                        this.mScaleX = ((float) i7) / ((float) i4);
                        i4 = i7;
                    } else {
                        int i8 = (int) ((((float) i4) * 4.0f) / 3.0f);
                        this.mScaleY = ((float) i8) / ((float) i5);
                        i5 = i8;
                    }
                } else {
                    this.mNeedCropped = false;
                    this.mScaleX = 1.0f;
                    this.mScaleY = 1.0f;
                }
                if (CameraSettings.sCroppedIfNeeded) {
                    this.mIsFullScreen = true;
                    this.mNeedCropped = true;
                    this.mIsRatio16_9 = true;
                    i = (int) ((((float) i4) * 16.0f) / 9.0f);
                    this.mScaleX *= 0.75f;
                } else {
                    i = i5;
                }
                if (b.isPad()) {
                    this.mIsFullScreen = true;
                }
            } else if (i6 != 1) {
                if (i6 == 2) {
                    this.mIsFullScreen = false;
                    this.mIsRatio16_9 = false;
                    this.mNeedCropped = true;
                    if (i4 != i5) {
                        this.mScaleX = 1.0f;
                        this.mScaleY = ((float) i4) / ((float) i5);
                        i = i4;
                    }
                }
                i = i5;
            } else {
                this.mIsRatio16_9 = true;
                this.mIsFullScreen = true;
                if (!CameraSettings.isAspectRatio16_9(i4, i5)) {
                    this.mNeedCropped = true;
                    if (i4 * 16 > i5 * 9) {
                        i2 = (int) ((((float) i5) * 9.0f) / 16.0f);
                        this.mScaleX = ((float) i2) / ((float) i4);
                    } else {
                        int i9 = (int) ((((float) i4) * 16.0f) / 9.0f);
                        this.mScaleY = ((float) i9) / ((float) i5);
                        int i10 = i9;
                        i2 = i4;
                        i3 = i10;
                        if (b.isPad()) {
                            this.mIsRatio16_9 = false;
                            this.mNeedCropped = true;
                            i3 = (int) (((float) i3) * 0.75f);
                            this.mScaleY *= 0.75f;
                        }
                        int i11 = i2;
                        i = i3;
                        i4 = i11;
                    }
                } else {
                    this.mNeedCropped = false;
                    this.mScaleX = 1.0f;
                    this.mScaleY = 1.0f;
                    i2 = i4;
                }
                i3 = i5;
                if (b.isPad()) {
                }
                int i112 = i2;
                i = i3;
                i4 = i112;
            }
            this.mWidth = i4;
            this.mHeight = i;
        } else {
            int i12 = this.mCameraWidth;
            if (i12 != 0) {
                int i13 = this.mCameraHeight;
                if (i13 != 0) {
                    int i14 = this.mRenderWidth;
                    if (i14 != 0) {
                        int i15 = this.mRenderHeight;
                        if (!(i15 == 0 || i14 * i13 == i15 * i12)) {
                            this.mNeedCropped = true;
                            if (i12 * i15 > i13 * i14) {
                                this.mHeight = i13;
                                this.mWidth = (i13 * i14) / i15;
                                this.mScaleX = ((float) this.mWidth) / ((float) i12);
                                this.mScaleY = 1.0f;
                            } else {
                                this.mWidth = i12;
                                this.mHeight = (i12 * i15) / i14;
                                this.mScaleX = 1.0f;
                                this.mScaleY = ((float) this.mHeight) / ((float) i13);
                            }
                            if ((((float) this.mRenderHeight) / ((float) this.mRenderWidth)) - (((float) Util.sWindowHeight) / ((float) Util.sWindowWidth)) < 0.1f) {
                                z = true;
                            }
                            this.mIsFullScreen = z;
                        }
                    }
                    this.mNeedCropped = false;
                    this.mScaleX = 1.0f;
                    this.mScaleY = 1.0f;
                    this.mWidth = this.mCameraWidth;
                    this.mHeight = this.mCameraHeight;
                    if ((((float) this.mRenderHeight) / ((float) this.mRenderWidth)) - (((float) Util.sWindowHeight) / ((float) Util.sWindowWidth)) < 0.1f) {
                    }
                    this.mIsFullScreen = z;
                }
            }
        }
        updateRenderSize();
        updateRenderRect();
    }

    private void initializePreviewTexture() {
        if (this.mExtTexture == null) {
            this.mExtTexture = new ExtTexture();
        }
        this.mExtTexture.setSize(this.mWidth, this.mHeight);
        if (b.wk() && !sFrameListener.isAlive()) {
            sFrameListener.start();
        }
        if (this.mSurfaceTexture == null) {
            this.mSurfaceTexture = new SurfaceTexture(this.mExtTexture.getId());
        }
        this.mSurfaceCreatedTimestamp = System.currentTimeMillis();
        Log.d(TAG, "acquireSurfaceTexture: setDefaultBufferSize " + this.mWidth + "x" + this.mHeight);
        int i = this.mWidth;
        int i2 = this.mHeight;
        if (i > i2) {
            this.mSurfaceTexture.setDefaultBufferSize(i, i2);
        } else {
            this.mSurfaceTexture.setDefaultBufferSize(i2, i);
        }
        if (Build.VERSION.SDK_INT < 21 || !b.wk()) {
            this.mSurfaceTexture.setOnFrameAvailableListener(this);
        } else {
            CompatibilityUtils.setSurfaceTextureOnFrameAvailableListener(this.mSurfaceTexture, this, new Handler(sFrameListener.getLooper()));
            Log.i(TAG, "fullHandlerCapacity:set urgent display");
            Process.setThreadPriority(sFrameListener.getThreadId(), -8);
            this.currentFrameCount = 0;
        }
        SurfaceTextureScreenNailCallback surfaceTextureScreenNailCallback = this.mScreenNailCallback;
        if (surfaceTextureScreenNailCallback != null) {
            surfaceTextureScreenNailCallback.onSurfaceTextureCreated(this.mSurfaceTexture);
        }
    }

    private void updateRenderSize() {
        if (2 != this.mTargetRatio) {
            this.mUncroppedRenderWidth = (int) (((float) this.mRenderWidth) / this.mScaleX);
            this.mUncroppedRenderHeight = (int) (((float) this.mRenderHeight) / this.mScaleY);
            return;
        }
        int i = this.mRenderWidth;
        this.mUncroppedRenderWidth = (int) (((float) i) / this.mScaleX);
        this.mUncroppedRenderHeight = (int) (((float) i) / this.mScaleY);
    }

    public void acquireSurfaceTexture() {
        Log.d(TAG, "acquireSurfaceTexture: mHasTexture = " + this.mHasTexture);
        synchronized (this) {
            if (!this.mHasTexture) {
                initializePreviewTexture();
                this.mAnimTexture = new RawTexture(this.mWidth / 4, this.mHeight / 4, true);
                this.mCaptureAnimTexture = new RawTexture(Util.LIMIT_SURFACE_WIDTH, (this.mHeight * Util.LIMIT_SURFACE_WIDTH) / this.mWidth, true);
                this.mFrameBuffer = null;
                this.mCaptureAnimFrameBuffer = null;
                synchronized (this) {
                    this.mHasTexture = true;
                    this.mModuleSwitching = false;
                    this.mSkipFirstFrame = false;
                }
            }
        }
    }

    public void draw(GLCanvas gLCanvas) {
        if (this.mSkipFirstFrame) {
            this.mSkipFirstFrame = false;
            this.mSurfaceTexture.updateTexImage();
            return;
        }
        ExternalFrameProcessor externalFrameProcessor = this.mExternalFrameProcessor;
        if (externalFrameProcessor != null) {
            SurfaceTexture surfaceTexture = this.mSurfaceTexture;
            if (surfaceTexture != null) {
                surfaceTexture.updateTexImage();
                if ((!isAnimationRunning() || isAnimationGaussian()) && externalFrameProcessor.isProcessorReady()) {
                    return;
                }
            }
        }
        gLCanvas.clearBuffer();
        if (!this.mIsFullScreen || b.Vj() || Util.isNotchDevice || Util.isLongRatioScreen || Util.sIsnotchScreenHidden) {
            draw(gLCanvas, this.mTx, this.mTy, this.mTwidth, this.mTheight);
            return;
        }
        draw(gLCanvas, 0, 0, this.mSurfaceWidth, this.mSurfaceHeight);
    }

    public void draw(GLCanvas gLCanvas, int i, int i2, int i3, int i4) {
        synchronized (this) {
            if (this.mHasTexture) {
                if (b.wk()) {
                    checkThreadPriority();
                }
                gLCanvas.setPreviewSize(this.mWidth, this.mHeight);
                this.mSurfaceTexture.updateTexImage();
                if (this.mDrawEnabled) {
                    this.mSurfaceTexture.getTransformMatrix(this.mTransform);
                    gLCanvas.getState().pushState();
                    updateTransformMatrix(this.mTransform);
                    updateExtraTransformMatrix(this.mTransform);
                    gLCanvas.draw(this.mDrawAttribute.init(this.mExtTexture, this.mTransform, i, i2, i3, i4));
                    if (this.mScreenNailCallback != null) {
                        this.mScreenNailCallback.onSurfaceTextureUpdated(this.mDrawAttribute);
                    }
                    gLCanvas.getState().popState();
                }
            }
        }
    }

    public void draw(GLCanvas gLCanvas, RectF rectF, RectF rectF2) {
        throw new UnsupportedOperationException();
    }

    public void enableDraw(boolean z) {
        synchronized (this.mLock) {
            Log.d(TAG, "enableScreeNailDraw: " + z);
            this.mDrawEnabled = z;
        }
    }

    public ExtTexture getExtTexture() {
        ExtTexture extTexture;
        synchronized (this.mLock) {
            extTexture = this.mExtTexture;
        }
        return extTexture;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getRenderHeight() {
        return this.mUncroppedRenderHeight;
    }

    public int getRenderTargetRatio() {
        return this.mTargetRatio;
    }

    public int getRenderWidth() {
        return this.mUncroppedRenderWidth;
    }

    public long getSurfaceCreatedTimestamp() {
        return this.mSurfaceCreatedTimestamp;
    }

    public SurfaceTexture getSurfaceTexture() {
        SurfaceTexture surfaceTexture;
        synchronized (this.mLock) {
            surfaceTexture = this.mSurfaceTexture;
        }
        return surfaceTexture;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean isAnimationGaussian() {
        return false;
    }

    public boolean isAnimationRunning() {
        return false;
    }

    public abstract void noDraw();

    public abstract void onFrameAvailable(SurfaceTexture surfaceTexture);

    public abstract void recycle();

    public abstract void releaseBitmapIfNeeded();

    public void releaseSurfaceTexture() {
        Log.d(TAG, "releaseSurfaceTexture: mHasTexture = " + this.mHasTexture);
        synchronized (this) {
            this.mHasTexture = false;
        }
        ExtTexture extTexture = this.mExtTexture;
        if (extTexture != null) {
            extTexture.recycle();
            this.mExtTexture = null;
        }
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.mSurfaceTexture.setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener) null);
            this.mSurfaceTexture = null;
            this.mSurfaceCreatedTimestamp = 0;
        }
        SurfaceTextureScreenNailCallback surfaceTextureScreenNailCallback = this.mScreenNailCallback;
        if (surfaceTextureScreenNailCallback != null) {
            surfaceTextureScreenNailCallback.onSurfaceTextureReleased();
        }
        RawTexture rawTexture = this.mAnimTexture;
        if (rawTexture != null) {
            rawTexture.recycle();
            this.mAnimTexture = null;
        }
        RawTexture rawTexture2 = this.mCaptureAnimTexture;
        if (rawTexture2 != null) {
            rawTexture2.recycle();
            this.mCaptureAnimTexture = null;
        }
        this.mFrameBuffer = null;
        this.mCaptureAnimFrameBuffer = null;
        releaseBitmapIfNeeded();
    }

    public void setDisplayArea(Rect rect) {
        this.mDisplayRect = rect;
        this.mRenderOffsetX = rect.left;
        this.mRenderOffsetY = rect.top;
        this.mRenderWidth = rect.width();
        this.mRenderHeight = rect.height();
        computeRatio();
    }

    public void setDisplayOrientation(int i) {
        this.mDisplayOrientation = i;
    }

    public void setOrientation(int i, boolean z) {
    }

    public void setPreviewSize(int i, int i2) {
        if (i > i2) {
            this.mCameraWidth = i2;
            this.mCameraHeight = i;
        } else {
            this.mCameraWidth = i;
            this.mCameraHeight = i2;
        }
        this.mTargetRatio = CameraSettings.getRenderAspectRatio(i, i2);
        computeRatio();
        if (this.mSurfaceTexture != null) {
            Log.d(TAG, "setDefaultBufferSize: " + i + " | " + i2);
            this.mSurfaceTexture.setDefaultBufferSize(i, i2);
        }
    }

    public void setVideoStabilizationCropped(boolean z) {
        if (b.Xk()) {
            this.mVideoStabilizationCropped = z;
        } else {
            this.mVideoStabilizationCropped = false;
        }
    }

    /* access modifiers changed from: protected */
    public void updateExtraTransformMatrix(float[] fArr) {
    }

    /* access modifiers changed from: protected */
    public void updateRenderRect() {
        int i = 0;
        if (this.mTargetRatio == 2) {
            int i2 = this.mRenderWidth;
            this.mTx = i2 == 0 ? 0 : (this.mRenderOffsetX * this.mSurfaceWidth) / i2;
            int i3 = this.mSurfaceHeight;
            int i4 = (i3 - this.mSurfaceWidth) / 2;
            int i5 = this.mRenderHeight;
            if (i5 != 0) {
                i = (this.mRenderOffsetY * i3) / i5;
            }
            this.mTy = i4 + i;
            int i6 = this.mSurfaceWidth;
            this.mTwidth = i6;
            this.mTheight = i6;
            Rect rect = this.mRenderLayoutRect;
            int i7 = this.mRenderOffsetX;
            int i8 = this.mRenderHeight;
            int i9 = this.mRenderWidth;
            int i10 = this.mRenderOffsetY;
            rect.set(i7, ((i8 - i9) / 2) + i10, i9 + i7, ((i8 - i9) / 2) + i10 + i9);
            return;
        }
        int i11 = this.mRenderWidth;
        this.mTx = i11 == 0 ? 0 : (this.mRenderOffsetX * this.mSurfaceWidth) / i11;
        int i12 = this.mRenderHeight;
        this.mTy = i12 == 0 ? 0 : (this.mRenderOffsetY * this.mSurfaceHeight) / i12;
        this.mTwidth = this.mSurfaceWidth;
        this.mTheight = this.mSurfaceHeight;
        this.mRenderLayoutRect.set(0, 0, this.mRenderWidth, this.mRenderHeight);
    }

    /* access modifiers changed from: protected */
    public void updateTransformMatrix(float[] fArr) {
        boolean z;
        float f2;
        float f3;
        boolean z2 = true;
        if (!this.mVideoStabilizationCropped || !ModuleManager.isInVideoCategory()) {
            f3 = 1.0f;
            f2 = 1.0f;
            z = false;
        } else {
            f3 = 0.8f;
            f2 = 0.8f;
            z = true;
        }
        if (this.mNeedCropped) {
            f3 *= this.mScaleX;
            f2 *= this.mScaleY;
            z = true;
        }
        if (this.mDisplayOrientation == 0) {
            z2 = z;
        }
        if (z2) {
            Matrix.translateM(fArr, 0, 0.5f, 0.5f, 0.0f);
            Matrix.rotateM(fArr, 0, (float) this.mDisplayOrientation, 0.0f, 0.0f, 1.0f);
            Matrix.scaleM(fArr, 0, f3, f2, 1.0f);
            Matrix.translateM(fArr, 0, -0.5f, -0.5f, 0.0f);
        }
    }
}
