package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Message;
import com.bumptech.glide.load.engine.ActiveResources;

/* renamed from: com.bumptech.glide.load.engine.a  reason: case insensitive filesystem */
/* compiled from: ActiveResources */
class C0142a implements Handler.Callback {
    final /* synthetic */ ActiveResources this$0;

    C0142a(ActiveResources activeResources) {
        this.this$0 = activeResources;
    }

    public boolean handleMessage(Message message) {
        if (message.what != 1) {
            return false;
        }
        this.this$0.a((ActiveResources.ResourceWeakReference) message.obj);
        return true;
    }
}
