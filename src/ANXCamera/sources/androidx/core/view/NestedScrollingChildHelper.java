package androidx.core.view;

import android.view.View;
import android.view.ViewParent;

public class NestedScrollingChildHelper {
    private boolean mIsNestedScrollingEnabled;
    private ViewParent mNestedScrollingParentNonTouch;
    private ViewParent mNestedScrollingParentTouch;
    private int[] mTempNestedScrollConsumed;
    private final View mView;

    public NestedScrollingChildHelper(View view) {
        this.mView = view;
    }

    private boolean dispatchNestedScrollInternal(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        int i6;
        int i7;
        int[] iArr3;
        int[] iArr4 = iArr;
        if (isNestedScrollingEnabled()) {
            ViewParent nestedScrollingParentForType = getNestedScrollingParentForType(i5);
            if (nestedScrollingParentForType == null) {
                return false;
            }
            if (i != 0 || i2 != 0 || i3 != 0 || i4 != 0) {
                if (iArr4 != null) {
                    this.mView.getLocationInWindow(iArr4);
                    i7 = iArr4[0];
                    i6 = iArr4[1];
                } else {
                    i7 = 0;
                    i6 = 0;
                }
                if (iArr2 == null) {
                    int[] tempNestedScrollConsumed = getTempNestedScrollConsumed();
                    tempNestedScrollConsumed[0] = 0;
                    tempNestedScrollConsumed[1] = 0;
                    iArr3 = tempNestedScrollConsumed;
                } else {
                    iArr3 = iArr2;
                }
                ViewParentCompat.onNestedScroll(nestedScrollingParentForType, this.mView, i, i2, i3, i4, i5, iArr3);
                if (iArr4 != null) {
                    this.mView.getLocationInWindow(iArr4);
                    iArr4[0] = iArr4[0] - i7;
                    iArr4[1] = iArr4[1] - i6;
                }
                return true;
            } else if (iArr4 != null) {
                iArr4[0] = 0;
                iArr4[1] = 0;
            }
        } else {
            int i8 = i5;
        }
        return false;
    }

    private ViewParent getNestedScrollingParentForType(int i) {
        if (i == 0) {
            return this.mNestedScrollingParentTouch;
        }
        if (i != 1) {
            return null;
        }
        return this.mNestedScrollingParentNonTouch;
    }

    private int[] getTempNestedScrollConsumed() {
        if (this.mTempNestedScrollConsumed == null) {
            this.mTempNestedScrollConsumed = new int[2];
        }
        return this.mTempNestedScrollConsumed;
    }

    private void setNestedScrollingParentForType(int i, ViewParent viewParent) {
        if (i == 0) {
            this.mNestedScrollingParentTouch = viewParent;
        } else if (i == 1) {
            this.mNestedScrollingParentNonTouch = viewParent;
        }
    }

    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        if (isNestedScrollingEnabled()) {
            ViewParent nestedScrollingParentForType = getNestedScrollingParentForType(0);
            if (nestedScrollingParentForType != null) {
                return ViewParentCompat.onNestedFling(nestedScrollingParentForType, this.mView, f2, f3, z);
            }
        }
        return false;
    }

    public boolean dispatchNestedPreFling(float f2, float f3) {
        if (isNestedScrollingEnabled()) {
            ViewParent nestedScrollingParentForType = getNestedScrollingParentForType(0);
            if (nestedScrollingParentForType != null) {
                return ViewParentCompat.onNestedPreFling(nestedScrollingParentForType, this.mView, f2, f3);
            }
        }
        return false;
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return dispatchNestedPreScroll(i, i2, iArr, iArr2, 0);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        int i4;
        int i5;
        int[] iArr3 = iArr2;
        if (isNestedScrollingEnabled()) {
            ViewParent nestedScrollingParentForType = getNestedScrollingParentForType(i3);
            if (nestedScrollingParentForType == null) {
                return false;
            }
            if (i != 0 || i2 != 0) {
                if (iArr3 != null) {
                    this.mView.getLocationInWindow(iArr3);
                    i5 = iArr3[0];
                    i4 = iArr3[1];
                } else {
                    i5 = 0;
                    i4 = 0;
                }
                int[] tempNestedScrollConsumed = iArr == null ? getTempNestedScrollConsumed() : iArr;
                tempNestedScrollConsumed[0] = 0;
                tempNestedScrollConsumed[1] = 0;
                ViewParentCompat.onNestedPreScroll(nestedScrollingParentForType, this.mView, i, i2, tempNestedScrollConsumed, i3);
                if (iArr3 != null) {
                    this.mView.getLocationInWindow(iArr3);
                    iArr3[0] = iArr3[0] - i5;
                    iArr3[1] = iArr3[1] - i4;
                }
                return (tempNestedScrollConsumed[0] == 0 && tempNestedScrollConsumed[1] == 0) ? false : true;
            } else if (iArr3 != null) {
                iArr3[0] = 0;
                iArr3[1] = 0;
            }
        } else {
            int i6 = i3;
        }
        return false;
    }

    public void dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        dispatchNestedScrollInternal(i, i2, i3, i4, iArr, i5, iArr2);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return dispatchNestedScrollInternal(i, i2, i3, i4, iArr, 0, (int[]) null);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return dispatchNestedScrollInternal(i, i2, i3, i4, iArr, i5, (int[]) null);
    }

    public boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    public boolean hasNestedScrollingParent(int i) {
        return getNestedScrollingParentForType(i) != null;
    }

    public boolean isNestedScrollingEnabled() {
        return this.mIsNestedScrollingEnabled;
    }

    public void onDetachedFromWindow() {
        ViewCompat.stopNestedScroll(this.mView);
    }

    public void onStopNestedScroll(View view) {
        ViewCompat.stopNestedScroll(this.mView);
    }

    public void setNestedScrollingEnabled(boolean z) {
        if (this.mIsNestedScrollingEnabled) {
            ViewCompat.stopNestedScroll(this.mView);
        }
        this.mIsNestedScrollingEnabled = z;
    }

    public boolean startNestedScroll(int i) {
        return startNestedScroll(i, 0);
    }

    public boolean startNestedScroll(int i, int i2) {
        if (hasNestedScrollingParent(i2)) {
            return true;
        }
        if (!isNestedScrollingEnabled()) {
            return false;
        }
        View view = this.mView;
        for (ViewParent parent = this.mView.getParent(); parent != null; parent = parent.getParent()) {
            if (ViewParentCompat.onStartNestedScroll(parent, view, this.mView, i, i2)) {
                setNestedScrollingParentForType(i2, parent);
                ViewParentCompat.onNestedScrollAccepted(parent, view, this.mView, i, i2);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    public void stopNestedScroll(int i) {
        ViewParent nestedScrollingParentForType = getNestedScrollingParentForType(i);
        if (nestedScrollingParentForType != null) {
            ViewParentCompat.onStopNestedScroll(nestedScrollingParentForType, this.mView, i);
            setNestedScrollingParentForType(i, (ViewParent) null);
        }
    }
}
