package com.android.camera.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.android.camera.CameraSettings;
import com.android.camera.animation.type.AlphaInOnSubscribe;
import com.android.camera.animation.type.AlphaOutOnSubscribe;
import com.android.camera.ui.drawable.zoom.CameraZoomAnimateDrawable;
import io.reactivex.Completable;

public class ZoomView extends View {
    private static final String TAG = "ZoomView";
    private CameraZoomAnimateDrawable mCameraZoomAnimateDrawable;
    private boolean mIsHorizontal;
    private boolean mIsInited;
    private boolean mIsVisible = true;
    private boolean mIsZoomMoving;
    private float mMaxZoomRatio;
    private float mMinZoomRatio;

    public ZoomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public float getCurrentZoomRatio() {
        CameraZoomAnimateDrawable cameraZoomAnimateDrawable = this.mCameraZoomAnimateDrawable;
        if (cameraZoomAnimateDrawable != null) {
            return cameraZoomAnimateDrawable.getCurrentZoomRatio();
        }
        return 1.0f;
    }

    public void hide() {
        this.mIsVisible = false;
        Completable.create(new AlphaOutOnSubscribe(this)).subscribe();
    }

    public void init() {
        if (!this.mIsInited) {
            this.mIsInited = true;
            this.mCameraZoomAnimateDrawable = new CameraZoomAnimateDrawable(getContext(), this.mIsHorizontal);
            this.mCameraZoomAnimateDrawable.setCallback(this);
            this.mCameraZoomAnimateDrawable.updateZoomRatio(this.mMinZoomRatio, this.mMaxZoomRatio);
            invalidate();
        }
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidate();
    }

    public boolean isVisible() {
        return this.mIsVisible;
    }

    public boolean isZoomMoving() {
        return this.mIsZoomMoving;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.mIsVisible && this.mIsInited) {
            CameraZoomAnimateDrawable cameraZoomAnimateDrawable = this.mCameraZoomAnimateDrawable;
            if (cameraZoomAnimateDrawable != null) {
                cameraZoomAnimateDrawable.draw(canvas);
            }
        }
    }

    public boolean onViewTouchEvent(MotionEvent motionEvent) {
        if (!this.mIsVisible || !this.mIsInited || this.mCameraZoomAnimateDrawable == null) {
            return false;
        }
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        Point point = new Point((int) (motionEvent.getX() - ((float) iArr[0])), (int) (motionEvent.getY() - ((float) iArr[1])));
        if (motionEvent.getActionMasked() == 0 && this.mCameraZoomAnimateDrawable.startTouchDownAnimation(point)) {
            this.mIsZoomMoving = true;
        }
        if (1 == motionEvent.getAction() || 3 == motionEvent.getAction()) {
            this.mIsZoomMoving = false;
            this.mCameraZoomAnimateDrawable.stopTouchUpAnimation();
        }
        if (2 == motionEvent.getAction()) {
            this.mCameraZoomAnimateDrawable.move(point);
        }
        return true;
    }

    public void reInit() {
        if (CameraSettings.readZoom() <= 1.0f) {
            CameraZoomAnimateDrawable cameraZoomAnimateDrawable = this.mCameraZoomAnimateDrawable;
            if (cameraZoomAnimateDrawable != null) {
                cameraZoomAnimateDrawable.reset();
                invalidate();
            }
        }
    }

    public void reset() {
        CameraZoomAnimateDrawable cameraZoomAnimateDrawable = this.mCameraZoomAnimateDrawable;
        if (cameraZoomAnimateDrawable != null) {
            cameraZoomAnimateDrawable.reset();
        }
    }

    public void setCurrentZoomRatio(float f2) {
        CameraZoomAnimateDrawable cameraZoomAnimateDrawable = this.mCameraZoomAnimateDrawable;
        if (cameraZoomAnimateDrawable != null) {
            cameraZoomAnimateDrawable.setCurrentZoomRatio(f2);
        }
    }

    public void setIsHorizonal(boolean z) {
        this.mIsHorizontal = z;
    }

    public void setOrientation(int i, boolean z) {
        setRotation((float) i);
    }

    public void show() {
        this.mIsVisible = true;
        Completable.create(new AlphaInOnSubscribe(this)).subscribe();
        invalidate();
    }

    public void updateZoomRatio(float f2, float f3) {
        this.mMinZoomRatio = f2;
        this.mMaxZoomRatio = f3;
        CameraZoomAnimateDrawable cameraZoomAnimateDrawable = this.mCameraZoomAnimateDrawable;
        if (cameraZoomAnimateDrawable != null) {
            cameraZoomAnimateDrawable.updateZoomRatio(this.mMinZoomRatio, this.mMaxZoomRatio);
        }
    }
}
