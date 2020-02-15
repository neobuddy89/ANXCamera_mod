package com.android.camera.fragment;

import android.content.DialogInterface;

/* compiled from: lambda */
public final /* synthetic */ class g implements DialogInterface.OnClickListener {
    private final /* synthetic */ GoogleLensFragment wb;

    public /* synthetic */ g(GoogleLensFragment googleLensFragment) {
        this.wb = googleLensFragment;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.wb.c(dialogInterface, i);
    }
}
