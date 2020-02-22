package miui.util;

import miui.util.Pools;

class h {
    final /* synthetic */ Pools.a j;

    h(Pools.a aVar) {
        this.j = aVar;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            this.j.close();
        } finally {
            super.finalize();
        }
    }
}
