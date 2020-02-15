package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.VisibleForTesting;
import com.bumptech.glide.util.l;
import java.util.NavigableMap;

@RequiresApi(19)
final class SizeStrategy implements k {
    private static final int Ag = 8;
    private final KeyPool kg = new KeyPool();
    private final g<Key, Bitmap> lg = new g<>();
    private final NavigableMap<Integer, Integer> og = new PrettyPrintTreeMap();

    @VisibleForTesting
    static final class Key implements l {
        private final KeyPool pool;
        int size;

        Key(KeyPool keyPool) {
            this.pool = keyPool;
        }

        public void J() {
            this.pool.a(this);
        }

        public boolean equals(Object obj) {
            return (obj instanceof Key) && this.size == ((Key) obj).size;
        }

        public int hashCode() {
            return this.size;
        }

        public void init(int i) {
            this.size = i;
        }

        public String toString() {
            return SizeStrategy.w(this.size);
        }
    }

    @VisibleForTesting
    static class KeyPool extends c<Key> {
        KeyPool() {
        }

        /* access modifiers changed from: protected */
        public Key create() {
            return new Key(this);
        }

        public Key get(int i) {
            Key key = (Key) super.get();
            key.init(i);
            return key;
        }
    }

    SizeStrategy() {
    }

    private void g(Integer num) {
        Integer num2 = (Integer) this.og.get(num);
        if (num2.intValue() == 1) {
            this.og.remove(num);
        } else {
            this.og.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    private static String k(Bitmap bitmap) {
        return w(l.j(bitmap));
    }

    static String w(int i) {
        return "[" + i + "]";
    }

    public void a(Bitmap bitmap) {
        Key key = this.kg.get(l.j(bitmap));
        this.lg.a(key, bitmap);
        Integer num = (Integer) this.og.get(Integer.valueOf(key.size));
        NavigableMap<Integer, Integer> navigableMap = this.og;
        Integer valueOf = Integer.valueOf(key.size);
        int i = 1;
        if (num != null) {
            i = 1 + num.intValue();
        }
        navigableMap.put(valueOf, Integer.valueOf(i));
    }

    public String b(int i, int i2, Bitmap.Config config) {
        return w(l.g(i, i2, config));
    }

    public int c(Bitmap bitmap) {
        return l.j(bitmap);
    }

    @Nullable
    public Bitmap d(int i, int i2, Bitmap.Config config) {
        int g = l.g(i, i2, config);
        Key key = this.kg.get(g);
        Integer ceilingKey = this.og.ceilingKey(Integer.valueOf(g));
        if (!(ceilingKey == null || ceilingKey.intValue() == g || ceilingKey.intValue() > g * 8)) {
            this.kg.a(key);
            key = this.kg.get(ceilingKey.intValue());
        }
        Bitmap b2 = this.lg.b(key);
        if (b2 != null) {
            b2.reconfigure(i, i2, config);
            g(ceilingKey);
        }
        return b2;
    }

    public String e(Bitmap bitmap) {
        return k(bitmap);
    }

    @Nullable
    public Bitmap removeLast() {
        Bitmap removeLast = this.lg.removeLast();
        if (removeLast != null) {
            g(Integer.valueOf(l.j(removeLast)));
        }
        return removeLast;
    }

    public String toString() {
        return "SizeStrategy:\n  " + this.lg + "\n  SortedSizes" + this.og;
    }
}
