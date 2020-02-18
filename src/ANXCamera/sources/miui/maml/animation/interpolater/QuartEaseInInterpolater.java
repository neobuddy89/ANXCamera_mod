package miui.maml.animation.interpolater;

import android.view.animation.Interpolator;

public class QuartEaseInInterpolater implements Interpolator {
    public float getInterpolation(float f2) {
        return f2 * f2 * f2 * f2;
    }
}
