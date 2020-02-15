package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.A;
import com.bumptech.glide.load.engine.bitmap_recycle.b;
import com.bumptech.glide.load.engine.bitmap_recycle.d;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.util.e;
import com.bumptech.glide.util.i;
import com.bumptech.glide.util.l;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/* compiled from: Downsampler */
public final class o {
    private static final int Pd = 10485760;
    static final String TAG = "Downsampler";
    public static final f<DecodeFormat> hj = f.a("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.DEFAULT);
    @Deprecated
    public static final f<DownsampleStrategy> ij = DownsampleStrategy.fj;
    public static final f<Boolean> jj = f.a("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", false);
    public static final f<Boolean> kj = f.s("com.bumtpech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode");
    private static final String lj = "image/vnd.wap.wbmp";
    private static final String mj = "image/x-ico";
    private static final Set<String> nj = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{lj, mj})));
    private static final a oj = new n();
    private static final Set<ImageHeaderParser.ImageType> pj = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
    private static final Queue<BitmapFactory.Options> qj = l.createQueue(0);
    private final d Eb;
    private final b de;
    private final DisplayMetrics eh;
    private final t gj = t.getInstance();
    private final List<ImageHeaderParser> te;

    /* compiled from: Downsampler */
    public interface a {
        void I();

        void a(d dVar, Bitmap bitmap) throws IOException;
    }

    public o(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, d dVar, b bVar) {
        this.te = list;
        i.checkNotNull(displayMetrics);
        this.eh = displayMetrics;
        i.checkNotNull(dVar);
        this.Eb = dVar;
        i.checkNotNull(bVar);
        this.de = bVar;
    }

    private Bitmap a(InputStream inputStream, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, boolean z, int i, int i2, boolean z2, a aVar) throws IOException {
        o oVar;
        int i3;
        int i4;
        int i5;
        InputStream inputStream2 = inputStream;
        BitmapFactory.Options options2 = options;
        a aVar2 = aVar;
        long Hj = e.Hj();
        int[] b2 = b(inputStream2, options2, aVar2, this.Eb);
        boolean z3 = false;
        int i6 = b2[0];
        int i7 = b2[1];
        String str = options2.outMimeType;
        boolean z4 = (i6 == -1 || i7 == -1) ? false : z;
        int a2 = com.bumptech.glide.load.b.a(this.te, inputStream2, this.de);
        int A = y.A(a2);
        boolean B = y.B(a2);
        int i8 = i;
        int i9 = i2;
        int i10 = i8 == Integer.MIN_VALUE ? i6 : i8;
        int i11 = i9 == Integer.MIN_VALUE ? i7 : i9;
        ImageHeaderParser.ImageType b3 = com.bumptech.glide.load.b.b(this.te, inputStream2, this.de);
        d dVar = this.Eb;
        ImageHeaderParser.ImageType imageType = b3;
        a(b3, inputStream, aVar, dVar, downsampleStrategy, A, i6, i7, i10, i11, options);
        int i12 = a2;
        String str2 = str;
        int i13 = i7;
        int i14 = i6;
        a aVar3 = aVar2;
        BitmapFactory.Options options3 = options2;
        a(inputStream, decodeFormat, z4, B, options, i10, i11);
        if (Build.VERSION.SDK_INT >= 19) {
            z3 = true;
        }
        if (options3.inSampleSize == 1 || z3) {
            oVar = this;
            if (oVar.a(imageType)) {
                if (i14 < 0 || i13 < 0 || !z2 || !z3) {
                    float f2 = b(options) ? ((float) options3.inTargetDensity) / ((float) options3.inDensity) : 1.0f;
                    float f3 = (float) options3.inSampleSize;
                    i5 = Math.round(((float) ((int) Math.ceil((double) (((float) i14) / f3)))) * f2);
                    i4 = Math.round(((float) ((int) Math.ceil((double) (((float) i13) / f3)))) * f2);
                    if (Log.isLoggable(TAG, 2)) {
                        Log.v(TAG, "Calculated target [" + i5 + "x" + i4 + "] for source [" + i14 + "x" + i13 + "], sampleSize: " + r4 + ", targetDensity: " + options3.inTargetDensity + ", density: " + options3.inDensity + ", density multiplier: " + f2);
                    }
                } else {
                    i5 = i10;
                    i4 = i11;
                }
                if (i5 > 0 && i4 > 0) {
                    a(options3, oVar.Eb, i5, i4);
                }
            }
        } else {
            oVar = this;
        }
        Bitmap a3 = a(inputStream, options3, aVar3, oVar.Eb);
        aVar3.a(oVar.Eb, a3);
        if (Log.isLoggable(TAG, 2)) {
            i3 = i12;
            a(i14, i13, str2, options, a3, i, i2, Hj);
        } else {
            i3 = i12;
        }
        Bitmap bitmap = null;
        if (a3 != null) {
            a3.setDensity(oVar.eh.densityDpi);
            bitmap = y.a(oVar.Eb, a3, i3);
            if (!a3.equals(bitmap)) {
                oVar.Eb.a(a3);
            }
        }
        return bitmap;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:23|24) */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x005d */
    private static Bitmap a(InputStream inputStream, BitmapFactory.Options options, a aVar, d dVar) throws IOException {
        if (options.inJustDecodeBounds) {
            inputStream.mark(Pd);
        } else {
            aVar.I();
        }
        int i = options.outWidth;
        int i2 = options.outHeight;
        String str = options.outMimeType;
        y.Hi().lock();
        try {
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, (Rect) null, options);
            y.Hi().unlock();
            if (options.inJustDecodeBounds) {
                inputStream.reset();
            }
            return decodeStream;
        } catch (IllegalArgumentException e2) {
            IOException a2 = a(e2, i, i2, str, options);
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Failed to decode with inBitmap, trying again without Bitmap re-use", a2);
            }
            if (options.inBitmap != null) {
                inputStream.reset();
                dVar.a(options.inBitmap);
                options.inBitmap = null;
                Bitmap a3 = a(inputStream, options, aVar, dVar);
                y.Hi().unlock();
                return a3;
            }
            throw a2;
        } catch (Throwable th) {
            y.Hi().unlock();
            throw th;
        }
    }

    private static IOException a(IllegalArgumentException illegalArgumentException, int i, int i2, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i + ", outHeight: " + i2 + ", outMimeType: " + str + ", inBitmap: " + a(options), illegalArgumentException);
    }

    private static String a(BitmapFactory.Options options) {
        return k(options.inBitmap);
    }

    private static void a(int i, int i2, String str, BitmapFactory.Options options, Bitmap bitmap, int i3, int i4, long j) {
        Log.v(TAG, "Decoded " + k(bitmap) + " from [" + i + "x" + i2 + "] " + str + " with inBitmap " + a(options) + " for [" + i3 + "x" + i4 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + e.g(j));
    }

    @TargetApi(26)
    private static void a(BitmapFactory.Options options, d dVar, int i, int i2) {
        Bitmap.Config config;
        if (Build.VERSION.SDK_INT < 26) {
            config = null;
        } else if (options.inPreferredConfig != Bitmap.Config.HARDWARE) {
            config = options.outConfig;
        } else {
            return;
        }
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = dVar.c(i, i2, config);
    }

    private static void a(ImageHeaderParser.ImageType imageType, InputStream inputStream, a aVar, d dVar, DownsampleStrategy downsampleStrategy, int i, int i2, int i3, int i4, int i5, BitmapFactory.Options options) throws IOException {
        int i6;
        int i7;
        int i8;
        double d2;
        ImageHeaderParser.ImageType imageType2 = imageType;
        DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
        int i9 = i;
        int i10 = i2;
        int i11 = i3;
        int i12 = i4;
        int i13 = i5;
        BitmapFactory.Options options2 = options;
        if (i10 <= 0 || i11 <= 0) {
            String str = TAG;
            String str2 = "x";
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Unable to determine dimensions for: " + imageType2 + " with target [" + i12 + str2 + i13 + "]");
                return;
            }
            return;
        }
        float b2 = (i9 == 90 || i9 == 270) ? downsampleStrategy2.b(i11, i10, i12, i13) : downsampleStrategy2.b(i10, i11, i12, i13);
        if (b2 > 0.0f) {
            DownsampleStrategy.SampleSizeRounding a2 = downsampleStrategy2.a(i10, i11, i12, i13);
            if (a2 != null) {
                float f2 = (float) i10;
                int round = round((double) (b2 * f2));
                float f3 = (float) i11;
                String str3 = TAG;
                String str4 = "x";
                int i14 = i10 / round;
                int round2 = i11 / round((double) (b2 * f3));
                int max = a2 == DownsampleStrategy.SampleSizeRounding.MEMORY ? Math.max(i14, round2) : Math.min(i14, round2);
                if (Build.VERSION.SDK_INT > 23 || !nj.contains(options2.outMimeType)) {
                    int max2 = Math.max(1, Integer.highestOneBit(max));
                    i6 = (a2 != DownsampleStrategy.SampleSizeRounding.MEMORY || ((float) max2) >= 1.0f / b2) ? max2 : max2 << 1;
                } else {
                    i6 = 1;
                }
                options2.inSampleSize = i6;
                if (imageType2 == ImageHeaderParser.ImageType.JPEG) {
                    float min = (float) Math.min(i6, 8);
                    i7 = (int) Math.ceil((double) (f2 / min));
                    i8 = (int) Math.ceil((double) (f3 / min));
                    int i15 = i6 / 8;
                    if (i15 > 0) {
                        i7 /= i15;
                        i8 /= i15;
                    }
                } else {
                    if (imageType2 == ImageHeaderParser.ImageType.PNG || imageType2 == ImageHeaderParser.ImageType.PNG_A) {
                        float f4 = (float) i6;
                        i7 = (int) Math.floor((double) (f2 / f4));
                        d2 = Math.floor((double) (f3 / f4));
                    } else if (imageType2 == ImageHeaderParser.ImageType.WEBP || imageType2 == ImageHeaderParser.ImageType.WEBP_A) {
                        if (Build.VERSION.SDK_INT >= 24) {
                            float f5 = (float) i6;
                            i7 = Math.round(f2 / f5);
                            i8 = Math.round(f3 / f5);
                        } else {
                            float f6 = (float) i6;
                            i7 = (int) Math.floor((double) (f2 / f6));
                            d2 = Math.floor((double) (f3 / f6));
                        }
                    } else if (i10 % i6 == 0 && i11 % i6 == 0) {
                        i7 = i10 / i6;
                        i8 = i11 / i6;
                    } else {
                        int[] b3 = b(inputStream, options2, aVar, dVar);
                        int i16 = b3[0];
                        i8 = b3[1];
                        i7 = i16;
                    }
                    i8 = (int) d2;
                }
                double b4 = (double) downsampleStrategy2.b(i7, i8, i12, i13);
                if (Build.VERSION.SDK_INT >= 19) {
                    options2.inTargetDensity = b(b4);
                    options2.inDensity = c(b4);
                }
                if (b(options)) {
                    options2.inScaled = true;
                } else {
                    options2.inTargetDensity = 0;
                    options2.inDensity = 0;
                }
                String str5 = str3;
                if (Log.isLoggable(str5, 2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Calculate scaling, source: [");
                    sb.append(i10);
                    String str6 = str4;
                    sb.append(str6);
                    sb.append(i11);
                    sb.append("], target: [");
                    sb.append(i12);
                    sb.append(str6);
                    sb.append(i13);
                    sb.append("], power of two scaled: [");
                    sb.append(i7);
                    sb.append(str6);
                    sb.append(i8);
                    sb.append("], exact scale factor: ");
                    sb.append(b2);
                    sb.append(", power of 2 sample size: ");
                    sb.append(i6);
                    sb.append(", adjusted scale factor: ");
                    sb.append(b4);
                    sb.append(", target density: ");
                    sb.append(options2.inTargetDensity);
                    sb.append(", density: ");
                    sb.append(options2.inDensity);
                    Log.v(str5, sb.toString());
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Cannot round with null rounding");
        }
        String str7 = "x";
        throw new IllegalArgumentException("Cannot scale with factor: " + b2 + " from: " + downsampleStrategy2 + ", source: [" + i10 + str7 + i11 + "], target: [" + i12 + str7 + i13 + "]");
    }

    private void a(InputStream inputStream, DecodeFormat decodeFormat, boolean z, boolean z2, BitmapFactory.Options options, int i, int i2) {
        if (!this.gj.a(i, i2, options, decodeFormat, z, z2)) {
            if (decodeFormat == DecodeFormat.PREFER_ARGB_8888 || decodeFormat == DecodeFormat.PREFER_ARGB_8888_DISALLOW_HARDWARE || Build.VERSION.SDK_INT == 16) {
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                return;
            }
            boolean z3 = false;
            try {
                z3 = com.bumptech.glide.load.b.b(this.te, inputStream, this.de).hasAlpha();
            } catch (IOException e2) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Cannot determine whether the image has alpha or not from header, format " + decodeFormat, e2);
                }
            }
            options.inPreferredConfig = z3 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
            if (options.inPreferredConfig == Bitmap.Config.RGB_565) {
                options.inDither = true;
            }
        }
    }

    private boolean a(ImageHeaderParser.ImageType imageType) {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return pj.contains(imageType);
    }

    private static int b(double d2) {
        int c2 = c(d2);
        int round = round(((double) c2) * d2);
        return round((d2 / ((double) (((float) round) / ((float) c2)))) * ((double) round));
    }

    private static boolean b(BitmapFactory.Options options) {
        int i = options.inTargetDensity;
        if (i > 0) {
            int i2 = options.inDensity;
            return i2 > 0 && i != i2;
        }
    }

    private static int[] b(InputStream inputStream, BitmapFactory.Options options, a aVar, d dVar) throws IOException {
        options.inJustDecodeBounds = true;
        a(inputStream, options, aVar, dVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private static int c(double d2) {
        if (d2 > 1.0d) {
            d2 = 1.0d / d2;
        }
        return (int) Math.round(d2 * 2.147483647E9d);
    }

    private static void c(BitmapFactory.Options options) {
        d(options);
        synchronized (qj) {
            qj.offer(options);
        }
    }

    private static void d(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    @Nullable
    @TargetApi(19)
    private static String k(Bitmap bitmap) {
        String str;
        if (bitmap == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            str = " (" + bitmap.getAllocationByteCount() + ")";
        } else {
            str = "";
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + str;
    }

    private static synchronized BitmapFactory.Options nm() {
        BitmapFactory.Options poll;
        synchronized (o.class) {
            synchronized (qj) {
                poll = qj.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                d(poll);
            }
        }
        return poll;
    }

    private static int round(double d2) {
        return (int) (d2 + 0.5d);
    }

    public A<Bitmap> a(InputStream inputStream, int i, int i2, g gVar) throws IOException {
        return a(inputStream, i, i2, gVar, oj);
    }

    public A<Bitmap> a(InputStream inputStream, int i, int i2, g gVar, a aVar) throws IOException {
        g gVar2 = gVar;
        i.b(inputStream.markSupported(), "You must provide an InputStream that supports mark()");
        byte[] bArr = (byte[]) this.de.a(65536, byte[].class);
        BitmapFactory.Options nm = nm();
        nm.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) gVar2.a(hj);
        try {
            return f.a(a(inputStream, nm, (DownsampleStrategy) gVar2.a(DownsampleStrategy.fj), decodeFormat, decodeFormat == DecodeFormat.PREFER_ARGB_8888_DISALLOW_HARDWARE ? false : gVar2.a(kj) != null && ((Boolean) gVar2.a(kj)).booleanValue(), i, i2, ((Boolean) gVar2.a(jj)).booleanValue(), aVar), this.Eb);
        } finally {
            c(nm);
            this.de.put(bArr);
        }
    }

    public boolean b(ByteBuffer byteBuffer) {
        return true;
    }

    public boolean h(InputStream inputStream) {
        return true;
    }
}
