package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.VisibleForTesting;
import com.bumptech.glide.util.l;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

@RequiresApi(19)
public class SizeConfigStrategy implements k {
    private static final int Ag = 8;
    private static final Bitmap.Config[] Bg;
    private static final Bitmap.Config[] Cg = Bg;
    private static final Bitmap.Config[] Dg = {Bitmap.Config.RGB_565};
    private static final Bitmap.Config[] Eg = {Bitmap.Config.ARGB_4444};
    private static final Bitmap.Config[] Fg = {Bitmap.Config.ALPHA_8};
    private final KeyPool kg = new KeyPool();
    private final g<Key, Bitmap> lg = new g<>();
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> og = new HashMap();

    @VisibleForTesting
    static final class Key implements l {
        private Bitmap.Config config;
        private final KeyPool pool;
        int size;

        public Key(KeyPool keyPool) {
            this.pool = keyPool;
        }

        @VisibleForTesting
        Key(KeyPool keyPool, int i, Bitmap.Config config2) {
            this(keyPool);
            b(i, config2);
        }

        public void J() {
            this.pool.a(this);
        }

        public void b(int i, Bitmap.Config config2) {
            this.size = i;
            this.config = config2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            return this.size == key.size && l.d(this.config, key.config);
        }

        public int hashCode() {
            int i = this.size * 31;
            Bitmap.Config config2 = this.config;
            return i + (config2 != null ? config2.hashCode() : 0);
        }

        public String toString() {
            return SizeConfigStrategy.c(this.size, this.config);
        }
    }

    @VisibleForTesting
    static class KeyPool extends c<Key> {
        KeyPool() {
        }

        public Key a(int i, Bitmap.Config config) {
            Key key = (Key) get();
            key.b(i, config);
            return key;
        }

        /* access modifiers changed from: protected */
        public Key create() {
            return new Key(this);
        }
    }

    static {
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, configArr.length + 1);
            configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        }
        Bg = configArr;
    }

    private void a(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> d2 = d(bitmap.getConfig());
        Integer num2 = (Integer) d2.get(num);
        if (num2 == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + e(bitmap) + ", this: " + this);
        } else if (num2.intValue() == 1) {
            d2.remove(num);
        } else {
            d2.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    static String c(int i, Bitmap.Config config) {
        return "[" + i + "](" + config + ")";
    }

    private static Bitmap.Config[] c(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(config)) {
            return Cg;
        }
        int i = m.zg[config.ordinal()];
        if (i == 1) {
            return Bg;
        }
        if (i == 2) {
            return Dg;
        }
        if (i == 3) {
            return Eg;
        }
        if (i == 4) {
            return Fg;
        }
        return new Bitmap.Config[]{config};
    }

    private Key d(int i, Bitmap.Config config) {
        Key a2 = this.kg.a(i, config);
        Bitmap.Config[] c2 = c(config);
        int length = c2.length;
        int i2 = 0;
        while (i2 < length) {
            Bitmap.Config config2 = c2[i2];
            Integer ceilingKey = d(config2).ceilingKey(Integer.valueOf(i));
            if (ceilingKey == null || ceilingKey.intValue() > i * 8) {
                i2++;
            } else {
                if (ceilingKey.intValue() == i) {
                    if (config2 == null) {
                        if (config == null) {
                            return a2;
                        }
                    } else if (config2.equals(config)) {
                        return a2;
                    }
                }
                this.kg.a(a2);
                return this.kg.a(ceilingKey.intValue(), config2);
            }
        }
        return a2;
    }

    private NavigableMap<Integer, Integer> d(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.og.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.og.put(config, treeMap);
        return treeMap;
    }

    public void a(Bitmap bitmap) {
        Key a2 = this.kg.a(l.j(bitmap), bitmap.getConfig());
        this.lg.a(a2, bitmap);
        NavigableMap<Integer, Integer> d2 = d(bitmap.getConfig());
        Integer num = (Integer) d2.get(Integer.valueOf(a2.size));
        Integer valueOf = Integer.valueOf(a2.size);
        int i = 1;
        if (num != null) {
            i = 1 + num.intValue();
        }
        d2.put(valueOf, Integer.valueOf(i));
    }

    public String b(int i, int i2, Bitmap.Config config) {
        return c(l.g(i, i2, config), config);
    }

    public int c(Bitmap bitmap) {
        return l.j(bitmap);
    }

    @Nullable
    public Bitmap d(int i, int i2, Bitmap.Config config) {
        Key d2 = d(l.g(i, i2, config), config);
        Bitmap b2 = this.lg.b(d2);
        if (b2 != null) {
            a(Integer.valueOf(d2.size), b2);
            b2.reconfigure(i, i2, b2.getConfig() != null ? b2.getConfig() : Bitmap.Config.ARGB_8888);
        }
        return b2;
    }

    public String e(Bitmap bitmap) {
        return c(l.j(bitmap), bitmap.getConfig());
    }

    @Nullable
    public Bitmap removeLast() {
        Bitmap removeLast = this.lg.removeLast();
        if (removeLast != null) {
            a(Integer.valueOf(l.j(removeLast)), removeLast);
        }
        return removeLast;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SizeConfigStrategy{groupedMap=");
        sb.append(this.lg);
        sb.append(", sortedSizes=(");
        for (Map.Entry next : this.og.entrySet()) {
            sb.append(next.getKey());
            sb.append('[');
            sb.append(next.getValue());
            sb.append("], ");
        }
        if (!this.og.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(")}");
        return sb.toString();
    }
}
