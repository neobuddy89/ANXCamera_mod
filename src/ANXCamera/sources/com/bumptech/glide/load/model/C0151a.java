package com.bumptech.glide.load.model;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.a.i;
import com.bumptech.glide.load.a.n;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.model.t;
import com.ss.android.ugc.effectmanager.effect.model.ComposerHelper;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.model.a  reason: case insensitive filesystem */
/* compiled from: AssetUriLoader */
public class C0151a<Data> implements t<Uri, Data> {
    private static final String Oh = "android_asset";
    private static final String Ph = "file:///android_asset/";
    private static final int Qh = 22;
    private final AssetManager Vd;
    private final C0009a<Data> factory;

    /* renamed from: com.bumptech.glide.load.model.a$a  reason: collision with other inner class name */
    /* compiled from: AssetUriLoader */
    public interface C0009a<Data> {
        d<Data> a(AssetManager assetManager, String str);
    }

    /* renamed from: com.bumptech.glide.load.model.a$b */
    /* compiled from: AssetUriLoader */
    public static class b implements u<Uri, ParcelFileDescriptor>, C0009a<ParcelFileDescriptor> {
        private final AssetManager Vd;

        public b(AssetManager assetManager) {
            this.Vd = assetManager;
        }

        public void S() {
        }

        public d<ParcelFileDescriptor> a(AssetManager assetManager, String str) {
            return new i(assetManager, str);
        }

        @NonNull
        public t<Uri, ParcelFileDescriptor> a(x xVar) {
            return new C0151a(this.Vd, this);
        }
    }

    /* renamed from: com.bumptech.glide.load.model.a$c */
    /* compiled from: AssetUriLoader */
    public static class c implements u<Uri, InputStream>, C0009a<InputStream> {
        private final AssetManager Vd;

        public c(AssetManager assetManager) {
            this.Vd = assetManager;
        }

        public void S() {
        }

        public d<InputStream> a(AssetManager assetManager, String str) {
            return new n(assetManager, str);
        }

        @NonNull
        public t<Uri, InputStream> a(x xVar) {
            return new C0151a(this.Vd, this);
        }
    }

    public C0151a(AssetManager assetManager, C0009a<Data> aVar) {
        this.Vd = assetManager;
        this.factory = aVar;
    }

    public t.a<Data> a(@NonNull Uri uri, int i, int i2, @NonNull g gVar) {
        return new t.a<>(new com.bumptech.glide.e.d(uri), this.factory.a(this.Vd, uri.toString().substring(Qh)));
    }

    /* renamed from: i */
    public boolean c(@NonNull Uri uri) {
        return ComposerHelper.COMPOSER_PATH.equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && Oh.equals(uri.getPathSegments().get(0));
    }
}
