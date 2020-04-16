package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import androidx.collection.ArrayMap;
import com.android.camera.module.loader.FunctionParseBeautyBodySlimCount;
import com.google.android.apps.photos.api.PhotosOemApi;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzbo;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzfd;
import com.google.android.gms.internal.measurement.zzjj;
import com.google.android.gms.internal.measurement.zzju;
import com.google.android.gms.internal.measurement.zzkt;
import com.google.android.gms.internal.measurement.zzkz;
import com.google.android.gms.internal.measurement.zzll;
import com.google.android.gms.internal.measurement.zzlx;
import com.google.android.gms.internal.measurement.zzmv;
import com.google.android.gms.internal.measurement.zzv;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ss.android.vesdk.runtime.cloudconfig.HttpRequest;
import com.xiaomi.stat.a.j;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
public class zzks implements zzhj {
    private static volatile zzks zza;
    private zzgk zzb;
    private zzfq zzc;
    private zzac zzd;
    private zzft zze;
    private zzko zzf;
    private zzn zzg;
    private final zzkw zzh;
    private zzit zzi;
    private final zzgq zzj;
    private boolean zzk;
    private boolean zzl;
    private long zzm;
    private List<Runnable> zzn;
    private int zzo;
    private int zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private FileLock zzt;
    private FileChannel zzu;
    private List<Long> zzv;
    private List<Long> zzw;
    private long zzx;

    /* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
    class zza implements zzae {
        zzbr.zzg zza;
        List<Long> zzb;
        List<zzbr.zzc> zzc;
        private long zzd;

        private zza() {
        }

        /* synthetic */ zza(zzks zzks, zzkr zzkr) {
            this();
        }

        private static long zza(zzbr.zzc zzc2) {
            return ((zzc2.zze() / 1000) / 60) / 60;
        }

        public final void zza(zzbr.zzg zzg) {
            Preconditions.checkNotNull(zzg);
            this.zza = zzg;
        }

