package miui.view.animation;

import android.view.animation.Interpolator;

public class BackEaseInInterpolator implements Interpolator {
    private final float OT;

    public BackEaseInInterpolator() {
        this(0.0f);
    }

    public BackEaseInInterpolator(float f2) {
        this.OT = f2;
    }

    public float getInterpolation(float f2) {
        float f3 = this.OT;
        if (f3 == 0.0f) {
            f3 = 1.70158f;
        }
        return f2 * f2 * (((1.0f + f3) * f2) - f3);
    }
}
