package androidx.customview.widget;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.view.ViewCompat;
import java.util.Arrays;

public class ViewDragHelper {
    private static final int BASE_SETTLE_DURATION = 256;
    public static final int DIRECTION_ALL = 3;
    public static final int DIRECTION_HORIZONTAL = 1;
    public static final int DIRECTION_VERTICAL = 2;
    public static final int EDGE_ALL = 15;
    public static final int EDGE_BOTTOM = 8;
    public static final int EDGE_LEFT = 1;
    public static final int EDGE_RIGHT = 2;
    private static final int EDGE_SIZE = 20;
    public static final int EDGE_TOP = 4;
    public static final int INVALID_POINTER = -1;
    private static final int MAX_SETTLE_DURATION = 600;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "ViewDragHelper";
    private static final Interpolator sInterpolator = new Interpolator() {
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    };
    private int mActivePointerId = -1;
    private final Callback mCallback;
    private View mCapturedView;
    private int mDragState;
    private int[] mEdgeDragsInProgress;
    private int[] mEdgeDragsLocked;
    private int mEdgeSize;
    private int[] mInitialEdgesTouched;
    private float[] mInitialMotionX;
    private float[] mInitialMotionY;
    private float[] mLastMotionX;
    private float[] mLastMotionY;
    private float mMaxVelocity;
    private float mMinVelocity;
    private final ViewGroup mParentView;
    private int mPointersDown;
    private boolean mReleaseInProgress;
    private OverScroller mScroller;
    private final Runnable mSetIdleRunnable = new Runnable() {
        public void run() {
            ViewDragHelper.this.setDragState(0);
        }
    };
    private int mTouchSlop;
    private int mTrackingEdges;
    private VelocityTracker mVelocityTracker;

    public static abstract class Callback {
        public int clampViewPositionHorizontal(View view, int i, int i2) {
            return 0;
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            return 0;
        }

        public int getOrderedChildIndex(int i) {
            return i;
        }

        public int getViewHorizontalDragRange(View view) {
            return 0;
        }

        public int getViewVerticalDragRange(View view) {
            return 0;
        }

        public void onEdgeDragStarted(int i, int i2) {
        }

        public boolean onEdgeLock(int i) {
            return false;
        }

        public void onEdgeTouched(int i, int i2) {
        }

        public void onViewCaptured(View view, int i) {
        }

        public void onViewDragStateChanged(int i) {
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
        }

        public void onViewReleased(View view, float f2, float f3) {
        }

        public abstract boolean tryCaptureView(View view, int i);
    }

