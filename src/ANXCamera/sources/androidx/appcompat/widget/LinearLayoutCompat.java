package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.R;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.ss.android.vesdk.VEResult;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class LinearLayoutCompat extends ViewGroup {
    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.appcompat.widget.LinearLayoutCompat";
    public static final int HORIZONTAL = 0;
    private static final int INDEX_BOTTOM = 2;
    private static final int INDEX_CENTER_VERTICAL = 0;
    private static final int INDEX_FILL = 3;
    private static final int INDEX_TOP = 1;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_GRAVITY_COUNT = 4;
    private boolean mBaselineAligned;
    private int mBaselineAlignedChildIndex;
    private int mBaselineChildTop;
    private Drawable mDivider;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDividerWidth;
    private int mGravity;
    private int[] mMaxAscent;
    private int[] mMaxDescent;
    private int mOrientation;
    private int mShowDividers;
    private int mTotalLength;
    private boolean mUseLargestChild;
    private float mWeightSum;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DividerMode {
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int gravity;
        public float weight;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.gravity = -1;
            this.weight = 0.0f;
        }

        public LayoutParams(int i, int i2, float f2) {
            super(i, i2);
            this.gravity = -1;
            this.weight = f2;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.gravity = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LinearLayoutCompat_Layout);
            this.weight = obtainStyledAttributes.getFloat(R.styleable.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.gravity = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = -1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.gravity = -1;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = -1;
            this.weight = layoutParams.weight;
            this.gravity = layoutParams.gravity;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface OrientationMode {
    }

    public LinearLayoutCompat(Context context) {
        this(context, (AttributeSet) null);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = 8388659;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.LinearLayoutCompat, i, 0);
        int i2 = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_android_orientation, -1);
        if (i2 >= 0) {
            setOrientation(i2);
        }
        int i3 = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_android_gravity, -1);
        if (i3 >= 0) {
            setGravity(i3);
        }
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (!z) {
            setBaselineAligned(z);
        }
        this.mWeightSum = obtainStyledAttributes.getFloat(R.styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.mBaselineAlignedChildIndex = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.mUseLargestChild = obtainStyledAttributes.getBoolean(R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(obtainStyledAttributes.getDrawable(R.styleable.LinearLayoutCompat_divider));
        this.mShowDividers = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_showDividers, 0);
        this.mDividerPadding = obtainStyledAttributes.getDimensionPixelSize(R.styleable.LinearLayoutCompat_dividerPadding, 0);
        obtainStyledAttributes.recycle();
    }

    private void forceUniformHeight(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View virtualChildAt = getVirtualChildAt(i3);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (layoutParams.height == -1) {
                    int i4 = layoutParams.width;
                    layoutParams.width = virtualChildAt.getMeasuredWidth();
                    measureChildWithMargins(virtualChildAt, i2, 0, makeMeasureSpec, 0);
                    layoutParams.width = i4;
                }
            }
        }
    }

    private void forceUniformWidth(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View virtualChildAt = getVirtualChildAt(i3);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i4 = layoutParams.height;
                    layoutParams.height = virtualChildAt.getMeasuredHeight();
                    measureChildWithMargins(virtualChildAt, makeMeasureSpec, 0, i2, 0);
                    layoutParams.height = i4;
                }
            }
        }
    }

    private void setChildFrame(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i + i3, i2 + i4);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* access modifiers changed from: package-private */
    public void drawDividersHorizontal(Canvas canvas) {
        int i;
        int virtualChildCount = getVirtualChildCount();
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        for (int i2 = 0; i2 < virtualChildCount; i2++) {
            View virtualChildAt = getVirtualChildAt(i2);
            if (!(virtualChildAt == null || virtualChildAt.getVisibility() == 8 || !hasDividerBeforeChildAt(i2))) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                drawVerticalDivider(canvas, isLayoutRtl ? virtualChildAt.getRight() + layoutParams.rightMargin : (virtualChildAt.getLeft() - layoutParams.leftMargin) - this.mDividerWidth);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 == null) {
                i = isLayoutRtl ? getPaddingLeft() : (getWidth() - getPaddingRight()) - this.mDividerWidth;
            } else {
                LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                i = isLayoutRtl ? (virtualChildAt2.getLeft() - layoutParams2.leftMargin) - this.mDividerWidth : virtualChildAt2.getRight() + layoutParams2.rightMargin;
            }
            drawVerticalDivider(canvas, i);
        }
    }

    /* access modifiers changed from: package-private */
    public void drawDividersVertical(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        for (int i = 0; i < virtualChildCount; i++) {
            View virtualChildAt = getVirtualChildAt(i);
            if (!(virtualChildAt == null || virtualChildAt.getVisibility() == 8 || !hasDividerBeforeChildAt(i))) {
                drawHorizontalDivider(canvas, (virtualChildAt.getTop() - ((LayoutParams) virtualChildAt.getLayoutParams()).topMargin) - this.mDividerHeight);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            drawHorizontalDivider(canvas, virtualChildAt2 == null ? (getHeight() - getPaddingBottom()) - this.mDividerHeight : virtualChildAt2.getBottom() + ((LayoutParams) virtualChildAt2.getLayoutParams()).bottomMargin);
        }
    }

    /* access modifiers changed from: package-private */
    public void drawHorizontalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, i, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + i);
        this.mDivider.draw(canvas);
    }

    /* access modifiers changed from: package-private */
    public void drawVerticalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(i, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + i, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(canvas);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        int i = this.mOrientation;
        if (i == 0) {
            return new LayoutParams(-2, -2);
        }
        if (i == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public int getBaseline() {
        if (this.mBaselineAlignedChildIndex < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i = this.mBaselineAlignedChildIndex;
        if (childCount > i) {
            View childAt = getChildAt(i);
            int baseline = childAt.getBaseline();
            if (baseline != -1) {
                int i2 = this.mBaselineChildTop;
                if (this.mOrientation == 1) {
                    int i3 = this.mGravity & 112;
                    if (i3 != 48) {
                        if (i3 == 16) {
                            i2 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.mTotalLength) / 2;
                        } else if (i3 == 80) {
                            i2 = ((getBottom() - getTop()) - getPaddingBottom()) - this.mTotalLength;
                        }
                    }
                }
                return ((LayoutParams) childAt.getLayoutParams()).topMargin + i2 + baseline;
            } else if (this.mBaselineAlignedChildIndex == 0) {
                return -1;
            } else {
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    /* access modifiers changed from: package-private */
    public int getChildrenSkipCount(View view, int i) {
        return 0;
    }

    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    public int getGravity() {
        return this.mGravity;
    }

    /* access modifiers changed from: package-private */
    public int getLocationOffset(View view) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int getNextLocationOffset(View view) {
        return 0;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    /* access modifiers changed from: package-private */
    public View getVirtualChildAt(int i) {
        return getChildAt(i);
    }

    /* access modifiers changed from: package-private */
    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    /* access modifiers changed from: protected */
    public boolean hasDividerBeforeChildAt(int i) {
        if (i == 0) {
            return (this.mShowDividers & 1) != 0;
        }
        if (i == getChildCount()) {
            return (this.mShowDividers & 4) != 0;
        }
        if ((this.mShowDividers & 2) == 0) {
            return false;
        }
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (getChildAt(i2).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    public boolean isBaselineAligned() {
        return this.mBaselineAligned;
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.mUseLargestChild;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x011a  */
    public void layoutHorizontal(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int[] iArr;
        int[] iArr2;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        int paddingTop = getPaddingTop();
        int i14 = i4 - i2;
        int paddingBottom = i14 - getPaddingBottom();
        int paddingBottom2 = (i14 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        int i15 = this.mGravity;
        int i16 = i15 & 112;
        boolean z = this.mBaselineAligned;
        int[] iArr3 = this.mMaxAscent;
        int[] iArr4 = this.mMaxDescent;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i15 & 8388615, layoutDirection);
        int paddingLeft = absoluteGravity != 1 ? absoluteGravity != 5 ? getPaddingLeft() : ((getPaddingLeft() + i3) - i) - this.mTotalLength : getPaddingLeft() + (((i3 - i) - this.mTotalLength) / 2);
        if (isLayoutRtl) {
            i6 = virtualChildCount - 1;
            i5 = -1;
        } else {
            i6 = 0;
            i5 = 1;
        }
        int i17 = 0;
        while (i17 < virtualChildCount) {
            int i18 = i6 + (i5 * i17);
            boolean z2 = isLayoutRtl;
            View virtualChildAt = getVirtualChildAt(i18);
            if (virtualChildAt == null) {
                paddingLeft += measureNullChild(i18);
                i10 = layoutDirection;
                iArr2 = iArr4;
                iArr = iArr3;
                i7 = paddingTop;
                i9 = i14;
                i8 = virtualChildCount;
            } else {
                int i19 = i17;
                i10 = layoutDirection;
                if (virtualChildAt.getVisibility() != 8) {
                    int measuredWidth = virtualChildAt.getMeasuredWidth();
                    int measuredHeight = virtualChildAt.getMeasuredHeight();
                    LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                    if (z) {
                        i9 = i14;
                        if (layoutParams.height != -1) {
                            i11 = virtualChildAt.getBaseline();
                            int i20 = layoutParams.gravity;
                            i12 = (i20 >= 0 ? i16 : i20) & 112;
                            i8 = virtualChildCount;
                            if (i12 != 16) {
                                i13 = ((((paddingBottom2 - measuredHeight) / 2) + paddingTop) + layoutParams.topMargin) - layoutParams.bottomMargin;
                            } else if (i12 == 48) {
                                int i21 = layoutParams.topMargin + paddingTop;
                                i13 = i11 != -1 ? i21 + (iArr3[1] - i11) : i21;
                            } else if (i12 != 80) {
                                i13 = paddingTop;
                            } else {
                                int i22 = (paddingBottom - measuredHeight) - layoutParams.bottomMargin;
                                i13 = i11 != -1 ? i22 - (iArr4[2] - (virtualChildAt.getMeasuredHeight() - i11)) : i22;
                            }
                            if (hasDividerBeforeChildAt(i18)) {
                                paddingLeft += this.mDividerWidth;
                            }
                            int i23 = paddingLeft + layoutParams.leftMargin;
                            i7 = paddingTop;
                            int i24 = i11;
                            iArr2 = iArr4;
                            iArr = iArr3;
                            setChildFrame(virtualChildAt, i23 + getLocationOffset(virtualChildAt), i13, measuredWidth, measuredHeight);
                            int nextLocationOffset = i23 + measuredWidth + layoutParams.rightMargin + getNextLocationOffset(virtualChildAt);
                            i17 = i19 + getChildrenSkipCount(virtualChildAt, i18);
                            paddingLeft = nextLocationOffset;
                        }
                    } else {
                        i9 = i14;
                    }
                    i11 = -1;
                    int i202 = layoutParams.gravity;
                    i12 = (i202 >= 0 ? i16 : i202) & 112;
                    i8 = virtualChildCount;
                    if (i12 != 16) {
                    }
                    if (hasDividerBeforeChildAt(i18)) {
                    }
                    int i232 = paddingLeft + layoutParams.leftMargin;
                    i7 = paddingTop;
                    int i242 = i11;
                    iArr2 = iArr4;
                    iArr = iArr3;
                    setChildFrame(virtualChildAt, i232 + getLocationOffset(virtualChildAt), i13, measuredWidth, measuredHeight);
                    int nextLocationOffset2 = i232 + measuredWidth + layoutParams.rightMargin + getNextLocationOffset(virtualChildAt);
                    i17 = i19 + getChildrenSkipCount(virtualChildAt, i18);
                    paddingLeft = nextLocationOffset2;
                } else {
                    iArr2 = iArr4;
                    iArr = iArr3;
                    i7 = paddingTop;
                    i9 = i14;
                    i8 = virtualChildCount;
                    int i25 = i18;
                    i17 = i19;
                }
            }
            i17++;
            isLayoutRtl = z2;
            layoutDirection = i10;
            i14 = i9;
            virtualChildCount = i8;
            paddingTop = i7;
            iArr4 = iArr2;
            iArr3 = iArr;
        }
    }

    /* access modifiers changed from: package-private */
    public void layoutVertical(int i, int i2, int i3, int i4) {
        int i5;
        int paddingLeft = getPaddingLeft();
        int i6 = i3 - i;
        int paddingRight = i6 - getPaddingRight();
        int paddingRight2 = (i6 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i7 = this.mGravity;
        int i8 = i7 & 112;
        int i9 = i7 & 8388615;
        int paddingTop = i8 != 16 ? i8 != 80 ? getPaddingTop() : ((getPaddingTop() + i4) - i2) - this.mTotalLength : getPaddingTop() + (((i4 - i2) - this.mTotalLength) / 2);
        int i10 = 0;
        while (i10 < virtualChildCount) {
            View virtualChildAt = getVirtualChildAt(i10);
            if (virtualChildAt == null) {
                paddingTop += measureNullChild(i10);
                i5 = paddingLeft;
            } else if (virtualChildAt.getVisibility() != 8) {
                int measuredWidth = virtualChildAt.getMeasuredWidth();
                int measuredHeight = virtualChildAt.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                int i11 = layoutParams.gravity;
                int i12 = i11 < 0 ? i9 : i11;
                int layoutDirection = ViewCompat.getLayoutDirection(this);
                int absoluteGravity = GravityCompat.getAbsoluteGravity(i12, layoutDirection) & 7;
                int i13 = absoluteGravity != 1 ? absoluteGravity != 5 ? layoutParams.leftMargin + paddingLeft : (paddingRight - measuredWidth) - layoutParams.rightMargin : ((((paddingRight2 - measuredWidth) / 2) + paddingLeft) + layoutParams.leftMargin) - layoutParams.rightMargin;
                if (hasDividerBeforeChildAt(i10)) {
                    paddingTop += this.mDividerHeight;
                }
                int i14 = paddingTop + layoutParams.topMargin;
                int i15 = layoutDirection;
                int i16 = i12;
                i5 = paddingLeft;
                setChildFrame(virtualChildAt, i13, i14 + getLocationOffset(virtualChildAt), measuredWidth, measuredHeight);
                int nextLocationOffset = i14 + measuredHeight + layoutParams.bottomMargin + getNextLocationOffset(virtualChildAt);
                i10 += getChildrenSkipCount(virtualChildAt, i10);
                paddingTop = nextLocationOffset;
            } else {
                i5 = paddingLeft;
            }
            i10++;
            paddingLeft = i5;
        }
    }

    /* access modifiers changed from: package-private */
    public void measureChildBeforeLayout(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x0553  */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x058b  */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x0642  */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x064a  */
    public void measureHorizontal(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        float f2;
        int i14;
        int i15;
        int i16;
        boolean z;
        int i17;
        int i18;
        int i19;
        int i20;
        boolean z2;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        boolean z3;
        int i31;
        int i32;
        int i33;
        int i34;
        int i35;
        int i36;
        LayoutParams layoutParams;
        int i37;
        int i38;
        int i39;
        int i40;
        int i41;
        int i42 = i;
        int i43 = i2;
        this.mTotalLength = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (this.mMaxAscent == null || this.mMaxDescent == null) {
            this.mMaxAscent = new int[4];
            this.mMaxDescent = new int[4];
        }
        int[] iArr = this.mMaxAscent;
        int[] iArr2 = this.mMaxDescent;
        iArr[3] = -1;
        iArr[2] = -1;
        iArr[1] = -1;
        iArr[0] = -1;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        boolean z4 = this.mBaselineAligned;
        boolean z5 = this.mUseLargestChild;
        boolean z6 = mode == 1073741824;
        int i44 = 0;
        int i45 = 0;
        float f3 = 0.0f;
        int i46 = 0;
        int i47 = 0;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = true;
        int i48 = 0;
        int i49 = 0;
        while (i44 < virtualChildCount) {
            View virtualChildAt = getVirtualChildAt(i44);
            if (virtualChildAt == null) {
                this.mTotalLength += measureNullChild(i44);
                z3 = z4;
                i29 = virtualChildCount;
                i47 = i47;
                i30 = mode;
            } else {
                int i50 = i47;
                int i51 = i49;
                if (virtualChildAt.getVisibility() == 8) {
                    i44 += getChildrenSkipCount(virtualChildAt, i44);
                    z3 = z4;
                    i47 = i50;
                    i49 = i51;
                    i29 = virtualChildCount;
                    i30 = mode;
                } else {
                    if (hasDividerBeforeChildAt(i44)) {
                        this.mTotalLength += this.mDividerWidth;
                    }
                    LayoutParams layoutParams2 = (LayoutParams) virtualChildAt.getLayoutParams();
                    float f4 = f3 + layoutParams2.weight;
                    if (mode == 1073741824 && layoutParams2.width == 0 && layoutParams2.weight > 0.0f) {
                        if (z6) {
                            i41 = i48;
                            this.mTotalLength += layoutParams2.leftMargin + layoutParams2.rightMargin;
                        } else {
                            i41 = i48;
                            int i52 = this.mTotalLength;
                            this.mTotalLength = Math.max(i52, layoutParams2.leftMargin + i52 + layoutParams2.rightMargin);
                        }
                        if (z4) {
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                            virtualChildAt.measure(makeMeasureSpec, makeMeasureSpec);
                            layoutParams = layoutParams2;
                            i31 = i46;
                            z3 = z4;
                            i36 = i50;
                            i33 = i51;
                            i32 = i41;
                            i29 = virtualChildCount;
                            i30 = mode;
                            i35 = -1;
                            i34 = i45;
                        } else {
                            z7 = true;
                            layoutParams = layoutParams2;
                            i31 = i46;
                            z3 = z4;
                            i36 = i50;
                            i33 = i51;
                            i32 = i41;
                            i29 = virtualChildCount;
                            i30 = mode;
                            i35 = -1;
                            i34 = i45;
                        }
                    } else {
                        int i53 = i48;
                        if (layoutParams2.width != 0 || layoutParams2.weight <= 0.0f) {
                            i40 = Integer.MIN_VALUE;
                        } else {
                            layoutParams2.width = -2;
                            i40 = 0;
                        }
                        int i54 = i50;
                        LayoutParams layoutParams3 = layoutParams2;
                        i33 = i51;
                        i32 = i53;
                        i31 = i46;
                        i30 = mode;
                        i34 = i45;
                        z3 = z4;
                        i29 = virtualChildCount;
                        i35 = -1;
                        measureChildBeforeLayout(virtualChildAt, i44, i, f4 == 0.0f ? this.mTotalLength : 0, i2, 0);
                        int i55 = i40;
                        if (i55 != Integer.MIN_VALUE) {
                            layoutParams = layoutParams3;
                            layoutParams.width = i55;
                        } else {
                            layoutParams = layoutParams3;
                        }
                        int measuredWidth = virtualChildAt.getMeasuredWidth();
                        if (z6) {
                            this.mTotalLength += layoutParams.leftMargin + measuredWidth + layoutParams.rightMargin + getNextLocationOffset(virtualChildAt);
                        } else {
                            int i56 = this.mTotalLength;
                            this.mTotalLength = Math.max(i56, i56 + measuredWidth + layoutParams.leftMargin + layoutParams.rightMargin + getNextLocationOffset(virtualChildAt));
                        }
                        i36 = z5 ? Math.max(measuredWidth, i54) : i54;
                    }
                    boolean z10 = false;
                    if (mode2 != 1073741824 && layoutParams.height == i35) {
                        z8 = true;
                        z10 = true;
                    }
                    int i57 = layoutParams.topMargin + layoutParams.bottomMargin;
                    int measuredHeight = virtualChildAt.getMeasuredHeight() + i57;
                    int combineMeasuredStates = View.combineMeasuredStates(i31, virtualChildAt.getMeasuredState());
                    if (z3) {
                        int baseline = virtualChildAt.getBaseline();
                        if (baseline != i35) {
                            int i58 = ((((layoutParams.gravity < 0 ? this.mGravity : layoutParams.gravity) & 112) >> 4) & -2) >> 1;
                            i38 = i57;
                            iArr[i58] = Math.max(iArr[i58], baseline);
                            i37 = i36;
                            iArr2[i58] = Math.max(iArr2[i58], measuredHeight - baseline);
                        } else {
                            i38 = i57;
                            i37 = i36;
                        }
                    } else {
                        i38 = i57;
                        i37 = i36;
                    }
                    int max = Math.max(i34, measuredHeight);
                    boolean z11 = z9 && layoutParams.height == -1;
                    if (layoutParams.weight > 0.0f) {
                        i39 = Math.max(i33, z10 ? i38 : measuredHeight);
                    } else {
                        int i59 = i33;
                        i32 = Math.max(i32, z10 ? i38 : measuredHeight);
                        i39 = i59;
                    }
                    i44 += getChildrenSkipCount(virtualChildAt, i44);
                    z9 = z11;
                    i46 = combineMeasuredStates;
                    f3 = f4;
                    i47 = i37;
                    i48 = i32;
                    i45 = max;
                    i49 = i39;
                }
            }
            i44++;
            int i60 = i;
            z4 = z3;
            mode = i30;
            virtualChildCount = i29;
        }
        boolean z12 = z4;
        int i61 = virtualChildCount;
        int i62 = mode;
        int i63 = i49;
        int i64 = i48;
        int i65 = i46;
        int i66 = i45;
        int i67 = i47;
        if (this.mTotalLength > 0) {
            i3 = i61;
            if (hasDividerBeforeChildAt(i3)) {
                this.mTotalLength += this.mDividerWidth;
            }
        } else {
            i3 = i61;
        }
        if (iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1) {
            i4 = i65;
            i5 = i66;
        } else {
            i4 = i65;
            i5 = Math.max(i66, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
        }
        if (z5) {
            i7 = i62;
            if (i7 == Integer.MIN_VALUE || i7 == 0) {
                this.mTotalLength = 0;
                int i68 = 0;
                while (i68 < i3) {
                    View virtualChildAt2 = getVirtualChildAt(i68);
                    if (virtualChildAt2 == null) {
                        this.mTotalLength += measureNullChild(i68);
                        i26 = i5;
                        i28 = i68;
                    } else if (virtualChildAt2.getVisibility() == 8) {
                        i27 = i68 + getChildrenSkipCount(virtualChildAt2, i68);
                        i26 = i5;
                        i68 = i27 + 1;
                        i5 = i26;
                    } else {
                        LayoutParams layoutParams4 = (LayoutParams) virtualChildAt2.getLayoutParams();
                        if (z6) {
                            i26 = i5;
                            i28 = i68;
                            this.mTotalLength += layoutParams4.leftMargin + i67 + layoutParams4.rightMargin + getNextLocationOffset(virtualChildAt2);
                        } else {
                            i26 = i5;
                            i28 = i68;
                            int i69 = this.mTotalLength;
                            this.mTotalLength = Math.max(i69, i69 + i67 + layoutParams4.leftMargin + layoutParams4.rightMargin + getNextLocationOffset(virtualChildAt2));
                        }
                    }
                    i27 = i28;
                    i68 = i27 + 1;
                    i5 = i26;
                }
                i6 = i5;
                int i70 = i68;
            } else {
                i6 = i5;
            }
        } else {
            i6 = i5;
            i7 = i62;
        }
        this.mTotalLength += getPaddingLeft() + getPaddingRight();
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(this.mTotalLength, getSuggestedMinimumWidth()), i, 0);
        int i71 = resolveSizeAndState & 16777215;
        int i72 = i71 - this.mTotalLength;
        if (z7) {
            f2 = f3;
            int i73 = i67;
            int i74 = i71;
            i14 = i64;
        } else if (i72 == 0 || f3 <= 0.0f) {
            int max2 = Math.max(i64, i63);
            if (!z5) {
                float f5 = f3;
                i22 = max2;
                int i75 = i67;
                int i76 = i71;
            } else if (i7 != 1073741824) {
                int i77 = 0;
                while (i77 < i3) {
                    float f6 = f3;
                    View virtualChildAt3 = getVirtualChildAt(i77);
                    if (virtualChildAt3 != null) {
                        i25 = max2;
                        i24 = i71;
                        if (virtualChildAt3.getVisibility() == 8) {
                            i23 = i67;
                        } else {
                            LayoutParams layoutParams5 = (LayoutParams) virtualChildAt3.getLayoutParams();
                            float f7 = layoutParams5.weight;
                            if (f7 > 0.0f) {
                                LayoutParams layoutParams6 = layoutParams5;
                                float f8 = f7;
                                i23 = i67;
                                virtualChildAt3.measure(View.MeasureSpec.makeMeasureSpec(i67, 1073741824), View.MeasureSpec.makeMeasureSpec(virtualChildAt3.getMeasuredHeight(), 1073741824));
                            } else {
                                LayoutParams layoutParams7 = layoutParams5;
                                i23 = i67;
                                float f9 = f7;
                            }
                        }
                    } else {
                        i25 = max2;
                        i23 = i67;
                        i24 = i71;
                    }
                    i77++;
                    max2 = i25;
                    f3 = f6;
                    i71 = i24;
                    i67 = i23;
                }
                float f10 = f3;
                i22 = max2;
                int i78 = i67;
                int i79 = i71;
            } else {
                float f11 = f3;
                i22 = max2;
                int i80 = i67;
                int i81 = i71;
            }
            i10 = i2;
            i8 = i3;
            i9 = resolveSizeAndState;
            int i82 = i63;
            i13 = i22;
            i11 = i6;
            boolean z13 = z5;
            int i83 = i4;
            int i84 = i7;
            i12 = i83;
            if (!z9 && mode2 != 1073741824) {
                i11 = i13;
            }
            setMeasuredDimension(i9 | (-16777216 & i12), View.resolveSizeAndState(Math.max(i11 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i10, i12 << 16));
            if (!z8) {
                forceUniformHeight(i8, i);
                return;
            }
            int i85 = i;
            int i86 = i8;
            return;
        } else {
            f2 = f3;
            int i87 = i67;
            int i88 = i71;
            i14 = i64;
        }
        float f12 = this.mWeightSum;
        if (f12 <= 0.0f) {
            f12 = f2;
        }
        iArr[3] = -1;
        iArr[2] = -1;
        iArr[1] = -1;
        iArr[0] = -1;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        this.mTotalLength = 0;
        int i89 = 0;
        int i90 = i72;
        int i91 = -1;
        int i92 = i4;
        while (i89 < i3) {
            int i93 = i63;
            View virtualChildAt4 = getVirtualChildAt(i89);
            if (virtualChildAt4 != null) {
                z = z5;
                i16 = i3;
                if (virtualChildAt4.getVisibility() == 8) {
                    i15 = i7;
                    i17 = resolveSizeAndState;
                    i18 = i90;
                    int i94 = i2;
                } else {
                    LayoutParams layoutParams8 = (LayoutParams) virtualChildAt4.getLayoutParams();
                    float f13 = layoutParams8.weight;
                    if (f13 > 0.0f) {
                        int i95 = (int) ((((float) i90) * f13) / f12);
                        float f14 = f12 - f13;
                        float f15 = f13;
                        i17 = resolveSizeAndState;
                        int i96 = i90 - i95;
                        int childMeasureSpec = getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom() + layoutParams8.topMargin + layoutParams8.bottomMargin, layoutParams8.height);
                        if (layoutParams8.width == 0 && i7 == 1073741824) {
                            virtualChildAt4.measure(View.MeasureSpec.makeMeasureSpec(i95 > 0 ? i95 : 0, 1073741824), childMeasureSpec);
                            i15 = i7;
                        } else {
                            int measuredWidth2 = virtualChildAt4.getMeasuredWidth() + i95;
                            if (measuredWidth2 < 0) {
                                measuredWidth2 = 0;
                            }
                            i15 = i7;
                            virtualChildAt4.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824), childMeasureSpec);
                        }
                        i92 = View.combineMeasuredStates(i92, virtualChildAt4.getMeasuredState() & -16777216);
                        f12 = f14;
                        i19 = i96;
                    } else {
                        float f16 = f13;
                        i15 = i7;
                        i17 = resolveSizeAndState;
                        i19 = i90;
                        int i97 = i2;
                    }
                    if (z6) {
                        this.mTotalLength += virtualChildAt4.getMeasuredWidth() + layoutParams8.leftMargin + layoutParams8.rightMargin + getNextLocationOffset(virtualChildAt4);
                    } else {
                        int i98 = this.mTotalLength;
                        this.mTotalLength = Math.max(i98, virtualChildAt4.getMeasuredWidth() + i98 + layoutParams8.leftMargin + layoutParams8.rightMargin + getNextLocationOffset(virtualChildAt4));
                    }
                    boolean z14 = mode2 != 1073741824 && layoutParams8.height == -1;
                    int i99 = layoutParams8.topMargin + layoutParams8.bottomMargin;
                    int measuredHeight2 = virtualChildAt4.getMeasuredHeight() + i99;
                    i91 = Math.max(i91, measuredHeight2);
                    float f17 = f12;
                    int max3 = Math.max(i14, z14 ? i99 : measuredHeight2);
                    if (z9) {
                        i20 = max3;
                        if (layoutParams8.height == -1) {
                            z2 = true;
                            if (!z12) {
                                int baseline2 = virtualChildAt4.getBaseline();
                                z9 = z2;
                                if (baseline2 != -1) {
                                    int i100 = (layoutParams8.gravity < 0 ? this.mGravity : layoutParams8.gravity) & 112;
                                    int i101 = ((i100 >> 4) & -2) >> 1;
                                    int i102 = i100;
                                    iArr[i101] = Math.max(iArr[i101], baseline2);
                                    i21 = i19;
                                    iArr2[i101] = Math.max(iArr2[i101], measuredHeight2 - baseline2);
                                } else {
                                    i21 = i19;
                                }
                            } else {
                                z9 = z2;
                                i21 = i19;
                            }
                            f12 = f17;
                            i14 = i20;
                            i18 = i21;
                        }
                    } else {
                        i20 = max3;
                    }
                    z2 = false;
                    if (!z12) {
                    }
                    f12 = f17;
                    i14 = i20;
                    i18 = i21;
                }
            } else {
                i16 = i3;
                i15 = i7;
                i17 = resolveSizeAndState;
                i18 = i90;
                z = z5;
                int i103 = i2;
            }
            i89++;
            int i104 = i;
            i90 = i18;
            resolveSizeAndState = i17;
            z5 = z;
            i3 = i16;
            i63 = i93;
            i7 = i15;
        }
        i8 = i3;
        int i105 = i7;
        i9 = resolveSizeAndState;
        int i106 = i63;
        int i107 = i90;
        boolean z15 = z5;
        i10 = i2;
        this.mTotalLength += getPaddingLeft() + getPaddingRight();
        int max4 = (iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1) ? i91 : Math.max(i91, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
        int i108 = i107;
        i13 = i14;
        i12 = i92;
        i11 = max4;
        i11 = i13;
        setMeasuredDimension(i9 | (-16777216 & i12), View.resolveSizeAndState(Math.max(i11 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i10, i12 << 16));
        if (!z8) {
        }
    }

    /* access modifiers changed from: package-private */
    public int measureNullChild(int i) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x03da  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x03dc  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x03e3  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x03ed  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0460  */
    /* JADX WARNING: Removed duplicated region for block: B:191:? A[RETURN, SYNTHETIC] */
    public void measureVertical(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        float f2;
        int i8;
        int i9;
        int i10;
        float f3;
        boolean z;
        boolean z2;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        LayoutParams layoutParams;
        int i22;
        View view;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27 = i;
        int i28 = i2;
        this.mTotalLength = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i29 = this.mBaselineAlignedChildIndex;
        boolean z3 = this.mUseLargestChild;
        boolean z4 = false;
        int i30 = 0;
        float f4 = 0.0f;
        int i31 = 0;
        int i32 = 0;
        boolean z5 = false;
        int i33 = 0;
        int i34 = 0;
        int i35 = 0;
        boolean z6 = true;
        while (true) {
            int i36 = i34;
            if (i32 < virtualChildCount) {
                View virtualChildAt = getVirtualChildAt(i32);
                if (virtualChildAt == null) {
                    this.mTotalLength += measureNullChild(i32);
                    i16 = virtualChildCount;
                    i17 = mode2;
                    i34 = i36;
                } else {
                    int i37 = i35;
                    if (virtualChildAt.getVisibility() == 8) {
                        i32 += getChildrenSkipCount(virtualChildAt, i32);
                        i16 = virtualChildCount;
                        i34 = i36;
                        i35 = i37;
                        i17 = mode2;
                    } else {
                        if (hasDividerBeforeChildAt(i32)) {
                            this.mTotalLength += this.mDividerHeight;
                        }
                        LayoutParams layoutParams2 = (LayoutParams) virtualChildAt.getLayoutParams();
                        float f5 = f4 + layoutParams2.weight;
                        if (mode2 == 1073741824 && layoutParams2.height == 0 && layoutParams2.weight > 0.0f) {
                            int i38 = this.mTotalLength;
                            int i39 = i32;
                            this.mTotalLength = Math.max(i38, layoutParams2.topMargin + i38 + layoutParams2.bottomMargin);
                            z4 = true;
                            i19 = i31;
                            i18 = i33;
                            i16 = virtualChildCount;
                            i21 = i36;
                            i23 = i37;
                            i20 = i39;
                            i22 = 1073741824;
                            i17 = mode2;
                            layoutParams = layoutParams2;
                            view = virtualChildAt;
                        } else {
                            int i40 = i32;
                            if (layoutParams2.height != 0 || layoutParams2.weight <= 0.0f) {
                                i26 = Integer.MIN_VALUE;
                            } else {
                                layoutParams2.height = -2;
                                i26 = 0;
                            }
                            int i41 = i26;
                            i20 = i40;
                            int i42 = i37;
                            i17 = mode2;
                            layoutParams = layoutParams2;
                            i16 = virtualChildCount;
                            i22 = 1073741824;
                            i21 = i36;
                            View view2 = virtualChildAt;
                            i19 = i31;
                            i18 = i33;
                            measureChildBeforeLayout(virtualChildAt, i20, i, 0, i2, f5 == 0.0f ? this.mTotalLength : 0);
                            if (i41 != Integer.MIN_VALUE) {
                                layoutParams.height = i41;
                            }
                            int measuredHeight = view2.getMeasuredHeight();
                            int i43 = this.mTotalLength;
                            view = view2;
                            this.mTotalLength = Math.max(i43, i43 + measuredHeight + layoutParams.topMargin + layoutParams.bottomMargin + getNextLocationOffset(view));
                            i23 = z3 ? Math.max(measuredHeight, i42) : i42;
                        }
                        if (i29 >= 0) {
                            i24 = i20;
                            if (i29 == i24 + 1) {
                                this.mBaselineChildTop = this.mTotalLength;
                            }
                        } else {
                            i24 = i20;
                        }
                        if (i24 >= i29 || layoutParams.weight <= 0.0f) {
                            boolean z7 = false;
                            if (mode != i22 && layoutParams.width == -1) {
                                z5 = true;
                                z7 = true;
                            }
                            int i44 = layoutParams.leftMargin + layoutParams.rightMargin;
                            int measuredWidth = view.getMeasuredWidth() + i44;
                            int max = Math.max(i30, measuredWidth);
                            int combineMeasuredStates = View.combineMeasuredStates(i18, view.getMeasuredState());
                            boolean z8 = z6 && layoutParams.width == -1;
                            if (layoutParams.weight > 0.0f) {
                                int i45 = i44;
                                i25 = Math.max(i21, z7 ? i44 : measuredWidth);
                            } else {
                                i25 = i21;
                                int i46 = i44;
                                i19 = Math.max(i19, z7 ? i44 : measuredWidth);
                            }
                            int childrenSkipCount = getChildrenSkipCount(view, i24) + i24;
                            i35 = i23;
                            z6 = z8;
                            i34 = i25;
                            f4 = f5;
                            i31 = i19;
                            i32 = childrenSkipCount;
                            i30 = max;
                            i33 = combineMeasuredStates;
                        } else {
                            throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                        }
                    }
                }
                i32++;
                int i47 = i;
                int i48 = i2;
                mode2 = i17;
                virtualChildCount = i16;
            } else {
                int i49 = i32;
                int i50 = i35;
                int i51 = virtualChildCount;
                int i52 = mode2;
                int i53 = i36;
                int i54 = 8;
                int i55 = i31;
                if (this.mTotalLength > 0) {
                    i3 = i51;
                    if (hasDividerBeforeChildAt(i3)) {
                        this.mTotalLength += this.mDividerHeight;
                    }
                } else {
                    i3 = i51;
                }
                if (z3) {
                    i5 = i52;
                    if (i5 == Integer.MIN_VALUE || i5 == 0) {
                        this.mTotalLength = 0;
                        int i56 = 0;
                        while (i56 < i3) {
                            View virtualChildAt2 = getVirtualChildAt(i56);
                            if (virtualChildAt2 == null) {
                                this.mTotalLength += measureNullChild(i56);
                                i15 = i33;
                            } else if (virtualChildAt2.getVisibility() == i54) {
                                i56 += getChildrenSkipCount(virtualChildAt2, i56);
                                i15 = i33;
                            } else {
                                LayoutParams layoutParams3 = (LayoutParams) virtualChildAt2.getLayoutParams();
                                int i57 = this.mTotalLength;
                                i15 = i33;
                                this.mTotalLength = Math.max(i57, i57 + i50 + layoutParams3.topMargin + layoutParams3.bottomMargin + getNextLocationOffset(virtualChildAt2));
                            }
                            i56++;
                            i33 = i15;
                            i54 = 8;
                        }
                        i4 = i33;
                    } else {
                        i4 = i33;
                    }
                } else {
                    i4 = i33;
                    i5 = i52;
                }
                this.mTotalLength += getPaddingTop() + getPaddingBottom();
                int i58 = i2;
                int i59 = i50;
                int resolveSizeAndState = View.resolveSizeAndState(Math.max(this.mTotalLength, getSuggestedMinimumHeight()), i58, 0);
                int i60 = resolveSizeAndState & 16777215;
                int i61 = i60 - this.mTotalLength;
                if (z4) {
                    f2 = f4;
                    int i62 = i60;
                    int i63 = i53;
                } else if (i61 == 0 || f4 <= 0.0f) {
                    int max2 = Math.max(i55, i53);
                    if (!z3 || i5 == 1073741824) {
                        float f6 = f4;
                        i11 = max2;
                        int i64 = i60;
                        int i65 = i53;
                    } else {
                        int i66 = 0;
                        while (i66 < i3) {
                            float f7 = f4;
                            View virtualChildAt3 = getVirtualChildAt(i66);
                            if (virtualChildAt3 != null) {
                                i14 = max2;
                                i13 = i60;
                                if (virtualChildAt3.getVisibility() == 8) {
                                    i12 = i53;
                                } else {
                                    LayoutParams layoutParams4 = (LayoutParams) virtualChildAt3.getLayoutParams();
                                    float f8 = layoutParams4.weight;
                                    if (f8 > 0.0f) {
                                        LayoutParams layoutParams5 = layoutParams4;
                                        float f9 = f8;
                                        i12 = i53;
                                        virtualChildAt3.measure(View.MeasureSpec.makeMeasureSpec(virtualChildAt3.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i59, 1073741824));
                                    } else {
                                        LayoutParams layoutParams6 = layoutParams4;
                                        float f10 = f8;
                                        i12 = i53;
                                    }
                                }
                            } else {
                                i14 = max2;
                                i13 = i60;
                                i12 = i53;
                            }
                            i66++;
                            max2 = i14;
                            f4 = f7;
                            i60 = i13;
                            i53 = i12;
                        }
                        float f11 = f4;
                        i11 = max2;
                        int i67 = i60;
                        int i68 = i53;
                    }
                    i6 = i;
                    int i69 = i5;
                    int i70 = i59;
                    int i71 = i61;
                    boolean z9 = z3;
                    int i72 = i29;
                    i55 = i11;
                    i7 = i4;
                    if (!z6 && mode != 1073741824) {
                        i30 = i55;
                    }
                    setMeasuredDimension(View.resolveSizeAndState(Math.max(i30 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i6, i7), resolveSizeAndState);
                    if (!z5) {
                        forceUniformWidth(i3, i58);
                        return;
                    }
                    return;
                } else {
                    f2 = f4;
                    int i73 = i60;
                    int i74 = i53;
                }
                float f12 = this.mWeightSum;
                if (f12 <= 0.0f) {
                    f12 = f2;
                }
                this.mTotalLength = 0;
                int i75 = 0;
                int i76 = i61;
                i7 = i4;
                while (i75 < i3) {
                    View virtualChildAt4 = getVirtualChildAt(i75);
                    int i77 = i59;
                    boolean z10 = z3;
                    if (virtualChildAt4.getVisibility() == 8) {
                        i8 = i5;
                        i9 = i76;
                        i10 = i29;
                        int i78 = i;
                    } else {
                        LayoutParams layoutParams7 = (LayoutParams) virtualChildAt4.getLayoutParams();
                        float f13 = layoutParams7.weight;
                        if (f13 > 0.0f) {
                            i10 = i29;
                            int i79 = (int) ((((float) i76) * f13) / f12);
                            float f14 = f12 - f13;
                            float f15 = f13;
                            i9 = i76 - i79;
                            int childMeasureSpec = getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + layoutParams7.leftMargin + layoutParams7.rightMargin, layoutParams7.width);
                            if (layoutParams7.height != 0) {
                                i8 = i5;
                            } else if (i5 != 1073741824) {
                                i8 = i5;
                            } else {
                                i8 = i5;
                                virtualChildAt4.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i79 > 0 ? i79 : 0, 1073741824));
                                int i80 = i79;
                                i7 = View.combineMeasuredStates(i7, virtualChildAt4.getMeasuredState() & -256);
                                f12 = f14;
                            }
                            int measuredHeight2 = virtualChildAt4.getMeasuredHeight() + i79;
                            if (measuredHeight2 < 0) {
                                measuredHeight2 = 0;
                            }
                            int i81 = i79;
                            virtualChildAt4.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
                            i7 = View.combineMeasuredStates(i7, virtualChildAt4.getMeasuredState() & -256);
                            f12 = f14;
                        } else {
                            i8 = i5;
                            float f16 = f13;
                            int i82 = i76;
                            i10 = i29;
                            int i83 = i;
                            i9 = i82;
                        }
                        int i84 = layoutParams7.leftMargin + layoutParams7.rightMargin;
                        int measuredWidth2 = virtualChildAt4.getMeasuredWidth() + i84;
                        i30 = Math.max(i30, measuredWidth2);
                        if (mode != 1073741824) {
                            f3 = f12;
                            if (layoutParams7.width == -1) {
                                z = true;
                                int max3 = Math.max(i55, !z ? i84 : measuredWidth2);
                                if (!z6) {
                                    boolean z11 = z;
                                    if (layoutParams7.width == -1) {
                                        z2 = true;
                                        int i85 = this.mTotalLength;
                                        this.mTotalLength = Math.max(i85, i85 + virtualChildAt4.getMeasuredHeight() + layoutParams7.topMargin + layoutParams7.bottomMargin + getNextLocationOffset(virtualChildAt4));
                                        z6 = z2;
                                        f12 = f3;
                                        i55 = max3;
                                    }
                                } else {
                                    boolean z12 = z;
                                }
                                z2 = false;
                                int i852 = this.mTotalLength;
                                this.mTotalLength = Math.max(i852, i852 + virtualChildAt4.getMeasuredHeight() + layoutParams7.topMargin + layoutParams7.bottomMargin + getNextLocationOffset(virtualChildAt4));
                                z6 = z2;
                                f12 = f3;
                                i55 = max3;
                            }
                        } else {
                            f3 = f12;
                        }
                        z = false;
                        int max32 = Math.max(i55, !z ? i84 : measuredWidth2);
                        if (!z6) {
                        }
                        z2 = false;
                        int i8522 = this.mTotalLength;
                        this.mTotalLength = Math.max(i8522, i8522 + virtualChildAt4.getMeasuredHeight() + layoutParams7.topMargin + layoutParams7.bottomMargin + getNextLocationOffset(virtualChildAt4));
                        z6 = z2;
                        f12 = f3;
                        i55 = max32;
                    }
                    i75++;
                    i59 = i77;
                    z3 = z10;
                    i29 = i10;
                    i76 = i9;
                    i5 = i8;
                }
                int i86 = i5;
                int i87 = i59;
                boolean z13 = z3;
                int i88 = i76;
                int i89 = i29;
                i6 = i;
                this.mTotalLength += getPaddingTop() + getPaddingBottom();
                i30 = i55;
                setMeasuredDimension(View.resolveSizeAndState(Math.max(i30 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i6, i7), resolveSizeAndState);
                if (!z5) {
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.mDivider != null) {
            if (this.mOrientation == 1) {
                drawDividersVertical(canvas);
            } else {
                drawDividersHorizontal(canvas);
            }
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mOrientation == 1) {
            layoutVertical(i, i2, i3, i4);
        } else {
            layoutHorizontal(i, i2, i3, i4);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.mOrientation == 1) {
            measureVertical(i, i2);
        } else {
            measureHorizontal(i, i2);
        }
    }

    public void setBaselineAligned(boolean z) {
        this.mBaselineAligned = z;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.mBaselineAlignedChildIndex = i;
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable != this.mDivider) {
            this.mDivider = drawable;
            boolean z = false;
            if (drawable != null) {
                this.mDividerWidth = drawable.getIntrinsicWidth();
                this.mDividerHeight = drawable.getIntrinsicHeight();
            } else {
                this.mDividerWidth = 0;
                this.mDividerHeight = 0;
            }
            if (drawable == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }

    public void setDividerPadding(int i) {
        this.mDividerPadding = i;
    }

    public void setGravity(int i) {
        if (this.mGravity != i) {
            if ((8388615 & i) == 0) {
                i |= 8388611;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.mGravity = i;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & 8388615;
        int i3 = this.mGravity;
        if ((8388615 & i3) != i2) {
            this.mGravity = (-8388616 & i3) | i2;
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.mUseLargestChild = z;
    }

    public void setOrientation(int i) {
        if (this.mOrientation != i) {
            this.mOrientation = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        if (i != this.mShowDividers) {
            requestLayout();
        }
        this.mShowDividers = i;
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        int i3 = this.mGravity;
        if ((i3 & 112) != i2) {
            this.mGravity = (i3 & VEResult.TER_NO_SPACE) | i2;
            requestLayout();
        }
    }

    public void setWeightSum(float f2) {
        this.mWeightSum = Math.max(0.0f, f2);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
