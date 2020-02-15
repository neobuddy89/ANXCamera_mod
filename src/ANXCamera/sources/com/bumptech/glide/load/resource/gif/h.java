package com.bumptech.glide.load.resource.gif;

import android.support.annotation.NonNull;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.A;
import com.bumptech.glide.load.engine.bitmap_recycle.b;
import com.bumptech.glide.load.g;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: StreamGifDecoder */
public class h implements com.bumptech.glide.load.h<InputStream, b> {
    private static final String TAG = "StreamGifDecoder";
    private final b de;
    private final com.bumptech.glide.load.h<ByteBuffer, b> hk;
    private final List<ImageHeaderParser> te;

    public h(List<ImageHeaderParser> list, com.bumptech.glide.load.h<ByteBuffer, b> hVar, b bVar) {
        this.te = list;
        this.hk = hVar;
        this.de = bVar;
    }

    private static byte[] k(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e2) {
            if (!Log.isLoggable(TAG, 5)) {
                return null;
            }
            Log.w(TAG, "Error reading data from stream", e2);
            return null;
        }
    }

    /* renamed from: a */
    public A<b> b(@NonNull InputStream inputStream, int i, int i2, @NonNull g gVar) throws IOException {
        byte[] k = k(inputStream);
        if (k == null) {
            return null;
        }
        return this.hk.b(ByteBuffer.wrap(k), i, i2, gVar);
    }

    public boolean a(@NonNull InputStream inputStream, @NonNull g gVar) throws IOException {
        return !((Boolean) gVar.a(g.gk)).booleanValue() && com.bumptech.glide.load.b.b(this.te, inputStream, this.de) == ImageHeaderParser.ImageType.GIF;
    }
}
