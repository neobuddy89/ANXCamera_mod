package com.android.camera.ui.drawable.snap;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.android.camera.Util;
import com.android.camera.ui.drawable.CameraPaintBase;

public class CameraSnapPaintSecond extends CameraPaintBase {
    private boolean mNeedSpacing;

    public CameraSnapPaintSecond(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void draw(Canvas canvas) {
        float f2 = this.mBaseRadius * this.mCurrentWidthPercent;
        for (int i = 0; i < 90; i++) {
            canvas.save();
            float f3 = (float) (i * 4);
            canvas.rotate(f3, this.mMiddleX, this.mMiddleY);
            int i2 = this.isRecording ? (f3 != 0.0f || !this.needZero) ? f3 < this.timeAngle ? this.isClockwise ? CameraPaintBase.ALPHA_OUTSTANDING : CameraPaintBase.ALPHA_HINT : this.isClockwise ? CameraPaintBase.ALPHA_HINT : CameraPaintBase.ALPHA_OUTSTANDING : CameraPaintBase.ALPHA_OUTSTANDING : this.mCurrentAlpha;
            if (this.mNeedSpacing && i > 67 && i < 90 && i % 2 != 0) {
                i2 = 0;
            }
            this.mPaint.setAlpha(i2);
            float f4 = this.mMiddleX;
            float f5 = this.mMiddleY;
            canvas.drawLine(f4, f5 - f2, f4, (f5 - f2) + ((float) Util.dpToPixel(5.0f)), this.mPaint);
            canvas.restore();
        }
    }

    /* access modifiers changed from: protected */
    public void initPaint(Context context) {
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(3.0f);
    }

    public void setNeedSpacing(boolean z) {
        this.mNeedSpacing = z;
    }
}
