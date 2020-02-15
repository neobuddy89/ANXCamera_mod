package com.android.camera.fragment.mimoji;

import com.android.camera.ui.autoselectview.AutoSelectAdapter;

/* compiled from: lambda */
public final /* synthetic */ class c implements AutoSelectAdapter.OnSelectListener {
    private final /* synthetic */ FragmentMimojiEdit wb;

    public /* synthetic */ c(FragmentMimojiEdit fragmentMimojiEdit) {
        this.wb = fragmentMimojiEdit;
    }

    public final void onSelectListener(Object obj, int i) {
        this.wb.a((MimojiTypeBean) obj, i);
    }
}
