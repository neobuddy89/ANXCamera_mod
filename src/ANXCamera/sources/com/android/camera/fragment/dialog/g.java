package com.android.camera.fragment.dialog;

import android.content.DialogInterface;

/* compiled from: lambda */
public final /* synthetic */ class g implements DialogInterface.OnClickListener {
    private final /* synthetic */ FragmentLiveReview wb;

    public /* synthetic */ g(FragmentLiveReview fragmentLiveReview) {
        this.wb = fragmentLiveReview;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.wb.g(dialogInterface, i);
    }
}
