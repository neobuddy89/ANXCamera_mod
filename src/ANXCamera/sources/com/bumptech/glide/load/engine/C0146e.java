package com.bumptech.glide.load.engine;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.engine.a.a;
import com.bumptech.glide.load.g;
import java.io.File;

/* renamed from: com.bumptech.glide.load.engine.e  reason: case insensitive filesystem */
/* compiled from: DataCacheWriter */
class C0146e<DataType> implements a.b {
    private final DataType data;
    private final com.bumptech.glide.load.a<DataType> encoder;
    private final g options;

    C0146e(com.bumptech.glide.load.a<DataType> aVar, DataType datatype, g gVar) {
        this.encoder = aVar;
        this.data = datatype;
        this.options = gVar;
    }

    public boolean c(@NonNull File file) {
        return this.encoder.a(this.data, file, this.options);
    }
}
