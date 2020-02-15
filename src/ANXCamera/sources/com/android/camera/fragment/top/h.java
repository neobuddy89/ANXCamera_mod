package com.android.camera.fragment.top;

import android.content.DialogInterface;

/* compiled from: lambda */
public final /* synthetic */ class h implements DialogInterface.OnClickListener {
    private final /* synthetic */ FragmentTopAlert wb;

    public /* synthetic */ h(FragmentTopAlert fragmentTopAlert) {
        this.wb = fragmentTopAlert;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.wb.i(dialogInterface, i);
    }
}
