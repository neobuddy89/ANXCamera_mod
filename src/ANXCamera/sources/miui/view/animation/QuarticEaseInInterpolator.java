package miui.view.animation;

import android.view.animation.Interpolator;

public class QuarticEaseInInterpolator implements Interpolator {
    public float getInterpolation(float f2) {
        return f2 * f2 * f2 * f2;
    }
}