        public final boolean zza(long j, zzbr.zzc zzc2) {
            Preconditions.checkNotNull(zzc2);
            if (this.zzc == null) {
                this.zzc = new ArrayList();
            }
            if (this.zzb == null) {
                this.zzb = new ArrayList();
            }
            if (this.zzc.size() > 0 && zza(this.zzc.get(0)) != zza(zzc2)) {
                return false;
            }
            long zzbn = this.zzd + ((long) zzc2.zzbn());
            if (zzbn >= ((long) Math.max(0, zzap.zzh.zza(null).intValue()))) {
                return false;
            }
            this.zzd = zzbn;
            this.zzc.add(zzc2);
            this.zzb.add(Long.valueOf(j));
            return this.zzc.size() < Math.max(1, zzap.zzi.zza(null).intValue());
        }
    }

    private zzks(zzkx zzkx) {
        this(zzkx, (zzgq) null);
    }

    private zzks(zzkx zzkx, zzgq zzgq) {
        this.zzk = false;
        Preconditions.checkNotNull(zzkx);
        this.zzj = zzgq.zza(zzkx.zza, (zzv) null);
        this.zzx = -1;
        zzkw zzkw = new zzkw(this);
        zzkw.zzal();
        this.zzh = zzkw;
        zzfq zzfq = new zzfq(this);
        zzfq.zzal();
        this.zzc = zzfq;
        zzgk zzgk = new zzgk(this);
        zzgk.zzal();
        this.zzb = zzgk;
        this.zzj.zzq().zza((Runnable) new zzkr(this, zzkx));
    }

    private final int zza(FileChannel fileChannel) {
        zzw();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzj.zzr().zzf().zza("Bad channel to read from");
            return 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        try {
            fileChannel.position(0);
            int read = fileChannel.read(allocate);
            if (read != 4) {
                if (read != -1) {
                    this.zzj.zzr().zzi().zza("Unexpected data length. Bytes read", Integer.valueOf(read));
                }
                return 0;
            }
            allocate.flip();
            return allocate.getInt();
        } catch (IOException e2) {
            this.zzj.zzr().zzf().zza("Failed to read from channel", e2);
            return 0;
        }
    }

    private final zzg zza(zzm zzm2, zzg zzg2, String str) {
        boolean z;
        boolean z2 = true;
        if (zzg2 == null) {
            zzg2 = new zzg(this.zzj, zzm2.zza);
            zzg2.zza(this.zzj.zzi().zzk());
            zzg2.zze(str);
            z = true;
        } else if (!str.equals(zzg2.zzh())) {
            zzg2.zze(str);
            zzg2.zza(this.zzj.zzi().zzk());
            z = true;
        } else {
            z = false;
        }
        if (!TextUtils.equals(zzm2.zzb, zzg2.zze())) {
            zzg2.zzb(zzm2.zzb);
            z = true;
        }
        if (!TextUtils.equals(zzm2.zzr, zzg2.zzf())) {
            zzg2.zzc(zzm2.zzr);
            z = true;
        }
        if (zzll.zzb() && this.zzj.zzb().zze(zzg2.zzc(), zzap.zzch) && !TextUtils.equals(zzm2.zzv, zzg2.zzg())) {
            zzg2.zzd(zzm2.zzv);
            z = true;
        }
        if (!TextUtils.isEmpty(zzm2.zzk) && !zzm2.zzk.equals(zzg2.zzi())) {
            zzg2.zzf(zzm2.zzk);
            z = true;
        }
        if (!(zzm2.zze == 0 || zzm2.zze == zzg2.zzo())) {
            zzg2.zzd(zzm2.zze);
            z = true;
        }
        if (!TextUtils.isEmpty(zzm2.zzc) && !zzm2.zzc.equals(zzg2.zzl())) {
            zzg2.zzg(zzm2.zzc);
            z = true;
        }
        if (zzm2.zzj != zzg2.zzm()) {
            zzg2.zzc(zzm2.zzj);
            z = true;
        }
        if (zzm2.zzd != null && !zzm2.zzd.equals(zzg2.zzn())) {
            zzg2.zzh(zzm2.zzd);
            z = true;
        }
        if (zzm2.zzf != zzg2.zzp()) {
            zzg2.zze(zzm2.zzf);
            z = true;
        }
        if (zzm2.zzh != zzg2.zzr()) {
            zzg2.zza(zzm2.zzh);
            z = true;
        }
        if (!TextUtils.isEmpty(zzm2.zzg) && !zzm2.zzg.equals(zzg2.zzac())) {
            zzg2.zzi(zzm2.zzg);
            z = true;
        }
        if (!this.zzj.zzb().zza(zzap.zzdh) && zzm2.zzl != zzg2.zzae()) {
            zzg2.zzp(zzm2.zzl);
            z = true;
        }
        if (zzm2.zzo != zzg2.zzaf()) {
            zzg2.zzb(zzm2.zzo);
            z = true;
        }
        if (zzm2.zzp != zzg2.zzag()) {
            zzg2.zzc(zzm2.zzp);
            z = true;
        }
        if (this.zzj.zzb().zze(zzm2.zza, zzap.zzbd) && zzm2.zzs != zzg2.zzah()) {
            zzg2.zza(zzm2.zzs);
            z = true;
        }
        if (zzm2.zzt == 0 || zzm2.zzt == zzg2.zzq()) {
            z2 = z;
        } else {
            zzg2.zzf(zzm2.zzt);
        }
        if (z2) {
            zze().zza(zzg2);
        }
        return zzg2;
    }

    public static zzks zza(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zza == null) {
            synchronized (zzks.class) {
                if (zza == null) {
                    zza = new zzks(new zzkx(context));
                }
            }
        }
        return zza;
    }

    private final zzm zza(Context context, String str, String str2, boolean z, boolean z2, boolean z3, long j, String str3, String str4) {
        String str5;
        String str6;
        int i;
        String str7 = str;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            this.zzj.zzr().zzf().zza("PackageManager is null, can not log app install information");
            return null;
        }
        try {
            str5 = packageManager.getInstallerPackageName(str7);
        } catch (IllegalArgumentException e2) {
            this.zzj.zzr().zzf().zza("Error retrieving installer package name. appId", zzfj.zza(str));
            str5 = "Unknown";
        }
        String str8 = str5 == null ? "manual_install" : "com.android.vending".equals(str5) ? "" : str5;
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str7, 0);
            if (packageInfo != null) {
                CharSequence applicationLabel = Wrappers.packageManager(context).getApplicationLabel(str7);
                if (!TextUtils.isEmpty(applicationLabel)) {
                    String charSequence = applicationLabel.toString();
                }
                str6 = packageInfo.versionName;
                i = packageInfo.versionCode;
            } else {
                i = Integer.MIN_VALUE;
                str6 = "Unknown";
            }
            zzm zzm2 = new zzm(str, str2, str6, (long) i, str8, this.zzj.zzb().zzf(), this.zzj.zzi().zza(context, str7), (String) null, z, false, "", 0, j, 0, z2, z3, false, str3, (Boolean) null, 0, (List<String>) null, (!zzll.zzb() || !this.zzj.zzb().zze(str7, zzap.zzch)) ? null : str4);
            return zzm2;
        } catch (PackageManager.NameNotFoundException e3) {
            this.zzj.zzr().zzf().zza("Error retrieving newly installed package info. appId, appName", zzfj.zza(str), "Unknown");
            return null;
        }
    }

    private final zzm zza(String str) {
        String str2 = str;
        zzg zzb2 = zze().zzb(str2);
        if (zzb2 == null || TextUtils.isEmpty(zzb2.zzl())) {
            this.zzj.zzr().zzw().zza("No app data available; dropping", str2);
            return null;
        }
        Boolean zzb3 = zzb(zzb2);
        if (zzb3 == null || zzb3.booleanValue()) {
            zzm zzm2 = new zzm(str, zzb2.zze(), zzb2.zzl(), zzb2.zzm(), zzb2.zzn(), zzb2.zzo(), zzb2.zzp(), (String) null, zzb2.zzr(), false, zzb2.zzi(), zzb2.zzae(), 0, 0, zzb2.zzaf(), zzb2.zzag(), false, zzb2.zzf(), zzb2.zzah(), zzb2.zzq(), zzb2.zzai(), (!zzll.zzb() || !this.zzj.zzb().zze(str2, zzap.zzch)) ? null : zzb2.zzg());
            return zzm2;
        }
        this.zzj.zzr().zzf().zza("App version does not match; dropping. appId", zzfj.zza(str));
        return null;
    }

    private static void zza(zzbr.zzc.zza zza2, int i, String str) {
        List<zzbr.zze> zza3 = zza2.zza();
        int i2 = 0;
        while (i2 < zza3.size()) {
            if (!"_err".equals(zza3.get(i2).zzb())) {
                i2++;
            } else {
                return;
            }
        }
        zza2.zza((zzbr.zze) ((zzfd) zzbr.zze.zzk().zza("_err").zza(Long.valueOf((long) i).longValue()).zzu())).zza((zzbr.zze) ((zzfd) zzbr.zze.zzk().zza("_ev").zzb(str).zzu()));
    }

    private static void zza(zzbr.zzc.zza zza2, String str) {
        List<zzbr.zze> zza3 = zza2.zza();
        for (int i = 0; i < zza3.size(); i++) {
            if (str.equals(zza3.get(i).zzb())) {
                zza2.zzb(i);
                return;
            }
        }
    }

    private static void zza(zzbr.zzg.zza zza2) {
        zza2.zzb(Long.MAX_VALUE).zzc(Long.MIN_VALUE);
        for (int i = 0; i < zza2.zzb(); i++) {
            zzbr.zzc zzb2 = zza2.zzb(i);
            if (zzb2.zze() < zza2.zzf()) {
                zza2.zzb(zzb2.zze());
            }
            if (zzb2.zze() > zza2.zzg()) {
                zza2.zzc(zzb2.zze());
            }
        }
    }

    private final void zza(zzbr.zzg.zza zza2, long j, boolean z) {
        String str = z ? "_se" : "_lte";
        zzlb zzc2 = zze().zzc(zza2.zzj(), str);
        zzlb zzlb = (zzc2 == null || zzc2.zze == null) ? new zzlb(zza2.zzj(), "auto", str, this.zzj.zzm().currentTimeMillis(), Long.valueOf(j)) : new zzlb(zza2.zzj(), "auto", str, this.zzj.zzm().currentTimeMillis(), Long.valueOf(((Long) zzc2.zze).longValue() + j));
        zzbr.zzk zzk2 = (zzbr.zzk) ((zzfd) zzbr.zzk.zzj().zza(str).zza(this.zzj.zzm().currentTimeMillis()).zzb(((Long) zzlb.zze).longValue()).zzu());
        boolean z2 = false;
        int zza3 = zzkw.zza(zza2, str);
        if (zza3 >= 0) {
            zza2.zza(zza3, zzk2);
            z2 = true;
        }
        if (!z2) {
            zza2.zza(zzk2);
        }
        if (j > 0) {
            zze().zza(zzlb);
            String str2 = z ? "session-scoped" : "lifetime";
            if (!zzkz.zzb() || !this.zzj.zzb().zze(zza2.zzj(), zzap.zzcy)) {
                this.zzj.zzr().zzw().zza("Updated engagement user property. scope, value", str2, zzlb.zze);
            } else {
                this.zzj.zzr().zzx().zza("Updated engagement user property. scope, value", str2, zzlb.zze);
            }
        }
    }

    private final void zza(zzg zzg2) {
        ArrayMap arrayMap;
        zzw();
        if (!zzll.zzb() || !this.zzj.zzb().zze(zzg2.zzc(), zzap.zzch)) {
            if (TextUtils.isEmpty(zzg2.zze()) && TextUtils.isEmpty(zzg2.zzf())) {
                zza(zzg2.zzc(), 204, (Throwable) null, (byte[]) null, (Map<String, List<String>>) null);
                return;
            }
        } else if (TextUtils.isEmpty(zzg2.zze()) && TextUtils.isEmpty(zzg2.zzg()) && TextUtils.isEmpty(zzg2.zzf())) {
            zza(zzg2.zzc(), 204, (Throwable) null, (byte[]) null, (Map<String, List<String>>) null);
            return;
        }
        String zza2 = this.zzj.zzb().zza(zzg2);
        try {
            URL url = new URL(zza2);
            this.zzj.zzr().zzx().zza("Fetching remote configuration", zzg2.zzc());
            zzbo.zzb zza3 = zzc().zza(zzg2.zzc());
            String zzb2 = zzc().zzb(zzg2.zzc());
            if (zza3 == null || TextUtils.isEmpty(zzb2)) {
                arrayMap = null;
            } else {
                ArrayMap arrayMap2 = new ArrayMap();
                arrayMap2.put("If-Modified-Since", zzb2);
                arrayMap = arrayMap2;
            }
            this.zzq = true;
            zzfq zzd2 = zzd();
            String zzc2 = zzg2.zzc();
            zzkt zzkt = new zzkt(this);
            zzd2.zzd();
            zzd2.zzak();
            Preconditions.checkNotNull(url);
            Preconditions.checkNotNull(zzkt);
            zzgj zzq2 = zzd2.zzq();
            zzfu zzfu = new zzfu(zzd2, zzc2, url, (byte[]) null, arrayMap, zzkt);
            zzq2.zzb((Runnable) zzfu);
        } catch (MalformedURLException e2) {
            this.zzj.zzr().zzf().zza("Failed to parse config URL. Not fetching. appId", zzfj.zza(zzg2.zzc()), zza2);
        }
    }

    /* access modifiers changed from: private */
    public final void zza(zzkx zzkx) {
        this.zzj.zzq().zzd();
        zzac zzac = new zzac(this);
        zzac.zzal();
        this.zzd = zzac;
        this.zzj.zzb().zza((zzz) this.zzb);
        zzn zzn2 = new zzn(this);
        zzn2.zzal();
        this.zzg = zzn2;
        zzit zzit = new zzit(this);
        zzit.zzal();
        this.zzi = zzit;
        zzko zzko = new zzko(this);
        zzko.zzal();
        this.zzf = zzko;
        this.zze = new zzft(this);
        if (this.zzo != this.zzp) {
            this.zzj.zzr().zzf().zza("Not all upload components initialized", Integer.valueOf(this.zzo), Integer.valueOf(this.zzp));
        }
        this.zzk = true;
    }

    private final boolean zza(int i, FileChannel fileChannel) {
        zzw();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzj.zzr().zzf().zza("Bad channel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.flip();
        try {
            fileChannel.truncate(0);
            if (this.zzj.zzb().zza(zzap.zzcu) && Build.VERSION.SDK_INT <= 19) {
                fileChannel.position(0);
            }
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() != 4) {
                this.zzj.zzr().zzf().zza("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            }
            return true;
        } catch (IOException e2) {
            this.zzj.zzr().zzf().zza("Failed to write to channel", e2);
            return false;
        }
    }

    private final boolean zza(zzbr.zzc.zza zza2, zzbr.zzc.zza zza3) {
        Preconditions.checkArgument("_e".equals(zza2.zzd()));
        zzh();
        zzbr.zze zza4 = zzkw.zza((zzbr.zzc) ((zzfd) zza2.zzu()), "_sc");
        String str = null;
        String zzd2 = zza4 == null ? null : zza4.zzd();
        zzh();
        zzbr.zze zza5 = zzkw.zza((zzbr.zzc) ((zzfd) zza3.zzu()), "_pc");
        if (zza5 != null) {
            str = zza5.zzd();
        }
        if (str == null || !str.equals(zzd2)) {
            return false;
        }
        zzb(zza2, zza3);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:119:0x0266 A[Catch:{ IOException -> 0x0223, all -> 0x10d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0274 A[Catch:{ IOException -> 0x0223, all -> 0x10d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x03c2 A[Catch:{ IOException -> 0x0223, all -> 0x10d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x03cd A[Catch:{ IOException -> 0x0223, all -> 0x10d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x03ce A[Catch:{ IOException -> 0x0223, all -> 0x10d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x05e1 A[Catch:{ IOException -> 0x0223, all -> 0x10d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x06b0 A[Catch:{ IOException -> 0x0223, all -> 0x10d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:264:0x06c7 A[Catch:{ IOException -> 0x0223, all -> 0x10d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:319:0x0887 A[Catch:{ IOException -> 0x0223, all -> 0x10d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:326:0x08a3 A[Catch:{ IOException -> 0x0223, all -> 0x10d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:327:0x08be A[Catch:{ IOException -> 0x0223, all -> 0x10d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:468:0x0caf A[Catch:{ IOException -> 0x0223, all -> 0x10d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:469:0x0cc3 A[Catch:{ IOException -> 0x0223, all -> 0x10d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:471:0x0cc6 A[Catch:{ IOException -> 0x0223, all -> 0x10d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:472:0x0cf4 A[Catch:{ IOException -> 0x0223, all -> 0x10d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:585:0x10b9 A[SYNTHETIC, Splitter:B:585:0x10b9] */
    /* JADX WARNING: Removed duplicated region for block: B:592:0x10cd A[SYNTHETIC, Splitter:B:592:0x10cd] */
    private final boolean zza(String str, long j) {
        Cursor cursor;
        zzac zze2;
        Throwable th;
        boolean z;
        boolean z2;
        String str2;
        String str3;
        int i;
        long j2;
        long j3;
        zza zza2;
        zzbr.zzg.zza zza3;
        SecureRandom secureRandom;
        zza zza4;
        int i2;
        zzbr.zzg.zza zza5;
        boolean z3;
        int zzd2;
        long j4;
        zzbr.zzg.zza zza6;
        int i3;
        long j5;
        boolean z4;
        boolean z5;
        boolean z6;
        int i4;
        zzbr.zzg.zza zza7;
        int i5;
        zzbr.zzg.zza zza8;
        String str4;
        zzbr.zzc.zza zza9;
        int i6;
        String str5;
        String str6;
        zzbr.zzc.zza zza10;
        String str7;
        String str8;
        long j6;
        int i7;
        int i8;
        boolean z7;
        zzbr.zzc.zza zza11;
        int i9;
        zzbr.zzc.zza zza12;
        char c2;
        boolean z8;
        String str9;
        SQLiteException sQLiteException;
        String str10;
        String[] strArr;
        String str11;
        String[] strArr2;
        String str12 = "_npa";
        String str13 = "";
        zze().zzf();
        try {
            cursor = null;
            zza zza13 = new zza(this, (zzkr) null);
            zze2 = zze();
            long j7 = this.zzx;
            Preconditions.checkNotNull(zza13);
            zze2.zzd();
            zze2.zzak();
            try {
                SQLiteDatabase c_ = zze2.c_();
                if (TextUtils.isEmpty((CharSequence) null)) {
                    int i10 = (j7 > -1 ? 1 : (j7 == -1 ? 0 : -1));
                    if (i10 != 0) {
                        try {
                            strArr2 = new String[]{String.valueOf(j7), String.valueOf(j)};
                        } catch (SQLiteException e2) {
                            sQLiteException = e2;
                            str9 = null;
                        }
                    } else {
                        strArr2 = new String[]{String.valueOf(j)};
                    }
                    String str14 = i10 != 0 ? "rowid <= ? and " : str13;
                    StringBuilder sb = new StringBuilder(String.valueOf(str14).length() + 148);
                    sb.append("select app_id, metadata_fingerprint from raw_events where ");
                    sb.append(str14);
                    sb.append("app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;");
                    cursor = c_.rawQuery(sb.toString(), strArr2);
                    try {
                        if (!cursor.moveToFirst()) {
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (zza13.zzc != null) {
                                if (!zza13.zzc.isEmpty()) {
                                    z = false;
                                    if (z) {
                                        zzbr.zzg.zza zzc2 = ((zzbr.zzg.zza) zza13.zza.zzbm()).zzc();
                                        boolean zze3 = this.zzj.zzb().zze(zza13.zza.zzx(), zzap.zzbc);
                                        int i11 = -1;
                                        int i12 = -1;
                                        zzbr.zzc.zza zza14 = null;
                                        zzbr.zzc.zza zza15 = null;
                                        int i13 = 0;
                                        boolean z9 = false;
                                        int i14 = 0;
                                        long j8 = 0;
                                        while (true) {
                                            String str15 = str13;
                                            z2 = z9;
                                            str2 = "_et";
                                            str3 = str12;
                                            i = i14;
                                            j2 = j8;
                                            if (i13 >= zza13.zzc.size()) {
                                                break;
                                            }
                                            zzbr.zzc.zza zza16 = (zzbr.zzc.zza) zza13.zzc.get(i13).zzbm();
                                            int i15 = i13;
                                            if (zzc().zzb(zza13.zza.zzx(), zza16.zzd())) {
                                                this.zzj.zzr().zzi().zza("Dropping blacklisted raw event. appId", zzfj.zza(zza13.zza.zzx()), this.zzj.zzj().zza(zza16.zzd()));
                                                if (!zzc().zzg(zza13.zza.zzx())) {
                                                    if (!zzc().zzh(zza13.zza.zzx())) {
                                                        z8 = false;
                                                        if (!z8 && !"_err".equals(zza16.zzd())) {
                                                            this.zzj.zzi().zza(zza13.zza.zzx(), 11, "_ev", zza16.zzd(), 0);
                                                        }
                                                        z6 = zze3;
                                                        i4 = i15;
                                                        z9 = z2;
                                                        i14 = i;
                                                        j8 = j2;
                                                        zza7 = zzc2;
                                                    }
                                                }
                                                z8 = true;
                                                this.zzj.zzi().zza(zza13.zza.zzx(), 11, "_ev", zza16.zzd(), 0);
                                                z6 = zze3;
                                                i4 = i15;
                                                z9 = z2;
                                                i14 = i;
                                                j8 = j2;
                                                zza7 = zzc2;
                                            } else {
                                                z6 = zze3;
                                                boolean zzc3 = zzc().zzc(zza13.zza.zzx(), zza16.zzd());
                                                if (!zzc3) {
                                                    zzh();
                                                    String zzd3 = zza16.zzd();
                                                    Preconditions.checkNotEmpty(zzd3);
                                                    i6 = i11;
                                                    int hashCode = zzd3.hashCode();
                                                    zza9 = zza14;
                                                    if (hashCode != 94660) {
                                                        if (hashCode != 95025) {
                                                            if (hashCode == 95027 && zzd3.equals("_ui")) {
                                                                c2 = 1;
                                                                if (c2 != 0 || c2 == 1 || c2 == 2) {
                                                                    zza8 = zzc2;
                                                                    i5 = i12;
                                                                    zza10 = zza15;
                                                                    str4 = str2;
                                                                    str5 = "_e";
                                                                    str6 = "_fr";
                                                                    if (!zzc3) {
                                                                        ArrayList arrayList = new ArrayList(zza16.zza());
                                                                        int i16 = -1;
                                                                        int i17 = -1;
                                                                        for (int i18 = 0; i18 < arrayList.size(); i18++) {
                                                                            if ("value".equals(((zzbr.zze) arrayList.get(i18)).zzb())) {
                                                                                i16 = i18;
                                                                            } else if ("currency".equals(((zzbr.zze) arrayList.get(i18)).zzb())) {
                                                                                i17 = i18;
                                                                            }
                                                                        }
                                                                        if (i16 != -1) {
                                                                            if (((zzbr.zze) arrayList.get(i16)).zze() || ((zzbr.zze) arrayList.get(i16)).zzg()) {
                                                                                if (i17 != -1) {
                                                                                    String zzd4 = ((zzbr.zze) arrayList.get(i17)).zzd();
                                                                                    if (zzd4.length() == 3) {
                                                                                        int i19 = 0;
                                                                                        while (true) {
                                                                                            if (i19 >= zzd4.length()) {
                                                                                                z7 = false;
                                                                                                break;
                                                                                            }
                                                                                            int codePointAt = zzd4.codePointAt(i19);
                                                                                            if (!Character.isLetter(codePointAt)) {
                                                                                                z7 = true;
                                                                                                break;
                                                                                            }
                                                                                            i19 += Character.charCount(codePointAt);
                                                                                        }
                                                                                    } else {
                                                                                        z7 = true;
                                                                                    }
                                                                                } else {
                                                                                    z7 = true;
                                                                                }
                                                                                if (z7) {
                                                                                    this.zzj.zzr().zzk().zza("Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter.");
                                                                                    zza16.zzb(i16);
                                                                                    zza(zza16, "_c");
                                                                                    zza(zza16, 19, "currency");
                                                                                }
                                                                            } else {
                                                                                this.zzj.zzr().zzk().zza("Value must be specified with a numeric type.");
                                                                                zza16.zzb(i16);
                                                                                zza(zza16, "_c");
                                                                                zza(zza16, 18, "value");
                                                                            }
                                                                        }
                                                                    }
                                                                    if (!this.zzj.zzb().zze(zza13.zza.zzx(), zzap.zzbb)) {
                                                                        str8 = str5;
                                                                        if (str8.equals(zza16.zzd())) {
                                                                            zzh();
                                                                            if (zzkw.zza((zzbr.zzc) ((zzfd) zza16.zzu()), str6) == null) {
                                                                                if (zza10 == null) {
                                                                                    zza7 = zza8;
                                                                                    i12 = i5;
                                                                                } else if (Math.abs(zza10.zzf() - zza16.zzf()) <= 1000) {
                                                                                    zzbr.zzc.zza zza17 = (zzbr.zzc.zza) ((zzfd.zzb) zza10.clone());
                                                                                    if (zza(zza16, zza17)) {
                                                                                        zza7 = zza8;
                                                                                        i12 = i5;
                                                                                        zza7.zza(i12, zza17);
                                                                                        i11 = i6;
                                                                                        str7 = str4;
                                                                                        zza10 = null;
                                                                                        zza9 = null;
                                                                                        if (!z6 && str8.equals(zza16.zzd())) {
                                                                                            if (zza16.zzb() == 0) {
                                                                                                this.zzj.zzr().zzi().zza("Engagement event does not contain any parameters. appId", zzfj.zza(zza13.zza.zzx()));
                                                                                            } else {
                                                                                                Long l = (Long) zzh().zzb((zzbr.zzc) ((zzfd) zza16.zzu()), str7);
                                                                                                if (l == null) {
                                                                                                    this.zzj.zzr().zzi().zza("Engagement event does not include duration. appId", zzfj.zza(zza13.zza.zzx()));
                                                                                                } else {
                                                                                                    j6 = j2 + l.longValue();
                                                                                                    i4 = i15;
                                                                                                    zza13.zzc.set(i4, (zzbr.zzc) ((zzfd) zza16.zzu()));
                                                                                                    i14 = i + 1;
                                                                                                    zza7.zza(zza16);
                                                                                                    j8 = j6;
                                                                                                    zza15 = zza10;
                                                                                                    z9 = z2;
                                                                                                    zza14 = zza9;
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        j6 = j2;
                                                                                        i4 = i15;
                                                                                        zza13.zzc.set(i4, (zzbr.zzc) ((zzfd) zza16.zzu()));
                                                                                        i14 = i + 1;
                                                                                        zza7.zza(zza16);
                                                                                        j8 = j6;
                                                                                        zza15 = zza10;
                                                                                        z9 = z2;
                                                                                        zza14 = zza9;
                                                                                    } else {
                                                                                        zza7 = zza8;
                                                                                        i12 = i5;
                                                                                    }
                                                                                } else {
                                                                                    zza7 = zza8;
                                                                                    i12 = i5;
                                                                                }
                                                                                zza9 = zza16;
                                                                                i11 = i;
                                                                                str7 = str4;
                                                                                if (zza16.zzb() == 0) {
                                                                                }
                                                                                j6 = j2;
                                                                                i4 = i15;
                                                                                zza13.zzc.set(i4, (zzbr.zzc) ((zzfd) zza16.zzu()));
                                                                                i14 = i + 1;
                                                                                zza7.zza(zza16);
                                                                                j8 = j6;
                                                                                zza15 = zza10;
                                                                                z9 = z2;
                                                                                zza14 = zza9;
                                                                            } else {
                                                                                zza7 = zza8;
                                                                                i12 = i5;
                                                                                i7 = i6;
                                                                                str7 = str4;
                                                                            }
                                                                        } else {
                                                                            zza7 = zza8;
                                                                            i12 = i5;
                                                                            if ("_vs".equals(zza16.zzd())) {
                                                                                zzh();
                                                                                str7 = str4;
                                                                                if (zzkw.zza((zzbr.zzc) ((zzfd) zza16.zzu()), str7) == null) {
                                                                                    if (zza9 == null) {
                                                                                        i8 = i6;
                                                                                    } else if (Math.abs(zza9.zzf() - zza16.zzf()) <= 1000) {
                                                                                        zzbr.zzc.zza zza18 = (zzbr.zzc.zza) ((zzfd.zzb) zza9.clone());
                                                                                        if (zza(zza18, zza16)) {
                                                                                            int i20 = i6;
                                                                                            zza7.zza(i20, zza18);
                                                                                            i11 = i20;
                                                                                            zza10 = null;
                                                                                            zza9 = null;
                                                                                            if (zza16.zzb() == 0) {
                                                                                            }
                                                                                            j6 = j2;
                                                                                            i4 = i15;
                                                                                            zza13.zzc.set(i4, (zzbr.zzc) ((zzfd) zza16.zzu()));
                                                                                            i14 = i + 1;
                                                                                            zza7.zza(zza16);
                                                                                            j8 = j6;
                                                                                            zza15 = zza10;
                                                                                            z9 = z2;
                                                                                            zza14 = zza9;
                                                                                        } else {
                                                                                            i8 = i6;
                                                                                        }
                                                                                    } else {
                                                                                        i8 = i6;
                                                                                    }
                                                                                    zza10 = zza16;
                                                                                    i11 = i8;
                                                                                    i12 = i;
                                                                                    if (zza16.zzb() == 0) {
                                                                                    }
                                                                                    j6 = j2;
                                                                                    i4 = i15;
                                                                                    zza13.zzc.set(i4, (zzbr.zzc) ((zzfd) zza16.zzu()));
                                                                                    i14 = i + 1;
                                                                                    zza7.zza(zza16);
                                                                                    j8 = j6;
                                                                                    zza15 = zza10;
                                                                                    z9 = z2;
                                                                                    zza14 = zza9;
                                                                                } else {
                                                                                    i7 = i6;
                                                                                }
                                                                            } else {
                                                                                i7 = i6;
                                                                                str7 = str4;
                                                                                if (this.zzj.zzb().zze(zza13.zza.zzx(), zzap.zzcl) && "_ab".equals(zza16.zzd())) {
                                                                                    zzh();
                                                                                    if (zzkw.zza((zzbr.zzc) ((zzfd) zza16.zzu()), str7) == null && zza9 != null && Math.abs(zza9.zzf() - zza16.zzf()) <= FunctionParseBeautyBodySlimCount.TIP_TIME) {
                                                                                        zzbr.zzc.zza zza19 = (zzbr.zzc.zza) ((zzfd.zzb) zza9.clone());
                                                                                        zzb(zza19, zza16);
                                                                                        Preconditions.checkArgument(str8.equals(zza19.zzd()));
                                                                                        zzh();
                                                                                        zzbr.zze zza20 = zzkw.zza((zzbr.zzc) ((zzfd) zza19.zzu()), "_sn");
                                                                                        zzh();
                                                                                        zzbr.zze zza21 = zzkw.zza((zzbr.zzc) ((zzfd) zza19.zzu()), "_sc");
                                                                                        zzh();
                                                                                        zzbr.zze zza22 = zzkw.zza((zzbr.zzc) ((zzfd) zza19.zzu()), "_si");
                                                                                        String zzd5 = zza20 != null ? zza20.zzd() : str15;
                                                                                        if (!TextUtils.isEmpty(zzd5)) {
                                                                                            zzh().zza(zza16, "_sn", (Object) zzd5);
                                                                                        }
                                                                                        String zzd6 = zza21 != null ? zza21.zzd() : str15;
                                                                                        if (!TextUtils.isEmpty(zzd6)) {
                                                                                            zzh().zza(zza16, "_sc", (Object) zzd6);
                                                                                        }
                                                                                        if (zza22 != null) {
                                                                                            zzh().zza(zza16, "_si", (Object) Long.valueOf(zza22.zzf()));
                                                                                        }
                                                                                        zza7.zza(i7, zza19);
                                                                                        i11 = i7;
                                                                                        zza9 = null;
                                                                                        if (zza16.zzb() == 0) {
                                                                                        }
                                                                                        j6 = j2;
                                                                                        i4 = i15;
                                                                                        zza13.zzc.set(i4, (zzbr.zzc) ((zzfd) zza16.zzu()));
                                                                                        i14 = i + 1;
                                                                                        zza7.zza(zza16);
                                                                                        j8 = j6;
                                                                                        zza15 = zza10;
                                                                                        z9 = z2;
                                                                                        zza14 = zza9;
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    } else {
                                                                        str8 = str5;
                                                                        i7 = i6;
                                                                        str7 = str4;
                                                                        zza7 = zza8;
                                                                        i12 = i5;
                                                                    }
                                                                    i11 = i7;
                                                                    if (zza16.zzb() == 0) {
                                                                    }
                                                                    j6 = j2;
                                                                    i4 = i15;
                                                                    zza13.zzc.set(i4, (zzbr.zzc) ((zzfd) zza16.zzu()));
                                                                    i14 = i + 1;
                                                                    zza7.zza(zza16);
                                                                    j8 = j6;
                                                                    zza15 = zza10;
                                                                    z9 = z2;
                                                                    zza14 = zza9;
                                                                }
                                                            }
                                                        } else if (zzd3.equals("_ug")) {
                                                            c2 = 2;
                                                            if (c2 != 0 || c2 == 1 || c2 == 2) {
                                                            }
                                                        }
                                                    } else if (zzd3.equals("_in")) {
                                                        c2 = 0;
                                                        if (c2 != 0 || c2 == 1 || c2 == 2) {
                                                        }
                                                    }
                                                    c2 = 65535;
                                                    if (c2 != 0 || c2 == 1 || c2 == 2) {
                                                    }
                                                } else {
                                                    i6 = i11;
                                                    zza9 = zza14;
                                                }
                                                boolean z10 = false;
                                                boolean z11 = false;
                                                int i21 = 0;
                                                while (true) {
                                                    str4 = str2;
                                                    zza8 = zzc2;
                                                    if (i21 >= zza16.zzb()) {
                                                        break;
                                                    }
                                                    if ("_c".equals(zza16.zza(i21).zzb())) {
                                                        i9 = i12;
                                                        zza16.zza(i21, (zzbr.zze) ((zzfd) ((zzbr.zze.zza) zza16.zza(i21).zzbm()).zza(1).zzu()));
                                                        zza12 = zza15;
                                                        z10 = true;
                                                    } else {
                                                        i9 = i12;
                                                        if ("_r".equals(zza16.zza(i21).zzb())) {
                                                            zza12 = zza15;
                                                            zza16.zza(i21, (zzbr.zze) ((zzfd) ((zzbr.zze.zza) zza16.zza(i21).zzbm()).zza(1).zzu()));
                                                            z11 = true;
                                                        } else {
                                                            zza12 = zza15;
                                                        }
                                                    }
                                                    i21++;
                                                    zza15 = zza12;
                                                    i12 = i9;
                                                    str2 = str4;
                                                    zzc2 = zza8;
                                                }
                                                int i22 = i12;
                                                zzbr.zzc.zza zza23 = zza15;
                                                if (z10 || !zzc3) {
                                                    str6 = "_fr";
                                                    i5 = i22;
                                                    str5 = "_e";
                                                } else {
                                                    i5 = i22;
                                                    this.zzj.zzr().zzx().zza("Marking event as conversion", this.zzj.zzj().zza(zza16.zzd()));
                                                    str5 = "_e";
                                                    str6 = "_fr";
                                                    zza16.zza(zzbr.zze.zzk().zza("_c").zza(1));
                                                }
                                                if (!z11) {
                                                    this.zzj.zzr().zzx().zza("Marking event as real-time", this.zzj.zzj().zza(zza16.zzd()));
                                                    zza11 = zza23;
                                                    zza16.zza(zzbr.zze.zzk().zza("_r").zza(1));
                                                } else {
                                                    zza11 = zza23;
                                                }
                                                zza10 = zza11;
                                                if (zze().zza(zzx(), zza13.zza.zzx(), false, false, false, false, true).zze > ((long) this.zzj.zzb().zzb(zza13.zza.zzx()))) {
                                                    zza(zza16, "_r");
                                                } else {
                                                    z2 = true;
                                                }
                                                if (zzla.zza(zza16.zzd()) && zzc3 && zze().zza(zzx(), zza13.zza.zzx(), false, false, true, false, false).zzc > ((long) this.zzj.zzb().zzb(zza13.zza.zzx(), zzap.zzm))) {
                                                    this.zzj.zzr().zzi().zza("Too many conversions. Not logging as conversion. appId", zzfj.zza(zza13.zza.zzx()));
                                                    int i23 = -1;
                                                    zzbr.zze.zza zza24 = null;
                                                    boolean z12 = false;
                                                    for (int i24 = 0; i24 < zza16.zzb(); i24++) {
                                                        zzbr.zze zza25 = zza16.zza(i24);
                                                        if ("_c".equals(zza25.zzb())) {
                                                            zza24 = (zzbr.zze.zza) zza25.zzbm();
                                                            i23 = i24;
                                                        } else if ("_err".equals(zza25.zzb())) {
                                                            z12 = true;
                                                        }
                                                    }
                                                    if (z12 && zza24 != null) {
                                                        zza16.zzb(i23);
                                                    } else if (zza24 != null) {
                                                        zza16.zza(i23, (zzbr.zze) ((zzfd) ((zzbr.zze.zza) ((zzfd.zzb) zza24.clone())).zza("_err").zza(10).zzu()));
                                                    } else {
                                                        this.zzj.zzr().zzf().zza("Did not find conversion parameter. appId", zzfj.zza(zza13.zza.zzx()));
                                                    }
                                                }
                                                if (!zzc3) {
                                                }
                                                if (!this.zzj.zzb().zze(zza13.zza.zzx(), zzap.zzbb)) {
                                                }
                                                i11 = i7;
                                                if (zza16.zzb() == 0) {
                                                }
                                                j6 = j2;
                                                i4 = i15;
                                                zza13.zzc.set(i4, (zzbr.zzc) ((zzfd) zza16.zzu()));
                                                i14 = i + 1;
                                                zza7.zza(zza16);
                                                j8 = j6;
                                                zza15 = zza10;
                                                z9 = z2;
                                                zza14 = zza9;
                                            }
                                            i13 = i4 + 1;
                                            zzc2 = zza7;
                                            str13 = str15;
                                            str12 = str3;
                                            zze3 = z6;
                                        }
                                        String str16 = "_fr";
                                        boolean z13 = zze3;
                                        String str17 = str2;
                                        zzbr.zzg.zza zza26 = zzc2;
                                        String str18 = "_e";
                                        if (z13) {
                                            int i25 = i;
                                            long j9 = j2;
                                            int i26 = 0;
                                            while (i26 < i25) {
                                                zzbr.zzc zzb2 = zza26.zzb(i26);
                                                if (str18.equals(zzb2.zzc())) {
                                                    zzh();
                                                    if (zzkw.zza(zzb2, str16) != null) {
                                                        zza26.zzc(i26);
                                                        i25--;
                                                        i26--;
                                                        i26++;
                                                    }
                                                }
                                                zzh();
                                                zzbr.zze zza27 = zzkw.zza(zzb2, str17);
                                                if (zza27 != null) {
                                                    Long valueOf = zza27.zze() ? Long.valueOf(zza27.zzf()) : null;
                                                    if (valueOf != null && valueOf.longValue() > 0) {
                                                        j9 += valueOf.longValue();
                                                    }
                                                }
                                                i26++;
                                            }
                                            j3 = j9;
                                        } else {
                                            j3 = j2;
                                        }
                                        zza(zza26, j3, false);
                                        if (this.zzj.zzb().zze(zza26.zzj(), zzap.zzbo)) {
                                            Iterator<zzbr.zzc> it = zza26.zza().iterator();
                                            while (true) {
                                                if (!it.hasNext()) {
                                                    z5 = false;
                                                    break;
                                                } else if ("_s".equals(it.next().zzc())) {
                                                    z5 = true;
                                                    break;
                                                }
                                            }
                                            if (z5) {
                                                zze().zzb(zza26.zzj(), "_se");
                                            }
                                            if (zzmv.zzb() && this.zzj.zzb().zze(zza26.zzj(), zzap.zzbp)) {
                                                if (!(zzkw.zza(zza26, "_sid") >= 0)) {
                                                    int zza28 = zzkw.zza(zza26, "_se");
                                                    if (zza28 >= 0) {
                                                        zza26.zze(zza28);
                                                        if (zzkz.zzb()) {
                                                            if (this.zzj.zzb().zze(zza13.zza.zzx(), zzap.zzcy)) {
                                                                this.zzj.zzr().zzf().zza("Session engagement user property is in the bundle without session ID. appId", zzfj.zza(zza13.zza.zzx()));
                                                            }
                                                        }
                                                        this.zzj.zzr().zzi().zza("Session engagement user property is in the bundle without session ID. appId", zzfj.zza(zza13.zza.zzx()));
                                                    }
                                                }
                                            }
                                            zza(zza26, j3, true);
                                        } else if (this.zzj.zzb().zze(zza26.zzj(), zzap.zzbr)) {
                                            zze().zzb(zza26.zzj(), "_se");
                                        }
                                        if (this.zzj.zzb().zze(zza26.zzj(), zzap.zzbd)) {
                                            zzkw zzh2 = zzh();
                                            zzh2.zzr().zzx().zza("Checking account type status for ad personalization signals");
                                            if (zzh2.zzj().zze(zza26.zzj())) {
                                                zzg zzb3 = zzh2.zzi().zzb(zza26.zzj());
                                                if (zzb3 != null && zzb3.zzaf() && zzh2.zzl().zzj()) {
                                                    zzh2.zzr().zzw().zza("Turning off ad personalization due to account type");
                                                    String str19 = str3;
                                                    zzbr.zzk zzk2 = (zzbr.zzk) ((zzfd) zzbr.zzk.zzj().zza(str19).zza(zzh2.zzl().zzh()).zzb(1).zzu());
                                                    int i27 = 0;
                                                    while (true) {
                                                        if (i27 >= zza26.zze()) {
                                                            z4 = false;
                                                            break;
                                                        } else if (str19.equals(zza26.zzd(i27).zzc())) {
                                                            zza26.zza(i27, zzk2);
                                                            z4 = true;
                                                            break;
                                                        } else {
                                                            i27++;
                                                        }
                                                    }
                                                    if (!z4) {
                                                        zza26.zza(zzk2);
                                                    }
                                                }
                                            }
                                        }
                                        if (this.zzj.zzb().zze(zza26.zzj(), zzap.zzcg)) {
                                            zza(zza26);
                                        }
                                        zza26.zzm().zzc((Iterable<? extends zzbr.zza>) zzf().zza(zza26.zzj(), zza26.zza(), zza26.zzd(), Long.valueOf(zza26.zzf()), Long.valueOf(zza26.zzg())));
                                        if (this.zzj.zzb().zzg(zza13.zza.zzx())) {
                                            HashMap hashMap = new HashMap();
                                            ArrayList arrayList2 = new ArrayList();
                                            SecureRandom zzh3 = this.zzj.zzi().zzh();
                                            int i28 = 0;
                                            while (i28 < zza26.zzb()) {
                                                zzbr.zzc.zza zza29 = (zzbr.zzc.zza) zza26.zzb(i28).zzbm();
                                                if (zza29.zzd().equals("_ep")) {
                                                    String str20 = (String) zzh().zzb((zzbr.zzc) ((zzfd) zza29.zzu()), "_en");
                                                    zzaj zzaj = (zzaj) hashMap.get(str20);
                                                    if (zzaj == null) {
                                                        zzaj = zze().zza(zza13.zza.zzx(), str20);
                                                        hashMap.put(str20, zzaj);
                                                    }
                                                    if (zzaj.zzi == null) {
                                                        if (zzaj.zzj.longValue() > 1) {
                                                            zzh().zza(zza29, "_sr", (Object) zzaj.zzj);
                                                        }
                                                        if (zzaj.zzk != null && zzaj.zzk.booleanValue()) {
                                                            zzh().zza(zza29, "_efs", (Object) 1L);
                                                        }
                                                        arrayList2.add((zzbr.zzc) ((zzfd) zza29.zzu()));
                                                    }
                                                    zza26.zza(i28, zza29);
                                                    zza4 = zza13;
                                                    secureRandom = zzh3;
                                                    zza5 = zza26;
                                                    i2 = i28;
                                                } else {
                                                    long zzf2 = zzc().zzf(zza13.zza.zzx());
                                                    this.zzj.zzi();
                                                    long zza30 = zzla.zza(zza29.zzf(), zzf2);
                                                    zzbr.zzc zzc4 = (zzbr.zzc) ((zzfd) zza29.zzu());
                                                    long j10 = zzf2;
                                                    Long l2 = 1L;
                                                    if (!TextUtils.isEmpty("_dbg")) {
                                                        if (l2 != null) {
                                                            Iterator<zzbr.zze> it2 = zzc4.zza().iterator();
                                                            while (true) {
                                                                if (!it2.hasNext()) {
                                                                    z3 = false;
                                                                    break;
                                                                }
                                                                zzbr.zze next = it2.next();
                                                                Iterator<zzbr.zze> it3 = it2;
                                                                if ("_dbg".equals(next.zzb())) {
                                                                    z3 = ((l2 instanceof Long) && l2.equals(Long.valueOf(next.zzf()))) || ((l2 instanceof String) && l2.equals(next.zzd())) || ((l2 instanceof Double) && l2.equals(Double.valueOf(next.zzh())));
                                                                } else {
                                                                    it2 = it3;
                                                                }
                                                            }
                                                            zzd2 = z3 ? zzc().zzd(zza13.zza.zzx(), zza29.zzd()) : 1;
                                                            if (zzd2 > 0) {
                                                                this.zzj.zzr().zzi().zza("Sample rate must be positive. event, rate", zza29.zzd(), Integer.valueOf(zzd2));
                                                                arrayList2.add((zzbr.zzc) ((zzfd) zza29.zzu()));
                                                                zza26.zza(i28, zza29);
                                                                zza4 = zza13;
                                                                secureRandom = zzh3;
                                                                zza5 = zza26;
                                                                i2 = i28;
                                                            } else {
                                                                zzaj zzaj2 = (zzaj) hashMap.get(zza29.zzd());
                                                                if (zzaj2 == null) {
                                                                    zzaj2 = zze().zza(zza13.zza.zzx(), zza29.zzd());
                                                                    if (zzaj2 == null) {
                                                                        j4 = zza30;
                                                                        this.zzj.zzr().zzi().zza("Event being bundled has no eventAggregate. appId, eventName", zza13.zza.zzx(), zza29.zzd());
                                                                        zzaj2 = this.zzj.zzb().zze(zza13.zza.zzx(), zzap.zzbn) ? new zzaj(zza13.zza.zzx(), zza29.zzd(), 1, 1, 1, zza29.zzf(), 0, (Long) null, (Long) null, (Long) null, (Boolean) null) : new zzaj(zza13.zza.zzx(), zza29.zzd(), 1, 1, zza29.zzf(), 0, (Long) null, (Long) null, (Long) null, (Boolean) null);
                                                                    } else {
                                                                        j4 = zza30;
                                                                    }
                                                                } else {
                                                                    j4 = zza30;
                                                                }
                                                                Long l3 = (Long) zzh().zzb((zzbr.zzc) ((zzfd) zza29.zzu()), "_eid");
                                                                Boolean valueOf2 = Boolean.valueOf(l3 != null);
                                                                if (zzd2 == 1) {
                                                                    arrayList2.add((zzbr.zzc) ((zzfd) zza29.zzu()));
                                                                    if (valueOf2.booleanValue() && !(zzaj2.zzi == null && zzaj2.zzj == null && zzaj2.zzk == null)) {
                                                                        hashMap.put(zza29.zzd(), zzaj2.zza((Long) null, (Long) null, (Boolean) null));
                                                                    }
                                                                    zza26.zza(i28, zza29);
                                                                    zza4 = zza13;
                                                                    secureRandom = zzh3;
                                                                    zza5 = zza26;
                                                                    i2 = i28;
                                                                } else {
                                                                    if (zzh3.nextInt(zzd2) == 0) {
                                                                        long j11 = (long) zzd2;
                                                                        zzh().zza(zza29, "_sr", (Object) Long.valueOf(j11));
                                                                        arrayList2.add((zzbr.zzc) ((zzfd) zza29.zzu()));
                                                                        if (valueOf2.booleanValue()) {
                                                                            zzaj2 = zzaj2.zza((Long) null, Long.valueOf(j11), (Boolean) null);
                                                                        }
                                                                        hashMap.put(zza29.zzd(), zzaj2.zza(zza29.zzf(), j4));
                                                                        zza4 = zza13;
                                                                        secureRandom = zzh3;
                                                                        zza6 = zza26;
                                                                        i3 = i28;
                                                                    } else {
                                                                        long j12 = j4;
                                                                        secureRandom = zzh3;
                                                                        if (zzaj2.zzh != null) {
                                                                            zza6 = zza26;
                                                                            zza4 = zza13;
                                                                            i3 = i28;
                                                                            j5 = zzaj2.zzh.longValue();
                                                                        } else {
                                                                            this.zzj.zzi();
                                                                            zza4 = zza13;
                                                                            zza6 = zza26;
                                                                            i3 = i28;
                                                                            j5 = zzla.zza(zza29.zzg(), j10);
                                                                        }
                                                                        if (j5 != j12) {
                                                                            zzh().zza(zza29, "_efs", (Object) 1L);
                                                                            long j13 = (long) zzd2;
                                                                            zzh().zza(zza29, "_sr", (Object) Long.valueOf(j13));
                                                                            arrayList2.add((zzbr.zzc) ((zzfd) zza29.zzu()));
                                                                            if (valueOf2.booleanValue()) {
                                                                                zzaj2 = zzaj2.zza((Long) null, Long.valueOf(j13), true);
                                                                            }
                                                                            hashMap.put(zza29.zzd(), zzaj2.zza(zza29.zzf(), j12));
                                                                        } else if (valueOf2.booleanValue()) {
                                                                            hashMap.put(zza29.zzd(), zzaj2.zza(l3, (Long) null, (Boolean) null));
                                                                        }
                                                                    }
                                                                    i2 = i3;
                                                                    zza5 = zza6;
                                                                    zza5.zza(i2, zza29);
                                                                }
                                                            }
                                                        }
                                                    }
                                                    z3 = false;
                                                    if (z3) {
                                                    }
                                                    if (zzd2 > 0) {
                                                    }
                                                }
                                                i28 = i2 + 1;
                                                zzh3 = secureRandom;
                                                zza26 = zza5;
                                                zza13 = zza4;
                                            }
                                            zza2 = zza13;
                                            zza3 = zza26;
                                            if (arrayList2.size() < zza3.zzb()) {
                                                zza3.zzc().zza((Iterable<? extends zzbr.zzc>) arrayList2);
                                            }
                                            for (Map.Entry value : hashMap.entrySet()) {
                                                zze().zza((zzaj) value.getValue());
                                            }
                                        } else {
                                            zza2 = zza13;
                                            zza3 = zza26;
                                        }
                                        if (!this.zzj.zzb().zze(zza3.zzj(), zzap.zzcg)) {
                                            zza(zza3);
                                        }
                                        zza zza31 = zza2;
                                        String zzx2 = zza31.zza.zzx();
                                        zzg zzb4 = zze().zzb(zzx2);
                                        if (zzb4 == null) {
                                            this.zzj.zzr().zzf().zza("Bundling raw events w/o app info. appId", zzfj.zza(zza31.zza.zzx()));
                                        } else if (zza3.zzb() > 0) {
                                            long zzk3 = zzb4.zzk();
                                            if (zzk3 != 0) {
                                                zza3.zze(zzk3);
                                            } else {
                                                zza3.zzi();
                                            }
                                            long zzj2 = zzb4.zzj();
                                            if (zzj2 != 0) {
                                                zzk3 = zzj2;
                                            }
                                            if (zzk3 != 0) {
                                                zza3.zzd(zzk3);
                                            } else {
                                                zza3.zzh();
                                            }
                                            zzb4.zzv();
                                            zza3.zzg((int) zzb4.zzs());
                                            zzb4.zza(zza3.zzf());
                                            zzb4.zzb(zza3.zzg());
                                            String zzad = zzb4.zzad();
                                            if (zzad != null) {
                                                zza3.zzj(zzad);
                                            } else {
                                                zza3.zzk();
                                            }
                                            zze().zza(zzb4);
                                        }
                                        if (zza3.zzb() > 0) {
                                            this.zzj.zzu();
                                            zzbo.zzb zza32 = zzc().zza(zza31.zza.zzx());
                                            if (zza32 != null) {
                                                if (zza32.zza()) {
                                                    zza3.zzi(zza32.zzb());
                                                    zze().zza((zzbr.zzg) ((zzfd) zza3.zzu()), z2);
                                                }
                                            }
                                            if (TextUtils.isEmpty(zza31.zza.zzam())) {
                                                zza3.zzi(-1);
                                            } else {
                                                this.zzj.zzr().zzi().zza("Did not find measurement config or missing version info. appId", zzfj.zza(zza31.zza.zzx()));
                                            }
                                            zze().zza((zzbr.zzg) ((zzfd) zza3.zzu()), z2);
                                        }
                                        zzac zze4 = zze();
                                        List<Long> list = zza31.zzb;
                                        Preconditions.checkNotNull(list);
                                        zze4.zzd();
                                        zze4.zzak();
                                        StringBuilder sb2 = new StringBuilder("rowid in (");
                                        for (int i29 = 0; i29 < list.size(); i29++) {
                                            if (i29 != 0) {
                                                sb2.append(",");
                                            }
                                            sb2.append(list.get(i29).longValue());
                                        }
                                        sb2.append(")");
                                        int delete = zze4.c_().delete("raw_events", sb2.toString(), (String[]) null);
                                        if (delete != list.size()) {
                                            zze4.zzr().zzf().zza("Deleted fewer rows from raw events table than expected", Integer.valueOf(delete), Integer.valueOf(list.size()));
                                        }
                                        zzac zze5 = zze();
                                        try {
                                            zze5.c_().execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", new String[]{zzx2, zzx2});
                                        } catch (SQLiteException e3) {
                                            zze5.zzr().zzf().zza("Failed to remove unused event metadata. appId", zzfj.zza(zzx2), e3);
                                        }
                                        zze().b_();
                                        zze().zzh();
                                        return true;
                                    }
                                    zze().b_();
                                    zze().zzh();
                                    return false;
                                }
                            }
                            z = true;
                            if (z) {
                            }
                        } else {
                            str9 = cursor.getString(0);
                            try {
                                str10 = cursor.getString(1);
                                cursor.close();
                            } catch (SQLiteException e4) {
                                sQLiteException = e4;
                            }
                        }
                    } catch (SQLiteException e5) {
                        sQLiteException = e5;
                        str9 = null;
                        try {
                            zze2.zzr().zzf().zza("Data loss. Error selecting raw event. appId", zzfj.zza(str9), sQLiteException);
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (zza13.zzc != null) {
                            }
                            z = true;
                            if (z) {
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursor != null) {
                            }
                            throw th;
                        }
                    }
                } else {
                    int i30 = (j7 > -1 ? 1 : (j7 == -1 ? 0 : -1));
                    String[] strArr3 = i30 != 0 ? new String[]{null, String.valueOf(j7)} : new String[]{null};
                    String str21 = i30 != 0 ? " and rowid <= ?" : str13;
                    StringBuilder sb3 = new StringBuilder(String.valueOf(str21).length() + 84);
                    sb3.append("select metadata_fingerprint from raw_events where app_id = ?");
                    sb3.append(str21);
                    sb3.append(" order by rowid limit 1;");
                    cursor = c_.rawQuery(sb3.toString(), strArr3);
                    if (!cursor.moveToFirst()) {
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (zza13.zzc != null) {
                        }
                        z = true;
                        if (z) {
                        }
                    } else {
                        str10 = cursor.getString(0);
                        cursor.close();
                        str9 = null;
                    }
                }
                SQLiteDatabase sQLiteDatabase = c_;
                cursor = c_.query("raw_events_metadata", new String[]{"metadata"}, "app_id = ? and metadata_fingerprint = ?", new String[]{str9, str10}, (String) null, (String) null, "rowid", "2");
                if (!cursor.moveToFirst()) {
                    zze2.zzr().zzf().zza("Raw event metadata record is missing. appId", zzfj.zza(str9));
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (zza13.zzc != null) {
                    }
                    z = true;
                    if (z) {
                    }
                } else {
                    zzbr.zzg zzg2 = (zzbr.zzg) ((zzfd) ((zzbr.zzg.zza) zzkw.zza(zzbr.zzg.zzbf(), cursor.getBlob(0))).zzu());
                    if (cursor.moveToNext()) {
                        zze2.zzr().zzi().zza("Get multiple raw event metadata records, expected one. appId", zzfj.zza(str9));
                    }
                    cursor.close();
                    zza13.zza(zzg2);
                    if (j7 != -1) {
                        str11 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?";
                        strArr = new String[]{str9, str10, String.valueOf(j7)};
                    } else {
                        str11 = "app_id = ? and metadata_fingerprint = ?";
                        strArr = new String[]{str9, str10};
                    }
                    cursor = sQLiteDatabase.query("raw_events", new String[]{"rowid", AppMeasurementSdk.ConditionalUserProperty.NAME, "timestamp", PhotosOemApi.PATH_SPECIAL_TYPE_DATA}, str11, strArr, (String) null, (String) null, "rowid", (String) null);
                    if (!cursor.moveToFirst()) {
                        zze2.zzr().zzi().zza("Raw event data disappeared while in transaction. appId", zzfj.zza(str9));
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (zza13.zzc != null) {
                        }
                        z = true;
                        if (z) {
                        }
                    } else {
                        do {
                            long j14 = cursor.getLong(0);
                            try {
                                zzbr.zzc.zza zza33 = (zzbr.zzc.zza) zzkw.zza(zzbr.zzc.zzj(), cursor.getBlob(3));
                                zza33.zza(cursor.getString(1)).zza(cursor.getLong(2));
                                if (!zza13.zza(j14, (zzbr.zzc) ((zzfd) zza33.zzu()))) {
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    if (zza13.zzc != null) {
                                    }
                                    z = true;
                                    if (z) {
                                    }
                                }
                            } catch (IOException e6) {
                                zze2.zzr().zzf().zza("Data loss. Failed to merge raw event. appId", zzfj.zza(str9), e6);
                            }
                        } while (cursor.moveToNext());
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (zza13.zzc != null) {
                        }
                        z = true;
                        if (z) {
                        }
                    }
                }
            } catch (SQLiteException e7) {
                sQLiteException = e7;
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (IOException e8) {
            zze2.zzr().zzf().zza("Data loss. Failed to merge raw event metadata. appId", zzfj.zza(str9), e8);
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th4) {
            Throwable th5 = th4;
            zze().zzh();
            throw th5;
        }
    }

    private final void zzaa() {
        zzw();
        if (this.zzq || this.zzr || this.zzs) {
            this.zzj.zzr().zzx().zza("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzq), Boolean.valueOf(this.zzr), Boolean.valueOf(this.zzs));
            return;
        }
        this.zzj.zzr().zzx().zza("Stopping uploading service(s)");
        List<Runnable> list = this.zzn;
        if (list != null) {
            for (Runnable run : list) {
                run.run();
            }
            this.zzn.clear();
        }
    }

    private final boolean zzab() {
        zzw();
        if (this.zzj.zzb().zza(zzap.zzcf)) {
            FileLock fileLock = this.zzt;
            if (fileLock != null && fileLock.isValid()) {
                this.zzj.zzr().zzx().zza("Storage concurrent access okay");
                return true;
            }
        }
        try {
            FileChannel channel = new RandomAccessFile(new File(this.zzj.zzn().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
            this.zzu = channel;
            FileLock tryLock = channel.tryLock();
            this.zzt = tryLock;
            if (tryLock != null) {
                this.zzj.zzr().zzx().zza("Storage concurrent access okay");
                return true;
            }
            this.zzj.zzr().zzf().zza("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e2) {
            this.zzj.zzr().zzf().zza("Failed to acquire storage lock", e2);
            return false;
        } catch (IOException e3) {
            this.zzj.zzr().zzf().zza("Failed to access storage lock file", e3);
            return false;
        } catch (OverlappingFileLockException e4) {
            this.zzj.zzr().zzi().zza("Storage lock already acquired", e4);
            return false;
        }
    }

    private final Boolean zzb(zzg zzg2) {
        try {
            if (zzg2.zzm() != -2147483648L) {
                if (zzg2.zzm() == ((long) Wrappers.packageManager(this.zzj.zzn()).getPackageInfo(zzg2.zzc(), 0).versionCode)) {
                    return true;
                }
            } else {
                String str = Wrappers.packageManager(this.zzj.zzn()).getPackageInfo(zzg2.zzc(), 0).versionName;
                if (zzg2.zzl() != null && zzg2.zzl().equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException e2) {
            return null;
        }
    }

    private final void zzb(zzbr.zzc.zza zza2, zzbr.zzc.zza zza3) {
        Preconditions.checkArgument("_e".equals(zza2.zzd()));
        zzh();
        zzbr.zze zza4 = zzkw.zza((zzbr.zzc) ((zzfd) zza2.zzu()), "_et");
        if (zza4.zze() && zza4.zzf() > 0) {
            long zzf2 = zza4.zzf();
            zzh();
            zzbr.zze zza5 = zzkw.zza((zzbr.zzc) ((zzfd) zza3.zzu()), "_et");
            if (zza5 != null && zza5.zzf() > 0) {
                zzf2 += zza5.zzf();
            }
            zzh().zza(zza3, "_et", (Object) Long.valueOf(zzf2));
            zzh().zza(zza2, "_fr", (Object) 1L);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:123:0x03bd A[Catch:{ IOException -> 0x0a46, all -> 0x0ad3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x03fa A[Catch:{ IOException -> 0x0a46, all -> 0x0ad3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0409  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0421 A[Catch:{ IOException -> 0x0a46, all -> 0x0ad3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0476 A[Catch:{ IOException -> 0x0a46, all -> 0x0ad3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x04a4  */
    /* JADX WARNING: Removed duplicated region for block: B:315:0x0a43 A[Catch:{ IOException -> 0x0a46, all -> 0x0ad3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0247 A[Catch:{ IOException -> 0x0a46, all -> 0x0ad3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x024f A[Catch:{ IOException -> 0x0a46, all -> 0x0ad3 }] */
    private final void zzb(zzan zzan, zzm zzm2) {
        boolean z;
        boolean z2;
        long j;
        long j2;
        long intValue;
        zzaj zzaj;
        zzbr.zzg.zza zza2;
        boolean z3;
        boolean z4;
        long j3;
        zzlb zzlb;
        int i;
        char c2;
        int i2;
        zzla zzla;
        Iterator it;
        zzan zzan2 = zzan;
        zzm zzm3 = zzm2;
        Preconditions.checkNotNull(zzm2);
        Preconditions.checkNotEmpty(zzm3.zza);
        long nanoTime = System.nanoTime();
        zzw();
        zzk();
        String str = zzm3.zza;
        if (zzh().zza(zzan2, zzm3)) {
            if (!zzm3.zzh) {
                zzc(zzm3);
            } else if (zzc().zzb(str, zzan2.zza)) {
                this.zzj.zzr().zzi().zza("Dropping blacklisted event. appId", zzfj.zza(str), this.zzj.zzj().zza(zzan2.zza));
                boolean z5 = zzc().zzg(str) || zzc().zzh(str);
                if (!z5 && !"_err".equals(zzan2.zza)) {
                    this.zzj.zzi().zza(str, 11, "_ev", zzan2.zza, 0);
                }
                if (z5) {
                    zzg zzb2 = zze().zzb(str);
                    if (zzb2 != null) {
                        if (Math.abs(this.zzj.zzm().currentTimeMillis() - Math.max(zzb2.zzu(), zzb2.zzt())) > zzap.zzy.zza(null).longValue()) {
                            this.zzj.zzr().zzw().zza("Fetching config for blacklisted app");
                            zza(zzb2);
                        }
                    }
                }
            } else {
                if (zzjj.zzb() && this.zzj.zzb().zza(zzap.zzdf)) {
                    zzfn zzfn = new zzfn(zzan2.zza, zzan2.zzc, zzan2.zzb.zzb(), zzan2.zzd);
                    zzla zzi2 = this.zzj.zzi();
                    int zza3 = this.zzj.zzb().zza(str, zzap.zzah, 25, 100);
                    Iterator it2 = new TreeSet(zzfn.zzd.keySet()).iterator();
                    int i3 = 0;
                    while (it2.hasNext()) {
                        String str2 = (String) it2.next();
                        if (zzla.zza(str2)) {
                            i3++;
                            if (i3 > zza3) {
                                StringBuilder sb = new StringBuilder(48);
                                sb.append("Event can't contain more than ");
                                sb.append(zza3);
                                sb.append(" params");
                                i2 = zza3;
                                it = it2;
                                zzla = zzi2;
                                zzi2.zzr().zzh().zza(sb.toString(), zzi2.zzo().zza(zzfn.zza), zzi2.zzo().zza(zzfn.zzd));
                                zzla.zza(zzfn.zzd, 5);
                                zzfn.zzd.remove(str2);
                            } else {
                                zzla = zzi2;
                                i2 = zza3;
                                it = it2;
                            }
                        } else {
                            zzla = zzi2;
                            i2 = zza3;
                            it = it2;
                        }
                        zza3 = i2;
                        it2 = it;
                        zzi2 = zzla;
                    }
                    zzan2 = new zzan(zzfn.zza, new zzam(new Bundle(zzfn.zzd)), zzfn.zzb, zzfn.zzc);
                }
                if (this.zzj.zzr().zza(2)) {
                    this.zzj.zzr().zzx().zza("Logging event", this.zzj.zzj().zza(zzan2));
                }
                zze().zzf();
                zzc(zzm3);
                boolean z6 = zzju.zzb() && this.zzj.zzb().zza(zzap.zzde);
                if (!FirebaseAnalytics.Event.ECOMMERCE_PURCHASE.equals(zzan2.zza)) {
                    if (z6) {
                        if (!FirebaseAnalytics.Event.PURCHASE.equals(zzan2.zza)) {
                            if (FirebaseAnalytics.Event.REFUND.equals(zzan2.zza)) {
                            }
                        }
                    }
                    z = false;
                    if (!"_iap".equals(zzan2.zza)) {
                        if (!z) {
                            z2 = false;
                            if (z2) {
                                String zzd2 = zzan2.zzb.zzd("currency");
                                if (z) {
                                    double doubleValue = zzan2.zzb.zzc("value").doubleValue() * 1000000.0d;
                                    if (doubleValue == 0.0d) {
                                        doubleValue = ((double) zzan2.zzb.zzb("value").longValue()) * 1000000.0d;
                                    }
                                    if (doubleValue > 9.223372036854776E18d || doubleValue < -9.223372036854776E18d) {
                                        this.zzj.zzr().zzi().zza("Data lost. Currency value is too big. appId", zzfj.zza(str), Double.valueOf(doubleValue));
                                        j = nanoTime;
                                        z4 = false;
                                        if (!z4) {
                                            zze().b_();
                                            zze().zzh();
                                            return;
                                        }
                                    } else {
                                        j3 = Math.round(doubleValue);
                                        if (zzju.zzb() && this.zzj.zzb().zza(zzap.zzde) && FirebaseAnalytics.Event.REFUND.equals(zzan2.zza)) {
                                            j3 = -j3;
                                        }
                                    }
                                } else {
                                    j3 = zzan2.zzb.zzb("value").longValue();
                                }
                                if (!TextUtils.isEmpty(zzd2)) {
                                    String upperCase = zzd2.toUpperCase(Locale.US);
                                    if (upperCase.matches("[A-Z]{3}")) {
                                        String valueOf = String.valueOf("_ltv_");
                                        String valueOf2 = String.valueOf(upperCase);
                                        String concat = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                                        zzlb zzc2 = zze().zzc(str, concat);
                                        if (zzc2 == null) {
                                            j = nanoTime;
                                            c2 = 0;
                                            i = 1;
                                        } else if (!(zzc2.zze instanceof Long)) {
                                            j = nanoTime;
                                            c2 = 0;
                                            i = 1;
                                        } else {
                                            j = nanoTime;
                                            zzlb zzlb2 = new zzlb(str, zzan2.zzc, concat, this.zzj.zzm().currentTimeMillis(), Long.valueOf(((Long) zzc2.zze).longValue() + j3));
                                            zzlb = zzlb2;
                                            if (!zze().zza(zzlb)) {
                                                this.zzj.zzr().zzf().zza("Too many unique user properties are set. Ignoring user property. appId", zzfj.zza(str), this.zzj.zzj().zzc(zzlb.zzc), zzlb.zze);
                                                this.zzj.zzi().zza(str, 9, (String) null, (String) null, 0);
                                            }
                                        }
                                        zzac zze2 = zze();
                                        int zzb3 = this.zzj.zzb().zzb(str, zzap.zzad) - i;
                                        Preconditions.checkNotEmpty(str);
                                        zze2.zzd();
                                        zze2.zzak();
                                        try {
                                            SQLiteDatabase c_ = zze2.c_();
                                            String[] strArr = new String[3];
                                            strArr[c2] = str;
                                            strArr[1] = str;
                                            try {
                                                strArr[2] = String.valueOf(zzb3);
                                                c_.execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", strArr);
                                            } catch (SQLiteException e2) {
                                                e = e2;
                                            }
                                        } catch (SQLiteException e3) {
                                            e = e3;
                                            zze2.zzr().zzf().zza("Error pruning currencies. appId", zzfj.zza(str), e);
                                            zzlb zzlb3 = new zzlb(str, zzan2.zzc, concat, this.zzj.zzm().currentTimeMillis(), Long.valueOf(j3));
                                            zzlb = zzlb3;
                                            if (!zze().zza(zzlb)) {
                                            }
                                            z4 = true;
                                            if (!z4) {
                                            }
                                            boolean zza4 = zzla.zza(zzan2.zza);
                                            boolean equals = "_err".equals(zzan2.zza);
                                            if (zzju.zzb()) {
                                            }
                                            j2 = 1;
                                            String str3 = str;
                                            zzab zza5 = zze().zza(zzx(), str, j2, true, zza4, false, equals, false);
                                            intValue = zza5.zzb - ((long) zzap.zzj.zza(null).intValue());
                                            if (intValue <= 0) {
                                            }
                                        }
                                        zzlb zzlb32 = new zzlb(str, zzan2.zzc, concat, this.zzj.zzm().currentTimeMillis(), Long.valueOf(j3));
                                        zzlb = zzlb32;
                                        if (!zze().zza(zzlb)) {
                                        }
                                    } else {
                                        j = nanoTime;
                                    }
                                } else {
                                    j = nanoTime;
                                }
                                z4 = true;
                                if (!z4) {
                                }
                            } else {
                                j = nanoTime;
                            }
                            boolean zza42 = zzla.zza(zzan2.zza);
                            boolean equals2 = "_err".equals(zzan2.zza);
                            if (zzju.zzb() || !this.zzj.zzb().zze(zzm3.zza, zzap.zzda)) {
                                j2 = 1;
                            } else {
                                this.zzj.zzi();
                                j2 = zzla.zza(zzan2.zzb) + 1;
                            }
                            String str32 = str;
                            zzab zza52 = zze().zza(zzx(), str, j2, true, zza42, false, equals2, false);
                            intValue = zza52.zzb - ((long) zzap.zzj.zza(null).intValue());
                            if (intValue <= 0) {
                                if (intValue % 1000 == 1) {
                                    this.zzj.zzr().zzf().zza("Data loss. Too many events logged. appId, count", zzfj.zza(str32), Long.valueOf(zza52.zzb));
                                }
                                zze().b_();
                                zze().zzh();
                                return;
                            }
                            if (zza42) {
                                long intValue2 = zza52.zza - ((long) zzap.zzl.zza(null).intValue());
                                if (intValue2 > 0) {
                                    if (intValue2 % 1000 == 1) {
                                        this.zzj.zzr().zzf().zza("Data loss. Too many public events logged. appId, count", zzfj.zza(str32), Long.valueOf(zza52.zza));
                                    }
                                    this.zzj.zzi().zza(str32, 16, "_ev", zzan2.zza, 0);
                                    zze().b_();
                                    zze().zzh();
                                    return;
                                }
                            }
                            if (equals2) {
                                long max = zza52.zzd - ((long) Math.max(0, Math.min(1000000, this.zzj.zzb().zzb(zzm3.zza, zzap.zzk))));
                                if (max > 0) {
                                    if (max == 1) {
                                        this.zzj.zzr().zzf().zza("Too many error events logged. appId, count", zzfj.zza(str32), Long.valueOf(zza52.zzd));
                                    }
                                    zze().b_();
                                    zze().zzh();
                                    return;
                                }
                            }
                            Bundle zzb4 = zzan2.zzb.zzb();
                            this.zzj.zzi().zza(zzb4, "_o", (Object) zzan2.zzc);
                            String str4 = str32;
                            if (this.zzj.zzi().zzf(str4)) {
                                this.zzj.zzi().zza(zzb4, "_dbg", (Object) 1L);
                                this.zzj.zzi().zza(zzb4, "_r", (Object) 1L);
                            }
                            if ("_s".equals(zzan2.zza)) {
                                if (this.zzj.zzb().zze(zzm3.zza, zzap.zzat)) {
                                    zzlb zzc3 = zze().zzc(zzm3.zza, "_sno");
                                    if (zzc3 != null && (zzc3.zze instanceof Long)) {
                                        this.zzj.zzi().zza(zzb4, "_sno", zzc3.zze);
                                    }
                                }
                            }
                            if ("_s".equals(zzan2.zza) && this.zzj.zzb().zze(zzm3.zza, zzap.zzax) && !this.zzj.zzb().zze(zzm3.zza, zzap.zzat)) {
                                zzb(new zzkz("_sno", 0, (String) null), zzm3);
                            }
                            long zzc4 = zze().zzc(str4);
                            if (zzc4 > 0) {
                                this.zzj.zzr().zzi().zza("Data lost. Too many events stored on disk, deleted. appId", zzfj.zza(str4), Long.valueOf(zzc4));
                            }
                            zzgq zzgq = this.zzj;
                            String str5 = zzan2.zzc;
                            String str6 = zzan2.zza;
                            long j4 = zzan2.zzd;
                            String str7 = "_r";
                            String str8 = str5;
                            String str9 = str4;
                            zzak zzak = new zzak(zzgq, str8, str4, str6, j4, 0, zzb4);
                            zzaj zza6 = zze().zza(str9, zzak.zzb);
                            if (zza6 != null) {
                                zzak = zzak.zza(this.zzj, zza6.zzf);
                                zzaj = zza6.zza(zzak.zzc);
                            } else if (zze().zzh(str9) < ((long) this.zzj.zzb().zza(str9)) || !zza42) {
                                zzaj = new zzaj(str9, zzak.zzb, 0, 0, zzak.zzc, 0, (Long) null, (Long) null, (Long) null, (Boolean) null);
                            } else {
                                this.zzj.zzr().zzf().zza("Too many event names used, ignoring event. appId, name, supported count", zzfj.zza(str9), this.zzj.zzj().zza(zzak.zzb), Integer.valueOf(this.zzj.zzb().zza(str9)));
                                this.zzj.zzi().zza(str9, 8, (String) null, (String) null, 0);
                                zze().zzh();
                                return;
                            }
                            zze().zza(zzaj);
                            zzw();
                            zzk();
                            Preconditions.checkNotNull(zzak);
                            Preconditions.checkNotNull(zzm2);
                            Preconditions.checkNotEmpty(zzak.zza);
                            Preconditions.checkArgument(zzak.zza.equals(zzm3.zza));
                            zza2 = zzbr.zzg.zzbf().zza(1).zza("android");
                            if (!TextUtils.isEmpty(zzm3.zza)) {
                                zza2.zzf(zzm3.zza);
                            }
                            if (!TextUtils.isEmpty(zzm3.zzd)) {
                                zza2.zze(zzm3.zzd);
                            }
                            if (!TextUtils.isEmpty(zzm3.zzc)) {
                                zza2.zzg(zzm3.zzc);
                            }
                            if (zzm3.zzj != -2147483648L) {
                                zza2.zzh((int) zzm3.zzj);
                            }
                            zza2.zzf(zzm3.zze);
                            if (!TextUtils.isEmpty(zzm3.zzb)) {
                                zza2.zzk(zzm3.zzb);
                            }
                            if (zzll.zzb() && this.zzj.zzb().zze(zzm3.zza, zzap.zzch)) {
                                if (TextUtils.isEmpty(zza2.zzl()) && !TextUtils.isEmpty(zzm3.zzv)) {
                                    zza2.zzp(zzm3.zzv);
                                }
                                if (TextUtils.isEmpty(zza2.zzl()) && TextUtils.isEmpty(zza2.zzo()) && !TextUtils.isEmpty(zzm3.zzr)) {
                                    zza2.zzo(zzm3.zzr);
                                }
                            } else if (TextUtils.isEmpty(zza2.zzl()) && !TextUtils.isEmpty(zzm3.zzr)) {
                                zza2.zzo(zzm3.zzr);
                            }
                            if (zzm3.zzf != 0) {
                                zza2.zzh(zzm3.zzf);
                            }
                            zza2.zzk(zzm3.zzt);
                            if (this.zzj.zzb().zze(zzm3.zza, zzap.zzbf)) {
                                List<Integer> zzf2 = zzh().zzf();
                                if (zzf2 != null) {
                                    zza2.zzd((Iterable<? extends Integer>) zzf2);
                                }
                            }
                            Pair<String, Boolean> zza7 = this.zzj.zzc().zza(zzm3.zza);
                            if (zza7 == null || TextUtils.isEmpty((CharSequence) zza7.first)) {
                                if (!this.zzj.zzx().zza(this.zzj.zzn()) && zzm3.zzp) {
                                    String string = Settings.Secure.getString(this.zzj.zzn().getContentResolver(), "android_id");
                                    if (string == null) {
                                        this.zzj.zzr().zzi().zza("null secure ID. appId", zzfj.zza(zza2.zzj()));
                                        string = "null";
                                    } else if (string.isEmpty()) {
                                        this.zzj.zzr().zzi().zza("empty secure ID. appId", zzfj.zza(zza2.zzj()));
                                    }
                                    zza2.zzm(string);
                                }
                            } else if (zzm3.zzo) {
                                zza2.zzh((String) zza7.first);
                                if (zza7.second != null) {
                                    zza2.zza(((Boolean) zza7.second).booleanValue());
                                }
                            }
                            this.zzj.zzx().zzaa();
                            zzbr.zzg.zza zzc5 = zza2.zzc(Build.MODEL);
                            this.zzj.zzx().zzaa();
                            zzc5.zzb(Build.VERSION.RELEASE).zzf((int) this.zzj.zzx().zzf()).zzd(this.zzj.zzx().zzg());
                            if (!this.zzj.zzb().zza(zzap.zzdh)) {
                                zza2.zzj(zzm3.zzl);
                            }
                            if (this.zzj.zzab()) {
                                zza2.zzj();
                                if (!TextUtils.isEmpty((CharSequence) null)) {
                                    zza2.zzn((String) null);
                                }
                            }
                            zzg zzb5 = zze().zzb(zzm3.zza);
                            if (zzb5 == null) {
                                zzb5 = new zzg(this.zzj, zzm3.zza);
                                zzb5.zza(this.zzj.zzi().zzk());
                                zzb5.zzf(zzm3.zzk);
                                zzb5.zzb(zzm3.zzb);
                                zzb5.zze(this.zzj.zzc().zzb(zzm3.zza));
                                zzb5.zzg(0);
                                zzb5.zza(0);
                                zzb5.zzb(0);
                                zzb5.zzg(zzm3.zzc);
                                zzb5.zzc(zzm3.zzj);
                                zzb5.zzh(zzm3.zzd);
                                zzb5.zzd(zzm3.zze);
                                zzb5.zze(zzm3.zzf);
                                zzb5.zza(zzm3.zzh);
                                if (!this.zzj.zzb().zza(zzap.zzdh)) {
                                    zzb5.zzp(zzm3.zzl);
                                }
                                zzb5.zzf(zzm3.zzt);
                                zze().zza(zzb5);
                            }
                            if (!TextUtils.isEmpty(zzb5.zzd())) {
                                zza2.zzi(zzb5.zzd());
                            }
                            if (!TextUtils.isEmpty(zzb5.zzi())) {
                                zza2.zzl(zzb5.zzi());
                            }
                            List<zzlb> zza8 = zze().zza(zzm3.zza);
                            for (int i4 = 0; i4 < zza8.size(); i4++) {
                                zzbr.zzk.zza zza9 = zzbr.zzk.zzj().zza(zza8.get(i4).zzc).zza(zza8.get(i4).zzd);
                                zzh().zza(zza9, zza8.get(i4).zze);
                                zza2.zza(zza9);
                            }
                            long zza10 = zze().zza((zzbr.zzg) ((zzfd) zza2.zzu()));
                            zzac zze3 = zze();
                            if (zzak.zze != null) {
                                Iterator<String> it3 = zzak.zze.iterator();
                                while (true) {
                                    if (!it3.hasNext()) {
                                        boolean zzc6 = zzc().zzc(zzak.zza, zzak.zzb);
                                        zzab zza11 = zze().zza(zzx(), zzak.zza, false, false, false, false, false);
                                        if (zzc6 && zza11.zze < ((long) this.zzj.zzb().zzb(zzak.zza))) {
                                            z3 = true;
                                        }
                                    } else if (str7.equals(it3.next())) {
                                        z3 = true;
                                        break;
                                    }
                                }
                                if (zze3.zza(zzak, zza10, z3)) {
                                    this.zzm = 0;
                                }
                                zze().b_();
                                if ((!zzkz.zzb() || !this.zzj.zzb().zze(zzm3.zza, zzap.zzcy)) && this.zzj.zzr().zza(2)) {
                                    this.zzj.zzr().zzx().zza("Event recorded", this.zzj.zzj().zza(zzak));
                                }
                                zze().zzh();
                                zzz();
                                this.zzj.zzr().zzx().zza("Background event processing time, ms", Long.valueOf(((System.nanoTime() - j) + 500000) / 1000000));
                                return;
                            }
                            z3 = false;
                            if (zze3.zza(zzak, zza10, z3)) {
                            }
                            zze().b_();
                            this.zzj.zzr().zzx().zza("Event recorded", this.zzj.zzj().zza(zzak));
                            zze().zzh();
                            zzz();
                            this.zzj.zzr().zzx().zza("Background event processing time, ms", Long.valueOf(((System.nanoTime() - j) + 500000) / 1000000));
                            return;
                        }
                    }
                    z2 = true;
                    if (z2) {
                    }
                    boolean zza422 = zzla.zza(zzan2.zza);
                    boolean equals22 = "_err".equals(zzan2.zza);
                    if (zzju.zzb()) {
                    }
                    j2 = 1;
                    String str322 = str;
                    zzab zza522 = zze().zza(zzx(), str, j2, true, zza422, false, equals22, false);
                    intValue = zza522.zzb - ((long) zzap.zzj.zza(null).intValue());
                    if (intValue <= 0) {
                    }
                }
                z = true;
                if (!"_iap".equals(zzan2.zza)) {
                }
                z2 = true;
                if (z2) {
                }
                try {
                    boolean zza4222 = zzla.zza(zzan2.zza);
                    boolean equals222 = "_err".equals(zzan2.zza);
                    if (zzju.zzb()) {
                    }
                    j2 = 1;
                    String str3222 = str;
                    zzab zza5222 = zze().zza(zzx(), str, j2, true, zza4222, false, equals222, false);
                    intValue = zza5222.zzb - ((long) zzap.zzj.zza(null).intValue());
                    if (intValue <= 0) {
                    }
                } catch (IOException e4) {
                    this.zzj.zzr().zzf().zza("Data loss. Failed to insert raw event metadata. appId", zzfj.zza(zza2.zzj()), e4);
                } catch (Throwable th) {
                    Throwable th2 = th;
                    zze().zzh();
                    throw th2;
                }
            }
        }
    }

    private static void zzb(zzkp zzkp) {
        if (zzkp == null) {
            throw new IllegalStateException("Upload Component not created");
        } else if (!zzkp.zzaj()) {
            String valueOf = String.valueOf(zzkp.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    private final boolean zze(zzm zzm2) {
        return (!zzll.zzb() || !this.zzj.zzb().zze(zzm2.zza, zzap.zzch)) ? !TextUtils.isEmpty(zzm2.zzb) || !TextUtils.isEmpty(zzm2.zzr) : !TextUtils.isEmpty(zzm2.zzb) || !TextUtils.isEmpty(zzm2.zzv) || !TextUtils.isEmpty(zzm2.zzr);
    }

    private final zzft zzt() {
        zzft zzft = this.zze;
        if (zzft != null) {
            return zzft;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    private final zzko zzv() {
        zzb((zzkp) this.zzf);
        return this.zzf;
    }

    private final void zzw() {
        this.zzj.zzq().zzd();
    }

    private final long zzx() {
        long currentTimeMillis = this.zzj.zzm().currentTimeMillis();
        zzfv zzc2 = this.zzj.zzc();
        zzc2.zzaa();
        zzc2.zzd();
        long zza2 = zzc2.zzg.zza();
        if (zza2 == 0) {
            zza2 = 1 + ((long) zzc2.zzp().zzh().nextInt(86400000));
            zzc2.zzg.zza(zza2);
        }
        return ((((currentTimeMillis + zza2) / 1000) / 60) / 60) / 24;
    }

    private final boolean zzy() {
        zzw();
        zzk();
        return zze().zzy() || !TextUtils.isEmpty(zze().d_());
    }

    private final void zzz() {
        long j;
        long j2;
        zzw();
        zzk();
        if (this.zzm > 0) {
            long abs = 3600000 - Math.abs(this.zzj.zzm().elapsedRealtime() - this.zzm);
            if (abs > 0) {
                this.zzj.zzr().zzx().zza("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(abs));
                zzt().zzb();
                zzv().zzf();
                return;
            }
            this.zzm = 0;
        }
        if (!this.zzj.zzah() || !zzy()) {
            this.zzj.zzr().zzx().zza("Nothing to upload or uploading impossible");
            zzt().zzb();
            zzv().zzf();
            return;
        }
        long currentTimeMillis = this.zzj.zzm().currentTimeMillis();
        long max = Math.max(0, zzap.zzz.zza(null).longValue());
        boolean z = zze().zzz() || zze().zzk();
        if (z) {
            String zzw2 = this.zzj.zzb().zzw();
            j = (TextUtils.isEmpty(zzw2) || ".none.".equals(zzw2)) ? Math.max(0, zzap.zzt.zza(null).longValue()) : Math.max(0, zzap.zzu.zza(null).longValue());
        } else {
            j = Math.max(0, zzap.zzs.zza(null).longValue());
        }
        long zza2 = this.zzj.zzc().zzc.zza();
        long zza3 = this.zzj.zzc().zzd.zza();
        long j3 = j;
        long j4 = max;
        long max2 = Math.max(zze().zzw(), zze().zzx());
        if (max2 == 0) {
            j2 = 0;
        } else {
            long abs2 = currentTimeMillis - Math.abs(max2 - currentTimeMillis);
            long abs3 = currentTimeMillis - Math.abs(zza2 - currentTimeMillis);
            long abs4 = currentTimeMillis - Math.abs(zza3 - currentTimeMillis);
            long max3 = Math.max(abs3, abs4);
            j2 = abs2 + j4;
            if (z && max3 > 0) {
                j2 = Math.min(abs2, max3) + j3;
            }
            long j5 = j3;
            if (!zzh().zza(max3, j5)) {
                j2 = max3 + j5;
            }
            if (abs4 != 0 && abs4 >= abs2) {
                int i = 0;
                while (true) {
                    if (i >= Math.min(20, Math.max(0, zzap.zzab.zza(null).intValue()))) {
                        j2 = 0;
                        break;
                    }
                    j2 += Math.max(0, zzap.zzaa.zza(null).longValue()) * (1 << i);
                    if (j2 > abs4) {
                        break;
                    }
                    i++;
                }
            }
        }
        if (j2 == 0) {
            this.zzj.zzr().zzx().zza("Next upload time is 0");
            zzt().zzb();
            zzv().zzf();
        } else if (!zzd().zzf()) {
            this.zzj.zzr().zzx().zza("No network");
            zzt().zza();
            zzv().zzf();
        } else {
            long zza4 = this.zzj.zzc().zze.zza();
            long max4 = Math.max(0, zzap.zzq.zza(null).longValue());
            if (!zzh().zza(zza4, max4)) {
                j2 = Math.max(j2, zza4 + max4);
            }
            zzt().zzb();
            long currentTimeMillis2 = j2 - this.zzj.zzm().currentTimeMillis();
            if (currentTimeMillis2 <= 0) {
                currentTimeMillis2 = Math.max(0, zzap.zzv.zza(null).longValue());
                this.zzj.zzc().zzc.zza(this.zzj.zzm().currentTimeMillis());
            }
            this.zzj.zzr().zzx().zza("Upload scheduled in approximately ms", Long.valueOf(currentTimeMillis2));
            zzv().zza(currentTimeMillis2);
        }
    }

    /* access modifiers changed from: protected */
    public final void zza() {
        this.zzj.zzq().zzd();
        zze().zzv();
        if (this.zzj.zzc().zzc.zza() == 0) {
            this.zzj.zzc().zzc.zza(this.zzj.zzm().currentTimeMillis());
        }
        zzz();
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public final void zza(int i, Throwable th, byte[] bArr, String str) {
        zzac zze2;
        zzw();
        zzk();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzr = false;
                zzaa();
                throw th2;
            }
        }
        List<Long> list = this.zzv;
        this.zzv = null;
        boolean z = true;
        if ((i == 200 || i == 204) && th == null) {
            try {
                this.zzj.zzc().zzc.zza(this.zzj.zzm().currentTimeMillis());
                this.zzj.zzc().zzd.zza(0);
                zzz();
                this.zzj.zzr().zzx().zza("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                zze().zzf();
                try {
                    for (Long next : list) {
                        try {
                            zze2 = zze();
                            long longValue = next.longValue();
                            zze2.zzd();
                            zze2.zzak();
                            if (zze2.c_().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                                throw new SQLiteException("Deleted fewer rows from queue than expected");
                            }
                        } catch (SQLiteException e2) {
                            zze2.zzr().zzf().zza("Failed to delete a bundle in a queue table", e2);
                            throw e2;
                        } catch (SQLiteException e3) {
                            if (this.zzw == null || !this.zzw.contains(next)) {
                                throw e3;
                            }
                        }
                    }
                    zze().b_();
                    zze().zzh();
                    this.zzw = null;
                    if (!zzd().zzf() || !zzy()) {
                        this.zzx = -1;
                        zzz();
                    } else {
                        zzl();
                    }
                    this.zzm = 0;
                } catch (Throwable th3) {
                    zze().zzh();
                    throw th3;
                }
            } catch (SQLiteException e4) {
                this.zzj.zzr().zzf().zza("Database error while trying to delete uploaded bundles", e4);
                this.zzm = this.zzj.zzm().elapsedRealtime();
                this.zzj.zzr().zzx().zza("Disable upload, time", Long.valueOf(this.zzm));
            }
        } else {
            this.zzj.zzr().zzx().zza("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            this.zzj.zzc().zzd.zza(this.zzj.zzm().currentTimeMillis());
            if (i != 503) {
                if (i != 429) {
                    z = false;
                }
            }
            if (z) {
                this.zzj.zzc().zze.zza(this.zzj.zzm().currentTimeMillis());
            }
            zze().zza(list);
            zzz();
        }
        this.zzr = false;
        zzaa();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0140 A[Catch:{ all -> 0x03a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0222 A[Catch:{ all -> 0x03a2 }] */
    public final void zza(zzan zzan, zzm zzm2) {
        List<zzv> list;
        List<zzv> list2;
        List<zzv> list3;
        zzan zzan2 = zzan;
        zzm zzm3 = zzm2;
        Preconditions.checkNotNull(zzm2);
        Preconditions.checkNotEmpty(zzm3.zza);
        zzw();
        zzk();
        String str = zzm3.zza;
        long j = zzan2.zzd;
        if (zzh().zza(zzan2, zzm3)) {
            if (!zzm3.zzh) {
                zzc(zzm3);
                return;
            }
            if (this.zzj.zzb().zze(str, zzap.zzbl) && zzm3.zzu != null) {
                if (zzm3.zzu.contains(zzan2.zza)) {
                    Bundle zzb2 = zzan2.zzb.zzb();
                    zzb2.putLong("ga_safelisted", 1);
                    zzan zzan3 = new zzan(zzan2.zza, new zzam(zzb2), zzan2.zzc, zzan2.zzd);
                    zzan2 = zzan3;
                } else {
                    this.zzj.zzr().zzw().zza("Dropping non-safelisted event. appId, event name, origin", str, zzan2.zza, zzan2.zzc);
                    return;
                }
            }
            zze().zzf();
            try {
                zzac zze2 = zze();
                Preconditions.checkNotEmpty(str);
                zze2.zzd();
                zze2.zzak();
                int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                if (i < 0) {
                    zze2.zzr().zzi().zza("Invalid time querying timed out conditional properties", zzfj.zza(str), Long.valueOf(j));
                    list = Collections.emptyList();
                } else {
                    list = zze2.zza("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j)});
                }
                for (zzv next : list) {
                    if (next != null) {
                        if (zzkz.zzb()) {
                            if (this.zzj.zzb().zze(zzm3.zza, zzap.zzcy)) {
                                this.zzj.zzr().zzx().zza("User property timed out", next.zza, this.zzj.zzj().zzc(next.zzc.zza), next.zzc.zza());
                                if (next.zzg != null) {
                                    zzb(new zzan(next.zzg, j), zzm3);
                                }
                                zze().zze(str, next.zzc.zza);
                            }
                        }
                        this.zzj.zzr().zzw().zza("User property timed out", next.zza, this.zzj.zzj().zzc(next.zzc.zza), next.zzc.zza());
                        if (next.zzg != null) {
                        }
                        zze().zze(str, next.zzc.zza);
                    }
                }
                zzac zze3 = zze();
                Preconditions.checkNotEmpty(str);
                zze3.zzd();
                zze3.zzak();
                if (i < 0) {
                    zze3.zzr().zzi().zza("Invalid time querying expired conditional properties", zzfj.zza(str), Long.valueOf(j));
                    list2 = Collections.emptyList();
                } else {
                    list2 = zze3.zza("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j)});
                }
                ArrayList arrayList = new ArrayList(list2.size());
                for (zzv next2 : list2) {
                    if (next2 != null) {
                        if (zzkz.zzb()) {
                            if (this.zzj.zzb().zze(zzm3.zza, zzap.zzcy)) {
                                this.zzj.zzr().zzx().zza("User property expired", next2.zza, this.zzj.zzj().zzc(next2.zzc.zza), next2.zzc.zza());
                                zze().zzb(str, next2.zzc.zza);
                                if (next2.zzk != null) {
                                    arrayList.add(next2.zzk);
                                }
                                zze().zze(str, next2.zzc.zza);
                            }
                        }
                        this.zzj.zzr().zzw().zza("User property expired", next2.zza, this.zzj.zzj().zzc(next2.zzc.zza), next2.zzc.zza());
                        zze().zzb(str, next2.zzc.zza);
                        if (next2.zzk != null) {
                        }
                        zze().zze(str, next2.zzc.zza);
                    }
                }
                ArrayList arrayList2 = arrayList;
                int size = arrayList2.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList2.get(i2);
                    i2++;
                    zzb(new zzan((zzan) obj, j), zzm3);
                }
                zzac zze4 = zze();
                String str2 = zzan2.zza;
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotEmpty(str2);
                zze4.zzd();
                zze4.zzak();
                if (i < 0) {
                    zze4.zzr().zzi().zza("Invalid time querying triggered conditional properties", zzfj.zza(str), zze4.zzo().zza(str2), Long.valueOf(j));
                    list3 = Collections.emptyList();
                } else {
                    list3 = zze4.zza("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j)});
                }
                ArrayList arrayList3 = new ArrayList(list3.size());
                for (zzv next3 : list3) {
                    if (next3 != null) {
                        zzkz zzkz = next3.zzc;
                        zzlb zzlb = r4;
                        zzlb zzlb2 = new zzlb(next3.zza, next3.zzb, zzkz.zza, j, zzkz.zza());
                        if (zze().zza(zzlb)) {
                            if (zzkz.zzb()) {
                                if (this.zzj.zzb().zze(zzm3.zza, zzap.zzcy)) {
                                    this.zzj.zzr().zzx().zza("User property triggered", next3.zza, this.zzj.zzj().zzc(zzlb.zzc), zzlb.zze);
                                }
                            }
                            this.zzj.zzr().zzw().zza("User property triggered", next3.zza, this.zzj.zzj().zzc(zzlb.zzc), zzlb.zze);
                        } else {
                            this.zzj.zzr().zzf().zza("Too many active user properties, ignoring", zzfj.zza(next3.zza), this.zzj.zzj().zzc(zzlb.zzc), zzlb.zze);
                        }
                        if (next3.zzi != null) {
                            arrayList3.add(next3.zzi);
                        }
                        next3.zzc = new zzkz(zzlb);
                        next3.zze = true;
                        zze().zza(next3);
                    }
                }
                zzb(zzan2, zzm3);
                ArrayList arrayList4 = arrayList3;
                int size2 = arrayList4.size();
                int i3 = 0;
                while (i3 < size2) {
                    Object obj2 = arrayList4.get(i3);
                    i3++;
                    zzb(new zzan((zzan) obj2, j), zzm3);
                }
                zze().b_();
            } finally {
                zze().zzh();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzan zzan, String str) {
        zzan zzan2 = zzan;
        zzg zzb2 = zze().zzb(str);
        if (zzb2 == null || TextUtils.isEmpty(zzb2.zzl())) {
            this.zzj.zzr().zzw().zza("No app data available; dropping event", str);
            return;
        }
        Boolean zzb3 = zzb(zzb2);
        if (zzb3 == null) {
            if (!"_ui".equals(zzan2.zza)) {
                this.zzj.zzr().zzi().zza("Could not find package. appId", zzfj.zza(str));
            }
        } else if (!zzb3.booleanValue()) {
            this.zzj.zzr().zzf().zza("App version does not match; dropping event. appId", zzfj.zza(str));
            return;
        }
        zzm zzm2 = r2;
        zzm zzm3 = new zzm(str, zzb2.zze(), zzb2.zzl(), zzb2.zzm(), zzb2.zzn(), zzb2.zzo(), zzb2.zzp(), (String) null, zzb2.zzr(), false, zzb2.zzi(), zzb2.zzae(), 0, 0, zzb2.zzaf(), zzb2.zzag(), false, zzb2.zzf(), zzb2.zzah(), zzb2.zzq(), zzb2.zzai(), (!zzll.zzb() || !this.zzj.zzb().zze(zzb2.zzc(), zzap.zzch)) ? null : zzb2.zzg());
        zza(zzan2, zzm2);
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzkp zzkp) {
        this.zzo++;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzkz zzkz, zzm zzm2) {
        zzw();
        zzk();
        if (zze(zzm2)) {
            if (!zzm2.zzh) {
                zzc(zzm2);
                return;
            }
            int zzc2 = this.zzj.zzi().zzc(zzkz.zza);
            if (zzc2 != 0) {
                this.zzj.zzi();
                this.zzj.zzi().zza(zzm2.zza, zzc2, "_ev", zzla.zza(zzkz.zza, 24, true), zzkz.zza != null ? zzkz.zza.length() : 0);
                return;
            }
            int zzb2 = this.zzj.zzi().zzb(zzkz.zza, zzkz.zza());
            if (zzb2 != 0) {
                this.zzj.zzi();
                String zza2 = zzla.zza(zzkz.zza, 24, true);
                Object zza3 = zzkz.zza();
                this.zzj.zzi().zza(zzm2.zza, zzb2, "_ev", zza2, (zza3 == null || (!(zza3 instanceof String) && !(zza3 instanceof CharSequence))) ? 0 : String.valueOf(zza3).length());
                return;
            }
            Object zzc3 = this.zzj.zzi().zzc(zzkz.zza, zzkz.zza());
            if (zzc3 != null) {
                if ("_sid".equals(zzkz.zza) && this.zzj.zzb().zze(zzm2.zza, zzap.zzat)) {
                    long j = zzkz.zzb;
                    String str = zzkz.zze;
                    long j2 = 0;
                    zzlb zzc4 = zze().zzc(zzm2.zza, "_sno");
                    if (zzc4 == null || !(zzc4.zze instanceof Long)) {
                        if (zzc4 != null) {
                            this.zzj.zzr().zzi().zza("Retrieved last session number from database does not contain a valid (long) value", zzc4.zze);
                        }
                        if (this.zzj.zzb().zze(zzm2.zza, zzap.zzaw)) {
                            zzaj zza4 = zze().zza(zzm2.zza, "_s");
                            if (zza4 != null) {
                                j2 = zza4.zzc;
                                this.zzj.zzr().zzx().zza("Backfill the session number. Last used session number", Long.valueOf(j2));
                            }
                        }
                    } else {
                        j2 = ((Long) zzc4.zze).longValue();
                    }
                    zzkz zzkz2 = new zzkz("_sno", j, Long.valueOf(j2 + 1), str);
                    zza(zzkz2, zzm2);
                }
                zzlb zzlb = new zzlb(zzm2.zza, zzkz.zze, zzkz.zza, zzkz.zzb, zzc3);
                if (!zzkz.zzb() || !this.zzj.zzb().zze(zzm2.zza, zzap.zzcy)) {
                    this.zzj.zzr().zzw().zza("Setting user property", this.zzj.zzj().zzc(zzlb.zzc), zzc3);
                } else {
                    this.zzj.zzr().zzx().zza("Setting user property", this.zzj.zzj().zzc(zzlb.zzc), zzc3);
                }
                zze().zzf();
                try {
                    zzc(zzm2);
                    boolean zza5 = zze().zza(zzlb);
                    zze().b_();
                    if (!zza5) {
                        this.zzj.zzr().zzf().zza("Too many unique user properties are set. Ignoring user property", this.zzj.zzj().zzc(zzlb.zzc), zzlb.zze);
                        this.zzj.zzi().zza(zzm2.zza, 9, (String) null, (String) null, 0);
                    } else if (!zzkz.zzb() || !this.zzj.zzb().zze(zzm2.zza, zzap.zzcy)) {
                        this.zzj.zzr().zzw().zza("User property set", this.zzj.zzj().zzc(zzlb.zzc), zzlb.zze);
                    }
                } finally {
                    zze().zzh();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzm zzm2) {
        if (this.zzv != null) {
            ArrayList arrayList = new ArrayList();
            this.zzw = arrayList;
            arrayList.addAll(this.zzv);
        }
        zzac zze2 = zze();
        String str = zzm2.zza;
        Preconditions.checkNotEmpty(str);
        zze2.zzd();
        zze2.zzak();
        try {
            SQLiteDatabase c_ = zze2.c_();
            String[] strArr = {str};
            int delete = c_.delete("apps", "app_id=?", strArr) + 0 + c_.delete(j.f343b, "app_id=?", strArr) + c_.delete("user_attributes", "app_id=?", strArr) + c_.delete("conditional_properties", "app_id=?", strArr) + c_.delete("raw_events", "app_id=?", strArr) + c_.delete("raw_events_metadata", "app_id=?", strArr) + c_.delete("queue", "app_id=?", strArr) + c_.delete("audience_filter_values", "app_id=?", strArr) + c_.delete("main_event_params", "app_id=?", strArr);
            if (delete > 0) {
                zze2.zzr().zzx().zza("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e2) {
            zze2.zzr().zzf().zza("Error resetting analytics data. appId, error", zzfj.zza(str), e2);
        }
        if (!com.google.android.gms.internal.measurement.zzks.zzb() || !this.zzj.zzb().zza(zzap.zzcm)) {
            zzm zza2 = zza(this.zzj.zzn(), zzm2.zza, zzm2.zzb, zzm2.zzh, zzm2.zzo, zzm2.zzp, zzm2.zzm, zzm2.zzr, zzm2.zzv);
            if (zzm2.zzh) {
                zzb(zza2);
            }
        } else if (zzm2.zzh) {
            zzb(zzm2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzv zzv2) {
        zzm zza2 = zza(zzv2.zza);
        if (zza2 != null) {
            zza(zzv2, zza2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzv zzv2, zzm zzm2) {
        Preconditions.checkNotNull(zzv2);
        Preconditions.checkNotEmpty(zzv2.zza);
        Preconditions.checkNotNull(zzv2.zzb);
        Preconditions.checkNotNull(zzv2.zzc);
        Preconditions.checkNotEmpty(zzv2.zzc.zza);
        zzw();
        zzk();
        if (zze(zzm2)) {
            if (!zzm2.zzh) {
                zzc(zzm2);
                return;
            }
            zzv zzv3 = new zzv(zzv2);
            boolean z = false;
            zzv3.zze = false;
            zze().zzf();
            try {
                zzv zzd2 = zze().zzd(zzv3.zza, zzv3.zzc.zza);
                if (zzd2 != null && !zzd2.zzb.equals(zzv3.zzb)) {
                    this.zzj.zzr().zzi().zza("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzj.zzj().zzc(zzv3.zzc.zza), zzv3.zzb, zzd2.zzb);
                }
                if (zzd2 != null && zzd2.zze) {
                    zzv3.zzb = zzd2.zzb;
                    zzv3.zzd = zzd2.zzd;
                    zzv3.zzh = zzd2.zzh;
                    zzv3.zzf = zzd2.zzf;
                    zzv3.zzi = zzd2.zzi;
                    zzv3.zze = zzd2.zze;
                    zzkz zzkz = new zzkz(zzv3.zzc.zza, zzd2.zzc.zzb, zzv3.zzc.zza(), zzd2.zzc.zze);
                    zzv3.zzc = zzkz;
                } else if (TextUtils.isEmpty(zzv3.zzf)) {
                    zzkz zzkz2 = new zzkz(zzv3.zzc.zza, zzv3.zzd, zzv3.zzc.zza(), zzv3.zzc.zze);
                    zzv3.zzc = zzkz2;
                    zzv3.zze = true;
                    z = true;
                }
                if (zzv3.zze) {
                    zzkz zzkz3 = zzv3.zzc;
                    zzlb zzlb = new zzlb(zzv3.zza, zzv3.zzb, zzkz3.zza, zzkz3.zzb, zzkz3.zza());
                    if (zze().zza(zzlb)) {
                        this.zzj.zzr().zzw().zza("User property updated immediately", zzv3.zza, this.zzj.zzj().zzc(zzlb.zzc), zzlb.zze);
                    } else {
                        this.zzj.zzr().zzf().zza("(2)Too many active user properties, ignoring", zzfj.zza(zzv3.zza), this.zzj.zzj().zzc(zzlb.zzc), zzlb.zze);
                    }
                    if (z && zzv3.zzi != null) {
                        zzb(new zzan(zzv3.zzi, zzv3.zzd), zzm2);
                    }
                }
                if (zze().zza(zzv3)) {
                    this.zzj.zzr().zzw().zza("Conditional property added", zzv3.zza, this.zzj.zzj().zzc(zzv3.zzc.zza), zzv3.zzc.zza());
                } else {
                    this.zzj.zzr().zzf().zza("Too many conditional properties, ignoring", zzfj.zza(zzv3.zza), this.zzj.zzj().zzc(zzv3.zzc.zza), zzv3.zzc.zza());
                }
                zze().b_();
            } finally {
                zze().zzh();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(Runnable runnable) {
        zzw();
        if (this.zzn == null) {
            this.zzn = new ArrayList();
        }
        this.zzn.add(runnable);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0141 A[Catch:{ all -> 0x0198, all -> 0x01a1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0152 A[Catch:{ all -> 0x0198, all -> 0x01a1 }] */
    public final void zza(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        zzw();
        zzk();
        Preconditions.checkNotEmpty(str);
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzq = false;
                zzaa();
                throw th2;
            }
        }
        this.zzj.zzr().zzx().zza("onConfigFetched. Response size", Integer.valueOf(bArr.length));
        zze().zzf();
        zzg zzb2 = zze().zzb(str);
        boolean z = true;
        boolean z2 = (i == 200 || i == 204 || i == 304) && th == null;
        if (zzb2 == null) {
            this.zzj.zzr().zzi().zza("App does not exist in onConfigFetched. appId", zzfj.zza(str));
        } else {
            if (!z2) {
                if (i != 404) {
                    zzb2.zzi(this.zzj.zzm().currentTimeMillis());
                    zze().zza(zzb2);
                    this.zzj.zzr().zzx().zza("Fetching config failed. code, error", Integer.valueOf(i), th);
                    zzc().zzc(str);
                    this.zzj.zzc().zzd.zza(this.zzj.zzm().currentTimeMillis());
                    if (i != 503) {
                        if (i != 429) {
                            z = false;
                        }
                    }
                    if (z) {
                        this.zzj.zzc().zze.zza(this.zzj.zzm().currentTimeMillis());
                    }
                    zzz();
                }
            }
            List list = map != null ? map.get(HttpRequest.HEADER_LAST_MODIFIED) : null;
            String str2 = (list == null || list.size() <= 0) ? null : (String) list.get(0);
            if (i != 404) {
                if (i != 304) {
                    if (!zzc().zza(str, bArr, str2)) {
                        zze().zzh();
                        this.zzq = false;
                        zzaa();
                        return;
                    }
                    zzb2.zzh(this.zzj.zzm().currentTimeMillis());
                    zze().zza(zzb2);
                    if (i != 404) {
                        this.zzj.zzr().zzk().zza("Config not found. Using empty config. appId", str);
                    } else {
                        this.zzj.zzr().zzx().zza("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                    }
                    if (zzd().zzf() || !zzy()) {
                        zzz();
                    } else {
                        zzl();
                    }
                }
            }
            if (zzc().zza(str) == null && !zzc().zza(str, (byte[]) null, (String) null)) {
                zze().zzh();
                this.zzq = false;
                zzaa();
                return;
            }
            zzb2.zzh(this.zzj.zzm().currentTimeMillis());
            zze().zza(zzb2);
            if (i != 404) {
            }
            if (zzd().zzf()) {
            }
            zzz();
        }
        zze().b_();
        zze().zzh();
        this.zzq = false;
        zzaa();
    }

    /* access modifiers changed from: package-private */
    public final void zza(boolean z) {
        zzz();
    }

    public final zzx zzb() {
        return this.zzj.zzb();
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzkz zzkz, zzm zzm2) {
        zzw();
        zzk();
        if (zze(zzm2)) {
            if (!zzm2.zzh) {
                zzc(zzm2);
            } else if (!this.zzj.zzb().zze(zzm2.zza, zzap.zzbd)) {
                this.zzj.zzr().zzw().zza("Removing user property", this.zzj.zzj().zzc(zzkz.zza));
                zze().zzf();
                try {
                    zzc(zzm2);
                    zze().zzb(zzm2.zza, zzkz.zza);
                    zze().b_();
                    this.zzj.zzr().zzw().zza("User property removed", this.zzj.zzj().zzc(zzkz.zza));
                } finally {
                    zze().zzh();
                }
            } else if (!"_npa".equals(zzkz.zza) || zzm2.zzs == null) {
                this.zzj.zzr().zzw().zza("Removing user property", this.zzj.zzj().zzc(zzkz.zza));
                zze().zzf();
                try {
                    zzc(zzm2);
                    zze().zzb(zzm2.zza, zzkz.zza);
                    zze().b_();
                    this.zzj.zzr().zzw().zza("User property removed", this.zzj.zzj().zzc(zzkz.zza));
                } finally {
                    zze().zzh();
                }
            } else {
                this.zzj.zzr().zzw().zza("Falling back to manifest metadata value for ad personalization");
                zzkz zzkz2 = new zzkz("_npa", this.zzj.zzm().currentTimeMillis(), Long.valueOf(zzm2.zzs.booleanValue() ? 1 : 0), "auto");
                zza(zzkz2, zzm2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0233 A[Catch:{ SQLiteException -> 0x01e2, all -> 0x0502 }] */
    public final void zzb(zzm zzm2) {
        String str;
        int i;
        zzg zzb2;
        String str2;
        PackageInfo packageInfo;
        String str3;
        ApplicationInfo applicationInfo;
        boolean z;
        boolean z2;
        zzac zze2;
        String zzc2;
        zzm zzm3 = zzm2;
        zzw();
        zzk();
        Preconditions.checkNotNull(zzm2);
        Preconditions.checkNotEmpty(zzm3.zza);
        if (zze(zzm2)) {
            zzg zzb3 = zze().zzb(zzm3.zza);
            if (zzb3 != null && TextUtils.isEmpty(zzb3.zze()) && !TextUtils.isEmpty(zzm3.zzb)) {
                zzb3.zzh(0);
                zze().zza(zzb3);
                zzc().zzd(zzm3.zza);
            }
            if (!zzm3.zzh) {
                zzc(zzm2);
                return;
            }
            long j = zzm3.zzm;
            if (j == 0) {
                j = this.zzj.zzm().currentTimeMillis();
            }
            if (this.zzj.zzb().zze(zzm3.zza, zzap.zzbd)) {
                this.zzj.zzx().zzi();
            }
            int i2 = zzm3.zzn;
            if (!(i2 == 0 || i2 == 1)) {
                this.zzj.zzr().zzi().zza("Incorrect app type, assuming installed app. appId, appType", zzfj.zza(zzm3.zza), Integer.valueOf(i2));
                i2 = 0;
            }
            zze().zzf();
            try {
                if (this.zzj.zzb().zze(zzm3.zza, zzap.zzbd)) {
                    zzlb zzc3 = zze().zzc(zzm3.zza, "_npa");
                    if (zzc3 != null) {
                        if (!"auto".equals(zzc3.zzb)) {
                            str = "_sysu";
                            i = 1;
                        }
                    }
                    if (zzm3.zzs != null) {
                        zzkz zzkz = r12;
                        str = "_sysu";
                        zzlb zzlb = zzc3;
                        i = 1;
                        zzkz zzkz2 = new zzkz("_npa", j, Long.valueOf(zzm3.zzs.booleanValue() ? 1 : 0), "auto");
                        if (zzlb == null || !zzlb.zze.equals(zzkz.zzc)) {
                            zza(zzkz, zzm3);
                        }
                    } else {
                        str = "_sysu";
                        i = 1;
                        if (zzc3 != null) {
                            zzkz zzkz3 = new zzkz("_npa", j, (Object) null, "auto");
                            zzb(zzkz3, zzm3);
                        }
                    }
                } else {
                    str = "_sysu";
                    i = 1;
                }
                zzb2 = zze().zzb(zzm3.zza);
                if (zzb2 != null) {
                    this.zzj.zzi();
                    if (zzla.zza(zzm3.zzb, zzb2.zze(), zzm3.zzr, zzb2.zzf())) {
                        this.zzj.zzr().zzi().zza("New GMP App Id passed in. Removing cached database data. appId", zzfj.zza(zzb2.zzc()));
                        zze2 = zze();
                        zzc2 = zzb2.zzc();
                        zze2.zzak();
                        zze2.zzd();
                        Preconditions.checkNotEmpty(zzc2);
                        SQLiteDatabase c_ = zze2.c_();
                        String[] strArr = new String[i];
                        strArr[0] = zzc2;
                        int delete = c_.delete(j.f343b, "app_id=?", strArr) + 0 + c_.delete("user_attributes", "app_id=?", strArr) + c_.delete("conditional_properties", "app_id=?", strArr) + c_.delete("apps", "app_id=?", strArr) + c_.delete("raw_events", "app_id=?", strArr) + c_.delete("raw_events_metadata", "app_id=?", strArr) + c_.delete("event_filters", "app_id=?", strArr) + c_.delete("property_filters", "app_id=?", strArr) + c_.delete("audience_filter_values", "app_id=?", strArr);
                        if (delete > 0) {
                            zze2.zzr().zzx().zza("Deleted application data. app, records", zzc2, Integer.valueOf(delete));
                        }
                        zzb2 = null;
                    }
                }
            } catch (SQLiteException e2) {
                zze2.zzr().zzf().zza("Error deleting application data. appId, error", zzfj.zza(zzc2), e2);
            } catch (Throwable th) {
                zze().zzh();
                throw th;
            }
            if (zzb2 != null) {
                if (zzb2.zzm() != -2147483648L) {
                    str2 = "_sys";
                    if (zzb2.zzm() != zzm3.zzj) {
                        z2 = true;
                        if (z2 || ((zzb2.zzm() == -2147483648L || zzb2.zzl() == null || zzb2.zzl().equals(zzm3.zzc)) ? false : true)) {
                            Bundle bundle = new Bundle();
                            bundle.putString("_pv", zzb2.zzl());
                            zzan zzan = new zzan("_au", new zzam(bundle), "auto", j);
                            zza(zzan, zzm3);
                        }
                    }
                } else {
                    str2 = "_sys";
                }
                z2 = false;
                if (z2 || ((zzb2.zzm() == -2147483648L || zzb2.zzl() == null || zzb2.zzl().equals(zzm3.zzc)) ? false : true)) {
                }
            } else {
                str2 = "_sys";
            }
            zzc(zzm2);
            if ((i2 == 0 ? zze().zza(zzm3.zza, "_f") : i2 == 1 ? zze().zza(zzm3.zza, "_v") : null) == null) {
                long j2 = ((j / 3600000) + 1) * 3600000;
                if (i2 == 0) {
                    zzkz zzkz4 = new zzkz("_fot", j, Long.valueOf(j2), "auto");
                    zza(zzkz4, zzm3);
                    if (this.zzj.zzb().zze(zzm3.zzb, zzap.zzar)) {
                        zzw();
                        this.zzj.zzf().zza(zzm3.zza);
                    }
                    zzw();
                    zzk();
                    Bundle bundle2 = new Bundle();
                    bundle2.putLong("_c", 1);
                    bundle2.putLong("_r", 1);
                    bundle2.putLong("_uwa", 0);
                    bundle2.putLong("_pfo", 0);
                    bundle2.putLong(str2, 0);
                    String str4 = str;
                    bundle2.putLong(str4, 0);
                    if (this.zzj.zzb().zze(zzm3.zza, zzap.zzbb)) {
                        bundle2.putLong("_et", 1);
                    }
                    if (zzm3.zzq) {
                        bundle2.putLong("_dac", 1);
                    }
                    zzac zze3 = zze();
                    String str5 = zzm3.zza;
                    Preconditions.checkNotEmpty(str5);
                    zze3.zzd();
                    zze3.zzak();
                    long zzh2 = zze3.zzh(str5, "first_open_count");
                    if (this.zzj.zzn().getPackageManager() == null) {
                        this.zzj.zzr().zzf().zza("PackageManager is null, first open report might be inaccurate. appId", zzfj.zza(zzm3.zza));
                    } else {
                        try {
                            packageInfo = Wrappers.packageManager(this.zzj.zzn()).getPackageInfo(zzm3.zza, 0);
                        } catch (PackageManager.NameNotFoundException e3) {
                            this.zzj.zzr().zzf().zza("Package info is null, first open report might be inaccurate. appId", zzfj.zza(zzm3.zza), e3);
                            packageInfo = null;
                        }
                        if (packageInfo == null) {
                            str3 = str4;
                        } else if (packageInfo.firstInstallTime != 0) {
                            String str6 = str4;
                            if (packageInfo.firstInstallTime != packageInfo.lastUpdateTime) {
                                if (!this.zzj.zzb().zza(zzap.zzcn)) {
                                    bundle2.putLong("_uwa", 1);
                                } else if (zzh2 == 0) {
                                    bundle2.putLong("_uwa", 1);
                                }
                                z = false;
                            } else {
                                z = true;
                            }
                            str3 = str6;
                            zzkz zzkz5 = new zzkz("_fi", j, Long.valueOf(z ? 1 : 0), "auto");
                            zza(zzkz5, zzm3);
                        } else {
                            str3 = str4;
                        }
                        try {
                            applicationInfo = Wrappers.packageManager(this.zzj.zzn()).getApplicationInfo(zzm3.zza, 0);
                        } catch (PackageManager.NameNotFoundException e4) {
                            this.zzj.zzr().zzf().zza("Application info is null, first open report might be inaccurate. appId", zzfj.zza(zzm3.zza), e4);
                            applicationInfo = null;
                        }
                        if (applicationInfo != null) {
                            if ((applicationInfo.flags & 1) != 0) {
                                bundle2.putLong(str2, 1);
                            }
                            if ((applicationInfo.flags & 128) != 0) {
                                bundle2.putLong(str3, 1);
                            }
                        }
                    }
                    if (zzh2 >= 0) {
                        bundle2.putLong("_pfo", zzh2);
                    }
                    zzan zzan2 = new zzan("_f", new zzam(bundle2), "auto", j);
                    zza(zzan2, zzm3);
                } else if (i2 == 1) {
                    zzkz zzkz6 = new zzkz("_fvt", j, Long.valueOf(j2), "auto");
                    zza(zzkz6, zzm3);
                    zzw();
                    zzk();
                    Bundle bundle3 = new Bundle();
                    bundle3.putLong("_c", 1);
                    bundle3.putLong("_r", 1);
                    if (this.zzj.zzb().zze(zzm3.zza, zzap.zzbb)) {
                        bundle3.putLong("_et", 1);
                    }
                    if (zzm3.zzq) {
                        bundle3.putLong("_dac", 1);
                    }
                    zzan zzan3 = new zzan("_v", new zzam(bundle3), "auto", j);
                    zza(zzan3, zzm3);
                }
                if (!this.zzj.zzb().zze(zzm3.zza, zzap.zzbc)) {
                    Bundle bundle4 = new Bundle();
                    bundle4.putLong("_et", 1);
                    if (this.zzj.zzb().zze(zzm3.zza, zzap.zzbb)) {
                        bundle4.putLong("_fr", 1);
                    }
                    zzan zzan4 = new zzan("_e", new zzam(bundle4), "auto", j);
                    zza(zzan4, zzm3);
                }
            } else if (zzm3.zzi) {
                zzan zzan5 = new zzan("_cd", new zzam(new Bundle()), "auto", j);
                zza(zzan5, zzm3);
            }
            zze().b_();
            zze().zzh();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzv zzv2) {
        zzm zza2 = zza(zzv2.zza);
        if (zza2 != null) {
            zzb(zzv2, zza2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzv zzv2, zzm zzm2) {
        Preconditions.checkNotNull(zzv2);
        Preconditions.checkNotEmpty(zzv2.zza);
        Preconditions.checkNotNull(zzv2.zzc);
        Preconditions.checkNotEmpty(zzv2.zzc.zza);
        zzw();
        zzk();
        if (zze(zzm2)) {
            if (!zzm2.zzh) {
                zzc(zzm2);
                return;
            }
            zze().zzf();
            try {
                zzc(zzm2);
                zzv zzd2 = zze().zzd(zzv2.zza, zzv2.zzc.zza);
                if (zzd2 != null) {
                    this.zzj.zzr().zzw().zza("Removing conditional user property", zzv2.zza, this.zzj.zzj().zzc(zzv2.zzc.zza));
                    zze().zze(zzv2.zza, zzv2.zzc.zza);
                    if (zzd2.zze) {
                        zze().zzb(zzv2.zza, zzv2.zzc.zza);
                    }
                    if (zzv2.zzk != null) {
                        zzb(this.zzj.zzi().zza(zzv2.zza, zzv2.zzk.zza, zzv2.zzk.zzb != null ? zzv2.zzk.zzb.zzb() : null, zzd2.zzb, zzv2.zzk.zzd, true, false), zzm2);
                    }
                } else {
                    this.zzj.zzr().zzi().zza("Conditional user property doesn't exist", zzfj.zza(zzv2.zza), this.zzj.zzj().zzc(zzv2.zzc.zza));
                }
                zze().b_();
            } finally {
                zze().zzh();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final zzg zzc(zzm zzm2) {
        zzw();
        zzk();
        Preconditions.checkNotNull(zzm2);
        Preconditions.checkNotEmpty(zzm2.zza);
        zzg zzb2 = zze().zzb(zzm2.zza);
        String zzb3 = this.zzj.zzc().zzb(zzm2.zza);
        if (!zzkt.zzb() || !this.zzj.zzb().zza(zzap.zzcp)) {
            return zza(zzm2, zzb2, zzb3);
        }
        if (zzb2 == null) {
            zzb2 = new zzg(this.zzj, zzm2.zza);
            zzb2.zza(this.zzj.zzi().zzk());
            zzb2.zze(zzb3);
        } else if (!zzb3.equals(zzb2.zzh())) {
            zzb2.zze(zzb3);
            zzb2.zza(this.zzj.zzi().zzk());
        }
        zzb2.zzb(zzm2.zzb);
        zzb2.zzc(zzm2.zzr);
        if (zzll.zzb() && this.zzj.zzb().zze(zzb2.zzc(), zzap.zzch)) {
            zzb2.zzd(zzm2.zzv);
        }
        if (!TextUtils.isEmpty(zzm2.zzk)) {
            zzb2.zzf(zzm2.zzk);
        }
        if (zzm2.zze != 0) {
            zzb2.zzd(zzm2.zze);
        }
        if (!TextUtils.isEmpty(zzm2.zzc)) {
            zzb2.zzg(zzm2.zzc);
        }
        zzb2.zzc(zzm2.zzj);
        if (zzm2.zzd != null) {
            zzb2.zzh(zzm2.zzd);
        }
        zzb2.zze(zzm2.zzf);
        zzb2.zza(zzm2.zzh);
        if (!TextUtils.isEmpty(zzm2.zzg)) {
            zzb2.zzi(zzm2.zzg);
        }
        if (!this.zzj.zzb().zza(zzap.zzdh)) {
            zzb2.zzp(zzm2.zzl);
        }
        zzb2.zzb(zzm2.zzo);
        zzb2.zzc(zzm2.zzp);
        if (this.zzj.zzb().zze(zzm2.zza, zzap.zzbd)) {
            zzb2.zza(zzm2.zzs);
        }
        zzb2.zzf(zzm2.zzt);
        if (zzb2.zza()) {
            zze().zza(zzb2);
        }
        return zzb2;
    }

    public final zzgk zzc() {
        zzb((zzkp) this.zzb);
        return this.zzb;
    }

    public final zzfq zzd() {
        zzb((zzkp) this.zzc);
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final String zzd(zzm zzm2) {
        try {
            return (String) this.zzj.zzq().zza(new zzkv(this, zzm2)).get(30000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e2) {
            this.zzj.zzr().zzf().zza("Failed to get app instance id. appId", zzfj.zza(zzm2.zza), e2);
            return null;
        }
    }

    public final zzac zze() {
        zzb((zzkp) this.zzd);
        return this.zzd;
    }

    public final zzn zzf() {
        zzb((zzkp) this.zzg);
        return this.zzg;
    }

    public final zzit zzg() {
        zzb((zzkp) this.zzi);
        return this.zzi;
    }

    public final zzkw zzh() {
        zzb((zzkp) this.zzh);
        return this.zzh;
    }

    public final zzfh zzi() {
        return this.zzj.zzj();
    }

    public final zzla zzj() {
        return this.zzj.zzi();
    }

    /* access modifiers changed from: package-private */
    public final void zzk() {
        if (!this.zzk) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzl() {
        String d_;
        String str;
        String zza2;
        zzw();
        zzk();
        this.zzs = true;
        try {
            this.zzj.zzu();
            Boolean zzag = this.zzj.zzw().zzag();
            if (zzag == null) {
                this.zzj.zzr().zzi().zza("Upload data called on the client side before use of service was decided");
                this.zzs = false;
                zzaa();
            } else if (zzag.booleanValue()) {
                this.zzj.zzr().zzf().zza("Upload called in the client side when service should be used");
                this.zzs = false;
                zzaa();
            } else if (this.zzm > 0) {
                zzz();
                this.zzs = false;
                zzaa();
            } else {
                zzw();
                if (this.zzv != null) {
                    this.zzj.zzr().zzx().zza("Uploading requested multiple times");
                    this.zzs = false;
                    zzaa();
                } else if (!zzd().zzf()) {
                    this.zzj.zzr().zzx().zza("Network not connected, ignoring upload request");
                    zzz();
                    this.zzs = false;
                    zzaa();
                } else {
                    long currentTimeMillis = this.zzj.zzm().currentTimeMillis();
                    int zzb2 = zzlx.zzb() ? this.zzj.zzb().zzb((String) null, zzap.zzap) : 1;
                    if (zzb2 > 1) {
                        long zzv2 = currentTimeMillis - zzx.zzv();
                        for (int i = 0; i < zzb2 && zza((String) null, zzv2); i++) {
                        }
                    } else {
                        zza((String) null, currentTimeMillis - zzx.zzv());
                    }
                    long zza3 = this.zzj.zzc().zzc.zza();
                    if (zza3 != 0) {
                        this.zzj.zzr().zzw().zza("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(currentTimeMillis - zza3)));
                    }
                    d_ = zze().d_();
                    if (!TextUtils.isEmpty(d_)) {
                        if (this.zzx == -1) {
                            this.zzx = zze().zzaa();
                        }
                        List<Pair<zzbr.zzg, Long>> zza4 = zze().zza(d_, this.zzj.zzb().zzb(d_, zzap.zzf), Math.max(0, this.zzj.zzb().zzb(d_, zzap.zzg)));
                        if (!zza4.isEmpty()) {
                            Iterator<Pair<zzbr.zzg, Long>> it = zza4.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    str = null;
                                    break;
                                }
                                zzbr.zzg zzg2 = (zzbr.zzg) it.next().first;
                                if (!TextUtils.isEmpty(zzg2.zzad())) {
                                    str = zzg2.zzad();
                                    break;
                                }
                            }
                            if (str != null) {
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= zza4.size()) {
                                        break;
                                    }
                                    zzbr.zzg zzg3 = (zzbr.zzg) zza4.get(i2).first;
                                    if (!TextUtils.isEmpty(zzg3.zzad()) && !zzg3.zzad().equals(str)) {
                                        zza4 = zza4.subList(0, i2);
                                        break;
                                    }
                                    i2++;
                                }
                            }
                            zzbr.zzf.zza zzb3 = zzbr.zzf.zzb();
                            int size = zza4.size();
                            ArrayList arrayList = new ArrayList(zza4.size());
                            boolean zzf2 = this.zzj.zzb().zzf(d_);
                            for (int i3 = 0; i3 < size; i3++) {
                                zzbr.zzg.zza zza5 = (zzbr.zzg.zza) ((zzbr.zzg) zza4.get(i3).first).zzbm();
                                arrayList.add((Long) zza4.get(i3).second);
                                zzbr.zzg.zza zza6 = zza5.zzg(this.zzj.zzb().zzf()).zza(currentTimeMillis);
                                this.zzj.zzu();
                                zza6.zzb(false);
                                if (!zzf2) {
                                    zza5.zzn();
                                }
                                if (this.zzj.zzb().zze(d_, zzap.zzbh)) {
                                    zza5.zzl(zzh().zza(((zzbr.zzg) ((zzfd) zza5.zzu())).zzbi()));
                                }
                                zzb3.zza(zza5);
                            }
                            String zza7 = this.zzj.zzr().zza(2) ? zzh().zza((zzbr.zzf) ((zzfd) zzb3.zzu())) : null;
                            zzh();
                            byte[] zzbi = ((zzbr.zzf) ((zzfd) zzb3.zzu())).zzbi();
                            zza2 = zzap.zzp.zza(null);
                            URL url = new URL(zza2);
                            Preconditions.checkArgument(!arrayList.isEmpty());
                            if (this.zzv != null) {
                                this.zzj.zzr().zzf().zza("Set uploading progress before finishing the previous upload");
                            } else {
                                this.zzv = new ArrayList(arrayList);
                            }
                            this.zzj.zzc().zzd.zza(currentTimeMillis);
                            String str2 = "?";
                            if (size > 0) {
                                str2 = zzb3.zza(0).zzx();
                            }
                            this.zzj.zzr().zzx().zza("Uploading data. app, uncompressed size, data", str2, Integer.valueOf(zzbi.length), zza7);
                            this.zzr = true;
                            zzfq zzd2 = zzd();
                            zzku zzku = new zzku(this, d_);
                            zzd2.zzd();
                            zzd2.zzak();
                            Preconditions.checkNotNull(url);
                            Preconditions.checkNotNull(zzbi);
                            Preconditions.checkNotNull(zzku);
                            zzgj zzq2 = zzd2.zzq();
                            zzfu zzfu = new zzfu(zzd2, d_, url, zzbi, (Map<String, String>) null, zzku);
                            zzq2.zzb((Runnable) zzfu);
                        }
                    } else {
                        this.zzx = -1;
                        String zza8 = zze().zza(currentTimeMillis - zzx.zzv());
                        if (!TextUtils.isEmpty(zza8)) {
                            zzg zzb4 = zze().zzb(zza8);
                            if (zzb4 != null) {
                                zza(zzb4);
                            }
                        }
                    }
                    this.zzs = false;
                    zzaa();
                }
            }
        } catch (MalformedURLException e2) {
            this.zzj.zzr().zzf().zza("Failed to parse upload URL. Not uploading. appId", zzfj.zza(d_), zza2);
        } catch (Throwable th) {
            this.zzs = false;
            zzaa();
            throw th;
        }
    }

    public final Clock zzm() {
        return this.zzj.zzm();
    }

    public final Context zzn() {
        return this.zzj.zzn();
    }

    /* access modifiers changed from: package-private */
    public final void zzo() {
        zzw();
        zzk();
        if (!this.zzl) {
            this.zzl = true;
            if (zzab()) {
                int zza2 = zza(this.zzu);
                int zzaf = this.zzj.zzy().zzaf();
                zzw();
                if (zza2 > zzaf) {
                    this.zzj.zzr().zzf().zza("Panic: can't downgrade version. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzaf));
                } else if (zza2 >= zzaf) {
                } else {
                    if (zza(zzaf, this.zzu)) {
                        this.zzj.zzr().zzx().zza("Storage version upgraded. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzaf));
                    } else {
                        this.zzj.zzr().zzf().zza("Storage version upgrade failed. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzaf));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzp() {
        this.zzp++;
    }

    public final zzgj zzq() {
        return this.zzj.zzq();
    }

    public final zzfj zzr() {
        return this.zzj.zzr();
    }

    /* access modifiers changed from: package-private */
    public final zzgq zzs() {
        return this.zzj;
    }

    public final zzw zzu() {
        return this.zzj.zzu();
    }
}
