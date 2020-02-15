package com.android.camera.preferences;

import android.content.Context;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.Iterator;

public class PreferenceGroup extends CameraPreference {
    private ArrayList<CameraPreference> list = new ArrayList<>();

    public PreferenceGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void addChild(CameraPreference cameraPreference) {
        this.list.add(cameraPreference);
    }

    public ListPreference findPreference(String str) {
        Iterator<CameraPreference> it = this.list.iterator();
        while (it.hasNext()) {
            CameraPreference next = it.next();
            if (next instanceof ListPreference) {
                ListPreference listPreference = (ListPreference) next;
                if (listPreference.getKey().equals(str)) {
                    return listPreference;
                }
            } else if (next instanceof PreferenceGroup) {
                ListPreference findPreference = ((PreferenceGroup) next).findPreference(str);
                if (findPreference != null) {
                    return findPreference;
                }
            } else {
                continue;
            }
        }
        return null;
    }

    public CameraPreference get(int i) {
        return this.list.get(i);
    }

    public void removePreference(int i) {
        this.list.remove(i);
    }

    public int size() {
        return this.list.size();
    }
}
