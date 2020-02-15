package com.android.camera.preferences;

import android.content.SharedPreferences;
import java.util.HashMap;

public class SettingsOverrider {
    private HashMap<String, String> mRestoredMap = new HashMap<>();

    public void overrideSettings(String... strArr) {
        CameraSettingPreferences instance = CameraSettingPreferences.instance();
        SharedPreferences.Editor edit = instance.edit();
        synchronized (this.mRestoredMap) {
            this.mRestoredMap.clear();
            for (int i = 0; i < strArr.length; i += 2) {
                String str = strArr[i];
                String str2 = strArr[i + 1];
                this.mRestoredMap.put(str, instance.getString(str, (String) null));
                if (str2 == null) {
                    edit.remove(str);
                } else {
                    edit.putString(str, str2);
                }
            }
            edit.apply();
        }
    }

    public void removeSavedSetting(String str) {
        this.mRestoredMap.remove(str);
    }

    public boolean restoreSettings() {
        boolean z;
        CameraSettingPreferences instance = CameraSettingPreferences.instance();
        SharedPreferences.Editor edit = instance.edit();
        synchronized (this.mRestoredMap) {
            z = false;
            for (String next : this.mRestoredMap.keySet()) {
                String string = instance.getString(next, (String) null);
                String str = this.mRestoredMap.get(next);
                if (str == null) {
                    edit.remove(next);
                    if (string == null) {
                    }
                } else {
                    edit.putString(next, str);
                    if (!str.equals(string)) {
                    }
                }
                z = true;
            }
            this.mRestoredMap.clear();
        }
        edit.apply();
        return z;
    }
}
