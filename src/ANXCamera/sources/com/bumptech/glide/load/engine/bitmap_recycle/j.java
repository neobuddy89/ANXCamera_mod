package com.bumptech.glide.load.engine.bitmap_recycle;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: LruBitmapPool */
public class j implements d {
    private static final Bitmap.Config DEFAULT_CONFIG = Bitmap.Config.ARGB_8888;
    private static final String TAG = "LruBitmapPool";
    private long currentSize;
    private long maxSize;
    private final Set<Bitmap.Config> sg;
    private final k strategy;
    private final long tg;
    private final a ug;
    private int vg;
    private int wg;
    private int xg;
    private int yg;

    /* compiled from: LruBitmapPool */
    private interface a {
        void b(Bitmap bitmap);

        void f(Bitmap bitmap);
    }

    /* compiled from: LruBitmapPool */
    private static final class b implements a {
        b() {
        }

        public void b(Bitmap bitmap) {
        }

        public void f(Bitmap bitmap) {
        }
    }

    /* compiled from: LruBitmapPool */
    private static class c implements a {
        private final Set<Bitmap> rg = Collections.synchronizedSet(new HashSet());

        private c() {
        }

        public void b(Bitmap bitmap) {
            if (!this.rg.contains(bitmap)) {
                this.rg.add(bitmap);
                return;
            }
            throw new IllegalStateException("Can't add already added bitmap: " + bitmap + " [" + bitmap.getWidth() + "x" + bitmap.getHeight() + "]");
        }

        public void f(Bitmap bitmap) {
            if (this.rg.contains(bitmap)) {
                this.rg.remove(bitmap);
                return;
            }
            throw new IllegalStateException("Cannot remove bitmap not in tracker");
        }
    }

    public j(long j) {
        this(j, am(), _l());
    }

    j(long j, k kVar, Set<Bitmap.Config> set) {
        this.tg = j;
        this.maxSize = j;
        this.strategy = kVar;
        this.sg = set;
        this.ug = new b();
    }

    public j(long j, Set<Bitmap.Config> set) {
        this(j, am(), set);
    }

    private void Xl() {
        h(this.maxSize);
    }

    private void Zl() {
        Log.v(TAG, "Hits=" + this.vg + ", misses=" + this.wg + ", puts=" + this.xg + ", evictions=" + this.yg + ", currentSize=" + this.currentSize + ", maxSize=" + this.maxSize + "\nStrategy=" + this.strategy);
    }

    @TargetApi(26)
    private static Set<Bitmap.Config> _l() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        if (Build.VERSION.SDK_INT >= 19) {
            hashSet.add((Object) null);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private static k am() {
        return Build.VERSION.SDK_INT >= 19 ? new SizeConfigStrategy() : new AttributeStrategy();
    }

    @TargetApi(26)
    private static void b(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
    }

    @NonNull
    private static Bitmap createBitmap(int i, int i2, @Nullable Bitmap.Config config) {
        if (config == null) {
            config = DEFAULT_CONFIG;
        }
        return Bitmap.createBitmap(i, i2, config);
    }

    private void dump() {
        if (Log.isLoggable(TAG, 2)) {
            Zl();
        }
    }

    @Nullable
    private synchronized Bitmap h(int i, int i2, @Nullable Bitmap.Config config) {
        Bitmap d2;
        b(config);
        d2 = this.strategy.d(i, i2, config != null ? config : DEFAULT_CONFIG);
        if (d2 == null) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Missing bitmap=" + this.strategy.b(i, i2, config));
            }
            this.wg++;
        } else {
            this.vg++;
            this.currentSize -= (long) this.strategy.c(d2);
            this.ug.f(d2);
            m(d2);
        }
        if (Log.isLoggable(TAG, 2)) {
            Log.v(TAG, "Get bitmap=" + this.strategy.b(i, i2, config));
        }
        dump();
        return d2;
    }

    private synchronized void h(long j) {
        while (this.currentSize > j) {
            Bitmap removeLast = this.strategy.removeLast();
            if (removeLast == null) {
                if (Log.isLoggable(TAG, 5)) {
                    Log.w(TAG, "Size mismatch, resetting");
                    Zl();
                }
                this.currentSize = 0;
                return;
            }
            this.ug.f(removeLast);
            this.currentSize -= (long) this.strategy.c(removeLast);
            this.yg++;
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Evicting bitmap=" + this.strategy.e(removeLast));
            }
            dump();
            removeLast.recycle();
        }
    }

    @TargetApi(19)
    private static void l(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 19) {
            bitmap.setPremultiplied(true);
        }
    }

    private static void m(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        l(bitmap);
    }

    public void V() {
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "clearMemory");
        }
        h(0);
    }

    public synchronized void a(float f2) {
        this.maxSize = (long) Math.round(((float) this.tg) * f2);
        Xl();
    }

    public synchronized void a(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    if (bitmap.isMutable() && ((long) this.strategy.c(bitmap)) <= this.maxSize) {
                        if (this.sg.contains(bitmap.getConfig())) {
                            int c2 = this.strategy.c(bitmap);
                            this.strategy.a(bitmap);
                            this.ug.b(bitmap);
                            this.xg++;
                            this.currentSize += (long) c2;
                            if (Log.isLoggable(TAG, 2)) {
                                Log.v(TAG, "Put bitmap in pool=" + this.strategy.e(bitmap));
                            }
                            dump();
                            Xl();
                            return;
                        }
                    }
                    if (Log.isLoggable(TAG, 2)) {
                        Log.v(TAG, "Reject bitmap from pool, bitmap: " + this.strategy.e(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.sg.contains(bitmap.getConfig()));
                    }
                    bitmap.recycle();
                    return;
                }
                throw new IllegalStateException("Cannot pool recycled bitmap");
            } catch (Throwable th) {
                throw th;
            }
        } else {
            throw new NullPointerException("Bitmap must not be null");
        }
    }

    @NonNull
    public Bitmap c(int i, int i2, Bitmap.Config config) {
        Bitmap h = h(i, i2, config);
        return h == null ? createBitmap(i, i2, config) : h;
    }

    @NonNull
    public Bitmap d(int i, int i2, Bitmap.Config config) {
        Bitmap h = h(i, i2, config);
        if (h == null) {
            return createBitmap(i, i2, config);
        }
        h.eraseColor(0);
        return h;
    }

    public long getMaxSize() {
        return this.maxSize;
    }

    @SuppressLint({"InlinedApi"})
    public void trimMemory(int i) {
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "trimMemory, level=" + i);
        }
        if (i >= 40) {
            V();
        } else if (i >= 20 || i == 15) {
            h(getMaxSize() / 2);
        }
    }
}
