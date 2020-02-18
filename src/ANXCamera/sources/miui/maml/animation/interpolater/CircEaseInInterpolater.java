package miui.maml.animation.interpolater;

import android.view.animation.Interpolator;

public class CircEaseInInterpolater implements Interpolator {
    public float getInterpolation(float f2) {
        return -((float) (Math.sqrt((double) (1.0f - (f2 * f2))) - 1.0d));
    }
}
