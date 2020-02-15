package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.support.annotation.VisibleForTesting;
import com.bumptech.glide.util.l;

class AttributeStrategy implements k {
    private final KeyPool kg = new KeyPool();
    private final g<Key, Bitmap> lg = new g<>();

    @VisibleForTesting
    static class Key implements l {
        private Bitmap.Config config;
        private int height;
        private final KeyPool pool;
        private int width;

        public Key(KeyPool keyPool) {
            this.pool = keyPool;
        }

        public void J() {
            this.pool.a(this);
        }

        public void e(int i, int i2, Bitmap.Config config2) {
            this.width = i;
            this.height = i2;
            this.config = config2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            return this.width == key.width && this.height == key.height && this.config == key.config;
        }

        public int hashCode() {
            int i = ((this.width * 31) + this.height) * 31;
            Bitmap.Config config2 = this.config;
            return i + (config2 != null ? config2.hashCode() : 0);
        }

        public String toString() {
            return AttributeStrategy.f(this.width, this.height, this.config);
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

        /* access modifiers changed from: package-private */
        public Key d(int i, int i2, Bitmap.Config config) {
            Key key = (Key) get();
            key.e(i, i2, config);
            return key;
        }
    }

    AttributeStrategy() {
    }

    static String f(int i, int i2, Bitmap.Config config) {
        return "[" + i + "x" + i2 + "], " + config;
    }

    private static String k(Bitmap bitmap) {
        return f(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    public void a(Bitmap bitmap) {
        this.lg.a(this.kg.d(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    public String b(int i, int i2, Bitmap.Config config) {
        return f(i, i2, config);
    }

    public int c(Bitmap bitmap) {
        return l.j(bitmap);
    }

    public Bitmap d(int i, int i2, Bitmap.Config config) {
        return this.lg.b(this.kg.d(i, i2, config));
    }

    public String e(Bitmap bitmap) {
        return k(bitmap);
    }

    public Bitmap removeLast() {
        return this.lg.removeLast();
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.lg;
    }
}
