package com.bumptech.glide.request;

import android.support.annotation.Nullable;

/* compiled from: ErrorRequestCoordinator */
public final class a implements d, c {
    private c error;
    @Nullable
    private final d parent;
    private c primary;

    public a(@Nullable d dVar) {
        this.parent = dVar;
    }

    private boolean j(c cVar) {
        return cVar.equals(this.primary) || (this.primary.isFailed() && cVar.equals(this.error));
    }

    private boolean sm() {
        d dVar = this.parent;
        return dVar == null || dVar.g(this);
    }

    private boolean tm() {
        d dVar = this.parent;
        return dVar == null || dVar.c(this);
    }

    private boolean um() {
        d dVar = this.parent;
        return dVar == null || dVar.d(this);
    }

    private boolean vm() {
        d dVar = this.parent;
        return dVar != null && dVar.z();
    }

    public boolean A() {
        return (this.primary.isFailed() ? this.error : this.primary).A();
    }

    public void a(c cVar, c cVar2) {
        this.primary = cVar;
        this.error = cVar2;
    }

    public boolean a(c cVar) {
        if (!(cVar instanceof a)) {
            return false;
        }
        a aVar = (a) cVar;
        return this.primary.a(aVar.primary) && this.error.a(aVar.error);
    }

    public void b(c cVar) {
        d dVar = this.parent;
        if (dVar != null) {
            dVar.b(this);
        }
    }

    public void begin() {
        if (!this.primary.isRunning()) {
            this.primary.begin();
        }
    }

    public boolean c(c cVar) {
        return tm() && j(cVar);
    }

    public void clear() {
        this.primary.clear();
        if (this.error.isRunning()) {
            this.error.clear();
        }
    }

    public boolean d(c cVar) {
        return um() && j(cVar);
    }

    public void e(c cVar) {
        if (cVar.equals(this.error)) {
            d dVar = this.parent;
            if (dVar != null) {
                dVar.e(this);
            }
        } else if (!this.error.isRunning()) {
            this.error.begin();
        }
    }

    public boolean g(c cVar) {
        return sm() && j(cVar);
    }

    public boolean isCancelled() {
        return (this.primary.isFailed() ? this.error : this.primary).isCancelled();
    }

    public boolean isComplete() {
        return (this.primary.isFailed() ? this.error : this.primary).isComplete();
    }

    public boolean isFailed() {
        return this.primary.isFailed() && this.error.isFailed();
    }

    public boolean isPaused() {
        return (this.primary.isFailed() ? this.error : this.primary).isPaused();
    }

    public boolean isRunning() {
        return (this.primary.isFailed() ? this.error : this.primary).isRunning();
    }

    public void pause() {
        if (!this.primary.isFailed()) {
            this.primary.pause();
        }
        if (this.error.isRunning()) {
            this.error.pause();
        }
    }

    public void recycle() {
        this.primary.recycle();
        this.error.recycle();
    }

    public boolean z() {
        return vm() || A();
    }
}
