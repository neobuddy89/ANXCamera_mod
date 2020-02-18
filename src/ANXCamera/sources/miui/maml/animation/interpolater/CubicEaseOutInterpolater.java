package miui.maml.animation.interpolater;

import android.view.animation.Interpolator;

public class CubicEaseOutInterpolater implements Interpolator {
    public float getInterpolation(float f2) {
        float f3 = f2 - 1.0f;
        float f4 = f3;
        return (f3 * f4 * f4) + 1.0f;
    }
}
