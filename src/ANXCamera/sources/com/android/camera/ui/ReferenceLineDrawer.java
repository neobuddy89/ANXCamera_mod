package com.android.camera.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.android.camera.effect.EffectController;
import com.android.camera.ui.GradienterDrawer;

public class ReferenceLineDrawer extends View {
    private static final int BORDER = 1;
    public static final String TAG = "ReferenceLineDrawer";
    private boolean isGradienterEnabled;
    private boolean mBottomVisible = true;
    private int mColumnCount = 1;
    private GradienterDrawer.Direct mCurrentDirect = GradienterDrawer.Direct.NONE;
    private float mDeviceRotation = 0.0f;
    private int mFrameColor = 402653184;
    private Paint mFramePaint;
    private int mLineColor = 1795162111;
    private Paint mLinePaint;
    private int mRowCount = 1;
    private boolean mTopVisible = true;

    public ReferenceLineDrawer(Context context) {
        super(context);
    }

    public ReferenceLineDrawer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ReferenceLineDrawer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void resetline(Canvas canvas) {
        int width = getWidth() - 1;
        int height = getHeight() - 1;
        int i = 1;
        while (true) {
            int i2 = this.mColumnCount;
            if (i >= i2) {
                break;
            }
            if (this.isGradienterEnabled && this.mCurrentDirect == GradienterDrawer.Direct.LEFT && i == 2) {
                int i3 = i * width;
                canvas.drawRect(new Rect(i3 / i2, 1, (i3 / i2) + 3, height / this.mRowCount), this.mFramePaint);
                int i4 = this.mColumnCount;
                int i5 = this.mRowCount;
                canvas.drawRect(new Rect(i3 / i4, ((height / i5) * (i5 - 1)) + 1, (i3 / i4) + 3, height - 1), this.mFramePaint);
            } else if (this.isGradienterEnabled && this.mCurrentDirect == GradienterDrawer.Direct.RIGHT && i == 1) {
                int i6 = i * width;
                int i7 = this.mColumnCount;
                canvas.drawRect(new Rect(i6 / i7, 1, (i6 / i7) + 3, height / this.mRowCount), this.mFramePaint);
                int i8 = this.mColumnCount;
                int i9 = this.mRowCount;
                canvas.drawRect(new Rect(i6 / i8, ((height / i9) * (i9 - 1)) + 1, (i6 / i8) + 3, height - 1), this.mFramePaint);
            } else {
                int i10 = i * width;
                int i11 = this.mColumnCount;
                canvas.drawRect(new Rect(i10 / i11, 1, (i10 / i11) + 3, height - 1), this.mFramePaint);
            }
            i++;
        }
        boolean z = !this.mBottomVisible;
        int i12 = 0;
        int i13 = 0;
        while (true) {
            int i14 = this.mRowCount;
            if (i13 > i14) {
                break;
            }
            if (!(i13 == 0 || i13 == i14) || ((i13 == 0 && this.mTopVisible) || (i13 == this.mRowCount && this.mBottomVisible))) {
                if (this.isGradienterEnabled && this.mCurrentDirect == GradienterDrawer.Direct.BOTTOM && i13 == 1) {
                    int i15 = i13 * height;
                    int i16 = this.mRowCount;
                    canvas.drawRect(new Rect(z, i15 / i16, width / this.mColumnCount, (i15 / i16) + 3), this.mFramePaint);
                    int i17 = this.mColumnCount;
                    int i18 = this.mRowCount;
                    canvas.drawRect(new Rect(((width / i17) * (i17 - 1)) + z, i15 / i18, width - z, (i15 / i18) + 3), this.mFramePaint);
                } else if (this.isGradienterEnabled && this.mCurrentDirect == GradienterDrawer.Direct.TOP && i13 == 2) {
                    int i19 = i13 * height;
                    int i20 = this.mRowCount;
                    canvas.drawRect(new Rect(z, i19 / i20, width / this.mColumnCount, (i19 / i20) + 3), this.mFramePaint);
                    int i21 = this.mColumnCount;
                    int i22 = this.mRowCount;
                    canvas.drawRect(new Rect(((width / i21) * (i21 - 1)) + z, i19 / i22, width - z, (i19 / i22) + 3), this.mFramePaint);
                } else {
                    int i23 = i13 * height;
                    int i24 = this.mRowCount;
                    canvas.drawRect(new Rect(z, i23 / i24, width - z, (i23 / i24) + 3), this.mFramePaint);
                }
            }
            i13++;
        }
        int i25 = 1;
        while (true) {
            int i26 = this.mColumnCount;
            if (i25 >= i26) {
                break;
            }
            if (this.isGradienterEnabled && this.mCurrentDirect == GradienterDrawer.Direct.RIGHT && i25 == 1) {
                int i27 = i25 * width;
                canvas.drawRect(new Rect(i27 / i26, 1, (i27 / i26) + 2, height / this.mRowCount), this.mLinePaint);
                int i28 = this.mColumnCount;
                int i29 = this.mRowCount;
                canvas.drawRect(new Rect(i27 / i28, ((height / i29) * (i29 - 1)) + 1, (i27 / i28) + 2, height - 1), this.mLinePaint);
            } else if (this.isGradienterEnabled && this.mCurrentDirect == GradienterDrawer.Direct.LEFT && i25 == 2) {
                int i30 = i25 * width;
                int i31 = this.mColumnCount;
                canvas.drawRect(new Rect(i30 / i31, 1, (i30 / i31) + 2, height / this.mRowCount), this.mLinePaint);
                int i32 = this.mColumnCount;
                int i33 = this.mRowCount;
                canvas.drawRect(new Rect(i30 / i32, ((height / i33) * (i33 - 1)) + 1, (i30 / i32) + 2, height - 1), this.mLinePaint);
            } else {
                int i34 = i25 * width;
                int i35 = this.mColumnCount;
                canvas.drawRect(new Rect(i34 / i35, 1, (i34 / i35) + 2, height - 1), this.mLinePaint);
            }
            i25++;
        }
        while (true) {
            int i36 = this.mRowCount;
            if (i12 <= i36) {
                if (!(i12 == 0 || i12 == i36) || ((i12 == 0 && this.mTopVisible) || (i12 == this.mRowCount && this.mBottomVisible))) {
                    if (this.isGradienterEnabled && this.mCurrentDirect == GradienterDrawer.Direct.BOTTOM && i12 == 1) {
                        int i37 = i12 * height;
                        int i38 = this.mRowCount;
                        canvas.drawRect(new Rect(z, i37 / i38, width / this.mColumnCount, (i37 / i38) + 2), this.mLinePaint);
                        int i39 = this.mColumnCount;
                        int i40 = this.mRowCount;
                        canvas.drawRect(new Rect(((width / i39) * (i39 - 1)) + z, i37 / i40, width - z, (i37 / i40) + 2), this.mLinePaint);
                    } else if (this.isGradienterEnabled && this.mCurrentDirect == GradienterDrawer.Direct.TOP && i12 == 2) {
                        int i41 = i12 * height;
                        int i42 = this.mRowCount;
                        canvas.drawRect(new Rect(z, i41 / i42, width / this.mColumnCount, (i41 / i42) + 2), this.mLinePaint);
                        int i43 = this.mColumnCount;
                        int i44 = this.mRowCount;
                        canvas.drawRect(new Rect(((width / i43) * (i43 - 1)) + z, i41 / i44, width - z, (i41 / i44) + 2), this.mLinePaint);
                    } else {
                        int i45 = i12 * height;
                        int i46 = this.mRowCount;
                        canvas.drawRect(new Rect(z, i45 / i46, width - (z ? 1 : 0), (i45 / i46) + 2), this.mLinePaint);
                    }
                }
                i12++;
            } else {
                return;
            }
        }
    }

