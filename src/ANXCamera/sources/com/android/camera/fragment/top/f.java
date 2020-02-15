package com.android.camera.fragment.top;

import android.content.DialogInterface;

/* compiled from: lambda */
public final /* synthetic */ class f implements DialogInterface.OnClickListener {
    private final /* synthetic */ FragmentTopAlert wb;

    public /* synthetic */ f(FragmentTopAlert fragmentTopAlert) {
        this.wb = fragmentTopAlert;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.wb.h(dialogInterface, i);
    }
}
