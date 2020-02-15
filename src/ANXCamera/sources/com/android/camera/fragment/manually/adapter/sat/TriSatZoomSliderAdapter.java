package com.android.camera.fragment.manually.adapter.sat;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.TextAppearanceSpan;
import android.util.Spline;
import android.view.View;
import com.android.camera.ActivityBase;
import com.android.camera.HybridZoomingSystem;
import com.android.camera.R;
import com.android.camera.Util;
import com.android.camera.data.data.ComponentData;
import com.android.camera.fragment.manually.ManuallyListener;
import com.android.camera.fragment.manually.adapter.AbstractZoomSliderAdapter;
import com.android.camera.lib.compatibility.related.vibrator.ViberatorContext;
import com.android.camera.log.Log;
import com.android.camera.module.BaseModule;

public class TriSatZoomSliderAdapter extends AbstractZoomSliderAdapter {
    public static final int ENTRY_COUNT_1X_TO_2X = 11;
    public static final int ENTRY_COUNT_2X_TO_MAX = 38;
    public static final int ENTRY_COUNT_MIN_TO_1X = 5;
    public static final int ENTRY_COUNT_TOTAL = 52;
    public static final int ENTRY_INDEX_1X = 4;
    public static final int ENTRY_INDEX_2X = 14;
    public static final int ENTRY_INDEX_MAX = 51;
    public static final int ENTRY_INDEX_MIN = 0;
    public static final int ENTRY_INDEX_TELE_ACTUAL = findActualTeleIndex();
    private static final float[] RANGE_1X_TO_2X_ENTRY_INDEX_X = {4.0f, 14.0f};
    private static final float[] RANGE_1X_TO_2X_ZOOM_RATIO_Y = {1.0f, 2.0f};
    private static final float[] RANGE_2X_TO_MAX_ENTRY_INDEX_X = {14.0f, 16.0f, 24.0f, 29.0f, 31.0f, 33.0f, 34.0f, 36.0f, 39.0f};
    private static final float[] RANGE_2X_TO_MAX_ZOOM_RATIO_Y = {2.0f, 2.2f, 3.7f, 5.1f, 5.8f, 6.6f, 7.0f, 8.0f, 10.0f};
    private static final float[] RANGE_MIN_TO_1X_ENTRY_INDEX_X = {0.0f, 1.0f, 2.0f, 3.0f, 4.0f};
    private static final float[] RANGE_MIN_TO_1X_ZOOM_RATIO_Y = {0.6f, 0.7f, 0.8f, 0.9f, 1.0f};
    private static final String TAG = "TriSatZoomSliderAdapter";
    private static final int[] sTextActivatedColorState = {16843518};
    private static final int[] sTextDefaultColorState = {0};
    private ComponentData mComponentData;
    private int mCurrentMode;
    private String mCurrentValue;
    private int mCurrentValueIndex;
    private TextAppearanceSpan mDigitsTextStyle;
    private int mDotColorActivated;
    private int mDotRadius;
    private boolean mEnable;
    private StaticLayout[] mEntryLayouts;
    private int mLineColorDefault;
    private int mLineDotYGap;
    private float mLineHalfHeight;
    private int mLineLineGap;
    private int mLineTextGap;
    private int mLineWidth;
    private ManuallyListener mManuallyListener;
    private Paint mPaint;
    private Spline mRange1XTo2XEntryToZoomRatioSpline = Spline.createLinearSpline(RANGE_1X_TO_2X_ENTRY_INDEX_X, RANGE_1X_TO_2X_ZOOM_RATIO_Y);
    private Spline mRange1XTo2XZoomRatioToEntrySpline = Spline.createLinearSpline(RANGE_1X_TO_2X_ZOOM_RATIO_Y, RANGE_1X_TO_2X_ENTRY_INDEX_X);
    private Spline mRange2XToMaxEntryToZoomRatioSpline;
    private Spline mRange2XToMaxZoomRatioToEntrySpline;
    private Spline mRangeMinTo1XEntryToZoomRatioSpline = Spline.createLinearSpline(RANGE_MIN_TO_1X_ENTRY_INDEX_X, RANGE_MIN_TO_1X_ZOOM_RATIO_Y);
    private Spline mRangeMinTo1XZoomRatioToEntrySpline = Spline.createLinearSpline(RANGE_MIN_TO_1X_ZOOM_RATIO_Y, RANGE_MIN_TO_1X_ENTRY_INDEX_X);
    private ColorStateList mTextColor;
    private TextPaint mTextPaint;
    private int mTextSize;
    private ViberatorContext mViberatorContext;
    private TextAppearanceSpan mXTextStyle;
    private final float mZoomRatioMax;
    private final float mZoomRatioMin;

