package com.bumptech.glide.load.b.a;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.a.e;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferRewinder */
public class a implements e<ByteBuffer> {
    private final ByteBuffer buffer;

    /* renamed from: com.bumptech.glide.load.b.a.a$a  reason: collision with other inner class name */
    /* compiled from: ByteBufferRewinder */
    public static class C0006a implements e.a<ByteBuffer> {
        @NonNull
        public Class<ByteBuffer> ba() {
            return ByteBuffer.class;
        }

        @NonNull
        /* renamed from: c */
        public e<ByteBuffer> build(ByteBuffer byteBuffer) {
            return new a(byteBuffer);
        }
    }

    public a(ByteBuffer byteBuffer) {
        this.buffer = byteBuffer;
    }

    @NonNull
    public ByteBuffer R() {
        this.buffer.position(0);
        return this.buffer;
    }

    public void cleanup() {
    }
}
