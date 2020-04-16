package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.3.0 */
public class zzbw {
    public static final Uri zza = Uri.parse("content://com.google.android.gsf.gservices");
    public static final Pattern zzb = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    public static final Pattern zzc = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    private static final Uri zzd = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    /* access modifiers changed from: private */
    public static final AtomicBoolean zze = new AtomicBoolean();
    private static HashMap<String, String> zzf;
    private static final HashMap<String, Boolean> zzg = new HashMap<>();
    private static final HashMap<String, Integer> zzh = new HashMap<>();
    private static final HashMap<String, Long> zzi = new HashMap<>();
    private static final HashMap<String, Float> zzj = new HashMap<>();
    private static Object zzk;
    private static boolean zzl;
    private static String[] zzm = new String[0];

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006b, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a7, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a9, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ae, code lost:
        r10 = r10.query(zza, (java.lang.String[]) null, (java.lang.String) null, new java.lang.String[]{r11}, (java.lang.String) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00bc, code lost:
        if (r10 != null) goto L_0x00c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00bf, code lost:
        if (r10 == null) goto L_0x00c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c1, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c4, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00c9, code lost:
        if (r10.moveToFirst() != false) goto L_0x00d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00cb, code lost:
        zza(r0, r11, (java.lang.String) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00d3, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        r12 = r10.getString(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d8, code lost:
        if (r12 == null) goto L_0x00e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00de, code lost:
        if (r12.equals((java.lang.Object) null) == false) goto L_0x00e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e0, code lost:
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e1, code lost:
        zza(r0, r11, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00e4, code lost:
        if (r12 == null) goto L_0x00e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00e6, code lost:
        r3 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00e7, code lost:
        if (r10 == null) goto L_0x00ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00e9, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00ec, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00ed, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00ee, code lost:
        if (r10 != null) goto L_0x00f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00f0, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00f3, code lost:
        throw r11;
     */
    public static String zza(ContentResolver contentResolver, String str, String str2) {
        synchronized (zzbw.class) {
            String str3 = null;
            if (zzf == null) {
                zze.set(false);
                zzf = new HashMap<>();
                zzk = new Object();
                zzl = false;
                contentResolver.registerContentObserver(zza, true, new zzbv((Handler) null));
            } else if (zze.getAndSet(false)) {
                zzf.clear();
                zzg.clear();
                zzh.clear();
                zzi.clear();
                zzj.clear();
                zzk = new Object();
                zzl = false;
            }
            Object obj = zzk;
            if (zzf.containsKey(str)) {
                String str4 = zzf.get(str);
                if (str4 != null) {
                    str3 = str4;
                }
            } else {
                String[] strArr = zzm;
                int length = strArr.length;
                int i = 0;
                while (i < length) {
                    if (!str.startsWith(strArr[i])) {
                        i++;
                    } else if (!zzl || zzf.isEmpty()) {
                        zzf.putAll(zza(contentResolver, zzm));
                        zzl = true;
                        if (zzf.containsKey(str)) {
                            String str5 = zzf.get(str);
                            if (str5 != null) {
                                str3 = str5;
                            }
                        }
                    }
                }
            }
        }
    }

    private static Map<String, String> zza(ContentResolver contentResolver, String... strArr) {
        Cursor query = contentResolver.query(zzd, (String[]) null, (String) null, strArr, (String) null);
        TreeMap treeMap = new TreeMap();
        if (query == null) {
            return treeMap;
        }
        while (query.moveToNext()) {
            try {
                treeMap.put(query.getString(0), query.getString(1));
            } finally {
                query.close();
            }
        }
        return treeMap;
    }

    private static void zza(Object obj, String str, String str2) {
        synchronized (zzbw.class) {
            if (obj == zzk) {
                zzf.put(str, str2);
            }
        }
    }
}