    private void updateView(Canvas canvas) {
        GradienterDrawer.Direct direct;
        this.mDeviceRotation = EffectController.getInstance().getDeviceRotation();
        float f2 = this.mDeviceRotation;
        if (f2 <= 45.0f || f2 >= 135.0f) {
            float f3 = this.mDeviceRotation;
            if (f3 < 135.0f || f3 >= 225.0f) {
                float f4 = this.mDeviceRotation;
                if (f4 <= 225.0f || f4 >= 315.0f) {
                    direct = GradienterDrawer.Direct.BOTTOM;
                    int i = (this.mDeviceRotation > 300.0f ? 1 : (this.mDeviceRotation == 300.0f ? 0 : -1));
                } else {
                    direct = GradienterDrawer.Direct.LEFT;
                }
            } else {
                direct = GradienterDrawer.Direct.TOP;
            }
        } else {
            direct = GradienterDrawer.Direct.RIGHT;
        }
        if (direct != this.mCurrentDirect) {
            this.mCurrentDirect = direct;
        }
        resetline(canvas);
        if (this.isGradienterEnabled) {
            invalidate();
        }
    }

    public void initialize(int i, int i2) {
        this.mColumnCount = Math.max(i2, 1);
        this.mRowCount = Math.max(i, 1);
        this.mLinePaint = new Paint();
        this.mFramePaint = new Paint();
        this.mLinePaint.setStrokeWidth(1.0f);
        this.mFramePaint.setStrokeWidth(1.0f);
        this.mLinePaint.setStyle(Paint.Style.FILL);
        this.mFramePaint.setStyle(Paint.Style.STROKE);
        this.mLinePaint.setColor(this.mLineColor);
        this.mFramePaint.setColor(this.mFrameColor);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        updateView(canvas);
        super.onDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            this.mCurrentDirect = GradienterDrawer.Direct.NONE;
        }
    }

    public void setBorderVisible(boolean z, boolean z2) {
        if (this.mTopVisible != z || this.mBottomVisible != z2) {
            this.mTopVisible = z;
            this.mBottomVisible = z2;
            invalidate();
        }
    }

    public void setGradienterEnabled(boolean z) {
        this.isGradienterEnabled = z;
        if (getVisibility() == 0) {
            this.mCurrentDirect = GradienterDrawer.Direct.NONE;
            invalidate();
        }
    }

    public void setLineColor(int i) {
        this.mLineColor = i;
    }
}
