package com.android.camera.resource;

import android.util.Log;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public abstract class SimpleNetworkBaseRequest<T> extends BaseObservableRequest<T> {
    protected static final OkHttpClient CLIENT = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS).writeTimeout(10, TimeUnit.SECONDS).readTimeout(10, TimeUnit.SECONDS).build();
    protected static final String TAG = "SimpleNetworkBaseRequest";
    protected Map<String, String> mParams = new HashMap();
    protected String mUrl;

    public SimpleNetworkBaseRequest(String str) {
        setUrl(str);
    }

    private String appendUrlParams() {
        if (this.mUrl != null) {
            Map<String, String> map = this.mParams;
            if (map != null && !map.isEmpty()) {
                StringBuilder sb = new StringBuilder(this.mUrl);
                if (this.mUrl.indexOf(63) > 0) {
                    if (!this.mUrl.endsWith("?") && !this.mUrl.endsWith("&")) {
                        sb.append("&");
                    }
                    sb.append(encodeParameters(this.mParams, "UTF-8"));
                    return sb.toString();
                }
                sb.append("?");
                sb.append(encodeParameters(this.mParams, "UTF-8"));
                return sb.toString();
            }
        }
        return this.mUrl;
    }

    private String encodeParameters(Map<String, String> map, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry next : map.entrySet()) {
                sb.append(URLEncoder.encode((String) next.getKey(), str));
                sb.append('=');
                sb.append(URLEncoder.encode((String) next.getValue(), str));
                sb.append('&');
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("Encoding not supported: " + str, e2);
        }
    }

    /* access modifiers changed from: protected */
    public void addParam(String str, String str2) {
        this.mParams.put(str, str2);
    }

    /* access modifiers changed from: protected */
    public abstract T process(String str) throws BaseRequestException;

    /* access modifiers changed from: protected */
    public void scheduleRequest(final ResponseListener<T> responseListener, Class<T> cls) {
        CLIENT.newCall(new Request.Builder().get().url(appendUrlParams()).build()).enqueue(new Callback() {
            public void onFailure(Call call, IOException iOException) {
                Log.e(SimpleNetworkBaseRequest.TAG, "scheduleRequest onFailure", iOException);
                ResponseListener responseListener = responseListener;
                if (responseListener != null) {
                    responseListener.onResponseError(0, iOException.getMessage(), iOException);
                }
            }

            public void onResponse(Call call, Response response) {
                if (!response.isSuccessful()) {
                    ResponseListener responseListener = responseListener;
                    if (responseListener != null) {
                        responseListener.onResponseError(1, response.message(), response);
                    }
                } else {
                    try {
                        Object process = SimpleNetworkBaseRequest.this.process(response.body().string());
                        if (responseListener != null) {
                            responseListener.onResponse(process);
                        }
                    } catch (BaseRequestException e2) {
                        ResponseListener responseListener2 = responseListener;
                        if (responseListener2 != null) {
                            responseListener2.onResponseError(e2.getErrorCode(), e2.getMessage(), response);
                        }
                    } catch (IOException e3) {
                        ResponseListener responseListener3 = responseListener;
                        if (responseListener3 != null) {
                            responseListener3.onResponseError(0, e3.getMessage(), response);
                        }
                    }
                }
                response.close();
            }
        });
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }
}