    public TriSatZoomSliderAdapter(Context context, ComponentData componentData, int i, ManuallyListener manuallyListener) {
        this.mViberatorContext = ViberatorContext.getInstance(context);
        this.mComponentData = componentData;
        this.mCurrentMode = i;
        this.mManuallyListener = manuallyListener;
        this.mCurrentValue = componentData.getComponentValue(this.mCurrentMode);
        BaseModule baseModule = (BaseModule) ((ActivityBase) context).getCurrentModule();
        this.mZoomRatioMax = baseModule.getMaxZoomRatio();
        this.mZoomRatioMin = baseModule.getMinZoomRatio();
        Log.d(TAG, "ZOOM RATIO RANGE [" + this.mZoomRatioMin + ", " + this.mZoomRatioMax + "]");
        float[] entryX = getEntryX();
        float[] zoomRatioY = getZoomRatioY(this.mZoomRatioMax);
        this.mRange2XToMaxEntryToZoomRatioSpline = Spline.createMonotoneCubicSpline(entryX, zoomRatioY);
        this.mRange2XToMaxZoomRatioToEntrySpline = Spline.createMonotoneCubicSpline(zoomRatioY, entryX);
        initStyle(context);
        CharSequence[] charSequenceArr = {createZoomRatioLabel(0.6f), createZoomRatioLabel(1.0f), createZoomRatioLabel(2.0f), createZoomRatioLabel(this.mZoomRatioMax)};
        this.mEntryLayouts = new StaticLayout[charSequenceArr.length];
        for (int i2 = 0; i2 < charSequenceArr.length; i2++) {
            StaticLayout[] staticLayoutArr = this.mEntryLayouts;
            StaticLayout staticLayout = new StaticLayout(charSequenceArr[i2], this.mTextPaint, Util.sWindowWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            staticLayoutArr[i2] = staticLayout;
        }
    }

    private CharSequence createZoomRatioLabel(float f2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        float decimal = HybridZoomingSystem.toDecimal(f2);
        int i = (int) decimal;
        if (((int) ((10.0f * decimal) - ((float) (i * 10)))) == 0) {
            Util.appendInApi26(spannableStringBuilder, String.valueOf(i), this.mDigitsTextStyle, 33);
        } else {
            Util.appendInApi26(spannableStringBuilder, String.valueOf(decimal), this.mDigitsTextStyle, 33);
        }
        Util.appendInApi26(spannableStringBuilder, "X", this.mXTextStyle, 33);
        return spannableStringBuilder;
    }

    private void drawText(int i, Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, ((float) (this.mEntryLayouts[i].getLineAscent(0) - this.mEntryLayouts[i].getLineDescent(0))) / 2.0f);
        this.mEntryLayouts[i].draw(canvas);
        canvas.restore();
    }

    private static boolean drawTextForItemAt(int i) {
        return i == 0 || i == 4 || i == 14 || i == 51;
    }

    static int findActualTeleIndex() {
        float realZoomRatioTele = (float) AbstractZoomSliderAdapter.getRealZoomRatioTele();
        if (realZoomRatioTele == 20.0f || realZoomRatioTele <= 10.0f || realZoomRatioTele >= 20.0f) {
            return 14;
        }
        return (int) (realZoomRatioTele - 10.0f);
    }

    private static float[] getEntryX() {
        float[] fArr = RANGE_2X_TO_MAX_ENTRY_INDEX_X;
        float f2 = (float) 14;
        int i = (int) ((fArr[fArr.length - 1] - f2) + 1.0f);
        float[] fArr2 = new float[fArr.length];
        for (int i2 = 0; i2 < fArr.length; i2++) {
            if (fArr[i2] <= f2) {
                fArr2[i2] = fArr[i2];
            } else {
                fArr2[i2] = (((fArr[i2] - f2) / ((float) (i - 1))) * 37.0f) + f2;
            }
        }
        return fArr2;
    }

    private static float[] getZoomRatioY(float f2) {
        float[] fArr = RANGE_2X_TO_MAX_ZOOM_RATIO_Y;
        int i = (int) fArr[fArr.length - 1];
        float[] fArr2 = new float[fArr.length];
        for (int i2 = 0; i2 < fArr.length; i2++) {
            if (fArr[i2] <= 2.0f) {
                fArr2[i2] = fArr[i2];
            } else {
                fArr2[i2] = (((fArr[i2] - 2.0f) / (((float) i) - 2.0f)) * (f2 - 2.0f)) + 2.0f;
            }
        }
        return fArr2;
    }

