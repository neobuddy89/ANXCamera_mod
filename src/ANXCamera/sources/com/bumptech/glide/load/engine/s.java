package com.bumptech.glide.load.engine;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.j;
import com.bumptech.glide.util.i;
import java.security.MessageDigest;
import java.util.Map;

/* compiled from: EngineKey */
class s implements c {
    private final Class<?> He;
    private final Map<Class<?>, j<?>> Qd;
    private int hashCode;
    private final int height;
    private final Object model;
    private final g options;
    private final c signature;
    private final int width;
    private final Class<?> yc;

    s(Object obj, c cVar, int i, int i2, Map<Class<?>, j<?>> map, Class<?> cls, Class<?> cls2, g gVar) {
        i.checkNotNull(obj);
        this.model = obj;
        i.b(cVar, "Signature must not be null");
        this.signature = cVar;
        this.width = i;
        this.height = i2;
        i.checkNotNull(map);
        this.Qd = map;
        i.b(cls, "Resource class must not be null");
        this.He = cls;
        i.b(cls2, "Transcode class must not be null");
        this.yc = cls2;
        i.checkNotNull(gVar);
        this.options = gVar;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.model.equals(sVar.model) && this.signature.equals(sVar.signature) && this.height == sVar.height && this.width == sVar.width && this.Qd.equals(sVar.Qd) && this.He.equals(sVar.He) && this.yc.equals(sVar.yc) && this.options.equals(sVar.options);
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = this.model.hashCode();
            this.hashCode = (this.hashCode * 31) + this.signature.hashCode();
            this.hashCode = (this.hashCode * 31) + this.width;
            this.hashCode = (this.hashCode * 31) + this.height;
            this.hashCode = (this.hashCode * 31) + this.Qd.hashCode();
            this.hashCode = (this.hashCode * 31) + this.He.hashCode();
            this.hashCode = (this.hashCode * 31) + this.yc.hashCode();
            this.hashCode = (this.hashCode * 31) + this.options.hashCode();
        }
        return this.hashCode;
    }

    public String toString() {
        return "EngineKey{model=" + this.model + ", width=" + this.width + ", height=" + this.height + ", resourceClass=" + this.He + ", transcodeClass=" + this.yc + ", signature=" + this.signature + ", hashCode=" + this.hashCode + ", transformations=" + this.Qd + ", options=" + this.options + '}';
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }
}
