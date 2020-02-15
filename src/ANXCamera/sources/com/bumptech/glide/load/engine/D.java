package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bumptech.glide.util.l;

/* compiled from: ResourceRecycler */
class D {
    private boolean fg;
    private final Handler handler = new Handler(Looper.getMainLooper(), new a());

    /* compiled from: ResourceRecycler */
    private static final class a implements Handler.Callback {
        static final int eg = 1;

        a() {
        }

        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((A) message.obj).recycle();
            return true;
        }
    }

    D() {
    }

    /* access modifiers changed from: package-private */
    public void g(A<?> a2) {
        l.Jj();
        if (this.fg) {
            this.handler.obtainMessage(1, a2).sendToTarget();
            return;
        }
        this.fg = true;
        a2.recycle();
        this.fg = false;
    }
}
