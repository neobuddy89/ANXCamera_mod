package com.android.camera;

import android.content.DialogInterface;

/* compiled from: lambda */
public final /* synthetic */ class b implements DialogInterface.OnClickListener {
    private final /* synthetic */ CameraPreferenceActivity wb;

    public /* synthetic */ b(CameraPreferenceActivity cameraPreferenceActivity) {
        this.wb = cameraPreferenceActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.wb.e(dialogInterface, i);
    }
}
