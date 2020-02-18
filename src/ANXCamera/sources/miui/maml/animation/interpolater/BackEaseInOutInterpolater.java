package miui.maml.animation.interpolater;

import android.view.animation.Interpolator;

public class BackEaseInOutInterpolater implements Interpolator {
    private final float mFactor;

    public BackEaseInOutInterpolater() {
        this.mFactor = 1.70158f;
    }

    public BackEaseInOutInterpolater(float f2) {
        this.mFactor = f2;
    }

    public float getInterpolation(float f2) {
        float f3 = this.mFactor;
        float f4 = f2 * 2.0f;
        float f5 = f4;
        if (f4 < 1.0f) {
            float f6 = (float) (((double) f3) * 1.525d);
            return f5 * f5 * (((f6 + 1.0f) * f5) - f6) * 0.5f;
        }
        float f7 = f5 - 2.0f;
        float f8 = f7;
        float f9 = (float) (((double) f3) * 1.525d);
        return ((f7 * f8 * (((f9 + 1.0f) * f8) + f9)) + 2.0f) * 0.5f;
    }
}
