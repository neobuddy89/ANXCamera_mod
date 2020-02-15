package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import com.bumptech.glide.b.a;
import com.bumptech.glide.b.c;
import com.bumptech.glide.b.d;
import com.bumptech.glide.b.e;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.bitmap_recycle.b;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.h;
import com.bumptech.glide.util.l;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

public class ByteBufferGifDecoder implements h<ByteBuffer, b> {
    private static final String TAG = "BufferGifDecoder";
    private static final GifDecoderFactory Vj = new GifDecoderFactory();
    private static final GifHeaderParserPool Wj = new GifHeaderParserPool();
    private final GifHeaderParserPool Tj;
    private final GifDecoderFactory Uj;
    private final Context context;
    private final a provider;
    private final List<ImageHeaderParser> te;

    @VisibleForTesting
    static class GifDecoderFactory {
        GifDecoderFactory() {
        }

        /* access modifiers changed from: package-private */
        public a a(a.C0004a aVar, c cVar, ByteBuffer byteBuffer, int i) {
            return new e(aVar, cVar, byteBuffer, i);
        }
    }

    @VisibleForTesting
    static class GifHeaderParserPool {
        private final Queue<d> pool = l.createQueue(0);

        GifHeaderParserPool() {
        }

        /* access modifiers changed from: package-private */
        public synchronized void a(d dVar) {
            dVar.clear();
            this.pool.offer(dVar);
        }

        /* access modifiers changed from: package-private */
        public synchronized d d(ByteBuffer byteBuffer) {
            d poll;
            poll = this.pool.poll();
            if (poll == null) {
                poll = new d();
            }
            return poll.setData(byteBuffer);
        }
    }

    public ByteBufferGifDecoder(Context context2) {
        this(context2, com.bumptech.glide.c.get(context2).getRegistry().Hh(), com.bumptech.glide.c.get(context2).Dh(), com.bumptech.glide.c.get(context2).ka());
    }

    public ByteBufferGifDecoder(Context context2, List<ImageHeaderParser> list, com.bumptech.glide.load.engine.bitmap_recycle.d dVar, b bVar) {
        this(context2, list, dVar, bVar, Wj, Vj);
    }

    @VisibleForTesting
    ByteBufferGifDecoder(Context context2, List<ImageHeaderParser> list, com.bumptech.glide.load.engine.bitmap_recycle.d dVar, b bVar, GifHeaderParserPool gifHeaderParserPool, GifDecoderFactory gifDecoderFactory) {
        this.context = context2.getApplicationContext();
        this.te = list;
        this.Uj = gifDecoderFactory;
        this.provider = new a(dVar, bVar);
        this.Tj = gifHeaderParserPool;
    }

    private static int a(c cVar, int i, int i2) {
        int min = Math.min(cVar.getHeight() / i2, cVar.getWidth() / i);
        int max = Math.max(1, min == 0 ? 0 : Integer.highestOneBit(min));
        if (Log.isLoggable(TAG, 2) && max > 1) {
            Log.v(TAG, "Downsampling GIF, sampleSize: " + max + ", target dimens: [" + i + "x" + i2 + "], actual dimens: [" + cVar.getWidth() + "x" + cVar.getHeight() + "]");
        }
        return max;
    }

    @Nullable
    private d a(ByteBuffer byteBuffer, int i, int i2, d dVar, g gVar) {
        long Hj = com.bumptech.glide.util.e.Hj();
        try {
            c bi = dVar.bi();
            if (bi.getNumFrames() > 0) {
                if (bi.getStatus() == 0) {
                    Bitmap.Config config = gVar.a(g.hj) == DecodeFormat.PREFER_RGB_565 ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                    a a2 = this.Uj.a(this.provider, bi, byteBuffer, a(bi, i, i2));
                    a2.a(config);
                    a2.advance();
                    Bitmap nextFrame = a2.getNextFrame();
                    if (nextFrame == null) {
                        if (Log.isLoggable(TAG, 2)) {
                            Log.v(TAG, "Decoded GIF from stream in " + com.bumptech.glide.util.e.g(Hj));
                        }
                        return null;
                    }
                    b bVar = new b(this.context, a2, com.bumptech.glide.load.b.b.get(), i, i2, nextFrame);
                    d dVar2 = new d(bVar);
                    if (Log.isLoggable(TAG, 2)) {
                        Log.v(TAG, "Decoded GIF from stream in " + com.bumptech.glide.util.e.g(Hj));
                    }
                    return dVar2;
                }
            }
            return null;
        } finally {
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "Decoded GIF from stream in " + com.bumptech.glide.util.e.g(Hj));
            }
        }
    }

    /* renamed from: a */
    public d b(@NonNull ByteBuffer byteBuffer, int i, int i2, @NonNull g gVar) {
        d d2 = this.Tj.d(byteBuffer);
        try {
            d a2 = a(byteBuffer, i, i2, d2, gVar);
            return a2;
        } finally {
            this.Tj.a(d2);
        }
    }

    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull g gVar) throws IOException {
        return !((Boolean) gVar.a(g.gk)).booleanValue() && com.bumptech.glide.load.b.a(this.te, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }
}
