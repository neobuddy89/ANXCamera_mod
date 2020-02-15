package com.bumptech.glide.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.bumptech.glide.f;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.request.target.n;
import java.util.Arrays;

/* compiled from: ViewPreloadSizeProvider */
public class m<T> implements f.b<T>, n {
    private a rm;
    private int[] size;

    /* compiled from: ViewPreloadSizeProvider */
    private static final class a extends ViewTarget<View, Object> {
        a(@NonNull View view, @NonNull n nVar) {
            super(view);
            b(nVar);
        }

        public void a(@NonNull Object obj, @Nullable com.bumptech.glide.request.a.f<? super Object> fVar) {
        }
    }

    public m() {
    }

    public m(@NonNull View view) {
        this.rm = new a(view, this);
    }

    @Nullable
    public int[] a(@NonNull T t, int i, int i2) {
        int[] iArr = this.size;
        if (iArr == null) {
            return null;
        }
        return Arrays.copyOf(iArr, iArr.length);
    }

    public void b(int i, int i2) {
        this.size = new int[]{i, i2};
        this.rm = null;
    }

    public void setView(@NonNull View view) {
        if (this.size == null && this.rm == null) {
            this.rm = new a(view, this);
        }
    }
}
