package miui.view.animation;

import android.view.animation.Interpolator;

public class ExponentialEaseInInterpolator implements Interpolator {
    public float getInterpolation(float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        return (float) Math.pow(2.0d, (double) ((f2 - 1.0f) * 10.0f));
    }
}
