package miui.maml.animation.interpolater;

import android.view.animation.Interpolator;

public class CircEaseOutInterpolater implements Interpolator {
    public float getInterpolation(float f2) {
        float f3 = f2 - 1.0f;
        return (float) Math.sqrt((double) (1.0f - (f3 * f3)));
    }
}
