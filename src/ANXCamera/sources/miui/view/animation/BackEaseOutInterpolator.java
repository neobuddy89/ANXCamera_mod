package miui.view.animation;

import android.view.animation.Interpolator;

public class BackEaseOutInterpolator implements Interpolator {
    private final float OT;

    public BackEaseOutInterpolator() {
        this(0.0f);
    }

    public BackEaseOutInterpolator(float f2) {
        this.OT = f2;
    }

    public float getInterpolation(float f2) {
        float f3 = this.OT;
        if (f3 == 0.0f) {
            f3 = 1.70158f;
        }
        float f4 = f2 - 1.0f;
        return (f4 * f4 * (((f3 + 1.0f) * f4) + f3)) + 1.0f;
    }
}
