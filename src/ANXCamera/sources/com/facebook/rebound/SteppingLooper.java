package com.facebook.rebound;

public class SteppingLooper extends SpringLooper {
    private long mLastTime;
    private boolean mStarted;

    public void start() {
        this.mStarted = true;
        this.mLastTime = 0;
    }

    public boolean step(long j) {
        BaseSpringSystem baseSpringSystem = this.mSpringSystem;
        if (baseSpringSystem == null || !this.mStarted) {
            return false;
        }
        long j2 = this.mLastTime + j;
        baseSpringSystem.loop((double) j2);
        this.mLastTime = j2;
        return this.mSpringSystem.getIsIdle();
    }

    public void stop() {
        this.mStarted = false;
    }
}
