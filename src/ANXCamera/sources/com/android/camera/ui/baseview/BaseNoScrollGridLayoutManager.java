package com.android.camera.ui.baseview;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import com.android.camera.log.Log;

public class BaseNoScrollGridLayoutManager extends GridLayoutManager {
    public BaseNoScrollGridLayoutManager(Context context, int i) {
        super(context, i);
    }

    public BaseNoScrollGridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i, i2, z);
    }

    public BaseNoScrollGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public boolean canScrollHorizontally() {
        return false;
    }

    public boolean canScrollVertically() {
        return false;
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (IndexOutOfBoundsException unused) {
            Log.i("BaseNoScrollGridLayoutManager", "IndexOutOfBoundsException ");
        }
    }
}
