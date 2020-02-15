package com.android.camera.fragment.manually.adapter.sat;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.CharacterStyle;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.util.Spline;
import android.view.View;
import com.android.camera.ActivityBase;
import com.android.camera.HybridZoomingSystem;
import com.android.camera.R;
import com.android.camera.Util;
import com.android.camera.constant.ColorConstant;
import com.android.camera.data.data.ComponentData;
import com.android.camera.fragment.manually.ManuallyListener;
import com.android.camera.fragment.manually.adapter.AbstractZoomSliderAdapter;
import com.android.camera.log.Log;
import com.android.camera.module.BaseModule;

public class FourSatZoomSliderAdapter extends AbstractZoomSliderAdapter {
    public static final int ENTRY_COUNT_10X_TO_MAX = 12;
    public static final int ENTRY_COUNT_1X_TO_5X = 11;
    public static final int ENTRY_COUNT_1X_TO_5X_RANGE_10X = 11;
    public static final int ENTRY_COUNT_5X_TO_10X = 11;
    public static final int ENTRY_COUNT_5X_TO_10X_RANGE_10X = 21;
    public static int ENTRY_COUNT_MIN_TO_10X_RANGE_10X = 31;
    public static final int ENTRY_COUNT_MIN_TO_1X = 5;
    public static int ENTRY_COUNT_MIN_TO_MAX = 36;
    public static int ENTRY_COUNT_TOTAL = ENTRY_COUNT_MIN_TO_MAX;
    public static final int ENTRY_INDEX_10X = 24;
    public static final int ENTRY_INDEX_10X_RANGE_10X = 30;
    public static final int ENTRY_INDEX_1X = 4;
    public static final int ENTRY_INDEX_1X_RANGE_10X = 0;
    public static final int ENTRY_INDEX_5X = 14;
    public static final int ENTRY_INDEX_5X_RANGE_10X = 10;
    public static int ENTRY_INDEX_LAST = 35;
    public static int ENTRY_INDEX_MAX = ENTRY_INDEX_LAST;
    public static final int ENTRY_INDEX_MIN = 0;
    private static final float[] RANGE_10X_TO_MAX_ENTRY_INDEX_X = {24.0f, 29.0f, 35.0f, 43.0f, 44.0f};
    private static final float[] RANGE_10X_TO_MAX_ZOOM_RATIO_Y = {10.0f, 20.0f, 32.0f, 46.4f, 50.0f};
    private static final float[] RANGE_1X_TO_5X_ENTRY_INDEX_X = {4.0f, 14.0f};
    private static final float[] RANGE_1X_TO_5X_FOR_10X_ENTRY_INDEX_X = {0.0f, 2.0f, 4.0f, 6.0f, 8.0f, 10.0f};
    private static final float[] RANGE_1X_TO_5X_FOR_10X_ZOOM_RATIO_Y = {1.0f, 1.8f, 2.6f, 3.4f, 4.2f, 5.0f};
    private static final float[] RANGE_1X_TO_5X_ZOOM_RATIO_Y = {1.0f, 5.0f};
    private static final float[] RANGE_5X_TO_10X_ENTRY_INDEX_X = {14.0f, 24.0f};
    private static final float[] RANGE_5X_TO_10X_FOR_10X_ENTRY_INDEX_X = {10.0f, 12.0f, 14.0f, 20.0f, 22.0f, 26.0f, 30.0f};
    private static final float[] RANGE_5X_TO_10X_FOR_10X_ZOOM_RATIO_Y = {5.0f, 5.5f, 6.0f, 7.5f, 8.0f, 9.0f, 10.0f};
    private static final float[] RANGE_5X_TO_10X_ZOOM_RATIO_Y = {5.0f, 10.0f};
    private static final float[] RANGE_MIN_TO_1X_ENTRY_INDEX_X = {0.0f, 1.0f, 2.0f, 3.0f, 4.0f};
    private static final float[] RANGE_MIN_TO_1X_ZOOM_RATIO_Y = {0.6f, 0.7f, 0.8f, 0.9f, 1.0f};
    private static final String TAG = "FourSatZoomSliderAdapter";
    private ComponentData mComponentData;
    private int mCurrentMode;
    private String mCurrentValue = "-1";
    private int mCurrentValueIndex = -1;
    private boolean mEnable;
    private StaticLayout[] mEntryLayouts;
    private boolean mIsLayoutRTL;
    private int mLineColorDefault;
    private float mLineHalfHeight;
    private int mLineTextGap;
    private int mLineWidth;
    private ManuallyListener mManuallyListener;
    private Paint mPaint;
    private Spline mRange10XToMaxEntryToZoomRatioSpline;
    private Spline mRange10XToMaxZoomRatioToEntrySpline;
    private Spline mRange1XTo5XEntryToZoomRatioSpline;
    private Spline mRange1XTo5XFor10XEntryToZoomRatioSpline;
    private Spline mRange1XTo5XFor10XZoomRatioToEntrySpline;
    private Spline mRange1XTo5XZoomRatioToEntrySpline;
    private Spline mRange5XTo10XEntryToZoomRatioSpline;
    private Spline mRange5XTo10XFor10XEntryToZoomRatioSpline;
    private Spline mRange5XTo10XFor10XZoomRatioToEntrySpline;
    private Spline mRange5XTo10XZoomRatioToEntrySpline;
    private Spline mRangeMinTo1XEntryToZoomRatioSpline;
    private Spline mRangeMinTo1XZoomRatioToEntrySpline;
    private int mSelectHalfHeight;
    private Paint mSelectPaint;
    private AbsoluteSizeSpan mSpaceTextStyle;
    private int mTargetHalfHeight;
    private StyleSpan mTextBoldStyle;
    private int mTextColor;
    private TypefaceSpan mTextFontStyle;
    private TextPaint mTextPaint;
    private int mTextSize;
    private final float mZoomRatioMax;
    private final float mZoomRatioMin;

