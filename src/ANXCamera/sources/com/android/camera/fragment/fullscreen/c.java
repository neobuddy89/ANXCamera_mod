package com.android.camera.fragment.fullscreen;

import com.android.camera.fragment.fullscreen.FragmentFullScreen;
import com.android.camera.protocol.ModeProtocol;

/* compiled from: lambda */
public final /* synthetic */ class c implements FragmentFullScreen.OnFrameUpdatedCallback {
    private final /* synthetic */ ModeProtocol.LiveVideoEditor Ab;
    private final /* synthetic */ FragmentFullScreen wb;

    public /* synthetic */ c(FragmentFullScreen fragmentFullScreen, ModeProtocol.LiveVideoEditor liveVideoEditor) {
        this.wb = fragmentFullScreen;
        this.Ab = liveVideoEditor;
    }

    public final void onUpdate() {
        this.wb.a(this.Ab);
    }
}
