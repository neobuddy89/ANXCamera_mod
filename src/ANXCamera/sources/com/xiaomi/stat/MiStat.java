package com.xiaomi.stat;

import android.content.Context;

public class MiStat {

    /* renamed from: a  reason: collision with root package name */
    private static C0162e f304a;

    public final class Event {
        public static final String ADD_TO_CART = "add_to_cart";
        public static final String ADD_TO_FAVORITE = "add_to_favorite";
        public static final String APP_OPEN = "app_open";
        public static final String CLICK = "click";
        public static final String DOWNLOAD_START = "download_start";
        public static final String ECOMMERCE_PAY = "ecommerce_pay";
        public static final String IMPRESSION = "impression";
        public static final String LEVEL_UP = "level_up";
        public static final String LOGIN = "login";
        public static final String PURCHASE_REFUND = "purchase_refund";
        public static final String REMOVE_FROM_CART = "remove_from_cart";
        public static final String SEARCH = "search";
        public static final String SHARE = "share";
        public static final String SIGN_UP = "sign_up";

        public Event() {
        }
    }

    public final class NetworkType {
        public static final int TYPE_2G = 1;
        public static final int TYPE_3G = 2;
        public static final int TYPE_4G = 4;
        public static final int TYPE_ALL = 31;
        public static final int TYPE_ETHERNET = 16;
        public static final int TYPE_NONE = 0;
        public static final int TYPE_WIFI = 8;

        public NetworkType() {
        }
    }

    public final class Param {
        public static final String CITY = "city";
        public static final String CONTENT = "content";
        public static final String CONTENT_TYPE = "content_type";
        public static final String COUNT = "count";
        public static final String CURRENCY = "currency";
        public static final String DESTINATION = "destination";
        public static final String END_DATE = "end_date";
        public static final String LEVEL = "level";
        public static final String LEVEL_NAME = "level_name";
        public static final String LOCATION = "location";
        public static final String METHOD = "method";
        public static final String ORIGIN = "origin";
        public static final String PRICE = "price";
        public static final String PROVINCE = "province";
        public static final String REGION = "region";
        public static final String SCORE = "score";
        public static final String SEARCH_TERM = "search_term";
        public static final String START_DATE = "start_date";
        public static final String STATUS = "status";
        public static final String VALUE = "value";

        public Param() {
        }
    }

    public final class UserProperty {
        public static final String CITY = "city";
        public static final String FIRST_ACTIVATION = "first_activation";
        public static final String PACKAGE_CHANNEL = "package_channel";
        public static final String PROVINCE = "province";
        public static final String REGION = "region";
        public static final String SIGN_UP_METHOD = "sign_up_method";
        public static final String SIGN_UP_TIME = "sign_up_time";
        public static final String USER_NAME = "user_name";

        public UserProperty() {
        }
    }

    private static void a() {
        if (f304a == null) {
            throw new IllegalStateException("must init sdk before use!");
        }
    }

    public static String getDeviceId() {
        a();
        return f304a.c();
    }

    public static int getUploadInterval() {
        a();
        return f304a.b();
    }

    public static int getUploadNetworkType() {
        a();
        return f304a.a();
    }

    public static void initialize(Context context, String str, String str2, boolean z) {
        if (f304a == null) {
            f304a = new C0162e(context, str, str2, z);
            return;
        }
        throw new IllegalStateException("duplicate sdk init!");
    }

    public static void initialize(Context context, String str, String str2, boolean z, String str3) {
        if (f304a == null) {
            C0162e eVar = new C0162e(context, str, str2, z, str3);
            f304a = eVar;
            return;
        }
        throw new IllegalStateException("duplicate sdk init!");
    }

    public static void setCustomPrivacyState(boolean z) {
        a();
        f304a.d(z);
    }

    public static void setDebugModeEnabled(boolean z) {
        a();
        f304a.f(z);
    }

    public static void setExceptionCatcherEnabled(boolean z) {
        a();
        f304a.c(z);
    }

    public static void setIdentifiedUserProperty(MiStatParams miStatParams) {
        a();
        f304a.b(miStatParams);
    }

    public static void setIdentifiedUserProperty(String str, String str2) {
        a();
        f304a.d(str, str2);
    }

    public static void setInternationalRegion(boolean z, String str) {
        a();
        f304a.a(z, str);
    }

    public static void setNetworkAccessEnabled(boolean z) {
        a();
        f304a.b(z);
    }

    public static void setStatisticEnabled(boolean z) {
        a();
        f304a.a(z);
    }

    public static void setUploadInterval(int i) {
        a();
        f304a.b(i);
    }

    public static void setUploadNetworkType(int i) {
        a();
        f304a.a(i);
    }

    public static boolean setUseSystemUploadingService(boolean z) {
        a();
        return f304a.e(z);
    }

    public static boolean setUseSystemUploadingService(boolean z, boolean z2) {
        a();
        return f304a.a(z, z2);
    }

    public static void setUserId(String str) {
        a();
        f304a.e(str);
    }

    public static void setUserProperty(MiStatParams miStatParams) {
        a();
        f304a.a(miStatParams);
    }

    public static void setUserProperty(String str, String str2) {
        a();
        f304a.c(str, str2);
    }

    public static void trackEvent(String str) {
        a();
        f304a.c(str);
    }

    public static void trackEvent(String str, MiStatParams miStatParams) {
        a();
        f304a.b(str, miStatParams);
    }

    public static void trackEvent(String str, String str2) {
        a();
        f304a.a(str, str2);
    }

    public static void trackEvent(String str, String str2, MiStatParams miStatParams) {
        a();
        f304a.a(str, str2, miStatParams);
    }

    public static void trackException(Throwable th) {
        a();
        f304a.a(th);
    }

    public static void trackException(Throwable th, String str) {
        a();
        f304a.a(th, str);
    }

    public static void trackHttpEvent(HttpEvent httpEvent) {
        a();
        f304a.a(httpEvent);
    }

    public static void trackIdentifiedEvent(String str) {
        a();
        f304a.c(str);
    }

    public static void trackIdentifiedEvent(String str, MiStatParams miStatParams) {
        a();
        f304a.b(str, miStatParams);
    }

    public static void trackIdentifiedEvent(String str, String str2) {
        a();
        f304a.a(str, str2);
    }

    public static void trackIdentifiedEvent(String str, String str2, MiStatParams miStatParams) {
        a();
        f304a.a(str, str2, miStatParams);
    }

    public static void trackPageEnd(String str) {
        a();
        f304a.b(str);
    }

    public static void trackPageEnd(String str, MiStatParams miStatParams) {
        a();
        f304a.a(str, miStatParams);
    }

    public static void trackPageStart(String str) {
        a();
        f304a.a(str);
    }

    public static void trackPlainTextEvent(String str, String str2) {
        a();
        f304a.e(str, str2);
    }
}
