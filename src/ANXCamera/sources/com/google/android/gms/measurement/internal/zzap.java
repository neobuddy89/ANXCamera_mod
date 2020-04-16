package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.provider.MiuiSettings;
import com.android.camera.module.loader.FunctionParseBeautyBodySlimCount;
import com.google.android.gms.internal.measurement.zzbx;
import com.google.android.gms.internal.measurement.zzcm;
import com.google.android.gms.internal.measurement.zzji;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
public final class zzap {
    public static zzfc<Long> zza;
    public static zzfc<Long> zzaa = zza("measurement.upload.retry_time", 1800000L, 1800000L, zzbw.zza);
    public static zzfc<Integer> zzab = zza("measurement.upload.retry_count", 6, 6, zzbv.zza);
    public static zzfc<Long> zzac = zza("measurement.upload.max_queue_time", 2419200000L, 2419200000L, zzby.zza);
    public static zzfc<Integer> zzad = zza("measurement.lifetimevalue.max_currency_tracked", 4, 4, zzbx.zza);
    public static zzfc<Integer> zzae = zza("measurement.audience.filter_result_max_count", 200, 200, zzbz.zza);
    public static zzfc<Integer> zzaf = zza("measurement.upload.max_public_user_properties", 25, 25, (zzfa) null);
    public static zzfc<Integer> zzag;
    public static zzfc<Integer> zzah = zza("measurement.upload.max_public_event_params", 25, 25, (zzfa) null);
    public static zzfc<Long> zzai = zza("measurement.service_client.idle_disconnect_millis", 5000L, 5000L, zzcc.zza);
    public static zzfc<Boolean> zzaj = zza("measurement.test.boolean_flag", false, false, zzcb.zza);
    public static zzfc<String> zzak = zza("measurement.test.string_flag", "---", "---", zzce.zza);
    public static zzfc<Long> zzal = zza("measurement.test.long_flag", -1L, -1L, zzcd.zza);
    public static zzfc<Integer> zzam = zza("measurement.test.int_flag", -2, -2, zzcg.zza);
    public static zzfc<Double> zzan;
    public static zzfc<Integer> zzao = zza("measurement.experiment.max_ids", 50, 50, zzci.zza);
    public static zzfc<Integer> zzap = zza("measurement.max_bundles_per_iteration", 1, 1, zzch.zza);
    public static zzfc<Boolean> zzaq = zza("measurement.validation.internal_limits_internal_event_params", false, false, zzck.zza);
    public static zzfc<Boolean> zzar = zza("measurement.referrer.enable_logging_install_referrer_cmp_from_apk", true, true, zzcm.zza);
    public static zzfc<Boolean> zzas = zza("measurement.client.sessions.session_id_enabled", true, true, zzcl.zza);
    public static zzfc<Boolean> zzat = zza("measurement.service.sessions.session_number_enabled", true, true, zzco.zza);
    public static zzfc<Boolean> zzau = zza("measurement.client.sessions.background_sessions_enabled", true, true, zzcn.zza);
    public static zzfc<Boolean> zzav = zza("measurement.client.sessions.remove_expired_session_properties_enabled", true, true, zzcq.zza);
    public static zzfc<Boolean> zzaw = zza("measurement.service.sessions.session_number_backfill_enabled", true, true, zzcp.zza);
    public static zzfc<Boolean> zzax = zza("measurement.service.sessions.remove_disabled_session_number", true, true, zzcs.zza);
    public static zzfc<Boolean> zzay = zza("measurement.client.sessions.start_session_before_view_screen", true, true, zzcr.zza);
    public static zzfc<Boolean> zzaz = zza("measurement.client.sessions.check_on_startup", true, true, zzcu.zza);
    public static zzfc<Long> zzb = zza("measurement.monitoring.sample_period_millis", 86400000L, 86400000L, zzar.zza);
    public static zzfc<Boolean> zzba = zza("measurement.collection.firebase_global_collection_flag_enabled", true, true, zzct.zza);
    public static zzfc<Boolean> zzbb = zza("measurement.collection.efficient_engagement_reporting_enabled_2", false, false, zzcv.zza);
    public static zzfc<Boolean> zzbc = zza("measurement.collection.redundant_engagement_removal_enabled", false, false, zzcy.zza);
    public static zzfc<Boolean> zzbd = zza("measurement.personalized_ads_signals_collection_enabled", true, true, zzcx.zza);
    public static zzfc<Boolean> zzbe = zza("measurement.personalized_ads_property_translation_enabled", true, true, zzda.zza);
    public static zzfc<Boolean> zzbf = zza("measurement.experiment.enable_experiment_reporting", true, true, zzcz.zza);
    public static zzfc<Boolean> zzbg = zza("measurement.collection.log_event_and_bundle_v2", true, true, zzdc.zza);
    public static zzfc<Boolean> zzbh = zza("measurement.quality.checksum", false, false, (zzfa) null);
    public static zzfc<Boolean> zzbi = zza("measurement.sdk.dynamite.use_dynamite3", false, false, zzde.zza);
    public static zzfc<Boolean> zzbj = zza("measurement.sdk.dynamite.allow_remote_dynamite", false, false, zzdd.zza);
    public static zzfc<Boolean> zzbk = zza("measurement.sdk.collection.validate_param_names_alphabetical", true, true, zzdg.zza);
    public static zzfc<Boolean> zzbl = zza("measurement.collection.event_safelist", true, true, zzdi.zza);
    public static zzfc<Boolean> zzbm = zza("measurement.service.audience.scoped_filters_v27", true, true, zzdh.zza);
    public static zzfc<Boolean> zzbn = zza("measurement.service.audience.session_scoped_event_aggregates", true, true, zzdk.zza);
    public static zzfc<Boolean> zzbo = zza("measurement.service.audience.session_scoped_user_engagement", true, true, zzdj.zza);
    public static zzfc<Boolean> zzbp = zza("measurement.service.audience.scoped_engagement_removal_when_session_expired", true, true, zzdm.zza);
    public static zzfc<Boolean> zzbq = zza("measurement.client.audience.scoped_engagement_removal_when_session_expired", true, true, zzdl.zza);
    public static zzfc<Boolean> zzbr = zza("measurement.service.audience.remove_disabled_session_scoped_user_engagement", false, false, zzdo.zza);
    public static zzfc<Boolean> zzbs = zza("measurement.service.audience.use_bundle_timestamp_for_property_filters", true, true, zzdn.zza);
    public static zzfc<Boolean> zzbt = zza("measurement.service.audience.fix_prepending_previous_sequence_timestamp", true, true, zzdq.zza);
    public static zzfc<Boolean> zzbu = zza("measurement.service.audience.fix_skip_audience_with_failed_filters", true, true, zzdr.zza);
    public static zzfc<Boolean> zzbv = zza("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false, false, zzdu.zza);
    public static zzfc<Boolean> zzbw = zza("measurement.audience.refresh_event_count_filters_timestamp", false, false, zzdt.zza);
    public static zzfc<Boolean> zzbx = zza("measurement.audience.use_bundle_timestamp_for_event_count_filters", false, false, zzdw.zza);
    public static zzfc<Boolean> zzby = zza("measurement.sdk.collection.retrieve_deeplink_from_bow_2", true, true, zzdv.zza);
    public static zzfc<Boolean> zzbz = zza("measurement.app_launch.event_ordering_fix", true, true, zzdy.zza);
    public static zzfc<Long> zzc = zza("measurement.config.cache_time", 86400000L, 3600000L, zzbn.zza);
    public static zzfc<Boolean> zzca = zza("measurement.sdk.collection.last_deep_link_referrer2", true, true, zzdx.zza);
    public static zzfc<Boolean> zzcb = zza("measurement.sdk.collection.last_deep_link_referrer_campaign2", false, false, zzea.zza);
    public static zzfc<Boolean> zzcc = zza("measurement.sdk.collection.last_gclid_from_referrer2", false, false, zzdz.zza);
    public static zzfc<Boolean> zzcd = zza("measurement.sdk.collection.worker_thread_referrer", true, true, zzec.zza);
    public static zzfc<Boolean> zzce = zza("measurement.sdk.collection.enable_extend_user_property_size", true, true, zzee.zza);
    public static zzfc<Boolean> zzcf = zza("measurement.upload.file_lock_state_check", false, false, zzed.zza);
    public static zzfc<Boolean> zzcg = zza("measurement.sampling.calculate_bundle_timestamp_before_sampling", true, true, zzeg.zza);
    public static zzfc<Boolean> zzch = zza("measurement.ga.ga_app_id", false, false, zzef.zza);
    public static zzfc<Boolean> zzci = zza("measurement.lifecycle.app_backgrounded_tracking", true, true, zzei.zza);
    public static zzfc<Boolean> zzcj = zza("measurement.lifecycle.app_in_background_parameter", false, false, zzeh.zza);
    public static zzfc<Boolean> zzck = zza("measurement.integration.disable_firebase_instance_id", false, false, zzek.zza);
    public static zzfc<Boolean> zzcl = zza("measurement.lifecycle.app_backgrounded_engagement", false, false, zzej.zza);
    public static zzfc<Boolean> zzcm = zza("measurement.service.fix_gmp_version", true, true, zzem.zza);
    public static zzfc<Boolean> zzcn = zza("measurement.collection.service.update_with_analytics_fix", false, false, zzel.zza);
    public static zzfc<Boolean> zzco = zza("measurement.service.disable_install_state_reporting", true, true, zzen.zza);
    public static zzfc<Boolean> zzcp = zza("measurement.service.use_appinfo_modified", false, false, zzeq.zza);
    public static zzfc<Boolean> zzcq = zza("measurement.client.firebase_feature_rollout.v1.enable", true, true, zzep.zza);
    public static zzfc<Boolean> zzcr = zza("measurement.client.sessions.check_on_reset_and_enable", false, false, zzes.zza);
    public static zzfc<Boolean> zzcs = zza("measurement.config.string.always_update_disk_on_set", true, true, zzer.zza);
    public static zzfc<Boolean> zzct = zza("measurement.scheduler.task_thread.cleanup_on_exit", false, false, zzeu.zza);
    public static zzfc<Boolean> zzcu = zza("measurement.upload.file_truncate_fix", false, false, zzet.zza);
    public static zzfc<Boolean> zzcv = zza("measurement.engagement_time_main_thread", true, true, zzew.zza);
    public static zzfc<Boolean> zzcw = zza("measurement.sdk.referrer.delayed_install_referrer_api", false, false, zzev.zza);
    public static zzfc<Boolean> zzcx = zza("measurement.logging.improved_messaging_q4_2019_client", true, true, zzey.zza);
    public static zzfc<Boolean> zzcy = zza("measurement.logging.improved_messaging_q4_2019_service", true, true, zzat.zza);
    public static zzfc<Boolean> zzcz = zza("measurement.gold.enhanced_ecommerce.format_logs", false, false, zzaw.zza);
    public static zzfc<String> zzd = zza("measurement.config.url_scheme", "https", "https", zzca.zza);
    public static zzfc<Boolean> zzda = zza("measurement.gold.enhanced_ecommerce.nested_param_daily_event_count", false, false, zzav.zza);
    public static zzfc<Boolean> zzdb = zza("measurement.gold.enhanced_ecommerce.upload_nested_complex_events", false, false, zzay.zza);
    public static zzfc<Boolean> zzdc = zza("measurement.gold.enhanced_ecommerce.log_nested_complex_events", false, false, zzax.zza);
    public static zzfc<Boolean> zzdd = zza("measurement.gold.enhanced_ecommerce.updated_schema.client", false, false, zzba.zza);
    public static zzfc<Boolean> zzde = zza("measurement.gold.enhanced_ecommerce.updated_schema.service", false, false, zzaz.zza);
    public static zzfc<Boolean> zzdf = zza("measurement.service.configurable_service_limits", false, false, zzbb.zza);
    public static zzfc<Boolean> zzdg = zza("measurement.client.configurable_service_limits", false, false, zzbe.zza);
    public static zzfc<Boolean> zzdh = zza("measurement.androidId.delete_feature", true, true, zzbg.zza);
    /* access modifiers changed from: private */
    public static List<zzfc<?>> zzdi = Collections.synchronizedList(new ArrayList());
    private static Set<zzfc<?>> zzdj = Collections.synchronizedSet(new HashSet());
    private static zzfc<Boolean> zzdk = zza("measurement.module.collection.conditionally_omit_admob_app_id", true, true, zzdb.zza);
    private static zzfc<Boolean> zzdl = zza("measurement.service.audience.invalidate_config_cache_after_app_unisntall", true, true, zzdp.zza);
    private static zzfc<Boolean> zzdm = zza("measurement.collection.synthetic_data_mitigation", false, false, zzbc.zza);
    public static zzfc<String> zze = zza("measurement.config.url_authority", "app-measurement.com", "app-measurement.com", zzcj.zza);
    public static zzfc<Integer> zzf = zza("measurement.upload.max_bundles", 100, 100, zzcw.zza);
    public static zzfc<Integer> zzg = zza("measurement.upload.max_batch_size", 65536, 65536, zzdf.zza);
    public static zzfc<Integer> zzh = zza("measurement.upload.max_bundle_size", 65536, 65536, zzds.zza);
    public static zzfc<Integer> zzi = zza("measurement.upload.max_events_per_bundle", 1000, 1000, zzeb.zza);
    public static zzfc<Integer> zzj = zza("measurement.upload.max_events_per_day", 100000, 100000, zzeo.zza);
    public static zzfc<Integer> zzk = zza("measurement.upload.max_error_events_per_day", 1000, 1000, zzau.zza);
    public static zzfc<Integer> zzl = zza("measurement.upload.max_public_events_per_day", 50000, 50000, zzbd.zza);
    public static zzfc<Integer> zzm = zza("measurement.upload.max_conversions_per_day", 10000, 10000, zzbf.zza);
    public static zzfc<Integer> zzn = zza("measurement.upload.max_realtime_events_per_day", 10, 10, zzbi.zza);
    public static zzfc<Integer> zzo = zza("measurement.store.max_stored_events_per_app", 100000, 100000, zzbh.zza);
    public static zzfc<String> zzp = zza("measurement.upload.url", "https://app-measurement.com/a", "https://app-measurement.com/a", zzbk.zza);
    public static zzfc<Long> zzq = zza("measurement.upload.backoff_period", 43200000L, 43200000L, zzbj.zza);
    public static zzfc<Long> zzr = zza("measurement.upload.window_interval", 3600000L, 3600000L, zzbm.zza);
    public static zzfc<Long> zzs = zza("measurement.upload.interval", 3600000L, 3600000L, zzbl.zza);
    public static zzfc<Long> zzt;
    public static zzfc<Long> zzu = zza("measurement.upload.debug_upload_interval", 1000L, 1000L, zzbq.zza);
    public static zzfc<Long> zzv = zza("measurement.upload.minimum_delay", 500L, 500L, zzbp.zza);
    public static zzfc<Long> zzw = zza("measurement.alarm_manager.minimum_interval", 60000L, 60000L, zzbs.zza);
    public static zzfc<Long> zzx = zza("measurement.upload.stale_data_deletion_interval", 86400000L, 86400000L, zzbr.zza);
    public static zzfc<Long> zzy = zza("measurement.upload.refresh_blacklisted_config_interval", 604800000L, 604800000L, zzbu.zza);
    public static zzfc<Long> zzz = zza("measurement.upload.initial_upload_delay_time", 15000L, 15000L, zzbt.zza);

    static {
        Long valueOf = Long.valueOf(FunctionParseBeautyBodySlimCount.TIP_INTERVAL_TIME);
        zza = zza("measurement.ad_id_cache_time", valueOf, valueOf, zzas.zza);
        zzt = zza("measurement.upload.realtime_upload_interval", valueOf, valueOf, zzbo.zza);
        Integer valueOf2 = Integer.valueOf(MiuiSettings.System.SCREEN_KEY_LONG_PRESS_TIMEOUT_DEFAULT);
        zzag = zza("measurement.upload.max_event_name_cardinality", valueOf2, valueOf2, (zzfa) null);
        Double valueOf3 = Double.valueOf(-3.0d);
        zzan = zza("measurement.test.double_flag", valueOf3, valueOf3, zzcf.zza);
    }

    private static <V> zzfc<V> zza(String str, V v, V v2, zzfa<V> zzfa) {
        zzfc zzfc = new zzfc(str, v, v2, zzfa);
        zzdi.add(zzfc);
        return zzfc;
    }

    public static Map<String, String> zza(Context context) {
        zzbx zza2 = zzbx.zza(context.getContentResolver(), zzcm.zza("com.google.android.gms.measurement"));
        return zza2 == null ? Collections.emptyMap() : zza2.zza();
    }

    static final /* synthetic */ Long zzde() {
        if (zzez.zza != null) {
            zzw zzw2 = zzez.zza;
        }
        return Long.valueOf(zzji.zzc());
    }
}
