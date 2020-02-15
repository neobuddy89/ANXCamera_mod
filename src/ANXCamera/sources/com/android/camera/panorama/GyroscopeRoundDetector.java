package com.android.camera.panorama;

import android.hardware.SensorEvent;
import android.provider.MiuiSettings;
import com.android.camera.Util;

public class GyroscopeRoundDetector extends RoundDetector {
    private static final float NS2S = 1.0E-9f;
    private float mLastTimestamp;
    private float mRadianLandscape;
    private float mRadianPortrait;
    private float mTargetDegree = 360.0f;
    private boolean mUseSensor;

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001c, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0031, code lost:
        return r2;
     */
    public boolean detect() {
        synchronized (RoundDetector.SynchronizedObject) {
            boolean z = false;
            if (!this.mIsEndOk) {
                return false;
            }
            if (this.mDirection == 0) {
                if (this.mTargetDegree <= ((float) currentDegree())) {
                    z = true;
                }
            } else if (((double) currentDegree()) <= 360.0d - ((double) this.mTargetDegree)) {
                z = true;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00b5, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00a3  */
    public void onSensorChanged(SensorEvent sensorEvent) {
        boolean z;
        if (sensorEvent.sensor.getType() == 4 || sensorEvent.sensor.getType() == 16) {
            synchronized (RoundDetector.SynchronizedObject) {
                if (this.mUseSensor) {
                    boolean z2 = false;
                    if (!Util.isEqualsZero((double) this.mLastTimestamp)) {
                        float f2 = (((float) sensorEvent.timestamp) - this.mLastTimestamp) * NS2S;
                        float f3 = sensorEvent.values[0];
                        float f4 = sensorEvent.values[1];
                        this.mRadianLandscape += f3 * f2;
                        this.mRadianPortrait += f4 * f2;
                    }
                    this.mLastTimestamp = (float) sensorEvent.timestamp;
                    int radianToDegree = RoundDetector.radianToDegree(this.mRadianLandscape);
                    int radianToDegree2 = RoundDetector.radianToDegree(this.mRadianPortrait);
                    if (radianToDegree <= 0 && this.mDirection == 1) {
                        radianToDegree += MiuiSettings.ScreenEffect.SCREEN_PAPER_MODE_TWILIGHT_START_DEAULT;
                    }
                    if (radianToDegree2 <= 0 && this.mDirection == 1) {
                        radianToDegree2 += MiuiSettings.ScreenEffect.SCREEN_PAPER_MODE_TWILIGHT_START_DEAULT;
                    }
                    int i = this.isLandscape ? radianToDegree : radianToDegree2;
                    int i2 = this.isLandscape ? this.mCurrentDegreeLandscape : this.mCurrentDegreePortrait;
                    if (this.mDirection != 0) {
                        if (i2 != 0) {
                            if (i2 >= i && Math.abs(i - i2) < 180) {
                            }
                        }
                        z = true;
                        if (z) {
                            this.mCurrentDegreeLandscape = radianToDegree;
                            this.mCurrentDegreePortrait = radianToDegree2;
                        }
                        if (!this.mIsEndOk) {
                            if (180 <= currentDegree() && currentDegree() <= 190) {
                                z2 = true;
                            }
                            this.mIsEndOk = z2;
                        }
                    } else {
                        if (i2 != 0) {
                            if (i2 <= i && Math.abs(i - i2) < 180) {
                            }
                        }
                        z = true;
                        if (z) {
                        }
                        if (!this.mIsEndOk) {
                        }
                    }
                    z = false;
                    if (z) {
                    }
                    if (!this.mIsEndOk) {
                    }
                }
            }
        }
    }

    public void setStartPosition(int i, int i2, float f2, float f3, boolean z) {
        this.isLandscape = i == 0 || i == 180;
        synchronized (RoundDetector.SynchronizedObject) {
            this.mLastTimestamp = 0.0f;
            this.mRadianLandscape = 0.0f;
            this.mRadianPortrait = 0.0f;
            this.mCurrentDegreeLandscape = 0;
            this.mCurrentDegreePortrait = 0;
            this.mDirection = i2;
            this.mIsEndOk = false;
            this.mUseSensor = true;
            if (!z) {
                if (this.isLandscape) {
                    this.mTargetDegree = (360.0f - f2) + 20.0f;
                } else {
                    this.mTargetDegree = (360.0f - f3) + 20.0f;
                }
            }
        }
    }

    public void stop() {
        synchronized (RoundDetector.SynchronizedObject) {
            this.mUseSensor = false;
        }
    }
}
