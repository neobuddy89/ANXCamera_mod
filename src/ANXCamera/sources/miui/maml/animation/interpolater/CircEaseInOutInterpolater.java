package miui.maml.animation.interpolater;

import android.view.animation.Interpolator;

public class CircEaseInOutInterpolater implements Interpolator {
    public float getInterpolation(float f2) {
        float f3 = f2 * 2.0f;
        float f4 = f3;
        if (f3 < 1.0f) {
            return ((float) (Math.sqrt((double) (1.0f - (f4 * f4))) - 1.0d)) * -0.5f;
        }
        float f5 = f4 - 2.0f;
        return ((float) (Math.sqrt((double) (1.0f - (f5 * f5))) + 1.0d)) * 0.5f;
    }
}
