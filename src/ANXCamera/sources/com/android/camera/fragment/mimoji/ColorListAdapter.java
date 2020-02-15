package com.android.camera.fragment.mimoji;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.camera.R;
import com.android.camera.fragment.beauty.LinearLayoutManagerWrapper;
import com.arcsoft.avatar.AvatarConfig;
import java.util.ArrayList;
import java.util.List;

public class ColorListAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static final String TAG = "ColorListAdapter";
    /* access modifiers changed from: private */
    public ClickCheck clickCheck;
    /* access modifiers changed from: private */
    public AvatarConfigItemClick mAvatarConfigItemClick;
    private Context mContext;
    private List<AvatarConfig.ASAvatarConfigInfo> mDatas;
    public int mLastPosion = -1;
    /* access modifiers changed from: private */
    public LinearLayoutManagerWrapper mLinearLayoutManagerWrapper;
    /* access modifiers changed from: private */
    public RecyclerView mRootView;

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView ivColor;

        public ViewHolder(View view) {
            super(view);
            this.ivColor = (CircleImageView) view.findViewById(R.id.iv_color);
        }
    }

    public ColorListAdapter(Context context, AvatarConfigItemClick avatarConfigItemClick, LinearLayoutManagerWrapper linearLayoutManagerWrapper) {
        this.mContext = context;
        this.mDatas = new ArrayList();
        this.mAvatarConfigItemClick = avatarConfigItemClick;
        this.mLinearLayoutManagerWrapper = linearLayoutManagerWrapper;
    }

    public int getItemCount() {
        List<AvatarConfig.ASAvatarConfigInfo> list = this.mDatas;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public float getSelectItem(int i) {
        return AvatarEngineManager.getInstance().getInnerConfigSelectIndex(i);
    }

    public LinearLayoutManagerWrapper getmLinearLayoutManagerWrapper() {
        return this.mLinearLayoutManagerWrapper;
    }

    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.mRootView = recyclerView;
    }

    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final AvatarConfig.ASAvatarConfigInfo aSAvatarConfigInfo = this.mDatas.get(i);
        final CircleImageView circleImageView = viewHolder.ivColor;
        float selectItem = getSelectItem(aSAvatarConfigInfo.configType);
        final ArgbEvaluator argbEvaluator = new ArgbEvaluator();
        int intValue = ((Integer) argbEvaluator.evaluate(aSAvatarConfigInfo.continuousValue, Integer.valueOf(aSAvatarConfigInfo.startColorValue), Integer.valueOf(aSAvatarConfigInfo.endColorValue))).intValue();
        if (selectItem == ((float) aSAvatarConfigInfo.configID)) {
            circleImageView.updateView(true, intValue);
            this.mLastPosion = i;
        } else {
            circleImageView.updateView(false, intValue);
        }
        View view = viewHolder.itemView;
        final int i2 = i;
        AnonymousClass1 r1 = new View.OnClickListener() {
            public void onClick(View view) {
                if (ColorListAdapter.this.clickCheck == null || ColorListAdapter.this.clickCheck.checkClickable()) {
                    ColorListAdapter colorListAdapter = ColorListAdapter.this;
                    if (colorListAdapter.mLastPosion != i2 && argbEvaluator != null && colorListAdapter.mRootView != null) {
                        if (aSAvatarConfigInfo.configType == 2) {
                            AvatarEngineManager.getInstance().setInnerConfigSelectIndex(20, (float) aSAvatarConfigInfo.configID);
                            AvatarEngineManager.getInstance().setInnerConfigSelectIndex(17, (float) aSAvatarConfigInfo.configID);
                        }
                        if (ColorListAdapter.this.mLinearLayoutManagerWrapper != null) {
                            if (i2 == ColorListAdapter.this.mLinearLayoutManagerWrapper.findFirstVisibleItemPosition() || i2 == ColorListAdapter.this.mLinearLayoutManagerWrapper.findFirstCompletelyVisibleItemPosition()) {
                                ColorListAdapter.this.mRootView.scrollToPosition(Math.max(0, i2 - 1));
                            } else if (i2 == ColorListAdapter.this.mLinearLayoutManagerWrapper.findLastVisibleItemPosition() || i2 == ColorListAdapter.this.mLinearLayoutManagerWrapper.findLastCompletelyVisibleItemPosition()) {
                                ColorListAdapter.this.mRootView.scrollToPosition(Math.min(i2 + 1, ColorListAdapter.this.getItemCount() - 1));
                            }
                        }
                        AvatarEngineManager instance = AvatarEngineManager.getInstance();
                        AvatarConfig.ASAvatarConfigInfo aSAvatarConfigInfo = aSAvatarConfigInfo;
                        instance.setInnerConfigSelectIndex(aSAvatarConfigInfo.configType, (float) aSAvatarConfigInfo.configID);
                        ViewHolder viewHolder = (ViewHolder) ColorListAdapter.this.mRootView.findViewHolderForAdapterPosition(ColorListAdapter.this.mLastPosion);
                        if (viewHolder != null) {
                            viewHolder.ivColor.updateView(false);
                        } else {
                            ColorListAdapter colorListAdapter2 = ColorListAdapter.this;
                            colorListAdapter2.notifyItemChanged(colorListAdapter2.mLastPosion);
                        }
                        circleImageView.updateView(true);
                        ColorListAdapter colorListAdapter3 = ColorListAdapter.this;
                        colorListAdapter3.mLastPosion = i2;
                        colorListAdapter3.mAvatarConfigItemClick.onConfigItemClick(aSAvatarConfigInfo, true, i2);
                    }
                }
            }
        };
        view.setOnClickListener(r1);
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.item_mimoji_color, viewGroup, false));
    }

    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.mRootView = null;
    }

    public void setClickCheck(ClickCheck clickCheck2) {
        this.clickCheck = clickCheck2;
    }

    public void setData(List<AvatarConfig.ASAvatarConfigInfo> list) {
        this.mDatas = list;
        notifyDataSetChanged();
    }
}
