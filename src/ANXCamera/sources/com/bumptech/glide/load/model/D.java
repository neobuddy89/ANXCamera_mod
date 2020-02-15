package com.bumptech.glide.load.model;

import android.net.Uri;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.model.t;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: UrlUriLoader */
public class D<Data> implements t<Uri, Data> {
    private static final Set<String> SCHEMES = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"http", "https"})));
    private final t<l, Data> wi;

    /* compiled from: UrlUriLoader */
    public static class a implements u<Uri, InputStream> {
        public void S() {
        }

        @NonNull
        public t<Uri, InputStream> a(x xVar) {
            return new D(xVar.a(l.class, InputStream.class));
        }
    }

    public D(t<l, Data> tVar) {
        this.wi = tVar;
    }

    public t.a<Data> a(@NonNull Uri uri, int i, int i2, @NonNull g gVar) {
        return this.wi.a(new l(uri.toString()), i, i2, gVar);
    }

    /* renamed from: i */
    public boolean c(@NonNull Uri uri) {
        return SCHEMES.contains(uri.getScheme());
    }
}
