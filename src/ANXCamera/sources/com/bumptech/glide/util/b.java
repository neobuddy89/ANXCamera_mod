package com.bumptech.glide.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ContentLengthInputStream */
public final class b extends FilterInputStream {
    private static final String TAG = "ContentLengthStream";
    private static final int UNKNOWN = -1;
    private int Mp;
    private final long contentLength;

    private b(@NonNull InputStream inputStream, long j) {
        super(inputStream);
        this.contentLength = j;
    }

    private static int L(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e2) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "failed to parse content length header: " + str, e2);
                }
            }
        }
        return -1;
    }

    @NonNull
    public static InputStream a(@NonNull InputStream inputStream, long j) {
        return new b(inputStream, j);
    }

    @NonNull
    public static InputStream b(@NonNull InputStream inputStream, @Nullable String str) {
        return a(inputStream, (long) L(str));
    }

    private int ba(int i) throws IOException {
        if (i >= 0) {
            this.Mp += i;
        } else if (this.contentLength - ((long) this.Mp) > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.contentLength + ", but read: " + this.Mp);
        }
        return i;
    }

    public synchronized int available() throws IOException {
        return (int) Math.max(this.contentLength - ((long) this.Mp), (long) this.in.available());
    }

    public synchronized int read() throws IOException {
        int read;
        read = super.read();
        ba(read >= 0 ? 1 : -1);
        return read;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        int read;
        read = super.read(bArr, i, i2);
        ba(read);
        return read;
    }
}
