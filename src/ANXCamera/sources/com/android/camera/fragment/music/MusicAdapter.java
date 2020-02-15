package com.android.camera.fragment.music;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.camera.R;
import com.android.camera.fragment.CommonRecyclerViewHolder;
import com.bumptech.glide.c;
import com.bumptech.glide.load.j;
import com.bumptech.glide.request.f;
import java.util.List;

public class MusicAdapter extends RecyclerView.Adapter<CommonRecyclerViewHolder> {
    private Context mContext;
    private List<LiveMusicInfo> mMusicList;
    private View.OnClickListener mOnClickListener;
    private View.OnTouchListener mOnTouchListener;

    public MusicAdapter(Context context, View.OnClickListener onClickListener, View.OnTouchListener onTouchListener, List<LiveMusicInfo> list) {
        this.mContext = context;
        this.mOnClickListener = onClickListener;
        this.mOnTouchListener = onTouchListener;
        this.mMusicList = list;
    }

    public int getItemCount() {
        return this.mMusicList.size();
    }

    public void onBindViewHolder(CommonRecyclerViewHolder commonRecyclerViewHolder, int i) {
        LiveMusicInfo liveMusicInfo = this.mMusicList.get(i);
        commonRecyclerViewHolder.itemView.setOnTouchListener(this.mOnTouchListener);
        commonRecyclerViewHolder.itemView.setTag(liveMusicInfo);
        float f2 = this.mContext.getResources().getConfiguration().fontScale;
        TextView textView = (TextView) commonRecyclerViewHolder.getView(R.id.music_author);
        textView.setText(liveMusicInfo.mAuthor.trim());
        ((TextView) commonRecyclerViewHolder.getView(R.id.music_title)).setText(liveMusicInfo.mTitle.trim());
        c.G(this.mContext).load(liveMusicInfo.mThumbnailUrl).b(f.a((j<Bitmap>) new RoundedCornersTransformation(10, 1))).a((ImageView) commonRecyclerViewHolder.getView(R.id.music_thumbnail));
        ImageView imageView = (ImageView) commonRecyclerViewHolder.getView(R.id.music_play);
        imageView.setOnClickListener(this.mOnClickListener);
        imageView.setTag(liveMusicInfo);
        ((ProgressBar) commonRecyclerViewHolder.getView(R.id.music_loading)).setTag(liveMusicInfo);
        ((TextView) commonRecyclerViewHolder.getView(R.id.music_duration)).setText("00 : " + liveMusicInfo.mDuration.trim());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
        if (f2 > 1.25f) {
            layoutParams.topMargin = 0;
        } else {
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(R.dimen.music_author_margin_top);
        }
        textView.setLayoutParams(layoutParams);
    }

    public CommonRecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new CommonRecyclerViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_music_adapter, viewGroup, false));
    }

    public void setData(List<LiveMusicInfo> list) {
        this.mMusicList = list;
        notifyDataSetChanged();
    }
}
