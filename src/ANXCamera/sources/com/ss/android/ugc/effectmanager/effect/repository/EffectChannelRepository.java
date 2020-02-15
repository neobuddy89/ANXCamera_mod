package com.ss.android.ugc.effectmanager.effect.repository;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.android.ugc.effectmanager.common.WeakHandler;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.context.EffectContext;
import com.ss.android.ugc.effectmanager.effect.listener.ICheckChannelListener;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchCategoryEffectListener;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchPanelInfoListener;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchProviderEffect;
import com.ss.android.ugc.effectmanager.effect.model.EffectChannelResponse;
import com.ss.android.ugc.effectmanager.effect.task.result.EffectChannelTaskResult;
import com.ss.android.ugc.effectmanager.effect.task.result.EffectCheckUpdateResult;
import com.ss.android.ugc.effectmanager.effect.task.result.FetchCategoryEffectTaskResult;
import com.ss.android.ugc.effectmanager.effect.task.result.FetchPanelInfoTaskResult;
import com.ss.android.ugc.effectmanager.effect.task.result.ProviderEffectTaskResult;
import com.ss.android.ugc.effectmanager.effect.task.task.CheckUpdateTask;
import com.ss.android.ugc.effectmanager.effect.task.task.FetchCategoryEffectCacheTask;
import com.ss.android.ugc.effectmanager.effect.task.task.FetchCategoryEffectTask;
import com.ss.android.ugc.effectmanager.effect.task.task.FetchEffectChannelCacheTask;
import com.ss.android.ugc.effectmanager.effect.task.task.FetchEffectChannelTask;
import com.ss.android.ugc.effectmanager.effect.task.task.FetchExistEffectListTask;
import com.ss.android.ugc.effectmanager.effect.task.task.FetchPanelInfoCacheTask;
import com.ss.android.ugc.effectmanager.effect.task.task.FetchPanelInfoTask;
import com.ss.android.ugc.effectmanager.effect.task.task.FetchProviderEffectTask;
import com.ss.android.ugc.effectmanager.effect.task.task.SearchProviderEffectTask;

public class EffectChannelRepository implements WeakHandler.IHandler {
    private EffectConfiguration mConfiguration = this.mEffectContext.getEffectConfiguration();
    private EffectContext mEffectContext;
    private EffectListListener mEffectListListener;
    private Handler mHandler = new WeakHandler(this);

    public interface EffectListListener {
        void updateEffectChannel(String str, EffectChannelResponse effectChannelResponse, int i, ExceptionResult exceptionResult);
    }

    public EffectChannelRepository(EffectContext effectContext) {
        this.mEffectContext = effectContext;
    }

