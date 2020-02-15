package com.android.camera.module.impl.component;

import com.android.camera.protocol.ModeCoordinatorImpl;
import com.android.camera.protocol.ModeProtocol;
import java.util.ArrayList;
import java.util.Iterator;

public class BeautyRecordingImpl implements ModeProtocol.BeautyRecording {
    private ArrayList<ModeProtocol.HandleBeautyRecording> recordingArrayList = new ArrayList<>();

    public static BeautyRecordingImpl create() {
        return new BeautyRecordingImpl();
    }

    public <P extends ModeProtocol.HandleBeautyRecording> void addBeautyStack(P p) {
        this.recordingArrayList.add(p);
    }

    public void handleAngleChang(float f2) {
        Iterator<ModeProtocol.HandleBeautyRecording> it = this.recordingArrayList.iterator();
        while (it.hasNext()) {
            it.next().onAngleChanged(f2);
        }
    }

    public void handleBeautyRecordingStart() {
        Iterator<ModeProtocol.HandleBeautyRecording> it = this.recordingArrayList.iterator();
        while (it.hasNext()) {
            it.next().onBeautyRecordingStart();
        }
    }

    public void handleBeautyRecordingStop() {
        Iterator<ModeProtocol.HandleBeautyRecording> it = this.recordingArrayList.iterator();
        while (it.hasNext()) {
            it.next().onBeautyRecordingStop();
        }
    }

    public void registerProtocol() {
        ModeCoordinatorImpl.getInstance().attachProtocol(173, this);
    }

    public <P extends ModeProtocol.HandleBeautyRecording> void removeBeautyStack(P p) {
        this.recordingArrayList.remove(p);
    }

    public void unRegisterProtocol() {
        this.recordingArrayList.clear();
        ModeCoordinatorImpl.getInstance().detachProtocol(173, this);
    }
}
