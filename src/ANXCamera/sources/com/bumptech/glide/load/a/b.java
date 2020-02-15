package com.bumptech.glide.load.a;

import android.content.res.AssetManager;
import android.support.annotation.NonNull;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.a.d;
import java.io.IOException;

/* compiled from: AssetPathFetcher */
public abstract class b<T> implements d<T> {
    private static final String TAG = "AssetPathFetcher";
    private final String Ud;
    private final AssetManager Vd;
    private T data;

    public b(AssetManager assetManager, String str) {
        this.Vd = assetManager;
        this.Ud = str;
    }

    @NonNull
    public DataSource G() {
        return DataSource.LOCAL;
    }

    public void a(@NonNull Priority priority, @NonNull d.a<? super T> aVar) {
        try {
            this.data = b(this.Vd, this.Ud);
            aVar.b(this.data);
        } catch (IOException e2) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Failed to load data from asset manager", e2);
            }
            aVar.b((Exception) e2);
        }
    }

    /* access modifiers changed from: protected */
    public abstract T b(AssetManager assetManager, String str) throws IOException;

    public void cancel() {
    }

    public void cleanup() {
        T t = this.data;
        if (t != null) {
            try {
                e(t);
            } catch (IOException unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract void e(T t) throws IOException;
}
