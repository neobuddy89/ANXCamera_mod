package com.bumptech.glide.d;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ImageHeaderParserRegistry */
public final class b {
    private final List<ImageHeaderParser> te = new ArrayList();

    @NonNull
    public synchronized List<ImageHeaderParser> Pi() {
        return this.te;
    }

    public synchronized void b(@NonNull ImageHeaderParser imageHeaderParser) {
        this.te.add(imageHeaderParser);
    }
}
