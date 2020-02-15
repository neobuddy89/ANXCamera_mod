package com.android.camera.fragment.mimoji;

import com.android.camera.fragment.mimoji.EditLevelListAdapter;

/* compiled from: lambda */
public final /* synthetic */ class d implements EditLevelListAdapter.ItfGvOnItemClickListener {
    private final /* synthetic */ FragmentMimojiEdit wb;

    public /* synthetic */ d(FragmentMimojiEdit fragmentMimojiEdit) {
        this.wb = fragmentMimojiEdit;
    }

    public final void notifyUIChanged() {
        this.wb.ya();
    }
}