    private ViewDragHelper(Context context, ViewGroup viewGroup, Callback callback) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (callback != null) {
            this.mParentView = viewGroup;
            this.mCallback = callback;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.mEdgeSize = (int) ((20.0f * context.getResources().getDisplayMetrics().density) + 0.5f);
            this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
            this.mMaxVelocity = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.mMinVelocity = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.mScroller = new OverScroller(context, sInterpolator);
        } else {
            throw new IllegalArgumentException("Callback may not be null");
        }
    }

    private boolean checkNewEdgeDrag(float f2, float f3, int i, int i2) {
        float abs = Math.abs(f2);
        float abs2 = Math.abs(f3);
        if (!((this.mInitialEdgesTouched[i] & i2) != i2 || (this.mTrackingEdges & i2) == 0 || (this.mEdgeDragsLocked[i] & i2) == i2 || (this.mEdgeDragsInProgress[i] & i2) == i2)) {
            int i3 = this.mTouchSlop;
            if (abs > ((float) i3) || abs2 > ((float) i3)) {
                if (abs >= 0.5f * abs2 || !this.mCallback.onEdgeLock(i2)) {
                    return (this.mEdgeDragsInProgress[i] & i2) == 0 && abs > ((float) this.mTouchSlop);
                }
                int[] iArr = this.mEdgeDragsLocked;
                iArr[i] = iArr[i] | i2;
                return false;
            }
        }
        return false;
    }

    private boolean checkTouchSlop(View view, float f2, float f3) {
        if (view == null) {
            return false;
        }
        boolean z = this.mCallback.getViewHorizontalDragRange(view) > 0;
        boolean z2 = this.mCallback.getViewVerticalDragRange(view) > 0;
        if (!z || !z2) {
            return z ? Math.abs(f2) > ((float) this.mTouchSlop) : z2 && Math.abs(f3) > ((float) this.mTouchSlop);
        }
        float f4 = (f2 * f2) + (f3 * f3);
        int i = this.mTouchSlop;
        return f4 > ((float) (i * i));
    }

    private float clampMag(float f2, float f3, float f4) {
        float abs = Math.abs(f2);
        if (abs < f3) {
            return 0.0f;
        }
        return abs > f4 ? f2 > 0.0f ? f4 : -f4 : f2;
    }

    private int clampMag(int i, int i2, int i3) {
        int abs = Math.abs(i);
        if (abs < i2) {
            return 0;
        }
        return abs > i3 ? i > 0 ? i3 : -i3 : i;
    }

    private void clearMotionHistory() {
        float[] fArr = this.mInitialMotionX;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.mInitialMotionY, 0.0f);
            Arrays.fill(this.mLastMotionX, 0.0f);
            Arrays.fill(this.mLastMotionY, 0.0f);
            Arrays.fill(this.mInitialEdgesTouched, 0);
            Arrays.fill(this.mEdgeDragsInProgress, 0);
            Arrays.fill(this.mEdgeDragsLocked, 0);
            this.mPointersDown = 0;
        }
    }

    private void clearMotionHistory(int i) {
        if (this.mInitialMotionX != null && isPointerDown(i)) {
            this.mInitialMotionX[i] = 0.0f;
            this.mInitialMotionY[i] = 0.0f;
            this.mLastMotionX[i] = 0.0f;
            this.mLastMotionY[i] = 0.0f;
            this.mInitialEdgesTouched[i] = 0;
            this.mEdgeDragsInProgress[i] = 0;
            this.mEdgeDragsLocked[i] = 0;
            this.mPointersDown &= ~(1 << i);
        }
    }

    private int computeAxisDuration(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.mParentView.getWidth();
        int i4 = width / 2;
        float distanceInfluenceForSnapDuration = ((float) i4) + (((float) i4) * distanceInfluenceForSnapDuration(Math.min(1.0f, ((float) Math.abs(i)) / ((float) width))));
        int abs = Math.abs(i2);
        return Math.min(abs > 0 ? Math.round(Math.abs(distanceInfluenceForSnapDuration / ((float) abs)) * 1000.0f) * 4 : (int) ((1.0f + (((float) Math.abs(i)) / ((float) i3))) * 256.0f), MAX_SETTLE_DURATION);
    }

    private int computeSettleDuration(View view, int i, int i2, int i3, int i4) {
        float f2;
        float f3;
        float f4;
        float f5;
        View view2 = view;
        int clampMag = clampMag(i3, (int) this.mMinVelocity, (int) this.mMaxVelocity);
        int clampMag2 = clampMag(i4, (int) this.mMinVelocity, (int) this.mMaxVelocity);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(clampMag);
        int abs4 = Math.abs(clampMag2);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        if (clampMag != 0) {
            f3 = (float) abs3;
            f2 = (float) i5;
        } else {
            f3 = (float) abs;
            f2 = (float) i6;
        }
        float f6 = f3 / f2;
        if (clampMag2 != 0) {
            f5 = (float) abs4;
            f4 = (float) i5;
        } else {
            f5 = (float) abs2;
            f4 = (float) i6;
        }
        float f7 = f5 / f4;
        return (int) ((((float) computeAxisDuration(i, clampMag, this.mCallback.getViewHorizontalDragRange(view2))) * f6) + (((float) computeAxisDuration(i2, clampMag2, this.mCallback.getViewVerticalDragRange(view2))) * f7));
    }

    public static ViewDragHelper create(ViewGroup viewGroup, float f2, Callback callback) {
        ViewDragHelper create = create(viewGroup, callback);
        create.mTouchSlop = (int) (((float) create.mTouchSlop) * (1.0f / f2));
        return create;
    }

    public static ViewDragHelper create(ViewGroup viewGroup, Callback callback) {
        return new ViewDragHelper(viewGroup.getContext(), viewGroup, callback);
    }

    private void dispatchViewReleased(float f2, float f3) {
        this.mReleaseInProgress = true;
        this.mCallback.onViewReleased(this.mCapturedView, f2, f3);
        this.mReleaseInProgress = false;
        if (this.mDragState == 1) {
            setDragState(0);
        }
    }

    private float distanceInfluenceForSnapDuration(float f2) {
        return (float) Math.sin((double) ((f2 - 0.5f) * 0.47123894f));
    }

    private void dragTo(int i, int i2, int i3, int i4) {
        int i5 = i3;
        int i6 = i4;
        int i7 = i;
        int i8 = i2;
        int left = this.mCapturedView.getLeft();
        int top = this.mCapturedView.getTop();
        if (i5 != 0) {
            i7 = this.mCallback.clampViewPositionHorizontal(this.mCapturedView, i, i5);
            ViewCompat.offsetLeftAndRight(this.mCapturedView, i7 - left);
        } else {
            int i9 = i;
        }
        if (i6 != 0) {
            i8 = this.mCallback.clampViewPositionVertical(this.mCapturedView, i2, i6);
            ViewCompat.offsetTopAndBottom(this.mCapturedView, i8 - top);
        } else {
            int i10 = i2;
        }
        if (i5 != 0 || i6 != 0) {
            this.mCallback.onViewPositionChanged(this.mCapturedView, i7, i8, i7 - left, i8 - top);
        }
    }

    private void ensureMotionHistorySizeForId(int i) {
        float[] fArr = this.mInitialMotionX;
        if (fArr == null || fArr.length <= i) {
            float[] fArr2 = new float[(i + 1)];
            float[] fArr3 = new float[(i + 1)];
            float[] fArr4 = new float[(i + 1)];
            float[] fArr5 = new float[(i + 1)];
            int[] iArr = new int[(i + 1)];
            int[] iArr2 = new int[(i + 1)];
            int[] iArr3 = new int[(i + 1)];
            float[] fArr6 = this.mInitialMotionX;
            if (fArr6 != null) {
                System.arraycopy(fArr6, 0, fArr2, 0, fArr6.length);
                float[] fArr7 = this.mInitialMotionY;
                System.arraycopy(fArr7, 0, fArr3, 0, fArr7.length);
                float[] fArr8 = this.mLastMotionX;
                System.arraycopy(fArr8, 0, fArr4, 0, fArr8.length);
                float[] fArr9 = this.mLastMotionY;
                System.arraycopy(fArr9, 0, fArr5, 0, fArr9.length);
                int[] iArr4 = this.mInitialEdgesTouched;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.mEdgeDragsInProgress;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.mEdgeDragsLocked;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.mInitialMotionX = fArr2;
            this.mInitialMotionY = fArr3;
            this.mLastMotionX = fArr4;
            this.mLastMotionY = fArr5;
            this.mInitialEdgesTouched = iArr;
            this.mEdgeDragsInProgress = iArr2;
            this.mEdgeDragsLocked = iArr3;
        }
    }

    private boolean forceSettleCapturedViewAt(int i, int i2, int i3, int i4) {
        int left = this.mCapturedView.getLeft();
        int top = this.mCapturedView.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.mScroller.abortAnimation();
            setDragState(0);
            return false;
        }
        this.mScroller.startScroll(left, top, i5, i6, computeSettleDuration(this.mCapturedView, i5, i6, i3, i4));
        setDragState(2);
        return true;
    }

    private int getEdgesTouched(int i, int i2) {
        int i3 = 0;
        if (i < this.mParentView.getLeft() + this.mEdgeSize) {
            i3 = 0 | 1;
        }
        if (i2 < this.mParentView.getTop() + this.mEdgeSize) {
            i3 |= 4;
        }
        if (i > this.mParentView.getRight() - this.mEdgeSize) {
            i3 |= 2;
        }
        return i2 > this.mParentView.getBottom() - this.mEdgeSize ? i3 | 8 : i3;
    }

    private boolean isValidPointerForActionMove(int i) {
        if (isPointerDown(i)) {
            return true;
        }
        Log.e(TAG, "Ignoring pointerId=" + i + " because ACTION_DOWN was not received " + "for this pointer before ACTION_MOVE. It likely happened because " + " ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    private void releaseViewForPointerUp() {
        this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxVelocity);
        dispatchViewReleased(clampMag(this.mVelocityTracker.getXVelocity(this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity), clampMag(this.mVelocityTracker.getYVelocity(this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity));
    }

    private void reportNewEdgeDrags(float f2, float f3, int i) {
        int i2 = 0;
        if (checkNewEdgeDrag(f2, f3, i, 1)) {
            i2 = 0 | 1;
        }
        if (checkNewEdgeDrag(f3, f2, i, 4)) {
            i2 |= 4;
        }
        if (checkNewEdgeDrag(f2, f3, i, 2)) {
            i2 |= 2;
        }
        if (checkNewEdgeDrag(f3, f2, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.mEdgeDragsInProgress;
            iArr[i] = iArr[i] | i2;
            this.mCallback.onEdgeDragStarted(i2, i);
        }
    }

    private void saveInitialMotion(float f2, float f3, int i) {
        ensureMotionHistorySizeForId(i);
        float[] fArr = this.mInitialMotionX;
        this.mLastMotionX[i] = f2;
        fArr[i] = f2;
        float[] fArr2 = this.mInitialMotionY;
        this.mLastMotionY[i] = f3;
        fArr2[i] = f3;
        this.mInitialEdgesTouched[i] = getEdgesTouched((int) f2, (int) f3);
        this.mPointersDown |= 1 << i;
    }

    private void saveLastMotion(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            if (isValidPointerForActionMove(pointerId)) {
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                this.mLastMotionX[pointerId] = x;
                this.mLastMotionY[pointerId] = y;
            }
        }
    }

    public void abort() {
        cancel();
        if (this.mDragState == 2) {
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            this.mScroller.abortAnimation();
            int currX2 = this.mScroller.getCurrX();
            int currY2 = this.mScroller.getCurrY();
            this.mCallback.onViewPositionChanged(this.mCapturedView, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        setDragState(0);
    }

    /* access modifiers changed from: protected */
    public boolean canScroll(View view, boolean z, int i, int i2, int i3, int i4) {
        View view2 = view;
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i3 + scrollX >= childAt.getLeft() && i3 + scrollX < childAt.getRight() && i4 + scrollY >= childAt.getTop() && i4 + scrollY < childAt.getBottom()) {
                    if (canScroll(childAt, true, i, i2, (i3 + scrollX) - childAt.getLeft(), (i4 + scrollY) - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (!z) {
            int i5 = i;
            int i6 = i2;
        } else if (view2.canScrollHorizontally(-i)) {
            int i7 = i2;
            return true;
        } else if (view2.canScrollVertically(-i2)) {
            return true;
        }
        return false;
    }

    public void cancel() {
        this.mActivePointerId = -1;
        clearMotionHistory();
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public void captureChildView(View view, int i) {
        if (view.getParent() == this.mParentView) {
            this.mCapturedView = view;
            this.mActivePointerId = i;
            this.mCallback.onViewCaptured(view, i);
            setDragState(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.mParentView + ")");
    }

    public boolean checkTouchSlop(int i) {
        int length = this.mInitialMotionX.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (checkTouchSlop(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkTouchSlop(int i, int i2) {
        if (!isPointerDown(i2)) {
            return false;
        }
        boolean z = (i & 1) == 1;
        boolean z2 = (i & 2) == 2;
        float f2 = this.mLastMotionX[i2] - this.mInitialMotionX[i2];
        float f3 = this.mLastMotionY[i2] - this.mInitialMotionY[i2];
        if (!z || !z2) {
            return z ? Math.abs(f2) > ((float) this.mTouchSlop) : z2 && Math.abs(f3) > ((float) this.mTouchSlop);
        }
        float f4 = (f2 * f2) + (f3 * f3);
        int i3 = this.mTouchSlop;
        return f4 > ((float) (i3 * i3));
    }

    public boolean continueSettling(boolean z) {
        if (this.mDragState == 2) {
            boolean computeScrollOffset = this.mScroller.computeScrollOffset();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            int left = currX - this.mCapturedView.getLeft();
            int top = currY - this.mCapturedView.getTop();
            if (left != 0) {
                ViewCompat.offsetLeftAndRight(this.mCapturedView, left);
            }
            if (top != 0) {
                ViewCompat.offsetTopAndBottom(this.mCapturedView, top);
            }
            if (!(left == 0 && top == 0)) {
                this.mCallback.onViewPositionChanged(this.mCapturedView, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.mScroller.getFinalX() && currY == this.mScroller.getFinalY()) {
                this.mScroller.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z) {
                    this.mParentView.post(this.mSetIdleRunnable);
                } else {
                    setDragState(0);
                }
            }
        }
        return this.mDragState == 2;
    }

    public View findTopChildUnder(int i, int i2) {
        for (int childCount = this.mParentView.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.mParentView.getChildAt(this.mCallback.getOrderedChildIndex(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public void flingCapturedView(int i, int i2, int i3, int i4) {
        if (this.mReleaseInProgress) {
            this.mScroller.fling(this.mCapturedView.getLeft(), this.mCapturedView.getTop(), (int) this.mVelocityTracker.getXVelocity(this.mActivePointerId), (int) this.mVelocityTracker.getYVelocity(this.mActivePointerId), i, i3, i2, i4);
            setDragState(2);
            return;
        }
        throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
    }

    public int getActivePointerId() {
        return this.mActivePointerId;
    }

    public View getCapturedView() {
        return this.mCapturedView;
    }

    public int getEdgeSize() {
        return this.mEdgeSize;
    }

    public float getMinVelocity() {
        return this.mMinVelocity;
    }

    public int getTouchSlop() {
        return this.mTouchSlop;
    }

    public int getViewDragState() {
        return this.mDragState;
    }

    public boolean isCapturedViewUnder(int i, int i2) {
        return isViewUnder(this.mCapturedView, i, i2);
    }

    public boolean isEdgeTouched(int i) {
        int length = this.mInitialEdgesTouched.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (isEdgeTouched(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEdgeTouched(int i, int i2) {
        return isPointerDown(i2) && (this.mInitialEdgesTouched[i2] & i) != 0;
    }

    public boolean isPointerDown(int i) {
        return (this.mPointersDown & (1 << i)) != 0;
    }

    public boolean isViewUnder(View view, int i, int i2) {
        return view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom();
    }

    public void processTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            cancel();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View findTopChildUnder = findTopChildUnder((int) x, (int) y);
            saveInitialMotion(x, y, pointerId);
            tryCaptureViewForDrag(findTopChildUnder, pointerId);
            int i = this.mInitialEdgesTouched[pointerId];
            int i2 = this.mTrackingEdges;
            if ((i & i2) != 0) {
                this.mCallback.onEdgeTouched(i2 & i, pointerId);
            }
        } else if (actionMasked == 1) {
            if (this.mDragState == 1) {
                releaseViewForPointerUp();
            }
            cancel();
        } else if (actionMasked != 2) {
            if (actionMasked == 3) {
                if (this.mDragState == 1) {
                    dispatchViewReleased(0.0f, 0.0f);
                }
                cancel();
            } else if (actionMasked == 5) {
                int pointerId2 = motionEvent.getPointerId(actionIndex);
                float x2 = motionEvent.getX(actionIndex);
                float y2 = motionEvent.getY(actionIndex);
                saveInitialMotion(x2, y2, pointerId2);
                if (this.mDragState == 0) {
                    tryCaptureViewForDrag(findTopChildUnder((int) x2, (int) y2), pointerId2);
                    int i3 = this.mInitialEdgesTouched[pointerId2];
                    int i4 = this.mTrackingEdges;
                    if ((i3 & i4) != 0) {
                        this.mCallback.onEdgeTouched(i4 & i3, pointerId2);
                    }
                } else if (isCapturedViewUnder((int) x2, (int) y2)) {
                    tryCaptureViewForDrag(this.mCapturedView, pointerId2);
                }
            } else if (actionMasked == 6) {
                int pointerId3 = motionEvent.getPointerId(actionIndex);
                if (this.mDragState == 1 && pointerId3 == this.mActivePointerId) {
                    int i5 = -1;
                    int pointerCount = motionEvent.getPointerCount();
                    int i6 = 0;
                    while (true) {
                        if (i6 >= pointerCount) {
                            break;
                        }
                        int pointerId4 = motionEvent.getPointerId(i6);
                        if (pointerId4 != this.mActivePointerId) {
                            View findTopChildUnder2 = findTopChildUnder((int) motionEvent.getX(i6), (int) motionEvent.getY(i6));
                            View view = this.mCapturedView;
                            if (findTopChildUnder2 == view && tryCaptureViewForDrag(view, pointerId4)) {
                                i5 = this.mActivePointerId;
                                break;
                            }
                        }
                        i6++;
                    }
                    if (i5 == -1) {
                        releaseViewForPointerUp();
                    }
                }
                clearMotionHistory(pointerId3);
            }
        } else if (this.mDragState != 1) {
            int pointerCount2 = motionEvent.getPointerCount();
            for (int i7 = 0; i7 < pointerCount2; i7++) {
                int pointerId5 = motionEvent.getPointerId(i7);
                if (isValidPointerForActionMove(pointerId5)) {
                    float x3 = motionEvent.getX(i7);
                    float y3 = motionEvent.getY(i7);
                    float f2 = x3 - this.mInitialMotionX[pointerId5];
                    float f3 = y3 - this.mInitialMotionY[pointerId5];
                    reportNewEdgeDrags(f2, f3, pointerId5);
                    if (this.mDragState != 1) {
                        View findTopChildUnder3 = findTopChildUnder((int) x3, (int) y3);
                        if (checkTouchSlop(findTopChildUnder3, f2, f3) && tryCaptureViewForDrag(findTopChildUnder3, pointerId5)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            saveLastMotion(motionEvent);
        } else if (isValidPointerForActionMove(this.mActivePointerId)) {
            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
            float x4 = motionEvent.getX(findPointerIndex);
            float y4 = motionEvent.getY(findPointerIndex);
            float[] fArr = this.mLastMotionX;
            int i8 = this.mActivePointerId;
            int i9 = (int) (x4 - fArr[i8]);
            int i10 = (int) (y4 - this.mLastMotionY[i8]);
            dragTo(this.mCapturedView.getLeft() + i9, this.mCapturedView.getTop() + i10, i9, i10);
            saveLastMotion(motionEvent);
        }
    }

    /* access modifiers changed from: package-private */
    public void setDragState(int i) {
        this.mParentView.removeCallbacks(this.mSetIdleRunnable);
        if (this.mDragState != i) {
            this.mDragState = i;
            this.mCallback.onViewDragStateChanged(i);
            if (this.mDragState == 0) {
                this.mCapturedView = null;
            }
        }
    }

    public void setEdgeTrackingEnabled(int i) {
        this.mTrackingEdges = i;
    }

    public void setMinVelocity(float f2) {
        this.mMinVelocity = f2;
    }

    public boolean settleCapturedViewAt(int i, int i2) {
        if (this.mReleaseInProgress) {
            return forceSettleCapturedViewAt(i, i2, (int) this.mVelocityTracker.getXVelocity(this.mActivePointerId), (int) this.mVelocityTracker.getYVelocity(this.mActivePointerId));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0110, code lost:
        if (r2 != r15) goto L_0x011f;
     */
    public boolean shouldInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int i;
        int i2;
        int i3;
        MotionEvent motionEvent2 = motionEvent;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            cancel();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent2);
        boolean z2 = true;
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                int i4 = actionMasked;
                int i5 = actionIndex;
            } else if (actionMasked != 2) {
                if (actionMasked == 3) {
                    int i6 = actionMasked;
                    int i7 = actionIndex;
                } else if (actionMasked == 5) {
                    int pointerId = motionEvent2.getPointerId(actionIndex);
                    float x = motionEvent2.getX(actionIndex);
                    float y = motionEvent2.getY(actionIndex);
                    saveInitialMotion(x, y, pointerId);
                    int i8 = this.mDragState;
                    if (i8 == 0) {
                        int i9 = this.mInitialEdgesTouched[pointerId];
                        int i10 = this.mTrackingEdges;
                        if ((i9 & i10) != 0) {
                            this.mCallback.onEdgeTouched(i10 & i9, pointerId);
                        }
                    } else if (i8 == 2) {
                        View findTopChildUnder = findTopChildUnder((int) x, (int) y);
                        if (findTopChildUnder == this.mCapturedView) {
                            tryCaptureViewForDrag(findTopChildUnder, pointerId);
                        }
                        int i11 = actionMasked;
                        int i12 = actionIndex;
                        z = false;
                    }
                    int i13 = actionMasked;
                    int i14 = actionIndex;
                    z = false;
                } else if (actionMasked != 6) {
                    int i15 = actionMasked;
                    int i16 = actionIndex;
                    z = false;
                } else {
                    clearMotionHistory(motionEvent2.getPointerId(actionIndex));
                    int i17 = actionMasked;
                    int i18 = actionIndex;
                    z = false;
                }
            } else if (this.mInitialMotionX == null) {
                int i19 = actionMasked;
                int i20 = actionIndex;
                z = false;
            } else if (this.mInitialMotionY == null) {
                int i21 = actionMasked;
                int i22 = actionIndex;
                z = false;
            } else {
                int pointerCount = motionEvent.getPointerCount();
                int i23 = 0;
                while (true) {
                    if (i23 >= pointerCount) {
                        int i24 = actionMasked;
                        int i25 = actionIndex;
                        int i26 = pointerCount;
                        break;
                    }
                    int pointerId2 = motionEvent2.getPointerId(i23);
                    if (isValidPointerForActionMove(pointerId2)) {
                        float x2 = motionEvent2.getX(i23);
                        float y2 = motionEvent2.getY(i23);
                        float f2 = x2 - this.mInitialMotionX[pointerId2];
                        float f3 = y2 - this.mInitialMotionY[pointerId2];
                        View findTopChildUnder2 = findTopChildUnder((int) x2, (int) y2);
                        boolean z3 = (findTopChildUnder2 == null || !checkTouchSlop(findTopChildUnder2, f2, f3)) ? false : z2;
                        if (z3) {
                            int left = findTopChildUnder2.getLeft();
                            int i27 = ((int) f2) + left;
                            i3 = actionMasked;
                            int clampViewPositionHorizontal = this.mCallback.clampViewPositionHorizontal(findTopChildUnder2, i27, (int) f2);
                            int top = findTopChildUnder2.getTop();
                            i2 = actionIndex;
                            int i28 = ((int) f3) + top;
                            int i29 = i27;
                            i = pointerCount;
                            int clampViewPositionVertical = this.mCallback.clampViewPositionVertical(findTopChildUnder2, i28, (int) f3);
                            int viewHorizontalDragRange = this.mCallback.getViewHorizontalDragRange(findTopChildUnder2);
                            int i30 = i28;
                            int viewVerticalDragRange = this.mCallback.getViewVerticalDragRange(findTopChildUnder2);
                            if (viewHorizontalDragRange != 0) {
                                if (viewHorizontalDragRange > 0) {
                                }
                            }
                            if (viewVerticalDragRange != 0) {
                                if (viewVerticalDragRange > 0 && clampViewPositionVertical == top) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        } else {
                            i3 = actionMasked;
                            i2 = actionIndex;
                            i = pointerCount;
                        }
                        reportNewEdgeDrags(f2, f3, pointerId2);
                        if (this.mDragState != 1) {
                            if (z3 && tryCaptureViewForDrag(findTopChildUnder2, pointerId2)) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        i3 = actionMasked;
                        i2 = actionIndex;
                        i = pointerCount;
                    }
                    i23++;
                    actionMasked = i3;
                    actionIndex = i2;
                    pointerCount = i;
                    z2 = true;
                }
                saveLastMotion(motionEvent);
                z = false;
            }
            cancel();
            z = false;
        } else {
            int i31 = actionMasked;
            int i32 = actionIndex;
            float x3 = motionEvent.getX();
            float y3 = motionEvent.getY();
            z = false;
            int pointerId3 = motionEvent2.getPointerId(0);
            saveInitialMotion(x3, y3, pointerId3);
            View findTopChildUnder3 = findTopChildUnder((int) x3, (int) y3);
            if (findTopChildUnder3 == this.mCapturedView && this.mDragState == 2) {
                tryCaptureViewForDrag(findTopChildUnder3, pointerId3);
            }
            int i33 = this.mInitialEdgesTouched[pointerId3];
            int i34 = this.mTrackingEdges;
            if ((i33 & i34) != 0) {
                this.mCallback.onEdgeTouched(i34 & i33, pointerId3);
            }
        }
        if (this.mDragState == 1) {
            return true;
        }
        return z;
    }

    public boolean smoothSlideViewTo(View view, int i, int i2) {
        this.mCapturedView = view;
        this.mActivePointerId = -1;
        boolean forceSettleCapturedViewAt = forceSettleCapturedViewAt(i, i2, 0, 0);
        if (!forceSettleCapturedViewAt && this.mDragState == 0 && this.mCapturedView != null) {
            this.mCapturedView = null;
        }
        return forceSettleCapturedViewAt;
    }

    /* access modifiers changed from: package-private */
    public boolean tryCaptureViewForDrag(View view, int i) {
        if (view == this.mCapturedView && this.mActivePointerId == i) {
            return true;
        }
        if (view == null || !this.mCallback.tryCaptureView(view, i)) {
            return false;
        }
        this.mActivePointerId = i;
        captureChildView(view, i);
        return true;
    }
}
