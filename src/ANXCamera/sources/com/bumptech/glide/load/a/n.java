package com.bumptech.glide.load.a;

import android.content.res.AssetManager;
import android.support.annotation.NonNull;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: StreamAssetPathFetcher */
public class n extends b<InputStream> {
    public n(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    /* access modifiers changed from: protected */
    public InputStream b(AssetManager assetManager, String str) throws IOException {
        return assetManager.open(str);
    }

    @NonNull
    public Class<InputStream> ba() {
        return InputStream.class;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void e(InputStream inputStream) throws IOException {
        inputStream.close();
    }
}
