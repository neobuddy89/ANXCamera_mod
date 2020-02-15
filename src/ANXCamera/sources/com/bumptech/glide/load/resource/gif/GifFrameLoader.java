package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.bumptech.glide.c;
import com.bumptech.glide.load.engine.bitmap_recycle.d;
import com.bumptech.glide.load.j;
import com.bumptech.glide.m;
import com.bumptech.glide.request.a.f;
import com.bumptech.glide.request.target.o;
import com.bumptech.glide.util.i;
import com.bumptech.glide.util.l;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

class GifFrameLoader {
    private final d Eb;
    private final com.bumptech.glide.b.a Zj;
    private boolean _j;
    private boolean bk;
    private final List<a> callbacks;
    private j<Bitmap> cg;
    private com.bumptech.glide.j<Bitmap> ck;
    private DelayTarget current;
    private boolean dk;
    final m ea;
    private DelayTarget ek;
    private Bitmap firstFrame;
    @Nullable
    private OnEveryFrameListener fk;
    private final Handler handler;
    private boolean isRunning;
    private DelayTarget next;

    @VisibleForTesting
    static class DelayTarget extends com.bumptech.glide.request.target.m<Bitmap> {
        private final long Jl;
        private final Handler handler;
        final int index;
        private Bitmap resource;

        DelayTarget(Handler handler2, int i, long j) {
            this.handler = handler2;
            this.index = i;
            this.Jl = j;
        }

        public void a(@NonNull Bitmap bitmap, @Nullable f<? super Bitmap> fVar) {
            this.resource = bitmap;
            this.handler.sendMessageAtTime(this.handler.obtainMessage(1, this), this.Jl);
        }

        /* access modifiers changed from: package-private */
        public Bitmap vi() {
            return this.resource;
        }
    }

    @VisibleForTesting
    interface OnEveryFrameListener {
        void B();
    }

    public interface a {
        void B();
    }

    private class b implements Handler.Callback {
        static final int Xj = 1;
        static final int Yj = 2;

