package com.google.android.gms.measurement.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzx;
import com.google.android.gms.measurement.internal.zzhp;
import com.google.android.gms.measurement.internal.zzhq;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.3.0 */
public class AppMeasurementSdk {
    private final zzx zza;

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.3.0 */
    public static final class ConditionalUserProperty {
        public static final String ACTIVE = "active";
        public static final String CREATION_TIMESTAMP = "creation_timestamp";
        public static final String EXPIRED_EVENT_NAME = "expired_event_name";
        public static final String EXPIRED_EVENT_PARAMS = "expired_event_params";
        public static final String NAME = "name";
        public static final String ORIGIN = "origin";
        public static final String TIMED_OUT_EVENT_NAME = "timed_out_event_name";
        public static final String TIMED_OUT_EVENT_PARAMS = "timed_out_event_params";
        public static final String TIME_TO_LIVE = "time_to_live";
        public static final String TRIGGERED_EVENT_NAME = "triggered_event_name";
        public static final String TRIGGERED_EVENT_PARAMS = "triggered_event_params";
        public static final String TRIGGERED_TIMESTAMP = "triggered_timestamp";
        public static final String TRIGGER_EVENT_NAME = "trigger_event_name";
        public static final String TRIGGER_TIMEOUT = "trigger_timeout";
        public static final String VALUE = "value";

        private ConditionalUserProperty() {
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.3.0 */
    public interface EventInterceptor extends zzhq {
        void interceptEvent(String str, String str2, Bundle bundle, long j);
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.3.0 */
    public interface OnEventListener extends zzhp {
        void onEvent(String str, String str2, Bundle bundle, long j);
    }

    public AppMeasurementSdk(zzx zzx) {
        this.zza = zzx;
    }

    public static AppMeasurementSdk getInstance(Context context) {
        return zzx.zza(context).zza();
    }

    public static AppMeasurementSdk getInstance(Context context, String str, String str2, String str3, Bundle bundle) {
        return zzx.zza(context, str, str2, str3, bundle).zza();
    }

    public void beginAdUnitExposure(String str) {
        this.zza.zzb(str);
    }

    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        this.zza.zzb(str, str2, bundle);
    }

    public void endAdUnitExposure(String str) {
        this.zza.zzc(str);
    }

    public long generateEventId() {
        return this.zza.zze();
    }

    public String getAppIdOrigin() {
        return this.zza.zzi();
    }

    public String getAppInstanceId() {
        return this.zza.zzd();
    }

    public List<Bundle> getConditionalUserProperties(String str, String str2) {
        return this.zza.zzb(str, str2);
    }

    public String getCurrentScreenClass() {
        return this.zza.zzg();
    }

    public String getCurrentScreenName() {
        return this.zza.zzf();
    }

    public String getGmpAppId() {
        return this.zza.zzc();
    }

    public int getMaxUserProperties(String str) {
        return this.zza.zzd(str);
    }

    public Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        return this.zza.zza(str, str2, z);
    }

    public void logEvent(String str, String str2, Bundle bundle) {
        this.zza.zza(str, str2, bundle);
    }

    public void logEventNoInterceptor(String str, String str2, Bundle bundle, long j) {
        this.zza.zza(str, str2, bundle, j);
    }

    public void performAction(Bundle bundle) {
        this.zza.zza(bundle, false);
    }

    public Bundle performActionWithResponse(Bundle bundle) {
        return this.zza.zza(bundle, true);
    }

    public void registerOnMeasurementEventListener(OnEventListener onEventListener) {
        this.zza.zza((zzhp) onEventListener);
    }

    public void setConditionalUserProperty(Bundle bundle) {
        this.zza.zza(bundle);
    }

    public void setCurrentScreen(Activity activity, String str, String str2) {
        this.zza.zza(activity, str, str2);
    }

    public void setEventInterceptor(EventInterceptor eventInterceptor) {
        this.zza.zza((zzhq) eventInterceptor);
    }

    public void setMeasurementEnabled(boolean z) {
        this.zza.zza(z);
    }

    public void setUserProperty(String str, String str2, Object obj) {
        this.zza.zza(str, str2, obj);
    }

    public void unregisterOnMeasurementEventListener(OnEventListener onEventListener) {
        this.zza.zzb((zzhp) onEventListener);
    }
}
