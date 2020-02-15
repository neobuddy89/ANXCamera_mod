package com.bumptech.glide.request;

import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;

/* compiled from: ThumbnailRequestCoordinator */
public class i implements d, c {
    private c Gl;
    private boolean isRunning;
    @Nullable
    private final d parent;
    private c thumb;

    @VisibleForTesting
    i() {
        this((d) null);
    }

    public i(@Nullable d dVar) {
        this.parent = dVar;
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
        return this.Gl.A() || this.thumb.A();
    }

    public void a(c cVar, c cVar2) {
        this.Gl = cVar;
        this.thumb = cVar2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0029 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    public boolean a(c cVar) {
        if (!(cVar instanceof i)) {
            return false;
        }
        i iVar = (i) cVar;
        c cVar2 = this.Gl;
        if (cVar2 == null) {
            if (iVar.Gl != null) {
                return false;
            }
        } else if (!cVar2.a(iVar.Gl)) {
            return false;
        }
        c cVar3 = this.thumb;
        if (cVar3 == null) {
            return iVar.thumb == null;
        }
        if (!cVar3.a(iVar.thumb)) {
            return false;
        }
    }

    public void b(c cVar) {
        if (!cVar.equals(this.thumb)) {
            d dVar = this.parent;
            if (dVar != null) {
                dVar.b(this);
            }
            if (!this.thumb.isComplete()) {
                this.thumb.clear();
            }
        }
    }

    public void begin() {
        this.isRunning = true;
        if (!this.Gl.isComplete() && !this.thumb.isRunning()) {
            this.thumb.begin();
        }
        if (this.isRunning && !this.Gl.isRunning()) {
            this.Gl.begin();
        }
    }

    public boolean c(c cVar) {
        return tm() && cVar.equals(this.Gl) && !z();
    }

    public void clear() {
        this.isRunning = false;
        this.thumb.clear();
        this.Gl.clear();
    }

    public boolean d(c cVar) {
        return um() && (cVar.equals(this.Gl) || !this.Gl.A());
    }

    public void e(c cVar) {
        if (cVar.equals(this.Gl)) {
            d dVar = this.parent;
            if (dVar != null) {
                dVar.e(this);
            }
        }
    }

    public boolean g(c cVar) {
        return sm() && cVar.equals(this.Gl);
    }

    public boolean isCancelled() {
        return this.Gl.isCancelled();
    }

    public boolean isComplete() {
        return this.Gl.isComplete() || this.thumb.isComplete();
    }

    public boolean isFailed() {
        return this.Gl.isFailed();
    }

    public boolean isPaused() {
        return this.Gl.isPaused();
    }

    public boolean isRunning() {
        return this.Gl.isRunning();
    }

    public void pause() {
        this.isRunning = false;
        this.Gl.pause();
        this.thumb.pause();
    }

    public void recycle() {
        this.Gl.recycle();
        this.thumb.recycle();
    }

    public boolean z() {
        return vm() || A();
    }
}
