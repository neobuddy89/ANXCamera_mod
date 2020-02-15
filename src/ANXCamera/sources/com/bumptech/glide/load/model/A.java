package com.bumptech.glide.load.model;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.model.t;
import java.io.File;
import java.io.InputStream;

/* compiled from: StringLoader */
public class A<Data> implements t<String, Data> {
    private final t<Uri, Data> vi;

    /* compiled from: StringLoader */
    public static final class a implements u<String, AssetFileDescriptor> {
        public void S() {
        }

        public t<String, AssetFileDescriptor> a(x xVar) {
            return new A(xVar.a(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* compiled from: StringLoader */
    public static class b implements u<String, ParcelFileDescriptor> {
        public void S() {
        }

        @NonNull
        public t<String, ParcelFileDescriptor> a(x xVar) {
            return new A(xVar.a(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* compiled from: StringLoader */
    public static class c implements u<String, InputStream> {
        public void S() {
        }

        @NonNull
        public t<String, InputStream> a(x xVar) {
            return new A(xVar.a(Uri.class, InputStream.class));
        }
    }

    public A(t<Uri, Data> tVar) {
        this.vi = tVar;
    }

    @Nullable
    private static Uri D(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.charAt(0) == '/') {
            return E(str);
        }
        Uri parse = Uri.parse(str);
        return parse.getScheme() == null ? E(str) : parse;
    }

    private static Uri E(String str) {
        return Uri.fromFile(new File(str));
    }

    public t.a<Data> a(@NonNull String str, int i, int i2, @NonNull g gVar) {
        Uri D = D(str);
        if (D == null) {
            return null;
        }
        return this.vi.a(D, i, i2, gVar);
    }

    /* renamed from: x */
    public boolean c(@NonNull String str) {
        return true;
    }
}
