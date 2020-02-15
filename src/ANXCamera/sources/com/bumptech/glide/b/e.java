package com.bumptech.glide.b;

import android.graphics.Bitmap;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.bumptech.glide.b.a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* compiled from: StandardGifDecoder */
public class e implements a {
    private static final int Ld = -1;
    private static final int MAX_STACK_SIZE = 4096;
    private static final int Md = -1;
    private static final int Nd = 4;
    @ColorInt
    private static final int Od = 0;
    private static final String TAG = "e";
    private static final int cd = 255;
    private final a.C0004a Ad;
    private byte[] Bd;
    @ColorInt
    private int[] Cd;
    private int Dd;
    private Bitmap Ed;
    private boolean Fd;
    private int Gd;
    private int Hd;
    @Nullable
    private Boolean Jd;
    @NonNull
    private Bitmap.Config Kd;
    @ColorInt
    private int[] act;
    private ByteBuffer bd;
    private byte[] block;
    private c header;
    private d parser;
    private byte[] pixelStack;
    private short[] prefix;
    private int sampleSize;
    private int status;
    private byte[] suffix;
    @ColorInt
    private final int[] zd;

    public e(@NonNull a.C0004a aVar) {
        this.zd = new int[256];
        this.Kd = Bitmap.Config.ARGB_8888;
        this.Ad = aVar;
        this.header = new c();
    }

    public e(@NonNull a.C0004a aVar, c cVar, ByteBuffer byteBuffer) {
        this(aVar, cVar, byteBuffer, 1);
    }

    public e(@NonNull a.C0004a aVar, c cVar, ByteBuffer byteBuffer, int i) {
        this(aVar);
        a(cVar, byteBuffer, i);
    }

    @NonNull
    private d Hl() {
        if (this.parser == null) {
            this.parser = new d();
        }
        return this.parser;
    }

    private Bitmap Il() {
        Boolean bool = this.Jd;
        Bitmap a2 = this.Ad.a(this.Hd, this.Gd, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.Kd);
        a2.setHasAlpha(true);
        return a2;
    }

    private Bitmap a(b bVar, b bVar2) {
        int[] iArr = this.Cd;
        int i = 0;
        if (bVar2 == null) {
            Bitmap bitmap = this.Ed;
            if (bitmap != null) {
                this.Ad.d(bitmap);
            }
            this.Ed = null;
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && bVar2.dispose == 3 && this.Ed == null) {
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null) {
            int i2 = bVar2.dispose;
            if (i2 > 0) {
                if (i2 == 2) {
                    if (!bVar.transparency) {
                        c cVar = this.header;
                        int i3 = cVar.bgColor;
                        if (bVar.lct == null || cVar.bgIndex != bVar.transIndex) {
                            i = i3;
                        }
                    } else if (this.Dd == 0) {
                        this.Jd = true;
                    }
                    int i4 = bVar2.ih;
                    int i5 = this.sampleSize;
                    int i6 = i4 / i5;
                    int i7 = bVar2.iy / i5;
                    int i8 = bVar2.iw / i5;
                    int i9 = bVar2.ix / i5;
                    int i10 = this.Hd;
                    int i11 = (i7 * i10) + i9;
                    int i12 = (i6 * i10) + i11;
                    while (i11 < i12) {
                        int i13 = i11 + i8;
                        for (int i14 = i11; i14 < i13; i14++) {
                            iArr[i14] = i;
                        }
                        i11 += this.Hd;
                    }
                } else if (i2 == 3) {
                    Bitmap bitmap2 = this.Ed;
                    if (bitmap2 != null) {
                        int i15 = this.Hd;
                        bitmap2.getPixels(iArr, 0, i15, 0, 0, i15, this.Gd);
                    }
                }
            }
        }
        c(bVar);
        if (bVar.interlace || this.sampleSize != 1) {
            a(bVar);
        } else {
            b(bVar);
        }
        if (this.Fd) {
            int i16 = bVar.dispose;
            if (i16 == 0 || i16 == 1) {
                if (this.Ed == null) {
                    this.Ed = Il();
                }
                Bitmap bitmap3 = this.Ed;
                int i17 = this.Hd;
                bitmap3.setPixels(iArr, 0, i17, 0, 0, i17, this.Gd);
            }
        }
        Bitmap Il = Il();
        int i18 = this.Hd;
        Il.setPixels(iArr, 0, i18, 0, 0, i18, this.Gd);
        return Il;
    }

