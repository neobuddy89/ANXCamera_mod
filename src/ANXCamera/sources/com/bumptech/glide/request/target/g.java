package com.bumptech.glide.request.target;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import com.bumptech.glide.util.i;

/* compiled from: FixedSizeDrawable */
public class g extends Drawable {
    private final RectF Ha;
    private boolean Ia;
    private final RectF bounds;
    private final Matrix matrix;
    private a state;
    private Drawable ya;

    /* compiled from: FixedSizeDrawable */
    static final class a extends Drawable.ConstantState {
        final int height;
        final int width;
        private final Drawable.ConstantState ya;

        a(Drawable.ConstantState constantState, int i, int i2) {
            this.ya = constantState;
            this.width = i;
            this.height = i2;
        }

        a(a aVar) {
            this(aVar.ya, aVar.width, aVar.height);
        }

        public int getChangingConfigurations() {
            return 0;
        }

        @NonNull
        public Drawable newDrawable() {
            return new g(this, this.ya.newDrawable());
        }

        @NonNull
        public Drawable newDrawable(Resources resources) {
            return new g(this, this.ya.newDrawable(resources));
        }
    }

    public g(Drawable drawable, int i, int i2) {
        this(new a(drawable.getConstantState(), i, i2), drawable);
    }

    g(a aVar, Drawable drawable) {
        i.checkNotNull(aVar);
        this.state = aVar;
        i.checkNotNull(drawable);
        this.ya = drawable;
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.matrix = new Matrix();
        this.Ha = new RectF(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
        this.bounds = new RectF();
    }

    private void Al() {
        this.matrix.setRectToRect(this.Ha, this.bounds, Matrix.ScaleToFit.CENTER);
    }

    public void clearColorFilter() {
        this.ya.clearColorFilter();
    }

    public void draw(@NonNull Canvas canvas) {
        canvas.save();
        canvas.concat(this.matrix);
        this.ya.draw(canvas);
        canvas.restore();
    }

    @RequiresApi(19)
    public int getAlpha() {
        return this.ya.getAlpha();
    }

    public Drawable.Callback getCallback() {
        return this.ya.getCallback();
    }

    public int getChangingConfigurations() {
        return this.ya.getChangingConfigurations();
    }

    public Drawable.ConstantState getConstantState() {
        return this.state;
    }

    @NonNull
    public Drawable getCurrent() {
        return this.ya.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.state.height;
    }

    public int getIntrinsicWidth() {
        return this.state.width;
    }

    public int getMinimumHeight() {
        return this.ya.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.ya.getMinimumWidth();
    }

    public int getOpacity() {
        return this.ya.getOpacity();
    }

    public boolean getPadding(@NonNull Rect rect) {
        return this.ya.getPadding(rect);
    }

    public void invalidateSelf() {
        super.invalidateSelf();
        this.ya.invalidateSelf();
    }

    @NonNull
    public Drawable mutate() {
        if (!this.Ia && super.mutate() == this) {
            this.ya = this.ya.mutate();
            this.state = new a(this.state);
            this.Ia = true;
        }
        return this;
    }

    public void scheduleSelf(@NonNull Runnable runnable, long j) {
        super.scheduleSelf(runnable, j);
        this.ya.scheduleSelf(runnable, j);
    }

    public void setAlpha(int i) {
        this.ya.setAlpha(i);
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        this.bounds.set((float) i, (float) i2, (float) i3, (float) i4);
        Al();
    }

    public void setBounds(@NonNull Rect rect) {
        super.setBounds(rect);
        this.bounds.set(rect);
        Al();
    }

    public void setChangingConfigurations(int i) {
        this.ya.setChangingConfigurations(i);
    }

    public void setColorFilter(int i, @NonNull PorterDuff.Mode mode) {
        this.ya.setColorFilter(i, mode);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.ya.setColorFilter(colorFilter);
    }

    @Deprecated
    public void setDither(boolean z) {
        this.ya.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.ya.setFilterBitmap(z);
    }

    public boolean setVisible(boolean z, boolean z2) {
        return this.ya.setVisible(z, z2);
    }

    public void unscheduleSelf(@NonNull Runnable runnable) {
        super.unscheduleSelf(runnable);
        this.ya.unscheduleSelf(runnable);
    }
}
