package com.ss.android.ttve.monitor;

import com.android.camera.statistic.MistatsConstants;
import com.ss.android.ugc.effectmanager.effect.model.ComposerHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class TEMonitorFilterMgr {
    public static final int FILTER_TYPE_EFFECT = 0;
    public static final int FILTER_TYPE_INFO_STICKER = 1;
    public static final int REPEAT_EFFECT = 1;
    public static final int REVERSE_EFFECT = 3;
    public static final int SLOW_MOTION_EFFECT = 2;
    public static final int TIME_EFFECT_NONE = 0;
    private static TEMonitorFilterMgr sInstance;
    public Map<Integer, TEMonitorFilter> effectMap = new HashMap();
    public Map<Integer, TEMonitorFilter> infoStickerMap = new HashMap();
    private int timeEffectType = -1;

    public static class TEMonitorFilter {
        public int duration;
        public String path;
        public int start;
    }

    public synchronized void addFilter(int i, int i2, TEMonitorFilter tEMonitorFilter) {
        if (i == 0) {
            this.effectMap.put(Integer.valueOf(i2), tEMonitorFilter);
        } else if (i == 1) {
            this.infoStickerMap.put(Integer.valueOf(i2), tEMonitorFilter);
        }
    }

    public int getTimeEffectType() {
        return this.timeEffectType;
    }

    public synchronized boolean isEffectAdd() {
        return this.effectMap.isEmpty();
    }

    public synchronized boolean isInfoStickerAdd() {
        return this.infoStickerMap.isEmpty();
    }

    public synchronized void removeFilter(int i, int i2) {
        if (i == 0) {
            this.effectMap.remove(Integer.valueOf(i2));
        } else if (i == 1) {
            this.infoStickerMap.remove(Integer.valueOf(i2));
        }
    }

    public synchronized void reset() {
        this.effectMap.clear();
        this.infoStickerMap.clear();
        this.timeEffectType = -1;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:15|16|17|26|25|13|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0027 */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027 A[LOOP:0: B:12:0x0027->B:25:0x0027, LOOP_START, SYNTHETIC, Splitter:B:12:0x0027] */
    public synchronized String serializeMap(int i) {
        JSONArray jSONArray = new JSONArray();
        Iterator<Map.Entry<Integer, TEMonitorFilter>> it = i == 0 ? this.effectMap.entrySet().iterator() : i == 1 ? this.infoStickerMap.entrySet().iterator() : null;
        if (it == null) {
            return null;
        }
        while (it.hasNext()) {
            TEMonitorFilter tEMonitorFilter = (TEMonitorFilter) it.next().getValue();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ComposerHelper.CONFIG_PATH, tEMonitorFilter.path);
            jSONObject.put(MistatsConstants.BaseEvent.START, tEMonitorFilter.start);
            jSONObject.put("duration", tEMonitorFilter.duration);
            jSONArray.put(jSONObject);
        }
        return jSONArray.toString();
    }

    public void setTimeEffectType(int i) {
        this.timeEffectType = i;
    }
}
