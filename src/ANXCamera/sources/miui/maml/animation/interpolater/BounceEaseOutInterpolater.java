package miui.maml.animation.interpolater;

import android.view.animation.Interpolator;

public class BounceEaseOutInterpolater implements Interpolator {
    public static float getInterpolationImp(float f2) {
        if (((double) f2) < 0.36363636363636365d) {
            return 7.5625f * f2 * f2;
        }
        if (((double) f2) < 0.7272727272727273d) {
            float f3 = (float) (((double) f2) - 0.5454545454545454d);
            return (f3 * 7.5625f * f3) + 0.75f;
        } else if (((double) f2) < 0.9090909090909091d) {
            float f4 = (float) (((double) f2) - 0.8181818181818182d);
            return (f4 * 7.5625f * f4) + 0.9375f;
        } else {
            float f5 = (float) (((double) f2) - 0.9545454545454546d);
            return (f5 * 7.5625f * f5) + 0.984375f;
        }
    }

    public float getInterpolation(float f2) {
        return getInterpolationImp(f2);
    }
}