    private void a(b bVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        b bVar2 = bVar;
        int[] iArr = this.Cd;
        int i6 = bVar2.ih;
        int i7 = this.sampleSize;
        int i8 = i6 / i7;
        int i9 = bVar2.iy / i7;
        int i10 = bVar2.iw / i7;
        int i11 = bVar2.ix / i7;
        boolean z = true;
        boolean z2 = this.Dd == 0;
        int i12 = this.sampleSize;
        int i13 = this.Hd;
        int i14 = this.Gd;
        byte[] bArr = this.Bd;
        int[] iArr2 = this.act;
        int i15 = 1;
        int i16 = 8;
        int i17 = 0;
        Boolean bool = this.Jd;
        int i18 = 0;
        while (i18 < i8) {
            Boolean bool2 = z;
            if (bVar2.interlace) {
                if (i17 >= i8) {
                    i = i8;
                    i5 = i15 + 1;
                    if (i5 == 2) {
                        i17 = 4;
                    } else if (i5 == 3) {
                        i16 = 4;
                        i17 = 2;
                    } else if (i5 == 4) {
                        i17 = 1;
                        i16 = 2;
                    }
                } else {
                    i = i8;
                    i5 = i15;
                }
                i2 = i17 + i16;
                i15 = i5;
            } else {
                i = i8;
                i2 = i17;
                i17 = i18;
            }
            int i19 = i17 + i9;
            boolean z3 = i12 == 1;
            if (i19 < i14) {
                int i20 = i19 * i13;
                int i21 = i20 + i11;
                int i22 = i21 + i10;
                int i23 = i20 + i13;
                if (i23 < i22) {
                    i22 = i23;
                }
                i3 = i9;
                int i24 = i18 * i12 * bVar2.iw;
                if (z3) {
                    int i25 = i21;
                    while (i25 < i22) {
                        int i26 = i10;
                        int i27 = iArr2[bArr[i24] & 255];
                        if (i27 != 0) {
                            iArr[i25] = i27;
                        } else if (z2 && bool == null) {
                            bool = bool2;
                        }
                        i24 += i12;
                        i25++;
                        i10 = i26;
                    }
                } else {
                    i4 = i10;
                    int i28 = ((i22 - i21) * i12) + i24;
                    int i29 = i21;
                    while (i29 < i22) {
                        int i30 = i22;
                        int b2 = b(i24, i28, bVar2.iw);
                        if (b2 != 0) {
                            iArr[i29] = b2;
                        } else if (z2 && bool == null) {
                            bool = bool2;
                        }
                        i24 += i12;
                        i29++;
                        i22 = i30;
                    }
                    i18++;
                    i17 = i2;
                    i10 = i4;
                    z = bool2;
                    i8 = i;
                    i9 = i3;
                }
            } else {
                i3 = i9;
            }
            i4 = i10;
            i18++;
            i17 = i2;
            i10 = i4;
            z = bool2;
            i8 = i;
            i9 = i3;
        }
        if (this.Jd == null) {
            this.Jd = Boolean.valueOf(bool == null ? false : bool.booleanValue());
        }
    }

