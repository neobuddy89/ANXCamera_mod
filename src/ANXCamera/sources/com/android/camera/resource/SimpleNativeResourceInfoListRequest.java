package com.android.camera.resource;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.android.camera.CameraAppImpl;
import com.android.camera.Util;
import com.android.camera.log.Log;
import com.android.camera.module.impl.component.FileUtils;
import com.android.camera.resource.BaseResourceList;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import org.json.JSONObject;

public class SimpleNativeResourceInfoListRequest<T extends BaseResourceList> extends BaseObservableRequest<T> {
    private static final String PREFIX_CLOUD_RESOURCE = "https://";
    private static final String PREFIX_EXTERNAL_RESOURCE = "sdcard/";
    private static final String PREFIX_NATIVE_RESOURCE = "assets://";
    private String mAssetName;
    private String mOutPutFolder;

    public SimpleNativeResourceInfoListRequest(String str, String str2) {
        this.mAssetName = str;
        this.mOutPutFolder = str2;
    }

    private String convertStreamToString(InputStream inputStream) {
        Scanner useDelimiter = new Scanner(inputStream).useDelimiter("\\A");
        return useDelimiter.hasNext() ? useDelimiter.next() : "";
    }

    @NonNull
    private T create(@NonNull Class<T> cls) {
        try {
            return (BaseResourceList) cls.newInstance();
        } catch (InstantiationException unused) {
            Log.e("newInstanceError", "Cannot create an instance of " + cls);
            return null;
        } catch (IllegalAccessException unused2) {
            Log.e("newInstanceError", "Cannot create an instance of " + cls);
            return null;
        }
    }

    private void decompressNativeResource(Context context, BaseResourceItem baseResourceItem, String str, boolean z) throws IOException {
        String str2 = baseResourceItem.uri.split(PREFIX_NATIVE_RESOURCE)[1];
        String str3 = str + baseResourceItem.id + File.separator;
        if (!z || !baseResourceItem.simpleVerification(str3)) {
            Util.verifyAssetZip(context, str2, str3, 32768);
            baseResourceItem.onDecompressFinished(str3);
            return;
        }
        baseResourceItem.onDecompressFinished(str3);
    }

    private void decompressSdcardResource(Context context, String str, BaseResourceItem baseResourceItem, String str2) throws IOException {
        baseResourceItem.onDecompressFinished(str2 + baseResourceItem.id + File.separator);
    }

    private String getAssetCache(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return convertStreamToString(context.getApplicationContext().getAssets().open(str));
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void decompressResource(Context context, T t, String str, boolean z) throws IOException {
        for (BaseResourceItem baseResourceItem : t.getResourceList()) {
            String str2 = baseResourceItem.uri;
            if (str2.startsWith(PREFIX_NATIVE_RESOURCE)) {
                decompressNativeResource(context, baseResourceItem, str, z);
            } else if (str2.startsWith(PREFIX_EXTERNAL_RESOURCE)) {
                decompressSdcardResource(context, baseResourceItem.uri, baseResourceItem, str);
            }
        }
    }

    /* access modifiers changed from: protected */
    public Scheduler getWorkThread() {
        return Schedulers.io();
    }

    /* access modifiers changed from: protected */
    public void scheduleRequest(ResponseListener<T> responseListener, Class<T> cls) {
        Context androidContext = CameraAppImpl.getAndroidContext();
        String assetCache = getAssetCache(this.mAssetName, androidContext);
        T create = create(cls);
        if (create == null) {
            responseListener.onResponseError(2, (String) null, (Object) null);
        }
        try {
            create.createResourcesList(new JSONObject(assetCache));
            boolean z = true;
            String str = create.version;
            if (!create.getLocalVersion().equals(str)) {
                z = false;
                create.setLocalVersion(str);
            }
            try {
                FileUtils.makeNoMediaDir(this.mOutPutFolder);
                decompressResource(androidContext, create, this.mOutPutFolder, z);
                responseListener.onResponse(create);
            } catch (IOException e2) {
                e2.printStackTrace();
                responseListener.onResponseError(3, e2.getMessage(), (Object) null);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            responseListener.onResponseError(2, e3.getMessage(), (Object) null);
        }
    }
}
