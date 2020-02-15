package com.ss.android.vesdk;

public class VETestAnimator implements VEStickerAnimator {
    public float getDegree(int i) {
        VELogUtil.d("VETestAnimator", "timestamp: " + i);
        return (((float) i) / 1000.0f) * 36.0f;
    }

    public float getScaleX(int i) {
        return ((((float) i) / 1000.0f) * 0.1f) + 1.0f;
    }

    public float getScaleY(int i) {
        return ((((float) i) / 1000.0f) * 0.1f) + 1.0f;
    }

    public float getTransX(int i) {
        return (((float) i) / 1000.0f) * 0.1f;
    }

    public float getTransY(int i) {
        return (((float) i) / 1000.0f) * 0.1f;
    }
}
