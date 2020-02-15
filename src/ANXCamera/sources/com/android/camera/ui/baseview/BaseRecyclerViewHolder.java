package com.android.camera.ui.baseview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class BaseRecyclerViewHolder<T> extends RecyclerView.ViewHolder {
    public BaseRecyclerViewHolder(@NonNull View view) {
        super(view);
    }

    public void setClickListener(final OnRecyclerItemClickListener<T> onRecyclerItemClickListener, final T t, final int i) {
        this.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                onRecyclerItemClickListener.OnRecyclerItemClickListener(t, i);
            }
        });
    }

    public abstract void setData(T t, int i);
}
