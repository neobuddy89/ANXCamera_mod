package miui.maml.animation.interpolater;

import android.view.animation.Interpolator;

public class ElasticEaseOutInterpolater implements Interpolator {
    private float mAmplitude;
    private float mPriod;

    public ElasticEaseOutInterpolater() {
        this.mPriod = 0.3f;
        this.mAmplitude = 0.0f;
    }

    public ElasticEaseOutInterpolater(float f2, float f3) {
        this.mPriod = f2;
        this.mAmplitude = f3;
    }

    public float getInterpolation(float f2) {
        float f3;
        float f4 = this.mAmplitude;
        if (f2 == 0.0f) {
            return 0.0f;
        }
        if (f2 == 1.0f) {
            return 1.0f;
        }
        if (f4 < 1.0f) {
            f4 = 1.0f;
            f3 = this.mPriod / 4.0f;
        } else {
            f3 = (float) ((((double) this.mPriod) / 6.283185307179586d) * Math.asin((double) (1.0f / f4)));
        }
        return (float) ((((double) f4) * Math.pow(2.0d, (double) (-10.0f * f2)) * Math.sin((((double) (f2 - f3)) * 6.283185307179586d) / ((double) this.mPriod))) + 1.0d);
    }
}
