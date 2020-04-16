package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;

public class AlertDialogLayout extends LinearLayoutCompat {
    public AlertDialogLayout(Context context) {
        super(context);
    }

    public AlertDialogLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void forceUniformWidth(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) childAt.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i4 = layoutParams.height;
                    layoutParams.height = childAt.getMeasuredHeight();
                    measureChildWithMargins(childAt, makeMeasureSpec, 0, i2, 0);
                    layoutParams.height = i4;
                }
            }
        }
    }

    private static int resolveMinimumHeight(View view) {
        int minimumHeight = ViewCompat.getMinimumHeight(view);
        if (minimumHeight > 0) {
            return minimumHeight;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() == 1) {
                return resolveMinimumHeight(viewGroup.getChildAt(0));
            }
        }
        return 0;
    }

    private void setChildFrame(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i + i3, i2 + i4);
    }

    private boolean tryOnMeasure(int i, int i2) {
        int i3;
        int i4 = i;
        int i5 = i2;
        View view = null;
        View view2 = null;
        View view3 = null;
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                int id = childAt.getId();
                if (id == R.id.topPanel) {
                    view = childAt;
                } else if (id == R.id.buttonPanel) {
                    view2 = childAt;
                } else if ((id != R.id.contentPanel && id != R.id.customPanel) || view3 != null) {
                    return false;
                } else {
                    view3 = childAt;
                }
            }
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i);
        int i7 = 0;
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (view != null) {
            view.measure(i4, 0);
            paddingTop += view.getMeasuredHeight();
            i7 = View.combineMeasuredStates(0, view.getMeasuredState());
        }
        int i8 = 0;
        int i9 = 0;
        if (view2 != null) {
            view2.measure(i4, 0);
            i8 = resolveMinimumHeight(view2);
            i9 = view2.getMeasuredHeight() - i8;
            paddingTop += i8;
            i7 = View.combineMeasuredStates(i7, view2.getMeasuredState());
        }
        int i10 = 0;
        if (view3 != null) {
            if (mode == 0) {
                View view4 = view;
                i3 = 0;
            } else {
                View view5 = view;
                i3 = View.MeasureSpec.makeMeasureSpec(Math.max(0, size - paddingTop), mode);
            }
            view3.measure(i4, i3);
            i10 = view3.getMeasuredHeight();
            paddingTop += i10;
            i7 = View.combineMeasuredStates(i7, view3.getMeasuredState());
        } else {
            View view6 = view;
        }
        int i11 = size - paddingTop;
        if (view2 != null) {
            int i12 = paddingTop - i8;
            int min = Math.min(i11, i9);
            if (min > 0) {
                i11 -= min;
                i8 += min;
            }
            view2.measure(i4, View.MeasureSpec.makeMeasureSpec(i8, 1073741824));
            paddingTop = i12 + view2.getMeasuredHeight();
            i7 = View.combineMeasuredStates(i7, view2.getMeasuredState());
            i11 = i11;
        }
        if (view3 != null && i11 > 0) {
            int i13 = i11;
            int i14 = i11 - i13;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i10 + i13, mode);
            view3.measure(i4, makeMeasureSpec);
            paddingTop = (paddingTop - i10) + view3.getMeasuredHeight();
            int i15 = makeMeasureSpec;
            i7 = View.combineMeasuredStates(i7, view3.getMeasuredState());
            i11 = i14;
        }
        int i16 = 0;
        int i17 = i11;
        int i18 = 0;
        while (i18 < childCount) {
            View childAt2 = getChildAt(i18);
            View view7 = view2;
            View view8 = view3;
            if (childAt2.getVisibility() != 8) {
                i16 = Math.max(i16, childAt2.getMeasuredWidth());
            }
            i18++;
            view2 = view7;
            view3 = view8;
        }
        View view9 = view2;
        View view10 = view3;
        setMeasuredDimension(View.resolveSizeAndState(i16 + getPaddingLeft() + getPaddingRight(), i4, i7), View.resolveSizeAndState(paddingTop, i5, 0));
        if (mode2 == 1073741824) {
            return true;
        }
        forceUniformWidth(childCount, i5);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        AlertDialogLayout alertDialogLayout = this;
        int paddingLeft = getPaddingLeft();
        int i6 = i3 - i;
        int paddingRight = i6 - getPaddingRight();
        int paddingRight2 = (i6 - paddingLeft) - getPaddingRight();
        int measuredHeight = getMeasuredHeight();
        int childCount = getChildCount();
        int gravity = getGravity();
        int i7 = gravity & 112;
        int i8 = gravity & 8388615;
        int paddingTop = i7 != 16 ? i7 != 80 ? getPaddingTop() : ((getPaddingTop() + i4) - i2) - measuredHeight : getPaddingTop() + (((i4 - i2) - measuredHeight) / 2);
        Drawable dividerDrawable = getDividerDrawable();
        int intrinsicHeight = dividerDrawable == null ? 0 : dividerDrawable.getIntrinsicHeight();
        int i9 = 0;
        while (i9 < childCount) {
            View childAt = alertDialogLayout.getChildAt(i9);
            if (childAt == null || childAt.getVisibility() == 8) {
                i5 = i9;
            } else {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight2 = childAt.getMeasuredHeight();
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) childAt.getLayoutParams();
                int i10 = layoutParams.gravity;
                int i11 = i10 < 0 ? i8 : i10;
                int layoutDirection = ViewCompat.getLayoutDirection(this);
                int absoluteGravity = GravityCompat.getAbsoluteGravity(i11, layoutDirection) & 7;
                int i12 = layoutDirection;
                int i13 = absoluteGravity != 1 ? absoluteGravity != 5 ? layoutParams.leftMargin + paddingLeft : (paddingRight - measuredWidth) - layoutParams.rightMargin : ((((paddingRight2 - measuredWidth) / 2) + paddingLeft) + layoutParams.leftMargin) - layoutParams.rightMargin;
                if (alertDialogLayout.hasDividerBeforeChildAt(i9)) {
                    paddingTop += intrinsicHeight;
                }
                int i14 = paddingTop + layoutParams.topMargin;
                int i15 = i11;
                i5 = i9;
                setChildFrame(childAt, i13, i14, measuredWidth, measuredHeight2);
                paddingTop = i14 + measuredHeight2 + layoutParams.bottomMargin;
            }
            i9 = i5 + 1;
            alertDialogLayout = this;
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (!tryOnMeasure(i, i2)) {
            super.onMeasure(i, i2);
        }
    }
}
