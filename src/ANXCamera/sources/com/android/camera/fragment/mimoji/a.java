package com.android.camera.fragment.mimoji;

import android.view.View;
import com.android.camera.fragment.mimoji.MimojiCreateItemAdapter;

/* compiled from: lambda */
public final /* synthetic */ class a implements MimojiCreateItemAdapter.OnItemClickListener {
    private final /* synthetic */ FragmentMimoji wb;

    public /* synthetic */ a(FragmentMimoji fragmentMimoji) {
        this.wb = fragmentMimoji;
    }

    public final void onItemClick(MimojiInfo mimojiInfo, int i, View view) {
        this.wb.a(mimojiInfo, i, view);
    }
}
