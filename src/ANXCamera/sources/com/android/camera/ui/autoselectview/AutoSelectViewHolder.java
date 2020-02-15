package com.android.camera.ui.autoselectview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.android.camera.R;
import com.android.camera.ui.autoselectview.SelectItemBean;

public class AutoSelectViewHolder<T extends SelectItemBean> extends RecyclerView.ViewHolder {
    private TextView textView;

    public AutoSelectViewHolder(@NonNull View view) {
        super(view);
        this.textView = (TextView) view.findViewById(R.id.tv_type);
    }

    public void setData(T t, final int i) {
        this.textView.setTextColor(this.itemView.getContext().getColor(t.getAlpha() == 1 ? R.color.mimoji_edit_type_text_selected : R.color.mimoji_edit_type_text_normal));
        this.textView.setText(t.getText());
        this.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    ((AutoSelectHorizontalView) AutoSelectViewHolder.this.itemView.getParent()).moveToPosition(i);
                } catch (ClassCastException unused) {
                    Log.e(AnonymousClass1.class.getSimpleName(), "recyclerview 类型不正确");
                }
            }
        });
    }
}
