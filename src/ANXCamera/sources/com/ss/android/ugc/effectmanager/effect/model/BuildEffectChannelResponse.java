package com.ss.android.ugc.effectmanager.effect.model;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuildEffectChannelResponse {
    private String mFileDirectory;
    private boolean mIsCache;
    private String mPanel;

    public BuildEffectChannelResponse(String str, String str2, boolean z) {
        this.mPanel = str;
        this.mFileDirectory = str2;
        this.mIsCache = z;
    }

    private void fillEffectPath(List<Effect> list) {
        if (list != null && !list.isEmpty()) {
            for (Effect next : list) {
                next.setZipPath(this.mFileDirectory + File.separator + next.getId() + ".zip");
                StringBuilder sb = new StringBuilder();
                sb.append(this.mFileDirectory);
                sb.append(File.separator);
                sb.append(next.getId());
                next.setUnzipPath(sb.toString());
            }
        }
    }

    private List<Effect> getCategoryAllEffects(EffectCategoryModel effectCategoryModel, Map<String, Effect> map) {
        ArrayList arrayList = new ArrayList();
        for (String str : effectCategoryModel.getEffects()) {
            Effect effect = map.get(str);
            if (effect != null) {
                arrayList.add(effect);
            }
        }
        return arrayList;
    }

    private void getChildEffect(List<Effect> list, Map<String, Effect> map) {
        for (Effect next : list) {
            if (next.getEffectType() == 1) {
                ArrayList arrayList = new ArrayList();
                for (String str : next.getChildren()) {
                    Effect effect = map.get(str);
                    if (effect != null) {
                        arrayList.add(effect);
                    }
                }
                next.setChildEffects(arrayList);
            }
        }
    }

    private Effect getEffect(String str, Map<String, Effect> map) {
        return map.get(str);
    }

    private List<EffectCategoryResponse> initCategory(EffectChannelModel effectChannelModel, Map<String, Effect> map) {
        ArrayList arrayList = new ArrayList();
        if (!effectChannelModel.getCategory().isEmpty()) {
            for (EffectCategoryModel next : effectChannelModel.getCategory()) {
                EffectCategoryResponse effectCategoryResponse = new EffectCategoryResponse();
                effectCategoryResponse.setId(next.getId());
                effectCategoryResponse.setName(next.getName());
                effectCategoryResponse.setKey(next.getKey());
                if (!next.getIcon().getUrl_list().isEmpty()) {
                    effectCategoryResponse.setIcon_normal_url(next.getIcon().getUrl_list().get(0));
                }
                if (!next.getIcon_selected().getUrl_list().isEmpty()) {
                    effectCategoryResponse.setIcon_selected_url(next.getIcon_selected().getUrl_list().get(0));
                }
                effectCategoryResponse.setTotalEffects(getCategoryAllEffects(next, map));
                effectCategoryResponse.setTags(next.getTags());
                effectCategoryResponse.setTagsUpdateTime(next.getTagsUpdateTime());
                effectCategoryResponse.setCollectionEffect(effectChannelModel.getCollection());
                arrayList.add(effectCategoryResponse);
            }
        }
        return arrayList;
    }

    public EffectChannelResponse buildChannelResponse(EffectChannelModel effectChannelModel) {
        System.currentTimeMillis();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        for (Effect next : effectChannelModel.getEffects()) {
            hashMap.put(next.getEffectId(), next);
        }
        for (Effect next2 : effectChannelModel.getCollection()) {
            hashMap2.put(next2.getEffectId(), next2);
        }
        EffectChannelResponse effectChannelResponse = new EffectChannelResponse();
        effectChannelResponse.setPanel(this.mPanel);
        effectChannelResponse.setVersion(effectChannelModel.getVersion());
        effectChannelResponse.setAllCategoryEffects(effectChannelModel.getEffects());
        effectChannelResponse.setCollections(effectChannelModel.getCollection());
        effectChannelResponse.setUrlPrefix(effectChannelModel.getUrlPrefix());
        effectChannelResponse.setCategoryResponseList(initCategory(effectChannelModel, hashMap));
        getChildEffect(effectChannelModel.getEffects(), hashMap2);
        effectChannelResponse.setPanelModel(effectChannelModel.getPanel());
        effectChannelResponse.setFrontEffect(getEffect(effectChannelModel.getFront_effect_id(), hashMap));
        effectChannelResponse.setRearEffect(getEffect(effectChannelModel.getRear_effect_id(), hashMap));
        if (!this.mIsCache) {
            fillEffectPath(effectChannelModel.getEffects());
            fillEffectPath(effectChannelModel.getCollection());
        }
        return effectChannelResponse;
    }
}
