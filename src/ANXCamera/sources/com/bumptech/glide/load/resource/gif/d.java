package com.bumptech.glide.load.resource.gif;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.b.b.b;
import com.bumptech.glide.load.engine.v;

/* compiled from: GifDrawableResource */
public class d extends b<b> implements v {
    public d(b bVar) {
        super(bVar);
    }

    @NonNull
    public Class<b> O() {
        return b.class;
    }

    public int getSize() {
        return ((b) this.drawable).getSize();
    }

    public void initialize() {
        ((b) this.drawable).oa().prepareToDraw();
    }

    public void recycle() {
        ((b) this.drawable).stop();
        ((b) this.drawable).recycle();
    }
}
