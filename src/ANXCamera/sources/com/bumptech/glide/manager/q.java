package com.bumptech.glide.manager;

import android.support.annotation.NonNull;
import com.bumptech.glide.request.target.o;
import com.bumptech.glide.util.l;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: TargetTracker */
public final class q implements j {
    private final Set<o<?>> targets = Collections.newSetFromMap(new WeakHashMap());

    public void clear() {
        this.targets.clear();
    }

    public void e(@NonNull o<?> oVar) {
        this.targets.remove(oVar);
    }

    public void f(@NonNull o<?> oVar) {
        this.targets.add(oVar);
    }

    @NonNull
    public List<o<?>> getAll() {
        return l.b(this.targets);
    }

    public void onDestroy() {
        for (T onDestroy : l.b(this.targets)) {
            onDestroy.onDestroy();
        }
    }

    public void onStart() {
        for (T onStart : l.b(this.targets)) {
            onStart.onStart();
        }
    }

    public void onStop() {
        for (T onStop : l.b(this.targets)) {
            onStop.onStop();
        }
    }
}
