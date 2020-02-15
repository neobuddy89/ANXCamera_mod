package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.view.Gravity;
import com.bumptech.glide.c;
import com.bumptech.glide.load.engine.bitmap_recycle.d;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.resource.gif.GifFrameLoader;
import com.bumptech.glide.util.i;
import java.nio.ByteBuffer;

/* compiled from: GifDrawable */
public class b extends Drawable implements GifFrameLoader.a, Animatable {
    public static final int Fa = -1;
    private static final int GRAVITY = 119;
    public static final int Ga = 0;
    private boolean Aa;
    private boolean Ba;
    private int Ca;
    private boolean Da;
    private Rect Ea;
    private boolean isRunning;
    private int loopCount;
    private Paint paint;
    private final a state;
    private boolean za;

    /* compiled from: GifDrawable */
    static final class a extends Drawable.ConstantState {
        @VisibleForTesting
        final GifFrameLoader frameLoader;

        a(GifFrameLoader gifFrameLoader) {
            this.frameLoader = gifFrameLoader;
        }

        public int getChangingConfigurations() {
            return 0;
        }

        @NonNull
        public Drawable newDrawable() {
            return new b(this);
        }

        @NonNull
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }
    }

    @Deprecated
    public b(Context context, com.bumptech.glide.b.a aVar, d dVar, j<Bitmap> jVar, int i, int i2, Bitmap bitmap) {
        this(context, aVar, jVar, i, i2, bitmap);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public b(Context context, com.bumptech.glide.b.a aVar, j<Bitmap> jVar, int i, int i2, Bitmap bitmap) {
        this(new a(r1));
        GifFrameLoader gifFrameLoader = new GifFrameLoader(c.get(context), aVar, i, i2, jVar, bitmap);
    }

    @VisibleForTesting
    b(GifFrameLoader gifFrameLoader, Paint paint2) {
        this(new a(gifFrameLoader));
        this.paint = paint2;
    }

    b(a aVar) {
        this.Ba = true;
        this.Ca = -1;
        i.checkNotNull(aVar);
        this.state = aVar;
    }

    private Paint getPaint() {
        if (this.paint == null) {
            this.paint = new Paint(2);
        }
        return this.paint;
    }

    private void stopRunning() {
        this.isRunning = false;
        this.state.frameLoader.b(this);
    }

    private Drawable.Callback wl() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        return callback;
    }

    private Rect xl() {
        if (this.Ea == null) {
            this.Ea = new Rect();
        }
        return this.Ea;
    }

    private void yl() {
        this.loopCount = 0;
    }

    private void zl() {
        i.b(!this.Aa, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.state.frameLoader.getFrameCount() == 1) {
            invalidateSelf();
        } else if (!this.isRunning) {
            this.isRunning = true;
            this.state.frameLoader.a(this);
            invalidateSelf();
        }
    }

    public void B() {
        if (wl() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (pa() == getFrameCount() - 1) {
            this.loopCount++;
        }
        int i = this.Ca;
        if (i != -1 && this.loopCount >= i) {
            stop();
        }
    }

    public void a(j<Bitmap> jVar, Bitmap bitmap) {
        this.state.frameLoader.a(jVar, bitmap);
    }

    public void draw(@NonNull Canvas canvas) {
        if (!this.Aa) {
            if (this.Da) {
                Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), xl());
                this.Da = false;
            }
            canvas.drawBitmap(this.state.frameLoader.Ii(), (Rect) null, xl(), getPaint());
        }
    }

    public ByteBuffer getBuffer() {
        return this.state.frameLoader.getBuffer();
    }

    public Drawable.ConstantState getConstantState() {
        return this.state;
    }

    public int getFrameCount() {
        return this.state.frameLoader.getFrameCount();
    }

    public int getIntrinsicHeight() {
        return this.state.frameLoader.getHeight();
    }

    public int getIntrinsicWidth() {
        return this.state.frameLoader.getWidth();
    }

    public int getOpacity() {
        return -2;
    }

    public int getSize() {
        return this.state.frameLoader.getSize();
    }

    /* access modifiers changed from: package-private */
    public void i(boolean z) {
        this.isRunning = z;
    }

    /* access modifiers changed from: package-private */
    public boolean isRecycled() {
        return this.Aa;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    public Bitmap oa() {
        return this.state.frameLoader.oa();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.Da = true;
    }

    public int pa() {
        return this.state.frameLoader.getCurrentIndex();
    }

    public j<Bitmap> qa() {
        return this.state.frameLoader.qa();
    }

    public void ra() {
        i.b(!this.isRunning, "You cannot restart a currently running animation.");
        this.state.frameLoader.Ji();
        start();
    }

    public void recycle() {
        this.Aa = true;
        this.state.frameLoader.clear();
    }

    public void setAlpha(int i) {
        getPaint().setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        getPaint().setColorFilter(colorFilter);
    }

    public void setLoopCount(int i) {
        if (i <= 0 && i != -1 && i != 0) {
            throw new IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
        } else if (i == 0) {
            int loopCount2 = this.state.frameLoader.getLoopCount();
            if (loopCount2 == 0) {
                loopCount2 = -1;
            }
            this.Ca = loopCount2;
        } else {
            this.Ca = i;
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        i.b(!this.Aa, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.Ba = z;
        if (!z) {
            stopRunning();
        } else if (this.za) {
            zl();
        }
        return super.setVisible(z, z2);
    }

    public void start() {
        this.za = true;
        yl();
        if (this.Ba) {
            zl();
        }
    }

    public void stop() {
        this.za = false;
        stopRunning();
    }
}
