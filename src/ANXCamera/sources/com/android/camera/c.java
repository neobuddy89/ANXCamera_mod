package com.android.camera;

import android.content.DialogInterface;

/* compiled from: lambda */
public final /* synthetic */ class c implements DialogInterface.OnClickListener {
    private final /* synthetic */ CameraPreferenceActivity wb;

    public /* synthetic */ c(CameraPreferenceActivity cameraPreferenceActivity) {
        this.wb = cameraPreferenceActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.wb.d(dialogInterface, i);
    }
}
