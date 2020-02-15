package com.android.camera.ui.drawable.snap;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.android.camera.ui.drawable.CameraPaintBase;

public class CameraSnapPaintMotion extends CameraPaintBase {
    private boolean mIsOutstandingRound = false;
    private float mLastAngle = 0.0f;

    public CameraSnapPaintMotion(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void draw(Canvas canvas) {
        float f2 = this.mBaseRadius * this.mCurrentWidthPercent;
        if (this.timeAngle - this.mLastAngle < 0.0f) {
            this.mIsOutstandingRound = !this.mIsOutstandingRound;
        }
        for (int i = 0; i < 40; i++) {
            canvas.save();
            float f3 = (float) (i * 9);
            canvas.rotate(f3, this.mMiddleX, this.mMiddleY);
            int i2 = this.mCurrentAlpha;
            int i3 = 19;
            if (this.isRecording) {
                if (f3 == 0.0f && this.needZero) {
                    this.mPaint.setAlpha(CameraPaintBase.ALPHA_OUTSTANDING);
                } else if (f3 < this.timeAngle) {
                    this.mPaint.setAlpha(this.mIsOutstandingRound ? CameraPaintBase.ALPHA_OUTSTANDING : CameraPaintBase.ALPHA_HINT);
                } else {
                    this.mPaint.setAlpha(this.mIsOutstandingRound ? CameraPaintBase.ALPHA_HINT : CameraPaintBase.ALPHA_OUTSTANDING);
                }
                if (f3 % 90.0f == 0.0f) {
                    float f4 = this.mMiddleX;
                    float f5 = this.mMiddleY;
                    canvas.drawLine(f4, f5 - f2, f4, (f5 - f2) + ((float) i3), this.mPaint);
                    this.mPaint.setAlpha(i2);
                    canvas.restore();
                }
            } else if (f3 % 90.0f == 0.0f) {
                float f42 = this.mMiddleX;
                float f52 = this.mMiddleY;
                canvas.drawLine(f42, f52 - f2, f42, (f52 - f2) + ((float) i3), this.mPaint);
                this.mPaint.setAlpha(i2);
                canvas.restore();
            }
            i3 = 12;
            float f422 = this.mMiddleX;
            float f522 = this.mMiddleY;
            canvas.drawLine(f422, f522 - f2, f422, (f522 - f2) + ((float) i3), this.mPaint);
            this.mPaint.setAlpha(i2);
            canvas.restore();
        }
        float f6 = this.timeAngle;
        this.mLastAngle = f6;
        if (this.isRecording) {
            canvas.rotate(f6, this.mMiddleX, this.mMiddleY);
            int i4 = this.mCurrentAlpha;
            this.mPaint.setAlpha(CameraPaintBase.ALPHA_OUTSTANDING);
            float f7 = this.mMiddleX;
            float f8 = this.mMiddleY;
            canvas.drawLine(f7, f8 - f2, f7, (f8 - f2) + 19.0f, this.mPaint);
            this.mPaint.setAlpha(i4);
        }
    }

    /* access modifiers changed from: protected */
    public void initPaint(Context context) {
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(3.0f);
    }
}
