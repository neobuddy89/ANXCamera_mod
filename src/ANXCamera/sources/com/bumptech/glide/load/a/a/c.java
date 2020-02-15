package com.bumptech.glide.load.a.a;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.a.h;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ThumbFetcher */
public class c implements d<InputStream> {
    private static final String TAG = "MediaStoreThumbFetcher";
    private InputStream inputStream;
    private final Uri re;
    private final e se;

    /* compiled from: ThumbFetcher */
    static class a implements d {
        private static final String[] pe = {"_data"};
        private static final String qe = "kind = 1 AND image_id = ?";
        private final ContentResolver ge;

        a(ContentResolver contentResolver) {
            this.ge = contentResolver;
        }

        public Cursor b(Uri uri) {
            String lastPathSegment = uri.getLastPathSegment();
            return this.ge.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, pe, qe, new String[]{lastPathSegment}, (String) null);
        }
    }

    /* compiled from: ThumbFetcher */
    static class b implements d {
        private static final String[] pe = {"_data"};
        private static final String qe = "kind = 1 AND video_id = ?";
        private final ContentResolver ge;

        b(ContentResolver contentResolver) {
            this.ge = contentResolver;
        }

        public Cursor b(Uri uri) {
            String lastPathSegment = uri.getLastPathSegment();
            return this.ge.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, pe, qe, new String[]{lastPathSegment}, (String) null);
        }
    }

    @VisibleForTesting
    c(Uri uri, e eVar) {
        this.re = uri;
        this.se = eVar;
    }

    private InputStream Ll() throws FileNotFoundException {
        InputStream h = this.se.h(this.re);
        int g = h != null ? this.se.g(this.re) : -1;
        return g != -1 ? new h(h, g) : h;
    }

    private static c a(Context context, Uri uri, d dVar) {
        return new c(uri, new e(com.bumptech.glide.c.get(context).getRegistry().Hh(), dVar, com.bumptech.glide.c.get(context).ka(), context.getContentResolver()));
    }

    public static c b(Context context, Uri uri) {
        return a(context, uri, new a(context.getContentResolver()));
    }

    public static c c(Context context, Uri uri) {
        return a(context, uri, new b(context.getContentResolver()));
    }

    @NonNull
    public DataSource G() {
        return DataSource.LOCAL;
    }

    public void a(@NonNull Priority priority, @NonNull d.a<? super InputStream> aVar) {
        try {
            this.inputStream = Ll();
            aVar.b(this.inputStream);
        } catch (FileNotFoundException e2) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Failed to find thumbnail file", e2);
            }
            aVar.b((Exception) e2);
        }
    }

    @NonNull
    public Class<InputStream> ba() {
        return InputStream.class;
    }

    public void cancel() {
    }

    public void cleanup() {
        InputStream inputStream2 = this.inputStream;
        if (inputStream2 != null) {
            try {
                inputStream2.close();
            } catch (IOException unused) {
            }
        }
    }
}
