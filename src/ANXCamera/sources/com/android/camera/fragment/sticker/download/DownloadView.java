package com.android.camera.fragment.sticker.download;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.android.camera.R;
import miui.view.animation.CubicEaseOutInterpolator;

public class DownloadView extends RelativeLayout {
    private static final float ALPHA_MIN = 0.0f;
    private static final float ALPHA_NORMAL = 1.0f;
    private static final int ANIMAL_APPEAR_TIME = 350;
    private static final int ANIMAL_DISAPPEAR_TIME = 250;
    private static final int ANIMAL_ROTATION_TIME = 1000;
    private static final float SCALE_MIN = 0.6f;
    private static final float SCALE_NORMAL = 1.0f;
    /* access modifiers changed from: private */
    public ImageView mImageView;
    /* access modifiers changed from: private */
    public OnDownloadSuccessListener mListener;
    private ObjectAnimator mRotationAnimal;
    protected int mState;

    private abstract class MyAnimalListener implements Animator.AnimatorListener {
        private MyAnimalListener() {
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    public interface OnDownloadSuccessListener {
        void onDownloadSuccess(DownloadView downloadView);
    }

    public DownloadView(Context context) {
        super(context);
        initView();
    }

    public DownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    /* access modifiers changed from: private */
    public void doDownloading() {
        this.mImageView.setImageResource(getStateImageResource(2));
        show(this.mImageView, new MyAnimalListener() {
            public void onAnimationEnd(Animator animator) {
                DownloadView downloadView = DownloadView.this;
                if (downloadView.mState == 2) {
                    downloadView.rotation();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void hide(View view, Animator.AnimatorListener animatorListener) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("alpha", new float[]{getAlphaNormal(), 0.0f}), PropertyValuesHolder.ofFloat("scaleX", new float[]{1.0f, 0.6f}), PropertyValuesHolder.ofFloat("scaleY", new float[]{1.0f, 0.6f})});
        if (animatorListener != null) {
            ofPropertyValuesHolder.addListener(animatorListener);
        }
        ofPropertyValuesHolder.setInterpolator(new CubicEaseOutInterpolator());
        ofPropertyValuesHolder.setDuration(250).start();
    }

    private void initView() {
        this.mImageView = new ImageView(getContext());
        addView(this.mImageView, -2, -2);
        ((RelativeLayout.LayoutParams) this.mImageView.getLayoutParams()).addRule(13);
    }

    /* access modifiers changed from: private */
    public void rotation() {
        if (this.mRotationAnimal == null) {
            this.mRotationAnimal = ObjectAnimator.ofFloat(this.mImageView, "rotation", new float[]{0.0f, 360.0f});
            this.mRotationAnimal.setRepeatCount(-1);
            this.mRotationAnimal.setInterpolator(new LinearInterpolator());
            this.mRotationAnimal.setDuration(1000);
        }
        this.mRotationAnimal.start();
    }

    /* access modifiers changed from: private */
    public void show(View view, Animator.AnimatorListener animatorListener) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("alpha", new float[]{0.0f, getAlphaNormal()}), PropertyValuesHolder.ofFloat("scaleX", new float[]{0.6f, 1.0f}), PropertyValuesHolder.ofFloat("scaleY", new float[]{0.6f, 1.0f})});
        if (animatorListener != null) {
            ofPropertyValuesHolder.addListener(animatorListener);
        }
        ofPropertyValuesHolder.setInterpolator(new CubicEaseOutInterpolator());
        ofPropertyValuesHolder.setDuration(350).start();
    }

    public void clearAnimation() {
        super.clearAnimation();
        this.mImageView.clearAnimation();
        ObjectAnimator objectAnimator = this.mRotationAnimal;
        if (objectAnimator != null) {
            objectAnimator.end();
        }
        setAlpha(getAlphaNormal());
        setScaleX(1.0f);
        setScaleY(1.0f);
    }

    public void endDownloading() {
        clearAnimation();
        hide(this.mImageView, new MyAnimalListener() {
            public void onAnimationEnd(Animator animator) {
                DownloadView.this.mImageView.setImageResource(DownloadView.this.getStateImageResource(3));
                DownloadView downloadView = DownloadView.this;
                downloadView.show(downloadView.mImageView, new MyAnimalListener() {
                    {
                        DownloadView downloadView = DownloadView.this;
                    }

                    public void onAnimationEnd(Animator animator) {
                        DownloadView downloadView = DownloadView.this;
                        downloadView.hide(downloadView, new MyAnimalListener() {
                            {
                                DownloadView downloadView = DownloadView.this;
                            }

                            public void onAnimationEnd(Animator animator) {
                                if (DownloadView.this.mListener != null) {
                                    DownloadView.this.mListener.onDownloadSuccess(DownloadView.this);
                                }
                            }
                        });
                    }
                });
            }
        });
    }

    /* access modifiers changed from: protected */
    public float getAlphaNormal() {
        return 1.0f;
    }

    /* access modifiers changed from: protected */
    public int getStateImageResource(int i) {
        if (i == 0) {
            return R.drawable.icon_sticker_download;
        }
        if (i == 2) {
            return R.drawable.icon_sticker_downloading;
        }
        if (i == 3) {
            return R.drawable.icon_sticker_downloaded;
        }
        if (i != 4) {
            return 0;
        }
        return R.drawable.icon_sticker_download;
    }

    public void setOnDownloadSuccessListener(OnDownloadSuccessListener onDownloadSuccessListener) {
        this.mListener = onDownloadSuccessListener;
    }

    public void setStateImage(int i) {
        this.mState = i;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    clearAnimation();
                    setVisibility(0);
                    doDownloading();
                    return;
                } else if (i == 3) {
                    setVisibility(0);
                    endDownloading();
                    return;
                } else if (i == 4) {
                    clearAnimation();
                    setVisibility(0);
                    this.mImageView.setImageResource(getStateImageResource(i));
                    return;
                } else if (i != 5) {
                    return;
                }
            }
            clearAnimation();
            setVisibility(8);
            return;
        }
        clearAnimation();
        setVisibility(0);
        this.mImageView.setImageResource(getStateImageResource(i));
    }

    public void startDownload() {
        clearAnimation();
        hide(this.mImageView, new MyAnimalListener() {
            public void onAnimationEnd(Animator animator) {
                DownloadView.this.doDownloading();
            }
        });
    }
}
