package miui.maml.animation.interpolater;

import android.view.animation.Interpolator;

public class QuartEaseInOutInterpolater implements Interpolator {
    public float getInterpolation(float f2) {
        float f3 = f2 * 2.0f;
        float f4 = f3;
        if (f3 < 1.0f) {
            return 0.5f * f4 * f4 * f4 * f4;
        }
        float f5 = f4 - 2.0f;
        float f6 = f5;
        return ((((f5 * f6) * f6) * f6) - 2.0f) * -0.5f;
    }
}
