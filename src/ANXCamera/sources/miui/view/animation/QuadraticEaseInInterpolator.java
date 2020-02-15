package miui.view.animation;

import android.view.animation.Interpolator;

public class QuadraticEaseInInterpolator implements Interpolator {
    public float getInterpolation(float f2) {
        return f2 * f2;
    }
}
