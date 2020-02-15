package com.android.camera.data.backup;

import android.support.v4.util.SimpleArrayMap;
import android.util.SparseArray;
import com.android.camera.data.DataRepository;
import com.android.camera.data.data.runing.DataItemRunning;
import com.android.camera.data.provider.DataProvider;
import com.android.camera.effect.FilterInfo;

public class DataActionBackUpImpl implements DataBackUp {
    private SparseArray<SparseArray<SimpleArrayMap>> mBackupArrays;

    public void backupRunning(DataItemRunning dataItemRunning, int i, int i2, boolean z) {
        if (this.mBackupArrays == null) {
            this.mBackupArrays = new SparseArray<>();
        }
        SparseArray sparseArray = this.mBackupArrays.get(i);
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(i2, dataItemRunning.cloneValues());
        this.mBackupArrays.put(i, sparseArray);
        if (z) {
            dataItemRunning.clearArrayMap();
        }
    }

    public void clearBackUp() {
        SparseArray<SparseArray<SimpleArrayMap>> sparseArray = this.mBackupArrays;
        if (sparseArray != null) {
            sparseArray.clear();
        }
    }

    public String getBackupFilter(int i, int i2) {
        SimpleArrayMap backupRunning = getBackupRunning(DataRepository.dataItemGlobal().getDataBackUpKey(i), i2);
        if (backupRunning == null) {
            return String.valueOf(FilterInfo.FILTER_ID_NONE);
        }
        String str = (String) backupRunning.get("pref_camera_shader_coloreffect_key");
        return str == null ? String.valueOf(FilterInfo.FILTER_ID_NONE) : str;
    }

    public SimpleArrayMap getBackupRunning(int i, int i2) {
        SparseArray<SparseArray<SimpleArrayMap>> sparseArray = this.mBackupArrays;
        if (sparseArray == null) {
            return null;
        }
        SparseArray sparseArray2 = sparseArray.get(i);
        if (sparseArray2 == null) {
            return null;
        }
        return (SimpleArrayMap) sparseArray2.get(i2);
    }

    public boolean getBackupSwitchState(int i, String str, int i2) {
        SimpleArrayMap backupRunning = getBackupRunning(DataRepository.dataItemGlobal().getDataBackUpKey(i), i2);
        if (backupRunning == null) {
            return false;
        }
        Object obj = backupRunning.get(str);
        if (obj == null) {
            return false;
        }
        return ((Boolean) obj).booleanValue();
    }

    public boolean isLastVideoFastMotion() {
        SimpleArrayMap backupRunning = getBackupRunning(DataRepository.dataItemGlobal().getDataBackUpKey(169), 0);
        if (backupRunning == null) {
            return false;
        }
        Boolean bool = (Boolean) backupRunning.get("pref_video_speed_fast_key");
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public void removeOtherVideoMode() {
        if (this.mBackupArrays != null) {
            this.mBackupArrays.remove(DataRepository.dataItemGlobal().getDataBackUpKey(169));
        }
    }

    public void revertRunning(DataItemRunning dataItemRunning, int i, int i2) {
        dataItemRunning.clearArrayMap();
        SparseArray<SparseArray<SimpleArrayMap>> sparseArray = this.mBackupArrays;
        if (sparseArray != null) {
            SparseArray sparseArray2 = sparseArray.get(i);
            if (sparseArray2 != null && sparseArray2.get(i2) != null) {
                dataItemRunning.restoreArrayMap((SimpleArrayMap) sparseArray2.get(i2));
            }
        }
    }

    public <P extends DataProvider.ProviderEvent> void startBackup(P p, int i) {
    }
}
