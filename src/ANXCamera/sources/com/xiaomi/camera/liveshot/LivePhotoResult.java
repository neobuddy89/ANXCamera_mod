package com.xiaomi.camera.liveshot;

public class LivePhotoResult {
    boolean isGyroscopeStable;
    int mAEState;
    int mAWBState;
    int mFilterId;
    long mTimpSnap;

    public int getAEState() {
        return this.mAEState;
    }

    public int getAWBState() {
        return this.mAWBState;
    }

    public int getFilterId() {
        return this.mFilterId;
    }

    public long getTimeStamp() {
        return this.mTimpSnap;
    }

    public boolean isGyroScopeStable() {
        return this.isGyroscopeStable;
    }

    public void setAEState(int i) {
        this.mAEState = i;
    }

    public void setAWBState(int i) {
        this.mAWBState = i;
    }

    public void setFilterId(int i) {
        this.mFilterId = i;
    }

    public void setGyroscropStable(boolean z) {
        this.isGyroscopeStable = z;
    }

    public void setTimeStamp(long j) {
        this.mTimpSnap = j;
    }

    public String toString() {
        return ("LivePhoto AEState is " + this.mAEState) + (" time stamp is " + this.mTimpSnap) + (" gryo is " + this.isGyroscopeStable) + (" filterid is " + this.mFilterId) + (" awb is " + this.mAWBState);
    }
}