        b() {
        }

        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                GifFrameLoader.this.onFrameReady((DelayTarget) message.obj);
                return true;
            } else if (i != 2) {
                return false;
            } else {
                GifFrameLoader.this.ea.d((o<?>) (DelayTarget) message.obj);
                return false;
            }
        }
    }

    GifFrameLoader(c cVar, com.bumptech.glide.b.a aVar, int i, int i2, j<Bitmap> jVar, Bitmap bitmap) {
        this(cVar.Dh(), c.G(cVar.getContext()), aVar, (Handler) null, b(c.G(cVar.getContext()), i, i2), jVar, bitmap);
    }

    GifFrameLoader(d dVar, m mVar, com.bumptech.glide.b.a aVar, Handler handler2, com.bumptech.glide.j<Bitmap> jVar, j<Bitmap> jVar2, Bitmap bitmap) {
        this.callbacks = new ArrayList();
        this.ea = mVar;
        handler2 = handler2 == null ? new Handler(Looper.getMainLooper(), new b()) : handler2;
        this.Eb = dVar;
        this.handler = handler2;
        this.ck = jVar;
        this.Zj = aVar;
        a(jVar2, bitmap);
    }

    private static com.bumptech.glide.j<Bitmap> b(m mVar, int i, int i2) {
        return mVar.Lh().b(com.bumptech.glide.request.f.b(com.bumptech.glide.load.engine.o.NONE).x(true).v(true).l(i, i2));
    }

    private int getFrameSize() {
        return l.g(Ii().getWidth(), Ii().getHeight(), Ii().getConfig());
    }

    private static com.bumptech.glide.load.c pm() {
        return new com.bumptech.glide.e.d(Double.valueOf(Math.random()));
    }

    private void qm() {
        if (this.isRunning && !this._j) {
            if (this.bk) {
                i.b(this.ek == null, "Pending target must be null when starting from the first frame");
                this.Zj.H();
                this.bk = false;
            }
            DelayTarget delayTarget = this.ek;
            if (delayTarget != null) {
                this.ek = null;
                onFrameReady(delayTarget);
                return;
            }
            this._j = true;
            long uptimeMillis = SystemClock.uptimeMillis() + ((long) this.Zj.X());
            this.Zj.advance();
            this.next = new DelayTarget(this.handler, this.Zj.K(), uptimeMillis);
            this.ck.b(com.bumptech.glide.request.f.h(pm())).load((Object) this.Zj).c(this.next);
        }
    }

    private void rm() {
        Bitmap bitmap = this.firstFrame;
        if (bitmap != null) {
            this.Eb.a(bitmap);
            this.firstFrame = null;
        }
    }

    private void start() {
        if (!this.isRunning) {
            this.isRunning = true;
            this.dk = false;
            qm();
        }
    }

    private void stop() {
        this.isRunning = false;
    }

    /* access modifiers changed from: package-private */
    public Bitmap Ii() {
        DelayTarget delayTarget = this.current;
        return delayTarget != null ? delayTarget.vi() : this.firstFrame;
    }

    /* access modifiers changed from: package-private */
    public void Ji() {
        i.b(!this.isRunning, "Can't restart a running animation");
        this.bk = true;
        DelayTarget delayTarget = this.ek;
        if (delayTarget != null) {
            this.ea.d((o<?>) delayTarget);
            this.ek = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(j<Bitmap> jVar, Bitmap bitmap) {
        i.checkNotNull(jVar);
        this.cg = jVar;
        i.checkNotNull(bitmap);
        this.firstFrame = bitmap;
        this.ck = this.ck.b(new com.bumptech.glide.request.f().c(jVar));
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar) {
        if (this.dk) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        } else if (!this.callbacks.contains(aVar)) {
            boolean isEmpty = this.callbacks.isEmpty();
            this.callbacks.add(aVar);
            if (isEmpty) {
                start();
            }
        } else {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
    }

    /* access modifiers changed from: package-private */
    public void b(a aVar) {
        this.callbacks.remove(aVar);
        if (this.callbacks.isEmpty()) {
            stop();
        }
    }

    /* access modifiers changed from: package-private */
    public void clear() {
        this.callbacks.clear();
        rm();
        stop();
        DelayTarget delayTarget = this.current;
        if (delayTarget != null) {
            this.ea.d((o<?>) delayTarget);
            this.current = null;
        }
        DelayTarget delayTarget2 = this.next;
        if (delayTarget2 != null) {
            this.ea.d((o<?>) delayTarget2);
            this.next = null;
        }
        DelayTarget delayTarget3 = this.ek;
        if (delayTarget3 != null) {
            this.ea.d((o<?>) delayTarget3);
            this.ek = null;
        }
        this.Zj.clear();
        this.dk = true;
    }

    /* access modifiers changed from: package-private */
    public ByteBuffer getBuffer() {
        return this.Zj.getData().asReadOnlyBuffer();
    }

    /* access modifiers changed from: package-private */
    public int getCurrentIndex() {
        DelayTarget delayTarget = this.current;
        if (delayTarget != null) {
            return delayTarget.index;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public int getFrameCount() {
        return this.Zj.getFrameCount();
    }

    /* access modifiers changed from: package-private */
    public int getHeight() {
        return Ii().getHeight();
    }

    /* access modifiers changed from: package-private */
    public int getLoopCount() {
        return this.Zj.U();
    }

    /* access modifiers changed from: package-private */
    public int getSize() {
        return this.Zj.M() + getFrameSize();
    }

    /* access modifiers changed from: package-private */
    public int getWidth() {
        return Ii().getWidth();
    }

    /* access modifiers changed from: package-private */
    public Bitmap oa() {
        return this.firstFrame;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void onFrameReady(DelayTarget delayTarget) {
        OnEveryFrameListener onEveryFrameListener = this.fk;
        if (onEveryFrameListener != null) {
            onEveryFrameListener.B();
        }
        this._j = false;
        if (this.dk) {
            this.handler.obtainMessage(2, delayTarget).sendToTarget();
        } else if (!this.isRunning) {
            this.ek = delayTarget;
        } else {
            if (delayTarget.vi() != null) {
                rm();
                DelayTarget delayTarget2 = this.current;
                this.current = delayTarget;
                for (int size = this.callbacks.size() - 1; size >= 0; size--) {
                    this.callbacks.get(size).B();
                }
                if (delayTarget2 != null) {
                    this.handler.obtainMessage(2, delayTarget2).sendToTarget();
                }
            }
            qm();
        }
    }

    /* access modifiers changed from: package-private */
    public j<Bitmap> qa() {
        return this.cg;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void setOnEveryFrameReadyListener(@Nullable OnEveryFrameListener onEveryFrameListener) {
        this.fk = onEveryFrameListener;
    }
}
