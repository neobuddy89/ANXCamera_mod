package miui.view.animation;

import android.view.animation.Interpolator;

public class ExponentialEaseOutInterpolator implements Interpolator {
    public float getInterpolation(float f2) {
        if (f2 == 1.0f) {
            return 1.0f;
        }
        return (float) ((-Math.pow(2.0d, (double) (f2 * -10.0f))) + 1.0d);
    }
}
