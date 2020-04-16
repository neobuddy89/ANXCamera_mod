package com.bumptech.glide.load.engine;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.c;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.load.engine.d  reason: case insensitive filesystem */
/* compiled from: DataCacheKey */
final class C0149d implements c {
    private final c Ce;
    private final c signature;

    C0149d(c cVar, c cVar2) {
        this.Ce = cVar;
        this.signature = cVar2;
    }

    /* access modifiers changed from: package-private */
    public c di() {
        return this.Ce;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0149d)) {
            return false;
        }
        C0149d dVar = (C0149d) obj;
        return this.Ce.equals(dVar.Ce) && this.signature.equals(dVar.signature);
    }

    public int hashCode() {
        return (this.Ce.hashCode() * 31) + this.signature.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.Ce + ", signature=" + this.signature + '}';
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        this.Ce.updateDiskCacheKey(messageDigest);
        this.signature.updateDiskCacheKey(messageDigest);
    }
}
