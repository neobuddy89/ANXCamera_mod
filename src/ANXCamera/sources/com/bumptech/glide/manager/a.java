package com.bumptech.glide.manager;

import android.support.annotation.NonNull;
import com.bumptech.glide.util.l;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: ActivityFragmentLifecycle */
class a implements i {
    private final Set<j> qk = Collections.newSetFromMap(new WeakHashMap());
    private boolean rk;
    private boolean za;

    a() {
    }

    public void a(@NonNull j jVar) {
        this.qk.remove(jVar);
    }

    public void b(@NonNull j jVar) {
        this.qk.add(jVar);
        if (this.rk) {
            jVar.onDestroy();
        } else if (this.za) {
            jVar.onStart();
        } else {
            jVar.onStop();
        }
    }

    /* access modifiers changed from: package-private */
    public void onDestroy() {
        this.rk = true;
        for (T onDestroy : l.b(this.qk)) {
            onDestroy.onDestroy();
        }
    }

    /* access modifiers changed from: package-private */
    public void onStart() {
        this.za = true;
        for (T onStart : l.b(this.qk)) {
            onStart.onStart();
        }
    }

    /* access modifiers changed from: package-private */
    public void onStop() {
        this.za = false;
        for (T onStop : l.b(this.qk)) {
            onStop.onStop();
        }
    }
}
