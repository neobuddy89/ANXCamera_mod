package miui.maml.animation.interpolater;

import android.view.animation.Interpolator;

public class ExpoEaseInOutInterpolater implements Interpolator {
    public float getInterpolation(float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        if (f2 == 1.0f) {
            return 1.0f;
        }
        float f3 = 2.0f * f2;
        float f4 = f3;
        if (f3 < 1.0f) {
            return ((float) Math.pow(2.0d, (double) ((f4 - 1.0f) * 10.0f))) * 0.5f;
        }
        float f5 = f4 - 1.0f;
        float f6 = f5;
        return ((float) ((-Math.pow(2.0d, (double) (f5 * -10.0f))) + 2.0d)) * 0.5f;
    }
}
