package com.android.camera.data.data.runing;

import com.android.camera.R;
import com.android.camera.data.data.ComponentData;
import com.android.camera.data.data.ComponentDataItem;
import java.util.ArrayList;
import java.util.List;

public class ComponentRunningKaleidoscope extends ComponentData {
    public static final String KALEIDOSCOPE_1 = "1";
    public static final String KALEIDOSCOPE_2 = "2";
    public static final String KALEIDOSCOPE_3 = "3";
    public static final String KALEIDOSCOPE_4 = "4";
    public static final String KALEIDOSCOPE_5 = "5";
    public static final String KALEIDOSCOPE_6 = "6";
    public static final String KALEIDOSCOPE_NONE = "0";

    public ComponentRunningKaleidoscope(DataItemRunning dataItemRunning) {
        super(dataItemRunning);
    }

    private List<ComponentDataItem> initItems() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ComponentDataItem((int) R.drawable.ic_wht_1, (int) R.drawable.ic_wht_1, (int) R.string.kaleidoscope_fragment_tab_name, "1"));
        arrayList.add(new ComponentDataItem((int) R.drawable.ic_wht_2, (int) R.drawable.ic_wht_2, (int) R.string.kaleidoscope_fragment_tab_name, "2"));
        arrayList.add(new ComponentDataItem((int) R.drawable.ic_wht_3, (int) R.drawable.ic_wht_3, (int) R.string.kaleidoscope_fragment_tab_name, "3"));
        arrayList.add(new ComponentDataItem((int) R.drawable.ic_wht_4, (int) R.drawable.ic_wht_4, (int) R.string.kaleidoscope_fragment_tab_name, "4"));
        arrayList.add(new ComponentDataItem((int) R.drawable.ic_wht_5, (int) R.drawable.ic_wht_5, (int) R.string.kaleidoscope_fragment_tab_name, "5"));
        arrayList.add(new ComponentDataItem((int) R.drawable.ic_wht_6, (int) R.drawable.ic_wht_6, (int) R.string.kaleidoscope_fragment_tab_name, "6"));
        return arrayList;
    }

    public String getDefaultValue(int i) {
        return "0";
    }

    public int getDisplayTitleString() {
        return R.string.kaleidoscope_fragment_tab_name;
    }

    public List<ComponentDataItem> getItems() {
        if (this.mItems == null) {
            this.mItems = initItems();
        }
        return this.mItems;
    }

    public String getKaleidoscopeValue() {
        return getComponentValue(160);
    }

    public String getKey(int i) {
        return "pref_kaleidoscope";
    }

    public boolean isSwitchOn() {
        return !getComponentValue(160).equals("0");
    }

    public void setKaleidoscopeValue(String str) {
        setComponentValue(160, str);
    }
}
