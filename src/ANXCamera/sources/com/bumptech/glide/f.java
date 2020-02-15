package com.bumptech.glide;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.AbsListView;
import com.bumptech.glide.request.target.n;
import com.bumptech.glide.request.target.o;
import com.bumptech.glide.util.l;
import java.util.List;
import java.util.Queue;

/* compiled from: ListPreloader */
public class f<T> implements AbsListView.OnScrollListener {
    private final int Wb;
    private final d Xb;
    private final a<T> Yb;
    private final b<T> Zb;
    private int _b;
    private int bc;
    private int dc = -1;
    private final m ea;
    private int ec;
    private boolean fc = true;

    /* compiled from: ListPreloader */
    public interface a<U> {
        @Nullable
        j<?> f(@NonNull U u);

        @NonNull
        List<U> g(int i);
    }

    /* compiled from: ListPreloader */
    public interface b<T> {
        @Nullable
        int[] a(@NonNull T t, int i, int i2);
    }

    /* compiled from: ListPreloader */
    private static final class c extends com.bumptech.glide.request.target.b<Object> {
        int Hl;
        int Il;

        c() {
        }

        public void a(@NonNull n nVar) {
        }

        public void a(@NonNull Object obj, @Nullable com.bumptech.glide.request.a.f<? super Object> fVar) {
        }

        public void b(@NonNull n nVar) {
            nVar.b(this.Il, this.Hl);
        }
    }

    /* compiled from: ListPreloader */
    private static final class d {
        private final Queue<c> queue;

        d(int i) {
            this.queue = l.createQueue(i);
            for (int i2 = 0; i2 < i; i2++) {
                this.queue.offer(new c());
            }
        }

        public c f(int i, int i2) {
            c poll = this.queue.poll();
            this.queue.offer(poll);
            poll.Il = i;
            poll.Hl = i2;
            return poll;
        }
    }

    public f(@NonNull m mVar, @NonNull a<T> aVar, @NonNull b<T> bVar, int i) {
        this.ea = mVar;
        this.Yb = aVar;
        this.Zb = bVar;
        this.Wb = i;
        this.Xb = new d(i + 1);
    }

    private void a(int i, boolean z) {
        if (this.fc != z) {
            this.fc = z;
            cancelAll();
        }
        i(i, (z ? this.Wb : -this.Wb) + i);
    }

    private void a(List<T> list, int i, boolean z) {
        int size = list.size();
        if (z) {
            for (int i2 = 0; i2 < size; i2++) {
                c(list.get(i2), i, i2);
            }
            return;
        }
        for (int i3 = size - 1; i3 >= 0; i3--) {
            c(list.get(i3), i, i3);
        }
    }

    private void c(@Nullable T t, int i, int i2) {
        if (t != null) {
            int[] a2 = this.Zb.a(t, i, i2);
            if (a2 != null) {
                j<?> f2 = this.Yb.f(t);
                if (f2 != null) {
                    f2.c(this.Xb.f(a2[0], a2[1]));
                }
            }
        }
    }

    private void cancelAll() {
        for (int i = 0; i < this.Wb; i++) {
            this.ea.d((o<?>) this.Xb.f(0, 0));
        }
    }

    private void i(int i, int i2) {
        int i3;
        int i4;
        if (i < i2) {
            i3 = Math.max(this._b, i);
            i4 = i2;
        } else {
            i4 = Math.min(this.bc, i);
            i3 = i2;
        }
        int min = Math.min(this.ec, i4);
        int min2 = Math.min(this.ec, Math.max(0, i3));
        if (i < i2) {
            for (int i5 = min2; i5 < min; i5++) {
                a(this.Yb.g(i5), i5, true);
            }
        } else {
            for (int i6 = min - 1; i6 >= min2; i6--) {
                a(this.Yb.g(i6), i6, false);
            }
        }
        this.bc = min2;
        this._b = min;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.ec = i3;
        int i4 = this.dc;
        if (i > i4) {
            a(i2 + i, true);
        } else if (i < i4) {
            a(i, false);
        }
        this.dc = i;
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
