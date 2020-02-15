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

public class NewTriSatZoomSliderAdapter extends AbstractZoomSliderAdapter {
    private static final int ENTRY_COUNT_10X_TO_MAX = 11;
    private static int ENTRY_COUNT_MIN_TO_MAX = 35;
    private static int ENTRY_COUNT_TOTAL = ENTRY_COUNT_MIN_TO_MAX;
    private static final int ENTRY_INDEX_10X = 24;
    private static final int ENTRY_INDEX_10X_RANGE_10X = 30;
    private static final int ENTRY_INDEX_1X = 4;
    private static final int ENTRY_INDEX_1X_RANGE_10X = 0;
    private static final int ENTRY_INDEX_3X = 14;
    private static final int ENTRY_INDEX_3X_RANGE_10X = 10;
    private static int ENTRY_INDEX_LAST = 34;
    private static int ENTRY_INDEX_MAX = ENTRY_INDEX_LAST;
    private static final int ENTRY_INDEX_MIN = 0;
    private static final float[] RANGE_10X_TO_MAX_ENTRY_INDEX_X = {24.0f, 26.0f, 28.0f, 30.0f, 32.0f, 34.0f};
    private static final float[] RANGE_10X_TO_MAX_ZOOM_RATIO_Y = {10.0f, 14.0f, 18.0f, 22.0f, 26.0f, 30.0f};
    private static final float[] RANGE_1X_TO_3X_ENTRY_INDEX_X = {4.0f, 14.0f};
    private static final float[] RANGE_1X_TO_3X_FOR_10X_ENTRY_INDEX_X = {0.0f, 2.0f, 4.0f, 6.0f, 8.0f, 10.0f};
    private static final float[] RANGE_1X_TO_3X_FOR_10X_ZOOM_RATIO_Y = {1.0f, 1.4f, 1.8f, 2.2f, 2.6f, 3.0f};
    private static final float[] RANGE_1X_TO_3X_ZOOM_RATIO_Y = {1.0f, 3.0f};
    private static final float[] RANGE_3X_TO_10X_ENTRY_INDEX_X = {14.0f, 24.0f};
    private static final float[] RANGE_3X_TO_10X_FOR_10X_ENTRY_INDEX_X = {10.0f, 12.0f, 14.0f, 20.0f, 22.0f, 26.0f, 30.0f};
    private static final float[] RANGE_3X_TO_10X_FOR_10X_ZOOM_RATIO_Y = {3.0f, 3.5f, 4.0f, 6.5f, 8.0f, 9.0f, 10.0f};
    private static final float[] RANGE_3X_TO_10X_ZOOM_RATIO_Y = {3.0f, 10.0f};
    private static final float[] RANGE_MIN_TO_1X_ENTRY_INDEX_X = {0.0f, 1.0f, 2.0f, 3.0f, 4.0f};
    private static final float[] RANGE_MIN_TO_1X_ZOOM_RATIO_Y = {0.6f, 0.7f, 0.8f, 0.9f, 1.0f};
    private static final String TAG = "NewFourSatZoomSliderAdapter";
    private ComponentData mComponentData;
    private int mCurrentMode;
    private String mCurrentValue;
    private int mCurrentValueIndex = -1;
    private boolean mEnable;
    private StaticLayout[] mEntryLayouts;
    private boolean mIsLayoutRTL;
    private float mLineHalfHeight;
    private int mLineTextGap;
    private int mLineWidth;
    private ManuallyListener mManuallyListener;
    private Paint mPaint;
    private Spline mRange10XToMaxEntryToZoomRatioSpline;
    private Spline mRange10XToMaxZoomRatioToEntrySpline;
    private Spline mRange1XTo3XEntryToZoomRatioSpline;
    private Spline mRange1XTo3XFor10XEntryToZoomRatioSpline;
    private Spline mRange1XTo3XFor10XZoomRatioToEntrySpline;
    private Spline mRange1XTo3XZoomRatioToEntrySpline;
    private Spline mRange3XTo10XEntryToZoomRatioSpline;
    private Spline mRange3XTo10XFor10XEntryToZoomRatioSpline;
    private Spline mRange3XTo10XFor10XZoomRatioToEntrySpline;
    private Spline mRange3XTo10XZoomRatioToEntrySpline;
    private Spline mRangeMinTo1XEntryToZoomRatioSpline;
    private Spline mRangeMinTo1XZoomRatioToEntrySpline;
    private int mSelectHalfHeight;
    private Paint mSelectPaint;
    private AbsoluteSizeSpan mSpaceTextStyle;
    private int mTargetHalfHeight;
    private StyleSpan mTextBoldStyle;
    private TypefaceSpan mTextFontStyle;
    private TextPaint mTextPaint;
    private final float mZoomRatioMax;

