package com.android.camera.fragment;

import android.content.DialogInterface;

/* compiled from: lambda */
public final /* synthetic */ class a implements DialogInterface.OnClickListener {
    private final /* synthetic */ CtaNoticeFragment wb;

    public /* synthetic */ a(CtaNoticeFragment ctaNoticeFragment) {
        this.wb = ctaNoticeFragment;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.wb.b(dialogInterface, i);
    }
}
