package com.bumptech.glide.request.target;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.bumptech.glide.request.c;
import com.bumptech.glide.util.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class ViewTarget<T extends View, Z> extends b<Z> {
    private static boolean Rl = false;
    @Nullable
    private static Integer Sl = null;
    private static final String TAG = "ViewTarget";
    private final SizeDeterminer Nl;
    @Nullable
    private View.OnAttachStateChangeListener Ol;
    private boolean Pl;
    private boolean Ql;
    protected final T view;

    @VisibleForTesting
    static final class SizeDeterminer {
        private static final int Xl = 0;
        @Nullable
        @VisibleForTesting
        static Integer maxDisplayLength;
        private final List<n> Df = new ArrayList();
        boolean Vl;
        @Nullable
        private a Wl;
        private final View view;

        private static final class a implements ViewTreeObserver.OnPreDrawListener {
            private final WeakReference<SizeDeterminer> Ul;

            a(@NonNull SizeDeterminer sizeDeterminer) {
                this.Ul = new WeakReference<>(sizeDeterminer);
            }

            public boolean onPreDraw() {
                if (Log.isLoggable(ViewTarget.TAG, 2)) {
                    Log.v(ViewTarget.TAG, "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                SizeDeterminer sizeDeterminer = (SizeDeterminer) this.Ul.get();
                if (sizeDeterminer == null) {
                    return true;
                }
                sizeDeterminer.Fj();
                return true;
            }
        }

        SizeDeterminer(@NonNull View view2) {
            this.view = view2;
        }

        private int Jm() {
            int paddingTop = this.view.getPaddingTop() + this.view.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
            return c(this.view.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        private int Km() {
            int paddingLeft = this.view.getPaddingLeft() + this.view.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
            return c(this.view.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        private static int M(@NonNull Context context) {
            if (maxDisplayLength == null) {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                i.checkNotNull(windowManager);
                Display defaultDisplay = windowManager.getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                maxDisplayLength = Integer.valueOf(Math.max(point.x, point.y));
            }
            return maxDisplayLength.intValue();
        }

        private boolean Z(int i) {
            return i > 0 || i == Integer.MIN_VALUE;
        }

        private int c(int i, int i2, int i3) {
            int i4 = i2 - i3;
            if (i4 > 0) {
                return i4;
            }
            if (this.Vl && this.view.isLayoutRequested()) {
                return 0;
            }
            int i5 = i - i3;
            if (i5 > 0) {
                return i5;
            }
            if (this.view.isLayoutRequested() || i2 != -2) {
                return 0;
            }
            if (Log.isLoggable(ViewTarget.TAG, 4)) {
                Log.i(ViewTarget.TAG, "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return M(this.view.getContext());
        }

        private boolean r(int i, int i2) {
            return Z(i) && Z(i2);
        }

        private void s(int i, int i2) {
            Iterator it = new ArrayList(this.Df).iterator();
            while (it.hasNext()) {
                ((n) it.next()).b(i, i2);
            }
        }

        /* access modifiers changed from: package-private */
        public void Fj() {
            if (!this.Df.isEmpty()) {
                int Km = Km();
                int Jm = Jm();
                if (r(Km, Jm)) {
                    s(Km, Jm);
                    Gj();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void Gj() {
            ViewTreeObserver viewTreeObserver = this.view.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.Wl);
            }
            this.Wl = null;
            this.Df.clear();
        }

        /* access modifiers changed from: package-private */
        public void a(@NonNull n nVar) {
            this.Df.remove(nVar);
        }

        /* access modifiers changed from: package-private */
        public void b(@NonNull n nVar) {
            int Km = Km();
            int Jm = Jm();
            if (r(Km, Jm)) {
                nVar.b(Km, Jm);
                return;
            }
            if (!this.Df.contains(nVar)) {
                this.Df.add(nVar);
            }
            if (this.Wl == null) {
                ViewTreeObserver viewTreeObserver = this.view.getViewTreeObserver();
                this.Wl = new a(this);
                viewTreeObserver.addOnPreDrawListener(this.Wl);
            }
        }
    }

    public ViewTarget(@NonNull T t) {
        i.checkNotNull(t);
        this.view = (View) t;
        this.Nl = new SizeDeterminer(t);
    }

    @Deprecated
    public ViewTarget(@NonNull T t, boolean z) {
        this(t);
        if (z) {
            Ej();
        }
    }

    private void Hm() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.Ol;
        if (onAttachStateChangeListener != null && !this.Ql) {
            this.view.addOnAttachStateChangeListener(onAttachStateChangeListener);
            this.Ql = true;
        }
    }

    private void Im() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.Ol;
        if (onAttachStateChangeListener != null && this.Ql) {
            this.view.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            this.Ql = false;
        }
    }

    public static void M(int i) {
        if (Sl != null || Rl) {
            throw new IllegalArgumentException("You cannot set the tag id more than once or change the tag id after the first request has been made");
        }
        Sl = Integer.valueOf(i);
    }

    @Nullable
    private Object getTag() {
        Integer num = Sl;
        return num == null ? this.view.getTag() : this.view.getTag(num.intValue());
    }

    private void setTag(@Nullable Object obj) {
        Integer num = Sl;
        if (num == null) {
            Rl = true;
            this.view.setTag(obj);
            return;
        }
        this.view.setTag(num.intValue(), obj);
    }

    @NonNull
    public final ViewTarget<T, Z> Bj() {
        if (this.Ol != null) {
            return this;
        }
        this.Ol = new q(this);
        Hm();
        return this;
    }

    /* access modifiers changed from: package-private */
    public void Cj() {
        c request = getRequest();
        if (request != null && !request.isCancelled() && !request.isPaused()) {
            this.Pl = true;
            request.pause();
            this.Pl = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void Dj() {
        c request = getRequest();
        if (request != null && request.isPaused()) {
            request.begin();
        }
    }

    @NonNull
    public final ViewTarget<T, Z> Ej() {
        this.Nl.Vl = true;
        return this;
    }

    @CallSuper
    public void a(@NonNull n nVar) {
        this.Nl.a(nVar);
    }

    @CallSuper
    public void b(@Nullable Drawable drawable) {
        super.b(drawable);
        this.Nl.Gj();
        if (!this.Pl) {
            Im();
        }
    }

    @CallSuper
    public void b(@NonNull n nVar) {
        this.Nl.b(nVar);
    }

    @CallSuper
    public void c(@Nullable Drawable drawable) {
        super.c(drawable);
        Hm();
    }

    public void f(@Nullable c cVar) {
        setTag(cVar);
    }

    @Nullable
    public c getRequest() {
        Object tag = getTag();
        if (tag == null) {
            return null;
        }
        if (tag instanceof c) {
            return (c) tag;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    @NonNull
    public T getView() {
        return this.view;
    }

    public String toString() {
        return "Target for: " + this.view;
    }
}
