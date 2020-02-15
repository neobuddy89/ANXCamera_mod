package com.bumptech.glide.load.model;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.bumptech.glide.load.c;
import com.bumptech.glide.util.i;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

/* compiled from: GlideUrl */
public class l implements c {
    private static final String bi = "@#&=*+-_.,:!?()/~'%;$";
    @Nullable
    private final String Xh;
    @Nullable
    private String Yh;
    @Nullable
    private URL Zh;
    @Nullable
    private volatile byte[] _h;
    private int hashCode;
    private final n headers;
    @Nullable
    private final URL url;

    public l(String str) {
        this(str, n.DEFAULT);
    }

    public l(String str, n nVar) {
        this.url = null;
        i.y(str);
        this.Xh = str;
        i.checkNotNull(nVar);
        this.headers = nVar;
    }

    public l(URL url2) {
        this(url2, n.DEFAULT);
    }

    public l(URL url2, n nVar) {
        i.checkNotNull(url2);
        this.url = url2;
        this.Xh = null;
        i.checkNotNull(nVar);
        this.headers = nVar;
    }

    private byte[] fm() {
        if (this._h == null) {
            this._h = getCacheKey().getBytes(c.CHARSET);
        }
        return this._h;
    }

    private String gm() {
        if (TextUtils.isEmpty(this.Yh)) {
            String str = this.Xh;
            if (TextUtils.isEmpty(str)) {
                URL url2 = this.url;
                i.checkNotNull(url2);
                str = url2.toString();
            }
            this.Yh = Uri.encode(str, bi);
        }
        return this.Yh;
    }

    private URL hm() throws MalformedURLException {
        if (this.Zh == null) {
            this.Zh = new URL(gm());
        }
        return this.Zh;
    }

    public String Fi() {
        return gm();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return getCacheKey().equals(lVar.getCacheKey()) && this.headers.equals(lVar.headers);
    }

    public String getCacheKey() {
        String str = this.Xh;
        if (str != null) {
            return str;
        }
        URL url2 = this.url;
        i.checkNotNull(url2);
        return url2.toString();
    }

    public Map<String, String> getHeaders() {
        return this.headers.getHeaders();
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = getCacheKey().hashCode();
            this.hashCode = (this.hashCode * 31) + this.headers.hashCode();
        }
        return this.hashCode;
    }

    public String toString() {
        return getCacheKey();
    }

    public URL toURL() throws MalformedURLException {
        return hm();
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(fm());
    }
}