    private static int indexToSection(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 4) {
            return 1;
        }
        if (i == 14) {
            return 2;
        }
        return i == 51 ? 3 : -1;
    }

    private void initStyle(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(R.style.SingeTextItemTextStyle, new int[]{16842901, 16842904});
        this.mTextSize = obtainStyledAttributes.getDimensionPixelSize(obtainStyledAttributes.getIndex(0), this.mTextSize);
        this.mTextColor = obtainStyledAttributes.getColorStateList(obtainStyledAttributes.getIndex(1));
        obtainStyledAttributes.recycle();
        Resources resources = context.getResources();
        this.mLineHalfHeight = ((float) resources.getDimensionPixelSize(R.dimen.focus_line_height)) / 2.0f;
        this.mLineWidth = resources.getDimensionPixelSize(R.dimen.focus_line_width);
        this.mDotRadius = resources.getDimensionPixelSize(R.dimen.zoom_popup_dot_radius);
        this.mLineLineGap = resources.getDimensionPixelSize(R.dimen.focus_line_line_gap);
        this.mLineTextGap = resources.getDimensionPixelSize(R.dimen.focus_line_text_gap);
        this.mLineDotYGap = resources.getDimensionPixelSize(R.dimen.zoom_popup_line_dot_y_gap);
        this.mLineColorDefault = resources.getColor(R.color.zoom_popup_line_color_default);
        this.mDotColorActivated = resources.getColor(R.color.zoom_popup_dot_color_activated);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStrokeWidth((float) this.mLineWidth);
        this.mPaint.setTextSize((float) this.mTextSize);
        this.mPaint.setTextAlign(Paint.Align.LEFT);
        this.mTextPaint = new TextPaint(this.mPaint);
        this.mDigitsTextStyle = new TextAppearanceSpan(context, R.style.ZoomPopupDigitsTextStyle);
        this.mXTextStyle = new TextAppearanceSpan(context, R.style.ZoomPopupXTextStyle);
    }

    public void draw(int i, Canvas canvas, boolean z) {
        if (drawTextForItemAt(i)) {
            this.mTextPaint.drawableState = z ? sTextActivatedColorState : sTextDefaultColorState;
            drawText(indexToSection(i), canvas);
            return;
        }
        this.mPaint.setColor(z ? this.mTextColor.getColorForState(sTextActivatedColorState, 0) : this.mLineColorDefault);
        float f2 = this.mLineHalfHeight;
        canvas.drawLine(0.0f, -f2, 0.0f, f2, this.mPaint);
        if (i == ENTRY_INDEX_TELE_ACTUAL) {
            this.mPaint.setColor(z ? this.mDotColorActivated : this.mLineColorDefault);
            float f3 = (-this.mLineHalfHeight) - ((float) this.mLineDotYGap);
            int i2 = this.mDotRadius;
            canvas.drawCircle(0.0f, f3 - ((float) i2), (float) i2, this.mPaint);
        }
    }

    public Paint.Align getAlign(int i) {
        return drawTextForItemAt(i) ? Paint.Align.LEFT : Paint.Align.CENTER;
    }

    public int getCount() {
        return 52;
    }

    public boolean isEnable() {
        return this.mEnable;
    }

    public float mapPositionToZoomRatio(float f2) {
        return (0.0f > f2 || f2 >= 4.0f) ? (4.0f > f2 || f2 >= 14.0f) ? this.mRange2XToMaxEntryToZoomRatioSpline.interpolate(f2) : this.mRange1XTo2XEntryToZoomRatioSpline.interpolate(f2) : this.mRangeMinTo1XEntryToZoomRatioSpline.interpolate(f2);
    }

    public float mapZoomRatioToPosition(float f2) {
        return (0.6f > f2 || f2 >= 1.0f) ? (1.0f > f2 || f2 >= 2.0f) ? this.mRange2XToMaxZoomRatioToEntrySpline.interpolate(f2) : this.mRange1XTo2XZoomRatioToEntrySpline.interpolate(f2) : this.mRangeMinTo1XZoomRatioToEntrySpline.interpolate(f2);
    }

    public float measureGap(int i) {
        return (float) (drawTextForItemAt(i) ? this.mLineTextGap : this.mLineLineGap);
    }

    public float measureWidth(int i) {
        return drawTextForItemAt(i) ? this.mEntryLayouts[indexToSection(i)].getLineWidth(0) : (float) this.mLineWidth;
    }

    public void onPositionSelect(View view, int i, float f2) {
        boolean z;
        String str;
        if (this.mEnable) {
            boolean z2 = false;
            if (i <= 14) {
                str = String.valueOf(HybridZoomingSystem.add(0.6f, ((float) i) * 0.1f));
                z = this.mCurrentValueIndex != i;
            } else {
                str = String.valueOf(mapPositionToZoomRatio(f2 * ((float) (getCount() - 1))));
                z = !str.equals(this.mCurrentValue);
            }
            if (this.mCurrentValueIndex != i) {
                z2 = true;
            }
            if (z2) {
                if (drawTextForItemAt(i)) {
                    this.mViberatorContext.performSelectZoomNormal();
                } else {
                    this.mViberatorContext.performSelectZoomLight();
                }
            }
            if (z) {
                this.mComponentData.setComponentValue(this.mCurrentMode, str);
                ManuallyListener manuallyListener = this.mManuallyListener;
                if (manuallyListener != null) {
                    manuallyListener.onManuallyDataChanged(this.mComponentData, this.mCurrentValue, str, false, this.mCurrentMode);
                }
                this.mCurrentValue = str;
                this.mCurrentValueIndex = i;
            }
        }
    }

    public void setEnable(boolean z) {
        this.mEnable = z;
    }
}