    public void checkUpdate(String str, String str2, int i, String str3) {
        CheckUpdateTask checkUpdateTask = new CheckUpdateTask(this.mEffectContext, str3, this.mHandler, str, str2, i);
        this.mConfiguration.getTaskManager().commit(checkUpdateTask);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: com.ss.android.ugc.effectmanager.effect.task.task.FetchCategoryEffectCacheTask} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v0, resolved type: com.ss.android.ugc.effectmanager.effect.task.task.FetchCategoryEffectTask} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: com.ss.android.ugc.effectmanager.effect.task.task.FetchCategoryEffectCacheTask} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.ss.android.ugc.effectmanager.effect.task.task.FetchCategoryEffectCacheTask} */
    /* JADX WARNING: Multi-variable type inference failed */
    public void fetchCategoryEffect(String str, String str2, String str3, int i, int i2, int i3, String str4, boolean z) {
        FetchCategoryEffectCacheTask fetchCategoryEffectCacheTask;
        if (z) {
            FetchCategoryEffectCacheTask fetchCategoryEffectCacheTask2 = new FetchCategoryEffectCacheTask(this.mEffectContext, str, str2, str3, i, i2, i3, str4, this.mHandler);
            fetchCategoryEffectCacheTask = fetchCategoryEffectCacheTask2;
        } else {
            FetchCategoryEffectTask fetchCategoryEffectTask = new FetchCategoryEffectTask(this.mEffectContext, str, str2, str3, i, i2, i3, str4, this.mHandler);
            fetchCategoryEffectCacheTask = fetchCategoryEffectTask;
        }
        this.mConfiguration.getTaskManager().commit(fetchCategoryEffectCacheTask);
    }

    public void fetchExistEffectList(@NonNull String str, String str2) {
        this.mConfiguration.getTaskManager().commit(new FetchExistEffectListTask(str, str2, this.mEffectContext, this.mHandler));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: com.ss.android.ugc.effectmanager.effect.task.task.FetchEffectChannelCacheTask} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: com.ss.android.ugc.effectmanager.effect.task.task.FetchEffectChannelTask} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: com.ss.android.ugc.effectmanager.effect.task.task.FetchEffectChannelCacheTask} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: com.ss.android.ugc.effectmanager.effect.task.task.FetchEffectChannelCacheTask} */
    /* JADX WARNING: Multi-variable type inference failed */
    public void fetchList(String str, String str2, boolean z) {
        FetchEffectChannelCacheTask fetchEffectChannelCacheTask;
        if (z) {
            FetchEffectChannelCacheTask fetchEffectChannelCacheTask2 = new FetchEffectChannelCacheTask(this.mEffectContext, str, str2, this.mHandler, false);
            fetchEffectChannelCacheTask = fetchEffectChannelCacheTask2;
        } else {
            fetchEffectChannelCacheTask = new FetchEffectChannelTask(this.mEffectContext, str, str2, this.mHandler);
        }
        this.mConfiguration.getTaskManager().commit(fetchEffectChannelCacheTask);
    }

    /* JADX WARNING: type inference failed for: r1v2, types: [com.ss.android.ugc.effectmanager.effect.task.task.FetchPanelInfoCacheTask] */
    /* JADX WARNING: Multi-variable type inference failed */
    public void fetchPanelInfo(String str, String str2, boolean z, String str3, int i, int i2, boolean z2, IFetchPanelInfoListener iFetchPanelInfoListener) {
        FetchPanelInfoTask fetchPanelInfoTask;
        if (z2) {
            String str4 = str;
            String str5 = str2;
            fetchPanelInfoTask = new FetchPanelInfoCacheTask(this.mEffectContext, str, str2, this.mHandler);
        } else {
            FetchPanelInfoTask fetchPanelInfoTask2 = new FetchPanelInfoTask(this.mEffectContext, str, str2, z, str3, i, i2, this.mHandler);
            fetchPanelInfoTask = fetchPanelInfoTask2;
        }
        this.mConfiguration.getTaskManager().commit(fetchPanelInfoTask);
    }

    public void fetchProviderEffectList(@Nullable String str, int i, int i2, String str2) {
        FetchProviderEffectTask fetchProviderEffectTask = new FetchProviderEffectTask(this.mEffectContext, str2, str, i, i2, this.mHandler);
        this.mConfiguration.getTaskManager().commit(fetchProviderEffectTask);
    }

    public void handleMsg(Message message) {
        if (this.mEffectListListener != null) {
            if (message.what == 14) {
                Object obj = message.obj;
                if (obj instanceof EffectChannelTaskResult) {
                    EffectChannelTaskResult effectChannelTaskResult = (EffectChannelTaskResult) obj;
                    ExceptionResult exception = effectChannelTaskResult.getException();
                    if (exception == null) {
                        this.mEffectListListener.updateEffectChannel(effectChannelTaskResult.getTaskID(), effectChannelTaskResult.getEffectChannels(), 23, (ExceptionResult) null);
                    } else {
                        this.mEffectListListener.updateEffectChannel(effectChannelTaskResult.getTaskID(), effectChannelTaskResult.getEffectChannels(), 27, exception);
                    }
                }
            }
            if (message.what == 22) {
                Object obj2 = message.obj;
                if (obj2 instanceof FetchPanelInfoTaskResult) {
                    FetchPanelInfoTaskResult fetchPanelInfoTaskResult = (FetchPanelInfoTaskResult) obj2;
                    IFetchPanelInfoListener fetchPanelInfoListener = this.mConfiguration.getListenerManger().getFetchPanelInfoListener(fetchPanelInfoTaskResult.getTaskID());
                    ExceptionResult exception2 = fetchPanelInfoTaskResult.getException();
                    if (exception2 == null) {
                        fetchPanelInfoListener.onSuccess(fetchPanelInfoTaskResult.getPanelInfoModel());
                    } else {
                        fetchPanelInfoListener.onFail(exception2);
                    }
                }
            }
            if (message.what == 18) {
                Object obj3 = message.obj;
                if (obj3 instanceof ProviderEffectTaskResult) {
                    ProviderEffectTaskResult providerEffectTaskResult = (ProviderEffectTaskResult) obj3;
                    ExceptionResult exception3 = providerEffectTaskResult.getException();
                    IFetchProviderEffect fetchProviderEffectListener = this.mConfiguration.getListenerManger().getFetchProviderEffectListener(providerEffectTaskResult.getTaskID());
                    if (fetchProviderEffectListener != null) {
                        if (exception3 == null) {
                            fetchProviderEffectListener.onSuccess(providerEffectTaskResult.getEffectListResponse());
                        } else {
                            fetchProviderEffectListener.onFail(providerEffectTaskResult.getException());
                        }
                    }
                }
            }
            if (message.what == 21) {
                Object obj4 = message.obj;
                if (obj4 instanceof FetchCategoryEffectTaskResult) {
                    FetchCategoryEffectTaskResult fetchCategoryEffectTaskResult = (FetchCategoryEffectTaskResult) obj4;
                    ExceptionResult exception4 = fetchCategoryEffectTaskResult.getException();
                    IFetchCategoryEffectListener fetchCategoryEffectListener = this.mConfiguration.getListenerManger().getFetchCategoryEffectListener(fetchCategoryEffectTaskResult.getTaskID());
                    if (fetchCategoryEffectListener != null) {
                        if (exception4 == null) {
                            fetchCategoryEffectListener.onSuccess(fetchCategoryEffectTaskResult.getEffectChannels());
                        } else {
                            fetchCategoryEffectListener.onFail(exception4);
                        }
                    }
                }
            }
            if (message.what == 13) {
                Object obj5 = message.obj;
                if (obj5 instanceof EffectCheckUpdateResult) {
                    EffectCheckUpdateResult effectCheckUpdateResult = (EffectCheckUpdateResult) obj5;
                    ExceptionResult exception5 = effectCheckUpdateResult.getException();
                    ICheckChannelListener checkChannelListener = this.mConfiguration.getListenerManger().getCheckChannelListener(effectCheckUpdateResult.getTaskID());
                    if (checkChannelListener == null) {
                        return;
                    }
                    if (exception5 == null) {
                        checkChannelListener.checkChannelSuccess(effectCheckUpdateResult.isUpdate());
                    } else {
                        checkChannelListener.checkChannelFailed(exception5);
                    }
                }
            }
        }
    }

    public void searchProviderEffectList(@NonNull String str, @Nullable String str2, int i, int i2, String str3) {
        SearchProviderEffectTask searchProviderEffectTask = new SearchProviderEffectTask(this.mEffectContext, str3, str, str2, i, i2, this.mHandler);
        this.mConfiguration.getTaskManager().commit(searchProviderEffectTask);
    }

    public void setOnEffectListListener(EffectListListener effectListListener) {
        this.mEffectListListener = effectListListener;
    }
}
