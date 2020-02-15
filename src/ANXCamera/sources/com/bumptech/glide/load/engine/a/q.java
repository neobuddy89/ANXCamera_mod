package com.bumptech.glide.load.engine.a;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.support.annotation.VisibleForTesting;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.util.i;

/* compiled from: MemorySizeCalculator */
public final class q {
    @VisibleForTesting
    static final int BYTES_PER_ARGB_8888_PIXEL = 4;
    private static final String TAG = "MemorySizeCalculator";
    private static final int jh = 2;
    private final Context context;
    private final int fh;
    private final int gh;
    private final int hh;

    /* compiled from: MemorySizeCalculator */
    public static final class a {
        @VisibleForTesting
        static final int MEMORY_CACHE_TARGET_SCREENS = 2;
        static final int Zg = (Build.VERSION.SDK_INT < 26 ? 4 : 1);
        static final float _g = 0.4f;
        static final float bh = 0.33f;
        static final int dh = 4194304;
        ActivityManager Tg;
        float Ug = 2.0f;
        float Vg = ((float) Zg);
        float Wg = 0.4f;
        float Xg = bh;
        int Yg = 4194304;
        final Context context;
        c screenDimensions;

        public a(Context context2) {
            this.context = context2;
            this.Tg = (ActivityManager) context2.getSystemService("activity");
            this.screenDimensions = new b(context2.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT >= 26 && q.a(this.Tg)) {
                this.Vg = 0.0f;
            }
        }

        public q build() {
            return new q(this);
        }

        public a c(float f2) {
            i.b(f2 >= 0.0f, "Bitmap pool screens must be greater than or equal to 0");
            this.Vg = f2;
            return this;
        }

        public a d(float f2) {
            i.b(f2 >= 0.0f && f2 <= 1.0f, "Low memory max size multiplier must be between 0 and 1");
            this.Xg = f2;
            return this;
        }

        public a e(float f2) {
            i.b(f2 >= 0.0f && f2 <= 1.0f, "Size multiplier must be between 0 and 1");
            this.Wg = f2;
            return this;
        }

        public a f(float f2) {
            i.b(f2 >= 0.0f, "Memory cache screens must be greater than or equal to 0");
            this.Ug = f2;
            return this;
        }

        /* access modifiers changed from: package-private */
        @VisibleForTesting
        public a setActivityManager(ActivityManager activityManager) {
            this.Tg = activityManager;
            return this;
        }

        /* access modifiers changed from: package-private */
        @VisibleForTesting
        public a setScreenDimensions(c cVar) {
            this.screenDimensions = cVar;
            return this;
        }

        public a x(int i) {
            this.Yg = i;
            return this;
        }
    }

    /* compiled from: MemorySizeCalculator */
    private static final class b implements c {
        private final DisplayMetrics eh;

        b(DisplayMetrics displayMetrics) {
            this.eh = displayMetrics;
        }

        public int E() {
            return this.eh.heightPixels;
        }

        public int P() {
            return this.eh.widthPixels;
        }
    }

    /* compiled from: MemorySizeCalculator */
    interface c {
        int E();

        int P();
    }

    q(a aVar) {
        this.context = aVar.context;
        this.hh = a(aVar.Tg) ? aVar.Yg / 2 : aVar.Yg;
        int a2 = a(aVar.Tg, aVar.Wg, aVar.Xg);
        float P = (float) (aVar.screenDimensions.P() * aVar.screenDimensions.E() * 4);
        int round = Math.round(aVar.Vg * P);
        int round2 = Math.round(P * aVar.Ug);
        int i = a2 - this.hh;
        int i2 = round2 + round;
        if (i2 <= i) {
            this.gh = round2;
            this.fh = round;
        } else {
            float f2 = (float) i;
            float f3 = aVar.Vg;
            float f4 = aVar.Ug;
            float f5 = f2 / (f3 + f4);
            this.gh = Math.round(f4 * f5);
            this.fh = Math.round(f5 * aVar.Vg);
        }
        if (Log.isLoggable(TAG, 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(W(this.gh));
            sb.append(", pool size: ");
            sb.append(W(this.fh));
            sb.append(", byte array size: ");
            sb.append(W(this.hh));
            sb.append(", memory class limited? ");
            sb.append(i2 > a2);
            sb.append(", max size: ");
            sb.append(W(a2));
            sb.append(", memoryClass: ");
            sb.append(aVar.Tg.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(a(aVar.Tg));
            Log.d(TAG, sb.toString());
        }
    }

    private String W(int i) {
        return Formatter.formatFileSize(this.context, (long) i);
    }

    private static int a(ActivityManager activityManager, float f2, float f3) {
        boolean a2 = a(activityManager);
        float memoryClass = (float) (activityManager.getMemoryClass() * 1024 * 1024);
        if (a2) {
            f2 = f3;
        }
        return Math.round(memoryClass * f2);
    }

    @TargetApi(19)
    static boolean a(ActivityManager activityManager) {
        if (Build.VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return true;
    }

    public int xi() {
        return this.hh;
    }

    public int yi() {
        return this.fh;
    }

    public int zi() {
        return this.gh;
    }
}
