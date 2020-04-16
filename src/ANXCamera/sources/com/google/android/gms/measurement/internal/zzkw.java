package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzbj;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzeq;
import com.google.android.gms.internal.measurement.zzfd;
import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzgn;
import com.google.android.gms.internal.measurement.zzjo;
import com.google.android.gms.internal.measurement.zzju;
import com.google.android.gms.internal.measurement.zzkz;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.xiaomi.stat.C0161d;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
public final class zzkw extends zzkp {
    zzkw(zzks zzks) {
        super(zzks);
    }

    static int zza(zzbr.zzg.zza zza, String str) {
        if (zza == null) {
            return -1;
        }
        for (int i = 0; i < zza.zze(); i++) {
            if (str.equals(zza.zzd(i).zzc())) {
                return i;
            }
        }
        return -1;
    }

    static zzbr.zze zza(zzbr.zzc zzc, String str) {
        for (zzbr.zze next : zzc.zza()) {
            if (next.zzb().equals(str)) {
                return next;
            }
        }
        return null;
    }

    static <Builder extends zzgn> Builder zza(Builder builder, byte[] bArr) throws zzfo {
        zzeq zzb = zzeq.zzb();
        return zzb != null ? builder.zza(bArr, zzb) : builder.zza(bArr);
    }

    private static String zza(boolean z, boolean z2, boolean z3) {
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append("Dynamic ");
        }
        if (z2) {
            sb.append("Sequence ");
        }
        if (z3) {
            sb.append("Session-Scoped ");
        }
        return sb.toString();
    }

    static List<Long> zza(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            long j = 0;
            for (int i2 = 0; i2 < 64; i2++) {
                int i3 = (i << 6) + i2;
                if (i3 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i3)) {
                    j |= 1 << i2;
                }
            }
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    private static List<zzbr.zze> zza(Bundle[] bundleArr) {
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle : bundleArr) {
            if (bundle != null) {
                zzbr.zze.zza zzk = zzbr.zze.zzk();
                for (String str : bundle.keySet()) {
                    zzbr.zze.zza zza = zzbr.zze.zzk().zza(str);
                    Object obj = bundle.get(str);
                    if (obj instanceof Long) {
                        zza.zza(((Long) obj).longValue());
                    } else if (obj instanceof String) {
                        zza.zzb((String) obj);
                    } else if (obj instanceof Double) {
                        zza.zza(((Double) obj).doubleValue());
                    }
                    zzk.zza(zza);
                }
                if (zzk.zzd() > 0) {
                    arrayList.add((zzbr.zze) ((zzfd) zzk.zzu()));
                }
            }
        }
        return arrayList;
    }

    private static void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
    }

    private final void zza(StringBuilder sb, int i, zzbj.zzc zzc) {
        if (zzc != null) {
            zza(sb, i);
            sb.append("filter {\n");
            if (zzc.zze()) {
                zza(sb, i, "complement", (Object) Boolean.valueOf(zzc.zzf()));
            }
            if (!zzkz.zzb() || !zzt().zza(zzap.zzcy) || zzc.zzg()) {
                zza(sb, i, "param_name", (Object) zzo().zzb(zzc.zzh()));
            }
            if (!zzkz.zzb() || !zzt().zza(zzap.zzcy) || zzc.zza()) {
                int i2 = i + 1;
                zzbj.zzf zzb = zzc.zzb();
                if (zzb != null) {
                    zza(sb, i2);
                    sb.append("string_filter");
                    sb.append(" {\n");
                    if (zzb.zza()) {
                        zza(sb, i2, "match_type", (Object) zzb.zzb().name());
                    }
                    if (!zzkz.zzb() || !zzt().zza(zzap.zzcy) || zzb.zzc()) {
                        zza(sb, i2, "expression", (Object) zzb.zzd());
                    }
                    if (zzb.zze()) {
                        zza(sb, i2, "case_sensitive", (Object) Boolean.valueOf(zzb.zzf()));
                    }
                    if (zzb.zzh() > 0) {
                        zza(sb, i2 + 1);
                        sb.append("expression_list {\n");
                        for (String append : zzb.zzg()) {
                            zza(sb, i2 + 2);
                            sb.append(append);
                            sb.append("\n");
                        }
                        sb.append("}\n");
                    }
                    zza(sb, i2);
                    sb.append("}\n");
                }
            }
            if (!zzkz.zzb() || !zzt().zza(zzap.zzcy) || zzc.zzc()) {
                zza(sb, i + 1, "number_filter", zzc.zzd());
            }
            zza(sb, i);
            sb.append("}\n");
        }
    }

    private final void zza(StringBuilder sb, int i, String str, zzbj.zzd zzd) {
        if (zzd != null) {
            zza(sb, i);
            sb.append(str);
            sb.append(" {\n");
            if (zzd.zza()) {
                zza(sb, i, "comparison_type", (Object) zzd.zzb().name());
            }
            if (zzd.zzc()) {
                zza(sb, i, "match_as_float", (Object) Boolean.valueOf(zzd.zzd()));
            }
            if (!zzkz.zzb() || !zzt().zza(zzap.zzcy) || zzd.zze()) {
                zza(sb, i, "comparison_value", (Object) zzd.zzf());
            }
            if (!zzkz.zzb() || !zzt().zza(zzap.zzcy) || zzd.zzg()) {
                zza(sb, i, "min_comparison_value", (Object) zzd.zzh());
            }
            if (!zzkz.zzb() || !zzt().zza(zzap.zzcy) || zzd.zzi()) {
                zza(sb, i, "max_comparison_value", (Object) zzd.zzj());
            }
            zza(sb, i);
            sb.append("}\n");
        }
    }

    private static void zza(StringBuilder sb, int i, String str, zzbr.zzi zzi, String str2) {
        if (zzi != null) {
            zza(sb, 3);
            sb.append(str);
            sb.append(" {\n");
            if (zzi.zzd() != 0) {
                zza(sb, 4);
                sb.append("results: ");
                int i2 = 0;
                for (Long next : zzi.zzc()) {
                    int i3 = i2 + 1;
                    if (i2 != 0) {
                        sb.append(", ");
                    }
                    sb.append(next);
                    i2 = i3;
                }
                sb.append(10);
            }
            if (zzi.zzb() != 0) {
                zza(sb, 4);
                sb.append("status: ");
                int i4 = 0;
                for (Long next2 : zzi.zza()) {
                    int i5 = i4 + 1;
                    if (i4 != 0) {
                        sb.append(", ");
                    }
                    sb.append(next2);
                    i4 = i5;
                }
                sb.append(10);
            }
            if (zzi.zzf() != 0) {
                zza(sb, 4);
                sb.append("dynamic_filter_timestamps: {");
                int i6 = 0;
                for (zzbr.zzb next3 : zzi.zze()) {
                    int i7 = i6 + 1;
                    if (i6 != 0) {
                        sb.append(", ");
                    }
                    sb.append(next3.zza() ? Integer.valueOf(next3.zzb()) : null);
                    sb.append(":");
                    sb.append(next3.zzc() ? Long.valueOf(next3.zzd()) : null);
                    i6 = i7;
                }
                sb.append("}\n");
            }
            if (zzi.zzh() != 0) {
                zza(sb, 4);
                sb.append("sequence_filter_timestamps: {");
                int i8 = 0;
                for (zzbr.zzj next4 : zzi.zzg()) {
                    int i9 = i8 + 1;
                    if (i8 != 0) {
                        sb.append(", ");
                    }
                    sb.append(next4.zza() ? Integer.valueOf(next4.zzb()) : null);
                    sb.append(": [");
                    int i10 = 0;
                    for (Long longValue : next4.zzc()) {
                        long longValue2 = longValue.longValue();
                        int i11 = i10 + 1;
                        if (i10 != 0) {
                            sb.append(", ");
                        }
                        sb.append(longValue2);
                        i10 = i11;
                    }
                    sb.append("]");
                    i8 = i9;
                }
                sb.append("}\n");
            }
            zza(sb, 3);
            sb.append("}\n");
        }
    }

    private static void zza(StringBuilder sb, int i, String str, Object obj) {
        if (obj != null) {
            zza(sb, i + 1);
            sb.append(str);
            sb.append(": ");
            sb.append(obj);
            sb.append(10);
        }
    }

    private final void zza(StringBuilder sb, int i, List<zzbr.zze> list) {
        if (list != null) {
            int i2 = i + 1;
            for (zzbr.zze next : list) {
                if (next != null) {
                    zza(sb, i2);
                    sb.append("param {\n");
                    Double d2 = null;
                    if (!zzju.zzb() || !zzt().zza(zzap.zzcz)) {
                        zza(sb, i2, AppMeasurementSdk.ConditionalUserProperty.NAME, (Object) zzo().zzb(next.zzb()));
                        zza(sb, i2, "string_value", (Object) next.zzd());
                        zza(sb, i2, "int_value", (Object) next.zze() ? Long.valueOf(next.zzf()) : null);
                        if (next.zzg()) {
                            d2 = Double.valueOf(next.zzh());
                        }
                        zza(sb, i2, "double_value", (Object) d2);
                    } else {
                        zza(sb, i2, AppMeasurementSdk.ConditionalUserProperty.NAME, (Object) next.zza() ? zzo().zzb(next.zzb()) : null);
                        zza(sb, i2, "string_value", (Object) next.zzc() ? next.zzd() : null);
                        zza(sb, i2, "int_value", (Object) next.zze() ? Long.valueOf(next.zzf()) : null);
                        if (next.zzg()) {
                            d2 = Double.valueOf(next.zzh());
                        }
                        zza(sb, i2, "double_value", (Object) d2);
                        if (next.zzj() > 0) {
                            zza(sb, i2, next.zzi());
                        }
                    }
                    zza(sb, i2);
                    sb.append("}\n");
                }
            }
        }
    }

    static boolean zza(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    static boolean zza(List<Long> list, int i) {
        if (i >= (list.size() << 6)) {
            return false;
        }
        return ((1 << (i % 64)) & list.get(i / 64).longValue()) != 0;
    }

    public final /* bridge */ /* synthetic */ zzn e_() {
        return super.e_();
    }

    /* access modifiers changed from: package-private */
    public final long zza(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        zzp().zzd();
        MessageDigest zzi = zzla.zzi();
        if (zzi != null) {
            return zzla.zza(zzi.digest(bArr));
        }
        zzr().zzf().zza("Failed to get MD5");
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final <T extends Parcelable> T zza(byte[] bArr, Parcelable.Creator<T> creator) {
        if (bArr == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            obtain.unmarshall(bArr, 0, bArr.length);
            obtain.setDataPosition(0);
            return (Parcelable) creator.createFromParcel(obtain);
        } catch (SafeParcelReader.ParseException e2) {
            zzr().zzf().zza("Failed to load parcelable from buffer");
            return null;
        } finally {
            obtain.recycle();
        }
    }

    /* access modifiers changed from: package-private */
    public final String zza(zzbj.zzb zzb) {
        if (zzb == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nevent_filter {\n");
        if (zzb.zza()) {
            zza(sb, 0, "filter_id", (Object) Integer.valueOf(zzb.zzb()));
        }
        zza(sb, 0, "event_name", (Object) zzo().zza(zzb.zzc()));
        String zza = zza(zzb.zzh(), zzb.zzi(), zzb.zzk());
        if (!zza.isEmpty()) {
            zza(sb, 0, "filter_type", (Object) zza);
        }
        if (!zzkz.zzb() || !zzt().zza(zzap.zzcy) || zzb.zzf()) {
            zza(sb, 1, "event_count_filter", zzb.zzg());
        }
        if (!zzkz.zzb() || !zzt().zza(zzap.zzcy) || zzb.zze() > 0) {
            sb.append("  filters {\n");
            for (zzbj.zzc zza2 : zzb.zzd()) {
                zza(sb, 2, zza2);
            }
        }
        zza(sb, 1);
        sb.append("}\n}\n");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final String zza(zzbj.zze zze) {
        if (zze == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nproperty_filter {\n");
        if (zze.zza()) {
            zza(sb, 0, "filter_id", (Object) Integer.valueOf(zze.zzb()));
        }
        zza(sb, 0, "property_name", (Object) zzo().zzc(zze.zzc()));
        String zza = zza(zze.zze(), zze.zzf(), zze.zzh());
        if (!zza.isEmpty()) {
            zza(sb, 0, "filter_type", (Object) zza);
        }
        zza(sb, 1, zze.zzd());
        sb.append("}\n");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final String zza(zzbr.zzf zzf) {
        if (zzf == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        for (zzbr.zzg next : zzf.zza()) {
            if (next != null) {
                zza(sb, 1);
                sb.append("bundle {\n");
                if (next.zza()) {
                    zza(sb, 1, "protocol_version", (Object) Integer.valueOf(next.zzb()));
                }
                zza(sb, 1, "platform", (Object) next.zzq());
                if (next.zzz()) {
                    zza(sb, 1, "gmp_version", (Object) Long.valueOf(next.zzaa()));
                }
                if (next.zzab()) {
                    zza(sb, 1, "uploading_gmp_version", (Object) Long.valueOf(next.zzac()));
                }
                if (next.zzbc()) {
                    zza(sb, 1, "dynamite_version", (Object) Long.valueOf(next.zzbd()));
                }
                if (next.zzau()) {
                    zza(sb, 1, C0161d.al, (Object) Long.valueOf(next.zzav()));
                }
                zza(sb, 1, "gmp_app_id", (Object) next.zzam());
                zza(sb, 1, "admob_app_id", (Object) next.zzbb());
                zza(sb, 1, "app_id", (Object) next.zzx());
                zza(sb, 1, "app_version", (Object) next.zzy());
                if (next.zzar()) {
                    zza(sb, 1, "app_version_major", (Object) Integer.valueOf(next.zzas()));
                }
                zza(sb, 1, "firebase_instance_id", (Object) next.zzaq());
                if (next.zzah()) {
                    zza(sb, 1, "dev_cert_hash", (Object) Long.valueOf(next.zzai()));
                }
                zza(sb, 1, "app_store", (Object) next.zzw());
                if (next.zzg()) {
                    zza(sb, 1, "upload_timestamp_millis", (Object) Long.valueOf(next.zzh()));
                }
                if (next.zzi()) {
                    zza(sb, 1, "start_timestamp_millis", (Object) Long.valueOf(next.zzj()));
                }
                if (next.zzk()) {
                    zza(sb, 1, "end_timestamp_millis", (Object) Long.valueOf(next.zzl()));
                }
                if (next.zzm()) {
                    zza(sb, 1, "previous_bundle_start_timestamp_millis", (Object) Long.valueOf(next.zzn()));
                }
                if (next.zzo()) {
                    zza(sb, 1, "previous_bundle_end_timestamp_millis", (Object) Long.valueOf(next.zzp()));
                }
                zza(sb, 1, "app_instance_id", (Object) next.zzag());
                zza(sb, 1, "resettable_device_id", (Object) next.zzad());
                zza(sb, 1, "device_id", (Object) next.zzat());
                zza(sb, 1, "ds_id", (Object) next.zzay());
                if (next.zzae()) {
                    zza(sb, 1, "limited_ad_tracking", (Object) Boolean.valueOf(next.zzaf()));
                }
                zza(sb, 1, "os_version", (Object) next.zzr());
                zza(sb, 1, "device_model", (Object) next.zzs());
                zza(sb, 1, "user_default_language", (Object) next.zzt());
                if (next.zzu()) {
                    zza(sb, 1, "time_zone_offset_minutes", (Object) Integer.valueOf(next.zzv()));
                }
                if (next.zzaj()) {
                    zza(sb, 1, "bundle_sequential_index", (Object) Integer.valueOf(next.zzak()));
                }
                if (next.zzan()) {
                    zza(sb, 1, "service_upload", (Object) Boolean.valueOf(next.zzao()));
                }
                zza(sb, 1, "health_monitor", (Object) next.zzal());
                if (!zzt().zza(zzap.zzdh) && next.zzaw() && next.zzax() != 0) {
                    zza(sb, 1, "android_id", (Object) Long.valueOf(next.zzax()));
                }
                if (next.zzaz()) {
                    zza(sb, 1, "retry_counter", (Object) Integer.valueOf(next.zzba()));
                }
                List<zzbr.zzk> zze = next.zze();
                if (zze != null) {
                    for (zzbr.zzk next2 : zze) {
                        if (next2 != null) {
                            zza(sb, 2);
                            sb.append("user_property {\n");
                            Double d2 = null;
                            zza(sb, 2, "set_timestamp_millis", (Object) next2.zza() ? Long.valueOf(next2.zzb()) : null);
                            zza(sb, 2, AppMeasurementSdk.ConditionalUserProperty.NAME, (Object) zzo().zzc(next2.zzc()));
                            zza(sb, 2, "string_value", (Object) next2.zze());
                            zza(sb, 2, "int_value", (Object) next2.zzf() ? Long.valueOf(next2.zzg()) : null);
                            if (next2.zzh()) {
                                d2 = Double.valueOf(next2.zzi());
                            }
                            zza(sb, 2, "double_value", (Object) d2);
                            zza(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<zzbr.zza> zzap = next.zzap();
                String zzx = next.zzx();
                if (zzap != null) {
                    for (zzbr.zza next3 : zzap) {
                        if (next3 != null) {
                            zza(sb, 2);
                            sb.append("audience_membership {\n");
                            if (next3.zza()) {
                                zza(sb, 2, "audience_id", (Object) Integer.valueOf(next3.zzb()));
                            }
                            if (next3.zzf()) {
                                zza(sb, 2, "new_audience", (Object) Boolean.valueOf(next3.zzg()));
                            }
                            zza(sb, 2, "current_data", next3.zzc(), zzx);
                            if (!zzkz.zzb() || !zzt().zza(zzap.zzcy) || next3.zzd()) {
                                zza(sb, 2, "previous_data", next3.zze(), zzx);
                            }
                            zza(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<zzbr.zzc> zzc = next.zzc();
                if (zzc != null) {
                    for (zzbr.zzc next4 : zzc) {
                        if (next4 != null) {
                            zza(sb, 2);
                            sb.append("event {\n");
                            zza(sb, 2, AppMeasurementSdk.ConditionalUserProperty.NAME, (Object) zzo().zza(next4.zzc()));
                            if (next4.zzd()) {
                                zza(sb, 2, "timestamp_millis", (Object) Long.valueOf(next4.zze()));
                            }
                            if (next4.zzf()) {
                                zza(sb, 2, "previous_timestamp_millis", (Object) Long.valueOf(next4.zzg()));
                            }
                            if (next4.zzh()) {
                                zza(sb, 2, "count", (Object) Integer.valueOf(next4.zzi()));
                            }
                            if (next4.zzb() != 0) {
                                zza(sb, 2, next4.zza());
                            }
                            zza(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                zza(sb, 1);
                sb.append("}\n");
            }
        }
        sb.append("}\n");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final List<Long> zza(List<Long> list, List<Integer> list2) {
        ArrayList arrayList = new ArrayList(list);
        for (Integer next : list2) {
            if (next.intValue() < 0) {
                zzr().zzi().zza("Ignoring negative bit index to be cleared", next);
            } else {
                int intValue = next.intValue() / 64;
                if (intValue >= arrayList.size()) {
                    zzr().zzi().zza("Ignoring bit index greater than bitSet size", next, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(intValue, Long.valueOf(((Long) arrayList.get(intValue)).longValue() & (~(1 << (next.intValue() % 64)))));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (size2 >= 0 && ((Long) arrayList.get(size2)).longValue() == 0) {
            size = size2;
            size2--;
        }
        return arrayList.subList(0, size);
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzbr.zzc.zza zza, String str, Object obj) {
        List<zzbr.zze> zza2 = zza.zza();
        int i = 0;
        while (true) {
            if (i >= zza2.size()) {
                i = -1;
                break;
            } else if (str.equals(zza2.get(i).zzb())) {
                break;
            } else {
                i++;
            }
        }
        zzbr.zze.zza zza3 = zzbr.zze.zzk().zza(str);
        if (obj instanceof Long) {
            zza3.zza(((Long) obj).longValue());
        } else if (obj instanceof String) {
            zza3.zzb((String) obj);
        } else if (obj instanceof Double) {
            zza3.zza(((Double) obj).doubleValue());
        } else if (zzju.zzb() && zzt().zza(zzap.zzdb) && (obj instanceof Bundle[])) {
            zza3.zza((Iterable<? extends zzbr.zze>) zza((Bundle[]) obj));
        }
        if (i >= 0) {
            zza.zza(i, zza3);
        } else {
            zza.zza(zza3);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzbr.zze.zza zza, Object obj) {
        Preconditions.checkNotNull(obj);
        zza.zza().zzb().zzc().zze();
        if (obj instanceof String) {
            zza.zzb((String) obj);
        } else if (obj instanceof Long) {
            zza.zza(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            zza.zza(((Double) obj).doubleValue());
        } else if (!zzju.zzb() || !zzt().zza(zzap.zzdb) || !(obj instanceof Bundle[])) {
            zzr().zzf().zza("Ignoring invalid (type) event param value", obj);
        } else {
            zza.zza((Iterable<? extends zzbr.zze>) zza((Bundle[]) obj));
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzbr.zzk.zza zza, Object obj) {
        Preconditions.checkNotNull(obj);
        zza.zza().zzb().zzc();
        if (obj instanceof String) {
            zza.zzb((String) obj);
        } else if (obj instanceof Long) {
            zza.zzb(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            zza.zza(((Double) obj).doubleValue());
        } else {
            zzr().zzf().zza("Ignoring invalid (type) user attribute value", obj);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(zzm().currentTimeMillis() - j) > j2;
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzan zzan, zzm zzm) {
        Preconditions.checkNotNull(zzan);
        Preconditions.checkNotNull(zzm);
        if (zzjo.zzb() && zzt().zza(zzap.zzco)) {
            return !TextUtils.isEmpty(zzm.zzb) || !TextUtils.isEmpty(zzm.zzr);
        }
        if (!TextUtils.isEmpty(zzm.zzb) || !TextUtils.isEmpty(zzm.zzr)) {
            return true;
        }
        zzu();
        return false;
    }

    /* access modifiers changed from: package-private */
    public final Object zzb(zzbr.zzc zzc, String str) {
        zzbr.zze zza = zza(zzc, str);
        if (zza == null) {
            return null;
        }
        if (zza.zzc()) {
            return zza.zzd();
        }
        if (zza.zze()) {
            return Long.valueOf(zza.zzf());
        }
        if (zza.zzg()) {
            return Double.valueOf(zza.zzh());
        }
        if (!zzju.zzb() || !zzt().zza(zzap.zzdb) || zza.zzj() <= 0) {
            return null;
        }
        List<zzbr.zze> zzi = zza.zzi();
        ArrayList arrayList = new ArrayList();
        for (zzbr.zze next : zzi) {
            if (next != null) {
                Bundle bundle = new Bundle();
                for (zzbr.zze next2 : next.zzi()) {
                    if (next2.zzc()) {
                        bundle.putString(next2.zzb(), next2.zzd());
                    } else if (next2.zze()) {
                        bundle.putLong(next2.zzb(), next2.zzf());
                    } else if (next2.zzg()) {
                        bundle.putDouble(next2.zzb(), next2.zzh());
                    }
                }
                if (!bundle.isEmpty()) {
                    arrayList.add(bundle);
                }
            }
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    /* access modifiers changed from: package-private */
    public final byte[] zzb(byte[] bArr) throws IOException {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e2) {
            zzr().zzf().zza("Failed to ungzip content", e2);
            throw e2;
        }
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    /* access modifiers changed from: package-private */
    public final byte[] zzc(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            zzr().zzf().zza("Failed to gzip content", e2);
            throw e2;
        }
    }

    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    /* access modifiers changed from: protected */
    public final boolean zze() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final List<Integer> zzf() {
        Map<String, String> zza = zzap.zza(this.zza.zzn());
        if (zza == null || zza.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int intValue = zzap.zzao.zza(null).intValue();
        Iterator<Map.Entry<String, String>> it = zza.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry next = it.next();
            if (((String) next.getKey()).startsWith("measurement.id.")) {
                try {
                    int parseInt = Integer.parseInt((String) next.getValue());
                    if (parseInt != 0) {
                        arrayList.add(Integer.valueOf(parseInt));
                        if (arrayList.size() >= intValue) {
                            zzr().zzi().zza("Too many experiment IDs. Number of IDs", Integer.valueOf(arrayList.size()));
                            break;
                        }
                    } else {
                        continue;
                    }
                } catch (NumberFormatException e2) {
                    zzr().zzi().zza("Experiment ID NumberFormatException", e2);
                }
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    public final /* bridge */ /* synthetic */ zzkw zzg() {
        return super.zzg();
    }

    public final /* bridge */ /* synthetic */ zzac zzi() {
        return super.zzi();
    }

    public final /* bridge */ /* synthetic */ zzgk zzj() {
        return super.zzj();
    }

    public final /* bridge */ /* synthetic */ zzah zzl() {
        return super.zzl();
    }

    public final /* bridge */ /* synthetic */ Clock zzm() {
        return super.zzm();
    }

    public final /* bridge */ /* synthetic */ Context zzn() {
        return super.zzn();
    }

    public final /* bridge */ /* synthetic */ zzfh zzo() {
        return super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzla zzp() {
        return super.zzp();
    }

    public final /* bridge */ /* synthetic */ zzgj zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ zzfj zzr() {
        return super.zzr();
    }

    public final /* bridge */ /* synthetic */ zzfv zzs() {
        return super.zzs();
    }

    public final /* bridge */ /* synthetic */ zzx zzt() {
        return super.zzt();
    }

    public final /* bridge */ /* synthetic */ zzw zzu() {
        return super.zzu();
    }
}
