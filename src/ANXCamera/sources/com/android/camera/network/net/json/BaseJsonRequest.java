package com.android.camera.network.net.json;

import com.android.camera.network.net.base.ErrorCode;
import com.android.camera.network.net.base.VolleyRequest;
import com.android.volley.Request;
import com.android.volley.Response;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class BaseJsonRequest<T> extends VolleyRequest<JSONObject, T> {
    private Map<String, String> mHeaders;
    private int mMethod = 1;
    private String mUrl = null;

    public BaseJsonRequest(int i, String str) {
        this.mMethod = i;
        this.mUrl = str;
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

    public final void addHeader(String str, String str2) {
        if (this.mHeaders == null) {
            this.mHeaders = new HashMap();
        }
        this.mHeaders.put(str, str2);
    }

    /* access modifiers changed from: protected */
    public final Request<JSONObject> createVolleyRequest(Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        String str = this.mUrl;
        String appendUrlParams = appendUrlParams();
        if (this.mMethod == 0) {
            str = appendUrlParams;
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(this.mMethod, str, listener, errorListener);
        Map<String, String> map = this.mParams;
        if (map != null) {
            jsonObjectRequest.setParams(map);
        }
        Map<String, String> map2 = this.mHeaders;
        if (map2 != null) {
            jsonObjectRequest.setHeaders(map2);
        }
        jsonObjectRequest.setCacheKey(getCacheKey());
        return jsonObjectRequest;
    }

    public String getCacheKey() {
        return appendUrlParams();
    }

    public final String getUrl() {
        return this.mUrl;
    }

    public void onRequestError(ErrorCode errorCode, String str, Object obj) {
        deliverError(errorCode, str, obj);
    }

    /* access modifiers changed from: protected */
    public void onRequestSuccess(T t) throws Exception {
        deliverResponse(t);
    }

    public final void setUrl(String str) {
        this.mUrl = str;
    }
}
