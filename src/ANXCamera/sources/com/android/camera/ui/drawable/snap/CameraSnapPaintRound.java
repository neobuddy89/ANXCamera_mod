package com.android.camera.ui.drawable.snap;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.android.camera.ui.drawable.CameraPaintBase;

public class CameraSnapPaintRound extends CameraPaintBase {
    private static final float RECORDING_ROUND_WIDTH = 0.265f;
    public boolean isRecordingCircle;
    public boolean isRoundingCircle;
    private float mCurrentRoundRectRadius;
    private RectF mRectF;
    private float mRoundingProgress = 1.0f;

    public CameraSnapPaintRound(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void draw(Canvas canvas) {
        if (!this.isRecording) {
            canvas.drawCircle(this.mMiddleX, this.mMiddleY, this.mBaseRadius * this.mCurrentWidthPercent, this.mPaint);
        } else if (this.isRecordingCircle) {
            canvas.drawCircle(this.mMiddleX, this.mMiddleY, this.mBaseRadius * 0.55f, this.mPaint);
        } else if (this.isRoundingCircle) {
            canvas.drawCircle(this.mMiddleX, this.mMiddleY, this.mBaseRadius * this.mCurrentWidthPercent * this.mRoundingProgress, this.mPaint);
        } else {
            float f2 = this.mBaseRadius * this.mCurrentRoundRectRadius;
            float f3 = this.mMiddleX;
            float f4 = this.mMiddleY;
            RectF rectF = this.mRectF;
            rectF.set(f3 - f2, f4 - f2, f3 + f2, f4 + f2);
            RectF rectF2 = this.mRectF;
            float f5 = this.mRoundingProgress;
            canvas.drawRoundRect(rectF2, f2 * f5, f2 * f5, this.mPaint);
        }
    }

    /* access modifiers changed from: protected */
    public void initPaint(Context context) {
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mRectF = new RectF();
    }

    public void prepareRecord() {
        this.mCurrentRoundRectRadius = this.mCurrentWidthPercent;
        this.mRoundingProgress = 1.0f;
    }

    public void resetRecordingState() {
        super.resetRecordingState();
        this.isRecordingCircle = false;
        this.isRoundingCircle = false;
    }

    public void updateRecordValue(float f2, boolean z) {
        if (z) {
            if (this.isRoundingCircle) {
                this.mRoundingProgress = 1.0f - (0.45f * f2);
            } else {
                this.mRoundingProgress = 1.0f - (0.65f * f2);
            }
            float f3 = this.mCurrentWidthPercent;
            this.mCurrentRoundRectRadius = f3 - ((f3 - RECORDING_ROUND_WIDTH) * f2);
            return;
        }
        if (this.isRoundingCircle) {
            this.mRoundingProgress = (0.45f * f2) + 0.55f;
        } else {
            this.mRoundingProgress = (0.65f * f2) + 0.35f;
        }
        this.mCurrentRoundRectRadius = ((this.mCurrentWidthPercent - RECORDING_ROUND_WIDTH) * f2) + RECORDING_ROUND_WIDTH;
    }
}
