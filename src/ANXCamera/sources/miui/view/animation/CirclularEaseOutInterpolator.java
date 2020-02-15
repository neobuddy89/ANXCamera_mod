package miui.view.animation;

import android.view.animation.Interpolator;

public class CirclularEaseOutInterpolator implements Interpolator {
    public float getInterpolation(float f2) {
        float f3 = f2 - 1.0f;
        return (float) Math.sqrt((double) (1.0f - (f3 * f3)));
    }
}
