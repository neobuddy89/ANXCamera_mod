package miui.maml.animation.interpolater;

import android.view.animation.Interpolator;

public class SineEaseOutInterpolater implements Interpolator {
    public float getInterpolation(float f2) {
        return (float) Math.sin(((double) f2) * 1.5707963267948966d);
    }
}
