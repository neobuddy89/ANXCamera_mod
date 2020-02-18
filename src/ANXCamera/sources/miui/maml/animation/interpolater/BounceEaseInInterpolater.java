package miui.maml.animation.interpolater;

import android.view.animation.Interpolator;

public class BounceEaseInInterpolater implements Interpolator {
    public static float getInterpolationImp(float f2) {
        return 1.0f - BounceEaseOutInterpolater.getInterpolationImp(1.0f - f2);
    }

    public float getInterpolation(float f2) {
        return getInterpolationImp(f2);
    }
}
