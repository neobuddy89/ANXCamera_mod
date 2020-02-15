package com.bumptech.glide.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* compiled from: ExceptionCatchingInputStream */
public class c extends InputStream {
    private static final Queue<c> QUEUE = l.createQueue(0);
    private IOException exception;
    private InputStream ya;

    c() {
    }

    static void clearQueue() {
        while (!QUEUE.isEmpty()) {
            QUEUE.remove();
        }
    }

    @NonNull
    public static c j(@NonNull InputStream inputStream) {
        c poll;
        synchronized (QUEUE) {
            poll = QUEUE.poll();
        }
        if (poll == null) {
            poll = new c();
        }
        poll.setInputStream(inputStream);
        return poll;
    }

    public int available() throws IOException {
        return this.ya.available();
    }

    public void close() throws IOException {
        this.ya.close();
    }

    @Nullable
    public IOException getException() {
        return this.exception;
    }

    public void mark(int i) {
        this.ya.mark(i);
    }

    public boolean markSupported() {
        return this.ya.markSupported();
    }

    public int read() {
        try {
            return this.ya.read();
        } catch (IOException e2) {
            this.exception = e2;
            return -1;
        }
    }

    public int read(byte[] bArr) {
        try {
            return this.ya.read(bArr);
        } catch (IOException e2) {
            this.exception = e2;
            return -1;
        }
    }

    public int read(byte[] bArr, int i, int i2) {
        try {
            return this.ya.read(bArr, i, i2);
        } catch (IOException e2) {
            this.exception = e2;
            return -1;
        }
    }

    public void release() {
        this.exception = null;
        this.ya = null;
        synchronized (QUEUE) {
            QUEUE.offer(this);
        }
    }

    public synchronized void reset() throws IOException {
        this.ya.reset();
    }

    /* access modifiers changed from: package-private */
    public void setInputStream(@NonNull InputStream inputStream) {
        this.ya = inputStream;
    }

    public long skip(long j) {
        try {
            return this.ya.skip(j);
        } catch (IOException e2) {
            this.exception = e2;
            return 0;
        }
    }
}
