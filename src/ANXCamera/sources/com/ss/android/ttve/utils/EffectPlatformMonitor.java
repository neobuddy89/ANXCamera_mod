package com.ss.android.ttve.utils;

import com.ss.android.ttve.monitor.MonitorUtils;
import com.ss.android.ugc.effectmanager.common.listener.IMonitorService;
import org.json.JSONObject;

public class EffectPlatformMonitor implements IMonitorService {
    public void monitorCommonLog(String str, String str2, JSONObject jSONObject) {
    }

    public void monitorCommonLog(String str, JSONObject jSONObject) {
    }

    public void monitorDirectOnTimer(String str, String str2, float f2) {
    }

    public void monitorOnTimer(String str, String str2, float f2) {
    }

    public void monitorStatusAndDuration(String str, int i, JSONObject jSONObject, JSONObject jSONObject2) {
        MonitorUtils.monitorStatusAndDuration(str, i, jSONObject, jSONObject2);
    }

    public void monitorStatusRate(String str, int i, JSONObject jSONObject) {
        MonitorUtils.monitorStatusRate(str, i, jSONObject);
    }
}
