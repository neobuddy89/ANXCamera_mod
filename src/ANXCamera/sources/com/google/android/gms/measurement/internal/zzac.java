package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import androidx.collection.ArrayMap;
import com.google.android.apps.photos.api.PhotosOemApi;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzbj;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzfd;
import com.google.android.gms.internal.measurement.zzkz;
import com.google.android.gms.internal.measurement.zzll;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.xiaomi.stat.a.j;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
final class zzac extends zzkp {
    /* access modifiers changed from: private */
    public static final String[] zzb = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzc = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    /* access modifiers changed from: private */
    public static final String[] zzd = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;"};
    /* access modifiers changed from: private */
    public static final String[] zze = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzf = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzg = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    /* access modifiers changed from: private */
    public static final String[] zzh = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    /* access modifiers changed from: private */
    public static final String[] zzi = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private final zzad zzj = new zzad(this, zzn(), "google_app_measurement.db");
    /* access modifiers changed from: private */
    public final zzkl zzk = new zzkl(zzm());

    zzac(zzks zzks) {
        super(zzks);
    }

    private final long zza(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = c_().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                long j2 = rawQuery.getLong(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return j2;
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            return j;
        } catch (SQLiteException e2) {
            zzr().zzf().zza("Database error", str, e2);
            throw e2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private final Object zza(Cursor cursor, int i) {
        int type = cursor.getType(i);
        if (type == 0) {
            zzr().zzf().zza("Loaded invalid null value from database");
            return null;
        } else if (type == 1) {
            return Long.valueOf(cursor.getLong(i));
        } else {
            if (type == 2) {
                return Double.valueOf(cursor.getDouble(i));
            }
            if (type == 3) {
                return cursor.getString(i);
            }
            if (type != 4) {
                zzr().zzf().zza("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                return null;
            }
            zzr().zzf().zza("Loaded invalid blob type value, ignoring it");
            return null;
        }
    }

    private static void zza(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    private final boolean zza(String str, int i, zzbj.zzb zzb2) {
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzb2);
        Integer num = null;
        if (TextUtils.isEmpty(zzb2.zzc())) {
            zzfl zzi2 = zzr().zzi();
            Object zza = zzfj.zza(str);
            Integer valueOf = Integer.valueOf(i);
            if (zzb2.zza()) {
                num = Integer.valueOf(zzb2.zzb());
            }
            zzi2.zza("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zza, valueOf, String.valueOf(num));
            return false;
        }
        byte[] zzbi = zzb2.zzbi();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zzb2.zza() ? Integer.valueOf(zzb2.zzb()) : null);
        contentValues.put("event_name", zzb2.zzc());
        if (zzt().zze(str, zzap.zzbm)) {
            contentValues.put("session_scoped", zzb2.zzj() ? Boolean.valueOf(zzb2.zzk()) : null);
        }
        contentValues.put(PhotosOemApi.PATH_SPECIAL_TYPE_DATA, zzbi);
        try {
            if (c_().insertWithOnConflict("event_filters", (String) null, contentValues, 5) != -1) {
                return true;
            }
            zzr().zzf().zza("Failed to insert event filter (got -1). appId", zzfj.zza(str));
            return true;
        } catch (SQLiteException e2) {
            zzr().zzf().zza("Error storing event filter. appId", zzfj.zza(str), e2);
            return false;
        }
    }

    private final boolean zza(String str, int i, zzbj.zze zze2) {
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zze2);
        Integer num = null;
        if (TextUtils.isEmpty(zze2.zzc())) {
            zzfl zzi2 = zzr().zzi();
            Object zza = zzfj.zza(str);
            Integer valueOf = Integer.valueOf(i);
            if (zze2.zza()) {
                num = Integer.valueOf(zze2.zzb());
            }
            zzi2.zza("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zza, valueOf, String.valueOf(num));
            return false;
        }
        byte[] zzbi = zze2.zzbi();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zze2.zza() ? Integer.valueOf(zze2.zzb()) : null);
        contentValues.put("property_name", zze2.zzc());
        if (zzt().zze(str, zzap.zzbm)) {
            contentValues.put("session_scoped", zze2.zzg() ? Boolean.valueOf(zze2.zzh()) : null);
        }
        contentValues.put(PhotosOemApi.PATH_SPECIAL_TYPE_DATA, zzbi);
        try {
            if (c_().insertWithOnConflict("property_filters", (String) null, contentValues, 5) != -1) {
                return true;
            }
            zzr().zzf().zza("Failed to insert property filter (got -1). appId", zzfj.zza(str));
            return false;
        } catch (SQLiteException e2) {
            zzr().zzf().zza("Error storing property filter. appId", zzfj.zza(str), e2);
            return false;
        }
    }

    private final boolean zzam() {
        return zzn().getDatabasePath("google_app_measurement.db").exists();
    }

    private final long zzb(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = c_().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                long j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e2) {
            zzr().zzf().zza("Database error", str, e2);
            throw e2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private final boolean zzc(String str, List<Integer> list) {
        Preconditions.checkNotEmpty(str);
        zzak();
        zzd();
        SQLiteDatabase c_ = c_();
        try {
            long zzb2 = zzb("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int max = Math.max(0, Math.min(2000, zzt().zzb(str, zzap.zzae)));
            if (zzb2 <= ((long) max)) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                Integer num = list.get(i);
                if (num == null || !(num instanceof Integer)) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String join = TextUtils.join(",", arrayList);
            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
            sb.append("(");
            sb.append(join);
            sb.append(")");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 140);
            sb3.append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ");
            sb3.append(sb2);
            sb3.append(" order by rowid desc limit -1 offset ?)");
            return c_.delete("audience_filter_values", sb3.toString(), new String[]{str, Integer.toString(max)}) > 0;
        } catch (SQLiteException e2) {
            zzr().zzf().zza("Database error querying filters. appId", zzfj.zza(str), e2);
            return false;
        }
    }

    public final void b_() {
        zzak();
        c_().setTransactionSuccessful();
    }

    /* access modifiers changed from: package-private */
    public final SQLiteDatabase c_() {
        zzd();
        try {
            return this.zzj.getWritableDatabase();
        } catch (SQLiteException e2) {
            zzr().zzi().zza("Error opening database", e2);
            throw e2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0043  */
    public final String d_() {
        Cursor cursor;
        try {
            cursor = c_().rawQuery("select app_id from queue order by has_realtime desc, rowid asc limit 1;", (String[]) null);
            try {
                if (cursor.moveToFirst()) {
                    String string = cursor.getString(0);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return string;
                }
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzr().zzf().zza("Database error getting next bundle app id", e);
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            zzr().zzf().zza("Database error getting next bundle app id", e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            if (cursor != null) {
            }
            throw th;
        }
    }

    public final long zza(zzbr.zzg zzg2) throws IOException {
        zzd();
        zzak();
        Preconditions.checkNotNull(zzg2);
        Preconditions.checkNotEmpty(zzg2.zzx());
        byte[] zzbi = zzg2.zzbi();
        long zza = zzg().zza(zzbi);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzg2.zzx());
        contentValues.put("metadata_fingerprint", Long.valueOf(zza));
        contentValues.put("metadata", zzbi);
        try {
            c_().insertWithOnConflict("raw_events_metadata", (String) null, contentValues, 4);
            return zza;
        } catch (SQLiteException e2) {
            zzr().zzf().zza("Error storing raw event metadata. appId", zzfj.zza(zzg2.zzx()), e2);
            throw e2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0096  */
    public final Pair<zzbr.zzc, Long> zza(String str, Long l) {
        Cursor cursor;
        zzd();
        zzak();
        Cursor cursor2 = null;
        try {
            cursor = c_().rawQuery("select main_event, children_to_process from main_event_params where app_id=? and event_id=?", new String[]{str, String.valueOf(l)});
            try {
                if (!cursor.moveToFirst()) {
                    zzr().zzx().zza("Main event not found");
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                try {
                    Pair<zzbr.zzc, Long> create = Pair.create((zzbr.zzc) ((zzfd) ((zzbr.zzc.zza) zzkw.zza(zzbr.zzc.zzj(), cursor.getBlob(0))).zzu()), Long.valueOf(cursor.getLong(1)));
                    if (cursor != null) {
                        cursor.close();
                    }
                    return create;
                } catch (IOException e2) {
                    zzr().zzf().zza("Failed to merge main event. appId, eventId", zzfj.zza(str), l, e2);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
            } catch (SQLiteException e3) {
                e = e3;
                try {
                    zzr().zzf().zza("Error selecting main event", e);
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            zzr().zzf().zza("Error selecting main event", e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public final zzab zza(long j, String str, long j2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        Preconditions.checkNotEmpty(str);
        zzd();
        zzak();
        String[] strArr = {str};
        zzab zzab = new zzab();
        Cursor cursor = null;
        try {
            SQLiteDatabase c_ = c_();
            cursor = c_.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, (String) null, (String) null, (String) null);
            if (!cursor.moveToFirst()) {
                zzr().zzi().zza("Not updating daily counts, app is not known. appId", zzfj.zza(str));
                if (cursor != null) {
                    cursor.close();
                }
                return zzab;
            }
            if (cursor.getLong(0) == j) {
                zzab.zzb = cursor.getLong(1);
                zzab.zza = cursor.getLong(2);
                zzab.zzc = cursor.getLong(3);
                zzab.zzd = cursor.getLong(4);
                zzab.zze = cursor.getLong(5);
            }
            if (z) {
                zzab.zzb += j2;
            }
            if (z2) {
                zzab.zza += j2;
            }
            if (z3) {
                zzab.zzc += j2;
            }
            if (z4) {
                zzab.zzd += j2;
            }
            if (z5) {
                zzab.zze += j2;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("day", Long.valueOf(j));
            contentValues.put("daily_public_events_count", Long.valueOf(zzab.zza));
            contentValues.put("daily_events_count", Long.valueOf(zzab.zzb));
            contentValues.put("daily_conversions_count", Long.valueOf(zzab.zzc));
            contentValues.put("daily_error_events_count", Long.valueOf(zzab.zzd));
            contentValues.put("daily_realtime_events_count", Long.valueOf(zzab.zze));
            c_.update("apps", contentValues, "app_id=?", strArr);
            if (cursor != null) {
                cursor.close();
            }
            return zzab;
        } catch (SQLiteException e2) {
            zzr().zzf().zza("Error updating daily counts. appId", zzfj.zza(str), e2);
            if (cursor != null) {
                cursor.close();
            }
            return zzab;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final zzab zza(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        return zza(j, str, 1, false, false, z3, false, z5);
    }

    /* JADX WARNING: Removed duplicated region for block: B:68:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x016a  */
    public final zzaj zza(String str, String str2) {
        Cursor cursor;
        Cursor cursor2;
        Boolean bool;
        String str3 = str;
        String str4 = str2;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzd();
        zzak();
        boolean zze2 = zzt().zze(str3, zzap.zzbn);
        ArrayList arrayList = new ArrayList(Arrays.asList(new String[]{"lifetime_count", "current_bundle_count", "last_fire_timestamp", "last_bundled_timestamp", "last_bundled_day", "last_sampled_complex_event_id", "last_sampling_rate", "last_exempt_from_sampling"}));
        if (zze2) {
            arrayList.add("current_session_count");
        }
        Cursor cursor3 = null;
        try {
            boolean z = false;
            cursor = c_().query(j.f343b, (String[]) arrayList.toArray(new String[0]), "app_id=? and name=?", new String[]{str3, str4}, (String) null, (String) null, (String) null);
            try {
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                long j = cursor.getLong(0);
                long j2 = cursor.getLong(1);
                long j3 = cursor.getLong(2);
                long j4 = 0;
                long j5 = cursor.isNull(3) ? 0 : cursor.getLong(3);
                Long valueOf = cursor.isNull(4) ? null : Long.valueOf(cursor.getLong(4));
                Long valueOf2 = cursor.isNull(5) ? null : Long.valueOf(cursor.getLong(5));
                Long valueOf3 = cursor.isNull(6) ? null : Long.valueOf(cursor.getLong(6));
                if (!cursor.isNull(7)) {
                    try {
                        if (cursor.getLong(7) == 1) {
                            z = true;
                        }
                        bool = Boolean.valueOf(z);
                    } catch (SQLiteException e2) {
                        e = e2;
                        try {
                            zzr().zzf().zza("Error querying events. appId", zzfj.zza(str), zzo().zza(str2), e);
                            if (cursor != null) {
                            }
                            return null;
                        } catch (Throwable th) {
                            th = th;
                            cursor3 = cursor;
                            if (cursor3 != null) {
                            }
                            throw th;
                        }
                    }
                } else {
                    bool = null;
                }
                if (zze2 && !cursor.isNull(8)) {
                    j4 = cursor.getLong(8);
                }
                r1 = r1;
                cursor2 = cursor;
                try {
                    zzaj zzaj = new zzaj(str, str2, j, j2, j4, j3, j5, valueOf, valueOf2, valueOf3, bool);
                    if (cursor2.moveToNext()) {
                        zzr().zzf().zza("Got multiple records for event aggregates, expected one. appId", zzfj.zza(str));
                    }
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    return zzaj;
                } catch (SQLiteException e3) {
                    e = e3;
                    cursor = cursor2;
                    zzr().zzf().zza("Error querying events. appId", zzfj.zza(str), zzo().zza(str2), e);
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor3 = cursor2;
                    if (cursor3 != null) {
                    }
                    throw th;
                }
            } catch (SQLiteException e4) {
                e = e4;
                Cursor cursor4 = cursor;
                zzr().zzf().zza("Error querying events. appId", zzfj.zza(str), zzo().zza(str2), e);
                if (cursor != null) {
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                cursor2 = cursor;
                cursor3 = cursor2;
                if (cursor3 != null) {
                }
                throw th;
            }
        } catch (SQLiteException e5) {
            e = e5;
            cursor = null;
            zzr().zzf().zza("Error querying events. appId", zzfj.zza(str), zzo().zza(str2), e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            if (cursor3 != null) {
                cursor3.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005c  */
    public final String zza(long j) {
        Cursor cursor;
        zzd();
        zzak();
        Cursor cursor2 = null;
        try {
            cursor = c_().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf(j)});
            try {
                if (!cursor.moveToFirst()) {
                    zzr().zzx().zza("No expired configs for apps with pending events");
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                String string = cursor.getString(0);
                if (cursor != null) {
                    cursor.close();
                }
                return string;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzr().zzf().zza("Error selecting expired configs", e);
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            zzr().zzf().zza("Error selecting expired configs", e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a6  */
    public final List<zzlb> zza(String str) {
        Cursor cursor;
        Preconditions.checkNotEmpty(str);
        zzd();
        zzak();
        ArrayList arrayList = new ArrayList();
        Cursor cursor2 = null;
        try {
            cursor = c_().query("user_attributes", new String[]{AppMeasurementSdk.ConditionalUserProperty.NAME, "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, (String) null, (String) null, "rowid", "1000");
            try {
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return arrayList;
                }
                do {
                    String string = cursor.getString(0);
                    String string2 = cursor.getString(1);
                    String str2 = string2 == null ? "" : string2;
                    long j = cursor.getLong(2);
                    Object zza = zza(cursor, 3);
                    if (zza == null) {
                        zzr().zzf().zza("Read invalid user property value, ignoring it. appId", zzfj.zza(str));
                    } else {
                        zzlb zzlb = new zzlb(str, str2, string, j, zza);
                        arrayList.add(zzlb);
                    }
                } while (cursor.moveToNext());
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzr().zzf().zza("Error querying user properties. appId", zzfj.zza(str), e);
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            zzr().zzf().zza("Error querying user properties. appId", zzfj.zza(str), e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public final List<Pair<zzbr.zzg, Long>> zza(String str, int i, int i2) {
        zzd();
        zzak();
        Preconditions.checkArgument(i > 0);
        Preconditions.checkArgument(i2 > 0);
        Preconditions.checkNotEmpty(str);
        Cursor cursor = null;
        try {
            cursor = c_().query("queue", new String[]{"rowid", PhotosOemApi.PATH_SPECIAL_TYPE_DATA, "retry_count"}, "app_id=?", new String[]{str}, (String) null, (String) null, "rowid", String.valueOf(i));
            if (!cursor.moveToFirst()) {
                List<Pair<zzbr.zzg, Long>> emptyList = Collections.emptyList();
                if (cursor != null) {
                    cursor.close();
                }
                return emptyList;
            }
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            do {
                long j = cursor.getLong(0);
                try {
                    byte[] zzb2 = zzg().zzb(cursor.getBlob(1));
                    if (!arrayList.isEmpty() && zzb2.length + i3 > i2) {
                        break;
                    }
                    try {
                        zzbr.zzg.zza zza = (zzbr.zzg.zza) zzkw.zza(zzbr.zzg.zzbf(), zzb2);
                        if (!cursor.isNull(2)) {
                            zza.zzi(cursor.getInt(2));
                        }
                        i3 += zzb2.length;
                        arrayList.add(Pair.create((zzbr.zzg) ((zzfd) zza.zzu()), Long.valueOf(j)));
                    } catch (IOException e2) {
                        zzr().zzf().zza("Failed to merge queued bundle. appId", zzfj.zza(str), e2);
                    }
                    if (!cursor.moveToNext()) {
                        break;
                    }
                } catch (IOException e3) {
                    zzr().zzf().zza("Failed to unzip queued bundle. appId", zzfj.zza(str), e3);
                }
            } while (i3 <= i2);
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (SQLiteException e4) {
            zzr().zzf().zza("Error querying bundles. appId", zzfj.zza(str), e4);
            List<Pair<zzbr.zzg, Long>> emptyList2 = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return emptyList2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00fb, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00fc, code lost:
        r12 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0103, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0104, code lost:
        r12 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0107, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0108, code lost:
        r12 = r21;
        r11 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0122, code lost:
        r2.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0103 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x0010] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x012a  */
    public final List<zzlb> zza(String str, String str2, String str3) {
        Cursor cursor;
        String str4;
        Preconditions.checkNotEmpty(str);
        zzd();
        zzak();
        ArrayList arrayList = new ArrayList();
        Cursor cursor2 = null;
        try {
            ArrayList arrayList2 = new ArrayList(3);
            arrayList2.add(str);
            StringBuilder sb = new StringBuilder("app_id=?");
            if (!TextUtils.isEmpty(str2)) {
                str4 = str2;
                arrayList2.add(str4);
                sb.append(" and origin=?");
            } else {
                str4 = str2;
            }
            if (!TextUtils.isEmpty(str3)) {
                arrayList2.add(String.valueOf(str3).concat("*"));
                sb.append(" and name glob ?");
            }
            cursor = c_().query("user_attributes", new String[]{AppMeasurementSdk.ConditionalUserProperty.NAME, "set_timestamp", "value", "origin"}, sb.toString(), (String[]) arrayList2.toArray(new String[arrayList2.size()]), (String) null, (String) null, "rowid", "1001");
            try {
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return arrayList;
                }
                while (true) {
                    if (arrayList.size() >= 1000) {
                        zzr().zzf().zza("Read more than the max allowed user properties, ignoring excess", 1000);
                        break;
                    }
                    String string = cursor.getString(0);
                    long j = cursor.getLong(1);
                    try {
                        Object zza = zza(cursor, 2);
                        String string2 = cursor.getString(3);
                        if (zza == null) {
                            try {
                                zzr().zzf().zza("(2)Read invalid user property value, ignoring it", zzfj.zza(str), string2, str3);
                            } catch (SQLiteException e2) {
                                e = e2;
                                str4 = string2;
                                try {
                                    zzr().zzf().zza("(2)Error querying user properties", zzfj.zza(str), str4, e);
                                    if (cursor != null) {
                                    }
                                    return null;
                                } catch (Throwable th) {
                                    th = th;
                                    cursor2 = cursor;
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    throw th;
                                }
                            }
                        } else {
                            String str5 = str3;
                            zzlb zzlb = new zzlb(str, string2, string, j, zza);
                            arrayList.add(zzlb);
                        }
                        if (!cursor.moveToNext()) {
                            break;
                        }
                        str4 = string2;
                    } catch (SQLiteException e3) {
                        e = e3;
                        zzr().zzf().zza("(2)Error querying user properties", zzfj.zza(str), str4, e);
                        if (cursor != null) {
                        }
                        return null;
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (SQLiteException e4) {
                e = e4;
                zzr().zzf().zza("(2)Error querying user properties", zzfj.zza(str), str4, e);
                if (cursor != null) {
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                cursor2 = cursor;
                if (cursor2 != null) {
                }
                throw th;
            }
        } catch (SQLiteException e5) {
            e = e5;
            str4 = str2;
            cursor = null;
            zzr().zzf().zza("(2)Error querying user properties", zzfj.zza(str), str4, e);
            if (cursor != null) {
            }
            return null;
        } catch (Throwable th3) {
        }
    }

    public final List<zzv> zza(String str, String[] strArr) {
        zzd();
        zzak();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = c_().query("conditional_properties", new String[]{"app_id", "origin", AppMeasurementSdk.ConditionalUserProperty.NAME, "value", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, "timed_out_event", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "triggered_event", AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, "expired_event"}, str, strArr, (String) null, (String) null, "rowid", "1001");
            if (!cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            while (true) {
                if (arrayList.size() < 1000) {
                    boolean z = false;
                    String string = cursor.getString(0);
                    String string2 = cursor.getString(1);
                    String string3 = cursor.getString(2);
                    Object zza = zza(cursor, 3);
                    if (cursor.getInt(4) != 0) {
                        z = true;
                    }
                    String string4 = cursor.getString(5);
                    long j = cursor.getLong(6);
                    long j2 = cursor.getLong(8);
                    long j3 = cursor.getLong(10);
                    long j4 = cursor.getLong(11);
                    zzkz zzkz = new zzkz(string3, j3, zza, string2);
                    boolean z2 = z;
                    zzv zzv = r3;
                    zzv zzv2 = new zzv(string, string2, zzkz, j2, z2, string4, (zzan) zzg().zza(cursor.getBlob(7), zzan.CREATOR), j, (zzan) zzg().zza(cursor.getBlob(9), zzan.CREATOR), j4, (zzan) zzg().zza(cursor.getBlob(12), zzan.CREATOR));
                    arrayList.add(zzv);
                    if (!cursor.moveToNext()) {
                        break;
                    }
                } else {
                    zzr().zzf().zza("Read more than the max allowed conditional properties, ignoring extra", 1000);
                    break;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (SQLiteException e2) {
            zzr().zzf().zza("Error querying conditional user property value", e2);
            List<zzv> emptyList = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return emptyList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00cc  */
    public final Map<Integer, List<Integer>> zza(String str, List<String> list) {
        Cursor cursor;
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        ArrayMap arrayMap = new ArrayMap();
        if (list.isEmpty()) {
            return arrayMap;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("app_id=? AND property_name in (");
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                sb.append(",");
            }
            sb.append("?");
        }
        sb.append(")");
        ArrayList arrayList = new ArrayList(list);
        arrayList.add(0, str);
        Cursor cursor2 = null;
        try {
            cursor = c_().query("property_filters", new String[]{"audience_id", "filter_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), (String) null, (String) null, (String) null);
            try {
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return arrayMap;
                }
                do {
                    int i2 = cursor.getInt(0);
                    List list2 = (List) arrayMap.get(Integer.valueOf(i2));
                    if (list2 == null) {
                        list2 = new ArrayList();
                        arrayMap.put(Integer.valueOf(i2), list2);
                    }
                    list2.add(Integer.valueOf(cursor.getInt(1)));
                } while (cursor.moveToNext());
                if (cursor != null) {
                    cursor.close();
                }
                return arrayMap;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzr().zzf().zza("Database error querying filters. appId", zzfj.zza(str), e);
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            zzr().zzf().zza("Database error querying filters. appId", zzfj.zza(str), e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public final void zza(zzaj zzaj) {
        Preconditions.checkNotNull(zzaj);
        zzd();
        zzak();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzaj.zza);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzaj.zzb);
        contentValues.put("lifetime_count", Long.valueOf(zzaj.zzc));
        contentValues.put("current_bundle_count", Long.valueOf(zzaj.zzd));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzaj.zzf));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzaj.zzg));
        contentValues.put("last_bundled_day", zzaj.zzh);
        contentValues.put("last_sampled_complex_event_id", zzaj.zzi);
        contentValues.put("last_sampling_rate", zzaj.zzj);
        if (zzt().zze(zzaj.zza, zzap.zzbn)) {
            contentValues.put("current_session_count", Long.valueOf(zzaj.zze));
        }
        contentValues.put("last_exempt_from_sampling", (zzaj.zzk == null || !zzaj.zzk.booleanValue()) ? null : 1L);
        try {
            if (c_().insertWithOnConflict(j.f343b, (String) null, contentValues, 5) == -1) {
                zzr().zzf().zza("Failed to insert/update event aggregates (got -1). appId", zzfj.zza(zzaj.zza));
            }
        } catch (SQLiteException e2) {
            zzr().zzf().zza("Error storing event aggregates. appId", zzfj.zza(zzaj.zza), e2);
        }
    }

    public final void zza(zzg zzg2) {
        Preconditions.checkNotNull(zzg2);
        zzd();
        zzak();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzg2.zzc());
        contentValues.put("app_instance_id", zzg2.zzd());
        contentValues.put("gmp_app_id", zzg2.zze());
        contentValues.put("resettable_device_id_hash", zzg2.zzh());
        contentValues.put("last_bundle_index", Long.valueOf(zzg2.zzs()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzg2.zzj()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzg2.zzk()));
        contentValues.put("app_version", zzg2.zzl());
        contentValues.put("app_store", zzg2.zzn());
        contentValues.put("gmp_version", Long.valueOf(zzg2.zzo()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzg2.zzp()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzg2.zzr()));
        contentValues.put("day", Long.valueOf(zzg2.zzw()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzg2.zzx()));
        contentValues.put("daily_events_count", Long.valueOf(zzg2.zzy()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzg2.zzz()));
        contentValues.put("config_fetched_time", Long.valueOf(zzg2.zzt()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzg2.zzu()));
        contentValues.put("app_version_int", Long.valueOf(zzg2.zzm()));
        contentValues.put("firebase_instance_id", zzg2.zzi());
        contentValues.put("daily_error_events_count", Long.valueOf(zzg2.zzab()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzg2.zzaa()));
        contentValues.put("health_monitor_sample", zzg2.zzac());
        contentValues.put("android_id", Long.valueOf(zzg2.zzae()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzg2.zzaf()));
        contentValues.put("ssaid_reporting_enabled", Boolean.valueOf(zzg2.zzag()));
        contentValues.put("admob_app_id", zzg2.zzf());
        contentValues.put("dynamite_version", Long.valueOf(zzg2.zzq()));
        if (zzg2.zzai() != null) {
            if (zzg2.zzai().size() == 0) {
                zzr().zzi().zza("Safelisted events should not be an empty list. appId", zzg2.zzc());
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", zzg2.zzai()));
            }
        }
        if (zzll.zzb() && zzt().zze(zzg2.zzc(), zzap.zzch)) {
            contentValues.put("ga_app_id", zzg2.zzg());
        }
        try {
            SQLiteDatabase c_ = c_();
            if (((long) c_.update("apps", contentValues, "app_id = ?", new String[]{zzg2.zzc()})) == 0 && c_.insertWithOnConflict("apps", (String) null, contentValues, 5) == -1) {
                zzr().zzf().zza("Failed to insert/update app (got -1). appId", zzfj.zza(zzg2.zzc()));
            }
        } catch (SQLiteException e2) {
            zzr().zzf().zza("Error storing app. appId", zzfj.zza(zzg2.zzc()), e2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(List<Long> list) {
        zzd();
        zzak();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zzam()) {
            String join = TextUtils.join(",", list);
            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
            sb.append("(");
            sb.append(join);
            sb.append(")");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 80);
            sb3.append("SELECT COUNT(1) FROM queue WHERE rowid IN ");
            sb3.append(sb2);
            sb3.append(" AND retry_count =  2147483647 LIMIT 1");
            if (zzb(sb3.toString(), (String[]) null) > 0) {
                zzr().zzi().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase c_ = c_();
                StringBuilder sb4 = new StringBuilder(String.valueOf(sb2).length() + 127);
                sb4.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb4.append(sb2);
                sb4.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
                c_.execSQL(sb4.toString());
            } catch (SQLiteException e2) {
                zzr().zzf().zza("Error incrementing retry count. error", e2);
            }
        }
    }

    public final boolean zza(zzbr.zzg zzg2, boolean z) {
        zzd();
        zzak();
        Preconditions.checkNotNull(zzg2);
        Preconditions.checkNotEmpty(zzg2.zzx());
        Preconditions.checkState(zzg2.zzk());
        zzv();
        long currentTimeMillis = zzm().currentTimeMillis();
        if (zzg2.zzl() < currentTimeMillis - zzx.zzk() || zzg2.zzl() > zzx.zzk() + currentTimeMillis) {
            zzr().zzi().zza("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzfj.zza(zzg2.zzx()), Long.valueOf(currentTimeMillis), Long.valueOf(zzg2.zzl()));
        }
        try {
            byte[] zzc2 = zzg().zzc(zzg2.zzbi());
            zzr().zzx().zza("Saving bundle, size", Integer.valueOf(zzc2.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzg2.zzx());
            contentValues.put("bundle_end_timestamp", Long.valueOf(zzg2.zzl()));
            contentValues.put(PhotosOemApi.PATH_SPECIAL_TYPE_DATA, zzc2);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            if (zzg2.zzaz()) {
                contentValues.put("retry_count", Integer.valueOf(zzg2.zzba()));
            }
            try {
                if (c_().insert("queue", (String) null, contentValues) != -1) {
                    return true;
                }
                zzr().zzf().zza("Failed to insert bundle (got -1). appId", zzfj.zza(zzg2.zzx()));
                return false;
            } catch (SQLiteException e2) {
                zzr().zzf().zza("Error storing bundle. appId", zzfj.zza(zzg2.zzx()), e2);
                return false;
            }
        } catch (IOException e3) {
            zzr().zzf().zza("Data loss. Failed to serialize bundle. appId", zzfj.zza(zzg2.zzx()), e3);
            return false;
        }
    }

    public final boolean zza(zzak zzak, long j, boolean z) {
        zzd();
        zzak();
        Preconditions.checkNotNull(zzak);
        Preconditions.checkNotEmpty(zzak.zza);
        zzbr.zzc.zza zzb2 = zzbr.zzc.zzj().zzb(zzak.zzd);
        Iterator<String> it = zzak.zze.iterator();
        while (it.hasNext()) {
            String next = it.next();
            zzbr.zze.zza zza = zzbr.zze.zzk().zza(next);
            zzg().zza(zza, zzak.zze.zza(next));
            zzb2.zza(zza);
        }
        byte[] zzbi = ((zzbr.zzc) ((zzfd) zzb2.zzu())).zzbi();
        if (!zzkz.zzb() || !zzt().zze(zzak.zza, zzap.zzcy)) {
            zzr().zzx().zza("Saving event, name, data size", zzo().zza(zzak.zzb), Integer.valueOf(zzbi.length));
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzak.zza);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzak.zzb);
        contentValues.put("timestamp", Long.valueOf(zzak.zzc));
        contentValues.put("metadata_fingerprint", Long.valueOf(j));
        contentValues.put(PhotosOemApi.PATH_SPECIAL_TYPE_DATA, zzbi);
        contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
        try {
            if (c_().insert("raw_events", (String) null, contentValues) != -1) {
                return true;
            }
            zzr().zzf().zza("Failed to insert raw event (got -1). appId", zzfj.zza(zzak.zza));
            return false;
        } catch (SQLiteException e2) {
            zzr().zzf().zza("Error storing raw event. appId", zzfj.zza(zzak.zza), e2);
            return false;
        }
    }

    public final boolean zza(zzlb zzlb) {
        Preconditions.checkNotNull(zzlb);
        zzd();
        zzak();
        if (zzc(zzlb.zza, zzlb.zzc) == null) {
            if (zzla.zza(zzlb.zzc)) {
                if (zzb("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zzlb.zza}) >= ((long) zzt().zzc(zzlb.zza))) {
                    return false;
                }
            } else if (!zzt().zze(zzlb.zza, zzap.zzbd)) {
                if (zzb("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zzlb.zza, zzlb.zzb}) >= 25) {
                    return false;
                }
            } else if (!"_npa".equals(zzlb.zzc)) {
                if (zzb("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zzlb.zza, zzlb.zzb}) >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzlb.zza);
        contentValues.put("origin", zzlb.zzb);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzlb.zzc);
        contentValues.put("set_timestamp", Long.valueOf(zzlb.zzd));
        zza(contentValues, "value", zzlb.zze);
        try {
            if (c_().insertWithOnConflict("user_attributes", (String) null, contentValues, 5) == -1) {
                zzr().zzf().zza("Failed to insert/update user property (got -1). appId", zzfj.zza(zzlb.zza));
            }
        } catch (SQLiteException e2) {
            zzr().zzf().zza("Error storing user property. appId", zzfj.zza(zzlb.zza), e2);
        }
        return true;
    }

    public final boolean zza(zzv zzv) {
        Preconditions.checkNotNull(zzv);
        zzd();
        zzak();
        if (zzc(zzv.zza, zzv.zzc.zza) == null) {
            if (zzb("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{zzv.zza}) >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzv.zza);
        contentValues.put("origin", zzv.zzb);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzv.zzc.zza);
        zza(contentValues, "value", zzv.zzc.zza());
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, Boolean.valueOf(zzv.zze));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, zzv.zzf);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.valueOf(zzv.zzh));
        zzp();
        contentValues.put("timed_out_event", zzla.zza((Parcelable) zzv.zzg));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzv.zzd));
        zzp();
        contentValues.put("triggered_event", zzla.zza((Parcelable) zzv.zzi));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.valueOf(zzv.zzc.zzb));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.valueOf(zzv.zzj));
        zzp();
        contentValues.put("expired_event", zzla.zza((Parcelable) zzv.zzk));
        try {
            if (c_().insertWithOnConflict("conditional_properties", (String) null, contentValues, 5) == -1) {
                zzr().zzf().zza("Failed to insert/update conditional user property (got -1)", zzfj.zza(zzv.zza));
            }
        } catch (SQLiteException e2) {
            zzr().zzf().zza("Error storing conditional user property", zzfj.zza(zzv.zza), e2);
        }
        return true;
    }

    public final boolean zza(String str, Long l, long j, zzbr.zzc zzc2) {
        zzd();
        zzak();
        Preconditions.checkNotNull(zzc2);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l);
        byte[] zzbi = zzc2.zzbi();
        zzr().zzx().zza("Saving complex main event, appId, data size", zzo().zza(str), Integer.valueOf(zzbi.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l);
        contentValues.put("children_to_process", Long.valueOf(j));
        contentValues.put("main_event", zzbi);
        try {
            if (c_().insertWithOnConflict("main_event_params", (String) null, contentValues, 5) != -1) {
                return true;
            }
            zzr().zzf().zza("Failed to insert complex main event (got -1). appId", zzfj.zza(str));
            return false;
        } catch (SQLiteException e2) {
            zzr().zzf().zza("Error storing complex main event. appId", zzfj.zza(str), e2);
            return false;
        }
    }

    public final long zzaa() {
        Cursor cursor = null;
        try {
            cursor = c_().rawQuery("select rowid from raw_events order by rowid desc limit 1;", (String[]) null);
            if (!cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return -1;
            }
            long j = cursor.getLong(0);
            if (cursor != null) {
                cursor.close();
            }
            return j;
        } catch (SQLiteException e2) {
            zzr().zzf().zza("Error querying raw events", e2);
            if (cursor != null) {
                cursor.close();
            }
            return -1;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x011d A[Catch:{ SQLiteException -> 0x0204 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0121 A[Catch:{ SQLiteException -> 0x0204 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x015b A[Catch:{ SQLiteException -> 0x0204 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0174 A[Catch:{ SQLiteException -> 0x0204 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0189 A[Catch:{ SQLiteException -> 0x0204 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01a5 A[Catch:{ SQLiteException -> 0x0204 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x01a6 A[Catch:{ SQLiteException -> 0x0204 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01b5 A[Catch:{ SQLiteException -> 0x0204 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x01ec A[Catch:{ SQLiteException -> 0x0204 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0200  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0229  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0231  */
    public final zzg zzb(String str) {
        Cursor cursor;
        boolean z;
        boolean z2;
        String str2 = str;
        Preconditions.checkNotEmpty(str);
        zzd();
        zzak();
        Cursor cursor2 = null;
        try {
            boolean z3 = true;
            cursor = c_().query("apps", new String[]{"app_instance_id", "gmp_app_id", "resettable_device_id_hash", "last_bundle_index", "last_bundle_start_timestamp", "last_bundle_end_timestamp", "app_version", "app_store", "gmp_version", "dev_cert_hash", "measurement_enabled", "day", "daily_public_events_count", "daily_events_count", "daily_conversions_count", "config_fetched_time", "failed_config_fetch_time", "app_version_int", "firebase_instance_id", "daily_error_events_count", "daily_realtime_events_count", "health_monitor_sample", "android_id", "adid_reporting_enabled", "ssaid_reporting_enabled", "admob_app_id", "dynamite_version", "safelisted_events", "ga_app_id"}, "app_id=?", new String[]{str2}, (String) null, (String) null, (String) null);
            try {
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                try {
                    zzg zzg2 = new zzg(this.zza.zzs(), str2);
                    zzg2.zza(cursor.getString(0));
                    zzg2.zzb(cursor.getString(1));
                    zzg2.zze(cursor.getString(2));
                    zzg2.zzg(cursor.getLong(3));
                    zzg2.zza(cursor.getLong(4));
                    zzg2.zzb(cursor.getLong(5));
                    zzg2.zzg(cursor.getString(6));
                    zzg2.zzh(cursor.getString(7));
                    zzg2.zzd(cursor.getLong(8));
                    zzg2.zze(cursor.getLong(9));
                    if (!cursor.isNull(10)) {
                        if (cursor.getInt(10) == 0) {
                            z = false;
                            zzg2.zza(z);
                            zzg2.zzj(cursor.getLong(11));
                            zzg2.zzk(cursor.getLong(12));
                            zzg2.zzl(cursor.getLong(13));
                            zzg2.zzm(cursor.getLong(14));
                            zzg2.zzh(cursor.getLong(15));
                            zzg2.zzi(cursor.getLong(16));
                            zzg2.zzc(!cursor.isNull(17) ? -2147483648L : (long) cursor.getInt(17));
                            zzg2.zzf(cursor.getString(18));
                            zzg2.zzo(cursor.getLong(19));
                            zzg2.zzn(cursor.getLong(20));
                            zzg2.zzi(cursor.getString(21));
                            long j = 0;
                            if (!zzt().zza(zzap.zzdh)) {
                                zzg2.zzp(cursor.isNull(22) ? 0 : cursor.getLong(22));
                            }
                            if (!cursor.isNull(23)) {
                                if (cursor.getInt(23) == 0) {
                                    z2 = false;
                                    zzg2.zzb(z2);
                                    if (!cursor.isNull(24)) {
                                        if (cursor.getInt(24) == 0) {
                                            z3 = false;
                                        }
                                    }
                                    zzg2.zzc(z3);
                                    zzg2.zzc(cursor.getString(25));
                                    if (!cursor.isNull(26)) {
                                        j = cursor.getLong(26);
                                    }
                                    zzg2.zzf(j);
                                    if (!cursor.isNull(27)) {
                                        zzg2.zza((List<String>) Arrays.asList(cursor.getString(27).split(",", -1)));
                                    }
                                    if (zzll.zzb() && zzt().zze(str2, zzap.zzch)) {
                                        zzg2.zzd(cursor.getString(28));
                                    }
                                    zzg2.zzb();
                                    if (cursor.moveToNext()) {
                                        zzr().zzf().zza("Got multiple records for app, expected one. appId", zzfj.zza(str));
                                    }
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    return zzg2;
                                }
                            }
                            z2 = true;
                            zzg2.zzb(z2);
                            if (!cursor.isNull(24)) {
                            }
                            zzg2.zzc(z3);
                            zzg2.zzc(cursor.getString(25));
                            if (!cursor.isNull(26)) {
                            }
                            zzg2.zzf(j);
                            if (!cursor.isNull(27)) {
                            }
                            zzg2.zzd(cursor.getString(28));
                            zzg2.zzb();
                            if (cursor.moveToNext()) {
                            }
                            if (cursor != null) {
                            }
                            return zzg2;
                        }
                    }
                    z = true;
                    zzg2.zza(z);
                    zzg2.zzj(cursor.getLong(11));
                    zzg2.zzk(cursor.getLong(12));
                    zzg2.zzl(cursor.getLong(13));
                    zzg2.zzm(cursor.getLong(14));
                    zzg2.zzh(cursor.getLong(15));
                    zzg2.zzi(cursor.getLong(16));
                    zzg2.zzc(!cursor.isNull(17) ? -2147483648L : (long) cursor.getInt(17));
                    zzg2.zzf(cursor.getString(18));
                    zzg2.zzo(cursor.getLong(19));
                    zzg2.zzn(cursor.getLong(20));
                    zzg2.zzi(cursor.getString(21));
                    long j2 = 0;
                    if (!zzt().zza(zzap.zzdh)) {
                    }
                    if (!cursor.isNull(23)) {
                    }
                    z2 = true;
                    zzg2.zzb(z2);
                    if (!cursor.isNull(24)) {
                    }
                    zzg2.zzc(z3);
                    zzg2.zzc(cursor.getString(25));
                    if (!cursor.isNull(26)) {
                    }
                    zzg2.zzf(j2);
                    if (!cursor.isNull(27)) {
                    }
                    zzg2.zzd(cursor.getString(28));
                    zzg2.zzb();
                    if (cursor.moveToNext()) {
                    }
                    if (cursor != null) {
                    }
                    return zzg2;
                } catch (SQLiteException e2) {
                    e = e2;
                    try {
                        zzr().zzf().zza("Error querying app. appId", zzfj.zza(str), e);
                        if (cursor != null) {
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                        }
                        throw th;
                    }
                }
            } catch (SQLiteException e3) {
                e = e3;
                zzr().zzf().zza("Error querying app. appId", zzfj.zza(str), e);
                if (cursor != null) {
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                cursor2 = cursor;
                if (cursor2 != null) {
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            zzr().zzf().zza("Error querying app. appId", zzfj.zza(str), e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public final List<zzv> zzb(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzd();
        zzak();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return zza(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    public final void zzb(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzd();
        zzak();
        try {
            int delete = c_().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
            if (!zzkz.zzb() || !this.zza.zzb().zze(str, zzap.zzcy)) {
                zzr().zzx().zza("Deleted user attribute rows", Integer.valueOf(delete));
            }
        } catch (SQLiteException e2) {
            if (!zzkz.zzb() || !this.zza.zzb().zze(str, zzap.zzcy)) {
                zzr().zzf().zza("Error deleting user attribute. appId", zzfj.zza(str), zzo().zzc(str2), e2);
            } else {
                zzr().zzf().zza("Error deleting user property. appId", zzfj.zza(str), zzo().zzc(str2), e2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(String str, List<zzbj.zza> list) {
        boolean z;
        boolean z2;
        String str2 = str;
        List<zzbj.zza> list2 = list;
        Preconditions.checkNotNull(list);
        for (int i = 0; i < list.size(); i++) {
            zzbj.zza.C0022zza zza = (zzbj.zza.C0022zza) list2.get(i).zzbm();
            if (zza.zzb() != 0) {
                for (int i2 = 0; i2 < zza.zzb(); i2++) {
                    zzbj.zzb.zza zza2 = (zzbj.zzb.zza) zza.zzb(i2).zzbm();
                    zzbj.zzb.zza zza3 = (zzbj.zzb.zza) ((zzfd.zzb) zza2.clone());
                    String zzb2 = zzhl.zzb(zza2.zza());
                    if (zzb2 != null) {
                        zza3.zza(zzb2);
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    for (int i3 = 0; i3 < zza2.zzb(); i3++) {
                        zzbj.zzc zza4 = zza2.zza(i3);
                        String zza5 = zzho.zza(zza4.zzh());
                        if (zza5 != null) {
                            zza3.zza(i3, (zzbj.zzc) ((zzfd) ((zzbj.zzc.zza) zza4.zzbm()).zza(zza5).zzu()));
                            z2 = true;
                        }
                    }
                    if (z2) {
                        zza = zza.zza(i2, zza3);
                        list2.set(i, (zzbj.zza) ((zzfd) zza.zzu()));
                    }
                }
            }
            if (zza.zza() != 0) {
                for (int i4 = 0; i4 < zza.zza(); i4++) {
                    zzbj.zze zza6 = zza.zza(i4);
                    String zza7 = zzhn.zza(zza6.zzc());
                    if (zza7 != null) {
                        zza = zza.zza(i4, ((zzbj.zze.zza) zza6.zzbm()).zza(zza7));
                        list2.set(i, (zzbj.zza) ((zzfd) zza.zzu()));
                    }
                }
            }
        }
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        SQLiteDatabase c_ = c_();
        c_.beginTransaction();
        try {
            zzak();
            zzd();
            Preconditions.checkNotEmpty(str);
            SQLiteDatabase c_2 = c_();
            c_2.delete("property_filters", "app_id=?", new String[]{str2});
            c_2.delete("event_filters", "app_id=?", new String[]{str2});
            for (zzbj.zza next : list) {
                zzak();
                zzd();
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotNull(next);
                if (!next.zza()) {
                    zzr().zzi().zza("Audience with no ID. appId", zzfj.zza(str));
                } else {
                    int zzb3 = next.zzb();
                    Iterator<zzbj.zzb> it = next.zze().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            Iterator<zzbj.zze> it2 = next.zzc().iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    Iterator<zzbj.zzb> it3 = next.zze().iterator();
                                    while (true) {
                                        if (!it3.hasNext()) {
                                            z = true;
                                            break;
                                        } else if (!zza(str2, zzb3, it3.next())) {
                                            z = false;
                                            break;
                                        }
                                    }
                                    if (z) {
                                        Iterator<zzbj.zze> it4 = next.zzc().iterator();
                                        while (true) {
                                            if (!it4.hasNext()) {
                                                break;
                                            } else if (!zza(str2, zzb3, it4.next())) {
                                                z = false;
                                                break;
                                            }
                                        }
                                    }
                                    if (!z) {
                                        zzak();
                                        zzd();
                                        Preconditions.checkNotEmpty(str);
                                        SQLiteDatabase c_3 = c_();
                                        c_3.delete("property_filters", "app_id=? and audience_id=?", new String[]{str2, String.valueOf(zzb3)});
                                        c_3.delete("event_filters", "app_id=? and audience_id=?", new String[]{str2, String.valueOf(zzb3)});
                                    }
                                } else if (!it2.next().zza()) {
                                    zzr().zzi().zza("Property filter with no ID. Audience definition ignored. appId, audienceId", zzfj.zza(str), Integer.valueOf(zzb3));
                                    break;
                                }
                            }
                        } else if (!it.next().zza()) {
                            zzr().zzi().zza("Event filter with no ID. Audience definition ignored. appId, audienceId", zzfj.zza(str), Integer.valueOf(zzb3));
                            break;
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (zzbj.zza next2 : list) {
                arrayList.add(next2.zza() ? Integer.valueOf(next2.zzb()) : null);
            }
            zzc(str2, (List<Integer>) arrayList);
            c_.setTransactionSuccessful();
        } finally {
            c_.endTransaction();
        }
    }

    public final long zzc(String str) {
        Preconditions.checkNotEmpty(str);
        zzd();
        zzak();
        try {
            return (long) c_().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(1000000, zzt().zzb(str, zzap.zzo))))});
        } catch (SQLiteException e2) {
            zzr().zzf().zza("Error deleting over the limit events. appId", zzfj.zza(str), e2);
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ac  */
    public final zzlb zzc(String str, String str2) {
        Cursor cursor;
        String str3 = str2;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzd();
        zzak();
        Cursor cursor2 = null;
        try {
            cursor = c_().query("user_attributes", new String[]{"set_timestamp", "value", "origin"}, "app_id=? and name=?", new String[]{str, str3}, (String) null, (String) null, (String) null);
            try {
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                try {
                    zzlb zzlb = new zzlb(str, cursor.getString(2), str2, cursor.getLong(0), zza(cursor, 1));
                    if (cursor.moveToNext()) {
                        zzr().zzf().zza("Got multiple records for user property, expected one. appId", zzfj.zza(str));
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return zzlb;
                } catch (SQLiteException e2) {
                    e = e2;
                    try {
                        zzr().zzf().zza("Error querying user property. appId", zzfj.zza(str), zzo().zzc(str3), e);
                        if (cursor != null) {
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                        }
                        throw th;
                    }
                }
            } catch (SQLiteException e3) {
                e = e3;
                zzr().zzf().zza("Error querying user property. appId", zzfj.zza(str), zzo().zzc(str3), e);
                if (cursor != null) {
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                cursor2 = cursor;
                if (cursor2 != null) {
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            zzr().zzf().zza("Error querying user property. appId", zzfj.zza(str), zzo().zzc(str3), e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x012b  */
    public final zzv zzd(String str, String str2) {
        Cursor cursor;
        String str3 = str2;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzd();
        zzak();
        Cursor cursor2 = null;
        try {
            cursor = c_().query("conditional_properties", new String[]{"origin", "value", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, "timed_out_event", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "triggered_event", AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, "expired_event"}, "app_id=? and name=?", new String[]{str, str3}, (String) null, (String) null, (String) null);
            try {
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                String string = cursor.getString(0);
                try {
                    Object zza = zza(cursor, 1);
                    boolean z = cursor.getInt(2) != 0;
                    String string2 = cursor.getString(3);
                    long j = cursor.getLong(4);
                    long j2 = cursor.getLong(6);
                    zzkz zzkz = new zzkz(str2, cursor.getLong(8), zza, string);
                    zzv zzv = new zzv(str, string, zzkz, j2, z, string2, (zzan) zzg().zza(cursor.getBlob(5), zzan.CREATOR), j, (zzan) zzg().zza(cursor.getBlob(7), zzan.CREATOR), cursor.getLong(9), (zzan) zzg().zza(cursor.getBlob(10), zzan.CREATOR));
                    if (cursor.moveToNext()) {
                        zzr().zzf().zza("Got multiple records for conditional property, expected one", zzfj.zza(str), zzo().zzc(str3));
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return zzv;
                } catch (SQLiteException e2) {
                    e = e2;
                    try {
                        zzr().zzf().zza("Error querying conditional property", zzfj.zza(str), zzo().zzc(str3), e);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                        }
                        throw th;
                    }
                }
            } catch (SQLiteException e3) {
                e = e3;
                zzr().zzf().zza("Error querying conditional property", zzfj.zza(str), zzo().zzc(str3), e);
                if (cursor != null) {
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                cursor2 = cursor;
                if (cursor2 != null) {
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            zzr().zzf().zza("Error querying conditional property", zzfj.zza(str), zzo().zzc(str3), e);
            if (cursor != null) {
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0076  */
    public final byte[] zzd(String str) {
        Cursor cursor;
        Preconditions.checkNotEmpty(str);
        zzd();
        zzak();
        Cursor cursor2 = null;
        try {
            cursor = c_().query("apps", new String[]{"remote_config"}, "app_id=?", new String[]{str}, (String) null, (String) null, (String) null);
            try {
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                byte[] blob = cursor.getBlob(0);
                if (cursor.moveToNext()) {
                    zzr().zzf().zza("Got multiple records for app config, expected one. appId", zzfj.zza(str));
                }
                if (cursor != null) {
                    cursor.close();
                }
                return blob;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzr().zzf().zza("Error querying remote config. appId", zzfj.zza(str), e);
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            zzr().zzf().zza("Error querying remote config. appId", zzfj.zza(str), e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public final int zze(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzd();
        zzak();
        try {
            return c_().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e2) {
            zzr().zzf().zza("Error deleting conditional property", zzfj.zza(str), zzo().zzc(str2), e2);
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    public final Map<Integer, List<zzbj.zzb>> zze(String str) {
        Preconditions.checkNotEmpty(str);
        ArrayMap arrayMap = new ArrayMap();
        SQLiteDatabase c_ = c_();
        Cursor cursor = null;
        try {
            cursor = c_.query("event_filters", new String[]{"audience_id", PhotosOemApi.PATH_SPECIAL_TYPE_DATA}, "app_id=?", new String[]{str}, (String) null, (String) null, (String) null);
            if (!cursor.moveToFirst()) {
                Map<Integer, List<zzbj.zzb>> emptyMap = Collections.emptyMap();
                if (cursor != null) {
                    cursor.close();
                }
                return emptyMap;
            }
            do {
                try {
                    zzbj.zzb zzb2 = (zzbj.zzb) ((zzfd) ((zzbj.zzb.zza) zzkw.zza(zzbj.zzb.zzl(), cursor.getBlob(1))).zzu());
                    if (zzb2.zzf()) {
                        int i = cursor.getInt(0);
                        List list = (List) arrayMap.get(Integer.valueOf(i));
                        if (list == null) {
                            list = new ArrayList();
                            arrayMap.put(Integer.valueOf(i), list);
                        }
                        list.add(zzb2);
                    }
                } catch (IOException e2) {
                    zzr().zzf().zza("Failed to merge filter. appId", zzfj.zza(str), e2);
                }
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayMap;
        } catch (SQLiteException e3) {
            zzr().zzf().zza("Database error querying filters. appId", zzfj.zza(str), e3);
            Map<Integer, List<zzbj.zzb>> emptyMap2 = Collections.emptyMap();
            if (cursor != null) {
                cursor.close();
            }
            return emptyMap2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zze() {
        return false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0087  */
    public final Map<Integer, List<Integer>> zzf(String str) {
        Cursor cursor;
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor2 = null;
        try {
            cursor = c_().rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str, str});
            try {
                if (!cursor.moveToFirst()) {
                    Map<Integer, List<Integer>> emptyMap = Collections.emptyMap();
                    if (cursor != null) {
                        cursor.close();
                    }
                    return emptyMap;
                }
                do {
                    int i = cursor.getInt(0);
                    List list = (List) arrayMap.get(Integer.valueOf(i));
                    if (list == null) {
                        list = new ArrayList();
                        arrayMap.put(Integer.valueOf(i), list);
                    }
                    list.add(Integer.valueOf(cursor.getInt(1)));
                } while (cursor.moveToNext());
                if (cursor != null) {
                    cursor.close();
                }
                return arrayMap;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzr().zzf().zza("Database error querying scoped filters. appId", zzfj.zza(str), e);
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            zzr().zzf().zza("Database error querying scoped filters. appId", zzfj.zza(str), e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ba  */
    public final Map<Integer, List<zzbj.zzb>> zzf(String str, String str2) {
        Cursor cursor;
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor2 = null;
        try {
            cursor = c_().query("event_filters", new String[]{"audience_id", PhotosOemApi.PATH_SPECIAL_TYPE_DATA}, "app_id=? AND event_name=?", new String[]{str, str2}, (String) null, (String) null, (String) null);
            try {
                if (!cursor.moveToFirst()) {
                    Map<Integer, List<zzbj.zzb>> emptyMap = Collections.emptyMap();
                    if (cursor != null) {
                        cursor.close();
                    }
                    return emptyMap;
                }
                do {
                    try {
                        zzbj.zzb zzb2 = (zzbj.zzb) ((zzfd) ((zzbj.zzb.zza) zzkw.zza(zzbj.zzb.zzl(), cursor.getBlob(1))).zzu());
                        int i = cursor.getInt(0);
                        List list = (List) arrayMap.get(Integer.valueOf(i));
                        if (list == null) {
                            list = new ArrayList();
                            arrayMap.put(Integer.valueOf(i), list);
                        }
                        list.add(zzb2);
                    } catch (IOException e2) {
                        zzr().zzf().zza("Failed to merge filter. appId", zzfj.zza(str), e2);
                    }
                } while (cursor.moveToNext());
                if (cursor != null) {
                    cursor.close();
                }
                return arrayMap;
            } catch (SQLiteException e3) {
                e = e3;
                try {
                    zzr().zzf().zza("Database error querying filters. appId", zzfj.zza(str), e);
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            zzr().zzf().zza("Database error querying filters. appId", zzfj.zza(str), e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public final void zzf() {
        zzak();
        c_().beginTransaction();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a2  */
    public final Map<Integer, zzbr.zzi> zzg(String str) {
        Cursor cursor;
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        Cursor cursor2 = null;
        try {
            cursor = c_().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str}, (String) null, (String) null, (String) null);
            try {
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                ArrayMap arrayMap = new ArrayMap();
                do {
                    int i = cursor.getInt(0);
                    try {
                        arrayMap.put(Integer.valueOf(i), (zzbr.zzi) ((zzfd) ((zzbr.zzi.zza) zzkw.zza(zzbr.zzi.zzi(), cursor.getBlob(1))).zzu()));
                    } catch (IOException e2) {
                        zzr().zzf().zza("Failed to merge filter results. appId, audienceId, error", zzfj.zza(str), Integer.valueOf(i), e2);
                    }
                } while (cursor.moveToNext());
                if (cursor != null) {
                    cursor.close();
                }
                return arrayMap;
            } catch (SQLiteException e3) {
                e = e3;
                try {
                    zzr().zzf().zza("Database error querying filter results. appId", zzfj.zza(str), e);
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            zzr().zzf().zza("Database error querying filter results. appId", zzfj.zza(str), e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ba  */
    public final Map<Integer, List<zzbj.zze>> zzg(String str, String str2) {
        Cursor cursor;
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor2 = null;
        try {
            cursor = c_().query("property_filters", new String[]{"audience_id", PhotosOemApi.PATH_SPECIAL_TYPE_DATA}, "app_id=? AND property_name=?", new String[]{str, str2}, (String) null, (String) null, (String) null);
            try {
                if (!cursor.moveToFirst()) {
                    Map<Integer, List<zzbj.zze>> emptyMap = Collections.emptyMap();
                    if (cursor != null) {
                        cursor.close();
                    }
                    return emptyMap;
                }
                do {
                    try {
                        zzbj.zze zze2 = (zzbj.zze) ((zzfd) ((zzbj.zze.zza) zzkw.zza(zzbj.zze.zzi(), cursor.getBlob(1))).zzu());
                        int i = cursor.getInt(0);
                        List list = (List) arrayMap.get(Integer.valueOf(i));
                        if (list == null) {
                            list = new ArrayList();
                            arrayMap.put(Integer.valueOf(i), list);
                        }
                        list.add(zze2);
                    } catch (IOException e2) {
                        zzr().zzf().zza("Failed to merge filter", zzfj.zza(str), e2);
                    }
                } while (cursor.moveToNext());
                if (cursor != null) {
                    cursor.close();
                }
                return arrayMap;
            } catch (SQLiteException e3) {
                e = e3;
                try {
                    zzr().zzf().zza("Database error querying filters. appId", zzfj.zza(str), e);
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            zzr().zzf().zza("Database error querying filters. appId", zzfj.zza(str), e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public final long zzh(String str) {
        Preconditions.checkNotEmpty(str);
        return zza("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    public final long zzh(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzd();
        zzak();
        SQLiteDatabase c_ = c_();
        c_.beginTransaction();
        long j = 0;
        try {
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 32);
            sb.append("select ");
            sb.append(str2);
            sb.append(" from app2 where app_id=?");
            long zza = zza(sb.toString(), new String[]{str}, -1);
            if (zza == -1) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", str);
                contentValues.put("first_open_count", 0);
                contentValues.put("previous_install_count", 0);
                if (c_.insertWithOnConflict("app2", (String) null, contentValues, 5) == -1) {
                    zzr().zzf().zza("Failed to insert column (got -1). appId", zzfj.zza(str), str2);
                    c_.endTransaction();
                    return -1;
                }
                zza = 0;
            }
            try {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("app_id", str);
                contentValues2.put(str2, Long.valueOf(1 + zza));
                if (((long) c_.update("app2", contentValues2, "app_id = ?", new String[]{str})) == 0) {
                    zzr().zzf().zza("Failed to update column (got 0). appId", zzfj.zza(str), str2);
                    c_.endTransaction();
                    return -1;
                }
                c_.setTransactionSuccessful();
                c_.endTransaction();
                return zza;
            } catch (SQLiteException e2) {
                e = e2;
                j = zza;
                try {
                    zzr().zzf().zza("Error inserting column. appId", zzfj.zza(str), str2, e);
                    c_.endTransaction();
                    return j;
                } catch (Throwable th) {
                    c_.endTransaction();
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            zzr().zzf().zza("Error inserting column. appId", zzfj.zza(str), str2, e);
            c_.endTransaction();
            return j;
        }
    }

    public final void zzh() {
        zzak();
        c_().endTransaction();
    }

    public final boolean zzk() {
        return zzb("select count(1) > 0 from queue where has_realtime = 1", (String[]) null) != 0;
    }

    /* access modifiers changed from: package-private */
    public final void zzv() {
        zzd();
        zzak();
        if (zzam()) {
            long zza = zzs().zzf.zza();
            long elapsedRealtime = zzm().elapsedRealtime();
            if (Math.abs(elapsedRealtime - zza) > zzap.zzx.zza(null).longValue()) {
                zzs().zzf.zza(elapsedRealtime);
                zzd();
                zzak();
                if (zzam()) {
                    int delete = c_().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzm().currentTimeMillis()), String.valueOf(zzx.zzk())});
                    if (delete > 0) {
                        zzr().zzx().zza("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                    }
                }
            }
        }
    }

    public final long zzw() {
        return zza("select max(bundle_end_timestamp) from queue", (String[]) null, 0);
    }

    public final long zzx() {
        return zza("select max(timestamp) from raw_events", (String[]) null, 0);
    }

    public final boolean zzy() {
        return zzb("select count(1) > 0 from raw_events", (String[]) null) != 0;
    }

    public final boolean zzz() {
        return zzb("select count(1) > 0 from raw_events where realtime = 1", (String[]) null) != 0;
    }
}
