package com.bumptech.glide.load.a;

import android.support.annotation.NonNull;
import java.io.IOException;

/* compiled from: DataRewinder */
public interface e<T> {

    /* compiled from: DataRewinder */
    public interface a<T> {
        @NonNull
        Class<T> ba();

        @NonNull
        e<T> build(@NonNull T t);
    }

    @NonNull
    T R() throws IOException;

    void cleanup();
}
