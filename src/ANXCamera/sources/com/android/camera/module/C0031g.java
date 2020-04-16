package com.android.camera.module;

import com.android.camera.fragment.GoogleLensFragment;

/* renamed from: com.android.camera.module.g  reason: case insensitive filesystem */
/* compiled from: lambda */
public final /* synthetic */ class C0031g implements GoogleLensFragment.OnClickListener {
    private final /* synthetic */ float Ab;
    private final /* synthetic */ float Bb;
    private final /* synthetic */ int Cb;
    private final /* synthetic */ int Db;
    private final /* synthetic */ Camera2Module wb;

    public /* synthetic */ C0031g(Camera2Module camera2Module, float f2, float f3, int i, int i2) {
        this.wb = camera2Module;
        this.Ab = f2;
        this.Bb = f3;
        this.Cb = i;
        this.Db = i2;
    }

    public final void onOptionClick(int i) {
        this.wb.a(this.Ab, this.Bb, this.Cb, this.Db, i);
    }
}
