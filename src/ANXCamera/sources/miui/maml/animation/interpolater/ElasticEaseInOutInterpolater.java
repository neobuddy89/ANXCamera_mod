package miui.maml.animation.interpolater;

import android.view.animation.Interpolator;

public class ElasticEaseInOutInterpolater implements Interpolator {
    private float mAmplitude;
    private float mPriod;

    public ElasticEaseInOutInterpolater() {
        this.mPriod = 0.45000002f;
        this.mAmplitude = 0.0f;
    }

    public ElasticEaseInOutInterpolater(float f2, float f3) {
        this.mPriod = f2;
        this.mAmplitude = f3;
    }

    public float getInterpolation(float f2) {
        float f3;
        float f4 = this.mAmplitude;
        if (f2 == 0.0f) {
            return 0.0f;
        }
        float f5 = f2 / 0.5f;
        float f6 = f5;
        if (f5 == 2.0f) {
            return 1.0f;
        }
        if (f4 < 1.0f) {
            f4 = 1.0f;
            f3 = this.mPriod / 4.0f;
        } else {
            f3 = (float) ((((double) this.mPriod) / 6.283185307179586d) * Math.asin((double) (1.0f / f4)));
        }
        if (f6 < 1.0f) {
            float f7 = f6 - 1.0f;
            return ((float) (((double) f4) * Math.pow(2.0d, (double) (f7 * 10.0f)) * Math.sin((((double) (f7 - f3)) * 6.283185307179586d) / ((double) this.mPriod)))) * -0.5f;
        }
        float f8 = f6 - 1.0f;
        return (float) ((((double) f4) * Math.pow(2.0d, (double) (f8 * -10.0f)) * Math.sin((((double) (f8 - f3)) * 6.283185307179586d) / ((double) this.mPriod)) * 0.5d) + 1.0d);
    }
}
