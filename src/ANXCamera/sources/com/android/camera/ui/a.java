package com.android.camera.ui;

import android.animation.ValueAnimator;

/* compiled from: lambda */
public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {
    private final /* synthetic */ float Ab;
    private final /* synthetic */ float Bb;
    private final /* synthetic */ float Cb;
    private final /* synthetic */ float Db;
    private final /* synthetic */ MutiStateButton wb;

    public /* synthetic */ a(MutiStateButton mutiStateButton, float f2, float f3, float f4, float f5) {
        this.wb = mutiStateButton;
        this.Ab = f2;
        this.Bb = f3;
        this.Cb = f4;
        this.Db = f5;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.wb.a(this.Ab, this.Bb, this.Cb, this.Db, valueAnimator);
    }
}
