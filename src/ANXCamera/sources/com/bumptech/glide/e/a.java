package com.bumptech.glide.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import com.bumptech.glide.load.c;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: ApplicationVersionSignature */
public final class a {
    private static final String TAG = "AppVersionSignature";
    private static final ConcurrentMap<String, c> gm = new ConcurrentHashMap();

    private a() {
    }

    @Nullable
    private static PackageInfo N(@NonNull Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e(TAG, "Cannot resolve info for" + context.getPackageName(), e2);
            return null;
        }
    }

    @NonNull
    private static c O(@NonNull Context context) {
        return new d(b(N(context)));
    }

    @NonNull
    private static String b(@Nullable PackageInfo packageInfo) {
        return packageInfo != null ? String.valueOf(packageInfo.versionCode) : UUID.randomUUID().toString();
    }

    @NonNull
    public static c obtain(@NonNull Context context) {
        String packageName = context.getPackageName();
        c cVar = (c) gm.get(packageName);
        if (cVar != null) {
            return cVar;
        }
        c O = O(context);
        c putIfAbsent = gm.putIfAbsent(packageName, O);
        return putIfAbsent == null ? O : putIfAbsent;
    }

    @VisibleForTesting
    static void reset() {
        gm.clear();
    }
}
