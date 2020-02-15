package com.ss.android.ugc.effectmanager.link.task.task;

import android.os.Handler;
import com.android.camera.statistic.MistatsConstants;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.common.task.NormalTask;
import com.ss.android.ugc.effectmanager.common.utils.LogUtils;
import com.ss.android.ugc.effectmanager.link.LinkSelector;
import com.ss.android.ugc.effectmanager.link.model.host.Host;
import com.ss.android.ugc.effectmanager.link.model.host.HostStatus;
import com.ss.android.ugc.effectmanager.link.task.result.HostListStatusUpdateTaskResult;
import com.ss.android.ugc.effectmanager.link.task.result.HostStatusUpdateResult;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HostListStatusUpdateTask extends NormalTask {
    private static final long MAX_SORT_TIME = 2147483647L;
    private static final String TAG = "HostListStatusUpdateTask";
    private List<Host> mHosts = new ArrayList();
    private LinkSelector mLinkSelector;
    private String mSpeedApi;

    public HostListStatusUpdateTask(LinkSelector linkSelector, Handler handler, String str) {
        super(handler, str, EffectConstants.NORMAL);
        this.mHosts.clear();
        this.mHosts.addAll(linkSelector.getOriginHosts());
        this.mSpeedApi = linkSelector.getSpeedApi();
        this.mLinkSelector = linkSelector;
    }

    /* JADX WARNING: type inference failed for: r6v1, types: [java.net.URLConnection] */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0154, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0155, code lost:
        r20 = r2;
        r22 = r7;
        r10 = r0;
        r9 = null;
        r4 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0160, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0161, code lost:
        r22 = r7;
        r10 = r0;
        r5 = -1;
        r9 = null;
        r4 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0169, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x016a, code lost:
        r22 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x016d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x016e, code lost:
        r22 = r7;
        r10 = r0;
        r5 = -1;
        r9 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x01b3, code lost:
        r22.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0169 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:6:0x0047] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    private void getHostStatus(Host host, long j) {
        HttpURLConnection httpURLConnection;
        Exception exc;
        String str;
        long j2;
        int i;
        int responseCode;
        long currentTimeMillis;
        long j3;
        String headerField;
        int i2;
        StringBuilder sb;
        int i3;
        long j4;
        Host host2 = host;
        if (host2 != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(host.getSchema());
            sb2.append("://");
            sb2.append(host.getHost());
            sb2.append(this.mSpeedApi);
            sb2.append(System.currentTimeMillis());
            long currentTimeMillis2 = System.currentTimeMillis();
            try {
                URL url = new URL(sb2.toString());
                HttpURLConnection openConnection = url.openConnection();
                try {
                    openConnection.setConnectTimeout(this.mLinkSelector.getSpeedTimeOut());
                    openConnection.setReadTimeout(this.mLinkSelector.getSpeedTimeOut());
                    openConnection.setRequestProperty("X-SS-No-Cookie", MistatsConstants.BaseEvent.VALUE_TRUE);
                    responseCode = openConnection.getResponseCode();
                    currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
                    headerField = openConnection.getHeaderField("X-TT-LOGID");
                    if (responseCode == 200) {
                        host2.setSortTime(currentTimeMillis + j);
                        host.resetStatus();
                        String url2 = url.toString();
                        long j5 = currentTimeMillis;
                        long j6 = j5;
                        httpURLConnection = openConnection;
                        i3 = responseCode;
                        String str2 = "://";
                        try {
                            sendEvent(url2, host, responseCode, j5, currentTimeMillis2, headerField, (Exception) null, true);
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("sort speed time = ");
                            j4 = j6;
                            try {
                                sb3.append(j4);
                                sb3.append(" ");
                                sb3.append(host.getSchema());
                                sb3.append(str2);
                                sb3.append(host.getHost());
                                LogUtils.d(TAG, sb3.toString());
                                LogUtils.d(TAG, "sort weight time = " + host.getWeightTime() + " " + host.getSchema() + str2 + host.getHost());
                            } catch (Exception e2) {
                                e = e2;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            j4 = j6;
                            j2 = j4;
                            str = headerField;
                            i = i3;
                            exc = e;
                            try {
                                LogUtils.e(TAG, "sort speed error = " + exc);
                                host2.setSortTime(MAX_SORT_TIME);
                                exc.printStackTrace();
                                sendEvent(sb2.toString(), host, i, j2, currentTimeMillis2, str, exc, false);
                                if (httpURLConnection == null) {
                                }
                                httpURLConnection.disconnect();
                            } catch (Throwable th) {
                                th = th;
                                if (httpURLConnection != null) {
                                }
                                throw th;
                            }
                        }
                    } else {
                        long j7 = currentTimeMillis;
                        httpURLConnection = openConnection;
                        int i4 = responseCode;
                        try {
                            sb = new StringBuilder();
                            sb.append("sort speed error code = ");
                            i2 = i4;
                        } catch (Exception e4) {
                            e = e4;
                            j3 = j7;
                            i2 = i4;
                            exc = e;
                            i = i2;
                            str = headerField;
                            j2 = j3;
                            LogUtils.e(TAG, "sort speed error = " + exc);
                            host2.setSortTime(MAX_SORT_TIME);
                            exc.printStackTrace();
                            sendEvent(sb2.toString(), host, i, j2, currentTimeMillis2, str, exc, false);
                            if (httpURLConnection == null) {
                            }
                            httpURLConnection.disconnect();
                        }
                        try {
                            sb.append(i2);
                            LogUtils.e(TAG, sb.toString());
                            host2.setSortTime(MAX_SORT_TIME);
                            j3 = j7;
                            try {
                                sendEvent(url.toString(), host, i2, j7, currentTimeMillis2, headerField, (Exception) null, false);
                            } catch (Exception e5) {
                                e = e5;
                                exc = e;
                                i = i2;
                                str = headerField;
                                j2 = j3;
                                LogUtils.e(TAG, "sort speed error = " + exc);
                                host2.setSortTime(MAX_SORT_TIME);
                                exc.printStackTrace();
                                sendEvent(sb2.toString(), host, i, j2, currentTimeMillis2, str, exc, false);
                                if (httpURLConnection == null) {
                                }
                                httpURLConnection.disconnect();
                            }
                        } catch (Exception e6) {
                            e = e6;
                            j3 = j7;
                            exc = e;
                            i = i2;
                            str = headerField;
                            j2 = j3;
                            LogUtils.e(TAG, "sort speed error = " + exc);
                            host2.setSortTime(MAX_SORT_TIME);
                            exc.printStackTrace();
                            sendEvent(sb2.toString(), host, i, j2, currentTimeMillis2, str, exc, false);
                            if (httpURLConnection == null) {
                            }
                            httpURLConnection.disconnect();
                        }
                    }
                    if (httpURLConnection == null) {
                        return;
                    }
                } catch (Exception e7) {
                    e = e7;
                    j4 = currentTimeMillis;
                    httpURLConnection = openConnection;
                    i3 = responseCode;
                    j2 = j4;
                    str = headerField;
                    i = i3;
                    exc = e;
                    LogUtils.e(TAG, "sort speed error = " + exc);
                    host2.setSortTime(MAX_SORT_TIME);
                    exc.printStackTrace();
                    sendEvent(sb2.toString(), host, i, j2, currentTimeMillis2, str, exc, false);
                    if (httpURLConnection == null) {
                    }
                    httpURLConnection.disconnect();
                } catch (Throwable th2) {
                }
            } catch (Exception e8) {
                Exception exc2 = e8;
                j2 = -1;
                String str3 = null;
                HttpURLConnection httpURLConnection2 = null;
                i = -1;
                LogUtils.e(TAG, "sort speed error = " + exc);
                host2.setSortTime(MAX_SORT_TIME);
                exc.printStackTrace();
                sendEvent(sb2.toString(), host, i, j2, currentTimeMillis2, str, exc, false);
                if (httpURLConnection == null) {
                }
                httpURLConnection.disconnect();
            } catch (Throwable th3) {
                th = th3;
                httpURLConnection = null;
                if (httpURLConnection != null) {
                }
                throw th;
            }
            httpURLConnection.disconnect();
        }
    }

    private void sendEvent(String str, Host host, int i, long j, long j2, String str2, Exception exc, boolean z) {
        HostStatus hostStatus = new HostStatus(str, host, i, j, j2, str2, exc, z);
        sendMessage(30, new HostStatusUpdateResult(hostStatus, (ExceptionResult) null));
    }

    private void sendResults() {
        sendMessage(31, new HostListStatusUpdateTaskResult(this.mHosts, (ExceptionResult) null));
    }

    private void sortHost() {
        Collections.sort(this.mHosts, new Comparator<Host>() {
            public int compare(Host host, Host host2) {
                return (int) (host.getSortTime() - host2.getSortTime());
            }
        });
        ArrayList arrayList = new ArrayList(this.mHosts);
        arrayList.clear();
        arrayList.addAll(this.mHosts);
        int i = 0;
        while (i < this.mHosts.size()) {
            Host host = this.mHosts.get(i);
            LogUtils.d(TAG, "weight sort = " + host.getSortTime() + " " + host.getSchema() + "://" + host.getHost() + this.mSpeedApi);
            i++;
            for (int i2 = i; i2 < this.mHosts.size(); i2++) {
                Host host2 = this.mHosts.get(i2);
                if (host.getHost().equals(host2.getHost())) {
                    arrayList.remove(host2);
                }
            }
        }
        this.mHosts.clear();
        this.mHosts.addAll(arrayList);
        LogUtils.d(TAG, "speed distinct = " + this.mHosts.size() + " thread = " + Thread.currentThread());
    }

    private void speedMeasure() {
        for (int i = 0; i < this.mHosts.size(); i++) {
            this.mHosts.get(i).setSortTime(0);
            for (int i2 = 0; i2 < this.mLinkSelector.getRepeatTime(); i2++) {
                getHostStatus(this.mHosts.get(i), this.mHosts.get(i).getSortTime());
            }
        }
    }

    public void execute() {
        speedMeasure();
        sortHost();
        sendResults();
    }
}
