package com.bumptech.glide.load.resource.bitmap;

import android.support.annotation.NonNull;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.util.i;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* compiled from: DefaultImageHeaderParser */
public final class m implements ImageHeaderParser {
    private static final int Hi = 4671814;
    private static final int Ii = -1991225785;
    static final int Ji = 65496;
    private static final int Ki = 19789;
    private static final int Li = 18761;
    private static final String Mi = "Exif\u0000\u0000";
    static final byte[] Ni = Mi.getBytes(Charset.forName("UTF-8"));
    private static final int Oi = 218;
    private static final int Pi = 217;
    static final int Qi = 255;
    static final int Ri = 225;
    private static final int Si = 274;
    private static final String TAG = "DfltImageHeaderParser";
    private static final int[] Ti = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
    private static final int Ui = 1380533830;
    private static final int Vi = 1464156752;
    private static final int Wi = 1448097792;
    private static final int Xi = -256;
    private static final int Yi = 255;
    private static final int Zi = 88;
    private static final int _i = 76;
    private static final int bj = 16;
    private static final int cj = 8;

    /* compiled from: DefaultImageHeaderParser */
    private static final class a implements c {
        private final ByteBuffer byteBuffer;

        a(ByteBuffer byteBuffer2) {
            this.byteBuffer = byteBuffer2;
            byteBuffer2.order(ByteOrder.BIG_ENDIAN);
        }

        public int Q() {
            return (getByte() & 255) | ((getByte() << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK);
        }

        public short aa() {
            return (short) (getByte() & 255);
        }

        public int getByte() {
            if (this.byteBuffer.remaining() < 1) {
                return -1;
            }
            return this.byteBuffer.get();
        }

        public int read(byte[] bArr, int i) {
            int min = Math.min(i, this.byteBuffer.remaining());
            if (min == 0) {
                return -1;
            }
            this.byteBuffer.get(bArr, 0, min);
            return min;
        }

        public long skip(long j) {
            int min = (int) Math.min((long) this.byteBuffer.remaining(), j);
            ByteBuffer byteBuffer2 = this.byteBuffer;
            byteBuffer2.position(byteBuffer2.position() + min);
            return (long) min;
        }
    }

    /* compiled from: DefaultImageHeaderParser */
    private static final class b {
        private final ByteBuffer data;

        b(byte[] bArr, int i) {
            this.data = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
        }

        private boolean isAvailable(int i, int i2) {
            return this.data.remaining() - i >= i2;
        }

        /* access modifiers changed from: package-private */
        public int length() {
            return this.data.remaining();
        }

        /* access modifiers changed from: package-private */
        public void order(ByteOrder byteOrder) {
            this.data.order(byteOrder);
        }

        /* access modifiers changed from: package-private */
        public short y(int i) {
            if (isAvailable(i, 2)) {
                return this.data.getShort(i);
            }
            return -1;
        }

        /* access modifiers changed from: package-private */
        public int z(int i) {
            if (isAvailable(i, 4)) {
                return this.data.getInt(i);
            }
            return -1;
        }
    }

    /* compiled from: DefaultImageHeaderParser */
    private interface c {
        int Q() throws IOException;

        short aa() throws IOException;

        int getByte() throws IOException;

        int read(byte[] bArr, int i) throws IOException;

        long skip(long j) throws IOException;
    }

    /* compiled from: DefaultImageHeaderParser */
    private static final class d implements c {
        private final InputStream Gi;

        d(InputStream inputStream) {
            this.Gi = inputStream;
        }

