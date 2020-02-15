package com.bumptech.glide.load.model;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: LazyHeaders */
public final class p implements n {
    private final Map<String, List<o>> headers;
    private volatile Map<String, String> ii;

    /* compiled from: LazyHeaders */
    public static final class a {
        private static final String fi = "User-Agent";
        private static final String gi = getSanitizedUserAgent();
        private static final Map<String, List<o>> hi;
        private boolean di = true;
        private boolean ei = true;
        private Map<String, List<o>> headers = hi;

        static {
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(gi)) {
                hashMap.put("User-Agent", Collections.singletonList(new b(gi)));
            }
            hi = Collections.unmodifiableMap(hashMap);
        }

        private List<o> C(String str) {
            List<o> list = this.headers.get(str);
            if (list != null) {
                return list;
            }
            ArrayList arrayList = new ArrayList();
            this.headers.put(str, arrayList);
            return arrayList;
        }

        @VisibleForTesting
        static String getSanitizedUserAgent() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb = new StringBuilder(property.length());
            for (int i = 0; i < length; i++) {
                char charAt = property.charAt(i);
                if ((charAt > 31 || charAt == 9) && charAt < 127) {
                    sb.append(charAt);
                } else {
                    sb.append('?');
                }
            }
            return sb.toString();
        }

        private Map<String, List<o>> im() {
            HashMap hashMap = new HashMap(this.headers.size());
            for (Map.Entry next : this.headers.entrySet()) {
                hashMap.put(next.getKey(), new ArrayList((Collection) next.getValue()));
            }
            return hashMap;
        }

        private void jm() {
            if (this.di) {
                this.di = false;
                this.headers = im();
            }
        }

        public a a(String str, o oVar) {
            if (this.ei && "User-Agent".equalsIgnoreCase(str)) {
                return b(str, oVar);
            }
            jm();
            C(str).add(oVar);
            return this;
        }

        public a addHeader(String str, String str2) {
            return a(str, new b(str2));
        }

        public a b(String str, o oVar) {
            jm();
            if (oVar == null) {
                this.headers.remove(str);
            } else {
                List<o> C = C(str);
                C.clear();
                C.add(oVar);
            }
            if (this.ei && "User-Agent".equalsIgnoreCase(str)) {
                this.ei = false;
            }
            return this;
        }

        public p build() {
            this.di = true;
            return new p(this.headers);
        }

        public a setHeader(String str, String str2) {
            return b(str, str2 == null ? null : new b(str2));
        }
    }

    /* compiled from: LazyHeaders */
    static final class b implements o {
        private final String value;

        b(String str) {
            this.value = str;
        }

        public String D() {
            return this.value;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.value.equals(((b) obj).value);
            }
            return false;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.value + '\'' + '}';
        }
    }

    p(Map<String, List<o>> map) {
        this.headers = Collections.unmodifiableMap(map);
    }

    @NonNull
    private String f(@NonNull List<o> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            String D = list.get(i).D();
            if (!TextUtils.isEmpty(D)) {
                sb.append(D);
                if (i != list.size() - 1) {
                    sb.append(',');
                }
            }
        }
        return sb.toString();
    }

    private Map<String, String> km() {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.headers.entrySet()) {
            String f2 = f((List) next.getValue());
            if (!TextUtils.isEmpty(f2)) {
                hashMap.put(next.getKey(), f2);
            }
        }
        return hashMap;
    }

    public boolean equals(Object obj) {
        if (obj instanceof p) {
            return this.headers.equals(((p) obj).headers);
        }
        return false;
    }

    public Map<String, String> getHeaders() {
        if (this.ii == null) {
            synchronized (this) {
                if (this.ii == null) {
                    this.ii = Collections.unmodifiableMap(km());
                }
            }
        }
        return this.ii;
    }

    public int hashCode() {
        return this.headers.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.headers + '}';
    }
}
