package com.android.camera.module.interceptor;

public class ConfigChangeInterceptor extends BaseModuleInterceptor {
    public boolean consumeConfigChanged(int i) {
        return false;
    }

    public int getPriority() {
        return 0;
    }

    public int getScope() {
        return 0;
    }
}
