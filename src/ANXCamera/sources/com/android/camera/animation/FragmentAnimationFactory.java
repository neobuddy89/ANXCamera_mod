package com.android.camera.animation;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;

public class FragmentAnimationFactory {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: android.view.animation.TranslateAnimation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: android.view.animation.AlphaAnimation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: android.view.animation.AlphaAnimation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: android.view.animation.TranslateAnimation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: android.view.animation.TranslateAnimation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v1, resolved type: android.view.animation.TranslateAnimation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: android.view.animation.TranslateAnimation} */
    /* JADX WARNING: Multi-variable type inference failed */
    public static Animation wrapperAnimation(Animation.AnimationListener animationListener, int... iArr) {
        TranslateAnimation translateAnimation;
        Animation.AnimationListener animationListener2 = animationListener;
        AnimationSet animationSet = new AnimationSet(true);
        boolean z = false;
        for (int i : iArr) {
            if (i == 161) {
                translateAnimation = new AlphaAnimation(0.0f, 1.0f);
            } else if (i == 162) {
                translateAnimation = new AlphaAnimation(1.0f, 0.0f);
            } else if (i == 167) {
                TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
                translateAnimation = translateAnimation2;
            } else if (i != 168) {
                return null;
            } else {
                TranslateAnimation translateAnimation3 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
                translateAnimation = translateAnimation3;
            }
            if (animationListener2 != null && !z) {
                translateAnimation.setAnimationListener(animationListener2);
                z = true;
            }
            translateAnimation.setDuration(200);
            translateAnimation.setInterpolator(AnimationDelegate.DEFAULT_INTERPOLATOR);
            animationSet.addAnimation(translateAnimation);
        }
        return animationSet;
    }

    public static Animation wrapperAnimation(int... iArr) {
        return wrapperAnimation((Animation.AnimationListener) null, iArr);
    }
}
