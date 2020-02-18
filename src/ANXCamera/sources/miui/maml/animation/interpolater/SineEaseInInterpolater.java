package miui.maml.animation.interpolater;

import android.view.animation.Interpolator;

public class SineEaseInInterpolater implements Interpolator {
    public float getInterpolation(float f2) {
        return (-((float) Math.cos(((double) f2) * 1.5707963267948966d))) + 1.0f;
    }
}
