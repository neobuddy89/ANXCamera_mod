package miui.view.animation;

import android.view.animation.Interpolator;

public class SineEaseInOutInterpolator implements Interpolator {
    public float getInterpolation(float f2) {
        return ((float) (Math.cos(((double) f2) * 3.141592653589793d) - 1.0d)) * -0.5f;
    }
}
