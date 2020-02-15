package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.a.c;
import com.bumptech.glide.load.engine.A;
import com.bumptech.glide.load.engine.bitmap_recycle.b;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.i;
import com.bumptech.glide.util.l;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: BitmapEncoder */
public class e implements i<Bitmap> {
    public static final f<Integer> Bi = f.a("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);
    public static final f<Bitmap.CompressFormat> Ci = f.s("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");
    private static final String TAG = "BitmapEncoder";
    @Nullable
    private final b ra;

    @Deprecated
    public e() {
        this.ra = null;
    }

    public e(@NonNull b bVar) {
        this.ra = bVar;
    }

    private Bitmap.CompressFormat b(Bitmap bitmap, g gVar) {
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) gVar.a(Ci);
        return compressFormat != null ? compressFormat : bitmap.hasAlpha() ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
    }

    @NonNull
    public EncodeStrategy a(@NonNull g gVar) {
        return EncodeStrategy.TRANSFORMED;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:21|(2:37|38)|39|40) */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005f, code lost:
        if (r6 == null) goto L_0x0062;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00b5 */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005a A[Catch:{ all -> 0x0050 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b2 A[SYNTHETIC, Splitter:B:37:0x00b2] */
    public boolean a(@NonNull A<Bitmap> a2, @NonNull File file, @NonNull g gVar) {
        Bitmap bitmap = a2.get();
        Bitmap.CompressFormat b2 = b(bitmap, gVar);
        Integer.valueOf(bitmap.getWidth());
        Integer.valueOf(bitmap.getHeight());
        long Hj = com.bumptech.glide.util.e.Hj();
        int intValue = ((Integer) gVar.a(Bi)).intValue();
        boolean z = false;
        c cVar = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                cVar = this.ra != null ? new c(fileOutputStream, this.ra) : fileOutputStream;
                bitmap.compress(b2, intValue, cVar);
                cVar.close();
                z = true;
            } catch (IOException e2) {
                e = e2;
                cVar = fileOutputStream;
                try {
                    if (Log.isLoggable(TAG, 3)) {
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cVar != null) {
                        cVar.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                cVar = fileOutputStream;
                if (cVar != null) {
                }
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Failed to encode Bitmap", e);
            }
        }
        try {
            cVar.close();
        } catch (IOException unused) {
        }
        if (Log.isLoggable(TAG, 2)) {
            Log.v(TAG, "Compressed with type: " + b2 + " of size " + l.j(bitmap) + " in " + com.bumptech.glide.util.e.g(Hj) + ", options format: " + gVar.a(Ci) + ", hasAlpha: " + bitmap.hasAlpha());
        }
        return z;
    }
}
