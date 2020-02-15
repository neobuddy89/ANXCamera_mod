package com.bumptech.glide.load.engine.prefill;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: PreFillQueue */
final class b {
    private final Map<c, Integer> Kh;
    private final List<c> Lh;
    private int Mh;
    private int Nh;

    public b(Map<c, Integer> map) {
        this.Kh = map;
        this.Lh = new ArrayList(map.keySet());
        for (Integer intValue : map.values()) {
            this.Mh += intValue.intValue();
        }
    }

    public int getSize() {
        return this.Mh;
    }

    public boolean isEmpty() {
        return this.Mh == 0;
    }

    public c remove() {
        c cVar = this.Lh.get(this.Nh);
        Integer num = this.Kh.get(cVar);
        if (num.intValue() == 1) {
            this.Kh.remove(cVar);
            this.Lh.remove(this.Nh);
        } else {
            this.Kh.put(cVar, Integer.valueOf(num.intValue() - 1));
        }
        this.Mh--;
        this.Nh = this.Lh.isEmpty() ? 0 : (this.Nh + 1) % this.Lh.size();
        return cVar;
    }
}
