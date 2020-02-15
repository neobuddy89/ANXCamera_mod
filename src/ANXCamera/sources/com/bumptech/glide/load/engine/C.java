package com.bumptech.glide.load.engine;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.engine.bitmap_recycle.b;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.j;
import com.bumptech.glide.util.f;
import com.bumptech.glide.util.l;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: ResourceCacheKey */
final class C implements c {
    private static final f<Class<?>, byte[]> dg = new f<>(50);
    private final c Ce;
    private final Class<?> bg;
    private final j<?> cg;
    private final int height;
    private final g options;
    private final b ra;
    private final c signature;
    private final int width;

    C(b bVar, c cVar, c cVar2, int i, int i2, j<?> jVar, Class<?> cls, g gVar) {
        this.ra = bVar;
        this.Ce = cVar;
        this.signature = cVar2;
        this.width = i;
        this.height = i2;
        this.cg = jVar;
        this.bg = cls;
        this.options = gVar;
    }

    private byte[] Wl() {
        byte[] bArr = dg.get(this.bg);
        if (bArr != null) {
            return bArr;
        }
        byte[] bytes = this.bg.getName().getBytes(c.CHARSET);
        dg.put(this.bg, bytes);
        return bytes;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C)) {
            return false;
        }
        C c2 = (C) obj;
        return this.height == c2.height && this.width == c2.width && l.d(this.cg, c2.cg) && this.bg.equals(c2.bg) && this.Ce.equals(c2.Ce) && this.signature.equals(c2.signature) && this.options.equals(c2.options);
    }

    public int hashCode() {
        int hashCode = (((((this.Ce.hashCode() * 31) + this.signature.hashCode()) * 31) + this.width) * 31) + this.height;
        j<?> jVar = this.cg;
        if (jVar != null) {
            hashCode = (hashCode * 31) + jVar.hashCode();
        }
        return (((hashCode * 31) + this.bg.hashCode()) * 31) + this.options.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.Ce + ", signature=" + this.signature + ", width=" + this.width + ", height=" + this.height + ", decodedResourceClass=" + this.bg + ", transformation='" + this.cg + '\'' + ", options=" + this.options + '}';
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.ra.b(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.width).putInt(this.height).array();
        this.signature.updateDiskCacheKey(messageDigest);
        this.Ce.updateDiskCacheKey(messageDigest);
        messageDigest.update(bArr);
        j<?> jVar = this.cg;
        if (jVar != null) {
            jVar.updateDiskCacheKey(messageDigest);
        }
        this.options.updateDiskCacheKey(messageDigest);
        messageDigest.update(Wl());
        this.ra.put(bArr);
    }
}
