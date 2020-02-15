package com.android.camera.fragment.dialog;

import android.content.DialogInterface;

/* compiled from: lambda */
public final /* synthetic */ class b implements DialogInterface.OnClickListener {
    private final /* synthetic */ FragmentLiveReview wb;

    public /* synthetic */ b(FragmentLiveReview fragmentLiveReview) {
        this.wb = fragmentLiveReview;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.wb.f(dialogInterface, i);
    }
}