    public FourSatZoomSliderAdapter(Context context, ComponentData componentData, int i, ManuallyListener manuallyListener) {
        this.mComponentData = componentData;
        this.mCurrentMode = i;
        this.mManuallyListener = manuallyListener;
        this.mIsLayoutRTL = Util.isLayoutRTL(context);
        this.mCurrentValue = componentData.getComponentValue(this.mCurrentMode);
        BaseModule baseModule = (BaseModule) ((ActivityBase) context).getCurrentModule();
        this.mZoomRatioMax = baseModule.getMaxZoomRatio();
        this.mZoomRatioMin = baseModule.getMinZoomRatio();
        Log.d(TAG, "ZOOM RATIO RANGE [" + this.mZoomRatioMin + ", " + this.mZoomRatioMax + "]");
        if (this.mZoomRatioMax > 10.0f) {
            this.mRangeMinTo1XEntryToZoomRatioSpline = Spline.createLinearSpline(RANGE_MIN_TO_1X_ENTRY_INDEX_X, RANGE_MIN_TO_1X_ZOOM_RATIO_Y);
            this.mRangeMinTo1XZoomRatioToEntrySpline = Spline.createLinearSpline(RANGE_MIN_TO_1X_ZOOM_RATIO_Y, RANGE_MIN_TO_1X_ENTRY_INDEX_X);
            this.mRange1XTo5XEntryToZoomRatioSpline = Spline.createLinearSpline(RANGE_1X_TO_5X_ENTRY_INDEX_X, RANGE_1X_TO_5X_ZOOM_RATIO_Y);
            this.mRange1XTo5XZoomRatioToEntrySpline = Spline.createLinearSpline(RANGE_1X_TO_5X_ZOOM_RATIO_Y, RANGE_1X_TO_5X_ENTRY_INDEX_X);
            this.mRange5XTo10XEntryToZoomRatioSpline = Spline.createLinearSpline(RANGE_5X_TO_10X_ENTRY_INDEX_X, RANGE_5X_TO_10X_ZOOM_RATIO_Y);
            this.mRange5XTo10XZoomRatioToEntrySpline = Spline.createLinearSpline(RANGE_5X_TO_10X_ZOOM_RATIO_Y, RANGE_5X_TO_10X_ENTRY_INDEX_X);
            float[] entryX = getEntryX();
            float[] zoomRatioY = getZoomRatioY(this.mZoomRatioMax);
            this.mRange10XToMaxEntryToZoomRatioSpline = Spline.createMonotoneCubicSpline(entryX, zoomRatioY);
            this.mRange10XToMaxZoomRatioToEntrySpline = Spline.createMonotoneCubicSpline(zoomRatioY, entryX);
            ENTRY_COUNT_TOTAL = ENTRY_COUNT_MIN_TO_MAX;
            ENTRY_INDEX_MAX = ENTRY_INDEX_LAST;
        } else {
            this.mRange1XTo5XFor10XEntryToZoomRatioSpline = Spline.createSpline(RANGE_1X_TO_5X_FOR_10X_ENTRY_INDEX_X, RANGE_1X_TO_5X_FOR_10X_ZOOM_RATIO_Y);
            this.mRange1XTo5XFor10XZoomRatioToEntrySpline = Spline.createSpline(RANGE_1X_TO_5X_FOR_10X_ZOOM_RATIO_Y, RANGE_1X_TO_5X_FOR_10X_ENTRY_INDEX_X);
            this.mRange5XTo10XFor10XEntryToZoomRatioSpline = Spline.createSpline(RANGE_5X_TO_10X_FOR_10X_ENTRY_INDEX_X, RANGE_5X_TO_10X_FOR_10X_ZOOM_RATIO_Y);
            this.mRange5XTo10XFor10XZoomRatioToEntrySpline = Spline.createSpline(RANGE_5X_TO_10X_FOR_10X_ZOOM_RATIO_Y, RANGE_5X_TO_10X_FOR_10X_ENTRY_INDEX_X);
            ENTRY_COUNT_TOTAL = ENTRY_COUNT_MIN_TO_10X_RANGE_10X;
            ENTRY_INDEX_MAX = 30;
        }
        initStyle(context);
        CharSequence[] charSequenceArr = {createZoomRatioLabel(this.mZoomRatioMin), createZoomRatioLabel(this.mZoomRatioMax)};
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
            setStyleSpan(spannableStringBuilder, String.valueOf(i));
        } else {
            setStyleSpan(spannableStringBuilder, String.valueOf(decimal));
        }
        Util.appendInApi26(spannableStringBuilder, " ", this.mSpaceTextStyle, 33);
        setStyleSpan(spannableStringBuilder, "X");
        return spannableStringBuilder;
    }

    private void drawText(float f2, int i, Canvas canvas) {
        canvas.save();
        canvas.translate(f2, ((float) (this.mEntryLayouts[i].getLineAscent(0) - this.mEntryLayouts[i].getLineDescent(0))) / 2.0f);
        this.mEntryLayouts[i].draw(canvas);
        canvas.restore();
    }

    private static boolean drawTextForItemAt(int i) {
        return i == 0 || i == ENTRY_INDEX_MAX;
    }

    private static float[] getEntryX() {
        float[] fArr = RANGE_10X_TO_MAX_ENTRY_INDEX_X;
        float f2 = (float) 24;
        int i = (int) ((fArr[fArr.length - 1] - f2) + 1.0f);
        float[] fArr2 = new float[fArr.length];
        for (int i2 = 0; i2 < fArr.length; i2++) {
            if (fArr[i2] <= f2) {
                fArr2[i2] = fArr[i2];
            } else {
                fArr2[i2] = (((fArr[i2] - f2) / ((float) (i - 1))) * 11.0f) + f2;
            }
        }
        return fArr2;
    }

    private static float[] getZoomRatioY(float f2) {
        float[] fArr = RANGE_10X_TO_MAX_ZOOM_RATIO_Y;
        int i = (int) fArr[fArr.length - 1];
        float[] fArr2 = new float[fArr.length];
        for (int i2 = 0; i2 < fArr.length; i2++) {
            if (fArr[i2] <= 10.0f) {
                fArr2[i2] = fArr[i2];
            } else {
                fArr2[i2] = (((fArr[i2] - 10.0f) / (((float) i) - 10.0f)) * (f2 - 10.0f)) + 10.0f;
            }
        }
        return fArr2;
    }

    private int indexToSection(int i) {
        if (i == 0) {
            return 0;
        }
        return i == ENTRY_INDEX_MAX ? 1 : -1;
    }

    private void initStyle(Context context) {
        Resources resources = context.getResources();
        this.mTextSize = resources.getDimensionPixelSize(R.dimen.zoom_popup_text_size);
        this.mTextColor = resources.getColor(R.color.zoom_popup_color_new_default);
        this.mLineHalfHeight = (float) (resources.getDimensionPixelSize(R.dimen.zoom_popup_line_height_nornal) / 2);
        this.mTargetHalfHeight = resources.getDimensionPixelSize(R.dimen.zoom_popup_line_height_target) / 2;
        this.mSelectHalfHeight = resources.getDimensionPixelSize(R.dimen.zoom_popup_line_height_select) / 2;
        this.mLineWidth = resources.getDimensionPixelSize(R.dimen.zoom_popup_line_width);
        this.mLineTextGap = resources.getDimensionPixelSize(R.dimen.zoom_popup_line_text_margin);
        this.mLineColorDefault = resources.getColor(R.color.zoom_popup_color_new_default);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStrokeWidth((float) this.mLineWidth);
        this.mPaint.setColor(this.mLineColorDefault);
        this.mSelectPaint = new Paint(this.mPaint);
        this.mSelectPaint.setColor(ColorConstant.COLOR_COMMON_SELECTED);
        this.mPaint.setShadowLayer(1.0f, 0.0f, 1.0f, -1090519040);
        this.mTextPaint = new TextPaint(this.mPaint);
        this.mTextPaint.setTextSize((float) this.mTextSize);
        this.mTextPaint.setColor(this.mTextColor);
        this.mSpaceTextStyle = new AbsoluteSizeSpan(18, true);
        this.mTextFontStyle = new TypefaceSpan(Util.getLanTineGBTypeface(context));
        this.mTextBoldStyle = new StyleSpan(1);
    }

    private SpannableStringBuilder setStyleSpan(SpannableStringBuilder spannableStringBuilder, CharSequence charSequence) {
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append(charSequence);
        spannableStringBuilder.setSpan(CharacterStyle.wrap(this.mTextFontStyle), length, spannableStringBuilder.length(), 33);
        spannableStringBuilder.setSpan(CharacterStyle.wrap(this.mTextBoldStyle), length, spannableStringBuilder.length(), 33);
        return spannableStringBuilder;
    }

    public void draw(float f2, int i, Canvas canvas, boolean z) {
        if ((i == 0 && !this.mIsLayoutRTL) || (i == ENTRY_INDEX_MAX && this.mIsLayoutRTL)) {
            drawText(f2, indexToSection(i), canvas);
            f2 += measureWidth(i) - ((float) this.mLineWidth);
        }
        if (z) {
            int i2 = this.mSelectHalfHeight;
            canvas.drawLine(f2, (float) (-i2), f2, (float) i2, this.mSelectPaint);
        } else if ((this.mZoomRatioMax <= 10.0f || !(i == 0 || i == 4 || i == 14 || i == 24 || i == ENTRY_INDEX_MAX)) && (this.mZoomRatioMax > 10.0f || !(i == 0 || i == 10 || i == 30))) {
            float f3 = this.mLineHalfHeight;
            canvas.drawLine(f2, -f3, f2, f3, this.mPaint);
        } else {
            int i3 = this.mTargetHalfHeight;
            canvas.drawLine(f2, (float) (-i3), f2, (float) i3, this.mPaint);
        }
        if ((i == ENTRY_INDEX_MAX && !this.mIsLayoutRTL) || (i == 0 && this.mIsLayoutRTL)) {
            drawText(f2 + ((float) this.mLineWidth) + ((float) this.mLineTextGap), indexToSection(i), canvas);
        }
    }

    public Paint.Align getAlign(int i) {
        return null;
    }

    public int getCount() {
        return ENTRY_COUNT_TOTAL;
    }

    public boolean isEnable() {
        return this.mEnable;
    }

    public float mapPositionToZoomRatio(float f2) {
        if (this.mZoomRatioMax > 10.0f) {
            return (0.0f > f2 || f2 >= 4.0f) ? (4.0f > f2 || f2 >= 14.0f) ? (14.0f > f2 || f2 > 24.0f) ? this.mRange10XToMaxEntryToZoomRatioSpline.interpolate(f2) : this.mRange5XTo10XEntryToZoomRatioSpline.interpolate(f2) : this.mRange1XTo5XEntryToZoomRatioSpline.interpolate(f2) : this.mRangeMinTo1XEntryToZoomRatioSpline.interpolate(f2);
        }
        if (0.0f <= f2 && f2 < 10.0f) {
            return this.mRange1XTo5XFor10XEntryToZoomRatioSpline.interpolate(f2);
        }
        if (10.0f > f2 || f2 > 30.0f) {
            return 0.0f;
        }
        return this.mRange5XTo10XFor10XEntryToZoomRatioSpline.interpolate(f2);
    }

    public float mapZoomRatioToPosition(float f2) {
        if (this.mZoomRatioMax > 10.0f) {
            return (0.6f > f2 || f2 >= 1.0f) ? (1.0f > f2 || f2 >= 5.0f) ? (5.0f > f2 || f2 > 10.0f) ? this.mRange10XToMaxZoomRatioToEntrySpline.interpolate(f2) : this.mRange5XTo10XZoomRatioToEntrySpline.interpolate(f2) : this.mRange1XTo5XZoomRatioToEntrySpline.interpolate(f2) : this.mRangeMinTo1XZoomRatioToEntrySpline.interpolate(f2);
        }
        if (1.0f <= f2 && f2 < 5.0f) {
            return this.mRange1XTo5XFor10XZoomRatioToEntrySpline.interpolate(f2);
        }
        if (5.0f > f2 || f2 > 10.0f) {
            return 0.0f;
        }
        return this.mRange5XTo10XFor10XZoomRatioToEntrySpline.interpolate(f2);
    }

    public float measureTextWidth(int i) {
        if (drawTextForItemAt(i)) {
            return this.mEntryLayouts[indexToSection(i)].getLineWidth(0);
        }
        return 0.0f;
    }

    public float measureWidth(int i) {
        return drawTextForItemAt(i) ? this.mEntryLayouts[indexToSection(i)].getLineWidth(0) + ((float) this.mLineWidth) + ((float) this.mLineTextGap) : (float) this.mLineWidth;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003a, code lost:
        if (r12.mCurrentValueIndex != r14) goto L_0x00c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0053, code lost:
        if (r12.mCurrentValueIndex != r14) goto L_0x00c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006b, code lost:
        if (r12.mCurrentValueIndex != r14) goto L_0x00c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0096, code lost:
        if (r12.mCurrentValueIndex != r14) goto L_0x00c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ad, code lost:
        if (r12.mCurrentValueIndex != r14) goto L_0x00c9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    public void onPositionSelect(View view, int i, float f2) {
        boolean z;
        if (this.mEnable) {
            String str = null;
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            if (f2 >= 1.0f) {
                f2 = 1.0f;
            }
            boolean z2 = true;
            if (i == -1 || this.mZoomRatioMax <= 10.0f) {
                if (i == -1) {
                    getCount();
                    str = String.valueOf(mapPositionToZoomRatio(f2 * ((float) (getCount() - 1))));
                    z = str.equals(this.mCurrentValue);
                    z2 = true ^ z;
                    if (!z2) {
                    }
                } else if (i <= 10) {
                    str = String.valueOf(HybridZoomingSystem.add(1.0f, ((float) i) * 0.4f));
                } else {
                    if (i <= 30) {
                        str = String.valueOf(HybridZoomingSystem.add(5.0f, ((float) (i - 10)) * 0.25f));
                    }
                    if (!z2) {
                        this.mComponentData.setComponentValue(this.mCurrentMode, str);
                        ManuallyListener manuallyListener = this.mManuallyListener;
                        if (manuallyListener != null) {
                            manuallyListener.onManuallyDataChanged(this.mComponentData, this.mCurrentValue, str, false, this.mCurrentMode);
                        }
                        this.mCurrentValue = str;
                        this.mCurrentValueIndex = i;
                        return;
                    }
                    return;
                }
            } else if (i <= 4) {
                str = String.valueOf(HybridZoomingSystem.add(0.6f, ((float) i) * 0.1f));
            } else if (i <= 14) {
                str = String.valueOf(HybridZoomingSystem.add(1.0f, ((float) (i - 4)) * 0.4f));
            } else if (i <= 24) {
                str = String.valueOf(HybridZoomingSystem.add(5.0f, ((float) (i - 14)) * 0.5f));
            } else {
                str = String.valueOf(mapPositionToZoomRatio(f2 * ((float) (getCount() - 1))));
                z = str.equals(this.mCurrentValue);
                z2 = true ^ z;
                if (!z2) {
                }
            }
            z2 = false;
            if (!z2) {
            }
        }
    }

    public void setEnable(boolean z) {
        this.mEnable = z;
    }
}
