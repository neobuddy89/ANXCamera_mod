package com.android.camera.fragment.beauty;

import com.android.camera.R;
import com.android.camera.constant.BeautyConstant;
import com.android.camera.data.data.TypeItem;
import com.android.camera.protocol.ModeCoordinatorImpl;
import com.android.camera.protocol.ModeProtocol;
import com.android.camera.statistic.CameraStatUtils;
import java.util.List;

public class MakeupParamsFragment extends BaseBeautyMakeupFragment {
    /* access modifiers changed from: protected */
    public String getClassString() {
        return getClass().getSimpleName();
    }

    /* access modifiers changed from: protected */
    public String getShineType() {
        return "3";
    }

    /* access modifiers changed from: protected */
    public void initExtraType() {
        this.mHeaderElement = 1;
        this.mFooterElement = -1;
    }

    /* access modifiers changed from: protected */
    public void onAdapterItemClick(TypeItem typeItem) {
        ModeProtocol.MakeupProtocol makeupProtocol = (ModeProtocol.MakeupProtocol) ModeCoordinatorImpl.getInstance().getAttachProtocol(180);
        if (makeupProtocol != null) {
            makeupProtocol.onMakeupItemSelected(typeItem.mKeyOrType, true);
            CameraStatUtils.trackBeautyClick("3", typeItem.mKeyOrType);
        }
    }

    /* access modifiers changed from: protected */
    public void onClearClick() {
        ShineHelper.clearBeauty();
        selectFirstItem();
        CameraStatUtils.trackBeautyClick("3", BeautyConstant.BEAUTY_RESET);
    }

    /* access modifiers changed from: protected */
    public void onResetClick() {
        ShineHelper.resetBeauty();
        selectFirstItem();
        List<TypeItem> list = this.mItemList;
        if (list != null && !list.isEmpty()) {
            if ("pref_beautify_skin_smooth_ratio_key".equals(this.mItemList.get(0).mKeyOrType)) {
                toast(getResources().getString(R.string.beauty_reset_toast));
            } else {
                toast(getResources().getString(R.string.beauty_mode_reset_toast));
            }
        }
    }
}
