package miui.maml.animation.interpolater;

import android.view.animation.Interpolator;

public class PhysicBasedInterpolator implements Interpolator {

    /* renamed from: c  reason: collision with root package name */
    private float f693c;
    private float c1;
    private float c2;
    private float k;
    private float m;
    private float mInitial;
    private float r;
    private float w;

    public PhysicBasedInterpolator() {
        this(0.9f, 0.3f);
    }

    public PhysicBasedInterpolator(float f2, float f3) {
        this.mInitial = -1.0f;
        this.m = 1.0f;
        this.c1 = this.mInitial;
        double pow = Math.pow(6.283185307179586d / ((double) f3), 2.0d);
        float f4 = this.m;
        this.k = (float) (pow * ((double) f4));
        this.f693c = (float) (((((double) f2) * 12.566370614359172d) * ((double) f4)) / ((double) f3));
        float f5 = f4 * 4.0f * this.k;
        float f6 = this.f693c;
        float f7 = this.m;
        this.w = ((float) Math.sqrt((double) (f5 - (f6 * f6)))) / (f7 * 2.0f);
        this.r = -((this.f693c / 2.0f) * f7);
        this.c2 = (0.0f - (this.r * this.mInitial)) / this.w;
    }

    public float getInterpolation(float f2) {
        return (float) ((Math.pow(2.718281828459045d, (double) (this.r * f2)) * ((((double) this.c1) * Math.cos((double) (this.w * f2))) + (((double) this.c2) * Math.sin((double) (this.w * f2))))) + 1.0d);
    }
}
