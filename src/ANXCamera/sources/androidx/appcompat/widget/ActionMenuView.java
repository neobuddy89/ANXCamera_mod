package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.LinearLayoutCompat;

public class ActionMenuView extends LinearLayoutCompat implements MenuBuilder.ItemInvoker, MenuView {
    static final int GENERATED_ITEM_PADDING = 4;
    static final int MIN_CELL_SIZE = 56;
    private static final String TAG = "ActionMenuView";
    private MenuPresenter.Callback mActionMenuPresenterCallback;
    private boolean mFormatItems;
    private int mFormatItemsWidth;
    private int mGeneratedItemPadding;
    private MenuBuilder mMenu;
    MenuBuilder.Callback mMenuBuilderCallback;
    private int mMinCellSize;
    OnMenuItemClickListener mOnMenuItemClickListener;
    private Context mPopupContext;
    private int mPopupTheme;
    private ActionMenuPresenter mPresenter;
    private boolean mReserveOverflow;

    public interface ActionMenuChildView {
        boolean needsDividerAfter();

        boolean needsDividerBefore();
    }

    private static class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        ActionMenuPresenterCallback() {
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        }

        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            return false;
        }
    }

    public static class LayoutParams extends LinearLayoutCompat.LayoutParams {
        @ViewDebug.ExportedProperty
        public int cellsUsed;
        @ViewDebug.ExportedProperty
        public boolean expandable;
        boolean expanded;
        @ViewDebug.ExportedProperty
        public int extraPixels;
        @ViewDebug.ExportedProperty
        public boolean isOverflowButton;
        @ViewDebug.ExportedProperty
        public boolean preventEdgeOffset;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.isOverflowButton = false;
        }

        LayoutParams(int i, int i2, boolean z) {
            super(i, i2);
            this.isOverflowButton = z;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.LayoutParams) layoutParams);
            this.isOverflowButton = layoutParams.isOverflowButton;
        }
    }

    private class MenuBuilderCallback implements MenuBuilder.Callback {
        MenuBuilderCallback() {
        }

        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            return ActionMenuView.this.mOnMenuItemClickListener != null && ActionMenuView.this.mOnMenuItemClickListener.onMenuItemClick(menuItem);
        }

        public void onMenuModeChange(MenuBuilder menuBuilder) {
            if (ActionMenuView.this.mMenuBuilderCallback != null) {
                ActionMenuView.this.mMenuBuilderCallback.onMenuModeChange(menuBuilder);
            }
        }
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.mMinCellSize = (int) (56.0f * f2);
        this.mGeneratedItemPadding = (int) (4.0f * f2);
        this.mPopupContext = context;
        this.mPopupTheme = 0;
    }

    static int measureChildForCells(View view, int i, int i2, int i3, int i4) {
        View view2 = view;
        int i5 = i2;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3) - i4, View.MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view2 instanceof ActionMenuItemView ? (ActionMenuItemView) view2 : null;
        boolean z = false;
        boolean z2 = actionMenuItemView != null && actionMenuItemView.hasText();
        int i6 = 0;
        if (i5 > 0 && (!z2 || i5 >= 2)) {
            view.measure(View.MeasureSpec.makeMeasureSpec(i * i5, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            i6 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i6++;
            }
            if (z2 && i6 < 2) {
                i6 = 2;
            }
        }
        if (!layoutParams.isOverflowButton && z2) {
            z = true;
        }
        layoutParams.expandable = z;
        layoutParams.cellsUsed = i6;
        view.measure(View.MeasureSpec.makeMeasureSpec(i6 * i, 1073741824), makeMeasureSpec);
        return i6;
    }

    /* JADX WARNING: Removed duplicated region for block: B:131:0x0282  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x02af  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x02b7  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x02b9  */
    private void onMeasureExactFormat(int i, int i2) {
        int i3;
        int i4;
        boolean z;
        boolean z2;
        int i5;
        int i6;
        int i7;
        boolean z3;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        int i8 = size - paddingLeft;
        int i9 = this.mMinCellSize;
        int i10 = i8 / i9;
        int i11 = i8 % i9;
        if (i10 == 0) {
            setMeasuredDimension(i8, 0);
            return;
        }
        int i12 = i9 + (i11 / i10);
        int i13 = i10;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        boolean z4 = false;
        long j = 0;
        int childCount = getChildCount();
        int i17 = size2;
        int i18 = 0;
        int i19 = paddingLeft;
        int i20 = 0;
        while (i20 < childCount) {
            View childAt = getChildAt(i20);
            int i21 = i10;
            int i22 = i11;
            if (childAt.getVisibility() != 8) {
                boolean z5 = childAt instanceof ActionMenuItemView;
                int i23 = i18 + 1;
                if (z5) {
                    int i24 = this.mGeneratedItemPadding;
                    i7 = i23;
                    z3 = false;
                    childAt.setPadding(i24, 0, i24, 0);
                } else {
                    i7 = i23;
                    z3 = false;
                }
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.expanded = z3;
                layoutParams.extraPixels = z3 ? 1 : 0;
                layoutParams.cellsUsed = z3;
                layoutParams.expandable = z3;
                layoutParams.leftMargin = z3;
                layoutParams.rightMargin = z3;
                layoutParams.preventEdgeOffset = z5 && ((ActionMenuItemView) childAt).hasText();
                int i25 = layoutParams.isOverflowButton ? 1 : i13;
                boolean z6 = z5;
                int measureChildForCells = measureChildForCells(childAt, i12, i25, childMeasureSpec, paddingTop);
                i15 = Math.max(i15, measureChildForCells);
                int i26 = i25;
                if (layoutParams.expandable) {
                    i16++;
                }
                if (layoutParams.isOverflowButton) {
                    z4 = true;
                }
                i13 -= measureChildForCells;
                int max = Math.max(i14, childAt.getMeasuredHeight());
                if (measureChildForCells == 1) {
                    int i27 = measureChildForCells;
                    LayoutParams layoutParams2 = layoutParams;
                    i14 = max;
                    j |= (long) (1 << i20);
                    i18 = i7;
                } else {
                    int i28 = measureChildForCells;
                    LayoutParams layoutParams3 = layoutParams;
                    i14 = max;
                    i18 = i7;
                }
            }
            i20++;
            int i29 = i2;
            i10 = i21;
            i11 = i22;
        }
        int i30 = i10;
        int i31 = i11;
        boolean z7 = z4 && i18 == 2;
        boolean z8 = false;
        while (true) {
            if (i16 <= 0 || i13 <= 0) {
                i4 = mode;
                i3 = i8;
                int i32 = paddingTop;
                z = z8;
                int i33 = i16;
            } else {
                int i34 = Integer.MAX_VALUE;
                long j2 = 0;
                int i35 = 0;
                int i36 = paddingTop;
                int i37 = 0;
                while (i37 < childCount) {
                    boolean z9 = z8;
                    LayoutParams layoutParams4 = (LayoutParams) getChildAt(i37).getLayoutParams();
                    int i38 = i16;
                    if (layoutParams4.expandable) {
                        if (layoutParams4.cellsUsed < i34) {
                            i34 = layoutParams4.cellsUsed;
                            j2 = 1 << i37;
                            i35 = 1;
                        } else if (layoutParams4.cellsUsed == i34) {
                            j2 |= 1 << i37;
                            i35++;
                        }
                    }
                    i37++;
                    i16 = i38;
                    z8 = z9;
                }
                z = z8;
                int i39 = i16;
                j |= j2;
                if (i35 > i13) {
                    i4 = mode;
                    i3 = i8;
                    break;
                }
                int i40 = i34 + 1;
                int i41 = 0;
                while (i41 < childCount) {
                    View childAt2 = getChildAt(i41);
                    LayoutParams layoutParams5 = (LayoutParams) childAt2.getLayoutParams();
                    int i42 = i35;
                    int i43 = mode;
                    int i44 = i8;
                    if ((j2 & ((long) (1 << i41))) != 0) {
                        if (z7 && layoutParams5.preventEdgeOffset && i13 == 1) {
                            int i45 = this.mGeneratedItemPadding;
                            childAt2.setPadding(i45 + i12, 0, i45, 0);
                        }
                        layoutParams5.cellsUsed++;
                        layoutParams5.expanded = true;
                        i13--;
                    } else if (layoutParams5.cellsUsed == i40) {
                        j |= (long) (1 << i41);
                    }
                    i41++;
                    i35 = i42;
                    mode = i43;
                    i8 = i44;
                }
                int i46 = mode;
                int i47 = i8;
                int i48 = i35;
                z8 = true;
                paddingTop = i36;
                i16 = i39;
            }
        }
        i4 = mode;
        i3 = i8;
        int i322 = paddingTop;
        z = z8;
        int i332 = i16;
        boolean z10 = !z4 && i18 == 1;
        if (i13 <= 0 || j == 0) {
            boolean z11 = z10;
        } else if (i13 < i18 - 1 || z10 || i15 > 1) {
            float bitCount = (float) Long.bitCount(j);
            if (!z10) {
                if ((j & 1) != 0) {
                    i6 = 0;
                    if (!((LayoutParams) getChildAt(0).getLayoutParams()).preventEdgeOffset) {
                        bitCount -= 0.5f;
                    }
                } else {
                    i6 = 0;
                }
                if ((j & ((long) (1 << (childCount - 1)))) != 0 && !((LayoutParams) getChildAt(childCount - 1).getLayoutParams()).preventEdgeOffset) {
                    bitCount -= 0.5f;
                }
            } else {
                i6 = 0;
            }
            if (bitCount > 0.0f) {
                i6 = (int) (((float) (i13 * i12)) / bitCount);
            }
            int i49 = 0;
            z2 = z;
            while (i49 < childCount) {
                boolean z12 = z10;
                float f2 = bitCount;
                if ((j & ((long) (1 << i49))) != 0) {
                    View childAt3 = getChildAt(i49);
                    LayoutParams layoutParams6 = (LayoutParams) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        layoutParams6.extraPixels = i6;
                        layoutParams6.expanded = true;
                        if (i49 == 0 && !layoutParams6.preventEdgeOffset) {
                            layoutParams6.leftMargin = (-i6) / 2;
                        }
                        z2 = true;
                    } else if (layoutParams6.isOverflowButton) {
                        layoutParams6.extraPixels = i6;
                        layoutParams6.expanded = true;
                        layoutParams6.rightMargin = (-i6) / 2;
                        z2 = true;
                    } else {
                        if (i49 != 0) {
                            layoutParams6.leftMargin = i6 / 2;
                        }
                        if (i49 != childCount - 1) {
                            layoutParams6.rightMargin = i6 / 2;
                        }
                    }
                }
                i49++;
                z10 = z12;
                bitCount = f2;
            }
            boolean z13 = z10;
            float f3 = bitCount;
            if (!z2) {
                int i50 = 0;
                while (i50 < childCount) {
                    View childAt4 = getChildAt(i50);
                    LayoutParams layoutParams7 = (LayoutParams) childAt4.getLayoutParams();
                    if (!layoutParams7.expanded) {
                        i5 = i18;
                    } else {
                        i5 = i18;
                        childAt4.measure(View.MeasureSpec.makeMeasureSpec((layoutParams7.cellsUsed * i12) + layoutParams7.extraPixels, 1073741824), childMeasureSpec);
                    }
                    i50++;
                    i18 = i5;
                }
                int i51 = i18;
            } else {
                int i52 = i18;
            }
            setMeasuredDimension(i3, i4 == 1073741824 ? i14 : i17);
        } else {
            boolean z14 = z10;
        }
        z2 = z;
        if (!z2) {
        }
        setMeasuredDimension(i3, i4 == 1073741824 ? i14 : i17);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void dismissPopupMenus() {
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.dismissPopupMenus();
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        return layoutParams;
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return generateDefaultLayoutParams();
        }
        LayoutParams layoutParams2 = layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : new LayoutParams(layoutParams);
        if (layoutParams2.gravity <= 0) {
            layoutParams2.gravity = 16;
        }
        return layoutParams2;
    }

    public LayoutParams generateOverflowButtonLayoutParams() {
        LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
        generateDefaultLayoutParams.isOverflowButton = true;
        return generateDefaultLayoutParams;
    }

    public Menu getMenu() {
        if (this.mMenu == null) {
            Context context = getContext();
            MenuBuilder menuBuilder = new MenuBuilder(context);
            this.mMenu = menuBuilder;
            menuBuilder.setCallback(new MenuBuilderCallback());
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(context);
            this.mPresenter = actionMenuPresenter;
            actionMenuPresenter.setReserveOverflow(true);
            ActionMenuPresenter actionMenuPresenter2 = this.mPresenter;
            MenuPresenter.Callback callback = this.mActionMenuPresenterCallback;
            if (callback == null) {
                callback = new ActionMenuPresenterCallback();
            }
            actionMenuPresenter2.setCallback(callback);
            this.mMenu.addMenuPresenter(this.mPresenter, this.mPopupContext);
            this.mPresenter.setMenuView(this);
        }
        return this.mMenu;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.mPresenter.getOverflowIcon();
    }

    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    public int getWindowAnimations() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public boolean hasSupportDividerBeforeChildAt(int i) {
        if (i == 0) {
            return false;
        }
        View childAt = getChildAt(i - 1);
        View childAt2 = getChildAt(i);
        boolean z = false;
        if (i < getChildCount() && (childAt instanceof ActionMenuChildView)) {
            z = false | ((ActionMenuChildView) childAt).needsDividerAfter();
        }
        return (i <= 0 || !(childAt2 instanceof ActionMenuChildView)) ? z : z | ((ActionMenuChildView) childAt2).needsDividerBefore();
    }

    public boolean hideOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        return actionMenuPresenter != null && actionMenuPresenter.hideOverflowMenu();
    }

    public void initialize(MenuBuilder menuBuilder) {
        this.mMenu = menuBuilder;
    }

    public boolean invokeItem(MenuItemImpl menuItemImpl) {
        return this.mMenu.performItemAction(menuItemImpl, 0);
    }

    public boolean isOverflowMenuShowPending() {
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        return actionMenuPresenter != null && actionMenuPresenter.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        return actionMenuPresenter != null && actionMenuPresenter.isOverflowMenuShowing();
    }

    public boolean isOverflowReserved() {
        return this.mReserveOverflow;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.updateMenuView(false);
            if (this.mPresenter.isOverflowMenuShowing()) {
                this.mPresenter.hideOverflowMenu();
                this.mPresenter.showOverflowMenu();
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dismissPopupMenus();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        boolean z2;
        int i8;
        int i9;
        int i10;
        ActionMenuView actionMenuView = this;
        if (!actionMenuView.mFormatItems) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int childCount = getChildCount();
        int i11 = (i4 - i2) / 2;
        int dividerWidth = getDividerWidth();
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int paddingRight = ((i3 - i) - getPaddingRight()) - getPaddingLeft();
        int i15 = 0;
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        int i16 = 0;
        while (true) {
            i5 = 8;
            if (i16 >= childCount) {
                break;
            }
            View childAt = actionMenuView.getChildAt(i16);
            if (childAt.getVisibility() == 8) {
                i8 = i11;
                z2 = isLayoutRtl;
            } else {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isOverflowButton) {
                    i12 = childAt.getMeasuredWidth();
                    if (actionMenuView.hasSupportDividerBeforeChildAt(i16)) {
                        i12 += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (isLayoutRtl) {
                        i10 = getPaddingLeft() + layoutParams.leftMargin;
                        i9 = i10 + i12;
                    } else {
                        i9 = (getWidth() - getPaddingRight()) - layoutParams.rightMargin;
                        i10 = i9 - i12;
                    }
                    z2 = isLayoutRtl;
                    int i17 = i11 - (measuredHeight / 2);
                    i8 = i11;
                    childAt.layout(i10, i17, i9, i17 + measuredHeight);
                    paddingRight -= i12;
                    i15 = 1;
                } else {
                    i8 = i11;
                    z2 = isLayoutRtl;
                    int measuredWidth = childAt.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
                    i13 += measuredWidth;
                    paddingRight -= measuredWidth;
                    if (actionMenuView.hasSupportDividerBeforeChildAt(i16)) {
                        i13 += dividerWidth;
                    }
                    i14++;
                }
            }
            i16++;
            i11 = i8;
            isLayoutRtl = z2;
        }
        int i18 = i11;
        boolean z3 = isLayoutRtl;
        if (childCount == 1 && i15 == 0) {
            View childAt2 = actionMenuView.getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i19 = ((i3 - i) / 2) - (measuredWidth2 / 2);
            int i20 = i18 - (measuredHeight2 / 2);
            childAt2.layout(i19, i20, i19 + measuredWidth2, i20 + measuredHeight2);
            return;
        }
        int i21 = i14 - (i15 ^ 1);
        int max = Math.max(0, i21 > 0 ? paddingRight / i21 : 0);
        if (z3) {
            int width = getWidth() - getPaddingRight();
            int i22 = 0;
            while (i22 < childCount) {
                View childAt3 = actionMenuView.getChildAt(i22);
                LayoutParams layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                if (childAt3.getVisibility() == i5) {
                    i7 = dividerWidth;
                    i6 = i12;
                } else if (layoutParams2.isOverflowButton) {
                    i7 = dividerWidth;
                    i6 = i12;
                } else {
                    int i23 = width - layoutParams2.rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i24 = i18 - (measuredHeight3 / 2);
                    i7 = dividerWidth;
                    i6 = i12;
                    childAt3.layout(i23 - measuredWidth3, i24, i23, i24 + measuredHeight3);
                    width = i23 - ((layoutParams2.leftMargin + measuredWidth3) + max);
                }
                i22++;
                dividerWidth = i7;
                i12 = i6;
                i5 = 8;
            }
            int i25 = dividerWidth;
            int i26 = i12;
            return;
        }
        int i27 = dividerWidth;
        int i28 = i12;
        int paddingLeft = getPaddingLeft();
        int i29 = 0;
        while (i29 < childCount) {
            View childAt4 = actionMenuView.getChildAt(i29);
            LayoutParams layoutParams3 = (LayoutParams) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !layoutParams3.isOverflowButton) {
                int i30 = paddingLeft + layoutParams3.leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i31 = i18 - (measuredHeight4 / 2);
                childAt4.layout(i30, i31, i30 + measuredWidth4, i31 + measuredHeight4);
                paddingLeft = i30 + layoutParams3.rightMargin + measuredWidth4 + max;
            }
            i29++;
            actionMenuView = this;
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        boolean z = this.mFormatItems;
        boolean z2 = View.MeasureSpec.getMode(i) == 1073741824;
        this.mFormatItems = z2;
        if (z != z2) {
            this.mFormatItemsWidth = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.mFormatItems) {
            MenuBuilder menuBuilder = this.mMenu;
            if (!(menuBuilder == null || size == this.mFormatItemsWidth)) {
                this.mFormatItemsWidth = size;
                menuBuilder.onItemsChanged(true);
            }
        }
        int childCount = getChildCount();
        if (!this.mFormatItems || childCount <= 0) {
            for (int i3 = 0; i3 < childCount; i3++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
                layoutParams.rightMargin = 0;
                layoutParams.leftMargin = 0;
            }
            super.onMeasure(i, i2);
            return;
        }
        onMeasureExactFormat(i, i2);
    }

    public MenuBuilder peekMenu() {
        return this.mMenu;
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.mPresenter.setExpandedActionViewsExclusive(z);
    }

    public void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.mActionMenuPresenterCallback = callback;
        this.mMenuBuilderCallback = callback2;
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.mOnMenuItemClickListener = onMenuItemClickListener;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.mPresenter.setOverflowIcon(drawable);
    }

    public void setOverflowReserved(boolean z) {
        this.mReserveOverflow = z;
    }

    public void setPopupTheme(int i) {
        if (this.mPopupTheme != i) {
            this.mPopupTheme = i;
            if (i == 0) {
                this.mPopupContext = getContext();
            } else {
                this.mPopupContext = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.mPresenter = actionMenuPresenter;
        actionMenuPresenter.setMenuView(this);
    }

    public boolean showOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        return actionMenuPresenter != null && actionMenuPresenter.showOverflowMenu();
    }
}
