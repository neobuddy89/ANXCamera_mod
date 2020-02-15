package com.android.camera.backup;

import miui.cloud.backup.CloudBackupServiceBase;
import miui.cloud.backup.ICloudBackup;

public class CameraSettingsBackupService extends CloudBackupServiceBase {
    /* access modifiers changed from: protected */
    public ICloudBackup getBackupImpl() {
        return new CameraSettingsBackupImpl();
    }
}
