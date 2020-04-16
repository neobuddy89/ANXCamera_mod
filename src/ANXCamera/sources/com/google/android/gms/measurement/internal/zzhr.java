package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.android.camera.statistic.MistatsConstants;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.measurement.zzju;
import com.google.android.gms.internal.measurement.zzkb;
import com.google.android.gms.internal.measurement.zzkm;
import com.google.android.gms.internal.measurement.zzky;
import com.google.android.gms.internal.measurement.zzle;
import com.google.android.gms.internal.measurement.zzmv;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
public final class zzhr extends zze {
    protected zzio zza;
    protected boolean zzb = true;
    private zzhq zzc;
    private final Set<zzhp> zzd = new CopyOnWriteArraySet();
    private boolean zze;
    private final AtomicReference<String> zzf = new AtomicReference<>();

    protected zzhr(zzgq zzgq) {
        super(zzgq);
    }

    private final void zza(String str, String str2, long j, Object obj) {
        zzgj zzq = zzq();
        zzhv zzhv = new zzhv(this, str, str2, obj, j);
        zzq.zza((Runnable) zzhv);
    }

    /* access modifiers changed from: private */
    public final void zzam() {
        if (zzt().zza(zzap.zzbe)) {
            zzd();
            String zza2 = zzs().zzn.zza();
            if (zza2 != null) {
                if ("unset".equals(zza2)) {
                    zza("app", "_npa", (Object) null, zzm().currentTimeMillis());
                } else {
                    zza("app", "_npa", (Object) Long.valueOf(MistatsConstants.BaseEvent.VALUE_TRUE.equals(zza2) ? 1 : 0), zzm().currentTimeMillis());
                }
            }
        }
        if (!this.zzx.zzab() || !this.zzb) {
            zzr().zzw().zza("Updating Scion state (FE)");
            zzh().zzac();
            return;
        }
        zzr().zzw().zza("Recording app launch after enabling measurement for the first time (FE)");
        zzai();
        if (zzle.zzb() && zzt().zza(zzap.zzcr)) {
            zzk().zza.zza();
        }
        if (zzkm.zzb() && zzt().zza(zzap.zzcw)) {
            if (!(this.zzx.zzf().zza.zzc().zzi.zza() > 0)) {
                this.zzx.zzf().zza();
            }
        }
    }

