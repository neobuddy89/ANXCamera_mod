package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzju;
import com.google.android.gms.internal.measurement.zzll;
import com.google.android.gms.internal.measurement.zzn;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
public final class zzla extends zzhk {
    private static final String[] zza = {"firebase_", "google_", "ga_"};
    private SecureRandom zzb;
    private final AtomicLong zzc = new AtomicLong(0);
    private int zzd;
    private Integer zze = null;

    zzla(zzgq zzgq) {
        super(zzgq);
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b7 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b8  */
    private final int zza(String str, String str2, String str3, Object obj, Bundle bundle, List<String> list, boolean z, boolean z2) {
        int i;
        int i2;
        String str4 = str3;
        Object obj2 = obj;
        Bundle bundle2 = bundle;
        zzd();
        boolean z3 = false;
        if (!zzju.zzb() || !zzt().zza(zzap.zzdd)) {
            if (z2 && !zza("param", str4, 1000, obj2)) {
                return 17;
            }
        } else if (zzb(obj)) {
            if (!z2) {
                return 21;
            }
            if (!zza(str4, zzho.zzc)) {
                return 20;
            }
            if (!this.zzx.zzw().zzai()) {
                return 25;
            }
            if (!zza("param", str4, 200, obj2)) {
                if (obj2 instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj2;
                    if (parcelableArr.length > 200) {
                        bundle2.putParcelableArray(str4, (Parcelable[]) Arrays.copyOf(parcelableArr, 200));
                    }
                } else if (obj2 instanceof ArrayList) {
                    ArrayList arrayList = (ArrayList) obj2;
                    if (arrayList.size() > 200) {
                        bundle2.putParcelableArrayList(str4, new ArrayList(arrayList.subList(0, 200)));
                    }
                }
                i = 17;
                if (!zzb("param", str4, ((zzt().zze(str, zzap.zzaq) || !zze(str2)) && !zze(str3)) ? 100 : 256, obj2)) {
                    return i;
                }
                if (!z2) {
                    return 4;
                }
                boolean z4 = zzju.zzb() && zzt().zza(zzap.zzdc);
                if (obj2 instanceof Bundle) {
                    if (z4) {
                        zza(str, str2, str3, (Bundle) obj2, list, z);
                    }
                    z3 = true;
                } else if (obj2 instanceof Parcelable[]) {
                    Parcelable[] parcelableArr2 = (Parcelable[]) obj2;
                    int length = parcelableArr2.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length) {
                            z3 = true;
                            break;
                        }
                        Parcelable parcelable = parcelableArr2[i3];
                        if (!(parcelable instanceof Bundle)) {
                            zzr().zzk().zza("All Parcelable[] elements must be of type Bundle. Value type, name", parcelable.getClass(), str4);
                            break;
                        }
                        if (z4) {
                            i2 = i3;
                            zza(str, str2, str3, (Bundle) parcelable, list, z);
                        } else {
                            i2 = i3;
                        }
                        i3 = i2 + 1;
                    }
                } else if (obj2 instanceof ArrayList) {
                    ArrayList arrayList2 = (ArrayList) obj2;
                    int size = arrayList2.size();
                    int i4 = 0;
                    while (true) {
                        if (i4 >= size) {
                            z3 = true;
                            break;
                        }
                        Object obj3 = arrayList2.get(i4);
                        int i5 = i4 + 1;
                        if (!(obj3 instanceof Bundle)) {
                            zzr().zzk().zza("All ArrayList elements must be of type Bundle. Value type, name", obj3.getClass(), str4);
                            break;
                        }
                        if (z4) {
                            zza(str, str2, str3, (Bundle) obj3, list, z);
                        }
                        i4 = i5;
                    }
                }
                if (z3) {
                    return i;
                }
                return 4;
            }
        }
        i = 0;
        if (!zzb("param", str4, ((zzt().zze(str, zzap.zzaq) || !zze(str2)) && !zze(str3)) ? 100 : 256, obj2)) {
        }
    }

    public static long zza(long j, long j2) {
        return (j + (j2 * 60000)) / 86400000;
    }

    public static long zza(zzam zzam) {
        long j = 0;
        if (zzam == null) {
            return 0;
        }
        Iterator<String> it = zzam.iterator();
        while (it.hasNext()) {
            Object zza2 = zzam.zza(it.next());
            if (zza2 instanceof Parcelable[]) {
                j += (long) ((Parcelable[]) zza2).length;
            }
        }
        return j;
    }

    static long zza(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        int i = 0;
        Preconditions.checkState(bArr.length > 0);
        long j = 0;
        int length = bArr.length - 1;
        while (length >= 0 && length >= bArr.length - 8) {
            j += (((long) bArr[length]) & 255) << i;
            i += 8;
            length--;
        }
        return j;
    }

    public static Bundle zza(List<zzkz> list) {
        Bundle bundle = new Bundle();
        if (list == null) {
            return bundle;
        }
        for (zzkz next : list) {
            if (next.zzd != null) {
                bundle.putString(next.zza, next.zzd);
            } else if (next.zzc != null) {
                bundle.putLong(next.zza, next.zzc.longValue());
            } else if (next.zzf != null) {
                bundle.putDouble(next.zza, next.zzf.doubleValue());
            }
        }
        return bundle;
    }

    private final Object zza(int i, Object obj, boolean z, boolean z2) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf((long) ((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf((long) ((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        } else if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        } else {
            if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
                return zza(String.valueOf(obj), i, z);
            }
            if (!zzju.zzb() || !zzt().zza(zzap.zzdc) || !zzt().zza(zzap.zzdb) || !z2 || (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[]))) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Parcelable parcelable : (Parcelable[]) obj) {
                if (parcelable instanceof Bundle) {
                    Bundle zza2 = zza((Bundle) parcelable);
                    if (zza2 != null && !zza2.isEmpty()) {
                        arrayList.add(zza2);
                    }
                }
            }
            return arrayList.toArray(new Bundle[arrayList.size()]);
        }
    }

    public static String zza(String str, int i, boolean z) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) <= i) {
            return str;
        }
        if (z) {
            return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i))).concat("...");
        }
        return null;
    }

    private static void zza(Bundle bundle, int i, String str, String str2, Object obj) {
        if (zza(bundle, i)) {
            bundle.putString("_ev", zza(str, 40, true));
            if (obj != null) {
                Preconditions.checkNotNull(bundle);
                if (obj == null) {
                    return;
                }
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", (long) String.valueOf(obj).length());
                }
            }
        }
    }

    private final void zza(String str, String str2, String str3, Bundle bundle, List<String> list, boolean z) {
        int i;
        String str4;
        int i2;
        String str5;
        String str6 = str2;
        Bundle bundle2 = bundle;
        List<String> list2 = list;
        if (bundle2 != null) {
            boolean zza2 = zzt().zza(zzap.zzdd);
            int zze2 = zza2 ? 0 : zzt().zze();
            int i3 = 0;
            for (String str7 : new TreeSet(bundle.keySet())) {
                if (list2 == null || !list2.contains(str7)) {
                    i = z ? zzg(str7) : 0;
                    if (i == 0) {
                        i = zzh(str7);
                    }
                } else {
                    i = 0;
                }
                if (i != 0) {
                    zza(bundle2, i, str7, str7, (Object) i == 3 ? str7 : null);
                    bundle2.remove(str7);
                } else {
                    if (zzb(bundle2.get(str7))) {
                        zzr().zzk().zza("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str6, str3, str7);
                        i2 = 22;
                        str4 = str7;
                    } else {
                        String str8 = str3;
                        str4 = str7;
                        i2 = zza(str, str2, str7, bundle2.get(str7), bundle, list, z, false);
                    }
                    if (i2 != 0 && !"_ev".equals(str4)) {
                        zza(bundle2, i2, str4, str4, bundle2.get(str4));
                        bundle2.remove(str4);
                    } else if (zza(str4) && (!zza2 || !zza(str4, zzho.zzd))) {
                        int i4 = i3 + 1;
                        if (i4 > zze2) {
                            if (zza2) {
                                str5 = "Item cannot contain custom parameters";
                            } else {
                                StringBuilder sb = new StringBuilder(63);
                                sb.append("Child bundles can't contain more than ");
                                sb.append(zze2);
                                sb.append(" custom params");
                                str5 = sb.toString();
                            }
                            zzr().zzh().zza(str5, zzo().zza(str6), zzo().zza(bundle2));
                            zza(bundle2, zza2 ? 23 : 5);
                            bundle2.remove(str4);
                            i3 = i4;
                        } else {
                            i3 = i4;
                        }
                    }
                }
            }
        }
    }

    static boolean zza(Context context, boolean z) {
        Preconditions.checkNotNull(context);
        return Build.VERSION.SDK_INT >= 24 ? zzb(context, "com.google.android.gms.measurement.AppMeasurementJobService") : zzb(context, "com.google.android.gms.measurement.AppMeasurementService");
    }

    static boolean zza(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        return "android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra);
    }

    static boolean zza(Bundle bundle, int i) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", (long) i);
        return true;
    }

    static boolean zza(Boolean bool, Boolean bool2) {
        if (bool == null && bool2 == null) {
            return true;
        }
        if (bool == null) {
            return false;
        }
        return bool.equals(bool2);
    }

    static boolean zza(String str) {
        Preconditions.checkNotEmpty(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    private final boolean zza(String str, String str2, int i, Object obj) {
        int i2;
        if (obj instanceof Parcelable[]) {
            i2 = ((Parcelable[]) obj).length;
        } else if (!(obj instanceof ArrayList)) {
            return true;
        } else {
            i2 = ((ArrayList) obj).size();
        }
        if (i2 <= i) {
            return true;
        }
        zzr().zzk().zza("Parameter array is too long; discarded. Value kind, name, array length", str, str2, Integer.valueOf(i2));
        return false;
    }

    static boolean zza(String str, String str2, String str3, String str4) {
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        if (!isEmpty && !isEmpty2) {
            return !str.equals(str2);
        }
        if (isEmpty && isEmpty2) {
            return (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) ? !TextUtils.isEmpty(str4) : !str3.equals(str4);
        }
        if (isEmpty || !isEmpty2) {
            return TextUtils.isEmpty(str3) || !str3.equals(str4);
        }
        if (TextUtils.isEmpty(str4)) {
            return false;
        }
        return TextUtils.isEmpty(str3) || !str3.equals(str4);
    }

    private static boolean zza(String str, String[] strArr) {
        Preconditions.checkNotNull(strArr);
        for (String zzc2 : strArr) {
            if (zzc(str, zzc2)) {
                return true;
            }
        }
        return false;
    }

    static boolean zza(List<String> list, List<String> list2) {
        if (list == null && list2 == null) {
            return true;
        }
        if (list == null) {
            return false;
        }
        return list.equals(list2);
    }

    static byte[] zza(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }

    static Bundle[] zza(Object obj) {
        if (obj instanceof Bundle) {
            return new Bundle[]{(Bundle) obj};
        } else if (obj instanceof Parcelable[]) {
            Parcelable[] parcelableArr = (Parcelable[]) obj;
            return (Bundle[]) Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
        } else if (!(obj instanceof ArrayList)) {
            return null;
        } else {
            ArrayList arrayList = (ArrayList) obj;
            return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
        }
    }

    public static Bundle zzb(Bundle bundle) {
        if (bundle == null) {
            return new Bundle();
        }
        Bundle bundle2 = new Bundle(bundle);
        for (String str : bundle2.keySet()) {
            Object obj = bundle2.get(str);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str, new Bundle((Bundle) obj));
            } else {
                int i = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i < parcelableArr.length) {
                        if (parcelableArr[i] instanceof Bundle) {
                            parcelableArr[i] = new Bundle((Bundle) parcelableArr[i]);
                        }
                        i++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i < list.size()) {
                        Object obj2 = list.get(i);
                        if (obj2 instanceof Bundle) {
                            list.set(i, new Bundle((Bundle) obj2));
                        }
                        i++;
                    }
                }
            }
        }
        return bundle2;
    }

    public static ArrayList<Bundle> zzb(List<zzv> list) {
        if (list == null) {
            return new ArrayList<>(0);
        }
        ArrayList<Bundle> arrayList = new ArrayList<>(list.size());
        for (zzv next : list) {
            Bundle bundle = new Bundle();
            bundle.putString("app_id", next.zza);
            bundle.putString("origin", next.zzb);
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, next.zzd);
            bundle.putString(AppMeasurementSdk.ConditionalUserProperty.NAME, next.zzc.zza);
            zzhm.zza(bundle, next.zzc.zza());
            bundle.putBoolean(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, next.zze);
            if (next.zzf != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, next.zzf);
            }
            if (next.zzg != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, next.zzg.zza);
                if (next.zzg.zzb != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, next.zzg.zzb.zzb());
                }
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, next.zzh);
            if (next.zzi != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, next.zzi.zza);
                if (next.zzi.zzb != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, next.zzi.zzb.zzb());
                }
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, next.zzc.zzb);
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, next.zzj);
            if (next.zzk != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, next.zzk.zza);
                if (next.zzk.zzb != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, next.zzk.zzb.zzb());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    private static boolean zzb(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0);
            return serviceInfo != null && serviceInfo.enabled;
        } catch (PackageManager.NameNotFoundException e2) {
        }
    }

    private static boolean zzb(Object obj) {
        return (obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle);
    }

    private final boolean zzb(String str, String str2, int i, Object obj) {
        if (obj == null || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Boolean) || (obj instanceof Double)) {
            return true;
        }
        if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
            return false;
        }
        String valueOf = String.valueOf(obj);
        if (valueOf.codePointCount(0, valueOf.length()) <= i) {
            return true;
        }
        zzr().zzk().zza("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(valueOf.length()));
        return false;
    }

    private final boolean zzc(Context context, String str) {
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 64);
            if (packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (CertificateException e2) {
            zzr().zzf().zza("Error obtaining certificate", e2);
            return true;
        } catch (PackageManager.NameNotFoundException e3) {
            zzr().zzf().zza("Package name not found", e3);
            return true;
        }
    }

    static boolean zzc(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null) {
            return false;
        }
        return str.equals(str2);
    }

    static boolean zze(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    private final int zzg(String str) {
        if (!zza("event param", str)) {
            return 3;
        }
        if (!zza("event param", (String[]) null, str)) {
            return 14;
        }
        return !zza("event param", 40, str) ? 3 : 0;
    }

    private final int zzh(String str) {
        if (!zzb("event param", str)) {
            return 3;
        }
        if (!zza("event param", (String[]) null, str)) {
            return 14;
        }
        return !zza("event param", 40, str) ? 3 : 0;
    }

    static MessageDigest zzi() {
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                if (instance != null) {
                    return instance;
                }
                i++;
            } catch (NoSuchAlgorithmException e2) {
            }
        }
        return null;
    }

    private static boolean zzi(String str) {
        Preconditions.checkNotNull(str);
        return str.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$");
    }

    private final int zzj(String str) {
        if ("_ldl".equals(str)) {
            return 2048;
        }
        if ("_id".equals(str)) {
            return 256;
        }
        return (!zzt().zza(zzap.zzce) || !"_lgclid".equals(str)) ? 36 : 100;
    }

    /* access modifiers changed from: protected */
    public final void f_() {
        zzd();
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                zzr().zzi().zza("Utils falling back to Random for random id");
            }
        }
        this.zzc.set(nextLong);
    }

    public final int zza(int i) {
        return GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(zzn(), 12451000);
    }

    /* access modifiers changed from: package-private */
    public final long zza(Context context, String str) {
        zzd();
        Preconditions.checkNotNull(context);
        Preconditions.checkNotEmpty(str);
        PackageManager packageManager = context.getPackageManager();
        MessageDigest zzi = zzi();
        if (zzi == null) {
            zzr().zzf().zza("Could not get MD5 instance");
            return -1;
        }
        if (packageManager != null) {
            try {
                if (zzc(context, str)) {
                    return 0;
                }
                PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(zzn().getPackageName(), 64);
                if (packageInfo.signatures != null && packageInfo.signatures.length > 0) {
                    return zza(zzi.digest(packageInfo.signatures[0].toByteArray()));
                }
                zzr().zzi().zza("Could not get signatures");
                return -1;
            } catch (PackageManager.NameNotFoundException e2) {
                zzr().zzf().zza("Package name not found", e2);
            }
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final Bundle zza(Uri uri) {
        String str;
        String str2;
        String str3;
        String str4;
        if (uri == null) {
            return null;
        }
        try {
            if (uri.isHierarchical()) {
                str4 = uri.getQueryParameter("utm_campaign");
                str3 = uri.getQueryParameter("utm_source");
                str2 = uri.getQueryParameter("utm_medium");
                str = uri.getQueryParameter("gclid");
            } else {
                str4 = null;
                str3 = null;
                str2 = null;
                str = null;
            }
            if (TextUtils.isEmpty(str4) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str)) {
                return null;
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(str4)) {
                bundle.putString(FirebaseAnalytics.Param.CAMPAIGN, str4);
            }
            if (!TextUtils.isEmpty(str3)) {
                bundle.putString(FirebaseAnalytics.Param.SOURCE, str3);
            }
            if (!TextUtils.isEmpty(str2)) {
                bundle.putString(FirebaseAnalytics.Param.MEDIUM, str2);
            }
            if (!TextUtils.isEmpty(str)) {
                bundle.putString("gclid", str);
            }
            String queryParameter = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString(FirebaseAnalytics.Param.TERM, queryParameter);
            }
            String queryParameter2 = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString("content", queryParameter2);
            }
            String queryParameter3 = uri.getQueryParameter(FirebaseAnalytics.Param.ACLID);
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString(FirebaseAnalytics.Param.ACLID, queryParameter3);
            }
            String queryParameter4 = uri.getQueryParameter(FirebaseAnalytics.Param.CP1);
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString(FirebaseAnalytics.Param.CP1, queryParameter4);
            }
            String queryParameter5 = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter5)) {
                bundle.putString("anid", queryParameter5);
            }
            return bundle;
        } catch (UnsupportedOperationException e2) {
            zzr().zzi().zza("Install referrer url isn't a hierarchical URI", e2);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final Bundle zza(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object zza2 = zza(str, bundle.get(str));
                if (zza2 == null) {
                    zzr().zzk().zza("Param value can't be null", zzo().zzb(str));
                } else {
                    zza(bundle2, str, zza2);
                }
            }
        }
        return bundle2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: java.lang.String} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    public final Bundle zza(String str, String str2, Bundle bundle, List<String> list, boolean z, boolean z2) {
        int i;
        int i2;
        Bundle bundle2;
        String str3;
        int i3;
        String str4 = str2;
        Bundle bundle3 = bundle;
        List<String> list2 = list;
        boolean z3 = zzju.zzb() && zzt().zza(zzap.zzdd);
        boolean zza2 = z3 ? zza(str4, zzhl.zzc) : z2;
        if (bundle3 == null) {
            return null;
        }
        Bundle bundle4 = new Bundle(bundle3);
        int zze2 = zzt().zze();
        int i4 = 0;
        for (String next : zzt().zze(str, zzap.zzbk) ? new TreeSet(bundle.keySet()) : bundle.keySet()) {
            if (list2 == null || !list2.contains(next)) {
                i = z ? zzg(next) : 0;
                if (i == 0) {
                    i = zzh(next);
                }
            } else {
                i = 0;
            }
            if (i != 0) {
                zza(bundle4, i, next, next, (Object) i == 3 ? next : null);
                bundle4.remove(next);
                i2 = zze2;
                bundle2 = bundle4;
            } else {
                String str5 = next;
                i2 = zze2;
                Bundle bundle5 = bundle4;
                int zza3 = zza(str, str2, next, bundle3.get(next), bundle4, list, z, zza2);
                if (!z3 || zza3 != 17) {
                    str3 = str5;
                    bundle2 = bundle5;
                    if (zza3 != 0 && !"_ev".equals(str3)) {
                        zza(bundle2, zza3, zza3 == 21 ? str4 : str3, str3, bundle3.get(str3));
                        bundle2.remove(str3);
                    }
                } else {
                    str3 = str5;
                    bundle2 = bundle5;
                    zza(bundle2, zza3, str3, str3, (Object) false);
                }
                if (zza(str3)) {
                    int i5 = i4 + 1;
                    i3 = i2;
                    if (i5 > i3) {
                        StringBuilder sb = new StringBuilder(48);
                        sb.append("Event can't contain more than ");
                        sb.append(i3);
                        sb.append(" params");
                        zzr().zzh().zza(sb.toString(), zzo().zza(str4), zzo().zza(bundle3));
                        zza(bundle2, 5);
                        bundle2.remove(str3);
                        String str6 = str;
                        i4 = i5;
                        zze2 = i3;
                        bundle4 = bundle2;
                    } else {
                        i4 = i5;
                    }
                } else {
                    i3 = i2;
                }
                String str7 = str;
                zze2 = i3;
                bundle4 = bundle2;
            }
            String str8 = str;
            bundle4 = bundle2;
            zze2 = i2;
        }
        return bundle4;
    }

    /* access modifiers changed from: package-private */
    public final zzan zza(String str, String str2, Bundle bundle, String str3, long j, boolean z, boolean z2) {
        Bundle bundle2;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (zzb(str2) == 0) {
            if (bundle != null) {
                bundle2 = new Bundle(bundle);
            } else {
                bundle2 = new Bundle();
            }
            Bundle bundle3 = bundle2;
            bundle3.putString("_o", str3);
            String str4 = str2;
            zzan zzan = new zzan(str4, new zzam(zza(zza(str, str2, bundle3, (List<String>) CollectionUtils.listOf("_o"), false, false))), str3, j);
            return zzan;
        }
        zzr().zzf().zza("Invalid conditional property event name", zzo().zzc(str2));
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: package-private */
    public final Object zza(String str, Object obj) {
        int i = 256;
        if ("_ev".equals(str)) {
            return zza(256, obj, true, true);
        }
        if (!zze(str)) {
            i = 100;
        }
        return zza(i, obj, false, true);
    }

    public final URL zza(long j, String str, String str2, long j2) {
        try {
            Preconditions.checkNotEmpty(str2);
            Preconditions.checkNotEmpty(str);
            String format = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", new Object[]{String.format("v%s.%s", new Object[]{Long.valueOf(j), Integer.valueOf(zzj())}), str2, str, Long.valueOf(j2)});
            if (str.equals(zzt().zzx())) {
                format = format.concat("&ddl_test=1");
            }
            return new URL(format);
        } catch (IllegalArgumentException | MalformedURLException e2) {
            zzr().zzf().zza("Failed to create BOW URL for Deferred Deep Link. exception", e2.getMessage());
            return null;
        }
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    public final void zza(int i, String str, String str2, int i2) {
        zza((String) null, i, str, str2, i2);
    }

    /* access modifiers changed from: package-private */
    public final void zza(Bundle bundle, long j) {
        long j2 = bundle.getLong("_et");
        if (j2 != 0) {
            zzr().zzi().zza("Params already contained engagement", Long.valueOf(j2));
        }
        bundle.putLong("_et", j + j2);
    }

    /* access modifiers changed from: package-private */
    public final void zza(Bundle bundle, String str, Object obj) {
        if (bundle != null) {
            if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                bundle.putString(str, String.valueOf(obj));
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (zzju.zzb() && zzt().zza(zzap.zzdc) && zzt().zza(zzap.zzdb) && (obj instanceof Bundle[])) {
                bundle.putParcelableArray(str, (Bundle[]) obj);
            } else if (str != null) {
                zzr().zzk().zza("Not putting event parameter. Invalid value type. name, type", zzo().zzb(str), obj != null ? obj.getClass().getSimpleName() : null);
            }
        }
    }

    public final void zza(zzn zzn, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i);
        try {
            zzn.zza(bundle);
        } catch (RemoteException e2) {
            this.zzx.zzr().zzi().zza("Error returning int value to wrapper", e2);
        }
    }

    public final void zza(zzn zzn, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("r", j);
        try {
            zzn.zza(bundle);
        } catch (RemoteException e2) {
            this.zzx.zzr().zzi().zza("Error returning long value to wrapper", e2);
        }
    }

    public final void zza(zzn zzn, Bundle bundle) {
        try {
            zzn.zza(bundle);
        } catch (RemoteException e2) {
            this.zzx.zzr().zzi().zza("Error returning bundle value to wrapper", e2);
        }
    }

    public final void zza(zzn zzn, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("r", str);
        try {
            zzn.zza(bundle);
        } catch (RemoteException e2) {
            this.zzx.zzr().zzi().zza("Error returning string value to wrapper", e2);
        }
    }

    public final void zza(zzn zzn, ArrayList<Bundle> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            zzn.zza(bundle);
        } catch (RemoteException e2) {
            this.zzx.zzr().zzi().zza("Error returning bundle list to wrapper", e2);
        }
    }

    public final void zza(zzn zzn, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z);
        try {
            zzn.zza(bundle);
        } catch (RemoteException e2) {
            this.zzx.zzr().zzi().zza("Error returning boolean value to wrapper", e2);
        }
    }

    public final void zza(zzn zzn, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            zzn.zza(bundle);
        } catch (RemoteException e2) {
            this.zzx.zzr().zzi().zza("Error returning byte array to wrapper", e2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str, int i, String str2, String str3, int i2) {
        Bundle bundle = new Bundle();
        zza(bundle, i);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", (long) i2);
        }
        this.zzx.zzu();
        this.zzx.zzh().zza("auto", "_err", bundle);
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(String str, double d2) {
        try {
            SharedPreferences.Editor edit = zzn().getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
            edit.putString("deeplink", str);
            edit.putLong("timestamp", Double.doubleToRawLongBits(d2));
            return edit.commit();
        } catch (Exception e2) {
            zzr().zzf().zza("Failed to persist Deferred Deep Link. exception", e2);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(String str, int i, String str2) {
        if (str2 == null) {
            zzr().zzh().zza("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.codePointCount(0, str2.length()) <= i) {
            return true;
        } else {
            zzr().zzh().zza("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(String str, String str2) {
        if (str2 == null) {
            zzr().zzh().zza("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            zzr().zzh().zza("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (!Character.isLetter(codePointAt)) {
                zzr().zzh().zza("Name must start with a letter. Type, name", str, str2);
                return false;
            }
            int length = str2.length();
            int charCount = Character.charCount(codePointAt);
            while (charCount < length) {
                int codePointAt2 = str2.codePointAt(charCount);
                if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                    charCount += Character.charCount(codePointAt2);
                } else {
                    zzr().zzh().zza("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            if (zzi(str)) {
                return true;
            }
            if (this.zzx.zzl()) {
                zzr().zzh().zza("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", zzfj.zza(str));
            }
            return false;
        } else if (zzll.zzb() && zzt().zza(zzap.zzch) && !TextUtils.isEmpty(str3)) {
            return true;
        } else {
            if (TextUtils.isEmpty(str2)) {
                if (this.zzx.zzl()) {
                    zzr().zzh().zza("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
                }
                return false;
            } else if (zzi(str2)) {
                return true;
            } else {
                zzr().zzh().zza("Invalid admob_app_id. Analytics disabled.", zzfj.zza(str2));
                return false;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(String str, String[] strArr, String str2) {
        boolean z;
        if (str2 == null) {
            zzr().zzh().zza("Name is required and can't be null. Type", str);
            return false;
        }
        Preconditions.checkNotNull(str2);
        String[] strArr2 = zza;
        int length = strArr2.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            } else if (str2.startsWith(strArr2[i])) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            zzr().zzh().zza("Name starts with reserved prefix. Type, name", str, str2);
            return false;
        } else if (strArr == null || !zza(str2, strArr)) {
            return true;
        } else {
            zzr().zzh().zza("Name is reserved. Type, name", str, str2);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final int zzb(String str) {
        if (!zzb("event", str)) {
            return 2;
        }
        if (!zza("event", zzhl.zza, str)) {
            return 13;
        }
        return !zza("event", 40, str) ? 2 : 0;
    }

    /* access modifiers changed from: package-private */
    public final int zzb(String str, Object obj) {
        return "_ldl".equals(str) ? zzb("user property referrer", str, zzj(str), obj) : zzb("user property", str, zzj(str), obj) ? 0 : 7;
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzb(String str, String str2) {
        if (str2 == null) {
            zzr().zzh().zza("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            zzr().zzh().zza("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (Character.isLetter(codePointAt) || codePointAt == 95) {
                int length = str2.length();
                int charCount = Character.charCount(codePointAt);
                while (charCount < length) {
                    int codePointAt2 = str2.codePointAt(charCount);
                    if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                        charCount += Character.charCount(codePointAt2);
                    } else {
                        zzr().zzh().zza("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                        return false;
                    }
                }
                return true;
            }
            zzr().zzh().zza("Name must start with a letter or _ (underscore). Type, name", str, str2);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final int zzc(String str) {
        if (!zzb("user property", str)) {
            return 6;
        }
        if (!zza("user property", zzhn.zza, str)) {
            return 15;
        }
        return !zza("user property", 24, str) ? 6 : 0;
    }

    /* access modifiers changed from: package-private */
    public final Object zzc(String str, Object obj) {
        return "_ldl".equals(str) ? zza(zzj(str), obj, true, false) : zza(zzj(str), obj, false, false);
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzd(String str) {
        zzd();
        if (Wrappers.packageManager(zzn()).checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        zzr().zzw().zza("Permission not granted", str);
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean zze() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzf(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String zzw = zzt().zzw();
        zzu();
        return zzw.equals(str);
    }

    public final long zzg() {
        long andIncrement;
        long j;
        if (this.zzc.get() == 0) {
            synchronized (this.zzc) {
                long nextLong = new Random(System.nanoTime() ^ zzm().currentTimeMillis()).nextLong();
                int i = this.zzd + 1;
                this.zzd = i;
                j = nextLong + ((long) i);
            }
            return j;
        }
        synchronized (this.zzc) {
            this.zzc.compareAndSet(-1, 1);
            andIncrement = this.zzc.getAndIncrement();
        }
        return andIncrement;
    }

    /* access modifiers changed from: package-private */
    public final SecureRandom zzh() {
        zzd();
        if (this.zzb == null) {
            this.zzb = new SecureRandom();
        }
        return this.zzb;
    }

    public final int zzj() {
        if (this.zze == null) {
            this.zze = Integer.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(zzn()) / 1000);
        }
        return this.zze.intValue();
    }

    /* access modifiers changed from: package-private */
    public final String zzk() {
        byte[] bArr = new byte[16];
        zzh().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
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

    public final boolean zzv() {
        try {
            zzn().getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
            return true;
        } catch (ClassNotFoundException e2) {
            return false;
        }
    }
}
