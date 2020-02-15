package com.android.camera;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* compiled from: lambda */
public final /* synthetic */ class f implements DialogInterface.OnKeyListener {
    public static final /* synthetic */ f INSTANCE = new f();

    private /* synthetic */ f() {
    }

    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        return RotateDialogController.b(dialogInterface, i, keyEvent);
    }
}
