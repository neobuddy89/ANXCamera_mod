package com.android.camera.fragment.manually.adapter;

import android.support.annotation.StringRes;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.camera.CameraAppImpl;
import com.android.camera.R;
import com.android.camera.constant.ColorConstant;
import com.android.camera.data.data.ComponentData;
import com.android.camera.fragment.CommonRecyclerViewHolder;
import java.util.List;

public class ManuallyAdapter extends RecyclerView.Adapter<CommonRecyclerViewHolder> {
    private List<ComponentData> mComponentDataList;
    private int mCurrentMode;
    private View.OnClickListener mOnClickListener;
    @StringRes
    private int mSelectedTitle;

    public ManuallyAdapter(int i, View.OnClickListener onClickListener, List<ComponentData> list) {
        this.mCurrentMode = i;
        this.mOnClickListener = onClickListener;
        this.mComponentDataList = list;
    }

    public int getItemCount() {
        return this.mComponentDataList.size();
    }

    public void onBindViewHolder(CommonRecyclerViewHolder commonRecyclerViewHolder, int i) {
        String str;
        ComponentData componentData = this.mComponentDataList.get(i);
        commonRecyclerViewHolder.itemView.setOnClickListener(this.mOnClickListener);
        commonRecyclerViewHolder.itemView.setTag(componentData);
        TextView textView = (TextView) commonRecyclerViewHolder.getView(R.id.manually_item_key);
        TextView textView2 = (TextView) commonRecyclerViewHolder.getView(R.id.manually_item_value);
        ImageView imageView = (ImageView) commonRecyclerViewHolder.getView(R.id.manually_item_value_image);
        textView.setSelected(true);
        textView2.setSelected(true);
        if (componentData.getDisplayTitleString() > 0) {
            textView.setText(componentData.getDisplayTitleString());
            if (!componentData.disableUpdate() || componentData.mIsKeepValueWhenDisabled) {
                commonRecyclerViewHolder.itemView.setEnabled(true);
            } else {
                commonRecyclerViewHolder.itemView.setEnabled(false);
                textView2.setVisibility(0);
                textView2.setText(componentData.getDefaultValueDisplayString(this.mCurrentMode));
                imageView.setVisibility(8);
                textView.setTextColor(ColorConstant.COLOR_COMMON_DISABLE);
                textView2.setTextColor(ColorConstant.COLOR_COMMON_DISABLE);
                return;
            }
        }
        int i2 = componentData.getDisplayTitleString() == this.mSelectedTitle ? ColorConstant.COLOR_COMMON_SELECTED : ColorConstant.COLOR_COMMON_NORMAL;
        if (componentData.disableUpdate()) {
            commonRecyclerViewHolder.itemView.setEnabled(false);
            textView.setTextColor(ColorConstant.COLOR_COMMON_DISABLE);
            textView2.setTextColor(ColorConstant.COLOR_COMMON_DISABLE);
        } else {
            textView.setTextColor(i2);
        }
        if (componentData.mIsDisplayStringFromResourceId) {
            str = componentData.getValueDisplayStringNotFromResource(this.mCurrentMode);
        } else {
            int valueDisplayString = componentData.getValueDisplayString(this.mCurrentMode);
            str = valueDisplayString == -1 ? null : CameraAppImpl.getAndroidContext().getString(valueDisplayString);
        }
        if (!TextUtils.isEmpty(str)) {
            textView2.setVisibility(0);
            textView2.setText(str);
            imageView.setVisibility(8);
            return;
        }
        textView2.setVisibility(8);
        imageView.setImageResource(componentData.getValueSelectedDrawable(this.mCurrentMode));
        imageView.setVisibility(0);
    }

    public CommonRecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_manually_item, viewGroup, false);
        inflate.getLayoutParams().width = inflate.getResources().getDisplayMetrics().widthPixels / getItemCount();
        return new CommonRecyclerViewHolder(inflate);
    }

    public void setSelectedTitle(@StringRes int i) {
        this.mSelectedTitle = i;
        notifyDataSetChanged();
    }
}