    public NewTriSatZoomSliderAdapter(Context context, ComponentData componentData, int i, ManuallyListener manuallyListener) {
        this.mComponentData = componentData;
        this.mCurrentMode = i;
        this.mManuallyListener = manuallyListener;
        this.mIsLayoutRTL = Util.isLayoutRTL(context);
        this.mCurrentValue = componentData.getComponentValue(this.mCurrentMode);
        BaseModule baseModule = (BaseModule) ((ActivityBase) context).getCurrentModule();
        this.mZoomRatioMax = baseModule.getMaxZoomRatio();
        float minZoomRatio = baseModule.getMinZoomRatio();
        Log.d(TAG, "ZOOM RATIO RANGE [" + minZoomRatio + ", " + this.mZoomRatioMax + "]");
        if (this.mZoomRatioMax > 10.0f) {
            this.mRangeMinTo1XEntryToZoomRatioSpline = Spline.createLinearSpline(RANGE_MIN_TO_1X_ENTRY_INDEX_X, RANGE_MIN_TO_1X_ZOOM_RATIO_Y);
            this.mRangeMinTo1XZoomRatioToEntrySpline = Spline.createLinearSpline(RANGE_MIN_TO_1X_ZOOM_RATIO_Y, RANGE_MIN_TO_1X_ENTRY_INDEX_X);
            this.mRange1XTo3XEntryToZoomRatioSpline = Spline.createLinearSpline(RANGE_1X_TO_3X_ENTRY_INDEX_X, RANGE_1X_TO_3X_ZOOM_RATIO_Y);
            this.mRange1XTo3XZoomRatioToEntrySpline = Spline.createLinearSpline(RANGE_1X_TO_3X_ZOOM_RATIO_Y, RANGE_1X_TO_3X_ENTRY_INDEX_X);
            this.mRange3XTo10XEntryToZoomRatioSpline = Spline.createLinearSpline(RANGE_3X_TO_10X_ENTRY_INDEX_X, RANGE_3X_TO_10X_ZOOM_RATIO_Y);
            this.mRange3XTo10XZoomRatioToEntrySpline = Spline.createLinearSpline(RANGE_3X_TO_10X_ZOOM_RATIO_Y, RANGE_3X_TO_10X_ENTRY_INDEX_X);
            float[] entryX = getEntryX();
            float[] zoomRatioY = getZoomRatioY(this.mZoomRatioMax);
            this.mRange10XToMaxEntryToZoomRatioSpline = Spline.createMonotoneCubicSpline(entryX, zoomRatioY);
            this.mRange10XToMaxZoomRatioToEntrySpline = Spline.createMonotoneCubicSpline(zoomRatioY, entryX);
            ENTRY_COUNT_TOTAL = ENTRY_COUNT_MIN_TO_MAX;
            ENTRY_INDEX_MAX = ENTRY_INDEX_LAST;
        } else {
            this.mRange1XTo3XFor10XEntryToZoomRatioSpline = Spline.createSpline(RANGE_1X_TO_3X_FOR_10X_ENTRY_INDEX_X, RANGE_1X_TO_3X_FOR_10X_ZOOM_RATIO_Y);
            this.mRange1XTo3XFor10XZoomRatioToEntrySpline = Spline.createSpline(RANGE_1X_TO_3X_FOR_10X_ZOOM_RATIO_Y, RANGE_1X_TO_3X_FOR_10X_ENTRY_INDEX_X);
            this.mRange3XTo10XFor10XEntryToZoomRatioSpline = Spline.createSpline(RANGE_3X_TO_10X_FOR_10X_ENTRY_INDEX_X, RANGE_3X_TO_10X_FOR_10X_ZOOM_RATIO_Y);
            this.mRange3XTo10XFor10XZoomRatioToEntrySpline = Spline.createSpline(RANGE_3X_TO_10X_FOR_10X_ZOOM_RATIO_Y, RANGE_3X_TO_10X_FOR_10X_ENTRY_INDEX_X);
            ENTRY_COUNT_TOTAL = 31;
            ENTRY_INDEX_MAX = 30;
        }
        initStyle(context);
        CharSequence[] charSequenceArr = {createZoomRatioLabel(minZoomRatio), createZoomRatioLabel(this.mZoomRatioMax)};
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
                fArr2[i2] = (((fArr[i2] - f2) / ((float) (i - 1))) * 10.0f) + f2;
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
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.zoom_popup_text_size);
        int color = resources.getColor(R.color.zoom_popup_color_new_default);
        this.mLineHalfHeight = (float) (resources.getDimensionPixelSize(R.dimen.zoom_popup_line_height_nornal) / 2);
        this.mTargetHalfHeight = resources.getDimensionPixelSize(R.dimen.zoom_popup_line_height_target) / 2;
        this.mSelectHalfHeight = resources.getDimensionPixelSize(R.dimen.zoom_popup_line_height_select) / 2;
        this.mLineWidth = resources.getDimensionPixelSize(R.dimen.zoom_popup_line_width);
        this.mLineTextGap = resources.getDimensionPixelSize(R.dimen.zoom_popup_line_text_margin);
        int color2 = resources.getColor(R.color.zoom_popup_color_new_default);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStrokeWidth((float) this.mLineWidth);
        this.mPaint.setColor(color2);
        this.mSelectPaint = new Paint(this.mPaint);
        this.mSelectPaint.setColor(ColorConstant.COLOR_COMMON_SELECTED);
        this.mPaint.setShadowLayer(1.0f, 0.0f, 1.0f, -1090519040);
        this.mTextPaint = new TextPaint(this.mPaint);
        this.mTextPaint.setTextSize((float) dimensionPixelSize);
        this.mTextPaint.setColor(color);
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
            return (0.0f > f2 || f2 >= 4.0f) ? (4.0f > f2 || f2 >= 14.0f) ? (14.0f > f2 || f2 > 24.0f) ? this.mRange10XToMaxEntryToZoomRatioSpline.interpolate(f2) : this.mRange3XTo10XEntryToZoomRatioSpline.interpolate(f2) : this.mRange1XTo3XEntryToZoomRatioSpline.interpolate(f2) : this.mRangeMinTo1XEntryToZoomRatioSpline.interpolate(f2);
        }
        if (0.0f <= f2 && f2 < 10.0f) {
            return this.mRange1XTo3XFor10XEntryToZoomRatioSpline.interpolate(f2);
        }
        if (10.0f > f2 || f2 > 30.0f) {
            return 0.0f;
        }
        return this.mRange3XTo10XFor10XEntryToZoomRatioSpline.interpolate(f2);
    }

    public float mapZoomRatioToPosition(float f2) {
        if (this.mZoomRatioMax > 10.0f) {
            return (0.6f > f2 || f2 >= 1.0f) ? (1.0f > f2 || f2 >= 3.0f) ? (3.0f > f2 || f2 > 10.0f) ? this.mRange10XToMaxZoomRatioToEntrySpline.interpolate(f2) : this.mRange3XTo10XZoomRatioToEntrySpline.interpolate(f2) : this.mRange1XTo3XZoomRatioToEntrySpline.interpolate(f2) : this.mRangeMinTo1XZoomRatioToEntrySpline.interpolate(f2);
        }
        if (1.0f <= f2 && f2 < 3.0f) {
            return this.mRange1XTo3XFor10XZoomRatioToEntrySpline.interpolate(f2);
        }
        if (3.0f > f2 || f2 > 10.0f) {
            return 0.0f;
        }
        return this.mRange3XTo10XFor10XZoomRatioToEntrySpline.interpolate(f2);
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

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0037, code lost:
        if (r11.mCurrentValueIndex != r13) goto L_0x00ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0053, code lost:
        if (r11.mCurrentValueIndex != r13) goto L_0x00ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006c, code lost:
        if (r11.mCurrentValueIndex != r13) goto L_0x00ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009a, code lost:
        if (r11.mCurrentValueIndex != r13) goto L_0x00ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b1, code lost:
        if (r11.mCurrentValueIndex != r13) goto L_0x00ca;
     */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00cc  */
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
                    str = String.valueOf(mapPositionToZoomRatio(f2 * ((float) (getCount() - 1))));
                    z = str.equals(this.mCurrentValue);
                    z2 = true ^ z;
                    if (!z2) {
                    }
                } else if (i <= 10) {
                    str = String.valueOf(HybridZoomingSystem.add(1.0f, ((float) i) * 0.4f));
                } else {
                    if (i <= 30) {
                        str = String.valueOf(HybridZoomingSystem.add(3.0f, ((float) (i - 10)) * 0.25f));
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
                str = String.valueOf(HybridZoomingSystem.add(1.0f, ((float) (i - 4)) * 0.2f));
            } else if (i <= 24) {
                str = String.valueOf(HybridZoomingSystem.add(3.0f, ((float) (i - 14)) * 0.7f));
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
