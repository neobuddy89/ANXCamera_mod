package com.ss.android.ugc.effectmanager.effect.task.task;

import android.os.Handler;
import android.text.TextUtils;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import com.ss.android.ugc.effectmanager.common.ErrorConstants;
import com.ss.android.ugc.effectmanager.common.listener.ICache;
import com.ss.android.ugc.effectmanager.common.listener.IJsonConverter;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.common.task.NormalTask;
import com.ss.android.ugc.effectmanager.common.utils.EffectCacheKeyGenerator;
import com.ss.android.ugc.effectmanager.common.utils.EffectUtils;
import com.ss.android.ugc.effectmanager.context.EffectContext;
import com.ss.android.ugc.effectmanager.effect.model.BuildEffectChannelResponse;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import com.ss.android.ugc.effectmanager.effect.model.EffectCategoryModel;
import com.ss.android.ugc.effectmanager.effect.model.EffectCategoryResponse;
import com.ss.android.ugc.effectmanager.effect.model.EffectChannelModel;
import com.ss.android.ugc.effectmanager.effect.model.EffectChannelResponse;
import com.ss.android.ugc.effectmanager.effect.task.result.EffectChannelTaskResult;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class FetchEffectChannelCacheTask extends NormalTask {
    private ICache mCache = this.mEffectContext.getEffectConfiguration().getCache();
    private EffectContext mEffectContext;
    private IJsonConverter mJsonConverter = this.mEffectContext.getEffectConfiguration().getJsonConverter();
    private String panel;
    private boolean whileDownload;

    public FetchEffectChannelCacheTask(EffectContext effectContext, String str, String str2, Handler handler, boolean z) {
        super(handler, str2, EffectConstants.NETWORK);
        this.panel = str;
        this.whileDownload = z;
        this.mEffectContext = effectContext;
    }

    private EffectChannelResponse buildChannelResponse(EffectChannelModel effectChannelModel) {
        EffectChannelResponse effectChannelResponse = new EffectChannelResponse();
        effectChannelResponse.setVersion(effectChannelModel.getVersion());
        effectChannelResponse.setAllCategoryEffects(effectChannelModel.getEffects());
        ArrayList arrayList = new ArrayList();
        effectChannelResponse.setCollections(effectChannelModel.getCollection());
        for (EffectCategoryModel next : effectChannelModel.getCategory()) {
            EffectCategoryResponse effectCategoryResponse = new EffectCategoryResponse();
            next.checkValued();
            effectCategoryResponse.setName(next.getName());
            effectCategoryResponse.setId(next.getId());
            if (!next.getIcon().getUrl_list().isEmpty()) {
                effectCategoryResponse.setIcon_normal_url(next.getIcon().getUrl_list().get(0));
            }
            if (!next.getIcon_selected().getUrl_list().isEmpty()) {
                effectCategoryResponse.setIcon_selected_url(next.getIcon_selected().getUrl_list().get(0));
            }
            effectCategoryResponse.setTotalEffects(getCategoryAllEffects(next, effectChannelModel));
            effectCategoryResponse.setTagsUpdateTime(next.getTagsUpdateTime());
            effectCategoryResponse.setTags(next.getTags());
            effectCategoryResponse.setKey(next.getKey());
            arrayList.add(effectCategoryResponse);
        }
        effectChannelResponse.setCategoryResponseList(arrayList);
        effectChannelResponse.setPanel(this.panel);
        effectChannelResponse.setPanelModel(effectChannelModel.getPanel());
        if (this.whileDownload) {
            downloadEffect(effectChannelModel.getEffects());
        }
        return effectChannelResponse;
    }

    private void downloadEffect(List<Effect> list) {
        for (Effect next : list) {
            if (!this.mCache.has(next.getId())) {
                try {
                    EffectUtils.downloadEffect(this.mEffectContext.getEffectConfiguration(), next);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private List<Effect> getCategoryAllEffects(EffectCategoryModel effectCategoryModel, EffectChannelModel effectChannelModel) {
        ArrayList arrayList = new ArrayList();
        for (String next : effectCategoryModel.getEffects()) {
            for (Effect next2 : effectChannelModel.getEffects()) {
                if (TextUtils.equals(next, next2.getEffectId())) {
                    arrayList.add(next2);
                }
            }
        }
        return arrayList;
    }

    public void execute() {
        InputStream queryToStream = this.mCache.queryToStream(EffectCacheKeyGenerator.generatePanelKey(this.mEffectContext.getEffectConfiguration().getChannel(), this.panel));
        if (queryToStream == null) {
            sendMessage(14, new EffectChannelTaskResult(new EffectChannelResponse(this.panel), new ExceptionResult((int) ErrorConstants.CODE_INVALID_EFFECT_CACHE)));
            return;
        }
        EffectChannelModel effectChannelModel = (EffectChannelModel) this.mJsonConverter.convertJsonToObj(queryToStream, EffectChannelModel.class);
        if (effectChannelModel == null) {
            sendMessage(14, new EffectChannelTaskResult(new EffectChannelResponse(this.panel), new ExceptionResult((int) ErrorConstants.CODE_INVALID_EFFECT_CACHE)));
        } else if (!effectChannelModel.checkValued()) {
            sendMessage(14, new EffectChannelTaskResult(new EffectChannelResponse(this.panel), new ExceptionResult((int) ErrorConstants.CODE_INVALID_EFFECT_CACHE)));
        } else {
            sendMessage(14, new EffectChannelTaskResult(new BuildEffectChannelResponse(this.panel, this.mEffectContext.getEffectConfiguration().getEffectDir().getAbsolutePath(), true).buildChannelResponse(effectChannelModel), (ExceptionResult) null));
        }
    }
}
