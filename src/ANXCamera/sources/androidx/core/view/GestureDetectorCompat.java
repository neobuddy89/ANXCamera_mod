package androidx.core.view;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public final class GestureDetectorCompat {
    private final GestureDetectorCompatImpl mImpl;

    interface GestureDetectorCompatImpl {
        boolean isLongpressEnabled();

        boolean onTouchEvent(MotionEvent motionEvent);

        void setIsLongpressEnabled(boolean z);

        void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener);
    }

    static class GestureDetectorCompatImplBase implements GestureDetectorCompatImpl {
        private static final int DOUBLE_TAP_TIMEOUT = ViewConfiguration.getDoubleTapTimeout();
        private static final int LONGPRESS_TIMEOUT = ViewConfiguration.getLongPressTimeout();
        private static final int LONG_PRESS = 2;
        private static final int SHOW_PRESS = 1;
        private static final int TAP = 3;
        private static final int TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
        private boolean mAlwaysInBiggerTapRegion;
        private boolean mAlwaysInTapRegion;
        MotionEvent mCurrentDownEvent;
        boolean mDeferConfirmSingleTap;
        GestureDetector.OnDoubleTapListener mDoubleTapListener;
        private int mDoubleTapSlopSquare;
        private float mDownFocusX;
        private float mDownFocusY;
        private final Handler mHandler;
        private boolean mInLongPress;
        private boolean mIsDoubleTapping;
        private boolean mIsLongpressEnabled;
        private float mLastFocusX;
        private float mLastFocusY;
        final GestureDetector.OnGestureListener mListener;
        private int mMaximumFlingVelocity;
        private int mMinimumFlingVelocity;
        private MotionEvent mPreviousUpEvent;
        boolean mStillDown;
        private int mTouchSlopSquare;
        private VelocityTracker mVelocityTracker;

        private class GestureHandler extends Handler {
            GestureHandler() {
            }

            GestureHandler(Handler handler) {
                super(handler.getLooper());
            }

            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 1) {
                    GestureDetectorCompatImplBase.this.mListener.onShowPress(GestureDetectorCompatImplBase.this.mCurrentDownEvent);
                } else if (i == 2) {
                    GestureDetectorCompatImplBase.this.dispatchLongPress();
                } else if (i != 3) {
                    throw new RuntimeException("Unknown message " + message);
                } else if (GestureDetectorCompatImplBase.this.mDoubleTapListener == null) {
                } else {
                    if (!GestureDetectorCompatImplBase.this.mStillDown) {
                        GestureDetectorCompatImplBase.this.mDoubleTapListener.onSingleTapConfirmed(GestureDetectorCompatImplBase.this.mCurrentDownEvent);
                    } else {
                        GestureDetectorCompatImplBase.this.mDeferConfirmSingleTap = true;
                    }
                }
            }
        }

        GestureDetectorCompatImplBase(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            if (handler != null) {
                this.mHandler = new GestureHandler(handler);
            } else {
                this.mHandler = new GestureHandler();
            }
            this.mListener = onGestureListener;
            if (onGestureListener instanceof GestureDetector.OnDoubleTapListener) {
                setOnDoubleTapListener((GestureDetector.OnDoubleTapListener) onGestureListener);
            }
            init(context);
        }

        private void cancel() {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.removeMessages(3);
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
            this.mIsDoubleTapping = false;
            this.mStillDown = false;
            this.mAlwaysInTapRegion = false;
            this.mAlwaysInBiggerTapRegion = false;
            this.mDeferConfirmSingleTap = false;
            if (this.mInLongPress) {
                this.mInLongPress = false;
            }
        }

        private void cancelTaps() {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.removeMessages(3);
            this.mIsDoubleTapping = false;
            this.mAlwaysInTapRegion = false;
            this.mAlwaysInBiggerTapRegion = false;
            this.mDeferConfirmSingleTap = false;
            if (this.mInLongPress) {
                this.mInLongPress = false;
            }
        }

        private void init(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null");
            } else if (this.mListener != null) {
                this.mIsLongpressEnabled = true;
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
                int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
                this.mMinimumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
                this.mMaximumFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
                this.mTouchSlopSquare = scaledTouchSlop * scaledTouchSlop;
                this.mDoubleTapSlopSquare = scaledDoubleTapSlop * scaledDoubleTapSlop;
            } else {
                throw new IllegalArgumentException("OnGestureListener must not be null");
            }
        }

        private boolean isConsideredDoubleTap(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
            if (!this.mAlwaysInBiggerTapRegion || motionEvent3.getEventTime() - motionEvent2.getEventTime() > ((long) DOUBLE_TAP_TIMEOUT)) {
                return false;
            }
            int x = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
            int y = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
            return (x * x) + (y * y) < this.mDoubleTapSlopSquare;
        }

        /* access modifiers changed from: package-private */
        public void dispatchLongPress() {
            this.mHandler.removeMessages(3);
            this.mDeferConfirmSingleTap = false;
            this.mInLongPress = true;
            this.mListener.onLongPress(this.mCurrentDownEvent);
        }

        public boolean isLongpressEnabled() {
            return this.mIsLongpressEnabled;
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z;
            int i;
            int i2;
            MotionEvent motionEvent2 = motionEvent;
            int action = motionEvent.getAction();
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent2);
            boolean z2 = (action & 255) == 6;
            int actionIndex = z2 ? motionEvent.getActionIndex() : -1;
            float f2 = 0.0f;
            float f3 = 0.0f;
            int pointerCount = motionEvent.getPointerCount();
            for (int i3 = 0; i3 < pointerCount; i3++) {
                if (actionIndex != i3) {
                    f2 += motionEvent2.getX(i3);
                    f3 += motionEvent2.getY(i3);
                }
            }
            int i4 = z2 ? pointerCount - 1 : pointerCount;
            float f4 = f2 / ((float) i4);
            float f5 = f3 / ((float) i4);
            boolean z3 = false;
            int i5 = action & 255;
            if (i5 == 0) {
                int i6 = action;
                boolean z4 = z2;
                if (this.mDoubleTapListener != null) {
                    boolean hasMessages = this.mHandler.hasMessages(3);
                    if (hasMessages) {
                        this.mHandler.removeMessages(3);
                    }
                    MotionEvent motionEvent3 = this.mCurrentDownEvent;
                    if (motionEvent3 != null) {
                        MotionEvent motionEvent4 = this.mPreviousUpEvent;
                        if (motionEvent4 != null && hasMessages && isConsideredDoubleTap(motionEvent3, motionEvent4, motionEvent2)) {
                            this.mIsDoubleTapping = true;
                            z3 = this.mDoubleTapListener.onDoubleTap(this.mCurrentDownEvent) | false | this.mDoubleTapListener.onDoubleTapEvent(motionEvent2);
                        }
                    }
                    this.mHandler.sendEmptyMessageDelayed(3, (long) DOUBLE_TAP_TIMEOUT);
                }
                this.mLastFocusX = f4;
                this.mDownFocusX = f4;
                this.mLastFocusY = f5;
                this.mDownFocusY = f5;
                MotionEvent motionEvent5 = this.mCurrentDownEvent;
                if (motionEvent5 != null) {
                    motionEvent5.recycle();
                }
                this.mCurrentDownEvent = MotionEvent.obtain(motionEvent);
                this.mAlwaysInTapRegion = true;
                this.mAlwaysInBiggerTapRegion = true;
                this.mStillDown = true;
                this.mInLongPress = false;
                this.mDeferConfirmSingleTap = false;
                if (this.mIsLongpressEnabled) {
                    this.mHandler.removeMessages(2);
                    int i7 = actionIndex;
                    this.mHandler.sendEmptyMessageAtTime(2, this.mCurrentDownEvent.getDownTime() + ((long) TAP_TIMEOUT) + ((long) LONGPRESS_TIMEOUT));
                } else {
                    int i8 = actionIndex;
                }
                this.mHandler.sendEmptyMessageAtTime(1, this.mCurrentDownEvent.getDownTime() + ((long) TAP_TIMEOUT));
                return z3 | this.mListener.onDown(motionEvent2);
            } else if (i5 != 1) {
                if (i5 == 2) {
                    int i9 = action;
                    boolean z5 = z2;
                    if (!this.mInLongPress) {
                        float f6 = this.mLastFocusX - f4;
                        float f7 = this.mLastFocusY - f5;
                        if (this.mIsDoubleTapping) {
                            int i10 = actionIndex;
                            return false | this.mDoubleTapListener.onDoubleTapEvent(motionEvent2);
                        } else if (this.mAlwaysInTapRegion) {
                            int i11 = (int) (f4 - this.mDownFocusX);
                            int i12 = (int) (f5 - this.mDownFocusY);
                            int i13 = (i11 * i11) + (i12 * i12);
                            if (i13 > this.mTouchSlopSquare) {
                                int i14 = i11;
                                boolean onScroll = this.mListener.onScroll(this.mCurrentDownEvent, motionEvent2, f6, f7);
                                this.mLastFocusX = f4;
                                this.mLastFocusY = f5;
                                this.mAlwaysInTapRegion = false;
                                this.mHandler.removeMessages(3);
                                this.mHandler.removeMessages(1);
                                this.mHandler.removeMessages(2);
                                z3 = onScroll;
                            } else {
                                int i15 = i11;
                            }
                            if (i13 > this.mTouchSlopSquare) {
                                this.mAlwaysInBiggerTapRegion = false;
                            }
                            int i16 = actionIndex;
                            return z3;
                        } else if (Math.abs(f6) >= 1.0f || Math.abs(f7) >= 1.0f) {
                            boolean onScroll2 = this.mListener.onScroll(this.mCurrentDownEvent, motionEvent2, f6, f7);
                            this.mLastFocusX = f4;
                            this.mLastFocusY = f5;
                            int i17 = actionIndex;
                            return onScroll2;
                        }
                    }
                } else if (i5 == 3) {
                    int i18 = action;
                    boolean z6 = z2;
                    cancel();
                } else if (i5 != 5) {
                    if (i5 == 6) {
                        this.mLastFocusX = f4;
                        this.mDownFocusX = f4;
                        this.mLastFocusY = f5;
                        this.mDownFocusY = f5;
                        this.mVelocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumFlingVelocity);
                        int actionIndex2 = motionEvent.getActionIndex();
                        int pointerId = motionEvent2.getPointerId(actionIndex2);
                        float xVelocity = this.mVelocityTracker.getXVelocity(pointerId);
                        float yVelocity = this.mVelocityTracker.getYVelocity(pointerId);
                        int i19 = action;
                        int i20 = 0;
                        while (true) {
                            if (i20 >= pointerCount) {
                                boolean z7 = z2;
                                int i21 = actionIndex2;
                                int i22 = pointerId;
                                break;
                            }
                            if (i20 == actionIndex2) {
                                z = z2;
                                i2 = actionIndex2;
                                i = pointerId;
                            } else {
                                z = z2;
                                int pointerId2 = motionEvent2.getPointerId(i20);
                                i2 = actionIndex2;
                                i = pointerId;
                                if ((this.mVelocityTracker.getXVelocity(pointerId2) * xVelocity) + (this.mVelocityTracker.getYVelocity(pointerId2) * yVelocity) < 0.0f) {
                                    int i23 = pointerId2;
                                    this.mVelocityTracker.clear();
                                    break;
                                }
                                int i24 = pointerId2;
                            }
                            i20++;
                            actionIndex2 = i2;
                            pointerId = i;
                            z2 = z;
                        }
                    } else {
                        int i25 = action;
                        boolean z8 = z2;
                    }
                } else {
                    int i26 = action;
                    boolean z9 = z2;
                    this.mLastFocusX = f4;
                    this.mDownFocusX = f4;
                    this.mLastFocusY = f5;
                    this.mDownFocusY = f5;
                    cancelTaps();
                }
                int i27 = actionIndex;
                return false;
            } else {
                int i28 = action;
                boolean z10 = z2;
                this.mStillDown = false;
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                if (this.mIsDoubleTapping) {
                    z3 = false | this.mDoubleTapListener.onDoubleTapEvent(motionEvent2);
                } else if (this.mInLongPress) {
                    this.mHandler.removeMessages(3);
                    this.mInLongPress = false;
                } else if (this.mAlwaysInTapRegion) {
                    z3 = this.mListener.onSingleTapUp(motionEvent2);
                    if (this.mDeferConfirmSingleTap) {
                        GestureDetector.OnDoubleTapListener onDoubleTapListener = this.mDoubleTapListener;
                        if (onDoubleTapListener != null) {
                            onDoubleTapListener.onSingleTapConfirmed(motionEvent2);
                        }
                    }
                } else {
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    int pointerId3 = motionEvent2.getPointerId(0);
                    velocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumFlingVelocity);
                    float yVelocity2 = velocityTracker.getYVelocity(pointerId3);
                    float xVelocity2 = velocityTracker.getXVelocity(pointerId3);
                    VelocityTracker velocityTracker2 = velocityTracker;
                    if (Math.abs(yVelocity2) > ((float) this.mMinimumFlingVelocity) || Math.abs(xVelocity2) > ((float) this.mMinimumFlingVelocity)) {
                        z3 = this.mListener.onFling(this.mCurrentDownEvent, motionEvent2, xVelocity2, yVelocity2);
                    }
                }
                MotionEvent motionEvent6 = this.mPreviousUpEvent;
                if (motionEvent6 != null) {
                    motionEvent6.recycle();
                }
                this.mPreviousUpEvent = obtain;
                VelocityTracker velocityTracker3 = this.mVelocityTracker;
                if (velocityTracker3 != null) {
                    velocityTracker3.recycle();
                    this.mVelocityTracker = null;
                }
                this.mIsDoubleTapping = false;
                this.mDeferConfirmSingleTap = false;
                this.mHandler.removeMessages(1);
                this.mHandler.removeMessages(2);
                int i29 = actionIndex;
                return z3;
            }
        }

        public void setIsLongpressEnabled(boolean z) {
            this.mIsLongpressEnabled = z;
        }

        public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
            this.mDoubleTapListener = onDoubleTapListener;
        }
    }

    static class GestureDetectorCompatImplJellybeanMr2 implements GestureDetectorCompatImpl {
        private final GestureDetector mDetector;

        GestureDetectorCompatImplJellybeanMr2(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            this.mDetector = new GestureDetector(context, onGestureListener, handler);
        }

        public boolean isLongpressEnabled() {
            return this.mDetector.isLongpressEnabled();
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            return this.mDetector.onTouchEvent(motionEvent);
        }

        public void setIsLongpressEnabled(boolean z) {
            this.mDetector.setIsLongpressEnabled(z);
        }

        public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
            this.mDetector.setOnDoubleTapListener(onDoubleTapListener);
        }
    }

    public GestureDetectorCompat(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, (Handler) null);
    }

    public GestureDetectorCompat(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        if (Build.VERSION.SDK_INT > 17) {
            this.mImpl = new GestureDetectorCompatImplJellybeanMr2(context, onGestureListener, handler);
        } else {
            this.mImpl = new GestureDetectorCompatImplBase(context, onGestureListener, handler);
        }
    }

    public boolean isLongpressEnabled() {
        return this.mImpl.isLongpressEnabled();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mImpl.onTouchEvent(motionEvent);
    }

    public void setIsLongpressEnabled(boolean z) {
        this.mImpl.setIsLongpressEnabled(z);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.mImpl.setOnDoubleTapListener(onDoubleTapListener);
    }
}