    private final ArrayList<Bundle> zzb(String str, String str2, String str3) {
        if (zzq().zzg()) {
            zzr().zzf().zza("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList<>(0);
        } else if (zzw.zza()) {
            zzr().zzf().zza("Cannot get conditional user properties from main thread");
            return new ArrayList<>(0);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            zzgj zzq = this.zzx.zzq();
            zzie zzie = new zzie(this, atomicReference, str, str2, str3);
            zzq.zza(atomicReference, 5000, "get conditional user properties", zzie);
            List list = (List) atomicReference.get();
            if (list != null) {
                return zzla.zzb((List<zzv>) list);
            }
            zzr().zzf().zza("Timed out waiting for get conditional user properties", str);
            return new ArrayList<>();
        }
    }

    private final Map<String, Object> zzb(String str, String str2, String str3, boolean z) {
        if (zzq().zzg()) {
            zzr().zzf().zza("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        } else if (zzw.zza()) {
            zzr().zzf().zza("Cannot get user properties from main thread");
            return Collections.emptyMap();
        } else {
            AtomicReference atomicReference = new AtomicReference();
            zzgj zzq = this.zzx.zzq();
            zzig zzig = new zzig(this, atomicReference, str, str2, str3, z);
            zzq.zza(atomicReference, 5000, "get user properties", zzig);
            List<zzkz> list = (List) atomicReference.get();
            if (list == null) {
                zzr().zzf().zza("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z));
                return Collections.emptyMap();
            }
            ArrayMap arrayMap = new ArrayMap(list.size());
            for (zzkz zzkz : list) {
                arrayMap.put(zzkz.zza, zzkz.zza());
            }
            return arrayMap;
        }
    }

    private final void zzb(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        zzhm.zza(bundle, "app_id", String.class, null);
        zzhm.zza(bundle, "origin", String.class, null);
        zzhm.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.NAME, String.class, null);
        zzhm.zza(bundle, "value", Object.class, null);
        zzhm.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, String.class, null);
        zzhm.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.class, 0L);
        zzhm.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, null);
        zzhm.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
        zzhm.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, null);
        zzhm.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
        zzhm.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.class, 0L);
        zzhm.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, null);
        zzhm.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
        Preconditions.checkNotEmpty(bundle.getString(AppMeasurementSdk.ConditionalUserProperty.NAME));
        Preconditions.checkNotEmpty(bundle.getString("origin"));
        Preconditions.checkNotNull(bundle.get("value"));
        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, j);
        String string = bundle.getString(AppMeasurementSdk.ConditionalUserProperty.NAME);
        Object obj = bundle.get("value");
        if (zzp().zzc(string) != 0) {
            zzr().zzf().zza("Invalid conditional user property name", zzo().zzc(string));
        } else if (zzp().zzb(string, obj) != 0) {
            zzr().zzf().zza("Invalid conditional user property value", zzo().zzc(string), obj);
        } else {
            Object zzc2 = zzp().zzc(string, obj);
            if (zzc2 == null) {
                zzr().zzf().zza("Unable to normalize conditional user property value", zzo().zzc(string), obj);
                return;
            }
            zzhm.zza(bundle, zzc2);
            long j2 = bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT);
            if (TextUtils.isEmpty(bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME)) || (j2 <= 15552000000L && j2 >= 1)) {
                long j3 = bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE);
                if (j3 > 15552000000L || j3 < 1) {
                    zzr().zzf().zza("Invalid conditional user property time to live", zzo().zzc(string), Long.valueOf(j3));
                } else {
                    zzq().zza((Runnable) new zzic(this, bundle));
                }
            } else {
                zzr().zzf().zza("Invalid conditional user property timeout", zzo().zzc(string), Long.valueOf(j2));
            }
        }
    }

    private final void zzb(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        Bundle zzb2 = zzla.zzb(bundle);
        zzgj zzq = zzq();
        zzhw zzhw = new zzhw(this, str, str2, j, zzb2, z, z2, z3, str3);
        zzq.zza((Runnable) zzhw);
    }

    private final void zzb(String str, String str2, String str3, Bundle bundle) {
        long currentTimeMillis = zzm().currentTimeMillis();
        Preconditions.checkNotEmpty(str2);
        Bundle bundle2 = new Bundle();
        if (str != null) {
            bundle2.putString("app_id", str);
        }
        bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.NAME, str2);
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, currentTimeMillis);
        if (str3 != null) {
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str3);
            bundle2.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle);
        }
        zzq().zza((Runnable) new zzib(this, bundle2));
    }

    /* access modifiers changed from: private */
    public final void zzc(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzd();
        zzw();
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME));
        Preconditions.checkNotEmpty(bundle2.getString("origin"));
        Preconditions.checkNotNull(bundle2.get("value"));
        if (!this.zzx.zzab()) {
            zzr().zzx().zza("Conditional property not set since app measurement is disabled");
            return;
        }
        zzkz zzkz = new zzkz(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME), bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP), bundle2.get("value"), bundle2.getString("origin"));
        try {
            zzan zza2 = zzp().zza(bundle2.getString("app_id"), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME), bundle2.getBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS), bundle2.getString("origin"), 0, true, false);
            zzv zzv = new zzv(bundle2.getString("app_id"), bundle2.getString("origin"), zzkz, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), false, bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), zzp().zza(bundle2.getString("app_id"), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME), bundle2.getBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS), bundle2.getString("origin"), 0, true, false), bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), zza2, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zzp().zza(bundle2.getString("app_id"), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle2.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), bundle2.getString("origin"), 0, true, false));
            zzh().zza(zzv);
        } catch (IllegalArgumentException e2) {
        }
    }

    /* access modifiers changed from: private */
    public final void zzd(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzd();
        zzw();
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME));
        if (!this.zzx.zzab()) {
            zzr().zzx().zza("Conditional property not cleared since app measurement is disabled");
            return;
        }
        zzkz zzkz = new zzkz(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME), 0, (Object) null, (String) null);
        try {
            zzan zza2 = zzp().zza(bundle2.getString("app_id"), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle2.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), bundle2.getString("origin"), bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), true, false);
            zzkz zzkz2 = zzkz;
            zzv zzv = new zzv(bundle2.getString("app_id"), bundle2.getString("origin"), zzkz2, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), bundle2.getBoolean(AppMeasurementSdk.ConditionalUserProperty.ACTIVE), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), (zzan) null, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), (zzan) null, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zza2);
            zzh().zza(zzv);
        } catch (IllegalArgumentException e2) {
        }
    }

    /* access modifiers changed from: private */
    public final void zzd(boolean z) {
        zzd();
        zzb();
        zzw();
        zzr().zzw().zza("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        zzs().zzb(z);
        zzam();
    }

    private final String zze(long j) {
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            zzq().zza((Runnable) new zzhx(this, atomicReference));
            try {
                atomicReference.wait(j);
            } catch (InterruptedException e2) {
                zzr().zzi().zza("Interrupted waiting for app instance id");
                return null;
            }
        }
        return (String) atomicReference.get();
    }

    public final ArrayList<Bundle> zza(String str, String str2) {
        zzb();
        return zzb((String) null, str, str2);
    }

    public final ArrayList<Bundle> zza(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zza();
        return zzb(str, str2, str3);
    }

    public final Map<String, Object> zza(String str, String str2, String str3, boolean z) {
        Preconditions.checkNotEmpty(str);
        zza();
        return zzb(str, str2, str3, z);
    }

    public final Map<String, Object> zza(String str, String str2, boolean z) {
        zzb();
        return zzb((String) null, str, str2, z);
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    public final void zza(long j) {
        zzb();
        zzq().zza((Runnable) new zzim(this, j));
    }

    public final void zza(Bundle bundle) {
        zza(bundle, zzm().currentTimeMillis());
    }

    public final void zza(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        zzb();
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            zzr().zzi().zza("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        zzb(bundle2, j);
    }

    public final void zza(zzhp zzhp) {
        zzb();
        zzw();
        Preconditions.checkNotNull(zzhp);
        if (!this.zzd.add(zzhp)) {
            zzr().zzi().zza("OnEventListener already registered");
        }
    }

    public final void zza(zzhq zzhq) {
        zzd();
        zzb();
        zzw();
        if (zzhq != null) {
            zzhq zzhq2 = this.zzc;
            if (zzhq != zzhq2) {
                Preconditions.checkState(zzhq2 == null, "EventInterceptor already set.");
            }
        }
        this.zzc = zzhq;
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str) {
        this.zzf.set(str);
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str, String str2, long j, Bundle bundle) {
        zzb();
        zzd();
        zza(str, str2, j, bundle, true, this.zzc == null || zzla.zze(str2), false, (String) null);
    }

    /* access modifiers changed from: protected */
    public final void zza(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        String str4;
        boolean z4;
        String str5;
        boolean z5;
        String str6;
        ArrayList arrayList;
        boolean z6;
        String str7;
        zziv zziv;
        int i;
        long j2;
        ArrayList arrayList2;
        Bundle bundle2;
        boolean z7;
        String str8 = str;
        String str9 = str2;
        long j3 = j;
        Bundle bundle3 = bundle;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(bundle);
        zzd();
        zzw();
        if (!this.zzx.zzab()) {
            zzr().zzw().zza("Event not sent since app measurement is disabled");
            return;
        }
        if (zzt().zza(zzap.zzbl)) {
            List<String> zzah = zzg().zzah();
            if (zzah != null && !zzah.contains(str9)) {
                zzr().zzw().zza("Dropping non-safelisted event. event name, origin", str9, str8);
                return;
            }
        }
        int i2 = 0;
        if (!this.zze) {
            this.zze = true;
            try {
                try {
                    (!this.zzx.zzt() ? Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, zzn().getClassLoader()) : Class.forName("com.google.android.gms.tagmanager.TagManagerService")).getDeclaredMethod("initialize", new Class[]{Context.class}).invoke((Object) null, new Object[]{zzn()});
                } catch (Exception e2) {
                    zzr().zzi().zza("Failed to invoke Tag Manager's initialize() method", e2);
                }
            } catch (ClassNotFoundException e3) {
                zzr().zzv().zza("Tag Manager is not found and thus will not be used");
            }
        }
        if (zzt().zza(zzap.zzca) && "_cmp".equals(str9) && bundle3.containsKey("gclid")) {
            zza("auto", "_lgclid", (Object) bundle3.getString("gclid"), zzm().currentTimeMillis());
        }
        if (z3) {
            zzu();
            if (!"_iap".equals(str9)) {
                zzla zzi = this.zzx.zzi();
                int i3 = 2;
                if (zzi.zza("event", str9)) {
                    if (!zzi.zza("event", zzhl.zza, str9)) {
                        i3 = 13;
                    } else if (zzi.zza("event", 40, str9)) {
                        i3 = 0;
                    }
                }
                if (i3 != 0) {
                    zzr().zzh().zza("Invalid public event name. Event will not be logged (FE)", zzo().zza(str9));
                    this.zzx.zzi();
                    String zza2 = zzla.zza(str9, 40, true);
                    if (str9 != null) {
                        i2 = str2.length();
                    }
                    this.zzx.zzi().zza(i3, "_ev", zza2, i2);
                    return;
                }
            }
        }
        zzu();
        zziv zzab = zzi().zzab();
        if (zzab != null && !bundle3.containsKey("_sc")) {
            zzab.zzd = true;
        }
        zziy.zza(zzab, bundle3, z && z3);
        boolean equals = "am".equals(str8);
        boolean zze2 = zzla.zze(str2);
        if (z && this.zzc != null && !zze2 && !equals) {
            zzr().zzw().zza("Passing event to registered event handler (FE)", zzo().zza(str9), zzo().zza(bundle3));
            this.zzc.interceptEvent(str, str2, bundle, j);
        } else if (this.zzx.zzah()) {
            int zzb2 = zzp().zzb(str9);
            if (zzb2 != 0) {
                zzr().zzh().zza("Invalid event name. Event will not be logged (FE)", zzo().zza(str9));
                zzp();
                String zza3 = zzla.zza(str9, 40, true);
                if (str9 != null) {
                    i2 = str2.length();
                }
                this.zzx.zzi().zza(str3, zzb2, "_ev", zza3, i2);
                return;
            }
            List listOf = CollectionUtils.listOf((T[]) new String[]{"_o", "_sn", "_sc", "_si"});
            String str10 = str9;
            Bundle zza4 = zzp().zza(str3, str2, bundle, (List<String>) listOf, z3, true);
            zziv zziv2 = (zza4 == null || !zza4.containsKey("_sc") || !zza4.containsKey("_si")) ? null : new zziv(zza4.getString("_sn"), zza4.getString("_sc"), Long.valueOf(zza4.getLong("_si")).longValue());
            zziv zziv3 = zziv2 == null ? zzab : zziv2;
            String str11 = "_ae";
            if (zzt().zza(zzap.zzbb)) {
                zzu();
                if (zzi().zzab() != null && str11.equals(str10)) {
                    long zzb3 = zzk().zzb.zzb();
                    if (zzb3 > 0) {
                        zzp().zza(zza4, zzb3);
                    }
                }
            }
            if (zzkb.zzb() && zzt().zza(zzap.zzcq)) {
                if (!"auto".equals(str8) && "_ssr".equals(str10)) {
                    zzla zzp = zzp();
                    String string = zza4.getString("_ffr");
                    String trim = Strings.isEmptyOrWhitespace(string) ? null : string.trim();
                    if (zzla.zzc(trim, zzp.zzs().zzw.zza())) {
                        zzp.zzr().zzw().zza("Not logging duplicate session_start_with_rollout event");
                        z7 = false;
                    } else {
                        zzp.zzs().zzw.zza(trim);
                        z7 = true;
                    }
                    if (!z7) {
                        return;
                    }
                } else if (str11.equals(str10)) {
                    String zza5 = zzp().zzs().zzw.zza();
                    if (!TextUtils.isEmpty(zza5)) {
                        zza4.putString("_ffr", zza5);
                    }
                }
            }
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(zza4);
            long nextLong = zzp().zzh().nextLong();
            if (!zzt().zza(zzap.zzav)) {
                str4 = "_o";
            } else if (zzs().zzq.zza() <= 0) {
                str4 = "_o";
            } else if (!zzs().zza(j)) {
                str4 = "_o";
            } else if (zzs().zzt.zza()) {
                zzr().zzx().zza("Current session is expired, remove the session number, ID, and engagement time");
                if (zzt().zza(zzap.zzas)) {
                    str4 = "_o";
                    zza("auto", "_sid", (Object) null, zzm().currentTimeMillis());
                } else {
                    str4 = "_o";
                }
                if (zzt().zza(zzap.zzat)) {
                    zza("auto", "_sno", (Object) null, zzm().currentTimeMillis());
                }
                if (zzmv.zzb() && zzt().zza(zzap.zzbq)) {
                    zza("auto", "_se", (Object) null, zzm().currentTimeMillis());
                }
            } else {
                str4 = "_o";
            }
            if (!zzt().zza(zzap.zzau)) {
                z4 = true;
                long j4 = j;
                str5 = str10;
            } else if (zza4.getLong(FirebaseAnalytics.Param.EXTEND_SESSION, 0) == 1) {
                zzr().zzx().zza("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                str5 = str10;
                z4 = true;
                this.zzx.zze().zza.zza(j, true);
            } else {
                z4 = true;
                long j5 = j;
                str5 = str10;
            }
            String[] strArr = (String[]) zza4.keySet().toArray(new String[zza4.size()]);
            Arrays.sort(strArr);
            if (!zzju.zzb() || !zzt().zza(zzap.zzdc) || !zzt().zza(zzap.zzdb)) {
                int length = strArr.length;
                int i4 = 0;
                int i5 = 0;
                while (i5 < length) {
                    int i6 = length;
                    String str12 = strArr[i5];
                    Object obj = zza4.get(str12);
                    zzp();
                    String[] strArr2 = strArr;
                    Bundle[] zza6 = zzla.zza(obj);
                    if (zza6 != null) {
                        zza4.putInt(str12, zza6.length);
                        int i7 = 0;
                        while (i7 < zza6.length) {
                            Bundle bundle4 = zza6[i7];
                            zziy.zza(zziv3, bundle4, true);
                            int i8 = i4;
                            long j6 = nextLong;
                            Bundle bundle5 = bundle4;
                            ArrayList arrayList4 = arrayList3;
                            Bundle zza7 = zzp().zza(str3, "_ep", bundle5, (List<String>) listOf, z3, false);
                            zza7.putString("_en", str5);
                            zza7.putLong("_eid", j6);
                            zza7.putString("_gn", str12);
                            zza7.putInt("_ll", zza6.length);
                            zza7.putInt("_i", i7);
                            arrayList4.add(zza7);
                            i7++;
                            zza4 = zza4;
                            arrayList3 = arrayList4;
                            nextLong = j6;
                            i5 = i5;
                            zziv3 = zziv3;
                            str11 = str11;
                            i4 = i8;
                            String str13 = str;
                        }
                        zziv = zziv3;
                        i = i5;
                        j2 = nextLong;
                        arrayList2 = arrayList3;
                        str7 = str11;
                        bundle2 = zza4;
                        z6 = true;
                        i4 += zza6.length;
                    } else {
                        zziv = zziv3;
                        int i9 = i4;
                        i = i5;
                        j2 = nextLong;
                        arrayList2 = arrayList3;
                        str7 = str11;
                        bundle2 = zza4;
                        z6 = true;
                    }
                    i5 = i + 1;
                    strArr = strArr2;
                    zza4 = bundle2;
                    arrayList3 = arrayList2;
                    nextLong = j2;
                    length = i6;
                    zziv3 = zziv;
                    str11 = str7;
                    boolean z8 = z6;
                    String str14 = str;
                    long j7 = j;
                }
                int i10 = i4;
                long j8 = nextLong;
                arrayList = arrayList3;
                str6 = str11;
                Bundle bundle6 = zza4;
                z5 = true;
                if (i10 != 0) {
                    bundle6.putLong("_eid", j8);
                    bundle6.putInt("_epc", i10);
                }
            } else {
                for (String str15 : strArr) {
                    zzp();
                    Bundle[] zza8 = zzla.zza(zza4.get(str15));
                    if (zza8 != null) {
                        zza4.putParcelableArray(str15, zza8);
                    }
                }
                z5 = z4;
                arrayList = arrayList3;
                str6 = str11;
            }
            int i11 = 0;
            while (i11 < arrayList.size()) {
                Bundle bundle7 = (Bundle) arrayList.get(i11);
                String str16 = i11 != 0 ? z5 : false ? "_ep" : str5;
                String str17 = str4;
                bundle7.putString(str17, str);
                Bundle zza9 = z2 ? zzp().zza(bundle7) : bundle7;
                if (!zzky.zzb() || !zzt().zza(zzap.zzcx)) {
                    zzr().zzw().zza("Logging event (FE)", zzo().zza(str5), zzo().zza(zza9));
                }
                ArrayList arrayList5 = arrayList;
                String str18 = str5;
                boolean z9 = z5;
                zzan zzan = new zzan(str16, new zzam(zza9), str, j);
                zzh().zza(zzan, str3);
                if (!equals) {
                    for (zzhp onEvent : this.zzd) {
                        onEvent.onEvent(str, str2, new Bundle(zza9), j);
                    }
                }
                i11++;
                str4 = str17;
                arrayList = arrayList5;
                str5 = str18;
                z5 = z9;
            }
            String str19 = str5;
            boolean z10 = z5;
            zzu();
            if (zzi().zzab() != null && str6.equals(str19)) {
                zzk().zza(z10, z10, zzm().elapsedRealtime());
            }
        }
    }

    public final void zza(String str, String str2, Bundle bundle) {
        zza(str, str2, bundle, true, true, zzm().currentTimeMillis());
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z) {
        zza(str, str2, bundle, false, true, zzm().currentTimeMillis());
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        boolean z3;
        zzb();
        String str3 = str == null ? "app" : str;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        if (z2) {
            if (this.zzc != null && !zzla.zze(str2)) {
                z3 = false;
                zzb(str3, str2, j, bundle2, z2, z3, !z, (String) null);
            }
        }
        z3 = true;
        zzb(str3, str2, j, bundle2, z2, z3, !z, (String) null);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008d  */
    public final void zza(String str, String str2, Object obj, long j) {
        Long l;
        String str3;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzd();
        zzb();
        zzw();
        if (zzt().zza(zzap.zzbe) && FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS.equals(str2)) {
            if (obj instanceof String) {
                String str4 = (String) obj;
                if (!TextUtils.isEmpty(str4)) {
                    String lowerCase = str4.toLowerCase(Locale.ENGLISH);
                    String str5 = MistatsConstants.BaseEvent.VALUE_FALSE;
                    Long valueOf = Long.valueOf(str5.equals(lowerCase) ? 1 : 0);
                    zzgc zzgc = zzs().zzn;
                    if (valueOf.longValue() == 1) {
                        str5 = MistatsConstants.BaseEvent.VALUE_TRUE;
                    }
                    zzgc.zza(str5);
                    l = valueOf;
                    str3 = "_npa";
                    if (!this.zzx.zzab()) {
                        zzr().zzx().zza("User property not set since app measurement is disabled");
                        return;
                    } else if (this.zzx.zzah()) {
                        zzkz zzkz = new zzkz(str3, j, l, str);
                        zzh().zza(zzkz);
                        return;
                    } else {
                        return;
                    }
                }
            }
            if (obj == null) {
                zzs().zzn.zza("unset");
                l = obj;
                str3 = "_npa";
                if (!this.zzx.zzab()) {
                }
            }
        }
        str3 = str2;
        l = obj;
        if (!this.zzx.zzab()) {
        }
    }

    public final void zza(String str, String str2, Object obj, boolean z) {
        zza(str, str2, obj, z, zzm().currentTimeMillis());
    }

    public final void zza(String str, String str2, Object obj, boolean z, long j) {
        String str3 = str == null ? "app" : str;
        int i = 6;
        int i2 = 0;
        if (z) {
            i = zzp().zzc(str2);
        } else {
            zzla zzp = zzp();
            if (zzp.zza("user property", str2)) {
                if (!zzp.zza("user property", zzhn.zza, str2)) {
                    i = 15;
                } else if (zzp.zza("user property", 24, str2)) {
                    i = 0;
                }
            }
        }
        if (i != 0) {
            zzp();
            String zza2 = zzla.zza(str2, 24, true);
            if (str2 != null) {
                i2 = str2.length();
            }
            this.zzx.zzi().zza(i, "_ev", zza2, i2);
        } else if (obj != null) {
            int zzb2 = zzp().zzb(str2, obj);
            if (zzb2 != 0) {
                zzp();
                String zza3 = zzla.zza(str2, 24, true);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    i2 = String.valueOf(obj).length();
                }
                this.zzx.zzi().zza(zzb2, "_ev", zza3, i2);
                return;
            }
            Object zzc2 = zzp().zzc(str2, obj);
            if (zzc2 != null) {
                zza(str3, str2, j, zzc2);
            }
        } else {
            zza(str3, str2, j, (Object) null);
        }
    }

    public final void zza(String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotEmpty(str);
        zza();
        zzb(str, str2, str3, bundle);
    }

    public final void zza(boolean z) {
        zzw();
        zzb();
        zzq().zza((Runnable) new zzik(this, z));
    }

    public final void zzab() {
        if (zzn().getApplicationContext() instanceof Application) {
            ((Application) zzn().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zza);
        }
    }

    public final Boolean zzac() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) zzq().zza(atomicReference, 15000, "boolean test flag value", new zzht(this, atomicReference));
    }

    public final String zzad() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) zzq().zza(atomicReference, 15000, "String test flag value", new zzid(this, atomicReference));
    }

    public final Long zzae() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) zzq().zza(atomicReference, 15000, "long test flag value", new zzif(this, atomicReference));
    }

    public final Integer zzaf() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) zzq().zza(atomicReference, 15000, "int test flag value", new zzii(this, atomicReference));
    }

    public final Double zzag() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) zzq().zza(atomicReference, 15000, "double test flag value", new zzih(this, atomicReference));
    }

    public final String zzah() {
        zzb();
        return this.zzf.get();
    }

    public final void zzai() {
        zzd();
        zzb();
        zzw();
        if (this.zzx.zzah()) {
            if (zzt().zza(zzap.zzby)) {
                zzx zzt = zzt();
                zzt.zzu();
                Boolean zzd2 = zzt.zzd("google_analytics_deferred_deep_link_enabled");
                if (zzd2 != null && zzd2.booleanValue()) {
                    zzr().zzw().zza("Deferred Deep Link feature enabled.");
                    zzq().zza((Runnable) new zzhu(this));
                }
            }
            zzh().zzae();
            this.zzb = false;
            String zzw = zzs().zzw();
            if (!TextUtils.isEmpty(zzw)) {
                zzl().zzaa();
                if (!zzw.equals(Build.VERSION.RELEASE)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_po", zzw);
                    zza("auto", "_ou", bundle);
                }
            }
        }
    }

    public final String zzaj() {
        zziv zzac = this.zzx.zzv().zzac();
        if (zzac != null) {
            return zzac.zza;
        }
        return null;
    }

    public final String zzak() {
        zziv zzac = this.zzx.zzv().zzac();
        if (zzac != null) {
            return zzac.zzb;
        }
        return null;
    }

    public final String zzal() {
        if (this.zzx.zzo() != null) {
            return this.zzx.zzo();
        }
        try {
            return GoogleServices.getGoogleAppId();
        } catch (IllegalStateException e2) {
            this.zzx.zzr().zzf().zza("getGoogleAppId failed with exception", e2);
            return null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    public final void zzb(long j) {
        zzb();
        zzq().zza((Runnable) new zzil(this, j));
    }

    public final void zzb(Bundle bundle) {
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle.getString("app_id"));
        zza();
        zzb(new Bundle(bundle), zzm().currentTimeMillis());
    }

    public final void zzb(zzhp zzhp) {
        zzb();
        zzw();
        Preconditions.checkNotNull(zzhp);
        if (!this.zzd.remove(zzhp)) {
            zzr().zzi().zza("OnEventListener had not been registered");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(String str, String str2, Bundle bundle) {
        zzb();
        zzd();
        zza(str, str2, zzm().currentTimeMillis(), bundle);
    }

    public final void zzb(boolean z) {
        zzw();
        zzb();
        zzq().zza((Runnable) new zzij(this, z));
    }

    public final String zzc(long j) {
        if (zzq().zzg()) {
            zzr().zzf().zza("Cannot retrieve app instance id from analytics worker thread");
            return null;
        } else if (zzw.zza()) {
            zzr().zzf().zza("Cannot retrieve app instance id from main thread");
            return null;
        } else {
            long elapsedRealtime = zzm().elapsedRealtime();
            String zze2 = zze(120000);
            long elapsedRealtime2 = zzm().elapsedRealtime() - elapsedRealtime;
            return (zze2 != null || elapsedRealtime2 >= 120000) ? zze2 : zze(120000 - elapsedRealtime2);
        }
    }

    public final List<zzkz> zzc(boolean z) {
        zzb();
        zzw();
        zzr().zzx().zza("Getting user properties (FE)");
        if (zzq().zzg()) {
            zzr().zzf().zza("Cannot get all user properties from analytics worker thread");
            return Collections.emptyList();
        } else if (zzw.zza()) {
            zzr().zzf().zza("Cannot get all user properties from main thread");
            return Collections.emptyList();
        } else {
            AtomicReference atomicReference = new AtomicReference();
            this.zzx.zzq().zza(atomicReference, 5000, "get user properties", new zzhy(this, atomicReference, z));
            List<zzkz> list = (List) atomicReference.get();
            if (list != null) {
                return list;
            }
            zzr().zzf().zza("Timed out waiting for get user properties, includeInternal", Boolean.valueOf(z));
            return Collections.emptyList();
        }
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    public final void zzc(String str, String str2, Bundle bundle) {
        zzb();
        zzb((String) null, str, str2, bundle);
    }

    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    public final void zzd(long j) {
        zza((String) null);
        zzq().zza((Runnable) new zzia(this, j));
    }

    public final /* bridge */ /* synthetic */ zzb zze() {
        return super.zze();
    }

    public final /* bridge */ /* synthetic */ zzhr zzf() {
        return super.zzf();
    }

    public final /* bridge */ /* synthetic */ zzfg zzg() {
        return super.zzg();
    }

    public final /* bridge */ /* synthetic */ zziz zzh() {
        return super.zzh();
    }

    public final /* bridge */ /* synthetic */ zziy zzi() {
        return super.zzi();
    }

    public final /* bridge */ /* synthetic */ zzff zzj() {
        return super.zzj();
    }

    public final /* bridge */ /* synthetic */ zzke zzk() {
        return super.zzk();
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

    /* access modifiers changed from: protected */
    public final boolean zzz() {
        return false;
    }
}
