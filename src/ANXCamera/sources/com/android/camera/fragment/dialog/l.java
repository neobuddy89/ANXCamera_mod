package com.android.camera.fragment.dialog;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* compiled from: lambda */
public final /* synthetic */ class l implements DialogInterface.OnKeyListener {
    private final /* synthetic */ ThermalDialogFragment wb;

    public /* synthetic */ l(ThermalDialogFragment thermalDialogFragment) {
        this.wb = thermalDialogFragment;
    }

    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        return this.wb.a(dialogInterface, i, keyEvent);
    }
}