        public int Q() throws IOException {
            return (this.Gi.read() & 255) | ((this.Gi.read() << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK);
        }

        public short aa() throws IOException {
            return (short) (this.Gi.read() & 255);
        }

        public int getByte() throws IOException {
            return this.Gi.read();
        }

        public int read(byte[] bArr, int i) throws IOException {
            int i2 = i;
            while (i2 > 0) {
                int read = this.Gi.read(bArr, i - i2, i2);
                if (read == -1) {
                    break;
                }
                i2 -= read;
            }
            return i - i2;
        }

        public long skip(long j) throws IOException {
            if (j < 0) {
                return 0;
            }
            long j2 = j;
            while (j2 > 0) {
                long skip = this.Gi.skip(j2);
                if (skip <= 0) {
                    if (this.Gi.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j2 -= skip;
            }
            return j - j2;
        }
    }

    private static boolean X(int i) {
        return (i & Ji) == Ji || i == Ki || i == Li;
    }

    private static int a(b bVar) {
        ByteOrder byteOrder;
        short y = bVar.y(6);
        if (y == Li) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else if (y != Ki) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Unknown endianness = " + y);
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        bVar.order(byteOrder);
        int z = bVar.z(10) + 6;
        short y2 = bVar.y(z);
        for (int i = 0; i < y2; i++) {
            int p = p(z, i);
            short y3 = bVar.y(p);
            if (y3 == 274) {
                short y4 = bVar.y(p + 2);
                if (y4 >= 1 && y4 <= 12) {
                    int z2 = bVar.z(p + 4);
                    if (z2 >= 0) {
                        if (Log.isLoggable(TAG, 3)) {
                            Log.d(TAG, "Got tagIndex=" + i + " tagType=" + y3 + " formatCode=" + y4 + " componentCount=" + z2);
                        }
                        int i2 = z2 + Ti[y4];
                        if (i2 <= 4) {
                            int i3 = p + 8;
                            if (i3 < 0 || i3 > bVar.length()) {
                                if (Log.isLoggable(TAG, 3)) {
                                    Log.d(TAG, "Illegal tagValueOffset=" + i3 + " tagType=" + y3);
                                }
                            } else if (i2 >= 0 && i2 + i3 <= bVar.length()) {
                                return bVar.y(i3);
                            } else {
                                if (Log.isLoggable(TAG, 3)) {
                                    Log.d(TAG, "Illegal number of bytes for TI tag data tagType=" + y3);
                                }
                            }
                        } else if (Log.isLoggable(TAG, 3)) {
                            Log.d(TAG, "Got byte count > 4, not orientation, continuing, formatCode=" + y4);
                        }
                    } else if (Log.isLoggable(TAG, 3)) {
                        Log.d(TAG, "Negative tiff component count");
                    }
                } else if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Got invalid format code = " + y4);
                }
            }
        }
        return -1;
    }

    private int a(c cVar, com.bumptech.glide.load.engine.bitmap_recycle.b bVar) throws IOException {
        int Q = cVar.Q();
        if (!X(Q)) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Parser doesn't handle magic number: " + Q);
            }
            return -1;
        }
        int b2 = b(cVar);
        if (b2 == -1) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Failed to parse exif segment length, or exif segment not found");
            }
            return -1;
        }
        byte[] bArr = (byte[]) bVar.a(b2, byte[].class);
        try {
            return a(cVar, bArr, b2);
        } finally {
            bVar.put(bArr);
        }
    }

    private int a(c cVar, byte[] bArr, int i) throws IOException {
        int read = cVar.read(bArr, i);
        if (read != i) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Unable to read exif segment data, length: " + i + ", actually read: " + read);
            }
            return -1;
        } else if (c(bArr, i)) {
            return a(new b(bArr, i));
        } else {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Missing jpeg exif preamble");
            }
            return -1;
        }
    }

    @NonNull
    private ImageHeaderParser.ImageType a(c cVar) throws IOException {
        int Q = cVar.Q();
        if (Q == Ji) {
            return ImageHeaderParser.ImageType.JPEG;
        }
        int Q2 = ((Q << 16) & SupportMenu.CATEGORY_MASK) | (cVar.Q() & SupportMenu.USER_MASK);
        if (Q2 == Ii) {
            cVar.skip(21);
            return cVar.getByte() >= 3 ? ImageHeaderParser.ImageType.PNG_A : ImageHeaderParser.ImageType.PNG;
        } else if ((Q2 >> 8) == Hi) {
            return ImageHeaderParser.ImageType.GIF;
        } else {
            if (Q2 != Ui) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            cVar.skip(4);
            if ((((cVar.Q() << 16) & SupportMenu.CATEGORY_MASK) | (cVar.Q() & SupportMenu.USER_MASK)) != Vi) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int Q3 = ((cVar.Q() << 16) & SupportMenu.CATEGORY_MASK) | (cVar.Q() & SupportMenu.USER_MASK);
            if ((Q3 & -256) != Wi) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int i = Q3 & 255;
            if (i == 88) {
                cVar.skip(4);
                return (cVar.getByte() & 16) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
            } else if (i != 76) {
                return ImageHeaderParser.ImageType.WEBP;
            } else {
                cVar.skip(4);
                return (cVar.getByte() & 8) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
            }
        }
    }

    private int b(c cVar) throws IOException {
        short aa;
        int Q;
        long j;
        do {
            if (cVar.aa() != 255) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Unknown segmentId=" + r8);
                }
                return -1;
            }
            aa = cVar.aa();
            if (aa == 218) {
                return -1;
            }
            if (aa == 217) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            Q = cVar.Q() - 2;
            if (aa == 225) {
                return Q;
            }
            j = (long) Q;
        } while (cVar.skip(j) == j);
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "Unable to skip enough data, type: " + aa + ", wanted to skip: " + Q + ", but actually skipped: " + r6);
        }
        return -1;
    }

    private boolean c(byte[] bArr, int i) {
        boolean z = bArr != null && i > Ni.length;
        if (z) {
            int i2 = 0;
            while (true) {
                byte[] bArr2 = Ni;
                if (i2 >= bArr2.length) {
                    break;
                } else if (bArr[i2] != bArr2[i2]) {
                    return false;
                } else {
                    i2++;
                }
            }
        }
        return z;
    }

    private static int p(int i, int i2) {
        return i + 2 + (i2 * 12);
    }

    public int a(@NonNull InputStream inputStream, @NonNull com.bumptech.glide.load.engine.bitmap_recycle.b bVar) throws IOException {
        i.checkNotNull(inputStream);
        d dVar = new d(inputStream);
        i.checkNotNull(bVar);
        return a((c) dVar, bVar);
    }

    public int a(@NonNull ByteBuffer byteBuffer, @NonNull com.bumptech.glide.load.engine.bitmap_recycle.b bVar) throws IOException {
        i.checkNotNull(byteBuffer);
        a aVar = new a(byteBuffer);
        i.checkNotNull(bVar);
        return a((c) aVar, bVar);
    }

    @NonNull
    public ImageHeaderParser.ImageType a(@NonNull ByteBuffer byteBuffer) throws IOException {
        i.checkNotNull(byteBuffer);
        return a((c) new a(byteBuffer));
    }

    @NonNull
    public ImageHeaderParser.ImageType c(@NonNull InputStream inputStream) throws IOException {
        i.checkNotNull(inputStream);
        return a((c) new d(inputStream));
    }
}
