package com.android.camera.fragment.beauty;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.android.camera.fragment.BaseViewPagerFragment;
import miui.view.animation.QuinticEaseInInterpolator;
import miui.view.animation.QuinticEaseOutInterpolator;

public abstract class BaseBeautyFragment extends BaseViewPagerFragment {
    /* access modifiers changed from: protected */
    public void enterAnim(@NonNull View view) {
        view.clearAnimation();
        view.setAlpha(0.0f);
        ViewCompat.animate(view).setDuration(240).alpha(1.0f).setStartDelay(120).setInterpolator(new QuinticEaseOutInterpolator()).start();
    }

    /* access modifiers changed from: protected */
    public void exitAnim(@NonNull View view) {
        view.clearAnimation();
        ViewCompat.animate(view).setDuration(120).alpha(0.0f).setInterpolator(new QuinticEaseInInterpolator()).start();
    }

    /* access modifiers changed from: protected */
    public abstract View getAnimateView();

    public Animation onCreateAnimation(int i, boolean z, int i2) {
        if (z) {
            return super.onCreateAnimation(i, z, i2);
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setInterpolator(new QuinticEaseInInterpolator());
        alphaAnimation.setDuration(140);
        return alphaAnimation;
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onViewCreatedAndJumpOut() {
        super.onViewCreatedAndJumpOut();
        if (getAnimateView() != null) {
            exitAnim(getAnimateView());
        }
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onViewCreatedAndVisibleToUser(boolean z) {
        super.onViewCreatedAndVisibleToUser(z);
        if (getAnimateView() != null) {
            enterAnim(getAnimateView());
        }
    }
}
