package com.android.camera.fragment;

import android.content.DialogInterface;

/* compiled from: lambda */
public final /* synthetic */ class b implements DialogInterface.OnClickListener {
    private final /* synthetic */ CtaNoticeFragment wb;

    public /* synthetic */ b(CtaNoticeFragment ctaNoticeFragment) {
        this.wb = ctaNoticeFragment;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.wb.a(dialogInterface, i);
    }
}
