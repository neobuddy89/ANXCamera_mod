package miui.view.animation;

import android.view.animation.Interpolator;

public class SineEaseOutInterpolator implements Interpolator {
    public float getInterpolation(float f2) {
        return (float) Math.sin(((double) f2) * 1.5707963267948966d);
    }
}
