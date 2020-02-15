package com.ss.android.ugc.effectmanager.effect.task.task;

import android.text.TextUtils;
import com.ss.android.ugc.effectmanager.common.ErrorConstants;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.common.utils.EffectUtils;
import com.ss.android.ugc.effectmanager.common.utils.FileUtils;
import com.ss.android.ugc.effectmanager.effect.bridge.EffectFetcher;
import com.ss.android.ugc.effectmanager.effect.bridge.EffectFetcherArguments;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import com.ss.android.ugc.effectmanager.effect.sync.SyncTask;
import com.ss.android.ugc.effectmanager.effect.task.result.EffectTaskResult;
import com.ss.android.ugc.effectmanager.network.EffectNetWorkerWrapper;
import java.io.File;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

public class DefaultEffectFetcher implements EffectFetcher {
    /* access modifiers changed from: private */
    public EffectNetWorkerWrapper mNetworker;

    public DefaultEffectFetcher(EffectNetWorkerWrapper effectNetWorkerWrapper) {
        this.mNetworker = effectNetWorkerWrapper;
    }

    public SyncTask<EffectTaskResult> fetchEffect(final EffectFetcherArguments effectFetcherArguments) {
        return new SyncTask<EffectTaskResult>() {
            public void execute() {
                String str;
                onStart(this);
                Effect effect = effectFetcherArguments.getEffect();
                if (effect == null || effectFetcherArguments.getDownloadUrl() == null || effectFetcherArguments.getDownloadUrl().isEmpty() || EffectUtils.isUrlModelEmpty(effect.getFileUrl())) {
                    onFailed(this, new ExceptionResult((int) ErrorConstants.CODE_EFFECT_NULL));
                } else {
                    int i = 0;
                    int size = effectFetcherArguments.getDownloadUrl().size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (isCanceled()) {
                            onFailed(this, new ExceptionResult((int) ErrorConstants.CODE_CANCEL_DOWNLOAD));
                            break;
                        } else {
                            String str2 = effectFetcherArguments.getDownloadUrl().get(i);
                            String str3 = null;
                            try {
                                if (TextUtils.isEmpty(effect.getZipPath()) || TextUtils.isEmpty(effect.getUnzipPath())) {
                                    effect.setZipPath(effectFetcherArguments.getEffectDir() + File.separator + effect.getId() + ".zip");
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(effectFetcherArguments.getEffectDir());
                                    sb.append(File.separator);
                                    sb.append(effect.getId());
                                    effect.setUnzipPath(sb.toString());
                                }
                                try {
                                    str = InetAddress.getByName(new URL(str2).getHost()).getHostAddress();
                                } catch (UnknownHostException e2) {
                                    e2.printStackTrace();
                                    str = null;
                                    EffectUtils.download(DefaultEffectFetcher.this.mNetworker, effectFetcherArguments.getDownloadUrl().get(i), effect.getZipPath());
                                    FileUtils.unZip(effect.getZipPath(), effect.getUnzipPath());
                                    onResponse(this, new EffectTaskResult(effect, (ExceptionResult) null));
                                    break;
                                    onFinally(this);
                                } catch (MalformedURLException e3) {
                                    e3.printStackTrace();
                                    str = null;
                                    EffectUtils.download(DefaultEffectFetcher.this.mNetworker, effectFetcherArguments.getDownloadUrl().get(i), effect.getZipPath());
                                    FileUtils.unZip(effect.getZipPath(), effect.getUnzipPath());
                                    onResponse(this, new EffectTaskResult(effect, (ExceptionResult) null));
                                    break;
                                    onFinally(this);
                                }
                                try {
                                    EffectUtils.download(DefaultEffectFetcher.this.mNetworker, effectFetcherArguments.getDownloadUrl().get(i), effect.getZipPath());
                                    FileUtils.unZip(effect.getZipPath(), effect.getUnzipPath());
                                    onResponse(this, new EffectTaskResult(effect, (ExceptionResult) null));
                                    break;
                                } catch (Exception e4) {
                                    String str4 = str;
                                    e = e4;
                                    str3 = str4;
                                }
                            } catch (Exception e5) {
                                e = e5;
                                if (i == size - 1) {
                                    e.printStackTrace();
                                    ExceptionResult exceptionResult = new ExceptionResult(e);
                                    exceptionResult.setTrackParams(str2, "", str3);
                                    FileUtils.removeDir(effect.getUnzipPath());
                                    onFailed(this, exceptionResult);
                                    onFinally(this);
                                }
                                i++;
                            }
                        }
                        i++;
                    }
                }
                onFinally(this);
            }
        };
    }
}
