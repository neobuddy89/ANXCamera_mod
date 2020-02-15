package com.android.camera.effect.renders;

import android.graphics.Bitmap;
import com.android.camera.Util;
import com.android.gallery3d.ui.BasicTexture;
import com.android.gallery3d.ui.BitmapTexture;

public class ImageWaterMark extends WaterMark {
    private int mCenterX;
    private int mCenterY;
    private int mHeight;
    private BitmapTexture mImageTexture;
    private boolean mIsCinematicAspectRatio;
    private int mPaddingX;
    private int mPaddingY;
    private int mWidth;

    public ImageWaterMark(Bitmap bitmap, int i, int i2, int i3, float f2, float f3, float f4, boolean z) {
        super(i, i2, i3);
        this.mIsCinematicAspectRatio = z;
        int[] calcDualCameraWatermarkLocation = Util.calcDualCameraWatermarkLocation(i, i2, bitmap.getWidth(), bitmap.getHeight(), f2, f3, f4);
        this.mWidth = calcDualCameraWatermarkLocation[0];
        this.mHeight = calcDualCameraWatermarkLocation[1];
        this.mPaddingX = calcDualCameraWatermarkLocation[2];
        this.mPaddingY = calcDualCameraWatermarkLocation[3];
        if (this.mIsCinematicAspectRatio) {
            float min = ((float) Math.min(i, i2)) / 1080.0f;
            int floor = (int) Math.floor((double) (((float) Util.getCinematicAspectRatioMargin()) * min));
            if (i3 == 90 || i3 == 270) {
                this.mWidth = (int) (Math.round(((double) this.mWidth) * 0.95d) & -2);
                this.mHeight = (int) (Math.round(((double) this.mHeight) * 0.95d) & -2);
                float f5 = min * 15.0f;
                this.mPaddingX = (int) (((float) this.mPaddingX) - f5);
                this.mPaddingY = (int) (((float) this.mPaddingY) - f5);
                this.mPaddingX += floor;
            } else {
                this.mPaddingY += floor;
            }
        }
        this.mImageTexture = new BitmapTexture(bitmap);
        this.mImageTexture.setOpaque(false);
        calcCenterAxis();
    }

    private void calcCenterAxis() {
        int i = this.mOrientation;
        if (i == 0) {
            this.mCenterX = this.mPaddingX + (getWidth() / 2);
            this.mCenterY = (this.mPictureHeight - this.mPaddingY) - (getHeight() / 2);
        } else if (i == 90) {
            this.mCenterX = (this.mPictureWidth - this.mPaddingY) - (getHeight() / 2);
            this.mCenterY = (this.mPictureHeight - this.mPaddingX) - (getWidth() / 2);
        } else if (i == 180) {
            this.mCenterX = (this.mPictureWidth - this.mPaddingX) - (getWidth() / 2);
            this.mCenterY = this.mPaddingY + (getHeight() / 2);
        } else if (i == 270) {
            this.mCenterX = this.mPaddingY + (getHeight() / 2);
            this.mCenterY = this.mPaddingX + (getWidth() / 2);
        }
    }

    public int getCenterX() {
        return this.mCenterX;
    }

    public int getCenterY() {
        return this.mCenterY;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public /* bridge */ /* synthetic */ int getLeft() {
        return super.getLeft();
    }

    public int getPaddingX() {
        return this.mPaddingX;
    }

    public int getPaddingY() {
        return this.mPaddingY;
    }

    public BasicTexture getTexture() {
        return this.mImageTexture;
    }

    public /* bridge */ /* synthetic */ int getTop() {
        return super.getTop();
    }

    public int getWidth() {
        return this.mWidth;
    }
}
