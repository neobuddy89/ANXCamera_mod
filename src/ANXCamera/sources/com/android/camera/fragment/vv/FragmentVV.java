package com.android.camera.fragment.vv;

import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.android.camera.R;
import com.android.camera.animation.FragmentAnimationFactory;
import com.android.camera.fragment.BaseFragment;
import com.android.camera.fragment.BaseFragmentDelegate;
import com.android.camera.fragment.FragmentUtils;
import com.android.camera.log.Log;
import com.android.camera.protocol.ModeCoordinatorImpl;
import com.android.camera.protocol.ModeProtocol;
import com.android.camera.statistic.CameraStatUtils;

public class FragmentVV extends BaseFragment implements View.OnClickListener, ModeProtocol.LiveVVChooser, ModeProtocol.HandleBackTrace, ResourceSelectedListener {
    private VVItem mSelectedItem;
    private View mShotView;

    private void adjustViewBackground(View view, int i) {
        view.setBackgroundResource(R.color.halfscreen_background);
    }

    private void initFragment(int i) {
        FragmentVVGallery fragmentVVGallery = new FragmentVVGallery();
        fragmentVVGallery.setResourceSelectedListener(this);
        fragmentVVGallery.registerProtocol();
        fragmentVVGallery.setPreviewData(i);
        FragmentUtils.addFragmentWithTag(getChildFragmentManager(), (int) R.id.vv_lift, (Fragment) fragmentVVGallery, fragmentVVGallery.getFragmentTag());
    }

    public int getFragmentInto() {
        return BaseFragmentDelegate.FRAGMENT_VV;
    }

    /* access modifiers changed from: protected */
    public int getLayoutResourceId() {
        return R.layout.fragment_vv;
    }

    public void hide() {
        FragmentUtils.removeFragmentByTag(getChildFragmentManager(), String.valueOf(BaseFragmentDelegate.FRAGMENT_VV_GALLERY));
        FragmentUtils.removeFragmentByTag(getChildFragmentManager(), String.valueOf(BaseFragmentDelegate.FRAGMENT_VV_PREVIEW));
        getView().setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void initView(View view) {
        ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).height = -2;
        adjustViewBackground(view, this.mCurrentMode);
        this.mShotView = view.findViewById(R.id.vv_start_layout).findViewById(R.id.vv_start);
        this.mShotView.setVisibility(4);
        this.mShotView.setOnClickListener(this);
        initFragment(0);
    }

    public boolean isPreviewShow() {
        if (!isShow()) {
            return false;
        }
        FragmentVVPreview fragmentVVPreview = (FragmentVVPreview) FragmentUtils.getFragmentByTag(getChildFragmentManager(), String.valueOf(BaseFragmentDelegate.FRAGMENT_VV_PREVIEW));
        return fragmentVVPreview != null && fragmentVVPreview.isVisible();
    }

    public boolean isShow() {
        return isAdded() && getView().getVisibility() == 0;
    }

    public boolean onBackEvent(int i) {
        return false;
    }

    public void onClick(View view) {
        if (isEnableClick() && view.getId() == R.id.vv_start) {
            startShot();
        }
    }

    public void onResourceReady() {
        this.mShotView.setVisibility(0);
    }

    public void onResourceSelected(VVItem vVItem) {
        Log.d("vvSelected:", vVItem.index + " | " + vVItem.name);
        this.mSelectedItem = vVItem;
    }

    /* access modifiers changed from: protected */
    public Animation provideEnterAnimation(int i) {
        return FragmentAnimationFactory.wrapperAnimation(167, 161);
    }

    /* access modifiers changed from: protected */
    public Animation provideExitAnimation(int i) {
        return FragmentAnimationFactory.wrapperAnimation(162, 168);
    }

    /* access modifiers changed from: protected */
    public void register(ModeProtocol.ModeCoordinator modeCoordinator) {
        super.register(modeCoordinator);
        modeCoordinator.attachProtocol(229, this);
        registerBackStack(modeCoordinator, this);
    }

    public void show(int i) {
        getView().setVisibility(0);
        initFragment(i);
    }

    public void startShot() {
        if (this.mSelectedItem != null) {
            ModeProtocol.ConfigChanges configChanges = (ModeProtocol.ConfigChanges) ModeCoordinatorImpl.getInstance().getAttachProtocol(164);
            if (configChanges != null) {
                CameraStatUtils.trackVVStartClick(this.mSelectedItem.name, isPreviewShow());
                configChanges.configLiveVV(this.mSelectedItem, true, false);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void unRegister(ModeProtocol.ModeCoordinator modeCoordinator) {
        super.unRegister(modeCoordinator);
        modeCoordinator.detachProtocol(229, this);
        unRegisterBackStack(modeCoordinator, this);
    }
}
