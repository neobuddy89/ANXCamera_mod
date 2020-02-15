package miui.view.animation;

import android.view.animation.Interpolator;

public class ExponentialEaseInOutInterpolator implements Interpolator {
    public float getInterpolation(float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        if (f2 == 1.0f) {
            return 1.0f;
        }
        float f3 = f2 * 2.0f;
        return ((float) (f3 < 1.0f ? Math.pow(2.0d, (double) ((f3 - 1.0f) * 10.0f)) : (-Math.pow(2.0d, (double) ((f3 - 1.0f) * -10.0f))) + 2.0d)) * 0.5f;
    }
}
