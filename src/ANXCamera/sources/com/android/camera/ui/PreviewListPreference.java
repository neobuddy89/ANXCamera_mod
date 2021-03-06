package com.android.camera.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.preference.ListPreference;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.android.camera.R;
import java.util.ArrayList;
import java.util.List;

public class PreviewListPreference extends ListPreference {
    private CharSequence[] mDefaultValues;
    /* access modifiers changed from: private */
    public int mExtraPaddingEnd;
    private CharSequence[] mLabels;
    private boolean mShowArrow;

    class PreviewListAdapter implements ListAdapter {
        private ListAdapter mAdapter;
        private int mPaddingEnd;

        public PreviewListAdapter(ListAdapter listAdapter) {
            this.mAdapter = listAdapter;
        }

        public boolean areAllItemsEnabled() {
            return this.mAdapter.areAllItemsEnabled();
        }

        public int getCount() {
            return this.mAdapter.getCount();
        }

        public Object getItem(int i) {
            return this.mAdapter.getItem(i);
        }

        public long getItemId(int i) {
            return this.mAdapter.getItemId(i);
        }

        public int getItemViewType(int i) {
            return this.mAdapter.getItemViewType(i);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            TextView textView = (TextView) this.mAdapter.getView(i, view, viewGroup);
            if (this.mPaddingEnd == 0) {
                this.mPaddingEnd = textView.getPaddingEnd() + PreviewListPreference.this.mExtraPaddingEnd;
            }
            textView.setSingleLine(false);
            textView.setPadding(textView.getPaddingStart(), textView.getPaddingTop(), this.mPaddingEnd, textView.getPaddingBottom());
            return textView;
        }

        public int getViewTypeCount() {
            return this.mAdapter.getViewTypeCount();
        }

        public boolean hasStableIds() {
            return this.mAdapter.hasStableIds();
        }

        public boolean isEmpty() {
            return this.mAdapter.isEmpty();
        }

        public boolean isEnabled(int i) {
            return this.mAdapter.isEnabled(i);
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.mAdapter.registerDataSetObserver(dataSetObserver);
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            this.mAdapter.unregisterDataSetObserver(dataSetObserver);
        }
    }

    public PreviewListPreference(Context context) {
        this(context, (AttributeSet) null);
    }

    public PreviewListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        CharSequence[] charSequenceArr = this.mDefaultValues;
        if (charSequenceArr != null) {
            setDefaultValue(findSupportedDefaultValue(charSequenceArr));
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PreviewListPreference, 0, 0);
        this.mLabels = obtainStyledAttributes.getTextArray(0);
        this.mShowArrow = obtainStyledAttributes.getBoolean(1, true);
        this.mExtraPaddingEnd = context.getResources().getDimensionPixelSize(R.dimen.preference_entry_padding_end);
        obtainStyledAttributes.recycle();
    }

    private CharSequence findSupportedDefaultValue(CharSequence[] charSequenceArr) {
        CharSequence[] entryValues = getEntryValues();
        if (entryValues == null) {
            return null;
        }
        for (CharSequence charSequence : entryValues) {
            for (CharSequence charSequence2 : charSequenceArr) {
                if (charSequence != null && charSequence.equals(charSequence2)) {
                    return charSequence2;
                }
            }
        }
        return null;
    }

    public void filterUnsupported(List<String> list) {
        CharSequence[] entries = getEntries();
        CharSequence[] entryValues = getEntryValues();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int length = entries.length;
        for (int i = 0; i < length; i++) {
            if (list.indexOf(entryValues[i].toString()) >= 0) {
                arrayList.add(entries[i]);
                arrayList2.add(entryValues[i]);
            }
        }
        int size = arrayList.size();
        setEntries((CharSequence[]) arrayList.toArray(new CharSequence[size]));
        setEntryValues((CharSequence[]) arrayList2.toArray(new CharSequence[size]));
    }

    public CharSequence getLabel() {
        int findIndexOfValue = findIndexOfValue(getValue());
        if (findIndexOfValue >= 0) {
            CharSequence[] charSequenceArr = this.mLabels;
            if (charSequenceArr != null) {
                return charSequenceArr[findIndexOfValue];
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onBindView(View view) {
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(R.id.value_right);
        ImageView imageView = (ImageView) view.findViewById(R.id.arrow_right);
        if (textView != null) {
            CharSequence entry = this.mLabels == null ? getEntry() : getLabel();
            if (!TextUtils.isEmpty(entry)) {
                textView.setText(String.valueOf(entry));
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
        if (imageView == null) {
            return;
        }
        if (this.mShowArrow) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(4);
        }
    }

    /* access modifiers changed from: protected */
    public View onCreateView(ViewGroup viewGroup) {
        return LayoutInflater.from(getContext()).inflate(R.layout.preference_value_list, viewGroup, false);
    }

    /* access modifiers changed from: protected */
    public Object onGetDefaultValue(TypedArray typedArray, int i) {
        TypedValue peekValue = typedArray.peekValue(i);
        if (peekValue != null && peekValue.type == 1) {
            this.mDefaultValues = typedArray.getTextArray(i);
        }
        CharSequence[] charSequenceArr = this.mDefaultValues;
        return charSequenceArr != null ? charSequenceArr[0] : typedArray.getString(i);
    }

    public void setEntryValues(CharSequence[] charSequenceArr) {
        super.setEntryValues(charSequenceArr);
        CharSequence[] charSequenceArr2 = this.mDefaultValues;
        if (charSequenceArr2 != null) {
            setDefaultValue(findSupportedDefaultValue(charSequenceArr2));
        }
    }

    public void setShowArrow(boolean z) {
        this.mShowArrow = z;
    }

    /* access modifiers changed from: protected */
    public void showDialog(Bundle bundle) {
        super.showDialog(bundle);
        ListView listView = ((AlertDialog) getDialog()).getListView();
        int checkedItemPosition = listView.getCheckedItemPosition();
        listView.setAdapter(new PreviewListAdapter(listView.getAdapter()));
        if (checkedItemPosition > -1) {
            listView.setItemChecked(checkedItemPosition, true);
            listView.setSelection(checkedItemPosition);
        }
    }
}