    @ColorInt
    private int b(int i, int i2, int i3) {
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = i; i9 < this.sampleSize + i; i9++) {
            byte[] bArr = this.Bd;
            if (i9 >= bArr.length || i9 >= i2) {
                break;
            }
            int i10 = this.act[bArr[i9] & 255];
            if (i10 != 0) {
                i4 += (i10 >> 24) & 255;
                i5 += (i10 >> 16) & 255;
                i6 += (i10 >> 8) & 255;
                i7 += i10 & 255;
                i8++;
            }
        }
        int i11 = i + i3;
        for (int i12 = i11; i12 < this.sampleSize + i11; i12++) {
            byte[] bArr2 = this.Bd;
            if (i12 >= bArr2.length || i12 >= i2) {
                break;
            }
            int i13 = this.act[bArr2[i12] & 255];
            if (i13 != 0) {
                i4 += (i13 >> 24) & 255;
                i5 += (i13 >> 16) & 255;
                i6 += (i13 >> 8) & 255;
                i7 += i13 & 255;
                i8++;
            }
        }
        if (i8 == 0) {
            return 0;
        }
        return ((i4 / i8) << 24) | ((i5 / i8) << 16) | ((i6 / i8) << 8) | (i7 / i8);
    }

    private void b(b bVar) {
        b bVar2 = bVar;
        int[] iArr = this.Cd;
        int i = bVar2.ih;
        int i2 = bVar2.iy;
        int i3 = bVar2.iw;
        int i4 = bVar2.ix;
        boolean z = this.Dd == 0;
        int i5 = this.Hd;
        byte[] bArr = this.Bd;
        int[] iArr2 = this.act;
        int i6 = 0;
        byte b2 = -1;
        while (i6 < i) {
            int i7 = (i6 + i2) * i5;
            int i8 = i7 + i4;
            int i9 = i8 + i3;
            int i10 = i7 + i5;
            if (i10 < i9) {
                i9 = i10;
            }
            int i11 = bVar2.iw * i6;
            int i12 = i8;
            while (i12 < i9) {
                byte b3 = bArr[i11];
                byte b4 = b3 & 255;
                if (b4 != b2) {
                    int i13 = iArr2[b4];
                    if (i13 != 0) {
                        iArr[i12] = i13;
                    } else {
                        b2 = b3;
                    }
                }
                i11++;
                i12++;
                b bVar3 = bVar;
            }
            i6++;
            bVar2 = bVar;
        }
        this.Jd = Boolean.valueOf(this.Jd == null && z && b2 != -1);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v5, resolved type: byte} */
    /* JADX WARNING: Incorrect type for immutable var: ssa=short, code=int, for r4v16, types: [short] */
    /* JADX WARNING: Multi-variable type inference failed */
    private void c(b bVar) {
        int i;
        int i2;
        int i3;
        e eVar = this;
        b bVar2 = bVar;
        if (bVar2 != null) {
            eVar.bd.position(bVar2.Tc);
        }
        if (bVar2 == null) {
            c cVar = eVar.header;
            i = cVar.width;
            i2 = cVar.height;
        } else {
            i = bVar2.iw;
            i2 = bVar2.ih;
        }
        int i4 = i * i2;
        byte[] bArr = eVar.Bd;
        if (bArr == null || bArr.length < i4) {
            eVar.Bd = eVar.Ad.f(i4);
        }
        byte[] bArr2 = eVar.Bd;
        if (eVar.prefix == null) {
            eVar.prefix = new short[4096];
        }
        short[] sArr = eVar.prefix;
        if (eVar.suffix == null) {
            eVar.suffix = new byte[4096];
        }
        byte[] bArr3 = eVar.suffix;
        if (eVar.pixelStack == null) {
            eVar.pixelStack = new byte[4097];
        }
        byte[] bArr4 = eVar.pixelStack;
        int readByte = readByte();
        int i5 = 1 << readByte;
        int i6 = i5 + 1;
        int i7 = i5 + 2;
        int i8 = readByte + 1;
        int i9 = (1 << i8) - 1;
        int i10 = 0;
        for (int i11 = 0; i11 < i5; i11++) {
            sArr[i11] = 0;
            bArr3[i11] = (byte) i11;
        }
        byte[] bArr5 = eVar.block;
        int i12 = i8;
        int i13 = i7;
        int i14 = i9;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = -1;
        while (true) {
            if (i10 < i4) {
                if (i15 == 0) {
                    i15 = readBlock();
                    if (i15 <= 0) {
                        eVar.status = 3;
                        break;
                    }
                    i18 = 0;
                }
                i17 += (bArr5[i18] & 255) << i16;
                i18++;
                i15--;
                int i23 = i16 + 8;
                int i24 = i22;
                int i25 = i20;
                int i26 = i13;
                int i27 = i19;
                int i28 = i10;
                int i29 = i12;
                while (true) {
                    if (i23 < i29) {
                        i12 = i29;
                        i20 = i25;
                        i10 = i28;
                        i19 = i27;
                        i16 = i23;
                        i13 = i26;
                        i22 = i24;
                        eVar = this;
                        break;
                    }
                    int i30 = i17 & i14;
                    i17 >>= i29;
                    i23 -= i29;
                    if (i30 == i5) {
                        i29 = i8;
                        i26 = i7;
                        i14 = i9;
                        i24 = -1;
                    } else if (i30 == i6) {
                        i16 = i23;
                        i12 = i29;
                        i10 = i28;
                        i19 = i27;
                        i13 = i26;
                        i20 = i25;
                        i22 = i24;
                        break;
                    } else {
                        if (i24 == -1) {
                            bArr2[i27] = bArr3[i30];
                            i27++;
                            i28++;
                            i24 = i30;
                            i25 = i24;
                        } else {
                            int i31 = i26;
                            int i32 = i23;
                            if (i30 >= i31) {
                                bArr4[i21] = (byte) i25;
                                i21++;
                                i3 = i24;
                            } else {
                                i3 = i30;
                            }
                            while (i3 >= i5) {
                                bArr4[i21] = bArr3[i3];
                                i21++;
                                i3 = sArr[i3];
                            }
                            int i33 = bArr3[i3] & 255;
                            int i34 = i8;
                            byte b2 = (byte) i33;
                            bArr2[i27] = b2;
                            while (true) {
                                i27++;
                                i28++;
                                if (i21 <= 0) {
                                    break;
                                }
                                i21--;
                                bArr2[i27] = bArr4[i21];
                            }
                            int i35 = i33;
                            if (i31 < 4096) {
                                sArr[i31] = (short) i24;
                                bArr3[i31] = b2;
                                i31++;
                                if ((i31 & i14) == 0 && i31 < 4096) {
                                    i29++;
                                    i14 += i31;
                                }
                            }
                            i24 = i30;
                            i23 = i32;
                            i8 = i34;
                            i25 = i35;
                            i26 = i31;
                        }
                        eVar = this;
                    }
                }
            } else {
                break;
            }
        }
        Arrays.fill(bArr2, i19, i4, (byte) 0);
    }

    private int readBlock() {
        int readByte = readByte();
        if (readByte <= 0) {
            return readByte;
        }
        ByteBuffer byteBuffer = this.bd;
        byteBuffer.get(this.block, 0, Math.min(readByte, byteBuffer.remaining()));
        return readByte;
    }

    private int readByte() {
        return this.bd.get() & 255;
    }

    public void H() {
        this.Dd = -1;
    }

    public int K() {
        return this.Dd;
    }

    public int M() {
        return this.bd.limit() + this.Bd.length + (this.Cd.length * 4);
    }

    public int U() {
        int i = this.header.loopCount;
        if (i == -1) {
            return 1;
        }
        if (i == 0) {
            return 0;
        }
        return i + 1;
    }

    public int X() {
        if (this.header.frameCount <= 0) {
            return 0;
        }
        int i = this.Dd;
        if (i < 0) {
            return 0;
        }
        return getDelay(i);
    }

    public void a(@NonNull Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888 || config == Bitmap.Config.RGB_565) {
            this.Kd = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
    }

    public synchronized void a(@NonNull c cVar, @NonNull ByteBuffer byteBuffer) {
        a(cVar, byteBuffer, 1);
    }

    public synchronized void a(@NonNull c cVar, @NonNull ByteBuffer byteBuffer, int i) {
        if (i > 0) {
            int highestOneBit = Integer.highestOneBit(i);
            this.status = 0;
            this.header = cVar;
            this.Dd = -1;
            this.bd = byteBuffer.asReadOnlyBuffer();
            this.bd.position(0);
            this.bd.order(ByteOrder.LITTLE_ENDIAN);
            this.Fd = false;
            Iterator<b> it = cVar.frames.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().dispose == 3) {
                        this.Fd = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            this.sampleSize = highestOneBit;
            this.Hd = cVar.width / highestOneBit;
            this.Gd = cVar.height / highestOneBit;
            this.Bd = this.Ad.f(cVar.width * cVar.height);
            this.Cd = this.Ad.h(this.Hd * this.Gd);
        } else {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i);
        }
    }

    public synchronized void a(@NonNull c cVar, @NonNull byte[] bArr) {
        a(cVar, ByteBuffer.wrap(bArr));
    }

    public void advance() {
        this.Dd = (this.Dd + 1) % this.header.frameCount;
    }

    public int ca() {
        return this.header.loopCount;
    }

    public void clear() {
        this.header = null;
        byte[] bArr = this.Bd;
        if (bArr != null) {
            this.Ad.g(bArr);
        }
        int[] iArr = this.Cd;
        if (iArr != null) {
            this.Ad.a(iArr);
        }
        Bitmap bitmap = this.Ed;
        if (bitmap != null) {
            this.Ad.d(bitmap);
        }
        this.Ed = null;
        this.bd = null;
        this.Jd = null;
        byte[] bArr2 = this.block;
        if (bArr2 != null) {
            this.Ad.g(bArr2);
        }
    }

    @NonNull
    public ByteBuffer getData() {
        return this.bd;
    }

    public int getDelay(int i) {
        if (i >= 0) {
            c cVar = this.header;
            if (i < cVar.frameCount) {
                return cVar.frames.get(i).delay;
            }
        }
        return -1;
    }

    public int getFrameCount() {
        return this.header.frameCount;
    }

    public int getHeight() {
        return this.header.height;
    }

    @Deprecated
    public int getLoopCount() {
        int i = this.header.loopCount;
        if (i == -1) {
            return 1;
        }
        return i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00e9, code lost:
        return null;
     */
    @Nullable
    public synchronized Bitmap getNextFrame() {
        if (this.header.frameCount <= 0 || this.Dd < 0) {
            if (Log.isLoggable(TAG, 3)) {
                String str = TAG;
                Log.d(str, "Unable to decode frame, frameCount=" + this.header.frameCount + ", framePointer=" + this.Dd);
            }
            this.status = 1;
        }
        if (this.status != 1) {
            if (this.status != 2) {
                this.status = 0;
                if (this.block == null) {
                    this.block = this.Ad.f(255);
                }
                b bVar = this.header.frames.get(this.Dd);
                int i = this.Dd - 1;
                b bVar2 = i >= 0 ? this.header.frames.get(i) : null;
                this.act = bVar.lct != null ? bVar.lct : this.header.gct;
                if (this.act == null) {
                    if (Log.isLoggable(TAG, 3)) {
                        String str2 = TAG;
                        Log.d(str2, "No valid color table found for frame #" + this.Dd);
                    }
                    this.status = 1;
                    return null;
                }
                if (bVar.transparency) {
                    System.arraycopy(this.act, 0, this.zd, 0, this.act.length);
                    this.act = this.zd;
                    this.act[bVar.transIndex] = 0;
                }
                return a(bVar, bVar2);
            }
        }
        if (Log.isLoggable(TAG, 3)) {
            String str3 = TAG;
            Log.d(str3, "Unable to decode frame, status=" + this.status);
        }
    }

    public int getStatus() {
        return this.status;
    }

    public int getWidth() {
        return this.header.width;
    }

    public int read(@Nullable InputStream inputStream, int i) {
        if (inputStream != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i > 0 ? i + 4096 : 16384);
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream.read(bArr, 0, bArr.length);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byteArrayOutputStream.flush();
                read(byteArrayOutputStream.toByteArray());
            } catch (IOException e2) {
                Log.w(TAG, "Error reading data from stream", e2);
            }
        } else {
            this.status = 2;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e3) {
                Log.w(TAG, "Error closing stream", e3);
            }
        }
        return this.status;
    }

    public synchronized int read(@Nullable byte[] bArr) {
        this.header = Hl().setData(bArr).bi();
        if (bArr != null) {
            a(this.header, bArr);
        }
        return this.status;
    }
}
