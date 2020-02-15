package com.android.camera.module.impl.component;

import com.android.camera.protocol.ModeCoordinatorImpl;
import com.android.camera.protocol.ModeProtocol;
import com.ss.android.vesdk.TERecorder;

public class LiveStickerChangeImpl implements ModeProtocol.StickerProtocol {
    private TERecorder mRecorder;

    public LiveStickerChangeImpl(TERecorder tERecorder) {
        this.mRecorder = tERecorder;
    }

    public void onStickerChanged(String str) {
        TERecorder tERecorder = this.mRecorder;
        tERecorder.switchEffect(FileUtils.STICKER_RESOURCE_DIR + str);
    }

    public void registerProtocol() {
        ModeCoordinatorImpl.getInstance().attachProtocol(178, this);
    }

    public void unRegisterProtocol() {
        ModeCoordinatorImpl.getInstance().detachProtocol(178, this);
    }
}
